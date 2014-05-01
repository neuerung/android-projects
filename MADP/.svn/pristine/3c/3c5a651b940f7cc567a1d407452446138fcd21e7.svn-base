package mobi.neuerung.Wrapper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PushNotificationWrapper {

	public String PID	=	"";
	public String title	=	"";
	public String message	=	"";
	public String date	=	"";
	public Boolean headerFlag	=	false;

	public PushNotificationWrapper() {
	}

	public void setTitle(String title,String message){
		this.title	=	title;
		this.message	=	message;
		SimpleDateFormat dfDate_day= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance(); 
		date=dfDate_day.format(c.getTime());
	}
	
	public void isHeader(Boolean flag){
		headerFlag	=	flag;
	}

}
