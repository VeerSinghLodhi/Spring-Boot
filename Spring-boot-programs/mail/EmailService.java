package com.second.secondbatchVeer.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;


    public void sendSimpleMail(String to, String subject, String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void htmlMail(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage m=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(m,true);
        helper.setFrom("samule5676@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody,true);
        mailSender.send(m);
    }

    public void htmlAttachment(String to, String subject, String htmlBody, String attachment) throws MessagingException {
        MimeMessage m=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(m,true);
        helper.setFrom("samule5676@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody,true);

        FileSystemResource f=new FileSystemResource(new File(attachment));
        helper.addAttachment(f.getFilename(),f);
        mailSender.send(m);
    }

}
