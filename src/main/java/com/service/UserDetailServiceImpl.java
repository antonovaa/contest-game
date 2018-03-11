package com.service;

import com.google.common.collect.ImmutableList;
import com.model.Role;
import com.model.UserDetailsMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

   private final JdbcTemplate jdbcTemplate;


   @Autowired
   public UserDetailServiceImpl(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

//      String sql = "SELECT u.id,u.username,u.password,u.email FROM public.usersetails u WHERE u.username = ?";
      UserDetailsMain userDetailsMain;
//      userDetailsMain = (UserDetailsMain)jdbcTemplate.queryForObject(
//          sql, new Object[] { s }, UserDetailsMain.class);
      userDetailsMain=new UserDetailsMain(1,"Dro","123","123");
      userDetailsMain.setAccountNonExpired(true);
      userDetailsMain.setAccountNonLocked(true);
      userDetailsMain.setCredentialsNonExpired(true);
      userDetailsMain.setEnabled(true);
      userDetailsMain.setAuthorities(ImmutableList.of(Role.USER));
      return userDetailsMain;

   }
}
