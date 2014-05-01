package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class UtilRegistration {


	String Section="";
	Context context;

	EditText[] fields;
	TextView[] titles;
	ScrollView scrollview;
	LinearLayout layout;
	Button submit;

	ArrayList<ElementWrapper> array;

	// **** Regisration for Type 31 *****
	public void SetShowUpdateList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{

		scrollview = new ScrollView(context);
		layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);

		submit = new Button(context);

		array = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);

		fields = new EditText[array.size()];
		titles = new TextView[array.size()];

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

		submit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				try {

					boolean validate=true;

					for(int i=0;i<fields.length;i++)
					{
						String s = fields[i].getText().toString();

						if(s.length()==0)
						{
							validate =false;
							break;
						}
					}

					if(validate)
					{
						for(int i=0;i<fields.length;i++)
						{
							keyValue= keyValue+titles[i].getText().toString()+"^"+fields[i].getText().toString()+"|";
						}
						if(keyValue.length()>0)
						{
							keyValue =keyValue.substring(0, keyValue.length()-1);

							new BadgeBGThread(context, "Registration", false).execute();
						}
					}
					else
					{
						Toast.makeText(context, "Please fill all the values", Toast.LENGTH_LONG).show();
					}


				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});


	}
	public String keyValue="";
	private void createForm(double width,double height) throws NullPointerException
	{

		scrollview.addView(layout);

		ViewGroup.LayoutParams params_layout = layout.getLayoutParams();
		params_layout.height=(int)(height*((Home)context).deviceHeight);
		params_layout.width=(int)(width*((Home)context).deviceWidth);
		layout.setLayoutParams(params_layout);


		for(int i=0;i<array.size();i++)
		{

			LinearLayout innerLayout = new LinearLayout(context);
			innerLayout.setOrientation(LinearLayout.HORIZONTAL);


			fields[i] = new EditText(context);
			titles[i] = new TextView(context);
			titles[i].setTextColor(Color.BLACK);


			innerLayout.addView(titles[i]);
			innerLayout.addView(fields[i]);

			layout.addView(innerLayout);

			LinearLayout.LayoutParams params_innerLayout =(LinearLayout.LayoutParams) innerLayout.getLayoutParams();
			params_innerLayout.height=(int)(.1f*height*((Home)context).deviceHeight);
			params_innerLayout.topMargin=(int)(.02f*height*((Home)context).deviceHeight);
			params_innerLayout.width=(int)(width*((Home)context).deviceWidth);
			params_innerLayout.rightMargin=(int)(.02f*width*((Home)context).deviceWidth);
			params_innerLayout.leftMargin=(int)(.02f*width*((Home)context).deviceWidth);
			innerLayout.setLayoutParams(params_innerLayout);

			LinearLayout.LayoutParams params_titles =(LinearLayout.LayoutParams) titles[i].getLayoutParams();
			params_titles.height=(int)(.1f*height*((Home)context).deviceHeight);
			params_titles.width=(int)(.2f*width*((Home)context).deviceWidth);
			params_titles.gravity=Gravity.CENTER_VERTICAL;
			titles[i].setLayoutParams(params_titles);
			titles[i].setGravity(Gravity.CENTER_VERTICAL);
			titles[i].setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
					determineTextSize(titles[i].getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.35f)));
			titles[i].setText(array.get(i).Title);


			LinearLayout.LayoutParams params_fields =(LinearLayout.LayoutParams) fields[i].getLayoutParams();
			params_fields.height=(int)(.1f*height*((Home)context).deviceHeight);
			params_fields.width=(int)(.69f*width*((Home)context).deviceWidth);
			params_fields.rightMargin=(int)(.02f*width*((Home)context).deviceWidth);
			params_fields.leftMargin=(int)(.02f*width*((Home)context).deviceWidth);
			params_fields.gravity=Gravity.CENTER_VERTICAL;
			fields[i].setLayoutParams(params_fields);



		}


		layout.addView(submit);

		LinearLayout.LayoutParams params_submit =(LinearLayout.LayoutParams) submit.getLayoutParams();
		params_submit.height=(int)(.1f*height*((Home)context).deviceHeight);
		params_submit.topMargin=(int)(.03f*height*((Home)context).deviceHeight);
		params_submit.width=(int)(.3f*width*((Home)context).deviceWidth);
		//		params_submit.rightMargin=(int)(.02f*width*((Home)context).deviceWidth);
		//		params_submit.leftMargin=(int)(.02f*width*((Home)context).deviceWidth);
		params_submit.gravity=Gravity.CENTER;
		submit.setLayoutParams(params_submit);
		submit.setText("SUBMIT");
		submit.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(submit.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.4f)));
	}

	public void isRegistrationSuccessfull(String message)
	{
		if(message.equals("Thank you for your registration"))
		{
			Toast.makeText(context, "Thank you for your registration", Toast.LENGTH_LONG).show();
		}
		else
			if(message.equals("Email is not Valid"))
			{
				Toast.makeText(context, "Email is not Valid", Toast.LENGTH_LONG).show();
			}
			else
				if(message.length()==0)
				{
					Toast.makeText(context, "Registration Unsuccessfull", Toast.LENGTH_LONG).show();
				}

	}

}
