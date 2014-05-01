package mobi.neuerung.unzip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

import android.content.Context;
import android.util.Log;

public class NewUnZip {
	public NewUnZip(Context context)
	{
		
	}
	public void unzip(String zipPath,String unzipPath)
	{
		try{
			
				String inFilename = zipPath;
				Log.i(" NewUnZip ","Opening the gzip file.......................... :  opened");
				GZIPInputStream gzipInputStream = null;
				gzipInputStream = new GZIPInputStream(new FileInputStream(inFilename));
				Log.i(" NewUnZip ","Opening the output file............. : opened");
				String outFilename = unzipPath;
				OutputStream out = new FileOutputStream(outFilename);
				Log.i(" NewUnZip ","Trsansferring bytes from the compressed file to the output file........:  Transfer successful");
				byte[] buf = new byte[1024];  //size can be changed according to programmer's need.
				int len;
				while ((len = gzipInputStream.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				Log.i(" NewUnZip ","The file and stream is ......closing.......... : closed"); 
				gzipInputStream.close();
				out.close();
			
		}
		catch(IOException e){
			Log.i(" NewUnZip ","Exception has been thrown" + e);
		}
	}
	
}
