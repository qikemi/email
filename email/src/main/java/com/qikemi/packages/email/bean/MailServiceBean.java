package com.qikemi.packages.email.bean;

import java.util.Properties;

/**
 * Configure Mail service info. 
 * 
 * Create Date: 2014年9月14日 下午4:02:33
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/qikemi/email>
 */
public class MailServiceBean {

	private String mailServerHost;
	private String mailServerPort = "25";
	// 登陆邮件服务器的用户名和密码 
	private String mailServerUserName;
	private String mailServerPwd;
	
	// default 
	public MailServiceBean() {}
	
	// sample 
	public MailServiceBean(String mailServerHost, String mailServerUserName,
			String mailServerPwd) {
		super();
		this.mailServerHost = mailServerHost;
		this.mailServerUserName = mailServerUserName;
		this.mailServerPwd = mailServerPwd;
	}
	
	// full 
	public MailServiceBean(String mailServerHost, String mailServerPort,
			String mailServerUserName, String mailServerPwd) {
		this.mailServerHost = mailServerHost;
		this.mailServerPort = mailServerPort;
		this.mailServerUserName = mailServerUserName;
		this.mailServerPwd = mailServerPwd;
	}
	
	/**
	 * 获得邮件session属性 
	 */
	public Properties getProperties(boolean validate) {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public String getMailServerUserName() {
		return mailServerUserName;
	}

	public void setMailServerUserName(String mailServerUserName) {
		this.mailServerUserName = mailServerUserName;
	}

	public String getMailServerPwd() {
		return mailServerPwd;
	}

	public void setMailServerPwd(String mailServerPwd) {
		this.mailServerPwd = mailServerPwd;
	}

}
