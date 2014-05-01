package mobi.neuerung.BGThread;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.Splash;
import mobi.neuerung.MADP.Splash0;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;


public class BGXMLSyncThread extends AsyncTask<Void, Void, Void>
{

	private ProgressDialog dialog;
	Context context;

	String url;
	String Name;
	public BGXMLSyncThread(Context context,String url)
	{
		this.context=context;
		this.url=url;

		dialog = new ProgressDialog(context);
	}


	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
		
		if(url.equals("CheckForSync"))
		{
			this.dialog.setMessage("Checking update from Server..");
		}
		else
		{
			this.dialog.setMessage("Please Wait ..");
		}
		this.dialog.show();
		this.dialog.setCancelable(false);
	}

	@Override
	protected Void doInBackground(Void... params)
	{
		try
		{
			if(context instanceof Home)
			{
				if(url.equals("CheckForSync"))
				{
					// * *	calling first time when syncing is done else it will not call again and again
					MyUIApplication.SyncTimeScreenParser(context, url);
				}
			}
			if(context instanceof Splash0)
			{
				if(url.equals("CheckForSync"))
				{
					/****************Check for Client Event List for Client List Screen(Splash0)*/
					MyUIApplication.SyncTimeScreenParser(context, url);
				}
			}
			if(context instanceof Splash)
			{
				if(url.equals("CheckForSync"))
				{
					// * *	calling first time when syncing is done else it will not call again and again
					MyUIApplication.SyncTimeScreenParser(context, url);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(""+e);
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) 
	{
		super.onPostExecute(result);

		try
		{
			if(dialog.isShowing())
				dialog.dismiss();

			if(context instanceof Home)
			{
				if(url.equals("CheckForSync"))
				{
//					((Home)context).FillScreenAfterDownloadFromServer();
				}

			}
			if(context instanceof Splash0)
			{
//				if(url.equals("CheckForSync"))
//				{
//					((Splash0)context).FillScreenAfterDownloadFromServer();
//				}
			}

			if(context instanceof Splash)
			{
				if(url.equals("CheckForSync"))
				{
					//					((Splash)context).FillScreenAfterDownloadFromServer();
					((Splash)context).checkforImagePacket();
				}

			}

		}
		catch (Exception e) {
			// TODO: handle exception
		}


		//		if (dialog.isShowing()) {
		//			dialog.dismiss();
		//		}
	}
}
