package mobi.neuerung.MADP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.TimeZone;

import mobi.neuerung.Adapters.ClientEventAdapter;
import mobi.neuerung.BGThread.BGImagePacketThread;
import mobi.neuerung.BGThread.BGThreadHomePage;
import mobi.neuerung.BGThread.BGXMLSyncThread;
import mobi.neuerung.BGThread.ImagePacketSync;
import mobi.neuerung.BGThread.Splash0Thread;
import mobi.neuerung.BGThread.WebUnZippingParserThread;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.ImageScale.Snippet;
import mobi.neuerung.Util.Util;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ScreenWrapper;
import mobi.neuerung.Wrapper.SplashOWrapper;
import mobi.neuerung.Wrapper.SyncForXmlWrapper;
import mobi.neuerung.Wrapper.SyncTimeWrapper;

import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * @author Saurabh
 * Screen For Event list in MADP Viewer
 */

public class Splash extends Activity {

	WindowManager mWinMgr;
	public int deviceHeight,deviceWidth;
	ListView eventList;
	EditText eventListsearch_et;
	ArrayList<String> array = new ArrayList<String>();
	ClientEventAdapter adapter;
	String client="";
	RelativeLayout clientLayout;
	public RelativeLayout hideListClick;
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		//Device Time Zone Detection
		System.out.println(TimeZone.getDefault().getID());
		
		
		
