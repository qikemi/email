package com.qikemi.packages.email;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.qikemi.packages.email.bean.MailBean;
import com.qikemi.packages.email.bean.MailServiceBean;
import com.qikemi.packages.email.properties.EmailProperties;

/**
 * Mail Sender Mail 发送邮件，调用时调用该方法。
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作 者，注明出处。
 * @URL 代码地址：http://github.com/openRDF/rdf_fronts
 * @dateTime 2014-3-22 下午7:43:59
 * @author XieXianbin
 * @email a.b@hotmail.com
 */

public class EmailSender {
	
	private static Logger logger = Logger.getLogger(EmailSender.class);
	
	public static MailServiceBean mailServiceBean;
	
	public static boolean sendTextMail(MailBean mailBean) {
		// 获取email的配置信息
		if (null == mailServiceBean) {
			EmailSender emailSender = new EmailSender();
			emailSender.getMailServiceBean();
		}
		EmailService emailService = new EmailService();
		// 采用以HTML格式发送邮件
		boolean send_state = emailService.sendTextMail(mailServiceBean, mailBean);
		logger.debug("Send Text Mail to: [" + mailBean.getToAddress()
				+ "] with subject: [" + mailBean.getSubject()
				+ "] .State is: [" + send_state + "]");
		// 返回发送邮件
		return send_state;
	}
	
	public static boolean sendHtmlMail(MailBean mailBean) {
		// 获取email的配置信息
		if (null == mailServiceBean) {
			EmailSender emailSender = new EmailSender();
			emailSender.getMailServiceBean();
		}
		EmailService emailService = new EmailService();
		// 采用以HTML格式发送邮件
		boolean send_state = emailService.sendHtmlMail(mailServiceBean, mailBean);
		logger.debug("Send Text Mail to: [" + mailBean.getToAddress()
				+ "] with subject: [" + mailBean.getSubject()
				+ "] .State is: [" + send_state + "]");
		// 返回发送邮件
		return send_state;
	}
	
	public static boolean sendTextMail(MailServiceBean mailServiceBean, MailBean mailBean) {
		EmailService emailService = new EmailService();
		// 采用以HTML格式发送邮件
		boolean send_state = emailService.sendTextMail(mailServiceBean, mailBean);
		logger.debug("Send Text Mail to: [" + mailBean.getToAddress()
				+ "] with subject: [" + mailBean.getSubject()
				+ "] .State is: [" + send_state + "]");
		// 返回发送邮件
		return send_state;
	}
	
	public static boolean sendHtmlMail(MailServiceBean mailServiceBean, MailBean mailBean) {
		EmailService emailService = new EmailService();
		// 采用以HTML格式发送邮件
		boolean send_state = emailService.sendHtmlMail(mailServiceBean, mailBean);
		logger.debug("Send Text Mail to: [" + mailBean.getToAddress()
				+ "] with subject: [" + mailBean.getSubject()
				+ "] .State is: [" + send_state + "]");
		// 返回发送邮件
		return send_state;
	}
	
	// get Email Configure from email.properties.
	private void getMailServiceBean() {
		// 加载属性文件
		// [mail_server_host="smtp.qq.com", pass_word="", user_name="hixxb@qq.com", server_port=25]
		Properties properties = EmailProperties.getEmailProperties();
		mailServiceBean = new MailServiceBean();
		mailServiceBean.setMailServerHost(properties.getProperty("mail_server_host"));
		mailServiceBean.setMailServerUserName(properties.getProperty("user_name"));
		mailServiceBean.setMailServerPort(properties.getProperty("server_port"));
		mailServiceBean.setMailServerPwd(properties.getProperty("pass_word"));
	}
}
