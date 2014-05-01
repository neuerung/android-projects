package mobi.neuerung.Util;


import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;


@SuppressWarnings("deprecation")
public class UtilButton {


	String Section="";
	Context context;

	AbsoluteLayout layout;
	
	ArrayList<ElementWrapper> Elementarray;

	int height,width;
	// **** Buttons at x y position for Type 43 *****
	public void SetButtons(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{

		layout = new AbsoluteLayout(context);
		Elementarray = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);

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

					((Home)context).LLTopCopy.addView(layout);

					try {
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						layout.setBackgroundColor(Color.WHITE);
					}


					try {

						if(_objScreenPartWrapper.TopbgImage.trim().length()>0)
						{

							ImageUtil.setBgFromSDCardNotCache(layout, context, _objScreenPartWrapper.TopbgImage, (int)(heightLLTopCopyPer*((Home)context).deviceHeight), (int)(widthLLTopCopyPer*((Home)context).deviceWidth));

						}
					} catch (Exception e) {
						// TODO: handle exception
					}


					createForm(widthLLTopCopyPer, heightLLTopCopyPer);

					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);
					
					//Saving parent height width
					height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(layout);

					try {
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						layout.setBackgroundColor(Color.WHITE);
					}

					try {

						if(_objScreenPartWrapper.MidbgImage.trim().length()>0)
						{

							//							Snippet.getBitmapFromSDCard(context,  _objScreenPartWrapper.MidbgImage, height, (int)(heightLLTopCopyPer*((Home)context).deviceWidth))
							ImageUtil.setBgFromSDCardNotCache(layout, context, _objScreenPartWrapper.MidbgImage, (int)(heightLLTopCopyPer*((Home)context).deviceHeight), (int)(widthLLTopCopyPer*((Home)context).deviceWidth));
//							ImageUtil.setBgFromSDCardNotCachewithCropMode(layout, context, _objScreenPartWrapper.MidbgImage, (int)(heightLLTopCopyPer*((Home)context).deviceHeight), (int)(widthLLTopCopyPer*((Home)context).deviceWidth));

						}
					} catch (Exception e) {
						// TODO: handle exception
					}

					

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);


					//Saving parent height width
					height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					
					createForm(widthLLTopCopyPer, heightLLTopCopyPer);
				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLBottomCopy.addView(layout);

					try {
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						layout.setBackgroundColor(Color.WHITE);
					}


					try {

						if(_objScreenPartWrapper.BottombgImage.trim().length()>0)
						{
							ImageUtil.setBgFromSDCardNotCache(layout, context, _objScreenPartWrapper.MidbgImage, (int)(heightLLTopCopyPer*((Home)context).deviceHeight), (int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					

					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);
					
					//Saving parent height width
					height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					
					createForm(widthLLTopCopyPer, heightLLTopCopyPer);
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

					((Home)context).LLTop.addView(layout);

					try {
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						layout.setBackgroundColor(Color.WHITE);
					}


					try {

						if(_objScreenPartWrapper.TopbgImage.trim().length()>0)
						{

							ImageUtil.setBgFromSDCardNotCache(layout, context, _objScreenPartWrapper.TopbgImage, (int)(heightLLTopPer*((Home)context).deviceHeight), (int)(widthLLTopPer*((Home)context).deviceWidth));

						}
					} catch (Exception e) {
						// TODO: handle exception
					}


					createForm(widthLLTopPer, heightLLTopPer);

					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);
					
					//Saving parent height width
					height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					width=(int)(widthLLTopPer*((Home)context).deviceWidth);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(layout);


					try {
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						layout.setBackgroundColor(Color.WHITE);
					}


					try {

						if(_objScreenPartWrapper.MidbgImage.trim().length()>0)
						{ 
							ImageUtil.setBgFromSDCardNotCache(layout, context, _objScreenPartWrapper.MidbgImage, (int)(heightLLTopPer*((Home)context).deviceHeight), (int)(widthLLTopPer*((Home)context).deviceWidth));
//							ImageUtil.setBgFromSDCardNotCachewithCropMode(layout, context, _objScreenPartWrapper.MidbgImage, (int)(heightLLTopPer*((Home)context).deviceHeight), (int)(widthLLTopPer*((Home)context).deviceWidth));
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

					

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);
					
					//Saving parent height width
					height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					
					createForm(widthLLTopPer, heightLLTopPer);

				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLBottom.addView(layout);


					try {
						layout.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						layout.setBackgroundColor(Color.WHITE);
					}

					try {

						if(_objScreenPartWrapper.BottombgImage.trim().length()>0)
						{

							ImageUtil.setBgFromSDCardNotCache(layout, context, _objScreenPartWrapper.BottombgImage, (int)(heightLLTopPer*((Home)context).deviceHeight), (int)(widthLLTopPer*((Home)context).deviceWidth));

						}
					} catch (Exception e) {
						// TODO: handle exception
					}


					createForm(widthLLTopPer, heightLLTopPer);

					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);
					
					//Saving parent height width
					height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					width=(int)(widthLLTopPer*((Home)context).deviceWidth);

				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println(""+e);
			}
		}



	}


	private void createForm(double width,double height) throws NullPointerException
	{
		try {

			/**Parent layout height and width */
			System.out.println("Paresnt Layout Height"+ this.height);
			System.out.println("Paresnt Layout width"+ this.width);

			int deviceHeight = ((Home)context).deviceHeight;
			int deviceWidth = ((Home)context).deviceWidth;

			ViewGroup.LayoutParams params_layout = layout.getLayoutParams();
			params_layout.height=(int)(height*deviceHeight);
			params_layout.width=(int)(width*deviceWidth);
			layout.setLayoutParams(params_layout);

			
			for (int i = 0; i < Elementarray.size(); i++)
			{
				final	ElementWrapper _objElementWrapper = Elementarray.get(i);

				if(_objElementWrapper.Title.trim().length()>0)
				{


					Button b = new Button(context);

					layout.addView(b);

//					b.setBackgroundColor(Color.WHITE);
					Float xper,yper;
					try {
						xper = Float.parseFloat(_objElementWrapper.xper.trim());
						xper = (xper*(int)(width*deviceWidth))/100;
					} catch (Exception e) {
						// TODO: handle exception
						xper =0.0f;
					}

					try {
						yper = Float.parseFloat(_objElementWrapper.yper.trim());
						yper = (yper*(int)(height*deviceHeight))/100;
					} catch (Exception e) {
						// TODO: handle exception
						yper =0.0f;
					}

					try {

						Float elementwidthper = Float.parseFloat(_objElementWrapper.width);
						Float elementheightper = Float.parseFloat(_objElementWrapper.height);
						int elementheight = (int)(elementheightper*(int)(height*deviceHeight))/100;
						int elementwidth =(int)(elementwidthper*(int)(width*deviceWidth))/100;;
						int xcod =(int)(xper-(elementwidth/2));
						int ycod =(int)(yper-(elementheight/2));
						if(xcod<0)
							xcod=0;
						if(ycod<0)
							ycod=0;
						AbsoluteLayout.LayoutParams params_b =(AbsoluteLayout.LayoutParams) b.getLayoutParams();
						params_b.x =xcod;
						params_b.y =ycod;
						try {
							params_b.width =elementwidth;
						} catch (Exception e) {
							// TODO: handle exception
						}

						try {
							params_b.height =elementheight;
						} catch (Exception e) {
							// TODO: handle exception
						}
						b.setLayoutParams(params_b);

					} catch (Exception e) {
						// TODO: handle exception
					}


					try {
						b.setText(_objElementWrapper.Title);
					} catch (Exception e) {
						// TODO: handle exception
					}


					try {
						Typeface tf = MyUIApplication.fontmap.get(_objElementWrapper.fontStyle);
						b.setTypeface(tf);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						b.setTextColor(Color.parseColor(_objElementWrapper.fontColor));
					} catch (Exception e) {
						// TODO: handle exception
						b.setTextColor(Color.BLACK);
					}

					try {
						int ii = Integer.parseInt(_objElementWrapper.fontSize);
						float testsizepercent = ii/960f;
						b.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(b.getTypeface(),(testsizepercent*deviceHeight)));	
					} catch (Exception e) {
						// TODO: handle exception
						b.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(b.getTypeface(),(0.1f)*(.4f*deviceHeight)));
					}

					try {
						b.setBackgroundColor(Color.parseColor(_objElementWrapper.bgcolor));
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {

						if(_objElementWrapper.Bitmap.trim().length()>0)
						{

							Integer elementwidth = Integer.parseInt(_objElementWrapper.width);
							Integer elementheight = Integer.parseInt(_objElementWrapper.height);
							ImageUtil.setBgFromSDCardNotCache(b, context, _objElementWrapper.Bitmap, (int)(elementheight*(int)(height*deviceHeight))/100, (int)(elementwidth*(int)(width*deviceWidth))/100);

						}
					} catch (Exception e) {
						// TODO: handle exception
					}

					b.setOnTouchListener(new OnTouchListener() 
					{
						public boolean onTouch(View v, MotionEvent event)
						{
							switch(event.getAction()) 
							{

							case MotionEvent.ACTION_DOWN:

								try {
									//								String selbg = _objElementWrapper.selectedBgcolor;
									//								v.setBackgroundColor(Color.parseColor(selbg));
									v.getBackground().setAlpha(150);
								} catch (Exception e) {
									// TODO: handle exception
								}

								return true;
							case MotionEvent.ACTION_UP:

								try {

									v.getBackground().setAlpha(255);

								} catch (Exception e) {
									// TODO: handle exception
								}

								if(_objElementWrapper.OnClick.length()>0)
								{
									String screenNumber=_objElementWrapper.OnClick.substring(12);
									String mailto=_objElementWrapper.mailto;
									String body=_objElementWrapper.body;
									String subject=_objElementWrapper.subject;
									String cc=_objElementWrapper.cc;
									String bcc=_objElementWrapper.bcc;

									if(screenNumber.equals("EXIT"))
									{
										((Home)context).outLayoutAnim();      
										Intent i = new Intent();
										i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
										((Activity)context).finish();

									}
									else if(screenNumber.equals("AGREE"))
									{
										MyUIApplication._objClientEventDB.UpdateisAggree(MyUIApplication.ClientCode,MyUIApplication.EventCode);
										if(MyUIApplication.ScreenNumbers.contains("-1"))
										{
											((Home)context).inLayoutAnim();
											((Home)context).OpenHtmlPage("-1","");
										}
										else if(MyUIApplication.ScreenNumbers.contains("0"))
										{
											((Home)context).inLayoutAnim();
											//											((Home)context).DesignHomeScreen();
											((Home)context).OpenHtmlPage("0", "");
										}
										else
										{
											MyUIApplication.AlertString(context, "Home Screen Not Available");
										}
									}

									else if(screenNumber.equals("1"))    //  "1" For Mail
									{
										UtilMail mail = new UtilMail();
										mail.OpenMail(context , mailto ,cc,bcc, body , subject);
									}
									else if(screenNumber.equals("0"))
									{
										MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
										String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
										((Home)context).OpenHtmlPage(LastScreen,"");
										((Home)context).outLayoutAnim();
									}
									else
									{

										((Home)context).inLayoutAnim();
										System.out.println(""+screenNumber);
										((Home)context).OpenHtmlPage(screenNumber,"");
										v.setEnabled(false);
										MyUIApplication.StateMachine.add(screenNumber);
										int i=MyUIApplication.StateMachine.size();
										System.out.println("State Machine Size >>>"+i);
										if(!screenNumber.equals("-1"))
										{

										}
									}
								}

								break;
							case MotionEvent.ACTION_CANCEL:

								try {

									v.getBackground().setAlpha(255);



								} catch (Exception e) {
									// TODO: handle exception
								}

								break;
							}

							return false;
						}

					});

				}
				else
				{

					ImageView b = new ImageView(context);

					layout.addView(b);

//					b.setBackgroundColor(Color.WHITE);
					
//					Float xper,yper;
//					try {
//						xper = Float.parseFloat(_objElementWrapper.xper.trim());
//						xper = (xper*(int)(width*deviceWidth))/100;
//					} catch (Exception e) {
//						// TODO: handle exception
//						xper =0.0f;
//					}
//
//					try {
//						yper = Float.parseFloat(_objElementWrapper.yper.trim());
//						yper = (yper*(int)(height*deviceHeight))/100;
//					} catch (Exception e) {
//						// TODO: handle exception
//						yper =0.0f;
//					}
//
//					try {
//
//						Float elementwidthper = Float.parseFloat(_objElementWrapper.width);
//						Float elementheightper = Float.parseFloat(_objElementWrapper.height);
//						int elementheight = (int)(elementheightper*(int)(height*deviceHeight))/100;
//						int elementwidth =(int)(elementwidthper*(int)(width*deviceWidth))/100;;
//						int xcod =(int)(xper-(elementwidth/2));
//						int ycod =(int)(yper-(elementheight/2));
//						if(xcod<0)
//							xcod=0;
//						if(ycod<0)
//							ycod=0;
//						AbsoluteLayout.LayoutParams params_b =(AbsoluteLayout.LayoutParams) b.getLayoutParams();
//						params_b.x =xcod;
//						params_b.y =ycod;
//						try {
//							params_b.width =elementwidth;
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//
//						try {
//							params_b.height =elementheight;
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//						b.setLayoutParams(params_b);

//					} catch (Exception e) {
//						// TODO: handle exception
//					}

					/*****KD_15042014*/

					Float xper,yper;
					try {
						xper = Float.parseFloat(_objElementWrapper.xper.trim());
						xper = (this.width)*(xper/100);
					} catch (Exception e) {
						xper =0.0f;
					}

					try {
						yper = Float.parseFloat(_objElementWrapper.yper.trim());
						yper = (this.height)*(yper/100);
					} catch (Exception e) {
						yper =0.0f;
					}
					
					try{
					Float elementwidthper 	= Float.parseFloat(_objElementWrapper.width);
					Float elementheightper = Float.parseFloat(_objElementWrapper.height);
					int elementheight 	= (int) ((int)(this.height)*(elementheightper/100));
					int elementwidth 	=(int) ((int)(this.width)*(elementwidthper/100));
					
					AbsoluteLayout.LayoutParams params_b =(AbsoluteLayout.LayoutParams) b.getLayoutParams();
					int xcod =(int)(xper-(elementwidth/2));
//					int xcod =(int)(xper*1);
					int ycod =(int)(yper-(elementheight/2));
//					int ycod =(int)(yper*1);
					if(xcod<0)
						xcod=0;
					if(ycod<0)
						ycod=0;
					params_b.x =xcod;
					params_b.y =ycod;
					params_b.height =elementheight;
					params_b.width =elementwidth;
					b.setLayoutParams(params_b);
					
					if(_objElementWrapper.Bitmap.trim().length()>0)
					{
						if(_objElementWrapper.ImageMode != null && _objElementWrapper.ImageMode.length()>0){
							MyUIApplication.imageMode	=	_objElementWrapper.ImageMode;
						}
						Bitmap bmp = ImageUtil.setBgFromSDCardNotCache(b, context, _objElementWrapper.Bitmap, elementheight,elementwidth);

						if(bmp != null)
						{
							b.setImageBitmap(bmp);
//							b.setScaleType(ScaleType.FIT_XY);
							b.setBackgroundDrawable(null);
						}

					}
					
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						b.setBackgroundColor(Color.parseColor(_objElementWrapper.bgcolor));
					} catch (Exception e) {
						// TODO: handle exception
					}


					b.setOnTouchListener(new OnTouchListener() 
					{
						public boolean onTouch(View v, MotionEvent event)
						{
							switch(event.getAction()) 
							{

							case MotionEvent.ACTION_DOWN:

								try {
									((ImageView)v).setAlpha(150);
								} catch (Exception e) {
									// TODO: handle exception
								}

								return true;
							case MotionEvent.ACTION_UP:

								try {


									((ImageView)v).setAlpha(255);

								} catch (Exception e) {
									// TODO: handle exception
								}

								if(_objElementWrapper.OnClick.length()>0)
								{
									String screenNumber=_objElementWrapper.OnClick.substring(12);


									if(MyUIApplication.ScreenNumbers.contains(screenNumber))
									{

										String mailto=_objElementWrapper.mailto;
										String body=_objElementWrapper.body;
										String subject=_objElementWrapper.subject;
										String cc=_objElementWrapper.cc;
										String bcc=_objElementWrapper.bcc;


										if(screenNumber.equals("1"))    //  "1" For Mail
										{
											UtilMail mail = new UtilMail();
											mail.OpenMail(context , mailto ,cc,bcc, body , subject);
										}
										else if(screenNumber.equals("0"))
										{
											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
											String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
											((Home)context).OpenHtmlPage(LastScreen,"");
											((Home)context).outLayoutAnim();
										}
										else
										{

											((Home)context).inLayoutAnim();
											System.out.println(""+screenNumber);
											((Home)context).OpenHtmlPage(screenNumber,"");
											v.setEnabled(false);
											MyUIApplication.StateMachine.add(screenNumber);
											int i=MyUIApplication.StateMachine.size();
											System.out.println("State Machine Size >>>"+i);
											if(!screenNumber.equals("-1"))
											{

											}
										}
									}
								}

								break;
							case MotionEvent.ACTION_CANCEL:

								try {

									((ImageView)v).setAlpha(255);


								} catch (Exception e) {
									// TODO: handle exception
								}

								break;
							}

							return false;
						}

					});
				}
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}

}
