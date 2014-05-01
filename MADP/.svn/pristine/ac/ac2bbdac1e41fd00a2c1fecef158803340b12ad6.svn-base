package mobi.neuerung.Util;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.SpeakerWrapper;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;



public class UtilSpeakerDetail {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	Button speakerImage;
	 SpeakerWrapper _objSpeakerWrapper=null;
	String scrrenNumString="";
	
	// **** Set Show Update view for Type 10 *****
	public void SetShowUpdateDetail(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		
		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);
		
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;



		LinearLayout mainLayout = new LinearLayout(context);
		mainLayout.setOrientation(LinearLayout.VERTICAL);

		LinearLayout innerLinearLayout = new LinearLayout(context);
		innerLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

		 speakerImage = new Button(context);

		LinearLayout innermostLinear = new LinearLayout(context);
		innermostLinear.setOrientation(LinearLayout.VERTICAL);

		FrameLayout postFavFrame = new FrameLayout(context);

		TextView postTextView = new TextView(context);
		postTextView.setTextColor(Color.BLACK);

		final Button favButton = new Button(context);

		TextView companyNameTextView = new TextView(context);
		companyNameTextView.setTextColor(Color.BLACK);

		TextView descriptionTextView = new TextView(context);
		descriptionTextView.setTextColor(Color.BLACK);


		Button seminarButton = new Button(context);


		mainLayout.addView(innerLinearLayout);

		innerLinearLayout.addView(speakerImage);
		innerLinearLayout.addView(innermostLinear);

		innermostLinear.addView(postFavFrame);

		postFavFrame.addView(postTextView);
		postFavFrame.addView(favButton);

		innermostLinear.addView(companyNameTextView);

		mainLayout.addView(descriptionTextView);
		mainLayout.addView(seminarButton);






		

