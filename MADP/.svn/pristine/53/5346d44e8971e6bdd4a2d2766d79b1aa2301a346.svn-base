
package mobi.neuerung.Parser;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.SyncTimeWrapper;
import mobi.neuerung.Wrapper.VideoGalleryListWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;



public class VideoGalleryListParser extends DefaultHandler {

	String buffer = "";
	String CategoryCode = "";
	VideoGalleryListWrapper _objVideoGalleryListWrapper;
	Context context;
	boolean hasbr = false;
	String des;
	public String isType;

	public VideoGalleryListParser(Context context,String CategoryCode)
	{
		this.context =  context;
		this.CategoryCode =  CategoryCode;
	}

	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {

		// System.out.println("ShowUpdatesPage Start Elements");

		buffer = "";

		if (localName.equalsIgnoreCase("VideoGallery"))
		{

			String PG_updatesdatetime=(atts.getValue("updatetimestamp"));

			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("VideoGalleryList"+CategoryCode);
			if(_obj.Date_time==null || _obj.Date_time.equals("NaN") )
			{
				_obj.Name="VideoGalleryList"+CategoryCode;
				_obj.Date_time=PG_updatesdatetime;
				MyUIApplication._objSyncTimeDB.insertRecords(_obj);
			}
			else
			{
				_obj.Name="VideoGalleryList"+CategoryCode;
				_obj.Date_time=PG_updatesdatetime;
				MyUIApplication._objSyncTimeDB.updateTable(_obj);
			}

		}

		if (localName.equalsIgnoreCase("Video")) {
			_objVideoGalleryListWrapper = null;
			_objVideoGalleryListWrapper = new VideoGalleryListWrapper();

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


	}

	public void endElement(String namespaceURI, String localName, String qName)
	throws SAXException 
	{
		if(isType.equals("new"))
		{
			if (localName.equalsIgnoreCase("Id"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.Id = MyUIApplication.CatagoryCode;
			}
			if (localName.equalsIgnoreCase("Title"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.Title = buffer;
			}
			if (localName.equalsIgnoreCase("Description"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.Description = buffer;
			}
			if (localName.equalsIgnoreCase("YouTube"))
			{
				System.out.println(localName + buffer);
				if(buffer.length()>0)
					_objVideoGalleryListWrapper.VideoUrl = buffer;
			}
			if (localName.equalsIgnoreCase("ImageName"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.ImageName = buffer;
			}
			if (localName.equalsIgnoreCase("ImagePath"))
			{
				System.out.println(localName + buffer);		
				_objVideoGalleryListWrapper.ImagePath =buffer;
			}
			if (localName.equalsIgnoreCase("VideoUrl"))
			{
				System.out.println(localName + buffer);	
				if(buffer.length()>0)
					_objVideoGalleryListWrapper.VideoUrl =buffer;
			}
			if (localName.equalsIgnoreCase("Video"))
			{
				MyUIApplication._objPictureGalleryGridDB.insertRecordsinVGL(_objVideoGalleryListWrapper);
				_objVideoGalleryListWrapper=null;
			}
		}
		if(isType.equals("update"))
		{

			if (localName.equalsIgnoreCase("Id"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.Id = buffer;
			}
			if (localName.equalsIgnoreCase("Title"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.Title = buffer;
			}
			if (localName.equalsIgnoreCase("Description"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.Description = buffer;
			}
			if (localName.equalsIgnoreCase("ImageName"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.ImageName = buffer;
			}
			if (localName.equalsIgnoreCase("ImagePath"))
			{
				System.out.println(localName + buffer);		
				_objVideoGalleryListWrapper.ImagePath =buffer;
			}
			if (localName.equalsIgnoreCase("VideoUrl"))
			{
				System.out.println(localName + buffer);		
				_objVideoGalleryListWrapper.VideoUrl =buffer;
			}
			if (localName.equalsIgnoreCase("Video"))
			{
				MyUIApplication._objPictureGalleryGridDB.updateTableRecordVGL(_objVideoGalleryListWrapper);
				_objVideoGalleryListWrapper=null;
			}
		}
		if(isType.equals("delete"))
		{
			if (localName.equalsIgnoreCase("Id"))
			{
				System.out.println(localName + buffer);
				_objVideoGalleryListWrapper.Id = buffer;
			}
			if (localName.equalsIgnoreCase("Video"))
			{
				MyUIApplication._objPictureGalleryGridDB.deleteRecordVGL(_objVideoGalleryListWrapper);
				_objVideoGalleryListWrapper=null;
			}
		}

	}

	public void characters(char ch[], int start, int length) 
	{
		buffer += new String(ch, start, length);
	}

}
