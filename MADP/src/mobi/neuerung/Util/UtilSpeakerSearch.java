package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.Adapters.SpeakerListAdapter;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.SpeakerWrapper;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;



public class UtilSpeakerSearch {

	String code1="P103";
	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static ListView Listview;

	String scrrenNumString="";
	EditText searchText;
	Button type1,type2,type3,refresh;

	// **** Set Show Update view for Type 27 *****
	public void SetShowUpdateList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);
		
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;



		if(MyUIApplication.Copy)
		{

			LinearLayout mainLayout = new LinearLayout(context);
			mainLayout.setOrientation(LinearLayout.VERTICAL);
			
			FrameLayout searchLayout = new FrameLayout(context);
			searchLayout.setBackgroundResource(R.drawable.search_speaker);

			ImageView searchImage = new ImageView(context);
			searchImage.setClickable(false);

			 searchText = new EditText(context);
			searchText.setBackgroundColor(Color.parseColor("#00000000"));
			
			
			
			 refresh = new Button(context);
			
			LinearLayout searchTypeLayout = new LinearLayout(context);
			searchTypeLayout.setOrientation(LinearLayout.HORIZONTAL);
			
			 type1 = new Button(context);
			type1.setText("A-Z");
			
			TextView separter1 = new TextView(context);
			TextView separter2 = new TextView(context);
			
			 type2 = new Button(context);
			type2.setText("Daywise");
			
			 type3 = new Button(context);
			type3.setText("My Favourites");
			
			searchTypeLayout.addView(type1);
			searchTypeLayout.addView(separter1);

			searchTypeLayout.addView(type2);
			searchTypeLayout.addView(separter2);
			
			searchTypeLayout.addView(type3);
			
			mainLayout.addView(searchLayout);
			mainLayout.addView(searchTypeLayout);
			
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

					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					searchLayout.addView(refresh);
					((Home)context).LLTopCopy.addView(mainLayout);
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
					searchText.setHint("Speaker Search ");
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


				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					searchLayout.addView(refresh);
					((Home)context).LLMiddleCopy.addView(mainLayout);
					((Home)context).LLMiddleCopy.addView(Listview);



					LinearLayout.LayoutParams params_searchLayout =(LinearLayout.LayoutParams) searchLayout.getLayoutParams();
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
					params_searchText.width=(int)(.70f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.CENTER|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setHint("Speaker Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_refresh =(FrameLayout.LayoutParams) refresh.getLayoutParams();
					params_refresh.height=(int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_refresh.width=(int)(.08f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_refresh.rightMargin=(int)(.024f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_refresh.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					refresh.setLayoutParams(params_refresh);

					ImageUtil.setBackgroundBgFromAssetsNotCache(refresh, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth));

					
					LinearLayout.LayoutParams params_searchTypeLayout =(LinearLayout.LayoutParams) searchTypeLayout.getLayoutParams();
					params_searchTypeLayout.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchTypeLayout.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchTypeLayout.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchTypeLayout.bottomMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchTypeLayout.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchTypeLayout.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					searchTypeLayout.setLayoutParams(params_searchTypeLayout);
					
					LinearLayout.LayoutParams params_type1 =(LinearLayout.LayoutParams) type1.getLayoutParams();
					params_type1.height=(int)(.95f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_type1.width=(int)(.318f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_type1.gravity=Gravity.CENTER_VERTICAL;
					type1.setLayoutParams(params_type1);
					type1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(type1.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.35f)));

					
					
					LinearLayout.LayoutParams params_type2 =(LinearLayout.LayoutParams) type2.getLayoutParams();
					params_type2.height=(int)(.95f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_type2.width=(int)(.318f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_type2.gravity=Gravity.CENTER_VERTICAL;
					type2.setLayoutParams(params_type2);
					type2.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(type2.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.35f)));
					
					
					LinearLayout.LayoutParams params_type3 =(LinearLayout.LayoutParams) type3.getLayoutParams();
					params_type3.height=(int)(.95f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_type3.width=(int)(.318f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_type3.gravity=Gravity.CENTER_VERTICAL;
					type3.setLayoutParams(params_type3);
					type3.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(type3.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.35f)));
					
					
					FrameLayout.LayoutParams params_Listview =(FrameLayout.LayoutParams) Listview.getLayoutParams();
					params_Listview.height=(int)(.765f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Listview.gravity=Gravity.BOTTOM;
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTop.addView(searchLayout);
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
					searchText.setHint("Speaker Search ");
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
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

		}
		else if(!MyUIApplication.Copy)
		{

			FrameLayout searchLayout = new FrameLayout(context);
			searchLayout.setBackgroundResource(R.drawable.search_speaker);

			ImageView searchImage = new ImageView(context);
			searchImage.setClickable(false);

			EditText searchText = new EditText(context);
			searchText.setBackgroundColor(Color.parseColor("#00000000"));
			
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
					searchText.setHint("Speaker Search ");
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
					params_searchText.width=(int)(.70f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.CENTER|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setHint("Speaker Search ");
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
					searchText.setHint("Speaker Search ");
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

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}
		
		type3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fillList(context, "P101");
				code1="P101";
			}
		});

		type1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fillList(context, "P102");
				
				code1="P102";
			}
		});

		refresh.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fillList(context, "P103");
				code1="P103";
			}
		});
	
		
		
		fillList(context, "P103");
	}
	
	 ArrayList<SpeakerWrapper> array=null;
	// Filling Values in Shoe Update List and Setting Adapter
	public void fillList(Context con,String code)
	{
		
		if(code.equals("P101"))
		{
			 array = MyUIApplication._objSpeakerListDB.getFavRecord();
//			 array = MyUIApplication._objSpeakerListDB.getRecords();
		}
		else if(code.equals("P103"))
		{
			 array = MyUIApplication._objSpeakerListDB.getRecords();
		}
		else if(code.equals("P102"))
		{
			 array = MyUIApplication._objSpeakerListDB.getSortedRecord();
		}
		else if(code.length()==0)
		{
			 array = MyUIApplication._objSpeakerListDB.getRecords();
		}
		
		
		try
		{
			final SpeakerListAdapter adapter = new SpeakerListAdapter(con,R.layout.show_update_category,array);
			String[] aa = new String[array.size()];
			for(int i=0;i<array.size();i++)
			{
				aa[i] = array.get(i).name;
			}
			
//			searchText.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_dropdown_item_1line,aa));

			searchText.addTextChangedListener(new TextWatcher() {

				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					if(s.toString().length()==0)
					{
						fillList(context, code1);
					}
					else
					{
					 adapter.getFilter().filter(s.toString());
					}
				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub
					
				}

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					// TODO Auto-generated method stub
					 
				}
			     
			  
				
			});
			Listview.setAdapter(adapter);
			if(scrrenNumString.length()>0)
			{
				
				
//				searchText.setOnItemClickListener(new OnItemClickListener() {
//
//					public void onItemClick(AdapterView<?> arg0, View arg1,
//							int arg2, long arg3) {
//						// TODO Auto-generated method stub
//						try {
//							SpeakerWrapper _obj = array.get(arg2);
//							MyUIApplication.speakerId = _obj.id;
//
//
//
//							((Home)context).OpenHtmlPage(scrrenNumString,"");
//							MyUIApplication.StateMachine.add(scrrenNumString);
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//					
//						
//					}
//				});
				
				
				
				Listview.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub

						SpeakerListAdapter.ViewHolder holder =(SpeakerListAdapter.ViewHolder) arg1.getTag();
						MyUIApplication.speakerId = holder.speakerId;



						((Home)context).OpenHtmlPage(scrrenNumString,"");
						MyUIApplication.StateMachine.add(scrrenNumString);

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
