package com.forme.app.auth.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final String sendGridApiKey = System.getenv("SENDGRID_API_KEY");


    public void sendPasswordResetEmail(String to, String token) {
        String subject = "Réinitialisation du mot de passe";
        String content = "Cliquez sur le lien suivant pour réinitialiser votre mot de passe : "
                + "http://localhost:5174/reset-password/" + token;

        sendEmail(to, subject, content);
    }

    private void sendEmail(String to, String subject, String content) {
        Email from = new Email("no-reply@prepa-competences.com");
        Email toEmail = new Email(to);
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, toEmail, emailContent);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
        } catch (IOException ex) {
            throw new RuntimeException("Erreur lors de l'envoi de l'email", ex);
        }
    }
}