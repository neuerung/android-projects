package mobi.neuerung.Util;


import mobi.neuerung.ImageScale.ImageUtil;
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
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;



public class UtilTopBar02 
{
	ElementWrapper _objEWLeftBtn = new ElementWrapper();
	ElementWrapper _objEWMiddle=new ElementWrapper();
	ElementWrapper _objEWRightBtn=new ElementWrapper();
	public void UniversalTopBar02(ScreenPartWrapper _objScreenPartWrapper, String Section,final Context context)
	{
		MyUIApplication._objEWList = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);


		if(MyUIApplication.Copy)
		{
			if(Section.equals("Top"))
			{

				double LLTopCopywidth=Double.parseDouble(_objScreenPartWrapper.TopWidth);
				double LLTopCopyheight=Double.parseDouble(_objScreenPartWrapper.TopHeight);
				double LLTopCopywidthPer=LLTopCopywidth/100;
				double LLTopCopyPerheight=LLTopCopyheight/100;

				ViewGroup.LayoutParams params_LLTopCopyBar = ((Home)context).LLTopCopy.getLayoutParams();
				int TopCopyBarHeight = (int)(LLTopCopyPerheight*((Home)context).deviceHeight);
				params_LLTopCopyBar.height = TopCopyBarHeight;
				params_LLTopCopyBar.width =(int)(LLTopCopywidthPer*((Home)context).deviceWidth);
				((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopyBar);

				try
				{
					if(_objScreenPartWrapper.TopbgImage.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.TopbgImage+".png"))
						{
							String LeftBtnfilePath=_objScreenPartWrapper.TopbgImage+".png";
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLTopCopy, context,LeftBtnfilePath,(float)TopCopyBarHeight,(float)(LLTopCopywidthPer*((Home)context).deviceWidth));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objScreenPartWrapper.TopbgImage+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTopCopy, context,LeftBtnfilePath,(float)TopCopyBarHeight,(float)(LLTopCopywidthPer*((Home)context).deviceWidth));
						}
					}



					for(int i=0 ; i < MyUIApplication._objEWList.size() ; i++)
					{
						if(MyUIApplication._objEWList.get(i).Number.equals("0"))
						{
							_objEWLeftBtn = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("1"))
						{
							_objEWMiddle = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("2"))
						{
							_objEWRightBtn = MyUIApplication._objEWList.get(i);
						}
					}
					FrameLayout LeftFrame = new FrameLayout(context);
					FrameLayout MiddleFrame = new FrameLayout(context);
					FrameLayout RightFrame = new FrameLayout(context);
					if(_objEWLeftBtn != null)
					{
						((Home)context).LLTopCopy.addView(LeftFrame);
					}
					if(_objEWMiddle != null)
					{
						((Home)context).LLTopCopy.addView(MiddleFrame);
					}
					if(_objEWRightBtn != null)
					{
						((Home)context).LLTopCopy.addView(RightFrame);
					}


					double LeftBtnwidth=Double.parseDouble(_objEWLeftBtn.width);
					double LeftBtnheight=Double.parseDouble(_objEWLeftBtn.height);
					double LeftBtnwidthPer=LeftBtnwidth/100;
					double LeftBtnheightPer=LeftBtnheight/100;

					ViewGroup.LayoutParams params_LeftFrame = LeftFrame.getLayoutParams();
					params_LeftFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_LeftFrame.height=(int)(TopCopyBarHeight);
					params_LeftFrame.width=(int)(LeftBtnwidthPer*(((Home)context).deviceWidth));
					LeftFrame.setLayoutParams(params_LeftFrame);

					if(_objEWLeftBtn.distleft.length()>0)
					{
						double LeftFrame_mar=Double.parseDouble(_objEWLeftBtn.distleft)/100;
						FrameLayout.LayoutParams marginparam_LeftFrame =(FrameLayout.LayoutParams) LeftFrame.getLayoutParams();
						marginparam_LeftFrame.leftMargin = (int)(LeftFrame_mar*(((Home)context).deviceWidth));
					}
					double MiddleBtnwidth=Double.parseDouble(_objEWMiddle.width);
					double MiddleBtnheight=Double.parseDouble(_objEWMiddle.height);
					double MiddleBtnwidthPer=MiddleBtnwidth/100;
					double MiddleBtnheightPer=MiddleBtnheight/100;

					ViewGroup.LayoutParams params_MiddleFrame = MiddleFrame.getLayoutParams();
					params_MiddleFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_MiddleFrame.height=(int)(TopCopyBarHeight);
					params_MiddleFrame.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
					MiddleFrame.setLayoutParams(params_MiddleFrame);

					double MiddleFrame_mar=Double.parseDouble(_objEWMiddle.distleft)/100;
					FrameLayout.LayoutParams marginparam_MiddleFrame =(FrameLayout.LayoutParams) MiddleFrame.getLayoutParams();
					marginparam_MiddleFrame.leftMargin = (int)(MiddleFrame_mar*(((Home)context).deviceWidth));

					double RightBtnwidth=Double.parseDouble(_objEWRightBtn.width);
					double RightBtnheight=Double.parseDouble(_objEWRightBtn.height);
					double RightBtnwidthPer=RightBtnwidth/100;
					double RightBtnheightPer=RightBtnheight/100;

					ViewGroup.LayoutParams params_RightFrame = RightFrame.getLayoutParams();
					params_RightFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_RightFrame.height=(int)(TopCopyBarHeight);
					params_RightFrame.width=(int)(RightBtnwidthPer*(((Home)context).deviceWidth));
					RightFrame.setLayoutParams(params_RightFrame);

