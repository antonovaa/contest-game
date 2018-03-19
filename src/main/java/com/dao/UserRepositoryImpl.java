package com.dao;

import com.model.Role;
import com.model.UserDetailsMain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

   private final JdbcTemplate jdbcTemplate;
   public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public UserDetailsMain findByUsername(String username) {
      String sqlUser="select * from public.usersetails u WHEre u.username=?";
      String sqlRole="select u.role from public.userroles u WHEre u.user_id=?";


      UserDetailsMain userDetailsMain= jdbcTemplate.queryForObject(
          sqlUser,new Object[]{username},
          (rs, rowNum) -> {
             UserDetailsMain userDetailsMain1 = new UserDetailsMain();
             userDetailsMain1.setId(rs.getInt("id"));
             userDetailsMain1.setUsername(rs.getString("username"));
             userDetailsMain1.setPassword(rs.getString("password"));
             userDetailsMain1.setEmail(rs.getString("email"));
             userDetailsMain1.setEnabled(true);
             userDetailsMain1.setCredentialsNonExpired(true);
             userDetailsMain1.setAccountNonExpired(true);
             userDetailsMain1.setAccountNonLocked(true);
             return userDetailsMain1;
          }
      );
      List<Role> roles=new ArrayList<>();
      jdbcTemplate.queryForList(sqlRole,new Object[]{userDetailsMain.getId()},String.class).forEach(r-> roles.add(new Role(r)));
      userDetailsMain.setAuthorities(roles);

      return userDetailsMain;
   }

   @Override
   public void saveUserDetailsMain(String username,String password,String email) {
      String sql="INSERT INTO usersetails (username, password, email) VALUES(?,?,?)";
      jdbcTemplate.update(sql,new Object[]{username,password,email});
   }

}
