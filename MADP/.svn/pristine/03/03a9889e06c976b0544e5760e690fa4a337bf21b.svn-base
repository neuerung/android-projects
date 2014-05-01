package mobi.neuerung.ScreenParser;

import mobi.neuerung.MADP.MyUIApplication;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SyncParser extends DefaultHandler
{
	private String localName = "";
	String buffer="";


	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		buffer="";

		if(localName.equals("Screens"))
		{
			MyUIApplication.Update_Time_Stamp=(atts.getValue("updatetimestamp"));
			MyUIApplication.ScreenFilePath =""; 
			MyUIApplication.ScreenFileName ="";
			
		}

		this.localName = localName;
		System.out.println("PARSER is of HomeScreen  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 

		if(localName.equals("ScreenFileName"))
		{
			MyUIApplication.ScreenFileName=buffer;
			String s=MyUIApplication.ScreenFileName;
			System.out.println(s);
		}
		if(localName.equals("ScreenFilePath"))
		{
			MyUIApplication.ScreenFilePath=buffer;
			String s=MyUIApplication.ScreenFilePath;
			System.out.println(s);
			
		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}
