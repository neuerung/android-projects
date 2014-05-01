package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.Adapters.SpeakerListAdapter;
import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.SpeakerWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class UtilSpeaker {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static ListView Listview;

	String scrrenNumString="";
	String scrrenNumString1="";
	FrameLayout searchLayout;
	// **** Set Show Update view for Type 25 *****
	public void SetShowUpdateList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		ElementWrapper _objEW,_objEW1;
		final ArrayList<ElementWrapper> array = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);
		if(array.size()>=2)
		{
			_objEW =array.get(0);
			_objEW1 =array.get(1);
		}		
		else
		{
			_objEW =((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);
			_objEW1 =((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		}
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;



		if(MyUIApplication.Copy)
		{
			 searchLayout = new FrameLayout(context);
			searchLayout.setBackgroundResource(R.drawable.search_speaker);

			ImageView searchImage = new ImageView(context);
			searchImage.setClickable(false);

			TextView searchText = new TextView(context);
			searchText.setClickable(false);

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

					((Home)context).LLTopCopy.addView(searchLayout);
					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					((Home)context).LLTopCopy.addView(Listview);

					FrameLayout.LayoutParams params_searchLayout =(FrameLayout.LayoutParams) searchLayout.getLayoutParams();
					params_searchLayout.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchLayout.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.bottomMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchLayout.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					searchLayout.setLayoutParams(params_searchLayout);

					FrameLayout.LayoutParams params_searchImage =(FrameLayout.LayoutParams) searchImage.getLayoutParams();
					params_searchImage.height=(int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchImage.width=(int)(.08f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchImage.leftMargin=(int)(.023f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchImage.gravity=Gravity.LEFT|Gravity.CENTER_VERTICAL;
					searchImage.setLayoutParams(params_searchImage);

					ImageUtil.setBackgroundBgFromAssetsNotCache(searchImage, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth));

					FrameLayout.LayoutParams params_searchText =(FrameLayout.LayoutParams) searchText.getLayoutParams();
					params_searchText.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchText.width=(int)(.81f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setText("Speaker Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_Listview =(FrameLayout.LayoutParams) Listview.getLayoutParams();
					params_Listview.height=(int)(.87f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Listview.gravity=Gravity.BOTTOM;
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

					String onclick1 =_objEW1.OnClick;
					scrrenNumString1 = _objEW1.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(searchLayout);
					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					((Home)context).LLMiddleCopy.addView(Listview);



					FrameLayout.LayoutParams params_searchLayout =(FrameLayout.LayoutParams) searchLayout.getLayoutParams();
					params_searchLayout.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchLayout.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.bottomMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchLayout.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					searchLayout.setLayoutParams(params_searchLayout);

					FrameLayout.LayoutParams params_searchImage =(FrameLayout.LayoutParams) searchImage.getLayoutParams();
					params_searchImage.height=(int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchImage.width=(int)(.08f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchImage.leftMargin=(int)(.023f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchImage.gravity=Gravity.LEFT|Gravity.CENTER_VERTICAL;
					searchImage.setLayoutParams(params_searchImage);

					ImageUtil.setBackgroundBgFromAssetsNotCache(searchImage, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth));

					FrameLayout.LayoutParams params_searchText =(FrameLayout.LayoutParams) searchText.getLayoutParams();
					params_searchText.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchText.width=(int)(.81f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setText("Speaker Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_Listview =(FrameLayout.LayoutParams) Listview.getLayoutParams();
					params_Listview.height=(int)(.87f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Listview.gravity=Gravity.BOTTOM;
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

					String onclick1 =_objEW1.OnClick;
					scrrenNumString1 = _objEW1.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLBottomCopy.addView(searchLayout);
					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					((Home)context).LLBottomCopy.addView(Listview);

					FrameLayout.LayoutParams params_searchLayout =(FrameLayout.LayoutParams) searchLayout.getLayoutParams();
					params_searchLayout.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchLayout.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.bottomMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchLayout.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					searchLayout.setLayoutParams(params_searchLayout);

					FrameLayout.LayoutParams params_searchImage =(FrameLayout.LayoutParams) searchImage.getLayoutParams();
					params_searchImage.height=(int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchImage.width=(int)(.08f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchImage.leftMargin=(int)(.023f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchImage.gravity=Gravity.LEFT|Gravity.CENTER_VERTICAL;
					searchImage.setLayoutParams(params_searchImage);

					ImageUtil.setBackgroundBgFromAssetsNotCache(searchImage, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth));

					FrameLayout.LayoutParams params_searchText =(FrameLayout.LayoutParams) searchText.getLayoutParams();
					params_searchText.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchText.width=(int)(.81f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setText("Speaker Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_Listview =(FrameLayout.LayoutParams) Listview.getLayoutParams();
					params_Listview.height=(int)(.87f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Listview.gravity=Gravity.BOTTOM;
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

					String onclick1 =_objEW1.OnClick;
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

			 searchLayout = new FrameLayout(context);
			searchLayout.setBackgroundResource(R.drawable.search_speaker);

			ImageView searchImage = new ImageView(context);
			searchImage.setClickable(false);

			TextView searchText = new TextView(context);
			searchText.setClickable(false);

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

					((Home)context).LLTop.addView(searchLayout);
					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					((Home)context).LLTop.addView(Listview);

					FrameLayout.LayoutParams params_searchLayout =(FrameLayout.LayoutParams) searchLayout.getLayoutParams();
					params_searchLayout.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchLayout.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.bottomMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchLayout.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					searchLayout.setLayoutParams(params_searchLayout);

					FrameLayout.LayoutParams params_searchImage =(FrameLayout.LayoutParams) searchImage.getLayoutParams();
					params_searchImage.height=(int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchImage.width=(int)(.08f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchImage.leftMargin=(int)(.023f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchImage.gravity=Gravity.LEFT|Gravity.CENTER_VERTICAL;
					searchImage.setLayoutParams(params_searchImage);

					ImageUtil.setBackgroundBgFromAssetsNotCache(searchImage, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopPer*((Home)context).deviceWidth));

					FrameLayout.LayoutParams params_searchText =(FrameLayout.LayoutParams) searchText.getLayoutParams();
					params_searchText.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchText.width=(int)(.81f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setText("Speaker Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_Listview =(FrameLayout.LayoutParams) Listview.getLayoutParams();
					params_Listview.height=(int)(.87f*heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Listview.gravity=Gravity.BOTTOM;
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

					String onclick1 =_objEW1.OnClick;
					scrrenNumString1 = _objEW1.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(searchLayout);
					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					((Home)context).LLMiddle.addView(Listview);

					FrameLayout.LayoutParams params_searchLayout =(FrameLayout.LayoutParams) searchLayout.getLayoutParams();
					params_searchLayout.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchLayout.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.bottomMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchLayout.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					searchLayout.setLayoutParams(params_searchLayout);

					FrameLayout.LayoutParams params_searchImage =(FrameLayout.LayoutParams) searchImage.getLayoutParams();
					params_searchImage.height=(int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchImage.width=(int)(.08f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchImage.leftMargin=(int)(.023f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchImage.gravity=Gravity.LEFT|Gravity.CENTER_VERTICAL;
					searchImage.setLayoutParams(params_searchImage);

					ImageUtil.setBackgroundBgFromAssetsNotCache(searchImage, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopPer*((Home)context).deviceWidth));

					FrameLayout.LayoutParams params_searchText =(FrameLayout.LayoutParams) searchText.getLayoutParams();
					params_searchText.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchText.width=(int)(.81f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setText("Speaker Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_Listview =(FrameLayout.LayoutParams) Listview.getLayoutParams();
					params_Listview.height=(int)(.87f*heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Listview.gravity=Gravity.BOTTOM;
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

					String onclick1 =_objEW1.OnClick;
					scrrenNumString1 = _objEW1.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLBottom.addView(searchLayout);
					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					((Home)context).LLBottom.addView(Listview);

					FrameLayout.LayoutParams params_searchLayout =(FrameLayout.LayoutParams) searchLayout.getLayoutParams();
					params_searchLayout.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchLayout.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.bottomMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchLayout.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					searchLayout.setLayoutParams(params_searchLayout);

					FrameLayout.LayoutParams params_searchImage =(FrameLayout.LayoutParams) searchImage.getLayoutParams();
					params_searchImage.height=(int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchImage.width=(int)(.08f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchImage.leftMargin=(int)(.023f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchImage.gravity=Gravity.LEFT|Gravity.CENTER_VERTICAL;
					searchImage.setLayoutParams(params_searchImage);

					ImageUtil.setBackgroundBgFromAssetsNotCache(searchImage, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopPer*((Home)context).deviceWidth));

					FrameLayout.LayoutParams params_searchText =(FrameLayout.LayoutParams) searchText.getLayoutParams();
					params_searchText.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchText.width=(int)(.81f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setText("Speaker Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_Listview =(FrameLayout.LayoutParams) Listview.getLayoutParams();
					params_Listview.height=(int)(.87f*heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Listview.gravity=Gravity.BOTTOM;
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

					String onclick1 =_objEW1.OnClick;
					scrrenNumString1 = _objEW1.OnClick.substring(12);

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}
		try {
			searchLayout.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					((Home)context).OpenHtmlPage(scrrenNumString,"");
					MyUIApplication.StateMachine.add(scrrenNumString);
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		if(UrlLink.length()>0)
		{
			if(UrlLink.equals("SP101"))
			{
				fillList(context,"SP101");
				MyUIApplication.elementCode="SP101";
			}
			else if(UrlLink.equals("SP103"))
			{
				MyUIApplication.elementCode="SP103";
				new BadgeBGThread(context, "Get Speakers", false).execute();
			}
			else if(UrlLink.equals("SP102"))
			{
				MyUIApplication.elementCode="SP102";
			}
			
		}
		else if(UrlLink.length()==0)
		{
			if(!(MyUIApplication.elementCode.equals("-1")))
			fillList(context,MyUIApplication.elementCode);
		}
	}

	// Filling Values in Shoe Update List and Setting Adapter
	public void fillList(Context con,String code)
	{
		ArrayList<SpeakerWrapper> array=null;
		if(code.equals("SP101"))
		{
			 array = MyUIApplication._objSpeakerListDB.getFavRecord();
//			 array = MyUIApplication._objSpeakerListDB.getRecords();
		}
		else if(code.equals("SP103"))
		{
			 array = MyUIApplication._objSpeakerListDB.getRecords();
		}
		else if(code.equals("SP102"))
		{

		}
		else if(code.length()==0)
		{
			 array = MyUIApplication._objSpeakerListDB.getRecords();
		}
		

		try
		{
			SpeakerListAdapter adapter = new SpeakerListAdapter(con,R.layout.show_update_category,array);
			Listview.setAdapter(adapter);
			if(scrrenNumString.length()>0)
			{
				Listview.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

						SpeakerListAdapter.ViewHolder holder =(SpeakerListAdapter.ViewHolder) arg1.getTag();
						MyUIApplication.speakerId = holder.speakerId;



						((Home)context).OpenHtmlPage(scrrenNumString1,"");
						MyUIApplication.StateMachine.add(scrrenNumString1);
						
					}
				});
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}


	}
}
