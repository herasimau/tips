package com.tips.registration.controllers;

import com.tips.registration.model.JsonResponse;
import com.tips.registration.model.User;
import com.tips.registration.service.RegistrationService;
import com.tips.registration.service.VerificationTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

/**
 * @author herasimau on 07.10.2016.
 */
@RestController
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private VerificationTokenService verificationTokenService;


    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws MessagingException {
        if (registrationService.canRegister(user.getEmail())) {
            registrationService.registerUser(user);
            logger.info("Registered user " + user.getEmail());
            registrationService.sendNotification(user);
            return new ResponseEntity<>(JsonResponse.successTrue, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(JsonResponse.successFalse, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/register/confirm/{token}")
    public ResponseEntity<?>  confirmUser(@PathVariable String token){
        if(verificationTokenService.confirmUserByToken(token)){
            logger.info("Confirmed user with token "+token);
            return new ResponseEntity<>(JsonResponse.successTrue,HttpStatus.OK);
        }
        return new ResponseEntity<>(JsonResponse.successFalse,HttpStatus.CONFLICT);
    }
}

