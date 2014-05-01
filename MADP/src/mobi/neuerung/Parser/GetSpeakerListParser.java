package mobi.neuerung.Parser;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SpeakerWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.util.Log;


public class GetSpeakerListParser extends DefaultHandler {

	private String localName = "";
	String buffer="";

	public String tag;
	public String tagItem;
	String isType;
	SpeakerWrapper _objNew;
	boolean forbadge;
	Context context;
	boolean hasbr = false;

	ArrayList<SpeakerWrapper> array;



	public GetSpeakerListParser(Context context,boolean forbadge)
	{
		this.forbadge = forbadge;
		this.context =  context;
	}

	String des;
	String show_updatesdatetime="";

	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		//	System.out.println("ShowUpdates Start Elements");




		if(localName.equals("br"))
		{
			hasbr = true;
			des= des+"\n"+buffer;
			System.out.println("br start" +des);
		}

		buffer="";

		if(localName.equals("SpeakerList"))
		{
			show_updatesdatetime=(atts.getValue("updatetimestamp"));


			MyUIApplication._objSpeakerListDB.updateTimestamp(show_updatesdatetime);

		}

		if(localName.equals("Speaker"))
		{
			_objNew = null;
			_objNew = new SpeakerWrapper();

		}

		if(localName.equals("New"))
		{
			isType="new";

			array = new ArrayList<SpeakerWrapper>();
		}
		if(localName.equals("Update"))
		{
			isType="update";

			array = new ArrayList<SpeakerWrapper>();
		}
		if(localName.equals("Delete"))
		{
			isType="delete";

			array = new ArrayList<SpeakerWrapper>();
		}

		this.localName = localName;
		System.out.println("PARSER is of Visitor  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 


		if(localName.equals("id"))
		{

			_objNew.id=buffer;
		}
		if(localName.equals("name"))
		{
			Log.i(localName, buffer);
			_objNew.name=buffer;
		}
		if(localName.equals("email"))
		{
			_objNew.email=buffer;
		}
		if(localName.equals("post"))
		{
			_objNew.post=buffer;
		}
		if(localName.equals("companyname"))
		{
			_objNew.companyname=buffer;
		}
		if(localName.equals("description"))
		{
			_objNew.description=buffer;
		}
		if(localName.equals("image"))
		{
			_objNew.image=buffer;
		}


		if(localName.equals("Speaker"))
		{

			array.add(_objNew);
			//				Log.i(localName, localName);
			//
			//				MyUIApplication._objShowUpdateCategoryDB.insertRecords(_objNew);
			//				_objNew=null;
		}

		if(isType.equals("new") && localName.equals("New"))
		{
			MyUIApplication._objSpeakerListDB.insertRecords(array);
			
			array = null;
			
		}
		if(isType.equals("update") && localName.equals("Update"))
		{

			MyUIApplication._objSpeakerListDB.updateTable(array);
			
			array = null;

		}

		if(isType.equals("delete") && localName.equals("Delete"))
		{

			MyUIApplication._objSpeakerListDB.deleteRecord(array);
			//	MyUIApplication._objFAQ_VisitorDB.insertRecords(_objZone_Manager_Wrapper);
			
			array = null;
		}

		if(localName.equals("SpeakerList"))
		{

			MyUIApplication._objSpeakerListDB.updateTimestamp(show_updatesdatetime);

		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}