		if(!(MyUIApplication.speakerId.equals("-1")))
		{
			_objSpeakerWrapper = MyUIApplication._objSpeakerListDB.getRecord(MyUIApplication.speakerId);

			if(_objSpeakerWrapper !=null)
			{
				postTextView.setText(_objSpeakerWrapper.post);
				companyNameTextView.setText(_objSpeakerWrapper.companyname);
				descriptionTextView.setText(_objSpeakerWrapper.description);
				
				new GetImage(_objSpeakerWrapper.image, this).execute();			
				try {
					((Home)context)._objUtilTopBar.Heading.setText(_objSpeakerWrapper.name.trim());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				if(_objSpeakerWrapper.favourites.equals("true"))
				{
					ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favourites.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
				}
				else if(_objSpeakerWrapper.favourites.equals("false"))
				{
					ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favouritesnonsel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
				}
				
			}

//			MyUIApplication.speakerId ="-1";
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


					ViewGroup.LayoutParams params_innerLinearLayout = innerLinearLayout.getLayoutParams();
					params_innerLinearLayout.height=(int)(.5f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innerLinearLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					innerLinearLayout.setLayoutParams(params_innerLinearLayout);

					LinearLayout.LayoutParams params_speakerImage =(LinearLayout.LayoutParams) speakerImage.getLayoutParams();
					params_speakerImage.height=(int)(.4f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.width=(int)(.35f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.bottomMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.gravity=Gravity.LEFT | Gravity.TOP;
					speakerImage.setLayoutParams(params_speakerImage);


					LinearLayout.LayoutParams params_innermostLinear =(LinearLayout.LayoutParams) innermostLinear.getLayoutParams();
					params_innermostLinear.height=(int)(.4f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innermostLinear.width=(int)(.55f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.topMargin=(int)(.03f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innermostLinear.bottomMargin=(int)(.03f*heightLLTopCopyPer*((Home)context).deviceHeight);
					innermostLinear.setLayoutParams(params_innermostLinear);


					LinearLayout.LayoutParams params_postFavFrame =(LinearLayout.LayoutParams) postFavFrame.getLayoutParams();
					params_postFavFrame.height=(int)(.2f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_postFavFrame.width=(int)(.55f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_postFavFrame.gravity=Gravity.CENTER_VERTICAL;
					postFavFrame.setLayoutParams(params_postFavFrame);


					FrameLayout.LayoutParams params_postTextView =(FrameLayout.LayoutParams) postTextView.getLayoutParams();
					params_postTextView.height=(int)(.2f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_postTextView.width=(int)(.4f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_postTextView.gravity=Gravity.LEFT | Gravity.CENTER_VERTICAL;
					postTextView.setLayoutParams(params_postTextView);

					postTextView.setGravity(Gravity.CENTER_VERTICAL);
					postTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(postTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					FrameLayout.LayoutParams params_favButton =(FrameLayout.LayoutParams) favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.15f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_favButton.gravity=Gravity.RIGHT| Gravity.CENTER_VERTICAL;
					favButton.setLayoutParams(params_favButton);

					companyNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(companyNameTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) descriptionTextView.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					descriptionTextView.setLayoutParams(params_descriptionTextView);
					descriptionTextView.setBackgroundResource(R.drawable.search_speaker);



					descriptionTextView.setPadding((int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight));
					descriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(descriptionTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_seminarButton =(LinearLayout.LayoutParams) seminarButton.getLayoutParams();
					params_seminarButton.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.width=(int)(.5f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_seminarButton.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.bottomMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.gravity=Gravity.CENTER;
					seminarButton.setLayoutParams(params_seminarButton);
					seminarButton.setText("SEMINAR");
					seminarButton.setGravity(Gravity.CENTER);

					seminarButton.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(seminarButton.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));




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


					ViewGroup.LayoutParams params_innerLinearLayout = innerLinearLayout.getLayoutParams();
					params_innerLinearLayout.height=(int)(.5f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innerLinearLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					innerLinearLayout.setLayoutParams(params_innerLinearLayout);

					LinearLayout.LayoutParams params_speakerImage =(LinearLayout.LayoutParams) speakerImage.getLayoutParams();
					params_speakerImage.height=(int)(.4f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.width=(int)(.35f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.bottomMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.gravity=Gravity.LEFT | Gravity.TOP;
					speakerImage.setLayoutParams(params_speakerImage);


					LinearLayout.LayoutParams params_innermostLinear =(LinearLayout.LayoutParams) innermostLinear.getLayoutParams();
					params_innermostLinear.height=(int)(.4f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innermostLinear.width=(int)(.55f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.topMargin=(int)(.03f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innermostLinear.bottomMargin=(int)(.03f*heightLLTopCopyPer*((Home)context).deviceHeight);
					innermostLinear.setLayoutParams(params_innermostLinear);


					LinearLayout.LayoutParams params_postFavFrame =(LinearLayout.LayoutParams) postFavFrame.getLayoutParams();
					params_postFavFrame.height=(int)(.2f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_postFavFrame.width=(int)(.55f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_postFavFrame.gravity=Gravity.CENTER_VERTICAL;
					postFavFrame.setLayoutParams(params_postFavFrame);
					

					FrameLayout.LayoutParams params_postTextView =(FrameLayout.LayoutParams) postTextView.getLayoutParams();
					params_postTextView.height=(int)(.2f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_postTextView.width=(int)(.4f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_postTextView.gravity=Gravity.LEFT | Gravity.CENTER_VERTICAL;
					postTextView.setLayoutParams(params_postTextView);

					postTextView.setGravity(Gravity.CENTER_VERTICAL);
					postTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(postTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_favButton =(FrameLayout.LayoutParams) favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.15f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_favButton.gravity=Gravity.RIGHT| Gravity.CENTER_VERTICAL;
					favButton.setLayoutParams(params_favButton);

					companyNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(companyNameTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) descriptionTextView.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					descriptionTextView.setLayoutParams(params_descriptionTextView);
					descriptionTextView.setBackgroundResource(R.drawable.search_speaker);



					descriptionTextView.setPadding((int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight));
					descriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(descriptionTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_seminarButton =(LinearLayout.LayoutParams) seminarButton.getLayoutParams();
					params_seminarButton.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.width=(int)(.5f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_seminarButton.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.bottomMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.gravity=Gravity.CENTER;
					seminarButton.setLayoutParams(params_seminarButton);
					seminarButton.setText("SEMINAR");
					seminarButton.setGravity(Gravity.CENTER);

					seminarButton.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(seminarButton.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));




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


					ViewGroup.LayoutParams params_innerLinearLayout = innerLinearLayout.getLayoutParams();
					params_innerLinearLayout.height=(int)(.5f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innerLinearLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					innerLinearLayout.setLayoutParams(params_innerLinearLayout);

					LinearLayout.LayoutParams params_speakerImage =(LinearLayout.LayoutParams) speakerImage.getLayoutParams();
					params_speakerImage.height=(int)(.4f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.width=(int)(.35f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_speakerImage.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.bottomMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_speakerImage.gravity=Gravity.LEFT | Gravity.TOP;
					speakerImage.setLayoutParams(params_speakerImage);


					LinearLayout.LayoutParams params_innermostLinear =(LinearLayout.LayoutParams) innermostLinear.getLayoutParams();
					params_innermostLinear.height=(int)(.4f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innermostLinear.width=(int)(.55f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_innermostLinear.topMargin=(int)(.03f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_innermostLinear.bottomMargin=(int)(.03f*heightLLTopCopyPer*((Home)context).deviceHeight);
					innermostLinear.setLayoutParams(params_innermostLinear);


					LinearLayout.LayoutParams params_postFavFrame =(LinearLayout.LayoutParams) postFavFrame.getLayoutParams();
					params_postFavFrame.height=(int)(.2f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_postFavFrame.width=(int)(.55f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_postFavFrame.gravity=Gravity.CENTER_VERTICAL;
					postFavFrame.setLayoutParams(params_postFavFrame);


					FrameLayout.LayoutParams params_postTextView =(FrameLayout.LayoutParams) postTextView.getLayoutParams();
					params_postTextView.height=(int)(.2f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_postTextView.width=(int)(.4f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_postTextView.gravity=Gravity.LEFT | Gravity.CENTER_VERTICAL;
					postTextView.setLayoutParams(params_postTextView);

					postTextView.setGravity(Gravity.CENTER_VERTICAL);
					postTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(postTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_favButton =(FrameLayout.LayoutParams) favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.15f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_favButton.gravity=Gravity.RIGHT| Gravity.CENTER_VERTICAL;
					favButton.setLayoutParams(params_favButton);

					companyNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(companyNameTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) descriptionTextView.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					descriptionTextView.setLayoutParams(params_descriptionTextView);
					descriptionTextView.setBackgroundResource(R.drawable.search_speaker);



					descriptionTextView.setPadding((int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight));
					descriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(descriptionTextView.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_seminarButton =(LinearLayout.LayoutParams) seminarButton.getLayoutParams();
					params_seminarButton.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.width=(int)(.5f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_seminarButton.topMargin=(int)(.04f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.bottomMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_seminarButton.gravity=Gravity.CENTER;
					seminarButton.setLayoutParams(params_seminarButton);
					seminarButton.setText("SEMINAR");
					seminarButton.setGravity(Gravity.CENTER);

					seminarButton.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(seminarButton.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));




					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);
					
					

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


					ViewGroup.LayoutParams params_innerLinearLayout = innerLinearLayout.getLayoutParams();
					params_innerLinearLayout.height=(int)(.5f*heightLLTopPer*((Home)context).deviceHeight);
					params_innerLinearLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					innerLinearLayout.setLayoutParams(params_innerLinearLayout);

					LinearLayout.LayoutParams params_speakerImage =(LinearLayout.LayoutParams) speakerImage.getLayoutParams();
					params_speakerImage.height=(int)(.4f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.width=(int)(.35f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.bottomMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.gravity=Gravity.LEFT | Gravity.TOP;
					speakerImage.setLayoutParams(params_speakerImage);


					LinearLayout.LayoutParams params_innermostLinear =(LinearLayout.LayoutParams) innermostLinear.getLayoutParams();
					params_innermostLinear.height=(int)(.4f*heightLLTopPer*((Home)context).deviceHeight);
					params_innermostLinear.width=(int)(.55f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.topMargin=(int)(.03f*heightLLTopPer*((Home)context).deviceHeight);
					params_innermostLinear.bottomMargin=(int)(.03f*heightLLTopPer*((Home)context).deviceHeight);
					innermostLinear.setLayoutParams(params_innermostLinear);


					LinearLayout.LayoutParams params_postFavFrame =(LinearLayout.LayoutParams) postFavFrame.getLayoutParams();
					params_postFavFrame.height=(int)(.2f*heightLLTopPer*((Home)context).deviceHeight);
					params_postFavFrame.width=(int)(.55f*widthLLTopPer*((Home)context).deviceWidth);
					params_postFavFrame.gravity=Gravity.CENTER_VERTICAL;
					postFavFrame.setLayoutParams(params_postFavFrame);


					FrameLayout.LayoutParams params_postTextView =(FrameLayout.LayoutParams) postTextView.getLayoutParams();
					params_postTextView.height=(int)(.2f*heightLLTopPer*((Home)context).deviceHeight);
					params_postTextView.width=(int)(.4f*widthLLTopPer*((Home)context).deviceWidth);
					params_postTextView.gravity=Gravity.LEFT | Gravity.CENTER_VERTICAL;
					postTextView.setLayoutParams(params_postTextView);

					postTextView.setGravity(Gravity.CENTER_VERTICAL);
					postTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(postTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_favButton =(FrameLayout.LayoutParams) favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.15f*widthLLTopPer*((Home)context).deviceWidth);
					params_favButton.gravity=Gravity.RIGHT| Gravity.CENTER_VERTICAL;
					favButton.setLayoutParams(params_favButton);



					companyNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(companyNameTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) descriptionTextView.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					descriptionTextView.setLayoutParams(params_descriptionTextView);
					descriptionTextView.setBackgroundResource(R.drawable.search_speaker);



					descriptionTextView.setPadding((int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight));
					descriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(descriptionTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_seminarButton =(LinearLayout.LayoutParams) seminarButton.getLayoutParams();
					params_seminarButton.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.width=(int)(.5f*widthLLTopPer*((Home)context).deviceWidth);
					params_seminarButton.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.bottomMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.gravity=Gravity.CENTER;
					seminarButton.setLayoutParams(params_seminarButton);
					seminarButton.setText("SEMINAR");
					seminarButton.setGravity(Gravity.CENTER);

					seminarButton.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(seminarButton.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));




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
					
					System.out.println("QQQQQQQQ.. ...  ...  "+scrrenNumString);
				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					
					((Home)context).LLMiddle.addView(mainLayout);


					ViewGroup.LayoutParams params_innerLinearLayout = innerLinearLayout.getLayoutParams();
					params_innerLinearLayout.height=(int)(.5f*heightLLTopPer*((Home)context).deviceHeight);
					params_innerLinearLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					innerLinearLayout.setLayoutParams(params_innerLinearLayout);

					LinearLayout.LayoutParams params_speakerImage =(LinearLayout.LayoutParams) speakerImage.getLayoutParams();
					params_speakerImage.height=(int)(.4f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.width=(int)(.35f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.bottomMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.gravity=Gravity.LEFT | Gravity.TOP;
					speakerImage.setLayoutParams(params_speakerImage);


					LinearLayout.LayoutParams params_innermostLinear =(LinearLayout.LayoutParams) innermostLinear.getLayoutParams();
					params_innermostLinear.height=(int)(.4f*heightLLTopPer*((Home)context).deviceHeight);
					params_innermostLinear.width=(int)(.55f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.topMargin=(int)(.03f*heightLLTopPer*((Home)context).deviceHeight);
					params_innermostLinear.bottomMargin=(int)(.03f*heightLLTopPer*((Home)context).deviceHeight);
					innermostLinear.setLayoutParams(params_innermostLinear);


					LinearLayout.LayoutParams params_postFavFrame =(LinearLayout.LayoutParams) postFavFrame.getLayoutParams();
					params_postFavFrame.height=(int)(.2f*heightLLTopPer*((Home)context).deviceHeight);
					params_postFavFrame.width=(int)(.55f*widthLLTopPer*((Home)context).deviceWidth);
					params_postFavFrame.gravity=Gravity.CENTER_VERTICAL;
					postFavFrame.setLayoutParams(params_postFavFrame);


					FrameLayout.LayoutParams params_postTextView =(FrameLayout.LayoutParams) postTextView.getLayoutParams();
					params_postTextView.height=(int)(.2f*heightLLTopPer*((Home)context).deviceHeight);
					params_postTextView.width=(int)(.4f*widthLLTopPer*((Home)context).deviceWidth);
					params_postTextView.gravity=Gravity.LEFT | Gravity.CENTER_VERTICAL;
					postTextView.setLayoutParams(params_postTextView);

					postTextView.setGravity(Gravity.CENTER_VERTICAL);
					postTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(postTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));



					FrameLayout.LayoutParams params_favButton =(FrameLayout.LayoutParams) favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.15f*widthLLTopPer*((Home)context).deviceWidth);
					params_favButton.gravity=Gravity.RIGHT| Gravity.CENTER_VERTICAL;
					favButton.setLayoutParams(params_favButton);




					companyNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(companyNameTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) descriptionTextView.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					descriptionTextView.setLayoutParams(params_descriptionTextView);
					descriptionTextView.setBackgroundResource(R.drawable.search_speaker);



					descriptionTextView.setPadding((int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight));
					descriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(descriptionTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_seminarButton =(LinearLayout.LayoutParams) seminarButton.getLayoutParams();
					params_seminarButton.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.width=(int)(.5f*widthLLTopPer*((Home)context).deviceWidth);
					params_seminarButton.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.bottomMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.gravity=Gravity.CENTER;
					seminarButton.setLayoutParams(params_seminarButton);
					seminarButton.setText("SEMINAR");
					seminarButton.setGravity(Gravity.CENTER);

					seminarButton.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(seminarButton.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));




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


					ViewGroup.LayoutParams params_innerLinearLayout = innerLinearLayout.getLayoutParams();
					params_innerLinearLayout.height=(int)(.5f*heightLLTopPer*((Home)context).deviceHeight);
					params_innerLinearLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					innerLinearLayout.setLayoutParams(params_innerLinearLayout);

					LinearLayout.LayoutParams params_speakerImage =(LinearLayout.LayoutParams) speakerImage.getLayoutParams();
					params_speakerImage.height=(int)(.4f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.width=(int)(.35f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_speakerImage.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.bottomMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_speakerImage.gravity=Gravity.LEFT | Gravity.TOP;
					speakerImage.setLayoutParams(params_speakerImage);


					LinearLayout.LayoutParams params_innermostLinear =(LinearLayout.LayoutParams) innermostLinear.getLayoutParams();
					params_innermostLinear.height=(int)(.4f*heightLLTopPer*((Home)context).deviceHeight);
					params_innermostLinear.width=(int)(.55f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_innermostLinear.topMargin=(int)(.03f*heightLLTopPer*((Home)context).deviceHeight);
					params_innermostLinear.bottomMargin=(int)(.03f*heightLLTopPer*((Home)context).deviceHeight);
					innermostLinear.setLayoutParams(params_innermostLinear);


					LinearLayout.LayoutParams params_postFavFrame =(LinearLayout.LayoutParams) postFavFrame.getLayoutParams();
					params_postFavFrame.height=(int)(.2f*heightLLTopPer*((Home)context).deviceHeight);
					params_postFavFrame.width=(int)(.55f*widthLLTopPer*((Home)context).deviceWidth);
					params_postFavFrame.gravity=Gravity.CENTER_VERTICAL;
					postFavFrame.setLayoutParams(params_postFavFrame);


					FrameLayout.LayoutParams params_postTextView =(FrameLayout.LayoutParams) postTextView.getLayoutParams();
					params_postTextView.height=(int)(.2f*heightLLTopPer*((Home)context).deviceHeight);
					params_postTextView.width=(int)(.4f*widthLLTopPer*((Home)context).deviceWidth);
					params_postTextView.gravity=Gravity.LEFT | Gravity.CENTER_VERTICAL;
					postTextView.setLayoutParams(params_postTextView);

					postTextView.setGravity(Gravity.CENTER_VERTICAL);
					postTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(postTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));

					FrameLayout.LayoutParams params_favButton =(FrameLayout.LayoutParams) favButton.getLayoutParams();
					params_favButton.height=(int)(.12f*heightLLTopPer*((Home)context).deviceHeight);
					params_favButton.width=(int)(.15f*widthLLTopPer*((Home)context).deviceWidth);
					params_favButton.gravity=Gravity.RIGHT| Gravity.CENTER_VERTICAL;
					favButton.setLayoutParams(params_favButton);


					companyNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(companyNameTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) descriptionTextView.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					descriptionTextView.setLayoutParams(params_descriptionTextView);
					descriptionTextView.setBackgroundResource(R.drawable.search_speaker);



					descriptionTextView.setPadding((int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight),
							(int)(.02f*widthLLTopPer*((Home)context).deviceWidth),
							(int)(.01f*heightLLTopPer*((Home)context).deviceHeight));
					descriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(descriptionTextView.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					LinearLayout.LayoutParams params_seminarButton =(LinearLayout.LayoutParams) seminarButton.getLayoutParams();
					params_seminarButton.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.width=(int)(.5f*widthLLTopPer*((Home)context).deviceWidth);
					params_seminarButton.topMargin=(int)(.04f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.bottomMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					params_seminarButton.gravity=Gravity.CENTER;
					seminarButton.setLayoutParams(params_seminarButton);
					seminarButton.setText("SEMINAR");
					seminarButton.setGravity(Gravity.CENTER);

					seminarButton.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(seminarButton.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));




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

		try {
			if(scrrenNumString.length()>0)
			{
				seminarButton.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						((Home)context).OpenHtmlPage(scrrenNumString,"");
						MyUIApplication.StateMachine.add(scrrenNumString);
					}
				}) ;
				
			}
			
			favButton.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if(_objSpeakerWrapper != null)
					{
						if(_objSpeakerWrapper.favourites.equals("false"))
						{
							MyUIApplication._objSpeakerListDB.favourites(_objSpeakerWrapper.id,_objSpeakerWrapper.favourites);
							ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favourites.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
							_objSpeakerWrapper.favourites="true";
						}
						else if(_objSpeakerWrapper.favourites.equals("true"))
						{
							MyUIApplication._objSpeakerListDB.favourites(_objSpeakerWrapper.id,_objSpeakerWrapper.favourites);
							ImageUtil.setBackgroundBgFromAssetsNotCache(favButton, context, "images/favouritesnonsel.png", (int)(.05f*((Home)context).deviceHeight), (int)(.05f*((Home)context).deviceWidth));
							_objSpeakerWrapper.favourites="false";
						}
					}
					
				}
			});
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	 class GetImage extends AsyncTask<Void, Void, Void>
	 {
	 	String imageUrl;
	 	UtilSpeakerDetail _obj;
	 	Bitmap img;
	 	public GetImage(String imageUrl,UtilSpeakerDetail _obj) {
	 		// TODO Auto-generated constructor stub
	 		this.imageUrl = imageUrl;
	 		this._obj =_obj;
	 	}
	 	@Override
	 	protected Void doInBackground(Void... params) {
	 		// TODO Auto-generated method stub
	 		img =LoadImageFromUrl(imageUrl);


	 		return null;
	 	}
	 	
	 	public  Bitmap LoadImageFromUrl(String imageUrl) {
	 		Bitmap img;
	 		
	 		try {
	 			URL url = new URL(imageUrl);
	 			HttpURLConnection connection  = (HttpURLConnection) url.openConnection();

	 			InputStream is = connection.getInputStream();
	 			img = BitmapFactory.decodeStream(is);  
	 		} catch (Exception e) {
	 			return null;
	 		}
	 		return img;
	 	}
	 	
	 	@Override
	 	protected void onPostExecute(Void result) {
	 		// TODO Auto-generated method stub
	 		super.onPostExecute(result);
	 		
	 		Drawable d = new BitmapDrawable(img);
	 		if(d !=null)
	 		_obj.speakerImage.setBackgroundDrawable(d );
	 	}
	 }
	
}


