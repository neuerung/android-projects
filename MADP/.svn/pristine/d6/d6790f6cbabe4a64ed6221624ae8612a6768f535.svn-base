package mobi.neuerung.ScreenParser;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SplashOWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;



public class EventListParser extends DefaultHandler
{
	private String localName = "";
	String buffer="";

	SplashOWrapper _objSplashOWrapper;
	Context context;
	
	public ArrayList<SplashOWrapper> _objEventList = new ArrayList<SplashOWrapper>();
	
	public EventListParser(Context context)
	{
		this.context=context;
	}
	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		buffer="";

		if(localName.equals("Events"))
		{
			_objEventList = new ArrayList<SplashOWrapper>();
		}
		if(localName.equals("Event"))
		{
			_objSplashOWrapper=null;
			_objSplashOWrapper=new SplashOWrapper();
		}

		this.localName = localName;
		System.out.println("PARSER is of HomeScreen  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 

		if(localName.equals("SNo"))
		{
			_objSplashOWrapper.SNo=buffer;
		}
		if(localName.equals("ClientName"))
		{
			_objSplashOWrapper.ClientName=buffer;
		}
		if(localName.equals("ClientCode"))
		{
			_objSplashOWrapper.ClientCode=buffer;
			System.out.println(buffer);
		}
		if(localName.equals("EventName"))
		{
			_objSplashOWrapper.EventName=buffer;
			System.out.println(buffer);
		}
		if(localName.equals("EventCode"))
		{
			_objSplashOWrapper.EventCode=buffer;
			System.out.println(buffer);
		}
		if(localName.equals("ImageUrl"))
		{
			_objSplashOWrapper.ImageUrl=buffer;
			System.out.println(buffer);
		}
		if(localName.equals("StartDate"))
		{
			_objSplashOWrapper.StartDate=buffer;
			System.out.println(buffer);
		}
		if(localName.equals("EndDate"))
		{
			_objSplashOWrapper.EndDate=buffer;
			System.out.println(buffer);
		}
		if(localName.equals("Event"))
		{
			_objEventList.add(_objSplashOWrapper);
			System.out.println("Size => "+_objEventList.size());
			System.out.println(buffer);
		}
		
		if(localName.equals("Events"))
		{
			MyUIApplication.EventList = new ArrayList<SplashOWrapper>();
			MyUIApplication.EventList =_objEventList;
		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}
