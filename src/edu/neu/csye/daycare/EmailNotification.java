package edu.neu.csye.daycare;

import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailNotification {

	String host;
	String to;
	String user = "daycarecsye2021@gmail.com";
	String password = "daycarecsye";
	String receipient;
	String studentName;
	Properties properties;
	Session session;
	String subject;
	//	String dose;
	String vaccine;
	String pendingDate;
	String phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNum) {
		this.phoneNumber = phoneNum;
	}

	public String getPendingDate() {
		return pendingDate;
	}

	public void setPendingDate(String revDate) {
		this.pendingDate = revDate;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studName) {
		this.studentName = studName;
	}

	public String getReceipient() {
		return receipient;
	}

	public void setReceipient(String recpName) {
		this.receipient = recpName;
	}

	public void sendImmunizationNotification() {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.phoneNumber+"@tmomail.net"));
			message.setSubject("Reminder: Student vaccination is due");
			message.setText("Hi " + this.getReceipient() + ",\nVaccination for " + this.getStudentName() + " for the vaccine " +  this.getVaccine() + " is due.\n Thanks & Regards,\n Daycare");
			Transport transport = this.session.getTransport("smtp");
			transport.connect(host, 587, user,  password);
			transport.sendMessage(message, message.getAllRecipients());

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendReviewNotification() {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Reminder : Annual Review is Pending");
			message.setText("Hi " + this.getReceipient() + ",\n Your annual review is scheduled on " + this.getPendingDate() + ". Please report to the office on the mentioned date. \n Thanks & Regards, \n Daycare ");
			Transport transport = this.session.getTransport("smtp");
			transport.connect(host, 587, user,  password);
			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendRegistrationNotification() {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));message.setSubject("Reminder : Annual Registration is Pending");
			message.setText("Hi " + this.getReceipient() + ",\n Please renew registration for your child " + this.getStudentName()  + "before " + this.getPendingDate()+ ".\n Thanks & Regards, \n Daycare ");
			Transport transport = this.session.getTransport("smtp");
			transport.connect(host, 587, user,  password);
			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
