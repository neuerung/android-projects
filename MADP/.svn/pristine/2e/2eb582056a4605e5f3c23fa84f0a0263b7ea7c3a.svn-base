package mobi.neuerung.BGThread;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Util.UtilExhibitorList;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;


public class ExhibitorBgThread extends AsyncTask<Void, Void, Void> {

	private ProgressDialog dialog;
	Context context;
	String id;
	String forParser="";


	public ExhibitorBgThread(Context activity,String id,String forParser)
	{
		context=activity;
		this.id=id;
		dialog = new ProgressDialog(context);
		this.forParser=forParser;
	}
	boolean isrefresh;
	public ExhibitorBgThread(Context activity,String id,String forParser,boolean isrefresh)
	{
		this.isrefresh=isrefresh;
		context=activity;
		this.id=id;
		dialog = new ProgressDialog(context);
		this.forParser=forParser;
	}


	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		try
		{
//			if(context instanceof ExhibitorDetail)
//			{
//				((ExhibitorDetail)(context)).fillListNote();
//				((ExhibitorDetail)(context)).fillListAppointment();
//			}
//			else if(context instanceof ExhibitorDirectory)
//			{
//				if(((ExhibitorDirectory)context).isNeedUpdated)
			
			
					new UtilExhibitorList().fillList(forParser,false,context);
					
					
//			}
//			else if(context instanceof FloorPlan)
//			{
//				((FloorPlan)(context)).fillList();
//			}
//			else if(forParser.equals("JSClass"))
//			{
//				((FloorPlan)(context)).GetDirectionAfterJS();
//			}

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(""+e);
		}

		if (dialog.isShowing()) {
			dialog.dismiss();
		}
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

//		if(context instanceof ExhibitorDirectory)
//		{
//			
//		}
//		else if(forParser.equals(""))
//		{
//			this.dialog.setMessage("Please Wait ..");
//			this.dialog.show();
//			this.dialog.setCancelable(false);
//		}
//		else if(forParser.equals("JSClass"))
//		{
//			
//		}
//	
//		else
//		{
			this.dialog.setMessage("Please Wait ..");
			this.dialog.show();
			this.dialog.setCancelable(false);
//		}
	}

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try
		{
//			if(context instanceof ExhibitorDetail)
//			{
//				MyUIApplication._objMyExhiDB.getMyNotesListFilterByCommpanyName(id);
//				MyUIApplication._objMyExhiDB.getMyAppointmentListFilterByCommpanyName(id);
//			}
//			else if(context instanceof ExhibitorDirectory)
//			{
//				((ExhibitorDirectory)context).isNeedUpdated=false;
//				if(!isrefresh)
					MyUIApplication.ExhibitorDirectoryParser(context);
				

//			}
//			else if(context instanceof FloorPlan)
//			{
//				if(forParser.equals("ExhibitoryDirectoryOnResume"))
//				{
//					MyUIApplication._objMyExhiDB.getMyExhiListFilterByAlphabetic();
//				}
//				else
//				{
//					MyUIApplication.ExhibitorDirectoryParserCalling(context);
//					MyUIApplication._objMyExhiDB.getMyExhiListFilterByAlphabetic();
//				}
//			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}



}