		WindowManager mWinMgr = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();
		scandialogLayout =(RelativeLayout) findViewById(R.id.scandialogLayout);
		hideListClick = (RelativeLayout) findViewById(R.id.hideListClick);
		hideListClick.getBackground().setAlpha(100);
		hideListClick.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			}
		});



	}

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


		scandialogLayout.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				imm.hideSoftInputFromWindow(clientcode_et.getWindowToken(), 0);
				scandialogLayout.setVisibility(View.GONE);
				return;
			}
		});

		QRcode_img.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				imm.hideSoftInputFromWindow(clientcode_et.getWindowToken(), 0);
				Intent intent = new Intent(Splash.this,CaptureActivity.class);
				intent.putExtra("fromScreen","event");
				startActivityForResult(intent,1);
			}
		});

		clientcode_et.setOnKeyListener(new OnKeyListener() {

			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN)
				{
					String s = clientcode_et.getText().toString();

					if(s.trim().length()>0)
					{
						try {
							if(scandialogLayout.getVisibility()== View.VISIBLE)
							{
								scandialogLayout.setVisibility(View.GONE);
							}	
						} catch (Exception e) {
							// TODO: handle exception
						}

						fromcaptureScreen(s);
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


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		try {
			if(scandialogLayout.getVisibility()== View.VISIBLE)
			{
				scandialogLayout.setVisibility(View.GONE);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if(requestCode==1)
		{
			if(resultCode == RESULT_OK)
			{
				String content = data.getExtras().getString("content");
				fromcaptureScreen(content);
			}
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		LinearLayout LLLayout =(LinearLayout) findViewById(R.id.LLLayout);
		clientLayout = (RelativeLayout)findViewById(R.id.clientLayout);

		if(((MyUIApplication)getApplication()).showclientscreen)
		{
//			if(MyUIApplication.isInternetAvailable(this))
//			{
//				new Splash0Thread(this,"GetListOfCLients","").execute();
//			}

			LLLayout.setBackgroundColor(Color.WHITE);
			clientLayout.setVisibility(View.VISIBLE);
			clientLayout.setBackgroundColor(Color.WHITE);
			eventList =(ListView) findViewById(R.id.eventList);
			eventListsearch_et =(EditText) findViewById(R.id.eventListsearch_et);
			eventListsearch_et.setTypeface(MyUIApplication.fontStyle);
			
			//Module for Show Hint in Search Edit view
			try {
				ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
				String SearchHintTextonEvent = (String)ai.metaData.get("SearchHintTextonEvent");
				eventListsearch_et.setHint(SearchHintTextonEvent);
			} catch (Exception e) {
			}
			eventListsearch_et.getLayoutParams().height =(int)(.1f*deviceHeight);

			ImageView back =(ImageView) findViewById(R.id.back);
			ImageView scan =(ImageView) findViewById(R.id.scan);

			FrameLayout.LayoutParams params_back =(FrameLayout.LayoutParams) back.getLayoutParams();
			params_back = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
					FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.CENTER_VERTICAL);

			back.getLayoutParams().height = (int)(.1f*deviceHeight);
			back.getLayoutParams().width = (int)(.1f*deviceHeight);
			params_back.leftMargin =(int)(.04f*deviceWidth);

			FrameLayout.LayoutParams params_scan =(FrameLayout.LayoutParams) scan.getLayoutParams();
			params_scan = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
					FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT|Gravity.CENTER_VERTICAL);

			scan.getLayoutParams().height = (int)(.08f*deviceHeight);
			scan.getLayoutParams().width = (int)(.08f*deviceHeight);
			params_scan.rightMargin =(int)(.04f*deviceWidth);
			scan.setLayoutParams(params_scan);
			
			/**
			 * Module to show Qr Code Image (True/False)
			 */
			try {
				ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
				Boolean showQRCodeonEvent = (Boolean)ai.metaData.get("showQRCodeonEvent");
				if(showQRCodeonEvent)
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

			/**
			 * Module to Show Back Button (True/False)
			 */
			try {
				ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
				Boolean showbackonevent = (Boolean)ai.metaData.get("showbackonevent");
				if(showbackonevent)
				{
					ImageUtil.setBackgroundBgFromAssetsNotCache(back, this,"images/back_button.png", (int)(.08f*deviceHeight), (int)(.08f*deviceHeight));
				}
				else
				{
					//KD_150220141109
//					ImageUtil.setBackgroundBgFromAssetsNotCache(back, this,"images", (int)(.08f*deviceHeight), (int)(.08f*deviceHeight));
				}

			} catch (Exception e) {
				// TODO: handle exception
				ImageUtil.setBackgroundBgFromAssetsNotCache(back, this,"images", (int)(.08f*deviceHeight), (int)(.08f*deviceHeight));
			}

			//@back press action
			back.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					finish();
					overridePendingTransition(0,R.anim.slide_in_right);
				}
			});

			//Click on QR Code popup , it will show the QR code scanner dialog
			scan.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					showscanDialog();
				}
			});


			forUniversal();
			Bundle b = getIntent().getExtras();

			if(b != null)
			{
				client = b.getString("Client");
				
				if(client.equals("HardCoded"))
				{//Condition to load hard Coded App
					try {
						ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
						Object HardcoredClientCode = (Object)ai.metaData.get("HardcoredClientCode");
						Object HardcoredEventCode = (Object)ai.metaData.get("HardcoredEventCode");

						MyUIApplication.EventCode =(String)HardcoredEventCode;
						MyUIApplication.ClientCode =(String) HardcoredClientCode;

						String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

						File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
						boolean bb = f.exists();
						if(!bb)
						{
							new WebUnZippingParserThread(Splash.this,"loadhardcoded").execute();
						}

						PleaseCheckForSync();

					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else
				{
					array = new ArrayList<String>();
					for (int i = 0; i < MyUIApplication.clientEventList.size(); i++) {

						if(MyUIApplication.clientEventList.get(i).ClientName.equals(client))
						{
							if(MyUIApplication.clientEventList.get(i).EventName.trim().length()>0)
								array.add(MyUIApplication.clientEventList.get(i).EventName);
						}

					}
					
					//Case OF MADP Viewer
					if(array.size()==0 && MyUIApplication.EventList.size()==0)
					{
						try {

							ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
							final Object HardcoredClientCode = (Object)ai.metaData.get("HardcoredClientCode");
							final Object HardcoredEventCode = (Object)ai.metaData.get("HardcoredEventCode");


							//						final String HardcoredClientCode = getResources().getString(R.string.HardcoredClientCode);
							//						final String HardcoredEventCode = getResources().getString(R.string.HardcoredEventCode);


							new AlertDialog.Builder(this)

							.setMessage("No event for "+client+". Do you want to reload the app with hardcoded "+HardcoredClientCode).setCancelable(false)
							.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) {

									//						((MyUIApplication)getApplication()).showclientscreen = false;

									//						LinearLayout LLLayout =(LinearLayout) findViewById(R.id.LLLayout);
									//						clientLayout.setVisibility(View.GONE);
									//						LLLayout.setBackgroundResource(R.drawable.defaultsplash);
									MyUIApplication.EventCode =(String)HardcoredEventCode;
									MyUIApplication.ClientCode =(String)HardcoredClientCode;

									String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

									File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
									boolean b = f.exists();
									if(!(b))
									{
										new WebUnZippingParserThread(Splash.this,"loadhardcoded").execute();
									}

									PleaseCheckForSync();



									//						StartActivityToSplash();


								}
							})
							.setNegativeButton("No", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) { 
									// do nothing

									finish();
									overridePendingTransition(0,R.anim.slide_in_right);
								}
							}).show();

						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					else if(MyUIApplication.EventList.size()>0)
					{//Case of QR Code Scanner
						array = new ArrayList<String>();
						for (int i = 0; i < MyUIApplication.EventList.size(); i++) {

							array.add(MyUIApplication.EventList.get(i).EventName);

						}

						adapter = new ClientEventAdapter(this, R.layout.clienteventlist,array);
						eventList.setAdapter(adapter);


						eventListsearch_et.addTextChangedListener(new TextWatcher() {

							public void onTextChanged(CharSequence s, int start, int before, int count) {
								// TODO Auto-generated method stub

							}

							public void beforeTextChanged(CharSequence s, int start, int count,
									int after) {
								// TODO Auto-generated method stub

							}

							public void afterTextChanged(Editable s) {
								// TODO Auto-generated method stub

								if(s.toString().length()==0)
								{

									array = new ArrayList<String>();
									for (int i = 0; i < MyUIApplication.clientEventList.size(); i++) {

										if(MyUIApplication.clientEventList.get(i).ClientName.equals(client))
										{
											if(MyUIApplication.clientEventList.get(i).EventName.trim().length()>0)
												array.add(MyUIApplication.clientEventList.get(i).EventName);
										}

									}

									adapter = new ClientEventAdapter(Splash.this, R.layout.clienteventlist,array);
									eventList.setAdapter(adapter);

								}
								else
								{
									adapter.getFilter().filter(s.toString());
								}

							}
						});

						eventListsearch_et.setOnKeyListener(new OnKeyListener() {

							public boolean onKey(View v, int keyCode, KeyEvent event) {
								// TODO Auto-generated method stub

								if(keyCode==KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN)
								{

									try {
										String s = eventListsearch_et.getText().toString();
										if(s.trim().length()>0)
										{
											adapter.getFilter().filter(s.toString());
										}
									} catch (Exception e) {
										// TODO: handle exception
									}

									return false;
								}

								return false;
							}
						});



					}
					else
					{
						adapter = new ClientEventAdapter(this, R.layout.clienteventlist,array);
						eventList.setAdapter(adapter);


						eventListsearch_et.addTextChangedListener(new TextWatcher() {

							public void onTextChanged(CharSequence s, int start, int before, int count) {
							}

							public void beforeTextChanged(CharSequence s, int start, int count,
									int after) {
							}

							public void afterTextChanged(Editable s) {
								// TODO Auto-generated method stub

								if(s.toString().length()==0)
								{

									array = new ArrayList<String>();
									for (int i = 0; i < MyUIApplication.clientEventList.size(); i++) {

										if(MyUIApplication.clientEventList.get(i).ClientName.equals(client))
										{
											if(MyUIApplication.clientEventList.get(i).EventName.trim().length()>0)
												array.add(MyUIApplication.clientEventList.get(i).EventName);
										}

									}

									adapter = new ClientEventAdapter(Splash.this, R.layout.clienteventlist,array);
									eventList.setAdapter(adapter);

								}
								else
								{
									adapter.getFilter().filter(s.toString());
								}

							}
						});

						eventListsearch_et.setOnKeyListener(new OnKeyListener() {

							public boolean onKey(View v, int keyCode, KeyEvent event) {
								// TODO Auto-generated method stub

								if(keyCode==KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_DOWN)
								{

									try {
										String s = eventListsearch_et.getText().toString();
										if(s.trim().length()>0)
										{
											adapter.getFilter().filter(s.toString());
										}
									} catch (Exception e) {
										// TODO: handle exception
									}

									return false;
								}

								return false;
							}
						});

					}
				}
			}

		}
		else
		{
			clientLayout.setVisibility(View.GONE);
			
			/********************************************Change Client Splash Screen Here**********************/
//			LLLayout.setBackgroundResource(R.drawable.splash_screen); //Splash for NMSJU
//			LLLayout.setBackgroundResource(R.drawable.oaktree_splash); //Screen For ocktree
			LLLayout.setBackgroundResource(R.drawable.splash); //Screen For Client_event
			Bitmap bmp	= Snippet.decodeSampledBitmapFromResource(getResources(),R.drawable.splash,deviceWidth,deviceHeight);
//			ImageUtil.setBackgroundBgFromAssetsNotCache(LLLayout, this,topbarfilePath,MyUIApplication.,(int)(widthLLTopCopyPer*((Home)context).deviceWidth)); 

			LLLayout.setBackgroundDrawable(new BitmapDrawable(bmp));
			
			String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

			File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
			boolean b = f.exists();
			if(!(b))
			{
				new WebUnZippingParserThread(this,"loadhardcoded").execute();
			}
			PleaseCheckForSync();
		}

		// some app propertiees
		MyUIApplication.Copy=false;
		MyUIApplication.Menu=false;

	}

	public void fromcaptureScreen(String eventcode)
	{

		try {
			SplashOWrapper _objSplashOWrapper =null;
			if(MyUIApplication.EventList.size()==0)
			{
				for (int i = 0; i < MyUIApplication.clientEventList.size(); i++) {

					if(MyUIApplication.clientEventList.get(i).ClientName.equals(client) && MyUIApplication.clientEventList.get(i).EventCode.equals(eventcode))
					{
						_objSplashOWrapper =MyUIApplication.clientEventList.get(i);
						break;
					}
					else
					{
						_objSplashOWrapper = new SplashOWrapper();
					}

				}
			}
			else if(MyUIApplication.EventList.size()>0)
			{
				for (int i = 0; i < MyUIApplication.EventList.size(); i++) {

					if(MyUIApplication.EventList.get(i).EventCode.equals(eventcode))
					{
						_objSplashOWrapper =MyUIApplication.EventList.get(i);
						_objSplashOWrapper.ClientCode = client;
						break;
					}
					else
					{
						_objSplashOWrapper = new SplashOWrapper();
					}

				}

			}
			else
			{
				_objSplashOWrapper = new SplashOWrapper();
			}
			//			 _objSplashOWrapper = MyUIApplication._objClientEventDB.getEventClientCode(client, event);
			if(_objSplashOWrapper != null)
			{

				ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
				final Object HardcoredClientCode = (Object)ai.metaData.get("HardcoredClientCode");
				final Object HardcoredEventCode = (Object)ai.metaData.get("HardcoredEventCode");


				//				final String HardcoredClientCode = getResources().getString(R.string.HardcoredClientCode);
				//				final String HardcoredEventCode = getResources().getString(R.string.HardcoredEventCode);

				if(_objSplashOWrapper.EventCode.equals(HardcoredEventCode) && _objSplashOWrapper.ClientCode.equals(HardcoredClientCode))
				{
					MyUIApplication.EventCode =_objSplashOWrapper.EventCode;
					MyUIApplication.ClientCode =_objSplashOWrapper.ClientCode;

					String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

					File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
					boolean b = f.exists();
					if(!(b))
					{
						new WebUnZippingParserThread(this,"loadhardcoded").execute();
					}

					PleaseCheckForSync();
				}
				else
				{

					if(MyUIApplication.isInternetAvailable(this))
					{


						if(_objSplashOWrapper != null)
						{
							MyUIApplication.EventCode =_objSplashOWrapper.EventCode;
							MyUIApplication.ClientCode =_objSplashOWrapper.ClientCode;
						}

						PleaseCheckForSync();

						//			new BGImagePacketThread(Splash.this,"http://203.190.149.92/EventMobile/Services/GetImagePacket.aspx?"+
						//			"ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&synctimestamp=24/04/2013%2017:08:33").execute();
						//				new ImagePacketSync(this, "ImagePacket").execute();
					}
					else
					{

						String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ _objSplashOWrapper.ClientCode+"/"+_objSplashOWrapper.EventCode+"/xmls"+"/screen.xml";

						System.out.println(XmlPathInSDCard);
						
						
						File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
						boolean b = f.exists();

						if(f.exists())
						{
							if(_objSplashOWrapper != null)
							{
								MyUIApplication.EventCode =_objSplashOWrapper.EventCode;
								MyUIApplication.ClientCode =_objSplashOWrapper.ClientCode;
							}

							new BGThreadHomePage(this, "Local" , "EMGScreen").execute();
						}
						else
						{
							new AlertDialog.Builder(this)

							.setMessage("Do you want to reload the app with hardcoded "+HardcoredClientCode)
							.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) {

									//						((MyUIApplication)getApplication()).showclientscreen = false;

									//						LinearLayout LLLayout =(LinearLayout) findViewById(R.id.LLLayout);
									//						clientLayout.setVisibility(View.GONE);
									//						LLLayout.setBackgroundResource(R.drawable.defaultsplash);
									MyUIApplication.EventCode =(String)HardcoredEventCode;
									MyUIApplication.ClientCode =(String)HardcoredClientCode;

									String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

									File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
									boolean b = f.exists();
									if(!(b))
									{
										new WebUnZippingParserThread(Splash.this,"loadhardcoded").execute();
									}

									PleaseCheckForSync();



									//						StartActivityToSplash();


								}
							})
							.setNegativeButton("No", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) { 
									// do nothing
									try {
										hideListClick.setVisibility(View.GONE);
									} catch (Exception e) {
										// TODO: handle exception
									}	

									//						finish();
								}
							}).show();


							//				new AlertDialog.Builder(this)
							//				.setTitle("No Data For the Selected Event")
							//				.setMessage("Please Selected Another Event.")
							//				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							//					public void onClick(DialogInterface dialog, int which) {
							//
							//					}
							//				}).show();


							//				xr.parse(new InputSource(context.getResources().openRawResource(R.raw.jlfl_latest)));
						}


					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * From Event List onClick
	 * @param event
	 */
	public void fromClientScreen(String event)
	{

		try {
			SplashOWrapper _objSplashOWrapper =null;
			if(MyUIApplication.EventList.size()==0)
			{
				for (int i = 0; i < MyUIApplication.clientEventList.size(); i++) {

					if(MyUIApplication.clientEventList.get(i).ClientName.equals(client) && MyUIApplication.clientEventList.get(i).EventName.equals(event))
					{
						_objSplashOWrapper =MyUIApplication.clientEventList.get(i);
						break;
					}
					else
					{
						_objSplashOWrapper = new SplashOWrapper();
					}

				}
			}
			else if(MyUIApplication.EventList.size()>0)
			{
				for (int i = 0; i < MyUIApplication.EventList.size(); i++) {

					if(MyUIApplication.EventList.get(i).EventName.equals(event))
					{
						_objSplashOWrapper =MyUIApplication.EventList.get(i);
						_objSplashOWrapper.ClientCode = client;
						break;
					}
					else
					{
						_objSplashOWrapper = new SplashOWrapper();
					}

				}

			}
			else
			{
				_objSplashOWrapper = new SplashOWrapper();
			}
			//			 _objSplashOWrapper = MyUIApplication._objClientEventDB.getEventClientCode(client, event);
			if(_objSplashOWrapper != null)
			{

				ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
				final Object HardcoredClientCode = (Object)ai.metaData.get("HardcoredClientCode");
				final Object HardcoredEventCode = (Object)ai.metaData.get("HardcoredEventCode");


				//				final String HardcoredClientCode = getResources().getString(R.string.HardcoredClientCode);
				//				final String HardcoredEventCode = getResources().getString(R.string.HardcoredEventCode);

				if(_objSplashOWrapper.EventCode.equals(HardcoredEventCode) && _objSplashOWrapper.ClientCode.equals(HardcoredClientCode))
				{
					MyUIApplication.EventCode =_objSplashOWrapper.EventCode;
					MyUIApplication.ClientCode =_objSplashOWrapper.ClientCode;

					String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

					File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
					boolean b = f.exists();
					if(!(b))
					{
						new WebUnZippingParserThread(this,"loadhardcoded").execute();
					}

					PleaseCheckForSync();
				}
				else
				{

					if(MyUIApplication.isInternetAvailable(this))
					{


						if(_objSplashOWrapper != null)
						{
							MyUIApplication.EventCode =_objSplashOWrapper.EventCode;
							MyUIApplication.ClientCode =_objSplashOWrapper.ClientCode;
						}

						PleaseCheckForSync();

						//			new BGImagePacketThread(Splash.this,"http://203.190.149.92/EventMobile/Services/GetImagePacket.aspx?"+
						//			"ClientCode="+MyUIApplication.ClientCode+"&EventCode="+MyUIApplication.EventCode+"&synctimestamp=24/04/2013%2017:08:33").execute();
						//				new ImagePacketSync(this, "ImagePacket").execute();
					}
					else
					{

						String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ _objSplashOWrapper.ClientCode+"/"+_objSplashOWrapper.EventCode+"/xmls"+"/screen.xml";

						File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
						boolean b = f.exists();

						if(f.exists())
						{
							if(_objSplashOWrapper != null)
							{
								MyUIApplication.EventCode =_objSplashOWrapper.EventCode;
								MyUIApplication.ClientCode =_objSplashOWrapper.ClientCode;
							}

							new BGThreadHomePage(this, "Local" , "EMGScreen").execute();
						}
						else
						{
							new AlertDialog.Builder(this)

							.setMessage("Do you want to reload the app with hardcoded "+HardcoredClientCode)
							.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) {

									//						((MyUIApplication)getApplication()).showclientscreen = false;

									//						LinearLayout LLLayout =(LinearLayout) findViewById(R.id.LLLayout);
									//						clientLayout.setVisibility(View.GONE);
									//						LLLayout.setBackgroundResource(R.drawable.defaultsplash);
									MyUIApplication.EventCode =(String)HardcoredEventCode;
									MyUIApplication.ClientCode =(String)HardcoredClientCode;

									String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

									File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
									boolean b = f.exists();
									if(!(b))
									{
										new WebUnZippingParserThread(Splash.this,"loadhardcoded").execute();
									}

									PleaseCheckForSync();



									//						StartActivityToSplash();


								}
							})
							.setNegativeButton("No", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) { 
									// do nothing
									try {
										hideListClick.setVisibility(View.GONE);
									} catch (Exception e) {
										// TODO: handle exception
									}	

									//						finish();
								}
							}).show();


							//				new AlertDialog.Builder(this)
							//				.setTitle("No Data For the Selected Event")
							//				.setMessage("Please Selected Another Event.")
							//				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							//					public void onClick(DialogInterface dialog, int which) {
							//
							//					}
							//				}).show();


							//				xr.parse(new InputSource(context.getResources().openRawResource(R.raw.jlfl_latest)));
						}


					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
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
			String TitleTextonEvent = (String)ai.metaData.get("TitleTextonEvent");
			headertext.setText(TitleTextonEvent);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void AfterDownloadImagePacket()
	{
		new BGThreadHomePage(this, "Local" , "EMGScreen").execute();

		//		String getPerferenceTable=MyUIApplication.getPerferenecTable(Splash.this);
		//		if(!MyUIApplication.isInternetAvailable(this))
		//		{
		//			new BGThreadHomePage(this, "Local" , "EMGScreen").execute();
		//		}
		//		else if(!getPerferenceTable.equals("Blank") && MyUIApplication.isInternetAvailable(this))
		//		{
		//			new BGThreadHomePage(this, "Live" , "EMGScreen").execute();
		//		}
		//		else if(getPerferenceTable.equals("Blank") && MyUIApplication.isInternetAvailable(this))
		//		{
		//			new BGThreadHomePage(this, "Local" , "EMGScreen").execute();
		//		}
	}


	private void PleaseCheckForSync() {
		// TODO Auto-generated method stub

		String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

		File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
		boolean b = f.exists();


		if(MyUIApplication.isInternetAvailable(this))
		{
			new BGXMLSyncThread(this, "CheckForSync").execute();
		}
		else if(b)
		{
			fillScreenList();
		}
	}

	public void fillScreenList()
	{
		if(isXMLChange)
		{
			new Splash0Thread(Splash.this,"SaveXMLintoSDCard",MyUIApplication.ScreenFilePath).execute();
		}
		else if(isimagePacketchage)
		{
			new BGImagePacketThread(Splash.this,MyUIApplication.imageFilePath).execute();
		}
		else if((!(isXMLChange)) &&(!(isimagePacketchage)))
		{
			new BGThreadHomePage(this, "Local" , "EMGScreen").execute();
		}
	}

	FrameLayout LLTop,LLMiddle,LLBottom;
	LinearLayout LLLayout;
	public void StartActivity()
	{
//		//Method to enable and disable Push Notification
//		CheckPointForPushNotification();
		
		
		String XmlPathInSDCard = "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls"+"/"+ "screen"+".xml";

		File f = new File(Environment.getExternalStorageDirectory() +XmlPathInSDCard);
		boolean b = f.exists();
		if(b)
		{

			int ii= MyUIApplication._objScreenWrappersList.size();
			if(ii>0)
			{

				try {
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(eventListsearch_et.getWindowToken(), 0);
				} catch (Exception e) {
				}
				
				if(MyUIApplication.client.trim().length()==0)
				{
					finish();
				}
				else if(!(((MyUIApplication)getApplication()).showclientscreen))
				{
					finish();
				}

				startActivity(new Intent(Splash.this, Home.class));
				overridePendingTransition( R.anim.slide_in_left, R.anim.noanim );
			}
		}else {
			
			AlertDialog.Builder dialog	=	new AlertDialog.Builder(this);
			dialog.setMessage("No HardCoded App present");
			dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					finish();
				}
			});
			dialog.show();
		}
	}

