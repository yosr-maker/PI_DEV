package com.esprit.spring.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailImpl implements IEmailService {
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public void sendMail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
		
	}

}
