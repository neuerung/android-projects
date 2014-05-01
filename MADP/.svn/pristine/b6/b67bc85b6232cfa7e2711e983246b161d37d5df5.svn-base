package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.MenuWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;






public class ElementDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public ElementDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}

	/*
	 *  Function is using to insert the data in Button Db from Screen Xml after parsing
	 */
	public int insertRecords(ElementWrapper _obj)
	{
		long id = 0;

		Log.i("ScreenNumber", _obj.ScreenName);
		ContentValues initialValues = new ContentValues();
		initialValues.put("ScreenName", _obj.ScreenName);
		initialValues.put("Number", _obj.Number);
		initialValues.put("Type", _obj.Type );
		initialValues.put("Code", _obj.Code);
		initialValues.put("Section", _obj.Section);
		initialValues.put("Title", _obj.Title);
		initialValues.put("Bitmap", _obj.Bitmap);
		initialValues.put("OnClick", _obj.OnClick);
		initialValues.put("width", _obj.width);
		initialValues.put("height", _obj.height);
		initialValues.put("Left", _obj.left);
		initialValues.put("Right", _obj.right);
		initialValues.put("LeftClick", _obj.leftClick);
		initialValues.put("RightClick", _obj.rightClick);
		initialValues.put("Client_EventCode", MyUIApplication.ClientCode+MyUIApplication.EventCode);

		id = dbAdapter.insertRecordsInDB("Element", null, initialValues);				
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
		dbAdapter.deleteAll("Element");
	}

//	public void getButtonList(String ScreenName,String Type)
//	{
//		//		MyUIApplication.fillButtonArrayList();
//		try 
//		{
//			dbAdapter.createDataBase();
//		} 
//		catch (IOException e)
//		{
//			Log.i("*** select ",e.getMessage());
//		}
//
//		try
//		{
//			
//		}
//		catch (SQLException e)
//		{
//			Log.i("Exception in BOOKDB",e.toString());
//		}		
//		String query="SELECT * FROM Button where ScreenName ='"+ScreenName +"' and Type='"+Type+"'";
//		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
//
//		dbAdapter.selectRecordsFromScreenNumber(query, null);
//
//		//
//
//	}
	public ElementWrapper getTopBarWrapper(String ScreenName,String Section)
	{
		//		MyUIApplication.fillButtonArrayList();
		try {
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
		String query="SELECT * FROM Element where ScreenName ='"+ScreenName +"' and Section='"+Section+"'";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;

		return dbAdapter.selectRecordsForTopBar(query, null);

		//

	}
	public ArrayList<ElementWrapper> getElementWrapperList(String ScreenName,String Section)
	{
		//		MyUIApplication.fillButtonArrayList();
		try {
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
		String query="SELECT * FROM Element where ScreenName ='"+ScreenName +"' and Section='"+Section+"'";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		
		return dbAdapter.selectRecordsForList(query, null);
		
		//
		
	}
	/*
	 *   Menu Buttons Getting
	 */
	public void getMenuListAccordingType(String ButtonType)
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in Button",e.toString());
			// TODO: handle exception
		}		


//		String query="SELECT * FROM Button where trim(SUBSTR(date_time ,0,11))='"+date+"'";
		String query="SELECT * FROM Element where Type='"+ButtonType+"'";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		System.out.println(query);
		dbAdapter.getMenuSectionList(query, null);

		//

	}
	public void getMenueList()
	{

		getShowUpdatesDate();
		MyUIApplication.sectionList = null;
		MyUIApplication.sectionList =new ArrayList<ArrayList<MenuWrapper>>();
		for(int i=0;i<MyUIApplication.TypeWisesectionList.size();i++)
		{
			System.out.println(MyUIApplication.TypeWisesectionList.get(i));
			getMenuListAccordingType(MyUIApplication.TypeWisesectionList.get(i));
		}

	}
	
	public void getShowUpdatesDate()
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in Button",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT Type FROM Button where ScreenName ='1'  group by Type ";       // order by SUBSTR(date_time ,0,11) desc";
		
//		String query="SELECT trim(SUBSTR(date_time ,0,11)) FROM showupdates  group by SUBSTR(date_time ,0,11) order by SUBSTR(date_time ,0,11) desc";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;

		dbAdapter.getTypeOfSection(query, null);

		//

	}
	
	

}
