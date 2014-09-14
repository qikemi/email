package com.qikemi.packages.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.qikemi.packages.email.bean.MailBean;
import com.qikemi.packages.email.bean.MailServiceBean;

/**
 * Sender Mail
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作 者，注明出处。
 * @URL 代码地址：http://github.com/openRDF/rdf_fronts
 * @dateTime 2014-3-22 下午7:43:59
 * @author XieXianbin
 * @email a.b@hotmail.com
 *
 */
public class EmailService {
	
	private Logger logger = Logger.getLogger(EmailService.class);
	
	/**
	 * 以文本格式发送邮成功 
	 * 
	 * @param senderMailBean
	 *            待发送的邮件的信
	 */
	public boolean sendTextMail(MailServiceBean mailServiceBean, MailBean mailBean) {
		// 判断是否身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailServiceBean.getProperties(mailBean.isValidate());
		if (mailBean.isValidate()) {
			// 如果身份认证，则创建密码验证 
			authenticator = new MyAuthenticator(mailServiceBean.getMailServerUserName(), mailServiceBean.getMailServerPwd());
		}
		// 根据邮件会话属和密码验证器构发邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发者地
			Address from = new InternetAddress(mailServiceBean.getMailServerUserName());
			// 设置邮件消息的发送
			mailMessage.setFrom(from);
			// 创建邮件的接收地址，并设置到邮件消息中
			Address to = new InternetAddress(mailBean.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主
			mailMessage.setSubject(mailBean.getSubject());
			// 设置邮件消息发的时
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内
			String mailContent = mailBean.getContent();
			mailMessage.setText(mailContent);
			// 发邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
//			ex.printStackTrace();
			logger.error("MessagingException -> " + ex.getMessage());
		}
		return false;
	}

	/**
	 * 以HTML格式发邮件
	 * 
	 * @param mailServiceBean
	 * 			邮件服务器信息 
	 * @param mailBean
	 * 			待发送的邮件信息
	 * @return
	 */
	public boolean sendHtmlMail(MailServiceBean mailServiceBean, MailBean mailBean) {
		// 判断是否身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailServiceBean.getProperties(mailBean.isValidate());
		// 如果身份认证，则创建密码验证 
		if (mailBean.isValidate()) {
			authenticator = new MyAuthenticator(mailServiceBean.getMailServerUserName(), mailServiceBean.getMailServerPwd());
		}
		// 根据邮件会话属和密码验证器构发邮件的session 
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发者地
			Address from = new InternetAddress(mailServiceBean.getMailServerUserName());
			// 设置邮件消息的发送
			mailMessage.setFrom(from);
			// 创建邮件的接收地址，并设置到邮件消息中
			Address to = new InternetAddress(mailBean.getToAddress());
			// Message.RecipientType.TO属表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主
			mailMessage.setSubject(mailBean.getSubject());
			// 设置邮件消息发的时
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是容器类，包含MimeBodyPart类型的对
			Multipart mainPart = new MimeMultipart();
			// 创建包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mailBean.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内
			mailMessage.setContent(mainPart);
			// 发邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
//			ex.printStackTrace();
			logger.error("MessagingException -> " + ex.getMessage());
		}
		return false;
	}

}