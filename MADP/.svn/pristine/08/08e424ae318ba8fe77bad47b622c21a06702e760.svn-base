package mobi.neuerung.db;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.EventsWrapper;
import mobi.neuerung.Wrapper.ExhibitorDirectoryWrapper;
import mobi.neuerung.Wrapper.MenuWrapper;
import mobi.neuerung.Wrapper.PictureGalleryCategoryWrapper;
import mobi.neuerung.Wrapper.PictureGalleryGridWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ShowUpdatesWrapper;
import mobi.neuerung.Wrapper.SyncForXmlWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;
import mobi.neuerung.Wrapper.VideoGalleryCategoryWrapper;
import mobi.neuerung.Wrapper.VideoGalleryListWrapper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.provider.MediaStore.Video.VideoColumns;
import android.util.Log;



public class DBAdapter extends SQLiteOpenHelper {

	private static String DB_PATH = "";
	private static final String DB_NAME = "events_mobile_guide_db.db";
	private SQLiteDatabase myDataBase;
	private final Context myContext;
	private static final int DATABASE_VERSION = 4;
	private static DBAdapter mDBConnection;

	/**
	 * Constructor Takes and keeps a reference of the passed context in order to
	 * access to the application assets and resources.
	 * 
	 * @param context
	 */
	private DBAdapter(Context context) {
		super(context, DB_NAME, null, DATABASE_VERSION);

		this.myContext = context;
		DB_PATH = "/data/data/"
			+ context.getApplicationContext().getPackageName()
			+ "/databases/";
		// The Android's default system path of your application database is
		// "/data/data/mypackagename/databases/"
	}

	/**
	 * getting Instance
	 * 
	 * @param context
	 * @return DBAdapter
	 */
	public static synchronized DBAdapter getDBAdapterInstance(Context context) {
		if (mDBConnection == null) {
			mDBConnection = new DBAdapter(context);
		}
		return mDBConnection;
	}

