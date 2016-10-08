package com.tips.registration.service;

import com.tips.registration.model.User;
import com.tips.registration.model.VerificationToken;
import com.tips.registration.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.UUID;

/**
 * @author herasimau on 07.10.2016.
 */
@Service
@Transactional
public class VerificationTokenService {

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public void sendNotification(User user) throws MessagingException {
        VerificationToken token = new VerificationToken(generateToken(),user);
        emailSenderService.sendEmail(user,token);
        verificationTokenRepository.save(token);
    }

    public String generateToken(){
        return UUID.randomUUID().toString();
    }
}
