package com.model;

import com.model.interf.DomainObject;

import java.util.UUID;

/**
 * Created by Lord on 23.09.2017.
 */

public class Person implements DomainObject{

    private UUID uuid;

    private String login;

    private String password;

    private String mail;

    private Long phone;

    public Person() {

    }

    public Person(Long phone, String mail, String password, String login) {
        this.phone = phone;
        this.mail = mail;
        this.password = password;
        this.login = login;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
