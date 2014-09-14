package com.qikemi.packages.test.email;

import java.util.Properties;

import org.junit.Test;

import com.qikemi.packages.email.EmailSender;
import com.qikemi.packages.email.bean.MailBean;
import com.qikemi.packages.email.bean.MailServiceBean;
import com.qikemi.packages.email.properties.EmailProperties;

/**
 * 
 * Create Date: 2014年9月14日 下午3:11:05
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/qikemi/email>
 */
public class SendMailTest {

	@Test
	public void getProperties(){
		// test load email properties 
		Properties p = EmailProperties.getEmailProperties();
		System.out.println(p);
	}
	
	@Test
	public void sendTextMail1(){
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "测试邮件内容");
		boolean b = EmailSender.sendTextMail(mailBean);
		System.out.println(b);
	}
	
	@Test
	public void sendTextMail2(){
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.qq.com", "hixxb@qq.com", "123456");
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "测试邮件内容");
		boolean b = EmailSender.sendTextMail(mailServiceBean, mailBean);
		System.out.println(b);
	}
	
	@Test
	public void sendTextMail3(){
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.qq.com", "25", "hixxb@qq.com", "123456");
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "测试邮件内容");
		boolean b = EmailSender.sendTextMail(mailServiceBean, mailBean);
		System.out.println(b);
	}
	
	@Test
	public void sendHtmlMail1(){
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "<html><head></head><style>body{color: red;}</style><body>测试邮件内容<body></html>");
		boolean b = EmailSender.sendHtmlMail(mailBean);
		System.out.println(b);
	}
	
	@Test
	public void sendHtmlMail2(){
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.qq.com", "hixxb@qq.com", "123456");
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "<html><head></head><style>body{color: red;}</style><body>测试邮件内容<body></html>");
		boolean b = EmailSender.sendHtmlMail(mailServiceBean, mailBean);
		System.out.println(b);
	}
	
	@Test
	public void sendHtmlMail3(){
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.qq.com", "25", "hixxb@qq.com", "123456");
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "<html><head></head><style>body{color: red;}</style><body>测试邮件内容<body></html>");
		boolean b = EmailSender.sendHtmlMail(mailServiceBean, mailBean);
		System.out.println(b);
	}
}
