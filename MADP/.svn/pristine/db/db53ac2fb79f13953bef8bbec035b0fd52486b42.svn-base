package mobi.neuerung.Util;


import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class UtilGoogleMap 
{
	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	String ScreenNumber="";
	public static WebView webView;
	
	 Location mostRecentLocation;
	
	 private static final String MAP_URL = "http://gmaps-samples.googlecode.com/svn/trunk/articles-android-webmap/simple-android-map.html";
	 private void getLocation()
	    {
	        LocationManager locationManager = (LocationManager)context. getSystemService(Context.LOCATION_SERVICE);
	        Criteria criteria = new Criteria();
	        criteria.setAccuracy(Criteria.ACCURACY_FINE);
	        String provider = locationManager.getBestProvider(criteria, true);
	        // In order to make sure the device is getting the location, request
	        // updates.
	        locationManager.requestLocationUpdates(provider, 1, 0, new LocationListener() {
				
				public void onStatusChanged(String provider, int status, Bundle extras) {
					// TODO Auto-generated method stub
					
				}
				
				public void onProviderEnabled(String provider) {
					// TODO Auto-generated method stub
					
				}
				
				public void onProviderDisabled(String provider) {
					// TODO Auto-generated method stub
					
				}
				
				public void onLocationChanged(Location location) {
					// TODO Auto-generated method stub
					
				}
			});
	        mostRecentLocation = locationManager.getLastKnownLocation(provider);
	    }

	    
	   

	    /** Sets up the WebView object and loads the URL of the page **/
	    private void setupWebView()
	    {
	        
	        webView.getSettings().setJavaScriptEnabled(true);
	        // Wait for the page to load then send the location information
	        webView.setWebViewClient(new WebViewClient());
	        final String centerURL = "javascript:centerAt(" + mostRecentLocation.getLatitude() + "," + mostRecentLocation.getLongitude() + ")";
	        
	        webView.loadUrl(MAP_URL);
	        /** Allows JavaScript calls to access application resources **/
//	        webView.addJavascriptInterface(new JavaScriptInterface(), "android");
	    }

	    /**
	     * Sets up the interface for getting access to Latitude and Longitude data
	     * from device
	     **/
	    private class JavaScriptInterface
	    {
	        public double getLatitude()
	        {
	            return mostRecentLocation.getLatitude();
	        }

	        public double getLongitude()
	        {
	            return mostRecentLocation.getLongitude();
	        }
	    }
	
	public void OpenGoogleMap(ScreenPartWrapper _objScreenPartWrapper , String Section ,final Context context)
	{
		
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;

		if(MyUIApplication.Copy)
		{
			webView= new WebView(context);

//			dialog = new ProgressDialog(context);
//			this.dialog.setMessage("Please Wait ..");
//			this.dialog.show();
//			this.dialog.setCancelable(false);


			try
			{
				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(webView);

					try
					{
						    webView.getSettings().setJavaScriptEnabled(true);
						    webView.getSettings().setBuiltInZoomControls(true);
							webView.getSettings().setSupportZoom(true);
						    webView.setWebViewClient(new WebViewClient());
						    getLocation();
						    final String centerURL = "javascript:centerAt(" + mostRecentLocation.getLatitude() + "," + mostRecentLocation.getLongitude() + ")";
					        webView.loadUrl(centerURL);
						    
//						    webView.loadUrl("http://maps.google.com/maps?" +"saddr=43.0054446,-87.9678884" + "&daddr=42.9257104,-88.0508355");

					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}
					ViewGroup.LayoutParams params_webView = webView.getLayoutParams();
					params_webView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_webView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					webView.setLayoutParams(params_webView);


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

					((Home)context).LLMiddleCopy.addView(webView);

					try
					{
						webView.getSettings().setJavaScriptEnabled(true);
						webView.getSettings().setBuiltInZoomControls(true);
						webView.getSettings().setSupportZoom(true);
					    webView.setWebViewClient(new WebViewClient());
					    getLocation();
					    final String centerURL = "javascript:centerAt(" + mostRecentLocation.getLatitude() + "," + mostRecentLocation.getLongitude() + ")";
				        webView.loadUrl(centerURL);
//					    webView.loadUrl("http://maps.google.com/maps?" +"saddr=43.0054446,-87.9678884" + "&daddr=42.9257104,-88.0508355");

					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}

					ViewGroup.LayoutParams params_webView = webView.getLayoutParams();
					params_webView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_webView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					webView.setLayoutParams(params_webView);

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


					((Home)context).LLBottomCopy.addView(webView);

					ViewGroup.LayoutParams params_webView = webView.getLayoutParams();
					params_webView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_webView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					webView.setLayoutParams(params_webView);


					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);

					try
					{
						webView.getSettings().setJavaScriptEnabled(true);
						webView.getSettings().setBuiltInZoomControls(true);
						webView.getSettings().setSupportZoom(true);
					    webView.setWebViewClient(new WebViewClient());
					    final String centerURL = "javascript:centerAt(" + mostRecentLocation.getLatitude() + "," + mostRecentLocation.getLongitude() + ")";
				        webView.loadUrl(centerURL);
//					    webView.loadUrl("http://maps.google.com/maps?" +"saddr=43.0054446,-87.9678884" + "&daddr=42.9257104,-88.0508355");
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
		else if(!MyUIApplication.Copy)
		{

			webView= new WebView(context);

//			dialog = new ProgressDialog(context);
//			this.dialog.setMessage("Please Wait ..");
//			this.dialog.show();
//			this.dialog.setCancelable(false);

			try
			{
				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(webView);

					try
					{
						webView.getSettings().setJavaScriptEnabled(true);
						webView.getSettings().setBuiltInZoomControls(true);
						webView.getSettings().setSupportZoom(true);
					    webView.setWebViewClient(new WebViewClient());
					    final String centerURL = "javascript:centerAt(" + mostRecentLocation.getLatitude() + "," + mostRecentLocation.getLongitude() + ")";
				        webView.loadUrl(centerURL);
//					    webView.loadUrl("http://maps.google.com/maps?" +"saddr=43.0054446,-87.9678884" + "&daddr=42.9257104,-88.0508355");

					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}
					ViewGroup.LayoutParams params_webView = webView.getLayoutParams();
					params_webView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_webView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					webView.setLayoutParams(params_webView);


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

					((Home)context).LLMiddle.addView(webView);

					try
					{
						webView.getSettings().setJavaScriptEnabled(true);
						webView.getSettings().setBuiltInZoomControls(true);
						webView.getSettings().setSupportZoom(true);
					    webView.setWebViewClient(new WebViewClient());
					    getLocation();
					    final String centerURL = "javascript:centerAt(" + mostRecentLocation.getLatitude() + "," + mostRecentLocation.getLongitude() + ")";
				        webView.loadUrl(centerURL);
//					    webView.loadUrl("http://maps.google.com/maps?" +"saddr=43.0054446,-87.9678884" + "&daddr=42.9257104,-88.0508355");

					}
					catch (Exception e)
					{
						System.out.println("Exception In Setting Xml Page"+e);
					}

					ViewGroup.LayoutParams params_webView = webView.getLayoutParams();
					params_webView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_webView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					webView.setLayoutParams(params_webView);

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


					((Home)context).LLBottom.addView(webView);

					ViewGroup.LayoutParams params_webView = webView.getLayoutParams();
					params_webView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_webView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					webView.setLayoutParams(params_webView);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

					try
					{
						webView.getSettings().setJavaScriptEnabled(true);
						webView.getSettings().setBuiltInZoomControls(true);
						webView.getSettings().setSupportZoom(true);
					    webView.setWebViewClient(new WebViewClient());
					    final String centerURL = "javascript:centerAt(" + mostRecentLocation.getLatitude() + "," + mostRecentLocation.getLongitude() + ")";
				        webView.loadUrl(centerURL);
//					    webView.loadUrl("http://maps.google.com/maps?" +"saddr=43.0054446,-87.9678884" + "&daddr=42.9257104,-88.0508355");
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
		
//		String uri = String.format(Locale.ENGLISH, "geo:%f,%f?z=%d&q=%f,%f (%s)", 
//			latitude, longitude, zoom, latitude, longitude, label);
//		
//		
//		
//	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//	context.startActivity(intent);
	}
}
