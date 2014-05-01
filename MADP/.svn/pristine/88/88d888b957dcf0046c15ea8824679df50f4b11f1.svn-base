package mobi.neuerung.db.dbhelper;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ExhibitorDirectoryWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;

public class MyExhiDB {

	public DBAdapter dbAdapter=null;
	Context view;

	public MyExhiDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(ExhibitorDirectoryWrapper _obj)
	{
		long id = 0;

		ContentValues initialValues = new ContentValues();
		initialValues.put("name", _obj.name );
		initialValues.put("exhibitor_id", _obj.exhibitor_id);
		initialValues.put("contact_person", _obj.contact_person);
		try
		{
			initialValues.put("booth_no_1", _obj.boothList.get(0) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_1	"+ex);
			initialValues.put("booth_no_1", "" );	
		}
		try
		{
			initialValues.put("booth_no_2", _obj.boothList.get(1) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_2"+ex);
			initialValues.put("booth_no_2", "" );	
		}
		try
		{
			initialValues.put("booth_no_3", _obj.boothList.get(2) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_3"+ex);
			initialValues.put("booth_no_3", "" );	
		}
		try
		{
			initialValues.put("booth_no_4", _obj.boothList.get(3) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_4"+ex);
			initialValues.put("booth_no_4", "" );	
		}
		try
		{
			initialValues.put("booth_no_5", _obj.boothList.get(4) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_5"+ex);
			initialValues.put("booth_no_5", "" );	
		}
		try
		{
			initialValues.put("booth_no_6", _obj.boothList.get(5) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_6"+ex);
			initialValues.put("booth_no_6", "" );	
		}
		try
		{
			initialValues.put("booth_no_7", _obj.boothList.get(6) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_7"+ex);
			initialValues.put("booth_no_7", "" );	
		}
		try
		{
			initialValues.put("booth_no_8", _obj.boothList.get(7) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_8"+ex);
			initialValues.put("booth_no_8", "" );	
		}
		initialValues.put("hall", _obj.hall );
		initialValues.put("zone_no", _obj.zone_no);
		initialValues.put("exhibitor_type", _obj.exhibitor_type);
		initialValues.put("section", _obj.section);
		initialValues.put("phone", _obj.phone );
		initialValues.put("email", _obj.email );
		initialValues.put("date_time",date_time());
		initialValues.put("Favourites","0");
		initialValues.put("Visited","0");
		initialValues.put("address",_obj.address);
		initialValues.put("Note",_obj.Note);
		initialValues.put("exhibitor_image",_obj.exhibitor_image);
		initialValues.put("CategoryName",_obj.CategoryName);
		initialValues.put("CategoryCode",_obj.CategoryCode);

		id = dbAdapter.insertRecordsInDB("exhi", null, initialValues);				
		_obj=null;

		return (int) id;
	}
	public String date_time()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = new Date();

		System.out.println("date_created"+ dateFormat.format(date));
		return  dateFormat.format(date);
	}
	public int updateexhiRecords(ExhibitorDirectoryWrapper _obj,String exhibitor_id)
	{
		long id = 0;
		
		ContentValues initialValues = new ContentValues();
		initialValues.put("name", _obj.name );
		initialValues.put("exhibitor_id", _obj.exhibitor_id);
		initialValues.put("contact_person", _obj.contact_person);
		try
		{
			initialValues.put("booth_no_1", _obj.boothList.get(0) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_1	"+ex);
			initialValues.put("booth_no_1", "" );	
		}
		try
		{
			initialValues.put("booth_no_2", _obj.boothList.get(1) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_2"+ex);
			initialValues.put("booth_no_2", "" );	
		}
		try
		{
			initialValues.put("booth_no_3", _obj.boothList.get(2) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_3"+ex);
			initialValues.put("booth_no_3", "" );	
		}
		try
		{
			initialValues.put("booth_no_4", _obj.boothList.get(3) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_4"+ex);
			initialValues.put("booth_no_4", "" );	
		}
		try
		{
			initialValues.put("booth_no_5", _obj.boothList.get(4) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_5"+ex);
			initialValues.put("booth_no_5", "" );	
		}
		try
		{
			initialValues.put("booth_no_6", _obj.boothList.get(5) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_6"+ex);
			initialValues.put("booth_no_6", "" );	
		}
		try
		{
			initialValues.put("booth_no_7", _obj.boothList.get(6) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_7"+ex);
			initialValues.put("booth_no_7", "" );	
		}
		try
		{
			initialValues.put("booth_no_8", _obj.boothList.get(7) );
		}catch(Exception ex)
		{
			System.out.println("In inseerting MyExpDb booth_no_8"+ex);
			initialValues.put("booth_no_8", "" );	
		}
		initialValues.put("hall", _obj.hall );
		initialValues.put("zone_no", _obj.zone_no);
		initialValues.put("exhibitor_type", _obj.exhibitor_type);
		initialValues.put("section", _obj.section);
		initialValues.put("phone", _obj.phone );
		initialValues.put("email", _obj.email );
		initialValues.put("date_time",date_time());
		initialValues.put("Favourites","0");
		initialValues.put("Visited","0");
		initialValues.put("address",_obj.address);
		initialValues.put("Note",_obj.Note);
		initialValues.put("exhibitor_image",_obj.exhibitor_image);
		initialValues.put("CategoryName",_obj.CategoryName);
		initialValues.put("CategoryCode",_obj.CategoryCode);
		
		String [] strArray = {""+exhibitor_id};
		long n = dbAdapter.updateRecordsInDB("exhi", initialValues, "exhibitor_id=?", strArray);
		return (int)n;
	}
	public boolean deleteRecordfromexhi(String exhibitor_id)
	{
		long n = 0 ;
		try
		{
			String [] strArray = {""+exhibitor_id};

			n= dbAdapter.deleteRecordInDB("exhi", "exhibitor_id = ?", strArray);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row "+exhibitor_id, ex.toString());
		}
		if(n==0)
		{
			return false;
		}
		return true;
	}
	public int updateTableFavourites(String i,String name)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("Favourites",i);
		System.out.println(i);
		System.out.println(name);
	//	initialValues.put("Favourites",_obj.Favourites);//MyRating

		//String id = etId.getText().toString();
		String [] strArray = {""+name};
		long n = dbAdapter.updateRecordsInDB("exhi", initialValues, "Name_id=?", strArray);
		return (int)n;
	}
	public int updateTableNotes(String i,String name)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("Note",i);
		System.out.println(i);
		System.out.println(name);
		//	initialValues.put("Favourites",_obj.Favourites);//MyRating
		
		//String id = etId.getText().toString();
		String [] strArray = {""+name};
		long n = dbAdapter.updateRecordsInDB("exhi", initialValues, "Name_id=?", strArray);
		return (int)n;
	}
	public int resetTableFavourites(String i)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("Favourites",i);
		System.out.println(i);
		
		//	initialValues.put("Favourites",_obj.Favourites);//MyRating
		
		//String id = etId.getText().toString();
		String [] strArray = {""};
		long n = dbAdapter.updateRecordsInDB("exhi", initialValues, null, null);
		return (int)n;
	}
	public int resetTableNotes(String i)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("Note",i);
		System.out.println(i);
		
		//	initialValues.put("Favourites",_obj.Favourites);//MyRating
		
		//String id = etId.getText().toString();
		String [] strArray = {""};
		long n = dbAdapter.updateRecordsInDB("exhi", initialValues, null, null);
		return (int)n;
	}
	public int updateTableVisited(String i,String name)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("Visited",i);
		
		//String id = etId.getText().toString();
		String [] strArray = {""+name};
		long n = dbAdapter.updateRecordsInDB("exhi", initialValues, "Name_id=?", strArray);
		return (int)n;
	}
	public int resetTableVisited(String i)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("Visited",i);
		
		//String id = etId.getText().toString();
		String [] strArray = {""};
		long n = dbAdapter.updateRecordsInDB("exhi", initialValues, null, null);
		return (int)n;
	}
//	public int insertNoteRecords(NotesWrapper _obj)
//	{
//	//	 Name_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,id text,name Text,contact_person TEXT,note Text,date_time datetime
//		long id = 0;
//		
//		ContentValues initialValues = new ContentValues();
//		initialValues.put("name", _obj.name );
//		initialValues.put("id", _obj.id );
//		initialValues.put("contact_person", _obj.contact_person);
//		initialValues.put("note", _obj.note);
//		initialValues.put("date_time",MyUIApplication.date_time());
//		
//		id = dbAdapter.insertRecordsInDB("Note", null, initialValues);				
//		_obj=null;
//		return (int) id;
//	}
//	public int insertAppointmentRecords(AppointmentWrapper _obj)
//	{
//		//	 Name_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,id text,name Text,contact_person TEXT,note Text,date_time datetime
//		long id = 0;
//		
//		ContentValues initialValues = new ContentValues();
//		initialValues.put("name", _obj.name );
//		initialValues.put("id", _obj.id );
//		initialValues.put("contact_person", _obj.contact_person);
//		initialValues.put("mobile_no",_obj.MobileNo);
//		initialValues.put("date",_obj.Date);
//		initialValues.put("time",_obj.Time);
//		initialValues.put("date_time",MyUIApplication.date_time());
//		
//		id = dbAdapter.insertRecordsInDB("Appointment", null, initialValues);				
//		_obj=null;
//		return (int) id;
//	}

	public boolean deleteRecord(String i)
	{
		long n = 0 ;
		try
		{
			String [] strArray = {""+i};

			n= dbAdapter.deleteRecordInDB("MyExpBeer", "BeerId = ?", strArray);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row "+i, ex.toString());
		}
		if(n==0)
		{
			return false;
		}
		return true;
	}
	public boolean deleteRecordNameID(int i)
	{
		long n = 0 ;
		try
		{
			String [] strArray = {""+i};

			n= dbAdapter.deleteRecordInDB("exhi", "Name_id = ?", strArray);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row "+i, ex.toString());
		}
		if(n==0)
		{
			return false;
		}
		return true;
	}
	public boolean deleteRecordBeerRecod(String beerId)
	{
		long n = 0 ;
		try
		{
			//String [] strArray = {""+i};
			String whereCondition="";

			n= dbAdapter.deleteRecordInDB("exhi", "Name_id = ?", null);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row ", ex.toString());
		}
		if(n==0)
		{
			return false;
		}
		return true;
	}
	//	public int updateTable(ExhibitorDirectoryWrapper _obj,String newrating)
	//	{
	//
	//		ContentValues initialValues = new ContentValues();
	//		initialValues.put("BeerId",_obj.BeerId);
	//		initialValues.put("BeerTEXT",_obj.BeerTEXT);//MyRating
	//		initialValues.put("MyRating",newrating);
	//		//String id = etId.getText().toString();
	//		String [] strArray = {""+_obj.Name_id};
	//		long n = dbAdapter.updateRecordsInDB("exhi", initialValues, "Name_id=?", strArray);
	//		return (int)n;
	//	}
	//	
	public void deleteTable()
	{		
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** Delete ",e.getMessage());
		}
		dbAdapter.deleteAll("exhi");

	}
//	public void deleteAppointmentTable()
//	{		
//		try {
//			dbAdapter.createDataBase();
//		} catch (IOException e) {
//			Log.i("*** Delete ",e.getMessage());
//		}
//		dbAdapter.deleteAll("Appointment");
//		
//	}
//	public void deleteNotestTable()
//	{		
//		try {
//			dbAdapter.createDataBase();
//		} catch (IOException e) {
//			Log.i("*** Delete ",e.getMessage());
//		}
//		dbAdapter.deleteAll("Note");
//		
//	}



	public void getMyExhiList()
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi order by trim(name)  COLLATE NOCASE ASC";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);

		//

	}
	
//	public void getMyExhiListFilterByCommpanyName(String companyName)
//	{
//
//		try {
//			dbAdapter.createDataBase();
//		} catch (IOException e) {
//			Log.i("*** select ",e.getMessage());
//		}
//
//		try{
//			
//		}catch (SQLException e) {
//			Log.i("Exception in MyExpDB",e.toString());
//			// TODO: handle exception
//		}		
//		String query="SELECT * FROM exhi where name '"+companyName+"'";
//		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
//		System.out.println(query);
//		dbAdapter.getMyExhiDetail(query, null);
//
//		//
//
//	}
//	public void getMyExhiListFilterByExhibitorId(String ExhibitorId)
//	{
//		
//		try {
//			dbAdapter.createDataBase();
//		} catch (IOException e) {
//			Log.i("*** select ",e.getMessage());
//		}
//		
//		try{
//			
//		}catch (SQLException e) {
//			Log.i("Exception in MyExpDB",e.toString());
//			// TODO: handle exception
//		}		
//		String query="SELECT * FROM exhi where exhibitor_id= '"+ExhibitorId+"'";
//		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
//		System.out.println(query);
//		dbAdapter.getMyExhiDetail(query, null);
//		
//		//
//		
//	}
//	public void getMyNotesListFilterByCommpanyName(String id)
//	{
//		
//		try {
//			dbAdapter.createDataBase();
//		} catch (IOException e) {
//			Log.i("*** select ",e.getMessage());
//		}
//		
//		try{
//			
//		}catch (SQLException e) {
//			Log.i("Exception in MyExpDB",e.toString());
//			// TODO: handle exception
//		}		
//		String query="SELECT * FROM Note where id = '"+id+"' order by trim(name)";
//		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
//		System.out.println(query);
//		dbAdapter.getMyNotesList(query, null);
//		
//		//
//		
//	}
	
	public boolean deleteRecordNotes(String beerId)
	{
		long n = 0 ;
		try
		{
			//String [] strArray = {""+i};
			String whereCondition="";
			String [] strArray = {""+beerId};
			n= dbAdapter.deleteRecordInDB("Note", "Name_id = ?", strArray);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row ", ex.toString());
		}
		if(n==0)
		{
			return false;
		}
		return true;
	}

//	public void getMyAppointmentListFilterByCommpanyName(String id)
//	{
//		
//		try {
//			dbAdapter.createDataBase();
//		} catch (IOException e) {
//			Log.i("*** select ",e.getMessage());
//		}
//		
//		try{
//			
//		}catch (SQLException e) {
//			Log.i("Exception in MyExpDB",e.toString());
//			// TODO: handle exception
//		}		
//		String query="SELECT * FROM Appointment where id = '"+id+"' order by date ,time ";
//		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
//		System.out.println(query);
//		dbAdapter.getMyAppointmentList(query, null);
//		
//		//
//		
//	}
	
	
	public boolean deleteRecordAppointment(String beerId)
	{
		long n = 0 ;
		try
		{
			//String [] strArray = {""+i};
			String whereCondition="";
			String [] strArray = {""+beerId};
			n= dbAdapter.deleteRecordInDB("Appointment", "Name_id = ?", strArray);
		}
		catch(Exception ex)
		{
			MyUIApplication.LoggerToSD("Excepion in Deleting row ", ex.toString());
		}
		if(n==0)
		{
			return false;
		}
		return true;
	}

	public void getMyExhiListFilterByHall(String hall)
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi where hall='"+hall+"' order by trim(name)";
		System.out.println(query);
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		dbAdapter.getMyExhiList(query, null);
		//
	}
	
	public void addFavourite(String id,String isfavourites)
	{
		String favourites ="0";
		
		if(isfavourites.equals("1"))
		{
			favourites ="0";
		}
		else if(isfavourites.equals("0"))
		{
			favourites ="1";
		}
		
		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		
		ContentValues initialValues = new ContentValues();
		initialValues.put("Favourites",favourites);
		
		dbAdapter.updateRecordInDB("exhi", initialValues, "exhibitor_id=?",new String[]{id});
	}

	public void addVisited(String id,String isVisited)
	{
		String Visited ="0";
		
		if(isVisited.equals("1"))
		{
			Visited ="0";
		}
		else if(isVisited.equals("0"))
		{
			Visited ="1";
		}
		
		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		
		ContentValues initialValues = new ContentValues();
		initialValues.put("Visited",Visited);
		
		dbAdapter.updateRecordInDB("exhi", initialValues, "exhibitor_id=?",new String[]{id});
	}
	
	public void getMyExhiListFilterByFavourites(String Favourites)
	{
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}
		
		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi where Favourites ='"+Favourites+"' order by trim(name)";
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);
		//
	}
	public void getMyExhiListFilterByVisited(String Visited)
	{
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}
		
		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi where Visited ='"+Visited+"' order by trim(name)";
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);
		//
	}

	public void getMyExhiListFilterByNewExhibitor(String NewExhibitor)
	{
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}
		
		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi where exhibitor_type ='"+NewExhibitor+"' order by trim(name)";
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);
		//
	}

	public void getMyExhiListFilterByProductCategory(String ProductCategory)
	{
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}
		
		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi where CategoryName ='"+ProductCategory+"' order by trim(name)";
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);
		//
	}

	public void getMyExhiListFilterByProductCategoryCode(String ProductCategoryCode)
	{
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}
		
		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi where CategoryCode ='"+ProductCategoryCode+"' order by trim(name)";
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);
		//
	}
	public void getMyExhiListFilterByNote(String Note)
	{
		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}
		
		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi where Note ='"+Note+"' order by trim(name)";
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);
		//
	}
	public void getMyExhiListFilterBySectiom(String section)
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi where section='"+section+"' order by trim(name)";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);

		//

	}

	public void getMyExhiListFilterByEditext(String pattern)
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}	
		
		pattern=pattern.replace("\'", "\''");
		
		String query="SELECT * FROM exhi where name like '%"+pattern+"%' or contact_person like '%"+pattern+"%' order by trim(name)";
		
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);

		//

	}

	public void getMyExhiListFilterByAlphabetic()
	{

		try {
			dbAdapter.createDataBase();
		} catch (IOException e) {
			Log.i("*** select ",e.getMessage());
		}

		try{
			
		}catch (SQLException e) {
			Log.i("Exception in MyExpDB",e.toString());
			// TODO: handle exception
		}		
		String query="SELECT * FROM exhi order by trim(name) COLLATE NOCASE ASC";
		//String query="SELECT * FROM book where _uniqueID='00572' or _uniqueID='00571';" ;
		System.out.println(query);
		dbAdapter.getMyExhiList(query, null);

		//

	}
	public int updateNotes(String UpdateId,String UpdateNote)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("note",UpdateNote);

		//String id = etId.getText().toString();
		String [] strArray = {""+UpdateId};
		long n = dbAdapter.updateRecordsInDB("Note", initialValues, "Name_id=?", strArray);

		return (int)n;
	}
	public int updateAppointment(String UpdateAppointmentId,String UpdateContactName,String UpdateMobileNoET,String date,String time)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put("contact_person",UpdateContactName);
		initialValues.put("mobile_no",UpdateMobileNoET);
		initialValues.put("date",date);
		initialValues.put("time",time);
		
		//String id = etId.getText().toString();
		String [] strArray = {""+UpdateAppointmentId};
		long n = dbAdapter.updateRecordsInDB("Appointment", initialValues, "Name_id=?", strArray);
		
		return (int)n;
	}


}
