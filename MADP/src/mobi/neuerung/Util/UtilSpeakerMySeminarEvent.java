package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.Adapters.FavEventAdapter;
import mobi.neuerung.Adapters.SpeakerSeminarAdapter;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.EventsWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.SpeakerSeminarsWrapper;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;



public class UtilSpeakerMySeminarEvent {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static ListView Listview;

	String scrrenNumString="";
	String scrrenNumString1="";
	ElementWrapper _objEW,_objEW1;
	// **** Set Show Update view for Type 28 *****
	public void SetShowUpdateList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		final ArrayList<ElementWrapper> array = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);

		if(array.size()>=2)
		{
			  _objEW= array.get(0);
			  _objEW1= array.get(1);
		}
		else
		{
			_objEW = new ElementWrapper();
			_objEW1 = new ElementWrapper();
		}
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;



		if(MyUIApplication.Copy)
		{
			Listview= new ListView(context);
			Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));


			try
			{

				if(Section.equals("Top"))
				{
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
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);
					scrrenNumString1 = _objEW1.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(Listview);



					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);
					scrrenNumString1 = _objEW1.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{
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
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);
					scrrenNumString1 = _objEW1.OnClick.substring(12);
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
			Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
			if(MyUIApplication.isInternetAvailable(context))
			{
			}


			try
			{

				if(Section.equals("Top"))
				{
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
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);
					scrrenNumString1 = _objEW1.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
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

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);
					scrrenNumString1 = _objEW1.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{
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
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);
					scrrenNumString1 = _objEW1.OnClick.substring(12);

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}

		if(UrlLink.equals("MSP101"))
		{
			fillList(context, "MSP101");
			MyUIApplication.elementCode="MSP101";
		}
		if(UrlLink.equals("MSP102"))
		{
			fillList(context, "MSP102");
			MyUIApplication.elementCode="MSP102";
		}
		else if(UrlLink.length()==0)
		{
			if(!(MyUIApplication.elementCode.equals("-1")))
				fillList(context, MyUIApplication.elementCode);
		}

		//		new BadgeBGThread(context, "Get Seminars", false).execute();
	}

	// Filling Values in Shoe Update List and Setting Adapter
	public void fillList(Context con,String code)
	{
		ArrayList<SpeakerSeminarsWrapper> array=null;
		ArrayList<EventsWrapper> Eventsarray=null;
		if(code.equals("MSP101"))
		{
			array = MyUIApplication._objSpeakerSeminarDB.getFavRecord();
		}
		else if(code.equals("MSP102"))
		{
			Eventsarray = MyUIApplication._objEventsDB.getFavRecord();
		}
		else
		{
			array = new ArrayList<SpeakerSeminarsWrapper>();
		}
		try
		{
			if(code.equals("MSP101"))
			{
				SpeakerSeminarAdapter adapter = new SpeakerSeminarAdapter(con,R.layout.show_update_category,array);

				Listview.setAdapter(adapter);
				if(scrrenNumString.length()>0)
				{
					Listview.setOnItemClickListener(new OnItemClickListener() {

						public void onItemClick(AdapterView<?> arg0, View arg1,
								int arg2, long arg3) {
							// TODO Auto-generated method stub

							SpeakerSeminarAdapter.ViewHolder holder =(SpeakerSeminarAdapter.ViewHolder) arg1.getTag();

							String s =holder.speakerName.getText().toString()+"##"+holder.speakerId;

							((Home)context).OpenHtmlPage(scrrenNumString,holder.speakerName.getText().toString()+"##"+holder.speakerId);
							MyUIApplication.StateMachine.add(scrrenNumString);

						}
					});
				}
			}
			else if(code.equals("MSP102"))
			{
				FavEventAdapter adapter = new FavEventAdapter(con,R.layout.show_update_category,Eventsarray);

				Listview.setAdapter(adapter);
				if(scrrenNumString1.length()>0)
				{
					Listview.setOnItemClickListener(new OnItemClickListener() {

						public void onItemClick(AdapterView<?> arg0, View arg1,
								int arg2, long arg3) {
							// TODO Auto-generated method stub
							
							FavEventAdapter.ViewHolder holder =(FavEventAdapter.ViewHolder) arg1.getTag();
							String s = scrrenNumString1;
							MyUIApplication.EventsWrapperForDetail = holder._obj;
							((Home)context).OpenHtmlPage(scrrenNumString1,holder._obj.id);
							MyUIApplication.StateMachine.add(scrrenNumString1);

						}
					});
				}
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}


	}
}
