package com.tips.registration.service;

import com.tips.registration.model.User;
import com.tips.registration.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
/**
 * @author herasimau on 07.10.2016.
 */
@Service
public class EmailSenderService {

    @Autowired EmailHtmlSender emailHtmlSender;

    public void sendEmail(User user, VerificationToken token) throws MessagingException {

        Context context = new Context();
        context.setVariable("confirmationLink", "http://localhost:9292/register/confirm/"+token.getToken());
        context.setVariable("email", user.getEmail());
        emailHtmlSender.send(user.getEmail(), "Confirm your mail", "confirmation", context);
    }
}
