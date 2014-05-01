package mobi.neuerung.MADP;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.Util.Util;
import mobi.neuerung.Util.UtilAdvertisementBar;
import mobi.neuerung.Util.UtilAdvertisementManualSwitcher;
import mobi.neuerung.Util.UtilAdvertisementSwitcher;
import mobi.neuerung.Util.UtilButton;
import mobi.neuerung.Util.UtilButtonBar;
import mobi.neuerung.Util.UtilEnterFriendCode;
import mobi.neuerung.Util.UtilEventDetail;
import mobi.neuerung.Util.UtilEventList;
import mobi.neuerung.Util.UtilExhibitorDetails;
import mobi.neuerung.Util.UtilExhibitorList;
import mobi.neuerung.Util.UtilFriendsCode;
import mobi.neuerung.Util.UtilFriendsDetail;
import mobi.neuerung.Util.UtilFriendsList;
import mobi.neuerung.Util.UtilGoogleMap;
import mobi.neuerung.Util.UtilGridView;
import mobi.neuerung.Util.UtilHtml;
import mobi.neuerung.Util.UtilHtmlWithLink;
import mobi.neuerung.Util.UtilImageManualSwitcher;
import mobi.neuerung.Util.UtilImageSwitcher;
import mobi.neuerung.Util.UtilListView;
import mobi.neuerung.Util.UtilListView01;
import mobi.neuerung.Util.UtilLogin;
import mobi.neuerung.Util.UtilMenu;
import mobi.neuerung.Util.UtilPictureGalleryCategory;
import mobi.neuerung.Util.UtilPictureGalleryDetail;
import mobi.neuerung.Util.UtilPictureGalleryGrid;
import mobi.neuerung.Util.UtilPicturealleryDetailWithDesc;
import mobi.neuerung.Util.UtilProductDetail;
import mobi.neuerung.Util.UtilProductList;
import mobi.neuerung.Util.UtilRegistration;
import mobi.neuerung.Util.UtilRequestFriendCode;
import mobi.neuerung.Util.UtilShowUpdate;
import mobi.neuerung.Util.UtilShowUpdateCategory;
import mobi.neuerung.Util.UtilShowUpdateDetail;
import mobi.neuerung.Util.UtilSpeaker;
import mobi.neuerung.Util.UtilSpeakerDetail;
import mobi.neuerung.Util.UtilSpeakerMySeminarEvent;
import mobi.neuerung.Util.UtilSpeakerSearch;
import mobi.neuerung.Util.UtilSpeakerSeminarDetail;
import mobi.neuerung.Util.UtilSpeakerSeminars;
import mobi.neuerung.Util.UtilTextField;
import mobi.neuerung.Util.UtilTopBar;
import mobi.neuerung.Util.UtilTopBar01;
import mobi.neuerung.Util.UtilTopBar02;
import mobi.neuerung.Util.UtilVideoGalleryCategory;
import mobi.neuerung.Util.UtilVideoGalleryDetail;
import mobi.neuerung.Util.UtilVideoGalleryList;
import mobi.neuerung.Util.UtilXMLHtml;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ScreenWrapper;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.analytics.tracking.android.EasyTracker;


public class Home extends Activity {
	//	public void onConfigurationChanged(Configuration newConfig) {
	//		int currentOrientation = getResources().getConfiguration().orientation;
	//		if(newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT ||
	//				newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT) {
	//			super.onConfigurationChanged(newConfig);
	//		} 
	//	}
	WindowManager mWinMgr;
	public Button MenuButton;
	public int deviceHeight,deviceWidth;

