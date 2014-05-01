package mobi.neuerung.db.dbhelper;

import java.io.IOException;

import mobi.neuerung.Wrapper.ScreenWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;






public class ScreenDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public ScreenDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(ScreenWrapper _obj)
	{


		long id = 0;

		Log.i("Number", _obj.Number);
		ContentValues initialValues = new ContentValues();
		initialValues.put("Number", _obj.Number);
		initialValues.put("Type", _obj.Type);
		initialValues.put("Title", _obj.Title);
		initialValues.put("OnClick", _obj.OnClick);
//		initialValues.put("leftimage", _obj.leftimage);
//		initialValues.put("rightimage", _obj.rightimage);
//		initialValues.put("leftClick", _obj.leftClick);
//		initialValues.put("rightClick", _obj.rightClick);


		id = dbAdapter.insertRecordsInDB("Screen", null, initialValues);				
		_obj=null;

		return (int) id;
	}



	public void deleteTable()
	{		
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** Delete ",e.getMessage());
		}
		dbAdapter.deleteAll("Screen");
	}

//	public String getOrderScreenNumber(String onActiviate)
//	{
//
//		String query="SELECT Number FROM screen where OnActivate='"+onActiviate+"'";
//
//		 return dbAdapter.getScreenNumberFromOnActivate(query, null);
//	}
//	public String getMrgScreenNumber(String Title)
//	{
//
//		String query="SELECT _Number FROM screen where title ='"+Title+"'";
//
//		 return dbAdapter.getScreenNumberFromOnActivate(query, null);
//	}
//	public String getSupportScreenNumber(String Title)
//	{
//
//		String query="SELECT _Number FROM screen where title ='"+Title+"'";
//
//		 return dbAdapter.getScreenNumberFromOnActivate(query, null);
//	}
	
	
//	public ScreenWrapper getHeading(String Number)
//	{
////		MyUIApplication.fillButtonArrayList();
//				try {
//					dbAdapter.createDataBase();
//				} catch (IOException e) {
//					Log.i("*** select ",e.getMessage());
//				}
//		
//				try{
//					
//					}catch (SQLException e) {
//						Log.i("Exception in BOOKDB",e.toString());
//						// TODO: handle exception
//					}		
//					String query="SELECT * FROM Screen where Number ="+Number;
//				//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
//		
//			return	dbAdapter.selectHeadingOfScreen(query, null);
//					
//				//
//				
//	}

}
