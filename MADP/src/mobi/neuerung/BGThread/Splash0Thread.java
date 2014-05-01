package mobi.neuerung.BGThread;

import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mobi.neuerung.MADP.CaptureActivity;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.Splash;
import mobi.neuerung.MADP.Splash0;
import mobi.neuerung.ScreenParser.EventListParser;
import mobi.neuerung.ScreenParser.Splash0Parser;
import mobi.neuerung.Util.UtilPictureGalleryDetail;
import mobi.neuerung.Util.UtilPicturealleryDetailWithDesc;
import mobi.neuerung.Util.UtilVideoGalleryDetail;
import mobi.neuerung.Util.UtilVideoGalleryList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
/**
 * @author Saurabh
 * Here Url is Client Code which is very important in this whole app
 */


public class Splash0Thread extends AsyncTask<Void, Void, Void>
{

	private ProgressDialog dialog;
	Context context;
	String forParser;
	String Url;
	public Splash0Thread(Context context,String forParser,String Url)
	{
		this.context = context;
		this.forParser = forParser;
		this.Url = Url;
		dialog = new ProgressDialog(context);
	}
	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();

		if(forParser.equals("SaveXMLintoSDCard"))
		{
			this.dialog.setMessage("Downloading and Saving XML ..");
			this.dialog.show();
			this.dialog.setCancelable(false);
		}
		else if((forParser.equals("GetEventList")))
		{
			this.dialog.setMessage("Getting Event List ..");
			this.dialog.show();
			this.dialog.setCancelable(false);
		}
		else if(!((forParser.equals("GetListOfCLients")) || 
				(forParser.equals("DownLoadAdvertisementXmlInSdCard"))|| 
				(forParser.equals("DownLoadAdvertisementXmlInSdCardManual"))))
		{
			this.dialog.setMessage("Please Wait ..");
			this.dialog.show();
			this.dialog.setCancelable(false);
		}

	}
	EventListParser _objEventListParser;
	@Override
	protected Void doInBackground(Void... params)
	{
		try
		{
			if(context instanceof Splash0)
			{
				if(forParser.equals("GetListOfCLients"))
				{
					((Splash0)context).ParserMethod(context);
				}
				//				else if(forParser.equals("SaveXMLintoSDCard"))
				//				{
				//					((Splash0)context).DownloadFromUrl(Url, MyUIApplication.ClientCode+MyUIApplication.EventCode+".xml");
				//				}
				else if(forParser.equals("GetEventList"))
				{
					try 
					{
						/** Handling XML */
						SAXParserFactory spf = SAXParserFactory.newInstance();
						SAXParser sp = spf.newSAXParser();
						XMLReader xr = sp.getXMLReader();


						String URl=MyUIApplication.EMGUrl+"GetEventList.aspx?Code="+Url;
						Log.d("QR Code Pop-up Edit Text","Getting Event List :-"+URl);
						_objEventListParser = new EventListParser(context);
						xr.setContentHandler(_objEventListParser);

						HttpGet request = new HttpGet(URl);
						HttpParams httpParams = new BasicHttpParams();
						int some_reasonable_timeout = 8000;
						HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
						HttpClient client = new DefaultHttpClient(httpParams);

						HttpResponse response = client.execute(request);
						String ciper = EntityUtils.toString(response.getEntity());

						xr.parse(new InputSource(new StringReader(ciper)));

					} catch (Exception e) {
						System.out.println("XML Pasing Excpetion = " + e);
					}
				}
			}

			if(context instanceof CaptureActivity)
			{
				if(forParser.equals("GetEventList"))
				{
					try 
					{
						/** Handling XML */
						SAXParserFactory spf = SAXParserFactory.newInstance();
						SAXParser sp = spf.newSAXParser();
						XMLReader xr = sp.getXMLReader();


						String URl=MyUIApplication.EMGUrl+"GetEventList.aspx?Code="+Url;
						Log.d("Capture Activity","Getting Event List :-"+URl);
						_objEventListParser = new EventListParser(context);
						xr.setContentHandler(_objEventListParser);

						HttpGet request = new HttpGet(URl);
						HttpParams httpParams = new BasicHttpParams();
						int some_reasonable_timeout = 8000;
						HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
						HttpClient client = new DefaultHttpClient(httpParams);

						HttpResponse response = client.execute(request);
						String ciper = EntityUtils.toString(response.getEntity());

						xr.parse(new InputSource(new StringReader(ciper)));

					} catch (Exception e) {
						System.out.println("XML Pasing Excpetion = " + e);
					}
				}
			}

			if(context instanceof Splash)
			{

				if(forParser.equals("GetListOfCLients"))
				{
					try 
					{
						/** Handling XML */
						SAXParserFactory spf = SAXParserFactory.newInstance();
						SAXParser sp = spf.newSAXParser();
						XMLReader xr = sp.getXMLReader();

						String time = MyUIApplication._objClientEventDB.getTimeStamp();
						String URl=MyUIApplication.EMGUrl+"GetClientDetailsSync.aspx?Code=NTPL001&synctimestamp=";

						if(time.trim().length()>0)
						{
							URl = URl+time;
						}
						else
						{
							URl = URl+"null";
						}

						URl = URl.replace(" ","%20");
						/** Send URL to parse XML Tags */
						//						URL sourceUrl = new URL(URl);

						System.out.println("Url->>"+URl);
						/** Create handler to handle XML Tags ( extends DefaultHandler ) */

						Splash0Parser myXMLHandler = new Splash0Parser(context);
						xr.setContentHandler(myXMLHandler);


						HttpGet request = new HttpGet(URl);
						HttpParams httpParams = new BasicHttpParams();
						int some_reasonable_timeout = 8000;
						HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
						HttpClient client = new DefaultHttpClient(httpParams);

						HttpResponse response = client.execute(request);
						String ciper = EntityUtils.toString(response.getEntity());

						xr.parse(new InputSource(new StringReader(ciper)));

						//						if(MyUIApplication.isInternetAvailable(context))
						//						{
						//							//			xr.parse(new InputSource(context.getResources().openRawResource(R.raw.emg_screen)));
						//							xr.parse(new InputSource(sourceUrl.openStream()));
						//						}
						//						else
						//						{
						//							xr.parse(new InputSource(context.getResources().openRawResource(R.raw.clientdetails)));
						//						}


					} catch (Exception e) {
						System.out.println("XML Pasing Excpetion = " + e);

						//						alertForstartBrandedApp();
					}
				}

				//				if(forParser.equals("GetListOfCLients"))
				//				{
				//					((Splash0)context).ParserMethod(context);
				//				}
				//				else 
				if(forParser.equals("SaveXMLintoSDCard"))
				{
					//					((Splash)context).DownloadFromUrl(Url, MyUIApplication.ClientCode+MyUIApplication.EventCode+".xml");
					//KD_15022014
					((Splash)context).DownloadFromUrl(Url, "screen.xml");
				}
				// For Picture Gallery Images DownLoad

			}
			else if(forParser.equals("PGD"))
			{
				new UtilPictureGalleryDetail().DownloadFromUrl(Url, context);
			}
			else if(forParser.equals("PGDWthDesc"))
			{
				new UtilPicturealleryDetailWithDesc().DownloadFromUrl(Url, context);
			}
			else if(forParser.equals("VideoGalleryList"))
			{
				new UtilVideoGalleryList().ImageDownLoadMethod( context);
			}
			else if(forParser.equals("DownLoadVideoInSdCard"))
			{
				new UtilVideoGalleryDetail().downloadVideo(Url, context);
			}
			else if(forParser.equals("DownLoadAdvertisementXmlInSdCard"))
			{
				((Home)context)._objUtilAdvertisementSwitcher.DownloadFromUrl(Url, "AdvertisementSwitcher.xml");
			}
			else if(forParser.equals("DownLoadAdvertisementXmlInSdCardManual"))
			{
				((Home)context)._objUtilAdvertisementManualSwitcher.DownloadFromUrl(Url, "AdvertisementSwitcher.xml");
			}
			else 
			{
				//				new UtilPictureGalleryCategory().DownloadFromUrl(Url, forParser);
			}
		}
		catch (Exception e)
		{
			System.out.println(""+e);
		}
		return null;
	}


	@Override
	protected void onPostExecute(Void result) 
	{
		super.onPostExecute(result);

		try
		{
			if(context instanceof Splash0)
			{
				if(forParser.equals("GetListOfCLients"))
				{
					if(!isCancelled()){
						/**
						 * We are checking this condition because as we are checking for update in bg withut any Loader
						 * & meanwhile user switch the activity, we are canceling this async task on activity switch.
						 * So if this task is closed we are not going to show any UI update just update the database value.
						 */
						((Splash0)context).OnPostMethod();
					}

				}
				//				else if(forParser.equals("SaveXMLintoSDCard"))
				//				{
				//					((Splash0)context).StartActivityToSplash();
				//				}
				else if(forParser.equals("GetEventList"))
				{
					try {
						//Load Event List

						/**
						 * Here this Url	=	Client 
						 * is necessary to pass because its user entered Client Code so we have to 
						 * handle this situation too so if Client code is null we will pass 
						 * null Event list to splash0
						 */

						((Splash0)context).ShowEventScreen(_objEventListParser._objEventList,Url);
					} catch (Exception e) {
						// TODO: handle exception
						((Splash0)context).ShowEventScreen(null,Url);
					}
				}

			}
			if(context instanceof Splash)
			{
				//				if(forParser.equals("GetListOfCLients"))
				//				{
				//					((Splash0)context).OnPostMethod();
				//				}
				//				else 

				if(forParser.equals("SaveXMLintoSDCard"))
				{
					MyUIApplication.ScreenFilePath="";
					((Splash)context).isXMLChange=false;
					((Splash)context).fillScreenList();
					//					((Splash)context).StartActivity();
				}

			}
			else if(forParser.equals("PGD"))
			{
				//				new UtilPictureGalleryDetail().loadImage(Url,context);
			}
			else if(forParser.equals("PGDWthDesc"))
			{
				new UtilPicturealleryDetailWithDesc().loadImage(Url,context);
			}
			else if(forParser.equals("VideoGalleryList"))
			{
				new UtilVideoGalleryList().SetVideoGalleryListAdapter(context);
			}
			else if(forParser.equals("DownLoadVideoInSdCard"))
			{

				// not Working
				//				new UtilVideoGalleryDetail().SetVideoGalleryListAdapter(context);
			}
			else if(forParser.equals("DownLoadAdvertisementXmlInSdCard"))
			{
				//				((Home)context)._objUtilAdvertisementSwitcher.CallParser(context);
			}
			else if(forParser.equals("DownLoadAdvertisementXmlInSdCardManual"))
			{
				//				((Home)context)._objUtilAdvertisementManualSwitcher.CallParser(context);
			}

			else if(context instanceof CaptureActivity)
			{
				if(forParser.equals("GetEventList"))
				{
					try {
						//Load Event Screen With new parsed 
						((CaptureActivity)context).ShowEventScreen(_objEventListParser._objEventList);
					} catch (Exception e) {
						((CaptureActivity)context).ShowEventScreen(null);
					}
				}
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(""+e);
		}

		if (dialog.isShowing()) {
			dialog.dismiss();
		}
	}


}
