package mobi.neuerung.Util;

import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Sevices.GetMessageService;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.InputType;
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


public class UtilLogin {


	String Section="";
	Context context;

	EditText[] fields;
	TextView[] titles;
	ScrollView scrollview;
	LinearLayout layout;
	Button submit;
	ScreenPartWrapper _objScreenPartWrapper;
	String UrlLink;
	boolean iscopy;
	// **** Login for Type 37 *****
	public void SetShowUpdateList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{

		scrollview = new ScrollView(context);
		layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);

		submit = new Button(context);
		iscopy = MyUIApplication.Copy;
		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		fields = new EditText[2];
		titles = new TextView[2];

		this.Section=Section;
		this.context=context;
		this._objScreenPartWrapper =_objScreenPartWrapper;
		this.UrlLink =UrlLink;


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
						UserName = fields[0].getText().toString();
						Password = fields[1].getText().toString();
						new BadgeBGThread(context, "Login", false).execute();
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
	public String UserName="";
	public String Password="";
	private void createForm(double width,double height) throws NullPointerException
	{

		scrollview.addView(layout);

		ViewGroup.LayoutParams params_layout = layout.getLayoutParams();
		params_layout.height=(int)(height*((Home)context).deviceHeight);
		params_layout.width=(int)(width*((Home)context).deviceWidth);
		layout.setLayoutParams(params_layout);


		for(int i=0;i<2;i++)
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
			if(i==0)
				titles[i].setText("UserName");
			else			if(i==1)
			{
				titles[i].setText("Password");
				fields[i].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

			}
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

	public void isLoginSuccessfull(String message,String isEmailVerify)
	{
		if(message.equals("Login Successfully") && isEmailVerify.equals("True"))
		{
			Intent myIntent = new Intent(context,GetMessageService.class);
			
			context.startService(myIntent);
			
			MyUIApplication.UserName =UserName;

			((Home)context)._objUtilFriendsList.SetExhibitorList(_objScreenPartWrapper, Section, context, UrlLink,iscopy);
			
			
			
		}
		else if(message.equals("Login Successfully") && isEmailVerify.equalsIgnoreCase("False"))
		{
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					context);

			// set title
			alertDialogBuilder.setTitle("Verify Email");

			// set dialog message
			alertDialogBuilder
			.setMessage("Verify yor Email address")
			.setCancelable(false)
			.setPositiveButton("Verify",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {

					new BadgeBGThread(context, "Verify", false).execute();
				}
			})
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
			});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();
		}
		else
		{
			Toast.makeText(context, "Login Failed", Toast.LENGTH_LONG).show();
		}

	}


	public void isVerify(String message)
	{
		Toast.makeText(context, "URL Send to your Email Address. Please verify your email Address.", Toast.LENGTH_LONG).show();
	}

}
