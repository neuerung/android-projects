package mobi.neuerung.Util;


import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.SpeakerSeminarsWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;




public class UtilSpeakerSeminarDetail {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	Button speakerImage;
	SpeakerSeminarsWrapper _objSpeakerSeminarsWrapper=null;
	String scrrenNumString="";

	// **** Set Show Update view for Type 29 *****
	public void SetShowUpdateDetail(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{

		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;



		LinearLayout mainLayout = new LinearLayout(context);
		mainLayout.setOrientation(LinearLayout.VERTICAL);

		LinearLayout Layout1 = new LinearLayout(context);
		Layout1.setOrientation(LinearLayout.HORIZONTAL);

		TextView title = new TextView(context);
		title.setTextColor(Color.BLACK);

		final Button favButton = new Button(context);

		LinearLayout Layout2 = new LinearLayout(context);
		Layout2.setOrientation(LinearLayout.HORIZONTAL);

		TextView Day = new TextView(context);
		Day.setTextColor(Color.BLACK);

		final Button visiedButton = new Button(context);

		TextView Description = new TextView(context);
		Description.setTextColor(Color.BLACK);


		mainLayout.addView(Layout1);

		Layout1.addView(title);
		Layout1.addView(favButton);

		mainLayout.addView(Layout2);

		Layout2.addView(Day);
		Layout2.addView(visiedButton);

		mainLayout.addView(Description);

		String aa[] = UrlLink.split("##");
		
		String name="",id="";
		if(aa.length==2)
		{
			name =aa[0];
			id =aa[1];
		}
		
		
		_objSpeakerSeminarsWrapper = MyUIApplication._objSpeakerSeminarDB.getRecord(name,id);

		if(_objSpeakerSeminarsWrapper !=null)
		{
			title.setText(_objSpeakerSeminarsWrapper.Title);
			ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favouritesnonsel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));

			Day.setText(_objSpeakerSeminarsWrapper.Day);
			ImageUtil.setBackgroundBgFromAssetsNotCache(visiedButton, context, "images/visited_nonsel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));


			Description.setText(_objSpeakerSeminarsWrapper.description);

			try {
				((Home)context)._objUtilTopBar.Heading.setText(_objSpeakerSeminarsWrapper.Title.trim());

				if(_objSpeakerSeminarsWrapper.favourites.equals("true"))
				{
					ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favourites.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
				}
				else if(_objSpeakerSeminarsWrapper.favourites.equals("false"))
				{
					ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favouritesnonsel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
				}


				if(_objSpeakerSeminarsWrapper.visited.equals("true"))
				{
					ImageUtil.setBackgroundBgFromAssetsNotCache(visiedButton, context, "images/visited_sel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
				}
				else if(_objSpeakerSeminarsWrapper.visited.equals("false"))
				{
					ImageUtil.setBackgroundBgFromAssetsNotCache(visiedButton, context, "images/visited_nonsel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
				}



			} catch (Exception e) {

			}
		}
		else
		{
			return;
		}


		if(MyUIApplication.Copy)
		{

			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLTopCopy.addView(mainLayout);


					LinearLayout.LayoutParams params_Layout1 =(LinearLayout.LayoutParams) Layout1.getLayoutParams();
					params_Layout1.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Layout1.setLayoutParams(params_Layout1);

					LinearLayout.LayoutParams params_title =(LinearLayout.LayoutParams) title.getLayoutParams();
					params_title.width=(int)(.75f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_title.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					title.setGravity(Gravity.CENTER_VERTICAL);
					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(title.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_favButton = favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.12f*widthLLTopCopyPer*((Home)context).deviceWidth);
					favButton.setLayoutParams(params_favButton);



					LinearLayout.LayoutParams params_Layout2 =(LinearLayout.LayoutParams) Layout2.getLayoutParams();
					params_Layout2.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Layout2.setLayoutParams(params_Layout2);

					LinearLayout.LayoutParams params_Day =(LinearLayout.LayoutParams) Day.getLayoutParams();
					params_Day.width=(int)(.75f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Day.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					Day.setGravity(Gravity.CENTER_VERTICAL);
					Day.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Day.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_visiedButton = visiedButton.getLayoutParams();
					params_visiedButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_visiedButton.width=(int)(.15f*widthLLTopCopyPer*((Home)context).deviceWidth);
					visiedButton.setLayoutParams(params_visiedButton);


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					Description.setBackgroundResource(R.drawable.search_speaker);



					Description.setPadding((int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight));
					Description.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Description.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));






					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
					scrrenNumString = _objEW.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLMiddleCopy.addView(mainLayout);

					LinearLayout.LayoutParams params_Layout1 =(LinearLayout.LayoutParams) Layout1.getLayoutParams();
					params_Layout1.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Layout1.setLayoutParams(params_Layout1);

					LinearLayout.LayoutParams params_title =(LinearLayout.LayoutParams) title.getLayoutParams();
					params_title.width=(int)(.75f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_title.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					title.setGravity(Gravity.CENTER_VERTICAL);
					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(title.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_favButton = favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.12f*widthLLTopCopyPer*((Home)context).deviceWidth);
					favButton.setLayoutParams(params_favButton);



					LinearLayout.LayoutParams params_Layout2 =(LinearLayout.LayoutParams) Layout2.getLayoutParams();
					params_Layout2.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Layout2.setLayoutParams(params_Layout2);

					LinearLayout.LayoutParams params_Day =(LinearLayout.LayoutParams) Day.getLayoutParams();
					params_Day.width=(int)(.75f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Day.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					Day.setGravity(Gravity.CENTER_VERTICAL);
					Day.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Day.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_visiedButton = visiedButton.getLayoutParams();
					params_visiedButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_visiedButton.width=(int)(.15f*widthLLTopCopyPer*((Home)context).deviceWidth);
					visiedButton.setLayoutParams(params_visiedButton);


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					Description.setBackgroundResource(R.drawable.search_speaker);



					Description.setPadding((int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight));
					Description.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Description.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));



					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);


					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
					scrrenNumString = _objEW.OnClick.substring(12);
					System.out.println("QQQQQQQQ.. ...  ...  "+scrrenNumString);
				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(mainLayout);

					LinearLayout.LayoutParams params_Layout1 =(LinearLayout.LayoutParams) Layout1.getLayoutParams();
					params_Layout1.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout1.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Layout1.setLayoutParams(params_Layout1);

					LinearLayout.LayoutParams params_title =(LinearLayout.LayoutParams) title.getLayoutParams();
					params_title.width=(int)(.75f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_title.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					title.setGravity(Gravity.CENTER_VERTICAL);
					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(title.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_favButton = favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.12f*widthLLTopCopyPer*((Home)context).deviceWidth);
					favButton.setLayoutParams(params_favButton);



					LinearLayout.LayoutParams params_Layout2 =(LinearLayout.LayoutParams) Layout2.getLayoutParams();
					params_Layout2.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Layout2.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Layout2.setLayoutParams(params_Layout2);

					LinearLayout.LayoutParams params_Day =(LinearLayout.LayoutParams) Day.getLayoutParams();
					params_Day.width=(int)(.75f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_Day.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					Day.setGravity(Gravity.CENTER_VERTICAL);
					Day.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Day.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_visiedButton = visiedButton.getLayoutParams();
					params_visiedButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_visiedButton.width=(int)(.15f*widthLLTopCopyPer*((Home)context).deviceWidth);
					visiedButton.setLayoutParams(params_visiedButton);


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					Description.setBackgroundResource(R.drawable.search_speaker);



					Description.setPadding((int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight));
					Description.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Description.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));




					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);


					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
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


			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(mainLayout);


					LinearLayout.LayoutParams params_Layout1 =(LinearLayout.LayoutParams) Layout1.getLayoutParams();
					params_Layout1.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					Layout1.setLayoutParams(params_Layout1);

					LinearLayout.LayoutParams params_title =(LinearLayout.LayoutParams) title.getLayoutParams();
					params_title.width=(int)(.75f*widthLLTopPer*((Home)context).deviceWidth);
					params_title.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					title.setGravity(Gravity.CENTER_VERTICAL);
					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(title.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_favButton = favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.12f*widthLLTopPer*((Home)context).deviceWidth);
					favButton.setLayoutParams(params_favButton);



					LinearLayout.LayoutParams params_Layout2 =(LinearLayout.LayoutParams) Layout2.getLayoutParams();
					params_Layout2.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					Layout2.setLayoutParams(params_Layout2);

					LinearLayout.LayoutParams params_Day =(LinearLayout.LayoutParams) Day.getLayoutParams();
					params_Day.width=(int)(.75f*widthLLTopPer*((Home)context).deviceWidth);
					params_Day.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					Day.setGravity(Gravity.CENTER_VERTICAL);
					Day.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Day.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_visiedButton = visiedButton.getLayoutParams();
					params_visiedButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_visiedButton.width=(int)(.15f*widthLLTopPer*((Home)context).deviceWidth);
					visiedButton.setLayoutParams(params_visiedButton);


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					Description.setBackgroundResource(R.drawable.search_speaker);



					Description.setPadding((int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight));
					Description.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Description.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);


					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
					scrrenNumString = _objEW.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLMiddle.addView(mainLayout);

					LinearLayout.LayoutParams params_Layout1 =(LinearLayout.LayoutParams) Layout1.getLayoutParams();
					params_Layout1.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					Layout1.setLayoutParams(params_Layout1);

					LinearLayout.LayoutParams params_title =(LinearLayout.LayoutParams) title.getLayoutParams();
					params_title.width=(int)(.75f*widthLLTopPer*((Home)context).deviceWidth);
					params_title.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					title.setGravity(Gravity.CENTER_VERTICAL);
					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(title.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_favButton = favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.12f*widthLLTopPer*((Home)context).deviceWidth);
					favButton.setLayoutParams(params_favButton);



					LinearLayout.LayoutParams params_Layout2 =(LinearLayout.LayoutParams) Layout2.getLayoutParams();
					params_Layout2.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					Layout2.setLayoutParams(params_Layout2);

					LinearLayout.LayoutParams params_Day =(LinearLayout.LayoutParams) Day.getLayoutParams();
					params_Day.width=(int)(.75f*widthLLTopPer*((Home)context).deviceWidth);
					params_Day.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					Day.setGravity(Gravity.CENTER_VERTICAL);
					Day.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Day.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_visiedButton = visiedButton.getLayoutParams();
					params_visiedButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_visiedButton.width=(int)(.15f*widthLLTopPer*((Home)context).deviceWidth);
					visiedButton.setLayoutParams(params_visiedButton);


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					Description.setBackgroundResource(R.drawable.search_speaker);



					Description.setPadding((int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight));
					Description.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Description.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));



					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);



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


					((Home)context).LLBottom.addView(mainLayout);


					LinearLayout.LayoutParams params_Layout1 =(LinearLayout.LayoutParams) Layout1.getLayoutParams();
					params_Layout1.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout1.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					Layout1.setLayoutParams(params_Layout1);

					LinearLayout.LayoutParams params_title =(LinearLayout.LayoutParams) title.getLayoutParams();
					params_title.width=(int)(.75f*widthLLTopPer*((Home)context).deviceWidth);
					params_title.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					title.setGravity(Gravity.CENTER_VERTICAL);
					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(title.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_favButton = favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.12f*widthLLTopPer*((Home)context).deviceWidth);
					favButton.setLayoutParams(params_favButton);



					LinearLayout.LayoutParams params_Layout2 =(LinearLayout.LayoutParams) Layout2.getLayoutParams();
					params_Layout2.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_Layout2.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					Layout2.setLayoutParams(params_Layout2);

					LinearLayout.LayoutParams params_Day =(LinearLayout.LayoutParams) Day.getLayoutParams();
					params_Day.width=(int)(.75f*widthLLTopPer*((Home)context).deviceWidth);
					params_Day.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					Day.setGravity(Gravity.CENTER_VERTICAL);
					Day.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Day.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					ViewGroup.LayoutParams params_visiedButton = visiedButton.getLayoutParams();
					params_visiedButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_visiedButton.width=(int)(.15f*widthLLTopPer*((Home)context).deviceWidth);
					visiedButton.setLayoutParams(params_visiedButton);


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					Description.setBackgroundResource(R.drawable.search_speaker);



					Description.setPadding((int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight));
					Description.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(Description.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));




					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);



					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
					scrrenNumString = _objEW.OnClick.substring(12);

				}




			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}


		}


		favButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(_objSpeakerSeminarsWrapper != null)
				{
					if(_objSpeakerSeminarsWrapper.favourites.equals("false"))
					{
						MyUIApplication._objSpeakerSeminarDB.favourites(_objSpeakerSeminarsWrapper.Title,_objSpeakerSeminarsWrapper.favourites);
						ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favourites.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
						_objSpeakerSeminarsWrapper.favourites="true";
					}
					else if(_objSpeakerSeminarsWrapper.favourites.equals("true"))
					{
						MyUIApplication._objSpeakerSeminarDB.favourites(_objSpeakerSeminarsWrapper.Title,_objSpeakerSeminarsWrapper.favourites);
						ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favouritesnonsel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
						_objSpeakerSeminarsWrapper.favourites="false";
					}
				}

			}
		});

		visiedButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(_objSpeakerSeminarsWrapper != null)
				{
					if(_objSpeakerSeminarsWrapper.visited.equals("false"))
					{
						MyUIApplication._objSpeakerSeminarDB.visited(_objSpeakerSeminarsWrapper.Title,_objSpeakerSeminarsWrapper.visited);
						ImageUtil.setBackgroundBgFromAssetsNotCache(visiedButton, context, "images/visited_sel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
						_objSpeakerSeminarsWrapper.visited="true";
					}
					else if(_objSpeakerSeminarsWrapper.visited.equals("true"))
					{
						MyUIApplication._objSpeakerSeminarDB.visited(_objSpeakerSeminarsWrapper.Title,_objSpeakerSeminarsWrapper.visited);
						ImageUtil.setBackgroundBgFromAssetsNotCache(visiedButton, context, "images/visited_nonsel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
						_objSpeakerSeminarsWrapper.visited="false";
					}
				}

			}
		});



	}

}


