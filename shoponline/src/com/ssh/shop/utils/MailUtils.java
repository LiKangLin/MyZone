package com.ssh.shop.utils;

import java.util.Properties;







import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

//发送邮件的工具
public class MailUtils {
	public static void sendMail(String to,String code) throws Exception {
		Properties props= new Properties();
		props.setProperty("mail.smtp", "localhost");
		// 1.session对象，连接（与邮箱服务器连接）
		//注意session的导包
		Session session = Session.getInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "1234"); //发送方与服务器连接
			}
		});
		
		//2.构建邮件信息
		Message message = new MimeMessage(session);
		//发件人：
		message.setFrom(new InternetAddress("service@shop.com"));
		//收件人：
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		//设置标题
		message.setSubject("来自shop的激活邮件");
		//设置正文,本机ip
		message.setContent("<h1>来自SHOP的官网激活邮件</h1><h3><a href='http://10.13.64.150:8080/shoponline/user_active.action?code="+code+"'>http://10.13.64.150:8080/shoponline/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		// 3.发送对象
		Transport.send(message);
	
	}
}
