package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.EventsWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

public class EventsDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public EventsDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}

	public int insertRecords(EventsWrapper _obj)
	{


		long id = 0;


		ContentValues initialValues = new ContentValues();
		initialValues.put("id", _obj.id);
		initialValues.put("Title", _obj.Title);
		initialValues.put("Description", _obj.Description);
		initialValues.put("Day", _obj.Day );
		initialValues.put("Locations", _obj.Locations );
		initialValues.put("Fees", _obj.Fees );
		initialValues.put("Language", _obj.Language );
		initialValues.put("time", _obj.time );
		initialValues.put("date_time", _obj.date_time );
		initialValues.put("Last_Modify", date_time() );
		initialValues.put("Attended ", "No" );
		initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);

		id = dbAdapter.insertRecordsInDB("Events", null, initialValues);				
		_obj=null;

		return (int) id;
	}


	public int updateTable(EventsWrapper _obj)
	{

		ContentValues initialValues = new ContentValues();
		initialValues.put("id", _obj.id);
		initialValues.put("Title", _obj.Title);
		initialValues.put("Description", _obj.Description);
		initialValues.put("Day", _obj.Day );
		initialValues.put("Locations", _obj.Locations );
		initialValues.put("Fees", _obj.Fees );
		initialValues.put("Language", _obj.Language );
		initialValues.put("time", _obj.time );
		initialValues.put("date_time", _obj.date_time );
		initialValues.put("Last_Modify", date_time() );
		initialValues.put("Attended", "No" );
		initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);
		
		String [] strArray = {""+_obj.id};
		long n = dbAdapter.updateRecordsInDB("Events", initialValues, "id=?", strArray);
		return (int)n;
	}
	public int updateAttendedColumn(String id,String str)
	{
		
		ContentValues initialValues = new ContentValues();
		initialValues.put("Attended", str );
		String [] strArray = {""+id};
		long n = dbAdapter.updateRecordsInDB("Events", initialValues, "id=?", strArray);
		return (int)n;
	}
	public  String date_time()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = new Date();

		System.out.println("date_created"+ dateFormat.format(date));
		return  dateFormat.format(date);
	}

	public boolean deleteRecord(String i)
	{
		long n = 0 ;
		try
		{
			String [] strArray = {""+i};

			n= dbAdapter.deleteRecordInDB("events", "id = ?", strArray);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row "+i, ex.toString());
		}
		if(n==0)
		{
			return false;
		}
		return true;
	}


	public void deleteTable()
	{		
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** Delete ",e.getMessage());
		}
		dbAdapter.deleteAll("events");
		//int id=dbAdapter.deleteRecordInDB("BOOK", "1", new String[]{"1"});
		//Toast.makeText(view, String.valueOf(n),Toast.LENGTH_SHORT).show();

	}

	public void getSeminarsEvents(String Day)
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM Events where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' and Day='"+Day+"'";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;

		dbAdapter.getEvents(query, null);

		//
	}

	public String getEventAttendedOrNot(String Name_id)
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT Attended FROM Events where Name_id='"+Name_id+"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"'";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;

		String str = dbAdapter.getEventsAttended(query, null);
		return str;

		//
	}
	// 
	//	public void getEventDayList()
	//	{
	//		
	//		try {
	//			dbAdapter.createDataBase();
	//		} catch (IOException e) {
	//			Log.i("*** select ",e.getMessage());
	//		}
	//		
	//		try{
	//			
	//		}catch (SQLException e) {
	//			Log.i("Exception in MyExpDB",e.toString());
	//			// TODO: handle exception
	//		}		
	//		String query="SELECT * FROM Events";
	//		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
	//		
	//		dbAdapter.getEventsDayList(query, null);
	//		
	//		//
	//		
	//	}

	public void getEventTimeList(String Day)
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT trim(SUBSTR(time ,0,3)) FROM events where Day = '"+ Day +"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' group by trim(SUBSTR(time ,0,3)) order by trim(SUBSTR(time ,0,3)) ";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		dbAdapter.getEventTimeList(query, null);

		//

	}

	public void getEventsSectionList(String Day,String Time)
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		


		String query="SELECT * FROM events where trim(SUBSTR(time ,0,3))='"+ Time +"'and Day = '"+ Day +"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' order by time";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		System.out.println(query);
		dbAdapter.getEventsSectionList(query, null);

		//

	}

	public void getMySeminarEventList(String Day)
	{

		getEventTimeList(Day);

		MyUIApplication._objEventSectionList=null;
		MyUIApplication._objEventSectionList =  new ArrayList<ArrayList<EventsWrapper>>();
		for(int i=0;i<MyUIApplication._objEventTimeList.size();i++)
		{

			// For Getting ArrayList<ArrayList<EventsWrapper>> _objEventSectionList
			getEventsSectionList(Day,MyUIApplication._objEventTimeList.get(i));
		}
		System.out.println(MyUIApplication._objEventSectionList.size());
	}
	
	

	public ArrayList<EventsWrapper> getFavRecord()
	{
		ArrayList<EventsWrapper> array = new ArrayList<EventsWrapper>();
		
		String query="Select * from  Events where Client_EventCode=? and Attended =?";
		
		Cursor cursor = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode+MyUIApplication.EventCode,"Yes"});
		
		if(cursor.moveToFirst())
		{
			do
			{
				EventsWrapper _obj = new EventsWrapper();
				
				_obj.Name_id = (cursor.getString(0));
				_obj.id = (cursor.getString(1));
				_obj.Title = (cursor.getString(2));
				_obj.Description = cursor.getString(3);
				_obj.Day = cursor.getString(4);
				_obj.Locations = cursor.getString(5);
				_obj.Fees = cursor.getString(6);
				_obj.Language = cursor.getString(7);
				_obj.time = cursor.getString(8);
				_obj.date_time = (cursor.getString(9));
				_obj.Last_Modify = (cursor.getString(10));
				_obj.Attended  = (cursor.getString(11));
				
				array.add(_obj);
				
			}while(cursor.moveToNext());
		}
		
		
		return array;
	}

}
