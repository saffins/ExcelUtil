package com.ecw.utilities;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import ExcelReaderUtility.ReadFromTxt;

public class Mailer {
	
	public static void sendMail(){
	try {
		String host = "smtp.gmail.com";
		String user = "noreplychangelogs@gmail.com";
		String pass = "ATKT4343k";
		String cc1 = "ankit.patel@eclinicalworks.com";
		String cc2 = "ankit.patel@eclinicalworks.com";
		String cc3 = "ankit.patel@eclinicalworks.com";

		String to = "saffin.shivani@eclinicalworks.com";

		String from = "noreply@reports.com";
		String subject = "change log report";
		String messageText = ReadFromText.readData();
		boolean sessionDebug = false;

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.required", "true");

		java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(sessionDebug);
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] address = { new InternetAddress(to)/*, new InternetAddress(cc)*/ };
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject(subject);
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart = new MimeBodyPart();
		String filename = "C:\\JavaWorkspace\\DataDrivenFramework\\src\\test\\resources\\excel\\registration.xlsx";
		DataSource source = new FileDataSource(filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		Multipart multipart = new MimeMultipart();

		multipart.addBodyPart(messageBodyPart);
		msg.setSentDate(new Date());
		msg.setText(messageText);

		Transport transport = mailSession.getTransport("smtp");
		transport.connect(host, user, pass);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
		System.out.println("message send successfully");
	} catch (Exception ex) {
		System.out.println(ex);
	}

	}
}
