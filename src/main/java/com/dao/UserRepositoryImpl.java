package com.dao;

import com.model.UserDetailsMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

   private final UserMapper userMapper;

   @Autowired
   public UserRepositoryImpl(UserMapper userMapper) {
      this.userMapper = userMapper;
   }

   @Override
   public UserDetailsMain findByUsername(String username) {
      UserDetailsMain userDetailsMain=userMapper.getUser(username);
      userDetailsMain.setAuthorities(userMapper.getAuthorities(userDetailsMain.getId()));
      return userDetailsMain;
   }

   @Override
   public void saveUserDetailsMain(String username, String password, String email) {
      userMapper.saveUser(username,new BCryptPasswordEncoder().encode(password),email);
   }
}

