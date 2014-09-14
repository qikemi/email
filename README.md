Email Sender
=====

Create by xiexianbin, Package For Email Sender.

Home page: http://qikemi.github.io/email/

Demo
====

Send Text Mail 1.
```
	@Test
	public void sendTextMail1(){
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "测试邮件内容");
		EmailSender.sendTextMail(mailBean);
	}
```

Send Text Mail 2.
```	
	@Test
	public void sendTextMail2(){
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.qq.com", "hixxb@qq.com", "123456");
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "测试邮件内容");
		EmailSender.sendTextMail(mailServiceBean, mailBean);
	}
```

Send Text Mail 3.
```
	@Test
	public void sendTextMail3(){
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.qq.com", "25", "hixxb@qq.com", "123456");
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "测试邮件内容");
		EmailSender.sendTextMail(mailServiceBean, mailBean);
	}
```

Send Text Mail With Attach File 4.
```
	@Test
	public void sendTextMail4(){
		List<AttachFileBean> fileBeans = new ArrayList<AttachFileBean>();
		fileBeans.add(new AttachFileBean("真实性核验单.png", "H:\\真实性核验单.png"));
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.163.com", "25", "xianbinxie@163.com", "WRDwrd3");
		MailBean mailBean = new MailBean("hixxb@qq.com", "测试邮件主题", "测试邮件附件", fileBeans);
		EmailSender.sendTextMail(mailServiceBean, mailBean);
	}
```

Send Html Mail 1.
```
	@Test
	public void sendHtmlMail1(){
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "<html><head></head><style>body{color: red;}</style><body>测试邮件内容<body></html>");
		EmailSender.sendHtmlMail(mailBean);
	}
```

Send Html Mail 2.
```
	@Test
	public void sendHtmlMail2(){
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.qq.com", "hixxb@qq.com", "123456");
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "<html><head></head><style>body{color: red;}</style><body>测试邮件内容<body></html>");
		EmailSender.sendHtmlMail(mailServiceBean, mailBean);
	}
```
	
Send Html Mail 3.
```
	@Test
	public void sendHtmlMail3(){
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.qq.com", "25", "hixxb@qq.com", "123456");
		MailBean mailBean = new MailBean("xianbinxie@163.com", "测试邮件主题", "<html><head></head><style>body{color: red;}</style><body>测试邮件内容<body></html>");
		EmailSender.sendHtmlMail(mailServiceBean, mailBean);
	}
```
	
Send Html Mail With Attach File 4.
```
	@Test
	public void sendHtmlMail4(){
		List<AttachFileBean> fileBeans = new ArrayList<AttachFileBean>();
		fileBeans.add(new AttachFileBean("真实性核验单.png", "H:\\真实性核验单.png"));
		fileBeans.add(new AttachFileBean("email-0.0.1-SNAPSHOT.jar", "H:\\email-0.0.1-SNAPSHOT.jar"));
		MailServiceBean mailServiceBean = new MailServiceBean("smtp.163.com", "25", "xianbinxie@163.com", "123456");
		MailBean mailBean = new MailBean("hixxb@qq.com", "测试邮件主题", "<html><head></head><style>body{color: red;}</style><body>测试邮件内容<body></html>", fileBeans);
		EmailSender.sendHtmlMail(mailServiceBean, mailBean);
	}
```
