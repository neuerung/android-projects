package mobi.neuerung.unzip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import android.util.Log;

/** 
 * 
 * @author jon 
 */ 
public class Decompress { 
	private String _zipFile; 
	private String _location; 

	public Decompress(String zipFile, String location) { 
		_zipFile = zipFile; 
		_location = location; 

		_dirChecker(""); 
	} 

	public void unzip() { 
		try  { 


			FileInputStream fin = new FileInputStream(_zipFile); 
			ZipInputStream zin = new ZipInputStream(new BufferedInputStream(fin)); 
			ZipEntry ze = null; 
			while ((ze = zin.getNextEntry()) != null) { 
				Log.v("Decompress", "Unzipping " + ze.getName()); 
				if(ze.getName().equalsIgnoreCase("Kingfisher "))
				{
					System.out.println(""+ze.getName());	
				}
				if(ze.isDirectory()) { 
					_dirChecker(ze.getName()); 
				} else { 
					FileOutputStream fout = new FileOutputStream(_location + ze.getName().trim()); 

					byte b[] = new byte[1024];
					int n;
					while ((n = zin.read(b,0,1024)) >= 0) {
						fout.write(b,0,n);
					}


					zin.closeEntry(); 
					fout.close(); 
				} 

			} 
			zin.close(); 



			//      ZipInputStream in = new ZipInputStream(new FileInputStream(_zipFile));
			//      OutputStream out=null;
			//      // Get the first entry
			//      ZipEntry entry = null;
			//
			//      // Open the output file
			////      String outFilename = "o";
			//      
			//      while ((entry = in.getNextEntry()) != null) {
			//    	  
			//    	  
			//       out = new FileOutputStream(_location + entry.getName());
			//
			//      // Transfer bytes from the ZIP file to the output file
			//      byte[] buf = new byte[1024];
			//      int len;
			//      while ((len = in.read(buf)) > 0) {
			//          out.write(buf, 0, len);
			//      }
			//      }
			//      // Close the streams
			//      out.close();
			//      in.close();
		} catch(Exception e) { 
			Log.e("Decompress", "unzip", e); 
		} 

	} 

	private void _dirChecker(String dir) { 
		File f = new File(_location + dir); 

		if(!f.isDirectory()) { 
			f.mkdirs(); 
		} 
	} 
} 