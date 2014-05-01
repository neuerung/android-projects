package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ShowUpdatesWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;

public class ShowUpdateDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public ShowUpdateDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(ShowUpdatesWrapper _obj)
	{
		long id = 0;

		ContentValues initialValues = new ContentValues();
		initialValues.put("id", _obj.id );
		initialValues.put("title", _obj.title );
		initialValues.put("description", _obj.description);
		initialValues.put("date_time", _obj.ShowDate );
		initialValues.put("ReadOrUnRead", "Green" );
		initialValues.put("ImageUrl", _obj.ImageUrl );
		initialValues.put("Link", _obj.Link );
		initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);
		initialValues.put("CategoryCode", _obj.CatagoryCode);
		initialValues.put("instance", MyUIApplication.globel_instance);

		id = dbAdapter.insertRecordsInDB("ShowUpdates", null, initialValues);				
		_obj=null;

		return (int) id;
	}

	public int updateTable(ShowUpdatesWrapper _obj)
	{

		ContentValues initialValues = new ContentValues();
		initialValues.put("title", _obj.title );
		initialValues.put("description", _obj.description);
		initialValues.put("date_time", _obj.ShowDate );
		initialValues.put("ImageUrl", _obj.ImageUrl );
		initialValues.put("Link", _obj.Link );
		initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);
		initialValues.put("CategoryCode", _obj.CatagoryCode);
		initialValues.put("instance", MyUIApplication.globel_instance);
		String [] strArray = {""+_obj.id,_obj.CatagoryCode};
		long n = dbAdapter.updateRecordsInDB("ShowUpdates", initialValues, "id=? and CategoryCode=?", strArray);
		return (int)n;
	}

	public int updateTableForReadandUnread(String id,String Color)
	{

		ContentValues initialValues = new ContentValues();
		initialValues.put("ReadOrUnRead", Color );
		String [] strArray = {""+id};
		long n = dbAdapter.updateRecordsInDB("ShowUpdates", initialValues, "id=?", strArray);
		return (int)n;
	}
	public void deleteTable()
	{		
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** Delete ",e.getMessage());
		}
		dbAdapter.deleteAll("ShowUpdates");
		//int id=dbAdapter.deleteRecordInDB("BOOK", "1", new String[]{"1"});
		//Toast.makeText(view, String.valueOf(n),Toast.LENGTH_SHORT).show();

	}
	public boolean deleteRecord(String i)
	{
		long n = 0 ;
		try
		{
			String [] strArray = {""+i};

			n= dbAdapter.deleteRecordInDB("ShowUpdates", "id = ?", strArray);
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
	public boolean deleteRecordNameID(int i)
	{
		long n = 0 ;
		try
		{
			String [] strArray = {""+i};

			n= dbAdapter.deleteRecordInDB("exhi", "Name_id = ?", strArray);
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

	//Get only Distinct date for updates
	public void getShowUpdatesDate()
	{
		try 
		{
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="";
		if(MyUIApplication.showUpdateCategoryCode.equals("All")){
			 query="SELECT trim(SUBSTR(date_time ,0,11)) FROM showupdates where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' and instance = '"+MyUIApplication.globel_instance+"' group by SUBSTR(date_time ,0,11) order by SUBSTR(date_time ,0,11) desc";
		}else {
			 query="SELECT trim(SUBSTR(date_time ,0,11)) FROM showupdates where CategoryCode='"+MyUIApplication.showUpdateCategoryCode+"' and  Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' and instance = '"+MyUIApplication.globel_instance+"' group by SUBSTR(date_time ,0,11) order by SUBSTR(date_time ,0,11) desc";
		}
//		String query="SELECT trim(SUBSTR(date_time ,0,11)) FROM showupdates where CategoryCode='"+MyUIApplication.showUpdateCategoryCode+"' and  Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' and instance = '"+MyUIApplication.globel_instance+"' group by SUBSTR(date_time ,0,11) order by SUBSTR(date_time ,0,11) desc";
		dbAdapter.getShowUpdatesDate(query, null);
		sortShowUpdateDates();
		//
	}

	private void sortShowUpdateDates() {
		ArrayList<Date> temp	=	new ArrayList<Date>();
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		
		for(int i=0; MyUIApplication._objDateShowUpdateList.size()>i; i++){
			try {
				Date date = format1.parse(MyUIApplication._objDateShowUpdateList.get(i));
				temp.add(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		

		//Sorting
		Collections.sort(temp, new Comparator<Date>() {
		    public int compare(Date lhs, Date rhs) {
		        if (lhs.getTime() < rhs.getTime())
		            return -1;
		        else if (lhs.getTime() == rhs.getTime())
		            return 0;
		        else
		            return 1;
		    }
		});
		
		MyUIApplication._objDateShowUpdateList.clear();
		for(int i=temp.size(); 0<i; i--){
			MyUIApplication._objDateShowUpdateList.add(format1.format(temp.get(i-1)));
		}
		
	}


	//Extract New According to Date Wise
	public void getShowUpdateDate(String date)
	{
		try 
		{
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		

		String query="";
		if(MyUIApplication.showUpdateCategoryCode.equals("All")){
			 query="SELECT * FROM showupdates where trim(SUBSTR(date_time ,0,11))='"+date+"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"'  and instance = '"+MyUIApplication.globel_instance+"'  order by date_time desc" ;
		}else {
			 query="SELECT * FROM showupdates where CategoryCode='"+MyUIApplication.showUpdateCategoryCode+"' and trim(SUBSTR(date_time ,0,11))='"+date+"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"'  and instance = '"+MyUIApplication.globel_instance+"'  order by date_time desc" ;

		}

//		String query="SELECT * FROM showupdates where CategoryCode='"+MyUIApplication.showUpdateCategoryCode+"' and trim(SUBSTR(date_time ,0,11))='"+date+"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"'  and instance = '"+MyUIApplication.globel_instance+"'  order by date_time desc" ;
		dbAdapter.getShowUpdateDate(query, null);

		//
	}
	public void getShowUpdateList()
	{
		//Get only Date of list
		getShowUpdatesDate();

		MyUIApplication._objShowUpdateList = null;
		MyUIApplication._objShowUpdateList =new ArrayList<ArrayList<ShowUpdatesWrapper>>();

		for(int i=0;i<MyUIApplication._objDateShowUpdateList.size();i++)
		{
			//Now extract news Date wise
			getShowUpdateDate(MyUIApplication._objDateShowUpdateList.get(i));
		}

	}

	public void getUpdatesDate()
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
		String query="SELECT * FROM ShowUpdates where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' and instance = '"+MyUIApplication.globel_instance+"'  order by date_time";
		dbAdapter.getUpdate(query, null);

		//

	}
}
