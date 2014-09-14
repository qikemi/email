package com.qikemi.packages.email.bean;

import java.util.List;

/**
 * E-mail bean
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作 者，注明出处。
 * @URL 代码地址：http://github.com/openRDF/rdf_fronts
 * @dateTime 2014-3-22 下午6:47:59
 * @author XieXianbin
 * @email a.b@hotmail.com
 */

public class MailBean {
	
	// 邮件服务是否身份验证
	private boolean validate = true;
	// 邮件接收者的地址
	private String toAddress;
	// 邮件主题
	private String subject;
	// 邮件的文本内容
	private String content;
	// 邮件附件的文件名
	private List<AttachFileBean> attachFileList;
	
	// default 
	public MailBean() {}
	
	// sample 
	public MailBean(String toAddress, String subject, String content) {
		super();
		this.toAddress = toAddress;
		this.subject = subject;
		this.content = content;
	}
	
	public MailBean(boolean validate, String toAddress, String subject,
			String content) {
		super();
		this.validate = validate;
		this.toAddress = toAddress;
		this.subject = subject;
		this.content = content;
	}
	
	public MailBean(String toAddress, String subject,
			String content, List<AttachFileBean> attachFileList) {
		super();
		this.toAddress = toAddress;
		this.subject = subject;
		this.content = content;
		this.attachFileList = attachFileList;
	}

	// full
	public MailBean(boolean validate, String toAddress, String subject,
			String content, List<AttachFileBean> attachFileList) {
		super();
		this.validate = validate;
		this.toAddress = toAddress;
		this.subject = subject;
		this.content = content;
		this.attachFileList = attachFileList;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<AttachFileBean> getAttachFileList() {
		return attachFileList;
	}

	public void setAttachFileList(List<AttachFileBean> attachFileList) {
		this.attachFileList = attachFileList;
	}

}