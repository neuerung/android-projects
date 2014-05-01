package mobi.neuerung.MADP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mobi.neuerung.Adapters.EventItem;
import mobi.neuerung.MenuItem.MenuItem;
import mobi.neuerung.Parser.EventsParser;
import mobi.neuerung.Parser.ExhibitorDirectoryParser;
import mobi.neuerung.Parser.GetFriendsListParser;
import mobi.neuerung.Parser.PictureGalleryCategoryParser;
import mobi.neuerung.Parser.PictureGalleryGridParser;
import mobi.neuerung.Parser.ShowUpdatesParser;
import mobi.neuerung.Parser.VideoGalleryListParser;
import mobi.neuerung.ScreenParser.HomeScreenParser;
import mobi.neuerung.ScreenParser.SyncHtmlParser;
import mobi.neuerung.ScreenParser.SyncParser;
import mobi.neuerung.SectionList.ShowUpdateItem;
import mobi.neuerung.Sevices.GetMessageService;
import mobi.neuerung.Util.UtilVideoGalleryDetail;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.EventsWrapper;
import mobi.neuerung.Wrapper.ExhibitorDirectoryWrapper;
import mobi.neuerung.Wrapper.MenuWrapper;
import mobi.neuerung.Wrapper.Message;
import mobi.neuerung.Wrapper.PictureGalleryCategoryWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ScreenWrapper;
import mobi.neuerung.Wrapper.ShowUpdatesWrapper;
import mobi.neuerung.Wrapper.SplashOWrapper;
import mobi.neuerung.Wrapper.SyncForXmlWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;
import mobi.neuerung.Wrapper.VideoGalleryListWrapper;
import mobi.neuerung.db.DBAdapter;
import mobi.neuerung.db.dbhelper.ClientEventDB;
import mobi.neuerung.db.dbhelper.ElementDB;
import mobi.neuerung.db.dbhelper.EventsDB;
import mobi.neuerung.db.dbhelper.FriendsListDB;
import mobi.neuerung.db.dbhelper.MyExhiDB;
import mobi.neuerung.db.dbhelper.PictureGalleryDB;
import mobi.neuerung.db.dbhelper.PictureGalleryGridDB;
import mobi.neuerung.db.dbhelper.ProductListDB;
import mobi.neuerung.db.dbhelper.PushNotificationDB;
import mobi.neuerung.db.dbhelper.ScreenDB;
import mobi.neuerung.db.dbhelper.ScreenPartDB;
import mobi.neuerung.db.dbhelper.ShowUpdateCategoryDB;
import mobi.neuerung.db.dbhelper.ShowUpdateDB;
import mobi.neuerung.db.dbhelper.SpeakerListDB;
import mobi.neuerung.db.dbhelper.SpeakerSeminarDB;
import mobi.neuerung.db.dbhelper.SyncTimeDB;
import mobi.neuerung.db.dbhelper.VideoGalleryDB;
import mobi.neuerung.manager.PreferencesManager;

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

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;



public class MyUIApplication extends Application
{
	// Client Code And Event Codes For Starting an app
	public static String ClientCode="";
	public static String EventCode="";
	//	public static String HardcoredClientCode="Paathshaala";
	//	public static String HardcoredEventCode="Oaktree";
	public static String currentScreenNumber="0";
	public static String StartAndEndDate="";
	public static String Update_Time_Stamp="";
	public static String client="";


	public static String EMGUrl = "";
	public static String mainDirectoryName = "";

	public static String ImagePacketTimeStamp = "";


	public static ArrayList<SplashOWrapper> clientEventList=new ArrayList<SplashOWrapper>();
	public static ArrayList<SplashOWrapper> EventList=new ArrayList<SplashOWrapper>();


	//  These are For Screen Views
	public static boolean Copy=false;
	public static boolean Menu=false;

	/****************************************************/
	public  boolean showclientscreen=true;
	/****************************************************/
	public static int CurrentScrollPosition=0;
	public static String HTMLImageUrl = "";

	/*
	 *  Menu Items List
	 */
	public static ArrayList<ArrayList<MenuWrapper>> sectionList;
	public static ArrayList<String> TypeWisesectionList;
	public static ArrayList<MenuItem> Menuitems ;


	// *** Element Wrapper Arraylist for Home page

	public static ArrayList<ElementWrapper> _objEWList;
	public static ArrayList<String> StateMachine = new ArrayList<String>();
	public static ArrayList<String> ScreenNumbers = new ArrayList<String>();

	public static DBAdapter myDBAdaptor;
	private SQLiteDatabase myDB;
	public static ShowUpdateDB _objShowUpdateDB;
	public static ShowUpdateCategoryDB _objShowUpdateCategoryDB;
	public static ProductListDB _objProductListDB;
	public static SpeakerListDB _objSpeakerListDB;
	public static SpeakerSeminarDB _objSpeakerSeminarDB;
	public static EventsDB _objEventsDB;
	public static PictureGalleryDB _objPictureGalleryDB;
	public static PictureGalleryGridDB _objPictureGalleryGridDB;
	public static ElementDB _objElementDB;
	public static ScreenPartDB _objScreenPartDB;
	public static ScreenDB _objScreenDB;
	public static SyncTimeDB _objSyncTimeDB;
	public static MyExhiDB _objMyExhiDB;
	public static FriendsListDB _objFriendsListDB;
	public static ClientEventDB _objClientEventDB;
	public static VideoGalleryDB _objVideoGalleryDB;
	public static PushNotificationDB _objPushDB;


