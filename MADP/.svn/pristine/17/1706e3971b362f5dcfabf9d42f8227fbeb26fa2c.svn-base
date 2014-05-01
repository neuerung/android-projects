package mobi.neuerung.Util;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class UtilHtmlWithLink {

	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static WebView WView;
	private ProgressDialog dialog;
	//	private ProgressDialog dialog;

	// **** Set WebView in Html Pages *****
	public void SetHtmlPageWithLink(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;
		final ElementWrapper objElementWrapper = new Util().getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);
		if(_objScreenPartWrapper.ScreenName.equals("114"))
		{
			String aa[] = UrlLink.split("###");
			try {
				((Home)context)._objUtilTopBar.Heading.setText(aa[0]);
				UrlLink = aa[1];
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		
		UrlLink	= UrlLink+MyUIApplication.pref.getDeviceId();

		System.out.println(UrlLink);
		
		if(MyUIApplication.Copy)
		{


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
			
			
			if(_objScreenPartWrapper.ScreenName.equals("114"))
			{
				WView.getSettings().setSupportZoom(true);
				WView.getSettings().setBuiltInZoomControls(true);
				WView.getSettings().setLoadsImagesAutomatically(true);
			}
			WView.getSettings().setJavaScriptEnabled(true);
			if(MyUIApplication.isInternetAvailable(context) && UrlLink.trim().length()>0)
			{
				dialog = new ProgressDialog(context);
				dialog.setMessage("Please Wait ..");
				dialog.show();
				dialog.setCancelable(true);
				WView.loadUrl(UrlLink);
			}
			else
			{
				MyUIApplication.AlertForInternet(context);
			}

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
						i.putExtra(Intent.EXTRA_EMAIL  , new String[]{url});
						i.putExtra(Intent.EXTRA_SUBJECT, "subject");
						i.putExtra(Intent.EXTRA_TEXT   , body);
						((Home)context).startActivity(Intent.createChooser(i, "Email:"));
					}
					//					if(url.startsWith("http"))
					//					{
					//						Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					//						((Home)context).startActivity(browserIntent);
					//					}
					else
					{

						view.loadUrl(url);
					}

					return true;
				}

				@Override
				public void onPageStarted(WebView view, String url,
						Bitmap favicon) {
					// TODO Auto-generated method stub
					super.onPageStarted(view, url, favicon);

					//					dialog = new ProgressDialog(context);
					//					dialog.setMessage("Please Wait ..");
					//					dialog.show();
					//					dialog.setCancelable(false);

				}

				@Override
				public void onPageFinished(WebView view, String url) {
					Log.e("HTML", "Calling java script funtion with device id "+MyUIApplication.pref.getDeviceId());
					view.loadUrl("javascript:getDeviceID('"+MyUIApplication.pref.getDeviceId()+"')");
					if(((Home)context).deviceWidth == 320 && ((Home)context).deviceHeight == 480)
					{
					}
					else if(((Home)context).deviceWidth == 480 &&((Home)context).deviceHeight== 800)
					{
					}
					else if(((Home)context).deviceWidth == 480 && ((Home)context).deviceHeight== 854)
					{
					}
					else
					{
						if(((Home)context).deviceHeight>800)
						{
							float device_height25_per=(.022f)*(float)(((Home)context).deviceHeight);
							float device_height14_per=(.015f)*(float)(((Home)context).deviceHeight);

							String msgToSend ="iijs";
							WView.loadUrl("javascript:getValue((\""+msgToSend+"\"))");
							WView.loadUrl("javascript:setFontSize((\""+device_height25_per+","+device_height14_per+","+device_height14_per+"\"))");
							//							WView.loadUrl("javascript:setBodyFontSize((\""+device_height14_per+"\"))");
							//							WView.loadUrl("javascript:contentFontSize((\""+device_height14_per+"\"))");
							//							WView.loadUrl("javascript:subHeadingFontSize((\""+device_height17_per+"\"))");
						}
						else
						{
							float device_height25_per=(.035f)*(float)(((Home)context).deviceHeight);
							float device_height14_per=(.025f)*(float)(((Home)context).deviceHeight);

							String msgToSend ="iijs";
							WView.loadUrl("javascript:getValue((\""+msgToSend+"\"))");
							WView.loadUrl("javascript:setFontSize((\""+device_height25_per+","+device_height14_per+","+device_height14_per+"\"))");
							//							WView.loadUrl("javascript:setBodyFontSize((\""+device_height14_per+"\"))");
							//							WView.loadUrl("javascript:contentFontSize((\""+device_height14_per+"\"))");
							//							WView.loadUrl("javascript:subHeadingFontSize((\""+device_height17_per+"\"))");
						}
					}
					try {
						if(dialog != null)
						{
							if (dialog.isShowing()) {
								dialog.dismiss();
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}



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

					((Home)context).LLTopCopy.addView(WView);

					ViewGroup.LayoutParams params_WView = WView.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					WView.setLayoutParams(params_WView);


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

					((Home)context).LLMiddleCopy.addView(WView);



					ViewGroup.LayoutParams params_WView = WView.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					WView.setLayoutParams(params_WView);

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


					((Home)context).LLBottomCopy.addView(WView);

					ViewGroup.LayoutParams params_WView = WView.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					WView.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

		}
		else if(!MyUIApplication.Copy)
		{

			WView= new WebView(context);
			WView.getSettings().setJavaScriptEnabled(true);

			
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
			
			if(_objScreenPartWrapper.ScreenName.equals("114"))
			{
				WView.getSettings().setSupportZoom(true);
				WView.getSettings().setBuiltInZoomControls(true);
				WView.getSettings().setLoadsImagesAutomatically(true);
			}


			if(MyUIApplication.isInternetAvailable(context) && UrlLink.trim().length()>0)
			{
				dialog = new ProgressDialog(context);
				this.dialog.setMessage("Please Wait ..");
				this.dialog.show();
				this.dialog.setCancelable(true);
				WView.loadUrl(UrlLink);
			}
			else
			{
				MyUIApplication.AlertForInternet(context);
			}


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
						i.putExtra(Intent.EXTRA_EMAIL  , new String[]{url});
						i.putExtra(Intent.EXTRA_SUBJECT, "subject");
						i.putExtra(Intent.EXTRA_TEXT   , body);
						context.startActivity(Intent.createChooser(i, "Email:"));
					}
					//					if(url.startsWith("http"))
					//					{
					//						Toast.makeText(context, url, Toast.LENGTH_SHORT).show();
					//						Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					//						context.startActivity(browserIntent);
					//					}
					else
					{
						dialog = new ProgressDialog(context);
						dialog.setMessage("Please Wait ..");
						dialog.show();
						view.loadUrl(url);
					}
					return true;
				}

				public void onPageFinished(WebView view, String url) {
					try {
						Log.e("HTML", "Calling java script funtion with device id "+MyUIApplication.pref.getDeviceId());
						view.loadUrl("javascript:getDeviceID('"+MyUIApplication.pref.getDeviceId()+"')");
						if(dialog != null)
						{
							if (dialog.isShowing()) {
								dialog.dismiss();
							}
						}
						
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

				}
				
				
			});




			//		DownloadFromUrl("http://203.190.149.92/eventmobile/Upload/HTMLPages/201303181531/AboutGJEPC.html", "AboutGJEPC.html");

			try
			{


				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(WView);

					ViewGroup.LayoutParams params_WView = WView.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					WView.setLayoutParams(params_WView);


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

					((Home)context).LLMiddle.addView(WView);

					ViewGroup.LayoutParams params_WView = WView.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					WView.setLayoutParams(params_WView);

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


					((Home)context).LLBottom.addView(WView);

					ViewGroup.LayoutParams params_WView = WView.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					WView.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
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
}
