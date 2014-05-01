package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.VideoGalleryCategoryWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;

public class VideoGalleryDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public VideoGalleryDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;
	}

	public int insertRecords(ArrayList<VideoGalleryCategoryWrapper> array)
	{
		long id = 0;
		for (int i = 0; i < array.size(); i++) {

			VideoGalleryCategoryWrapper _obj = array.get(i);
			ContentValues initialValues = new ContentValues();
			initialValues.put("CatagoryCode", _obj.CatagoryCode );
			initialValues.put("CatagoryName", _obj.CatagoryName );
			initialValues.put("ImageCount", _obj.VideoCount);
			initialValues.put("Image", _obj.Image );
			initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance);


			id = dbAdapter.insertRecordsInDB("VideoGalleryCatagory", null, initialValues);				
			_obj=null;
		}
		return (int) id;
	}

	public void updateTable(ArrayList<VideoGalleryCategoryWrapper> array)
	{
		for (int i = 0; i < array.size(); i++) {
			VideoGalleryCategoryWrapper _obj = array.get(i);
			ContentValues initialValues = new ContentValues();
			initialValues.put("CatagoryName", _obj.CatagoryName );
			initialValues.put("ImageCount", _obj.VideoCount);
			initialValues.put("Image", _obj.Image );
			String [] strArray = {""+_obj.CatagoryCode};
			long n = dbAdapter.updateRecordsInDB("VideoGalleryCatagory", initialValues, "CatagoryCode=?", strArray);
		}

	}

	public void deleteRecord(ArrayList<VideoGalleryCategoryWrapper> array)
	{
		long n = 0 ;
		for (int i = 0; i < array.size(); i++) {
			VideoGalleryCategoryWrapper _obj = array.get(i);
			try
			{

				String [] strArray = {""+_obj.CatagoryCode};

				n= dbAdapter.deleteRecordInDB("VideoGalleryCatagory", "CatagoryCode = ?", strArray);
			}
			catch(Exception ex)
			{
				MyUIApplication.LoggerToSD("Excepion in Deleting row "+_obj.CatagoryCode, ex.toString());
			}
		}

	}

	public void deleteTable()
	{		
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** Delete ",e.getMessage());
		}
		dbAdapter.deleteAll("VideoGalleryCategoryWrapper");
	}

	// Filling Picture Gallery Category List
	public ArrayList<VideoGalleryCategoryWrapper> getVideoCategoryList()
	{
		try
		{
			dbAdapter.createDataBase();
		}
		catch (IOException e) 
		{
			Log.i("*** select ",e.getMessage());
		}

		try
		{
			
		}
		catch (SQLException e)
		{
			Log.i("Exception in BOOKDB",e.toString());
		}		
		String query="SELECT * FROM VideoGalleryCatagory where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance+"'";

		ArrayList<VideoGalleryCategoryWrapper> array =dbAdapter.getVideoCList(query, null);

		return array;
	}
}
