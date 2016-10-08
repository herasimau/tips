package com.tips.registration.service;

import com.tips.registration.model.User;
import com.tips.registration.model.VerificationToken;
import com.tips.registration.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.Optional;

/**
 * @author herasimau on 07.10.2016.
 */
@Service
@Transactional
public class RegistrationService {

    private static final Logger Logger = LoggerFactory.getLogger(RegistrationService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenService verificationTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Async
    public void sendNotification(User user) throws MessagingException {
        verificationTokenService.sendNotification(user);
    }

    public  boolean canRegister(String email){

        return !userRepository.findByEmail(email).isPresent();

    }

}
