package mobi.neuerung.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import mobi.neuerung.BGThread.Splash0Thread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ScreenPartWrapper;

import org.apache.http.util.ByteArrayBuffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.matabii.dev.scaleimageview.ScaleImageView;

public class UtilPicturealleryDetailWithDesc {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	String ScreenNumber="";
	private static ScaleImageView image;

	// **** Set WebView in Html Pages *****
	public void SetImageForPGDetail(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String ScreenNumber,String wrapper)
	{
		//		final ElementWrapper objElementWrapper = new Util().getElementWrapperFromDB(ScreenNumber,Section);

		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;
		this.ScreenNumber=ScreenNumber;

		String []obj  = wrapper.split("#,");
		String urlOfImage =obj[2];

		ScrollView  Sview = new ScrollView(context);
		LinearLayout Lview = new LinearLayout(context);

		if(MyUIApplication.Copy)
		{
			image = new ScaleImageView(context);
			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(Sview);
					Sview.addView(Lview);	
					Lview.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight*.7f);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

					if(_objScreenPartWrapper.Topbgcolor.length()>0)
					{
						((Home)context).LLTopCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					}
				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(Sview);
					Sview.addView(Lview);	
					Lview.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight*.7f);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					if(_objScreenPartWrapper.Midbgcolor.length()>0)
					{
						((Home)context).LLMiddleCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					}
				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLBottomCopy.addView(Sview);
					Sview.addView(Lview);	
					Lview.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight*.7f);
					params_WView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);

					if(_objScreenPartWrapper.Bottombgcolor.length()>0)
					{
						((Home)context).LLBottomCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

			if(MyUIApplication.isInternetAvailable(context))
			{
				String fileName = urlOfImage.substring(urlOfImage.lastIndexOf("/")+1);
				File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/EventsMobilePlatform"+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+fileName);

				if(!sdMiddlefileImage.exists())
				{
					new Splash0Thread(context,"PGDWthDesc",urlOfImage).execute();
				}
				else
				{
					loadImage(urlOfImage,context);
				}
			}
			Lview.setOrientation(LinearLayout.VERTICAL);
			LinearLayout BelowLayout = new LinearLayout(context);
			Lview.addView(BelowLayout);
			BelowLayout.setOrientation(LinearLayout.VERTICAL);

			TextView Heading = new TextView(context);
			BelowLayout.addView(Heading);
			Heading.setText("Product Detail");
			Heading.setTextColor(Color.BLACK);
			Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.4f)*(.1f*((Home)context).deviceHeight)));

			LinearLayout.LayoutParams Heading_param = (LinearLayout.LayoutParams)Heading.getLayoutParams();
			Heading_param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER_HORIZONTAL);

			String SDescription = obj[5];
			String LDescription =obj[6];
			
			String []Sdesc = SDescription.split(",");
			
			for(int i=0;i<Sdesc.length;i++)
			{
				TextView Txt = new TextView(context);
				BelowLayout.addView(Txt);
				Txt.setText(Sdesc[i]);
				Txt.setTextColor(Color.BLACK);
				Txt.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Txt.getTypeface(),(0.4f)*(.1f*((Home)context).deviceHeight)));

				LinearLayout.LayoutParams Txt_param = (LinearLayout.LayoutParams)Txt.getLayoutParams();
				Txt_param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER_HORIZONTAL);

			}

		}
		else if(!MyUIApplication.Copy)
		{
			image = new ScaleImageView(context);
			try
			{
				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(Sview);
					Sview.addView(Lview);	
					Lview.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight*.7f);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

					if(_objScreenPartWrapper.Topbgcolor.length()>0)
					{
						((Home)context).LLTop.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					}
				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(Sview);
					Sview.addView(Lview);	
					Lview.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight*.7f);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);



					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					if(_objScreenPartWrapper.Midbgcolor.length()>0)
					{
						((Home)context).LLMiddle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					}
				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(Sview);
					Sview.addView(Lview);	
					Lview.addView(image);

					ViewGroup.LayoutParams params_WView = image.getLayoutParams();
					params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight*.7f);
					params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					image.setLayoutParams(params_WView);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

					if(_objScreenPartWrapper.Bottombgcolor.length()>0)
					{
						((Home)context).LLBottom.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

			if(MyUIApplication.isInternetAvailable(context))
			{
				String fileName = urlOfImage.substring(urlOfImage.lastIndexOf("/")+1);
				File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/EventsMobilePlatform"+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+fileName);

				new Splash0Thread(context,"PGDWthDesc",urlOfImage).execute();
			}
			Lview.setOrientation(LinearLayout.VERTICAL);
			RelativeLayout BelowLayout = new RelativeLayout(context);
			Lview.addView(BelowLayout);

			TextView Heading = new TextView(context);
			BelowLayout.addView(Heading);
			Heading.setText("Product Detail");
			Heading.setTextColor(Color.BLACK);
			Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.4f)*(.1f*((Home)context).deviceHeight)));

			RelativeLayout.LayoutParams Heading_param = (RelativeLayout.LayoutParams)Heading.getLayoutParams();
			Heading_param.addRule(RelativeLayout.CENTER_HORIZONTAL);



		}
	}
	//first you will need to find the dimensions of the screen 

	//this function will set the current height according to screen orientation



	//call this function and it will place the image at the center

	public void loadImage(String DownloadUrl,Context context){

		String fileName = DownloadUrl.substring(DownloadUrl.lastIndexOf("/")+1);

		try
		{
			File Imagepath = new File(Environment.getExternalStorageDirectory()+"/EventsMobilePlatform"+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+fileName);
			InputStream istr=new FileInputStream(Imagepath);

			Bitmap BitmapOfMyImage=BitmapFactory.decodeStream(istr);

			image.setImageBitmap(BitmapOfMyImage);

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
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
