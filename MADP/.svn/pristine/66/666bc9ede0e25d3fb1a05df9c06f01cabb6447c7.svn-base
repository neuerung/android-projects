package mobi.neuerung.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import mobi.neuerung.Adapters.EventEntryItem;
import mobi.neuerung.Adapters.EventItem;
import mobi.neuerung.Adapters.EventSectionItem;
import mobi.neuerung.Adapters.EventsAdapter;
import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.EventsWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class UtilEventList {
	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static RelativeLayout RelView;

	// **** Set Show Update view for Type 10 *****
	public void SetEventsList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;


		if(MyUIApplication.Copy)
		{
			RelView= new RelativeLayout(context);

			//			if(MyUIApplication.isInternetAvailable(context))
			//			{
			//				
			//			}


			try
			{


				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(RelView);

					ViewGroup.LayoutParams params_RelView = RelView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					RelView.setLayoutParams(params_RelView);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(RelView);



					ViewGroup.LayoutParams params_RelView = RelView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					RelView.setLayoutParams(params_RelView);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);





				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(RelView);

					ViewGroup.LayoutParams params_RelView = RelView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					RelView.setLayoutParams(params_RelView);


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
			RelView = new RelativeLayout(context);

			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(RelView);

					ViewGroup.LayoutParams params_RelView = RelView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					RelView.setLayoutParams(params_RelView);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(RelView);

					ViewGroup.LayoutParams params_RelView = RelView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					RelView.setLayoutParams(params_RelView);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);





				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(RelView);

					ViewGroup.LayoutParams params_RelView = RelView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					RelView.setLayoutParams(params_RelView);


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
		int hg = RelView.getHeight();
		System.out.println(hg);
		
		new BadgeBGThread(context, "EVENTS", false).execute();
	}

	public int DateDifference()
	{
		String StartDate = MyUIApplication.StartAndEndDate.substring(0,MyUIApplication.StartAndEndDate.indexOf(","));
		String EndDate = MyUIApplication.StartAndEndDate.substring(MyUIApplication.StartAndEndDate.indexOf(",")+1);

		int diff =0;
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date Sdate = formatter.parse(StartDate);
			Date Edate = formatter.parse(EndDate);

			diff = (int)( (Edate.getTime() - Sdate.getTime()) / (1000 * 60 * 60 * 24) );
			
			_objDateButtonList = new ArrayList<String>();
			for(int i =0;i<=diff;i++)
			{
				Calendar c = Calendar.getInstance(); 
				c.setTime(Sdate); 
				c.add(Calendar.DATE, i);
				Date Currentdate = c.getTime();
				
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String reportDate = df.format(Currentdate);
				
				_objDateButtonList.add(reportDate);
				
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return diff+1;
	}
	ArrayList<String> _objDateButtonList;
	public void getDayListFromDB(final Context context)
	{

//		MyUIApplication._objEventsDB.getEventDayList();
		int siz = DateDifference();
		System.out.println(siz);

//		Collections.sort(MyUIApplication._objEventDayButtonsList);
//		System.out.println(MyUIApplication._objEventDayButtonsList);

		HorizontalScrollView HSV = new HorizontalScrollView(context);
		RelView.addView(HSV);
		HSV.setBackgroundColor(Color.WHITE);

		LinearLayout LinScroll = new LinearLayout(context);
		HSV.addView(LinScroll);


		try
		{
			if(siz<5 && siz>0)
			{
				_objButton = null;
				_objButton = new ArrayList<Button>();

				for(int i =0;i<siz;i++)
				{
					Button btn = new Button(context);
					LinScroll.addView(btn);
					_objButton.add(btn);
					btn.setText("Day"+(i+1));
					btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(btn.getTypeface(),(0.3f)*(int)(.1f*((Home)context).deviceHeight)));

					int width = ((Home)context).deviceWidth/siz;


					ViewGroup.LayoutParams btn_param = btn.getLayoutParams();
					btn_param.width = width;
					btn_param.height =(int) (((Home)context).deviceHeight*.07f);
					btn.setLayoutParams(btn_param);



					btn.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub

							Button b = (Button)v;
							String buttonText = b.getText().toString();
							try
							{
								ImageUtil.setBackgroundBgFromAssetsNotCache(v, context,"Events/selector.png",v.getHeight(),v.getWidth());
								for(int i =0;i<_objButton.size();i++)
								{
									if(_objButton.get(i) != v)
										ImageUtil.setBackgroundBgFromAssetsNotCache(_objButton.get(i), context,"Events/non_selector.png",_objButton.get(i).getHeight(),_objButton.get(i).getWidth());
								}
							}
							catch (Exception e) {
								// TODO: handle exception
								System.out.println(e);
							}

							ButtonClickGetList(_objDateButtonList.get(Integer.parseInt(buttonText.substring(3))-1),context);
						}
					});
				}
			}
			else if(siz>=5)
			{
				_objButton = null;
				_objButton = new ArrayList<Button>();

				for(int i =0;i<siz;i++)
				{
					Button btn = new Button(context);
					LinScroll.addView(btn);
					_objButton.add(btn);
					btn.setText("Day"+(i+1));
					btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(btn.getTypeface(),(0.3f)*(int)(.1f*((Home)context).deviceHeight)));


					ViewGroup.LayoutParams btn_param = btn.getLayoutParams();
					btn_param.width = (int) (((Home)context).deviceWidth/5);
					btn_param.height =(int) (((Home)context).deviceHeight*.07f);
					btn.setLayoutParams(btn_param);

					if(i ==0)
					{
						ImageUtil.setBackgroundBgFromAssetsNotCache(btn, context,"Events/selector.png",btn.getHeight(),btn.getWidth());
					}
					else
					{
						ImageUtil.setBackgroundBgFromAssetsNotCache(btn, context,"Events/non_selector.png",btn.getHeight(),btn.getWidth());
					}

					btn.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub

							Button b = (Button)v;
							String buttonText = b.getText().toString();
							try
							{
								ImageUtil.setBackgroundBgFromAssetsNotCache(v, context,"Events/selector.png",v.getHeight(),v.getWidth());
								for(int i =0;i<_objButton.size();i++)
								{
									if(_objButton.get(i) != v)
										ImageUtil.setBackgroundBgFromAssetsNotCache(_objButton.get(i), context,"Events/non_selector.png",_objButton.get(i).getHeight(),_objButton.get(i).getWidth());
								}
							}
							catch (Exception e) {
								// TODO: handle exception
								System.out.println(e);
							}

							ButtonClickGetList(_objDateButtonList.get(Integer.parseInt(buttonText.substring(3))-1),context);


						}
					});
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		listview = new ListView(context);
		RelView.addView(listview);

		listview.setBackgroundColor(Color.WHITE);


		RelativeLayout.LayoutParams listview_param = (RelativeLayout.LayoutParams)listview.getLayoutParams();
		listview_param.width = (int) (((Home)context).deviceWidth);
		listview_param.height =(int)(RelView.getHeight()-(((Home)context).deviceHeight*.07f));
		listview.setLayoutParams(listview_param);

		listview_param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, listview.getId());

		ButtonClickGetList(_objDateButtonList.get(0),context);

		getSeminarFillList(context);

	}
	static ArrayList<Button> _objButton;
	public void ButtonClickGetList(String Day,Context context)
	{
		MyUIApplication._objEventsDB.getSeminarsEvents(Day);

		MyUIApplication._objEventsWrapperList.size();
		MyUIApplication._objEventsDB.getMySeminarEventList(Day);

		getSeminarFillList(context);
	}

	static ListView listview;
	public void getSeminarFillList(Context context)
	{

		System.out.println("Filling list");
		MyUIApplication.Eventitems=null;
		MyUIApplication.Eventitems = new ArrayList<EventItem>();


		for(int i =0;i<MyUIApplication._objEventTimeList.size();i++)
		{
			try
			{
				//				Date date ; 

				SimpleDateFormat format1 = new SimpleDateFormat("hh");
				SimpleDateFormat format2 = new SimpleDateFormat("hh:mm:ss");

				try
				{

					Date date = format1.parse(MyUIApplication._objEventTimeList.get(i));

					//					sectionView.setText(format2.format(date));
					//					MyUIApplication.Eventitems.addAll(format2.format(date));
					//					
					MyUIApplication.Eventitems.add(new EventSectionItem(format2.format(date)));

				}catch (Exception e) {
					// TODO: handle exception
				}
				//				date = (Date)formatter.parse(MyUIApplication._objDateEventSeminarList.get(i)); 
				//				SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely  
				//				System.out.println(simpleDateformat.format(date));

			}catch (Exception e) {
				System.out.println(e);
			}
			ArrayList<EventsWrapper> _objArray =MyUIApplication._objEventSectionList.get(i);
			for(int j=0;j<_objArray.size();j++)
			{
				EventsWrapper _obj =	_objArray.get(j);
				//				String datetime[]=_obj.time.split(" ");
				MyUIApplication.Eventitems.add(new EventEntryItem(_obj.Title,_obj.time.trim(),_objArray.get(j)));
			}
		}
		//		MyUIApplication.Eventitems.add(new EntryItem("Item 2"));
		//		MyUIApplication.Eventitems.add(new EntryItem("Item 3"));



		listview.setAdapter(null);
		EventsAdapter adapter = new EventsAdapter(context, MyUIApplication.Eventitems);
		adapter.notifyDataSetChanged();
		listview.setAdapter(adapter);
	}
}
