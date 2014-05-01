package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SpeakerSeminarsWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class SpeakerSeminarDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public SpeakerSeminarDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(ArrayList<SpeakerSeminarsWrapper> array)
	{
		long id = 0;
		for(int i=0;i<array.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("_id", MyUIApplication.speakerId );
			initialValues.put("name", array.get(i).name );
			initialValues.put("Title", array.get(i).Title);
			initialValues.put("Day", array.get(i).Day);
			initialValues.put("description", array.get(i).description);
			initialValues.put("visited", array.get(i).visited);
			initialValues.put("favourites", array.get(i).favourites);
			initialValues.put("EventCode",MyUIApplication.EventCode);
			initialValues.put("ClientCode",MyUIApplication.ClientCode );

			id = dbAdapter.insertRecordsInDB("speakerSeminar", null, initialValues);				
		}

		return (int) id;
	}

	public int updateTable(ArrayList<SpeakerSeminarsWrapper> array)
	{
		int n=0;
		for(int i=0;i<array.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("_id", MyUIApplication.speakerId );
			initialValues.put("name", array.get(i).name );
			initialValues.put("Title", array.get(i).Title);
			initialValues.put("Day", array.get(i).Day);
			initialValues.put("description", array.get(i).description);
			initialValues.put("visited", array.get(i).visited);
			initialValues.put("favourites", array.get(i).favourites);
			initialValues.put("EventCode",MyUIApplication.EventCode);
			initialValues.put("ClientCode",MyUIApplication.ClientCode );

			String [] strArray = {MyUIApplication.speakerId ,MyUIApplication.EventCode,MyUIApplication.ClientCode};
			n = dbAdapter.updateRecordsInDB("speakerSeminar", initialValues, "_id=? and EventCode=? and ClientCode=?", strArray);
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
		dbAdapter.deleteAll("speakerSeminar");
		//int id=dbAdapter.deleteRecordInDB("BOOK", "1", new String[]{"1"});
		//Toast.makeText(view, String.valueOf(n),Toast.LENGTH_SHORT).show();

	}

	public boolean deleteRecord(ArrayList<SpeakerSeminarsWrapper> array)
	{
		long n = 0 ;

		for(int i=0;i<array.size();i++)
		{

			try
			{

				String [] strArray = {MyUIApplication.speakerId,MyUIApplication.EventCode,MyUIApplication.ClientCode};

				n= dbAdapter.deleteRecordInDB("speakerSeminar", "_id=? and EventCode=? and ClientCode=?", strArray);
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



	public ArrayList<SpeakerSeminarsWrapper> getRecords()
	{
		ArrayList<SpeakerSeminarsWrapper> array = new ArrayList<SpeakerSeminarsWrapper>();

		String query="Select * from  speakerSeminar where ClientCode=? and EventCode=? and _id=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode,MyUIApplication.speakerId});

		if(c.moveToFirst())
		{
			do
			{
				SpeakerSeminarsWrapper _objSpeakerWrapper = new SpeakerSeminarsWrapper();

				_objSpeakerWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objSpeakerWrapper.name = c.getString(c.getColumnIndex("name"));
				_objSpeakerWrapper.Title = c.getString(c.getColumnIndex("Title"));
				_objSpeakerWrapper.Day = c.getString(c.getColumnIndex("Day"));
				_objSpeakerWrapper.description = c.getString(c.getColumnIndex("description"));
				_objSpeakerWrapper.visited = c.getString(c.getColumnIndex("visited"));
				_objSpeakerWrapper.favourites = c.getString(c.getColumnIndex("favourites"));

				array.add(_objSpeakerWrapper);

			}while(c.moveToNext());
		}


		return array;
	}

	public ArrayList<SpeakerSeminarsWrapper> getFavRecord()
	{
		ArrayList<SpeakerSeminarsWrapper> array = new ArrayList<SpeakerSeminarsWrapper>();

		String query1 ="Select  distinct title from  speakerSeminar where ClientCode=? and EventCode=? and favourites=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query1, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode,"true"});
		if(c.moveToFirst())
		{
			do
			{
				String title=c.getString(c.getColumnIndex("Title"));

				String query="Select * from  speakerSeminar where title=? limit 1";

				Cursor cursor = dbAdapter.selectRecordsFromDB(query, new String[]{title});
				if(cursor.moveToFirst())
				{
					SpeakerSeminarsWrapper _objSpeakerWrapper = new SpeakerSeminarsWrapper();

					_objSpeakerWrapper.id = cursor.getString(cursor.getColumnIndex("_id"));
					_objSpeakerWrapper.name = cursor.getString(cursor.getColumnIndex("name"));
					_objSpeakerWrapper.Title = cursor.getString(cursor.getColumnIndex("Title"));
					_objSpeakerWrapper.Day = cursor.getString(cursor.getColumnIndex("Day"));
					_objSpeakerWrapper.description = cursor.getString(cursor.getColumnIndex("description"));
					_objSpeakerWrapper.visited = cursor.getString(cursor.getColumnIndex("visited"));
					_objSpeakerWrapper.favourites = cursor.getString(cursor.getColumnIndex("favourites"));

					array.add(_objSpeakerWrapper);
				}
			} while(c.moveToNext());
		}
		return array;
	}

	public void updateTimestamp(String timeStamp)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("updatetimestamp",timeStamp );

		String [] strArray = {MyUIApplication.EventCode,MyUIApplication.ClientCode,MyUIApplication.speakerId};
		long n = dbAdapter.updateRecordsInDB("speakerSeminar", initialValues, "EventCode=? and ClientCode=? and _id=?", strArray);

	}

	public String getTimeStamp()
	{

		String updateTime ="";

		String query="Select updatetimestamp from  speakerSeminar where ClientCode=? and EventCode=? and _id=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode,MyUIApplication.speakerId});

		if(c.moveToFirst())
		{
			updateTime = c.getString(c.getColumnIndex("updatetimestamp"));
		}

		return updateTime;
	}

	public void favourites(String seminarName,String favourites)
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

		String [] strArray = {MyUIApplication.EventCode,MyUIApplication.ClientCode,seminarName};
		long n = dbAdapter.updateRecordsInDB("speakerSeminar", initialValues, "EventCode=? and ClientCode=? and Title=?", strArray);

	}

	public void visited(String seminarName,String visited)
	{
		String isVisited ="false";

		if(visited.equals("false"))
		{

			isVisited ="true";

		}
		else if(visited.equals("true"))
		{
			isVisited ="false";
		}

		ContentValues initialValues = new ContentValues();
		initialValues.put("visited",isVisited);

		String [] strArray = {MyUIApplication.EventCode,MyUIApplication.ClientCode,seminarName};
		long n = dbAdapter.updateRecordsInDB("speakerSeminar", initialValues, "EventCode=? and ClientCode=? and Title=?", strArray);

	}


	public SpeakerSeminarsWrapper getRecord(String urlLink,String id) {
		// TODO Auto-generated method stub
		SpeakerSeminarsWrapper _objSpeakerWrapper=null;

		String query="Select * from  speakerSeminar where ClientCode=? and EventCode=? and _id=? and Title=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.ClientCode,MyUIApplication.EventCode,id,urlLink});

		if(c.moveToFirst())
		{
			do
			{
				_objSpeakerWrapper = new SpeakerSeminarsWrapper();

				_objSpeakerWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objSpeakerWrapper.name = c.getString(c.getColumnIndex("name"));
				_objSpeakerWrapper.Title = c.getString(c.getColumnIndex("Title"));
				_objSpeakerWrapper.Day = c.getString(c.getColumnIndex("Day"));
				_objSpeakerWrapper.description = c.getString(c.getColumnIndex("description"));
				_objSpeakerWrapper.visited = c.getString(c.getColumnIndex("visited"));
				_objSpeakerWrapper.favourites = c.getString(c.getColumnIndex("favourites"));


			}while(c.moveToNext());
		}


		return _objSpeakerWrapper;


	}
}
