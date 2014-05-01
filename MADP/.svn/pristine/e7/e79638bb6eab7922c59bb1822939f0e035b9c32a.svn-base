package mobi.neuerung.Parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SyncTimeWrapper;
import mobi.neuerung.Wrapper.VideoGalleryCategoryWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;


public class VideoGalleryCategoryParser extends DefaultHandler {

	String buffer="";
	ArrayList<VideoGalleryCategoryWrapper> array= new ArrayList<VideoGalleryCategoryWrapper>();
	VideoGalleryCategoryWrapper _objWrapper;
	Context context;
	String PG_updatesdatetime;
	public VideoGalleryCategoryParser(Context context)
	{
		this.context =  context;
	}


	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		buffer="";

		if(localName.equals("VideoGalleryCatagories"))
		{
			PG_updatesdatetime=(atts.getValue("updatetimestamp"));
		}

		if(localName.equals("New"))
		{
			array = new ArrayList<VideoGalleryCategoryWrapper>();
		}
		if(localName.equals("Update"))
		{
			array = new ArrayList<VideoGalleryCategoryWrapper>();
		}
		if(localName.equals("Delete"))
		{
			array = new ArrayList<VideoGalleryCategoryWrapper>();
		}

		if(localName.equals("Catagory"))
		{
			_objWrapper = null;
			_objWrapper = new VideoGalleryCategoryWrapper();

		}
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 


		if(localName.equals("VideoGalleryCatagories"))
		{
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("VideoGalleryCatagories"+"_"+MyUIApplication.globel_instance);
			if(_obj.Date_time==null || _obj.Date_time.equals("NaN") )
			{
				_obj.Name="VideoGalleryCatagories"+"_"+MyUIApplication.globel_instance;
				_obj.Date_time=PG_updatesdatetime;
				MyUIApplication._objSyncTimeDB.insertRecords(_obj);
			}
			else
			{
				_obj.Name="VideoGalleryCatagories"+"_"+MyUIApplication.globel_instance;
				_obj.Date_time=PG_updatesdatetime;
				MyUIApplication._objSyncTimeDB.updateTable(_obj);
			}
		}


		if(localName.equals("CatagoryCode"))
		{
			Log.i(localName, buffer);
			_objWrapper.CatagoryCode = buffer;
		}
		if(localName.equals("CatagoryName"))
		{
			_objWrapper.CatagoryName = buffer;
		}

		if(localName.equals("VideoCount"))
		{
			Log.i(localName, buffer);
			_objWrapper.VideoCount = buffer;
		}

		if(localName.equals("Image"))
		{
			if(buffer.trim().length()>0)
			{
				try {
					int i = buffer.lastIndexOf("/");

					String imageName =buffer.substring(i+1,buffer.length());
					_objWrapper.Image = imageName;
					LoadImageFromWebOperations(buffer, imageName);
				} catch (Exception e) {
					// TODO: handle exception
					_objWrapper.Image = buffer;
				}
			}
			else
			{
				_objWrapper.Image = buffer;
			}
		}
		if(localName.equals("Catagory"))
		{
			array.add(_objWrapper);
		}

		if(localName.equals("New"))
		{
			MyUIApplication._objVideoGalleryDB.insertRecords(array);
		}
		if(localName.equals("Update"))
		{
			MyUIApplication._objVideoGalleryDB.updateTable(array);
		}
		if(localName.equals("Delete"))
		{
			MyUIApplication._objVideoGalleryDB.deleteRecord(array);
		}

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}


	public static Bitmap LoadImageFromWebOperations(String url,String imageName) {
		try {

			Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());

			String root = Environment.getExternalStorageDirectory().toString();
			File myDir = new File(root + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/VideoGalleryCategory");    
			myDir.mkdirs();

			String fname = imageName;
			File file = new File (myDir, fname);
			if (file.exists ()) file.delete (); 
			try {
				FileOutputStream out = new FileOutputStream(file);
				bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}


			return bitmap;
		} catch (Exception e) {
			return null;
		}
	}

}

