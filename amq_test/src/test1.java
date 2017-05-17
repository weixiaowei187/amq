
import net.sf.json.JSONObject;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import com.nsn.activemq.client.JMSContext;
import com.nsn.activemq.client.NSNConsumer;
import com.nsn.activemq.client.NSNProducer;
import com.nsn.activemq.testcase.MainControl;




public class test1 {
	         //static String str="{\"callInterfaceName\":\"\",\"content\":{\"cmd\":\"delNet\",\"ct\":1,\"rt\":1},\"destQ\":\"Poseidon_Queue_dev\",\"exculde\":0,\"flag\":\"\",\"msg\":\"\",\"ne\":\"PPPPPPPP\",\"priority\":9,\"pwd\":\"\",\"session\":\"acebba60-a31e-4fe6-ba14-1fd020fb10af\",\"src\":\"\",\"srcQ\":\"Q_LIBRA_01\",\"timeout\":50,\"user\":\"\"}";
	 
	 private static NSNProducer nsnProducer;
	 private static String [] str={"ifconfig","free -g","df -h","ls -a","netstat -anp","cd /;ls"};
	 
	 
	 private static String strs ="{\"srcQ\":\"DHLR1\",\"destQ\":\"Poseidon_Queue_dev\",\"callInterfaceNamdde\":\"\",\"session\":\"9584fe2cfb8c9c8d79718b6057443a2e1\",\"content\":{\"cmd\":\"DHLR_COMMAND|ifconfig@free -g@df -h\",\"ct\":2,\"rt\":1},\"exclude\":0,\"flag\":\"\",\"msg\":\"\",\"ne\":\"PPPPPPPP\",\"pwd\":\"\",\"src\":\"\",\"timeout\":15,\"user\":\"\"}";
	 private static String amq_telnet="{\"app\":\"epc\",\"cacheTime\":5,\"callInterfaceName\":\"\",\"content\":{\"cmd\":\"ifconfig\",\"ct\":1,\"rt\":1},\"destQ\":\"Poseidon_Queue_dev\",\"exculde\":1,\"flag\":\"0\",\"ip\":\"yt_xk39b\",\"jumpCount\":0,\"maxConnNum\":10,\"msg\":\"\",\"msgCode\":\"300\",\"ne\":\"master\",\"neConnType\":\"linux\",\"needJump\":0,\"password\":\"yt_xk39b\",\"port\":23,\"priority\":1,\"procotol\":\"telnet\",\"retryInterval\":3,\"retryTimes\":3,\"sessionid\":\"1111111111111111111\",\"src\":\"\",\"srcQ\":\"Poseidon_Queue_dev1\",\"taskTimeout\":50,\"username\":\"root\",\"vendor\":\"NOKIA\",\"type\":\"sgw\"}";

	 private static String amq_ssh="{\"app\":\"epc\",\"cacheTime\":5,\"callInterfaceName\":\"\",\"content\":{\"cmd\":\"ifconfig\",\"ct\":1,\"rt\":1},\"destQ\":\"Poseidon_Queue_dev\",\"exculde\":1,\"flag\":\"0\",\"ip\":\"192.168.133.138\",\"jumpCount\":0,\"maxConnNum\":10,\"msg\":\"\",\"msgCode\":\"300\",\"ne\":\"master\",\"neConnType\":\"TEST\",\"needJump\":0,\"password\":\"111111\",\"port\":22,\"priority\":1,\"procotol\":\"ssh\",\"retryInterval\":3,\"retryTimes\":3,\"sessionid\":\"1111111111111111111\",\"src\":\"\",\"srcQ\":\"Poseidon_Queue_dev1\",\"taskTimeout\":50,\"username\":\"root\",\"vendor\":\"NOKIA\",\"type\":\"sgw\"}";
     
	 private static String cmd ="{\"msg\":\"\",\"flag\":\"\",\"jumpCount\":0,\"sessionid\":\"8a6e65f936734c32906d039601b50f64\",\"type\":\"HSSFE\",\"content\":{\"cmd\":\"date\",\"ct\":1,\"rt\":1},\"callInterfaceName\":\"\",\"unitType\":\"HSSFE\",\"password\":\"79745f786b333962\",\"procotol\":\"SSH\",\"hostname\":\"h02f01fe1\",\"vendor\":\"nokia\",\"srcQ\":\"DHLR-TASK-SMART\",\"maxConnNum\":5,\"msgCode\":71000,\"destQ\":\"POSEIDON_DEV\",\"app\":\"dhss\",\"neConnType\":\"DHSS_SSH\",\"netFlag\":\"root@h02f01fe1>\",\"src\":\"\",\"ip\":\"111.222.206.73\",\"priority\":5,\"exculde\":0,\"cacheTime\":5,\"retryTimes\":2,\"needJump\":0,\"port\":\"22\",\"ne\":\"h02f01fe1\",\"retryInterval\":3,\"username\":\"root\"}";

