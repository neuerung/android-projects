package mobi.neuerung.Parser;


import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.EventsWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.util.Log;


public class EventsParser extends DefaultHandler {

	private String localName = "";
	String buffer="";

	/*
	 * to Check whether its new,update or for delete
	 * */
	public String isType;
	public String tag;

	EventsWrapper _objEventsWrapper;
	boolean hasbr = false;
	String des;
	Context context;
	public EventsParser(Context context)
	{
		this.context=context;
	}
	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		//	System.out.println("Events Start Elements");
		if(localName.equals("br"))
		{
			hasbr = true;
			des= des+"\n"+buffer;
			System.out.println("br start" +des);
		}
		buffer="";
		if(localName.equals("events"))
		{
			String eventsdatetime=(atts.getValue("updatetimestamp"));
			//			MyUIApplication.zone_manegerdatetime=(atts.getValue("datetime"));
			/** Send URL to parse XML Tags */


			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("Events");

			if(_obj.Date_time==null  || _obj.Date_time.equals("NaN") )
			{
				_obj.Name="Events";
				_obj.Date_time=eventsdatetime;
				MyUIApplication._objSyncTimeDB.insertRecords(_obj);
			}
			else
			{
				_obj.Name="Events";
				_obj.Date_time=eventsdatetime;
				MyUIApplication._objSyncTimeDB.updateTable(_obj);
			}

			_obj=null;

			//			MyUIApplication._objEventsNew=null;
			//			MyUIApplication._objEventsNew = new ArrayList<EventsWrapper>();
			//			MyUIApplication._objEventsUpdate=null;
			//			MyUIApplication._objEventsUpdate = new ArrayList<EventsWrapper>();
			//			MyUIApplication._objEventsDelete=null;
			//			MyUIApplication._objEventsDelete = new ArrayList<EventsWrapper>();

		}

		if(localName.equals("element"))
		{
			_objEventsWrapper = null;
			_objEventsWrapper = new EventsWrapper();
		}
		if(localName.equals("New"))
		{
			isType="new";
		}
		if(localName.equals("Update"))
		{
			isType="update";
		}
		if(localName.equals("Delete"))
		{
			isType="delete";
		}

		if(localName.equals("Description"))
		{
			hasbr=false;
			des="";
		}

		this.localName = localName;
		System.out.println("PARSER is of Events  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 


		if(localName.equals("br"))
		{
			des= des+buffer;
			System.out.println("br end" +des);
		}
		if(isType.equals("new"))
		{
			if(localName.equals("id"))
			{

				//					((Events)(context)).viewNeedUpdation=true;
				Log.i(localName, buffer);
				_objEventsWrapper.id=buffer;
			}
			if(localName.equals("Title"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Title=buffer;
			}
			if(localName.equals("Description"))
			{
				Log.i(localName, buffer);
				Log.i("description try", des);
				if(hasbr)
					_objEventsWrapper.Description=des+"\n"+buffer;
				else
					_objEventsWrapper.Description=buffer;
			}
			if(localName.equals("Day"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Day=buffer;
			}
			if(localName.equals("Locations"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Locations=buffer;
			}
			if(localName.equals("Fees"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Fees=buffer;
			}
			if(localName.equals("Language"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Language=buffer;
			}
			if(localName.equals("time"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.time=buffer;
			}
			if(localName.equals("date_time"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.date_time=buffer;
			}
			if(localName.equals("element"))
			{
				Log.i(localName, localName);
				MyUIApplication._objEventsDB.insertRecords(_objEventsWrapper);
				_objEventsWrapper=null;
			}
		}
		if(isType.equals("update"))
		{
			if(localName.equals("id"))
			{
				//					((Events)(context)).viewNeedUpdation=true;
				Log.i(localName, buffer);
				_objEventsWrapper.id=buffer;
			}
			if(localName.equals("Title"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Title=buffer;
			}
			if(localName.equals("Description"))
			{
				Log.i(localName, buffer);
				Log.i("description try", des);
				if(hasbr)
					_objEventsWrapper.Description=des+"\n"+buffer;
				else
					_objEventsWrapper.Description=buffer;
			}
			if(localName.equals("Day"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Day=buffer;
			}
			if(localName.equals("Locations"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Locations=buffer;
			}
			if(localName.equals("Fees"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Fees=buffer;
			}
			if(localName.equals("Language"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.Language=buffer;
			}
			if(localName.equals("time"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.time=buffer;
			}
			if(localName.equals("date_time"))
			{
				Log.i(localName, buffer);
				_objEventsWrapper.date_time=buffer;
			}
			if(localName.equals("element"))
			{
				Log.i(localName, localName);
				MyUIApplication._objEventsDB.updateTable(_objEventsWrapper);
				//		MyUIApplication._objEvents_SeminarDB.insertRecords(_objEvents_Seminars_Wrapper);
				_objEventsWrapper=null;
			}
		}
		if(isType.equals("delete"))
		{
			if(localName.equals("id"))
			{
				//					((Events)(context)).viewNeedUpdation=true;
				Log.i(localName, buffer);
				_objEventsWrapper.id=buffer;
			}
			if(localName.equals("element"))
			{
				Log.i(localName, localName);
				MyUIApplication._objEventsDB.deleteRecord(_objEventsWrapper.id);
				//		MyUIApplication._objEvents_SeminarDB.insertRecords(_objEvents_Seminars_Wrapper);
				_objEventsWrapper=null;
			}
		}

		this.localName = "";
	}

	public void characters(char ch[], int start, int length) { 
		buffer+=new String(ch, start, length);
	}
}

