package com.second.secondbatchVeer.mail;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/send")
    @ResponseBody
    public String email(){
        System.out.println("Bhej do");
        emailService.sendSimpleMail("veerlodhi54@gmail.com",
                "Test Mail",
                "This is a test Email, H0ve a Nice Day"
                );
        return "Mail Sent";
    }
@GetMapping("/veerhtml")
public String htmlform(){
        return "mail";
}


    @PostMapping("/sendhtmlmail")
    public String htmlMail(String to, String subject, String body) throws MessagingException {
//        String html="<h1>RGPV</h1><hr><h2>From BTIRT using SpringBoot</h2><hr><h2>5100 ki mithai</h2>";
            emailService.htmlMail(to, subject, body);
        return  "confirmation";
    }

    @GetMapping("/sendhtmlattachment")
    public String htmlattach(String to, String subject, String body, String attachment) throws MessagingException {
        String html="<h1>RGPV</h1><hr><h2>From BTIRT using SpringBoot</h2><hr><h2>5100 ki mithai</h2>";
        emailService.htmlAttachment(to,subject,body,attachment);
        return  "confirmation";
    }
}