	 private static String  cmd1 ="{\"app\":\"dhss\",\"beginDate\":\"\",\"cacheTime\":5,\"callInterfaceName\":\"\",\"content\":{\"cmd\":\"SSH_DHLR_COMMAND|test,74657374:ifconfig\",\"ct\":2,\"rt\":1},\"destQ\":\"POSEIDON_DEV\",\"endDate\":\"2016-05-12 14:12:40\",\"exculde\":0,\"flag\":\"66051\",\"hostname\":\"\",\"ip\":\"192.168.133.146\",\"jumpCount\":0,\"maxConnNum\":5,\"msg\":\"NE login timeout.\",\"msgCode\":\"71000\",\"ne\":\"h02nt01ahub102\",\"neConnType\":\"DHSS_SSH\",\"needJump\":0,\"netFlag\":\"\",\"password\":\"79745f786b333962\",\"port\":22,\"priority\":9,\"procotol\":\"ssh\",\"retryInterval\":3,\"retryTimes\":2,\"sessionid\":\"d78e31c3d1ef41bb938a2bd18458a3fc\",\"src\":\"\",\"srcQ\":\"DHLR-TASK-SMART\",\"type\":\"NTHLRFE\",\"unitType\":\"\",\"username\":\"root\",\"vendor\":\"nokia\"}";
	 private static Logger logger = Logger.getLogger(MainControl.class);
	 
	 private static String cmds="{\"app\":\"dhss\",\"content\":{\"cmd\":\"SSH_DHLR_COMMAND|jrdas_4,6e736e2e6a72646173:netstat\",\"ct\":2,\"rt\":1},\"destQ\":\"POSEIDON_DEV\",\"device\":{\"command\":\"\",\"connIdleTimeout\":5,\"connType\":\"DHSS_SSH\",\"connectScriptFile\":\"DHLR_SSH_LOGIN_SCRIPT\",\"hostname\":\"\",\"id\":\"5\",\"initConnNum\":1,\"ip\":\"10.221.30.104\",\"jumpCount\":0,\"linkName\":\"\",\"location\":\"\",\"loginTimeout\":10,\"maxConnLongNum\":0,\"maxConnNum\":5,\"maxConnTerminalNum\":0,\"name\":\"238\",\"neDefaultTimeout\":0,\"needJump\":0,\"netFlag\":\"\",\"passwd\":\"6e736e636f\",\"port\":22,\"protocol\":\"SSH\",\"retryInterval\":3,\"retryTimes\":2,\"status\":\"\",\"taskQueueMaxSize\":10,\"taskTimeout\":10,\"type\":\"NTHLRFE\",\"unitType\":\"NTHLRFE\",\"username\":\"nsnco\",\"vendor\":\"nokia\",\"version\":\"\"},\"exclude\":0,\"flag\":\"\",\"hostname\":\"\",\"msg\":\"\",\"msgCode\":\"71000\",\"netFlag\":\"\",\"priority\":9,\"protocol\":\"SSH\",\"sessionId\":\"f92a8d415137453baff569b3fccd6bdd\",\"src\":\"\",\"srcQ\":\"DHSS_DAILY_MAINTAIN\",\"taskNum\":\"71002\",\"timeout\":3}";
	 private static String cmds2="{\"app\":\"dhss\",\"content\":{\"cmd\":\"SSH_DHLR_COMMAND|test,74657374:ifconfig\",\"ct\":2,\"rt\":1},\"destQ\":\"POSEIDON_DEV\",\"device\":{\"command\":\"\",\"connIdleTimeout\":5,\"connType\":\"DHSS_SSH\",\"connectScriptFile\":\"DHLR_SSH_LOGIN_SCRIPT\",\"hostname\":\"\",\"id\":\"1\",\"initConnNum\":1,\"ip\":\"192.168.133.146\",\"jumpCount\":0,\"linkName\":\"\",\"location\":\"\",\"loginTimeout\":10,\"maxConnLongNum\":0,\"maxConnNum\":5,\"maxConnTerminalNum\":0,\"name\":\"h02soapgw01n4-test\",\"neDefaultTimeout\":0,\"needJump\":0,\"netFlag\":\"_>\",\"passwd\":\"111111\",\"port\":22,\"retryInterval\":3,\"retryTimes\":2,\"status\":\"\",\"taskQueueMaxSize\":1000,\"taskTimeout\":10,\"type\":\"ONE_NDS\",\"unitType\":\"SOAP_GW\",\"username\":\"root\",\"vendor\":\"nokia\",\"version\":\"\"},\"exclude\":0,\"flag\":\"\",\"hostname\":\"\",\"msg\":\"\",\"msgCode\":\"71000\",\"netFlag\":\"\",\"priority\":9,\"protocol\":\"ssh\",\"sessionId\":\"de5c979ff25d4cd490bb00edfdd7c16a\",\"src\":\"\",\"srcQ\":\"DHSS_DAILY_MAINTAIN\",\"taskNum\":\"71002\",\"timeout\":10}";
	 
