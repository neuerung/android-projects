package mobi.neuerung.Parser;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ExhibitorDirectoryWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;


public class ExhibitorDirectoryParser extends DefaultHandler {

	String buffer;
	Context context;
	public ExhibitorDirectoryParser(Context context) {
		// TODO Auto-generated constructor stub
		//		MyUIApplication._objExhibitorDirectoryList=null;

		this.context=context;
		
//		if(context instanceof ExhibitorDirectory)
//			((ExhibitorDirectory)context).isNeedUpdated=false;

	}
	ExhibitorDirectoryWrapper _obj;
	@Override
	public void characters(char[] ch, int start, int length)
	throws SAXException {
		// TODO Auto-generated method stub
	//	buffer="";
		buffer+=new String(ch, start, length);
		
	}
	String Tag;
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		buffer="";
	//	Log.i("From ExhibitorDirectoryParser Parser ", "Start Elemnt");
		if(localName.equals("exhibitors_directory"))
		{
			String updatetimestamp=(attributes.getValue("updatetimestamp"));
//			MyUIApplication.zone_manegerdatetime=(atts.getValue("datetime"));
			/** Send URL to parse XML Tags */
			
			
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("ExhibitorDirectory");
			if(_obj.Date_time==null ||_obj.Date_time.equals("NaN"))
			{
				_obj.Name="ExhibitorDirectory";
				_obj.Date_time=updatetimestamp;
				MyUIApplication._objSyncTimeDB.insertRecords(_obj);
			}
			else
			{
				_obj.Name="ExhibitorDirectory";
				_obj.Date_time=updatetimestamp;
				MyUIApplication._objSyncTimeDB.updateTable(_obj);
			}
				
			_obj=null;

		}
		if(localName.equals("booth"))
		{
			_obj=null;
			_obj = new ExhibitorDirectoryWrapper();
		}
		if(localName.equals("booth_nos"))
		{
			_obj.boothList=null;
			_obj.boothList = new ArrayList<String>();
		}
		if(localName.equals("New"))
		{
			Tag="new";
		}
		if(localName.equals("Update"))
		{
			Tag="update";
		}
		if(localName.equals("Delete"))
		{
			Tag="delete";
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
	throws SAXException {
		// TODO Auto-generated method stub

		if(localName.equals("booth"))
		{

			if(Tag.equals("new"))
			{
				MyUIApplication._objMyExhiDB.insertRecords(_obj);
			}
			if(Tag.equals("update"))
			{
				MyUIApplication._objMyExhiDB.updateexhiRecords(_obj,_obj.exhibitor_id);
			}
			if(Tag.equals("delete"))
			{
				String delid=_obj.exhibitor_id;
				MyUIApplication._objMyExhiDB.deleteRecordfromexhi(delid);
			}
			//			MyUIApplication._objExhibitorDirectoryList.add(_obj);


		}
		if(localName.equals("id"))
		{
			_obj.exhibitor_id=buffer;
//			if(context instanceof ExhibitorDirectory)
//				((ExhibitorDirectory)context).isNeedUpdated=true;
		//	Log.i("exhibitor_id", buffer);
			buffer="";
		}
		if(localName.equals("name"))
		{
			_obj.name=buffer;
		//	Log.i("name", buffer);
			buffer="";
		}
		if(localName.equals("contact_person"))
		{
			_obj.contact_person=buffer;

		//	Log.i("contact_person", buffer);
			buffer="";
		}
		if(localName.equals("hall"))
		{
			_obj.hall=buffer;
		//	Log.i("hall", buffer);
			buffer="";
		}
		if(localName.equals("zone_no"))
		{
			_obj.zone_no=buffer;
		//	Log.i("url", buffer);
			buffer="";
		}

		if(localName.equals("exhibitor_type"))
		{
			_obj.exhibitor_type=buffer;
		//	Log.i("group", buffer);
			buffer="";
		}
		if(localName.equals("section"))
		{
			_obj.section=buffer;
		//	Log.i("section", buffer);
			buffer="";
		}
		if(localName.equals("address"))
		{
			_obj.address=buffer;
			//	Log.i("section", buffer);
			buffer="";
		}
		if(localName.equals("mobile"))
		{
			_obj.phone=buffer;
		//	Log.i("phone", buffer);
			buffer="";
		}
		if(localName.equals("email"))
		{
			_obj.email=buffer;
			buffer="";
		}
		if(localName.equals("exhibitor_image"))
		{
			_obj.exhibitor_image=buffer;
			buffer="";
		}

		if(localName.equals("CategoryCode"))
		{
			_obj.CategoryCode=buffer;
			buffer="";
		}
		if(localName.equals("CategoryName"))
		{
			_obj.CategoryName=buffer;
			buffer="";
		}
		if(localName.equals("booth_no"))
		{
			_obj.boothList.add(buffer);
		//	Log.i("booth_no", buffer);
			buffer="";
		}
		if(localName.equals("new"))
		{
			Tag="";
		}
		if(localName.equals("update"))
		{
			Tag="";
		}
		if(localName.equals("delete"))
		{
			Tag="";
		}



	}



}
