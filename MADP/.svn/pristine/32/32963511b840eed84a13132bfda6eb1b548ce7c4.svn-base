package mobi.neuerung.Adapters;

import java.io.File;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Util.UtilMail;
import mobi.neuerung.Wrapper.ElementWrapper;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
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
import android.widget.RelativeLayout;
import android.widget.TextView;



//**** Home Grid Adapter   *****
public class VideoGalleryListAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;

	String screenNumber="";
	private ElementWrapper _objEW;
	// Constructor
	public VideoGalleryListAdapter(Context c ,ElementWrapper _objEW)
	{
		mContext = c;
		mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		this._objEW	=	_objEW;
	}

	public int getCount() 
	{
		return MyUIApplication.VideoGalleryList.size();
	}
	public Object getItem(int position)
	{
		return MyUIApplication.VideoGalleryList;
	}
	public long getItemId(int position)
	{
		return 0;
	}
	WindowManager mWinMgr;
	int deviceHeight=0;
	int deviceWidth=0;
	View v = null;
	public View getView(final int position, View convertView, ViewGroup parent) {
//		final ViewHolderVGL holder;
//		WindowManager mWinMgr = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
//		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
//		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();
//		int buttonwidth;
//		if (convertView == null)
//		{
//			holder = new ViewHolderVGL();
//
//			convertView = mInflater.inflate(R.layout.video_gallery_list, null);
//			v = convertView;
//			try
//			{
//
//				holder.ButtonList = (ImageView) convertView.findViewById(R.id.ButtonList);
//				holder.TextListBtn=(TextView)convertView.findViewById(R.id.TextListBtn);
//				holder.TextListBtn1=(TextView)convertView.findViewById(R.id.TextListBtn1);
//				holder.ListButton=(LinearLayout)convertView.findViewById(R.id.ListButton);
//
//
//			}
//			catch (Exception e)
//			{
//				System.out.println("Exception in Grid Item's Width Please Define the Width"+e);
//
//				holder.ButtonList = (ImageView) convertView.findViewById(R.id.ButtonList);
//				ViewGroup.LayoutParams params_ButtonList = holder.ButtonList.getLayoutParams();
//				buttonwidth=(int)(.3f*deviceWidth);
//				params_ButtonList.width=buttonwidth;
//				params_ButtonList.height=buttonwidth;
//				holder.ButtonList.setLayoutParams(params_ButtonList);
//
//				LinearLayout.LayoutParams marginparam_ButtonList =(LinearLayout.LayoutParams) holder.ButtonList.getLayoutParams();
//				marginparam_ButtonList.leftMargin = (int)(.025f*deviceWidth);
//				marginparam_ButtonList.topMargin = (int)(.004f*deviceHeight);
//				marginparam_ButtonList.bottomMargin = (int)(.004f*deviceHeight);
//			}
//
//			convertView.setTag(holder);
//		}
//		else 
//		{
//			holder = (ViewHolderVGL) convertView.getTag();
//		}
//
//
//		try {
//
//			ViewGroup.LayoutParams params_ButtonList = holder.ButtonList.getLayoutParams();
//			params_ButtonList.width=(int)(.08f*((Home)mContext).deviceHeight);
//			params_ButtonList.height=(int)(.08f*((Home)mContext).deviceHeight);
//			holder.ButtonList.setLayoutParams(params_ButtonList);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		try
//		{
//
//			String fileName = MyUIApplication.VideoGalleryList.ImagePath.substring(MyUIApplication.VideoGalleryList.ImagePath.lastIndexOf("/")+1);
//			File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/VideoGalleryList/Images/"+fileName);
//
//
//			if(sdMiddlefileImage.exists())
//			{
//				String filePath=MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/VideoGalleryList/Images/"+fileName;
//				ImageUtil.setBgFromSDCardForOtherDirectoy(holder.ButtonList, (Home)mContext,filePath,(int)(.08f*((Home)mContext).deviceHeight),(int)(.08f*((Home)mContext).deviceHeight));
//			}
//			else 
//			{
//				String filePath="images/"+MyUIApplication._objEW.Bitmap;
//				ImageUtil.setBackgroundBgFromAssetsNotCache(holder.ButtonList, (Home)mContext,filePath,(int)(.08f*((Home)mContext).deviceHeight),(int)(.08f*((Home)mContext).deviceHeight));
//			}
//
//			try {
//				screenNumber = MyUIApplication._objEW.OnClick.trim().substring(12);
//			} catch (Exception e) {
//				// TODO: handle exception
//				screenNumber ="";
//			}
//
//			v.setOnTouchListener(new OnTouchListener() 
//			{
//				public boolean onTouch(View v, MotionEvent event)
//				{
//					switch(event.getAction()) 
//					{
//
//					case MotionEvent.ACTION_DOWN:
//						try {
//							v.setBackgroundColor(Color.parseColor(MyUIApplication._objEW.selectedBgcolor.trim()));
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//
//						return true;
//					case MotionEvent.ACTION_UP:
//						try {
//							v.setBackgroundColor(Color.parseColor(MyUIApplication._objEW.bgcolor.trim()));
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//						try {
//
//
//							boolean b = MyUIApplication.Copy;
//							MyUIApplication._objVideoGalleryListWrapper =  MyUIApplication.VideoGalleryList;
//							String  s = MyUIApplication.VideoGalleryList.VideoUrl;
//							((Home)mContext).inLayoutAnim();
//							((Home)mContext).OpenHtmlPage(screenNumber,MyUIApplication.VideoGalleryList.VideoUrl);
//							MyUIApplication.StateMachine.add(screenNumber);
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//
//						break;
//					case MotionEvent.ACTION_CANCEL:
//						try {
//							v.setBackgroundColor(Color.parseColor(MyUIApplication._objEW.bgcolor.trim()));
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//						break;
//					}
//
//					return false;
//				}
//
//			});
//
//			holder.TextListBtn.setText(MyUIApplication.VideoGalleryList.Title);
//			holder.TextListBtn1.setText(MyUIApplication.VideoGalleryList.Description);
//			try {
//				v.setBackgroundColor(Color.parseColor(MyUIApplication._objEW.bgcolor.trim()));
//			} catch (Exception e) {
//				// TODO: handle exception
//				v.setBackgroundColor(Color.WHITE);
//			}
//
//
//			try {
//				int deviceHeight = ((Home)mContext).deviceHeight;
//				int deviceWidth = ((Home)mContext).deviceWidth;
//
//
//
//
//				try {
//					if(MyUIApplication._objEW.TitleGravity.equalsIgnoreCase("center"))
//						holder.TextListBtn.setGravity(Gravity.CENTER);
//					if(MyUIApplication._objEW.TitleGravity.equalsIgnoreCase("right"))
//						holder.TextListBtn.setGravity(Gravity.RIGHT);
//					if(MyUIApplication._objEW.TitleGravity.equalsIgnoreCase("left"))
//						holder.TextListBtn.setGravity(Gravity.LEFT);
//				} catch (Exception e) {
//					// TODO: handle exception
//					holder.TextListBtn.setGravity(Gravity.CENTER);
//				}
//
//				try {
//					if(MyUIApplication._objEW.SubTitleGravity.equalsIgnoreCase("center"))
//						holder.TextListBtn1.setGravity(Gravity.CENTER);
//					if(MyUIApplication._objEW.SubTitleGravity.equalsIgnoreCase("right"))
//						holder.TextListBtn1.setGravity(Gravity.RIGHT);
//					if(MyUIApplication._objEW.SubTitleGravity.equalsIgnoreCase("left"))
//						holder.TextListBtn1.setGravity(Gravity.LEFT);
//				} catch (Exception e) {
//					// TODO: handle exception
//					holder.TextListBtn1.setGravity(Gravity.CENTER);
//				}
//
//
//
//				try {
//					Typeface tf = MyUIApplication.fontmap.get(MyUIApplication._objEW.fontStyle);
//					holder.TextListBtn.setTypeface(tf);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				try {
//					Typeface tf = MyUIApplication.fontmap.get(MyUIApplication._objEW.subtitlefontStyle);
//					holder.TextListBtn1.setTypeface(tf);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//				try {
//					holder.TextListBtn.setTextColor(Color.parseColor(MyUIApplication._objEW.fontColor));
//				} catch (Exception e) {
//					// TODO: handle exception
//					holder.TextListBtn.setTextColor(Color.BLACK);
//				}
//
//				try {
//					holder.TextListBtn1.setTextColor(Color.parseColor(MyUIApplication._objEW.subtitlefontColor));
//				} catch (Exception e) {
//					// TODO: handle exception
//					holder.TextListBtn1.setTextColor(Color.BLACK);
//				}
//
//				try {
//					int i = Integer.parseInt(MyUIApplication._objEW.fontSize);
//					float testsizepercent = i/960f;
//					holder.TextListBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(testsizepercent*deviceHeight)));	
//				} catch (Exception e) {
//					// TODO: handle exception
//					holder.TextListBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(0.1f)*(.4f*deviceHeight)));
//				}
//
//				try {
//					int i = Integer.parseInt(MyUIApplication._objEW.subtitlefontSize);
//					float testsizepercent = i/960f;
//					holder.TextListBtn1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(testsizepercent*deviceHeight)));	
//				} catch (Exception e) {
//					// TODO: handle exception
//					holder.TextListBtn1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(0.1f)*(.3f*deviceHeight)));
//				}
//
//
//				try {
//					LinearLayout.LayoutParams params_ListButton = (LinearLayout.LayoutParams) holder.ListButton.getLayoutParams();
//					float leftmargin = Float.parseFloat(MyUIApplication._objEW.leftper.trim());
//					leftmargin =leftmargin/100f;
//					params_ListButton.leftMargin = (int)(leftmargin*deviceWidth);
//				} catch (Exception e) {
//					MyUIApplication.LoggerToSD("Video Gallery List", "left Margin Error");
//					e.printStackTrace();
//				}
//
//				try {
//					LinearLayout.LayoutParams params_ListButton = (LinearLayout.LayoutParams) holder.ListButton.getLayoutParams();
//					float rightmargin = Float.parseFloat(MyUIApplication._objEW.rightper.trim());
//					rightmargin =rightmargin/100f;
//					params_ListButton.leftMargin = (int)(rightmargin*deviceWidth);
//				} catch (Exception e) {
//					MyUIApplication.LoggerToSD("Video Gallery List", "Right Margin Error");
//					e.printStackTrace();
//				}
//
//
//
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//
//		}
//
//
//
//		catch (Exception e)
//		{
//			holder.ButtonList.setBackgroundResource(R.drawable.ic_launcher);
//
//		}
//
//		// Display planet data
//		holder.id = position;
//		return convertView;
		

		final ViewHolderList holder;
		WindowManager mWinMgr = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();
		int buttonwidth,ArrowWidth;
		if (convertView == null)
		{
			holder = new ViewHolderList();

			convertView = mInflater.inflate(R.layout.listview01xml, null);
			try
			{
				Double RowHeight = Double.parseDouble(_objEW.height)/100;
				convertView.setMinimumHeight((int)(RowHeight*deviceHeight));


//				ElementWrapper _objWrapper = _objEW;


				holder.MainLL = (RelativeLayout)convertView.findViewById(R.id.MainLL);
				holder.ListButton=(LinearLayout)convertView.findViewById(R.id.ListButton);
				if(_objEW.bgcolor.length()>0)
				{
					try {
						holder.ListButton.setBackgroundColor(Color.parseColor(_objEW.bgcolor));
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				else
				{
					try {
						holder.ListButton.setBackgroundColor(Color.TRANSPARENT);
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				LinearLayout.LayoutParams params_MainLL = (LinearLayout.LayoutParams)holder.MainLL.getLayoutParams();
				params_MainLL.height = (int)((Double.parseDouble(_objEW.height)/100)*deviceHeight);
				holder.MainLL.setLayoutParams(params_MainLL);

				if(_objEW.leftper.length()>0)
				{
					holder.Frm1 = (FrameLayout)convertView.findViewById(R.id.Frm1);
					RelativeLayout.LayoutParams params_Frm1 = (RelativeLayout.LayoutParams)holder.Frm1.getLayoutParams();
					params_Frm1.width = (int)((Double.parseDouble(_objEW.leftper)/100)*deviceWidth);
					holder.Frm1.setLayoutParams(params_Frm1);
				}
				if(_objEW.middleper.length()>0)
				{
					holder.Frm2 = (LinearLayout)convertView.findViewById(R.id.Frm2);
					RelativeLayout.LayoutParams params_Frm2 = (RelativeLayout.LayoutParams)holder.Frm2.getLayoutParams();
					params_Frm2.width = (int)((Double.parseDouble(_objEW.middleper )/100)*deviceWidth);
					holder.Frm2.setLayoutParams(params_Frm2);
				}
				if(_objEW.rightper.length()>0)
				{
					holder.Frm3 = (FrameLayout)convertView.findViewById(R.id.Frm3);
					RelativeLayout.LayoutParams params_Frm3 = (RelativeLayout.LayoutParams)holder.Frm3.getLayoutParams();
					params_Frm3.width = (int)((Double.parseDouble(_objEW.rightper)/100)*deviceWidth);
					holder.Frm3.setLayoutParams(params_Frm3);
				}


				{
					Double Width2 = Double.parseDouble(_objEW.leftper)/100;

					holder.ButtonList = (ImageView) convertView.findViewById(R.id.ButtonList);

					FrameLayout.LayoutParams params_ButtonList = (FrameLayout.LayoutParams)holder.ButtonList.getLayoutParams();
					params_ButtonList = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER_VERTICAL);
					buttonwidth=(int)(Width2*deviceWidth*.96f);

					try {
						Float leftscalefactor = Float.parseFloat(_objEW.leftscalefactor);
						Float aa = buttonwidth*leftscalefactor;
						buttonwidth = Math.round(aa) ;
					} catch (Exception e) {
						// TODO: handle exception
					}

					params_ButtonList.width=buttonwidth;
					try {
						params_ButtonList.height= (int)(((Double.parseDouble(_objEW.height)/100)*deviceHeight)-(.01f*deviceHeight));
					} catch (Exception e) {
						// TODO: handle exception
						params_ButtonList.height=(int)(.795f*buttonwidth);
					}
					params_ButtonList.leftMargin = (int)(.01f*deviceWidth);
					params_ButtonList.rightMargin = (int)(.01f*deviceWidth);
					//				params_ButtonList.topMargin = (int)(.004f*deviceHeight);
					//				params_ButtonList.bottomMargin = (int)(.004f*deviceHeight);
					holder.ButtonList.setLayoutParams(params_ButtonList);
				}

				if(_objEW.rightper.length()>0)
				{
					Double RightWidth = Double.parseDouble(_objEW.rightper)/100;

					holder.Arrow = (ImageView) convertView.findViewById(R.id.Arrow);
					FrameLayout.LayoutParams params_Arrow = (FrameLayout.LayoutParams)holder.Arrow.getLayoutParams();
					params_Arrow = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER_VERTICAL);
					ArrowWidth = (int)(RightWidth*deviceWidth*.96f);

					try {
						Float rightscalefactor = Float.parseFloat(_objEW.rightscalefactor);
						Float aa = ArrowWidth*rightscalefactor;
						ArrowWidth = Math.round(aa) ;
					} catch (Exception e) {
						// TODO: handle exception
					}

					params_Arrow.width = ArrowWidth;;
					try {
						params_Arrow.height= (int)(((Double.parseDouble(_objEW.height)/100)*deviceHeight)-(.01f*deviceHeight));
					} catch (Exception e) {
						// TODO: handle exception
						params_Arrow.height=(int)(.795f*buttonwidth);
					}
					params_Arrow.rightMargin = (int)(.04f*((Home)mContext).deviceWidth);
					params_Arrow.topMargin = (int)(.004f*deviceHeight);
					params_Arrow.bottomMargin = (int)(.004f*deviceHeight);
					holder.Arrow.setLayoutParams(params_Arrow);

				}


				holder.TextListBtn=(TextView)convertView.findViewById(R.id.TextListBtn);


				LinearLayout.LayoutParams marginparam_TextListBtn =(LinearLayout.LayoutParams) holder.TextListBtn.getLayoutParams();
				marginparam_TextListBtn.leftMargin = (int)(.02f*deviceWidth);
				marginparam_TextListBtn.rightMargin = (int)(.02f*deviceWidth);
				holder.TextListBtn.setLayoutParams(marginparam_TextListBtn);

				holder.subtitle=(TextView)convertView.findViewById(R.id.subtitle);



				LinearLayout.LayoutParams marginparam_subtitle =(LinearLayout.LayoutParams) holder.subtitle.getLayoutParams();
				marginparam_subtitle.leftMargin = (int)(.02f*deviceWidth);
				marginparam_subtitle.rightMargin = (int)(.02f*deviceWidth);
				holder.subtitle.setLayoutParams(marginparam_subtitle);
				//				marginparam_TextListBtn.topMargin = (int)(.005f*deviceHeight);


			}
			catch (Exception e)
			{
				System.out.println("Exception in Home List Item's Width Please Define the Width"+e);

				holder.ButtonList = (ImageView) convertView.findViewById(R.id.ButtonList);
				ViewGroup.LayoutParams params_ButtonList = holder.ButtonList.getLayoutParams();
				buttonwidth=(int)(.2f*deviceWidth);
				params_ButtonList.width=buttonwidth;
				params_ButtonList.height=(int)(.795f*buttonwidth);
				holder.ButtonList.setLayoutParams(params_ButtonList);

				FrameLayout.LayoutParams marginparam_ButtonList =(FrameLayout.LayoutParams) holder.ButtonList.getLayoutParams();
				marginparam_ButtonList.leftMargin = (int)(.025f*deviceWidth);
				marginparam_ButtonList.topMargin = (int)(.004f*deviceHeight);
				marginparam_ButtonList.bottomMargin = (int)(.004f*deviceHeight);
			}

			convertView.setTag(holder);
		}
		else 
		{
			holder = (ViewHolderList) convertView.getTag();
		}
		try
		{
//			ElementWrapper _objWrapper = _objEW;

			try {
				holder.subtitle.setMaxLines(Integer.parseInt(_objEW.maxline));
			} catch (Exception e) {
				// TODO: handle exception
				holder.subtitle.setMaxLines(2);
			}
			
//			try {
//				holder.subtitle.setTextColor(Color.parseColor(_objWrapper.subtitlefontColor));
//			} catch (Exception e) {
//				// TODO: handle exception
//				holder.subtitle.setMaxLines(2);
//			}
			
			

			if(_objEW.leftbgColor.length()>0 && _objEW.leftper.length()>0)
			{
				holder.Frm1.setBackgroundColor(Color.parseColor(_objEW.leftbgColor.trim()));
			}
			if(_objEW.midbgColor.length()>0 && _objEW.middleper.length()>0)
			{
				holder.Frm2.setBackgroundColor(Color.parseColor(_objEW.midbgColor.trim()));
			}
			if(_objEW.rightbgColor.length()>0 && _objEW.rightper.length()>0)
			{
				holder.Frm3.setBackgroundColor(Color.parseColor(_objEW.rightbgColor.trim()));
			}

			if(_objEW.leftper.length()>0)
			{
				String Width  = _objEW.leftper;
				Double Width1 = Double.parseDouble(Width);
				Double Width2 = Width1/100;

				buttonwidth=(int)(Width2*deviceWidth*.96f);
				//				int buttonheight=0;
				//				try {
				//					params_ButtonList.height= (int)(((Double.parseDouble(_objWrapper.height)/100)*deviceHeight)-(.01f*deviceHeight));
				//				} catch (Exception e) {
				//					// TODO: handle exception
				//					params_ButtonList.height=(int)(.795f*buttonwidth);
				//				}

//				if(MyUIApplication.IsSdCardImageAvailable(_objEW.left))
//				{
//
//					String filePath=_objEW.left;
//					Bitmap bmp=null;
//					try {
//						bmp = ImageUtil.setBgFromSDCardNotCache(holder.ButtonList, (Home)mContext,filePath,(int)(holder.ButtonList.getHeight()),(int)(buttonwidth));
//					} catch (Exception e) {
//						// TODO: handle exception
//						bmp = ImageUtil.setBgFromSDCardNotCache(holder.ButtonList, (Home)mContext,filePath,(int)(buttonwidth*.795f),(int)(buttonwidth));
//					}
//
//
//
//					if(bmp != null)
//					{
//						holder.ButtonList.setImageBitmap(bmp);
//						holder.ButtonList.setBackgroundDrawable(null);
//					}
//
//				}
//				else 
//				{
//					String filePath="images/"+_objEW.left;
//					Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(holder.ButtonList, (Home)mContext,filePath,(int)(buttonwidth*.795f),(int)(buttonwidth));
//
//					if(bmp != null)
//					{
//						holder.ButtonList.setImageBitmap(bmp);
//						holder.ButtonList.setBackgroundDrawable(null);
//					}
//				}
				
				String fileName = MyUIApplication.VideoGalleryList.get(position).ImagePath.substring(MyUIApplication.VideoGalleryList.get(position).ImagePath.lastIndexOf("/")+1);
				File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/VideoGalleryList/Images/"+fileName);
	
	
				if(sdMiddlefileImage.exists())
				{
					String filePath=MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/VideoGalleryList/Images/"+fileName;
					ImageUtil.setImageDirectFromSdCard(holder.ButtonList, (Home)mContext,filePath,holder.ButtonList.getLayoutParams().height,holder.ButtonList.getLayoutParams().width);
				}
				else 
				{
					String filePath=_objEW.left;
					ImageUtil.setBgFromSDCardNotCache(holder.ButtonList, (Home)mContext,filePath,holder.ButtonList.getLayoutParams().height,holder.ButtonList.getLayoutParams().width);
				}
	
				try {
					screenNumber = _objEW.OnClick.trim().substring(12);
				} catch (Exception e) {
					screenNumber ="";
				}
			}
			
			
			if(_objEW.rightper.length()>0)
			{

				Double RightWidth = Double.parseDouble(_objEW.rightper)/100;
				ArrowWidth=(int)(RightWidth*deviceWidth*.96f);


				if(MyUIApplication.IsSdCardImageAvailable(_objEW.right))
				{
					String filePath=_objEW.right;
					//					Bitmap bmp = ImageUtil.setBgFromSDCardNotCache(holder.Arrow, (Home)mContext,filePath,(int)(ArrowWidth*.795f),(int)(ArrowWidth));

					Bitmap bmp=null;
					try {
						bmp = ImageUtil.setBgFromSDCardNotCache(holder.Arrow, (Home)mContext,filePath,(int)(holder.ButtonList.getHeight()),(int)(ArrowWidth));
					} catch (Exception e) {
						// TODO: handle exception
						bmp = ImageUtil.setBgFromSDCardNotCache(holder.Arrow, (Home)mContext,filePath,(int)(ArrowWidth*.795f),(int)(ArrowWidth));
					}
					if(bmp != null)
					{
						holder.Arrow.setImageBitmap(bmp);
						holder.Arrow.setBackgroundDrawable(null);
					}

				}
				else 
				{
					String filePath="images/"+_objEW.right;
					//				String filePath="arrow";
					//				ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Arrow, (Home)mContext,filePath,(int)((int)(.06f*((Home)mContext).deviceWidth+(.61f*.06f*((Home)mContext).deviceWidth))),(int)(.06f*((Home)mContext).deviceWidth));
					Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Arrow, (Home)mContext,filePath,(int)(ArrowWidth*.795f),(int)(ArrowWidth));

					if(bmp != null)
					{
						holder.Arrow.setImageBitmap(bmp);
						holder.Arrow.setBackgroundDrawable(null);
					}
				}
			}
			//			holder.ListButton.setOnClickListener(new OnClickListener() {
			//
			//				public void onClick(View v)
			//				{
			//					String screenNumber=_objEW.OnClick.substring(12);
			//					System.out.println(""+screenNumber);
			//					
			//					((Home)mContext).OpenHtmlPage(screenNumber);
			//					MyUIApplication.StateMachine.add(screenNumber);
			//					
			//					int i=MyUIApplication.StateMachine.size();
			//					System.out.println("State Machine Size >>>"+i);
			//					if(!screenNumber.equals("-1"))
			//					{
			////						((Home)mContext).StateMachine.add(screenNumber);
			////						((Home)mContext).openButtonClickScreen(_objEW.Title , screenNumber);
			//					}
			//				}
			//				
			//			});

			holder.ListButton.setOnTouchListener(new OnTouchListener() 
			{
				public boolean onTouch(View v, MotionEvent event)
				{
					switch(event.getAction()) 
					{

					case MotionEvent.ACTION_DOWN:

						try {
							String selbg = _objEW.selectedBgcolor;
							v.setBackgroundColor(Color.parseColor(selbg));

							//							if(_objWrap.leftbgColor.length()>0 && _objWrap.leftper.length()>0)
							//							{
							holder.Frm1.setBackgroundDrawable(null);
							//							}
							//							if(_objWrap.midbgColor.length()>0 && _objWrap.middleper.length()>0)
							//							{
							holder.Frm2.setBackgroundDrawable(null);
							//							}
							//							if(_objWrap.rightbgColor.length()>0 && _objWrap.rightper.length()>0)
							//							{
							holder.Frm3.setBackgroundDrawable(null);
							//							}


						} catch (Exception e) {
							// TODO: handle exception
						}

						//						holder.ListButton.getBackground().setAlpha(150);
						//			        	holder.GridButtonTV.getBackground().setAlpha(150);
						//						return false;
						return true;
					case MotionEvent.ACTION_UP:
						//						holder.ListButton.getBackground().setAlpha(255);
						//			        	holder.GridButtonTV.getBackground().setAlpha(255);


						ElementWrapper _objWrap = _objEW;

						try {
							String color =  _objWrap.bgcolor;
							if(color.length()>0)
							{
								v.setBackgroundColor(Color.parseColor(color));
							}else
							{
								v.setBackgroundColor(Color.TRANSPARENT);
							}

							if(_objWrap.leftbgColor.length()>0 && _objWrap.leftper.length()>0)
							{
								holder.Frm1.setBackgroundColor(Color.parseColor(_objWrap.leftbgColor.trim()));
							}
							if(_objWrap.midbgColor.length()>0 && _objWrap.middleper.length()>0)
							{
								holder.Frm2.setBackgroundColor(Color.parseColor(_objWrap.midbgColor.trim()));
							}
							if(_objWrap.rightbgColor.length()>0 && _objWrap.rightper.length()>0)
							{
								holder.Frm3.setBackgroundColor(Color.parseColor(_objWrap.rightbgColor.trim()));
							}

						} catch (Exception e) {
							// TODO: handle exception
						}

						if(_objWrap.OnClick.length()>0)
						{
							String screenNumber=_objEW.OnClick.substring(12);

							try {

								if(screenNumber.equals("1"))    //  "1" For Mail
								{

									String mailto=_objEW.mailto;
									String body=_objEW.body;
									String subject=_objEW.subject;
									String cc=_objEW.cc;
									String bcc=_objEW.bcc;

									UtilMail mail = new UtilMail();
									mail.OpenMail(mContext ,mailto,cc,bcc,body,subject);
								}
							} catch (Exception e) {
								// TODO: handle exception
							}


							if(MyUIApplication.ScreenNumbers.contains(screenNumber))
							{


								((Home)mContext).inLayoutAnim();


								System.out.println(""+screenNumber);


								if(_objEW !=null && _objEW.Code.length()>0)
								{
									if(_objEW.Code.equals("P103") || _objEW.Code.equals("P104") || _objEW.Code.equals("P102") || _objEW.Code.equals("P108"))
									{
										//										String aa[] = _objEW.Title.split(" ");
										//										if(aa.length>=2)
										v.setEnabled(false);
										((Home)mContext).OpenHtmlPage(screenNumber,_objEW.Code+"##"+_objEW.Title);
									}
									//									else if(_objEW.Code.equals("P104"))
									//									{
									//										((Home)mContext).OpenHtmlPage(screenNumber,_objEW.Title);
									//									}
									else
									{
										MyUIApplication.globel_video_wrapper	=	MyUIApplication.VideoGalleryList.get(position);
										v.setEnabled(false);
										((Home)mContext).OpenHtmlPage(screenNumber,_objEW.Code);
										
									}
								}
								else
								{
									MyUIApplication.globel_video_wrapper	=	MyUIApplication.VideoGalleryList.get(position);
									v.setEnabled(false);
									((Home)mContext).OpenHtmlPage(screenNumber,"");
									

								}
								MyUIApplication.StateMachine.add(screenNumber);

								int i=MyUIApplication.StateMachine.size();
								System.out.println("State Machine Size >>>"+i);
								if(!screenNumber.equals("-1"))
								{
									//							((Home)mContext).StateMachine.add(screenNumber);
									//							((Home)mContext).openButtonClickScreen(_objEW.Title , screenNumber);
								}
							}
						}

						else if(_objWrap.Link !=null && _objWrap.Link.length()>0)
						{//Condition if link is given
							try {
								Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(_objWrap.Link.trim()));
								((Home)mContext).startActivity(browserIntent);
								
								if(_objWrap.Link.equals("facebook:")){
//									loginToFacebook();
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						}


						break;
					case MotionEvent.ACTION_CANCEL:
						//						holder.ListButton.getBackground().setAlpha(255);
						//			        	holder.GridButtonTV.getBackground().setAlpha(255);
						//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();

						try {
							String color =  _objEW.bgcolor;
							if(color.length()>0)
							{
								v.setBackgroundColor(Color.parseColor(color));
							}else
							{
								v.setBackgroundColor(Color.TRANSPARENT);
							}

							if(_objEW.leftbgColor.length()>0 && _objEW.leftper.length()>0)
							{
								holder.Frm1.setBackgroundColor(Color.parseColor(_objEW.leftbgColor.trim()));
							}
							if(_objEW.midbgColor.length()>0 && _objEW.middleper.length()>0)
							{
								holder.Frm2.setBackgroundColor(Color.parseColor(_objEW.midbgColor.trim()));
							}
							if(_objEW.rightbgColor.length()>0 && _objEW.rightper.length()>0)
							{
								holder.Frm3.setBackgroundColor(Color.parseColor(_objEW.rightbgColor.trim()));
							}


						} catch (Exception e) {
							// TODO: handle exception
						}

						break;

					}

					return false;
				}

			});
			try {
//				String title =_objEW.Title;
				holder.TextListBtn.setText(MyUIApplication.VideoGalleryList.get(position).Title);

				String subtitle =MyUIApplication.VideoGalleryList.get(position).Description;
				holder.subtitle.setText(subtitle);
			} catch (Exception e) {
				// TODO: handle exception
			}


			try {
				Typeface tf = MyUIApplication.fontmap.get(_objEW.fontStyle);
				holder.TextListBtn.setTypeface(tf);
				holder.subtitle.setTypeface( MyUIApplication.fontmap.get(_objEW.subtitlefontStyle));
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				holder.TextListBtn.setTextColor(Color.parseColor(_objEW.fontColor));
				holder.subtitle.setTextColor(Color.parseColor(_objEW.subtitlefontColor));
				int i = Integer.parseInt(_objEW.fontSize);
				float testsizepercent = i/960f;
				int i1 = Integer.parseInt(_objEW.subtitlefontSize);
				float testsizepercent1 = i1/960f;
				holder.TextListBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(testsizepercent*deviceHeight)));
				holder.subtitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(.7f*testsizepercent1*deviceHeight)));
			} catch (Exception e) {
				holder.subtitle.setTextColor(Color.parseColor("#3c3c3c"));
				holder.TextListBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(0.1f)*(.4f*deviceHeight)));
			}
		}

		catch (Exception e)
		{
			holder.ButtonList.setBackgroundResource(R.drawable.ic_launcher);

		}

		// Display planet data
		holder.id = position;
		if(_objEW != null && _objEW.Code.length()>0)
			holder.elementcode = _objEW.Code;

		try {
			holder.MainLL.setBackgroundDrawable(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return convertView;
	
	}
	
	private class ViewHolderList 
	{
		ImageView ButtonList,Arrow;
		TextView TextListBtn,subtitle;
		LinearLayout ListButton;
		RelativeLayout MainLL;
		FrameLayout Frm1,Frm3;
		LinearLayout Frm2;
		int id;
		String elementcode;

	}
}




//class ViewHolderVGL 
//{
//	ImageView ButtonList;
//	TextView TextListBtn,TextListBtn1;
//	LinearLayout ListButton;
//	int id;
//
//}
