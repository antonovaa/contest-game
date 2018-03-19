package com.controller;


import com.dao.UserRepositoryImpl;
import com.model.UserDetailsMain;
import com.model.UserDetailsPerson;
import java.security.Principal;
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
   public String UserLogin(Principal principal) {
      UserDetailsMain user = (UserDetailsMain) SecurityContextHolder.getContext()
          .getAuthentication().getPrincipal();
      return "d3 name  " + user.getUsername() + "  " + user.getAuthorities();
   }


   @RequestMapping(value = "/UserRegistration", method = RequestMethod.POST)
   @ResponseBody
   public String UserRegistration(
//       @RequestParam("username") String username,
//       @RequestParam("password") String password,
//       @RequestParam("email") String email
       @RequestBody UserDetailsPerson userDetailsPerson
   ) {
      userRepository.saveUserDetailsMain(userDetailsPerson.getUserName(), userDetailsPerson.getPassword(), userDetailsPerson.getEmail());
      UserDetailsMain user = (UserDetailsMain) SecurityContextHolder.getContext()
          .getAuthentication().getPrincipal();
      return "d3 name  " + user.getUsername() + "  " + user.getAuthorities();
   }


}
