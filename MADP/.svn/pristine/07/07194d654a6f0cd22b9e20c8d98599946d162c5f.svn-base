package mobi.neuerung.BGThread;



import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Util.UtilEventList;
import mobi.neuerung.Util.UtilPictureGalleryGrid;
import mobi.neuerung.Util.UtilVideoGalleryList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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


public class BadgeBGThread extends AsyncTask<Void, Void, Void>  {

	private ProgressDialog dialog;
	Context context;
	String forParser;
	String CategoryCode;
	boolean forbadge;

	public BadgeBGThread(Context activity,String forParser,boolean forbadge)
	{
		context=activity;
		this.forParser=forParser;
		this.forbadge=forbadge;

		System.out.println(forParser);
		dialog = new ProgressDialog(context);
	}
	public BadgeBGThread(Context activity,String forParser,String CategoryCode)
	{
		context=activity;
		this.forParser=forParser;
		this.CategoryCode=CategoryCode;

		System.out.println(forParser);
		dialog = new ProgressDialog(context);
	}



	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		this.dialog.show();
		this.dialog.setCancelable(false);
		if(forParser.equals("DownloadHTPMIMage") || forParser.equals("DownloadHTPMIMage01"))
		{
			this.dialog.setMessage("Downloading Image ..");
		}
		else if(forParser.equals("UPDATE Category"))
		{
			this.dialog.setMessage("Getting News Category ...");
		}

