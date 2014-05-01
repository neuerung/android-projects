package mobi.neuerung.DateUtilPackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
/*	public static Date stringToDateUTC(String strDate) {
		String month, day, year, hour, min, sec;
		Calendar cl = Calendar.getInstance();

		try {
			year = strDate.substring(0, strDate.indexOf("-"));
			strDate = strDate.substring(strDate.indexOf("-") + 1);
			month = strDate.substring(0, strDate.indexOf("-"));
			strDate = strDate.substring(strDate.indexOf("-") + 1);
			day = strDate.substring(0, strDate.indexOf(" "));
			strDate = strDate.substring(strDate.indexOf(" ") + 1);
			hour = strDate.substring(0, strDate.indexOf(":"));
			strDate = strDate.substring(strDate.indexOf(":") + 1);
			min = strDate.substring(0, strDate.indexOf(":"));
			strDate = strDate.substring(strDate.indexOf(":") + 1);
			sec = strDate;
			cl.set(Calendar.YEAR, Integer.parseInt(year));
			cl.set(Calendar.MONTH, Integer.parseInt(month) - 1);
			cl.set(Calendar.DATE, Integer.parseInt(day));
			cl.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
			cl.set(Calendar.MINUTE, Integer.parseInt(min));
			cl.set(Calendar.SECOND, Integer.parseInt(sec));

		} catch (Exception e) {
//			Date date = new Date(HttpDateParser.parse(strDate));
			return date;
		}
		return cl.getTime();
	}

	*/
	
	//Method to set Day and Today, yesterday ETC.
	public static String checkDate(Date date1)
	{

		String dayOrDate="";
		int diff=10;
		Date date2=new Date();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		//cal1.set(Calendar.DAY_OF_YEAR, 153);
		DateFormat df=new SimpleDateFormat("dd MMM yyyy");
		if(cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH)&&cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR))
		{
			if(cal2.get(Calendar.DAY_OF_MONTH)-cal1.get(Calendar.DAY_OF_MONTH)>=0)
				diff=cal2.get(Calendar.DAY_OF_MONTH)-cal1.get(Calendar.DAY_OF_MONTH);

		}

		switch(diff)
		{
		case 0:
		{
			dayOrDate="Today";
			break;
		}
		case 1:
		{
			dayOrDate="Yesterday";
			break;
		}
		default:
		{
			String day = cal1.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());
			dayOrDate=day+", "+df.format(date1);
		}
		}
		return dayOrDate;
	}

	
//	public static String differenceTime(Date d2)
//	{
//		String time="";
//		Date d1=new Date();
//		
//
//		try {
//
//			//in milliseconds
//			long diff = d2.getTime() - d1.getTime();
//
//
//			long diffMinutes = diff / (60 * 1000) % 60;
//			long diffHours = diff / (60 * 60 * 1000) % 24;
//
//
//			time=diffHours+":"+diffMinutes+" hr";
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return time;
//	}
	
	
	public static String checkTime(Date date2)
	{
		String flag="";
		Date date1=new Date();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);

	

			if(cal1.get(Calendar.MONTH)==cal2.get(Calendar.MONTH)&&cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR)&&cal1.get(Calendar.DATE)==cal2.get(Calendar.DATE))
			{
				try {
				long diff = date2.getTime() - date1.getTime();
				long diffMinutes = diff / (60 * 1000) % 60;

			//long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			
//			if(diffHours<=24&&diffHours>0)
//				flag=true;
//			else
//				flag=false;
			
			if(diffMinutes<0){
				if(Math.abs(diffHours) <=  0){
					flag	=	Math.abs(diffMinutes)+"min Ago";
				}else {
					flag	=	Math.abs(diffHours)+"hr "+Math.abs(diffMinutes)+"min Ago";
				}
					
			}else{
				if(Math.abs(diffHours) <=  0){
					flag	=	Math.abs(diffMinutes)+"min Left";
				}else {
					flag	=	diffHours+"hr "+Math.abs(diffMinutes)+"min Left";
				}
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			}


		return flag;

	}
}

