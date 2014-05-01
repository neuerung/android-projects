package mobi.neuerung.BGThread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class getSQliteThread extends AsyncTask<Void, Void, Void> {

	private ProgressDialog dialog;
	Context context;


	public getSQliteThread(Context activity)
	{
		context=activity;

		dialog = new ProgressDialog(context);

	}


	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		if (dialog.isShowing()) {
			dialog.dismiss();
		}
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();


		this.dialog.setMessage("Please Wait ..");
		this.dialog.show();
		this.dialog.setCancelable(false);

	}

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub

		String[] db={"events_mobile_guide_db.sqlite"};
		for(int j=0;j<db.length;j++)
		{
			try
			{
				File f=new File("/data/data/com.ntpl.EMG/databases/"+db[j]);
				FileInputStream fis=null;
				FileOutputStream fos=null;

				try
				{
					fis=new FileInputStream(f);
					fos=new FileOutputStream("/mnt/sdcard/"+db[j]);
					while(true)
					{
						int i=fis.read();
						if(i!=-1)
						{fos.write(i);}
						else
						{break;}
					}
					fos.flush();

				}
				catch(Exception e)
				{
					e.printStackTrace();

				}
				finally
				{
					try
					{
						fos.close();
						fis.close();
					}
					catch(IOException ioe)
					{}
				}

			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}

		return null;
	}



}