package mobi.neuerung.Util;

import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;



public class UtilEnterFriendCode {

	public void SetEnterFriendsCode(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{

		final RelativeLayout RelView= new RelativeLayout(context);
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

					((Home)context).LLTopCopy.addView(RelView);

					ViewGroup.LayoutParams params_RelView = RelView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					RelView.setLayoutParams(params_RelView);

					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

					try
					{
						if(_objScreenPartWrapper.Topbgcolor.length()>0)
						{
							RelView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}


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
					try
					{
						if(_objScreenPartWrapper.Midbgcolor.length()>0)
						{
							RelView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}


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


					try
					{
						if(_objScreenPartWrapper.Bottombgcolor.length()>0)
						{
							RelView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

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

					((Home)context).LLTop.addView(RelView);

					ViewGroup.LayoutParams params_RelView = RelView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					RelView.setLayoutParams(params_RelView);

					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

					try
					{
						if(_objScreenPartWrapper.Topbgcolor.length()>0)
						{
							RelView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

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

					try
					{
						if(_objScreenPartWrapper.Midbgcolor.length()>0)
						{
							RelView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

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

					try
					{
						if(_objScreenPartWrapper.Bottombgcolor.length()>0)
						{
							RelView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

				}

			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}

		final EditText ET1 = new EditText(context);
		RelView.addView(ET1);
		ET1.setSingleLine(true);
		ET1.setGravity(Gravity.CENTER);
		ET1.setHint("Request Friend's Code");
		ET1.setTextColor(Color.BLACK);
		ET1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(ET1.getTypeface(),(0.3f*.1f*((Home)context).deviceHeight)));



		RelativeLayout.LayoutParams params_ET1 = (RelativeLayout.LayoutParams)ET1.getLayoutParams();
		params_ET1.height=(int)(.08f*((Home)context).deviceHeight);
		params_ET1.topMargin=(int)(.1f*((Home)context).deviceHeight);
		params_ET1.width=(int)(.7f*((Home)context).deviceWidth);
		params_ET1.leftMargin=(int)(.15f*((Home)context).deviceWidth);
		ET1.setLayoutParams(params_ET1);



		Button BTN1 = new Button(context);
		RelView.addView(BTN1);


		Button BTN2 = new Button(context);
		RelView.addView(BTN2);
		BTN1.setId(101);
		BTN2.setId(102);

		BTN1.setTextColor(Color.BLACK);
		BTN2.setTextColor(Color.BLACK);

		BTN1.setText("Ok");
		BTN2.setText("Cancel");
		BTN1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(BTN1.getTypeface(),(0.35f*.1f*((Home)context).deviceHeight)));
		BTN2.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(BTN2.getTypeface(),(0.35f*.1f*((Home)context).deviceHeight)));

		RelativeLayout.LayoutParams params_BTN1 = (RelativeLayout.LayoutParams)BTN1.getLayoutParams();
		params_BTN1.height=(int)(.08f*((Home)context).deviceHeight);
		params_BTN1.topMargin=(int)(.3f*((Home)context).deviceHeight);
		params_BTN1.width=(int)(.3f*((Home)context).deviceWidth);
		params_BTN1.leftMargin=(int)(.15f*((Home)context).deviceWidth);
		BTN1.setLayoutParams(params_BTN1);



		RelativeLayout.LayoutParams params_BTN2 = (RelativeLayout.LayoutParams)BTN2.getLayoutParams();
		params_BTN2.height=(int)(.08f*((Home)context).deviceHeight);
		params_BTN2.topMargin=(int)(.3f*((Home)context).deviceHeight);
		params_BTN2.width=(int)(.3f*((Home)context).deviceWidth);
		params_BTN2.leftMargin=(int)(.1f*((Home)context).deviceWidth);
		params_BTN2.addRule(RelativeLayout.RIGHT_OF,BTN1.getId());
		BTN2.setLayoutParams(params_BTN2);

		BTN1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(MyUIApplication.isInternetAvailable(context))
				{
					if(ET1.getText().toString().length()>0)
					{
						new BadgeBGThread(context, "EnterFriend'sCode", ET1.getText().toString()).execute();
					}
					else
					{
						Toast.makeText(context, "Please Enter Friend's Code", Toast.LENGTH_SHORT).show();
					}
				}
				else
				{
					MyUIApplication.AlertForInternet(context);
				}
			}
		});
		BTN2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				try
				{
					((Home)context).clearAllResources();
					try
					{
						if(UtilVideoGalleryDetail.videoview.isPlaying())
						{
							UtilVideoGalleryDetail.videoview.stopPlayback();
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println(e);
					}

					MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
					System.out.println("State Machine"+MyUIApplication.StateMachine);
					if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
					{
//						((Home)context).DesignHomeScreen();
						((Home)context).OpenHtmlPage("0", "");
						if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
						{
							((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
							((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
						}
						if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
						{
							((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
							((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
						}
					}
					else
					{
						String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);

						((Home)context).OpenHtmlPage(LastScreen,"");

						if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
						{
							((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
							((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
						}
						if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
						{
							((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
							((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
						}

					}
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println();
				}
			}
		});


	}
	public void isVerify(String Message,Context con)
	{
		Toast.makeText(con, Message, Toast.LENGTH_SHORT).show();
	}
}
