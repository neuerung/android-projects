package mobi.neuerung.MADP;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import mobi.neuerung.Adapters.ClientEventAdapter;
import mobi.neuerung.BGThread.Splash0Thread;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.ScreenParser.Splash0Parser;
import mobi.neuerung.Wrapper.SplashOWrapper;

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

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Saurabh
 * Screen For Client list in MADP Viewer
 */

public class Splash0 extends Activity
{/**ClientEvent list is actually is Event list With its Client*/

	ListView clientList;
	EditText clientListsearch_et;
	WindowManager mWinMgr;
	public int deviceHeight,deviceWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash0);

		WindowManager mWinMgr = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();

		scandialogLayout =(RelativeLayout) findViewById(R.id.scandialogLayout);

		//Condition to Show Client Screen OR Not
		if(((MyUIApplication)getApplication()).showclientscreen)
		{
			//If Client MetaData is Blank (In Case Of MADP Viewr)
			if(MyUIApplication.client.trim().length()==0)
			{
				//initialize Client list View
				clientList =(ListView) findViewById(R.id.clientList);

				//initialize Search Edit Text view
				clientListsearch_et =(EditText) findViewById(R.id.clientListsearch_et);
				clientListsearch_et.setTypeface(MyUIApplication.fontStyle);

				//Getting meta data to show hint in search edit text view
				try {
					ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
					String SearchHintTextonClient = (String)ai.metaData.get("SearchHintTextonClient");
					clientListsearch_et.setHint(SearchHintTextonClient);
				} catch (Exception e) {
					// TODO: handle exception
				}

				clientListsearch_et.getLayoutParams().height=(int)(.1f*deviceHeight);

				//initialize Back button image View
				ImageView back =(ImageView) findViewById(R.id.exit);
				FrameLayout.LayoutParams params_back =(FrameLayout.LayoutParams) back.getLayoutParams();
				params_back = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
						FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.CENTER_VERTICAL);
				back.getLayoutParams().height = (int)(.08f*deviceHeight);
				back.getLayoutParams().width = (int)(.08f*deviceHeight);
				params_back.leftMargin =(int)(.04f*deviceWidth);

				//initialize scan icon image view
				ImageView scan =(ImageView) findViewById(R.id.scan);
				FrameLayout.LayoutParams params_scan =(FrameLayout.LayoutParams) scan.getLayoutParams();
				params_scan = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
						FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT|Gravity.CENTER_VERTICAL);
				scan.getLayoutParams().height = (int)(.08f*deviceHeight);
				scan.getLayoutParams().width = (int)(.08f*deviceHeight);
				params_scan.rightMargin =(int)(.04f*deviceWidth);
				scan.setLayoutParams(params_scan);

				//Check to show QR code icon or not
				try {
					ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
					Boolean showQRCodeonClient = (Boolean)ai.metaData.get("showQRCodeonClient");
					if(showQRCodeonClient)
					{
						Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(scan, this,"images/qr_code_vote.png", (int)(.08f*deviceHeight), (int)(.08f*deviceHeight));
						if(bmp != null)
						{
							scan.setImageBitmap(bmp);
							scan.setBackgroundDrawable(null);
						}
					}

				} catch (Exception e) {
					// TODO: handle exception
				}

				//Check to show back button or not
				try {
					ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
					Boolean showexitbtn = (Boolean)ai.metaData.get("showexitbtn");
					if(showexitbtn)
					{
						ImageUtil.setBackgroundBgFromAssetsNotCache(back, this,"images/logoff_icon.png", (int)(.08f*deviceHeight), (int)(.08f*deviceHeight));
					}
					else
					{
						//KD_15022014
						//						ImageUtil.setBackgroundBgFromAssetsNotCache(back, this,"images", (int)(.08f*deviceHeight), (int)(.08f*deviceHeight));
					}

				} catch (Exception e) {
					ImageUtil.setBackgroundBgFromAssetsNotCache(back, this,"images", (int)(.08f*deviceHeight), (int)(.08f*deviceHeight));
				}

				//Back Button on Click
				back.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						finish();
						overridePendingTransition(0,R.anim.slide_in_right);
					}
				});


				//QR code icon on click
				scan.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						//Method to show QR Code Dialog box
						showscanDialog();
					}
				});
				//Method to make UI universal
				forUniversal();

				//Method to find list of Clients & show it in listview
				OnPostMethod();
			}
			else
			{//Case of Paathshaala As MyUIApplication.Client="Paathshaala"

				//Method to find list of Clients & show it in listview
				OnPostMethod();
			}
		}
		else
		{//Case when showclientscreen=false Or App is Hard Coded

			// Calling to Start Activity From Splash0.class to Splash.class
			StartActivityToSplash();
		}

		//Load Client Event list for Db
		MyUIApplication.clientEventList = MyUIApplication._objClientEventDB.getRecords();

		if(MyUIApplication.clientEventList!=null || MyUIApplication.clientEventList.size()>0)
		{
			if(MyUIApplication.client.trim().length() == 0){
				if(MyUIApplication.isInternetAvailable(this))
				{
					Splash0Thread	=	new Splash0Thread(this,"GetListOfCLients","");
					Splash0Thread.execute();
				}
			}
		}


	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		try {
			scandialogLayout.setVisibility(View.GONE);
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode==1)
		{
			if(resultCode == RESULT_OK)
			{
				String content = data.getExtras().getString("content");
				Toast.makeText(this,"Content...  "+content, Toast.LENGTH_LONG).show();
			}
		}
	}

	private void forUniversal() {
		// TODO Auto-generated method stub

		FrameLayout headerLayout =(FrameLayout) findViewById(R.id.headerLayout);
		headerLayout.getLayoutParams().height=(int)(.1f*deviceHeight);

		TextView headertext =(TextView) findViewById(R.id.headertext);
		headertext.setTypeface(MyUIApplication.fontStyle);
		headertext.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(headertext.getTypeface(),((int)(deviceHeight*.11f)*(.4f))));
		try {
			ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
			String TitleTextonClient = (String)ai.metaData.get("TitleTextonClient");
			headertext.setText(TitleTextonClient);
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	public void alertForstartBrandedApp()
	{

		try {
			ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
			Object HardcoredClientCode = (Object)ai.metaData.get("HardcoredClientCode");
			new AlertDialog.Builder(this)
			.setMessage("Do you want to reload the app with hardcoded "+HardcoredClientCode)
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent i =new Intent(Splash0.this,Splash.class);
					i.putExtra("Client","Hardcored");
					startActivity(i);
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) { 
					// do nothing

					finish();
				}
			}).show();

		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method have following Two Function
	 * 1. If we already declared the client in Android manifest meta-data and load it to MyUIApplication.client,
	 * this screen simple put this client in intent and load splash.java
	 * 
	 * 2.In Case me there is no client is mention in android manifest metadata, it search for all clients and how it 
	 * in client list View
	 * 
	 * 3. if MyUIApplication.clientEventList is empty ,if run the local parser and then check for the sync for any upadte 
	 * then fill this client event list in MyUIApplication.clientEventList. and reload this method by calling it form
	 * local parser.
	 */

	ArrayList<String> clients;
	ClientEventAdapter adapter;
	public void OnPostMethod()
	{
		try {

			//Load Client Event list for Db
			MyUIApplication.clientEventList = MyUIApplication._objClientEventDB.getRecords();

			if(MyUIApplication.clientEventList==null || MyUIApplication.clientEventList.size()==0)
			{//In Case There is no Clinet and Event Stored in DB, Parse the local XML and Fill the DB

				//This Method Will parse the Local XML and Call OnPostMethod again
				parseLocalclientXML();

			}else if(MyUIApplication.client.trim().length()>0){
				//Case of HardCoded Client like Paathshala

				for (int i = 0; i < MyUIApplication.clientEventList.size(); i++) {

					if(MyUIApplication.clientEventList.get(i).ClientCode.equals(MyUIApplication.client.trim()))
					{

						//Finish background async task on new activity launch
						if(Splash0Thread != null)
							Splash0Thread.cancel(true);


						Intent ii = new Intent(this, Splash.class);
						ii.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
						ii.putExtra("Client",MyUIApplication.clientEventList.get(i).ClientName);
						startActivity(ii);
						overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
						finish();
						break;
					}

				}
			}else{
				//Case if MADP View Load all the Clients of MADP viewr

				clients = new ArrayList<String>();

				//Extract Unique Client Name for ClientEvent List
				/**ClientEvent list is actually is Event list With its Client*/
				for(int i=0;i<MyUIApplication.clientEventList.size();i++)
				{
					boolean duplicate=false;
					for(int size=0;size<clients.size();size++)
					{
						if(clients.get(size).equals(MyUIApplication.clientEventList.get(i).ClientName))
						{
							duplicate=true;
							break;
						}
						else
						{
							duplicate=false;
						}
					}
					if(!duplicate)
						clients.add(MyUIApplication.clientEventList.get(i).ClientName);
				}


				adapter = new ClientEventAdapter(this, R.layout.clienteventlist,clients);
				clientList.setAdapter(adapter);

				clientListsearch_et.addTextChangedListener(new TextWatcher() {
					public void onTextChanged(CharSequence s, int start, int before, int count) {
					}

					public void beforeTextChanged(CharSequence s, int start, int count,
							int after) {
					}

					public void afterTextChanged(Editable s) {

						//Searching Logic Easy to Understand
						if(s.toString().length()==0)
						{

							clients = new ArrayList<String>();
							for(int i=0;i<MyUIApplication.clientEventList.size();i++)
							{
								boolean duplicate=false;
								for(int size=0;size<clients.size();size++)
								{
									if(clients.get(size).equals(MyUIApplication.clientEventList.get(i).ClientName))
									{
										duplicate=true;
										break;
									}
									else
									{
										duplicate=false;
									}
								}
								if(!duplicate)
									clients.add(MyUIApplication.clientEventList.get(i).ClientName);
							}

							adapter = new ClientEventAdapter(Splash0.this, R.layout.clienteventlist,clients);

							clientList.setAdapter(adapter);

						}
						else
						{
							//Filtering List View content
							adapter.getFilter().filter(s.toString());
						}

					}
				});

				//Key Action listener on Search Edit text field
				clientListsearch_et.setOnKeyListener(new OnKeyListener() {
					public boolean onKey(View v, int keyCode, KeyEvent event) {
						if(keyCode==KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN)
						{
							try {
								String s = clientListsearch_et.getText().toString();
								if(s.trim().length()>0)
								{
									adapter.getFilter().filter(s.toString());
								}
							} catch (Exception e) {
							}
							return false;
						}
						return false;
					}
				});
			}
		} catch (Exception e) {
			System.err.println(""+e);
		}

	}

	/*********************************Show QR Code scan dialog box*****************************/
	RelativeLayout scandialogLayout;
	private void showscanDialog()
	{

		scandialogLayout.getBackground().setAlpha(100);
		scandialogLayout.setVisibility(View.VISIBLE);


		RelativeLayout scandialogLayout1 =(RelativeLayout) findViewById(R.id.scandialogLayout1);
		scandialogLayout1.setBackgroundColor(Color.BLACK);
		scandialogLayout1.getBackground().setAlpha(255);
		RelativeLayout.LayoutParams params_scandialogLayout1 =(RelativeLayout.LayoutParams) scandialogLayout1.getLayoutParams();

		params_scandialogLayout1.width =(int)(.8f*deviceWidth);
		params_scandialogLayout1.height =(int)(.35f*deviceHeight);
		params_scandialogLayout1.topMargin =(int)(.14f*deviceHeight);

		//		FrameLayout scanheaderLayout =(FrameLayout) findViewById(R.id.scanheaderLayout);
		//
		//		scanheaderLayout.getLayoutParams().height =(int)(.1f*deviceHeight);
		//
		//		TextView scanheadertext =(TextView) findViewById(R.id.scanheadertext);
		//		scanheadertext.setTypeface(MyUIApplication.fontStyle);
		//		scanheadertext.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
		//				determineTextSize(scanheadertext.getTypeface(),((int)(deviceHeight*.11f)*(.3f))));

		final EditText clientcode_et =(EditText) findViewById(R.id.clientcode_et);
		clientcode_et.setTypeface(MyUIApplication.fontStyle);
		clientcode_et.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(clientcode_et.getTypeface(),((int)(deviceHeight*.11f)*(.25f))));

		clientcode_et.requestFocus();
		RelativeLayout.LayoutParams params_clientcode_et =(RelativeLayout.LayoutParams) clientcode_et.getLayoutParams();

		params_clientcode_et.width =(int)(.6f*deviceWidth);
		params_clientcode_et.height =(int)(.08f*deviceHeight);
		params_clientcode_et.topMargin =(int)(.04f*deviceHeight);


		RelativeLayout separtorll =(RelativeLayout) findViewById(R.id.separtorll);
		RelativeLayout.LayoutParams params_separtorll =(RelativeLayout.LayoutParams) separtorll.getLayoutParams();
		params_separtorll.width =(int)(.6f*deviceWidth);
		params_separtorll.topMargin =(int)(.02f*deviceHeight);

		TextView separtor_text =(TextView) findViewById(R.id.separtor_text);
		separtor_text.setTypeface(MyUIApplication.fontStyle);
		separtor_text.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(separtor_text.getTypeface(),((int)(deviceHeight*.11f)*(.2f))));

		ImageView QRcode_img =(ImageView) findViewById(R.id.QRcode_img);

		RelativeLayout.LayoutParams params_QRcode_img =(RelativeLayout.LayoutParams) QRcode_img.getLayoutParams();
		params_QRcode_img.width =(int)(.1f*deviceHeight);
		params_QRcode_img.height =(int)(.1f*deviceHeight);
		params_QRcode_img.topMargin =(int)(.02f*deviceHeight);
		Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(QRcode_img, this,"images/qr_code_vote.png", (int)(.1f*deviceHeight), (int)(.1f*deviceHeight));

		if(bmp != null)
		{
			QRcode_img.setImageBitmap(bmp);
			QRcode_img.setBackgroundDrawable(null);
		}

		final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

		//This will hide QR code dialog screen
		scandialogLayout.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imm.hideSoftInputFromWindow(clientcode_et.getWindowToken(), 0);
				scandialogLayout.setVisibility(View.GONE);
				return;
			}
		});

		//Click on QR image this will open Capture activity
		QRcode_img.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				imm.hideSoftInputFromWindow(clientcode_et.getWindowToken(), 0);
				Intent intent = new Intent(Splash0.this,CaptureActivity.class);
				intent.putExtra("fromScreen","client");
				startActivityForResult(intent,1);
			}
		});

		//Client Code Entered in Edit text on QR code pop-up
		clientcode_et.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN)
				{
					String s = clientcode_et.getText().toString();

					if(s.trim().length()>0)
					{
						new Splash0Thread(Splash0.this, "GetEventList", s).execute();
					}
				}
				return false;
			}
		});

		try {


			clientcode_et.postDelayed(new Runnable()
			{
				public void run()
				{
					clientcode_et.requestFocus();
					imm.showSoftInput(clientcode_et, 0);
				}
			}, 100);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void ShowEventScreen(ArrayList<SplashOWrapper> _objEventList,String client)
	{
		if(_objEventList != null)
		{
			//Load the Event List Screen with predefined Client 

			MyUIApplication.EventList = _objEventList;

			Intent i = new Intent(this, Splash.class);
			i.putExtra("Client",client);
			startActivity(i);
			overridePendingTransition( mobi.neuerung.MADP.R.anim.slide_in_left, mobi.neuerung.MADP.R.anim.noanim );
		}
		else
		{
			Toast.makeText(this,"Not a valid Client",Toast.LENGTH_LONG).show();
		}
	}

	/****Commented because it's hitting Screen XML
	 * and i dont know why
	 * 
	 */
	//	public void PleaseCheckForSync()
	//	{
	//		if(MyUIApplication.isInternetAvailable(this))
	//		{
	//			new BGXMLSyncThread(this, "CheckForSync").execute();
	//		}
	//		else
	//		{
	//			StartActivityToSplash();
	//		}
	//	}

	private Splash0Thread	Splash0Thread;
	//Load Client Event list form local XML from resource folder
	private void parseLocalclientXML()
	{
		try 
		{
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			//This parser will fill client event value from local XML to Db
			Splash0Parser myXMLHandler = new Splash0Parser(this);
			xr.setContentHandler(myXMLHandler);
			xr.parse(new InputSource(getResources().openRawResource(R.raw.clientdetails)));


		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);


			if(MyUIApplication.isInternetAvailable(this))
			{
				/**
				 * error in local XML parsing
				 * But Internet available now check for XML from Internet
				 */
				Splash0Thread	=	new Splash0Thread(this,"GetListOfCLients","");
				Splash0Thread.execute();
			}else {

				/**
				 * 1. Error in parsing local XML
				 * 2. Internet is not present to download new XML
				 * So the only thing we can do it run app with provided data as hard coded app
				 */
				alertForstartBrandedApp();
			}

		}

		/**
		 * Local XML has been parsed now its time to check for update if Internet present
		 * Parallel load the list view with local XML
		 */

		//Now check if there is any update in Client List Call ClientEventListWithSync service
		if(MyUIApplication.isInternetAvailable(this))
		{
			Splash0Thread	=	new Splash0Thread(this,"GetListOfCLients","");
			Splash0Thread.execute();
		}

		//Call this method again with new Client Event List
		OnPostMethod();
	}

	//	public void FillScreenAfterDownloadFromServer()
	//	{
	//		if(MyUIApplication.ScreenFilePath.length()>0 )
	//		{
	//			new AlertDialog.Builder(this)
	//			.setTitle("Update Application")
	//			.setMessage("New Update Available . Are you want to update now?")
	//			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	//				public void onClick(DialogInterface dialog, int which) { 
	//					// continue with delete
	//					try
	//					{
	//						SyncForXmlWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeForXmlWrapper(MyUIApplication.ClientCode,MyUIApplication.EventCode);
	//
	//						if( _obj.Date_time==null )
	//						{
	//							_obj.ClientCode=MyUIApplication.ClientCode;
	//							_obj.EventCode=MyUIApplication.EventCode;
	//							_obj.Date_time=MyUIApplication.Update_Time_Stamp;
	//							MyUIApplication._objSyncTimeDB.insertRecords(_obj);
	//						}
	//						else
	//						{
	//							_obj.ClientCode=MyUIApplication.ClientCode;
	//							_obj.EventCode=MyUIApplication.EventCode;
	//							_obj.Date_time=MyUIApplication.Update_Time_Stamp;
	//							MyUIApplication._objSyncTimeDB.updateTable(_obj);
	//						}
	//
	//						// Calling For Download Sceen.xml By the Name ClientCode+EventCode.xml 
	//						new Splash0Thread(Splash0.this,"SaveXMLintoSDCard",MyUIApplication.ScreenFilePath).execute();
	//					}
	//					catch (Exception e) 
	//					{
	//						// TODO: handle exception
	//						System.out.println(e);
	//					}
	//				}
	//			})
	//			.setNegativeButton("No", new DialogInterface.OnClickListener() {
	//				public void onClick(DialogInterface dialog, int which) { 
	//					// do nothing
	//
	//					// Calling to Start Activity From Splash0.class to Splash.class
	//					StartActivityToSplash();
	//				}
	//			}).show();
	//		}
	//		else
	//		{
	//			StartActivityToSplash();
	//		}
	//	}
	public void StartActivityToSplash()
	{
		startActivity(new Intent(Splash0.this,Splash.class));
		this.finish();
	}

	/**@BG Splash0Thread
	 * It Check any upadte in Client Event List download it and parse it
	 * @param context
	 */

	public void ParserMethod(Context context )
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

		} catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}
	}


	//	public void DownloadFromUrl(String DownloadUrl, String fileName) {
	//
	//		try {
	//			File dir = MyUIApplication.SDCardPath("/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls");
	//
	//			URL url = new URL(DownloadUrl); //you can write here any link
	//			File file = new File(dir, fileName);
	//
	//			long startTime = System.currentTimeMillis();
	//			Log.d("DownloadManager", "download begining");
	//			Log.d("DownloadManager", "download url:" + url);
	//			Log.d("DownloadManager", "downloaded file name:" + fileName);
	//
	//			/* Open a connection to that URL. */
	//			URLConnection ucon = url.openConnection();
	//
	//			/*
	//			 * Define InputStreams to read from the URLConnection.
	//			 */
	//			InputStream is = ucon.getInputStream();
	//			BufferedInputStream bis = new BufferedInputStream(is);
	//
	//			/*
	//			 * Read bytes to the Buffer until there is nothing more to read(-1).
	//			 */
	//			ByteArrayBuffer baf = new ByteArrayBuffer(5000);
	//			int current = 0;
	//			while ((current = bis.read()) != -1) {
	//				baf.append((byte) current);
	//			}
	//
	//
	//			/* Convert the Bytes read to a String. */
	//			FileOutputStream fos = new FileOutputStream(file);
	//			fos.write(baf.toByteArray());
	//			fos.flush();
	//			fos.close();
	//			Log.d("DownloadManager", "download ready in" + ((System.currentTimeMillis() - startTime) / 1000) + " sec");
	//
	//			// Activity For Splash0 To Splash.java
	//
	//
	//		} catch (IOException e) {
	//			Log.d("DownloadManager", "Error: " + e);
	//		}
	//
	//	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			try {
				if(scandialogLayout.getVisibility()== View.VISIBLE)
				{
					scandialogLayout.setVisibility(View.GONE);
				}
				else
				{
					finish();  
					overridePendingTransition(0,R.anim.slide_in_right);
				}
			} catch (Exception e) {
				finish();  
				overridePendingTransition(0,R.anim.slide_in_right);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
