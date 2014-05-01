package mobi.neuerung.Parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ShowUpdatesWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;


public class ShowUpdatesParser extends DefaultHandler {

	private String localName = "";
	String buffer="";

	public String tag;
	public String tagItem;
	String isType;
	ShowUpdatesWrapper _objNew;
	ShowUpdatesWrapper _objUpdate;
	ShowUpdatesWrapper _objDelete;
	boolean forbadge;
	Context context;
	boolean hasbr = false;
	public ShowUpdatesParser(Context context,boolean forbadge)
	{
		this.forbadge = forbadge;
		this.context =  context;
	}

	String des;

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

		if(localName.equals("ShowUpdates"))
		{
			String show_updatesdatetime=(atts.getValue("updatetimestamp"));

			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("showupdate_"+MyUIApplication.globel_instance+"_"+"All");
			String url="";
			if(_obj.Date_time==null || _obj.Date_time.equals("NaN") )
			{
				_obj.Name="showupdate_"+MyUIApplication.globel_instance+"_"+"All";
				_obj.Date_time=show_updatesdatetime;
				MyUIApplication._objSyncTimeDB.insertRecords(_obj);
			}
			else
			{
				_obj.Name="showupdate_"+MyUIApplication.globel_instance+"_"+"All";
				_obj.Date_time=show_updatesdatetime;
				MyUIApplication._objSyncTimeDB.updateTable(_obj);
			}

		}

		if(localName.equals("element"))
		{
			_objNew = null;
			_objNew = new ShowUpdatesWrapper();

		}
		if(localName.equals("New"))
		{
			isType="new";
		}
		if(localName.equals("Update"))
		{
			isType="update";
		}
		if(localName.equals("Delete"))
		{
			isType="delete";
		}

		if(localName.equals("description"))
		{
			hasbr=false;
			des="";
		}
		this.localName = localName;
		System.out.println("PARSER is of Visitor  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 

		if(localName.equals("br"))
		{
			des= des+buffer;
			System.out.println("br end" +des);
		}



		if(isType.equals("new"))
		{
			if(localName.equals("CategoryCode"))
			{
				Log.i(localName, buffer);
				_objNew.CatagoryCode=buffer;
			}
			if(localName.equals("id"))
			{
				Log.i(localName, buffer);
				_objNew.id=buffer;
			}
			if(localName.equals("Title"))
			{
				Log.i(localName, buffer);
				_objNew.title=buffer;
			}
			if(localName.equals("Description"))
			{
				if(hasbr)
					_objNew.description=des+"\n"+buffer;
				else
					_objNew.description=buffer;
			}

			if(localName.equals("ShowDate"))
			{
				Log.i(localName, buffer);
				_objNew.ShowDate=buffer;
			}

			if(localName.equals("ImageUrl"))
			{
				if(buffer.trim().length()>0)
				{
					try {
						int i = buffer.lastIndexOf("/");

						String imageName =buffer.substring(i+1,buffer.length());
						_objNew.ImageUrl = imageName;
						LoadImageFromWebOperations(buffer, imageName);
					} catch (Exception e) {
						// TODO: handle exception
						_objNew.ImageUrl = buffer;
					}
				}
				else
				{
					_objNew.ImageUrl = buffer;
				}
			}

			if(localName.equals("Link"))
			{
				Log.i(localName, buffer);
				_objNew.Link=buffer;
			}

			if(localName.equals("element"))
			{
				Log.i(localName, localName);

				MyUIApplication._objShowUpdateDB.insertRecords(_objNew);
				_objNew=null;
			}

		}
		if(isType.equals("update"))
		{
			
			Log.e("Show_Update_Parser", "In update XML");
//			if(localName.equals("CatagoryCode"))
//			{
//				Log.i(localName, buffer);
//				_objNew.CatagoryCode=buffer;
//			}
//			if(localName.equals("id"))
//			{
//
//				Log.i(localName, buffer);
//				_objNew.id=buffer;
//			}
//			if(localName.equals("title"))
//			{
//				Log.i(localName, buffer);
//				_objNew.title=buffer;
//			}
//			if(localName.equals("description"))
//			{
//
//				System.out.println("upadtesssssssssss dessssss"+hasbr+"     "+des);
//				Log.i(localName, buffer);
//				if(hasbr)
//					_objNew.description=des+"\n"+buffer;
//				else
//					_objNew.description=buffer;
//			}
//
//			if(localName.equals("date_time"))
//			{
//				Log.i(localName, buffer);
//				_objNew.ShowDate=buffer;
//			}
//
//			if(localName.equals("ImageUrl"))
//			{
//				if(buffer.trim().length()>0)
//				{
//					try {
//						int i = buffer.lastIndexOf("/");
//
//						String imageName =buffer.substring(i+1,buffer.length());
//						_objNew.ImageUrl = imageName;
//						LoadImageFromWebOperations(buffer, imageName);
//					} catch (Exception e) {
//						// TODO: handle exception
//						_objNew.ImageUrl = buffer;
//					}
//				}
//				else
//				{
//					_objNew.ImageUrl = buffer;
//				}
//
//			}
//			if(localName.equals("Link"))
//			{
//				Log.i(localName, buffer);
//				_objNew.Link=buffer;
//			}
			if(localName.equals("CategoryCode"))
			{
				Log.i(localName, buffer);
				_objNew.CatagoryCode=buffer;
			}
			if(localName.equals("id"))
			{
				Log.i(localName, buffer);
				_objNew.id=buffer;
			}
			if(localName.equals("Title"))
			{
				Log.i(localName, buffer);
				_objNew.title=buffer;
			}
			if(localName.equals("Description"))
			{
				if(hasbr)
					_objNew.description=des+"\n"+buffer;
				else
					_objNew.description=buffer;
			}

			if(localName.equals("ShowDate"))
			{
				Log.i(localName, buffer);
				_objNew.ShowDate=buffer;
			}

			if(localName.equals("ImageUrl"))
			{
				if(buffer.trim().length()>0)
				{
					try {
						int i = buffer.lastIndexOf("/");

						String imageName =buffer.substring(i+1,buffer.length());
						_objNew.ImageUrl = imageName;
						LoadImageFromWebOperations(buffer, imageName);
					} catch (Exception e) {
						// TODO: handle exception
						_objNew.ImageUrl = buffer;
					}
				}
				else
				{
					_objNew.ImageUrl = buffer;
				}
			}

			if(localName.equals("Link"))
			{
				Log.i(localName, buffer);
				_objNew.Link=buffer;
			}
			
			if(localName.equals("element"))
			{
				MyUIApplication.LoggerToSD("Update in Show Update", "");
				Log.e("Show_Update_Parser", "show update is updated");

				MyUIApplication._objShowUpdateDB.updateTable(_objNew);
				_objNew=null;
			}
		}
		if(isType.equals("delete"))
		{
			if(localName.equals("CatagoryCode"))
			{
				Log.i(localName, buffer);
				_objNew.CatagoryCode=buffer;
			}
			if(localName.equals("id"))
			{
				Log.i(localName, buffer);
				_objNew.id=buffer;
			}
			if(localName.equals("element"))
			{
				Log.i(localName, localName);

				MyUIApplication._objShowUpdateDB.deleteRecord(_objNew.id);
				_objNew=null;
			}
		}



		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}


	public Bitmap LoadImageFromWebOperations(String url,String imageName) {
		try {

			Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());

			String root = Environment.getExternalStorageDirectory().toString();
			File myDir = new File(root + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/showUpdate/"+MyUIApplication.showUpdateCategoryCode);    
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

