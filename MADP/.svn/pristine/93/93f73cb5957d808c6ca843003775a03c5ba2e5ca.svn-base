package mobi.neuerung.Util;

import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class UtilButtonBar {

	public void SetButtonBarView(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{
		MyUIApplication._objEWList = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);

		double PartHeight = 0.0; 
		double PartWidth = 0.0; 

		HorizontalScrollView scrollLayout = new HorizontalScrollView(context);
		LinearLayout LView= new LinearLayout(context);

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

					PartHeight = heightLLTopCopyPer;
					PartWidth = widthLLTopCopyPer;


					((Home)context).LLTopCopy.addView(scrollLayout);
					scrollLayout.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

					if(_objScreenPartWrapper.Topbgcolor.length()>0)
					{
						LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					}

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					PartHeight = heightLLTopCopyPer;
					PartWidth = widthLLTopCopyPer;


					((Home)context).LLMiddleCopy.addView(scrollLayout);
					scrollLayout.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					if(_objScreenPartWrapper.Midbgcolor.length()>0)
					{
						LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					}
				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					PartHeight = heightLLTopCopyPer;
					PartWidth = widthLLTopCopyPer;

					((Home)context).LLBottomCopy.addView(scrollLayout);
					scrollLayout.addView(LView);
					scrollLayout.setBackgroundColor(Color.RED);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);

					if(_objScreenPartWrapper.Bottombgcolor.length()>0)
					{
						LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
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

					PartHeight = heightLLTopPer;
					PartWidth = widthLLTopPer;

					((Home)context).LLTop.addView(scrollLayout);
					scrollLayout.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

					if(_objScreenPartWrapper.Topbgcolor.length()>0)
					{
						LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					}

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					PartHeight = heightLLTopPer;
					PartWidth = widthLLTopPer;

					((Home)context).LLMiddle.addView(scrollLayout);
					scrollLayout.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					if(_objScreenPartWrapper.Midbgcolor.length()>0)
					{
						LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					}

				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					PartHeight = heightLLTopPer;
					PartWidth = widthLLTopPer;

					((Home)context).LLBottom.addView(scrollLayout);
					scrollLayout.addView(LView);
					scrollLayout.setBackgroundColor(Color.RED);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

					if(_objScreenPartWrapper.Bottombgcolor.length()>0)
					{
						LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					}
				}

			}
			catch (Exception e) {
				System.out.println("Exception in Util Bottom Bar copy"+e);
			}

		}
		scrollLayout.setScrollbarFadingEnabled(false);
		scrollLayout.setHorizontalFadingEdgeEnabled(false);
		scrollLayout.setHorizontalScrollBarEnabled(false);
		//		scrollLayout.setScrollbarFadingEnabled(false);
		//		scrollLayout.setScrollBarStyle(SCROLLBARS_OUTSIDE_INSET); m)
		try{
			for(int i =0; i<MyUIApplication._objEWList.size();i++)
			{
				ElementWrapper EWrapper = MyUIApplication._objEWList.get(i);

				FrameButton = new FrameLayout(context);
				LView.addView(FrameButton);

				double ButtonHeight = (Double.parseDouble(EWrapper.height)*PartHeight)/100;
				//				double ButtonWidth = (Double.parseDouble(EWrapper.width)*PartWidth)/100;

				double ButtonWidth =0.0;
				if(MyUIApplication._objEWList.size() == 1)
				{
					ButtonWidth = 1.0;
				}
				else if(MyUIApplication._objEWList.size() == 2)
				{
					ButtonWidth = .5;
				}
				else if(MyUIApplication._objEWList.size() == 3)
				{
					ButtonWidth = .333;
				}
				else if(MyUIApplication._objEWList.size() == 4)
				{
					ButtonWidth = .25;
				}
				else
				{
					ButtonWidth = .25;
				}

				LinearLayout.LayoutParams FrameButton_param = (LinearLayout.LayoutParams)FrameButton.getLayoutParams();
				FrameButton_param.height = (int)(((Home)context).deviceHeight*ButtonHeight);
				FrameButton_param.width = (int)(Math.round(((Home)context).deviceWidth*ButtonWidth));
				//				FrameButton_param.leftMargin = (int)(((Home)context).deviceWidth*disteft);
				FrameButton.setLayoutParams(FrameButton_param);
				if(EWrapper.OnClick.length()>0)
				{
					FrameButton.setId(Integer.parseInt(EWrapper.OnClick.substring(12)));
				}

				if(EWrapper.Bitmap.length()>0)
				{

				}
				else if(EWrapper.bgcolor.length()>0)
				{
					FrameButton.setBackgroundColor(Color.parseColor(EWrapper.bgcolor));
				}


				TextView txt = new TextView(context);
				FrameButton.addView(txt);

				FrameLayout.LayoutParams txt_param = (FrameLayout.LayoutParams)txt.getLayoutParams();
				txt_param = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
				txt.setLayoutParams(txt_param);

				txt.setText(EWrapper.Title);
				txt.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(txt.getTypeface(),(0.4f)*(int)(.1f*((Home)context).deviceHeight)));

				FrameButton.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						switch(event.getAction()) 
						{

						case MotionEvent.ACTION_DOWN:
							FrameButton.getBackground().setAlpha(150);
							//		        	holder.GridButtonTV.getBackground().setAlpha(150);
							//					return false;
							return true;
						case MotionEvent.ACTION_UP:
							FrameButton.getBackground().setAlpha(255);
							try
							{
								String screenNumber = ""+v.getId();

								if(screenNumber.length()>0)
								{


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
							catch (Exception e) {
								// TODO: handle exception
								System.out.println();
							}

							break;
						case MotionEvent.ACTION_CANCEL:
							FrameButton.getBackground().setAlpha(255);
							break;
						}

						return false;
					}
				});
			}
		}
		catch (Exception e) {
			System.out.println("Exception in Setting Buttons in Linear Layout of UtilButtonBar Class"+e);
		}
	}
	FrameLayout FrameButton;
}
