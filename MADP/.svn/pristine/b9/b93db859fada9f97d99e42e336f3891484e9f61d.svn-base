package mobi.neuerung.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import mobi.neuerung.BGThread.PictureGalleryBG;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;

import org.apache.http.util.ByteArrayBuffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.matabii.dev.scaleimageview.ScaleImageView;

public class UtilPictureGalleryDetail {

	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	String ScreenNumber="";
	private static ScaleImageView image;
	public String ImageName="",urlOfImage="",shortDesc="";
	WindowManager mWinMgr;
	int deviceHeight=0;
	int deviceWidth=0;


	// **** Set WebView in Html Pages *****
	public void SetImageForPGDetail(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String ScreenNumber,String wrapper)
	{
		final ElementWrapper objElementWrapper = new Util().getElementWrapperFromDB(ScreenNumber,Section);
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;
		this.ScreenNumber=ScreenNumber;
		ImageName="";urlOfImage="";
		try {
			String []obj  = wrapper.split("#,");
			ImageName =obj[1];
			shortDesc =obj[5];
			urlOfImage =obj[2];

			try {
				((Home)context)._objUtilTopBar.Heading.setText(shortDesc);
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}

		if(MyUIApplication.Copy)
		{
			image = new ScaleImageView(context);
			try {
				image.setBackgroundColor(Color.parseColor(objElementWrapper.bgcolor));
			} catch (Exception e) {
				// TODO: handle exception
				image.setBackgroundColor(Color.WHITE);
			}

			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);
					
					//Set BGcolor 
					try {
						((Home)context).LLTopCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(image);


					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);


					//Set BGcolor 
					try {
						((Home)context).LLMiddleCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						e.printStackTrace();
					}



				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);


					//Set BGcolor 
					try {
						((Home)context).LLBottomCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

			WindowManager mWinMgr = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
			deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
			deviceWidth=mWinMgr.getDefaultDisplay().getWidth();

			//			if(MyUIApplication.isInternetAvailable(context))
			//			{
			//				String fileName = urlOfImage.substring(urlOfImage.lastIndexOf("/")+1);
			String filePath = MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName;
			File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName);
			
			File showUpdateDetailImage	=	new File(Environment.getExternalStorageDirectory()+"/"+wrapper);
			if(sdMiddlefileImage.exists())
			{
				Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(image, context, filePath, deviceHeight,deviceWidth);

				if(bmp != null)
				{
					image.setImageBitmap(bmp);
					image.setBackgroundDrawable(null);
				}
			}else if (showUpdateDetailImage.exists()) {
				
				Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(image, context, wrapper, deviceHeight,deviceWidth);

				if(bmp != null)
				{
					image.setImageBitmap(bmp);
					image.setBackgroundDrawable(null);
				}
			}
			else
			{
				new PictureGalleryBG(context, "Download Image").execute();
			}
			//				if(!sdMiddlefileImage.exists())
			//				{
			//					new Splash0Thread(context,"PGD",urlOfImage).execute();
			//				}
			//				else
			//				{
			//					loadImage(urlOfImage,context);
			//				}
			//			}


		}
		else if(!MyUIApplication.Copy)
		{
			image = new ScaleImageView(context);

			try {
				image.setBackgroundColor(Color.parseColor(objElementWrapper.bgcolor));
			} catch (Exception e) {
				// TODO: handle exception
				image.setBackgroundColor(Color.WHITE);
			}

			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);
					
					//Set BGcolor 
					try {
						((Home)context).LLTop.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(image);


					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);



					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					//Set BGcolor 
					try {
						((Home)context).LLMiddle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

					//Set BGcolor 
					try {
						((Home)context).LLBottom.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}


			//			if(MyUIApplication.isInternetAvailable(context))
			//			{
			//				String fileName = urlOfImage.substring(urlOfImage.lastIndexOf("/")+1);
			//				File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/EventsMobilePlatform"+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+fileName);
			//
			//				//				if(!sdMiddlefileImage.exists())
			//				//				{
			//				new Splash0Thread(context,"PGD",urlOfImage).execute();
			//				//				}
			//				//				else
			//				//				{
			//				//					loadImage(urlOfImage,context);
			//				//				}
			//			}

			WindowManager mWinMgr = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
			deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
			deviceWidth=mWinMgr.getDefaultDisplay().getWidth();

//			String filePath = MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName;
//			File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName);

//			Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(image, context, filePath,deviceHeight,deviceWidth);
//
//			if(bmp != null)
//			{
//				image.setImageBitmap(bmp);
//				image.setBackgroundDrawable(null);
//			}
			
			/***************BackUp code************/
//			String filePath = MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName;
//			File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName);
//			if(sdMiddlefileImage.exists())
//			{
//				Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(image, context, filePath, deviceHeight,deviceWidth);
//
//				if(bmp != null)
//				{
//					image.setImageBitmap(bmp);
//					image.setBackgroundDrawable(null);
//				}
//			}
//			else
//			{
//				new PictureGalleryBG(context, "Download Image").execute();
//			}
			
			String filePath = MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName;
			File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName);
			
			File showUpdateDetailImage	=	new File(Environment.getExternalStorageDirectory()+"/"+wrapper);
			if(sdMiddlefileImage.exists())
			{
				Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(image, context, filePath, deviceHeight,deviceWidth);

				if(bmp != null)
				{
					image.setImageBitmap(bmp);
					image.setBackgroundDrawable(null);
				}
			}else if (showUpdateDetailImage.exists()) {
				
				Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(image, context, wrapper, deviceHeight,deviceWidth);

				if(bmp != null)
				{
					image.setImageBitmap(bmp);
					image.setBackgroundDrawable(null);
				}
			}
			else
			{
				new PictureGalleryBG(context, "Download Image").execute();
			}


			//			WView.loadUrl(urlOfImage);


		}
	}
	//first you will need to find the dimensions of the screen 

	//this function will set the current height according to screen orientation



	//call this function and it will place the image at the center

	public void loadImage(){

		//		String fileName = DownloadUrl.substring(DownloadUrl.lastIndexOf("/")+1);
		//
		//		try
		//		{
		//			File Imagepath = new File(Environment.getExternalStorageDirectory()+"/EventsMobilePlatform"+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+fileName);
		//			InputStream istr=new FileInputStream(Imagepath);
		//
		//			Bitmap BitmapOfMyImage=BitmapFactory.decodeStream(istr);
		//
		//			image.setImageBitmap(BitmapOfMyImage);
		//
		//		}
		//		catch (Exception e) {
		//			// TODO: handle exception
		//			System.out.println(e);
		//		}
		try {

			String filePath = MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+MyUIApplication.CatagoryCode+"/"+ImageName;

			Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(image, context, filePath, image.getHeight(),image.getWidth());

			if(bmp != null)
			{
				image.setImageBitmap(bmp);
				image.setBackgroundDrawable(null);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void DownloadFromUrl(String DownloadUrl,Context context) {


		String fileName = DownloadUrl.substring(DownloadUrl.lastIndexOf("/")+1);
		//			DownloadFromUrl(DownloadUrl, fileName);
		try {

			File dir = MyUIApplication.SDCardPath("/EventsMobilePlatform"+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images");

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

}
