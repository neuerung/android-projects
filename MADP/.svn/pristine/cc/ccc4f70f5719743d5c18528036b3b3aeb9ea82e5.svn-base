package mobi.neuerung.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ScreenPartWrapper;

import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;

public class UtilVideoGalleryDetail {

	public static VideoView videoview;
	public LinearLayout LLView ;
	public LinearLayout mainLL ;

	public WebView mWebView;
	public String url;
	public Context context;

	// *** Set Grid View ****
	public void SetVideoPlayer(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context , final String Url)
	{
		MyUIApplication._objEWList = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);

		this.context	=	context;


		mainLL= new LinearLayout(context);
		mainLL.setOrientation(LinearLayout.VERTICAL);

		LLView= new LinearLayout(context);
		LLView.setOrientation(LinearLayout.VERTICAL);

		int deviceHeight = ((Home)context).deviceHeight;
		int deviceWidth = ((Home)context).deviceWidth;


		try {
			mainLL.setBackgroundColor(Color.parseColor(MyUIApplication._objEWList.get(0).bgcolor.trim()));
		} catch (Exception e) {
			// TODO: handle exception
			mainLL.setBackgroundColor(Color.RED);
		}




		if(MyUIApplication.Copy)
		{
			try
			{
				if(Section.equals("Top"))
				{


					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(mainLL);

					ViewGroup.LayoutParams params_LView = mainLL.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLL.setLayoutParams(params_LView);

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

					int i = ((Home)context).LLMiddleCopy.getChildCount();
					View v = ((Home)context).LLMiddleCopy.getChildAt(0);

					((Home)context).LLMiddleCopy.addView(mainLL);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);


					ViewGroup.LayoutParams params_LView = mainLL.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLL.setLayoutParams(params_LView);


				}
				else if(Section.equals("Bottom"))
				{

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(mainLL);

					ViewGroup.LayoutParams params_LView = mainLL.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLL.setLayoutParams(params_LView);

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
			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(mainLL);

					ViewGroup.LayoutParams params_mainLL = mainLL.getLayoutParams();
					params_mainLL.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLL.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLL.setLayoutParams(params_mainLL);

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

					((Home)context).LLMiddle.addView(mainLL);

					ViewGroup.LayoutParams params_mainLL = mainLL.getLayoutParams();
					params_mainLL.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLL.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLL.setLayoutParams(params_mainLL);

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


					((Home)context).LLBottom.addView(mainLL);

					ViewGroup.LayoutParams params_mainLL = mainLL.getLayoutParams();
					params_mainLL.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLL.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLL.setLayoutParams(params_mainLL);

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


		//Set linear layout margins
		try {
			FrameLayout.LayoutParams params_LLView = (FrameLayout.LayoutParams) LLView.getLayoutParams();
			float leftmargin = Float.parseFloat(MyUIApplication._objEWList.get(0).leftper.trim());
			leftmargin =leftmargin/100f;
			params_LLView.leftMargin = (int)(leftmargin*deviceWidth);
		} catch (Exception e) {
			MyUIApplication.LoggerToSD("Video Gallery Details", "left Margin Error");
			e.printStackTrace();
		}

		try {
			FrameLayout.LayoutParams params_ListButton = (FrameLayout.LayoutParams) LLView.getLayoutParams();
			float rightmargin = Float.parseFloat(MyUIApplication._objEWList.get(0).rightper.trim());
			rightmargin =rightmargin/100f;
			params_ListButton.leftMargin = (int)(rightmargin*deviceWidth);
		} catch (Exception e) {
			MyUIApplication.LoggerToSD("Video Gallery Details", "Right Margin Error"); 
			e.printStackTrace();
		}

		///////////////////////////////////
		//Add web view to play video in it
		url = new String(MyUIApplication.globel_video_wrapper.VideoUrl); 
//		mWebView = new WebView(context);

		videoview = new VideoView(context);
		
		mainLL.addView(videoview);
		LinearLayout.LayoutParams	parmaLin	=	(LinearLayout.LayoutParams)videoview.getLayoutParams();
		parmaLin.width	=	LayoutParams.MATCH_PARENT;
		parmaLin.height	=	LayoutParams.MATCH_PARENT;
		videoview.setLayoutParams(parmaLin);
//		videoview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		
		videoview.setVideoURI(Uri.parse(SrcPath));
		videoview.setMediaController(new MediaController(context));
		videoview.requestFocus();
		videoview.start();

//		mainLL.addView(mWebView);
//		LinearLayout.LayoutParamsS	parmaLin	=	(LinearLayout.LayoutParams)mWebView.getLayoutParams();
//		parmaLin.width	=	LayoutParams.MATCH_PARENT;
//		parmaLin.height	=	LayoutParams.MATCH_PARENT;
//		mWebView.setLayoutParams(parmaLin);

//		mWebView.setWebChromeClient(chromeClient);
//		mWebView.setWebViewClient(wvClient);
//		mWebView.getSettings().setJavaScriptEnabled(true);
//		mWebView.getSettings().setPluginsEnabled(true);
//		mWebView.loadUrl(url);



	}

	String SrcPath = "rtsp://v5.cache1.c.youtube.com/CjYLENy73wIaLQnhycnrJQ8qmRMYESARFEIJbXYtZ29vZ2xlSARSBXdhdGNoYPj_hYjnq6uUTQw=/0/0/0/video.3gp";


	WebChromeClient chromeClient	=	new WebChromeClient(){

		@Override
		public void onShowCustomView(View view, CustomViewCallback callback) {
			super.onShowCustomView(view, callback);
			if (view instanceof FrameLayout){
				FrameLayout frame = (FrameLayout) view;
				if (frame.getFocusedChild() instanceof VideoView){
					VideoView video = (VideoView) frame.getFocusedChild();
					frame.removeView(video);
					((Activity)context).setContentView(video);
					video.setOnCompletionListener(completeListner);
					video.setOnErrorListener(errorListner);
					video.start();
				}
			}
		}

	};

	WebViewClient wvClient	=	 new WebViewClient();

	MediaPlayer.OnCompletionListener completeListner	=	new OnCompletionListener() {

		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub

		}
	};

