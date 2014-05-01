package mobi.neuerung.BGThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;

public class PictureGalleryBG extends AsyncTask<Void,Void,Void> {

	Context context;
	String forparser;
	ProgressDialog dialog;
	public PictureGalleryBG(Context context,String forparser) {
		// TODO Auto-generated constructor stub

		this.context = context;

		this.forparser = forparser;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		dialog = new ProgressDialog(context);
		dialog.setCancelable(false);
		dialog.show();
		if(forparser.equals("PictureGalleryCategory"))
		{
			dialog.setMessage("Getting Picture Category");
		}
		else if(forparser.equals("PictureGalleryGrid"))
		{
			dialog.setMessage("Getting Picture");
		}
		else if(forparser.equals("Download Image"))
		{
			dialog.setMessage("Downloading Image. . .");
		}

	}


	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub

		if(forparser.equals("PictureGalleryCategory"))
		{
			MyUIApplication.PictureGalleryCategoryParser(context);
		}
		else if(forparser.equals("PictureGalleryGrid"))
		{
			MyUIApplication.PictureGalleryGridParser(context,MyUIApplication.CatagoryCode);
		}
		else if(forparser.equals("Download Image"))
		{
			LoadImage(((Home)context)._objUtilPictureGalleryDetail.urlOfImage, ((Home)context)._objUtilPictureGalleryDetail.ImageName, MyUIApplication.CatagoryCode);
		}
		

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		try {
			if(dialog.isShowing())
				dialog.dismiss();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			if(forparser.equals("PictureGalleryCategory"))
			{
				((Home)context)._objUtilPictureGalleryCategory.SetAdapterForCategory(context);
			}
			else if(forparser.equals("PictureGalleryGrid"))
			{
				((Home)context)._objUtilPictureGalleryGrid.fillGrid(context, MyUIApplication.CatagoryCode);
			}
			else if(forparser.equals("Download Image"))
			{
				((Home)context)._objUtilPictureGalleryDetail.loadImage();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
	public Bitmap LoadImage(String url,String imageName,String CategoryCode) {
		try {
			url=url.replaceAll(" ", "%20");
			Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());
			
			String root = Environment.getExternalStorageDirectory().toString();
			File myDir = new File(root + "/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Images/"+CategoryCode);;    
			myDir.mkdirs();
			
			String fname = imageName;
			File file = new File (myDir, fname);
			if (file.exists ()) file.delete (); 
			try {
				FileOutputStream out = new FileOutputStream(file);
				bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
				out.flush();
				out.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return bitmap;
		} catch (Exception e) {
			return null;
		}
	}
	
}
