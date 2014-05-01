package mobi.neuerung.Adapters;

import java.io.File;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
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
import android.widget.LinearLayout;
import android.widget.TextView;



//**** Home Grid Adapter   *****
public class PictureGaleryCategoryAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	static String ScreenNumberr;
	ElementWrapper _objElement;
	// Constructor
	public PictureGaleryCategoryAdapter(Context c,String ScreenNumber,ElementWrapper _objElement)
	{
		mContext = c;
		ScreenNumberr = ScreenNumber;
		this._objElement =_objElement;
		mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() 
	{
		int l =  MyUIApplication.PictureGaleryCategoryList.size();
		return l;
	}
	public Object getItem(int position)
	{
		return MyUIApplication.PictureGaleryCategoryList.get(position);
	}
	public long getItemId(int position)
	{
		return 0;
	}
	
	WindowManager mWinMgr;
	int deviceHeight=0;
	int deviceWidth=0;

	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder2 holder;
		WindowManager mWinMgr = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();

		if (convertView == null)
		{
			holder = new ViewHolder2();

			convertView = mInflater.inflate(R.layout.picturecategory, null);
			try
			{
				int buttonwidth=(int)(deviceWidth* .48);
				int imagewidth=(int)(deviceWidth* .48);
				int imageHeight=(int)(deviceWidth* .48f*.75f);

				holder.ButtonGrid = (FrameLayout) convertView.findViewById(R.id.ButtonGrid);
				LinearLayout.LayoutParams params_ButtonGrid = (LinearLayout.LayoutParams)holder.ButtonGrid.getLayoutParams();
				params_ButtonGrid = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,Gravity.TOP|Gravity.LEFT);
				params_ButtonGrid.width=buttonwidth;
				params_ButtonGrid.height=(int)(.9f*buttonwidth);
				params_ButtonGrid.leftMargin=(int)(0.02*deviceWidth);
				params_ButtonGrid.rightMargin=(int)(0.02*deviceWidth);
				holder.ButtonGrid.setLayoutParams(params_ButtonGrid);

				LinearLayout.LayoutParams marginparam_ButtonGrid =(LinearLayout.LayoutParams) holder.ButtonGrid.getLayoutParams();
				marginparam_ButtonGrid.topMargin = (int)(.02f*deviceHeight);


				holder.ButtonGV = (ImageView) convertView.findViewById(R.id.ButtonGV);
				ViewGroup.LayoutParams params_ButtonGV = holder.ButtonGV.getLayoutParams();
				params_ButtonGV.width=buttonwidth;
				params_ButtonGV.height=(int)(.9f*buttonwidth);
				holder.ButtonGV.setLayoutParams(params_ButtonGV);

				holder.THImage = (ImageView) convertView.findViewById(R.id.THImage);
				FrameLayout.LayoutParams params_THImage = (FrameLayout.LayoutParams)holder.THImage.getLayoutParams();
				params_THImage.width=imagewidth;
				params_THImage.height=(int)(.65*.9f*buttonwidth);
				params_THImage.topMargin=(int)(deviceHeight*.025f);
				holder.THImage.setLayoutParams(params_THImage);


				holder.GridButtonTV = (TextView) convertView.findViewById(R.id.GridButtonTV);
				ViewGroup.LayoutParams params_GridButtonTV = holder.GridButtonTV.getLayoutParams();
				params_GridButtonTV.height=(int)(.3*.9f*buttonwidth);
				holder.GridButtonTV.setPadding(0,(int)(.05*.9f*buttonwidth), 0, 0);
				holder.GridButtonTV.setLayoutParams(params_GridButtonTV);
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
				//				marginparam_ButtonGrid.leftMargin = (int)(.025f*deviceWidth);
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
			holder = (ViewHolder2) convertView.getTag();
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
					//		        	holder.GridButtonTV.getBackground().setAlpha(150);
					//					return false;
					return true;
				case MotionEvent.ACTION_UP:
					//					holder.THImage.getBackground().setAlpha(255);
					try {
						holder.THImage.setAlpha(255);
					} catch (Exception e) {
						// TODO: handle exception
					}
					//					String screenNumber=MyUIApplication._objEWList.get(position).OnClick.substring(12);
					//					String mailto=MyUIApplication._objEWList.get(position).mailto;
					//					String body=MyUIApplication._objEWList.get(position).body;
					//					String subject=MyUIApplication._objEWList.get(position).subject;

					//					if(screenNumber.equals("1"))   //  "1" For Mail
					//					{
					//						UtilMail mail = new UtilMail();
					//						mail.OpenMail(mContext ,mailto ,body,subject);
					//					}
					//					else
					//					{
					//					if(((Home)mContext).LLLayout.getVisibility()==View.VISIBLE)
					//					{
					//						((Home)mContext).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_left));
					//						((Home)mContext).LLLayout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_left));
					//					}
					//					if(((Home)mContext).LLLayoutCopy.getVisibility()==View.VISIBLE)
					//					{
					//						((Home)mContext).LLLayout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_left));
					//						((Home)mContext).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_left));
					//					}

					try {
						((Home)mContext).inLayoutAnim();
					} catch (Exception e) {
						// TODO: handle exception
					}


					MyUIApplication.CatagoryCode =MyUIApplication.PictureGaleryCategoryList.get(position).CatagoryCode;
					MyUIApplication.CatagoryName =MyUIApplication.PictureGaleryCategoryList.get(position).CatagoryName;

					//					if(ScreenNumberr.equals("100"))
					//					{
					//						((Home)mContext).OpenHtmlPage("11",MyUIApplication.PictureGaleryCategoryList.get(position).CatagoryCode);
					//						MyUIApplication.StateMachine.add("11");
					//					}
					//					else if(ScreenNumberr.equals("101"))
					//					{
					//						((Home)mContext).OpenHtmlPage("115",MyUIApplication.PictureGaleryCategoryList.get(position).CatagoryCode);
					//						MyUIApplication.StateMachine.add("115");
					//					}


					((Home)mContext).OpenHtmlPage(ScreenNumberr,MyUIApplication.PictureGaleryCategoryList.get(position).CatagoryName);
					MyUIApplication.StateMachine.add(ScreenNumberr);

					int i=MyUIApplication.StateMachine.size();
					System.out.println("State Machine Size >>>"+i);
					//					}

					break;
				case MotionEvent.ACTION_CANCEL:
					//					holder.THImage.getBackground().setAlpha(255);
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
		try
		{

			int buttonwidth=(int)(.48f*deviceWidth);
			int imagewidth=(int)(.48f*deviceWidth);
			//			int imagewidth=(int)(deviceWidth* .25f);
			int imageHeight=(int)(deviceWidth* .48f*.65f);

			try
			{

				String root = Environment.getExternalStorageDirectory().toString();
				String imagepath = MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryCategory/"+
				MyUIApplication.PictureGaleryCategoryList.get(position).Image;
				File myDir = new File(root + "/"+imagepath);
				if(myDir.exists())
				{
					Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(holder.THImage, (Home)mContext,imagepath,(int)(imageHeight),(int)(imagewidth));
					if(bmp != null)
					{
						holder.THImage.setImageBitmap(bmp);
						holder.THImage.setBackgroundDrawable(null);
					}
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				String filePath="images/folder.png";
				ImageUtil.setBackgroundBgFromAssetsNotCache(holder.ButtonGV, (Home)mContext,filePath,(int)(buttonwidth*.6f),(int)(buttonwidth));

			}

			String s=MyUIApplication.PictureGaleryCategoryList.get(position).ImageCount.trim();
			holder.GridButtonTV.setText(MyUIApplication.PictureGaleryCategoryList.get(position).CatagoryName.trim()+" ("+s+")");


		}
		catch (Exception e)
		{


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

		try {
			holder.ButtonGV.setBackgroundColor(Color.parseColor(_objElement.bgcolor));
		} catch (Exception e) {
			// TODO: handle exception
			holder.ButtonGV.setBackgroundColor(Color.WHITE);
		}
		
		// Display planet data
		holder.id = position;
		return convertView;
	}
}

class ViewHolder2
{
	FrameLayout ButtonGrid,TransBtn;
	ImageView THImage,ButtonGV;
	TextView GridButtonTV;
	int id;

}