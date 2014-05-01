package mobi.neuerung.Parser;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ShowUpdatesCategoryWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.util.Log;


public class ShowUpdatesCategoryParser extends DefaultHandler {

	private String localName = "";
	String buffer="";

	public String tag;
	public String tagItem;
	String isType;
	ShowUpdatesCategoryWrapper _objNew;
	boolean forbadge;
	Context context;
	boolean hasbr = false;




	public ShowUpdatesCategoryParser(Context context,boolean forbadge)
	{
		this.forbadge = forbadge;
		this.context =  context;
	}

	String des;
	String show_updatesdatetime="";
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

		if(localName.equals("ShowUpdateCatagories"))
		{
			show_updatesdatetime=(atts.getValue("updatetimestamp"));


			MyUIApplication._objShowUpdateCategoryDB.updateTimestamp(show_updatesdatetime);

		}

		if(localName.equals("Catagory"))
		{
			_objNew = null;
			_objNew = new ShowUpdatesCategoryWrapper();

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

		this.localName = localName;
		System.out.println("PARSER is of Visitor  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 

		if(isType.equals("new"))
		{
			if(localName.equals("id"))
			{

				_objNew.id=buffer;
			}
			if(localName.equals("CatagoryCode"))
			{
				Log.i(localName, buffer);
				_objNew.CatagoryCode=buffer;
			}
			if(localName.equals("CatagoryName"))
			{
				_objNew.CatagoryName=buffer;
			}


			if(localName.equals("Catagory"))
			{
				Log.i(localName, localName);

				MyUIApplication._objShowUpdateCategoryDB.insertRecords(_objNew);
				_objNew=null;
			}

		}
		if(isType.equals("update"))
		{
			if(localName.equals("id"))
			{

				Log.i(localName, buffer);
				_objNew.id=buffer;
			}
			if(localName.equals("CatagoryCode"))
			{
				Log.i(localName, buffer);
				_objNew.CatagoryCode=buffer;
			}
			if(localName.equals("CatagoryName"))
			{
				_objNew.CatagoryName=buffer;
			}

			if(localName.equals("Catagory"))
			{
				Log.i(localName, localName);

				MyUIApplication._objShowUpdateCategoryDB.updateTable(_objNew);
				_objNew=null;
			}
		}
		if(isType.equals("delete"))
		{
			if(localName.equals("id"))
			{

				Log.i(localName, buffer);
				_objNew.id=buffer;
			}

			if(localName.equals("CatagoryCode"))
			{
				Log.i(localName, buffer);
				_objNew.CatagoryCode=buffer;
			}
			if(localName.equals("CatagoryName"))
			{
				Log.i(localName, buffer);
				_objNew.CatagoryName=buffer;
			}


			if(localName.equals("Catagory"))
			{
				Log.i(localName, localName);
				MyUIApplication._objShowUpdateCategoryDB.deleteRecord(_objNew);
				//	MyUIApplication._objFAQ_VisitorDB.insertRecords(_objZone_Manager_Wrapper);
				_objNew=null;
			}
		}

		if(localName.equals("ShowUpdateCatagories"))
		{

			MyUIApplication._objShowUpdateCategoryDB.updateTimestamp(show_updatesdatetime);

		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}

