package mobi.neuerung.BGThread;

import java.io.File;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.MADP.Splash;
import mobi.neuerung.Util.TransferFileTosdcard;
import mobi.neuerung.Util.UtilPictureGalleryGrid;
import mobi.neuerung.unzip.Decompress;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;



public class WebUnZippingParserThread extends AsyncTask<Void, Void, Void> {
	private ProgressDialog dialog;
	Context context;

	String Url="";
	String link="";
	String CategoryCode="";
	String forParser;
	public WebUnZippingParserThread(Context activity,String Url,String forParser,String CategoryCode)
	{
		context=activity;

		this.Url=Url;
		this.forParser=forParser;
		this.CategoryCode=CategoryCode;
		dialog = new ProgressDialog(context);

		if(forParser.equals("PictureGalleryGrid"))
		{
			File sd= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Thumbnails",CategoryCode);
			if(sd.mkdirs())
			{
				Log.i("sdXml Dir Created","sdXml Dir Created");
			}
			else
				Log.i("sdXml Dir already Created","sdXml Dir already Created");			
		}
	}
	public WebUnZippingParserThread(Context context,String link)
	{
		this.context=context;
		dialog = new ProgressDialog(context);
		this.link=link;
		if(context instanceof Splash)
		{
			File sd= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"UNZIP","ImagePacket");
			if(sd.mkdirs())
			{
				Log.i("sdXml Dir Created","sdXml Dir Created");
			}
			else
				Log.i("sdXml Dir already Created","sdXml Dir already Created");			

			File sd1= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"HtmlPages");
			if(sd1.mkdirs())
			{
				Log.i("sdXml Dir Created","sdXml Dir Created");
			}
			else
				Log.i("sdXml Dir already Created","sdXml Dir already Created");			
		}

		if(context instanceof MyUIApplication)
		{
			File sd= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"UNZIP","ImagePacket");
			if(sd.mkdirs())
			{
				Log.i("sdXml Dir Created","sdXml Dir Created");
			}
			else
				Log.i("sdXml Dir already Created","sdXml Dir already Created");			

			File sd1= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"HtmlPages");
			if(sd1.mkdirs())
			{
				Log.i("sdXml Dir Created","sdXml Dir Created");
			}
			else
				Log.i("sdXml Dir already Created","sdXml Dir already Created");			
		}
	}

	//	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub

		super.onPreExecute();

		if(link.equals("loadhardcoded"))
		{
//			this.dialog.setMessage("Transfering files to Sdcard...");
//			//		this.dialog.setMessage("Please Wait Image Packet Zip is unzipping..");
//			this.dialog.setCancelable(false);
//
//			if(context instanceof Splash)
//			{
//				this.dialog.show();
//			}
		}
		else
			if(!(context instanceof MyUIApplication))
			{
				this.dialog.setMessage("Unzipping the image packet");
				//		this.dialog.setMessage("Please Wait Image Packet Zip is unzipping..");
				this.dialog.setCancelable(false);

				if(context instanceof Splash)
				{
					this.dialog.show();
				}
			}
	}
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if(!(context instanceof MyUIApplication))
		{
			if (dialog != null && dialog.isShowing())
			{
				dialog.dismiss();
			}
			if(context instanceof Splash)
			{
				((Splash)context).isimagePacketchage=false;
				MyUIApplication.imageFilePath ="";

				if(link.equals("changeinImagepacket"))
					((Splash)context).fillScreenList();
				if(!(MyUIApplication.isInternetAvailable(context)) && link.equals("loadhardcoded"))
				{
					((Splash)context).fillScreenList();
				}
			}
			else if(forParser.equals("PictureGalleryGrid"))
			{
				new UtilPictureGalleryGrid().fillGrid(context,CategoryCode);
			}
		}
	}

	@Override
	protected Void doInBackground(Void... arg0) {
		// TODO Auto-generated method stub
		try
		{

			if(context instanceof MyUIApplication)
			{
				if(link.equals("loadhardcoded"))
				{
					TransferFileTosdcard aa = new TransferFileTosdcard(context);

					aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"ZIPED",R.raw.image,"imagepacket.zip");
					aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"ZIPED",R.raw.htmlpages,"HtmlPages.zip");
					aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"xmls",R.raw.screen,R.string.res_screen_file);


					String zipFile1 = Environment.getExternalStorageDirectory() + "/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"ZIPED/HtmlPages.zip"; 
					String unzipLocation1 = ""+Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"HtmlPages/"; 
					Decompress d1 = new Decompress(zipFile1, unzipLocation1); 
					d1.unzip();
				}
			}

			if(context instanceof Splash)
			{

				if(link.equals("loadhardcoded"))
				{
					TransferFileTosdcard aa = new TransferFileTosdcard(context);

					aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"ZIPED",R.raw.image,"imagepacket.zip");
					aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"ZIPED",R.raw.htmlpages,"HtmlPages.zip");
					aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"xmls",R.raw.screen,R.string.res_screen_file);


					String zipFile1 = Environment.getExternalStorageDirectory() + "/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"ZIPED/HtmlPages.zip"; 
					String unzipLocation1 = ""+Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"HtmlPages/"; 
					Decompress d1 = new Decompress(zipFile1, unzipLocation1); 
					d1.unzip();
				}

				else if(!(link.equals("changeinImagepacket")))
				{
					if(!(((MyUIApplication)MyUIApplication.getContext()).showclientscreen))
					{
						TransferFileTosdcard aa = new TransferFileTosdcard(context);

						aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"ZIPED",R.raw.image,"imagepacket.zip");
						aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"ZIPED",R.raw.htmlpages,"HtmlPages.zip");
						aa.fromRawTosdcard(MyUIApplication.ClientCode,MyUIApplication.EventCode,"xmls",R.raw.screen,R.string.res_screen_file);

						String zipFile1 = Environment.getExternalStorageDirectory() + "/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"ZIPED/HtmlPages.zip"; 
						String unzipLocation1 = ""+Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"HtmlPages/"; 
						Decompress d1 = new Decompress(zipFile1, unzipLocation1); 
						d1.unzip(); 
					}
				}	


				String zipFile = Environment.getExternalStorageDirectory() + "/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"ZIPED/ImagePacket.zip"; 
				String unzipLocation = ""+Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+"UNZIP/ImagePacket/"; 
				Decompress d = new Decompress(zipFile, unzipLocation); 
				d.unzip(); 
			}
			else if(forParser.equals("PictureGalleryGrid"))
			{
				String zipFile = Environment.getExternalStorageDirectory() + "/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Thumbnails/"+CategoryCode+".zip"; 
				String unzipLocation = ""+Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Thumbnails/"+CategoryCode+"/"; 
				Decompress d = new Decompress(zipFile, unzipLocation); 
				d.unzip(); 
			}
		}
		catch(Exception e)
		{
			Log.i("From Dwn n uniz",e.toString());
		}
		return null;
	}
}
