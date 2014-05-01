package mobi.neuerung.Parser;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.Message;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetMessageParser extends DefaultHandler {



	String buffer="";


	public GetMessageParser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void characters(char[] ch, int start, int length)
	throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		buffer+= new String(ch,start,length);
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);

		buffer="";

		if(localName.equals("element"))
		{
			System.out.println("element");
		}

		if(localName.equals("Message"))
		{
			System.out.println("Message");
		}
		if(localName.equals("User"))
		{
			System.out.println("User");
		}
		if(localName.equals("Date"))
		{
			System.out.println("Date");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
	throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);

		if(localName.equals("element"))
		{
			System.out.println("element end");
			
			String[] aa = message.split("\\|");
			String[] aaa = date.split("\\|");
			ArrayList<Message> array =MyUIApplication.UserMessageArray.get(user);

			if(array != null)
			{
				for (int i = 0; i < aa.length; i++)
				{
					Message message = new Message(false, aa[i]);
					message.setDate(aaa[i]);
					array.add(message);
				}

			}
			
			Integer i = MyUIApplication.UserMessageCount.get(user);
			
			if(i !=null)
			{
				i = aa.length;
			}
			
			
			Integer ii = MyUIApplication.UserMessageCount.get(user);
			
			System.out.println("AAAAAAAAA.. .. ..  ..    "+ii);
		}

		if(localName.equals("Message"))
		{

			System.out.println("Message.. " + buffer);

			message=buffer;

		}

		if(localName.equals("Date"))
		{
			System.out.println("Date.. "+buffer);
			date = buffer;
		}

		if(localName.equals("User"))
		{
			System.out.println("User.. "+buffer);
			user = buffer;
			ArrayList<Message> array =MyUIApplication.UserMessageArray.get(user);
			if(array == null)
			{
				array = new ArrayList<Message>();

				MyUIApplication.UserMessageArray.put(user, array);

			}


		}
	}

	String user="";
	String message="";
	String date="";

}
