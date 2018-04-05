package com.config.AutoLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Service;

@Service
public class CustomRememberMeService implements RememberMeServices{

   @Override
   public Authentication autoLogin(HttpServletRequest httpServletRequest,
       HttpServletResponse httpServletResponse) {
      return null;
   }

   @Override
   public void loginFail(HttpServletRequest httpServletRequest,
       HttpServletResponse httpServletResponse) {

   }

   @Override
   public void loginSuccess(HttpServletRequest httpServletRequest,
       HttpServletResponse httpServletResponse, Authentication authentication) {

   }
}
