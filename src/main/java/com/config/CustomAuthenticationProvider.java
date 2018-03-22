//package com.config;
//
//import com.model.UserDetailsMain;
//import com.service.UserDetailServiceImpl;
//import java.util.Collection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//   @Autowired
//   private UserDetailServiceImpl userDetailService;
//
//   @Override
//   public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//      String username = authentication.getName();
//      String password = (String) authentication.getCredentials();
//
//      UserDetailsMain user = userDetailService.loadUserByUsername(username);
//
//      if (user == null) {
//         throw new BadCredentialsException("Username not found.");
//      }
//
//      if (!password.equals(user.getPassword())) {
//         throw new BadCredentialsException("Wrong password.");
//      }
//
//      Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
//
//      return new UsernamePasswordAuthenticationToken(user, password, authorities);
//   }
//
//   @Override
//   public boolean supports(Class<?> arg0) {
//      return true;
//   }
//}