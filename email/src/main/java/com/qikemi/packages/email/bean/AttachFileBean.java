package com.qikemi.packages.email.bean;

/**
 * 
 * Create Date: 2014年9月14日 下午6:47:33
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/qikemi/email>
 */
public class AttachFileBean {

	public String fileName;
	public String filePath;
	
	public AttachFileBean() {
		super();
	}
	
	public AttachFileBean(String fileName, String filePath) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