	 private static String cmds3="{\"app\":\"dhss\",\"cacheTime\":5,\"callInterfaceName\":\"\",\"content\":{\"cmd\":\"SSH_DHLR_COMMAND|SYSTEM,53595354454d:ZNBI;\",\"ct\":2,\"rt\":1},\"destQ\":\"POSEIDON_DEV\",\"exculde\":0,\"flag\":\"66010\",\"hostname\":\"\",\"ip\":\"10.221.252.108\",\"jumpCount\":0,\"maxConnNum\":5,\"msg\":\"Combination of command failed to execute:3305,current net ssh connection num exceed Max num;cost 19472 ms.\",\"msgCode\":\"71000\",\"ne\":\"SHHSS50SG02SGW\",\"neConnType\":\"DHSS_SSH\",\"needJump\":0,\"netFlag\":\"\",\"password\":\"53595354454d\",\"port\":22,\"priority\":9,\"procotol\":\"\",\"retryInterval\":3,\"retryTimes\":2,\"sessionid\":\"42f441a3d8e84793abbe8c82e59d0889\",\"src\":\"/adapter_6809/SHHSS50SG02SGW/2016/9/1/11/SSH_DHLR_COMMAND_20160901111039651632.tmp\",\"srcQ\":\"DHLR-TASK-SMART\",\"taskNum\":\"71001\",\"type\":\"SGW\",\"unitType\":\"\",\"username\":\"SYSTEM\",\"vendor\":\"nokia\"}";
	 
	 private static String test ="{\"msg\":\"\",\"flag\":\"\",\"jumpCount\":0,\"sessionid\":\"01294583-f404-458a-b4b2-aad2c499ec4d\",\"type\":\"ONE_NDS\",\"content\":{\"ct\":2,\"rt\":1,\"cmd\":\"DHLR_USERMANAGER_COMMAND|ZMSO:MSISDN=8618701784830;\"},\"callInterfaceName\":\"\",\"unitType\":\"ONE_NDS\",\"procotol\":\"TELNET\",\"password\":\"626f737340313233\",\"hostname\":null,\"vendor\":\"nokia\",\"srcQ\":\"DHLR-MML\",\"maxConnNum\":8,\"msgCode\":71000,\"taskNum\":71000,\"destQ\":\"POSEIDON_DEV\",\"app\":\"dhss\",\"neConnType\":\"DHSS_TELNET\",\"netFlag\":null,\"src\":\"\",\"ip\":\"10.224.43.183\",\"priority\":8,\"exculde\":0,\"cacheTime\":5,\"retryTimes\":2,\"needJump\":0,\"port\":\"23\",\"ne\":\"hncssoapgw01n3\",\"retryInterval\":3,\"username\":\"boss\"}";
	 
	 private static String com ="{\"app\":\"mac_epc\",\"cacheTime\":0,\"callInterfaceName\":\"\",\"content\":{\"cmd\":\"EPC_SGW_BACKUP|fsclish@start backup full@commit backup\",\"rt\":1,\"ct\":2},\"destQ\":\"POSEIDON_DEV\",\"exculde\":0,\"flag\":\"\",\"hostname\":\"\",\"ip\":\"10.199.217.104\",\"jumpCount\":0,\"maxConnNum\":5,\"msg\":\"\",\"msgCode\":71000,\"ne\":\"HKSAEGW06BNK\",\"neConnType\":\"DHSS_SSH\",\"needJump\":0,\"netFlag\":\"\",\"password\":\"4e6967656767736e37383921\",\"port\":22,\"priority\":5,\"procotol\":\"ssh\",\"retryInterval\":3,\"retryTimes\":3,\"sessionid\":\"1482110514997\",\"src\":\"\",\"srcQ\":\"Poseidon_Queue_Cmdjs\",\"taskNum\":0,\"taskTimeout\":20,\"timeout\":20,\"type\":\"\",\"unitType\":\"\",\"username\":\"NKICES\",\"vendor\":\"nokia\"}";
	 
