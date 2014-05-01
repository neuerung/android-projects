package mobi.neuerung.Adapters;

import java.util.ArrayList;

import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.Message;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * AwesomeAdapter is a Custom class to implement custom row in ListView
 * 
 * @author Adil Soomro
 *
 */
public class AwesomeAdapter extends BaseAdapter{
	private Context mContext;
	private ArrayList<Message> mMessages;



	public AwesomeAdapter(Context context, ArrayList<Message> messages) {
		super();
		this.mContext = context;
		this.mMessages = messages;
	}
	public int getCount() {
		return mMessages.size();
	}
	
	public Object getItem(int position) {		
		return mMessages.get(position);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		Message message = (Message) this.getItem(position);

		ViewHolder holder; 
		if(convertView == null)
		{
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.sms_row, parent, false);
			holder.message = (TextView) convertView.findViewById(R.id.message_text);
			holder.message_date = (TextView) convertView.findViewById(R.id.message_date);
			convertView.setTag(holder);
		}
		else
			holder = (ViewHolder) convertView.getTag();
		
		holder.message.setText(message.getMessage());
		holder.message_date.setText(message.getDate());
		
		LayoutParams lp = (LayoutParams) holder.message.getLayoutParams();
		LayoutParams params_message_date = (LayoutParams) holder.message_date.getLayoutParams();
		//check if it is a status message then remove background, and change text color.
		if(message.isStatusMessage())
		{
			holder.message.setBackgroundDrawable(null);
			lp.gravity = Gravity.LEFT;
			holder.message.setTextColor(Color.BLACK);
		}
		else
		{		
			//Check whether message is mine to show green background and align to right
			if(message.isMine())
			{
				holder.message.setBackgroundResource(R.drawable.speech_bubble_green);
				lp.gravity = Gravity.RIGHT;
				params_message_date.gravity = Gravity.RIGHT;
			}
			//If not mine then it is from sender to show orange background and align to left
			else
			{
				holder.message.setBackgroundResource(R.drawable.speech_bubble_orange);
				lp.gravity = Gravity.LEFT;
				params_message_date.gravity = Gravity.LEFT;
			}
			holder.message.setLayoutParams(lp);
			holder.message_date.setLayoutParams(params_message_date);
			holder.message.setTextColor(Color.BLACK);	
			holder.message_date.setTextColor(Color.BLACK);	
		}
		return convertView;
	}
	private static class ViewHolder
	{
		TextView message;
		TextView message_date;
	}

	
	public long getItemId(int position) {
		//Unimplemented, because we aren't using Sqlite.
		return 0;
	}

}
