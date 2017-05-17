import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Test3 {

	
	public static void main(String[] args) {
		
		//System.out.println(dds());
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(2);
		list.add(9);
		list.add(8);
		Collections.sort(list);
		for(Integer str :list){
			System.out.println(str);
		}
		
	}
	
	 //按今天的日期 年月日  去掉20 返回
	  public static String currtime_time() {
		    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
		    String date = sd.format(new Date());
		    //20159028
		    //20150928221418
		    date=date.substring(2,8);
		    return date;
		  }
	  
	  public static String dds(){
		  Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
	        calendar.add(Calendar.DATE, -1);    //得到前一天
	      String  yestedayDate 
	          = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()).substring(2,8);
	     // System.out.println(yestedayDate);
	      return yestedayDate;
	  }
}
