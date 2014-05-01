package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.PictureGalleryCategoryWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;

public class PictureGalleryDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public PictureGalleryDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;
	}

	public int insertRecords(ArrayList<PictureGalleryCategoryWrapper> array)
	{
		long id = 0;
		for (int i = 0; i < array.size(); i++) {

			PictureGalleryCategoryWrapper _obj = array.get(i);
			ContentValues initialValues = new ContentValues();
			initialValues.put("CatagoryCode", _obj.CatagoryCode );
			initialValues.put("CatagoryName", _obj.CatagoryName );
			initialValues.put("ImageCount", _obj.ImageCount);
			initialValues.put("Image", _obj.Image );
			initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);
			initialValues.put("instance", MyUIApplication.globel_instance);

			id = dbAdapter.insertRecordsInDB("PictureGalleryCatagory", null, initialValues);				
			_obj=null;
		}
		return (int) id;
	}

	public void updateTable(ArrayList<PictureGalleryCategoryWrapper> array)
	{
		for (int i = 0; i < array.size(); i++) {
			PictureGalleryCategoryWrapper _obj = array.get(i);
			ContentValues initialValues = new ContentValues();
			initialValues.put("CatagoryName", _obj.CatagoryName );
			initialValues.put("ImageCount", _obj.ImageCount);
			initialValues.put("Image", _obj.Image );
			initialValues.put("instance", MyUIApplication.globel_instance);
			//String id = etId.getText().toString();
			String [] strArray = {""+_obj.CatagoryCode};
			long n = dbAdapter.updateRecordsInDB("PictureGalleryCatagory", initialValues, "CatagoryCode=?", strArray);
		}

	}

	public void deleteRecord(ArrayList<PictureGalleryCategoryWrapper> array)
	{
		long n = 0 ;
		for (int i = 0; i < array.size(); i++) {
			PictureGalleryCategoryWrapper _obj = array.get(i);
			try
			{

				String [] strArray = {""+_obj.CatagoryCode};

				n= dbAdapter.deleteRecordInDB("PictureGalleryCatagory", "CatagoryCode = ?", strArray);
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
		dbAdapter.deleteAll("PictureGalleryCatagory");
	}

	// Filling Picture Gallery Category List
	public void getPGCategoryList()
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
		String query="SELECT * FROM PictureGalleryCatagory where Client_EventCode = '"+MyUIApplication.ClientCode+MyUIApplication.EventCode+"' and instance = '"+MyUIApplication.globel_instance+"'";

		dbAdapter.getPGCList(query, null);

		//

	}
}
