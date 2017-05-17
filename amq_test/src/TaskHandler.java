
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TaskHandler implements MessageListener {
	private final Logger logger = LoggerFactory
			.getLogger(TaskHandler.class);
	
	private static int id = 2142483647;
	
	
	private Map<Integer,String> sessionMap ;
	
	private Map<String,String> infoMap;
	
	
	public TaskHandler()
	{
		
	}
	
	@Override
	public void onMessage(Message message) {
		if (null != message){
			
			try {
				//取消息代码
				int msgcode = message.getIntProperty("msgCode");
				//System.out.println(msgcode+"-----------");
				
				//取消息附加信息
				TextMessage txtMsg = (TextMessage) message;
				
				
				//取消息体
				String msgBody = message.getStringProperty("msgBody");
				System.out.println(msgBody+"---------------------------------***************");
				//取得消息的优先级
				int priority = message.getJMSPriority();
				//System.out.println(priority+"--------------------");
				//判断是不是JWE发来的解析结果消息
			
				
				
				
				
			} catch(JMSException e){
				e.printStackTrace();
			}
			
		}
	}
	
	

	 public static void main(String args[]){
		 
		
	 }
	 
}

