package mobi.neuerung.BGThread;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.Splash;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;


public class BGThreadHomePage extends AsyncTask<Void, Void, Void>
{

	private ProgressDialog dialog;
	Context context;

	String url;
	String Name;
	public BGThreadHomePage(Context context,String url, String Name)
	{
		this.context=context;
		this.url=url;
		this.Name=Name;

		dialog = new ProgressDialog(context);
	}
	@Override
	protected void onPostExecute(Void result) 
	{
		super.onPostExecute(result);

		try
		{
			if(context instanceof Splash)
			{
				((Splash)context).StartActivity();
//				((Splash)context).CheckPointForPushNotification(); //KD_100220141840
			}
			if(context instanceof Home)
			{
				if(url.equals("Refresh"))
				{
//					((Home)context).DatachangeAftersync();
				}
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(""+e); 
			e.printStackTrace();
		}


		if (dialog.isShowing()) {
			dialog.dismiss();
		}
	}
	@Override
	protected Void doInBackground(Void... params)
	{

		try
		{
			if(context instanceof Splash)
			{
				// * *	calling first time when syncing is done else it will not call again and again
				MyUIApplication.HomeParser(context, "Local");
			}
			if(context instanceof Home)
			{
				if(url.equals("Refresh"))
				{
					// * *	calling first time when syncing is done else it will not call again and again
					MyUIApplication.HomeParser(context, "Refresh");
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
	protected void onPreExecute()
	{
		super.onPreExecute();

		if(context instanceof Splash)
		{
			this.dialog.setMessage("Rendering the App");
			this.dialog.show();
			this.dialog.setCancelable(false);
		}
	}
}
