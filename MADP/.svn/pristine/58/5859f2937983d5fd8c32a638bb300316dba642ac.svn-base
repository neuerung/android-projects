package mobi.neuerung.Util;


import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ProductListWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;




public class UtilProductDetail {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	Button speakerImage;
	ProductListWrapper _objProductListWrapper=null;
	String scrrenNumString="";

	// **** Set Product Details for Type 35 *****
	public void SetProductDetail(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{

		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;

		LinearLayout mainLayout = new LinearLayout(context);
		mainLayout.setOrientation(LinearLayout.VERTICAL);

	
		TextView Description = new TextView(context);
		Description.setTextColor(Color.BLACK);

		mainLayout.addView(Description);

		_objProductListWrapper = MyUIApplication._objProductListDB.getRecord(UrlLink);

		if(_objProductListWrapper !=null)
		{
		
			Description.setText(_objProductListWrapper.Description);

			try {
				
				((Home)context)._objUtilTopBar.Heading.setText(_objProductListWrapper.ProductName.trim());

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

					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					

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

					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					



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

					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					



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

					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					



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

					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);
					



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


					LinearLayout.LayoutParams params_descriptionTextView =(LinearLayout.LayoutParams) Description.getLayoutParams();
					params_descriptionTextView.height=(int)(.3f*heightLLTopPer*((Home)context).deviceHeight);
					params_descriptionTextView.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_descriptionTextView.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					Description.setLayoutParams(params_descriptionTextView);

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



	}

}


