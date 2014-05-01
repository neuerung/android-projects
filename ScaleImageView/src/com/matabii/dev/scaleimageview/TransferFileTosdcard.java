package com.matabii.dev.scaleimageview;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class TransferFileTosdcard {

	Context context;
	public TransferFileTosdcard(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public void fromRawTosdcard() {
		// TODO Auto-generated method stub
		try {

			File sdEMPF = new File(Environment.getExternalStorageDirectory(), "VikasTesting");

			if(sdEMPF.mkdirs())
			{
				Log.i("sdSignature Dir Created","Signature Dir Created");
				
				InputStream in = context.getResources().openRawResource(R.raw.arrow);
				FileOutputStream out = new FileOutputStream(sdEMPF);
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


			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
