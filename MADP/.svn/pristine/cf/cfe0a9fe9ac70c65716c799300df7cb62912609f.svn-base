package mobi.neuerung.Adapters;

import java.util.ArrayList;
import java.util.List;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.MADP.Splash;
import mobi.neuerung.MADP.Splash0;
import mobi.neuerung.Wrapper.SplashOWrapper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class ClientEventAdapter extends ArrayAdapter<String> {

	Context context;
	int textViewResourceId;
	ArrayList<String> array;

	int deviceHeight =0;
	int deviceWidth =0;

	private ViewHolder holder;

	public ClientEventAdapter(Context context, int textViewResourceId,ArrayList<String> array) {
		super(context, textViewResourceId,array);
		// TODO Auto-generated constructor stub

		this.context = context;
		this.textViewResourceId = textViewResourceId;
		this.array = array;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		View v = convertView;

		WindowManager windMgr = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

		deviceHeight =windMgr.getDefaultDisplay().getHeight();
		deviceWidth =windMgr.getDefaultDisplay().getWidth();

		if (v == null) 
		{		
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			v=inflater.inflate(textViewResourceId, null);

			holder = new ViewHolder();

			holder.clienteventimage =(ImageView) v.findViewById(R.id.clienteventimage);
			holder.clienteventtext =(TextView) v.findViewById(R.id.clienteventtext);
			holder.clienteventtext.setTypeface(MyUIApplication.fontStyle);
			holder.clienteventtext.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
					determineTextSize(holder.clienteventtext.getTypeface(),(deviceHeight*.11f)*(.35f)));

			holder.clienteventtext.setPadding((int)(.02f*deviceWidth), (int)(.02f*deviceHeight),(int)(.02f*deviceWidth),(int)(.02f*deviceHeight));

			LinearLayout.LayoutParams params_clienteventimage =(LinearLayout.LayoutParams) holder.clienteventimage.getLayoutParams();
			params_clienteventimage.width =(int)(.1f*deviceHeight);
			params_clienteventimage.height =(int)(.1f*deviceHeight);
			params_clienteventimage.leftMargin =(int)(.02f*deviceWidth);
			holder.clienteventimage.setLayoutParams(params_clienteventimage);
			try {
				holder.clienteventimage.setImageBitmap(null);
				holder.clienteventimage.setBackgroundDrawable(null);
			} catch (Exception e) {
				// TODO: handle exception
			}
			v.setTag(holder);
		}
		else
		{
			holder=(ViewHolder)v.getTag();
		}

		if(array.size()>0)
		{
			holder.clienteventimage.setImageBitmap(null);
			holder.clienteventimage.setBackgroundDrawable(null);
			holder.clienteventtext.setText(array.get(position));
			holder.clienteventtext.setBackgroundDrawable(null);

			Bitmap bmp =ImageUtil.setBgFromSDCardForOtherDirectoy(holder.clienteventimage, context,MyUIApplication.mainDirectoryName+"/ClientEventLogo/"+array.get(position), (int)(.1f*deviceHeight), (int)(.1f*deviceHeight));

			if(bmp != null)
			{
				holder.clienteventimage.setImageBitmap(bmp);
				holder.clienteventimage.setBackgroundDrawable(null);
			}
			else
			{
				holder.clienteventimage.setImageBitmap(null);
				holder.clienteventimage.setBackgroundDrawable(null);
			}
		}

		v.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				try {

					if(event.getAction() == MotionEvent.ACTION_DOWN)
					{
						v.setBackgroundColor(Color.parseColor("#cacaca"));
						holder.clienteventimage.setBackgroundDrawable(null);

						return false;
					}
					else
						if(event.getAction() == MotionEvent.ACTION_UP)
						{
							v.setBackgroundColor(Color.WHITE);	
						}
						else
							if(event.getAction() == MotionEvent.ACTION_CANCEL)
							{
								v.setBackgroundColor(Color.WHITE);	
							}
				} catch (Exception e) {
					// TODO: handle exception
				}

				return false;
			}
		});

		v.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				ViewHolder holder = (ViewHolder) v.getTag();

				if(context instanceof Splash0)
				{//OnClick on Client Code, As Splash0 Show Client Code only
					Intent i = new Intent(context, Splash.class);
					i.putExtra("Client",holder.clienteventtext.getText().toString());
					MyUIApplication.EventList = new ArrayList<SplashOWrapper>();
					context.startActivity(i);
					((Activity)context).overridePendingTransition( R.anim.slide_in_left, R.anim.noanim );
				}
				else if(context instanceof Splash)
				{//OnClick on Event Code, As Splash Show Client Code only
					
					//KD_15022014
//					try {
//						((Splash)context).hideListClick.setVisibility(View.VISIBLE);
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
					((Splash)context).fromClientScreen(holder.clienteventtext.getText().toString());
				}
			}
		});

		return v;
	}


	public static class ViewHolder
	{
		ImageView clienteventimage;
		TextView clienteventtext;
	}


	List<String> filtered;
	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return new Filter() {
			@SuppressWarnings("unchecked")
			@Override
			protected void publishResults(CharSequence constraint, FilterResults results) {
				filtered = (ArrayList<String>)results.values;
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
					ArrayList<String> filt = new ArrayList<String>();
					ArrayList<String> lItems = new ArrayList<String>();
					synchronized (this)
					{
						lItems.addAll(array);
					}
					for(int i = 0, l = lItems.size(); i < l; i++)
					{
						String m = lItems.get(i);
						if(m.toLowerCase().contains(constraint))
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
