package com.studybro.services;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.studybro.model.User;

@PropertySource("classpath:application.properties")
@Service("emailservice")
public class EmailServiceImpl implements EmailService 
{
	
	@Autowired
    public JavaMailSender javaMailSender;
	
	@Override
	public void sendmail(String subject, String mailpath ,User user) throws MessagingException
	{
	
		try 
		{
			sendMimeMessages(user,mailpath,subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void sendMimeMessages(User u,String mailpath, String subject) throws MessagingException
	{
		MimeMessage generateMailMessage =javaMailSender.createMimeMessage();
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(u.getEmail())); // jisko email bhejna h 
		generateMailMessage.setSubject(subject);
		generateMailMessage.setSubject("Verify Your Email Account");
		generateMailMessage.setContent(getHtmlContent(mailpath),"text/html");
		System.out.println("Mail Session has been created successfully..");
		javaMailSender.send(generateMailMessage);
	}
	
	   public  String getHtmlContent(String mailpath)
	    {
	    	try
	    	{
	    		
	    		System.out.println("Getting html file");
	    	//File file= new File(this.getClass().getResource(mailpath).getFile());
	    	File file =ResourceUtils.getFile("classpath:"+mailpath);
	    	String message =FileUtils.readFileToString(file, "UTF-8");
	    	return message;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	
	    	}
	    	return null;
	    			
	    }

}
