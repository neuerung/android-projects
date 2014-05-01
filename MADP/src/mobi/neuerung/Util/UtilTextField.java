package mobi.neuerung.Util;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class UtilTextField {


	String Section="";
	Context context;

	ScrollView scrollview;
	LinearLayout layout;

	ElementWrapper _objElement;

	// **** TextField for Type 42 *****
	public void SetTextField(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{

		scrollview = new ScrollView(context);
		layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);


		_objElement = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		this.Section=Section;
		this.context=context;



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

					((Home)context).LLTopCopy.addView(scrollview);

					try {
						scrollview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						scrollview.setBackgroundColor(Color.WHITE);
						layout.setBackgroundColor(Color.WHITE);
					}

					createForm(widthLLTopCopyPer, heightLLTopCopyPer);

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

					((Home)context).LLMiddleCopy.addView(scrollview);

					try {
						scrollview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						scrollview.setBackgroundColor(Color.WHITE);
						layout.setBackgroundColor(Color.WHITE);
					}

					createForm(widthLLTopCopyPer, heightLLTopCopyPer);

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

					((Home)context).LLBottomCopy.addView(scrollview);

					try {
						scrollview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						scrollview.setBackgroundColor(Color.WHITE);
						layout.setBackgroundColor(Color.WHITE);
					}

					createForm(widthLLTopCopyPer, heightLLTopCopyPer);

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
			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(scrollview);

					try {
						scrollview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						scrollview.setBackgroundColor(Color.WHITE);
						layout.setBackgroundColor(Color.WHITE);
					}


					createForm(widthLLTopPer, heightLLTopPer);

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

					((Home)context).LLMiddle.addView(scrollview);


					try {
						scrollview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						scrollview.setBackgroundColor(Color.WHITE);
						layout.setBackgroundColor(Color.WHITE);
					}

					createForm(widthLLTopPer, heightLLTopPer);

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

					((Home)context).LLBottom.addView(scrollview);


					try {
						scrollview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						scrollview.setBackgroundColor(Color.WHITE);
						layout.setBackgroundColor(Color.WHITE);
					}

					createForm(widthLLTopPer, heightLLTopPer);

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



	}


	private void createForm(double width,double height) throws NullPointerException
	{
		try {

			int deviceHeight = ((Home)context).deviceHeight;
			int deviceWidth = ((Home)context).deviceWidth;

			scrollview.addView(layout);

			ViewGroup.LayoutParams params_layout = layout.getLayoutParams();
			params_layout.height=(int)(height*((Home)context).deviceHeight);
			params_layout.width=(int)(width*((Home)context).deviceWidth);
			layout.setLayoutParams(params_layout);

			TextView header = new TextView(context);
			layout.addView(header);

			header.setPadding((int)(.04f*deviceWidth), (int)(.02f*deviceHeight),
					(int)(.04f*deviceWidth),(int)(.02f*deviceHeight));

			TextView content = new TextView(context);
			layout.addView(content);

			try {
				Integer leftper = Integer.parseInt(_objElement.leftper);
				Integer rightPer = Integer.parseInt(_objElement.rightper);

				float leftperf = leftper/100.0f;
				float rightPerf = rightPer/100.0f;

				content.setPadding((int)(leftperf*deviceWidth), (int)(.02f*deviceHeight),
						(int)(rightPerf*deviceWidth),(int)(.02f*deviceHeight));
			} catch (Exception e) {
				// TODO: handle exception
				content.setPadding((int)(.04f*deviceWidth), (int)(.02f*deviceHeight),
						(int)(.04f*deviceWidth),(int)(.02f*deviceHeight));
			}

			try {
				if(_objElement.TitleGravity.equalsIgnoreCase("center"))
					header.setGravity(Gravity.CENTER);
				if(_objElement.TitleGravity.equalsIgnoreCase("right"))
					header.setGravity(Gravity.RIGHT);
				if(_objElement.TitleGravity.equalsIgnoreCase("left"))
					header.setGravity(Gravity.LEFT);
			} catch (Exception e) {
				// TODO: handle exception
				header.setGravity(Gravity.CENTER);
			}

			try {
				if(_objElement.SubTitleGravity.equalsIgnoreCase("center"))
					content.setGravity(Gravity.CENTER);
				if(_objElement.SubTitleGravity.equalsIgnoreCase("right"))
					content.setGravity(Gravity.RIGHT);
				if(_objElement.SubTitleGravity.equalsIgnoreCase("left"))
					content.setGravity(Gravity.LEFT);
			} catch (Exception e) {
				// TODO: handle exception
				content.setGravity(Gravity.CENTER);
			}



			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.fontStyle);
				header.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.subtitlefontStyle);
				content.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				header.setTextColor(Color.parseColor(_objElement.fontColor));
			} catch (Exception e) {
				// TODO: handle exception
				header.setTextColor(Color.BLACK);
			}

			try {
				content.setTextColor(Color.parseColor(_objElement.subtitlefontColor));
			} catch (Exception e) {
				// TODO: handle exception
				content.setTextColor(Color.BLACK);
			}

			try {
				int i = Integer.parseInt(_objElement.fontSize);
				float testsizepercent = i/960f;
				header.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(header.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				header.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(header.getTypeface(),(0.1f)*(.4f*deviceHeight)));
			}

			try {
				int i = Integer.parseInt(_objElement.subtitlefontSize);
				float testsizepercent = i/960f;
				content.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(header.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				content.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(header.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			}

			if(_objElement != null)
			{
				if(_objElement.Title.trim().length()>0)
				{
					header.setText(Html.fromHtml(_objElement.Title));
				}
				else
				{
					header.setVisibility(View.GONE);
				}

				if(_objElement.subTitle.trim().length()>0)
				{
					content.setText(Html.fromHtml(_objElement.subTitle));
				}
				else
				{
					content.setVisibility(View.GONE);
				}

				try {

				} catch (Exception e) {
					// TODO: handle exception
				}
			}


		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
