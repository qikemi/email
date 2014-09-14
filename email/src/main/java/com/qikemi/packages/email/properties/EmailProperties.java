package com.qikemi.packages.email.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * Create Date: 2014年9月14日 下午3:23:14
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/qikemi/mail>
 */
public class EmailProperties {

	private Logger logger = Logger.getLogger(EmailProperties.class);
	public static Properties emailProperties;
	
	public static Properties getEmailProperties() {
		if(null == emailProperties){
			EmailProperties properties = new EmailProperties();
			emailProperties = properties.getProperties();
		}
		return emailProperties;
	}
	
	private Properties getProperties(){
		// 系统发布路径 
//		String systemPath = this.getClass().getResource("/email.properties").getFile(); 
		try {
	        InputStream in = this.getClass().getResourceAsStream("/email.properties");  
			// 加载属性文件
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			return properties;
		} catch (FileNotFoundException e) {
			logger.warn("FileNotFoundException: ->" + e.getMessage());
		} catch (IOException e) {
			logger.warn("IOException: ->" + e.getMessage());
		}
		return null;
	}
}
