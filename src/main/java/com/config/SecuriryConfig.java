package com.config;

import com.listners.CustomAuthenticationSuccessHandler;
import com.service.CustomAM;
import com.service.UserDetailServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@Configuration
@EnableWebSecurity
public class SecuriryConfig extends WebSecurityConfigurerAdapter {

   private final UserDetailServiceImpl userDetailService;
   private final DataSource dataSource;
   private final CustomAuthenticationSuccessHandler handler;

   @Autowired
   public SecuriryConfig(UserDetailServiceImpl userDetailService, DataSource dataSource,
       CustomAuthenticationSuccessHandler handler) {
      this.userDetailService = userDetailService;
      this.dataSource = dataSource;
      this.handler = handler;
   }

//   @Autowired
//   protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//      auth.userDetailsService(userDetailService);
//   }

   @Override
   protected AuthenticationManager authenticationManager() throws Exception {
      return new CustomAM(userDetailService);
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.httpBasic().and()
          .authorizeRequests()
          .antMatchers("/UserLogin", "/IsAuth", "/dist/*", "/logout", "/", "/testarray", "/src/**",
              "/src/assets/dollor.png", "/UserRegistration").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin().loginPage("/")
          //successHandler(handler)
//            .and().rememberMe().
//          rememberMeParameter("remember-me").
//          tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400)
//          .and()
//          .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
//          .logoutSuccessUrl("/")
          .and().csrf().csrfTokenRepository(csrfTokenRepository())
          .and().addFilterAfter(csrfHeaderFilter(), SessionManagementFilter.class);
   }

   @Bean
   public PersistentTokenRepository persistentTokenRepository() {
      JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
      tokenRepositoryImpl.setDataSource(dataSource);
      return tokenRepositoryImpl;
   }

   private OncePerRequestFilter csrfHeaderFilter() {
      return new OncePerRequestFilter() {

         @Override
         protected void doFilterInternal(HttpServletRequest request,
             HttpServletResponse response,
             FilterChain filterChain) throws ServletException, IOException {

            CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
            if (csrf != null) {
               Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
               String token = csrf.getToken();
               if (cookie == null || token != null
                   && !token.equals(cookie.getValue())) {

                  // Token is being added to the XSRF-TOKEN cookie.
                  cookie = new Cookie("XSRF-TOKEN", token);
                  cookie.setPath("/");
                  response.addCookie(cookie);
               }
            }
//            else {
//               csrf = csrfTokenRepository().generateToken(request);
//               Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//               String token = csrf.getToken();
//               if (cookie == null || token != null
//                   && !token.equals(cookie.getValue())) {
//
//                  // Token is being added to the XSRF-TOKEN cookie.
//                  cookie = new Cookie("XSRF-TOKEN", token);
//                  cookie.setPath("/");
//                  response.addCookie(cookie);
//               }
            filterChain.doFilter(request, response);

         }
      };
   }

   private CsrfTokenRepository csrfTokenRepository() {
      HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
      repository.setHeaderName("X-XSRF-TOKEN");
      repository.setSessionAttributeName("X-XSRF-TOKEN");
      return repository;
   }
}

