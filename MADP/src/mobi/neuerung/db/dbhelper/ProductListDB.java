package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ProductListWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class ProductListDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public ProductListDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(ArrayList<ProductListWrapper> array)
	{
		long id = 0;
		for(int i=0;i<array.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("_id", array.get(i).id );
			initialValues.put("ProductCode", array.get(i).ProductCode );
			initialValues.put("ProductName", array.get(i).ProductName);
			initialValues.put("Description", array.get(i).Description);
			initialValues.put("EventCode",MyUIApplication.EventCode);
			initialValues.put("ClientCode",MyUIApplication.ClientCode );
			initialValues.put("CategoryCode",MyUIApplication.exhibitorproductName );

			id = dbAdapter.insertRecordsInDB("ProductList", null, initialValues);				
		}

		return (int) id;
	}

	public int updateTable(ArrayList<ProductListWrapper> array)
	{
		int n=0;
		for(int i=0;i<array.size();i++)
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put("_id", array.get(i).id );
			initialValues.put("ProductCode", array.get(i).ProductCode );
			initialValues.put("ProductName", array.get(i).ProductName);
			initialValues.put("Description", array.get(i).Description);
			initialValues.put("EventCode",MyUIApplication.EventCode);
			initialValues.put("ClientCode",MyUIApplication.ClientCode );
			initialValues.put("CategoryCode",MyUIApplication.exhibitorproductName );

			String [] strArray = {array.get(i).id,MyUIApplication.EventCode,MyUIApplication.ClientCode};
			n = dbAdapter.updateRecordsInDB("ProductList", initialValues, "_id=? and EventCode=? and ClientCode=?", strArray);
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
		dbAdapter.deleteAll("ProductList");
		//int id=dbAdapter.deleteRecordInDB("BOOK", "1", new String[]{"1"});
		//Toast.makeText(view, String.valueOf(n),Toast.LENGTH_SHORT).show();

	}

	public boolean deleteRecord(ArrayList<ProductListWrapper> array)
	{
		long n = 0 ;

		for(int i=0;i<array.size();i++)
		{

			try
			{

				String [] strArray = {array.get(i).id,MyUIApplication.EventCode,MyUIApplication.ClientCode};

				n= dbAdapter.deleteRecordInDB("ProductList", "_id=? and EventCode=? and ClientCode=?", strArray);
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



	public ArrayList<ProductListWrapper> getRecords()
	{
		ArrayList<ProductListWrapper> array = new ArrayList<ProductListWrapper>();

		String query="Select * from  ProductList where CategoryCode=? and ClientCode=? and EventCode=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.exhibitorproductName,MyUIApplication.ClientCode,MyUIApplication.EventCode});

		if(c.moveToFirst())
		{
			do
			{
				ProductListWrapper _objProductListWrapper = new ProductListWrapper();

				_objProductListWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objProductListWrapper.ProductCode = c.getString(c.getColumnIndex("ProductCode"));
				_objProductListWrapper.ProductName = c.getString(c.getColumnIndex("ProductName"));
				_objProductListWrapper.Description = c.getString(c.getColumnIndex("Description"));

				array.add(_objProductListWrapper);

			}while(c.moveToNext());
		}


		return array;
	}

	public ProductListWrapper getRecord(String _id)
	{
		ProductListWrapper _objProductListWrapper = new ProductListWrapper();
		String query="Select * from  ProductList where CategoryCode=? and ClientCode=? and EventCode=? and _id=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.exhibitorproductName,MyUIApplication.ClientCode,MyUIApplication.EventCode,_id});

		if(c.moveToFirst())
		{
			do
			{


				_objProductListWrapper.id = c.getString(c.getColumnIndex("_id"));
				_objProductListWrapper.ProductCode = c.getString(c.getColumnIndex("ProductCode"));
				_objProductListWrapper.ProductName = c.getString(c.getColumnIndex("ProductName"));
				_objProductListWrapper.Description = c.getString(c.getColumnIndex("Description"));


			}while(c.moveToNext());
		}


		return _objProductListWrapper;
	}


	public void updateTimestamp(String timeStamp)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("updatetimestamp",timeStamp );

		String [] strArray = {MyUIApplication.exhibitorproductName,MyUIApplication.EventCode,MyUIApplication.ClientCode};
		long n = dbAdapter.updateRecordsInDB("ProductList", initialValues, "CategoryCode=? and EventCode=? and ClientCode=?", strArray);

	}

	public String getTimeStamp()
	{

		String updateTime ="";

		String query="Select updatetimestamp from  ProductList where CategoryCode=? and ClientCode=? and EventCode=?";

		Cursor c = dbAdapter.selectRecordsFromDB(query, new String[]{MyUIApplication.exhibitorproductName,MyUIApplication.ClientCode,MyUIApplication.EventCode});

		if(c.moveToFirst())
		{
			updateTime = c.getString(c.getColumnIndex("updatetimestamp"));
		}

		return updateTime;
	}
}