					double RightFrame_mar=Double.parseDouble(_objEWRightBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_RightFrame =(FrameLayout.LayoutParams) RightFrame.getLayoutParams();
					marginparam_RightFrame.leftMargin = (int)(RightFrame_mar*(((Home)context).deviceWidth));


					if(_objEWLeftBtn.bgcolor.length()>0)
					{
						LeftFrame.setBackgroundColor(Color.parseColor(_objEWLeftBtn.bgcolor));
					}
					if(_objEWMiddle.bgcolor.length()>0)
					{
						MiddleFrame.setBackgroundColor(Color.parseColor(_objEWMiddle.bgcolor));
					}
					if(_objEWRightBtn.bgcolor.length()>0)
					{
						RightFrame.setBackgroundColor(Color.parseColor(_objEWRightBtn.bgcolor));
					}


					final Button LeftBtn = new Button(context);
					final Button RightBtn = new Button(context);
					final TextView Heading = new TextView(context);
					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						LeftFrame.addView(LeftBtn);
					}
					if(_objEWRightBtn.Bitmap.length()>0)
					{
						RightFrame.addView(RightBtn);
					}


					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					params_LeftBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_LeftBtn.height=(int)(TopCopyBarHeight);
					params_LeftBtn.width=(int)(1.0f*TopCopyBarHeight);
					LeftBtn.setLayoutParams(params_LeftBtn);

					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWLeftBtn.Bitmap+".png"))
						{
							String LeftBtnfilePath=_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,LeftBtnfilePath,(float)(TopCopyBarHeight),(float)(1.0f*TopCopyBarHeight));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,LeftBtnfilePath,(float)(TopCopyBarHeight),(float)(1.0f*TopCopyBarHeight));
						}
					}

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_RightBtn.height=(int)(TopCopyBarHeight);
					params_RightBtn.width=(int)(1.0f*TopCopyBarHeight);
					RightBtn.setLayoutParams(params_RightBtn);


					if(_objEWRightBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWRightBtn.Bitmap+".png"))
						{
							String RightBtnfilePath=_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,RightBtnfilePath,(float)(TopCopyBarHeight),(float)(1.0f*TopCopyBarHeight));
						}
						else 
						{
							String RightBtnfilePath="images/"+_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,RightBtnfilePath,(float)(TopCopyBarHeight),(float)(1.0f*TopCopyBarHeight));
						}
					}
					if(_objEWMiddle.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWMiddle.Bitmap+".png"))
						{
							String MiddlefilePath=_objEWMiddle.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,MiddlefilePath,(float)(TopCopyBarHeight),(float)(1.0f*TopCopyBarHeight));
						}
						else 
						{
							String MiddlefilePath="images/"+_objEWMiddle.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(MiddleFrame, context,MiddlefilePath,(float)(TopCopyBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
					}
					if(_objEWMiddle.Title.length()>0)
					{

						MiddleFrame.addView(Heading);
						Heading.setMaxLines(2);
						Heading.setGravity(Gravity.CENTER);
						Heading.setText(_objEWMiddle.Title);
						int textsize=(int)((0.5f)*(TopCopyBarHeight));
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),textsize));

						if(_objEWMiddle.txtColor.length()>0)
						{
							Heading.setTextColor(Color.parseColor(_objEWMiddle.txtColor));
						}

						ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
						params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
								FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
						params_Heading.height=(int)(TopCopyBarHeight);
						params_Heading.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
						Heading.setLayoutParams(params_Heading);
						ImageUtil.setBackgroundBgFromAssetsNotCache(Heading, context,"images/Heading_Clickable"+".png",TopCopyBarHeight,(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
					}
					if(_objEWLeftBtn.OnClick.length()>0)
					{
						LeftBtn.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									LeftBtn.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									LeftBtn.getBackground().setAlpha(255);

									try
									{
										if(_objEWLeftBtn.OnClick.substring(12).equals("1"))
										{
											try {
												String mailto=_objEWLeftBtn.mailto;
												String body=_objEWLeftBtn.body;
												String subject=_objEWLeftBtn.subject;
												String cc=_objEWLeftBtn.cc;
												String bcc=_objEWLeftBtn.bcc;

												UtilMail mail = new UtilMail();
												mail.OpenMail(context ,mailto,cc,bcc,body,subject);

											} catch (Exception e) {
												// TODO: handle exception
											}

										}
										else
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
//												((Home)context).DesignHomeScreen();
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


												//												if(LastScreen.equals("112"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("113"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("114"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}

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
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println();
									}


									break;
								case MotionEvent.ACTION_CANCEL:
									LeftBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}

								return false;
							}

						});


					}
					if(_objEWRightBtn.OnClick.length()>0)
					{
						RightBtn.setOnClickListener(new OnClickListener() {

							public void onClick(View v) 
							{
								if(((Home)context).LLLayoutMenu.getVisibility()==View.VISIBLE && ((Home)context).MenuButton.getVisibility()==View.VISIBLE)
								{

									((Home)context).LLLayoutMenu.setAnimation(((Home)context).outToRightAnimation());

									((Home)context).LLLayoutMenu.setVisibility(View.GONE);
									((Home)context).MenuButton.setVisibility(View.GONE);


//									Thread thread = new Thread()
//									{
//										@Override
//										public void run()
//										{
//											try 
//											{
//												Thread.sleep(500);
//											}
//											catch (InterruptedException e)
//											{
//											}
//											((Home)context).runOnUiThread(new Runnable()
//											{
//												public void run() 
//												{
//													// Do some stuff
//													((Home)context).LLTopMenu.removeAllViews();
//													((Home)context).LLMiddleMenu.removeAllViews();
//													((Home)context).LLBottomMenu.removeAllViews();
//												}
//											});
//										}
//									};

								}
								else
								{


									String screenNumber=_objEWRightBtn.OnClick.substring(12);

									//					Toast.makeText(context, _objEW.rightClick+"Right" +"    "+screenNumber, Toast.LENGTH_SHORT).show();

									//					MyUIApplication.StateMachine.add(screenNumber);

									int i=MyUIApplication.StateMachine.size();
									System.out.println("State Machine Size >>>"+i);
									//					if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
									//					{
									((Home)context).OpenHtmlPage(screenNumber,"");
								}
							}
						});

						RightBtn.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									RightBtn.getBackground().setAlpha(150);
									//							return false;
									break;
								case MotionEvent.ACTION_UP:
									RightBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}

								return false;
							}

						});

					}
					if(_objEWMiddle.OnClick.length()>0)
					{

						Heading.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									Heading.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									Heading.getBackground().setAlpha(255);
									try
									{
										if(MyUIApplication.UserName.length()>0)
										{
											String screenNumber=_objEWMiddle.OnClick.substring(12);

											if(screenNumber.length()>0)
											{
												if(screenNumber.equals("1"))   //  "1" For Mail
												{
													try {
														String mailto=_objEWLeftBtn.mailto;
														String body=_objEWLeftBtn.body;
														String subject=_objEWLeftBtn.subject;
														String cc=_objEWLeftBtn.cc;
														String bcc=_objEWLeftBtn.bcc;

														UtilMail mail = new UtilMail();
														mail.OpenMail(context ,mailto,cc,bcc,body,subject);

													} catch (Exception e) {
														// TODO: handle exception
													}

												}
												else
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
										}
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println("Exception in UtilTopBar02 Heading ONTouchEvent"+e);
									}
									break;
								case MotionEvent.ACTION_CANCEL:
									Heading.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page TopCopy Bar"+e);
				}

			}
			else if(Section.equals("Middle"))
			{
				double LLMiddleCopywidth=Double.parseDouble(_objScreenPartWrapper.MidWidth);
				double LLMiddleCopyheight=Double.parseDouble(_objScreenPartWrapper.MidHeight);
				double LLMiddleCopywidthPer=LLMiddleCopywidth/100;
				double LLMiddleCopyPerheight=LLMiddleCopyheight/100;

				ViewGroup.LayoutParams params_LLMiddleCopyBar = ((Home)context).LLMiddleCopy.getLayoutParams();
				int MiddleCopyBarHeight = (int)(LLMiddleCopyPerheight*((Home)context).deviceHeight);
				params_LLMiddleCopyBar.height = MiddleCopyBarHeight;
				params_LLMiddleCopyBar.width =(int)(LLMiddleCopywidthPer*((Home)context).deviceWidth);
				((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopyBar);

				try
				{
					if(_objScreenPartWrapper.MidbgImage.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.MidbgImage+".png"))
						{
							String LeftBtnfilePath=_objScreenPartWrapper.MidbgImage+".png";
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLMiddleCopy, context,LeftBtnfilePath,(float)MiddleCopyBarHeight,(float)(LLMiddleCopywidthPer*((Home)context).deviceWidth));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objScreenPartWrapper.MidbgImage+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLMiddleCopy, context,LeftBtnfilePath,(float)MiddleCopyBarHeight,(float)(LLMiddleCopywidthPer*((Home)context).deviceWidth));
						}
					}



					for(int i=0 ; i < MyUIApplication._objEWList.size() ; i++)
					{
						if(MyUIApplication._objEWList.get(i).Number.equals("0"))
						{
							_objEWLeftBtn = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("1"))
						{
							_objEWMiddle = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("2"))
						{
							_objEWRightBtn = MyUIApplication._objEWList.get(i);
						}
					}
					FrameLayout LeftFrame = new FrameLayout(context);
					FrameLayout MiddleCopyFrame = new FrameLayout(context);
					FrameLayout RightFrame = new FrameLayout(context);
					if(_objEWLeftBtn != null)
					{
						((Home)context).LLMiddleCopy.addView(LeftFrame);
					}
					if(_objEWMiddle != null)
					{
						((Home)context).LLMiddleCopy.addView(MiddleCopyFrame);
					}
					if(_objEWRightBtn != null)
					{
						((Home)context).LLMiddleCopy.addView(RightFrame);
					}


					double LeftBtnwidth=Double.parseDouble(_objEWLeftBtn.width);
					double LeftBtnheight=Double.parseDouble(_objEWLeftBtn.height);
					double LeftBtnwidthPer=LeftBtnwidth/100;
					double LeftBtnheightPer=LeftBtnheight/100;

					ViewGroup.LayoutParams params_LeftFrame = LeftFrame.getLayoutParams();
					params_LeftFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_LeftFrame.height=(int)(MiddleCopyBarHeight);
					params_LeftFrame.width=(int)(LeftBtnwidthPer*(((Home)context).deviceWidth));
					LeftFrame.setLayoutParams(params_LeftFrame);

					double LeftFrame_mar=Double.parseDouble(_objEWLeftBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_LeftFrame =(FrameLayout.LayoutParams) LeftFrame.getLayoutParams();
					marginparam_LeftFrame.leftMargin = (int)(LeftFrame_mar*(((Home)context).deviceWidth));

					double MiddleCopyBtnwidth=Double.parseDouble(_objEWMiddle.width);
					double MiddleCopyBtnheight=Double.parseDouble(_objEWMiddle.height);
					double MiddleCopyBtnwidthPer=MiddleCopyBtnwidth/100;
					double MiddleCopyBtnheightPer=MiddleCopyBtnheight/100;

					ViewGroup.LayoutParams params_MiddleCopyFrame = MiddleCopyFrame.getLayoutParams();
					params_MiddleCopyFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_MiddleCopyFrame.height=(int)(MiddleCopyBarHeight);
					params_MiddleCopyFrame.width=(int)((((Home)context).deviceWidth)*MiddleCopyBtnwidthPer);
					MiddleCopyFrame.setLayoutParams(params_MiddleCopyFrame);

					double MiddleCopyFrame_mar=Double.parseDouble(_objEWMiddle.distleft)/100;
					FrameLayout.LayoutParams marginparam_MiddleCopyFrame =(FrameLayout.LayoutParams) MiddleCopyFrame.getLayoutParams();
					marginparam_MiddleCopyFrame.leftMargin = (int)(MiddleCopyFrame_mar*(((Home)context).deviceWidth));

					double RightBtnwidth=Double.parseDouble(_objEWRightBtn.width);
					double RightBtnheight=Double.parseDouble(_objEWRightBtn.height);
					double RightBtnwidthPer=RightBtnwidth/100;
					double RightBtnheightPer=RightBtnheight/100;

					ViewGroup.LayoutParams params_RightFrame = RightFrame.getLayoutParams();
					params_RightFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_RightFrame.height=(int)(MiddleCopyBarHeight);
					params_RightFrame.width=(int)(RightBtnwidthPer*(((Home)context).deviceWidth));
					RightFrame.setLayoutParams(params_RightFrame);

					double RightFrame_mar=Double.parseDouble(_objEWRightBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_RightFrame =(FrameLayout.LayoutParams) RightFrame.getLayoutParams();
					marginparam_RightFrame.leftMargin = (int)(RightFrame_mar*(((Home)context).deviceWidth));


					if(_objEWLeftBtn.bgcolor.length()>0)
					{
						LeftFrame.setBackgroundColor(Color.parseColor(_objEWLeftBtn.bgcolor));
					}
					if(_objEWMiddle.bgcolor.length()>0)
					{
						MiddleCopyFrame.setBackgroundColor(Color.parseColor(_objEWMiddle.bgcolor));
					}
					if(_objEWRightBtn.bgcolor.length()>0)
					{
						RightFrame.setBackgroundColor(Color.parseColor(_objEWRightBtn.bgcolor));
					}


					final Button LeftBtn = new Button(context);
					final Button RightBtn = new Button(context);
					final TextView Heading = new TextView(context);
					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						LeftFrame.addView(LeftBtn);
					}
					if(_objEWRightBtn.Bitmap.length()>0)
					{
						RightFrame.addView(RightBtn);
					}

					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					params_LeftBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_LeftBtn.height=(int)(MiddleCopyBarHeight);
					params_LeftBtn.width=(int)(1.0f*MiddleCopyBarHeight);
					LeftBtn.setLayoutParams(params_LeftBtn);

					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWLeftBtn.Bitmap+".png"))
						{
							String LeftBtnfilePath=_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,LeftBtnfilePath,(float)(MiddleCopyBarHeight),(float)(1.0f*MiddleCopyBarHeight));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,LeftBtnfilePath,(float)(MiddleCopyBarHeight),(float)(1.0f*MiddleCopyBarHeight));
						}
					}

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_RightBtn.height=(int)(MiddleCopyBarHeight);
					params_RightBtn.width=(int)(1.0f*MiddleCopyBarHeight);
					RightBtn.setLayoutParams(params_RightBtn);


					if(_objEWRightBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWRightBtn.Bitmap+".png"))
						{
							String RightBtnfilePath=_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,RightBtnfilePath,(float)(MiddleCopyBarHeight),(float)(1.0f*MiddleCopyBarHeight));
						}
						else 
						{
							String RightBtnfilePath="images/"+_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,RightBtnfilePath,(float)(MiddleCopyBarHeight),(float)(1.0f*MiddleCopyBarHeight));
						}
					}
					if(_objEWMiddle.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWMiddle.Bitmap+".png"))
						{
							String MiddleCopyfilePath=_objEWMiddle.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(MiddleCopyFrame, context,MiddleCopyfilePath,(float)(MiddleCopyBarHeight),(float)((((Home)context).deviceWidth)*MiddleCopyBtnwidthPer));
						}
						else 
						{
							String MiddleCopyfilePath="images/"+_objEWMiddle.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(MiddleCopyFrame, context,MiddleCopyfilePath,(float)(MiddleCopyBarHeight),(float)((((Home)context).deviceWidth)*MiddleCopyBtnwidthPer));
						}
					}
					if(_objEWMiddle.Title.length()>0)
					{

						MiddleCopyFrame.addView(Heading);
						Heading.setMaxLines(2);
						Heading.setGravity(Gravity.CENTER);
						Heading.setText(_objEWMiddle.Title);
						int textsize=(int)((0.5f)*(MiddleCopyBarHeight));
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),textsize));

						if(_objEWMiddle.txtColor.length()>0)
						{
							Heading.setTextColor(Color.parseColor(_objEWMiddle.txtColor));
						}

						ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
						params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
								FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
						params_Heading.height=(int)(MiddleCopyBarHeight);
						params_Heading.width=(int)((((Home)context).deviceWidth)*MiddleCopyBtnwidthPer);
						Heading.setLayoutParams(params_Heading);
						ImageUtil.setBackgroundBgFromAssetsNotCache(Heading, context,"images/Heading_Clickable"+".png",MiddleCopyBarHeight,(float)((((Home)context).deviceWidth)*MiddleCopyBtnwidthPer));
					}
					if(_objEWLeftBtn.OnClick.length()>0)
					{
						LeftBtn.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									LeftBtn.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									LeftBtn.getBackground().setAlpha(255);

									try
									{
										if(_objEWLeftBtn.OnClick.substring(12).equals("1"))
										{
											try {
												String mailto=_objEWLeftBtn.mailto;
												String body=_objEWLeftBtn.body;
												String subject=_objEWLeftBtn.subject;
												String cc=_objEWLeftBtn.cc;
												String bcc=_objEWLeftBtn.bcc;

												UtilMail mail = new UtilMail();
												mail.OpenMail(context ,mailto,cc,bcc,body,subject);

											} catch (Exception e) {
												// TODO: handle exception
											}


										}
										else
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
//												((Home)context).DesignHomeScreen();
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


												//												if(LastScreen.equals("112"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("113"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("114"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}

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
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println();
									}
									break;
								case MotionEvent.ACTION_CANCEL:
									LeftBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});
					}
					if(_objEWRightBtn.OnClick.length()>0)
					{
						RightBtn.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View v)
							{
								if(((Home)context).LLLayoutMenu.getVisibility()==View.VISIBLE && ((Home)context).MenuButton.getVisibility()==View.VISIBLE)
								{

									((Home)context).LLLayoutMenu.setAnimation(((Home)context).outToRightAnimation());

									((Home)context).LLLayoutMenu.setVisibility(View.GONE);
									((Home)context).MenuButton.setVisibility(View.GONE);


									Thread thread = new Thread()
									{
										@Override
										public void run()
										{
											try 
											{
												Thread.sleep(500);
											}
											catch (InterruptedException e)
											{
											}
											((Home)context).runOnUiThread(new Runnable()
											{
												public void run() 
												{
													// Do some stuff
													((Home)context).LLTopMenu.removeAllViews();
													((Home)context).LLMiddleMenu.removeAllViews();
													((Home)context).LLBottomMenu.removeAllViews();
												}
											});
										}
									};

								}
								else
								{
									String screenNumber=_objEWRightBtn.OnClick.substring(12);

									//					Toast.makeText(context, _objEW.rightClick+"Right" +"    "+screenNumber, Toast.LENGTH_SHORT).show();

									//					MyUIApplication.StateMachine.add(screenNumber);

									int i=MyUIApplication.StateMachine.size();
									System.out.println("State Machine Size >>>"+i);
									//					if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
									//					{
									((Home)context).OpenHtmlPage(screenNumber,"");
								}
							}
						});
						RightBtn.setOnTouchListener(new OnTouchListener() {

							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									RightBtn.getBackground().setAlpha(150);
									//							return false;
									break;
								case MotionEvent.ACTION_UP:
									RightBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});
					}
					if(_objEWMiddle.OnClick.length()>0)
					{
						Heading.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									Heading.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									Heading.getBackground().setAlpha(255);
									try
									{
										if(MyUIApplication.UserName.length()>0)
										{
											String screenNumber=_objEWMiddle.OnClick.substring(12);

											if(screenNumber.length()>0)
											{
												if(screenNumber.equals("1"))   //  "1" For Mail
												{
													try {
														String mailto=_objEWMiddle.mailto;
														String body=_objEWMiddle.body;
														String subject=_objEWMiddle.subject;
														String cc=_objEWMiddle.cc;
														String bcc=_objEWMiddle.bcc;

														UtilMail mail = new UtilMail();
														mail.OpenMail(context ,mailto,cc,bcc,body,subject);

													} catch (Exception e) {
														// TODO: handle exception
													}

												}
												else
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
										}
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println("Exception in UtilTopBar02 Heading ONTouchEvent"+e);
									}
									break;
								case MotionEvent.ACTION_CANCEL:
									Heading.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page MiddleCopy Bar"+e);
				}

			}
			else if(Section.equals("Bottom"))
			{
				double LLBottomCopywidth=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
				double LLBottomCopyheight=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
				double LLBottomCopywidthPer=LLBottomCopywidth/100;
				double LLBottomCopyPerheight=LLBottomCopyheight/100;

				ViewGroup.LayoutParams params_LLBottomCopyBar = ((Home)context).LLBottomCopy.getLayoutParams();
				int BottomCopyBarHeight = (int)(LLBottomCopyPerheight*((Home)context).deviceHeight);
				params_LLBottomCopyBar.height = BottomCopyBarHeight;
				params_LLBottomCopyBar.width =(int)(LLBottomCopywidthPer*((Home)context).deviceWidth);
				((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopyBar);

				try
				{
					if(_objScreenPartWrapper.BottombgImage.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.BottombgImage+".png"))
						{
							String LeftBtnfilePath=_objScreenPartWrapper.BottombgImage+".png";
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLBottomCopy, context,LeftBtnfilePath,(float)BottomCopyBarHeight,(float)(LLBottomCopywidthPer*((Home)context).deviceWidth));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objScreenPartWrapper.BottombgImage+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLBottomCopy, context,LeftBtnfilePath,(float)BottomCopyBarHeight,(float)(LLBottomCopywidthPer*((Home)context).deviceWidth));
						}
					}



					for(int i=0 ; i < MyUIApplication._objEWList.size() ; i++)
					{
						if(MyUIApplication._objEWList.get(i).Number.equals("0"))
						{
							_objEWLeftBtn = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("1"))
						{
							_objEWMiddle = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("2"))
						{
							_objEWRightBtn = MyUIApplication._objEWList.get(i);
						}
					}
					FrameLayout LeftFrame = new FrameLayout(context);
					FrameLayout MiddleFrame = new FrameLayout(context);
					FrameLayout RightFrame = new FrameLayout(context);
					if(_objEWLeftBtn != null)
					{
						((Home)context).LLBottomCopy.addView(LeftFrame);
					}
					if(_objEWMiddle != null)
					{
						((Home)context).LLBottomCopy.addView(MiddleFrame);
					}
					if(_objEWRightBtn != null)
					{
						((Home)context).LLBottomCopy.addView(RightFrame);
					}


					double LeftBtnwidth=Double.parseDouble(_objEWLeftBtn.width);
					double LeftBtnheight=Double.parseDouble(_objEWLeftBtn.height);
					double LeftBtnwidthPer=LeftBtnwidth/100;
					double LeftBtnheightPer=LeftBtnheight/100;

					ViewGroup.LayoutParams params_LeftFrame = LeftFrame.getLayoutParams();
					params_LeftFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_LeftFrame.height=(int)(BottomCopyBarHeight);
					params_LeftFrame.width=(int)(LeftBtnwidthPer*(((Home)context).deviceWidth));
					LeftFrame.setLayoutParams(params_LeftFrame);

					double LeftFrame_mar=Double.parseDouble(_objEWLeftBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_LeftFrame =(FrameLayout.LayoutParams) LeftFrame.getLayoutParams();
					marginparam_LeftFrame.leftMargin = (int)(LeftFrame_mar*(((Home)context).deviceWidth));

					double MiddleBtnwidth=Double.parseDouble(_objEWMiddle.width);
					double MiddleBtnheight=Double.parseDouble(_objEWMiddle.height);
					double MiddleBtnwidthPer=MiddleBtnwidth/100;
					double MiddleBtnheightPer=MiddleBtnheight/100;

					ViewGroup.LayoutParams params_MiddleFrame = MiddleFrame.getLayoutParams();
					params_MiddleFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_MiddleFrame.height=(int)(BottomCopyBarHeight);
					params_MiddleFrame.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
					MiddleFrame.setLayoutParams(params_MiddleFrame);

					double MiddleFrame_mar=Double.parseDouble(_objEWMiddle.distleft)/100;
					FrameLayout.LayoutParams marginparam_MiddleFrame =(FrameLayout.LayoutParams) MiddleFrame.getLayoutParams();
					marginparam_MiddleFrame.leftMargin = (int)(MiddleFrame_mar*(((Home)context).deviceWidth));

					double RightBtnwidth=Double.parseDouble(_objEWRightBtn.width);
					double RightBtnheight=Double.parseDouble(_objEWRightBtn.height);
					double RightBtnwidthPer=RightBtnwidth/100;
					double RightBtnheightPer=RightBtnheight/100;

					ViewGroup.LayoutParams params_RightFrame = RightFrame.getLayoutParams();
					params_RightFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_RightFrame.height=(int)(BottomCopyBarHeight);
					params_RightFrame.width=(int)(RightBtnwidthPer*(((Home)context).deviceWidth));
					RightFrame.setLayoutParams(params_RightFrame);

					double RightFrame_mar=Double.parseDouble(_objEWRightBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_RightFrame =(FrameLayout.LayoutParams) RightFrame.getLayoutParams();
					marginparam_RightFrame.leftMargin = (int)(RightFrame_mar*(((Home)context).deviceWidth));


					if(_objEWLeftBtn.bgcolor.length()>0)
					{
						LeftFrame.setBackgroundColor(Color.parseColor(_objEWLeftBtn.bgcolor));
					}
					if(_objEWMiddle.bgcolor.length()>0)
					{
						MiddleFrame.setBackgroundColor(Color.parseColor(_objEWMiddle.bgcolor));
					}
					if(_objEWRightBtn.bgcolor.length()>0)
					{
						RightFrame.setBackgroundColor(Color.parseColor(_objEWRightBtn.bgcolor));
					}


					final Button LeftBtn = new Button(context);
					final Button RightBtn = new Button(context);
					final TextView Heading = new TextView(context);;
					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						LeftFrame.addView(LeftBtn);
					}
					if(_objEWRightBtn.Bitmap.length()>0)
					{
						RightFrame.addView(RightBtn);
					}

					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					params_LeftBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_LeftBtn.height=(int)(BottomCopyBarHeight);
					params_LeftBtn.width=(int)(1.0f*BottomCopyBarHeight);
					LeftBtn.setLayoutParams(params_LeftBtn);

					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWLeftBtn.Bitmap+".png"))
						{
							String LeftBtnfilePath=_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,LeftBtnfilePath,(float)(BottomCopyBarHeight),(float)(1.0f*BottomCopyBarHeight));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,LeftBtnfilePath,(float)(BottomCopyBarHeight),(float)(1.0f*BottomCopyBarHeight));
						}
					}

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_RightBtn.height=(int)(BottomCopyBarHeight);
					params_RightBtn.width=(int)(1.0f*BottomCopyBarHeight);
					RightBtn.setLayoutParams(params_RightBtn);


					if(_objEWRightBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWRightBtn.Bitmap+".png"))
						{
							String RightBtnfilePath=_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,RightBtnfilePath,(float)(BottomCopyBarHeight),(float)(1.0f*BottomCopyBarHeight));
						}
						else 
						{
							String RightBtnfilePath="images/"+_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,RightBtnfilePath,(float)(BottomCopyBarHeight),(float)(1.0f*BottomCopyBarHeight));
						}
					}
					if(_objEWMiddle.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWMiddle.Bitmap+".png"))
						{
							String MiddlefilePath=_objEWMiddle.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(MiddleFrame, context,MiddlefilePath,(float)(BottomCopyBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
						else 
						{
							String MiddlefilePath="images/"+_objEWMiddle.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(MiddleFrame, context,MiddlefilePath,(float)(BottomCopyBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
					}
					if(_objEWMiddle.Title.length()>0)
					{

						MiddleFrame.addView(Heading);
						Heading.setMaxLines(2);
						Heading.setGravity(Gravity.CENTER);
						Heading.setText(_objEWMiddle.Title);
						int textsize=(int)((0.5f)*(BottomCopyBarHeight));
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),textsize));

						if(_objEWMiddle.txtColor.length()>0)
						{
							Heading.setTextColor(Color.parseColor(_objEWMiddle.txtColor));
						}

						ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
						params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
								FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
						params_Heading.height=(int)(BottomCopyBarHeight);
						params_Heading.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
						Heading.setLayoutParams(params_Heading);
						ImageUtil.setBackgroundBgFromAssetsNotCache(Heading, context,"images/Heading_Clickable"+".png",BottomCopyBarHeight,(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
					}
					if(_objEWLeftBtn.OnClick.length()>0)
					{
						LeftBtn.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									LeftBtn.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									LeftBtn.getBackground().setAlpha(255);

									try
									{
										if(_objEWLeftBtn.OnClick.substring(12).equals("1"))
										{
											try {
												String mailto=_objEWLeftBtn.mailto;
												String body=_objEWLeftBtn.body;
												String subject=_objEWLeftBtn.subject;
												String cc=_objEWLeftBtn.cc;
												String bcc=_objEWLeftBtn.bcc;

												UtilMail mail = new UtilMail();
												mail.OpenMail(context ,mailto,cc,bcc,body,subject);

											} catch (Exception e) {
												// TODO: handle exception
											}

										}
										else
										{
											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
											System.out.println("State Machine"+MyUIApplication.StateMachine);
											if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
											{
//												((Home)context).DesignHomeScreen();
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


												//												if(LastScreen.equals("112"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("113"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("114"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}

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
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println();
									}

									break;
								case MotionEvent.ACTION_CANCEL:
									LeftBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}

								return false;
							}

						});
					}
					if(_objEWRightBtn.OnClick.length()>0)
					{
						RightBtn.setOnClickListener(new OnClickListener()
						{
							public void onClick(View v)
							{
								if(((Home)context).LLLayoutMenu.getVisibility()==View.VISIBLE && ((Home)context).MenuButton.getVisibility()==View.VISIBLE)
								{

									((Home)context).LLLayoutMenu.setAnimation(((Home)context).outToRightAnimation());

									((Home)context).LLLayoutMenu.setVisibility(View.GONE);
									((Home)context).MenuButton.setVisibility(View.GONE);


									Thread thread = new Thread()
									{
										@Override
										public void run()
										{
											try 
											{
												Thread.sleep(500);
											}
											catch (InterruptedException e)
											{
											}
											((Home)context).runOnUiThread(new Runnable()
											{
												public void run() 
												{
													// Do some stuff
													((Home)context).LLTopMenu.removeAllViews();
													((Home)context).LLMiddleMenu.removeAllViews();
													((Home)context).LLBottomMenu.removeAllViews();
												}
											});
										}
									};

								}
								else
								{
									String screenNumber=_objEWRightBtn.OnClick.substring(12);

									//					Toast.makeText(context, _objEW.rightClick+"Right" +"    "+screenNumber, Toast.LENGTH_SHORT).show();

									//					MyUIApplication.StateMachine.add(screenNumber);

									int i=MyUIApplication.StateMachine.size();
									System.out.println("State Machine Size >>>"+i);
									//					if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
									//					{
									((Home)context).OpenHtmlPage(screenNumber,"");
								}
							}
						});

						RightBtn.setOnTouchListener(new OnTouchListener() 
						{
							public boolean onTouch(View v, MotionEvent event)
							{
								switch(event.getAction()) 
								{
								case MotionEvent.ACTION_DOWN:
									RightBtn.getBackground().setAlpha(150);
									//							return false;
									break;
								case MotionEvent.ACTION_UP:
									RightBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}

						});
					}
					if(_objEWMiddle.OnClick.length()>0)
					{
						Heading.setOnTouchListener(new OnTouchListener() {

							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									Heading.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									Heading.getBackground().setAlpha(255);
									try
									{
										if(MyUIApplication.UserName.length()>0)
										{
											String screenNumber=_objEWMiddle.OnClick.substring(12);

											if(screenNumber.length()>0)
											{
												if(screenNumber.equals("1"))   //  "1" For Mail
												{
													try {
														String mailto=_objEWMiddle.mailto;
														String body=_objEWMiddle.body;
														String subject=_objEWMiddle.subject;
														String cc=_objEWMiddle.cc;
														String bcc=_objEWMiddle.bcc;

														UtilMail mail = new UtilMail();
														mail.OpenMail(context ,mailto,cc,bcc,body,subject);

													} catch (Exception e) {
														// TODO: handle exception
													}

												}
												else
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
										}
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println("Exception in UtilTopBar02 Heading ONTouchEvent"+e);
									}
									break;
								case MotionEvent.ACTION_CANCEL:
									Heading.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});

					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page BottomCopy Bar"+e);
				}
			}
		}
		else if(!MyUIApplication.Copy)
		{
			if(Section.equals("Top"))
			{

				double LLTopwidth=Double.parseDouble(_objScreenPartWrapper.TopWidth);
				double LLTopheight=Double.parseDouble(_objScreenPartWrapper.TopHeight);
				double LLTopwidthPer=LLTopwidth/100;
				double LLTopPerheight=LLTopheight/100;

				ViewGroup.LayoutParams params_LLTopBar = ((Home)context).LLTop.getLayoutParams();
				int TopBarHeight = (int)(LLTopPerheight*((Home)context).deviceHeight);
				params_LLTopBar.height = TopBarHeight;
				params_LLTopBar.width =(int)(LLTopwidthPer*((Home)context).deviceWidth);
				((Home)context).LLTop.setLayoutParams(params_LLTopBar);

				try
				{
					if(_objScreenPartWrapper.TopbgImage.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.TopbgImage+".png"))
						{
							String LeftBtnfilePath=_objScreenPartWrapper.TopbgImage+".png";
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLTop, context,LeftBtnfilePath,(float)TopBarHeight,(float)(LLTopwidthPer*((Home)context).deviceWidth));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objScreenPartWrapper.TopbgImage+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTop, context,LeftBtnfilePath,(float)TopBarHeight,(float)(LLTopwidthPer*((Home)context).deviceWidth));
						}
					}



					for(int i=0 ; i < MyUIApplication._objEWList.size() ; i++)
					{
						if(MyUIApplication._objEWList.get(i).Number.equals("0"))
						{
							_objEWLeftBtn = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("1"))
						{
							_objEWMiddle = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("2"))
						{
							_objEWRightBtn = MyUIApplication._objEWList.get(i);
						}
					}
					FrameLayout LeftFrame = new FrameLayout(context);
					FrameLayout MiddleFrame = new FrameLayout(context);
					FrameLayout RightFrame = new FrameLayout(context);
					if(_objEWLeftBtn != null)
					{
						((Home)context).LLTop.addView(LeftFrame);
					}
					if(_objEWMiddle != null)
					{
						((Home)context).LLTop.addView(MiddleFrame);
					}
					if(_objEWRightBtn != null)
					{
						((Home)context).LLTop.addView(RightFrame);
					}


					double LeftBtnwidth=Double.parseDouble(_objEWLeftBtn.width);
					double LeftBtnheight=Double.parseDouble(_objEWLeftBtn.height);
					double LeftBtnwidthPer=LeftBtnwidth/100;
					double LeftBtnheightPer=LeftBtnheight/100;

					ViewGroup.LayoutParams params_LeftFrame = LeftFrame.getLayoutParams();
					params_LeftFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_LeftFrame.height=(int)(TopBarHeight);
					params_LeftFrame.width=(int)(LeftBtnwidthPer*(((Home)context).deviceWidth));
					LeftFrame.setLayoutParams(params_LeftFrame);

					if(_objEWLeftBtn.distleft.length()>0)
					{
						double LeftFrame_mar=Double.parseDouble(_objEWLeftBtn.distleft)/100;
						FrameLayout.LayoutParams marginparam_LeftFrame =(FrameLayout.LayoutParams) LeftFrame.getLayoutParams();
						marginparam_LeftFrame.leftMargin = (int)(LeftFrame_mar*(((Home)context).deviceWidth));
					}
					double MiddleBtnwidth=Double.parseDouble(_objEWMiddle.width);
					double MiddleBtnheight=Double.parseDouble(_objEWMiddle.height);
					double MiddleBtnwidthPer=MiddleBtnwidth/100;
					double MiddleBtnheightPer=MiddleBtnheight/100;

					ViewGroup.LayoutParams params_MiddleFrame = MiddleFrame.getLayoutParams();
					params_MiddleFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_MiddleFrame.height=(int)(TopBarHeight);
					params_MiddleFrame.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
					MiddleFrame.setLayoutParams(params_MiddleFrame);

					if(_objEWMiddle.distleft.length()>0)
					{
						double MiddleFrame_mar=Double.parseDouble(_objEWMiddle.distleft)/100;
						FrameLayout.LayoutParams marginparam_MiddleFrame =(FrameLayout.LayoutParams) MiddleFrame.getLayoutParams();
						marginparam_MiddleFrame.leftMargin = (int)(MiddleFrame_mar*(((Home)context).deviceWidth));
					}

					double RightBtnwidth=Double.parseDouble(_objEWRightBtn.width);
					double RightBtnheight=Double.parseDouble(_objEWRightBtn.height);
					double RightBtnwidthPer=RightBtnwidth/100;
					double RightBtnheightPer=RightBtnheight/100;

					ViewGroup.LayoutParams params_RightFrame = RightFrame.getLayoutParams();
					params_RightFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_RightFrame.height=(int)(TopBarHeight);
					params_RightFrame.width=(int)(RightBtnwidthPer*(((Home)context).deviceWidth));
					RightFrame.setLayoutParams(params_RightFrame);

					if(_objEWRightBtn.distleft.length()>0)
					{
						double RightFrame_mar=Double.parseDouble(_objEWRightBtn.distleft)/100;
						FrameLayout.LayoutParams marginparam_RightFrame =(FrameLayout.LayoutParams) RightFrame.getLayoutParams();
						marginparam_RightFrame.leftMargin = (int)(RightFrame_mar*(((Home)context).deviceWidth));
					}

					if(_objEWLeftBtn.bgcolor.length()>0)
					{
						LeftFrame.setBackgroundColor(Color.parseColor(_objEWLeftBtn.bgcolor));
					}
					if(_objEWMiddle.bgcolor.length()>0)
					{
						MiddleFrame.setBackgroundColor(Color.parseColor(_objEWMiddle.bgcolor));
					}
					if(_objEWRightBtn.bgcolor.length()>0)
					{
						RightFrame.setBackgroundColor(Color.parseColor(_objEWRightBtn.bgcolor));
					}


					final Button LeftBtn = new Button(context);
					final Button RightBtn = new Button(context);
					final TextView Heading = new TextView(context);
					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						LeftFrame.addView(LeftBtn);
					}
					if(_objEWRightBtn.Bitmap.length()>0)
					{
						RightFrame.addView(RightBtn);
					}

					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					params_LeftBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_LeftBtn.height=(int)(TopBarHeight);
					params_LeftBtn.width=(int)(1.0f*TopBarHeight);
					LeftBtn.setLayoutParams(params_LeftBtn);

					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWLeftBtn.Bitmap+".png"))
						{
							String LeftBtnfilePath=_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,LeftBtnfilePath,(float)(TopBarHeight),(float)(1.0f*TopBarHeight));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,LeftBtnfilePath,(float)(TopBarHeight),(float)(1.0f*TopBarHeight));
						}
					}

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_RightBtn.height=(int)(TopBarHeight);
					params_RightBtn.width=(int)(1.0f*TopBarHeight);
					RightBtn.setLayoutParams(params_RightBtn);


					if(_objEWRightBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWRightBtn.Bitmap+".png"))
						{
							String RightBtnfilePath=_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,RightBtnfilePath,(float)(TopBarHeight),(float)(1.0f*TopBarHeight));
						}
						else 
						{
							String RightBtnfilePath="images/"+_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,RightBtnfilePath,(float)(TopBarHeight),(float)(1.0f*TopBarHeight));
						}
					}
					if(_objEWMiddle.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWMiddle.Bitmap+".png"))
						{
							String MiddlefilePath=_objEWMiddle.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(MiddleFrame, context,MiddlefilePath,(float)(TopBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
						else 
						{
							String MiddlefilePath="images/"+_objEWMiddle.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(MiddleFrame, context,MiddlefilePath,(float)(TopBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
					}
					if(_objEWMiddle.Title.length()>0)
					{

						MiddleFrame.addView(Heading);
						Heading.setMaxLines(2);
						Heading.setGravity(Gravity.CENTER);
						Heading.setText(_objEWMiddle.Title);
						int textsize=(int)((0.5f)*(TopBarHeight));
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),textsize));

						if(_objEWMiddle.txtColor.length()>0)
						{
							Heading.setTextColor(Color.parseColor(_objEWMiddle.txtColor));
						}

						ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
						params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
								FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
						params_Heading.height=(int)(TopBarHeight);
						params_Heading.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
						Heading.setLayoutParams(params_Heading);
						ImageUtil.setBackgroundBgFromAssetsNotCache(Heading, context,"images/Heading_Clickable"+".png",TopBarHeight,(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
					}
					if(_objEWLeftBtn.OnClick.length()>0)
					{
						LeftBtn.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									LeftBtn.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									LeftBtn.getBackground().setAlpha(255);

									try
									{
										if(_objEWLeftBtn.OnClick.substring(12).equals("1"))
										{
											try {
												String mailto=_objEWLeftBtn.mailto;
												String body=_objEWLeftBtn.body;
												String subject=_objEWLeftBtn.subject;
												String cc=_objEWLeftBtn.cc;
												String bcc=_objEWLeftBtn.bcc;

												UtilMail mail = new UtilMail();
												mail.OpenMail(context ,mailto,cc,bcc,body,subject);

											} catch (Exception e) {
												// TODO: handle exception
											}


										}
										else
										{
											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
											System.out.println("State Machine"+MyUIApplication.StateMachine);
											if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
											{
//												((Home)context).DesignHomeScreen();
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


												//												if(LastScreen.equals("112"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("113"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("114"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}

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
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println();
									}


									break;
								case MotionEvent.ACTION_CANCEL:
									LeftBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}

								return false;
							}

						});


					}
					if(_objEWRightBtn.OnClick.length()>0)
					{
						RightBtn.setOnClickListener(new OnClickListener() {

							public void onClick(View v)
							{
								if(((Home)context).LLLayoutMenu.getVisibility()==View.VISIBLE && ((Home)context).MenuButton.getVisibility()==View.VISIBLE)
								{

									((Home)context).LLLayoutMenu.setAnimation(((Home)context).outToRightAnimation());

									((Home)context).LLLayoutMenu.setVisibility(View.GONE);
									((Home)context).MenuButton.setVisibility(View.GONE);


									Thread thread = new Thread()
									{
										@Override
										public void run()
										{
											try 
											{
												Thread.sleep(500);
											}
											catch (InterruptedException e)
											{
											}
											((Home)context).runOnUiThread(new Runnable()
											{
												public void run() 
												{
													// Do some stuff
													((Home)context).LLTopMenu.removeAllViews();
													((Home)context).LLMiddleMenu.removeAllViews();
													((Home)context).LLBottomMenu.removeAllViews();
												}
											});
										}
									};

								}
								else
								{
									String screenNumber=_objEWRightBtn.OnClick.substring(12);

									//					Toast.makeText(context, _objEW.rightClick+"Right" +"    "+screenNumber, Toast.LENGTH_SHORT).show();

									//					MyUIApplication.StateMachine.add(screenNumber);

									int i=MyUIApplication.StateMachine.size();
									System.out.println("State Machine Size >>>"+i);
									//					if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
									//					{
									((Home)context).OpenHtmlPage(screenNumber,"");
								}
							}
						});

						RightBtn.setOnTouchListener(new OnTouchListener() {

							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									RightBtn.getBackground().setAlpha(150);
									//							return false;
									break;
								case MotionEvent.ACTION_UP:
									RightBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}

								return false;
							}
						});
					}
					if(_objEWMiddle.OnClick.length()>0)
					{
						Heading.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									Heading.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									Heading.getBackground().setAlpha(255);
									try
									{
										if(MyUIApplication.UserName.length()>0)
										{
											String screenNumber=_objEWMiddle.OnClick.substring(12);

											if(screenNumber.length()>0)
											{
												if(screenNumber.equals("1"))   //  "1" For Mail
												{
													try {
														String mailto=_objEWMiddle.mailto;
														String body=_objEWMiddle.body;
														String subject=_objEWMiddle.subject;
														String cc=_objEWMiddle.cc;
														String bcc=_objEWMiddle.bcc;

														UtilMail mail = new UtilMail();
														mail.OpenMail(context ,mailto,cc,bcc,body,subject);

													} catch (Exception e) {
														// TODO: handle exception
													}

												}
												else
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
										}
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println("Exception in UtilTopBar02 Heading ONTouchEvent"+e);
									}
									break;
								case MotionEvent.ACTION_CANCEL:
									Heading.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}

			}
			else if(Section.equals("Middle"))
			{
				double LLMiddlewidth=Double.parseDouble(_objScreenPartWrapper.MidWidth);
				double LLMiddleheight=Double.parseDouble(_objScreenPartWrapper.MidHeight);
				double LLMiddlewidthPer=LLMiddlewidth/100;
				double LLMiddlePerheight=LLMiddleheight/100;

				ViewGroup.LayoutParams params_LLMiddleBar = ((Home)context).LLMiddle.getLayoutParams();
				int MiddleBarHeight = (int)(LLMiddlePerheight*((Home)context).deviceHeight);
				params_LLMiddleBar.height = MiddleBarHeight;
				params_LLMiddleBar.width =(int)(LLMiddlewidthPer*((Home)context).deviceWidth);
				((Home)context).LLMiddle.setLayoutParams(params_LLMiddleBar);

				try
				{
					if(_objScreenPartWrapper.MidbgImage.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.MidbgImage+".png"))
						{
							String LeftBtnfilePath=_objScreenPartWrapper.MidbgImage+".png";
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLMiddle, context,LeftBtnfilePath,(float)MiddleBarHeight,(float)(LLMiddlewidthPer*((Home)context).deviceWidth));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objScreenPartWrapper.MidbgImage+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLMiddle, context,LeftBtnfilePath,(float)MiddleBarHeight,(float)(LLMiddlewidthPer*((Home)context).deviceWidth));
						}
					}



					for(int i=0 ; i < MyUIApplication._objEWList.size() ; i++)
					{
						if(MyUIApplication._objEWList.get(i).Number.equals("0"))
						{
							_objEWLeftBtn = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("1"))
						{
							_objEWMiddle = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("2"))
						{
							_objEWRightBtn = MyUIApplication._objEWList.get(i);
						}
					}
					FrameLayout LeftFrame = new FrameLayout(context);
					FrameLayout MiddleFrame = new FrameLayout(context);
					FrameLayout RightFrame = new FrameLayout(context);
					if(_objEWLeftBtn != null)
					{
						((Home)context).LLMiddle.addView(LeftFrame);
					}
					if(_objEWMiddle != null)
					{
						((Home)context).LLMiddle.addView(MiddleFrame);
					}
					if(_objEWRightBtn != null)
					{
						((Home)context).LLMiddle.addView(RightFrame);
					}


					double LeftBtnwidth=Double.parseDouble(_objEWLeftBtn.width);
					double LeftBtnheight=Double.parseDouble(_objEWLeftBtn.height);
					double LeftBtnwidthPer=LeftBtnwidth/100;
					double LeftBtnheightPer=LeftBtnheight/100;

					ViewGroup.LayoutParams params_LeftFrame = LeftFrame.getLayoutParams();
					params_LeftFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_LeftFrame.height=(int)(MiddleBarHeight);
					params_LeftFrame.width=(int)(LeftBtnwidthPer*(((Home)context).deviceWidth));
					LeftFrame.setLayoutParams(params_LeftFrame);

					double LeftFrame_mar=Double.parseDouble(_objEWLeftBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_LeftFrame =(FrameLayout.LayoutParams) LeftFrame.getLayoutParams();
					marginparam_LeftFrame.leftMargin = (int)(LeftFrame_mar*(((Home)context).deviceWidth));

					double MiddleBtnwidth=Double.parseDouble(_objEWMiddle.width);
					double MiddleBtnheight=Double.parseDouble(_objEWMiddle.height);
					double MiddleBtnwidthPer=MiddleBtnwidth/100;
					double MiddleBtnheightPer=MiddleBtnheight/100;

					ViewGroup.LayoutParams params_MiddleFrame = MiddleFrame.getLayoutParams();
					params_MiddleFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_MiddleFrame.height=(int)(MiddleBarHeight);
					params_MiddleFrame.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
					MiddleFrame.setLayoutParams(params_MiddleFrame);

					double MiddleFrame_mar=Double.parseDouble(_objEWMiddle.distleft)/100;
					FrameLayout.LayoutParams marginparam_MiddleFrame =(FrameLayout.LayoutParams) MiddleFrame.getLayoutParams();
					marginparam_MiddleFrame.leftMargin = (int)(MiddleFrame_mar*(((Home)context).deviceWidth));

					double RightBtnwidth=Double.parseDouble(_objEWRightBtn.width);
					double RightBtnheight=Double.parseDouble(_objEWRightBtn.height);
					double RightBtnwidthPer=RightBtnwidth/100;
					double RightBtnheightPer=RightBtnheight/100;

					ViewGroup.LayoutParams params_RightFrame = RightFrame.getLayoutParams();
					params_RightFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_RightFrame.height=(int)(MiddleBarHeight);
					params_RightFrame.width=(int)(RightBtnwidthPer*(((Home)context).deviceWidth));
					RightFrame.setLayoutParams(params_RightFrame);

					double RightFrame_mar=Double.parseDouble(_objEWRightBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_RightFrame =(FrameLayout.LayoutParams) RightFrame.getLayoutParams();
					marginparam_RightFrame.leftMargin = (int)(RightFrame_mar*(((Home)context).deviceWidth));


					if(_objEWLeftBtn.bgcolor.length()>0)
					{
						LeftFrame.setBackgroundColor(Color.parseColor(_objEWLeftBtn.bgcolor));
					}
					if(_objEWMiddle.bgcolor.length()>0)
					{
						MiddleFrame.setBackgroundColor(Color.parseColor(_objEWMiddle.bgcolor));
					}
					if(_objEWRightBtn.bgcolor.length()>0)
					{
						RightFrame.setBackgroundColor(Color.parseColor(_objEWRightBtn.bgcolor));
					}


					final Button LeftBtn = new Button(context);
					final Button RightBtn = new Button(context);
					final TextView Heading = new TextView(context);
					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						LeftFrame.addView(LeftBtn);
					}
					if(_objEWRightBtn.Bitmap.length()>0)
					{
						RightFrame.addView(RightBtn);
					}

					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					params_LeftBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_LeftBtn.height=(int)(MiddleBarHeight);
					params_LeftBtn.width=(int)(1.0f*MiddleBarHeight);
					LeftBtn.setLayoutParams(params_LeftBtn);

					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWLeftBtn.Bitmap+".png"))
						{
							String LeftBtnfilePath=_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,LeftBtnfilePath,(float)(MiddleBarHeight),(float)(1.0f*MiddleBarHeight));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,LeftBtnfilePath,(float)(MiddleBarHeight),(float)(1.0f*MiddleBarHeight));
						}
					}

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_RightBtn.height=(int)(MiddleBarHeight);
					params_RightBtn.width=(int)(1.0f*MiddleBarHeight);
					RightBtn.setLayoutParams(params_RightBtn);


					if(_objEWRightBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWRightBtn.Bitmap+".png"))
						{
							String RightBtnfilePath=_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,RightBtnfilePath,(float)(MiddleBarHeight),(float)(1.0f*MiddleBarHeight));
						}
						else 
						{
							String RightBtnfilePath="images/"+_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,RightBtnfilePath,(float)(MiddleBarHeight),(float)(1.0f*MiddleBarHeight));
						}
					}
					if(_objEWMiddle.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWMiddle.Bitmap+".png"))
						{
							String MiddlefilePath=_objEWMiddle.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(MiddleFrame, context,MiddlefilePath,(float)(MiddleBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
						else 
						{
							String MiddlefilePath="images/"+_objEWMiddle.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(MiddleFrame, context,MiddlefilePath,(float)(MiddleBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
					}
					if(_objEWMiddle.Title.length()>0)
					{
						MiddleFrame.addView(Heading);
						Heading.setMaxLines(2);
						Heading.setGravity(Gravity.CENTER);
						Heading.setText(_objEWMiddle.Title);
						int textsize=(int)((0.5f)*(MiddleBarHeight));
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),textsize));

						if(_objEWMiddle.txtColor.length()>0)
						{
							Heading.setTextColor(Color.parseColor(_objEWMiddle.txtColor));
						}

						ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
						params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
								FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
						params_Heading.height=(int)(MiddleBarHeight);
						params_Heading.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
						Heading.setLayoutParams(params_Heading);
						ImageUtil.setBackgroundBgFromAssetsNotCache(Heading, context,"images/Heading_Clickable"+".png",MiddleBarHeight,(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
					}
					if(_objEWLeftBtn.OnClick.length()>0)
					{
						LeftBtn.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									LeftBtn.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									LeftBtn.getBackground().setAlpha(255);

									try
									{
										if(_objEWLeftBtn.OnClick.substring(12).equals("1"))
										{
											try {
												String mailto=_objEWLeftBtn.mailto;
												String body=_objEWLeftBtn.body;
												String subject=_objEWLeftBtn.subject;
												String cc=_objEWLeftBtn.cc;
												String bcc=_objEWLeftBtn.bcc;

												UtilMail mail = new UtilMail();
												mail.OpenMail(context ,mailto,cc,bcc,body,subject);

											} catch (Exception e) {
												// TODO: handle exception
											}


										}
										else
										{
											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
											System.out.println("State Machine"+MyUIApplication.StateMachine);
											if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
											{
//												((Home)context).DesignHomeScreen();
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


												//												if(LastScreen.equals("112"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("113"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("114"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}

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
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println();
									}
									break;
								case MotionEvent.ACTION_CANCEL:
									LeftBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});
					}
					if(_objEWRightBtn.OnClick.length()>0)
					{
						RightBtn.setOnClickListener(new OnClickListener() 
						{
							public void onClick(View v)
							{
								if(((Home)context).LLLayoutMenu.getVisibility()==View.VISIBLE && ((Home)context).MenuButton.getVisibility()==View.VISIBLE)
								{

									((Home)context).LLLayoutMenu.setAnimation(((Home)context).outToRightAnimation());

									((Home)context).LLLayoutMenu.setVisibility(View.GONE);
									((Home)context).MenuButton.setVisibility(View.GONE);


									Thread thread = new Thread()
									{
										@Override
										public void run()
										{
											try 
											{
												Thread.sleep(500);
											}
											catch (InterruptedException e)
											{
											}
											((Home)context).runOnUiThread(new Runnable()
											{
												public void run() 
												{
													// Do some stuff
													((Home)context).LLTopMenu.removeAllViews();
													((Home)context).LLMiddleMenu.removeAllViews();
													((Home)context).LLBottomMenu.removeAllViews();
												}
											});
										}
									};

								}
								else
								{
									String screenNumber=_objEWRightBtn.OnClick.substring(12);

									//					Toast.makeText(context, _objEW.rightClick+"Right" +"    "+screenNumber, Toast.LENGTH_SHORT).show();

									//					MyUIApplication.StateMachine.add(screenNumber);

									int i=MyUIApplication.StateMachine.size();
									System.out.println("State Machine Size >>>"+i);
									//					if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
									//					{
									((Home)context).OpenHtmlPage(screenNumber,"");
								}
							}
						});
						RightBtn.setOnTouchListener(new OnTouchListener() {

							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									RightBtn.getBackground().setAlpha(150);
									//							return false;
									break;
								case MotionEvent.ACTION_UP:
									RightBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});
					}
					if(_objEWMiddle.OnClick.length()>0)
					{
						Heading.setOnTouchListener(new OnTouchListener() {

							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									Heading.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									Heading.getBackground().setAlpha(255);
									try
									{
										if(MyUIApplication.UserName.length()>0)
										{
											String screenNumber=_objEWMiddle.OnClick.substring(12);

											if(screenNumber.length()>0)
											{
												if(screenNumber.equals("1"))   //  "1" For Mail
												{
													try {
														String mailto=_objEWMiddle.mailto;
														String body=_objEWMiddle.body;
														String subject=_objEWMiddle.subject;
														String cc=_objEWMiddle.cc;
														String bcc=_objEWMiddle.bcc;

														UtilMail mail = new UtilMail();
														mail.OpenMail(context ,mailto,cc,bcc,body,subject);

													} catch (Exception e) {
														// TODO: handle exception
													}

												}
												else
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
										}
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println("Exception in UtilTopBar02 Heading ONTouchEvent"+e);
									}
									break;
								case MotionEvent.ACTION_CANCEL:
									Heading.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});

					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Middle Bar"+e);
				}

			}
			else if(Section.equals("Bottom"))
			{
				double LLBottomwidth=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
				double LLBottomheight=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
				double LLBottomwidthPer=LLBottomwidth/100;
				double LLBottomPerheight=LLBottomheight/100;

				ViewGroup.LayoutParams params_LLBottomBar = ((Home)context).LLBottom.getLayoutParams();
				int BottomBarHeight = (int)(LLBottomPerheight*((Home)context).deviceHeight);
				params_LLBottomBar.height = BottomBarHeight;
				params_LLBottomBar.width =(int)(LLBottomwidthPer*((Home)context).deviceWidth);
				((Home)context).LLBottom.setLayoutParams(params_LLBottomBar);

				try
				{
					if(_objScreenPartWrapper.BottombgImage.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.BottombgImage+".png"))
						{
							String LeftBtnfilePath=_objScreenPartWrapper.BottombgImage+".png";
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLBottom, context,LeftBtnfilePath,(float)BottomBarHeight,(float)(LLBottomwidthPer*((Home)context).deviceWidth));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objScreenPartWrapper.BottombgImage+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLBottom, context,LeftBtnfilePath,(float)BottomBarHeight,(float)(LLBottomwidthPer*((Home)context).deviceWidth));
						}
					}



					for(int i=0 ; i < MyUIApplication._objEWList.size() ; i++)
					{
						if(MyUIApplication._objEWList.get(i).Number.equals("0"))
						{
							_objEWLeftBtn = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("1"))
						{
							_objEWMiddle = MyUIApplication._objEWList.get(i);
						}
						else if(MyUIApplication._objEWList.get(i).Number.equals("2"))
						{
							_objEWRightBtn = MyUIApplication._objEWList.get(i);
						}
					}
					FrameLayout LeftFrame = new FrameLayout(context);
					FrameLayout MiddleFrame = new FrameLayout(context);
					FrameLayout RightFrame = new FrameLayout(context);
					if(_objEWLeftBtn != null)
					{
						((Home)context).LLBottom.addView(LeftFrame);
					}
					if(_objEWMiddle != null)
					{
						((Home)context).LLBottom.addView(MiddleFrame);
					}
					if(_objEWRightBtn != null)
					{
						((Home)context).LLBottom.addView(RightFrame);
					}


					double LeftBtnwidth=Double.parseDouble(_objEWLeftBtn.width);
					double LeftBtnheight=Double.parseDouble(_objEWLeftBtn.height);
					double LeftBtnwidthPer=LeftBtnwidth/100;
					double LeftBtnheightPer=LeftBtnheight/100;

					ViewGroup.LayoutParams params_LeftFrame = LeftFrame.getLayoutParams();
					params_LeftFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_LeftFrame.height=(int)(BottomBarHeight);
					params_LeftFrame.width=(int)(LeftBtnwidthPer*(((Home)context).deviceWidth));
					LeftFrame.setLayoutParams(params_LeftFrame);

					double LeftFrame_mar=Double.parseDouble(_objEWLeftBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_LeftFrame =(FrameLayout.LayoutParams) LeftFrame.getLayoutParams();
					marginparam_LeftFrame.leftMargin = (int)(LeftFrame_mar*(((Home)context).deviceWidth));

					double MiddleBtnwidth=Double.parseDouble(_objEWMiddle.width);
					double MiddleBtnheight=Double.parseDouble(_objEWMiddle.height);
					double MiddleBtnwidthPer=MiddleBtnwidth/100;
					double MiddleBtnheightPer=MiddleBtnheight/100;

					ViewGroup.LayoutParams params_MiddleFrame = MiddleFrame.getLayoutParams();
					params_MiddleFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT);
					params_MiddleFrame.height=(int)(BottomBarHeight);
					params_MiddleFrame.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
					MiddleFrame.setLayoutParams(params_MiddleFrame);

					double MiddleFrame_mar=Double.parseDouble(_objEWMiddle.distleft)/100;
					FrameLayout.LayoutParams marginparam_MiddleFrame =(FrameLayout.LayoutParams) MiddleFrame.getLayoutParams();
					marginparam_MiddleFrame.leftMargin = (int)(MiddleFrame_mar*(((Home)context).deviceWidth));

					double RightBtnwidth=Double.parseDouble(_objEWRightBtn.width);
					double RightBtnheight=Double.parseDouble(_objEWRightBtn.height);
					double RightBtnwidthPer=RightBtnwidth/100;
					double RightBtnheightPer=RightBtnheight/100;

					ViewGroup.LayoutParams params_RightFrame = RightFrame.getLayoutParams();
					params_RightFrame = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					params_RightFrame.height=(int)(BottomBarHeight);
					params_RightFrame.width=(int)(RightBtnwidthPer*(((Home)context).deviceWidth));
					RightFrame.setLayoutParams(params_RightFrame);

					double RightFrame_mar=Double.parseDouble(_objEWRightBtn.distleft)/100;
					FrameLayout.LayoutParams marginparam_RightFrame =(FrameLayout.LayoutParams) RightFrame.getLayoutParams();
					marginparam_RightFrame.leftMargin = (int)(RightFrame_mar*(((Home)context).deviceWidth));


					if(_objEWLeftBtn.bgcolor.length()>0)
					{
						LeftFrame.setBackgroundColor(Color.parseColor(_objEWLeftBtn.bgcolor));
					}
					if(_objEWMiddle.bgcolor.length()>0)
					{
						MiddleFrame.setBackgroundColor(Color.parseColor(_objEWMiddle.bgcolor));
					}
					if(_objEWRightBtn.bgcolor.length()>0)
					{
						RightFrame.setBackgroundColor(Color.parseColor(_objEWRightBtn.bgcolor));
					}


					final Button LeftBtn = new Button(context);
					final Button RightBtn = new Button(context);
					final TextView Heading = new TextView(context);
					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						LeftFrame.addView(LeftBtn);
					}
					if(_objEWRightBtn.Bitmap.length()>0)
					{
						RightFrame.addView(RightBtn);
					}

					ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
					params_LeftBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_LeftBtn.height=(int)(BottomBarHeight);
					params_LeftBtn.width=(int)(1.0f*BottomBarHeight);
					LeftBtn.setLayoutParams(params_LeftBtn);

					if(_objEWLeftBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWLeftBtn.Bitmap+".png"))
						{
							String LeftBtnfilePath=_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,LeftBtnfilePath,(float)(BottomBarHeight),(float)(1.0f*BottomBarHeight));
						}
						else 
						{
							String LeftBtnfilePath="images/"+_objEWLeftBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,LeftBtnfilePath,(float)(BottomBarHeight),(float)(1.0f*BottomBarHeight));
						}
					}

					ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
					params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_RightBtn.height=(int)(BottomBarHeight);
					params_RightBtn.width=(int)(1.0f*BottomBarHeight);
					RightBtn.setLayoutParams(params_RightBtn);


					if(_objEWRightBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWRightBtn.Bitmap+".png"))
						{
							String RightBtnfilePath=_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,RightBtnfilePath,(float)(BottomBarHeight),(float)(1.0f*BottomBarHeight));
						}
						else 
						{
							String RightBtnfilePath="images/"+_objEWRightBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,RightBtnfilePath,(float)(BottomBarHeight),(float)(1.0f*BottomBarHeight));
						}
					}
					if(_objEWMiddle.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWMiddle.Bitmap+".png"))
						{
							String MiddlefilePath=_objEWMiddle.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(MiddleFrame, context,MiddlefilePath,(float)(BottomBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
						else 
						{
							String MiddlefilePath="images/"+_objEWMiddle.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(MiddleFrame, context,MiddlefilePath,(float)(BottomBarHeight),(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
						}
					}
					if(_objEWMiddle.Title.length()>0)
					{
						MiddleFrame.addView(Heading);
						Heading.setMaxLines(2);
						Heading.setGravity(Gravity.CENTER);
						Heading.setText(_objEWMiddle.Title);
						int textsize=(int)((0.5f)*(BottomBarHeight));
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),textsize));

						if(_objEWMiddle.txtColor.length()>0)
						{
							Heading.setTextColor(Color.parseColor(_objEWMiddle.txtColor));
						}

						ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
						params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
								FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
						params_Heading.height=(int)(BottomBarHeight);
						params_Heading.width=(int)((((Home)context).deviceWidth)*MiddleBtnwidthPer);
						Heading.setLayoutParams(params_Heading);
						ImageUtil.setBackgroundBgFromAssetsNotCache(Heading, context,"images/Heading_Clickable"+".png",BottomBarHeight,(float)((((Home)context).deviceWidth)*MiddleBtnwidthPer));
					}
					if(_objEWLeftBtn.OnClick.length()>0)
					{
						LeftBtn.setOnTouchListener(new OnTouchListener() {


							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									LeftBtn.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									LeftBtn.getBackground().setAlpha(255);

									try
									{
										if(_objEWLeftBtn.OnClick.substring(12).equals("1"))
										{
											try {
												String mailto=_objEWLeftBtn.mailto;
												String body=_objEWLeftBtn.body;
												String subject=_objEWLeftBtn.subject;
												String cc=_objEWLeftBtn.cc;
												String bcc=_objEWLeftBtn.bcc;

												UtilMail mail = new UtilMail();
												mail.OpenMail(context ,mailto,cc,bcc,body,subject);

											} catch (Exception e) {
												// TODO: handle exception
											}



										}
										else
										{
											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
											System.out.println("State Machine"+MyUIApplication.StateMachine);
											if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
											{
//												((Home)context).DesignHomeScreen();
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


												//												if(LastScreen.equals("112"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("113"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}
												//												else if(LastScreen.equals("114"))
												//												{
												//													MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
												//													LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
												//												}

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
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println();
									}

									break;
								case MotionEvent.ACTION_CANCEL:
									LeftBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}

								return false;
							}

						});
					}
					if(_objEWRightBtn.OnClick.length()>0)
					{
						RightBtn.setOnClickListener(new OnClickListener()
						{
							public void onClick(View v)
							{
								if(((Home)context).LLLayoutMenu.getVisibility()==View.VISIBLE && ((Home)context).MenuButton.getVisibility()==View.VISIBLE)
								{

									((Home)context).LLLayoutMenu.setAnimation(((Home)context).outToRightAnimation());

									((Home)context).LLLayoutMenu.setVisibility(View.GONE);
									((Home)context).MenuButton.setVisibility(View.GONE);


									Thread thread = new Thread()
									{
										@Override
										public void run()
										{
											try 
											{
												Thread.sleep(500);
											}
											catch (InterruptedException e)
											{
											}
											((Home)context).runOnUiThread(new Runnable()
											{
												public void run() 
												{
													// Do some stuff
													((Home)context).LLTopMenu.removeAllViews();
													((Home)context).LLMiddleMenu.removeAllViews();
													((Home)context).LLBottomMenu.removeAllViews();
												}
											});
										}
									};

								}
								else
								{
									String screenNumber=_objEWRightBtn.OnClick.substring(12);

									//					Toast.makeText(context, _objEW.rightClick+"Right" +"    "+screenNumber, Toast.LENGTH_SHORT).show();

									//					MyUIApplication.StateMachine.add(screenNumber);

									int i=MyUIApplication.StateMachine.size();
									System.out.println("State Machine Size >>>"+i);
									//					if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
									//					{
									((Home)context).OpenHtmlPage(screenNumber,"");
								}
							}
						});

						RightBtn.setOnTouchListener(new OnTouchListener() 
						{
							public boolean onTouch(View v, MotionEvent event)
							{
								switch(event.getAction()) 
								{
								case MotionEvent.ACTION_DOWN:
									RightBtn.getBackground().setAlpha(150);
									//							return false;
									break;
								case MotionEvent.ACTION_UP:
									RightBtn.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}

						});
					}
					if(_objEWMiddle.OnClick.length()>0)
					{
						Heading.setOnTouchListener(new OnTouchListener() {

							public boolean onTouch(View v, MotionEvent event) {

								switch(event.getAction()) {

								case MotionEvent.ACTION_DOWN:
									Heading.getBackground().setAlpha(150);
									//							return false;
									return true;
								case MotionEvent.ACTION_UP:
									Heading.getBackground().setAlpha(255);
									try
									{
										if(MyUIApplication.UserName.length()>0)
										{
											String screenNumber=_objEWMiddle.OnClick.substring(12);

											if(screenNumber.length()>0)
											{
												if(screenNumber.equals("1"))   //  "1" For Mail
												{
													try {
														String mailto=_objEWMiddle.mailto;
														String body=_objEWMiddle.body;
														String subject=_objEWMiddle.subject;
														String cc=_objEWMiddle.cc;
														String bcc=_objEWMiddle.bcc;

														UtilMail mail = new UtilMail();
														mail.OpenMail(context ,mailto,cc,bcc,body,subject);

													} catch (Exception e) {
														// TODO: handle exception
													}

												}
												else
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
										}
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println("Exception in UtilTopBar02 Heading ONTouchEvent"+e);
									}
									break;
								case MotionEvent.ACTION_CANCEL:
									Heading.getBackground().setAlpha(255);
									//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
									break;
								}
								return false;
							}
						});

					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Bottom Bar"+e);
				}
			}
		}
	}
}
