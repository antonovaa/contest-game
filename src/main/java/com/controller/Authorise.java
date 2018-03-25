package com.controller;


import com.dao.UserRepositoryImpl;
import com.model.UserDetailsPerson;
import java.util.HashMap;
import java.util.Map;
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
   public Map<String, String> UserLogin(@RequestBody UserDetailsPerson userDetailsPerson,HttpServletRequest request) {
      Map<String,String> map=new HashMap<String, String>();

      try {
         request.login(userDetailsPerson.getUserName(),userDetailsPerson.getPassword());
         map.put("result","0");
         map.put("name",userDetailsPerson.getUserName());
         return map;
      } catch (Exception e) {
         e.printStackTrace();
         map.put("result","1000");
         return map;
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
   public Map<String, String> IsAuth(@RequestBody UserDetailsPerson userDetailsPerson,HttpServletRequest request) {

      Map<String,String> map=new HashMap<String, String>();
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
