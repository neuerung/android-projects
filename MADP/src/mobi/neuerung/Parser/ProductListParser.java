package mobi.neuerung.Parser;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ProductListWrapper;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.util.Log;


public class ProductListParser extends DefaultHandler {

	private String localName = "";
	String buffer="";

	public String tag;
	public String tagItem;
	String isType;
	ProductListWrapper _objNew;
	boolean forbadge;
	Context context;
	boolean hasbr = false;


	ArrayList<ProductListWrapper> array;

	public ProductListParser(Context context,boolean forbadge)
	{
		this.forbadge = forbadge;
		this.context =  context;
	}

	String des;
	String updatesdatetime="";
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

		if(localName.equals("Products"))
		{
			updatesdatetime=(atts.getValue("updatetimestamp"));
		}

		if(localName.equals("element"))
		{
			_objNew = null;
			_objNew = new ProductListWrapper();

		}
		if(localName.equals("New"))
		{
			isType="new";
			array = new ArrayList<ProductListWrapper>();
		}
		if(localName.equals("Update"))
		{
			isType="update";

			array = new ArrayList<ProductListWrapper>();
		}
		if(localName.equals("Delete"))
		{
			isType="delete";

			array = new ArrayList<ProductListWrapper>();
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
		if(localName.equals("ProductCode"))
		{
			Log.i(localName, buffer);
			_objNew.ProductCode=buffer;
		}
		if(localName.equals("ProductName"))
		{
			_objNew.ProductName=buffer;
		}
		if(localName.equals("Description"))
		{
			_objNew.Description=buffer;
		}


		if(localName.equals("element"))
		{
			Log.i(localName, localName);
			array.add(_objNew);

		}

		if(localName.equals("New"))
		{
			MyUIApplication._objProductListDB.insertRecords(array);
		}
		if(localName.equals("Update"))
		{
			MyUIApplication._objProductListDB.updateTable(array);

		}
		if(localName.equals("Delete"))
		{
			MyUIApplication._objProductListDB.deleteRecord(array);

		}

		if(localName.equals("Products"))
		{

			MyUIApplication._objProductListDB.updateTimestamp(updatesdatetime);

		}

		this.localName = "";

	}

	public void characters(char ch[], int start, int length) { 

		buffer+=new String(ch, start, length);
	}
}

