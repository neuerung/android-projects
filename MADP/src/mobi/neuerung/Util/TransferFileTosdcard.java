package mobi.neuerung.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import mobi.neuerung.MADP.MyUIApplication;
import android.R;
import android.content.Context;
import android.os.Environment;

public class TransferFileTosdcard {

	Context context;
	public TransferFileTosdcard(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

//	public void fromRawTosdcard(String clientname,String eventname,int inputFile,String outputfile) {
//		// TODO Auto-generated method stub
//		try {
//
//
//			String root = Environment.getExternalStorageDirectory().toString();
//			
//			File myDir1 = new File(root + "/EventsMobilePlatform/"+clientname+"/"+eventname);    
//			myDir1.mkdirs();
//			
//			File file = new File (myDir1, outputfile);
//
//			InputStream in = context.getResources().openRawResource(inputFile);
//			FileOutputStream out = new FileOutputStream(file);
//			byte[] buff = new byte[1024];
//			int read = 0;
//
//			try {
//				while ((read = in.read(buff)) > 0) {
//					out.write(buff, 0, read);
//				}
//			} finally {
//				in.close();
//
//				out.close();
//			}
//
//
//			//			}
//
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}
	
	

	public void fromRawTosdcard(String clientname,String eventname,String path,int inputFile,String outputfile) {
		// TODO Auto-generated method stub
		try {


			String root = Environment.getExternalStorageDirectory().toString();
			
			File myDir1 = new File(root + "/"+MyUIApplication.mainDirectoryName+"/"+clientname+"/"+eventname+"/"+path);    
			myDir1.mkdirs();
			
			File file = new File (myDir1, outputfile);

			InputStream in = context.getResources().openRawResource(inputFile);
			FileOutputStream out = new FileOutputStream(file);
			byte[] buff = new byte[1024];
			int read = 0;

			try {
				while ((read = in.read(buff)) > 0) {
					out.write(buff, 0, read);
				}
			} finally {
				in.close();

				out.close();
			}


			//			}


		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void fromRawTosdcard(String clientname,String eventname,String path,int inputFile,int outputfile) {
		// TODO Auto-generated method stub
		try {
			
			
			String root = Environment.getExternalStorageDirectory().toString();
			
			File myDir1 = new File(root + "/"+MyUIApplication.mainDirectoryName+"/"+clientname+"/"+eventname+"/"+path);    
			myDir1.mkdirs();
			
			File file = new File (myDir1, context.getResources().getString(outputfile));
			
			InputStream in = context.getResources().openRawResource(inputFile);
			FileOutputStream out = new FileOutputStream(file);
			byte[] buff = new byte[1024];
			int read = 0;
			
			try {
				while ((read = in.read(buff)) > 0) {
					out.write(buff, 0, read);
				}
			} finally {
				in.close();
				
				out.close();
			}
			
		} catch (Exception e) {
			MyUIApplication.LoggerToSD("XML Copying Excetion", "Not able to transer xml file to sd card ** TransferFileTosdcar");
			e.printStackTrace();
		}
		
	}

}
