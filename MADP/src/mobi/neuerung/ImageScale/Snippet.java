package mobi.neuerung.ImageScale;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Hashtable;

import mobi.neuerung.MADP.MyUIApplication;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;


public class Snippet {

	//	Context cntex;
	private static Hashtable<String, Bitmap> bitmaps = new Hashtable<String, Bitmap>();
	private static Hashtable<String, Bitmap> bitmaps1 = new Hashtable<String, Bitmap>();


	private Snippet() {
		// TODO Auto-generated constructor stub
		//		super();
		//		cntex =  cntx;
		//        bitmaps = new Hashtable<String, Bitmap>();

	}

	public static void addBitmap(String key, Bitmap bmp){
		try{
			if(bmp != null && key != null)
				bitmaps1.put(key, bmp);
		}catch (Throwable e) {
		}
	}

	public void updateDrawable(Context cntex, final String imgUrl,ImageView img){
		try{
			Drawable d = Drawable.createFromStream(cntex.getAssets().open(imgUrl), null);
			img.setBackgroundDrawable(d);
		}catch (Throwable e) {
			System.out.println("excc  "+e);
		}
	}

	public static Bitmap getBitmapFromAsset(Context cntex, String strName) 
	{
		AssetManager assetManager = cntex.getAssets();
		BitmapFactory.Options opts=new BitmapFactory.Options();
		opts.inPurgeable = true;
		InputStream istr =  null;
		try{
			istr = assetManager.open(strName);
		}catch (Exception e) {
		}
		Bitmap bitmap = null;


		try {
			/*if(bitmaps.size() > 50){
				clenaUp();
			}*/

			if(strName!=null && bitmaps.get(strName) == null){
				bitmap  = BitmapFactory.decodeStream(istr,null,opts);
				if(bitmap != null)
					bitmaps.put(strName, bitmap);
			}else{
				System.out.println("already exist "+strName);
				if(strName != null)
					bitmap  =  bitmaps.get(strName);
				if(bitmap.isRecycled())
					bitmap  = BitmapFactory.decodeStream(istr,null,opts);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bitmap;
	} 

	/*	
	public Bitmap getBitmapFromAsset(Context cntex, String strName) throws IOThrowable
    {
        AssetManager assetManager = cntex.getAssets();

        BitmapFactory.Options opts=new BitmapFactory.Options();
        InputStream istr = assetManager.open(strName);
        System.out.println(istr+" << is "+strName);

       	Bitmap bitmap = BitmapFactory.decodeStream(istr,null,opts);
//        bitmaps.put(strName, bitmap);
        try{
        	istr.close();
        }catch (Throwable e) {
		}
        return bitmap;
    }*/

	public static Bitmap getBitmapFromAssetNotCache(Context cntex, String strName,float height,float width)  
	{
		AssetManager assetManager = cntex.getAssets();
		Bitmap bitmap = null;
		BitmapFactory.Options opts=new BitmapFactory.Options();
		opts.inPurgeable = true;

		try {
			InputStream istr1 = assetManager.open(strName);

			Bitmap bitmap1  = BitmapFactory.decodeStream(istr1,null,opts);

			opts.inSampleSize = calculateInSampleSize(opts, (int) width,(int) height);

			//			int heightRatio = (int)Math.ceil(bitmap1.getHeight()/(float)height);
			//			int widthRatio = (int)Math.ceil(bitmap1.getWidth()/(float)width);
			//			if (heightRatio > 1 || widthRatio > 1)
			//			{
			//				if (heightRatio > widthRatio)
			//				{
			//					opts.inSampleSize = heightRatio;
			//				} else {
			//					opts.inSampleSize = widthRatio;
			//				}
			//			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//		int width=100;
		//		int height=100;

		try{
			InputStream istr = assetManager.open(strName);
			System.out.println(istr+" << is "+strName);
			// bitmap  = BitmapFactory.decodeStream(istr,null,opts);
			try {
				if(bitmaps.size() > 50){
					clenaUp();
				}

				//				if(bitmaps1.get(strName) == null){
				bitmap  = BitmapFactory.decodeStream(istr,null,opts);


				int resH = bitmap.getHeight();
				int resW = bitmap.getWidth();

				System.out.println(""+resH+"..."+resW);
				//					bitmaps1.put(strName, bitmap);
				//				}else{
				//					System.out.println("already exist "+strName);
				//					bitmap  =  bitmaps1.get(strName);
				//				} 
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//			bitmap  = BitmapFactory.decodeStream(istr,null,opts);
			try{
				istr.close();
			}catch (Throwable e) {
			}
		}catch (Throwable e) {
		}
		return bitmap;
	}

	public static Bitmap getBitmapFromDirectSDCard(Context cntex, String strName,float height,float width)  
	{
		//		AssetManager assetManager = cntex.getAssets();
		String filePath	=	Environment.getExternalStorageDirectory().getPath()+"/"+MyUIApplication.mainDirectoryName+"/"+strName;
		BitmapFactory.Options opts=new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, opts);

		opts.inSampleSize = calculateInSampleSize(opts, (int) width,(int) height);

		opts.inJustDecodeBounds	=	false;

		return BitmapFactory.decodeFile(filePath, opts);
	}

	public static Bitmap getBitmapFromSDCardNotCache(View v,Context cntex, String strName,float height,float width)  
	{

		if(strName.trim().length()>0)
		{
			File f = new File(Environment.getExternalStorageDirectory().getPath()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"UNZIP/ImagePacket/"+strName);
			try {
				if(f.isFile())
				{
					new BitmapWorkerTask(v, f,height,width).execute(0);
				}
				else
				{
					MyUIApplication.LoggerToSD("In Image Processing getBitmapFromSDCardNotCache Method", "Path is a directory. . ."+f.getPath());
				}
			} catch (Exception e) {
				// TODO: handle exception
				MyUIApplication.LoggerToSD("In Image Processing getBitmapFromSDCardNotCache Method", e.getMessage());
			}
		}
		else
		{
			MyUIApplication.LoggerToSD("In Image Processing getBitmapFromSDCardNotCache Method", "No image on this view");
		}

		return null;
	}

	// For Other than ImagePacket
	public static Bitmap getBitmapForOtherNotCache(View v,Context cntex, String strName,float height,float width)  
	{
		if(strName.trim().length()>0)
		{
			File f = new File(Environment.getExternalStorageDirectory().getPath()+"/"+strName);
			try {
				if(f.isFile())
				{
					new BitmapWorkerTask(v, f,height,width).execute(0);
				}
				else
				{
					MyUIApplication.LoggerToSD("In Image Processing getBitmapForOtherNotCache Method", "Path is a directory. . ."+f.getPath());
				}
			} catch (Exception e) {
				// TODO: handle exception
				MyUIApplication.LoggerToSD("In Image Processing getBitmapForOtherNotCache Method", e.getMessage());
			}
		}
		else
		{
			MyUIApplication.LoggerToSD("In Image Processing getBitmapFromSDCardNotCache Method", "No image on this view");
		}
		return null;

	}
	public static Bitmap getBitmapFromAsset1(Context cntex, String strName,float height,float width) 
	{
		AssetManager assetManager = cntex.getAssets();
		Bitmap bitmap = null;
		BitmapFactory.Options opts=new BitmapFactory.Options();
		opts.inPurgeable = true;
		//		int width=100;
		//		int height=100;
		int heightRatio = (int)Math.ceil(opts.outHeight/(float)height);
		int widthRatio = (int)Math.ceil(opts.outWidth/(float)width);

		if (heightRatio > 1 || widthRatio > 1)
		{
			if (heightRatio > widthRatio)
			{
				opts.inSampleSize = heightRatio;
			} else {
				opts.inSampleSize = widthRatio;
			}
		}
		try{
			InputStream istr = assetManager.open(strName);
			System.out.println(istr+" << is "+strName);
			// bitmap  = BitmapFactory.decodeStream(istr,null,opts);
			try {
				/*if(bitmaps.size() > 50){
					clenaUp();
				}*/

				if(bitmaps1.get(strName) == null){
					bitmap  = BitmapFactory.decodeStream(istr,null,opts);
					bitmaps1.put(strName, bitmap);
				}else{
					System.out.println("already exist "+strName);
					bitmap  =  bitmaps1.get(strName);
				} 
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//			bitmap  = BitmapFactory.decodeStream(istr,null,opts);
			try{
				istr.close();
			}catch (Throwable e) {
			}
		}catch (Throwable e) {
		}
		return bitmap;
	}
	////////////////////////////////////////////
	//	Get Bitmap Directly from sdcard
	/////////////////////////////////////////////
	public static Bitmap getBitmapFromSDCard(Context cntex, String strName,float height,float width) 
	{
		Bitmap bitmap = null;
		bitmap	=	BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"UNZIP/ImagePacket/"+strName);
		return bitmap;

	}


	public static Bitmap getBitmapFromAsset2(Context cntex, String strName)
	{
		AssetManager assetManager = cntex.getAssets();
		Bitmap bitmap = null;
		BitmapFactory.Options opts=new BitmapFactory.Options();

		try{
			InputStream istr = assetManager.open(strName);
			System.out.println(istr+" << is "+strName);
			bitmap  = BitmapFactory.decodeStream(istr,null,opts);

			if(bitmaps1.get(strName) == null){
				bitmap  = BitmapFactory.decodeStream(istr,null,opts);
				bitmaps1.put(strName, bitmap);
			}else{
				System.out.println("already exist "+strName);
				bitmap  =  bitmaps1.get(strName);
			} 


			try{
				istr.close();
			}catch (Throwable e) {
			}
		}catch (Throwable e) {
		}


		return bitmap;
	}

	public static void clenaUp()
	{
		try {
			Enumeration<String> keys = bitmaps.keys();
			while (keys.hasMoreElements()) {
				try{
					String string = (String) keys.nextElement();
					Bitmap b =   bitmaps.remove(string);
					System.out.println("Keys are=========="+string+"       value     "+b.toString());
					if(b !=null && !b.isRecycled())
						b.recycle();
					b = null;
				}catch (Throwable e) {
				}
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public static void clenaUp1()
	{
		try {
			Enumeration<String> keys = bitmaps1.keys();
			while (keys.hasMoreElements()) {
				try{
					String string = (String) keys.nextElement();
					Bitmap b =   bitmaps1.remove(string);
					System.out.println("Keys are=========="+string+"       value     "+b.toString());
					if(b !=null && !b.isRecycled())
						b.recycle();
					b = null;
				}catch (Throwable e) {
				}
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void updateRelativeDrawable(Context cntex, final String imgUrl,RelativeLayout rl){
		try{
			Drawable d = Drawable.createFromStream(cntex.getAssets().open(imgUrl), null);
			rl.setBackgroundDrawable(d);
		}catch (Throwable e) {
			System.out.println("excc  "+e);
		}
	}

	public static void unbindDrawables(View view) {
		try{
			if (view.getBackground() != null) {
				view.getBackground().setCallback(null);
			}
			if (view instanceof ViewGroup) {
				for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
					unbindDrawables(((ViewGroup) view).getChildAt(i));
				}
				((ViewGroup) view).removeAllViews();
			}
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
			int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

		// Decode bitmap with inSampleSize set
		//		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	public static int calculateInSampleSize(
			BitmapFactory.Options options, int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}


		//		if (height > reqHeight || width > reqWidth) {
		//
		//			final int halfHeight = height / 2;
		//			final int halfWidth = width / 2;
		//
		//			// Calculate the largest inSampleSize value that is a power of 2 and keeps both
		//			// height and width larger than the requested height and width.
		//			while ((halfHeight / inSampleSize) > reqHeight
		//					&& (halfWidth / inSampleSize) > reqWidth) {
		//				inSampleSize *= 2;
		//			}
		//		}

		return inSampleSize;
	}


	/*	public Bitmap getImage(String path) throws IOThrowable
	{
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(path, options);
		int srcWidth = options.outWidth;
		int srcHeight = options.outHeight;
		int[] newWH =  new int[2];
		newWH[0] = 1024;
		newWH[1] = (1024*srcHeight)/srcWidth;

		int inSampleSize = 1;
		while(srcWidth / 2 > newWH[0]){
			srcWidth /= 2;
			srcHeight /= 2;
			inSampleSize *= 2;
		}
		Bitmap sampledSrcBitmap =null;

		try{
			// Decode with inSampleSize
			options.inJustDecodeBounds = false;
			options.inDither = false;
			options.inSampleSize = inSampleSize;
			options.inScaled = false;
			options.inPreferredConfig = Bitmap.Config.RGB_565;
			if(bitmaps.get(path) == null){
				sampledSrcBitmap = BitmapFactory.decodeFile(path,options);
				if(sampledSrcBitmap != null)
					bitmaps.put(path, sampledSrcBitmap);
			}else{
				System.out.println("already exist "+path);
				if(path != null)
					sampledSrcBitmap  =  bitmaps.get(path);
				if(sampledSrcBitmap.isRecycled())
					sampledSrcBitmap  = BitmapFactory.decodeFile(path,options);

			}

		}catch (Throwable e) {
		}
		return sampledSrcBitmap;
	}*/

	public static Bitmap getImageBitmap(String url) {
		Bitmap bm = null;
		BitmapFactory.Options options = new BitmapFactory.Options();
		//		options.inJustDecodeBounds = true;

		try {
			URL aURL = new URL(url);
			URLConnection conn = aURL.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);


			if(bitmaps.get(url) == null){
				bm = BitmapFactory.decodeStream(bis, null, options);
				if(bm != null)
					bitmaps.put(url, bm);
			}else{
				System.out.println("already exist "+url);
				if(url != null)
					bm  =  bitmaps.get(url);
				if(bm.isRecycled())
					bm  = BitmapFactory.decodeStream(bis,null,options);

			}

			bis.close();
			is.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return bm;
	} 

	/*  public static Bitmap loadBitmap(String url) {
	    Bitmap bitmap = null;
	    InputStream in = null;
	    BufferedOutputStream out = null;

	    try {
	        in = new BufferedInputStream(new URL(url).openStream(), IO_BUFFER_SIZE);

	        final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
	        out = new BufferedOutputStream(dataStream, IO_BUFFER_SIZE);

	        copy(in, out);
	        out.flush();

	        final byte[] data = dataStream.toByteArray();
	        BitmapFactory.Options options = new BitmapFactory.Options();
	        //options.inSampleSize = 1;

	        bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,options);
	    } catch (IOThrowable e) {
	        Log.e("0", "Could not load Bitmap from: " + url);
	    } finally {
	        closeStream(in);
	        closeStream(out);
	    }

	    return bitmap;
	} */
}


class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
	private final WeakReference<View> imageViewReference;
	private int data = 0;
	private File f;
	private float height;
	private float width;
	public BitmapWorkerTask(View imageView,File f,float height,float width) {
		// Use a WeakReference to ensure the ImageView can be garbage collected
		imageViewReference = new WeakReference<View>(imageView);
		this.f = f;
		this.height = height;
		this.width = width;
	}

	// Decode image in background.
	@Override
	protected Bitmap doInBackground(Integer... params) {
		data = params[0];
		try {
			BitmapFactory.Options opts=new BitmapFactory.Options();
			opts.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(f.getAbsolutePath(), opts);
			//			BitmapFactory.decodeStream(f.getAbsolutePath(),null,opts);
			opts.inSampleSize = calculateInSampleSize(opts, (int) width,(int) height);

			opts.inJustDecodeBounds = false;
			//			InputStream istr1=new FileInputStream(f);
			//			Bitmap bitmap  = BitmapFactory.decodeStream(istr1,null,opts);
			Bitmap bitmap  = BitmapFactory.decodeFile(f.getAbsolutePath(), opts);
			//			istr1.close();
			//			System.gc();
			return bitmap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MyUIApplication.LoggerToSD("In Image Processing do in background Method", e.getMessage()+" "+f.getPath());
			return null;
		}
		catch (Throwable e) {
			//											e.printStackTrace();
			System.gc();
			MyUIApplication.LoggerToSD("In Image Processing do in background Method", "In Trowable");
			return null;
		}

	}

	public static int calculateInSampleSize(
			BitmapFactory.Options options, int reqWidth, int reqHeight) {
		// Raw height and width of image
		try {
			final int height = options.outHeight;
			final int width = options.outWidth;
			int inSampleSize = 1;

			if (height > reqHeight || width > reqWidth) {
				//				if (width > height) {
				//					inSampleSize = Math.round((float)height / (float)reqHeight);
				//				} else {
				//					inSampleSize = Math.round((float)width / (float)reqWidth);
				//				}
				final int halfHeight = height / 2;
				final int halfWidth = width / 2;

				// Calculate the largest inSampleSize value that is a power of 2 and keeps both
				// height and width larger than the requested height and width.
				while ((halfHeight / inSampleSize) > reqHeight
						&& (halfWidth / inSampleSize) > reqWidth) {
					inSampleSize *= 2;
				}
			}
			return inSampleSize;
		} catch (Exception e) {
			e.printStackTrace();
			MyUIApplication.LoggerToSD("In Image Processing Scaling Calculation", e.getMessage());
			return 1;
		}
	}

	// Once complete, see if ImageView is still around and set bitmap.
	@Override
	protected void onPostExecute(Bitmap bitmap) {
		try {
			if (imageViewReference != null && bitmap != null) {
				final View imageView = imageViewReference.get();
				if (imageView != null) {
					if(imageView instanceof ImageView)
					{
						((ImageView)imageView).setImageBitmap(bitmap);

						/**Image Scaling logic*/ 
						if(MyUIApplication.imageMode.length()>0){
							if(MyUIApplication.imageMode.equalsIgnoreCase("Crop"))
								((ImageView)imageView).setScaleType(ScaleType.CENTER_CROP);
							else if (MyUIApplication.imageMode.equalsIgnoreCase("Scale")) 
								((ImageView)imageView).setScaleType(ScaleType.FIT_CENTER);
							else if (MyUIApplication.imageMode.equalsIgnoreCase("Stretch")) 
								((ImageView)imageView).setScaleType(ScaleType.FIT_CENTER);
						}

						String tag	=	(String) imageView.getTag();

						/***Implement Crop logic in case of flocker*/
						if(tag != null && tag.equals("flicker")){
							float bmHeight	=	bitmap.getHeight();
							float bmwidth	=	bitmap.getWidth();
							if(bmHeight>bmwidth){
								//Calculate the extra hight that is being croped
								float ratio	= height/width;
								float newBmpHeight	=(ratio*bmwidth);
								float cropedHight	=	(bmHeight - newBmpHeight)/2;

								if(cropedHight<0){
									float ratio1	= width/height;
									float newBmpHeight1	=(ratio1*bmHeight);
									float cropedHight1	=	(bmwidth - newBmpHeight1)/2;
									Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, (int)cropedHight1, 0,(int)(bmwidth -cropedHight1), (int)bmHeight);
									((ImageView)imageView).setImageBitmap(croppedBitmap);
								}else {
									Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, 0, (int)cropedHight, (int)bmwidth, (int)(bmHeight -cropedHight));
									((ImageView)imageView).setImageBitmap(croppedBitmap);
								}

							}else {

								float ratio	= width/height;
								float newBmpHeight	=(ratio*bmHeight);
								float cropedHight	=	(bmwidth - newBmpHeight)/2;
								if(cropedHight<0){
									float ratio1	= height/width;
									float newBmpHeight1	=(ratio1*bmwidth);
									float cropedHight1	=	(bmHeight - newBmpHeight1)/2;
									Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, 0, (int)cropedHight1, (int)bmwidth, (int)(bmHeight -cropedHight1));
									((ImageView)imageView).setImageBitmap(croppedBitmap);
								}else {
									Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, (int)cropedHight, 0,(int)(bmwidth -cropedHight), (int)bmHeight);
									((ImageView)imageView).setImageBitmap(croppedBitmap);
								}

							}
						}

					}
					else
					{
						imageView.setBackgroundDrawable(new BitmapDrawable(bitmap));

						float bmHeight	=	bitmap.getHeight();
						float bmwidth	=	bitmap.getWidth();
						if(bmHeight>bmwidth){
							//Calculate the extra hight that is being croped
							float ratio	= height/width;
							float newBmpHeight	=(ratio*bmwidth);
							float cropedHight	=	(bmHeight - newBmpHeight)/2;

							if(cropedHight<0){
								float ratio1	= width/height;
								float newBmpHeight1	=(ratio1*bmHeight);
								float cropedHight1	=	(bmwidth - newBmpHeight1)/2;
								Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, (int)cropedHight1, 0,(int)(bmwidth -cropedHight1), (int)bmHeight);
								imageView.setBackgroundDrawable(new BitmapDrawable(croppedBitmap));
							}else {
								Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, 0, (int)cropedHight, (int)bmwidth, (int)(bmHeight -cropedHight));
								imageView.setBackgroundDrawable(new BitmapDrawable(croppedBitmap));
							}

						}else {

							float ratio	= width/height;
							float newBmpHeight	=(ratio*bmHeight);
							float cropedHight	=	(bmwidth - newBmpHeight)/2;
							if(cropedHight<0){
								float ratio1	= height/width;
								float newBmpHeight1	=(ratio1*bmwidth);
								float cropedHight1	=	(bmHeight - newBmpHeight1)/2;
								Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, 0, (int)cropedHight1, (int)bmwidth, (int)(bmHeight -cropedHight1));
								imageView.setBackgroundDrawable(new BitmapDrawable(croppedBitmap));
							}else {
								Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, (int)cropedHight, 0,(int)(bmwidth -cropedHight), (int)bmHeight);
								imageView.setBackgroundDrawable(new BitmapDrawable(croppedBitmap));
							}

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			MyUIApplication.LoggerToSD("In Image Processing Post Method", e.getMessage());
		}

	}
}

