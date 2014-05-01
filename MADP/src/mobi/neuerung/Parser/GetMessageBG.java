package mobi.neuerung.Parser;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Util.UtilFriendsDetail;
import android.os.AsyncTask;

public class GetMessageBG extends AsyncTask<Void, Void, Void> {

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub

		MyUIApplication.GetMessagesParser();

		return null;
	}


	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		if(UtilFriendsDetail.adapter !=null)
		{
			UtilFriendsDetail.adapter.notifyDataSetChanged();
		}
		
		if(UtilFriendsDetail.chatList !=null)
		{
			if(UtilFriendsDetail.chatList.getAdapter() !=null)
			{
				UtilFriendsDetail.chatList.setSelection(UtilFriendsDetail.chatList.getAdapter().getCount()-1);	
			}
		}
	}

}
