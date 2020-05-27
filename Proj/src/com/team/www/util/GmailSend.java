package com.team.www.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;


public class GmailSend {

	public static void gmailSend(String name, String email) {
		String user = "sej0267@gmail.com";
		String password = "156478as";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			// 수신자 메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("sej0267@naver.com"));
			
			// Subject
			message.setSubject("이슬아 비밀번호 변경해야해"); // 메일 제목 입력
			// Text
			message.setText("변경은 요기서 하면되용"); // 메일 내용 입력
			
			// send the message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch(AddressException e) {
			e.printStackTrace();
		} catch(MessagingException e) {
			e.printStackTrace();
		}
	}

}