		else
		{
			this.dialog.setMessage("Please Wait ..");
		}

	}


	@Override
	protected Void doInBackground(Void... arg0) {
		// TODO Auto-generated method stub
		try
		{

			if(forParser.equals("Registration"))
			{
				try {
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser sp = spf.newSAXParser();
					XMLReader xr = sp.getXMLReader();

					String url=MyUIApplication.EMGUrl+"Registration.aspx?ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&Value="+((Home)context)._objUtilRegistration.keyValue;
					url=url.replaceAll(" ", "%20");
					System.out.println("URl"+url);

					//					URL sourceUrl = new URL(url);


					/** Create handler to handle XML Tags ( extends DefaultHandler ) */
					Parser myXMLHandler = new Parser();

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
					//					xr.parse(new InputSource(sourceUrl.openStream()));

					((Home)context)._objUtilRegistration.keyValue="";
				} catch (Exception e) {
					System.out.println("XML Pasing Excpetion = " + e);
				}
			}

			if(forParser.equals("Login"))
			{
				try {
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser sp = spf.newSAXParser();
					XMLReader xr = sp.getXMLReader();

					String url=MyUIApplication.EMGUrl+"Login.aspx?ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&UserName="+((Home)context)._objUtilLogin.UserName+"&Password="+((Home)context)._objUtilLogin.Password;
					url=url.replaceAll(" ", "%20");
					System.out.println("URl"+url);

					//					URL sourceUrl = new URL(url);


					/** Create handler to handle XML Tags ( extends DefaultHandler ) */
					Parser myXMLHandler = new Parser();

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
					//					xr.parse(new InputSource(sourceUrl.openStream()));

				} catch (Exception e) {
					System.out.println("XML Pasing Excpetion = " + e);
				}
			}

			if(forParser.equals("Verify"))
			{
				String url=MyUIApplication.EMGUrl+"VerifyEmail.aspx?ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&UserName="+((Home)context)._objUtilLogin.UserName;
				// Create a new HttpClient and Post Header
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(url);

				try {

					// Execute HTTP Post Request
					HttpResponse response =   httpclient.execute(httppost);
					message = EntityUtils.toString(response.getEntity());
					System.out.println(""+message);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}

			}

			if(forParser.equals("UpdateFriendList"))
			{
				String url=MyUIApplication.EMGUrl+"UpdateFriendList.aspx?ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&UserName="+MyUIApplication.UserName+"&Command=Delete&Code="+CategoryCode;
				// Create a new HttpClient and Post Header
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(url);

				try {

					// Execute HTTP Post Request
					HttpResponse response =   httpclient.execute(httppost);
					message = EntityUtils.toString(response.getEntity());
					System.out.println(""+message);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}

			}

			if(forParser.equals("SendMessage"))
			{
				String url=MyUIApplication.EMGUrl+"SendMessage.aspx?ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&From="+MyUIApplication.UserName+"&To="+((Home)context)._objUtilFriendsDetail.to+"&Message="+((Home)context)._objUtilFriendsDetail.message;

				System.out.println("AAAAAAA.. ...  ..  "+url);
				// Create a new HttpClient and Post Header
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(url);

				try {

					// Execute HTTP Post Request
					HttpResponse response =   httpclient.execute(httppost);
					message = EntityUtils.toString(response.getEntity());
					System.out.println(""+message);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}

			}


			if(forParser.equals("EnterFriend'sCode"))
			{
				String url=MyUIApplication.EMGUrl+"SaveCode.aspx?ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&UserName="+((Home)context)._objUtilLogin.UserName+"&Code="+CategoryCode;
				// Create a new HttpClient and Post Header
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(url);

				try {

					// Execute HTTP Post Request
					HttpResponse response =   httpclient.execute(httppost);
					message = EntityUtils.toString(response.getEntity());
					System.out.println(""+message);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}

			}
			if(forParser.equals("RequestFriend'sCode"))
			{
				String url=MyUIApplication.EMGUrl+"GenerateFriendsCode.aspx?ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&UserName="+((Home)context)._objUtilLogin.UserName;
				// Create a new HttpClient and Post Header
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(url);

				try {

					// Execute HTTP Post Request
					HttpResponse response =   httpclient.execute(httppost);
					message = EntityUtils.toString(response.getEntity());
					System.out.println(""+message);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}

			}

			if(forParser.equals("UPDATE"))
			{
				MyUIApplication.ShowUpdatesParser(context,forbadge);
			}

			if(forParser.equals("DownloadHTPMIMage"))
			{
				((Home)context)._objUtilTopBar.saveImageToGallery();
			}

			if(forParser.equals("DownloadHTPMIMage01"))
			{
				((Home)context)._objUtilTopBar01.saveImageToGallery();
			}

			if(forParser.equals("GetMessage"))
			{
				//				MyUIApplication.GetMessagesParser(context,forbadge);
			}

			if(forParser.equals("FriendsList"))
			{
				MyUIApplication.FriendsListParser(context,forbadge);
			}

			if(forParser.equals("Get Speakers"))
			{
				MyUIApplication.GetSpeakerListParser(context,forbadge);
			}

			if(forParser.equals("GetProductList"))
			{
				MyUIApplication.GetProductListParser(context,forbadge);
			}

			if(forParser.equals("Get Seminars"))
			{
				MyUIApplication.SpeakerSeminarsParser(context,forbadge);
			}
			if(forParser.equals("UPDATE Category"))
			{
				MyUIApplication.ShowUpdatesCategoryParser(context,forbadge);
			}
			else if(forParser.equals("EVENTS"))
			{
				MyUIApplication.EventsParser(context);
			}
			else if(forParser.equals("PictureGalleryCategory"))
			{
				MyUIApplication.PictureGalleryCategoryParser(context);
			}
			else if(forParser.equals("VideoGalleryCategory"))
			{
				MyUIApplication.VideoGalleryCategoryParser(context);
			}
			else if(forParser.equals("FillListForPictureGalleryCategory"))
			{
				MyUIApplication._objPictureGalleryDB.getPGCategoryList();
			}
			else if(forParser.equals("PictureGalleryGrid"))
			{
				MyUIApplication.PictureGalleryGridParser(context,CategoryCode);
			}
			else if(forParser.equals("VideoGalleryList"))
			{
				MyUIApplication.VideoGalleryListParser(context,CategoryCode);
			}
			else if(forParser.equals("AdvertisementSwitcher"))
			{
				((Home)context)._objUtilAdvertisementSwitcher.AdvertisementSwitcherParser(context);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println();
		}
		return null;
	}


	String message="";
	String EmailVerify="";
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		try{


			if(forParser.equals("EnterFriend'sCode"))
			{
				if(context instanceof Home)
				{
					((Home)context)._objUtilEnterFriendCode.isVerify(message,context);
				}
			}
			if(forParser.equals("RequestFriend'sCode"))
			{
				if(context instanceof Home)
				{
					((Home)context)._objUtilRequestFriendCode.isVerify(message,context);
				}
			}

			if(forParser.equals("Get Speakers"))
			{
				if(context instanceof Home)
				{
					((Home)context)._objUtilSpeaker.fillList(context,"SP103");
				}
			}
			if(forParser.equals("GetProductList"))
			{
				if(context instanceof Home)
				{
					((Home)context)._objUtilProductList.fillList(context);
				}
			}

			if(forParser.equals("Registration"))
			{
				if(context instanceof Home)
				{
					((Home)context)._objUtilRegistration.isRegistrationSuccessfull(message);
				}
			}

			if(forParser.equals("Verify"))
			{
				if(context instanceof Home)
				{
					((Home)context)._objUtilLogin.isVerify(message);
				}
			}

			if(forParser.equals("FriendsList"))
			{
				((Home)context)._objUtilFriendsList.fillList(forParser, false, context);
			}


			if(forParser.equals("Login"))
			{
				if(context instanceof Home)
				{
					((Home)context)._objUtilLogin.isLoginSuccessfull(message,EmailVerify);
				}
			}



			if(forParser.equals("Get Seminars"))
			{
				((Home)context)._objUtilSpeakerSeminars.fillList(context);
			}


			if(forParser.equals("UPDATE"))
			{
				((Home)context)._objUtilShowUpdate.fillList(context);
			}

			if(forParser.equals("UPDATE Category"))
			{
				if(context instanceof Home)
				{
					((Home)context)._objUtilShowUpdateCategory.fillList(context);
				}
			}
			else if(forParser.equals("EVENTS"))
			{
				new UtilEventList().getDayListFromDB(context);
			}
			else if(forParser.equals("PictureGalleryCategory"))
			{
				//				new UtilPictureGalleryCategory().fillCategoryList(context);
			}
			else if(forParser.equals("VideoGalleryCategory"))
			{			
				//				new UtilPictureGalleryCategory().fillCategoryList(context);
			}
			else if(forParser.equals("FillListForPictureGalleryCategory"))
			{
				//				new UtilPictureGalleryCategory().DownLoadImages(context);
			}
			else if(forParser.equals("PictureGalleryGrid"))
			{
				new UtilPictureGalleryGrid().DownloadImageZipThread(context,CategoryCode);
			}
			else if(forParser.equals("VideoGalleryList"))
			{
				new UtilVideoGalleryList().DownloadImagesInSdCard(context,CategoryCode);
			}
			else if(forParser.equals("AdvertisementSwitcher"))
			{
				((Home)context)._objUtilAdvertisementSwitcher.setImageInAdver(context);
			}


		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		if (dialog.isShowing()) {
			dialog.dismiss();
		}
	}


	class Parser extends DefaultHandler
	{
		String buffer="";

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

			if(localName.equals("Registration"))
			{
				System.out.println("Registration");
			}

			if(localName.equals("Message"))
			{
				System.out.println("Message");
			}
			if(localName.equals("Error"))
			{
				System.out.println("Error");
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
		throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);

			if(localName.equals("Registration"))
			{
				System.out.println("Registration end");
			}

			if(localName.equals("Message"))
			{
				System.out.println("Message end");
				System.out.println("Message end ..  "+buffer);
				message=buffer;
			}

			if(localName.equals("EmailVerify"))
			{
				System.out.println("EmailVerify end");
				System.out.println("EmailVerify end ..  "+buffer);
				EmailVerify=buffer;
			}

			if(localName.equals("Error"))
			{
				System.out.println("Error end");
				System.out.println("Error end ..  "+buffer);
				message=buffer;
			}
		}
	}

}
