import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jms.JMSException;

import org.apache.log4j.Logger;

import com.nsn.activemq.client.JMSContext;
import com.nsn.activemq.client.NSNConsumer;
import com.nsn.activemq.client.NSNProducer;
import com.nsn.activemq.testcase.MainControl;



public class test {
	         //static String str="{\"callInterfaceName\":\"\",\"content\":{\"cmd\":\"delNet\",\"ct\":1,\"rt\":1},\"destQ\":\"Poseidon_Queue_dev\",\"exculde\":0,\"flag\":\"\",\"msg\":\"\",\"ne\":\"PPPPPPPP\",\"priority\":9,\"pwd\":\"\",\"session\":\"acebba60-a31e-4fe6-ba14-1fd020fb10af\",\"src\":\"\",\"srcQ\":\"Q_LIBRA_01\",\"timeout\":50,\"user\":\"\"}";
	 private static NSNProducer nsnProducer;
	 private static String [] str={"ifconfig","free -g","df -h","ls -a","netstat -anp","cd /;ls"};
	 
	 
	 private static String strs ="{\"srcQ\":\"DHLR1\",\"destQ\":\"Poseidon_Queue_dev\",\"callInterfaceNamdde\":\"\",\"session\":\"9584fe2cfb8c9c8d79718b6057443a2e1\",\"content\":{\"cmd\":\"addNet\",\"ct\":1,\"rt\":1},\"exclude\":0,\"flag\":\"\",\"msg\":\"\",\"ne\":\"PPPPPPPP\",\"pwd\":\"\",\"src\":\"\",\"timeout\":15,\"user\":\"\"}";
	 private static String strs1="{\"content\":{\"cmd\":\"df -h\",\"ct\":1,\"rt\":1},\"destQ\":\"destQ\",\"device\":{\"command\":\"\",\"connIdleTimeout\":10,\"connType\":\"\",\"connectScriptFile\":\"\",\"id\":\"\",\"initConnNum\":3,\"ip\":\"10.221.17.84\",\"jumpCount\":0,\"jumpList\":[{\"jumpIp\":\"192.168.211.8\",\"jumpPassword\":\"2222222\",\"jumpPort\":22,\"jumpUsername\":\"test\"}],\"linkName\":\"\",\"location\":\"\",\"maxConnLongNum\":0,\"maxConnNum\":10,\"name\":\"device1\",\"needJump\":0,\"password\":\"Pasword1\",\"port\":22,\"retryInterval\":5,\"retryTimes\":3,\"taskQueueMaxSize\":50,\"taskTimeout\":5,\"type\":\"Ne40e\",\"username\":\"shhlr50\",\"vendor\":\"\",\"version\":\"\"},\"exclude\":0,\"flag\":\"0\",\"jumpIp\":\"\",\"jumpPassword\":\"\",\"jumpPort\":\"\",\"jumpUsername\":\"\",\"msg\":\"msg ok\",\"msgCode\":\"1\",\"priority\":\"9\",\"procotol\":\"\",\"src\":\"/report/ne40e/database\",\"srcQ\":\"srcQ\",\"cacheTime\":\"5\",\"timeout\":5}";

	 
	
