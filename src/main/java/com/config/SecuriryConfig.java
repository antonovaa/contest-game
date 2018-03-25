package com.config;

import com.service.CustomAM;
import com.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecuriryConfig extends WebSecurityConfigurerAdapter {

   private final UserDetailServiceImpl userDetailService;

   @Autowired
   public SecuriryConfig(UserDetailServiceImpl userDetailService) {
      this.userDetailService = userDetailService;
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
          .antMatchers("/UserLogin","/IsAuth", "/dist/*","/logout","/","/testarray","/src/**","/src/assets/dollor.png","/UserRegistration").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin().loginPage("/")
          .and()
          .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().logoutSuccessUrl("/")
          .and()
          .csrf().disable();
   }
}
