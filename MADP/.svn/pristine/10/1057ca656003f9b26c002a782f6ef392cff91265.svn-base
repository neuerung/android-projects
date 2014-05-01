package mobi.neuerung.ScreenParser;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SplashOWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;



public class Splash0Parser extends DefaultHandler
{
	private String localName = "";
	String buffer="";

	SplashOWrapper _objSplashOWrapper;
	Context context;

	public ArrayList<SplashOWrapper> _objClientList;

	public Splash0Parser(Context context)
	{
		this.context=context;
	}

	String updatetimestamp="";

	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		buffer="";

		if(localName.equals("Clients"))
		{
			_objClientList = new ArrayList<SplashOWrapper>();

			updatetimestamp = atts.getValue("updatetimestamp");
		}
		if(localName.equals("Client"))
		{
			_objSplashOWrapper=null;
			_objSplashOWrapper=new SplashOWrapper();
		}

		if(localName.equals("New"))
		{
			_objClientList = new ArrayList<SplashOWrapper>();
		}
		if(localName.equals("Update"))
		{
			_objClientList = new ArrayList<SplashOWrapper>();
		}
		if(localName.equals("Delete"))
		{
			_objClientList = new ArrayList<SplashOWrapper>();
		}

		this.localName = localName;
		System.out.println("PARSER is of HomeScreen  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 

		if(localName.equals("SNo"))
		{
			MyUIApplication.HTMLScreenFileName=buffer;
			String s=MyUIApplication.HTMLScreenFileName;
			System.out.println(s);
			_objSplashOWrapper.SNo=buffer;
		}
		if(localName.equals("ClientName"))
		{
			_objSplashOWrapper.ClientName=buffer;
			System.out.println(buffer);
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
		if(localName.equals("EventLogo"))
		{
			_objSplashOWrapper.EventLogo=buffer;
			if(buffer.trim().length()>0)
			getBitmap(buffer, "Event");
			System.out.println(buffer);
		}
		if(localName.equals("ClientLogo"))
		{
			_objSplashOWrapper.ClientLogo=buffer;
			if(buffer.trim().length()>0)
				getBitmap(buffer, "Client");
			System.out.println(buffer);
		}

		if(localName.equals("APIKey"))
		{
			_objSplashOWrapper.APIKey=buffer;
			System.out.println(buffer);
		}
		if(localName.equals("Client"))
		{
			//			((Splash0)context)._objClientList.add(_objSplashOWrapper);
			_objClientList.add(_objSplashOWrapper);
			System.out.println("Size => "+_objClientList.size());
			System.out.println(buffer);
		}

		if(localName.equals("New"))
		{
			MyUIApplication._objClientEventDB.insertRecords(_objClientList);
		}
		if(localName.equals("Update"))
		{
			MyUIApplication._objClientEventDB.updateRecords(_objClientList);
		}
		if(localName.equals("Delete"))
		{
			MyUIApplication._objClientEventDB.deleteRecords(_objClientList);
		}


		if(localName.equals("Clients"))
		{
			MyUIApplication._objClientEventDB.updateTimeStamp(updatetimestamp);
		}



		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}

	private void getBitmap(String encodedImage,String clicentevent)
	{
		byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
		Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

		String root = Environment.getExternalStorageDirectory().toString();
		File myDir = new File(root + "/"+MyUIApplication.mainDirectoryName+"/ClientEventLogo");    
		myDir.mkdirs();
		String fname="";
		if(clicentevent.equals("Client"))
			fname = _objSplashOWrapper.ClientName;
		else if(clicentevent.equals("Event"))
			fname = _objSplashOWrapper.EventName;
		File file = new File (myDir, fname);
		if (file.exists ()) file.delete (); 
		try {
			FileOutputStream out = new FileOutputStream(file);
			decodedByte.compress(Bitmap.CompressFormat.PNG, 90, out);
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
