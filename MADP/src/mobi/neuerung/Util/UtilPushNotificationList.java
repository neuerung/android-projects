package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.SectionList.ShowUpdateEntryItem;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.PushNotificationWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ShowUpdatesWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;


public class UtilPushNotificationList {
	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static ListView Listview;
	ElementWrapper _objEW;

	public void SetPushNotificationList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink){

		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;

		_objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		//		MyUIApplication.globel_instance	=	_objEW.instance;

		//Check if Copy View is displaying
		if(MyUIApplication.Copy)
		{
			Listview= new ListView(context);

			try {
				Listview.setDivider(new ColorDrawable(Color.parseColor(_objEW.dividerColor)));
				Listview.setDividerHeight((int)(.003*((Home)context).deviceHeight));
			} catch (Exception e) {
				// TODO: handle exception
				Listview.setDivider(new ColorDrawable(Color.WHITE));
				Listview.setDividerHeight((int)(.003f*((Home)context).deviceHeight));
			}

			try
			{


				if(Section.equals("Top"))
				{


					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

				}
				else if(Section.equals("Middle"))
				{
					//Set Show update list view BG Color 
					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					//Set Width & Height of the middle section 
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					//Add  the list view to main middle section
					((Home)context).LLMiddleCopy.addView(Listview);

					//Apply Width & Height to middle section of main view
					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					//Apply Width & Height to show update list view
					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);

				}
				else if(Section.equals("Bottom"))
				{

					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

		}
		else if(!MyUIApplication.Copy)
		{
			Listview = new ListView(context);

			try {
				Listview.setDivider(new ColorDrawable(Color.parseColor(_objEW.dividerColor)));
				Listview.setDividerHeight((int)(.003*((Home)context).deviceHeight));
			} catch (Exception e) {
				// TODO: handle exception
				Listview.setDivider(new ColorDrawable(Color.WHITE));
				Listview.setDividerHeight((int)(.003f*((Home)context).deviceHeight));
			}


			try
			{

				if(Section.equals("Top"))
				{

					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

				}
				else if(Section.equals("Middle"))
				{

					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}


					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);





				}
				else if(Section.equals("Bottom"))
				{

					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}


					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}

		//		if(MyUIApplication.checkShowUpdate){
		//
		//			if(MyUIApplication.isInternetAvailable(context))
		//			{
		//				//Check for update & then fill the list
		//				new BadgeBGThread(context, "UPDATE", false).execute();
		//				MyUIApplication.checkShowUpdate	=	false;
		//			}
		//
		//		}else {
		//			//Directly fill the list
		//			fillList(context);
		//		}
	}

	public void fillNotificationList(){
		ArrayList<PushNotificationWrapper> _objList	=	MyUIApplication._objPushDB.retriveRecords();
	}


	private class pushNotiAdapter extends BaseAdapter{

		ArrayList<PushNotificationWrapper> _objList;
		LayoutInflater inflater;
		WindowManager mWinMgr;
		int deviceHeight,deviceWidth;
		ElementWrapper _objElement;
		public pushNotiAdapter(ArrayList<PushNotificationWrapper> _objList,ElementWrapper _objElement) {
			this._objList	=	_objList;
			inflater	=	(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			this._objElement	=	_objElement;

			WindowManager mWinMgr = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
			deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
			deviceWidth=mWinMgr.getDefaultDisplay().getWidth();
		}

		public int getCount() {
			return _objList.size();
		}

		public Object getItem(int position) {
			return _objList.get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View v, ViewGroup parent) {
			v = inflater.inflate(R.layout.showupdate_list_item_entry, null);
			final TextView time = (TextView)v.findViewById(R.id.time);
			final TextView title = (TextView)v.findViewById(R.id.list_item_entry_title);
			final TextView name = (TextView)v.findViewById(R.id.name);
			final FrameLayout MainFrame = (FrameLayout)v.findViewById(R.id.MainFrame);


			PushNotificationWrapper _obj	=	_objList.get(position);

			int arrowHeight=(int)(.035f*deviceHeight);
			int arraywidth=(int)(0.7f*arrowHeight);


			ViewGroup.LayoutParams params_time = time.getLayoutParams();
			time.setLayoutParams(params_time);
			title.setPadding((int)(0.02f*deviceWidth), (int)(0.02f*deviceHeight), 0, 0);
			time.setPadding((int)(0.02f*deviceWidth), (int)(0.02f*deviceHeight),(int)(0.03f*deviceWidth), (int)(0.01f*deviceHeight));
			name.setPadding((int)(0.02f*deviceWidth),(int)(0.005f*deviceHeight), (int)(0.02f*deviceWidth), (int)(0.04f*deviceHeight));

			if (title != null) 
			{
				title.setText(_obj.message);
			}
			if (name != null) 
			{
				name.setText(_obj.date);
			}

			try {
				MainFrame.setBackgroundColor(Color.parseColor(_objElement.bgcolor));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try
			{
				//				DateFormat StringToDate = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
				//				String t=ei.time.trim();
				//				Date date = StringToDate.parse(t);
				//
				//				Format DateToString = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
				//				String strng = DateToString.format(date);

				//				time.setText(ei.time.trim());
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(""+e);
				time.setText("Exception");
			}
			MainFrame.setOnTouchListener(new OnTouchListener() {

				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub

					UtilShowUpdate _objSU = new UtilShowUpdate();

					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						try {
							MainFrame.setBackgroundColor(Color.parseColor(_objElement.selectedBgcolor));
						} catch (Exception e) {
							// TODO: handle exception
						}


						return true;
					case MotionEvent.ACTION_CANCEL:
						try {
							MainFrame.setBackgroundColor(Color.parseColor(_objElement.bgcolor));
						} catch (Exception e) {
							// TODO: handle exception
						}

						break;

					case MotionEvent.ACTION_UP:
						try {
							MainFrame.setBackgroundColor(Color.parseColor(_objElement.bgcolor));
						} catch (Exception e) {
							// TODO: handle exception
						}

						try
						{

							try
							{
								/////////////////////////Logic to show push notification in Popup////////////////////////////////

							}
							catch (Exception e)
							{
								System.out.println(e);
							}

						}catch (Exception e) 
						{
							System.out.println(e);
						}

						break;
					default:
						return false;
					}


					return false;
				}
			});


			try {
				if(_objElement.TitleGravity.equalsIgnoreCase("center"))
					title.setGravity(Gravity.CENTER);
				if(_objElement.TitleGravity.equalsIgnoreCase("right"))
					title.setGravity(Gravity.RIGHT);
				if(_objElement.TitleGravity.equalsIgnoreCase("left"))
					title.setGravity(Gravity.LEFT);
			} catch (Exception e) {
				// TODO: handle exception
				title.setGravity(Gravity.LEFT);
			}

			try {
				if(_objElement.SubTitleGravity.equalsIgnoreCase("center"))
					name.setGravity(Gravity.CENTER);
				if(_objElement.SubTitleGravity.equalsIgnoreCase("right"))
					name.setGravity(Gravity.RIGHT);
				if(_objElement.SubTitleGravity.equalsIgnoreCase("left"))
					name.setGravity(Gravity.LEFT);
			} catch (Exception e) {
				// TODO: handle exception
				name.setGravity(Gravity.LEFT);
			}


			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.fontStyle);
				title.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.subtitlefontStyle);
				name.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				title.setTextColor(Color.parseColor(_objElement.fontColor));
			} catch (Exception e) {
				// TODO: handle exception
				title.setTextColor(Color.BLACK);
			}

			try {
				name.setTextColor(Color.parseColor(_objElement.subtitlefontColor));
			} catch (Exception e) {
				// TODO: handle exception
				name.setTextColor(Color.BLACK);
			}

			try {
				int ii = Integer.parseInt(_objElement.fontSize);
				float testsizepercent = ii/960f;
				title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.4f*deviceHeight)));
			}

			try {
				int ii = Integer.parseInt(_objElement.subtitlefontSize);
				float testsizepercent = ii/960f;
				name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			}

			//On Read news
			//			if(ei._objShowUpdatesWrapper.ReadOrUnRead.equalsIgnoreCase("Red"))
			//			{
			//
			//				try {
			//					Typeface tf = MyUIApplication.fontmap.get(_objElement.ReadNewsfontStyle);
			//					title.setTypeface(tf);
			//					name.setTypeface(tf);
			//				} catch (Exception e) {
			//					// TODO: handle exception
			//				}
			//
			//				try {
			//					title.setTextColor(Color.parseColor(_objElement.ReadNewsfontColor));
			//					name.setTextColor(Color.parseColor(_objElement.ReadNewsfontColor));
			//				} catch (Exception e) {
			//					// TODO: handle exception
			//					title.setTextColor(Color.BLACK);
			//					name.setTextColor(Color.BLACK);
			//				}
			////
			////				try {
			////					int ii = Integer.parseInt(_objElement.ReadNewsfontSize);
			////					float testsizepercent = ii/960f;
			////					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
			////					name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(name.getTypeface(),(testsizepercent*deviceHeight)));	
			////				} catch (Exception e) {
			////					// TODO: handle exception
			////					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			////					name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(name.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			////				}
			//				
			//				try {
			//					int ii = Integer.parseInt(_objElement.fontSize);
			//					float testsizepercent = ii/960f;
			//					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
			//				} catch (Exception e) {
			//					// TODO: handle exception
			//					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.4f*deviceHeight)));
			//				}
			//
			//				try {
			//					int ii = Integer.parseInt(_objElement.subtitlefontSize);
			//					float testsizepercent = ii/960f;
			//					name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
			//				} catch (Exception e) {
			//					// TODO: handle exception
			//					name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			//				}
			//
			//			}



//			try {
//				Typeface tf = MyUIApplication.fontmap.get(_objElement.TimefontStyle);
//				time.setTypeface(tf);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//			try {
//				time.setTextColor(Color.parseColor(_objElement.TimefontColor));
//			} catch (Exception e) {
//				// TODO: handle exception
//				time.setTextColor(Color.BLACK);
//			}
//
//			try {
//				int ii = Integer.parseInt(_objElement.TimefontSize);
//				float testsizepercent = ii/960f;
//				time.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(time.getTypeface(),(testsizepercent*deviceHeight)));	
//			} catch (Exception e) {
//				// TODO: handle exception
//				time.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(time.getTypeface(),(0.1f)*(.25f*deviceHeight)));
//			}

			return v;
		}

	}

}
