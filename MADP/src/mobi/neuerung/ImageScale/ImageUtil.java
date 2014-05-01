package mobi.neuerung.ImageScale;

import mobi.neuerung.MADP.MyUIApplication;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class ImageUtil {

	//	public static void setBackgroundBgFromAssets(View v,Context context,String imgUrl,float height,float width) 
	//	{
	//		try {
	//			Snippet.clenaUp();
	//			System.runFinalization();
	////			String imgUrl = "home/one.png";
	//			Bitmap bmp1 = Snippet.getBitmapFromAsset1(context, imgUrl,height,width);
	////			if(!bmp1.isRecycled())
	////			{
	//				BitmapDrawable btmBg= new BitmapDrawable(bmp1);
	//				v.setBackgroundDrawable(btmBg);
	////			}
	//			
	//				
	////			linearLayout.setBackgroundDrawable(background);
	////			btnFirst.setBa(bbmp1);
	//		}catch (Exception e) {
	//			e.printStackTrace();
	//
	//		} catch (Throwable e) {
	//			e.printStackTrace();
	//		}
	//	}

	public static Bitmap setBackgroundBgFromAssetsNotCache(View v,Context context,String imgUrl,float height,float width) 
	{
		try {
			Snippet.clenaUp();
			System.runFinalization();
			Bitmap bmp1 = Snippet.getBitmapFromAssetNotCache(context, imgUrl,height,width);
			BitmapDrawable btmBg= new BitmapDrawable(bmp1);
			v.setBackgroundDrawable(btmBg);

			return bmp1;

		}catch (Exception e) {
			e.printStackTrace();

			return null;

		} catch (Throwable e) {
			e.printStackTrace();

			return null;
		}
	}

	// Set Bitmap From SD Card With Cache Functionality
	//	public static void setBgFromSDCard(View v,Context context,String imgUrl,float height,float width) 
	//	{
	//		try {
	//			Snippet.clenaUp();
	//			System.runFinalization();
	//			Bitmap bmp1 = Snippet.getBitmapFromSDCard(context, imgUrl,height,width);
	//			BitmapDrawable btmBg= new BitmapDrawable(bmp1);
	//			v.setBackgroundDrawable(btmBg);
	//		}catch (Exception e) {
	//			e.printStackTrace();
	//			
	//		} catch (Throwable e) {
	//			e.printStackTrace();
	//		}
	//	}
	public static Bitmap setBgFromSDCardNotCache(View v,Context context,String imgUrl,float height,float width) 
	{
		try {
			//			Snippet.clenaUp();
			System.runFinalization();
			Bitmap bmp1 = Snippet.getBitmapFromSDCardNotCache(v,context, imgUrl,height,width);
			BitmapDrawable btmBg= new BitmapDrawable(bmp1);
			v.setBackgroundDrawable(btmBg);
			//			((ImageView)v).setImageDrawable(btmBg);
			btmBg = null;
			return bmp1;

		}catch (Exception e) {
			//			e.printStackTrace();
			return null;
		} catch (Throwable e) {
			//			e.printStackTrace();
			MyUIApplication.LoggerToSD("In Image Processing setBgFromSDCardNotCache Method of ImageUtil class", e.getMessage());
			return null;
		}
	}

	public static Bitmap setImageDirectFromSdCard(View v,Context context,String imgUrl,float height,float width) 
	{
		try {
			//			Snippet.clenaUp();
			System.runFinalization();
			Bitmap bmp1 = Snippet.getBitmapFromDirectSDCard(context, imgUrl,height,width);
			BitmapDrawable btmBg= new BitmapDrawable(bmp1);
			v.setBackgroundDrawable(btmBg);
			btmBg = null;
			return bmp1;

		}catch (Exception e) {
			//			e.printStackTrace();
			return null;
		} catch (Throwable e) {
			//			e.printStackTrace();
			MyUIApplication.LoggerToSD("In Image Processing setBgFromSDCardNotCache Method of ImageUtil class", e.getMessage());
			return null;
		}
	}


	// This method is for different directory other than Image Packet
	public static Bitmap setBgFromSDCardForOtherDirectoy(View v,Context context,String imgUrl,float height,float width) 
	{
		try {
			Snippet.clenaUp();
			System.runFinalization();
			Bitmap bmp1 = Snippet.getBitmapForOtherNotCache(v,context, imgUrl,height,width);
			BitmapDrawable btmBg= new BitmapDrawable(bmp1);
			v.setBackgroundDrawable(btmBg);

			return bmp1;

		}catch (Exception e) {
			e.printStackTrace();
			return null;

		} catch (Throwable e) {
			//			e.printStackTrace();
			MyUIApplication.LoggerToSD("In Image Processing setBgFromSDCardNotCache Method of ImageUtil class", e.getMessage());
			return null;
		}
	}


		//		/**
		//		 * This method is use to fetch image from Drawable folder
		//		 * @param v
		//		 * @param context
		//		 * @param imgUrl
		//		 * @param height
		//		 * @param width
		//		 * @return
		//		 */
		//		public static Bitmap setBgFromDrawable(View v,Context context,int resourceId,float height,float width) 
		//		{
		//			try {
		//				Snippet.clenaUp();
		//				System.runFinalization();
		//				Bitmap bmp1 = Snippet.getBitmapForOtherNotCache(v,context, imgUrl,height,width);
		//				BitmapDrawable btmBg= new BitmapDrawable(bmp1);
		//				v.setBackgroundDrawable(btmBg);
		//				
		//				return bmp1;
		//				
		//			}catch (Exception e) {
		//				e.printStackTrace();
		//				return null;
		//				
		//			} catch (Throwable e) {
		////			e.printStackTrace();
		//				MyUIApplication.LoggerToSD("In Image Processing setBgFromSDCardNotCache Method of ImageUtil class", e.getMessage());
		//				return null;
		//			}
		//	}
	}
