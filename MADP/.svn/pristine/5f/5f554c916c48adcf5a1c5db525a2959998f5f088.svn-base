package mobi.neuerung.BGThread;

import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.MADP.Splash;
import mobi.neuerung.Wrapper.SyncTimeWrapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class ImagePacketSync extends AsyncTask<Void,Void,Void> {


	Context context;
	String forParser;
	private ProgressDialog dialog;
	public ImagePacketSync(Context context,String forParser) {
		// TODO Auto-generated constructor stub

		this.context = context;
		this.forParser = forParser;
		dialog = new ProgressDialog(context);

	}
	
	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
		if(forParser.equals("ImagePacket"))
		{
			this.dialog.setMessage("Checking Images Update from Server..");
		}
		else
		{
			this.dialog.setMessage("Please Wait ..");
		}
				
				this.dialog.show();
				this.dialog.setCancelable(false);
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		if(dialog.isShowing())
			dialog.dismiss();
		
		if(context instanceof Splash)
		{
			//			if(((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
			//			{
			//				new BGImagePacketThread(context,imageUrl).execute();
			//			}
			//			else
			//			{
			Splash _objSplash =((Splash)context);
			_objSplash.FillScreenAfterDownloadFromServer(imageUrl);
			//			}
		}
	}


	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub

		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			String url=MyUIApplication.EMGUrl+"GetImagePacketURL.aspx?ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode;

			SyncTimeWrapper _obj =	MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("ImagePacket");

			if(_obj !=null && _obj.Date_time !=null)
			{
				if(_obj.Date_time.length()>0)
				{
					url =url+"&synctimestamp="+_obj.Date_time;
				}

			}
			else
			{
				url =url+"&synctimestamp="+context.getResources().getString(R.string.sync_time);
			}


			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);

//			URL sourceUrl = new URL(url);


			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			ImageParser myXMLHandler = new ImageParser(context);

			xr.setContentHandler(myXMLHandler);
			

			HttpGet request = new HttpGet(url);
			HttpParams httpParams = new BasicHttpParams();
			int some_reasonable_timeout = 8000;
			HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpResponse response = client.execute(request);
			String ciper = EntityUtils.toString(response.getEntity());

			xr.parse(new InputSource(new StringReader(ciper)));

			//			xr.parse(new InputSource(context.getResources().openRawResource(R.raw.show_updates)));
//			xr.parse(new InputSource(sourceUrl.openStream()));

			((Home)context)._objUtilRegistration.keyValue="";
		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}

		return null;
	}



	String imageUrl="";
	class ImageParser extends DefaultHandler
	{
		Context context;
		public ImageParser(Context context) {
			// TODO Auto-generated constructor stub

			this.context = context;
		}

		String buffer="";

		@Override
		public void characters(char[] ch, int start, int length)
		throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);

			buffer+=new String(ch,start,length);

		}
		String updatetimestamp="";
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub
			super.startElement(uri, localName, qName, attributes);
			buffer="";
			if(localName.equals("Image"))
			{
				updatetimestamp = attributes.getValue("updatetimestamp");
				MyUIApplication.ImagePacketTimeStamp = updatetimestamp;
			}

			if(localName.equals("ImageURL"))
			{
			}
		}


		@Override
		public void endElement(String uri, String localName, String qName)
		throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);

			if(localName.equals("Image"))
			{



			}

			if(localName.equals("ImageURL"))
			{

				imageUrl =buffer;
//				if(imageUrl.trim().length()>0)
//				{
//					SyncTimeWrapper _obj =	MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("ImagePacket");
//
//					if(_obj !=null && _obj.Date_time !=null)
//					{
//						SyncTimeWrapper updateTable = new SyncTimeWrapper();
//
//						updateTable.Name="ImagePacket";
//						updateTable.Date_time = updatetimestamp;
//						updateTable.Client_EventCode =MyUIApplication.ClientCode+MyUIApplication.EventCode;
//
//						MyUIApplication._objSyncTimeDB.updateTable(updateTable);
//					}
//					else
//					{
//
//						SyncTimeWrapper insertTable = new SyncTimeWrapper();
//
//						insertTable.Name="ImagePacket";
//						insertTable.Date_time = updatetimestamp;
//						insertTable.Client_EventCode =MyUIApplication.ClientCode+MyUIApplication.EventCode;
//
//						MyUIApplication._objSyncTimeDB.insertRecords(insertTable);
//					}
//				}

			}
		}

	}

}

