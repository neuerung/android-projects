package mobi.neuerung.Parser;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.FriendsListWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.util.Log;


public class GetFriendsListParser extends DefaultHandler {

	private String localName = "";
	String buffer="";

	public String tag;
	public String tagItem;
	String isType;
	FriendsListWrapper _objNew;
	boolean forbadge;
	Context context;
	boolean hasbr = false;

	ArrayList<FriendsListWrapper> array;



	public GetFriendsListParser(Context context,boolean forbadge)
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

		if(localName.equals("Friends"))
		{
			show_updatesdatetime=(atts.getValue("updatetimestamp"));


			//			MyUIApplication._objFriendsListDB.updateTimestamp(show_updatesdatetime);

		}

		if(localName.equals("element"))
		{
			_objNew = null;
			_objNew = new FriendsListWrapper();

		}

		if(localName.equals("New"))
		{
			isType="new";

			array = new ArrayList<FriendsListWrapper>();
		}
		if(localName.equals("Update"))
		{
			isType="update";

			array = new ArrayList<FriendsListWrapper>();
		}
		if(localName.equals("Delete"))
		{
			isType="delete";

			array = new ArrayList<FriendsListWrapper>();
		}

		this.localName = localName;
		System.out.println("PARSER is of Visitor  "+localName);
	} 


	public void endElement(String namespaceURI, String localName, String qName) 
	throws SAXException { 


		if(localName.equals("id"))
		{

			_objNew.id=buffer;
		}

		if(localName.equals("Code"))
		{

			_objNew.Code=buffer;
		}
		if(localName.equals("Name"))
		{
			Log.i(localName, buffer);
			_objNew.Name=buffer;
		}


		if(localName.equals("Company"))
		{
			_objNew.Company=buffer;
		}


		if(localName.equals("E-mail"))
		{
			_objNew.Email=buffer;
		}


		if(localName.equals("City"))
		{
			_objNew.City=buffer;
		}


		if(localName.equals("Mobile"))
		{
			_objNew.Mobile=buffer;
		}



		if(localName.equals("element"))
		{

			if(_objNew.Email.length()>0)
			{
				Integer i =	MyUIApplication.UserMessageCount.get(_objNew.Email);
				if(i==null)
				{
					MyUIApplication.UserMessageCount.put(_objNew.Email, 0);
				}

			}
			array.add(_objNew);
		}

		if(isType.equals("new") && localName.equals("New"))
		{
			MyUIApplication._objFriendsListDB.insertRecords(array);

			array = null;

		}
		if(isType.equals("update") && localName.equals("Update"))
		{

			MyUIApplication._objFriendsListDB.updateTable(array);

			array = null;

		}

		if(isType.equals("delete") && localName.equals("Delete"))
		{

			MyUIApplication._objFriendsListDB.deleteRecord(array);
			//	MyUIApplication._objFAQ_VisitorDB.insertRecords(_objZone_Manager_Wrapper);

			array = null;
		}

		if(localName.equals("Friends"))
		{

			MyUIApplication._objFriendsListDB.updateTimestamp(show_updatesdatetime);

		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}

