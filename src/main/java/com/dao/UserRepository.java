package com.dao;

import com.model.UserDetailsMain;

public interface UserRepository {
   UserDetailsMain findByUsername(String username);
   void saveUserDetailsMain(String username,String password,String email);
}
