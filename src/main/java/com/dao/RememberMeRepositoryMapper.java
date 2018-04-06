package com.dao;

import com.model.UserDetailsMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RememberMeRepositoryMapper {


    @Select("select * from public.users_details u WHEre u.npt_hash = #{nptHash}")
    UserDetailsMain getUser(@Param("nptHash") String nptHash);

    @Update("update  users_details set npt_hash=#{nptHash} where user_id=#{userId}")
    void updateCookie(@Param("nptHash") String nptHash,@Param("userId") int userId);

}