	/**
	 * Creates an empty database on the system and rewrites it with your own
	 * database.
	 **/
	public boolean createDataBase() throws IOException {
		boolean dbExist = checkDataBase();

		if (dbExist) {

			//			getWritableDatabase();
			// do nothing - database already exist
		} else {
			// By calling following method
			// 1) an empty database will be created into the default system path
			// of your application
			// 2) than we overwrite that database with our database.
			getWritableDatabase();
			try {

				Log.i("from DBADAPTER", "DB Creating");
				copyDataBase();
				dbExist = true;
			} catch (IOException e) {
				throw new Error("Error copying database");
			}
		}
		return dbExist;
	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	public boolean checkDataBase() {
		SQLiteDatabase checkDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);

		} catch (SQLiteException e) {
			// database does't exist yet.
		}
		if (checkDB != null) {
			checkDB.close();
		}
		return checkDB != null ? true : false;
	}

	/**
	 * Copies your database from your local assets-folder to the just created
	 * empty database in the system folder, from where it can be accessed and
	 * handled. This is done by transfering bytestream.
	 * */
	// public void copyDataBase() throws IOException {
	// // Open your local db as the input stream
	// InputStream myInput = myContext.getAssets().open(DB_NAME);
	// // Path to the just created empty db
	// String outFileName = DB_PATH + DB_NAME;
	// // Open the empty db as the output stream
	// OutputStream myOutput = new FileOutputStream(outFileName);
	// // transfer bytes from the inputfile to the outputfile
	// byte[] buffer = new byte[1024];
	// int length;
	// while ((length = myInput.read(buffer)) > 0) {
	// myOutput.write(buffer, 0, length);
	// }
	// // Close the streams
	// myOutput.flush();
	// myOutput.close();
	// myInput.close();
	// }
	/*
	 *   This method is using for copy the database into phone from application
	 */
	public static void copyDataBase() throws IOException {
		// Open your local db as the input stream

		String DB_PATH = "/data/data/"+ MyUIApplication.getContext().getApplicationContext()
		.getPackageName() + "/databases/";
		InputStream myInput = MyUIApplication.getContext().getResources().openRawResource(R.raw.events_mobile_guide_db);

		// getContext().getAssets().open(DB_NAME);
		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;
		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);
		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}
		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	/**
	 * Open the database
	 * 
	 * @throws SQLException
	 */
	public SQLiteDatabase openDataBase() throws SQLException {
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READWRITE);
		return myDataBase;
	}

	/**
	 * Close the database if exist
	 */
	@Override
	public synchronized void close() {
		if (myDataBase != null)
			myDataBase.close();
		super.close();
	}

	/**
	 * Call on creating data base for example for creating tables at run time
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {

		try {
			copyDataBase();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("creatingggggggggggggggggggggggg");
		System.out.println("creatingggggggggggggggggggggggg..." + db.getVersion());

		File folder = Environment.getExternalStorageDirectory();
//		String fileName = folder.getPath() + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ MyUIApplication.ClientCode+MyUIApplication.EventCode+".xml";
		String fileName = folder.getPath() + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen.xml";
		File myFile = new File(fileName);
		if(myFile.exists())
			myFile.delete();

	}

	/**
	 * can used for drop tables then call onCreate(db) function to create tables
	 * again - upgrade
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		try {
			copyDataBase();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("upgrgggggggggggggggggggggggg");
		System.out.println("upgrgggggggggggggggggggggggg..." +db.getVersion());

		File folder = Environment.getExternalStorageDirectory();
		String fileName = folder.getPath() + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";
		File myFile = new File(fileName);
		if(myFile.exists())
			myFile.delete();
	}

	// ----------------------- CRUD Functions ------------------------------

	/**
	 * This function used to select the records from DB.
	 * 
	 * @param tableName
	 * @param tableColumns
	 * @param whereClase
	 * @param whereArgs
	 * @param groupBy
	 * @param having
	 * @param orderBy
	 * @return A Cursor object, which is positioned before the first entry.
	 */
	public Cursor selectRecordsFromDB(String tableName, String[] tableColumns,
			String whereClase, String whereArgs[], String groupBy,
			String having, String orderBy) {

		return myDataBase.query(tableName, tableColumns, whereClase, whereArgs,
				groupBy, having, orderBy);
	}

	/**
	 * select records from db and return in list
	 * 
	 * @param tableName
	 * @param tableColumns
	 * @param whereClase
	 * @param whereArgs
	 * @param groupBy
	 * @param having
	 * @param orderBy
	 * @return ArrayList<ArrayList<String>>
	 */
	// public ArrayList<ArrayList<String>> selectRecordsFromDBList(String
	// tableName, String[] tableColumns,
	// String whereClase, String whereArgs[], String groupBy,
	// String having, String orderBy) {
	//
	// ArrayList<ArrayList<String>> retList = new
	// ArrayList<ArrayList<String>>();
	//
	// ArrayList<String> list = new ArrayList<String>();
	//
	// Cursor cursor = myDataBase.query(tableName, tableColumns, whereClase,
	// whereArgs,
	// groupBy, having, orderBy);
	//
	// if (cursor.moveToFirst()) {
	// do {
	// list = new ArrayList<String>();
	//
	// for(int i=0; i<cursor.getColumnCount(); i++){
	// list.add( cursor.getString(i) );
	// }
	// retList.add(list);
	// } while (cursor.moveToNext());
	// }
	// if (cursor != null && !cursor.isClosed()) {
	// cursor.close();
	// }
	// return retList;
	//
	// }

	/**
	 * This function used to insert the Record in DB.
	 * 
	 * @param tableName
	 * @param nullColumnHack
	 * @param initialValues
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 */
	public long insertRecordsInDB(String tableName, String nullColumnHack,
			ContentValues initialValues) {

		return myDataBase.insert(tableName, nullColumnHack, initialValues);
	}

	/**
	 * This function used to update the Record in DB.
	 * 
	 * @param tableName
	 * @param initialValues
	 * @param whereClause
	 * @param whereArgs
	 * @return true / false on updating one or more records
	 */
	public boolean updateRecordInDB(String tableName,
			ContentValues initialValues, String whereClause, String whereArgs[]) {

		return myDataBase.update(tableName, initialValues, whereClause,
				whereArgs) > 0;
	}

	/**
	 * This function used to update the Record in DB.
	 * 
	 * @param tableName
	 * @param initialValues
	 * @param whereClause
	 * @param whereArgs
	 * @return 0 in case of failure otherwise return no of row(s) are updated
	 */
	public int updateRecordsInDB(String tableName, ContentValues initialValues,
			String whereClause, String whereArgs[]) {

		return myDataBase.update(tableName, initialValues, whereClause,
				whereArgs);
	}

	/**
	 * This function used to delete the Record in DB.
	 * 
	 * @param tableName
	 * @param whereClause
	 * @param whereArgs
	 * @return 0 in case of failure otherwise return no of row(s) are deleted.
	 */
	public int deleteRecordInDB(String tableName, String whereClause,
			String[] whereArgs) {

		return myDataBase.delete(tableName, whereClause, whereArgs);
	}

	// --------------------- Select Raw Query Functions ---------------------

	/**
	 * apply raw Query
	 * 
	 * @param query
	 * @param selectionArgs
	 * @return Cursor
	 */
	public Cursor selectRecordsFromDB(String query, String[] selectionArgs) {
		return myDataBase.rawQuery(query, selectionArgs);
	}

	/**
	 * apply raw query and return result in list
	 * 
	 * @param query
	 * @param selectionArgs
	 * @return ArrayList<ArrayList<String>>
	 */
	public ArrayList<ArrayList<String>> selectRecordsFromDBList(String query,
			String[] selectionArgs) {

		ArrayList<ArrayList<String>> retList = new ArrayList<ArrayList<String>>();

		ArrayList<String> list = new ArrayList<String>();
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {
				list = new ArrayList<String>();
				for (int i = 0; i < cursor.getColumnCount(); i++) {
					list.add(cursor.getString(i));
				}
				retList.add(list);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return retList;
	}
	public void deleteAll(String tablename) {
		myDataBase.delete(tablename, null, null);

	}



	/*
	 *  Returns ButtonList 
	 */
	//	public void selectRecordsFromScreenNumber (String query, String[] selectionArgs)
	//	{	      
	//
	//		ButtonWrapper _obj= new ButtonWrapper();
	//
	//		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
	//		if (cursor.moveToFirst()) {
	//			do {
	//				//list = new ArrayList<String>();
	//				_obj= new ButtonWrapper();
	//				_obj.ScreenName=(cursor.getString(1));
	//				_obj.Number=(cursor.getString(2));
	//				_obj.Type=(cursor.getString(3));
	//				_obj.Section=(cursor.getString(4));
	//				_obj.Code=(cursor.getString(5));
	//				_obj.Title=(cursor.getString(6));
	//				_obj.Bitmap=(cursor.getString(7));
	//				_obj.OnClick=(cursor.getString(8));
	//				_obj.width=(cursor.getString(9));
	//				_obj.height=(cursor.getString(10));
	//				try
	//				{
	//					boolean a= Home._objButtonList.add(_obj);
	//					System.out.println(a+""+Home._objButtonList.size());
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println(""+e);
	//				}
	//
	//			} while (cursor.moveToNext());
	//		}
	//		if (cursor != null && !cursor.isClosed()) {
	//			cursor.close();
	//		}
	//		//		return ((Home)myContext)._objButtonList;
	//
	//	}
	public ElementWrapper selectRecordsForTopBar (String query, String[] selectionArgs)
	{	      

		ElementWrapper _obj= new ElementWrapper();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				_obj= new ElementWrapper();
				_obj.ScreenName=(cursor.getString(1));
				_obj.Number=(cursor.getString(2));
				_obj.Code=(cursor.getString(3));
				_obj.Section=(cursor.getString(4));
				_obj.Type=(cursor.getString(5));
				_obj.Title=(cursor.getString(6));
				_obj.Bitmap=(cursor.getString(7));
				_obj.OnClick=(cursor.getString(8));
				_obj.width=(cursor.getString(9));
				_obj.height=(cursor.getString(10));
				_obj.left=(cursor.getString(11));
				_obj.right=(cursor.getString(12));
				_obj.leftClick=(cursor.getString(13));
				_obj.rightClick=(cursor.getString(14));


			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return _obj;

	}
	public ArrayList<ElementWrapper> selectRecordsForList (String query, String[] selectionArgs)
	{	      

		ArrayList<ElementWrapper> _objList= new ArrayList<ElementWrapper>();
		ElementWrapper _obj= new ElementWrapper();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				_obj= new ElementWrapper();
				_obj.ScreenName=(cursor.getString(1));
				_obj.Number=(cursor.getString(2));
				_obj.Code=(cursor.getString(3));
				_obj.Section=(cursor.getString(4));
				_obj.Type=(cursor.getString(5));
				_obj.Title=(cursor.getString(6));
				_obj.Bitmap=(cursor.getString(7));
				_obj.OnClick=(cursor.getString(8));
				_obj.width=(cursor.getString(9));
				_obj.height=(cursor.getString(10));

				_objList.add(_obj);

			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		int i =_objList.size();
		System.out.println(""+ i);
		return _objList;

	}
	public ScreenPartWrapper returnScreenPartWrapper (String query, String[] selectionArgs)
	{	      

		ScreenPartWrapper _obj= new ScreenPartWrapper();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				_obj= new ScreenPartWrapper();
				_obj.ScreenName=(cursor.getString(1));
				_obj.TopHeight=(cursor.getString(2));
				_obj.TopWidth=(cursor.getString(3));
				_obj.TopType=(cursor.getString(4));
				_obj.MidHeight=(cursor.getString(5));
				_obj.MidWidth=(cursor.getString(6));
				_obj.MidType=(cursor.getString(7));
				_obj.BottomHeight=(cursor.getString(8));
				_obj.BottomWidth=(cursor.getString(9));
				_obj.BottomType=(cursor.getString(10));

			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return _obj;

	}

	// Filling Picture Gallery Category List
	public void getPGCList (String query, String[] selectionArgs)
	{	      

		PictureGalleryCategoryWrapper _obj = new PictureGalleryCategoryWrapper();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				_obj= new PictureGalleryCategoryWrapper();
				_obj.CatagoryCode=(cursor.getString(1));
				_obj.CatagoryName=(cursor.getString(2));
				_obj.ImageCount=(cursor.getString(3));
				_obj.Image=(cursor.getString(4));
				_obj.instance	=	(cursor.getString(cursor.getColumnIndex("instance")));


				MyUIApplication.PictureGaleryCategoryList.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}


	}
	public ArrayList<VideoGalleryCategoryWrapper> getVideoCList (String query, String[] selectionArgs)
	{	      

		ArrayList<VideoGalleryCategoryWrapper> array = new ArrayList<VideoGalleryCategoryWrapper>();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				VideoGalleryCategoryWrapper _obj= new VideoGalleryCategoryWrapper();
				_obj.CatagoryCode=(cursor.getString(1));
				_obj.CatagoryName=(cursor.getString(2));
				_obj.VideoCount=(cursor.getString(3));
				_obj.Image=(cursor.getString(4));


				array.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

		return array;


	}
	public ArrayList<PictureGalleryGridWrapper> getPGGridList (String query, String[] selectionArgs)
	{	      

		PictureGalleryGridWrapper _obj = new PictureGalleryGridWrapper();
		ArrayList<PictureGalleryGridWrapper> PictureGaleryGridList = new ArrayList<PictureGalleryGridWrapper>();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				_obj= new PictureGalleryGridWrapper();
				_obj.Id=(cursor.getString(1));
				_obj.ImageName=(cursor.getString(2));
				_obj.ImagePath=(cursor.getString(3));
				_obj.ThumbnailPath=(cursor.getString(4));
				_obj.SDescription=(cursor.getString(7));
				_obj.LDescription=(cursor.getString(8));


				PictureGaleryGridList.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

		return PictureGaleryGridList;
	}

	public void getVideoGalleryList (String query, String[] selectionArgs)
	{	      

		VideoGalleryListWrapper _obj = new VideoGalleryListWrapper();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				_obj= new VideoGalleryListWrapper();
				_obj.Id=(cursor.getString(1));
				_obj.Title=(cursor.getString(2));
				_obj.Description=(cursor.getString(3));
				_obj.ImageName=(cursor.getString(4));
				_obj.ImagePath=(cursor.getString(5));
				_obj.VideoUrl=(cursor.getString(6));
				_obj.YoutubeUrl=(cursor.getString(7));


				MyUIApplication.VideoGalleryList.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}


	}

	// This is for Sync Time Wrapper Table
	public SyncTimeWrapper returnSyncTimeWrapper (String query, String[] selectionArgs)
	{	      

		SyncTimeWrapper _obj= new SyncTimeWrapper();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				_obj= new SyncTimeWrapper();
				_obj.Name=(cursor.getString(1));
				_obj.Date_time=(cursor.getString(2));
				_obj.Client_EventCode=(cursor.getString(3));

			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return _obj;
	}


	// This is for Sync Time For Client Code and Event Code Xml Wrapper Table
	public SyncForXmlWrapper returnSyncTimeForXmlWrapper (String query, String[] selectionArgs)
	{	      

		SyncForXmlWrapper _obj= new SyncForXmlWrapper();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);	        
		if (cursor.moveToFirst()) {
			do {
				//list = new ArrayList<String>();
				_obj= new SyncForXmlWrapper();
				_obj.ID=(cursor.getString(0));
				_obj.ClientCode=(cursor.getString(1));
				_obj.EventCode=(cursor.getString(2));
				_obj.Date_time=(cursor.getString(3));

			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return _obj;
	}


	/*
	 *    Method for Add Buttons in Section List  According to type(Section) 
	 */
	public void getMenuSectionList(String query, String[] selectionArgs) {

		ArrayList<MenuWrapper> myTemplist = new ArrayList<MenuWrapper>();

		MenuWrapper _obj = new MenuWrapper();
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) 
		{
			do 
			{

				_obj = new MenuWrapper();

				_obj.id = (cursor.getString(0));
				_obj.title = (cursor.getString(6));
				_obj.imageName = cursor.getString(7);

				myTemplist.add(_obj);
			} 
			while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed())
		{
			cursor.close();
		}
		MyUIApplication.sectionList.add(myTemplist);
		System.out.println(MyUIApplication.sectionList.size());
		myTemplist = null;
	}


	/*
	 *  Type
	 */
	public void getTypeOfSection(String query, String[] selectionArgs) {
		MyUIApplication.TypeWisesectionList = null;
		MyUIApplication.TypeWisesectionList = new ArrayList<String>();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				MyUIApplication.TypeWisesectionList.add(cursor.getString(0));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

	}

	// Show Update get
	public void getUpdate(String query, String[] selectionArgs) {
		MyUIApplication._objShow_UpdatesNew = null;
		MyUIApplication._objShow_UpdatesNew = new ArrayList<ShowUpdatesWrapper>();

		ShowUpdatesWrapper _obj = new ShowUpdatesWrapper();
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				_obj = new ShowUpdatesWrapper();
				/*
				 * _obj.setUniqueID(cursor.getString(1));
				 * _obj.setThumbURL(cursor.getString(2));
				 * _obj.setCoverImgURL(cursor.getString(3));
				 * 
				 * _obj.setThumbIMG(cursor.getBlob(4));
				 */

				_obj.Name_id = (cursor.getString(0));
				_obj.id = (cursor.getString(1));
				_obj.title = (cursor.getString(2));
				_obj.description = cursor.getString(3);
				_obj.ShowDate = (cursor.getString(4));
				_obj.ReadOrUnRead = (cursor.getString(5));

				MyUIApplication._objShow_UpdatesNew.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
	}
	public void getShowUpdatesDate(String query, String[] selectionArgs) {
		MyUIApplication._objDateShowUpdateList = null;
		MyUIApplication._objDateShowUpdateList = new ArrayList<String>();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				MyUIApplication._objDateShowUpdateList.add(cursor.getString(0));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

	}
	
	/*****KD_03/02/2014**************/
	public Cursor rawQuery(String query, String[] selectionArgs){
		return myDataBase.rawQuery(query, selectionArgs);
	}
	
	public void getShowUpdateDate(String query, String[] selectionArgs) {

		ArrayList<ShowUpdatesWrapper> myTemplist = new ArrayList<ShowUpdatesWrapper>();

		ShowUpdatesWrapper _obj = new ShowUpdatesWrapper();
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				_obj = new ShowUpdatesWrapper();
				/*
				 * _obj.setUniqueID(cursor.getString(1));
				 * _obj.setThumbURL(cursor.getString(2));
				 * _obj.setCoverImgURL(cursor.getString(3));
				 * 
				 * _obj.setThumbIMG(cursor.getBlob(4));
				 */

				_obj.Name_id = (cursor.getString(0));
				_obj.id = (cursor.getString(1));
				_obj.title = (cursor.getString(2));
				_obj.description = cursor.getString(3);
				_obj.ShowDate = (cursor.getString(4));
				_obj.ReadOrUnRead = (cursor.getString(6));
				_obj.ImageUrl = (cursor.getString(cursor.getColumnIndex("ImageUrl")));
				_obj.Link = (cursor.getString(cursor.getColumnIndex("Link")));
				_obj.instance = (cursor.getString(cursor.getColumnIndex("instance")));

				myTemplist.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		MyUIApplication._objShowUpdateList.add(myTemplist);
		System.out.println(MyUIApplication._objShowUpdateList.size());
		myTemplist = null;

	}
	public ArrayList<ShowUpdatesWrapper> getShowUpdateFiler(String query, String[] selectionArgs) {

		ArrayList<ShowUpdatesWrapper> myTemplist = new ArrayList<ShowUpdatesWrapper>();

		ShowUpdatesWrapper _obj = new ShowUpdatesWrapper();
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				_obj = new ShowUpdatesWrapper();
				/*
				 * _obj.setUniqueID(cursor.getString(1));
				 * _obj.setThumbURL(cursor.getString(2));
				 * _obj.setCoverImgURL(cursor.getString(3));
				 * 
				 * _obj.setThumbIMG(cursor.getBlob(4));
				 */

				_obj.Name_id = (cursor.getString(0));
				_obj.id = (cursor.getString(1));
				_obj.title = (cursor.getString(2));
				_obj.description = cursor.getString(3);
				_obj.ShowDate = (cursor.getString(4));
				_obj.ReadOrUnRead = (cursor.getString(6));

				myTemplist.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return myTemplist;
	}


	// For Exhibitor List
	public void getMyExhiList(String query, String[] selectionArgs) {
		MyUIApplication._objExhibitorDirectoryList = null;
		MyUIApplication._objExhibitorDirectoryList = new ArrayList<ExhibitorDirectoryWrapper>();

		ExhibitorDirectoryWrapper _obj = new ExhibitorDirectoryWrapper();
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				_obj = new ExhibitorDirectoryWrapper();
				/*
				 * _obj.setUniqueID(cursor.getString(1));
				 * _obj.setThumbURL(cursor.getString(2));
				 * _obj.setCoverImgURL(cursor.getString(3));
				 * 
				 * _obj.setThumbIMG(cursor.getBlob(4));
				 */

				_obj.Name_id = (cursor.getString(0));
				_obj.exhibitor_id = (cursor.getString(1));
				_obj.name = (cursor.getString(2));
				_obj.contact_person = (cursor.getString(3));
				_obj.boothList = new ArrayList<String>();
				_obj.boothList.add(cursor.getString(4));
				_obj.boothList.add(cursor.getString(5));
				_obj.boothList.add(cursor.getString(6));
				_obj.boothList.add(cursor.getString(7));
				_obj.boothList.add(cursor.getString(8));
				_obj.boothList.add(cursor.getString(9));
				_obj.boothList.add(cursor.getString(10));
				_obj.boothList.add(cursor.getString(11));
				_obj.hall = (cursor.getString(12));
				_obj.zone_no = (cursor.getString(13));
				_obj.exhibitor_type = (cursor.getString(14));
				_obj.section = (cursor.getString(15));
				_obj.phone = (cursor.getString(16));
				_obj.email = (cursor.getString(17));
				_obj.Favourites = (cursor.getString(19));
				_obj.Visited = (cursor.getString(20));
				_obj.address = (cursor.getString(21));
				_obj.CategoryCode = (cursor.getString(cursor.getColumnIndex("CategoryCode")));
				_obj.CategoryName = (cursor.getString(cursor.getColumnIndex("CategoryName")));
				//				System.out.println(_obj.email);

				MyUIApplication._objExhibitorDirectoryList.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

	}


	// Events DB Action Handle
	public void getEventsSectionList(String query, String[] selectionArgs) {

		ArrayList<EventsWrapper> myTemplist = new ArrayList<EventsWrapper>();

		EventsWrapper _obj = new EventsWrapper();
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				_obj = new EventsWrapper();

				_obj.Name_id = (cursor.getString(0));
				_obj.id = (cursor.getString(1));
				_obj.Title = (cursor.getString(2));
				_obj.Description = cursor.getString(3);
				_obj.Day = cursor.getString(4);
				_obj.Locations = cursor.getString(5);
				_obj.Fees = cursor.getString(6);
				_obj.Language = cursor.getString(7);
				_obj.time = cursor.getString(8);
				_obj.date_time = (cursor.getString(9));
				_obj.Last_Modify = (cursor.getString(10));
				_obj.Attended  = (cursor.getString(11));

				myTemplist.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		MyUIApplication._objEventSectionList.add(myTemplist);
		myTemplist = null;

	}
	// Method For Getting ArrayList<EventsWrapper> _objEventsWrapperList 
	public void getEvents(String query, String[] selectionArgs) {
		MyUIApplication._objEventsWrapperList = null;
		MyUIApplication._objEventsWrapperList = new ArrayList<EventsWrapper>();

		EventsWrapper _obj = new EventsWrapper();
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				_obj = new EventsWrapper();
				/*
				 * _obj.setUniqueID(cursor.getString(1));
				 * _obj.setThumbURL(cursor.getString(2));
				 * _obj.setCoverImgURL(cursor.getString(3));
				 * 
				 * _obj.setThumbIMG(cursor.getBlob(4));
				 */

				_obj.Name_id = (cursor.getString(0));
				_obj.id = (cursor.getString(1));
				_obj.Title = (cursor.getString(2));
				_obj.Description = cursor.getString(3);
				_obj.Day = cursor.getString(4);
				_obj.Locations = cursor.getString(5);
				_obj.Fees = cursor.getString(6);
				_obj.Language = cursor.getString(7);
				_obj.time = cursor.getString(8);
				_obj.date_time = (cursor.getString(9));
				_obj.Last_Modify = (cursor.getString(10));
				_obj.Attended  = (cursor.getString(11));

				MyUIApplication._objEventsWrapperList.add(_obj);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
	}
	// Method For Getting Event Attended or Not 
	public String getEventsAttended(String query, String[] selectionArgs) {

		String Atttended = "";
		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {
				Atttended  = (cursor.getString(0));

			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return Atttended;
	}

	public void getEventTimeList(String query, String[] selectionArgs) {
		MyUIApplication._objEventTimeList = null;
		MyUIApplication._objEventTimeList = new ArrayList<String>();

		Cursor cursor = myDataBase.rawQuery(query, selectionArgs);
		if (cursor.moveToFirst()) {
			do {

				MyUIApplication._objEventTimeList.add(cursor.getString(0));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

	}

}
