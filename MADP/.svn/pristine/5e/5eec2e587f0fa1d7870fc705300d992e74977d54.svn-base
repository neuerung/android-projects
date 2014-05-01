package mobi.neuerung.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import mobi.neuerung.BGThread.BGHTMLThread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;

import org.apache.http.util.ByteArrayBuffer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class UtilHtml {

	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	String ScreenNumber="";
	public static WebView WView;
	RelativeLayout mainll;
	Button changeTextSize;
	String pagecode;
	int i =0;
	String shareText="";
	//	private ProgressDialog dialog;
	// **** Set WebView in Html Pages *****
	public void SetHtmlPage(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String ScreenNumber)
	{


		final Button facebook_button = new Button(context);
		facebook_button.setBackgroundResource(R.drawable.share_white_icon);

		facebook_button.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == MotionEvent.ACTION_DOWN)
				{
					facebook_button.getBackground().setAlpha(100);
				}
				if(event.getAction() == MotionEvent.ACTION_UP)
				{
					facebook_button.getBackground().setAlpha(255);
				}
				if(event.getAction() == MotionEvent.ACTION_CANCEL)
				{
					facebook_button.getBackground().setAlpha(255);
				}
				return false;
			}
		});


		pagecode="";
		i=0;
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;
		this.ScreenNumber=ScreenNumber;

		final ElementWrapper objElementWrapper = new Util().getElementWrapperFromDB(ScreenNumber,Section);
		if(objElementWrapper.shareText !=null)
		{
			shareText = objElementWrapper.shareText;
		}
		pagecode = objElementWrapper.Code.trim();
		mainll = new RelativeLayout(context);
		mainll.setBackgroundColor(Color.WHITE);
		try {
			if(objElementWrapper.bgcolor.trim().length()>0)
			{
				mainll.setBackgroundColor(Color.parseColor(objElementWrapper.bgcolor));
			}
			else
			{
				mainll.setBackgroundColor(Color.WHITE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			mainll.setBackgroundColor(Color.WHITE);
		}

		if(MyUIApplication.Copy)
		{

			changeTextSize = new Button(context);
			changeTextSize.setBackgroundResource(R.drawable.changetextsize);

			changeTextSize.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(i<2)
						i++;
					else if(i==2)
						i=0;
					WView.reload();
				}
			});


			changeTextSize.setOnTouchListener(new OnTouchListener() {

				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					if(event.getAction() == MotionEvent.ACTION_DOWN)
					{
						changeTextSize.getBackground().setAlpha(100);
					}
					if(event.getAction() == MotionEvent.ACTION_UP)
					{
						changeTextSize.getBackground().setAlpha(255);
					}
					if(event.getAction() == MotionEvent.ACTION_CANCEL)
					{
						changeTextSize.getBackground().setAlpha(255);
					}
					return false;
				}
			});
			LinearLayout strip = new LinearLayout(context);
			WView= new WebView(context);

			try {
				if(objElementWrapper.bgcolor.trim().length()>0)
				{
					WView.setBackgroundColor(Color.parseColor(objElementWrapper.bgcolor));
				}
				else
				{
					WView.setBackgroundColor(Color.WHITE);
				}
			} catch (Exception e) {
				// TODO: handle exception
				WView.setBackgroundColor(Color.WHITE);
			}

			
			mainll.addView(WView);
			mainll.addView(strip);
			mainll.addView(facebook_button);
			mainll.addView(changeTextSize);
			try {
				strip.setBackgroundColor(Color.parseColor(objElementWrapper.TextTransColor));
			} catch (Exception e) {
				// TODO: handle exception
				strip.setBackgroundColor(Color.parseColor("#cacaca"));
			}

			strip.getBackground().setAlpha(100);


			changeTextSize.setId(01123);

			RelativeLayout.LayoutParams params_strip =(RelativeLayout.LayoutParams) strip.getLayoutParams();
			params_strip.width =(int)(((Home)context).deviceWidth);
			params_strip.height =(int)(.09f*((Home)context).deviceHeight);

			RelativeLayout.LayoutParams params_changeTextSize =(RelativeLayout.LayoutParams) changeTextSize.getLayoutParams();
			params_changeTextSize.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			params_changeTextSize.width =(int)(.05f*((Home)context).deviceHeight);
			params_changeTextSize.height =(int)(.05f*((Home)context).deviceHeight);
			params_changeTextSize.topMargin =(int)(.02f*((Home)context).deviceHeight);
			params_changeTextSize.rightMargin =(int)(.14f*((Home)context).deviceWidth);


			RelativeLayout.LayoutParams params_facebook_button =(RelativeLayout.LayoutParams) facebook_button.getLayoutParams();
			params_facebook_button.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,changeTextSize.getId());
			//			params_facebook_button.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			params_facebook_button.width =(int)(.05f*((Home)context).deviceHeight);
			params_facebook_button.height =(int)(.05f*((Home)context).deviceHeight);
			params_facebook_button.topMargin =(int)(.02f*((Home)context).deviceHeight);
			params_facebook_button.rightMargin =(int)(.04f*((Home)context).deviceWidth);


			try {


				if(objElementWrapper.shareVisiblity.equals("false") && objElementWrapper.textChangeSizeVisiblity.equals("false"))
				{
					strip.setVisibility(View.GONE);
					facebook_button.setVisibility(View.GONE);
					changeTextSize.setVisibility(View.GONE);
				}
				else if(objElementWrapper.shareVisiblity.equals("false"))
				{
					strip.setVisibility(View.VISIBLE);
					changeTextSize.setVisibility(View.VISIBLE);
					facebook_button.setVisibility(View.GONE);

					try {
						RelativeLayout.LayoutParams params_changeTextSize1 =(RelativeLayout.LayoutParams) changeTextSize.getLayoutParams();
						params_changeTextSize1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
						params_changeTextSize1.width =(int)(.05f*((Home)context).deviceHeight);
						params_changeTextSize1.height =(int)(.05f*((Home)context).deviceHeight);
						params_changeTextSize1.topMargin =(int)(.02f*((Home)context).deviceHeight);
						params_changeTextSize1.rightMargin =(int)(.04f*((Home)context).deviceWidth);

					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if( objElementWrapper.textChangeSizeVisiblity.equals("false"))
				{
					strip.setVisibility(View.VISIBLE);
					facebook_button.setVisibility(View.VISIBLE);
					changeTextSize.setVisibility(View.GONE);
				}
				else
				{
					strip.setVisibility(View.VISIBLE);
					facebook_button.setVisibility(View.VISIBLE);
					changeTextSize.setVisibility(View.VISIBLE);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			WView.getSettings().setJavaScriptEnabled(true);

			WView.setWebViewClient(new WebViewClient() {
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					if(url.startsWith("tel:"))
					{
						makeACall(url, context);
					}
					if(url.startsWith("mail"))
					{

						String body="Please shoot a mail.";
						Intent i = new Intent(android.content.Intent.ACTION_SEND);
						i.setType("text/plain");
						url = url.replace("mailto:", "");
						i.putExtra(Intent.EXTRA_EMAIL  , new String[]{url});
						i.putExtra(Intent.EXTRA_SUBJECT, "subject");
						i.putExtra(Intent.EXTRA_TEXT   , body);
						((Home)context).startActivity(Intent.createChooser(i, "Email:"));
					}
					if(url.startsWith("http"))
					{
						Toast.makeText(context, url, Toast.LENGTH_LONG).show();
						try {
							Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
							((Home)context).startActivity(browserIntent);
						} catch (Exception e) {
							// TODO: handle exception
						}


						if(objElementWrapper.OnClick.length()>12)
						{

							String screen = objElementWrapper.OnClick.substring(12);

							if(MyUIApplication.ScreenNumbers.contains(screen))
							{

								if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
								{
									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								}
								if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
								{
									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								}


								if(screen.equals("112"))
								{
									MyUIApplication.StateMachine.add("112");
									((Home)context).OpenHtmlPage("112", url);

								}
								else if(screen.equals("113"))
								{
									MyUIApplication.StateMachine.add("113");
									((Home)context).OpenHtmlPage("113", url);

								}
								else if(screen.equals("114"))
								{
									MyUIApplication.StateMachine.add("114");
									((Home)context).OpenHtmlPage("114", url);

								}
							}
						}
					}

					if(url.startsWith("img"))
					{
						url = url.replace("img:", "");
						//						Toast.makeText(context, url, Toast.LENGTH_LONG).show();

						if(objElementWrapper.OnClick.length()>12)
						{

							String screen = objElementWrapper.OnClick.substring(12);

							if(MyUIApplication.ScreenNumbers.contains(screen))
							{

								if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
								{
									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								}
								if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
								{
									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								}


								if(screen.equals("112"))
								{
									MyUIApplication.StateMachine.add("112");
									((Home)context).OpenHtmlPage("112", url);

								}
								else if(screen.equals("113"))
								{
									MyUIApplication.StateMachine.add("113");
									((Home)context).OpenHtmlPage("113", url);

								}
								else if(screen.equals("114"))
								{
									MyUIApplication.StateMachine.add("114");
									((Home)context).OpenHtmlPage("114", ((Home)context)._objUtilTopBar.Heading.getText().toString()+"###"+url);
									MyUIApplication.HTMLImageUrl = url;
								}
								else
								{
									MyUIApplication.StateMachine.add(screen);
									((Home)context).OpenHtmlPage(screen, url);
								}
							}
							else
							{
								try {
									Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
									((Home)context).startActivity(browserIntent);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}

						}
						else
						{
							try {
								Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
								((Home)context).startActivity(browserIntent);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}

					}

					return true;
				}

				public void onPageFinished(WebView view, String url) {

					super.onPageFinished(view, url);

					settextsize(view);
					
					Log.e("HTML", "Calling java script funtion with device id "+MyUIApplication.pref.getDeviceId());
					view.loadUrl("javascript:getDeviceID('"+MyUIApplication.pref.getDeviceId()+"')");
					view.loadUrl("javascript:getOSCode('OS002')");

				}
				public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

				}
			});


			try
			{


				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(mainll);

					try
					{
						if(_objScreenPartWrapper.TopType.trim().equals("Floor Plan"))
						{
							InputStream is = context.getAssets().open("Html/"+"FloorPlan"+".html");
							if(is!=null)
							{
								WebSettings webSettingsMap = WView.getSettings();
								webSettingsMap.setJavaScriptEnabled(true);
								webSettingsMap.setDefaultZoom(WebSettings.ZoomDensity.FAR);
								webSettingsMap.setBuiltInZoomControls(true);

							}
						}
						else
						{
							WebSettings webSettingsMap = WView.getSettings();
							webSettingsMap.setJavaScriptEnabled(true);
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}
					ViewGroup.LayoutParams params_WView = mainll.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainll.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(mainll);

					try
					{
						if(_objScreenPartWrapper.MidType.trim().equals("Floor Plan"))
						{
							InputStream is = context.getAssets().open("Html/"+"FloorPlan"+".html");
							if(is!=null)
							{
								WebSettings webSettingsMap = WView.getSettings();
								webSettingsMap.setJavaScriptEnabled(true);
								webSettingsMap.setDefaultZoom(WebSettings.ZoomDensity.FAR);
								webSettingsMap.setBuiltInZoomControls(true);

							}
						}
						else
						{
							//							String PageName = objElementWrapper.Title;
							//							File sdHTML= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/HtmlPages/"
							//									+PageName+".html");
							//
							//							if(sdHTML.exists()==true) 
							//							{
							//								WView.loadUrl("file://"+Environment.getExternalStorageDirectory()+
							//										"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/HtmlPages/"+PageName+".html");
							//							}
							//
							//
							//							WebSettings webSettingsMap = WView.getSettings();
							//							webSettingsMap.setJavaScriptEnabled(true);
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}

					ViewGroup.LayoutParams params_WView = mainll.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainll.setLayoutParams(params_WView);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(mainll);

					ViewGroup.LayoutParams params_WView = mainll.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainll.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);



					try
					{
						if(_objScreenPartWrapper.BottomType.trim().equals("Floor Plan"))
						{
							InputStream is = context.getAssets().open("Html/"+"FloorPlan"+".html");
							if(is!=null)
							{
								WebSettings webSettingsMap = WView.getSettings();
								webSettingsMap.setJavaScriptEnabled(true);
								webSettingsMap.setDefaultZoom(WebSettings.ZoomDensity.FAR);
								webSettingsMap.setBuiltInZoomControls(true);

							}
						}
						else
						{
							WebSettings webSettingsMap = WView.getSettings();
							webSettingsMap.setJavaScriptEnabled(true);
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

			//			new BGHTMLThread(context, objElementWrapper.Title.replace(" ", "") , objElementWrapper.Code).execute();
		}
		else if(!MyUIApplication.Copy)
		{

			//			mainll.setBackgroundColor(Color.WHITE);
			changeTextSize = new Button(context);
			changeTextSize.setBackgroundResource(R.drawable.changetextsize);

			changeTextSize.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub

					if(i<2)
						i++;
					else if(i==2)
						i=0;
					WView.reload();

				}
			});

			changeTextSize.setOnTouchListener(new OnTouchListener() {

				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					if(event.getAction() == MotionEvent.ACTION_DOWN)
					{
						changeTextSize.getBackground().setAlpha(100);
					}
					if(event.getAction() == MotionEvent.ACTION_UP)
					{
						changeTextSize.getBackground().setAlpha(255);
					}
					if(event.getAction() == MotionEvent.ACTION_CANCEL)
					{
						changeTextSize.getBackground().setAlpha(255);
					}
					return false;
				}
			});

			LinearLayout strip = new LinearLayout(context);
			WView= new WebView(context);
			
			try {
				if(objElementWrapper.bgcolor.trim().length()>0)
				{
					WView.setBackgroundColor(Color.parseColor(objElementWrapper.bgcolor));
				}
				else
				{
					WView.setBackgroundColor(Color.WHITE);
				}
			} catch (Exception e) {
				// TODO: handle exception
				WView.setBackgroundColor(Color.WHITE);
			}

			mainll.addView(WView);
			mainll.addView(strip);

			mainll.addView(facebook_button);

			mainll.addView(changeTextSize);
			try {
				strip.setBackgroundColor(Color.parseColor(objElementWrapper.TextTransColor));
			} catch (Exception e) {
				// TODO: handle exception
				strip.setBackgroundColor(Color.parseColor("#cacaca"));
			}

			strip.getBackground().setAlpha(100);
			changeTextSize.setId(01123);

			RelativeLayout.LayoutParams params_strip =(RelativeLayout.LayoutParams) strip.getLayoutParams();
			params_strip.width =(int)(((Home)context).deviceWidth);
			params_strip.height =(int)(.09f*((Home)context).deviceHeight);

			RelativeLayout.LayoutParams params_changeTextSize =(RelativeLayout.LayoutParams) changeTextSize.getLayoutParams();
			params_changeTextSize.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			params_changeTextSize.width =(int)(.05f*((Home)context).deviceHeight);
			params_changeTextSize.height =(int)(.05f*((Home)context).deviceHeight);
			params_changeTextSize.topMargin =(int)(.02f*((Home)context).deviceHeight);
			params_changeTextSize.rightMargin =(int)(.14f*((Home)context).deviceWidth);

			RelativeLayout.LayoutParams params_facebook_button =(RelativeLayout.LayoutParams) facebook_button.getLayoutParams();
			params_facebook_button.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,changeTextSize.getId());
			//			params_facebook_button.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			params_facebook_button.width =(int)(.05f*((Home)context).deviceHeight);
			params_facebook_button.height =(int)(.05f*((Home)context).deviceHeight);
			params_facebook_button.topMargin =(int)(.02f*((Home)context).deviceHeight);
			params_facebook_button.rightMargin =(int)(.04f*((Home)context).deviceWidth);

			

			try {


				if(objElementWrapper.shareVisiblity.equals("false") && objElementWrapper.textChangeSizeVisiblity.equals("false"))
				{
					strip.setVisibility(View.GONE);
					facebook_button.setVisibility(View.GONE);
					changeTextSize.setVisibility(View.GONE);
				}
				else if(objElementWrapper.shareVisiblity.equals("false"))
				{
					facebook_button.setVisibility(View.GONE);
					strip.setVisibility(View.VISIBLE);
					changeTextSize.setVisibility(View.VISIBLE);
					
					RelativeLayout.LayoutParams params_changeTextSize1 =(RelativeLayout.LayoutParams) changeTextSize.getLayoutParams();
					params_changeTextSize1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
					params_changeTextSize1.width =(int)(.05f*((Home)context).deviceHeight);
					params_changeTextSize1.height =(int)(.05f*((Home)context).deviceHeight);
					params_changeTextSize1.topMargin =(int)(.02f*((Home)context).deviceHeight);
					params_changeTextSize1.rightMargin =(int)(.04f*((Home)context).deviceWidth);

				}
				else if( objElementWrapper.textChangeSizeVisiblity.equals("false"))
				{

					facebook_button.setVisibility(View.VISIBLE);
					strip.setVisibility(View.VISIBLE);
					changeTextSize.setVisibility(View.GONE);
				}
				else
				{
					strip.setVisibility(View.VISIBLE);
					facebook_button.setVisibility(View.VISIBLE);
					changeTextSize.setVisibility(View.VISIBLE);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			
			
			WView.getSettings().setJavaScriptEnabled(true);

			//			dialog = new ProgressDialog(context);
			//			this.dialog.setMessage("Please Wait ..");
			//			this.dialog.show();
			//			this.dialog.setCancelable(false);

			WView.setWebViewClient(new WebViewClient() {
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					if(url.startsWith("tel:"))
					{
						makeACall(url, context);
					}
					if(url.startsWith("mail"))
					{
						String body="Please shoot a mail.";
						Intent i = new Intent(android.content.Intent.ACTION_SEND);
						i.setType("text/plain");
						url = url.replace("mailto:", "");
						i.putExtra(Intent.EXTRA_EMAIL  , new String[]{url});
						i.putExtra(Intent.EXTRA_SUBJECT, "subject");
						i.putExtra(Intent.EXTRA_TEXT   , body);
						context.startActivity(Intent.createChooser(i, "Email:"));
					}
					if(url.startsWith("http"))
					{
						Toast.makeText(context, url, Toast.LENGTH_SHORT).show();
						try {
							Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
							context.startActivity(browserIntent);
						} catch (Exception e) {
							// TODO: handle exception
						}


						if(objElementWrapper.OnClick.length()>12)
						{
							String screen = objElementWrapper.OnClick.substring(12);
							if(MyUIApplication.ScreenNumbers.contains(screen))
							{
								if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
								{
									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								}
								if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
								{
									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								}

								if(screen.equals("112"))
								{
									MyUIApplication.StateMachine.add("112");
									((Home)context).OpenHtmlPage("112", url);

								}
								else if(screen.equals("113"))
								{
									MyUIApplication.StateMachine.add("113");
									((Home)context).OpenHtmlPage("113", url);

								}
								else if(screen.equals("114"))
								{
									MyUIApplication.StateMachine.add("114");
									((Home)context).OpenHtmlPage("114", url);

								}
							}
						}
					}


					if(url.startsWith("img"))
					{
						url = url.replace("img:", "");
						//						Toast.makeText(context, url, Toast.LENGTH_LONG).show();
						//						try {
						//							Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
						//							((Home)context).startActivity(browserIntent);
						//						} catch (Exception e) {
						//							// TODO: handle exception
						//						}


						if(objElementWrapper.OnClick.length()>12)
						{

							String screen = objElementWrapper.OnClick.substring(12);

							if(MyUIApplication.ScreenNumbers.contains(screen))
							{

								if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
								{
									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								}
								if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
								{
									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								}


								if(screen.equals("112"))
								{
									MyUIApplication.StateMachine.add("112");
									((Home)context).OpenHtmlPage("112", url);

								}
								else if(screen.equals("113"))
								{
									MyUIApplication.StateMachine.add("113");
									((Home)context).OpenHtmlPage("113", url);

								}
								else if(screen.equals("114"))
								{
									MyUIApplication.StateMachine.add("114");
									((Home)context).OpenHtmlPage("114",  ((Home)context)._objUtilTopBar.Heading.getText().toString()+"###"+url);
									MyUIApplication.HTMLImageUrl = url;
								}
								else
								{
									MyUIApplication.StateMachine.add(screen);
									((Home)context).OpenHtmlPage(screen, url);
								}
							}
							else
							{
								try {
									Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
									((Home)context).startActivity(browserIntent);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
						}
						else
						{
							try {
								Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
								((Home)context).startActivity(browserIntent);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}

					}

					return true;
				}

				@Override
				public void onPageFinished(WebView view, String url) {
					// TODO Auto-generated method stub
					super.onPageFinished(view, url);

					settextsize(view);
					
					Log.e("HTML", "Calling java script funtion with device id "+MyUIApplication.pref.getDeviceId());
					view.loadUrl("javascript:getDeviceID('"+MyUIApplication.pref.getDeviceId()+"')");
					view.loadUrl("javascript:getOSCode('OS002')");

				}
				public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

				}
			});

			try
			{


				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(mainll);

					try
					{
						if(_objScreenPartWrapper.TopType.trim().equals("Floor Plan"))
						{
							InputStream is = context.getAssets().open("Html/"+"FloorPlan"+".html");
							if(is!=null)
							{
								WebSettings webSettingsMap = WView.getSettings();
								webSettingsMap.setJavaScriptEnabled(true);
								webSettingsMap.setDefaultZoom(WebSettings.ZoomDensity.FAR);
								webSettingsMap.setBuiltInZoomControls(true);

							}
						}
						else
						{
							WebSettings webSettingsMap = WView.getSettings();
							webSettingsMap.setJavaScriptEnabled(true);
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}
					ViewGroup.LayoutParams params_WView = mainll.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainll.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(mainll);

					try
					{
						if(_objScreenPartWrapper.MidType.trim().equals("Floor Plan"))
						{
							InputStream is = context.getAssets().open("Html/"+"FloorPlan"+".html");
							if(is!=null)
							{
								WebSettings webSettingsMap = WView.getSettings();
								webSettingsMap.setJavaScriptEnabled(true);
								webSettingsMap.setDefaultZoom(WebSettings.ZoomDensity.FAR);
								webSettingsMap.setBuiltInZoomControls(true);

							}
						}
						else
						{


						}
					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}

					ViewGroup.LayoutParams params_WView = mainll.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainll.setLayoutParams(params_WView);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);
				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(mainll);

					ViewGroup.LayoutParams params_WView = mainll.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainll.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);



					try
					{
						if(_objScreenPartWrapper.BottomType.trim().equals("Floor Plan"))
						{
							InputStream is = context.getAssets().open("Html/"+"FloorPlan"+".html");
							if(is!=null)
							{
								WebSettings webSettingsMap = WView.getSettings();
								webSettingsMap.setJavaScriptEnabled(true);
								webSettingsMap.setDefaultZoom(WebSettings.ZoomDensity.FAR);
								webSettingsMap.setBuiltInZoomControls(true);

							}
						}
						else
						{
							WebSettings webSettingsMap = WView.getSettings();
							webSettingsMap.setJavaScriptEnabled(true);
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}


		String PageName = objElementWrapper.Title;
		String PageCode = objElementWrapper.Code.trim();
		File sdHTML= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/HtmlPages/"
				+PageCode+".html");

		if(sdHTML.exists()) 
		{
			WView.loadUrl("file://"+Environment.getExternalStorageDirectory()+
					"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/HtmlPages/"+PageCode+".html");
			new BGHTMLThread(context, objElementWrapper.Title.replace(" ", "") , PageCode,"refresh").execute();

		}
		else
		{
			new BGHTMLThread(context, objElementWrapper.Title.replace(" ", "") , PageCode,"New").execute();
		}

		WebSettings webSettingsMap = WView.getSettings();
		webSettingsMap.setJavaScriptEnabled(true);
	}
	/**
	 * Listens Response from Library
	 * 
	 */



	public void DownloadFromUrl(String DownloadUrl, String fileName) {

		try {
			File sd= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/HtmlPages/");              

			if(sd.exists()==false) {
				sd.mkdirs();
			}

			URL url = new URL(DownloadUrl); //you can write here any link
			File file = new File(sd, fileName);

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



		} catch (IOException e) {
			Log.d("DownloadManager", "Error: " + e);
		}
	}

	public void callOnPost(String PageName, Context context)
	{

		if(MyUIApplication.HTMLScreenFilePath.length()>0 && MyUIApplication.HTMLScreenFileName.length()>0)
		{
			new BGHTMLThread(context, "DownloadHtmlPage","","New").execute();
		}
		else
		{
			SetHtmlPageMethod(PageName, context);
		}
	}

	public void  SetHtmlPageMethod(String PageName, Context context)
	{

		File sd= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/HtmlPages/");              

		if(sd.exists()==true) 
		{
			try
			{
				if(PageName.equals("FloorPlan"))
				{
					WebSettings webSettingsMap = WView.getSettings();
					webSettingsMap.setJavaScriptEnabled(true);
					webSettingsMap.setDefaultZoom(WebSettings.ZoomDensity.FAR);
					webSettingsMap.setBuiltInZoomControls(true);
				}
				else
				{
					WebSettings webSettingsMap = WView.getSettings();
					webSettingsMap.setJavaScriptEnabled(true);
				}



				File sdHTML= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/HtmlPages/"
						+pagecode+".html");

				if(sdHTML.exists()==true) 
				{
					WView.loadUrl("file://"+Environment.getExternalStorageDirectory()+
							"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/HtmlPages/"+pagecode+".html");
				}
				else if(((Home)context).getAssets().open("Html/"+PageName+".html")!=null)
				{
					WView.loadUrl("file:///android_asset/Html/"+pagecode+".html");
				}


			}
			catch (Exception e) {
				// TODO: handle exception
				//				WView.loadUrl("file:///android_asset/Html/FloorPlan.html");
				System.out.println("Error in HTML page Set"+PageName+"     "+e);
				e.printStackTrace();
				Toast.makeText(context, "Data Missing for this page", Toast.LENGTH_SHORT).show();

			}
		}
		else
		{

			//			WView.loadUrl("file:///android_asset/Html/"+"FloorPlan"+".html");
		}
	}
	public  void makeACall(String number,Context context)
	{
		TelephonyManager tm= (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		if(tm.getPhoneType()==TelephonyManager.PHONE_TYPE_NONE)
		{
			Toast.makeText(context, "No Network found",Toast.LENGTH_SHORT).show();
		}
		else
		{
			Intent intent = new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:" + number));
			context.startActivity(intent);
		}
	}

	private void settextsize(WebView view)
	{
		if(i==0)
		{
			if(((Home)context).deviceWidth == 320 && ((Home)context).deviceHeight == 480)
			{
			}
			else if(((Home)context).deviceWidth == 480 &&((Home)context).deviceHeight== 800)
			{
			}
			else
			{
				if(((Home)context).deviceHeight>800)
				{
					float device_height25_per=(.022f)*(float)(((Home)context).deviceHeight);
					float device_height14_per=(.015f)*(float)(((Home)context).deviceHeight);

					//							String msgToSend ="iijs";
					//							WView.loadUrl("javascript:getValue((\""+msgToSend+"\"))");
					//							view.loadUrl("javascript:setFontSize((\""+device_height25_per+","+device_height14_per+","+device_height14_per+"\"))");
					StringBuilder buf=new StringBuilder("javascript:setFontSize(");

					buf.append(String.valueOf(device_height25_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(")");
					view.loadUrl(buf.toString());
					//							WView.loadUrl("javascript:setBodyFontSize((\""+device_height14_per+"\"))");
					//							WView.loadUrl("javascript:contentFontSize((\""+device_height14_per+"\"))");
					//							WView.loadUrl("javascript:subHeadingFontSize((\""+device_height17_per+"\"))");
				}
				else
				{
					float device_height25_per=(.035f)*(float)(((Home)context).deviceHeight);
					float device_height14_per=(.025f)*(float)(((Home)context).deviceHeight);
					//							view.loadUrl("javascript:contentFontSize((\""+device_height14_per+"\"))");
					//							String msgToSend ="iijs";
					//							WView.loadUrl("javascript:getValue((\""+msgToSend+"\"))");
					StringBuilder buf=new StringBuilder("javascript:setFontSize(");

					buf.append(String.valueOf(device_height25_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(")");
					view.loadUrl(buf.toString());
					//							view.loadUrl("javascript:setFontSize((\""+device_height25_per+","+device_height14_per+","+device_height14_per+"\"))");
					//							WView.loadUrl("javascript:setBodyFontSize((\""+device_height14_per+"\"))");
					//							WView.loadUrl("javascript:contentFontSize((\""+device_height14_per+"\"))");
					//							WView.loadUrl("javascript:subHeadingFontSize((\""+device_height17_per+"\"))");
				}

			}	
		}
		else if(i==1)
		{
			if(((Home)context).deviceWidth == 320 && ((Home)context).deviceHeight == 480)
			{
				float device_height25_per=(.022f)*(float)(((Home)context).deviceHeight);
				float device_height14_per=(.015f)*(float)(((Home)context).deviceHeight);
				StringBuilder buf=new StringBuilder("javascript:setFontSize(");
				buf.append(String.valueOf(device_height25_per));
				buf.append(",");
				buf.append(String.valueOf(device_height14_per));
				buf.append(",");
				buf.append(String.valueOf(device_height14_per));
				buf.append(")");
				view.loadUrl(buf.toString());
			}
			else if(((Home)context).deviceWidth == 480 &&((Home)context).deviceHeight== 800)
			{
				float device_height25_per=(.022f)*(float)(((Home)context).deviceHeight);
				float device_height14_per=(.015f)*(float)(((Home)context).deviceHeight);
				StringBuilder buf=new StringBuilder("javascript:setFontSize(");
				buf.append(String.valueOf(device_height25_per));
				buf.append(",");
				buf.append(String.valueOf(device_height14_per));
				buf.append(",");
				buf.append(String.valueOf(device_height14_per));
				buf.append(")");
				view.loadUrl(buf.toString());
			}
			else
			{
				if(((Home)context).deviceHeight>800)
				{
					float device_height25_per=(.035f)*(float)(((Home)context).deviceHeight);
					float device_height14_per=(.025f)*(float)(((Home)context).deviceHeight);
					StringBuilder buf=new StringBuilder("javascript:setFontSize(");
					buf.append(String.valueOf(device_height25_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(")");
					view.loadUrl(buf.toString());
				}
				else
				{
					float device_height25_per=(.045f)*(float)(((Home)context).deviceHeight);
					float device_height14_per=(.035f)*(float)(((Home)context).deviceHeight);
					StringBuilder buf=new StringBuilder("javascript:setFontSize(");

					buf.append(String.valueOf(device_height25_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(")");
					view.loadUrl(buf.toString());
				}

			}	


		}
		else if(i==2)
		{

			if(((Home)context).deviceWidth == 320 && ((Home)context).deviceHeight == 480)
			{
				float device_height25_per=(.032f)*(float)(((Home)context).deviceHeight);
				float device_height14_per=(.025f)*(float)(((Home)context).deviceHeight);
				StringBuilder buf=new StringBuilder("javascript:setFontSize(");
				buf.append(String.valueOf(device_height25_per));
				buf.append(",");
				buf.append(String.valueOf(device_height14_per));
				buf.append(",");
				buf.append(String.valueOf(device_height14_per));
				buf.append(")");
				view.loadUrl(buf.toString());
			}
			else if(((Home)context).deviceWidth == 480 &&((Home)context).deviceHeight== 800)
			{
				float device_height25_per=(.032f)*(float)(((Home)context).deviceHeight);
				float device_height14_per=(.025f)*(float)(((Home)context).deviceHeight);
				StringBuilder buf=new StringBuilder("javascript:setFontSize(");
				buf.append(String.valueOf(device_height25_per));
				buf.append(",");
				buf.append(String.valueOf(device_height14_per));
				buf.append(",");
				buf.append(String.valueOf(device_height14_per));
				buf.append(")");
				view.loadUrl(buf.toString());
			}
			else
			{
				if(((Home)context).deviceHeight>800)
				{
					float device_height25_per=(.045f)*(float)(((Home)context).deviceHeight);
					float device_height14_per=(.035f)*(float)(((Home)context).deviceHeight);
					StringBuilder buf=new StringBuilder("javascript:setFontSize(");
					buf.append(String.valueOf(device_height25_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(")");
					view.loadUrl(buf.toString());
				}
				else
				{
					float device_height25_per=(.055f)*(float)(((Home)context).deviceHeight);
					float device_height14_per=(.045f)*(float)(((Home)context).deviceHeight);
					StringBuilder buf=new StringBuilder("javascript:setFontSize(");

					buf.append(String.valueOf(device_height25_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(",");
					buf.append(String.valueOf(device_height14_per));
					buf.append(")");
					view.loadUrl(buf.toString());
				}

			}	



		}

	}
}
