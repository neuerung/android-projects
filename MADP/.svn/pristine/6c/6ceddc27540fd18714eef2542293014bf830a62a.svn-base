package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.FriendsListWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class FriendsListDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public FriendsListDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(ArrayList<FriendsListWrapper> array)
	{
		long id = 0;
		for(int i=0;i<array.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("_id", array.get(i).id );
			initialValues.put("Name", array.get(i).Name );
			initialValues.put("Email", array.get(i).Email);
			initialValues.put("Code", array.get(i).Code);
			initialValues.put("Company", array.get(i).Company);
			initialValues.put("City", array.get(i).City);
			initialValues.put("Mobile", array.get(i).Mobile);
			initialValues.put("EventCode",MyUIApplication.EventCode);
			initialValues.put("ClientCode",MyUIApplication.ClientCode );
			initialValues.put("UserName",MyUIApplication.UserName );

			id = dbAdapter.insertRecordsInDB("FriendsList", null, initialValues);				
		}

		return (int) id;
	}

	public int updateTable(ArrayList<FriendsListWrapper> array)
	{
		int n=0;
		for(int i=0;i<array.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("_id", array.get(i).id );
			initialValues.put("Name", array.get(i).Name );
			initialValues.put("Email", array.get(i).Email);
			initialValues.put("Code", array.get(i).Code);
			initialValues.put("Company", array.get(i).Company);
			initialValues.put("City", array.get(i).City);
			initialValues.put("Mobile", array.get(i).Mobile);
			initialValues.put("EventCode",MyUIApplication.EventCode);
			initialValues.put("ClientCode",MyUIApplication.ClientCode );
			initialValues.put("UserName",MyUIApplication.UserName );

			String [] strArray = {MyUIApplication.UserName,array.get(i).id,MyUIApplication.EventCode,MyUIApplication.ClientCode};
			n = dbAdapter.updateRecordsInDB("FriendsList", initialValues, "UserName=? and _id=? and EventCode=? and ClientCode=?", strArray);
		}


		return n;
	}

	public void deleteTable()
	{		
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** Delete ",e.getMessage());
		}
		dbAdapter.deleteAll("FriendsList");
		//int id=dbAdapter.deleteRecordInDB("BOOK", "1", new String[]{"1"});
		//Toast.makeText(view, String.valueOf(n),Toast.LENGTH_SHORT).show();

	}

	public boolean deleteRecord(ArrayList<FriendsListWrapper> array)
	{
		long n = 0 ;

		for(int i=0;i<array.size();i++)
		{

			try
			{

				String [] strArray = {MyUIApplication.UserName,array.get(i).id,MyUIApplication.EventCode,MyUIApplication.ClientCode};

				n= dbAdapter.deleteRecordInDB("FriendsList", "UserName=? and _id=? and EventCode=? and ClientCode=?", strArray);
			}
			catch(Exception ex)
			{
				MyUIApplication.LoggerToSD("Excepion in Deleting row "+array.get(i).id, ex.toString());
			}

		}
		if(n==0)
		{
			return false;
		}
		return true;
	}



	public ArrayList<FriendsListWrapper> getRecords()
	{
		ArrayList<FriendsListWrapper> array = new ArrayList<FriendsListWrapper>();

		String query="Select * from  FriendsList where UserName=? and ClientCode=? and EventCode=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.UserName,MyUIApplication.ClientCode,MyUIApplication.EventCode});

		if(c.moveToFirst())
		{
			do
			{
				FriendsListWrapper _objFriendsListWrapper = new FriendsListWrapper();

				_objFriendsListWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objFriendsListWrapper.Name = c.getString(c.getColumnIndex("Name"));
				_objFriendsListWrapper.Email = c.getString(c.getColumnIndex("Email"));
				_objFriendsListWrapper.Code = c.getString(c.getColumnIndex("Code"));
				_objFriendsListWrapper.Company = c.getString(c.getColumnIndex("Company"));
				_objFriendsListWrapper.City = c.getString(c.getColumnIndex("City"));
				_objFriendsListWrapper.Mobile = c.getString(c.getColumnIndex("Mobile"));

				array.add(_objFriendsListWrapper);

			}while(c.moveToNext());
		}


		return array;
	}
	

	
	public FriendsListWrapper getRecord(String _id)
	{
		FriendsListWrapper _objFriendsListWrapper = new FriendsListWrapper();
		String query="Select * from  FriendsList where UserName=? and ClientCode=? and EventCode=? and _id=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.UserName,MyUIApplication.ClientCode,MyUIApplication.EventCode,_id});

		if(c.moveToFirst())
		{
			do
			{


				_objFriendsListWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objFriendsListWrapper.Name = c.getString(c.getColumnIndex("Name"));
				_objFriendsListWrapper.Email = c.getString(c.getColumnIndex("Email"));
				_objFriendsListWrapper.Code = c.getString(c.getColumnIndex("Code"));
				_objFriendsListWrapper.Company = c.getString(c.getColumnIndex("Company"));
				_objFriendsListWrapper.City = c.getString(c.getColumnIndex("City"));
				_objFriendsListWrapper.Mobile = c.getString(c.getColumnIndex("Mobile"));


			}while(c.moveToNext());
		}


		return _objFriendsListWrapper;
	}


	public void updateTimestamp(String timeStamp)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("updatetimestamp",timeStamp );

		String [] strArray = {MyUIApplication.UserName,MyUIApplication.EventCode,MyUIApplication.ClientCode};
		long n = dbAdapter.updateRecordsInDB("FriendsList", initialValues, "UserName=? and EventCode=? and ClientCode=?", strArray);

	}

	public String getTimeStamp()
	{

		String updateTime ="";

		String query="Select updatetimestamp from  FriendsList where UserName=? and ClientCode=? and EventCode=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.UserName,MyUIApplication.ClientCode,MyUIApplication.EventCode});

		if(c.moveToFirst())
		{
			updateTime = c.getString(c.getColumnIndex("updatetimestamp"));
		}

		return updateTime;
	}

}
