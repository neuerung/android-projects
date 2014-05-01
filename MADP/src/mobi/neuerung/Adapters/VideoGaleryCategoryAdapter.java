package mobi.neuerung.Adapters;

import java.io.File;
import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.VideoGalleryCategoryWrapper;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Environment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;



//**** Home Grid Adapter   *****
public class VideoGaleryCategoryAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	ElementWrapper _objElement;
	ArrayList<VideoGalleryCategoryWrapper> array;
	// Constructor
	public VideoGaleryCategoryAdapter(Context c,ElementWrapper _objElement, ArrayList<VideoGalleryCategoryWrapper> array)
	{
		mContext = c;
		this._objElement =_objElement;
		this.array = array;
		mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() 
	{
		int l =  array.size();
		return l;
	}
	public Object getItem(int position)
	{
		return array.get(position);
	}
	public long getItemId(int position)
	{
		return 0;
	}
	WindowManager mWinMgr;
	int deviceHeight=0;
	int deviceWidth=0;

	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder10 holder;
		WindowManager mWinMgr = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();

		if (convertView == null)
		{
			holder = new ViewHolder10();

			convertView = mInflater.inflate(R.layout.picturecategory, null);
			try
			{
				holder.ButtonGrid = (FrameLayout) convertView.findViewById(R.id.ButtonGrid);
				holder.ButtonGV = (ImageView) convertView.findViewById(R.id.ButtonGV);
				holder.THImage = (ImageView) convertView.findViewById(R.id.THImage);
				holder.GridButtonTV = (TextView) convertView.findViewById(R.id.GridButtonTV);
				
			}
			catch (Exception e)
			{
				System.out.println("Exception in Grid Item's Width Please Define the Width"+e);

				holder.ButtonGrid = (FrameLayout) convertView.findViewById(R.id.ButtonGrid);
				ViewGroup.LayoutParams params_ButtonGrid = holder.ButtonGrid.getLayoutParams();
				int buttonwidth=(int)(.2f*deviceWidth);
				params_ButtonGrid.width=buttonwidth;
				params_ButtonGrid.height=(int)(1.07f*buttonwidth);
				holder.ButtonGrid.setLayoutParams(params_ButtonGrid);

				LinearLayout.LayoutParams marginparam_ButtonGrid =(LinearLayout.LayoutParams) holder.ButtonGrid.getLayoutParams();
				marginparam_ButtonGrid.topMargin = (int)(.025f*deviceHeight);

				holder.ButtonGV = (ImageView) convertView.findViewById(R.id.ButtonGV);
				ViewGroup.LayoutParams params_ButtonGV = holder.ButtonGV.getLayoutParams();
				params_ButtonGV.width=buttonwidth;
				params_ButtonGV.height=(int)(.6f*buttonwidth);
				holder.ButtonGV.setLayoutParams(params_ButtonGV);

				holder.GridButtonTV = (TextView) convertView.findViewById(R.id.GridButtonTV);
				ViewGroup.LayoutParams params_GridButtonTV = holder.GridButtonTV.getLayoutParams();
				params_GridButtonTV.height=(int)(.0725f*deviceHeight);
				holder.GridButtonTV.setLayoutParams(params_GridButtonTV);


			}

			convertView.setTag(holder);
		}
		else 
		{
			holder = (ViewHolder10) convertView.getTag();
		}

		holder.ButtonGrid.setOnTouchListener(new OnTouchListener() 
		{
			public boolean onTouch(View v, MotionEvent event)
			{
				switch(event.getAction()) 
				{

				case MotionEvent.ACTION_DOWN:
					//					holder.THImage.getBackground().setAlpha(150);
					try {
						holder.THImage.setAlpha(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
					return true;
				case MotionEvent.ACTION_UP:
					try {
						holder.THImage.setAlpha(255);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						((Home)mContext).inLayoutAnim();
					} catch (Exception e) {
						// TODO: handle exception
					}


					MyUIApplication.CatagoryCode =array.get(position).CatagoryCode;

					((Home)mContext).OpenHtmlPage(_objElement.OnClick.trim().substring(12),array.get(position).CatagoryCode);
					MyUIApplication.StateMachine.add(_objElement.OnClick.trim().substring(12));

					int i=MyUIApplication.StateMachine.size();
					System.out.println("State Machine Size >>>"+i);

					break;
				case MotionEvent.ACTION_CANCEL:
					try {
						holder.THImage.setAlpha(255);
					} catch (Exception e) {
						// TODO: handle exception
					}
					break;
				}

				return false;
			}

		});


		try {
			int buttonwidth=(int)(deviceWidth* .48);
			int imagewidth=(int)(deviceWidth* .48);
			int imageHeight=(int)(deviceWidth* .48f*.75f);


			LinearLayout.LayoutParams params_ButtonGrid = (LinearLayout.LayoutParams)holder.ButtonGrid.getLayoutParams();
			params_ButtonGrid = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,Gravity.TOP|Gravity.LEFT);
			params_ButtonGrid.width=buttonwidth;
			params_ButtonGrid.height=(int)(1.12f*buttonwidth);
			try {
				float leftmargin = Float.parseFloat(_objElement.leftper.trim());
				leftmargin=leftmargin/100f;
				params_ButtonGrid.leftMargin=(int)(leftmargin*deviceWidth);
			} catch (Exception e) {
				// TODO: handle exception
				params_ButtonGrid.leftMargin=(int)(0.02f*deviceWidth);
			}

			try {
				float rightmargin = Float.parseFloat(_objElement.rightper.trim());
				rightmargin=rightmargin/100f;
				params_ButtonGrid.rightMargin=(int)(rightmargin*deviceWidth);
			} catch (Exception e) {
				// TODO: handle exception
				params_ButtonGrid.rightMargin=(int)(.02f*deviceWidth);
			}

			params_ButtonGrid.rightMargin=(int)(0.02*deviceWidth);
			holder.ButtonGrid.setLayoutParams(params_ButtonGrid);

			LinearLayout.LayoutParams marginparam_ButtonGrid =(LinearLayout.LayoutParams) holder.ButtonGrid.getLayoutParams();
			try {
				float topmargin = Float.parseFloat(_objElement.TopMargin.trim());
				topmargin=topmargin/100f;
				marginparam_ButtonGrid.topMargin = (int)(topmargin*deviceHeight);
			} catch (Exception e) {
				// TODO: handle exception
				marginparam_ButtonGrid.topMargin = (int)(.01f*deviceHeight);
			}




			ViewGroup.LayoutParams params_ButtonGV = holder.ButtonGV.getLayoutParams();
			params_ButtonGV.width=buttonwidth;
			params_ButtonGV.height=(int)(buttonwidth);
			holder.ButtonGV.setLayoutParams(params_ButtonGV);
			holder.ButtonGV.setBackgroundColor(Color.WHITE);




			FrameLayout.LayoutParams params_THImage = (FrameLayout.LayoutParams)holder.THImage.getLayoutParams();
			params_THImage.width=imagewidth;
			params_THImage.height=imageHeight;
			params_THImage.topMargin=(int)(deviceHeight*.025f);
			holder.THImage.setLayoutParams(params_THImage);

			ViewGroup.LayoutParams params_GridButtonTV = holder.GridButtonTV.getLayoutParams();
			params_GridButtonTV.height=(int)(.06f*deviceHeight);
			holder.GridButtonTV.setLayoutParams(params_GridButtonTV);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		


		try {
			Typeface tf = MyUIApplication.fontmap.get(_objElement.fontStyle);
			holder.GridButtonTV.setTypeface(tf);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			holder.GridButtonTV.setTextColor(Color.parseColor(_objElement.fontColor));
			int i = Integer.parseInt(_objElement.fontSize);
			float testsizepercent = i/960f;
			holder.GridButtonTV.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.GridButtonTV.getTypeface(),(testsizepercent*deviceHeight)));
		} catch (Exception e) {
			// TODO: handle exception
			holder.GridButtonTV.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.GridButtonTV.getTypeface(),(0.1f)*(.4f*deviceHeight)));
		}

		try {
			if(_objElement.TitleGravity.equalsIgnoreCase("center"))
				holder.GridButtonTV.setGravity(Gravity.CENTER);
			if(_objElement.TitleGravity.equalsIgnoreCase("right"))
				holder.GridButtonTV.setGravity(Gravity.RIGHT);
			if(_objElement.TitleGravity.equalsIgnoreCase("left"))
				holder.GridButtonTV.setGravity(Gravity.LEFT);
		} catch (Exception e) {
			// TODO: handle exception
			holder.GridButtonTV.setGravity(Gravity.CENTER);
		}





		try
		{

			Double Width2 = (deviceWidth* .4);
			int buttonwidth=(int)(Width2*deviceWidth);
			int imagewidth=(int)(deviceWidth* .25f);
			int imageHeight=(int)(deviceWidth* .25f*.75f);

			try
			{

				String root = Environment.getExternalStorageDirectory().toString();
				String imagepath = MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/VideoGalleryCategory/"+
				array.get(position).Image;
				File myDir = new File(root + "/"+imagepath);
				if(myDir.exists())
				{
					Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(holder.THImage, (Home)mContext,imagepath,(int)(imageHeight),(int)(imagewidth));
					if(bmp != null)
					{
						holder.THImage.setImageBitmap(bmp);
						if(_objElement.ImageMode != null && _objElement.ImageMode.trim().equalsIgnoreCase("crop"))
						{
							holder.THImage.setScaleType(ScaleType.FIT_XY);
						}
						holder.THImage.setBackgroundDrawable(null);
					}
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				String filePath="images/folder.png";
				ImageUtil.setBackgroundBgFromAssetsNotCache(holder.ButtonGV, (Home)mContext,filePath,(int)(buttonwidth*.6f),(int)(buttonwidth));

			}

			String s=array.get(position).VideoCount.trim();
			holder.GridButtonTV.setText(array.get(position).CatagoryName.trim()+" ("+s+")");
//			holder.GridButtonTV.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.GridButtonTV.getTypeface(),(0.3f)*(int)(.1f*deviceHeight)));


		}
		catch (Exception e)
		{

			holder.ButtonGV.setBackgroundResource(R.drawable.ic_launcher);

		}

		// Display planet data
		holder.id = position;
		return convertView;
	}
}

class ViewHolder10 
{
	FrameLayout ButtonGrid;
	ImageView THImage,ButtonGV;
	TextView GridButtonTV;
	int id;

}