	 private static String test2="{\"app\":\"dhss\",\"beginDate\":\"2017-01-17 16:37:00\",\"cacheTime\":5,\"callInterfaceName\":\"\",\"content\":{\"cmd\":\"EPC_COMMON_MME|ZKAI\",\"ct\":2,\"rt\":1},\"destQ\":\"POSEIDON_DEV\",\"endDate\":\"\",\"exculde\":0,\"flag\":\"\",\"hostname\":\"\",\"ip\":\"10.203.39.4\",\"jumpCount\":0,\"maxConnNum\":5,\"msg\":\"\",\"msgCode\":\"\",\"ne\":\"HKMME02BNK\",\"neConnType\":\"DHSS_TELNET\",\"needJump\":1,\"netFlag\":\"\",\"password\":\"4e6967657367736e31323321\",\"port\":23,\"priority\":8,\"procotol\":\"telnet\",\"retryInterval\":3,\"retryTimes\":3,\"sessionid\":\"a0f1a660d889443da179f51560b40656\",\"src\":\"\",\"srcQ\":\"Q_NETASK_test_01\",\"taskNum\":\"75001\",\"type\":\"MME\",\"unitType\":\"MME\",\"username\":\"NKICES\",\"vendor\":\"nokia\"}";
	 
	 
	static String cmdTask="{\"sessionId\":\"VAC_BILL76\",\"taskNum\":\"0\",\"app\":\"VAC\",\"protocol\":\"SSH\",\"content\":{\"ct\":2,\"cmd\":\"VAC_COMMON_QUERY_IM|start@java -jar /cdr/work/proc_raw/jar/asn1find.jar -c 1740760191 20170509000000 20170509010000 /cdr/work/proc_raw/proc/archive/ CMD_55_56_p_ *.dat@/cdr/work/proc_raw/proc/archive/@/cdr/work/proc_raw/bill_result/@/home/vac/billDownload/@10.14.63.102@cmd@3352786279777321\",\"rt\":1},\"device\":{\"id\":\"5\",\"name\":\"JNCG55BNK\",\"location\":\"\",\"ip\":\"10.14.63.102\",\"port\":22,\"username\":\"cmd\",\"passwd\":\"3352786279777321\",\"version\":\"\",\"command\":\"\",\"type\":\"\",\"vendor\":\"nokia\",\"connectScriptFile\":\"COMMON_SSH_LOGIN_SCRIPT\",\"connType\":\"DHSS_SSH\",\"linkName\":\"\",\"initConnNum\":1,\"maxConnNum\":5,\"connIdleTimeout\":5,\"taskQueueMaxSize\":10,\"taskTimeout\":10,\"neDefaultTimeout\":0,\"retryTimes\":3,\"retryInterval\":3,\"maxConnLongNum\":0,\"maxConnTerminalNum\":0,\"needJump\":0,\"jumpCount\":0,\"loginTimeout\":10,\"hostname\":\"\",\"netFlag\":\"\",\"protocol\":\"SSH\",\"unitType\":\"\"},\"timeout\":10,\"src\":\"\",\"msgCode\":\"71000\",\"srcQ\":\"Poseidon_Queue_Cmdjs\",\"destQ\":\"POSEIDON_DEV\",\"priority\":9,\"msg\":\"\",\"flag\":\"0\",\"exclude\":0}";
	 /**
	  *  必填项：
	  *     procotol 协议类型：ssh/telnet
	  *     sessionid: 系统生成
	  *     password： 网元登录密码 加密
	  *     msgCode：71000 
	  *     ip：登录ip地址
	  *     port： 端口号（telnet:23  ssh 22---也可以自定义）
	  *     username： 网元登录用户名；
	  *     ne：网元名称
	  *     neConnType：ssh连接：DHSS_SSH   telnet连接：DHSS_TELNET
	  *     "content":{"cmd":"DHLR_COMMAND|jcomp:7a7863764031323334:313539333537@test1","ct":2,"rt":1},//这个可以问杜云昌
	  *             "cmd":"DHLR_COMMAND|jcomp:7a7863764031323334:313539333537@test1" 	  *             jcomp:7a7863764031323334:313539333537@test1   

	  *     type：网元类型   
	  *     unitType：单元类型
	  */
	 private static String cmd2="{\"msg\":\"\",\"procotol\":\"SSH\",\"flag\":\"\",\"jumpCount\":0,\"sessionid\":\"604c2d930215482ea25e14c462e60658\",\"type\":\"HSSFE\",\"content\":{\"cmd\":\"Task|test,74657374:ps -ef\",\"ct\":2,\"rt\":1},\"callInterfaceName\":\"\",\"unitType\":\"HSSFE\",\"password\":\"111111\",\"hostname\":null,\"vendor\":\"nokia\",\"srcQ\":\"DHSS_SECURITY\",\"maxConnNum\":5,\"msgCode\":71000,\"taskNum\":71003,\"destQ\":\"POSEIDON_DEV\",\"app\":\"dhss\",\"neConnType\":\"DHSS_SSH\",\"netFlag\":null,\"src\":\"\",\"ip\":\"192.168.133.148\",\"priority\":5,\"exculde\":0,\"cacheTime\":5,\"retryTimes\":2,\"needJump\":0,\"port\":22,\"ne\":\"test1\",\"retryInterval\":3,\"username\":\"root\",timeout:\"5\"}";
	 
