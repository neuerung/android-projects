package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ShowUpdatesCategoryWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class ShowUpdateCategoryDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public ShowUpdateCategoryDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(ShowUpdatesCategoryWrapper _obj)
	{
		long id = 0;

		ContentValues initialValues = new ContentValues();
		initialValues.put("_id", _obj.id );
		initialValues.put("CatagoryCode", _obj.CatagoryCode );
		initialValues.put("CatagoryName", _obj.CatagoryName);
		initialValues.put("EventCode",MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance);
		initialValues.put("ClientCode",MyUIApplication.ClientCode );

		id = dbAdapter.insertRecordsInDB("ShowUpdatesCategory", null, initialValues);				
		_obj=null;

		return (int) id;
	}

	public int updateTable(ShowUpdatesCategoryWrapper _obj)
	{

		ContentValues initialValues = new ContentValues();
		initialValues.put("CatagoryCode", _obj.CatagoryCode );
		initialValues.put("CatagoryName", _obj.CatagoryName);
		
		String [] strArray = {_obj.id,MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance,MyUIApplication.ClientCode};
		long n = dbAdapter.updateRecordsInDB("ShowUpdatesCategory", initialValues, "_id=? and EventCode=? and ClientCode=?", strArray);
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
	public boolean deleteRecord(ShowUpdatesCategoryWrapper _obj)
	{
		long n = 0 ;
		try
		{
			
			String [] strArray = {_obj.id,MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance,MyUIApplication.ClientCode};

			n= dbAdapter.deleteRecordInDB("ShowUpdatesCategory", "_id=? and EventCode=? and ClientCode=?", strArray);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row "+_obj.id, ex.toString());
		}
		if(n==0)
		{
			return false;
		}
		return true;
	}

//	public void getShowUpdatesDate()
//	{
//		try 
//		{
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
//		String query="SELECT trim(SUBSTR(date_time ,0,11)) FROM showupdates where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' group by SUBSTR(date_time ,0,11) order by SUBSTR(date_time ,0,11) desc";
//		dbAdapter.getShowUpdatesDate(query, null);
//
//		//
//	}
//
//	public void getShowUpdateDate(String date)
//	{
//		try 
//		{
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
//
//
//		String query="SELECT * FROM showupdates where trim(SUBSTR(date_time ,0,11))='"+date+"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' order by date_time desc" ;
//		dbAdapter.getShowUpdateDate(query, null);
//
//		//
//	}
//	public void getShowUpdateList()
//	{
//		getShowUpdatesDate();
//
//
//		MyUIApplication._objShowUpdateList = null;
//		MyUIApplication._objShowUpdateList =new ArrayList<ArrayList<ShowUpdatesWrapper>>();
//		for(int i=0;i<MyUIApplication._objDateShowUpdateList.size();i++)
//		{
//			getShowUpdateDate(MyUIApplication._objDateShowUpdateList.get(i));
//		}
//
//	}
//
//	public void getUpdatesDate()
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
//		String query="SELECT * FROM ShowUpdates where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' order by date_time";
//		dbAdapter.getUpdate(query, null);
//
//		//
//
//	}
	
	
	public ArrayList<ShowUpdatesCategoryWrapper> getRecords()
	{
		ArrayList<ShowUpdatesCategoryWrapper> array = new ArrayList<ShowUpdatesCategoryWrapper>();
		
		String query="Select * from  ShowUpdatesCategory where ClientCode=? and EventCode=?";
		
		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance});
		
		if(c.moveToFirst())
		{
			do
			{
				ShowUpdatesCategoryWrapper _objShowUpdatesCategoryWrapper = new ShowUpdatesCategoryWrapper();
				
				_objShowUpdatesCategoryWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objShowUpdatesCategoryWrapper.CatagoryCode = c.getString(c.getColumnIndex("CatagoryCode"));
				_objShowUpdatesCategoryWrapper.CatagoryName = c.getString(c.getColumnIndex("CatagoryName"));
				
				array.add(_objShowUpdatesCategoryWrapper);
				
			}while(c.moveToNext());
		}
		
		
		return array;
	}
	
	
	public void updateTimestamp(String timeStamp)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("updatetimestamp",timeStamp );
		
		String [] strArray = {MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance,MyUIApplication.ClientCode};
		long n = dbAdapter.updateRecordsInDB("ShowUpdatesCategory", initialValues, "EventCode=? and ClientCode=?", strArray);
		
	}
	
	public String getTimeStamp()
	{
		
		String updateTime ="";
		
		String query="Select updatetimestamp from  ShowUpdatesCategory where ClientCode=? and EventCode=?";
		
		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance});
		
		if(c.moveToFirst())
		{
			updateTime = c.getString(c.getColumnIndex("updatetimestamp"));
		}
		
		return updateTime;
	}
}
