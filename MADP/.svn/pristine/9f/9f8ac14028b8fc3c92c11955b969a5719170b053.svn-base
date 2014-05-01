package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.Adapters.HomeAdaptorList;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;


public class UtilListView {


	// *** Set Grid View ****
	public void SetListView(ScreenPartWrapper _objScreenPartWrapper, String Section , Context context)
	{
		ArrayList<ElementWrapper> _objEWList = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);
		if(MyUIApplication.Copy)
		{

			try
			{
				final ListView LView= new ListView(context);
				try {
					LView.setDivider(new ColorDrawable(Color.parseColor(_objEWList.get(0).dividerColor)));
					LView.setDividerHeight((int)(.003*((Home)context).deviceHeight));
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
					
					if(_objScreenPartWrapper.TopbgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(LView, context, _objScreenPartWrapper.TopbgImage, LView.getLayoutParams().height, LView.getLayoutParams().width);

					}

					LView.setAdapter(null);
					LView.setAdapter(new HomeAdaptorList(context,_objEWList));
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
					LView.setAdapter(new HomeAdaptorList(context,_objEWList));
					LView.setSelection(MyUIApplication.CurrentScrollPosition);

					
					if(_objScreenPartWrapper.MidbgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(LView, context, _objScreenPartWrapper.MidbgImage, LView.getLayoutParams().height, LView.getLayoutParams().width);

					}
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


					HomeAdaptorList _objAdapter=new HomeAdaptorList(context,_objEWList);

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

						if(_objScreenPartWrapper.BottombgImage.trim().length()>0)
						{

							ImageUtil.setBgFromSDCardNotCache(LView, context, _objScreenPartWrapper.BottombgImage, LView.getLayoutParams().height, LView.getLayoutParams().width);

						}
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
					LView.setAdapter(new HomeAdaptorList(context,_objEWList));


					if(_objScreenPartWrapper.TopbgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(LView, context, _objScreenPartWrapper.TopbgImage, LView.getLayoutParams().height, LView.getLayoutParams().width);

					}

					//					LView.setSelection(MyUIApplication.CurrentScrollPosition);

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
					LView.setAdapter(new HomeAdaptorList(context,_objEWList));
					LView.setSelection(MyUIApplication.CurrentScrollPosition);

					if(_objScreenPartWrapper.MidbgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(LView, context, _objScreenPartWrapper.MidbgImage, LView.getLayoutParams().height, LView.getLayoutParams().width);

					}
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

					HomeAdaptorList _objAdapter=new HomeAdaptorList(context,_objEWList);
					try
					{
						LView.setAdapter(null);
						LView.setAdapter(_objAdapter);

						if(_objScreenPartWrapper.BottombgImage.trim().length()>0)
						{

							ImageUtil.setBgFromSDCardNotCache(LView, context, _objScreenPartWrapper.BottombgImage, LView.getLayoutParams().height, LView.getLayoutParams().width);

						}
						//						LView.setSelection(MyUIApplication.CurrentScrollPosition);

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
					}

					public void onScroll(AbsListView view, int firstVisibleItem,
							int visibleItemCount, int totalItemCount) {
						MyUIApplication.CurrentScrollPosition = view.getFirstVisiblePosition();
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
}