	 static String [] str1={"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:ls /\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:ls /\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:df -h\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:free -g\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:free -m\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:ifconfig","rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:ls /home\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:ls /etc\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:ls /opt\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:ls /var\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:df -h;free -g\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|root,111111:ls /\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /usr\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /tmp\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /home\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /opt\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:free -g\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ifconfig\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /etc\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:df -h\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
	 ,"{\"srcQ\":\"Q_LIBRA_01\",\"destQ\":\"Poseidon_Queue_dev\",\"session\":\"d3a2f19f5e984fd19ba801438153f351\",\"ne\":\"master\",\"content\":{\"cmd\":\"DHLR_COMMAND|t,111111:ls /home\",\"rt\":\"1\",\"ct\":\"2\"},\"timeout\":5,\"exclude\":0}"
		};
	private static Logger logger = Logger.getLogger(MainControl.class);
	static String strrr ="{\"jumpCount\":0,\"port\":0,\"callInterfaceName\":\"\",\"type\":\"\",\"maxConnNum\":3,\"neConnType\":\"DHSS_SSH\",\"password\":\"\",\"toDbEntity\":{\"DBPassword\":\"mysql\",\"DBPort\":\"3306\",\"DBUrl\":\"jdbc:mysql://10.221.30.103:3306/epc-ices?useUnicode=true&characterEncoding=utf-8\",\"DBType\":\"mysql\",\"DBName\":\"epc-ices\",\"DBUser\":\"root\"},\"taskNum\":\"80001\",\"destQ\":\"POSEIDON_MAC\",\"srcQ\":\"Q_Poseidon_KPI\",\"username\":\"\",\"priority\":5,\"msgCode\":\"71000\",\"src\":\"\",\"retryTimes\":0,\"app\":\"EPC\",\"unitType\":\"\",\"vendor\":\"NOKIA\",\"fromDbEntity\":{\"DBPassword\":\"rdr\",\"DBPort\":\"1521\",\"DBUrl\":\"jdbc:oracle:thin:@10.221.255.4:1521:oss\",\"DBType\":\"oracle\",\"DBName\":\"oss\",\"DBUser\":\"rdr\"},\"hostname\":\"\",\"cacheTime\":0,\"exculde\":0,\"sessionid\":\"5a1a177584f842fb970e2888e5dd477c\",\"msg\":\"\",\"ip\":\"10.221.255.4:1521\",\"content\":{\"cmd\":\"EPC_GZDW_LOAD_DATA|epc-ices@oss@2017-04-20 19:45:00@2017-04-20 19:30:00@2017-04-19 20:00:00@2017-04-18 20:00:00@2017-04-20 20:00:00\",\"rt\":1,\"ct\":2},\"needJump\":0,\"netFlag\":\"\",\"flag\":\"\",\"ne\":\"epc-ices-oss\",\"procotol\":\"SSH\",\"retryInterval\":0}";

	public static void main(String[] args) throws UnknownHostException {
		testAMQ();
//		 InetAddress addr = InetAddress.getLocalHost();  
//		  System.out.println(addr.getHostAddress());
	}
	static{
		nsnProducer = new NSNProducer();
	}

	public static void testAMQ() {
		//String s="{"id":-2146583846,"ne":"FZSGSN15BNK","content":{"ct":1,"cmd":"ZDOI:MCHU,:","rt":1},"flag":"0","msg":"ok;cost 1007 ms.","src":"/adapter_6801/FZSGSN15BNK/2013/10/15/18/cmd20131015185008465578.src","timeout":15,"exclude":0,"pid":0}"
		
		JMSContext jmsContext =JMSContext.getInstance(
				"admin",
				"admin",
				"failover:(tcp://127.0.0.1:61616)"); //�����IP��������AMQ Broker��IP���˿ڲ���Ĭ��ֵ

		NSNConsumer nsnConsumer= new NSNConsumer();
		nsnProducer.setJmsContext(jmsContext);
		nsnConsumer.setJmsContext(jmsContext);
		
		//���ô�Queue_2������Ϣ
		nsnConsumer.setMonitorQueueName("POSEIDON_DEV1");
		
		//���ô�����Ϣ��Handler
		nsnConsumer.initialize(new TaskHandler());
	
			try {
							
//							for(int i=0;i<1000;i++){
//								int n = (int)(Math.random()*10);
//							 nsnProducer.sendMsg("Q_POSEIDON", 20003,strs[i],"text2",n);
//							}
//							for(int i=0;i<100;i++){
//								int n = (int)(Math.random()*10);
				          
			               //System.out.println(str1);
//				         while(true){
//				        	 try {
//								Thread.currentThread().sleep(1000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//			               for(String sr:str){
//			            	   System.out.println(str1);
			            	   
			            	  // String nset=strs.replace("addNet", sr);
			            	   //System.out.println(nset);
			            	   //nsnProducer.sendMsg("Poseidon_Queue_dev", 20003,str,"text2",2);
							nsnProducer.sendMsg("POSEIDON_DEV", 20003,strrr,"text2",2);
//									  
//			               }
//				         }
						   
							
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
		}
	
}