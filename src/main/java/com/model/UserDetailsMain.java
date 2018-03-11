package com.model;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsMain implements UserDetails {

   private int id;
   private String username;
   private String email;
   private String password;


   private List<Role> authorities;


   private boolean accountNonExpired;
   private boolean accountNonLocked;
   private boolean credentialsNonExpired;
   private boolean enabled;

   public void setAuthorities(List<Role> authorities) {
      this.authorities = authorities;
   }

   public void setAccountNonExpired(boolean accountNonExpired) {
      this.accountNonExpired = accountNonExpired;
   }

   public void setAccountNonLocked(boolean accountNonLocked) {
      this.accountNonLocked = accountNonLocked;
   }

   public void setCredentialsNonExpired(boolean credentialsNonExpired) {
      this.credentialsNonExpired = credentialsNonExpired;
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   public UserDetailsMain() {
   }

   public UserDetailsMain(int id, String username, String email, String password) {
      this.id = id;
      this.username = username;
      this.email = email;
      this.password = password;
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setPassword(String password) {
      this.password = password;
   }



   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.authorities;
   }

   @Override
   public String getUsername() {
      return username;
   }

   @Override
   public boolean isAccountNonExpired() {
      return this.accountNonExpired;
   }

   @Override
   public boolean isAccountNonLocked() {
      return this.accountNonLocked;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return this.credentialsNonExpired;
   }

   @Override
   public boolean isEnabled() {
      return this.enabled;
   }

   @Override
   public String getPassword() {
      return password;
   }
}
