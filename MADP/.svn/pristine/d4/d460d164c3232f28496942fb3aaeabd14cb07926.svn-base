package mobi.neuerung.Adapters;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.EventsWrapper;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class FavEventAdapter extends ArrayAdapter<EventsWrapper>
{

	ArrayList<EventsWrapper> array;
	
	Context context;
	
	int resourceId;
	
	public FavEventAdapter(Context context,int textViewResourceId,ArrayList<EventsWrapper> array) {
		super(context,textViewResourceId,array);
		// TODO Auto-generated constructor stub
		
		this.context = context;
		
		this.resourceId = textViewResourceId;
		
		this.array = array;
		
	}
	
	public static class ViewHolder{
		
		public TextView speakerName;
		
		public String speakerId;
		
		public EventsWrapper _obj;
	}
	
	int deviceHeight =0;
	int deviceWidth =0;

	private ViewHolder holder;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
          View v = convertView;
		
          WindowManager windMgr = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
          
          deviceHeight =windMgr.getDefaultDisplay().getHeight();
          deviceWidth =windMgr.getDefaultDisplay().getWidth();
          
		if (v == null) {		
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			v=inflater.inflate(resourceId, null);
			holder = new ViewHolder();
			
			holder.speakerName =(TextView) v.findViewById(R.id.showUpadteCategoryName);
			
			holder.speakerName.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
					determineTextSize(holder.speakerName.getTypeface(),(deviceHeight*.11f)*(.4f)));
			
			holder.speakerName.setPadding((int)(.02f*deviceWidth), (int)(.02f*deviceHeight),(int)(.02f*deviceWidth),(int)(.01f*deviceHeight));
			
			
			v.setTag(holder);
			
		}
		else
		{
			holder=(ViewHolder)v.getTag();
		}
		
		if(array.size()>0)
		{
			holder.speakerName.setText(array.get(position).Title);
			
			holder.speakerId = array.get(position).id;
			
			holder._obj = array.get(position);
			
		}
		return v;
	}

}
