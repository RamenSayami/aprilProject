/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.model.DTO.MailDto;
import com.mycompany.service.MailService;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ramen
 */
public class MailServiceImpl implements MailService {

    @Override
    public void sendEmail(MailDto mailDto) {

        final String username = "rick.137c.sanchez@gmail.com";
        final String password = "p0k3m0ng0";
        
        

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("rick.137c.sanchez@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mailDto.getTo()));
            System.out.println(""+ mailDto.getSubject());
            message.setSubject(mailDto.getSubject());
            message.setText(mailDto.getMessage());

            Transport.send(message);

            System.out.println("Mail sent!");

        } catch (MessagingException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
    }

}
