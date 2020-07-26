package com.servletstudy.dbUtil;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletResponse;

public class EmailClass {
	
	public static void sendEmail(String from,String pass,String to,HttpServletResponse response) throws IOException {
		
		String fromEmail = from;
		String password = pass;
		
		String toEmail = to;
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");

		Authenticator authenticator = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}

		};
		/**
		*  Create the java.mail.Session by calling Session.getInstance(properties, authenticator) method 
		*	or Session.getDefaultInstance(properties) 
		*/
		Session mailSession = Session.getInstance(properties, authenticator);

		try {
			InternetAddress addressFrom = new InternetAddress(fromEmail);
			InternetAddress addressTo = new InternetAddress(toEmail);

			MimeMessage message = new MimeMessage(mailSession);
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");

			message.setFrom(addressFrom);
			message.addRecipient(RecipientType.TO, addressTo);
			message.setSubject("Subject Line JavaMail Application Server", "UTF-8");
			message.setText("Message Text Body JavaMail Application Server by Branislav Osadkovski ::" + EmailClass.class+"::","UTF-8");
			message.setSentDate(new Date());

			Transport.send(message);
			
			String title = "Send Email";
			String res = "Sent message successfully....";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

			response.getWriter().write(docType+
					"<html>\n" +
		               "<head><title>" + title + "</title></head>\n" +
		               "<body bgcolor = \"#f0f0f0\">\n" +
		                  "<h1 align = \"center\">" + title + "</h1>\n" +
		                  "<p align = \"center\">" + res + "</p>\n" +
		               "</body>"+
		            "</html>"
					
					);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}