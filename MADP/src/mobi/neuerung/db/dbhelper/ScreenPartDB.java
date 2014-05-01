package mobi.neuerung.db.dbhelper;

import java.io.IOException;

import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;


public class ScreenPartDB
{

	public DBAdapter dbAdapter=null;
	Context view;

	public ScreenPartDB(DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}

	/*
	 *  Function is using to insert the data in Button Db from Screen Xml after parsing
	 */
	public int insertRecords(ScreenPartWrapper _obj)
	{
		long id = 0;

		Log.i("ScreenNumber", _obj.ScreenName);
		ContentValues initialValues = new ContentValues();
		initialValues.put("ScreenName", _obj.ScreenName);
		initialValues.put("TopHeight", _obj.TopHeight);
		initialValues.put("TopWidth", _obj.TopWidth );
		initialValues.put("TopType", _obj.TopType);
		initialValues.put("MidHeight", _obj.MidHeight);
		initialValues.put("MidWidth", _obj.MidWidth);
		initialValues.put("MidType", _obj.MidType);
		initialValues.put("BottomHeight", _obj.BottomHeight);
		initialValues.put("BottomWidth", _obj.BottomWidth);
		initialValues.put("BottomType", _obj.BottomType);

		id = dbAdapter.insertRecordsInDB("ScreenPart", null, initialValues);				
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
		dbAdapter.deleteAll("ScreenPart");
	}

	public ScreenPartWrapper getScreenPartWrapper(String Number)
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
		String query="SELECT * FROM ScreenPart where ScreenName ='"+Number+"'";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;

		return	dbAdapter.returnScreenPartWrapper(query, null);

		//

	}






}
