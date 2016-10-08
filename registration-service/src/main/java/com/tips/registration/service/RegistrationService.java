package com.tips.registration.service;

import com.tips.registration.model.User;
import com.tips.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

/**
 * @author herasimau on 07.10.2016.
 */
@Service
@Transactional(isolation= Isolation.REPEATABLE_READ)
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenService verificationTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Async
    public void registerUser(User user) throws MessagingException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        sendNotification(user);

    }


    public void sendNotification(User user) throws MessagingException {
        verificationTokenService.sendNotification(user);
    }
    //TODO: Make method can't read dirty reads from DB, when registerUser try to save new User
    public  boolean canRegister(String email){

        return !userRepository.findByEmail(email).isPresent();

    }
}
