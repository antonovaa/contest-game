package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecuriryConfig extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
          .authorizeRequests()
          .antMatchers("/readme.txt", "/js/*","/index","/**").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin().loginPage("/index.html#/login").permitAll()
          .and()
          .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();

   }
}
