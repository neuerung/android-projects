package mobi.neuerung.db.dbhelper;


import java.util.ArrayList;

import mobi.neuerung.Wrapper.SplashOWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ClientEventDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public ClientEventDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;
	}


	public int insertRecords(ArrayList<SplashOWrapper> _objClientList)
	{
		long id = 0;
		for(int i=0;i<_objClientList.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("SNo", _objClientList.get(i).SNo );
			initialValues.put("ClientName", _objClientList.get(i).ClientName );
			initialValues.put("ClientCode", _objClientList.get(i).ClientCode);
			initialValues.put("EventName", _objClientList.get(i).EventName);
			initialValues.put("EventCode", _objClientList.get(i).EventCode);
			initialValues.put("StartDate", _objClientList.get(i).StartDate);
			initialValues.put("EndDate", _objClientList.get(i).EndDate);
			initialValues.put("ImageUrl",_objClientList.get(i).ImageUrl);
			initialValues.put("EventLogo",_objClientList.get(i).EventLogo);
			initialValues.put("ClientLogo",_objClientList.get(i).ClientLogo);
			initialValues.put("APIKey",_objClientList.get(i).APIKey);
			initialValues.put("IsAggree","false");

			id = dbAdapter.insertRecordsInDB("ClientEvent", null, initialValues);				
		}

		return (int) id;
	}

	public int updateRecords(ArrayList<SplashOWrapper> _objClientList)
	{
		long id = 0;
		for(int i=0;i<_objClientList.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("SNo", _objClientList.get(i).SNo );
			initialValues.put("ClientName", _objClientList.get(i).ClientName );
			initialValues.put("ClientCode", _objClientList.get(i).ClientCode);
			initialValues.put("EventName", _objClientList.get(i).EventName);
			initialValues.put("EventCode", _objClientList.get(i).EventCode);
			initialValues.put("StartDate", _objClientList.get(i).StartDate);
			initialValues.put("EndDate", _objClientList.get(i).EndDate);
			initialValues.put("ImageUrl",_objClientList.get(i).ImageUrl);
			initialValues.put("EventLogo",_objClientList.get(i).EventLogo);
			initialValues.put("ClientLogo",_objClientList.get(i).ClientLogo);
			initialValues.put("APIKey",_objClientList.get(i).APIKey);

			id = dbAdapter.updateRecordsInDB("ClientEvent", initialValues, "SNo = ?",new String[]{ _objClientList.get(i).SNo});				
		}

		return (int) id;
	}

	public int deleteRecords(ArrayList<SplashOWrapper> _objClientList)
	{
		long id = 0;
		for(int i=0;i<_objClientList.size();i++)
		{
			id = dbAdapter.deleteRecordInDB("ClientEvent", "SNo = ?",new String[]{ _objClientList.get(i).SNo});				
		}

		return (int) id;
	}




	public ArrayList<SplashOWrapper> getRecords()
	{
		ArrayList<SplashOWrapper> array = new ArrayList<SplashOWrapper>();

		String query="Select * from  ClientEvent order by clientname,eventname asc";

		Cursor c = dbAdapter.selectRecordsFromDB(query, null);

		if(c.moveToFirst())
		{
			do
			{
				SplashOWrapper _objSplashOWrapper = new SplashOWrapper();

				_objSplashOWrapper.SNo = c.getString(c.getColumnIndex("SNo"));
				_objSplashOWrapper.ClientName = c.getString(c.getColumnIndex("ClientName"));
				_objSplashOWrapper.ClientCode = c.getString(c.getColumnIndex("ClientCode"));
				_objSplashOWrapper.EventName = c.getString(c.getColumnIndex("EventName"));
				_objSplashOWrapper.EventCode = c.getString(c.getColumnIndex("EventCode"));
				_objSplashOWrapper.StartDate = c.getString(c.getColumnIndex("StartDate"));
				_objSplashOWrapper.EndDate = c.getString(c.getColumnIndex("EndDate"));
				_objSplashOWrapper.ImageUrl = c.getString(c.getColumnIndex("ImageUrl"));
				_objSplashOWrapper.EventLogo = c.getString(c.getColumnIndex("EventLogo"));
				_objSplashOWrapper.ClientLogo = c.getString(c.getColumnIndex("ClientLogo"));
				_objSplashOWrapper.APIKey = c.getString(c.getColumnIndex("APIKey"));
				_objSplashOWrapper.IsAggree = c.getString(c.getColumnIndex("IsAggree"));

				array.add(_objSplashOWrapper);

			}while(c.moveToNext());
		}


		return array;
	}



	public ArrayList<String> getEvents(String client)
	{
		ArrayList<String> array = new ArrayList<String>();

		String query="Select * from  ClientEvent where ClientName=?" ;

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{client});

		if(c.moveToFirst())
		{
			do
			{

				String eventCode =c.getString(c.getColumnIndex("EventCode"));

				if(eventCode.trim().length()>0)
					array.add(c.getString(c.getColumnIndex("EventName")));

			}while(c.moveToNext());
		}


		return array;
	}


	public SplashOWrapper getEventClientCode(String client,String event)
	{
		SplashOWrapper _objSplashOWrapper = new SplashOWrapper();

		String query="Select * from  ClientEvent where ClientName=? and EventName=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{client,event});

		if(c.moveToFirst())
		{
			do
			{

				_objSplashOWrapper.SNo = c.getString(c.getColumnIndex("SNo"));
				_objSplashOWrapper.ClientName = c.getString(c.getColumnIndex("ClientName"));
				_objSplashOWrapper.ClientCode = c.getString(c.getColumnIndex("ClientCode"));
				_objSplashOWrapper.EventName = c.getString(c.getColumnIndex("EventName"));
				_objSplashOWrapper.EventCode = c.getString(c.getColumnIndex("EventCode"));
				_objSplashOWrapper.StartDate = c.getString(c.getColumnIndex("StartDate"));
				_objSplashOWrapper.EndDate = c.getString(c.getColumnIndex("EndDate"));
				_objSplashOWrapper.ImageUrl = c.getString(c.getColumnIndex("ImageUrl"));
				_objSplashOWrapper.EventLogo = c.getString(c.getColumnIndex("EventLogo"));
				_objSplashOWrapper.ClientLogo = c.getString(c.getColumnIndex("ClientLogo"));
				_objSplashOWrapper.APIKey = c.getString(c.getColumnIndex("APIKey"));
				_objSplashOWrapper.IsAggree = c.getString(c.getColumnIndex("IsAggree"));


			}while(c.moveToNext());
		}


		return _objSplashOWrapper;
	}


	public void updateTimeStamp(String time)
	{
		try {
			ContentValues initialValues = new ContentValues();
			initialValues.put("updatetimestamp",time);
			dbAdapter.updateRecordInDB("ClientEvent", initialValues, null,null);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String getTimeStamp()
	{
		String time="";
		try {


			String query="Select updatetimestamp from  ClientEvent";

			Cursor c = dbAdapter.selectRecordsFromDB(query,null);

			if(c.moveToFirst())
				time=c.getString(c.getColumnIndex("updatetimestamp"));
			return time;
		} catch (Exception e) {
			// TODO: handle exception
			return time;
		}

	}
	public boolean isAggree(String ClientCode,String EventCode)
	{
		String IsAggree="false";
		try {


			String query="Select IsAggree from  ClientEvent where ClientCode=? and EventCode=?";

			Cursor c = dbAdapter.selectRecordsFromDB(query,new String[]{ClientCode,EventCode});

			if(c.moveToFirst())
				IsAggree=c.getString(c.getColumnIndex("IsAggree"));


			return Boolean.parseBoolean(IsAggree);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public void UpdateisAggree(String ClientCode,String EventCode)
	{
		try {
			ContentValues initialValues = new ContentValues();
			initialValues.put("IsAggree","true");
			dbAdapter.updateRecordInDB("ClientEvent", initialValues, "ClientCode=? and EventCode=?",new String[]{ClientCode,EventCode});
		} catch (Exception e) {
			// TODO: handle exception
		}


	}



}
