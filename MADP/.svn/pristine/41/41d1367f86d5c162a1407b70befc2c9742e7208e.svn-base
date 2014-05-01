package mobi.neuerung.db.dbhelper;

import java.io.IOException;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SyncForXmlWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;


public class SyncTimeDB {


	public DBAdapter dbAdapter=null;
	Context view;

	public SyncTimeDB(DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}

	/*
	 *  Function is using to insert the data in Button Db from Screen Xml 
	 *  after parsing for without client code and event code
	 */
	public int insertRecords(SyncTimeWrapper _obj)
	{
		long id = 0;

		Log.i("ScreenNumber", _obj.Name);

		if(_obj.Name.equals("showupdate"))
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("Name", _obj.Name);
			initialValues.put("Date_time", _obj.Date_time);
			initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);
			initialValues.put("CategoryCode", MyUIApplication.showUpdateCategoryCode);


			id = dbAdapter.insertRecordsInDB("SyncTime", null, initialValues);				
			_obj=null;

			return (int) id;
		}
		else
		{

			ContentValues initialValues = new ContentValues();
			initialValues.put("Name", _obj.Name);
			initialValues.put("Date_time", _obj.Date_time);
			initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);


			id = dbAdapter.insertRecordsInDB("SyncTime", null, initialValues);				
			_obj=null;

			return (int) id;
		}
	}
	/*
	 *  Function is using to insert the data for Sync for XML file
	 *  after parsing for with client code and event code
	 */
	public int insertRecords(SyncForXmlWrapper _obj)
	{
		long id = 0;

		Log.i("ScreenNumber", _obj.ClientCode);
		ContentValues initialValues = new ContentValues();
		initialValues.put("ClientCode", _obj.ClientCode);
		initialValues.put("EventCode", _obj.EventCode);
		initialValues.put("Date_time", _obj.Date_time);
		initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);

		id = dbAdapter.insertRecordsInDB("SyncForXml", null, initialValues);				
		_obj=null;

		return (int) id;
	}

	public void deleteTable()
	{		
		try 
		{
			dbAdapter.createDataBase();
		} 
		catch (IOException e)
		{
			Log.i("*** Delete ",e.getMessage());
		}
		dbAdapter.deleteAll("SyncTime");
	}

	// This is for Sync Time Wrapper Table
	public SyncTimeWrapper getSyncTimeWrapper(String Name)
	{
		if(Name.equals("showupdate"))
		{
			try {
				dbAdapter.createDataBase();
			} catch (IOException e) {
				Log.i("*** select ",e.getMessage());
			}

			try{
				
			}catch (SQLException e) {
				Log.i("Exception in BOOKDB",e.toString());
				// TODO: handle exception
			}		
			String query="SELECT * FROM SyncTime where CategoryCode='"+MyUIApplication.showUpdateCategoryCode+"' and Name ='"+Name+"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"'";
			//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;

			return	dbAdapter.returnSyncTimeWrapper(query, null);
		}
		else
		{

			try {
				dbAdapter.createDataBase();
			} catch (IOException e) {
				Log.i("*** select ",e.getMessage());
			}

			try{
				
			}catch (SQLException e) {
				Log.i("Exception in BOOKDB",e.toString());
				// TODO: handle exception
			}		
			String query="SELECT * FROM SyncTime where Name ='"+Name+"' and Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"'";
			//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;

			return	dbAdapter.returnSyncTimeWrapper(query, null);
		}
		//

	}

	// This is for Sync Time For Client Code and Event Code Xml Wrapper Table
	public SyncForXmlWrapper getSyncTimeForXmlWrapper(String ClientCode,String EventCode)
	{
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in BOOKDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM SyncForXml where ClientCode  = '"+ ClientCode +"' and EventCode  ='"+EventCode+"'";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;

		return	dbAdapter.returnSyncTimeForXmlWrapper(query, null);

		//

	}

	// This is For SyncTime Table With Name without ClientCode and EventCode
	public int updateTable(SyncTimeWrapper _obj)
	{

		if(_obj.Name.equals("showupdate"))
		{
			ContentValues initialValues = new ContentValues();

			initialValues.put("Name", _obj.Name );
			initialValues.put("Date_time", _obj.Date_time);


			String [] strArray = {""+_obj.Name,MyUIApplication.showUpdateCategoryCode};
			long n = dbAdapter.updateRecordsInDB("SyncTime", initialValues, "name=? and CategoryCode=?", strArray);
			return (int)n;
		}
		else
		{


			ContentValues initialValues = new ContentValues();

			initialValues.put("Name", _obj.Name );
			initialValues.put("Date_time", _obj.Date_time);

			String [] strArray = {""+_obj.Name};
			long n = dbAdapter.updateRecordsInDB("SyncTime", initialValues, "name=?", strArray);
			return (int)n;
		}
	}

	// This is For SyncTime Table With Name without ClientCode and EventCode
	public int updateTable(SyncForXmlWrapper _obj)
	{
		ContentValues initialValues = new ContentValues();

		initialValues.put("ClientCode", _obj.ClientCode );
		initialValues.put("EventCode", _obj.EventCode );
		initialValues.put("Date_time", _obj.Date_time);

		String [] strArray = {_obj.ClientCode,_obj.EventCode };
		long n = dbAdapter.updateRecordsInDB("SyncForXml", initialValues, "ClientCode=? and EventCode=?", strArray);
		return (int)n;
	}

}
