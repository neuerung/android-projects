package mobi.neuerung.Parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.PictureGalleryCategoryWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;


public class PictureGalleryCategoryParser extends DefaultHandler {

	private String localName = "";
	String buffer="";
	ArrayList<PictureGalleryCategoryWrapper> array = new ArrayList<PictureGalleryCategoryWrapper>();
	public String tag;
	PictureGalleryCategoryWrapper _objWrapper;
	Context context;
	boolean hasbr = false;

	public PictureGalleryCategoryParser(Context context)
	{
		this.context =  context;
	}

	String PG_updatesdatetime;
	public void startElement(String namespaceURI, String localName, 
			String qName, Attributes atts) throws SAXException { 

		buffer="";

		if(localName.equals("PictureGalleryCatagories"))
		{
			PG_updatesdatetime=(atts.getValue("updatetimestamp"));
		}

		if(localName.equals("Catagory"))
		{
			_objWrapper = null;
			_objWrapper = new PictureGalleryCategoryWrapper();

		}
		if(localName.equals("New"))
		{
			array = new ArrayList<PictureGalleryCategoryWrapper>();
		}
		if(localName.equals("Update"))
		{
			array = new ArrayList<PictureGalleryCategoryWrapper>();
		}
		if(localName.equals("Delete"))
		{
			array = new ArrayList<PictureGalleryCategoryWrapper>();
		}


		this.localName = localName;
		System.out.println("PARSER is of Picture Gallery Category "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 

		
			if(localName.equals("CatagoryCode"))
			{
				_objWrapper.CatagoryCode = buffer;
			}
			if(localName.equals("CatagoryName"))
			{
				_objWrapper.CatagoryName = buffer;
			}

			if(localName.equals("ImageCount"))
			{
				_objWrapper.ImageCount = buffer;
			}

			if(localName.equals("Image"))
			{
				if(buffer.trim().length()>0)
				{
					try {
						int i = buffer.lastIndexOf("/");
//						int ii = buffer.lastIndexOf(".");
						
						String imageName =buffer.substring(i+1,buffer.length());
						_objWrapper.Image = imageName;
						LoadImageFromWebOperations(buffer, imageName);
					} catch (Exception e) {
						e.printStackTrace();
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
				MyUIApplication._objPictureGalleryDB.insertRecords(array);
			}
			if(localName.equals("Update"))
			{
				MyUIApplication._objPictureGalleryDB.updateTable(array);
			}
			if(localName.equals("Delete"))
			{
				MyUIApplication._objPictureGalleryDB.deleteRecord(array);
			}
		
		if(localName.equals("PictureGalleryCatagories"))
		{
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("PictureGalleryCatagories_"+MyUIApplication.globel_instance);
			if(_obj.Date_time==null || _obj.Date_time.equals("NaN") )
			{
				_obj.Name="PictureGalleryCatagories_"+MyUIApplication.globel_instance;
				_obj.Date_time=PG_updatesdatetime;
				MyUIApplication._objSyncTimeDB.insertRecords(_obj);
			}
			else
			{
				_obj.Name="PictureGalleryCatagories_"+MyUIApplication.globel_instance;
				_obj.Date_time=PG_updatesdatetime;
				MyUIApplication._objSyncTimeDB.updateTable(_obj);
			}
		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
	
	
	public static Bitmap LoadImageFromWebOperations(String url,String imageName) {
	    try {
	    	url=url.replaceAll(" ", "%20");
	    	 Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());
	    	 
//	    	 int i = url.lastIndexOf("/");
//				int ii = url.lastIndexOf(".");
//				
//				String imageName =url.substring(i+1,ii);
				
				String root = Environment.getExternalStorageDirectory().toString();
				File myDir = new File(root + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryCategory");    
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
	    	e.printStackTrace();
	        return null;
	    }
	}
}