	 public static String cmds22="{\"msg\":\"\",\"procotol\":\"TELNET\",\"flag\":\"\",\"jumpCount\":0,\"sessionid\":\"6fbbf890-79a5-4d9b-a7ba-d31b97cc682b@--ZMSO\",\"type\":\"SOAP_GW\",\"callInterfaceName\":\"\",\"unitType\":\"SOAP_GW\",\"password\":\"50494e475441492331\",\"hostname\":\"h02soapgw01n4\",\"vendor\":\"nokia\",\"srcQ\":\"DHLR-MML\",\"maxConnNum\":8,\"taskNum\":71000,\"msgCode\":71000,\"destQ\":\"POSEIDON_DEV\",\"app\":\"dhss\",\"neConnType\":\"DHSS_TELNET\",\"netFlag\":\"[root@h02soapgw01n4 ~]#\",\"src\":\"\",\"ip\":\"111.222.206.216\",\"content\":{\"ct\":2,\"rt\":1,\"cmd\":\"DHLR_USERMANAGER_COMMAND|ZMSO:msisdn=861306184015\"},\"priority\":5,\"exculde\":0,\"cacheTime\":5,\"retryTimes\":2,\"needJump\":0,\"port\":9091,\"ne\":\"h02soapgw01n4\",\"retryInterval\":3,\"username\":\"PINGTAI\"}";
	 
	 static String rrrr="{\"app\":\"VAC\",\"cacheTime\":0,\"callInterfaceName\":\"\",\"content\":{\"ct\":2,\"rt\":1,\"cmd\":\"VAC_COMMON_QUERY_IM|start@java -jar /cdr/work/proc_raw/jar/asn1find.jar -c 1740760191 20170509000000 20170509010000 /cdr/work/proc_raw/proc/archive/ CMD_55_56_p_ *.dat@/cdr/work/proc_raw/proc/archive/@/cdr/work/proc_raw/bill_result/@/home/vac/billDownload/@10.14.63.102@cmd@3352786279777321\"},\"destQ\":\"POSEIDON_DEV\",\"exculde\":0,\"flag\":\"\",\"hostname\":\"\",\"ip\":\"10.14.63.102\",\"jumpCount\":0,\"maxConnNum\":5,\"msg\":\"\",\"msgCode\":71000,\"ne\":\"JNCG55BNK\",\"neConnType\":\"DHSS_SSH\",\"needJump\":0,\"netFlag\":\"\",\"password\":\"3352786279777321\",\"port\":22,\"priority\":5,\"procotol\":\"SSH\",\"retryInterval\":3,\"retryTimes\":3,\"sessionid\":\"VAC_BILL76\",\"src\":\"\",\"srcQ\":\"Poseidon_Queue_Cmdjs\",\"taskNum\":0,\"taskTimeout\":10,\"timeout\":10,\"type\":\"\",\"unitType\":\"\",\"username\":\"cmd\",\"vendor\":\"nokia\"}{\"app\":\"VAC\",\"cacheTime\":0,\"callInterfaceName\":\"\",\"content\":{\"ct\":2,\"rt\":1,\"cmd\":\"VAC_COMMON_QUERY_IM|start@java -jar /cdr/work/proc_raw/jar/asn1find.jar -c 1740760191 20170509000000 20170509010000 /cdr/work/proc_raw/proc/archive/ CMD_55_56_p_ *.dat@/cdr/work/proc_raw/proc/archive/@/cdr/work/proc_raw/bill_result/@/home/vac/billDownload/@10.14.63.102@cmd@3352786279777321\"},\"destQ\":\"POSEIDON_DEV\",\"exculde\":0,\"flag\":\"\",\"hostname\":\"\",\"ip\":\"10.14.63.102\",\"jumpCount\":0,\"maxConnNum\":5,\"msg\":\"\",\"msgCode\":71000,\"ne\":\"JNCG55BNK\",\"neConnType\":\"DHSS_SSH\",\"needJump\":0,\"netFlag\":\"\",\"password\":\"3352786279777321\",\"port\":22,\"priority\":5,\"procotol\":\"SSH\",\"retryInterval\":3,\"retryTimes\":3,\"sessionid\":\"VAC_BILL76\",\"src\":\"\",\"srcQ\":\"Poseidon_Queue_Cmdjs\",\"taskNum\":0,\"taskTimeout\":10,\"timeout\":10,\"type\":\"\",\"unitType\":\"\",\"username\":\"cmd\",\"vendor\":\"nokia\"}";
     public static String test12="{\"jumpCount\":0,\"port\":0,\"callInterfaceName\":\"\",\"type\":\"\",\"maxConnNum\":0,\"neConnType\":\"DHSS_SSH\",\"password\":\"\",\"toDbEntity\":{\"DBPassword\":\"mysql\",\"DBPort\":\"3306\",\"DBUrl\":\"jdbc:mysql://10.221.30.103:3306/epc-ices?useUnicode=true&characterEncoding=utf-8\",\"DBType\":\"mysql\",\"DBName\":\"epc-ices\",\"DBUser\":\"root\"},\"taskNum\":\"80001\",\"destQ\":\"POSEIDON_DEV\",\"srcQ\":\"Q_Poseidon_KPI\",\"username\":\"\",\"priority\":5,\"msgCode\":\"71000\",\"src\":\"\",\"retryTimes\":0,\"app\":\"EPC\",\"unitType\":\"\",\"vendor\":\"NOKIA\",\"fromDbEntity\":{\"DBPassword\":\"rdr\",\"DBPort\":\"1521\",\"DBUrl\":\"jdbc:oracle:thin:@10.221.255.4:1521:oss\",\"DBType\":\"oracle\",\"DBName\":\"oss\",\"DBUser\":\"rdr\"},\"hostname\":\"\",\"cacheTime\":0,\"exculde\":0,\"sessionid\":\"921014c76b9c40c79a1fd08c3d86ccaa\",\"msg\":\"\",\"ip\":\"\",\"content\":{\"cmd\":\"EPC_GZDW_LOAD_DATE|epc-ices@oss@2016-11-03 14:00:00@2016-11-03 13:45:00@2016-11-02 14:15:00@2016-11-01 14:15:00@2016-11-03 14:15:00\",\"rt\":0,\"ct\":0},\"needJump\":0,\"netFlag\":\"\",\"flag\":\"\",\"ne\":\"epc-ices-oss\",\"procotol\":\"SSH\",\"retryInterval\":0}";
	 
