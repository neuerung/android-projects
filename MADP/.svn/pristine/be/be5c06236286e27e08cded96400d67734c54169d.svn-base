package mobi.neuerung.MADP;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.Util.Util;
import mobi.neuerung.Util.UtilMail;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ScreenWrapper;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class GoogleMapActivity extends FragmentActivity
{
	public FrameLayout LLTopGoogle ,LLMiddleGoogle,LLBottomGoogle;
	static final LatLng HAMBURG = new LatLng(26.9200, 75.8200);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	private GoogleMap map;
	WindowManager mWinMgr;
	public int deviceHeight,deviceWidth;
	public Util _objUtil = new Util();


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.google_map);


		WindowManager mWinMgr = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();


		LLTopGoogle  = (FrameLayout)findViewById(R.id.LLTopGoogle );
		LLMiddleGoogle = (FrameLayout)findViewById(R.id.LLMiddleGoogle);
		LLBottomGoogle = (FrameLayout)findViewById(R.id.LLBottomGoogle);

		try {
			Intent intent = getIntent();
			String ScreenNumber = intent.getStringExtra("GoogleScreenName");

			Toast.makeText(this, ScreenNumber, Toast.LENGTH_SHORT).show();


			ScreenWrapper objScreenWrapper = _objUtil.getScreenWrapperFromDB(ScreenNumber);
			ScreenPartWrapper objScreenPartWrapper = _objUtil.getScreenPartWrapper(ScreenNumber);


			//  **** For Top Bar Only ***
			if(objScreenPartWrapper.TopType.equals("0"))
			{
				UniversalTopBar(objScreenPartWrapper,"Top" ,this);
			}
			else if(objScreenPartWrapper.MidType.equals("0"))
			{
				UniversalTopBar(objScreenPartWrapper,"Middle" ,this);
			}
			else if(objScreenPartWrapper.BottomType.equals("0"))
			{
				UniversalTopBar(objScreenPartWrapper,"Bottom" ,this);
			}

			//***** For Google Map Bar only **
			if(objScreenPartWrapper.TopType.equals("GoogleMap"))
			{
				GoogleMapView(objScreenPartWrapper,"Top" ,this);
			}
			else if(objScreenPartWrapper.MidType.equals("GoogleMap"))
			{
				GoogleMapView(objScreenPartWrapper,"Middle" ,this);
			}
			else if(objScreenPartWrapper.BottomType.equals("GoogleMap"))
			{
				GoogleMapView(objScreenPartWrapper,"Bottom" ,this);
			}


			//***** For AdvertiseMent Bar only **
			if(objScreenPartWrapper.TopType.equals("4"))
			{
				UniversalAdvertisementBar(objScreenPartWrapper,"Top" ,this);
			}
			else if(objScreenPartWrapper.MidType.equals("4"))
			{
				UniversalAdvertisementBar(objScreenPartWrapper,"Middle" ,this);
			}
			else if(objScreenPartWrapper.BottomType.equals("4"))
			{
				UniversalAdvertisementBar(objScreenPartWrapper,"Bottom" ,this);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		map = ((SupportMapFragment) this.getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
				.title("Hamburg"));
		Marker kiel = map.addMarker(new MarkerOptions()
		.position(KIEL)
		.title("Kiel")
		.snippet("Kiel is cool")
		.icon(BitmapDescriptorFactory
				.fromResource(R.drawable.ic_launcher)));
		//		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		map.getUiSettings().setCompassEnabled(true);
		map.getUiSettings().setZoomControlsEnabled(true);
		// Move the camera instantly to hamburg with a zoom of 15.
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));

		// Zoom in, animating the camera.
		//	    map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
	}
	public void UniversalTopBar(ScreenPartWrapper _objScreenPartWrapper, String Section,final Context context)
	{

		final ElementWrapper _objEW = _objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		int i = _objEW.leftClick.length();
		System.out.println(""+i);



		final Button LeftBtn = new Button(context);
		final Button RightBtn = new Button(context);

		if(Section.equals("Top"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.TopWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.TopHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLTopGoogle =  LLTopGoogle.getLayoutParams();
			params_LLTopGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLTopGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLTopGoogle.setLayoutParams(params_LLTopGoogle);

			try
			{
				if(_objEW.Bitmap.length()>0)
				{
					String topbarfilePath="images/"+_objEW.Bitmap+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache( LLTopGoogle, context,topbarfilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));
				}
				TextView Heading= new TextView(context);
				Heading.setMaxLines(2);

				Heading.setText(_objEW.Title);
				Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopGooglePer*deviceHeight)));
				Heading.setGravity(Gravity.CENTER);
				LLTopGoogle.addView(Heading);

				ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
				params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
						FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
				params_Heading.width=(int)(.65f*deviceWidth);
				Heading.setLayoutParams(params_Heading);

				if(_objScreenPartWrapper.TopbgImage.length()>0)
				{
					String TopbgImagefilePath="images/"+_objScreenPartWrapper.TopbgImage+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache( LLTopGoogle, context,TopbgImagefilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));
				}
				else if(_objScreenPartWrapper.Topbgcolor.length()>0)
				{
					LLTopGoogle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
				}

				if(_objEW.left.length()>0)
				{

					LLTopGoogle.addView(LeftBtn);
					LeftBtn.setGravity(Gravity.LEFT);

					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					int lftbtnhgt=(int)(heightLLTopGooglePer*deviceHeight);
					params_LeftBtn.height=(int)(lftbtnhgt);
					params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
					LeftBtn.setLayoutParams(params_LeftBtn);


					String lftBtnfilePath="images/"+_objEW.left+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
				}
				if(_objEW.right.length()>0)
				{

					LLTopGoogle.addView(RightBtn);
					RightBtn.setGravity(Gravity.RIGHT);

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
					int lftbtnhgt=(int)(heightLLTopGooglePer*deviceHeight);
					params_RightBtn.height=(int)(lftbtnhgt);
					params_RightBtn.width=(int)(1.0f*lftbtnhgt);
					RightBtn.setLayoutParams(params_RightBtn);


					String rghtBtnfilePath="images/"+_objEW.right+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
				}
			}
			catch (Exception e) 
			{
				System.out.println("Exception in Setting home Page Top Bar"+e);
			}
		}
		else if(Section.equals("Middle"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.MidWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.MidHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLTopGoogle = LLMiddleGoogle.getLayoutParams();
			params_LLTopGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLTopGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLMiddleGoogle.setLayoutParams(params_LLTopGoogle);

			try
			{
				if(_objEW.Bitmap.length()>0)
				{
					String topbarfilePath="images/"+_objEW.Bitmap+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(LLMiddleGoogle, context,topbarfilePath,(float)(heightLLTopGooglePer*deviceHeight),(float)(widthLLTopGooglePer*deviceWidth));
				}
				TextView Heading= new TextView(context);
				Heading.setText(_objEW.Title);
				Heading.setGravity(Gravity.CENTER);
				Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(.092f*deviceHeight)));
				LLMiddleGoogle.addView(Heading);

				ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
				params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
						FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
				params_Heading.width=(int)(.65f*deviceWidth);
				Heading.setLayoutParams(params_Heading);

				if(_objScreenPartWrapper.MidbgImage.length()>0)
				{
					String MiddlebgImagefilePath="images/"+_objScreenPartWrapper.MidbgImage+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(LLMiddleGoogle, context,MiddlebgImagefilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));
				}
				else if(_objScreenPartWrapper.Midbgcolor.length()>0)
				{
					LLMiddleGoogle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
				}




				if(_objEW.left.length()>0)
				{
					LLMiddleGoogle.addView(LeftBtn);
					LeftBtn.setGravity(Gravity.LEFT|Gravity.TOP);

					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					int lftbtnhgt=(int)(heightLLTopGooglePer*deviceHeight);
					params_LeftBtn.height=(int)(lftbtnhgt);
					params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
					LeftBtn.setLayoutParams(params_LeftBtn);


					String lftBtnfilePath="images/"+_objEW.left+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
				}
				if(_objEW.right.length()>0)
				{
					LLMiddleGoogle.addView(RightBtn);
					RightBtn.setGravity(Gravity.RIGHT|Gravity.TOP);

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
					int lftbtnhgt=(int)(heightLLTopGooglePer*deviceHeight);
					params_RightBtn.height=(int)(lftbtnhgt);
					params_RightBtn.width=(int)(1.0f*lftbtnhgt);
					RightBtn.setLayoutParams(params_RightBtn);


					String rghtBtnfilePath="images/"+_objEW.right+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
				}
			}
			catch (Exception e) 
			{
				System.out.println("Exception in Setting home Page Top Bar"+e);
			}
		}
		else if(Section.equals("Bottom"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLTopGoogle = LLBottomGoogle.getLayoutParams();
			params_LLTopGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLTopGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLBottomGoogle.setLayoutParams(params_LLTopGoogle);

			try
			{
				if(_objEW.Bitmap.length()>0)
				{
					String topbarfilePath="images/"+_objEW.Bitmap+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(LLBottomGoogle, context,topbarfilePath,(float)(heightLLTopGooglePer*deviceHeight),(float)(widthLLTopGooglePer*deviceWidth));
				}

				TextView Heading= new TextView(context);
				Heading.setText(_objEW.Title);
				Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(.092f*deviceHeight)));
				Heading.setGravity(Gravity.CENTER);
				LLBottomGoogle.addView(Heading);

				ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
				params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
						FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
				params_Heading.width=(int)(.65f*deviceWidth);
				Heading.setLayoutParams(params_Heading);

				if(_objScreenPartWrapper.BottombgImage.length()>0)
				{
					String BottombgImagefilePath="images/"+_objScreenPartWrapper.BottombgImage+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(LLBottomGoogle, context,BottombgImagefilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));
				}
				else if(_objScreenPartWrapper.Bottombgcolor.length()>0)
				{
					LLBottomGoogle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
				}


				if(_objEW.left.length()>0)
				{
					LLBottomGoogle.addView(LeftBtn);
					LeftBtn.setGravity(Gravity.LEFT);

					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					int lftbtnhgt=(int)(heightLLTopGooglePer*deviceHeight);
					params_LeftBtn.height=(int)(lftbtnhgt);
					params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
					LeftBtn.setLayoutParams(params_LeftBtn);


					String lftBtnfilePath="images/"+_objEW.left+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
				}
				if(_objEW.right.length()>0)
				{
					LLBottomGoogle.addView(RightBtn);
					RightBtn.setGravity(Gravity.RIGHT);

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
					int lftbtnhgt=(int)(heightLLTopGooglePer*deviceHeight);
					params_RightBtn.height=(int)(lftbtnhgt);
					params_RightBtn.width=(int)(1.0f*lftbtnhgt);
					RightBtn.setLayoutParams(params_RightBtn);


					String rghtBtnfilePath="images/"+_objEW.right+".png";
					ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
				}
			}
			catch (Exception e) 
			{
				System.out.println("Exception in Setting home Page Top Bar"+e);
			}
		}
		if(_objEW.leftClick.length()>12)
		{

			LeftBtn.setOnTouchListener(new OnTouchListener() {


				public boolean onTouch(View v, MotionEvent event) {

					switch(event.getAction()) {

					case MotionEvent.ACTION_DOWN:
						LeftBtn.getBackground().setAlpha(150);
						//							return false;
						return true;
					case MotionEvent.ACTION_UP:
						LeftBtn.getBackground().setAlpha(255);

						if(_objEW.leftClick.substring(12).equals("1"))
						{
							try {
								String mailto=_objEW.mailto;
								String body=_objEW.body;
								String subject=_objEW.subject;
								String cc=_objEW.cc;
								String bcc=_objEW.bcc;

								UtilMail mail = new UtilMail();
								mail.OpenMail(context ,mailto,cc,bcc,body,subject);

							} catch (Exception e) {
								// TODO: handle exception
							}


						}
						else
						{

							MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
							System.out.println("State Machine"+MyUIApplication.StateMachine);
							if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
							{
//								((Home)context).DesignHomeScreen();
								((Home)context).OpenHtmlPage("0", "");

							}
							else if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("1"))
							{
								try {
									String mailto=_objEW.mailto;
									String body=_objEW.body;
									String subject=_objEW.subject;
									String cc=_objEW.cc;
									String bcc=_objEW.bcc;

									UtilMail mail = new UtilMail();
									mail.OpenMail(context ,mailto,cc,bcc,body,subject);

								} catch (Exception e) {
									// TODO: handle exception
								}


							}
							else
							{
								String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);


								if(LastScreen.equals("112"))
								{
									MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
								}
								else if(LastScreen.equals("113"))
								{
									MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
								}
								else if(LastScreen.equals("114"))
								{
									MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
								}

								((Home)context).OpenHtmlPage(LastScreen,"");



							}
						}
						break;
					case MotionEvent.ACTION_CANCEL:
						LeftBtn.getBackground().setAlpha(255);
						//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
						break;
					}

					return false;
				}

			});
		}

		if(_objEW.rightClick.length()>0)
		{
			RightBtn.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {


					String screenNumber=_objEW.rightClick.substring(12);

					//					Toast.makeText(context, _objEW.rightClick+"Right" +"    "+screenNumber, Toast.LENGTH_SHORT).show();

					//					MyUIApplication.StateMachine.add(screenNumber);

					int i=MyUIApplication.StateMachine.size();
					System.out.println("State Machine Size >>>"+i);
					//					if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
					//					{
					((Home)context).OpenHtmlPage(screenNumber,"");
					//					}
				}
			});

			RightBtn.setOnTouchListener(new OnTouchListener() {


				public boolean onTouch(View v, MotionEvent event) {

					switch(event.getAction()) {

					case MotionEvent.ACTION_DOWN:
						RightBtn.getBackground().setAlpha(150);
						//							return false;
						break;
					case MotionEvent.ACTION_UP:
						RightBtn.getBackground().setAlpha(255);
						//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
						break;
					}

					return false;
				}

			});
		}
	}
	public void GoogleMapView(final ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{
		ElementWrapper _objEW = _objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		if(Section.equals("Top"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.TopWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.TopHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLMiddleGoogle = LLTopGoogle.getLayoutParams();
			params_LLMiddleGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLMiddleGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLTopGoogle.setLayoutParams(params_LLMiddleGoogle);

		}
		else if(Section.equals("Middle"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.MidWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.MidHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLMiddleGoogle = LLMiddleGoogle.getLayoutParams();
			params_LLMiddleGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLMiddleGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLMiddleGoogle.setLayoutParams(params_LLMiddleGoogle);


		}
		else if(Section.equals("Bottom"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLMiddleGoogle = LLBottomGoogle.getLayoutParams();
			params_LLMiddleGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLMiddleGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLBottomGoogle.setLayoutParams(params_LLMiddleGoogle);

		}

	}
	public void UniversalAdvertisementBar(final ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{

		ElementWrapper _objEW = _objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		if(Section.equals("Top"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.TopWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.TopHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLMiddleGoogle = LLTopGoogle.getLayoutParams();
			params_LLMiddleGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLMiddleGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLTopGoogle.setLayoutParams(params_LLMiddleGoogle);

			if(_objScreenPartWrapper.TopbgImage.length()>0)
			{
				String topbarfilePath="images/"+_objScreenPartWrapper.TopbgImage+".png";
				//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				//				LLTopGoogleCopy.setBackgroundDrawable(d);
				ImageUtil.setBackgroundBgFromAssetsNotCache(LLTopGoogle, context,topbarfilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));
			}
			else if(_objScreenPartWrapper.Topbgcolor.length()>0)
			{
				LLTopGoogle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
			}


			try
			{
				ImageView adv= new ImageView(context);
				LLTopGoogle.addView(adv);



				double heightadv=Double.parseDouble(_objEW.height);
				double widthadv=Double.parseDouble(_objEW.width);


				ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
				params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
						FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
				int advheight=(int)(heightadv*heightLLTopGooglePer);
				int h=(int)(advheight*deviceHeight);
				params_adv.height=(int)(h/100);
				params_adv.width=(int)(h*3.333f*.01f);
				adv.setLayoutParams(params_adv);



				String topbarfilePath="images/"+_objEW.Bitmap+".png";
				//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				//				LLMiddleGoogle.setBackgroundDrawable(d);
				ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));

			}
			catch (Exception e) 
			{
				System.out.println("Exception in Setting home Page Top Bar"+e);
			}
		}
		else if(Section.equals("Middle"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.MidWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.MidHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLMiddleGoogle = LLMiddleGoogle.getLayoutParams();
			params_LLMiddleGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLMiddleGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLMiddleGoogle.setLayoutParams(params_LLMiddleGoogle);

			if(_objScreenPartWrapper.MidbgImage.length()>0)
			{
				String topbarfilePath="images/"+_objScreenPartWrapper.MidbgImage+".png";
				//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				//				LLTopGoogleCopy.setBackgroundDrawable(d);
				ImageUtil.setBackgroundBgFromAssetsNotCache(LLMiddleGoogle, context,topbarfilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));
			}
			else if(_objScreenPartWrapper.Midbgcolor.length()>0)
			{
				LLMiddleGoogle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
			}

			try
			{
				ImageView adv= new ImageView(context);
				LLMiddleGoogle.addView(adv);



				double heightadv=Double.parseDouble(_objEW.height);
				double widthadv=Double.parseDouble(_objEW.width);


				ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
				params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
						FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
				int advheight=(int)(heightadv*heightLLTopGooglePer);
				int h=(int)(advheight*deviceHeight);
				params_adv.height=(int)(h/100);
				params_adv.width=(int)(h*3.333f*.01f);
				adv.setLayoutParams(params_adv);



				String topbarfilePath="images/"+_objEW.Bitmap+".png";
				//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				//				LLMiddleGoogle.setBackgroundDrawable(d);
				ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));

			}
			catch (Exception e) 
			{
				System.out.println("Exception in Setting home Page Top Bar"+e);
			}
		}
		else if(Section.equals("Bottom"))
		{
			double widthLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
			double heightLLTopGoogle=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
			double widthLLTopGooglePer=widthLLTopGoogle/100;
			double heightLLTopGooglePer=heightLLTopGoogle/100;

			ViewGroup.LayoutParams params_LLMiddleGoogle = LLBottomGoogle.getLayoutParams();
			params_LLMiddleGoogle.height=(int)(heightLLTopGooglePer*deviceHeight);
			params_LLMiddleGoogle.width=(int)(widthLLTopGooglePer*deviceWidth);
			LLBottomGoogle.setLayoutParams(params_LLMiddleGoogle);

			if(_objScreenPartWrapper.Bottombgcolor.length()>0)
			{
				String topbarfilePath="images/"+_objScreenPartWrapper.BottombgImage+".png";
				//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				//				LLTopGoogleCopy.setBackgroundDrawable(d);
				ImageUtil.setBackgroundBgFromAssetsNotCache(LLBottomGoogle, context,topbarfilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));
			}
			else if(_objScreenPartWrapper.Bottombgcolor.length()>0)
			{
				LLBottomGoogle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
			}


			try
			{
				ImageView adv= new ImageView(context);
				LLBottomGoogle.addView(adv);



				double heightadv=Double.parseDouble(_objEW.height);
				double widthadv=Double.parseDouble(_objEW.width);


				ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
				params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
						FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
				int advheight=(int)(heightadv*heightLLTopGooglePer);
				int h=(int)(advheight*deviceHeight);
				params_adv.height=(int)(h/100);
				params_adv.width=(int)(h*3.333f*.01f);
				adv.setLayoutParams(params_adv);



				String topbarfilePath="images/"+_objEW.Bitmap+".png";
				//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				//				LLMiddleGoogle.setBackgroundDrawable(d);
				ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopGooglePer*deviceHeight),(int)(widthLLTopGooglePer*deviceWidth));

			}
			catch (Exception e) 
			{
				System.out.println("Exception in Setting home Page Top Bar"+e);
			}
		}


		if(_objScreenPartWrapper.TopLink.length()>0)
		{
			LLTopGoogle.setOnClickListener( new OnClickListener()
			{
				public void onClick(View v)
				{
					String str=_objScreenPartWrapper.TopLink.trim();

					Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
					myWebLink.setData(Uri.parse(str));
					context.startActivity(myWebLink);
				}
			});
		}
		if(_objScreenPartWrapper.MidLink.length()>0)
		{
			LLMiddleGoogle.setOnClickListener( new OnClickListener()
			{
				public void onClick(View v)
				{
					String str=_objScreenPartWrapper.MidLink.trim();

					Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
					myWebLink.setData(Uri.parse(str));
					context.startActivity(myWebLink);
				}
			});
		}
		if(_objScreenPartWrapper.BottomLink.length()>0)
		{
			LLBottomGoogle.setOnClickListener( new OnClickListener()
			{
				public void onClick(View v)
				{
					String str=_objScreenPartWrapper.BottomLink.trim();

					Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
					myWebLink.setData(Uri.parse(str));
					context.startActivity(myWebLink);
				}
			});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//	    getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			try
			{
				this.finish();
//				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
			}


			catch(Exception ex)
			{
				System.out.println("Exception in onkeydown "+ex);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
