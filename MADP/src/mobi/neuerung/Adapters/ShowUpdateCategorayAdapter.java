package mobi.neuerung.Adapters;

import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ShowUpdatesCategoryWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class ShowUpdateCategorayAdapter extends ArrayAdapter<ShowUpdatesCategoryWrapper> {

	ArrayList<ShowUpdatesCategoryWrapper> array;

	Context context;

	int resourceId;

	ElementWrapper _objelement;   

	public ShowUpdateCategorayAdapter(Context context,int textViewResourceId,ArrayList<ShowUpdatesCategoryWrapper> array,ElementWrapper _objelement) {
		super(context,textViewResourceId,array);
		// TODO Auto-generated constructor stub

		this.context = context;
		this.resourceId = textViewResourceId;
		this.array = array;
		this._objelement = _objelement;

	}

	public static class ViewHolder{

		public FrameLayout mainll;
		public TextView showUpadteCategoryName;
		public ImageView showUpadteCategoryImage;

		public String categoryCode;
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

			holder.mainll =(FrameLayout) v.findViewById(R.id.mainll);
			holder.showUpadteCategoryName =(TextView) v.findViewById(R.id.showUpadteCategoryName);
			holder.showUpadteCategoryImage =(ImageView) v.findViewById(R.id.showUpadteCategoryImage);

			holder.showUpadteCategoryImage.getLayoutParams().height= (int)(.08f*deviceHeight);
			holder.showUpadteCategoryImage.getLayoutParams().width= (int)(.08f*deviceHeight);




			v.setTag(holder);

		}
		else
		{
			holder=(ViewHolder)v.getTag();
		}

		if(array.size()>0)
		{
			holder.showUpadteCategoryName.setText(array.get(position).CatagoryName);

			holder.categoryCode = array.get(position).CatagoryCode;


			try {
				if(array.get(position).CatagoryCode.equals(MyUIApplication.showUpdateShowTickCategoryCode))
				{
					ImageUtil.setBackgroundBgFromAssetsNotCache(holder.showUpadteCategoryImage, context,"images/tick.png", (int)(.08f*deviceHeight),(int)(.08f*deviceHeight));
				}
				

			} catch (Exception e) {
				// TODO: handle exception
			}

		}



		try {
			Typeface tf = MyUIApplication.fontmap.get(_objelement.fontStyle);
			holder.showUpadteCategoryName.setTypeface(tf);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			holder.showUpadteCategoryName.setTextColor(Color.parseColor(_objelement.fontColor));
			int i = Integer.parseInt(_objelement.fontSize);
			float testsizepercent = i/960f;
			holder.showUpadteCategoryName.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.showUpadteCategoryName.getTypeface(),(testsizepercent*deviceHeight)));
		} catch (Exception e) {
			// TODO: handle exception
			holder.showUpadteCategoryName.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.showUpadteCategoryName.getTypeface(),(0.1f)*(.4f*deviceHeight)));
		}

		try {
			if(_objelement.TitleGravity.equalsIgnoreCase("center"))
				holder.showUpadteCategoryName.setGravity(Gravity.CENTER);
			if(_objelement.TitleGravity.equalsIgnoreCase("right"))
				holder.showUpadteCategoryName.setGravity(Gravity.RIGHT);
			if(_objelement.TitleGravity.equalsIgnoreCase("left"))
				holder.showUpadteCategoryName.setGravity(Gravity.LEFT);
		} catch (Exception e) {
			// TODO: handle exception
			holder.showUpadteCategoryName.setGravity(Gravity.CENTER);
		}

		try {

			float leftMargin = Float.parseFloat(_objelement.leftper.trim());
			float rightMargin = Float.parseFloat(_objelement.rightper.trim());

			leftMargin = leftMargin/100f;
			rightMargin = rightMargin/100f;

			FrameLayout.LayoutParams params_mainll =(FrameLayout.LayoutParams) holder.mainll.getLayoutParams();
			params_mainll.leftMargin =(int)(leftMargin*deviceWidth);
			params_mainll.rightMargin =(int)(rightMargin*deviceWidth);
		} catch (Exception e) {
			// TODO: handle exception
			FrameLayout.LayoutParams params_mainll =(FrameLayout.LayoutParams) holder.mainll.getLayoutParams();
			params_mainll.leftMargin =(int)(.03f*deviceWidth);
			params_mainll.rightMargin =(int)(.03f*deviceWidth);
		}

		try {
			v.setBackgroundColor(Color.parseColor(_objelement.bgcolor.trim()));
		} catch (Exception e) {
			// TODO: handle exception
			v.setBackgroundColor(Color.WHITE);
		}


		v.setOnTouchListener(new OnTouchListener() 
		{
			public boolean onTouch(View v, MotionEvent event)
			{

				try {

				} catch (Exception e) {
					// TODO: handle exception
				}

				switch(event.getAction()) 
				{

				case MotionEvent.ACTION_DOWN:

					try {
						v.setBackgroundColor(Color.parseColor(_objelement.selectedBgcolor.trim()));
					} catch (Exception e) {
						// TODO: handle exception
						v.setBackgroundColor(Color.WHITE);
						System.out.println(""+e);
					}

					return true;
				case MotionEvent.ACTION_UP:

					try {
						v.setBackgroundColor(Color.parseColor(_objelement.bgcolor.trim()));
					} catch (Exception e) {
						// TODO: handle exception
						v.setBackgroundColor(Color.WHITE);
					}

					try {
						String scrrenNumString = _objelement.OnClick.trim().substring(12);
						ShowUpdateCategorayAdapter.ViewHolder holder =(ShowUpdateCategorayAdapter.ViewHolder) v.getTag();
						MyUIApplication.showUpdateCategoryCode = holder.categoryCode;
						MyUIApplication.showUpdateShowTickCategoryCode = holder.categoryCode;
						((Home)context).inLayoutAnim();
						((Home)context).OpenHtmlPage(scrrenNumString,"");
						MyUIApplication.StateMachine.add(scrrenNumString);

					} catch (Exception e) {
						// TODO: handle exception
					}


					break;
				case MotionEvent.ACTION_CANCEL:

					try {
						v.setBackgroundColor(Color.parseColor(_objelement.bgcolor.trim()));
					} catch (Exception e) {
						// TODO: handle exception
						v.setBackgroundColor(Color.WHITE);
					}

					break;
				}

				return false;
			}

		});

		return v;
	}

}
