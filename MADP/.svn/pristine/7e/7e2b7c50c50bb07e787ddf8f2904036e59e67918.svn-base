package mobi.neuerung.Parser;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SpeakerSeminarsWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.util.Log;


public class SpeakerSeminarParser extends DefaultHandler {

	private String localName = "";
	String buffer="";

	public String tag;
	public String tagItem;
	String isType;
	SpeakerSeminarsWrapper _objNew;
	boolean forbadge;
	Context context;
	boolean hasbr = false;

	ArrayList<SpeakerSeminarsWrapper> array;



	public SpeakerSeminarParser(Context context,boolean forbadge)
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

		if(localName.equals("MapSpeaker"))
		{
			show_updatesdatetime=(atts.getValue("updatetimestamp"));


			MyUIApplication._objSpeakerSeminarDB.updateTimestamp(show_updatesdatetime);

		}

		if(localName.equals("element"))
		{
			_objNew = null;
			_objNew = new SpeakerSeminarsWrapper();

		}

		if(localName.equals("New"))
		{
			isType="new";

			array = new ArrayList<SpeakerSeminarsWrapper>();
		}
		if(localName.equals("Update"))
		{
			isType="update";

			array = new ArrayList<SpeakerSeminarsWrapper>();
		}
		if(localName.equals("Delete"))
		{
			isType="delete";

			array = new ArrayList<SpeakerSeminarsWrapper>();
		}

		this.localName = localName;
		System.out.println("PARSER is of Visitor  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 


		
		if(localName.equals("Name"))
		{
			Log.i(localName, buffer);
			_objNew.name=buffer;
		}
		if(localName.equals("Title"))
		{
			_objNew.Title=buffer;
		}
		if(localName.equals("Day"))
		{
			_objNew.Day=buffer;
		}
		if(localName.equals("Description"))
		{
			_objNew.description=buffer;
		}

		if(localName.equals("element"))
		{
			array.add(_objNew);
		}

		if(isType.equals("new") && localName.equals("New"))
		{
			MyUIApplication._objSpeakerSeminarDB.insertRecords(array);
			
			array = null;
			
		}
		if(isType.equals("update") && localName.equals("Update"))
		{

			MyUIApplication._objSpeakerSeminarDB.updateTable(array);
			
			array = null;

		}

		if(isType.equals("delete") && localName.equals("Delete"))
		{

			MyUIApplication._objSpeakerSeminarDB.deleteRecord(array);
			
			array = null;
		}

		if(localName.equals("MapSpeaker"))
		{

			MyUIApplication._objSpeakerSeminarDB.updateTimestamp(show_updatesdatetime);

		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}

