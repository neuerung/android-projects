package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.Adapters.HomeAdaptorList01;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.facebook.Session;
import com.facebook.android.Facebook;


public class UtilListView01 {

	private Context context;
	// *** Set Grid View ****
	public void SetListView(ScreenPartWrapper _objScreenPartWrapper, String Section , Context context)
	{
		this.context	=	 context;
		ArrayList<ElementWrapper> _objEWList = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);
		if(MyUIApplication.Copy)
		{

			try
			{
				final ListView LView= new ListView(context);

				try {
					LView.setDivider(new ColorDrawable(Color.parseColor(_objEWList.get(0).dividerColor)));
					LView.setDividerHeight((int)(.003f*((Home)context).deviceHeight));
				} catch (Exception e) {
					// TODO: handle exception
					LView.setDivider(new ColorDrawable(Color.WHITE));
					LView.setDividerHeight((int)(.003f*((Home)context).deviceHeight));
				}

				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

					try
					{
						if(_objScreenPartWrapper.Topbgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

					LView.setAdapter(null);
					LView.setAdapter(new HomeAdaptorList01(context,_objEWList));
					LView.setSelection(MyUIApplication.CurrentScrollPosition);

					//					LView.setOnTouchListener(new OnTouchListener() {
					//
					//
					//						public boolean onTouch(View v, MotionEvent event) {
					//
					//							switch(event.getAction()) {
					//
					//							case MotionEvent.ACTION_DOWN:
					//								LView.getBackground().setAlpha(150);
					//								//							return false;
					//								break;
					//							case MotionEvent.ACTION_UP:
					//								LView.getBackground().setAlpha(255);
					//								//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
					//								break;
					//							}
					//
					//							return false;
					//						}
					//
					//					});

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);
					try
					{
						if(_objScreenPartWrapper.Midbgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}


					LView.setAdapter(null);
					LView.setAdapter(new HomeAdaptorList01(context,_objEWList));
					LView.setSelection(MyUIApplication.CurrentScrollPosition);

					//					LView.setOnTouchListener(new OnTouchListener() {
					//
					//
					//						public boolean onTouch(View v, MotionEvent event) {
					//
					//							switch(event.getAction()) {
					//
					//							case MotionEvent.ACTION_DOWN:
					//								LView.getBackground().setAlpha(150);
					//								//							return false;
					//								break;
					//							case MotionEvent.ACTION_UP:
					//								LView.getBackground().setAlpha(255);
					//								//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
					//								break;
					//							}
					//
					//							return false;
					//						}
					//
					//					});

				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);


					HomeAdaptorList01 _objAdapter=new HomeAdaptorList01(context,_objEWList);

					try
					{
						if(_objScreenPartWrapper.Bottombgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

					try
					{
						LView.setAdapter(null);
						LView.setAdapter(_objAdapter);
						LView.setSelection(MyUIApplication.CurrentScrollPosition);

						//						LView.setOnTouchListener(new OnTouchListener() {
						//
						//
						//							public boolean onTouch(View v, MotionEvent event) {
						//
						//								switch(event.getAction()) {
						//
						//								case MotionEvent.ACTION_DOWN:
						//									LView.getBackground().setAlpha(150);
						//									//								return false;
						//									break;
						//								case MotionEvent.ACTION_UP:
						//									LView.getBackground().setAlpha(255);
						//									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
						//									break;
						//								}
						//
						//								return false;
						//							}
						//
						//						});
					}
					catch (Exception e)
					{
						System.out.println(""+e);
					}
				}
				LView.setVerticalFadingEdgeEnabled(false);

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
				final ListView LView= new ListView(context);

				try {
					LView.setDivider(new ColorDrawable(Color.parseColor(_objEWList.get(0).dividerColor)));
					LView.setDividerHeight((int)(.003f*((Home)context).deviceHeight));
				} catch (Exception e) {
					// TODO: handle exception
					LView.setDivider(new ColorDrawable(Color.WHITE));
					LView.setDividerHeight((int)(.003f*((Home)context).deviceHeight));
				}

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

					try
					{
						if(_objScreenPartWrapper.Topbgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}


					LView.setAdapter(null);
					LView.setAdapter(new HomeAdaptorList01(context,_objEWList));
					LView.setSelection(MyUIApplication.CurrentScrollPosition);

					//				LView.setOnTouchListener(new OnTouchListener() {
					//
					//
					//					public boolean onTouch(View v, MotionEvent event) {
					//
					//						switch(event.getAction()) {
					//
					//						case MotionEvent.ACTION_DOWN:
					//							LView.getBackground().setAlpha(150);
					//							//							return false;
					//							break;
					//						case MotionEvent.ACTION_UP:
					//							LView.getBackground().setAlpha(255);
					//							//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
					//							break;
					//						}
					//
					//						return false;
					//					}
					//
					//				});

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					try
					{
						if(_objScreenPartWrapper.Midbgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

					LView.setAdapter(null);
					LView.setAdapter(new HomeAdaptorList01(context,_objEWList));
					LView.setSelection(MyUIApplication.CurrentScrollPosition);

					//				LView.setOnTouchListener(new OnTouchListener() {
					//
					//
					//					public boolean onTouch(View v, MotionEvent event) {
					//
					//						switch(event.getAction()) {
					//
					//						case MotionEvent.ACTION_DOWN:
					//							LView.getBackground().setAlpha(150);
					//							//							return false;
					//							break;
					//						case MotionEvent.ACTION_UP:
					//							LView.getBackground().setAlpha(255);
					//							//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
					//							break;
					//						}
					//
					//						return false;
					//					}
					//
					//				});

				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

					try
					{
						if(_objScreenPartWrapper.Bottombgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

					HomeAdaptorList01 _objAdapter=new HomeAdaptorList01(context,_objEWList);
					try
					{
						LView.setAdapter(null);
						LView.setAdapter(_objAdapter);
						LView.setSelection(MyUIApplication.CurrentScrollPosition);

						//					LView.setOnTouchListener(new OnTouchListener() {
						//
						//
						//						public boolean onTouch(View v, MotionEvent event) {
						//
						//							switch(event.getAction()) {
						//
						//							case MotionEvent.ACTION_DOWN:
						//								LView.getBackground().setAlpha(150);
						//								//								return false;
						//								break;
						//							case MotionEvent.ACTION_UP:
						//								LView.getBackground().setAlpha(255);
						//								//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
						//								break;
						//							}
						//
						//							return false;
						//						}
						//
						//					});
					}
					catch (Exception e)
					{
						System.out.println(""+e);
					}
				}
				LView.setVerticalFadingEdgeEnabled(false);

				LView.setOnScrollListener(new OnScrollListener() {

					public void onScrollStateChanged(AbsListView view, int scrollState) {
						// TODO Auto-generated method stub

					}

					public void onScroll(AbsListView view, int firstVisibleItem,
							int visibleItemCount, int totalItemCount) {
						// TODO Auto-generated method stub
						MyUIApplication.CurrentScrollPosition = view.getFirstVisiblePosition();
						//						Toast.makeText(context, mCurrentX, Toast.LENGTH_SHORT).show();
						System.out.println("Scrollllllllll    "+MyUIApplication.CurrentScrollPosition);

					}
				});
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}
	}
	
	// Your Facebook APP ID
//	private static String APP_ID = "308180782571605"; // Replace your App ID here
//	public Facebook mFacebook = new Facebook(APP_ID);
//
//	public void loginToFacebook() {if( !mFacebook.isSessionValid() ) {
//		Toast.makeText(Home.this, "Authorizing", Toast.LENGTH_SHORT).show();
//		mFacebook.authorize(Home.this, new String[] { "" }, new LoginDialogListener());
//	}
//	else {
//		Toast.makeText( Login.this, "Has valid session", Toast.LENGTH_SHORT).show();
//		try {
//			JSONObject json = Util.parseJson(mFacebook.request("me"));
//			String facebookID = json.getString("id");
//			String firstName = json.getString("first_name");
//			String lastName = json.getString("last_name");
//			Toast.makeText(Login.this, "You already have a valid session, " + firstName + " " + lastName + ". No need to re-authorize.", Toast.LENGTH_SHORT).show();
//		}
//		catch( Exception error ) {
//			Toast.makeText( Login.this, error.toString(), Toast.LENGTH_SHORT).show();
//		}
//		catch( FacebookError error ) {
//			Toast.makeText( Login.this, error.toString(), Toast.LENGTH_SHORT).show();
//		}
//	}
//	}
//	}
}
