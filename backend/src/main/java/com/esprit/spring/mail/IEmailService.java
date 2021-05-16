package com.esprit.spring.mail;

public interface IEmailService {
	public void sendMail(String to, String subject, String body);

}