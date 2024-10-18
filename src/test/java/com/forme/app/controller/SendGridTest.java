package com.forme.app.controller;
import com.sendgrid.*;
import java.io.IOException;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;

import com.sendgrid.helpers.mail.objects.Email;

public class SendGridTest {
  public static void main(String[] args) throws IOException {
    String apiKey = System.getenv("SENDGRID_API_KEY");
    System.out.println("SENDGRID_API_KEY: " + apiKey); // Ligne de débogage
    if (apiKey == null || apiKey.isEmpty()) {
      System.out.println("SENDGRID_API_KEY is not set");
      return;
    }

    Email from = new Email("test@example.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email("test@example.com");
    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(apiKey);
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}