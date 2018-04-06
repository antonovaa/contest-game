package com.dao;

import com.model.UserDetailsMain;
import com.model.UserDetailsPerson;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RememberMeRepositoryImpl implements RememberMeRepository {

    private final RememberMeRepositoryMapper rememberMeRepositoryMapper;

    @Autowired
    public RememberMeRepositoryImpl(RememberMeRepositoryMapper rememberMeRepositoryMapper) {
        this.rememberMeRepositoryMapper = rememberMeRepositoryMapper;
    }


    @Override
    public void updateCookie(HttpServletResponse response, UserDetailsPerson userDetailsPerson) {
        String c = createCookieUP(userDetailsPerson.getUserName(), userDetailsPerson.getPassword());
        rememberMeRepositoryMapper.updateCookie(c, userDetailsPerson.getId());
        Cookie cookie = new Cookie("CsrfCookie", c);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }

    @Override
    public UserDetailsMain getUserDetailsMainByCookie(String nptHash) {
        return rememberMeRepositoryMapper.getUser(nptHash);
    }

    @Override
    public String createCookieUP(String userName, String password) {
        return new BCryptPasswordEncoder().encode(userName + ":" + password);
    }

    @Override
    public void removeCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("CsrfCookie")) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }

}
