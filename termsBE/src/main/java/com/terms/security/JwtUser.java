package com.terms.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;


public class JwtUser implements UserDetails {

    private final Long id;
    private final Collection<? extends GrantedAuthority> authorities;
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String newPassword;
    private final String email;
    private final String phone;
    private final Date lastPasswordResetDate;
    private final boolean active;
    private final String imgUrl;


    public JwtUser(
            Long id,
            Collection<? extends GrantedAuthority> authorities,
            String userName,
            String firstName,
            String lastName,
            String password,
            String newPassword,
            String email,
            boolean active,
            String imgUrl,
            String phone,
            Date lastPasswordResetDate

    ) {
        this.id = id;
        this.authorities = authorities;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.newPassword = newPassword;
        this.active = active;
        this.imgUrl = imgUrl;
        this.phone = phone;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }


    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public String getNewPassword() {
        return newPassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return (Collection<? extends GrantedAuthority>) authorities;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

  /*  public Role getRole() {
        return role;
    }*/

    public String getImgUrl() {
        return imgUrl;
    }
}