//	public void CheckPointForPushNotification() {
//		if(!MyUIApplication.pref.getPushStatus()){
//			
//			AlertDialog.Builder dialog	=	new AlertDialog.Builder(this);
//			dialog.setMessage("Do you want to enable push notification !!");
//			dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//				
//				public void onClick(DialogInterface dialog, int which) {
//					new PushNotificationMain(getBaseContext()).onCreate();
//					StartActivity(); //KD_100220141840
//				}
//			});
//			dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//				
//				public void onClick(DialogInterface dialog, int which) {
//					StartActivity(); //KD_100220141840
//				}
//			});
//			dialog.show();
//		}else {
//			//If registered ,Do nothing
//			StartActivity(); //KD_100220141840
//		}
//	}

	public boolean isXMLChange=false;
	public boolean isimagePacketchage=false;

	public void checkforImagePacket()
	{

		if(MyUIApplication.ScreenFilePath.length()>0 )
		{
			isXMLChange =true;

		}

		new ImagePacketSync(this, "ImagePacket").execute();


	}

	/**
	 * Called From BG Thread after check for Sync
	 * @param imageUrl
	 */
	public void FillScreenAfterDownloadFromServer(final String imageUrl)
	{
		if(MyUIApplication.ScreenFilePath.length()>0 || imageUrl.length()>0 )
		{
			if(imageUrl.length()>0)
			{
				isimagePacketchage=true;
				MyUIApplication.imageFilePath = imageUrl;
			}
			new AlertDialog.Builder(this)
			.setTitle("Update Application")
			.setMessage("New Update Available .Do you want to update now?").setCancelable(false)
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) { 
					// continue with delete
					try
					{
						SyncForXmlWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeForXmlWrapper(MyUIApplication.ClientCode,MyUIApplication.EventCode);

						if( _obj.Date_time==null )
						{
							_obj.ClientCode=MyUIApplication.ClientCode;
							_obj.EventCode=MyUIApplication.EventCode;
							_obj.Date_time=MyUIApplication.Update_Time_Stamp;
							MyUIApplication._objSyncTimeDB.insertRecords(_obj);
						}
						else
						{
							_obj.ClientCode=MyUIApplication.ClientCode;
							_obj.EventCode=MyUIApplication.EventCode;
							_obj.Date_time=MyUIApplication.Update_Time_Stamp;
							MyUIApplication._objSyncTimeDB.updateTable(_obj);
						}

						if(MyUIApplication.ScreenFilePath.length()>0)
						{
							// Calling For Download Sceen.xml By the Name ClientCode+EventCode.xml 
							new Splash0Thread(Splash.this,"SaveXMLintoSDCard",MyUIApplication.ScreenFilePath).execute();
						}
						else if(imageUrl.length()>0)
						{
							new BGImagePacketThread(Splash.this,imageUrl).execute();
						}
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						System.out.println(e);
					}
					
					
					try {
						if(imageUrl.trim().length()>0)
						{
							SyncTimeWrapper _obj =	MyUIApplication._objSyncTimeDB.getSyncTimeWrapper("ImagePacket");
		
							if(_obj !=null && _obj.Date_time !=null)
							{
								SyncTimeWrapper updateTable = new SyncTimeWrapper();
		
								updateTable.Name="ImagePacket";
								updateTable.Date_time = MyUIApplication.ImagePacketTimeStamp;
								updateTable.Client_EventCode =MyUIApplication.ClientCode+MyUIApplication.EventCode;
		
								MyUIApplication._objSyncTimeDB.updateTable(updateTable);
							}
							else
							{
		
								SyncTimeWrapper insertTable = new SyncTimeWrapper();
		
								insertTable.Name="ImagePacket";
								insertTable.Date_time = MyUIApplication.ImagePacketTimeStamp;
								insertTable.Client_EventCode =MyUIApplication.ClientCode+MyUIApplication.EventCode;
		
								MyUIApplication._objSyncTimeDB.insertRecords(insertTable);
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) { 
					// do nothing

					isimagePacketchage=false;
					isXMLChange=false;

					fillScreenList();
					// Calling to Start Activity From Splash0.class to Splash.class
				}
			}).show();
		}
		else
		{

			isimagePacketchage=false;
			isXMLChange=false;
			fillScreenList();
		}
	}


	public void DownloadFromUrl(String DownloadUrl, String fileName) {

		try {
			//			File root = android.os.Environment.getExternalStorageDirectory();               
			//
			//			File dir = new File (root.getAbsolutePath() +"/EventsMobilePlatform"+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"/xmls");
			//			if(dir.exists()==false) {
			//				dir.mkdirs();
			//			}

			File dir = MyUIApplication.SDCardPath("/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/xmls");

			URL url = new URL(DownloadUrl); //you can write here any link
			File file = new File(dir, fileName);

			long startTime = System.currentTimeMillis();
			Log.d("DownloadManager", "download begining");
			Log.d("DownloadManager", "download url:" + url);
			Log.d("DownloadManager", "downloaded file name:" + fileName);

			/* Open a connection to that URL. */
			URLConnection ucon = url.openConnection();

			/*
			 * Define InputStreams to read from the URLConnection.
			 */
			InputStream is = ucon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			/*
			 * Read bytes to the Buffer until there is nothing more to read(-1).
			 */
			ByteArrayBuffer baf = new ByteArrayBuffer(5000);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}


			/* Convert the Bytes read to a String. */
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(baf.toByteArray());
			fos.flush();
			fos.close();
			Log.d("DownloadManager", "download ready in" + ((System.currentTimeMillis() - startTime) / 1000) + " sec");

			// Activity For Splash0 To Splash.java


		} catch (IOException e) {
			Log.d("DownloadManager", "Error: " + e);
		}

	}


	Util _objUtil;
	public void setSplashProperties()
	{
		LLLayout=(LinearLayout)findViewById(R.id.LLLayout);
		LLTop=(FrameLayout)findViewById(R.id.LLTop);
		LLMiddle=(FrameLayout)findViewById(R.id.LLMiddle);
		LLBottom=(FrameLayout)findViewById(R.id.LLBottom);

		_objUtil = new Util();

		ScreenWrapper objScreenWrapper = _objUtil.getScreenWrapperFromDB("-1");
		ScreenPartWrapper objScreenPartWrapper = _objUtil.getScreenPartWrapper("-1");


		if(objScreenWrapper.bgImage.length()>0)
		{

		}
		else if(objScreenWrapper.bgcolor.length()>0)
		{
			LLLayout.setBackgroundColor(Color.parseColor(objScreenWrapper.bgcolor));
		}

		setTopView(objScreenPartWrapper);
		setMiddleView(objScreenPartWrapper);
		setBottomView(objScreenPartWrapper);
	}


	public void setTopView(final ScreenPartWrapper _objScreenPartWrapper)
	{
		final ElementWrapper _objEW = _objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,"Top");


		double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
		double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
		double widthLLTopPer=widthLLTop/100;
		double heightLLTopPer=heightLLTop/100;

		ViewGroup.LayoutParams params_LLTop = LLTop.getLayoutParams();
		params_LLTop.height=(int)(heightLLTopPer*(deviceHeight));
		params_LLTop.width=(int)(widthLLTopPer*(deviceWidth));
		LLTop.setLayoutParams(params_LLTop);

		try
		{
			if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.TopbgImage))
			{
				String topbarfilePath=_objScreenPartWrapper.TopbgImage;
				ImageUtil.setBgFromSDCardNotCache(LLTop, this,topbarfilePath,(int)(heightLLTopPer*(deviceHeight)),(int)(widthLLTopPer*(deviceWidth)));
			}
			else 
			{
				String topbarfilePath="images/"+_objScreenPartWrapper.TopbgImage;
				ImageUtil.setBackgroundBgFromAssetsNotCache(LLTop, this,topbarfilePath,(int)(heightLLTopPer*(deviceHeight)),(int)(widthLLTopPer*(deviceWidth)));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in Splash setTopView() Image Setting"+e);
		}
		try
		{
			ImageView adv= new ImageView(this);
			LLTop.addView(adv);

			double heightadv=Double.parseDouble(_objEW.height);
			double widthadv=Double.parseDouble(_objEW.width);
			double heightadvper=heightadv/100;
			double widthadvper=widthadv/100;

			ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
			params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
					FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
			params_adv.height=(int)(heightLLTopPer*heightadvper*(deviceHeight));
			params_adv.width=(int)(widthLLTopPer*widthadvper*(deviceWidth));
			adv.setLayoutParams(params_adv);

			if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
			{
				String advfilePath=_objEW.Bitmap;
				ImageUtil.setBgFromSDCardNotCache(adv, this,advfilePath,(int)(heightLLTopPer*heightadvper*deviceHeight),(int)(widthLLTopPer*widthadvper*deviceWidth));
			}
			else 
			{
				String advfilePath="images/"+_objEW.Bitmap;
				ImageUtil.setBackgroundBgFromAssetsNotCache(adv, this,advfilePath,(int)(heightLLTopPer*heightadvper*deviceHeight),(int)(widthLLTopPer*widthadvper*deviceWidth));
			}
			if(_objScreenPartWrapper.TopLink.length()>0)
			{
				LLTop.setOnClickListener( new OnClickListener()
				{
					public void onClick(View v)
					{
						String str=_objScreenPartWrapper.TopLink.trim();

						Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
						myWebLink.setData(Uri.parse(str));
						startActivity(myWebLink);
					}
				});
			}

		}
		catch (Exception e) 
		{
			System.out.println("Exception in Setting home Page Top Bar"+e);
		}
	}



	public void setMiddleView(final ScreenPartWrapper _objScreenPartWrapper)
	{
		final ElementWrapper _objEW = _objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,"Middle");


		double widthLLMiddle=Double.parseDouble(_objScreenPartWrapper.MidWidth);
		double heightLLMiddle=Double.parseDouble(_objScreenPartWrapper.MidHeight);
		double widthLLMiddlePer=widthLLMiddle/100;
		double heightLLMiddlePer=heightLLMiddle/100;

		ViewGroup.LayoutParams params_LLMiddle = LLMiddle.getLayoutParams();
		params_LLMiddle.height=(int)(heightLLMiddlePer*(deviceHeight));
		params_LLMiddle.width=(int)(widthLLMiddlePer*(deviceWidth));
		LLMiddle.setLayoutParams(params_LLMiddle);

		if(_objScreenPartWrapper.MidbgImage.length()>0)
		{
			try
			{
				if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.MidbgImage))
				{
					String MiddlebarfilePath=_objScreenPartWrapper.MidbgImage;
					ImageUtil.setBgFromSDCardNotCache(LLMiddle, this,MiddlebarfilePath,(int)(heightLLMiddlePer*(deviceHeight)),(int)(widthLLMiddlePer*(deviceWidth)));
				}
				else 
				{
					String MiddlebarfilePath="images/"+_objScreenPartWrapper.MidbgImage;
					ImageUtil.setBackgroundBgFromAssetsNotCache(LLMiddle, this,MiddlebarfilePath,(int)(heightLLMiddlePer*(deviceHeight)),(int)(widthLLMiddlePer*(deviceWidth)));
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in Splash setMiddleView() Image Setting"+e);
			}
		}
		else if(_objScreenPartWrapper.Midbgcolor.length()>0)
		{
			LLMiddle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
		}

		try
		{
			ImageView adv= new ImageView(this);
			LLMiddle.addView(adv);

			double heightadv=Double.parseDouble(_objEW.height);
			double widthadv=Double.parseDouble(_objEW.width);
			double heightadvper=heightadv/100;
			double widthadvper=widthadv/100;

			ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
			params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
					FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
			params_adv.height=(int)(heightLLMiddlePer*heightadvper*(deviceHeight));
			params_adv.width=(int)(widthLLMiddlePer*widthadvper*(deviceWidth));
			adv.setLayoutParams(params_adv);

			if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
			{
				String advfilePath=_objEW.Bitmap;
				ImageUtil.setBgFromSDCardNotCache(adv, this,advfilePath,(int)(heightLLMiddlePer*heightadvper*deviceHeight),(int)(widthLLMiddlePer*widthadvper*deviceWidth));
			}
			else 
			{
				String advfilePath="images/"+_objEW.Bitmap;
				ImageUtil.setBackgroundBgFromAssetsNotCache(adv, this,advfilePath,(int)(heightLLMiddlePer*heightadvper*deviceHeight),(int)(widthLLMiddlePer*widthadvper*deviceWidth));
			}
			if(_objScreenPartWrapper.MidLink.length()>0)
			{
				LLMiddle.setOnClickListener( new OnClickListener()
				{
					public void onClick(View v)
					{
						String str=_objScreenPartWrapper.MidLink.trim();

						Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
						myWebLink.setData(Uri.parse(str));
						startActivity(myWebLink);
					}
				});
			}

		}
		catch (Exception e) 
		{
			System.out.println("Exception in Setting home Page Top Bar"+e);
		}
	}



	public void setBottomView(final ScreenPartWrapper _objScreenPartWrapper)
	{
		final ElementWrapper _objEW = _objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,"Bottom");


		double widthLLBottom=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
		double heightLLBottom=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
		double widthLLBottomPer=widthLLBottom/100;
		double heightLLBottomPer=heightLLBottom/100;

		ViewGroup.LayoutParams params_LLBottom = LLBottom.getLayoutParams();
		params_LLBottom.height=(int)(heightLLBottomPer*(deviceHeight));
		params_LLBottom.width=(int)(widthLLBottomPer*(deviceWidth));
		LLBottom.setLayoutParams(params_LLBottom);

		try
		{
			if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.BottombgImage))
			{
				String BottombarfilePath=_objScreenPartWrapper.BottombgImage;
				ImageUtil.setBgFromSDCardNotCache(LLBottom, this,BottombarfilePath,(int)(heightLLBottomPer*(deviceHeight)),(int)(widthLLBottomPer*(deviceWidth)));
			}
			else 
			{
				String BottombarfilePath="images/"+_objScreenPartWrapper.BottombgImage;
				ImageUtil.setBackgroundBgFromAssetsNotCache(LLBottom, this,BottombarfilePath,(int)(heightLLBottomPer*(deviceHeight)),(int)(widthLLBottomPer*(deviceWidth)));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in Splash setBottomView() Image Setting"+e);
		}

		try
		{
			ImageView adv= new ImageView(this);
			LLBottom.addView(adv);

			double heightadv=Double.parseDouble(_objEW.height);
			double widthadv=Double.parseDouble(_objEW.width);
			double heightadvper=heightadv/100;
			double widthadvper=widthadv/100;

			ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
			params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
					FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
			params_adv.height=(int)(heightLLBottomPer*heightadvper*(deviceHeight));
			params_adv.width=(int)(widthLLBottomPer*widthadvper*(deviceWidth));
			adv.setLayoutParams(params_adv);

			if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
			{
				String advfilePath=_objEW.Bitmap;
				ImageUtil.setBgFromSDCardNotCache(adv, this,advfilePath,(int)(heightLLBottomPer*heightadvper*deviceHeight),(int)(widthLLBottomPer*widthadvper*deviceWidth));
			}
			else 
			{
				String advfilePath="images/"+_objEW.Bitmap;
				ImageUtil.setBackgroundBgFromAssetsNotCache(adv, this,advfilePath,(int)(heightLLBottomPer*heightadvper*deviceHeight),(int)(widthLLBottomPer*widthadvper*deviceWidth));
			}
			if(_objScreenPartWrapper.BottomLink.length()>0)
			{
				LLBottom.setOnClickListener( new OnClickListener()
				{
					public void onClick(View v)
					{
						String str=_objScreenPartWrapper.BottomLink.trim();

						Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
						myWebLink.setData(Uri.parse(str));
						startActivity(myWebLink);
					}
				});
			}

		}
		catch (Exception e) 
		{
			System.out.println("Exception in Setting home Page Top Bar"+e);
		}
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			if(scandialogLayout.getVisibility()== View.VISIBLE)
			{
				scandialogLayout.setVisibility(View.GONE);
			}
			else {
				finish();  
				overridePendingTransition(0,R.anim.slide_in_right);
			}
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}


}
