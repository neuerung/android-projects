package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SpeakerWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class SpeakerListDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public SpeakerListDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(ArrayList<SpeakerWrapper> array)
	{
		long id = 0;
		for(int i=0;i<array.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("_id", array.get(i).id );
			initialValues.put("name", array.get(i).name );
			initialValues.put("email", array.get(i).email);
			initialValues.put("post", array.get(i).post);
			initialValues.put("companyname", array.get(i).companyname);
			initialValues.put("description", array.get(i).description);
			initialValues.put("image", array.get(i).image);
			initialValues.put("favourites", array.get(i).favourites);
			initialValues.put("EventCode",MyUIApplication.EventCode);
			initialValues.put("ClientCode",MyUIApplication.ClientCode );

			id = dbAdapter.insertRecordsInDB("speakerList", null, initialValues);				
		}

		return (int) id;
	}

	public int updateTable(ArrayList<SpeakerWrapper> array)
	{
		int n=0;
		for(int i=0;i<array.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("_id", array.get(i).id );
			initialValues.put("name", array.get(i).name );
			initialValues.put("email", array.get(i).email);
			initialValues.put("post", array.get(i).post);
			initialValues.put("companyname", array.get(i).companyname);
			initialValues.put("description", array.get(i).description);
			initialValues.put("image", array.get(i).image);
			initialValues.put("EventCode",MyUIApplication.EventCode);
			initialValues.put("ClientCode",MyUIApplication.ClientCode );

			String [] strArray = {array.get(i).id,MyUIApplication.EventCode,MyUIApplication.ClientCode};
			n = dbAdapter.updateRecordsInDB("speakerList", initialValues, "_id=? and EventCode=? and ClientCode=?", strArray);
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
		dbAdapter.deleteAll("speakerList");
		//int id=dbAdapter.deleteRecordInDB("BOOK", "1", new String[]{"1"});
		//Toast.makeText(view, String.valueOf(n),Toast.LENGTH_SHORT).show();

	}

	public boolean deleteRecord(ArrayList<SpeakerWrapper> array)
	{
		long n = 0 ;

		for(int i=0;i<array.size();i++)
		{

			try
			{

				String [] strArray = {array.get(i).id,MyUIApplication.EventCode,MyUIApplication.ClientCode};

				n= dbAdapter.deleteRecordInDB("speakerList", "_id=? and EventCode=? and ClientCode=?", strArray);
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



	public ArrayList<SpeakerWrapper> getRecords()
	{
		ArrayList<SpeakerWrapper> array = new ArrayList<SpeakerWrapper>();

		String query="Select * from  speakerList where ClientCode=? and EventCode=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode});

		if(c.moveToFirst())
		{
			do
			{
				SpeakerWrapper _objSpeakerWrapper = new SpeakerWrapper();

				_objSpeakerWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objSpeakerWrapper.name = c.getString(c.getColumnIndex("name"));
				_objSpeakerWrapper.email = c.getString(c.getColumnIndex("email"));
				_objSpeakerWrapper.post = c.getString(c.getColumnIndex("post"));
				_objSpeakerWrapper.companyname = c.getString(c.getColumnIndex("companyname"));
				_objSpeakerWrapper.description = c.getString(c.getColumnIndex("description"));
				_objSpeakerWrapper.image = c.getString(c.getColumnIndex("image"));
				_objSpeakerWrapper.favourites = c.getString(c.getColumnIndex("favourites"));

				array.add(_objSpeakerWrapper);

			}while(c.moveToNext());
		}


		return array;
	}
	
	public ArrayList<SpeakerWrapper> getFavRecord()
	{
		ArrayList<SpeakerWrapper> array = new ArrayList<SpeakerWrapper>();
		
		String query="Select * from  speakerList where ClientCode=? and EventCode=? and favourites=?";
		
		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode,"true"});
		
		if(c.moveToFirst())
		{
			do
			{
				SpeakerWrapper _objSpeakerWrapper = new SpeakerWrapper();
				
				_objSpeakerWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objSpeakerWrapper.name = c.getString(c.getColumnIndex("name"));
				_objSpeakerWrapper.email = c.getString(c.getColumnIndex("email"));
				_objSpeakerWrapper.post = c.getString(c.getColumnIndex("post"));
				_objSpeakerWrapper.companyname = c.getString(c.getColumnIndex("companyname"));
				_objSpeakerWrapper.description = c.getString(c.getColumnIndex("description"));
				_objSpeakerWrapper.image = c.getString(c.getColumnIndex("image"));
				_objSpeakerWrapper.favourites = c.getString(c.getColumnIndex("favourites"));
				
				array.add(_objSpeakerWrapper);
				
			}while(c.moveToNext());
		}
		
		
		return array;
	}

	public ArrayList<SpeakerWrapper> getSortedRecord()
	{
		ArrayList<SpeakerWrapper> array = new ArrayList<SpeakerWrapper>();
		
		String query="Select * from  speakerList where ClientCode=? and EventCode=?  ORDER BY name ASC";
		
		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode});
		
		if(c.moveToFirst())
		{
			do
			{
				SpeakerWrapper _objSpeakerWrapper = new SpeakerWrapper();
				
				_objSpeakerWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objSpeakerWrapper.name = c.getString(c.getColumnIndex("name"));
				_objSpeakerWrapper.email = c.getString(c.getColumnIndex("email"));
				_objSpeakerWrapper.post = c.getString(c.getColumnIndex("post"));
				_objSpeakerWrapper.companyname = c.getString(c.getColumnIndex("companyname"));
				_objSpeakerWrapper.description = c.getString(c.getColumnIndex("description"));
				_objSpeakerWrapper.image = c.getString(c.getColumnIndex("image"));
				_objSpeakerWrapper.favourites = c.getString(c.getColumnIndex("favourites"));
				
				array.add(_objSpeakerWrapper);
				
			}while(c.moveToNext());
		}
		
		
		return array;
	}

	public SpeakerWrapper getRecord(String _id)
	{
		SpeakerWrapper _objSpeakerWrapper = new SpeakerWrapper();
		String query="Select * from  speakerList where ClientCode=? and EventCode=? and _id=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode,_id});

		if(c.moveToFirst())
		{
			do
			{


				_objSpeakerWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objSpeakerWrapper.name = c.getString(c.getColumnIndex("name"));
				_objSpeakerWrapper.email = c.getString(c.getColumnIndex("email"));
				_objSpeakerWrapper.post = c.getString(c.getColumnIndex("post"));
				_objSpeakerWrapper.companyname = c.getString(c.getColumnIndex("companyname"));
				_objSpeakerWrapper.description = c.getString(c.getColumnIndex("description"));
				_objSpeakerWrapper.image = c.getString(c.getColumnIndex("image"));
				_objSpeakerWrapper.favourites  = c.getString(c.getColumnIndex("favourites"));


			}while(c.moveToNext());
		}


		return _objSpeakerWrapper;
	}


	public void updateTimestamp(String timeStamp)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("updatetimestamp",timeStamp );

		String [] strArray = {MyUIApplication.EventCode,MyUIApplication.ClientCode};
		long n = dbAdapter.updateRecordsInDB("speakerList", initialValues, "EventCode=? and ClientCode=?", strArray);

	}

	public String getTimeStamp()
	{

		String updateTime ="";

		String query="Select updatetimestamp from  speakerList where ClientCode=? and EventCode=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode});

		if(c.moveToFirst())
		{
			updateTime = c.getString(c.getColumnIndex("updatetimestamp"));
		}

		return updateTime;
	}

	public void favourites(String id,String favourites)
	{
		String isFavourite ="false";
		
		if(favourites.equals("false"))
		{
			
			isFavourite ="true";
			
		}
		else if(favourites.equals("true"))
		{
			isFavourite ="false";
		}
		
		ContentValues initialValues = new ContentValues();
		initialValues.put("favourites",isFavourite);

		String [] strArray = {MyUIApplication.EventCode,MyUIApplication.ClientCode,id};
		long n = dbAdapter.updateRecordsInDB("speakerList", initialValues, "EventCode=? and ClientCode=? and _id=?", strArray);
		
	}
}