	@Override
	public void onStart() {
		super.onStart();
		EasyTracker.getInstance(this).activityStart(this);  // Add this method.
		
		 // Monitor launch times and interval from installation
	    RateThisApp.onStart(this);
	    // If the criteria is satisfied, "Rate this app" dialog will be shown
	    RateThisApp.showRateDialogIfNeeded(this);
	}


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.home);


		WindowManager mWinMgr = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();

		ScreenLayout=(FrameLayout)findViewById(R.id.ScreenLayout);

		LLLayout=(LinearLayout)findViewById(R.id.LLLayout);
		LLTop=(FrameLayout)findViewById(R.id.LLTop);
		LLMiddle=(FrameLayout)findViewById(R.id.LLMiddle);
		LLBottom=(FrameLayout)findViewById(R.id.LLBottom);

		LLLayoutCopy=(LinearLayout)findViewById(R.id.LLLayoutCopy);
		LLTopCopy=(FrameLayout)findViewById(R.id.LLTopCopy);
		LLMiddleCopy=(FrameLayout)findViewById(R.id.LLMiddleCopy);
		LLBottomCopy=(FrameLayout)findViewById(R.id.LLBottomCopy);

		LLLayoutMenu=(FrameLayout)findViewById(R.id.LLLayoutMenu);
		LLTopMenu=(FrameLayout)findViewById(R.id.LLTopMenu);
		LLMiddleMenu=(FrameLayout)findViewById(R.id.LLMiddleMenu);
		LLBottomMenu=(FrameLayout)findViewById(R.id.LLBottomMenu);
		MenuButton=(Button)findViewById(R.id.MenuButton);

		if(MyUIApplication.ScreenNumbers.contains("-2"))
		{
			if(!(MyUIApplication._objClientEventDB.isAggree(MyUIApplication.ClientCode,MyUIApplication.EventCode)))
				OpenHtmlPage("-2","");
			else if(MyUIApplication.ScreenNumbers.contains("-1"))
			{
				OpenHtmlPage("-1","");
			}
			else if(MyUIApplication.ScreenNumbers.contains("0"))
			{
				//					DesignHomeScreen();
				OpenHtmlPage("0","");
				MyUIApplication.StateMachine.clear();
				MyUIApplication.StateMachine.add("0");
			}
			else
			{
				MyUIApplication.AlertString(this, "Home Screen Not Available inner");
			}
		}
		else if(MyUIApplication.ScreenNumbers.contains("-1"))
		{
			OpenHtmlPage("-1","");
		}
		else if(MyUIApplication.ScreenNumbers.contains("0"))
		{
			CheckPointForPushNotification();
		}
		else
		{
			MyUIApplication.AlertString(this, "Home Screen Not Available");
		}
		
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		try {
			Bundle bundle = getIntent().getExtras();
			if(bundle !=null)
			{
				try {
					String screennumber = bundle.getString("screenNumber");
					if(MyUIApplication.ScreenNumbers.contains(screennumber))
					{
						OpenHtmlPage(screennumber,"");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(""+e);
			MyUIApplication.LoggerToSD("In Home page on Resume", e.getMessage());
		}


	}


	/**Calling this from menu, Don't know why*/
	//	public void PleaseCheckForSync()
	//	{
	//
	//		if(MyUIApplication.isInternetAvailable(this))
	//		{
	//			new BGXMLSyncThread(this, "CheckForSync" ).execute();
	//		}
	//	}


	//	public void DatachangeAftersync()
	//	{
	//
	//		MyUIApplication._objElementWrapperList=null;
	//		MyUIApplication._objScreenWrappersList=null;
	//		MyUIApplication._objScreenPartWrappersList=null;
	//
	//		MyUIApplication._objElementWrapperList=new ArrayList<ElementWrapper>();
	//		MyUIApplication._objScreenWrappersList=new ArrayList<ScreenWrapper>();
	//		MyUIApplication._objScreenPartWrappersList=new ArrayList<ScreenPartWrapper>();
	//
	//
	//		int i=MyUIApplication._objTempElementWrapperList.size();
	//		int j= MyUIApplication._objTempScreenWrappersList.size();
	//		int k=MyUIApplication._objTempScreenPartWrappersList.size();
	//		System.out.println(""+i+j+k);
	//
	//
	//		MyUIApplication._objElementWrapperList=MyUIApplication._objTempElementWrapperList;
	//		MyUIApplication._objScreenWrappersList=MyUIApplication._objTempScreenWrappersList;
	//		MyUIApplication._objScreenPartWrappersList=MyUIApplication._objTempScreenPartWrappersList;
	//
	//		i=MyUIApplication._objTempElementWrapperList.size();
	//		j= MyUIApplication._objTempScreenWrappersList.size();
	//		k=MyUIApplication._objTempScreenPartWrappersList.size();
	//		System.out.println(""+i+j+k);
	//
	//		DesignHomeScreen();
	//
	//	}



	//	public void FillScreenAfterDownloadFromServer()
	//	{
	//
	//		if(MyUIApplication.ScreenFilePath.length()>0)
	//		{
	//			new AlertDialog.Builder(this)
	//			.setTitle("Update Application")
	//			.setMessage("New Update Available . Are you want to update now?")
	//			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	//				public void onClick(DialogInterface dialog, int which) {
	//					SyncForXmlWrapper _obj=MyUIApplication._objSyncTimeDB.getSyncTimeForXmlWrapper(MyUIApplication.ClientCode,MyUIApplication.EventCode);
	//
	//					if( _obj.Date_time==null )
	//					{
	//						_obj.ClientCode=MyUIApplication.ClientCode;
	//						_obj.EventCode=MyUIApplication.EventCode;
	//						_obj.Date_time=MyUIApplication.Update_Time_Stamp;
	//						MyUIApplication._objSyncTimeDB.insertRecords(_obj);
	//					}
	//					else
	//					{
	//						_obj.ClientCode=MyUIApplication.ClientCode;
	//						_obj.EventCode=MyUIApplication.EventCode;
	//						_obj.Date_time=MyUIApplication.Update_Time_Stamp;
	//						MyUIApplication._objSyncTimeDB.updateTable(_obj);
	//					}
	//					new BGThreadHomePage(Home.this, "Refresh" , "EMGScreen").execute();
	//				}
	//			})
	//			.setNegativeButton("No", new DialogInterface.OnClickListener() {
	//				public void onClick(DialogInterface dialog, int which) { 
	//
	//				}
	//			}).show();
	//		}
	//
	//		else 
	//		{
	//			new AlertDialog.Builder(this)
	//			.setTitle("Update Application")
	//			.setMessage("There is no Update now. Please Press Ok")
	//			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	//				public void onClick(DialogInterface dialog, int which) { 
	//					// continue with delete
	//					MyUIApplication.CurrentScrollPosition=0;
	//					//					DesignHomeScreen();
	//				}
	//			})
	//			.show();
	//		}
	//
	//	}


	public FrameLayout ScreenLayout,LLTop,LLMiddle,LLBottom,LLTopCopy,LLMiddleCopy,LLBottomCopy;
	public FrameLayout LLTopMenu,LLMiddleMenu,LLBottomMenu,LLLayoutMenu;
	public LinearLayout LLLayout,LLLayoutCopy;
	public Util _objUtil = new Util();
	public UtilTopBar _objUtilTopBar = new UtilTopBar();
	public UtilTopBar01 _objUtilTopBar01 = new UtilTopBar01();
	public UtilTopBar02 _objUtilTopBar02 = new UtilTopBar02();
	public UtilAdvertisementBar _objUtilAddBar = new UtilAdvertisementBar();
	public UtilGridView _objGridView = new UtilGridView();
	public UtilListView _objUtilListView = new UtilListView();
	public UtilListView01 _objUtilListView01 = new UtilListView01();
	public UtilHtml _objUtilHtml = new UtilHtml();
	public UtilXMLHtml _objUtilXMLHtml = new UtilXMLHtml();
	public UtilMenu _objUtilMenu = new UtilMenu();
	public UtilGoogleMap _objUtilGoogleMap = new UtilGoogleMap();
	public UtilHtmlWithLink _objUtilHtmlWithLink = new UtilHtmlWithLink();
	public UtilShowUpdate _objUtilShowUpdate = new UtilShowUpdate();
	public UtilShowUpdateCategory _objUtilShowUpdateCategory = new UtilShowUpdateCategory();
	public UtilEventList _objUtilEventList = new UtilEventList();
	public UtilEventDetail _objUtilEventDetail = new UtilEventDetail();
	public UtilShowUpdateDetail _objUtilShowUpdateDetail = new UtilShowUpdateDetail();
	public UtilPictureGalleryCategory _objUtilPictureGalleryCategory = new UtilPictureGalleryCategory();
	public UtilPictureGalleryGrid _objUtilPictureGalleryGrid = new UtilPictureGalleryGrid();
	public UtilPictureGalleryDetail _objUtilPictureGalleryDetail = new UtilPictureGalleryDetail();
	public UtilVideoGalleryCategory _objUtilVideoGalleryCategory = new UtilVideoGalleryCategory();
	public UtilVideoGalleryList _objUtilVideoGalleryList = new UtilVideoGalleryList();
	public UtilVideoGalleryDetail _objUtilVideoGalleryDetail = new UtilVideoGalleryDetail();
	public UtilExhibitorList _objUtilExhibitorList = new UtilExhibitorList();
	public UtilExhibitorDetails _objUtilExhibitorDetails = new UtilExhibitorDetails();
	public UtilAdvertisementSwitcher _objUtilAdvertisementSwitcher = new UtilAdvertisementSwitcher();
	public UtilAdvertisementManualSwitcher _objUtilAdvertisementManualSwitcher = new UtilAdvertisementManualSwitcher();
	public UtilButtonBar _objUtilButtonBar = new UtilButtonBar();
	public UtilPicturealleryDetailWithDesc _objUtilPictureDetailWithDesc = new UtilPicturealleryDetailWithDesc();
	public UtilSpeaker _objUtilSpeaker = new UtilSpeaker();
	public UtilSpeakerSearch _objUtilSpeakerSearch = new UtilSpeakerSearch();
	public UtilSpeakerDetail _objUtilSpeakerDetail = new UtilSpeakerDetail();
	public UtilSpeakerSeminars _objUtilSpeakerSeminars = new UtilSpeakerSeminars();
	public UtilSpeakerSeminarDetail _objUtilSpeakerSeminarDetail = new UtilSpeakerSeminarDetail();
	public UtilSpeakerMySeminarEvent _objUtilSpeakerMySeminarEvent = new UtilSpeakerMySeminarEvent();
	public UtilRegistration _objUtilRegistration = new UtilRegistration();
	public UtilProductList _objUtilProductList = new UtilProductList();
	public UtilProductDetail _objUtilProductDetail = new UtilProductDetail();
	public UtilLogin _objUtilLogin = new UtilLogin();
	public UtilFriendsList _objUtilFriendsList = new UtilFriendsList();
	public UtilFriendsDetail _objUtilFriendsDetail = new UtilFriendsDetail();
	public UtilFriendsCode _objUtilFriendsCode = new UtilFriendsCode();
	public UtilRequestFriendCode _objUtilRequestFriendCode = new UtilRequestFriendCode();
	public UtilEnterFriendCode _objUtilEnterFriendCode = new UtilEnterFriendCode();
	public UtilTextField _objUtilTextField = new UtilTextField();
	public UtilButton _objUtilButton = new UtilButton();
	public UtilImageSwitcher _objUtilImageSwitcher = new UtilImageSwitcher();
	public UtilImageManualSwitcher _objUtilImageManualSwitcher = new UtilImageManualSwitcher();



	// ****  Home Screen Design Method ****
	//	public void DesignHomeScreen()
	//	{
	//
	//
	//		MyUIApplication.Copy=false;
	//		try
	//		{
	//			ScreenPartWrapper objScreenPartWrapper = _objUtil.getScreenPartWrapper("0");
	//			ScreenWrapper objScreenWrapper = _objUtil.getScreenWrapperFromDB("0");
	//			MyUIApplication.currentScreenNumber =objScreenPartWrapper.ScreenName;
	//
	//			if(MyUIApplication.Copy)
	//			{
	//
	//
	//				// for copy view
	//
	//				LLLayoutCopy.setBackgroundColor(Color.WHITE);
	//				LLTopCopy.setBackgroundColor(Color.WHITE);
	//				LLMiddleCopy.setBackgroundColor(Color.WHITE);
	//				LLBottomCopy.setBackgroundColor(Color.WHITE);
	//
	//				LLTopCopy.setBackgroundColor(Color.WHITE);
	//				LLMiddleCopy.setBackgroundColor(Color.WHITE);
	//				LLBottomCopy.setBackgroundColor(Color.WHITE);
	//
	//				LLLayoutCopy.setVisibility(View.VISIBLE);
	//				LLTopCopy.removeAllViews();
	//				LLMiddleCopy.removeAllViews();
	//				LLBottomCopy.removeAllViews();
	//
	//				LLTopCopy.setBackgroundDrawable(null);
	//				LLMiddleCopy.setBackgroundDrawable(null);
	//				LLBottomCopy.setBackgroundDrawable(null);
	//
	//
	//				try
	//				{
	//					if(objScreenWrapper.bgImage.length()>0)
	//					{
	//						ImageUtil.setBgFromSDCardNotCache(LLLayoutCopy, this,objScreenWrapper.bgImage,deviceHeight,deviceWidth);
	//					}
	//					else if(objScreenWrapper.bgcolor.length()>0)
	//					{
	//						LLLayoutCopy.setBackgroundColor(Color.parseColor(objScreenWrapper.bgcolor));
	//					}
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
	//					LLLayoutCopy.setBackgroundColor(Color.WHITE);
	//				}
	//
	//				try
	//				{
	//					if(objScreenPartWrapper.TopbgImage.trim().length()>0)
	//					{
	//						ImageUtil.setBgFromSDCardNotCache(LLTopCopy, this,objScreenPartWrapper.TopbgImage.trim(),Integer.parseInt(objScreenPartWrapper.TopHeight),Integer.parseInt(objScreenPartWrapper.TopWidth));
	//					}
	//					else if(objScreenPartWrapper.Topbgcolor.trim().length()>0)
	//					{
	//						LLTopCopy.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Topbgcolor.trim()));
	//					}
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
	//					LLTopCopy.setBackgroundColor(Color.WHITE);
	//				}
	//
	//				try
	//				{
	//					if(objScreenPartWrapper.MidbgImage.trim().length()>0)
	//					{
	//						ImageUtil.setBgFromSDCardNotCache(LLMiddleCopy, this,objScreenPartWrapper.MidbgImage.trim(),Integer.parseInt(objScreenPartWrapper.MidHeight),Integer.parseInt(objScreenPartWrapper.MidWidth));
	//					}
	//					else if(objScreenPartWrapper.Midbgcolor.trim().length()>0)
	//					{
	//						LLMiddleCopy.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Midbgcolor.trim()));
	//					}
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
	//					LLMiddleCopy.setBackgroundColor(Color.WHITE);
	//				}
	//
	//				try
	//				{
	//					if(objScreenPartWrapper.BottombgImage.trim().length()>0)
	//					{
	//						ImageUtil.setBgFromSDCardNotCache(LLBottomCopy, this,objScreenPartWrapper.BottombgImage.trim(),Integer.parseInt(objScreenPartWrapper.BottomHeight),Integer.parseInt(objScreenPartWrapper.BottomWidth));
	//					}
	//					else if(objScreenPartWrapper.Bottombgcolor.trim().length()>0)
	//					{
	//						LLBottomCopy.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Bottombgcolor.trim()));
	//					}
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
	//					LLBottomCopy.setBackgroundColor(Color.WHITE);
	//				}
	//
	//
	//				if(objScreenPartWrapper!=null)
	//				{
	//					//  **** For Top Bar Only ***
	//					if(objScreenPartWrapper.TopType.equals("0"))
	//					{
	//						_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Top" ,this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("0"))
	//					{
	//						//					UniversalTopBar(objScreenPartWrapper,"Middle");
	//						_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Middle",this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("0"))
	//					{
	//						//					UniversalTopBar(objScreenPartWrapper,"Bottom");
	//						_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					//  **** For Top Bar with three Elements Only ***
	//					if(objScreenPartWrapper.TopType.equals("0.1"))
	//					{
	//						_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Top" ,this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("0.1"))
	//					{
	//						_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Middle",this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("0.1"))
	//					{
	//						_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//					if(objScreenPartWrapper.TopType.equals("0.2"))
	//					{
	//						//					UniversalTopBar(objScreenPartWrapper,"Top");
	//						_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Top" ,this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("0.2"))
	//					{
	//						//					UniversalTopBar(objScreenPartWrapper,"Middle");
	//						_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Middle",this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("0.2"))
	//					{
	//						//					UniversalTopBar(objScreenPartWrapper,"Bottom");
	//						_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//					//***** For AdvertiseMent Bar only **
	//					if(objScreenPartWrapper.TopType.equals("4"))
	//					{
	//						//					UniversalAdvertisementBar(objScreenPartWrapper,"Top");
	//						_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Top", this);
	//					}
	//					if(objScreenPartWrapper.MidType.equals("4"))
	//					{
	//						//					UniversalAdvertisementBar(objScreenPartWrapper,"Middle");
	//						_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Middle" , this);
	//					}
	//					if(objScreenPartWrapper.BottomType.equals("4"))
	//					{
	//						//					UniversalAdvertisementBar(objScreenPartWrapper,"Bottom");
	//						_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					// **** For GridView ****
	//					if(objScreenPartWrapper.TopType.equals("1"))
	//					{
	//						//					SetGridView(objScreenPartWrapper,"Top");
	//						_objGridView.SetGridView(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("1"))
	//					{
	//						//					SetGridView(objScreenPartWrapper,"Middle");
	//						_objGridView.SetGridView(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("1"))
	//					{
	//						//					SetGridView(objScreenPartWrapper,"Bottom");
	//						_objGridView.SetGridView(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//					// **** For List View Adapter ****
	//					if(objScreenPartWrapper.TopType.equals("2"))
	//					{
	//						//					SetListView(objScreenPartWrapper,"Top");
	//						_objUtilListView.SetListView(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("2"))
	//					{
	//						_objUtilListView.SetListView(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("2"))
	//					{
	//						_objUtilListView.SetListView(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					// **** For List View Adapter ****
	//					if(objScreenPartWrapper.TopType.equals("2.1"))
	//					{
	//						//					SetListView(objScreenPartWrapper,"Top");
	//						_objUtilListView01.SetListView(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("2.1"))
	//					{
	//						_objUtilListView01.SetListView(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("2.1"))
	//					{
	//						_objUtilListView01.SetListView(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//					// **** For Advertisement Switcher****
	//					if(objScreenPartWrapper.TopType.equals("20"))
	//					{
	//						_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("20"))
	//					{
	//						_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("20"))
	//					{
	//						_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					if(objScreenPartWrapper.TopType.equals("20.2"))
	//					{
	//						_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("20.2"))
	//					{
	//						_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("20.2"))
	//					{
	//						_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					// **** For Advertisement Manual Switcher****
	//					if(objScreenPartWrapper.TopType.equals("20.1"))
	//					{
	//						_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("20.1"))
	//					{
	//						_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("20.1"))
	//					{
	//						_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
	//					}
	//					if(objScreenPartWrapper.TopType.equals("20.3"))
	//					{
	//						_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("20.3"))
	//					{
	//						_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("20.3"))
	//					{
	//						_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//					// **** For Text Bottom Bar****
	//					if(objScreenPartWrapper.TopType.equals("23"))
	//					{
	//						_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("23"))
	//					{
	//						_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("23"))
	//					{
	//						_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//					// **** For Button  ****
	//					if(objScreenPartWrapper.TopType.equals("43"))
	//					{
	//						_objUtilButton.SetButtons(objScreenPartWrapper, "Top",this, "");
	//					}
	//					if(objScreenPartWrapper.MidType.equals("43"))
	//					{
	//						_objUtilButton.SetButtons(objScreenPartWrapper,"Middle" , this,"");
	//					}
	//					if(objScreenPartWrapper.BottomType.equals("43"))
	//					{
	//						_objUtilButton.SetButtons(objScreenPartWrapper,"Bottom" , this,"");
	//					}
	//
	//
	//				}
	//				LLLayout.setVisibility(View.GONE);
	//				MyUIApplication.Copy=false;
	//
	//			}
	//			else if(!MyUIApplication.Copy)
	//			{
	//
	//				LLLayout.setBackgroundColor(Color.WHITE);
	//				LLTop.setBackgroundColor(Color.WHITE);
	//				LLMiddle.setBackgroundColor(Color.WHITE);
	//				LLBottom.setBackgroundColor(Color.WHITE);
	//
	//				LLTop.setBackgroundColor(Color.WHITE);
	//				LLMiddle.setBackgroundColor(Color.WHITE);
	//				LLBottom.setBackgroundColor(Color.WHITE);
	//
	//				LLLayout.setVisibility(View.VISIBLE);
	//				LLTop.removeAllViews();
	//				LLMiddle.removeAllViews();
	//				LLBottom.removeAllViews();
	//
	//				LLTop.setBackgroundDrawable(null);
	//				LLMiddle.setBackgroundDrawable(null);
	//				LLBottom.setBackgroundDrawable(null);
	//
	//
	//				try
	//				{
	//					if(objScreenWrapper.bgImage.length()>0)
	//					{
	//						ImageUtil.setBgFromSDCardNotCache(LLLayout,this,objScreenWrapper.bgImage,deviceHeight,deviceWidth);
	//					}
	//					else if(objScreenWrapper.bgcolor.length()>0)
	//					{
	//						LLLayout.setBackgroundColor(Color.parseColor(objScreenWrapper.bgcolor));
	//					}
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
	//					ScreenLayout.setBackgroundColor(Color.parseColor("#0000FF"));
	//				}
	//
	//
	//
	//
	//				try
	//				{
	//					if(objScreenPartWrapper.TopbgImage.trim().length()>0)
	//					{
	//						ImageUtil.setBgFromSDCardNotCache(LLTop, this,objScreenPartWrapper.TopbgImage.trim(),Integer.parseInt(objScreenPartWrapper.TopHeight),Integer.parseInt(objScreenPartWrapper.TopWidth));
	//					}
	//					else if(objScreenPartWrapper.Topbgcolor.trim().length()>0)
	//					{
	//						LLTop.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Topbgcolor.trim()));
	//					}
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
	//					LLTop.setBackgroundColor(Color.WHITE);
	//				}
	//
	//				try
	//				{
	//					if(objScreenPartWrapper.MidbgImage.trim().length()>0)
	//					{
	//						ImageUtil.setBgFromSDCardNotCache(LLMiddle, this,objScreenPartWrapper.MidbgImage.trim(),Integer.parseInt(objScreenPartWrapper.MidHeight),Integer.parseInt(objScreenPartWrapper.MidWidth));
	//					}
	//					else if(objScreenPartWrapper.Midbgcolor.trim().length()>0)
	//					{
	//						LLMiddle.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Midbgcolor.trim()));
	//					}
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
	//					LLMiddle.setBackgroundColor(Color.WHITE);
	//				}
	//
	//				try
	//				{
	//					if(objScreenPartWrapper.BottombgImage.trim().length()>0)
	//					{
	//						ImageUtil.setBgFromSDCardNotCache(LLBottom, this,objScreenPartWrapper.BottombgImage.trim(),Integer.parseInt(objScreenPartWrapper.BottomHeight),Integer.parseInt(objScreenPartWrapper.BottomWidth));
	//					}
	//					else if(objScreenPartWrapper.Bottombgcolor.trim().length()>0)
	//					{
	//						LLBottom.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Bottombgcolor.trim()));
	//					}
	//				}
	//				catch (Exception e)
	//				{
	//					System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
	//					LLBottom.setBackgroundColor(Color.WHITE);
	//				}
	//
	//
	//				if(objScreenPartWrapper!=null)
	//				{
	//					//  **** For Top Bar Only ***
	//					if(objScreenPartWrapper.TopType.equals("0"))
	//					{
	//						_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Top" ,this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("0"))
	//					{
	//						_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Middle",this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("0"))
	//					{
	//						_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//
	//					//  **** For Top Bar with three Elements Only ***
	//					if(objScreenPartWrapper.TopType.equals("0.1"))
	//					{
	//						//					UniversalTopBar(objScreenPartWrapper,"Top");
	//						_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Top" ,this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("0.1"))
	//					{
	//						//					UniversalTopBar(objScreenPartWrapper,"Middle");
	//						_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Middle",this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("0.1"))
	//					{
	//						//					UniversalTopBar(objScreenPartWrapper,"Bottom");
	//						_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					//  **** For Top Bar Only ***
	//					if(objScreenPartWrapper.TopType.equals("0"))
	//					{
	//						_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Top" ,this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("0"))
	//					{
	//						_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Middle",this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("0"))
	//					{
	//						_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//					//***** For AdvertiseMent Bar only **
	//					if(objScreenPartWrapper.TopType.equals("4"))
	//					{
	//						//					UniversalAdvertisementBar(objScreenPartWrapper,"Top");
	//						_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Top", this);
	//					}
	//					if(objScreenPartWrapper.MidType.equals("4"))
	//					{
	//						//					UniversalAdvertisementBar(objScreenPartWrapper,"Middle");
	//						_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Middle" , this);
	//					}
	//					if(objScreenPartWrapper.BottomType.equals("4"))
	//					{
	//						//					UniversalAdvertisementBar(objScreenPartWrapper,"Bottom");
	//						_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					// **** For GridView ****
	//					if(objScreenPartWrapper.TopType.equals("1"))
	//					{
	//						_objGridView.SetGridView(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("1"))
	//					{
	//						_objGridView.SetGridView(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("1"))
	//					{
	//						_objGridView.SetGridView(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//					// **** For List View Adapter ****
	//					if(objScreenPartWrapper.TopType.equals("2"))
	//					{
	//						_objUtilListView.SetListView(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("2"))
	//					{
	//						_objUtilListView.SetListView(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("2"))
	//					{
	//						_objUtilListView.SetListView(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//
	//					// **** For List View Adapter ****
	//					if(objScreenPartWrapper.TopType.equals("2.1"))
	//					{
	//						//					SetListView(objScreenPartWrapper,"Top");
	//						_objUtilListView01.SetListView(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("2.1"))
	//					{
	//						_objUtilListView01.SetListView(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("2.1"))
	//					{
	//						_objUtilListView01.SetListView(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//
	//
	//					// **** For Advertisement Switcher****
	//					if(objScreenPartWrapper.TopType.equals("20"))
	//					{
	//						_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("20"))
	//					{
	//						_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("20"))
	//					{
	//						_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					if(objScreenPartWrapper.TopType.equals("20.2"))
	//					{
	//						_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("20.2"))
	//					{
	//						_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("20.2"))
	//					{
	//						_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					// **** For Advertisement Manual Switcher****
	//					if(objScreenPartWrapper.TopType.equals("20.1"))
	//					{
	//						_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("20.1"))
	//					{
	//						_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("20.1"))
	//					{
	//						_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					if(objScreenPartWrapper.TopType.equals("20.3"))
	//					{
	//						_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("20.3"))
	//					{
	//						_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("20.3"))
	//					{
	//						_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					// **** For Text Bottom Bar****
	//					if(objScreenPartWrapper.TopType.equals("23"))
	//					{
	//						_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Top" , this);
	//					}
	//					else if(objScreenPartWrapper.MidType.equals("23"))
	//					{
	//						_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Middle" , this);
	//					}
	//					else if(objScreenPartWrapper.BottomType.equals("23"))
	//					{
	//						_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Bottom" , this);
	//					}
	//
	//					// **** For Button  ****
	//					if(objScreenPartWrapper.TopType.equals("43"))
	//					{
	//						_objUtilButton.SetButtons(objScreenPartWrapper, "Top",this, "");
	//					}
	//					if(objScreenPartWrapper.MidType.equals("43"))
	//					{
	//						_objUtilButton.SetButtons(objScreenPartWrapper,"Middle" , this,"");
	//					}
	//					if(objScreenPartWrapper.BottomType.equals("43"))
	//					{
	//						_objUtilButton.SetButtons(objScreenPartWrapper,"Bottom" , this,"");
	//					}
	//
	//
	//				}
	//
	//				LLLayoutCopy.setVisibility(View.GONE);
	//
	//				//				LLTopCopy.removeAllViews();
	//				//				LLMiddleCopy.removeAllViews();
	//				//				LLBottomCopy.removeAllViews();
	//				MyUIApplication.Copy=true;
	//			}
	//			MyUIApplication.StateMachine.clear();
	//			MyUIApplication.StateMachine.add("0");
	//		}
	//		catch (Exception e) {
	//			System.out.println("Exception In DesignHomeScreen Method "+e);
	//		}
	//	}

	/**
	 * Push Notification Method
	 */
	public void CheckPointForPushNotification() {

		if(!MyUIApplication.pref.getPushStatus(MyUIApplication.ClientCode+"_"+MyUIApplication.EventCode)){

			AlertDialog.Builder dialog	=	new AlertDialog.Builder(this);
			dialog.setTitle("Notifications");
			dialog.setMessage("May we have permission to send you messages? If so please make sure your device is set to receive them.");
			dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					new PushNotificationMain(getBaseContext()).onCreate();
					//					DesignHomeScreen(); //KD_100220141840
					OpenHtmlPage("0", "");
					MyUIApplication.StateMachine.clear();
					MyUIApplication.StateMachine.add("0");
				}
			});
			dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					//					DesignHomeScreen(); //KD_100220141840
					OpenHtmlPage("0", "");
					MyUIApplication.StateMachine.clear();
					MyUIApplication.StateMachine.add("0");
				}
			});
			dialog.show();
		}else {
			//If registered ,Do nothing
			//			DesignHomeScreen(); //KD_100220141840
			OpenHtmlPage("0", "");
			MyUIApplication.StateMachine.clear();
			MyUIApplication.StateMachine.add("0");
		}
	}

	public LinearLayout LinearLayoutMenu;
	// ***** This is calling from list or Grid Adapter's Button Click  and Advertise Click*****
	public void OpenHtmlPage(String ScreenNumber,String UrlLink)
	{
		
		/***************************/
		 MyUIApplication.globel_instance	=	"";

		try {
			if (MyUIApplication.StateMachine.contains("-1")) {
				MyUIApplication.StateMachine.remove("-1");
			}
			else if(MyUIApplication.StateMachine.contains("-2"))
			{
				MyUIApplication.StateMachine.remove("-2");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try
		{
			ScreenPartWrapper objScreenPartWrapper = _objUtil.getScreenPartWrapper(ScreenNumber);
			MyUIApplication.currentScreenNumber =objScreenPartWrapper.ScreenName;

			if(objScreenPartWrapper.ScreenName.equals("-1"))
			{
				new  CountDownTimer(2000, 2000) {
					public void onTick(long millisUntilFinished)
					{

					}
					public void onFinish() {
						CheckPointForPushNotification();
					}
				}.start();
			} 

			if(objScreenPartWrapper.ScreenName.equals("50"))
			{



				LLTopMenu.setAnimation(inFromRightAnimation());
				LLMiddleMenu.setAnimation(inFromRightAnimation());
				LLBottomMenu.setAnimation(inFromRightAnimation());

				LLLayoutMenu.setVisibility(View.VISIBLE);
				MenuButton.setVisibility(View.VISIBLE);

				//  **** For Top Bar Only ***
				if(objScreenPartWrapper.TopType.equals("0"))
				{
					_objUtilMenu.UniversalTopBar(objScreenPartWrapper,"Top" ,this);
				}
				else if(objScreenPartWrapper.MidType.equals("0"))
				{
					_objUtilMenu.UniversalTopBar(objScreenPartWrapper,"Middle" ,this);
				}
				else if(objScreenPartWrapper.BottomType.equals("0"))
				{
					_objUtilMenu.UniversalTopBar(objScreenPartWrapper,"Bottom" ,this);
				}


				if(objScreenPartWrapper.TopType.equals("0.2"))
				{
					//					UniversalTopBar(objScreenPartWrapper,"Top");
					_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Top" ,this);
				}
				else if(objScreenPartWrapper.MidType.equals("0.2"))
				{
					//					UniversalTopBar(objScreenPartWrapper,"Middle");
					_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Middle",this);
				}
				else if(objScreenPartWrapper.BottomType.equals("0.2"))
				{
					//					UniversalTopBar(objScreenPartWrapper,"Bottom");
					_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Bottom" , this);
				}


				//***** For AdvertiseMent Bar only **
				if(objScreenPartWrapper.TopType.equals("4"))
				{
					_objUtilMenu.UniversalAdvertisementBar(objScreenPartWrapper,"Top" ,this);
				}
				if(objScreenPartWrapper.MidType.equals("4"))
				{
					_objUtilMenu.UniversalAdvertisementBar(objScreenPartWrapper,"Middle" ,this);
				}
				if(objScreenPartWrapper.BottomType.equals("4"))
				{
					_objUtilMenu.UniversalAdvertisementBar(objScreenPartWrapper,"Bottom" ,this);
				}




				// **** For Menu Page ****
				if(objScreenPartWrapper.TopType.equals("7"))
				{
					_objUtilMenu.SetMenuView(objScreenPartWrapper,"Top" , this );
				}
				else if(objScreenPartWrapper.MidType.equals("7"))
				{
					_objUtilMenu.SetMenuView(objScreenPartWrapper,"Middle" , this );
				}
				else if(objScreenPartWrapper.BottomType.equals("7"))
				{
					_objUtilMenu.SetMenuView(objScreenPartWrapper,"Bottom" , this );
				}
			}
			else if(objScreenPartWrapper.ScreenName.equals("2"))
			{
				try
				{
					Intent i = new Intent(Home.this, GoogleMapActivity.class);
					i.putExtra("GoogleScreenName" , ScreenNumber);
					startActivityForResult(i, 999);
					overridePendingTransition( R.anim.slide_in_left, R.anim.noanim );
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println("Exception in Intent%%%%%%"+e);
				}
			}
			else
			{
				//KD_250220141442
				if(objScreenPartWrapper.ScreenName.equals("0")){
					
					//Boolean for enable showupdate online check
					MyUIApplication.checkShowUpdate	=	true;
					MyUIApplication.checkUpdateCategory	=	true;
					MyUIApplication.currentScreenNumber =objScreenPartWrapper.ScreenName;
					
				}else if(objScreenPartWrapper.TopType.equals("12") || objScreenPartWrapper.MidType.equals("12") || objScreenPartWrapper.BottomType.equals("12") || objScreenPartWrapper.TopType.equals("51") || objScreenPartWrapper.MidType.equals("51") || objScreenPartWrapper.BottomType.equals("51"))
					///////////////////////////////////////Code for other screen update logic
				{
					MyUIApplication.checkShowUpdate	=	true;
				}

				if(MyUIApplication.Copy)
				{

					LLLayoutCopy.setBackgroundColor(Color.WHITE);
					LLTopCopy.setBackgroundColor(Color.WHITE);
					LLMiddleCopy.setBackgroundColor(Color.WHITE);
					LLBottomCopy.setBackgroundColor(Color.WHITE);

					LLTopCopy.setBackgroundColor(Color.WHITE);
					LLMiddleCopy.setBackgroundColor(Color.WHITE);
					LLBottomCopy.setBackgroundColor(Color.WHITE);



					LLLayoutCopy.setVisibility(View.VISIBLE);
					LLTopCopy.removeAllViews();
					LLMiddleCopy.removeAllViews();
					LLBottomCopy.removeAllViews();

					LLTopCopy.setBackgroundDrawable(null);
					LLMiddleCopy.setBackgroundDrawable(null);
					LLBottomCopy.setBackgroundDrawable(null);

					ScreenWrapper objScreenWrapper = _objUtil.getScreenWrapperFromDB(ScreenNumber);
					try
					{
						if(objScreenWrapper.bgImage.length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(LLLayoutCopy, this,objScreenWrapper.bgImage,deviceHeight,deviceWidth);
						}
						else if(objScreenWrapper.bgcolor.length()>0)
						{
							LLLayoutCopy.setBackgroundColor(Color.parseColor(objScreenWrapper.bgcolor));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
						ScreenLayout.setBackgroundColor(Color.WHITE);
					}



					try
					{
						if(objScreenPartWrapper.TopbgImage.trim().length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(LLTopCopy, this,objScreenPartWrapper.TopbgImage.trim(),Integer.parseInt(objScreenPartWrapper.TopHeight),Integer.parseInt(objScreenPartWrapper.TopWidth));
						}
						else if(objScreenPartWrapper.Topbgcolor.trim().length()>0)
						{
							LLTopCopy.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Topbgcolor.trim()));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
						LLTopCopy.setBackgroundColor(Color.WHITE);
					}

					try
					{
						if(objScreenPartWrapper.MidbgImage.trim().length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(LLMiddleCopy, this,objScreenPartWrapper.MidbgImage.trim(),Integer.parseInt(objScreenPartWrapper.MidHeight),Integer.parseInt(objScreenPartWrapper.MidWidth));
						}
						else if(objScreenPartWrapper.Midbgcolor.trim().length()>0)
						{
							LLMiddleCopy.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Midbgcolor.trim()));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
						LLMiddleCopy.setBackgroundColor(Color.WHITE);
					}

					try
					{
						if(objScreenPartWrapper.BottombgImage.trim().length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(LLBottomCopy, this,objScreenPartWrapper.BottombgImage.trim(),Integer.parseInt(objScreenPartWrapper.BottomHeight),Integer.parseInt(objScreenPartWrapper.BottomWidth));
						}
						else if(objScreenPartWrapper.Bottombgcolor.trim().length()>0)
						{
							LLBottomCopy.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Bottombgcolor.trim()));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
						LLBottomCopy.setBackgroundColor(Color.WHITE);
					}



					if(objScreenPartWrapper!=null)
					{
						//  **** For Top Bar Only ***
						if(objScreenPartWrapper.TopType.equals("0"))
						{
							_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Top" ,this);
						}
						else if(objScreenPartWrapper.MidType.equals("0"))
						{
							_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Middle" ,this);
						}
						else if(objScreenPartWrapper.BottomType.equals("0"))
						{
							_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Bottom" ,this);
						}

						//  **** For Top Bar with three Elements Only ***
						if(objScreenPartWrapper.TopType.equals("0.1"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Top");
							_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Top" ,this);
						}
						else if(objScreenPartWrapper.MidType.equals("0.1"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Middle");
							_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Middle",this);
						}
						else if(objScreenPartWrapper.BottomType.equals("0.1"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Bottom");
							_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Bottom" , this);
						}


						if(objScreenPartWrapper.TopType.equals("0.2"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Top");
							_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Top" ,this);
						}
						else if(objScreenPartWrapper.MidType.equals("0.2"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Middle");
							_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Middle",this);
						}
						else if(objScreenPartWrapper.BottomType.equals("0.2"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Bottom");
							_objUtilTopBar02.UniversalTopBar02(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For GridView ****
						if(objScreenPartWrapper.TopType.equals("1"))
						{
							_objGridView.SetGridView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("1"))
						{
							_objGridView.SetGridView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("1"))
						{
							_objGridView.SetGridView(objScreenPartWrapper,"Bottom" , this);
						}

						if(objScreenPartWrapper.TopType.equals("2"))
						{
							_objUtilListView.SetListView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("2"))
						{
							_objUtilListView.SetListView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("2"))
						{
							_objUtilListView.SetListView(objScreenPartWrapper,"Bottom" , this);
						}



						// **** For List View Adapter ****
						if(objScreenPartWrapper.TopType.equals("2.1"))
						{
							//					SetListView(objScreenPartWrapper,"Top");
							_objUtilListView01.SetListView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("2.1"))
						{
							_objUtilListView01.SetListView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("2.1"))
						{
							_objUtilListView01.SetListView(objScreenPartWrapper,"Bottom" , this);
						}
						
						/***Control for push Notification list*/
						if(objScreenPartWrapper.TopType.equals("2.2"))
						{
							//					SetListView(objScreenPartWrapper,"Top");
							_objUtilListView01.SetListView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("2.2"))
						{
							_objUtilListView01.SetListView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("2.2"))
						{
							_objUtilListView01.SetListView(objScreenPartWrapper,"Bottom" , this);
						}


						//***** For AdvertiseMent Bar only **
						if(objScreenPartWrapper.TopType.equals("4"))
						{
							_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Top" ,this);
						}
						if(objScreenPartWrapper.MidType.equals("4"))
						{
							_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Middle" ,this);
						}
						if(objScreenPartWrapper.BottomType.equals("4"))
						{
							_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Bottom" ,this);
						}

						// **** For Html Page ****
						if(objScreenPartWrapper.TopType.equals("6"))
						{
							_objUtilHtml.SetHtmlPage(objScreenPartWrapper,"Top" , this ,ScreenNumber);
						}
						if(objScreenPartWrapper.MidType.equals("6"))
						{
							_objUtilHtml.SetHtmlPage(objScreenPartWrapper,"Middle" , this ,ScreenNumber);
						}
						if(objScreenPartWrapper.BottomType.equals("6"))
						{
							_objUtilHtml.SetHtmlPage(objScreenPartWrapper,"Bottom" , this , ScreenNumber);
						}

						// **** For Html Page Content from XML ****
						if(objScreenPartWrapper.TopType.equals("6.1"))
						{
							_objUtilXMLHtml.SetHtmlPageFromXML(objScreenPartWrapper,"Top" , this ,ScreenNumber);
						}
						if(objScreenPartWrapper.MidType.equals("6.1"))
						{
							_objUtilXMLHtml.SetHtmlPageFromXML(objScreenPartWrapper,"Middle" , this ,ScreenNumber);
						}
						if(objScreenPartWrapper.BottomType.equals("6.1"))
						{
							_objUtilXMLHtml.SetHtmlPageFromXML(objScreenPartWrapper,"Bottom" , this , ScreenNumber);
						}


						if(!(objScreenPartWrapper.ScreenName.equals("114")))
						{

							// **** For HTML with Link  ****
							if(objScreenPartWrapper.TopType.equals("3"))
							{
								_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper,"Top" , this ,objScreenPartWrapper.TopLink);
							}
							else if(objScreenPartWrapper.MidType.equals("3"))
							{
								_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper,"Middle" , this ,objScreenPartWrapper.MidLink);
							}
							else if(objScreenPartWrapper.BottomType.equals("3"))
							{
								_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper, "Bottom" , this ,objScreenPartWrapper.BottomLink);
							}
						}
						// **** For HTML with Link  ****
						if(objScreenPartWrapper.TopType.equals("3") && objScreenPartWrapper.ScreenName.equals("114"))
						{
							_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper,"Top" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("3")&& objScreenPartWrapper.ScreenName.equals("114"))
						{
							_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("3")&& objScreenPartWrapper.ScreenName.equals("114"))
						{
							_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}


						// **** For Show Update Category ****
						if(objScreenPartWrapper.TopType.equals("24"))
						{
							_objUtilShowUpdateCategory.SetShowUpdateList(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("24"))
						{
							_objUtilShowUpdateCategory.SetShowUpdateList(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("24"))
						{
							_objUtilShowUpdateCategory.SetShowUpdateList(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}


						// **** For Show Update ****
						if(objScreenPartWrapper.TopType.equals("10"))
						{
							_objUtilShowUpdate.SetShowUpdateList(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("10"))
						{
							_objUtilShowUpdate.SetShowUpdateList(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("10"))
						{
							_objUtilShowUpdate.SetShowUpdateList(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// **** For Event List ****
						if(objScreenPartWrapper.TopType.equals("18"))
						{
							_objUtilEventList.SetEventsList(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("18"))
						{
							_objUtilEventList.SetEventsList(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("18"))
						{
							_objUtilEventList.SetEventsList(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// **** For Event Detail Page ****
						if(objScreenPartWrapper.TopType.equals("19"))
						{
							_objUtilEventDetail.SetEventsDetail(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("19"))
						{
							_objUtilEventDetail.SetEventsDetail(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("19"))
						{
							_objUtilEventDetail.SetEventsDetail(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// **** For Show Update Detail Page ****
						if(objScreenPartWrapper.TopType.equals("11"))
						{
							_objUtilShowUpdateDetail.SetShowUpdateDetail(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("11"))
						{
							_objUtilShowUpdateDetail.SetShowUpdateDetail(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("11"))
						{
							_objUtilShowUpdateDetail.SetShowUpdateDetail(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// picture Galery Category Grid 
						if(objScreenPartWrapper.TopType.equals("12"))
						{
							_objUtilPictureGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper,"Top" , Home.this );
						}
						else if(objScreenPartWrapper.MidType.equals("12"))
						{
							_objUtilPictureGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper,"Middle" , this );
						}
						else if(objScreenPartWrapper.BottomType.equals("12"))
						{
							_objUtilPictureGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper, "Bottom" , this );
						}

						// picture Galery Lazy Loading Tiles View  Grid 
						if(objScreenPartWrapper.TopType.equals("13"))
						{
							_objUtilPictureGalleryGrid.SetPictureGaleryGrid(objScreenPartWrapper,"Top" , Home.this,UrlLink );
						}
						else if(objScreenPartWrapper.MidType.equals("13"))
						{
							_objUtilPictureGalleryGrid.SetPictureGaleryGrid(objScreenPartWrapper,"Middle" , this,UrlLink );
						}
						else if(objScreenPartWrapper.BottomType.equals("13"))
						{
							_objUtilPictureGalleryGrid.SetPictureGaleryGrid(objScreenPartWrapper, "Bottom" , this , UrlLink);
						}

						// picture Galery  Detail view
						if(objScreenPartWrapper.TopType.equals("8"))
						{
							_objUtilPictureGalleryDetail.SetImageForPGDetail(objScreenPartWrapper,"Top" , Home.this ,ScreenNumber,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("8"))
						{
							_objUtilPictureGalleryDetail.SetImageForPGDetail(objScreenPartWrapper,"Middle" , this ,ScreenNumber,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("8"))
						{
							_objUtilPictureGalleryDetail.SetImageForPGDetail(objScreenPartWrapper, "Bottom" , this ,ScreenNumber,UrlLink);
						}

						// Video Gallery  Category
						if(objScreenPartWrapper.TopType.equals("51"))
						{
							_objUtilVideoGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper,"Top" , Home.this );
						}
						else if(objScreenPartWrapper.MidType.equals("51"))
						{
							_objUtilVideoGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper,"Middle" , this );
						}
						else if(objScreenPartWrapper.BottomType.equals("51"))
						{
							_objUtilVideoGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper, "Bottom" , this );
						}
						// Video Gallery  List view
						if(objScreenPartWrapper.TopType.equals("14"))
						{
							_objUtilVideoGalleryList.SetListView(objScreenPartWrapper,"Top" , Home.this );
						}
						else if(objScreenPartWrapper.MidType.equals("14"))
						{
							_objUtilVideoGalleryList.SetListView(objScreenPartWrapper,"Middle" , this );
						}
						else if(objScreenPartWrapper.BottomType.equals("14"))
						{
							_objUtilVideoGalleryList.SetListView(objScreenPartWrapper, "Bottom" , this );
						}

						// Video Gallery  Detail view
						if(objScreenPartWrapper.TopType.equals("15"))
						{
							_objUtilVideoGalleryDetail.SetVideoPlayer(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("15"))
						{
							_objUtilVideoGalleryDetail.SetVideoPlayer(objScreenPartWrapper,"Middle" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("15"))
						{
							_objUtilVideoGalleryDetail.SetVideoPlayer(objScreenPartWrapper, "Bottom" , Home.this ,UrlLink);
						}

						// Exhibitor List view
						if(objScreenPartWrapper.TopType.equals("16"))
						{
							_objUtilExhibitorList.SetExhibitorList(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("16"))
						{
							_objUtilExhibitorList.SetExhibitorList(objScreenPartWrapper,"Middle" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("16"))
						{
							_objUtilExhibitorList.SetExhibitorList(objScreenPartWrapper, "Bottom" , Home.this ,UrlLink);
						}

						// Exhibitor Detail view
						if(objScreenPartWrapper.TopType.equals("17"))
						{
							_objUtilExhibitorDetails.SetExhibitorDetails(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("17"))
						{
							_objUtilExhibitorDetails.SetExhibitorDetails(objScreenPartWrapper,"Middle" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("17"))
						{
							_objUtilExhibitorDetails.SetExhibitorDetails(objScreenPartWrapper, "Bottom" , Home.this ,UrlLink);
						}

						// **** For Advertisement Switcher****
						if(objScreenPartWrapper.TopType.equals("20"))
						{
							_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("20"))
						{
							_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("20"))
						{
							_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
						}

						if(objScreenPartWrapper.TopType.equals("20.2"))
						{
							_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("20.2"))
						{
							_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("20.2"))
						{
							_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Advertisement Switcher****
						if(objScreenPartWrapper.TopType.equals("20.1"))
						{
							_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("20.1"))
						{
							_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("20.1"))
						{
							_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
						}

						if(objScreenPartWrapper.TopType.equals("20.3"))
						{
							_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("20.3"))
						{
							_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("20.3"))
						{
							_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Picture Gallery Detail With Description ***
						if(objScreenPartWrapper.TopType.equals("22"))
						{
							_objUtilPictureDetailWithDesc.SetImageForPGDetail(objScreenPartWrapper, "Top", this, ScreenNumber, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("22"))
						{
							_objUtilPictureDetailWithDesc.SetImageForPGDetail(objScreenPartWrapper, "Middle", this, ScreenNumber, UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("22"))
						{
							_objUtilPictureDetailWithDesc.SetImageForPGDetail(objScreenPartWrapper, "Bottom", this, ScreenNumber, UrlLink);
						}

						// **** For Text Bottom Bar****
						if(objScreenPartWrapper.TopType.equals("23"))
						{
							_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("23"))
						{
							_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("23"))
						{
							_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Bottom" , this);
						}


						// **** For Speaker****
						if(objScreenPartWrapper.TopType.equals("25"))
						{
							_objUtilSpeaker.SetShowUpdateList(objScreenPartWrapper,"Top" , this,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("25"))
						{
							_objUtilSpeaker.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("25"))
						{
							_objUtilSpeaker.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}


						// **** For Speaker Details****
						if(objScreenPartWrapper.TopType.equals("26"))
						{
							_objUtilSpeakerDetail.SetShowUpdateDetail(objScreenPartWrapper, "Top", this, "");
						}
						else if(objScreenPartWrapper.MidType.equals("26"))
						{
							_objUtilSpeakerDetail.SetShowUpdateDetail(objScreenPartWrapper,"Middle" , this,"");
						}
						else if(objScreenPartWrapper.BottomType.equals("26"))
						{
							_objUtilSpeakerDetail.SetShowUpdateDetail(objScreenPartWrapper,"Bottom" , this,"");
						}

						// **** For Speaker Serach****
						if(objScreenPartWrapper.TopType.equals("27"))
						{
							_objUtilSpeakerSearch.SetShowUpdateList(objScreenPartWrapper,"Top" , this,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("27"))
						{
							_objUtilSpeakerSearch.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("27"))
						{
							_objUtilSpeakerSearch.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For Speaker Seminars Details****
						if(objScreenPartWrapper.TopType.equals("29"))
						{
							_objUtilSpeakerSeminarDetail.SetShowUpdateDetail(objScreenPartWrapper, "Top", this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("29"))
						{
							_objUtilSpeakerSeminarDetail.SetShowUpdateDetail(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("29"))
						{
							_objUtilSpeakerSeminarDetail.SetShowUpdateDetail(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For Speaker seminars ****
						if(objScreenPartWrapper.TopType.equals("28"))
						{
							_objUtilSpeakerSeminars.SetShowUpdateList(objScreenPartWrapper, "Top",this, "");
						}
						else if(objScreenPartWrapper.MidType.equals("28"))
						{
							_objUtilSpeakerSeminars.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,"");
						}
						else if(objScreenPartWrapper.BottomType.equals("28"))
						{
							_objUtilSpeakerSeminars.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,"");
						}


						// **** For My Registration ****
						if(objScreenPartWrapper.TopType.equals("31"))
						{
							_objUtilRegistration.SetShowUpdateList(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("31"))
						{
							_objUtilRegistration.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("31"))
						{
							_objUtilRegistration.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						if(MyUIApplication.UserName.length()==0)
						{
							// **** For Login ****
							if(objScreenPartWrapper.TopType.equals("37"))
							{
								_objUtilLogin.SetShowUpdateList(objScreenPartWrapper, "Top",this, UrlLink);
							}
							else if(objScreenPartWrapper.MidType.equals("37"))
							{
								_objUtilLogin.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
							}
							else if(objScreenPartWrapper.BottomType.equals("37"))
							{
								_objUtilLogin.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
							}

						}
						else 
						{

							// **** For Login ****
							if(objScreenPartWrapper.TopType.equals("37"))
							{
								_objUtilFriendsList.SetExhibitorList(objScreenPartWrapper, "Top",this, UrlLink,MyUIApplication.Copy);
							}
							else if(objScreenPartWrapper.MidType.equals("37"))
							{
								_objUtilFriendsList.SetExhibitorList(objScreenPartWrapper,"Middle" , this,UrlLink,MyUIApplication.Copy);
							}
							else if(objScreenPartWrapper.BottomType.equals("37"))
							{
								_objUtilFriendsList.SetExhibitorList(objScreenPartWrapper,"Bottom" , this,UrlLink,MyUIApplication.Copy);
							}

						}
						// **** For My seminars ****
						if(objScreenPartWrapper.TopType.equals("32"))
						{
							_objUtilSpeakerMySeminarEvent.SetShowUpdateList(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("32"))
						{
							_objUtilSpeakerMySeminarEvent.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("32"))
						{
							_objUtilSpeakerMySeminarEvent.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}
						// **** For My Product List ****
						if(objScreenPartWrapper.TopType.equals("34"))
						{
							_objUtilProductList.SetProductList(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("34"))
						{
							_objUtilProductList.SetProductList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("34"))
						{
							_objUtilProductList.SetProductList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For My Product Detais ****
						if(objScreenPartWrapper.TopType.equals("35"))
						{
							_objUtilProductDetail.SetProductDetail(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("35"))
						{
							_objUtilProductDetail.SetProductDetail(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("35"))
						{
							_objUtilProductDetail.SetProductDetail(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}


						// **** For Friends Code QR Code  ****
						if(objScreenPartWrapper.TopType.equals("38"))
						{
							_objUtilFriendsCode.SetFriendsCode(objScreenPartWrapper, "Top",this);
						}
						else if(objScreenPartWrapper.MidType.equals("38"))
						{
							_objUtilFriendsCode.SetFriendsCode(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("38"))
						{
							_objUtilFriendsCode.SetFriendsCode(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Enter Friends Code QR Code  ****
						if(objScreenPartWrapper.TopType.equals("39"))
						{
							_objUtilEnterFriendCode.SetEnterFriendsCode(objScreenPartWrapper, "Top",this);
						}
						else if(objScreenPartWrapper.MidType.equals("39"))
						{
							_objUtilEnterFriendCode.SetEnterFriendsCode(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("39"))
						{
							_objUtilEnterFriendCode.SetEnterFriendsCode(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Enter Friends Code QR Code  ****
						if(objScreenPartWrapper.TopType.equals("40"))
						{
							_objUtilRequestFriendCode.SetRequestFriendsCode(objScreenPartWrapper, "Top",this);
						}
						else if(objScreenPartWrapper.MidType.equals("40"))
						{
							_objUtilRequestFriendCode.SetRequestFriendsCode(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("40"))
						{
							_objUtilRequestFriendCode.SetRequestFriendsCode(objScreenPartWrapper,"Bottom" , this);
						}





						// **** For Friends Detais ****
						if(objScreenPartWrapper.TopType.equals("41"))
						{
							_objUtilFriendsDetail.SetFriendsDetail(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("41"))
						{
							_objUtilFriendsDetail.SetFriendsDetail(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("41"))
						{
							_objUtilFriendsDetail.SetFriendsDetail(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}


						// **** For TextField  ****
						if(objScreenPartWrapper.TopType.equals("42"))
						{
							_objUtilTextField.SetTextField(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("42"))
						{
							_objUtilTextField.SetTextField(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("42"))
						{
							_objUtilTextField.SetTextField(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For Button  ****
						if(objScreenPartWrapper.TopType.equals("43"))
						{
							_objUtilButton.SetButtons(objScreenPartWrapper, "Top",this, UrlLink);
						}
						if(objScreenPartWrapper.MidType.equals("43"))
						{
							_objUtilButton.SetButtons(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						if(objScreenPartWrapper.BottomType.equals("43"))
						{
							_objUtilButton.SetButtons(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}


					}
					LLLayout.setVisibility(View.GONE);
					//					LLTop.removeAllViews();
					//					LLMiddle.removeAllViews();
					//					LLBottom.removeAllViews();
					MyUIApplication.Copy=false;
				}

				else if(!MyUIApplication.Copy)
				{

					LLLayout.setBackgroundColor(Color.WHITE);
					LLTop.setBackgroundColor(Color.WHITE);
					LLMiddle.setBackgroundColor(Color.WHITE);
					LLBottom.setBackgroundColor(Color.WHITE);

					LLTop.setBackgroundColor(Color.WHITE);
					LLMiddle.setBackgroundColor(Color.WHITE);
					LLBottom.setBackgroundColor(Color.WHITE);


					LLLayout.setVisibility(View.VISIBLE);
					LLTop.removeAllViews();
					LLMiddle.removeAllViews();
					LLBottom.removeAllViews();

					LLTop.setBackgroundDrawable(null);
					LLMiddle.setBackgroundDrawable(null);
					LLBottom.setBackgroundDrawable(null);


					ScreenWrapper objScreenWrapper = _objUtil.getScreenWrapperFromDB(ScreenNumber);
					try
					{
						if(objScreenWrapper.bgImage.length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(LLLayout, this,objScreenWrapper.bgImage,deviceHeight,deviceWidth);
						}
						else if(objScreenWrapper.bgcolor.length()>0)
						{
							LLLayout.setBackgroundColor(Color.parseColor(objScreenWrapper.bgcolor));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
						LLLayout.setBackgroundColor(Color.WHITE);
					}




					try
					{
						if(objScreenPartWrapper.TopbgImage.trim().length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(LLTop, this,objScreenPartWrapper.TopbgImage.trim(),Integer.parseInt(objScreenPartWrapper.TopHeight),Integer.parseInt(objScreenPartWrapper.TopWidth));
						}
						else if(objScreenPartWrapper.Topbgcolor.trim().length()>0)
						{
							LLTop.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Topbgcolor.trim()));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
						LLTop.setBackgroundColor(Color.WHITE);
					}

					try
					{
						if(objScreenPartWrapper.MidbgImage.trim().length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(LLMiddle, this,objScreenPartWrapper.MidbgImage.trim(),(int)((Double.parseDouble(objScreenPartWrapper.MidHeight)/100)*deviceHeight),(Integer.parseInt(objScreenPartWrapper.MidWidth)/100)*deviceWidth);
						}
						else if(objScreenPartWrapper.Midbgcolor.trim().length()>0)
						{
							LLMiddle.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Midbgcolor.trim()));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
						LLMiddle.setBackgroundColor(Color.WHITE);
					}

					try
					{
						if(objScreenPartWrapper.BottombgImage.trim().length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(LLBottom, this,objScreenPartWrapper.BottombgImage.trim(),Integer.parseInt(objScreenPartWrapper.BottomHeight),Integer.parseInt(objScreenPartWrapper.BottomWidth));
						}
						else if(objScreenPartWrapper.Bottombgcolor.trim().length()>0)
						{
							LLBottom.setBackgroundColor(Color.parseColor(objScreenPartWrapper.Bottombgcolor.trim()));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in DesignHomeScreen() Set backgroung bgcolor and image");
						LLBottom.setBackgroundColor(Color.WHITE);
					}




					if(objScreenPartWrapper!=null)
					{


						//  **** For Top Bar Only ***
						if(objScreenPartWrapper.TopType.equals("0"))
						{
							_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Top" ,this);
						}
						else if(objScreenPartWrapper.MidType.equals("0"))
						{
							_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Middle" ,this);
						}
						else if(objScreenPartWrapper.BottomType.equals("0"))
						{
							_objUtilTopBar.UniversalTopBar(objScreenPartWrapper,"Bottom" ,this);
						}


						//  **** For Top Bar with three Elements Only ***
						if(objScreenPartWrapper.TopType.equals("0.1"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Top");
							_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Top" ,this);
						}
						else if(objScreenPartWrapper.MidType.equals("0.1"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Middle");
							_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Middle",this);
						}
						else if(objScreenPartWrapper.BottomType.equals("0.1"))
						{
							//					UniversalTopBar(objScreenPartWrapper,"Bottom");
							_objUtilTopBar01.UniversalTopBar01(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For GridView ****
						if(objScreenPartWrapper.TopType.equals("1"))
						{
							_objGridView.SetGridView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("1"))
						{
							_objGridView.SetGridView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("1"))
						{
							_objGridView.SetGridView(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For ListView ****
						if(objScreenPartWrapper.TopType.equals("2"))
						{
							_objUtilListView.SetListView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("2"))
						{
							_objUtilListView.SetListView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("2"))
						{
							_objUtilListView.SetListView(objScreenPartWrapper,"Bottom" , this);
						}



						// **** For List View Adapter ****
						if(objScreenPartWrapper.TopType.equals("2.1"))
						{
							//					SetListView(objScreenPartWrapper,"Top");
							_objUtilListView01.SetListView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("2.1"))
						{
							_objUtilListView01.SetListView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("2.1"))
						{
							_objUtilListView01.SetListView(objScreenPartWrapper,"Bottom" , this);
						}


						//***** For AdvertiseMent Bar only **
						if(objScreenPartWrapper.TopType.equals("4"))
						{
							_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Top" ,this);
						}
						if(objScreenPartWrapper.MidType.equals("4"))
						{
							_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Middle" ,this);
						}
						if(objScreenPartWrapper.BottomType.equals("4"))
						{
							_objUtilAddBar.UniversalAdvertisementBar(objScreenPartWrapper,"Bottom" ,this);
						}

						// **** For Html Page ****
						if(objScreenPartWrapper.TopType.equals("6"))
						{
							//							UtilHtml _objUtilHtml = new UtilHtml();
							_objUtilHtml.SetHtmlPage(objScreenPartWrapper,"Top" , this ,ScreenNumber);
						}
						if(objScreenPartWrapper.MidType.equals("6"))
						{
							//							UtilHtml _objUtilHtml = new UtilHtml();
							_objUtilHtml.SetHtmlPage(objScreenPartWrapper,"Middle" , this ,ScreenNumber);
						}
						if(objScreenPartWrapper.BottomType.equals("6"))
						{
							//							UtilHtml _objUtilHtml = new UtilHtml();
							_objUtilHtml.SetHtmlPage(objScreenPartWrapper,"Bottom" , this , ScreenNumber);
						}

						// **** For Html Page Content from XML ****
						if(objScreenPartWrapper.TopType.equals("6.1"))
						{
							_objUtilXMLHtml.SetHtmlPageFromXML(objScreenPartWrapper,"Top" , this ,ScreenNumber);
						}
						if(objScreenPartWrapper.MidType.equals("6.1"))
						{
							_objUtilXMLHtml.SetHtmlPageFromXML(objScreenPartWrapper,"Middle" , this ,ScreenNumber);
						}
						if(objScreenPartWrapper.BottomType.equals("6.1"))
						{
							_objUtilXMLHtml.SetHtmlPageFromXML(objScreenPartWrapper,"Bottom" , this , ScreenNumber);
						}


						if(!(objScreenPartWrapper.ScreenName.equals("114")))
						{
							// **** For HTML with Link  ****
							if(objScreenPartWrapper.TopType.equals("3"))
							{
								_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper,"Top" , this ,objScreenPartWrapper.TopLink);
							}
							else if(objScreenPartWrapper.MidType.equals("3"))
							{
								_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper,"Middle" , this ,objScreenPartWrapper.MidLink);
							}
							else if(objScreenPartWrapper.BottomType.equals("3"))
							{
								_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper, "Bottom" , this ,objScreenPartWrapper.BottomLink);
							}
						}

						// **** For HTML with Link  ****
						if(objScreenPartWrapper.TopType.equals("3") && objScreenPartWrapper.ScreenName.equals("114"))
						{
							_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper,"Top" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("3")&& objScreenPartWrapper.ScreenName.equals("114"))
						{
							_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("3")&& objScreenPartWrapper.ScreenName.equals("114"))
						{
							_objUtilHtmlWithLink.SetHtmlPageWithLink(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// **** For Show Update Category ****
						if(objScreenPartWrapper.TopType.equals("24"))
						{
							_objUtilShowUpdateCategory.SetShowUpdateList(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("24"))
						{
							_objUtilShowUpdateCategory.SetShowUpdateList(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("24"))
						{
							_objUtilShowUpdateCategory.SetShowUpdateList(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}


						// **** For Show Update ****
						if(objScreenPartWrapper.TopType.equals("10"))
						{
							_objUtilShowUpdate.SetShowUpdateList(objScreenPartWrapper,"Top" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("10"))
						{
							_objUtilShowUpdate.SetShowUpdateList(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("10"))
						{
							_objUtilShowUpdate.SetShowUpdateList(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// **** For Show Update Detail Page ****
						if(objScreenPartWrapper.TopType.equals("11"))
						{
							_objUtilShowUpdateDetail.SetShowUpdateDetail(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("11"))
						{
							_objUtilShowUpdateDetail.SetShowUpdateDetail(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("11"))
						{
							_objUtilShowUpdateDetail.SetShowUpdateDetail(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// **** For Show Update ****
						if(objScreenPartWrapper.TopType.equals("18"))
						{
							_objUtilEventList.SetEventsList(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("18"))
						{
							_objUtilEventList.SetEventsList(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("18"))
						{
							_objUtilEventList.SetEventsList(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// **** For Event Detail Page ****
						if(objScreenPartWrapper.TopType.equals("19"))
						{
							_objUtilEventDetail.SetEventsDetail(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("19"))
						{
							_objUtilEventDetail.SetEventsDetail(objScreenPartWrapper,"Middle" , this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("19"))
						{
							_objUtilEventDetail.SetEventsDetail(objScreenPartWrapper, "Bottom" , this ,UrlLink);
						}

						// picture Gallery Category Grid 
						if(objScreenPartWrapper.TopType.equals("12"))
						{
							_objUtilPictureGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper,"Top" , Home.this );
						}
						else if(objScreenPartWrapper.MidType.equals("12"))
						{
							_objUtilPictureGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper,"Middle" , this );
						}
						else if(objScreenPartWrapper.BottomType.equals("12"))
						{
							_objUtilPictureGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper, "Bottom" , this );
						}

						// picture Gallery  Grid view
						if(objScreenPartWrapper.TopType.equals("13"))
						{
							_objUtilPictureGalleryGrid.SetPictureGaleryGrid(objScreenPartWrapper,"Top" , Home.this,UrlLink );
						}
						else if(objScreenPartWrapper.MidType.equals("13"))
						{
							_objUtilPictureGalleryGrid.SetPictureGaleryGrid(objScreenPartWrapper,"Middle" , this,UrlLink );
						}
						else if(objScreenPartWrapper.BottomType.equals("13"))
						{
							_objUtilPictureGalleryGrid.SetPictureGaleryGrid(objScreenPartWrapper, "Bottom" , this,UrlLink );
						}

						// picture Gallery  Detail view
						if(objScreenPartWrapper.TopType.equals("8"))
						{
							_objUtilPictureGalleryDetail.SetImageForPGDetail(objScreenPartWrapper,"Top" , Home.this ,ScreenNumber,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("8"))
						{
							_objUtilPictureGalleryDetail.SetImageForPGDetail(objScreenPartWrapper,"Middle" , this ,ScreenNumber,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("8"))
						{
							_objUtilPictureGalleryDetail.SetImageForPGDetail(objScreenPartWrapper, "Bottom" , this ,ScreenNumber,UrlLink);
						}

						// Video Gallery  Category
						if(objScreenPartWrapper.TopType.equals("51"))
						{
							_objUtilVideoGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper,"Top" , Home.this );
						}
						else if(objScreenPartWrapper.MidType.equals("51"))
						{
							_objUtilVideoGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper,"Middle" , this );
						}
						else if(objScreenPartWrapper.BottomType.equals("51"))
						{
							_objUtilVideoGalleryCategory.SetPictureGaleryCategory(objScreenPartWrapper, "Bottom" , this );
						}

						// Video Gallery  List view
						if(objScreenPartWrapper.TopType.equals("14"))
						{
							_objUtilVideoGalleryList.SetListView(objScreenPartWrapper,"Top" , Home.this );
						}
						else if(objScreenPartWrapper.MidType.equals("14"))
						{
							_objUtilVideoGalleryList.SetListView(objScreenPartWrapper,"Middle" , this );
						}
						else if(objScreenPartWrapper.BottomType.equals("14"))
						{
							_objUtilVideoGalleryList.SetListView(objScreenPartWrapper, "Bottom" , this );
						}

						// Video Gallery  Detail view

						if(objScreenPartWrapper.TopType.equals("15"))
						{
							_objUtilVideoGalleryDetail.SetVideoPlayer(objScreenPartWrapper,"Top" , Home.this, UrlLink);

						}
						else if(objScreenPartWrapper.MidType.equals("15"))
						{
							_objUtilVideoGalleryDetail.SetVideoPlayer(objScreenPartWrapper,"Middle" , Home.this, UrlLink );
						}
						else if(objScreenPartWrapper.BottomType.equals("15"))
						{
							_objUtilVideoGalleryDetail.SetVideoPlayer(objScreenPartWrapper, "Bottom" ,  Home.this, UrlLink );
						}

						// Exhibitor List view
						if(objScreenPartWrapper.TopType.equals("16"))
						{
							_objUtilExhibitorList.SetExhibitorList(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("16"))
						{
							_objUtilExhibitorList.SetExhibitorList(objScreenPartWrapper,"Middle" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("16"))
						{
							_objUtilExhibitorList.SetExhibitorList(objScreenPartWrapper, "Bottom" , Home.this ,UrlLink);
						}


						// Exhibitor Detail view
						if(objScreenPartWrapper.TopType.equals("17"))
						{
							_objUtilExhibitorDetails.SetExhibitorDetails(objScreenPartWrapper,"Top" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("17"))
						{
							_objUtilExhibitorDetails.SetExhibitorDetails(objScreenPartWrapper,"Middle" , Home.this ,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("17"))
						{
							_objUtilExhibitorDetails.SetExhibitorDetails(objScreenPartWrapper, "Bottom" , Home.this ,UrlLink);
						}


						// **** For Advertisement Switcher****
						if(objScreenPartWrapper.TopType.equals("20"))
						{
							_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("20"))
						{
							_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("20"))
						{
							_objUtilAdvertisementSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
						}

						if(objScreenPartWrapper.TopType.equals("20.2"))
						{
							_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("20.2"))
						{
							_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("20.2"))
						{
							_objUtilImageSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Advertisement Switcher****
						if(objScreenPartWrapper.TopType.equals("20.1"))
						{
							_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("20.1"))
						{
							_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("20.1"))
						{
							_objUtilAdvertisementManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
						}

						if(objScreenPartWrapper.TopType.equals("20.3"))
						{
							_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("20.3"))
						{
							_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("20.3"))
						{
							_objUtilImageManualSwitcher.UniversalAdvertisementSwitcher(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Picture Gallery Detail With Description ***
						if(objScreenPartWrapper.TopType.equals("22"))
						{
							_objUtilPictureDetailWithDesc.SetImageForPGDetail(objScreenPartWrapper, "Top", this, ScreenNumber, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("22"))
						{
							_objUtilPictureDetailWithDesc.SetImageForPGDetail(objScreenPartWrapper, "Middle", this, ScreenNumber, UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("22"))
						{
							_objUtilPictureDetailWithDesc.SetImageForPGDetail(objScreenPartWrapper, "Bottom", this, ScreenNumber, UrlLink);
						}

						// **** For Text Bottom Bar****
						if(objScreenPartWrapper.TopType.equals("23"))
						{
							_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Top" , this);
						}
						else if(objScreenPartWrapper.MidType.equals("23"))
						{
							_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("23"))
						{
							_objUtilButtonBar.SetButtonBarView(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Speaker****
						if(objScreenPartWrapper.TopType.equals("25"))
						{
							_objUtilSpeaker.SetShowUpdateList(objScreenPartWrapper,"Top" , this,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("25"))
						{
							_objUtilSpeaker.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("25"))
						{
							_objUtilSpeaker.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}



						// **** For Speaker Details****
						if(objScreenPartWrapper.TopType.equals("26"))
						{
							_objUtilSpeakerDetail.SetShowUpdateDetail(objScreenPartWrapper, "Top", this, "");
						}
						else if(objScreenPartWrapper.MidType.equals("26"))
						{
							_objUtilSpeakerDetail.SetShowUpdateDetail(objScreenPartWrapper,"Middle" , this,"");
						}
						else if(objScreenPartWrapper.BottomType.equals("26"))
						{
							_objUtilSpeakerDetail.SetShowUpdateDetail(objScreenPartWrapper,"Bottom" , this,"");
						}

						// **** For Speaker Serach****
						if(objScreenPartWrapper.TopType.equals("27"))
						{
							_objUtilSpeakerSearch.SetShowUpdateList(objScreenPartWrapper,"Top" , this,UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("27"))
						{
							_objUtilSpeakerSearch.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("27"))
						{
							_objUtilSpeakerSearch.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}


						// **** For Speaker seminars Details****
						if(objScreenPartWrapper.TopType.equals("28"))
						{
							_objUtilSpeakerSeminars.SetShowUpdateList(objScreenPartWrapper, "Top",this, "");
						}
						else if(objScreenPartWrapper.MidType.equals("28"))
						{
							_objUtilSpeakerSeminars.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,"");
						}
						else if(objScreenPartWrapper.BottomType.equals("28"))
						{
							_objUtilSpeakerSeminars.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,"");
						}


						// **** For Speaker Seminars Details****
						if(objScreenPartWrapper.TopType.equals("29"))
						{
							_objUtilSpeakerSeminarDetail.SetShowUpdateDetail(objScreenPartWrapper, "Top", this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("29"))
						{
							_objUtilSpeakerSeminarDetail.SetShowUpdateDetail(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("29"))
						{
							_objUtilSpeakerSeminarDetail.SetShowUpdateDetail(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For My Registration ****
						if(objScreenPartWrapper.TopType.equals("31"))
						{
							_objUtilRegistration.SetShowUpdateList(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("31"))
						{
							_objUtilRegistration.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("31"))
						{
							_objUtilRegistration.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						if(MyUIApplication.UserName.length()==0)
						{


							// **** For Login ****
							if(objScreenPartWrapper.TopType.equals("37"))
							{
								_objUtilLogin.SetShowUpdateList(objScreenPartWrapper, "Top",this, UrlLink);
							}
							else if(objScreenPartWrapper.MidType.equals("37"))
							{
								_objUtilLogin.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
							}
							else if(objScreenPartWrapper.BottomType.equals("37"))
							{
								_objUtilLogin.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
							}
						}
						else
						{

							// **** For Login ****
							if(objScreenPartWrapper.TopType.equals("37"))
							{
								_objUtilFriendsList.SetExhibitorList(objScreenPartWrapper, "Top",this, UrlLink,MyUIApplication.Copy);
							}
							else if(objScreenPartWrapper.MidType.equals("37"))
							{
								_objUtilFriendsList.SetExhibitorList(objScreenPartWrapper,"Middle" , this,UrlLink,MyUIApplication.Copy);
							}
							else if(objScreenPartWrapper.BottomType.equals("37"))
							{
								_objUtilFriendsList.SetExhibitorList(objScreenPartWrapper,"Bottom" , this,UrlLink,MyUIApplication.Copy);
							}

						}
						// **** For My seminars ****
						if(objScreenPartWrapper.TopType.equals("32"))
						{
							_objUtilSpeakerMySeminarEvent.SetShowUpdateList(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("32"))
						{
							_objUtilSpeakerMySeminarEvent.SetShowUpdateList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("32"))
						{
							_objUtilSpeakerMySeminarEvent.SetShowUpdateList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}


						// **** For My Product List ****
						if(objScreenPartWrapper.TopType.equals("34"))
						{
							_objUtilProductList.SetProductList(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("34"))
						{
							_objUtilProductList.SetProductList(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("34"))
						{
							_objUtilProductList.SetProductList(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For My Product Detais ****
						if(objScreenPartWrapper.TopType.equals("35"))
						{
							_objUtilProductDetail.SetProductDetail(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("35"))
						{
							_objUtilProductDetail.SetProductDetail(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("35"))
						{
							_objUtilProductDetail.SetProductDetail(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For Friends Code QR Code  ****
						if(objScreenPartWrapper.TopType.equals("38"))
						{
							_objUtilFriendsCode.SetFriendsCode(objScreenPartWrapper, "Top",this);
						}
						else if(objScreenPartWrapper.MidType.equals("38"))
						{
							_objUtilFriendsCode.SetFriendsCode(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("38"))
						{
							_objUtilFriendsCode.SetFriendsCode(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Enter Friends Code QR Code  ****
						if(objScreenPartWrapper.TopType.equals("39"))
						{
							_objUtilEnterFriendCode.SetEnterFriendsCode(objScreenPartWrapper, "Top",this);
						}
						else if(objScreenPartWrapper.MidType.equals("39"))
						{
							_objUtilEnterFriendCode.SetEnterFriendsCode(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("39"))
						{
							_objUtilEnterFriendCode.SetEnterFriendsCode(objScreenPartWrapper,"Bottom" , this);
						}

						// **** For Enter Friends Code QR Code  ****
						if(objScreenPartWrapper.TopType.equals("40"))
						{
							_objUtilRequestFriendCode.SetRequestFriendsCode(objScreenPartWrapper, "Top",this);
						}
						else if(objScreenPartWrapper.MidType.equals("40"))
						{
							_objUtilRequestFriendCode.SetRequestFriendsCode(objScreenPartWrapper,"Middle" , this);
						}
						else if(objScreenPartWrapper.BottomType.equals("40"))
						{
							_objUtilRequestFriendCode.SetRequestFriendsCode(objScreenPartWrapper,"Bottom" , this);
						}



						// **** For Friends Detais ****
						if(objScreenPartWrapper.TopType.equals("41"))
						{
							_objUtilFriendsDetail.SetFriendsDetail(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("41"))
						{
							_objUtilFriendsDetail.SetFriendsDetail(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("41"))
						{
							_objUtilFriendsDetail.SetFriendsDetail(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For TextField  ****
						if(objScreenPartWrapper.TopType.equals("42"))
						{
							_objUtilTextField.SetTextField(objScreenPartWrapper, "Top",this, UrlLink);
						}
						else if(objScreenPartWrapper.MidType.equals("42"))
						{
							_objUtilTextField.SetTextField(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						else if(objScreenPartWrapper.BottomType.equals("42"))
						{
							_objUtilTextField.SetTextField(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}

						// **** For Button  ****
						if(objScreenPartWrapper.TopType.equals("43"))
						{
							_objUtilButton.SetButtons(objScreenPartWrapper, "Top",this, UrlLink);
						}
						if(objScreenPartWrapper.MidType.equals("43"))
						{
							_objUtilButton.SetButtons(objScreenPartWrapper,"Middle" , this,UrlLink);
						}
						if(objScreenPartWrapper.BottomType.equals("43"))
						{
							_objUtilButton.SetButtons(objScreenPartWrapper,"Bottom" , this,UrlLink);
						}



					}
					LLLayoutCopy.setVisibility(View.GONE);
					//					LLTopCopy.removeAllViews();
					//					LLMiddleCopy.removeAllViews();
					//					LLBottomCopy.removeAllViews();
					MyUIApplication.Copy=true;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
//			System.out.println(""+e);
		}

		System.out.println(MyUIApplication.StateMachine.toString());
	}


	public void clearAllResources() {
		// Set related variables null
		System.gc();
		Runtime.getRuntime().gc();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			try
			{
				clearAllResources();

				//				if(_objUtilAdvertisementSwitcher.handler.)
				//				_objUtilAdvertisementSwitcher.handler.removeCallbacks(_objUtilAdvertisementSwitcher.runnable);

				/**To close Video gallary*/
				try
				{
					if(UtilVideoGalleryDetail.videoview!=null &&UtilVideoGalleryDetail.videoview.isPlaying())
					{
						UtilVideoGalleryDetail.videoview.stopPlayback();
					}
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}

				/**To close slide menu*/
				if(LLLayoutMenu.getVisibility()==View.VISIBLE && MenuButton.getVisibility()==View.VISIBLE)
				{

					LLLayoutMenu.setAnimation(outToRightAnimation());
					LLLayoutMenu.setVisibility(View.GONE);
					MenuButton.setVisibility(View.GONE);

					//					Thread thread = new Thread()
					//					{
					//						@Override
					//						public void run()
					//						{
					//							try 
					//							{
					//								Thread.sleep(500);
					//							}
					//							catch (InterruptedException e)
					//							{
					//							}
					//							runOnUiThread(new Runnable()
					//							{
					//								public void run() 
					//								{
					//									// Do some stuff
					//									LLTopMenu.removeAllViews();
					//									LLMiddleMenu.removeAllViews();
					//									LLBottomMenu.removeAllViews();
					//								}
					//							});
					//						}
					//					};

					return true;
				}
				else
				{

					if(MyUIApplication.StateMachine.size()==1)
					{
						if(!((MyUIApplication)getApplication()).showclientscreen)
						{

							AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
							//		alertDialogBuilder.setTitle("Exit the app");
							alertDialogBuilder.setCancelable(true);

							// set dialog message
							alertDialogBuilder
							.setMessage("Do you want to exit from the application?")
							.setCancelable(false)
							.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									// if this button is clicked, close
									// current activity

									finish();          

									try {
										System.runFinalizersOnExit(true);
										//Force the system to close the app down completely.
										System.exit(0);
									} catch (Exception e) {
										// TODO: handle exception
									}

								}
							})
							.setNegativeButton("No",new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									// if this button is clicked, just close
									// the dialog box and do nothing
									dialog.cancel();
								}
							});

							// create alert dialog
							AlertDialog alertDialog = alertDialogBuilder.create();
							alertDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
							// show it
							alertDialog.show();
						}
						else
						{
							finish();  
							overridePendingTransition(0,R.anim.slide_in_right);
						}

					}

					else if(MyUIApplication.StateMachine.size()>0)
					{
						MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
						System.out.println("State Machine"+MyUIApplication.StateMachine);


						//						if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
						//						{
						////							DesignHomeScreen();
						//							OpenHtmlPage("0", "");
						//							//							if(LLLayout.getVisibility()==View.VISIBLE)
						//							//							{
						//							//								LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_right));
						//							//								LLLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_right));
						//							//							}
						//							//							if(LLLayoutCopy.getVisibility()==View.VISIBLE)
						//							//							{
						//							//								LLLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_right));
						//							//								LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_right));
						//							//							}
						//
						//							outLayoutAnim();
						//						}	
						//						else
						//						{
						String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);

						//						if(LastScreen.equals("112"))
						//						{
						//							MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
						//							LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
						//						}
						//						else if(LastScreen.equals("113"))
						//						{
						//							MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
						//							LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
						//						}
						//						else if(LastScreen.equals("114"))
						//						{
						//							MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
						//							LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
						//						}

						OpenHtmlPage(LastScreen,""); 

						//							if(LLLayout.getVisibility()==View.VISIBLE)
						//							{
						//								LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_right));
						//								LLLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_right));
						//							}
						//							if(LLLayoutCopy.getVisibility()==View.VISIBLE)
						//							{
						//								LLLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_right));
						//								LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_right));
						//							}

						outLayoutAnim();
						//						}
						return true;
					}
				}

			}
			catch(Exception ex)
			{
				System.out.println("Exception in onkeydown "+ex);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		try
		{
			int seek=0;
			if(UtilVideoGalleryDetail.videoview.isPlaying())
			{
				if (UtilVideoGalleryDetail.videoview.isPlaying()) 
				{
					seek = UtilVideoGalleryDetail.videoview.getCurrentPosition();
					UtilVideoGalleryDetail.videoview.pause();

				} 
				else 
				{
					UtilVideoGalleryDetail.videoview.seekTo(seek);
					UtilVideoGalleryDetail.videoview.start();
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void TransparentMenuBtnOnclick(View v)
	{
		if(LLLayoutMenu.getVisibility()==View.VISIBLE && MenuButton.getVisibility()==View.VISIBLE)
		{
			//			Toast.makeText(this, "Top bar pressed", Toast.LENGTH_LONG).show();
			LLLayoutMenu.setAnimation(outToRightAnimation());
			LLLayoutMenu.setVisibility(View.GONE);
			MenuButton.setVisibility(View.GONE);

			Thread thread = new Thread()
			{
				public void run()
				{
					try 
					{
						Thread.sleep(500);
					}
					catch (InterruptedException e)
					{
					}
					runOnUiThread(new Runnable()
					{
						public void run() 
						{
							// Do some stuff
							LLTopMenu.removeAllViews();
							LLMiddleMenu.removeAllViews();
							LLBottomMenu.removeAllViews();
						}
					});
				}
			};
		}
	}

	
	public void inLayoutAnim()
	{
		if(MyUIApplication.Copy)
		{
			LLLayoutCopy.setAnimation(inFromRightAnimation());
			LLLayoutCopy.bringToFront();
			LLLayout.setAnimation(out1ToLeftAnimation());
		}

		else
		{
			LLLayout.setAnimation(inFromRightAnimation());
			LLLayout.bringToFront();
			LLLayoutCopy.setAnimation(out1ToLeftAnimation());
		}

	}

	public void outLayoutAnim()
	{
		if(MyUIApplication.Copy)
		{
			LLLayoutCopy.setAnimation(outToRightAnimation());
		}

		else
		{
			LLLayout.setAnimation(outToRightAnimation());
		}

	}

	public void TopBarClick(View v)
	{

	}
	public Animation inFromRightAnimation() {

		Animation inFromRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(600);
		inFromRight.setInterpolator(new AccelerateInterpolator());
		return inFromRight;
	}

	//	outToLeftAnimation   
	public Animation outToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(500);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	public Animation out1ToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(600);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	//	inFromLeftAnimation

	public Animation inFromLeftAnimation() {
		Animation inFromLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromLeft.setDuration(500);
		inFromLeft.setInterpolator(new AccelerateInterpolator());
		return inFromLeft;
	}

	//	4)outToRightAnimation

	public Animation outToRightAnimation() {
		Animation outtoRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoRight.setDuration(600);
		outtoRight.setInterpolator(new AccelerateInterpolator());
		outtoRight.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				if(MyUIApplication.Copy)
				{
					LLLayoutCopy.bringToFront();
				}

				else
				{
					LLLayout.bringToFront();
				}
			}

			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub

				if(MyUIApplication.Copy)
				{
					LLLayout.bringToFront();
				}

				else
				{
					LLLayoutCopy.bringToFront();
				}

			}
		});
		return outtoRight;
	}
}