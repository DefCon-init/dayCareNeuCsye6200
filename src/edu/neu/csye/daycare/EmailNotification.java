package edu.neu.csye.daycare;

import java.util.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLSession;
import javax.activation.*;
import javax.mail.Transport.*;

public class EmailNotification {
	
	String host;
	String to;
	String user = "daycarecsye2021@gmail.com";
	String password = "daycarecsye";
	Properties properties;
	Session session;
	int f;
	
	public EmailNotification(String to) {
            this.to = to;
            this.host = "smtp.gmail.com";
            properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.user", user);
			properties.put("mail.smtp.password", password);
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
            this.session = Session.getInstance(properties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });
		
	}
}
