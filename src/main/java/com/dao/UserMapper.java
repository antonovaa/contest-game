package com.dao;

import com.model.Role;
import com.model.UserDetailsMain;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

   @Select("select * from public.usersetails u WHEre u.username = #{username}")
   UserDetailsMain getUser(@Param("username") String username);

   @Select("select u.role from public.userroles u WHEre u.user_id=#{user_id}")
   List<Role> getAuthorities(@Param("user_id") int user_id);

   @Insert("INSERT INTO usersetails (username, password, email) VALUES(#{username},#{password},#{email})")
   void saveUser(@Param("username") String username,@Param("password") String password,@Param("email") String email);
}
