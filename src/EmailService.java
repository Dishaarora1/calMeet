import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	public static int sendMail(String toEmail, String name, String subject, String description) {
		int status = 0;
		String host="smtp.gmail.com";
		// enter your email and  password
		final String user="";
		final String pass = "";
		Properties props = new Properties();  
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");  
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("teamcalmeet@gmail.com"));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			message.setSubject("CalMeet Reminder : " + subject);
			message.setText("Hello, " + name + ". " + description);
			
			Transport.send(message);
			status = 1;
		} catch(Exception e) {
			System.out.println("EmailService :::: Error in sendMail() :::: " + e);
			status = 0;
		}
		
		return status;
	}
	
}
