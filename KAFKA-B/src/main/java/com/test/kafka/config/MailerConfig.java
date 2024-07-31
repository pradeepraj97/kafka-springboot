package com.test.kafka.config;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


import org.springframework.stereotype.Service;


import java.util.Properties;


@Service
public class MailerConfig {
    private static final String USERNAME = "pradeeprajcs55@gmail.com";
    private static final String PASSWORD = "doxfkasfcuvzebhl";
    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 587;

    public static void sendEmail(String email, String subject, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(subject);
            message.setContent(content, "text/html; charset=utf-8");
            if (email.equals("pradeeprajcs55@gmail.com")) {
                Transport.send(message);
            }
            System.out.println("Mail has been sent successfully!");
        } catch (MessagingException e) {

        }
    }

}