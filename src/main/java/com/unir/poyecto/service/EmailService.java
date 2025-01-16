package com.unir.poyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

	@Value("$spring.mail.username}")
	private String correo;

	@Autowired
	private JavaMailSender mailSender;

	public void enviarEmail(String para, String asunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(para);
		message.setSubject(asunto);
		message.setText(texto);
		message.setFrom(correo);

		mailSender.send(message);
	}
}