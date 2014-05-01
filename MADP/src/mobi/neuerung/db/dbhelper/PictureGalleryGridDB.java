package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.PictureGalleryGridWrapper;
import mobi.neuerung.Wrapper.VideoGalleryListWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;

public class PictureGalleryGridDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public PictureGalleryGridDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;
	}

	// for Picture Gallery Operations
	public void insertRecords(ArrayList<PictureGalleryGridWrapper> array)
	{
		for (int i = 0; i < array.size(); i++) {
			PictureGalleryGridWrapper _obj = array.get(i);

			long id = 0;

			ContentValues initialValues = new ContentValues();
			initialValues.put("IdWrapper", _obj.Id );
			initialValues.put("ImageName", _obj.ImageName );
			initialValues.put("ImagePath", _obj.ImagePath);
			initialValues.put("ThumbnailPath", _obj.ThumbnailPath );
			initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance);
			initialValues.put("CatagoryCode", _obj.CatagoryCode);
			initialValues.put("SDescription", _obj.SDescription);
			initialValues.put("LDescription", _obj.LDescription);


			id = dbAdapter.insertRecordsInDB("PictureGalleryGrid", null, initialValues);				
			_obj=null;

		}


	}

	public void updateTable(ArrayList<PictureGalleryGridWrapper> array)
	{
		for (int i = 0; i < array.size(); i++) {
			PictureGalleryGridWrapper _obj = array.get(i);
			ContentValues initialValues = new ContentValues();

			initialValues.put("ImageName", _obj.ImageName );
			initialValues.put("ImagePath", _obj.ImagePath);
			initialValues.put("ThumbnailPath", _obj.ThumbnailPath );
			initialValues.put("SDescription", _obj.SDescription );
			initialValues.put("LDescription", _obj.LDescription );
			//String id = etId.getText().toString();
			String [] strArray = {""+_obj.Id};
			long n = dbAdapter.updateRecordsInDB("PictureGalleryGrid", initialValues, "IdWrapper=?", strArray);
		}
	}

	public void deleteRecord(ArrayList<PictureGalleryGridWrapper> array)
	{
		for (int i = 0; i < array.size(); i++) {
			PictureGalleryGridWrapper _obj = array.get(i);
			long n = 0 ;
			try
			{
				String [] strArray = {""+_obj.Id};

				n= dbAdapter.deleteRecordInDB("PictureGalleryGrid", "IdWrapper = ?", strArray);
			}
			catch(Exception ex)
			{
				MyUIApplication.LoggerToSD("Excepion in Deleting row "+_obj.Id, ex.toString());
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
		dbAdapter.deleteAll("PictureGalleryGrid");
	}

	// Filling Picture Gallery Category List
	public ArrayList<PictureGalleryGridWrapper> getPGGridList(String CatagoryCode)
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
		String query="SELECT * FROM PictureGalleryGrid where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"_"+MyUIApplication.globel_instance+"' and CatagoryCode ='"+CatagoryCode+"'";

		ArrayList<PictureGalleryGridWrapper> PictureGaleryGridList = dbAdapter.getPGGridList(query, null);

		//
		return PictureGaleryGridList;
	}
	// for Video Gallery  Operations
	public int insertRecordsinVGL(VideoGalleryListWrapper _obj)
	{
		long id = 0;

		ContentValues initialValues = new ContentValues();
		initialValues.put("IdWrapper", _obj.Id );
		initialValues.put("Title", _obj.Title );
		initialValues.put("Description", _obj.Description );
		initialValues.put("ImageName", _obj.ImageName );
		initialValues.put("ImagePath", _obj.ImagePath);
		initialValues.put("VideoUrl", _obj.VideoUrl);
		initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);



		id = dbAdapter.insertRecordsInDB("VideoGalleryList", null, initialValues);				
		_obj=null;

		return (int) id;
	}

	public int updateTableRecordVGL(VideoGalleryListWrapper _obj)
	{
		ContentValues initialValues = new ContentValues();

		initialValues.put("Title", _obj.Title );
		initialValues.put("Description", _obj.Description);
		initialValues.put("ImageName", _obj.ImageName);
		initialValues.put("ImagePath", _obj.ImagePath);
		initialValues.put("VideoUrl", _obj.VideoUrl);
		//String id = etId.getText().toString();
		String [] strArray = {""+_obj.Id};
		long n = dbAdapter.updateRecordsInDB("VideoGalleryList", initialValues, "IdWrapper=?", strArray);
		return (int)n;
	}

	public void deleteRecordVGL(VideoGalleryListWrapper _obj)
	{
		long n = 0 ;
		try
		{
			String [] strArray = {""+_obj.Id};

			n= dbAdapter.deleteRecordInDB("VideoGalleryList", "IdWrapper = ?", strArray);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row "+_obj.Id, ex.toString());
		}
	}

	public void deleteTableVGL()
	{		
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** Delete ",e.getMessage());
		}
		dbAdapter.deleteAll("VideoGalleryList");
	}

	// Filling Picture Gallery Category List
	public void getVideoGalleryList()
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
		String query="SELECT * FROM VideoGalleryList where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' AND IdWrapper= '"+MyUIApplication.CatagoryCode+"'";

		dbAdapter.getVideoGalleryList(query, null);

		//

	}
}
