package com.tips.registration.service;

import com.tips.registration.model.User;
import com.tips.registration.model.VerificationToken;
import com.tips.registration.repository.UserRepository;
import com.tips.registration.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.Optional;
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

    @Autowired
    private UserRepository userRepository;

    public void sendNotification(User user) throws MessagingException {
        VerificationToken token = new VerificationToken(generateToken(),user);
        emailSenderService.sendEmail(user,token);
        verificationTokenRepository.save(token);
    }

    public boolean confirmUserByToken(String token){
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        if(tokenIsValid(verificationToken)){
           confirmUser(verificationToken);
            return true;
        }
        return false;
    }

    @Async
    public void confirmUser(Optional<VerificationToken> verificationToken) {
        verificationToken.ifPresent(token->{
            Optional<User>  user = userRepository.findById(token.getUser().getId());
            user.ifPresent(u-> u.setEnabled(true));
            userRepository.save(user.get());
        });
    }

    public boolean tokenIsValid(Optional<VerificationToken> token){

        return token.isPresent()?token.get().getExpiryDate().isAfter(LocalDateTime.now()):false;
    }


    public String generateToken(){
        return UUID.randomUUID().toString();
    }
}