	MediaPlayer.OnErrorListener errorListner=	new MediaPlayer.OnErrorListener(){

		public boolean onError(MediaPlayer mp, int what, int extra) {
			// TODO Auto-generated method stub
			return false;
		}

	};

	private void createView(double height,double width)
	{


	}

	static int seek=0;
	public void VideoClick(View view,Context context,int Height, int width)
	{
		if (videoview.isPlaying()) 
		{
			seek = videoview.getCurrentPosition();
			videoview.pause();
			ImageUtil.setBgFromSDCardNotCache(view, context,"pause.png",Height,width);

		} 
		else 
		{
			videoview.seekTo(seek);
			videoview.start();
			ImageUtil.setBgFromSDCardNotCache(view, context,"play.png",Height,width);
		}
	}

	public void downloadVideo(String Url,Context context)
	{
		try {


			String fileName = Url.substring(Url.lastIndexOf("/")+1);
			//			DownloadFromUrl(DownloadUrl, fileName);


			File SDCardRoot = MyUIApplication.SDCardPath("/Download");
			URL url = new URL(Url); //you can write here any link
			File file = new File(SDCardRoot, fileName);

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
			int totalSize = ucon.getContentLength();
			int downloadedSize = 0;

			ByteArrayBuffer baf = new ByteArrayBuffer(5000);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
				downloadedSize += current;
				updateProgress(context,downloadedSize, totalSize);
			}


			/* Convert the Bytes read to a String. */
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(baf.toByteArray());
			fos.flush();
			fos.close();
			Log.d("DownloadManager", "download ready in" + ((System.currentTimeMillis() - startTime) / 1000) + " sec");

			// Activity For Splash0 To Splash.java


		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void updateProgress(Context context,int downloadedSize,int totalSize)
	{

	}
}