	 public static String strsd="{\"sessionid\":\"a99640647f81461eb15eb8a6d2dcb8d4\",\"priority\":5,\"app\":\"vac\",\"taskNum\":71000,\"vendor\":\"nokia\",\"msgCode\":71000,\"cacheTime\":5,\"srcQ\":\"CDR_DOWNLOAD_QUEUE\",\"destQ\":\"POSEIDON_DEV\",\"content\":{\"cmd\":\"VAC_COMMON_SNYC_FILE|201702270744*@out@/home/cdrSource/cgs/cg01@/home/cdr_parse/cdr_files/raw/cg01@10.10.4.200@root@726f6f74726f6f74\",\"ct\":2,\"rt\":1},\"msg\":\"\",\"flag\":\"\",\"src\":\"\",\"jumpCount\":0,\"needJump\":0,\"ne\":\"cg01\",\"type\":\"\",\"unitType\":\"\",\"hostname\":\"\",\"ip\":\"10.10.4.200\",\"port\":22,\"username\":\"root\",\"password\":\"726f6f74726f6f74\",\"neConnType\":\"ssh\",\"maxConnNum\":8,\"netFlag\":\"\",\"procotol\":\"ssh\",\"retryInterval\":3,\"retryTimes\":2,\"exculde\":0,\"callInterfaceName\":\"\"}";
	 static String teststr="{\"app\":\"mac_epc\",\"cacheTime\":0,\"callInterfaceName\":\"\",\"content\":{\"ct\":2,\"rt\":1,\"cmd\":\"FTP_COMMON|sftp@10.199.217.64,22,root,Nigeggsn789!@/root/,/home/nsnco/report/,HKPGW01BNK_FB170314.tar\"},\"destQ\":\"POSEIDON_DEV\",\"exculde\":0,\"flag\":\"\",\"hostname\":\"\",\"ip\":\"127.0.0.1\",\"jumpCount\":0,\"maxConnNum\":50,\"msg\":\"\",\"msgCode\":71000,\"ne\":\"local\",\"neConnType\":\"DHSS_SSH\",\"needJump\":0,\"netFlag\":\"\",\"password\":\"6e736e636f\",\"port\":22,\"priority\":5,\"procotol\":\"ftp\",\"retryInterval\":3,\"retryTimes\":3,\"sessionid\":\"HKPGW01BNK1489487055067\",\"src\":\"\",\"srcQ\":\"Poseidon_Queue_Cmdjs\",\"taskNum\":80002,\"taskTimeout\":0,\"timeout\":30,\"type\":\"\",\"unitType\":\"\",\"username\":\"nsnco\",\"vendor\":\"nokia\"}";
	 
