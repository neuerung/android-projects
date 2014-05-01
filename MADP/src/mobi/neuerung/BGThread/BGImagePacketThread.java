package mobi.neuerung.BGThread;

import java.io.File;
import java.io.FileOutputStream;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.Splash;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

public class BGImagePacketThread extends AsyncTask<Void, Void, Void>
{

	Context context;
	private ProgressDialog dialog;
	String link="";
	String ClassName="";
	String CategoryCode="";
	public BGImagePacketThread(Context context, String url)
	{
		this.link = url;
		this.context = context;
		dialog = new ProgressDialog(context);
		File sd= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode,"ZIPED");
		if(sd.mkdirs())
		{
			Log.i("sdXml Dir Created","sdXml Dir Created");
		}
		else
			Log.i("sdXml Dir already Created","sdXml Dir already Created");	
	}
	
	// This Constructor is for Picture Gallery Grid 
	public BGImagePacketThread(Context context, String url,String ClassName,String CategoryCode)
	{
		this.link = url;
		this.context = context;
		this.ClassName = ClassName;
		this.CategoryCode = CategoryCode;
		dialog = new ProgressDialog(context);
		
		File sd= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid","Thumbnails");
		if(sd.mkdirs())
		{
			Log.i("sdXml Dir Created","sdXml Dir Created");
		}
		else
			Log.i("sdXml Dir already Created","sdXml Dir already Created");	
	}
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		this.dialog.setMessage("Please Wait Image Packet is Downloading ..");
		this.dialog.setCancelable(false);
		if(context instanceof Splash)
		{
			this.dialog.show();
			
		}
		super.onPreExecute();
	}
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try
		{
			if(context instanceof Splash)
			{
				
				link=link.replaceAll(" ","%20");
				HttpGet request = new HttpGet(link);
				HttpParams httpParams = new BasicHttpParams();
				int some_reasonable_timeout = 8000;
				HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
				HttpClient client = new DefaultHttpClient(httpParams);
				
				client.execute(request)
				.getEntity().writeTo(
						new FileOutputStream(new File(Environment
								.getExternalStorageDirectory(),MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"ZIPED/ImagePacket.zip")));
			}
			else if(ClassName.equals("PictureGalleryGrid"))
			{
				link=link.replaceAll(" ", "%20");
				
				HttpGet request = new HttpGet(link);
				HttpParams httpParams = new BasicHttpParams();
				int some_reasonable_timeout = 8000;
				HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
				HttpClient client = new DefaultHttpClient(httpParams);
				
				client.execute(request)
				.getEntity().writeTo(
						new FileOutputStream(new File(Environment
								.getExternalStorageDirectory(),MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Thumbnails/"+CategoryCode+".zip")));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in BGImagePacketThread doInBackground" +e);
		}

		return null;
	}
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		if (dialog.isShowing()) {
			dialog.dismiss();
		}
		try
		{
			if(ClassName.equals("PictureGalleryGrid"))
			{
				new WebUnZippingParserThread(context,link,"PictureGalleryGrid",CategoryCode).execute();
			}
			else if(context instanceof Splash)
			{
				new WebUnZippingParserThread(context,"changeinImagepacket").execute();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		super.onPostExecute(result);
	}
}
