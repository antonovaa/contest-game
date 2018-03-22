package com.controller;


import com.dao.UserRepositoryImpl;
import com.model.UserDetailsPerson;
import javax.servlet.http.HttpServletRequest;
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

   @Autowired
   public Authorise(UserRepositoryImpl userRepository) {
      this.userRepository = userRepository;
   }

   @RequestMapping(value = "/UserLogin", method = RequestMethod.POST)
   @ResponseBody
   public int UserLogin(@RequestBody UserDetailsPerson userDetailsPerson,HttpServletRequest request) {
      try {
         request.login(userDetailsPerson.getUserName(),userDetailsPerson.getPassword());
         return 0;
      } catch (Exception e) {
         e.printStackTrace();
         return 1000;
      }

   }

//   @RequestMapping(value = "/logoutUser", method = RequestMethod.POST)
//   @ResponseBody
//   public String logout(HttpServletRequest request) {
//      try {
//         request.logout();
//         return "index";
//      } catch (Exception e) {
//         e.printStackTrace();
//         return "1000";
//      }
//
//   }

   @RequestMapping(value = "/IsAuth", method = RequestMethod.POST)
   @ResponseBody
   public int IsAuth(@RequestBody UserDetailsPerson userDetailsPerson,HttpServletRequest request) {

         if(!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) return 0;
         else return 1001;
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
