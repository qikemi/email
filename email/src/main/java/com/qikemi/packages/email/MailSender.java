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
  
/**
 * Sender Mail
 * 
 * @description 鏈▼搴忕敤浜庢潵鑷阿鍏堟枌姣曚笟璁烘枃锛屽鏈変娇鐢ㄨ鑱旂郴浣� 鑰咃紝娉ㄦ槑鍑哄銆�
 * @URL 浠ｇ爜鍦板潃锛歨ttp://github.com/openRDF/rdf_fronts
 * @dateTime 2014-3-22 涓嬪崍7:43:59
 * @author XieXianbin
 * @email a.b@hotmail.com
 *
 */
public class MailSender  {
/**  
  * 浠ユ枃鏈牸寮忓彂閫侀偖鎴愬姛
  * @param senderMailBean 寰呭彂閫佺殑閭欢鐨勪俊锟�? 
  */   
    public boolean sendTextMail(MailSenderBean senderMailBean) {
      // 鍒ゆ柇鏄惁锟�?锟斤拷韬唤璁よ瘉   
      MyAuthenticator authenticator = null;   
      Properties pro = senderMailBean.getProperties();  
      if (senderMailBean.isValidate()) {
    	  // 濡傛灉锟�?锟斤拷韬唤璁よ瘉锛屽垯鍒涘缓锟�?锟斤拷瀵嗙爜楠岃瘉锟�?  
    	  authenticator = new MyAuthenticator(senderMailBean.getUserName(), senderMailBean.getPassword());   
      }  
      // 鏍规嵁閭欢浼氳瘽灞烇拷?鍜屽瘑鐮侀獙璇佸櫒鏋勶拷?锟�?锟斤拷鍙戯拷?閭欢鐨剆ession   
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);   
      try {
	      // 鏍规嵁session鍒涘缓锟�?锟斤拷閭欢娑堟伅   
	      Message mailMessage = new MimeMessage(sendMailSession);   
	      // 鍒涘缓閭欢鍙戯拷?鑰呭湴锟�?  
	      Address from = new InternetAddress(senderMailBean.getFromAddress());   
	      // 璁剧疆閭欢娑堟伅鐨勫彂閫侊拷?   
	      mailMessage.setFrom(from);   
	      // 鍒涘缓閭欢鐨勬帴鏀讹拷?鍦板潃锛屽苟璁剧疆鍒伴偖浠舵秷鎭腑   
	      Address to = new InternetAddress(senderMailBean.getToAddress());   
	      mailMessage.setRecipient(Message.RecipientType.TO,to);   
	      // 璁剧疆閭欢娑堟伅鐨勪富锟�?  
	      mailMessage.setSubject(senderMailBean.getSubject());   
	      // 璁剧疆閭欢娑堟伅鍙戯拷?鐨勬椂锟�?  
	      mailMessage.setSentDate(new Date());   
	      // 璁剧疆閭欢娑堟伅鐨勪富瑕佸唴锟�?  
	      String mailContent = senderMailBean.getContent();   
	      mailMessage.setText(mailContent);   
	      // 鍙戯拷?閭欢   
	      Transport.send(mailMessage);  
	      return true;
      } catch (MessagingException ex) {
          ex.printStackTrace();  
      }
      return false;   
    }
      
    /**  
      * 浠TML鏍煎紡鍙戯拷?閭欢  
      * @param senderMailBean 寰呭彂閫佺殑閭欢淇℃伅  
      */   
    public boolean sendHtmlMail(MailSenderBean senderMailBean){
      // 鍒ゆ柇鏄惁锟�?锟斤拷韬唤璁よ瘉   
      MyAuthenticator authenticator = null;  
      Properties pro = senderMailBean.getProperties();  
      //濡傛灉锟�?锟斤拷韬唤璁よ瘉锛屽垯鍒涘缓锟�?锟斤拷瀵嗙爜楠岃瘉锟�?   
      if (senderMailBean.isValidate()) {
    	  authenticator = new MyAuthenticator(senderMailBean.getUserName(), senderMailBean.getPassword());  
      }
      // 鏍规嵁閭欢浼氳瘽灞烇拷?鍜屽瘑鐮侀獙璇佸櫒鏋勶拷?锟�?锟斤拷鍙戯拷?閭欢鐨剆ession   
      Session sendMailSession = Session.getDefaultInstance(pro,authenticator);   
      try {
	      // 鏍规嵁session鍒涘缓锟�?锟斤拷閭欢娑堟伅   
	      Message mailMessage = new MimeMessage(sendMailSession);   
	      // 鍒涘缓閭欢鍙戯拷?鑰呭湴锟�?  
	      Address from = new InternetAddress(senderMailBean.getFromAddress());   
	      // 璁剧疆閭欢娑堟伅鐨勫彂閫侊拷?   
	      mailMessage.setFrom(from);   
	      // 鍒涘缓閭欢鐨勬帴鏀讹拷?鍦板潃锛屽苟璁剧疆鍒伴偖浠舵秷鎭腑   
	      Address to = new InternetAddress(senderMailBean.getToAddress());   
	      // Message.RecipientType.TO灞烇拷?琛ㄧず鎺ユ敹鑰呯殑绫诲瀷涓篢O   
	      mailMessage.setRecipient(Message.RecipientType.TO,to);   
	      // 璁剧疆閭欢娑堟伅鐨勪富锟�?  
	      mailMessage.setSubject(senderMailBean.getSubject());   
	      // 璁剧疆閭欢娑堟伅鍙戯拷?鐨勬椂锟�?  
	      mailMessage.setSentDate(new Date());   
	      // MiniMultipart绫绘槸锟�?锟斤拷瀹瑰櫒绫伙紝鍖呭惈MimeBodyPart绫诲瀷鐨勫锟�?  
	      Multipart mainPart = new MimeMultipart();   
	      // 鍒涘缓锟�?锟斤拷鍖呭惈HTML鍐呭鐨凪imeBodyPart   
	      BodyPart html = new MimeBodyPart();   
	      // 璁剧疆HTML鍐呭
	      html.setContent(senderMailBean.getContent(), "text/html; charset=utf-8");   
	      mainPart.addBodyPart(html);   
	      // 灏哅iniMultipart瀵硅薄璁剧疆涓洪偖浠跺唴锟�?  
	      mailMessage.setContent(mainPart);   
	      // 鍙戯拷?閭欢   
	      Transport.send(mailMessage);   
	      return true;   
      } catch (MessagingException ex) {
          ex.printStackTrace();   
      }
      return false;   
    }
}