package com.listners;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements
    AuthenticationSuccessHandler {


   @Override
   public void onAuthenticationSuccess(HttpServletRequest request,
       HttpServletResponse response, Authentication authentication) throws IOException,
       ServletException {

      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
         Arrays.stream(cookies)
             .forEach(c -> System.out.println(c.getName() + "=" + c.getValue()));
      }

      HttpSession session = request.getSession();
      Cookie newCookie = new Cookie("testCookie", "testCookieValue");
      newCookie.setMaxAge(24 * 60 * 60);
      response.addCookie(newCookie);


      response.addCookie(newCookie);
   }
}
