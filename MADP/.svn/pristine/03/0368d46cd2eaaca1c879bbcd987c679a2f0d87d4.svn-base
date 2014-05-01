package mobi.neuerung.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import mobi.neuerung.Adapters.VideoGalleryListAdapter;
import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.BGThread.PictureGalleryBG;
import mobi.neuerung.BGThread.Splash0Thread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.VideoGalleryListWrapper;

import org.apache.http.util.ByteArrayBuffer;

import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class UtilVideoGalleryList {

	public static ListView LView;
	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static String screenNumber;
	 ElementWrapper _objEW;

	// *** Set List View ****
	public void SetListView(ScreenPartWrapper _objScreenPartWrapper, String Section , Context context)
	{
//		MyUIApplication._objEWList = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);
		 _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;

		MyUIApplication.globel_instance	=	_objEW.instance;
		
		MyUIApplication.globel_video_wrapper	=	new VideoGalleryListWrapper();
		
		try {
			((Home)context)._objUtilTopBar.Heading.setText(MyUIApplication.CatagoryName);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if(_objEW.OnClick.length()>0)
		{
			screenNumber=_objEW.OnClick.substring(12);
		}
		else
		{
			Toast.makeText(context, "OnClick length is less than 12", Toast.LENGTH_SHORT).show();
		}

		if(MyUIApplication.Copy)
		{

			try
			{
				LView= new ListView(context);

				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

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

					((Home)context).LLMiddleCopy.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

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


					((Home)context).LLBottomCopy.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);


				}
				LView.setVerticalFadingEdgeEnabled(false);
				LView.setBackgroundColor(Color.WHITE);		
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
				LView= new ListView(context);
				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

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

					((Home)context).LLMiddle.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

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


					((Home)context).LLBottom.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

				}
				LView.setVerticalFadingEdgeEnabled(false);
				LView.setBackgroundColor(Color.WHITE);

			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}

		if(MyUIApplication.checkShowUpdate){

			if(MyUIApplication.isInternetAvailable(context))
			{
				//Check for update & then fill the list
				new BadgeBGThread(context, "VideoGalleryList", MyUIApplication.CatagoryCode).execute();
				MyUIApplication.checkShowUpdate	=	false;
			}

		}else {
			//Directly fill the list
			SetVideoGalleryListAdapter(context);
		}
//		SetVideoGalleryListAdapter(context);
		
		// For Parsing and getting list of PictureGaleryGrid
//		new BadgeBGThread(context, "VideoGalleryList", MyUIApplication.CatagoryCode).execute();
	}

	public void DownloadImagesInSdCard(Context context,String CatagoryCode)
	{
		try
		{
			MyUIApplication.VideoGalleryList = null; 
			MyUIApplication.VideoGalleryList = new ArrayList<VideoGalleryListWrapper>(); 
			MyUIApplication._objPictureGalleryGridDB.getVideoGalleryList();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		// For DownLoad Images For List

		if(MyUIApplication.isInternetAvailable(context))
		{
			new Splash0Thread(context,"VideoGalleryList","").execute();

		}
	}
	public void ImageDownLoadMethod(Context context)
	{
		try
		{
			for(int i = 0; i<MyUIApplication.VideoGalleryList.size();i++)
			{
				if(MyUIApplication.VideoGalleryList.get(i).ImagePath.trim().length()>5){
					
					String fileName = MyUIApplication.VideoGalleryList.get(i).ImagePath.substring(MyUIApplication.VideoGalleryList.get(i).ImagePath.lastIndexOf("/")+1);
					File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/VideoGalleryList/Images/"+fileName);

					if(!sdMiddlefileImage.exists())
					{
						DownloadImages(MyUIApplication.VideoGalleryList.get(i).ImagePath,context);
					}
					
				}else {
					Log.e("Video category List", "Youtube link");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void DownloadImages(String DownloadUrl,Context context) {


		String fileName = DownloadUrl.substring(DownloadUrl.lastIndexOf("/")+1);
		//			DownloadFromUrl(DownloadUrl, fileName);
		try {

			File dir = MyUIApplication.SDCardPath("/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/VideoGalleryList/Images");

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
			Log.e("DownloadManager", "Error: " + e);
			e.printStackTrace();

		}
	}
	public void SetVideoGalleryListAdapter(Context context)
	{
		
		MyUIApplication.VideoGalleryList = null; 
		MyUIApplication.VideoGalleryList = new ArrayList<VideoGalleryListWrapper>(); 
		MyUIApplication._objPictureGalleryGridDB.getVideoGalleryList();
		
		LView.setAdapter(null);
		LView.setAdapter(new VideoGalleryListAdapter(context,_objEW));
	}

}
