package mobi.neuerung.db.dbhelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import mobi.neuerung.Wrapper.PushNotificationWrapper;
import mobi.neuerung.db.DBAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class PushNotificationDB {
	public DBAdapter dbAdapter=null;
	Context view;
	private final static String TABLE_NAME	=	"push_notiication";


	public PushNotificationDB( DBAdapter dbAdapter)
	{
		this.dbAdapter=dbAdapter;

	}


	public int insertRecords(PushNotificationWrapper _obj)
	{
		long id = 0;
		//		for(int i=0;i<array.size();i++)
		//		{
		ContentValues initialValues = new ContentValues();
		initialValues.put("title", _obj.title );
		initialValues.put("message", _obj.message );
		initialValues.put("incoming_date",_obj.date);

		id = dbAdapter.insertRecordsInDB(TABLE_NAME, null, initialValues);				
		//		}

		return (int) id;
	}

	public ArrayList<PushNotificationWrapper> retriveRecords(){
		Cursor cursor	= dbAdapter.selectRecordsFromDB(TABLE_NAME, null, null, null, null, null, null);

		ArrayList<PushNotificationWrapper> _objList	=	new ArrayList<PushNotificationWrapper>();

		PushNotificationWrapper _obj;

		if(cursor.getCount()>0){
			if(cursor.moveToFirst()){
				do{
					_obj	=	new PushNotificationWrapper();
					_obj.PID = cursor.getString(cursor.getColumnIndex("PID"));
					_obj.title = cursor.getString(cursor.getColumnIndex("title"));
					_obj.message = cursor.getString(cursor.getColumnIndex("title"));
					_obj.date = cursor.getString(cursor.getColumnIndex("incoming_date"));

					_objList.add(_obj);

				}while(cursor.moveToNext());
			}
		}

//		sortByDate(_objList);

		return _objList;
	}

	/***Retrive Distinct notification date in order*/
	public ArrayList<String> retriveNotificationDate(){
		String  query = "SELECT trim(SUBSTR(incoming_date ,0,11)) FROM "+TABLE_NAME+" group by SUBSTR(date_time ,0,11) order by SUBSTR(date_time ,0,11) desc";
		Cursor cursor	=	dbAdapter.rawQuery(query, null);

		ArrayList<String> notification_date	=	new ArrayList<String>();
		if (cursor.moveToFirst()) {
			do {

				notification_date.add(cursor.getString(0));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return sortByDate(notification_date);
	}
	
	public void retriveRecordsByDate(String date){
		
	}

	public ArrayList<String> sortByDate(ArrayList<String> _objList){
		ArrayList<Date> temp	=	new ArrayList<Date>();

		SimpleDateFormat formate= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		for(int i=0; _objList.size()>i; i++){

			try {
				Date date = formate.parse(_objList.get(i));
				temp.add(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}


		//Sorting
		Collections.sort(temp, new Comparator<Date>() {
			public int compare(Date lhs, Date rhs) {
				if (lhs.getTime() < rhs.getTime())
					return -1;
				else if (lhs.getTime() == rhs.getTime())
					return 0;
				else
					return 1;
			}
		});

				_objList.clear();
//		int size	=	_objList.size();
		for(int i=temp.size(); 0<i; i--){
			_objList.add(formate.format(temp.get(i-1)));
		}
		return _objList;
	}
}
