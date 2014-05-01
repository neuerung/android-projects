package mobi.neuerung.BGThread;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;


public class BGHTMLThread extends AsyncTask<Void, Void, Void>
{

	private ProgressDialog dialog;
	Context context;

	String Name;
	String PageCode;
	String forparse;
	public BGHTMLThread(Context context, String Name , String PageCode,String forparse)
	{
		this.context=context;
		this.Name=Name;
		this.PageCode=PageCode;
		this.forparse=forparse;

		dialog = new ProgressDialog(context);
	}
	@Override
	protected void onPostExecute(Void result) 
	{
		super.onPostExecute(result);

		try
		{
			if(dialog.isShowing())
				dialog.dismiss();

			if(Name.equals("DownloadHtmlPage"))
			{
				if(forparse.equals("New"))
				{
					((Home)context)._objUtilHtml.SetHtmlPageMethod(MyUIApplication.HTMLScreenFileName, context);
				}
			}

			else if(context instanceof Home)
			{
				if(forparse.equals("New"))
				{
					((Home)context)._objUtilHtml.callOnPost(Name,context);
				} 
				else if(forparse.equals("refresh"))
				{
					if(MyUIApplication.HTMLScreenFilePath.length()>0 && MyUIApplication.HTMLScreenFileName.length()>0)
					{
						new BGHTMLThread(context, "DownloadHtmlPage","","refresh").execute();
					}
				}
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(""+e);
		}


		//		if (dialog.isShowing()) {
		//			dialog.dismiss();
		//		}
	}
	@Override
	protected Void doInBackground(Void... params)
	{

		try
		{
			if(Name.equals("DownloadHtmlPage"))
			{
				((Home)context)._objUtilHtml.DownloadFromUrl(MyUIApplication.HTMLScreenFilePath, MyUIApplication.HTMLScreenFileName+".html");
			}
			else if(context instanceof Home)
			{
				// * *	calling first time when syncing is done else it will not call again and again
				MyUIApplication.SyncTimeHTMLParser(context, Name,PageCode);
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
		if(forparse.equals("New"))
		{
			this.dialog.setMessage("Fetching data from Server..");
			this.dialog.show();
			this.dialog.setCancelable(false);
		}
		
	}
}
