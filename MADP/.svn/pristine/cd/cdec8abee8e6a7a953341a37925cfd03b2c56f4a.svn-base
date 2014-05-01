package mobi.neuerung.Parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Util.UtilPictureGalleryGrid;
import mobi.neuerung.Wrapper.PictureGalleryGridWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;



public class PictureGalleryGridParser extends DefaultHandler {

	String buffer = "";
	String CategoryCode = "";
	PictureGalleryGridWrapper _objPictureGrid;
	ArrayList <PictureGalleryGridWrapper> array = new ArrayList<PictureGalleryGridWrapper>();
	Context context;
	boolean hasbr = false;
	String des;

	public PictureGalleryGridParser(Context context,String CategoryCode)
	{
		this.context =  context;
		this.CategoryCode =  CategoryCode;
	}
	String PG_updatesdatetime;
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {

		// System.out.println("ShowUpdatesPage Start Elements");

		buffer = "";

		if (localName.equalsIgnoreCase("PictureGallery"))
		{
			 PG_updatesdatetime=(atts.getValue("updatetimestamp"));
			 
			 SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("PictureGalleryGrid"+CategoryCode+"_"+MyUIApplication.globel_instance);
				if(_obj.Date_time==null || _obj.Date_time.equals("NaN") )
				{
					_obj.Name="PictureGalleryGrid"+CategoryCode+"_"+MyUIApplication.globel_instance;
					_obj.Date_time=PG_updatesdatetime;
					MyUIApplication._objSyncTimeDB.insertRecords(_obj);
				}
				else
				{
					_obj.Name="PictureGalleryGrid"+CategoryCode+"_"+MyUIApplication.globel_instance;
					_obj.Date_time=PG_updatesdatetime;
					MyUIApplication._objSyncTimeDB.updateTable(_obj);
				}
		}
		if(localName.equals("New"))
		{
			array = new ArrayList<PictureGalleryGridWrapper>();
		}
		if(localName.equals("Update"))
		{
			array = new ArrayList<PictureGalleryGridWrapper>();
		}
		if(localName.equals("Delete"))
		{
			array = new ArrayList<PictureGalleryGridWrapper>();
		}

		if (localName.equalsIgnoreCase("Image")) {
			_objPictureGrid = null;
			_objPictureGrid = new PictureGalleryGridWrapper();
		}
	}

	public void endElement(String namespaceURI, String localName, String qName)
	throws SAXException 
	{
			if (localName.equalsIgnoreCase("Id"))
			{
				System.out.println(localName + buffer);
				_objPictureGrid.Id = buffer;
			}
			if (localName.equalsIgnoreCase("ImageName"))
			{
				System.out.println(localName + buffer);
				_objPictureGrid.ImageName = buffer;
			}
			if (localName.equalsIgnoreCase("ImagePath"))
			{
				System.out.println(localName + buffer);	
				_objPictureGrid.ImagePath = buffer;
//				try {
//					int i = buffer.lastIndexOf("/");
//					String imageName =buffer.substring(i+1,buffer.length());
//					_objPictureGrid.ImagePath = imageName;
//					LoadImage(buffer, imageName);
//				} catch (Exception e) {
//					// TODO: handle exception
//					_objPictureGrid.ImagePath =buffer;
//				}
			}
			if (localName.equalsIgnoreCase("ThumbnailPath")) 
			{
				System.out.println(localName + buffer);	
				try {
					int i = buffer.lastIndexOf("/");
					String imageName =buffer.substring(i+1,buffer.length());
					_objPictureGrid.ThumbnailPath = imageName;
					LoadTumbnails(buffer, imageName);
				} catch (Exception e) {
					e.printStackTrace();
					_objPictureGrid.ThumbnailPath =buffer;
				}
				
				
			}
			if (localName.equalsIgnoreCase("SDescription"))
			{
				_objPictureGrid.SDescription = buffer;
			}
			if (localName.equalsIgnoreCase("LDescription"))
			{
				_objPictureGrid.LDescription = buffer;
			}
			if (localName.equalsIgnoreCase("Image"))
			{
				_objPictureGrid.CatagoryCode = CategoryCode;
				array.add(_objPictureGrid);
			}
			
			if(localName.equals("New"))
			{
				MyUIApplication._objPictureGalleryGridDB.insertRecords(array);
			}
			if(localName.equals("Update"))
			{
				MyUIApplication._objPictureGalleryGridDB.updateTable(array);
			}
			if(localName.equals("Delete"))
			{
				MyUIApplication._objPictureGalleryGridDB.deleteRecord(array);
			}
			
			
		if (localName.equalsIgnoreCase("ThumbnailZip"))
		{
			new UtilPictureGalleryGrid().ThumbnailZipPath = buffer;
		}
		if (localName.equalsIgnoreCase("ImageZip"))
		{
			new UtilPictureGalleryGrid().ImageZipPath = buffer;
		}
		
		
		if (localName.equalsIgnoreCase("PictureGallery"))
		{
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("PictureGalleryGrid"+CategoryCode);
			if(_obj.Date_time==null || _obj.Date_time.equals("NaN") )
			{
				_obj.Name="PictureGalleryGrid"+CategoryCode;
				_obj.Date_time=PG_updatesdatetime;
				MyUIApplication._objSyncTimeDB.insertRecords(_obj);
			}
			else
			{
				_obj.Name="PictureGalleryGrid"+CategoryCode;
				_obj.Date_time=PG_updatesdatetime;
				MyUIApplication._objSyncTimeDB.updateTable(_obj);
			}

		}

	}

	public void characters(char ch[], int start, int length) 
	{
		buffer += new String(ch, start, length);
	}


	public Bitmap LoadTumbnails(String url,String imageName) {
		try {
			url=url.replaceAll(" ", "%20");
			Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());

			String root = Environment.getExternalStorageDirectory().toString();
			File myDir = new File(root + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Thumbnails/"+CategoryCode);;    
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
/*
	public Bitmap LoadImage(String url,String imageName) {
		try {
			
			Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());
			
			String root = Environment.getExternalStorageDirectory().toString();
			File myDir = new File(root + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+CategoryCode);;    
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

*/}