	 static String strrr ="{\"jumpCount\":0,\"port\":0,\"callInterfaceName\":\"\",\"type\":\"\",\"maxConnNum\":3,\"neConnType\":\"DHSS_SSH\",\"password\":\"\",\"toDbEntity\":{\"DBPassword\":\"mysql\",\"DBPort\":\"3306\",\"DBUrl\":\"jdbc:mysql://10.221.30.103:3306/epc-ices?useUnicode=true&characterEncoding=utf-8\",\"DBType\":\"mysql\",\"DBName\":\"epc-ices\",\"DBUser\":\"root\"},\"taskNum\":\"80001\",\"destQ\":\"POSEIDON_MAC\",\"srcQ\":\"Q_Poseidon_KPI\",\"username\":\"\",\"priority\":5,\"msgCode\":\"71000\",\"src\":\"\",\"retryTimes\":0,\"app\":\"EPC\",\"unitType\":\"\",\"vendor\":\"NOKIA\",\"fromDbEntity\":{\"DBPassword\":\"rdr\",\"DBPort\":\"1521\",\"DBUrl\":\"jdbc:oracle:thin:@10.221.255.4:1521:oss\",\"DBType\":\"oracle\",\"DBName\":\"oss\",\"DBUser\":\"rdr\"},\"hostname\":\"\",\"cacheTime\":0,\"exculde\":0,\"sessionid\":\"5a1a177584f842fb970e2888e5dd477c\",\"msg\":\"\",\"ip\":\"10.221.255.4:1521\",\"content\":{\"cmd\":\"EPC_GZDW_LOAD_DATA|epc-ices@oss@2017-04-20 19:45:00@2017-04-20 19:30:00@2017-04-19 20:00:00@2017-04-18 20:00:00@2017-04-20 20:00:00\",\"rt\":1,\"ct\":2},\"needJump\":0,\"netFlag\":\"\",\"flag\":\"\",\"ne\":\"epc-ices-oss\",\"procotol\":\"SSH\",\"retryInterval\":0}";
	 static  String strtest="{\"app\":\"VAC\",\"cacheTime\":0,\"callInterfaceName\":\"\",\"content\":{\"ct\":2,\"rt\":1,\"cmd\":\"VAC_COMMON_QUERY_IM|start@java -jar /cdr/work/proc_raw/jarasn1find.jar -c 1223743664 20170414230000 20170415010000 /cdr/work/proc_raw/cdrtest CMD_29_30_p_ *.dat@/cdr/work/proc_raw/cdrtest@/cdr/work/proc_raw/bill_result@10.14.63.102@cmd@3Rxbyws!\"},\"destQ\":\"POSEIDON_DEV\",\"exculde\":0,\"flag\":\"\",\"hostname\":\"\",\"ip\":\"10.14.63.102\",\"jumpCount\":0,\"maxConnNum\":5,\"msg\":\"\",\"msgCode\":71000,\"ne\":\"JNCG55BNK\",\"neConnType\":\"DHSS_SSH\",\"needJump\":0,\"netFlag\":\"\",\"password\":\"3Rxbyws!\",\"port\":22,\"priority\":5,\"procotol\":\"SSH\",\"retryInterval\":3,\"retryTimes\":3,\"sessionid\":\"VAC_BILL8\",\"src\":\"\",\"srcQ\":\"Poseidon_Queue_Cmdjs\",\"taskNum\":0,\"timeout\":10,\"type\":\"\",\"unitType\":\"\",\"username\":\"cmd\",\"vendor\":\"nokia\"}";
	static  String news = "{\"sessionid\":\"f8b1e1241a9247d3b82f121999732249\",\"priority\":5,\"app\":\"vac\",\"taskNum\":71000,\"vendor\":\"nokia\",\"msgCode\":71000,\"cacheTime\":5,\"srcQ\":\"CDR_MONITOR_PRG_QUEUE\",\"destQ\":\"POSEIDON_DEV\",\"content\":{\"cmd\":\"VAC_COMMON_SNYC_FILE|201704261200*@download@/cdr/work/proc_raw/cdrtest@/home/vac/cdr_parse/vac_cdr/raw/JNCG55BNK@10.14.63.102@cmd@3Rxbyws!\",\"ct\":2,\"rt\":1},\"msg\":\"\",\"flag\":\"\",\"src\":\"\",\"jumpCount\":0,\"needJump\":0,\"ne\":\"JNCG55BNK\",\"type\":\"\",\"unitType\":\"\",\"hostname\":\"\",\"ip\":\"10.14.63.102\",\"port\":22,\"username\":\"cmd\",\"password\":\"3Rxbyws!\",\"neConnType\":\"DHSS_SSH\",\"maxConnNum\":8,\"netFlag\":\"\",\"procotol\":\"ssh\",\"retryInterval\":3,\"retryTimes\":2,\"exculde\":0,\"callInterfaceName\":\"\"}";

	 
	 public static void main(String[] args) {
		
		 
	   String name = "xx";
	   String [] arr = name.split("@");
	   System.out.println(arr[0]);
		 
		System.out.println(new String(Hex.encodeHex("3Rxbyws!".getBytes())));
//		
//		try {
//			System.out.println(new String(Hex.decodeHex("6E736E3132333421".toCharArray())));
//		} catch (DecoderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//System.out.println(EncodeUtil.decodeHex("4e6b31323324"));
		 
	//	 System.out.println(new String(Hex.encodeHex("test".getBytes())));
		test1.testAMQ();
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
	
		
		RuleContent  rc = new RuleContent();
		
		 rc.setRule("week");
		 rc.setRuleDay("1,2");
		 rc.setRuleHour("2");
		 rc.setRuleMintue("");
		 rc.setRuleMonth("");
		 rc.setRuleWeek("1,2");
		
		TimePlan tp = new TimePlan();
		
		tp.setApp("lte");
		tp.setSrcQueue("SYSTEM_MANAGER_QUEUE");
		tp.setAppQueue("SYSTEM_MANAGER_QUEUE1");
		
		tp.setEndTime("2016-12-12 19:00");
		tp.setFlag2("");
		tp.setFlag3("");
		tp.setMessageCode("70003");
		tp.setStartStatus("2");
		tp.setFlag1("30");
		tp.setOpenStatus(0);
		tp.setRuleContent(rc);
		tp.setRuleDesc("每周运行一次111111111");
		tp.setServiceName("huhu");
		tp.setSessionId("1d396c12d68c44fba2419dc08098b4b3");
		tp.setStartTime("2016-12-11 19:00");
		tp.setTaskName("ices_zeroFlowCell");
		tp.setTaskParam("111111");
		tp.setTaskType(4);
		tp.setStartMethod("3");
		tp.setStartTime("2017-03-26 11:14");
		tp.setEndTime("2017-03-3123: 59");
		
//		
		
		String dd = JSONObject.fromObject(tp).toString();
//		
		
			try {
							int x=0;
//				for(int i=0;i<1;i++){
//								int n = (int)(Math.random()*10);
//								x++;
//								String cmd2="{\"msg\":\"\",\"procotol\":\"SSH\",\"flag\":\"\",\"jumpCount\":0,\"sessionid\":\""+i+"\",\"type\":\"HSSFE\",\"content\":{\"cmd\":\"SSH_DHLR_COMMAND|test,74657374:ps -ef\",\"ct\":2,\"rt\":1},\"callInterfaceName\":\"\",\"unitType\":\"HSSFE\",\"password\":\"111111\",\"hostname\":null,\"vendor\":\"nokia\",\"srcQ\":\"DHSS_SECURITY\",\"maxConnNum\":5,\"msgCode\":71000,\"taskNum\":71003,\"destQ\":\"POSEIDON_DEV\",\"app\":\"dhss\",\"neConnType\":\"DHSS_SSH\",\"netFlag\":null,\"src\":\"\",\"ip\":\"192.168.133.147\",\"priority\":5,\"exculde\":0,\"cacheTime\":5,\"retryTimes\":2,\"needJump\":0,\"port\":22,\"ne\":\"test1\",\"retryInterval\":3,\"username\":\"root\"}";
//								 
////							 nsnProducer.sendMsg("Q_POSEIDON", 20003,strs[i],"text2",n);
////							}
////							for(int i=0;i<100;i++){
////								int n = (int)(Math.random()*10);
//				          
//			               //System.out.println(str1);
////				         while(true){
////				        	 try {
////								Thread.currentThread().sleep(1000);
////							} catch (InterruptedException e) {
////								// TODO Auto-generated catch block
////								e.printStackTrace();
////							}
//			             
//			            	   
//			            	   //System.out.println(amq_ssh);			            	   
//			            	   //String nset=strs.replace("addNet", sr);
//			            	   //System.out.println(nset);
//			            	   //nsnProducer.sendMsg("Poseidon_Queue_dev", 20003,str,"text2",2);
//								
//								
							test2=test2.replace("111111", new String(Hex.encodeHex("111111".getBytes())));

							//								//cmd2=cmd2.replace("604c2d930215482ea25e14c462e60658", x+"");
//								System.out.println(test12);
//							   nsnProducer.sendMsg("POSEIDON_DEV", 71000,test12,"text2",9 );
//									    
//				         }
							 nsnProducer.sendMsg("POSEIDON_DEV", 71000,strs,"text2",9);
//								
							//nsnProducer.sendMsg("SYSTEM_MANAGER_QUEUE", 70003,dd,"text2",9 );
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
		}
	
	
	
}