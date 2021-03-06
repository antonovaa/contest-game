package com.service;

import com.dao.UserRepository;
import com.model.UserDetailsMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;

   @Override
   public UserDetailsMain loadUserByUsername(String username) {
      UserDetailsMain user = userRepository.findByUsername(username);
      if (user == null) {
         throw new UsernameNotFoundException(username);
      }
      return user;
   }
}