	// *****  For Screen Xml Parsing Arraylists ******

	public static ArrayList<ScreenWrapper> _objScreenWrappersList;
	public static ArrayList<ScreenPartWrapper> _objScreenPartWrappersList;
	public static ArrayList<ElementWrapper> _objElementWrapperList;

	public static ArrayList<ScreenWrapper> _objTempScreenWrappersList;
	public static ArrayList<ScreenPartWrapper> _objTempScreenPartWrappersList;
	public static ArrayList<ElementWrapper> _objTempElementWrapperList;


	// All For Show Updates

	//This _objList Content Date list of news with Desc order
	public static ArrayList<String> _objDateShowUpdateList;
	//This _objlist will store news accoridng to _objDateShowUpdateList.
	public static ArrayList<ArrayList<ShowUpdatesWrapper>> _objShowUpdateList;
	//This object just a new formate of _objDateShowUpdateList.
	public static ArrayList<ShowUpdateItem> ShowUpdateitems ;

	// For PictureGaleryCategory 
	public static ArrayList<PictureGalleryCategoryWrapper> PictureGaleryCategoryList ;
	public static String CatagoryCode="" ;
	public static String CatagoryName="" ;

	// For PictureGaleryGrid 
	//	public static ArrayList<PictureGalleryGridWrapper> PictureGaleryGridList ;

	// For PictureGaleryGrid 
	public static ArrayList<VideoGalleryListWrapper> VideoGalleryList ;

	//	public static ArrayList<ShowUpdatesWrapper> _objShow_Updates;
	public static ArrayList<ShowUpdatesWrapper> _objShow_UpdatesNew;
	public static ArrayList<ShowUpdatesWrapper> _objShow_UpdatesUpdate;
	//	public static ArrayList<ShowUpdatesWrapper> _objShow_UpdatesDelete;

	public static ShowUpdatesWrapper ShowUpdateWrapperForDetail;
	public static EventsWrapper EventsWrapperForDetail;

	// *****   For EMG Screen Xml Sync ****

	public static String ScreenFileName="";
	public static String ScreenFilePath="";
	public static String imageFilePath="";

	// *****   For Html  Pages Sync ****

	public static String HTMLScreenFileName="";
	public static String HTMLScreenFilePath="";

	//  Event Page Lists
	public static ArrayList<ArrayList<EventsWrapper>> _objEventSectionList;
	public static VideoGalleryListWrapper _objVideoGalleryListWrapper;

	// Event Time List It will contain Time Period Starting 2 letters like "hh"
	public static ArrayList<String> _objEventTimeList;

	public static ArrayList<EventsWrapper> _objEventsWrapperList;
	public static ArrayList<EventItem> Eventitems ;
	public static HashMap<String, Typeface> fontmap ;

	// Created by Puneet
	//	public static ArrayList<String> _objEventDayButtonsList;

	// ExhibitorDirectory Arraylist
	public static ArrayList<ExhibitorDirectoryWrapper> _objExhibitorDirectoryList;

	public static MyUIApplication instance;
	public static boolean isFIrstTymLogger;

	public static Typeface tf;
	public static Typeface fontStyle;
	public static String elementCode="-1";
	public static int exhibitornumbeinList=-1;

	public static String exhibitorproductName="-1";

	public static String UserName="";

	public static HashMap<String, ArrayList<Message>> UserMessageArray = new HashMap<String, ArrayList<Message>>();
	public static HashMap<String, Integer> UserMessageCount = new HashMap<String, Integer>();

	/**
	 * Saurabh changes  100220141816
	 */
	public static PreferencesManager pref;
	public static Boolean checkUpdateCategory	=	false;
	public static Boolean checkShowUpdate	=	false;
	public static String globel_instance	=	"";
	public static VideoGalleryListWrapper globel_video_wrapper	=	new VideoGalleryListWrapper();
	public static String imageMode="";
	public MyUIApplication()
	{
		instance = this;
	}
	public static Context getContext() 
	{
		return instance;
	}



	public void startService()

	{
		Intent myIntent = new Intent(this,GetMessageService.class);
		AlarmManager alarmMgr=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

		PendingIntent pendingIntent = PendingIntent.getService(this, 0, myIntent, 0);

		Calendar calender =Calendar.getInstance();
		calender.setTimeInMillis(System.currentTimeMillis());
		calender.add(Calendar.SECOND, 10);


		alarmMgr.set(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(), pendingIntent);

	}

