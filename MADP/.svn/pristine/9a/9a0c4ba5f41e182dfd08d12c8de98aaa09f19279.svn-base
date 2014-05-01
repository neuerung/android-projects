package mobi.neuerung.Adapters;

import java.util.ArrayList;
import java.util.List;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.SpeakerWrapper;
import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;



public class SpeakerListAdapter extends ArrayAdapter<SpeakerWrapper>
{

	ArrayList<SpeakerWrapper> array;

	Context context;

	int resourceId;

	public SpeakerListAdapter(Context context,int textViewResourceId,ArrayList<SpeakerWrapper> array) {
		super(context,textViewResourceId,array);
		// TODO Auto-generated constructor stub

		this.context = context;

		this.resourceId = textViewResourceId;

		this.array = array;

	}

	public static class ViewHolder{

		public TextView speakerName;

		public String speakerId;
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
			holder.speakerName.setText(array.get(position).name);

			holder.speakerId = array.get(position).id;

		}
		return v;
	}
	 List<SpeakerWrapper> filtered;
	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		 return new Filter() {
	            @SuppressWarnings("unchecked")
	            @Override
	            protected void publishResults(CharSequence constraint, FilterResults results) {
	            	 filtered = (ArrayList<SpeakerWrapper>)results.values;
	                 notifyDataSetChanged();
	                 clear();
	                 for(int i = 0, l = filtered.size(); i < l; i++)
	                     add(filtered.get(i));
	                 notifyDataSetInvalidated();
	            }

	            @Override
	            protected FilterResults performFiltering(CharSequence constraint) {
	                Log.d("", "**** PERFORM FILTERING for: " + constraint);
	                
	                constraint = constraint.toString().toLowerCase();
	                FilterResults result = new FilterResults();
	                if(constraint != null && constraint.toString().length() > 0)
	                {
	                    ArrayList<SpeakerWrapper> filt = new ArrayList<SpeakerWrapper>();
	                    ArrayList<SpeakerWrapper> lItems = new ArrayList<SpeakerWrapper>();
	                    synchronized (this)
	                    {
	                        lItems.addAll(array);
	                    }
	                    for(int i = 0, l = lItems.size(); i < l; i++)
	                    {
	                    	SpeakerWrapper m = lItems.get(i);
	                        if(m.name.toLowerCase().contains(constraint))
	                            filt.add(m);
	                    }
	                    result.count = filt.size();
	                    result.values = filt;
	                }
	                else
	                {
	                    synchronized(this)
	                    {
	                        result.values = array;
	                        result.count = array.size();
	                    }
	                }
	                return result;
	            }
	        };
	}


}
