package com.controller;


import com.dao.RememberMeRepositoryImpl;
import com.dao.UserRepositoryImpl;
import com.model.UserDetailsMain;
import com.model.UserDetailsPerson;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Authorise {


   private final UserRepositoryImpl userRepository;
   private final RememberMeRepositoryImpl rememberMeRepository;

   @Autowired
   public Authorise(UserRepositoryImpl userRepository, RememberMeRepositoryImpl rememberMeRepository) {
      this.userRepository = userRepository;
      this.rememberMeRepository = rememberMeRepository;
   }

   @RequestMapping(value = "/UserLogin", method = RequestMethod.POST)
   @ResponseBody
   public Map<String, String> UserLogin(@RequestBody UserDetailsPerson userDetailsPerson,HttpServletRequest request,HttpServletResponse response) {
      Map<String,String> map=new HashMap<String, String>();

      try {
         request.login(userDetailsPerson.getUserName(),userDetailsPerson.getPassword());
         rememberMeRepository.updateCookie(response,userDetailsPerson);
         //todo set cookie and update
         map.put("result","0");
         map.put("name",userDetailsPerson.getUserName());
         return map;
      } catch (Exception e) {
         e.printStackTrace();
         map.put("result","1000");
         return map;
      }
   }

   @RequestMapping(value = "/logoutUser", method = RequestMethod.POST)
   @ResponseBody
   public String logout(HttpServletRequest request,HttpServletResponse response) {
      try {
         request.logout();

         //todo remove cookie
         rememberMeRepository.removeCookie(request,response);
         return "index";
      } catch (Exception e) {
         e.printStackTrace();
         return "1000";
      }

   }

   @RequestMapping(value = "/IsAuth", method = RequestMethod.POST)
   @ResponseBody
   public Map<String, String> IsAuth(@RequestBody UserDetailsPerson userDetailsPerson,HttpServletRequest request) {

      Map<String,String> map=new HashMap<String, String>();

      //todo get cookie and check

      String cVal=Stream
          .of(request.getCookies())
          .filter(e->e.getName().equals("CsrfCookie"))
          .map(Cookie::getValue)
          .findFirst().orElse("");
      UserDetailsMain userDetailsMain=rememberMeRepository.getUserDetailsMainByCookie(cVal);
      if(userDetailsMain!=null){
         try {
            request.login(userDetailsMain.getUsername(),userDetailsMain.getPassword());
         } catch (ServletException e) {
            e.printStackTrace();
         }
      }
         if(!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
            map.put("result","0");
            map.put("name",SecurityContextHolder.getContext().getAuthentication().getName());
            return map;
         }
         else {
            map.put("result","1001");
            return map;
         }
   }




   @RequestMapping(value = "/UserRegistration", method = RequestMethod.POST)
   @ResponseBody
   public int UserRegistration(
//       @RequestParam("username") String username,
//       @RequestParam("password") String password,
//       @RequestParam("email") String email
       @RequestBody UserDetailsPerson userDetailsPerson
   ) {
      userRepository.saveUserDetailsMain(userDetailsPerson.getUserName(), userDetailsPerson.getPassword(), userDetailsPerson.getEmail());
      return 0;
   }
}
