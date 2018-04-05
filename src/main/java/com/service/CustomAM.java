package com.service;

import com.model.UserDetailsMain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAM implements AuthenticationManager {

private final UserDetailServiceImpl userDetailService;

   public CustomAM(UserDetailServiceImpl userDetailService) {
      this.userDetailService = userDetailService;
   }


   @Override
   public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      String username = authentication.getPrincipal() + "";
      String password = authentication.getCredentials() + "";

      UserDetailsMain user = userDetailService.loadUserByUsername(username);
      if (user == null) {
         throw new BadCredentialsException("1000");
      }
      if (!user.isEnabled()) {
         throw new DisabledException("1001");
      }
      if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
         throw new BadCredentialsException("1002");
      }
      return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
   }
}
