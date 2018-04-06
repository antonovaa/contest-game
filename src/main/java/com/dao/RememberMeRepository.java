package com.dao;

import com.model.UserDetailsMain;
import com.model.UserDetailsPerson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RememberMeRepository {

    public void updateCookie(HttpServletResponse response, UserDetailsPerson userDetailsPerson);

    public UserDetailsMain getUserDetailsMainByCookie(String nptHash);

    public String createCookieUP(String userName,String password);

    public void removeCookie(HttpServletRequest request,HttpServletResponse response);

}
