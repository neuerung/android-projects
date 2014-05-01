package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;



public class UtilFriendsCode {


	// *** Set Grid View ****
	public void SetFriendsCode(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{
		final ArrayList<ElementWrapper> _objList = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);

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

		Button BTN1 = new Button(context);
		RelView.addView(BTN1);


		Button BTN2 = new Button(context);
		RelView.addView(BTN2);
		BTN1.setId(101);
		BTN2.setId(102);

		BTN1.setTextColor(Color.BLACK);
		BTN2.setTextColor(Color.BLACK);

		BTN1.setText("Enter Friend's Code");
		BTN2.setText("Request Friend's Code");
		BTN1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(BTN1.getTypeface(),(0.35f*.1f*((Home)context).deviceHeight)));
		BTN2.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(BTN2.getTypeface(),(0.35f*.1f*((Home)context).deviceHeight)));

		RelativeLayout.LayoutParams params_BTN1 = (RelativeLayout.LayoutParams)BTN1.getLayoutParams();
		params_BTN1.height=(int)(.08f*((Home)context).deviceHeight);
		params_BTN1.topMargin=(int)(.1f*((Home)context).deviceHeight);
		params_BTN1.width=(int)(.6f*((Home)context).deviceWidth);
		params_BTN1.addRule(RelativeLayout.CENTER_HORIZONTAL);
		BTN1.setLayoutParams(params_BTN1);



		RelativeLayout.LayoutParams params_BTN2 = (RelativeLayout.LayoutParams)BTN2.getLayoutParams();
		params_BTN2.height=(int)(.08f*((Home)context).deviceHeight);
		params_BTN2.topMargin=(int)(.28f*((Home)context).deviceHeight);
		params_BTN2.width=(int)(.6f*((Home)context).deviceWidth);
		params_BTN2.addRule(RelativeLayout.CENTER_HORIZONTAL);
		BTN2.setLayoutParams(params_BTN2);

		BTN1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(_objList.size()>0)
				{
					String screenNumber = _objList.get(0).OnClick.substring(12);
					if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
					{
						((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
						((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
					}
					if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
					{
						((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
						((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
					}
					((Home)context).OpenHtmlPage(screenNumber,"");
					MyUIApplication.StateMachine.add(screenNumber);

					int i=MyUIApplication.StateMachine.size();
					System.out.println("State Machine Size >>>"+i);
				}
			}
		});
		BTN2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if(_objList.size()>1)
				{
				String screenNumber="140";
				if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
				{
					((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
					((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
				}
				if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
				{
					((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
					((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
				}
				((Home)context).OpenHtmlPage(screenNumber,"");
				MyUIApplication.StateMachine.add(screenNumber);

				int i=MyUIApplication.StateMachine.size();
				System.out.println("State Machine Size >>>"+i);
				}

			}
		});

	}
}
