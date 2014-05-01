package mobi.neuerung.ScreenParser;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SyncTimeWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SyncHtmlParser extends DefaultHandler
{
	private String localName = "";
	String buffer="";

	SyncTimeWrapper _objSyncTimeWrapper;
	String Name="";

	public SyncHtmlParser(String Name)
	{
		this.Name=Name;
	}
	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		buffer="";

		if(localName.equals("HTMLPages"))
		{
			_objSyncTimeWrapper=null;
			_objSyncTimeWrapper=new SyncTimeWrapper();
			_objSyncTimeWrapper.Date_time=(atts.getValue("updatetimestamp"));
			
						
			MyUIApplication.HTMLScreenFileName="";
			MyUIApplication.HTMLScreenFilePath="";
		}


		this.localName = localName;
		System.out.println("PARSER is of HomeScreen  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 

		if(localName.equals("FileName"))
		{
			MyUIApplication.HTMLScreenFileName=buffer;
			_objSyncTimeWrapper.Name=buffer;
			String s=MyUIApplication.HTMLScreenFileName;
			System.out.println(s);
		}
		if(localName.equals("FilePath"))
		{
			
			
			MyUIApplication.HTMLScreenFilePath=buffer;
			String s=MyUIApplication.HTMLScreenFilePath;
			
			SyncTimeWrapper _obj =	MyUIApplication._objSyncTimeDB.getSyncTimeWrapper(_objSyncTimeWrapper.Name);

			if(_obj !=null && _obj.Date_time !=null)
			{
				MyUIApplication._objSyncTimeDB.updateTable(_objSyncTimeWrapper);
			}
			else
			{
				MyUIApplication._objSyncTimeDB.insertRecords(_objSyncTimeWrapper);
			}
			
		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}
