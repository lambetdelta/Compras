package gob.tlajomulco.utiles;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

import javax.activation.*;

public class Email {
	private String to;
	private String from;
	private String host;
	private Properties properties;
	private String config_server;
	private String msn;
	private boolean attached;
	private Session session;
	private String subject;
	private String src;//Path del archivo
	private String HTML;
	private String nameFile;//Nombre de archivo incluida la extención
	public Email(String to,String from,String host,Properties properties,String config_server, String msn, 
			 String subject){
		//Sin archivo 
		this.to=to;
		this.from = from;
		this.host = host;
		this.config_server = config_server;
		this.msn = msn;
		this.properties = properties;
		this.attached = false;
		this.subject = subject;
		this.setHTML();
	}
	public Email(String to,String from,String host,Properties properties,String config_server, String msn, String subject,
			 String src,String nameFile){
		//Con archivo
		this.to=to;
		this.from = from;
		this.host = host;
		this.config_server = config_server;
		this.msn = msn;
		this.properties = properties;
		this.attached = true;
		this.subject = subject;
		this.src = src;
		this.nameFile = nameFile;
		this.setHTML();
	}
	private void configServer(){
//		this.properties.setProperty(this.config_server, this.host);
//		this.session = Session.getDefaultInstance(this.properties);
		this.session = Session.getDefaultInstance(this.properties,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("lambetdelta@gmail.com","gvyfebxxvtzlmtum");
			}
		});
	}
	public void sendEmail(){
		try {
			this.configServer();
			MimeMessage message = new MimeMessage(this.session);
			this.configEmail(message);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(this.HTML, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			if(this.attached)
				multipart = this.attachedFile(multipart);
			message.setContent(multipart);
			Transport.send(message);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Multipart  attachedFile(Multipart  multipart) throws MessagingException{
        try {
        	BodyPart messageBodyPart = new MimeBodyPart();
            String filename = this.src;
            DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(this.nameFile);
	        multipart.addBodyPart(messageBodyPart);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return multipart;
	}
	private void configEmail(MimeMessage message){
		try{
			message.setFrom(new InternetAddress(this.host));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			message.setSubject(this.subject);
		}catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setHTML(){
		this.HTML = "<html><head><meta http-equiv='Content-Type' "
				+ "content='text/html; charset=UTF-8'><meta name='viewport' "
				+ "content='width=device-width, initial-scale=1, user-scalable=no'></head>"
				+ "<body>" + this.msn + "</body></html>";
	}
}
