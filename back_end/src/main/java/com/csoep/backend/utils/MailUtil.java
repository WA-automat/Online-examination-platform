package com.csoep.backend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 邮件工具类
 * @author WA_automat
 * @since 1.0
 */
@Component
public class MailUtil {

	@Autowired(required = false)
	private JavaMailSender mailSender; // 引入Spring Mail依赖后，会自动装配到IOC容器。用来发送邮件

	@Value("${spring.mail.username}")
	private String from;

	public String send(String to, String subject, String text) {
		try {
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setFrom(from);
			mail.setTo(to);
			mail.setSubject(subject);
			mail.setText(text);
			mailSender.send(mail);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

}
