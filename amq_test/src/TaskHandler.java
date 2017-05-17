
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
				//ȡ��Ϣ����
				int msgcode = message.getIntProperty("msgCode");
				//System.out.println(msgcode+"-----------");
				
				//ȡ��Ϣ������Ϣ
				TextMessage txtMsg = (TextMessage) message;
				
				
				//ȡ��Ϣ��
				String msgBody = message.getStringProperty("msgBody");
				System.out.println(msgBody+"---------------------------------***************");
				//ȡ����Ϣ�����ȼ�
				int priority = message.getJMSPriority();
				//System.out.println(priority+"--------------------");
				//�ж��ǲ���JWE�����Ľ��������Ϣ
			
				
				
				
				
			} catch(JMSException e){
				e.printStackTrace();
			}
			
		}
	}
	
	

	 public static void main(String args[]){
		 
		
	 }
	 
}

