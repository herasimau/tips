package com.tips.auth.model;

/**
 * @author herasimau on 07.10.2016.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    public CurrentUser(User user){
        super(user.getEmail(),user.getPassword(),user.getAuthorities());
    }

}
