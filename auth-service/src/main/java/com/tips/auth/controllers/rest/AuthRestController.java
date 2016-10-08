package com.tips.auth.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author herasimau on 07.10.2016.
 */
@RestController
@RequestMapping("/")
public class AuthRestController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }


}
