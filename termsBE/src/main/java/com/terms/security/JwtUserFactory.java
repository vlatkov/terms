package com.terms.security;

import com.terms.domen.Role;
import com.terms.domen.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;


public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.getActive(),
                user.getImgUrl(),
                user.getAddress(),
                user.getLastPasswordResetDate()
        );
    }
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getNameRole()))
                .collect(Collectors.toList());
    }

}
