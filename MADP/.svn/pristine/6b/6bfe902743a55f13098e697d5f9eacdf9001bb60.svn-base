package mobi.neuerung.Parser;

import mobi.neuerung.MADP.Home;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.util.Log;


public class AdvertisementParser extends DefaultHandler {

	private String localName = "";
	String buffer="";
	Context context;
	String forParser="";
	public AdvertisementParser(Context context,String forParser)
	{
		this.context =  context;
		this.forParser = forParser;
	}


	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		buffer="";

		if(localName.equals("adversitement"))
		{
		}

		if(localName.equals("elements"))
		{
		}

		this.localName = localName;
		System.out.println("PARSER is of Advertisement Switcher "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 


		if(localName.equals("images"))
		{

			Log.i(localName, buffer);
			if(forParser.equals("AutoSwitcher"))
			{
				((Home)context)._objUtilAdvertisementSwitcher.imagesName = buffer;
			}
			
			if(forParser.equals("ManualSwitcher"))
			{
				((Home)context)._objUtilAdvertisementManualSwitcher.imagesName = buffer;
			}
			
		}
		if(localName.equals("urls"))
		{
			if(forParser.equals("AutoSwitcher"))
			{
				((Home)context)._objUtilAdvertisementSwitcher.imagesUrls = buffer;
			}
			
			if(forParser.equals("ManualSwitcher"))
			{
				((Home)context)._objUtilAdvertisementManualSwitcher.imagesUrls = buffer;
			}
			
		}

		if(localName.equals("adversitement"))
		{
			if(forParser.equals("AutoSwitcher"))
			{
				((Home)context)._objUtilAdvertisementSwitcher.setImageInAdver(context);
			}

			if(forParser.equals("ManualSwitcher"))
			{
				((Home)context)._objUtilAdvertisementManualSwitcher.setImageInAdver(context);
			}
			
		}

		//		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}