	@Override
	public void onCreate() 
	{
		// TODO Auto-generated method stub
		super.onCreate();
		try {
			//Loading meta data from Android Manifest
			ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
			Object client = (Object)ai.metaData.get("client");
			Object HardcoredClientCode = (Object)ai.metaData.get("HardcoredClientCode");
			Object HardcoredEventCode = (Object)ai.metaData.get("HardcoredEventCode");
			Object EMGUrl = (Object)ai.metaData.get("EMGUrl");
			Object mainDirectoryName = (Object)ai.metaData.get("mainDirectoryName");
			//			CommonUtilities.SENDER_ID = (String)ai.metaData.get("pushsenderid");
			CommonUtilities.SENDER_ID = getResources().getString(R.string.push_sender_id);
			MyUIApplication.client =(String) client;

			if(client.equals("HardCoded")){
				MyUIApplication.ClientCode =(String) HardcoredClientCode;
				MyUIApplication.EventCode =(String) HardcoredEventCode;
				showclientscreen	=	false;
			}

			MyUIApplication.mainDirectoryName =(String) mainDirectoryName;
			MyUIApplication.EMGUrl =(String) EMGUrl;

		} catch (Exception e) {
			// TODO: handle exception
		}


		/*****************************Loading Font in Hash Map**************************/
		fontmap = new HashMap<String, Typeface>();
		tf = Typeface.createFromAsset(getAssets(),"fonts/Hero.otf");
		fontmap.put("Hero", tf);
		tf = Typeface.createFromAsset(getAssets(),"fonts/MYRIADPRO-REGULAR.OTF");
		fontmap.put("Myriad-Pro", tf);
		tf = Typeface.createFromAsset(getAssets(),"fonts/RupeeForadianStandard.ttf");
		fontStyle = Typeface.createFromAsset(getAssets(),"fonts/RupeeForadianStandard.ttf");
		fontmap.put("Rupee Foradian Standard", tf);
		tf = Typeface.createFromAsset(getAssets(),"fonts/AnjaliOldLipi.ttf");
		fontmap.put("AnjaliOldLipi", tf);


		/***********************************Method to create Directory in Sd Card*******************/
		createSDDirectories();

		/**********************************App Db Module, initialize  all Db object********************/
		try
		{
			System.out.println("APlication Db Modules");
			if(isDBPresent())
			{
				LoggerToSD("From Root DB ", " DB Created");
				try {
					myDBAdaptor.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				myDB=myDBAdaptor.openDataBase();

				/********************initialize Db Object here*****************************/
				_objElementDB =new ElementDB(myDBAdaptor);
				_objScreenDB = new ScreenDB(myDBAdaptor);
				_objShowUpdateDB = new ShowUpdateDB(myDBAdaptor);
				_objShowUpdateCategoryDB = new ShowUpdateCategoryDB(myDBAdaptor);
				_objProductListDB = new ProductListDB(myDBAdaptor);
				_objSpeakerListDB = new SpeakerListDB(myDBAdaptor);
				_objSpeakerSeminarDB = new SpeakerSeminarDB(myDBAdaptor);
				_objEventsDB = new EventsDB(myDBAdaptor);
				_objPictureGalleryDB = new PictureGalleryDB(myDBAdaptor);
				_objPictureGalleryGridDB = new PictureGalleryGridDB(myDBAdaptor);
				_objScreenPartDB = new ScreenPartDB(myDBAdaptor);
				_objSyncTimeDB = new SyncTimeDB(myDBAdaptor);
				_objMyExhiDB = new MyExhiDB(myDBAdaptor);
				_objFriendsListDB = new FriendsListDB(myDBAdaptor);
				_objClientEventDB = new ClientEventDB(myDBAdaptor);
				_objVideoGalleryDB = new VideoGalleryDB(myDBAdaptor);
				_objPushDB = new PushNotificationDB(myDBAdaptor);

			}
			else
			{
				LoggerToSD("From Root macdprod DB ", "Could copy macdprod DB Created");
			}

		}catch(Exception ex)
		{
			LoggerToSD("From Root  DB ", ex.toString());
		}

		/************initialize the preference manager*********************/
		pref	=	new PreferencesManager(this);
	}


	//  Method for detecting internet availability
	public static boolean isInternetAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		// test for connection
		if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable()
				&& cm.getActiveNetworkInfo().isConnected()) 
		{
			return true;
		}
		else 
		{
			//Log.v("APP_ROOT", "Internet Connection Not Present");
			return false;
		}
	}


	public static void AlertForInternet(final Context context)
	{
		new AlertDialog.Builder(context)
		.setTitle("Internet Not Available")
		.setMessage("")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) { 
				// continue with delete
				try
				{

					((Home)context).clearAllResources();
					if(UtilVideoGalleryDetail.videoview.isPlaying())
					{
						UtilVideoGalleryDetail.videoview.stopPlayback();
					}
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}

				MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
				System.out.println("State Machine"+MyUIApplication.StateMachine);
				if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
				{
					//					((Home)context).DesignHomeScreen();
					((Home)context).OpenHtmlPage("0", "");

					if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
					{
						((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
						((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
					}
					if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
					{
						((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
						((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
					}


				}
				else
				{
					String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);


					//										if(LastScreen.equals("112"))
					//										{
					//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
					//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
					//										}
					//										else if(LastScreen.equals("113"))
					//										{
					//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
					//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
					//										}
					//										else if(LastScreen.equals("114"))
					//										{
					//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
					//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
					//										}

					((Home)context).OpenHtmlPage(LastScreen,"");

					if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
					{
						((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
						((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
					}
					if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
					{
						((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
						((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
					}

				}
			}
		}).show();

	}


	public static void AlertString(final Context context,String str)
	{
		new AlertDialog.Builder(context)
		.setTitle(str)
		.setMessage("").setCancelable(false)
		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) { 
				// continue with delete
			}
		}).show();
	}

	/*
	 *   Method For Creating Folder in SD Card
	 */

	public void createSDDirectories()
	{
		try{


			File sdEMPF = new File(Environment.getExternalStorageDirectory(), MyUIApplication.mainDirectoryName);

			if(sdEMPF.mkdirs())
			{
				Log.i("sdSignature Dir Created","Signature Dir Created");

			}
			else
				Log.i("sdEMPF Dir already Created","EventsMobilePlatform Dir already Created");

			/*********************No need KD_120220141312*******************************************/
			//			File sdZIPED= new File(Environment.getExternalStorageDirectory()+"/"+mainDirectoryName,"ZIPED");
			//			if(sdZIPED.mkdirs())
			//			{
			//				Log.i("sdXml Dir Created","sdXml Dir Created");
			//
			//			}
			//			else
			//				Log.i("sdXml Dir already Created","sdXml Dir already Created");
			//
			//
			//			File sdUNZIPED= new File(Environment.getExternalStorageDirectory()+"/"+mainDirectoryName,"UNZIP");
			//			if(sdUNZIPED.mkdirs())
			//			{
			//				Log.i("sdXml Dir Created","sdXml Dir Created");
			//
			//			}
			//			else
			//				Log.i("sdXml Dir already Created","sdXml Dir already Created");

		}
		catch(Exception ex)
		{
			Log.i("ex in creating file Structure from myuiapplication", ex.toString());
		}
	}


	// Method For Checking Image in SD Card Is available or not

	public static boolean IsSdCardImageAvailable(String ImageName)
	{
		File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/"+mainDirectoryName+"/"+ClientCode+"/"+EventCode+"/UNZIP/ImagePacket/"+ImageName);

		if(sdMiddlefileImage.exists()){
			return true;
		}else{ 
			return false;
		}
	}

	public boolean isDBPresent() throws IOException
	{
		myDBAdaptor= DBAdapter.getDBAdapterInstance(this);
		return myDBAdaptor.createDataBase();
	}

	public static void LoggerToSD(String tag,String msg)
	{
//		Log.i(tag, msg);

		try {
			File sdDir = Environment.getExternalStorageDirectory();
			if (sdDir.canWrite()) {

				File dir = MyUIApplication.SDCardPath("/"+mainDirectoryName+"/LOG/");

				File logFile = new File (sdDir, "/"+mainDirectoryName+"/LOG/myLogger"+getDateTimeString(true)+".emp");
				if(logFile.exists())
				{	

					FileWriter logFileWriter = new FileWriter(logFile,true);

					PrintWriter zLogWriter = new PrintWriter(logFileWriter);

					zLogWriter.write("\r\n "+ getDateTimeString(false)+" "+tag+"\n"+ msg);  
					zLogWriter.flush();
				}
				else
				{
					logFile.createNewFile();
					FileWriter logFileWriter = new FileWriter(logFile,true);

					PrintWriter zLogWriter = new PrintWriter(logFileWriter);

					zLogWriter.write("for version "+ getDateTimeString(false)+tag+"\n"+ msg);  
					zLogWriter.flush();
				}

			}
			isFIrstTymLogger=true;
		} catch (IOException e) {
			Log.e("ZLogger", "Count not write to file: " + e.getMessage());
			e.printStackTrace();

		}
	}

	public static String getDateTimeString(boolean islooger)
	{
		String s;
		Format formatter;
		Date date = new Date();
		if(islooger)
			formatter = new SimpleDateFormat( "ddMMyyyyHH");
		else
			formatter = new SimpleDateFormat( "dd/MM/yyyy%20HH:mm:ss");
		s = formatter.format(date);

		return s;
	}

	// Method For Returning File For mnt SDCard Path

	public static File SDCardPath(String Path)
	{
		File root = android.os.Environment.getExternalStorageDirectory();               

		File dir = new File (root.getAbsolutePath() +Path);

		if(dir.exists()==false) {
			dir.mkdirs();
		}
		return dir;
	}


	/*
	 *  Home Parser
	 */

	public static void HomeParser(Context context,String url)
	{
		try 
		{
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			HomeScreenParser myXMLHandler = new HomeScreenParser(url);   
			xr.setContentHandler(myXMLHandler);

			String XmlPathInSDCard = "/"+mainDirectoryName+"/"+ ClientCode+"/"+EventCode+"/xmls"+"/"+ "screen"+".xml";

			File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
			boolean b = f.exists();

			if(f.exists())
			{
				URL sourceUrl = new URL("file://" + Environment.getExternalStorageDirectory() +XmlPathInSDCard);
				xr.parse(new InputSource(sourceUrl.openStream()));
			}
			else
			{


				//				xr.parse(new InputSource(context.getResources().openRawResource(R.raw.jlfl_latest)));
			}

			//			if(url.equals("Local"))
			//			{
			//				
			//				
			//				/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			//				
			//				HomeScreenParser myXMLHandler = new HomeScreenParser(url);   // url ="Local"
			//				xr.setContentHandler(myXMLHandler);
			//				
			//				
			//				xr.parse(new InputSource(context.getResources().openRawResource(R.raw.puru)));
			//				//			xr.parse(new InputSource(sourceUrl.openStream()));
			//			}
			//			else if(url.equals("Live"))
			//			{
			//				String s=ScreenFilePath;
			//
			//				String getPerferenceTable=MyUIApplication.getPerferenecTable(MyUIApplication.getContext());
			//				String urlData=getPerferenceTable;
			//
			//				/** Send URL to parse XML Tags */
			//				URL sourceUrl = new URL(urlData);
			//
			//				/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			//				HomeScreenParser myXMLHandler = new HomeScreenParser(url);      // url ="Live"
			//				xr.setContentHandler(myXMLHandler);
			//
			//				//				xr.parse(new InputSource(context.getResources().openRawResource(R.raw.emg_screen)));
			//				xr.parse(new InputSource(sourceUrl.openStream()));
			//			}
			//			else if(url.equals("Refresh"))
			//			{
			//				String s=ScreenFilePath;
			//
			//				String getPerferenceTable=MyUIApplication.getPerferenecTable(MyUIApplication.getContext());
			//				String urlData=getPerferenceTable;
			//
			//				/** Send URL to parse XML Tags */
			//				URL sourceUrl = new URL(urlData);
			//
			//				/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			//				HomeScreenParser myXMLHandler = new HomeScreenParser(url);      // url ="Live"
			//				xr.setContentHandler(myXMLHandler);
			//
			//				//				xr.parse(new InputSource(context.getResources().openRawResource(R.raw.emg_screen)));
			//				xr.parse(new InputSource(sourceUrl.openStream()));
			//			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			
			System.out.println("Exception in "+url+"of try of screenParser in"+e);
			try
			{

				/** Handling XML */
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				XMLReader xr = sp.getXMLReader();

				/** Create handler to handle XML Tags ( extends DefaultHandler ) */

				HomeScreenParser myXMLHandler = new HomeScreenParser("Local");
				xr.setContentHandler(myXMLHandler);

				//				File f = new File(Environment.getExternalStorageDirectory() +"/EventsMobilePlatform/xmls/"+ MyUIApplication.ClientCode+MyUIApplication.EventCode+".xml");
				//				boolean b = f.exists();
				//				
				//				if(f.exists())
				//				{
				//					URL sourceUrl = new URL("file://" + Environment.getExternalStorageDirectory() +"/EventsMobilePlatform/xmls/"+ MyUIApplication.ClientCode+MyUIApplication.EventCode+".xml");
				//					xr.parse(new InputSource(sourceUrl.openStream()));
				//				}
				//				else
				//				{
				//					xr.parse(new InputSource(context.getResources().openRawResource(R.raw.jlfl_latest)));
				//				}
				//			xr.parse(new InputSource(sourceUrl.openStream()));
			}
			catch (Exception ex)
			{
				// TODO: handle exception
				System.out.println("Exception in Parsing Catch Screen $$$$$"+ex);
			}
		}
	}
	/*
	 *  Sync EMG Screen xml Parser
	 */
	/********************************************************Screen XML parser********************************/

	public static void SyncTimeScreenParser(Context context,String url)
	{
		try 
		{
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			SyncForXmlWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeForXmlWrapper(ClientCode, EventCode);

			/*
			 * Syncing the Html Page
			 */

			//			http://203.190.149.92/EventMobile/Services/GetScreenXML.aspx?ClientCode=DJPG&EventCode=JJS2013&synctimestamp=08/04/2013%2010:43:00

			String XmlPathInSDCard = "/"+mainDirectoryName+"/"+ ClientCode+"/"+EventCode+"/xmls"+"/"+ "screen"+".xml";

			File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
			boolean b = f.exists();


			String URl1=EMGUrl+"GetScreenXML.aspx?ClientCode="+ ClientCode +"&EventCode="+ EventCode +"&synctimestamp=";
			if( _obj.Date_time==null )
			{
				URl1= URl1+context.getResources().getString(R.string.sync_time);
			}
			else if(!f.exists())
			{
				URl1= URl1+context.getResources().getString(R.string.sync_time);
			}
			else
			{
				URl1= URl1+_obj.Date_time;

			}

			String urlData=URl1;
			Log.e("URL", urlData);
			urlData=urlData.replace(" ", "%20");
			/** Send URL to parse XML Tags */
			//			URL sourceUrl = new URL(urlData);
			//			xr.parse(new InputSource(sourceUrl.openStream()));

			HttpGet request = new HttpGet(urlData);
			HttpParams httpParams = new BasicHttpParams();
			int some_reasonable_timeout = 8000;
			HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpResponse response = client.execute(request);
			String ciper = EntityUtils.toString(response.getEntity());

			SyncParser myXMLHandler = new SyncParser();
			xr.setContentHandler(myXMLHandler);

			xr.parse(new InputSource(new StringReader(ciper)));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
			e.printStackTrace();
		}
	}


	/**************************************************HTML Page parser****************************************************/
	/*
	 *  Sync Html Pages Parser
	 */
	public static void SyncTimeHTMLParser(Context context, String Name,String PageCode)
	{
		try 
		{
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();



			/** Send URL to parse XML Tags */
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper(PageCode);

			/*
			 * Syncing the Html Page
			 */

			String URl1=MyUIApplication.EMGUrl+"GetHtmlPages.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&PageCode="+PageCode+"&OS=OS002&synctimestamp=";
			if( _obj.Date_time==null )
			{
				//				URl1= URl1+"18/03/2013%2015:25:41";
				URl1= URl1+"null";
			}
			else
			{
				URl1= URl1+_obj.Date_time;

			}

			String urlData=URl1;
			urlData=urlData.replace(" ", "%20");

			System.out.println("Url->>"+urlData);
			/** Create handler to handle XML Tags ( extends DefaultHandler ) */


			HttpGet request = new HttpGet(urlData);
			HttpParams httpParams = new BasicHttpParams();
			int some_reasonable_timeout = 8000;
			HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpResponse response = client.execute(request);
			String ciper = EntityUtils.toString(response.getEntity());


			SyncHtmlParser myXMLHandler = new SyncHtmlParser(Name);
			xr.setContentHandler(myXMLHandler);
			xr.parse(new InputSource(new StringReader(ciper)));

		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}


	// Show Update Parser

	public static String showUpdateCategoryCode="All";
	public static String showUpdateShowTickCategoryCode="All";

	public static String speakerId="-1";
	//	public static String friends="-1";


	/********************************************************************Screen Type Specific parsers***********************/

	//Check for update in show event
	public static void ShowUpdatesParser(Context context,boolean forbadge)
	{
		String sa =MyUIApplication.showUpdateCategoryCode;
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
//			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("showupdate_"+MyUIApplication.globel_instance+"_"+showUpdateCategoryCode);
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("showupdate_"+MyUIApplication.globel_instance+"_"+"All");

//			String url=EMGUrl+"ShowUpdate.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&CategoryCode="+showUpdateCategoryCode;
			String url=EMGUrl+"ShowUpdate.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&CategoryCode="+"All";
			if(_obj.Date_time==null ||_obj.Date_time.equals("NaN") )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+_obj.Date_time;
			_obj=null;

			if(globel_instance.length() > 0){
				url=url+"&instance="+globel_instance;
			}

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);

			URL sourceUrl = new URL(url);


			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			ShowUpdatesParser myXMLHandler = new ShowUpdatesParser(context,forbadge);

			xr.setContentHandler(myXMLHandler);

			//			xr.parse(new InputSource(context.getResources().openRawResource(R.raw.show_updates)));
			xr.parse(new InputSource(sourceUrl.openStream()));


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}

	public static void FriendsListParser(Context context,boolean forbadge)
	{
		String sa =MyUIApplication.showUpdateCategoryCode;
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			String time=MyUIApplication._objFriendsListDB.getTimeStamp();

			String url=EMGUrl+"GetFriendList.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&UserName="+UserName;
			if(time.trim().length()==0 )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+time;

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);

			URL sourceUrl = new URL(url);


			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			GetFriendsListParser myXMLHandler = new GetFriendsListParser(context,forbadge);

			xr.setContentHandler(myXMLHandler);

			//			xr.parse(new InputSource(context.getResources().openRawResource(R.raw.show_updates)));
			xr.parse(new InputSource(sourceUrl.openStream()));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}

	// Show Update Category Parser

	public static void ShowUpdatesCategoryParser(Context context,boolean forbadge)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			String updateTime =MyUIApplication._objShowUpdateCategoryDB.getTimeStamp();

			String url=EMGUrl+"ShowUpdateCategory.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode;
			if(updateTime.length()==0 ||updateTime.equals("NaN") )
			{
				url=url+"&synctimestamp=02/05/2013 00:00:00";
			}
			else
				url=url+"&synctimestamp="+updateTime;

			if(globel_instance.length() > 0){
				url=url+"&instance="+globel_instance;
			}

			url=url.replaceAll(" ", "%20");

			System.out.println(url);

			HttpGet request = new HttpGet(url);
			HttpParams httpParams = new BasicHttpParams();
			int some_reasonable_timeout = 8000;
			HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpResponse response = client.execute(request);
			String ciper = EntityUtils.toString(response.getEntity());

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			mobi.neuerung.Parser.ShowUpdatesCategoryParser myXMLHandler = new mobi.neuerung.Parser.ShowUpdatesCategoryParser(context,forbadge);
			xr.setContentHandler(myXMLHandler);
			xr.parse(new InputSource(new StringReader(ciper)));



		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}

	// Get speaker seminars list Parser

	public static void SpeakerSeminarsParser(Context context,boolean forbadge)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			String updateTime =MyUIApplication._objSpeakerSeminarDB.getTimeStamp();

			String url=EMGUrl+"GetMapSpeaker.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&SpeakerID="+speakerId;
			if(updateTime.length()==0 ||updateTime.equals("NaN") )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+updateTime;

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);

			URL sourceUrl = new URL(url);


			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			mobi.neuerung.Parser.SpeakerSeminarParser myXMLHandler = new mobi.neuerung.Parser.SpeakerSeminarParser(context,forbadge);

			xr.setContentHandler(myXMLHandler);

			//			xr.parse(new InputSource(context.getResources().openRawResource(R.raw.show_updates)));
			xr.parse(new InputSource(sourceUrl.openStream()));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}

	// Get Speaker List Parser

	public static void GetSpeakerListParser(Context context,boolean forbadge)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			String updateTime =MyUIApplication._objSpeakerListDB.getTimeStamp();

			String url=EMGUrl+"GetSpeakers.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode;
			if(updateTime.length()==0 ||updateTime.equals("NaN") )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+updateTime;

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);

			URL sourceUrl = new URL(url);


			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			mobi.neuerung.Parser.GetSpeakerListParser myXMLHandler = new mobi.neuerung.Parser.GetSpeakerListParser(context,forbadge);

			xr.setContentHandler(myXMLHandler);

			//			xr.parse(new InputSource(context.getResources().openRawResource(R.raw.show_updates)));
			xr.parse(new InputSource(sourceUrl.openStream()));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}

	// Get Messages Parser

	public static void GetMessagesParser()
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */

			String url=EMGUrl+"GetMessage.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&User="+UserName+"&synctimestamp=null";

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);

			URL sourceUrl = new URL(url);


			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			mobi.neuerung.Parser.GetMessageParser myXMLHandler = new mobi.neuerung.Parser.GetMessageParser();

			xr.setContentHandler(myXMLHandler);

			//			xr.parse(new InputSource(context.getResources().openRawResource(R.raw.show_updates)));
			xr.parse(new InputSource(sourceUrl.openStream()));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}
	// Get Product List Parser

	public static void GetProductListParser(Context context,boolean forbadge)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			String updateTime =MyUIApplication._objProductListDB.getTimeStamp();

			String url=EMGUrl+"GetProductList.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&CategoryCode="+exhibitorproductName;
			if(updateTime.length()==0 ||updateTime.equals("NaN") )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+updateTime;

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);

			URL sourceUrl = new URL(url);


			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			mobi.neuerung.Parser.ProductListParser myXMLHandler = new mobi.neuerung.Parser.ProductListParser(context,forbadge);

			xr.setContentHandler(myXMLHandler);

			//			xr.parse(new InputSource(context.getResources().openRawResource(R.raw.show_updates)));
			xr.parse(new InputSource(sourceUrl.openStream()));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}
	// Events Parser

	public static void EventsParser(Context context)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("Events");

			String url=EMGUrl+"EventSchedule.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&synctimestamp=";
			if(_obj.Date_time==null ||_obj.Date_time.equals("NaN") )
			{
				url = url+"null";
			}
			else
				url=url+_obj.Date_time;
			_obj=null;

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);
			URL sourceUrl = new URL(url);

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			EventsParser myXMLHandler = new EventsParser(context);
			xr.setContentHandler(myXMLHandler);
			InputSource inputSource = new InputSource(sourceUrl.openStream());
			//inputSource.setEncoding("iso-8859-1");
			inputSource.setEncoding("ISO-8859-15");
			//xr.parse(new InputSource(context.getResources().openRawResource(R.raw.events)));
			//xr.parse(inputSource);

			xr.parse(new InputSource(sourceUrl.openStream()));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}

	public static void PictureGalleryCategoryParser(Context context)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("PictureGalleryCatagories_"+MyUIApplication.globel_instance);

			String url=EMGUrl+"GetGallaryCategory.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode;
			if(_obj.Date_time==null ||_obj.Date_time.equals("NaN") )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+_obj.Date_time;
			_obj=null;


			if(globel_instance.length() > 0){
				url=url+"&instance="+globel_instance;
			}


			url=url.replaceAll(" ", "%20");

			System.out.println("Picture gallery category:-"+url);

			HttpGet request = new HttpGet(url);
			HttpParams httpParams = new BasicHttpParams();
			int some_reasonable_timeout = 8000;
			HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpResponse response = client.execute(request);
			String ciper = EntityUtils.toString(response.getEntity());


			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			PictureGalleryCategoryParser myXMLHandler = new PictureGalleryCategoryParser(context);

			xr.setContentHandler(myXMLHandler);
			xr.parse(new InputSource(new StringReader(ciper)));

		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}


	/*
	 * Parser for Video Gallery Images
	 */
	public static void VideoGalleryCategoryParser(Context context)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("VideoGalleryCatagories"+"_"+MyUIApplication.globel_instance);

			String url=EMGUrl+"GetVideoCategory.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode;
			if(_obj.Date_time==null ||_obj.Date_time.equals("NaN") )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+_obj.Date_time;
			_obj=null;

			if(globel_instance.length() > 0){
				url=url+"&instance="+globel_instance;
			}


			url=url.replaceAll(" ", "%20");

			//			URL sourceUrl = new URL(url);
			System.out.println(url);


			HttpGet request = new HttpGet(url);
			HttpParams httpParams = new BasicHttpParams();
			int some_reasonable_timeout = 8000;
			HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpResponse response = client.execute(request);
			String ciper = EntityUtils.toString(response.getEntity());

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			mobi.neuerung.Parser.VideoGalleryCategoryParser myXMLHandler = new mobi.neuerung.Parser.VideoGalleryCategoryParser(context);

			xr.setContentHandler(myXMLHandler);

			xr.parse(new InputSource(new StringReader(ciper)));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}
	public static void PictureGalleryGridParser(Context context,String CategoryCode)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			PictureGalleryGridParser myXMLHandler = new PictureGalleryGridParser(context,CategoryCode);
			xr.setContentHandler(myXMLHandler);

			/** Send URL to parse XML Tags */
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("PictureGalleryGrid"+CategoryCode+"_"+MyUIApplication.globel_instance);


			String url=EMGUrl+"GetPictureGallary.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&CategoryCode="+CategoryCode;
			if(_obj.Date_time==null ||_obj.Date_time.equals("NaN") )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+_obj.Date_time;
			_obj=null;

			if(globel_instance.length() > 0){
				url=url+"&instance="+globel_instance;
			}

			url=url.replaceAll(" ", "%20");

			System.out.println("Picture gallery grid parser"+url);

			HttpGet request = new HttpGet(url);
			HttpParams httpParams = new BasicHttpParams();
			int some_reasonable_timeout = 8000;
			HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpResponse response = client.execute(request);
			String ciper = EntityUtils.toString(response.getEntity());

			xr.parse(new InputSource(new StringReader(ciper)));
			//			URL sourceUrl = new URL(url);
			//
			//			xr.parse(new InputSource(sourceUrl.openStream()));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}

	public static void VideoGalleryListParser(Context context,String CategoryCode)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("VideoGalleryList"+CategoryCode);


			String url=EMGUrl+"GetVideoGallery.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&CategoryCode="+MyUIApplication.CatagoryCode;
			if(_obj.Date_time==null ||_obj.Date_time.equals("NaN") )
			{
				url=url+"&synctimestamp=null";
			}
			else
				url=url+"&synctimestamp="+_obj.Date_time;
			_obj=null;

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);


			URL sourceUrl = new URL(url);

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			VideoGalleryListParser myXMLHandler = new VideoGalleryListParser(context,CategoryCode);
			xr.setContentHandler(myXMLHandler);
			xr.parse(new InputSource(sourceUrl.openStream()));
		} 
		catch (Exception e) 
		{
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}


	// Exhibitor Directory Parser
	public static void ExhibitorDirectoryParser(Context context)
	{
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			/** Send URL to parse XML Tags */
			SyncTimeWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("ExhibitorDirectory");
			String url=EMGUrl +"GetExhibitorList.aspx?ClientCode="+ClientCode+"&EventCode="+EventCode+"&synctimestamp=";
			if(_obj.Date_time==null ||_obj.Date_time.equals("NaN") )
			{
				url=url + "null";
			}
			else
				url=url + _obj.Date_time;

			_obj=null;

			url=url.replaceAll(" ", "%20");
			System.out.println("URl"+url);
			URL sourceUrl = new URL(url);

			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			ExhibitorDirectoryParser myXMLHandler = new ExhibitorDirectoryParser(context);
			xr.setContentHandler(myXMLHandler);
			InputSource inputSource = new InputSource(sourceUrl.openStream());
			//inputSource.setEncoding("iso-8859-1");
			inputSource.setEncoding("ISO-8859-15");
			//xr.parse(new InputSource(context.getResources().openRawResource(R.raw.events)));
			//xr.parse(inputSource);

			xr.parse(new InputSource(sourceUrl.openStream()));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);e.printStackTrace();
		}
	}

	// Font Matrix for uuniversal textsize
	public static float calculateHeight(FontMetrics fm)
	{
		return fm.bottom - fm.top;
	}
	// determineTextSize method
	public static int determineTextSize(Typeface font, float allowableHeight) {

		Paint p = new Paint();
		p.setTypeface(font);

		int size = (int) allowableHeight;
		p.setTextSize(size);

		float currentHeight = calculateHeight(p.getFontMetrics());

		while (size!=0 && (currentHeight) > allowableHeight)
		{
			p.setTextSize(size--);
			currentHeight = calculateHeight(p.getFontMetrics());
		}
		if (size==0) 
		{
			System.out.print("Using Allowable Height!!");
			return (int) allowableHeight;
		}
		return size;
	}

	// Return a default Gray Color When Color Gives Exception
	public static int GetColor(String color)
	{
		try
		{
			int Col = Color.parseColor(color);
			return Col;
		}
		catch (Exception e) {
			// TODO: handle exception
			return Color.GRAY;
		}
	}

}
