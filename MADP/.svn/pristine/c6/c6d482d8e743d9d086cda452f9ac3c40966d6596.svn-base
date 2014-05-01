package mobi.neuerung.Util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;





public class UtilTopBar {

	public  TextView Heading;
	Context context;
	// *** Method for setting Top Bar ****
	public void UniversalTopBar(ScreenPartWrapper _objScreenPartWrapper, String Section,final Context context)
	{
		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);
		this.context = context;
		int i = _objEW.leftClick.length();
		System.out.println(""+i);


		if(MyUIApplication.Copy)
		{
			final ImageView LeftBtn = new ImageView(context);
			final ImageView RightBtn = new ImageView(context);

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




				try
				{

					if(_objScreenPartWrapper.TopbgImage.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.TopbgImage))
						{
							String TopbgImagefilePath=_objScreenPartWrapper.TopbgImage;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLTopCopy, context,TopbgImagefilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
						else 
						{
							String TopbgImagefilePath="images/"+_objScreenPartWrapper.TopbgImage;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTopCopy, context,TopbgImagefilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
					}
					else if(_objScreenPartWrapper.Topbgcolor.length()>0)
					{
						((Home)context).LLTopCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					}





					if(_objEW.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLTopCopy, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTopCopy, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
					}
					Heading= new TextView(context);

					try {
						float midper = Integer.parseInt(_objEW.middleper)/100.0f;

						Heading.getLayoutParams().width =(int)(midper*widthLLTopCopyPer*((Home)context).deviceWidth);

					} catch (Exception e) {
						// TODO: handle exception
					}

					Heading.setMaxLines(2);

					Heading.setText(_objEW.Title);


					try {
						Typeface tf = MyUIApplication.fontmap.get(_objEW.fontStyle);
						Heading.setTypeface(tf);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						Heading.setTextColor(Color.parseColor(_objEW.fontColor));
						int ii = Integer.parseInt(_objEW.fontSize);
						float testsizepercent = ii/960f;
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(testsizepercent*((Home)context).deviceHeight)));
					} catch (Exception e) {
						// TODO: handle exception
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopCopyPer*((Home)context).deviceHeight)));
					}


					//					Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopCopyPer*((Home)context).deviceHeight)));
					Heading.setGravity(Gravity.CENTER);
					((Home)context).LLTopCopy.addView(Heading);

					ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
					params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_Heading.width=(int)(.65f*((Home)context).deviceWidth);
					Heading.setLayoutParams(params_Heading);

					if(_objEW.leftper.trim().length()>0)
					{
						if(_objEW.left.length()>0)
						{

							((Home)context).LLTopCopy.addView(LeftBtn);
							//						LeftBtn.setGravity(Gravity.LEFT);

							ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
							int lftbtnhgt=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
							params_LeftBtn.height=(int)(lftbtnhgt);
							try {
								float leftper = Float.parseFloat(_objEW.leftper.trim())/100.0f;
								params_LeftBtn.width=(int)(leftper*widthLLTopCopyPer*((Home)context).deviceWidth);
							} catch (Exception e) {
								// TODO: handle exception
								params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
							}

							LeftBtn.setLayoutParams(params_LeftBtn);


							if(MyUIApplication.IsSdCardImageAvailable(_objEW.left))
							{
								String lftBtnfilePath=_objEW.left;
								Bitmap bmp = ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));

								if(bmp != null)
								{

									LeftBtn.setImageBitmap(bmp);
									LeftBtn.setBackgroundDrawable(null);

								}

							}
							else 
							{
								String lftBtnfilePath="images/"+_objEW.left;
								Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));

								if(bmp != null)
								{

									LeftBtn.setImageBitmap(bmp);
									LeftBtn.setBackgroundDrawable(null);

								}
							}


							if(MyUIApplication.currentScreenNumber.equals("0"))
							{
								if(!((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
								{
									LeftBtn.setVisibility(View.GONE);
								}
								else
								{
									try {
										ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
										Boolean showbackonhome = (Boolean)ai.metaData.get("showbackonhome");
										if(showbackonhome)
										{
										}
										else
										{
											LeftBtn.setBackgroundDrawable(null);
										}

									} catch (Exception e) {
										// TODO: handle exception
										LeftBtn.setBackgroundDrawable(null);
									}

								}
							}




						}
					}
					if(_objEW.rightper.trim().length()>0)
					{
						if(_objEW.right.length()>0)
						{

							((Home)context).LLTopCopy.addView(RightBtn);
							//						RightBtn.setGravity(Gravity.RIGHT);

							ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
							params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
									FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
							int lftbtnhgt=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
							params_RightBtn.height=(int)(lftbtnhgt);

							try {
								float rightper = Float.parseFloat(_objEW.rightper.trim())/100.0f;
								params_RightBtn.width=(int)(rightper*widthLLTopCopyPer*((Home)context).deviceWidth);
							} catch (Exception e) {
								// TODO: handle exception
								params_RightBtn.width=(int)(1.0f*lftbtnhgt);
							}

							RightBtn.setLayoutParams(params_RightBtn);




							if(MyUIApplication.IsSdCardImageAvailable(_objEW.right))
							{
								String rghtBtnfilePath=_objEW.right;
								ImageUtil.setBgFromSDCardNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
							else 
							{
								String rghtBtnfilePath="images/"+_objEW.right;
								ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}



						}
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}
			}
			else if(Section.equals("Middle"))
			{
				double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
				double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
				double widthLLTopCopyPer=widthLLTopCopy/100;
				double heightLLTopCopyPer=heightLLTopCopy/100;

				ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
				params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
				params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
				((Home)context).LLMiddleCopy.setLayoutParams(params_LLTopCopy);

				try
				{
					if(_objEW.Bitmap.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLMiddleCopy, context,topbarfilePath,(float)(heightLLTopCopyPer*((Home)context).deviceHeight),(float)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLMiddleCopy, context,topbarfilePath,(float)(heightLLTopCopyPer*((Home)context).deviceHeight),(float)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
					}
					Heading= new TextView(context);

					try {
						float midper = Integer.parseInt(_objEW.middleper)/100.0f;

						Heading.getLayoutParams().width =(int)(midper*widthLLTopCopyPer*((Home)context).deviceWidth);

					} catch (Exception e) {
						// TODO: handle exception
					}


					Heading.setText(_objEW.Title);
					Heading.setGravity(Gravity.CENTER);


					try {
						Typeface tf = MyUIApplication.fontmap.get(_objEW.fontStyle);
						Heading.setTypeface(tf);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						Heading.setTextColor(Color.parseColor(_objEW.fontColor));
						int ii = Integer.parseInt(_objEW.fontSize);
						float testsizepercent = ii/960f;
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(testsizepercent*((Home)context).deviceHeight)));
					} catch (Exception e) {
						// TODO: handle exception
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopCopyPer*((Home)context).deviceHeight)));
					}


					//					Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(.092f*((Home)context).deviceHeight)));
					((Home)context).LLMiddleCopy.addView(Heading);

					ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
					params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_Heading.width=(int)(.65f*((Home)context).deviceWidth);
					Heading.setLayoutParams(params_Heading);

					if(_objScreenPartWrapper.MidbgImage.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.MidbgImage))
						{
							String MiddlebgImagefilePath=_objScreenPartWrapper.MidbgImage;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLMiddleCopy, context,MiddlebgImagefilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
						else 
						{
							String MiddlebgImagefilePath="images/"+_objScreenPartWrapper.MidbgImage;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLMiddleCopy, context,MiddlebgImagefilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
					}
					else if(_objScreenPartWrapper.Midbgcolor.length()>0)
					{
						((Home)context).LLMiddleCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					}


					if(_objEW.leftper.trim().length()>0)
					{

						if(_objEW.left.length()>0)
						{
							((Home)context).LLMiddleCopy.addView(LeftBtn);
							//						LeftBtn.setGravity(Gravity.LEFT|Gravity.TOP);

							ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
							int lftbtnhgt=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
							params_LeftBtn.height=(int)(lftbtnhgt);
							try {
								float leftper = Float.parseFloat(_objEW.leftper.trim())/100.0f;
								params_LeftBtn.width=(int)(leftper*widthLLTopCopyPer*((Home)context).deviceWidth);
							} catch (Exception e) {
								// TODO: handle exception
								params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
							}
							LeftBtn.setLayoutParams(params_LeftBtn);


							if(MyUIApplication.IsSdCardImageAvailable(_objEW.left))
							{
								String lftBtnfilePath=_objEW.left;
								ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
							else 
							{
								String lftBtnfilePath="images/"+_objEW.left;
								ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}




							if(MyUIApplication.currentScreenNumber.equals("0"))
							{
								if(!((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
								{
									LeftBtn.setVisibility(View.GONE);
								}
								else
								{
									try {
										ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
										Boolean showbackonhome = (Boolean)ai.metaData.get("showbackonhome");
										if(showbackonhome)
										{
										}
										else
										{
											LeftBtn.setBackgroundDrawable(null);
										}

									} catch (Exception e) {
										// TODO: handle exception
										LeftBtn.setBackgroundDrawable(null);
									}

								}
							}

						}
					}
					if(_objEW.rightper.trim().length()>0)
					{
						if(_objEW.right.length()>0)
						{
							((Home)context).LLMiddleCopy.addView(RightBtn);
							//						RightBtn.setGravity(Gravity.RIGHT|Gravity.TOP);

							ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
							params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
									FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
							int lftbtnhgt=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
							params_RightBtn.height=(int)(lftbtnhgt);
							try {
								float rightper = Float.parseFloat(_objEW.rightper.trim())/100.0f;
								params_RightBtn.width=(int)(rightper*widthLLTopCopyPer*((Home)context).deviceWidth);
							} catch (Exception e) {
								// TODO: handle exception
								params_RightBtn.width=(int)(1.0f*lftbtnhgt);
							}
							RightBtn.setLayoutParams(params_RightBtn);

							if(MyUIApplication.IsSdCardImageAvailable(_objEW.right))
							{
								String rghtBtnfilePath=_objEW.right;
								ImageUtil.setBgFromSDCardNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
							else 
							{
								String rghtBtnfilePath="images/"+_objEW.right;
								ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
						}
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}
			}
			else if(Section.equals("Bottom"))
			{
				double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
				double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
				double widthLLTopCopyPer=widthLLTopCopy/100;
				double heightLLTopCopyPer=heightLLTopCopy/100;

				ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLBottomCopy.getLayoutParams();
				params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
				params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
				((Home)context).LLBottomCopy.setLayoutParams(params_LLTopCopy);

				try
				{
					if(_objEW.Bitmap.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLBottomCopy, context,topbarfilePath,(float)(heightLLTopCopyPer*((Home)context).deviceHeight),(float)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLBottomCopy, context,topbarfilePath,(float)(heightLLTopCopyPer*((Home)context).deviceHeight),(float)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
					}

					Heading= new TextView(context);

					try {
						float midper = Integer.parseInt(_objEW.middleper)/100.0f;

						Heading.getLayoutParams().width =(int)(midper*widthLLTopCopyPer*((Home)context).deviceWidth);

					} catch (Exception e) {
						// TODO: handle exception
					}

					Heading.setText(_objEW.Title);


					try {
						Typeface tf = MyUIApplication.fontmap.get(_objEW.fontStyle);
						Heading.setTypeface(tf);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						Heading.setTextColor(Color.parseColor(_objEW.fontColor));
						int ii = Integer.parseInt(_objEW.fontSize);
						float testsizepercent = ii/960f;
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(testsizepercent*((Home)context).deviceHeight)));
					} catch (Exception e) {
						// TODO: handle exception
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopCopyPer*((Home)context).deviceHeight)));
					}


					//					Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(.092f*((Home)context).deviceHeight)));
					Heading.setGravity(Gravity.CENTER);
					((Home)context).LLBottomCopy.addView(Heading);

					ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
					params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_Heading.width=(int)(.65f*((Home)context).deviceWidth);
					Heading.setLayoutParams(params_Heading);

					if(_objScreenPartWrapper.BottombgImage.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.BottombgImage))
						{
							String BottombgImagefilePath=_objScreenPartWrapper.BottombgImage;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLBottomCopy, context,BottombgImagefilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
						else 
						{
							String BottombgImagefilePath="images/"+_objScreenPartWrapper.BottombgImage;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLBottomCopy, context,BottombgImagefilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
						}
					}
					else if(_objScreenPartWrapper.Bottombgcolor.length()>0)
					{
						((Home)context).LLBottomCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					}


					if(_objEW.leftper.trim().length()>0)
					{

						if(_objEW.left.length()>0)
						{
							((Home)context).LLBottomCopy.addView(LeftBtn);
							//						LeftBtn.setGravity(Gravity.LEFT);

							ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
							int lftbtnhgt=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
							params_LeftBtn.height=(int)(lftbtnhgt);
							try {
								float leftper = Float.parseFloat(_objEW.leftper.trim())/100.0f;
								params_LeftBtn.width=(int)(leftper*widthLLTopCopyPer*((Home)context).deviceWidth);
							} catch (Exception e) {
								// TODO: handle exception
								params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
							}
							LeftBtn.setLayoutParams(params_LeftBtn);


							if(MyUIApplication.IsSdCardImageAvailable(_objEW.left))
							{
								String lftBtnfilePath=_objEW.left;
								ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
							else 
							{
								String lftBtnfilePath="images/"+_objEW.left;
								ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}



							if(MyUIApplication.currentScreenNumber.equals("0"))
							{
								if(!((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
								{
									LeftBtn.setVisibility(View.GONE);
								}
								else
								{
									try {
										ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
										Boolean showbackonhome = (Boolean)ai.metaData.get("showbackonhome");
										if(showbackonhome)
										{
										}
										else
										{
											LeftBtn.setBackgroundDrawable(null);
										}

									} catch (Exception e) {
										// TODO: handle exception
										LeftBtn.setBackgroundDrawable(null);
									}

								}
							}
						}


					}
					if(_objEW.rightper.trim().length()>0)
					{
						if(_objEW.right.length()>0)
						{
							((Home)context).LLBottomCopy.addView(RightBtn);
							//						RightBtn.setGravity(Gravity.RIGHT);

							ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
							params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
									FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
							int lftbtnhgt=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
							params_RightBtn.height=(int)(lftbtnhgt);
							try {
								float rightper = Float.parseFloat(_objEW.rightper.trim())/100.0f;
								params_RightBtn.width=(int)(rightper*widthLLTopCopyPer*((Home)context).deviceWidth);
							} catch (Exception e) {
								// TODO: handle exception
								params_RightBtn.width=(int)(1.0f*lftbtnhgt);
							}
							RightBtn.setLayoutParams(params_RightBtn);


							if(MyUIApplication.IsSdCardImageAvailable(_objEW.right))
							{
								String rghtBtnfilePath=_objEW.right;
								ImageUtil.setBgFromSDCardNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
							else 
							{
								String rghtBtnfilePath="images/"+_objEW.right;
								ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
						}
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}
			}
			//			if(_objEW.leftClick.length()>12)
			//			{
			//				LeftBtn.setOnClickListener( new OnClickListener() {
			//
			//					public void onClick(View v) {
			//						//					Toast.makeText(context, _objEW.leftClick+"Left", Toast.LENGTH_SHORT).show();
			//
			//						MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
			//						System.out.println("State Machine"+MyUIApplication.StateMachine);
			//						if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
			//						{
			//							((Home)context).DesignHomeScreen();
			//							if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
			//							{
			//								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
			//								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
			//							}
			//							if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
			//							{
			//								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
			//								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
			//							}
			//
			//
			//						}
			//						else
			//						{
			//
			//							if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
			//							{
			//								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
			//								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
			//							}
			//							if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
			//							{
			//								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
			//								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
			//							}
			//							String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
			//							((Home)context).OpenHtmlPage(LastScreen);
			//						}
			//					}
			//				});
			LeftBtn.setOnTouchListener(new OnTouchListener() {


				public boolean onTouch(View v, MotionEvent event) {

					switch(event.getAction()) {

					case MotionEvent.ACTION_DOWN:
						try {
							LeftBtn.setAlpha(100);
						} catch (Exception e) {
							// TODO: handle exception
						}

						//							return false;
						return true;
					case MotionEvent.ACTION_UP:
						try {
							LeftBtn.setAlpha(255);
						} catch (Exception e) {
							// TODO: handle exception
						}


						try
						{


							if(MyUIApplication.currentScreenNumber.equals("0"))
							{
								if(((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
								{
									((Activity)context).finish();
									((Activity)context).overridePendingTransition(R.anim.slide_out_right,R.anim.slide_in_right);
								}
							}


							if(_objEW.leftClick.substring(12).equals("1"))
							{
								try {

									String mailto=_objEW.mailto;
									String body=_objEW.body;
									String subject=_objEW.subject;
									String cc=_objEW.cc;
									String bcc=_objEW.bcc;

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
//									((Home)context).DesignHomeScreen();
									((Home)context).OpenHtmlPage("0", "");
									//									if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
									//									{
									//										((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
									//										((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
									//									}
									//									if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
									//									{
									//										((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
									//										((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
									//									}

									((Home)context).outLayoutAnim();


								}
								else
								{
									String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);


									//										if(LastScreen.equals("112"))
									//										{
									//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
									//										}
									//										else if(LastScreen.equals("113"))
									//										{
									//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
									//										}
									//										else if(LastScreen.equals("114"))
									//										{
									//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
									//										}

									((Home)context).OpenHtmlPage(LastScreen,"");
									((Home)context).outLayoutAnim();

									//									if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
									//									{
									//										((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
									//										((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
									//									}
									//									if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
									//									{
									//										((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
									//										((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
									//									}

								}
							}
						}
						catch (Exception e) {
							// TODO: handle exception
							System.out.println();
						}


						break;
					case MotionEvent.ACTION_CANCEL:
						try {
							LeftBtn.setAlpha(255);
							//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
						} catch (Exception e) {
							// TODO: handle exception
						}

						break;
					}

					return false;
				}

			});

			//			}
			if(_objEW.rightClick.length()>0)
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

							String screenNumber=_objEW.rightClick.substring(12);
							if(screenNumber.equals("5"))
							{

								new BadgeBGThread(context, "DownloadHTPMIMage","").execute();

								//								saveImageToGallery();DownloadHTPMIMage


							}
							else  if(MyUIApplication.ScreenNumbers.contains(screenNumber))
							{
								((Home)context).inLayoutAnim();

								v.setEnabled(false);
								((Home)context).OpenHtmlPage(screenNumber,"");
								MyUIApplication.StateMachine.add(screenNumber);

							}
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

		}
		else if(!MyUIApplication.Copy)
		{

			final ImageView LeftBtn = new ImageView(context);
			final ImageView RightBtn = new ImageView(context);

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

				try
				{


					if(_objScreenPartWrapper.TopbgImage.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.TopbgImage))
						{
							String TopbgImagefilePath=_objScreenPartWrapper.TopbgImage;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLTop, context,TopbgImagefilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
						}
						else 
						{
							String TopbgImagefilePath="images/"+_objScreenPartWrapper.TopbgImage;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTop, context,TopbgImagefilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
						}
					}
					else if(_objScreenPartWrapper.Topbgcolor.length()>0)
					{
						((Home)context).LLTop.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					}




					if(_objEW.Bitmap.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLTop, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTop, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
						}
					}
					Heading= new TextView(context);


					try {
						float midper = Integer.parseInt(_objEW.middleper)/100.0f;

						Heading.getLayoutParams().width =(int)(midper*widthLLTopPer*((Home)context).deviceWidth);

					} catch (Exception e) {
						// TODO: handle exception
					}


					Heading.setMaxLines(2);

					Heading.setText(_objEW.Title);


					try {
						Typeface tf = MyUIApplication.fontmap.get(_objEW.fontStyle);
						Heading.setTypeface(tf);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						Heading.setTextColor(Color.parseColor(_objEW.fontColor));
						int ii = Integer.parseInt(_objEW.fontSize);
						float testsizepercent = ii/960f;
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(testsizepercent*((Home)context).deviceHeight)));
					} catch (Exception e) {
						// TODO: handle exception
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopPer*((Home)context).deviceHeight)));
					}


					//					Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopPer*((Home)context).deviceHeight)));
					Heading.setGravity(Gravity.CENTER);
					((Home)context).LLTop.addView(Heading);

					ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
					params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_Heading.width=(int)(.65f*((Home)context).deviceWidth);
					Heading.setLayoutParams(params_Heading);


					if(_objEW.leftper.trim().length()>0)
					{
						if(_objEW.left.length()>0)
						{

							((Home)context).LLTop.addView(LeftBtn);
							//							LeftBtn.setGravity(Gravity.LEFT);

							ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
							int lftbtnhgt=(int)(heightLLTopPer*((Home)context).deviceHeight);
							params_LeftBtn.height=(int)(lftbtnhgt);
							try {
								float leftper = Float.parseFloat(_objEW.leftper.trim())/100.0f;
								params_LeftBtn.width=(int)(leftper*widthLLTopPer*((Home)context).deviceWidth);
							} catch (Exception e) {
								// TODO: handle exception
								params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
							}
							LeftBtn.setLayoutParams(params_LeftBtn);


							if(MyUIApplication.IsSdCardImageAvailable(_objEW.left))
							{
								String lftBtnfilePath=_objEW.left;
								Bitmap bmp = ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));

								if(bmp != null)
								{

									LeftBtn.setImageBitmap(bmp);
									LeftBtn.setBackgroundDrawable(null);

								}
							}
							else 
							{
								String lftBtnfilePath="images/"+_objEW.left;
								ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
							if(MyUIApplication.currentScreenNumber.equals("0"))
							{
								if(!((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
								{
									LeftBtn.setVisibility(View.GONE);
								}
								else
								{
									try {
										ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
										Boolean showbackonhome = (Boolean)ai.metaData.get("showbackonhome");
										if(showbackonhome)
										{
										}
										else
										{
											LeftBtn.setBackgroundDrawable(null);
										}

									} catch (Exception e) {
										// TODO: handle exception
										LeftBtn.setBackgroundDrawable(null);
									}

								}
							}
						}

					}
					if(_objEW.rightper.trim().length()>0)
					{
						if(_objEW.right.length()>0)
						{

							((Home)context).LLTop.addView(RightBtn);
							//							RightBtn.setGravity(Gravity.RIGHT);

							ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
							params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
									FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
							int lftbtnhgt=(int)(heightLLTopPer*((Home)context).deviceHeight);
							params_RightBtn.height=(int)(lftbtnhgt);
							try {
								float rightper = Float.parseFloat(_objEW.rightper.trim())/100.0f;
								params_RightBtn.width=(int)(rightper*widthLLTopPer*((Home)context).deviceWidth);
							} catch (Exception e) {
								// TODO: handle exception
								params_RightBtn.width=(int)(1.0f*lftbtnhgt);
							}
							RightBtn.setLayoutParams(params_RightBtn);


							if(MyUIApplication.IsSdCardImageAvailable(_objEW.right))
							{
								String rghtBtnfilePath=_objEW.right;
								ImageUtil.setBgFromSDCardNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
							else 
							{
								String rghtBtnfilePath="images/"+_objEW.right;
								ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
							}
						}
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}
			}
			else if(Section.equals("Middle"))
			{
				double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
				double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
				double widthLLTopPer=widthLLTop/100;
				double heightLLTopPer=heightLLTop/100;

				ViewGroup.LayoutParams params_LLTop = ((Home)context).LLMiddle.getLayoutParams();
				params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				((Home)context).LLMiddle.setLayoutParams(params_LLTop);

				try
				{
					if(_objEW.Bitmap.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLMiddle, context,topbarfilePath,(float)(heightLLTopPer*((Home)context).deviceHeight),(float)(widthLLTopPer*((Home)context).deviceWidth));
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLMiddle, context,topbarfilePath,(float)(heightLLTopPer*((Home)context).deviceHeight),(float)(widthLLTopPer*((Home)context).deviceWidth));
						}
					}
					Heading= new TextView(context);
					Heading.setText(_objEW.Title);
					Heading.setGravity(Gravity.CENTER);


					try {
						Typeface tf = MyUIApplication.fontmap.get(_objEW.fontStyle);
						Heading.setTypeface(tf);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						Heading.setTextColor(Color.parseColor(_objEW.fontColor));
						int ii = Integer.parseInt(_objEW.fontSize);
						float testsizepercent = ii/960f;
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(testsizepercent*((Home)context).deviceHeight)));
					} catch (Exception e) {
						// TODO: handle exception
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopPer*((Home)context).deviceHeight)));
					}



					//					Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(.092f*((Home)context).deviceHeight)));
					((Home)context).LLMiddle.addView(Heading);

					ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
					params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_Heading.width=(int)(.65f*((Home)context).deviceWidth);
					Heading.setLayoutParams(params_Heading);

					if(_objScreenPartWrapper.MidbgImage.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.MidbgImage))
						{
							String MiddlebgImagefilePath=_objScreenPartWrapper.MidbgImage;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLMiddle, context,MiddlebgImagefilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
						}
						else 
						{
							String MiddlebgImagefilePath="images/"+_objScreenPartWrapper.MidbgImage;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLMiddle, context,MiddlebgImagefilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
						}
					}
					else if(_objScreenPartWrapper.Midbgcolor.length()>0)
					{
						((Home)context).LLMiddle.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					}




					if(_objEW.left.length()>0)
					{
						((Home)context).LLMiddle.addView(LeftBtn);
						//						LeftBtn.setGravity(Gravity.LEFT|Gravity.TOP);

						ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
						int lftbtnhgt=(int)(heightLLTopPer*((Home)context).deviceHeight);
						params_LeftBtn.height=(int)(lftbtnhgt);
						try {
							float leftper = Float.parseFloat(_objEW.leftper.trim())/100.0f;
							params_LeftBtn.width=(int)(leftper*widthLLTopPer*((Home)context).deviceWidth);
						} catch (Exception e) {
							// TODO: handle exception
							params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
						}
						LeftBtn.setLayoutParams(params_LeftBtn);


						if(MyUIApplication.IsSdCardImageAvailable(_objEW.left))
						{
							String lftBtnfilePath=_objEW.left;
							ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
						}
						else 
						{
							String lftBtnfilePath="images/"+_objEW.left;
							ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
						}




						if(MyUIApplication.currentScreenNumber.equals("0"))
						{
							if(!((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
							{
								LeftBtn.setVisibility(View.GONE);
							}
							else
							{
								try {
									ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
									Boolean showbackonhome = (Boolean)ai.metaData.get("showbackonhome");
									if(showbackonhome)
									{
									}
									else
									{
										LeftBtn.setBackgroundDrawable(null);
									}

								} catch (Exception e) {
									// TODO: handle exception
									LeftBtn.setBackgroundDrawable(null);
								}

							}
						}


					}
					if(_objEW.right.length()>0)
					{
						((Home)context).LLMiddle.addView(RightBtn);
						//						RightBtn.setGravity(Gravity.RIGHT|Gravity.TOP);

						ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
						params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
								FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
						int lftbtnhgt=(int)(heightLLTopPer*((Home)context).deviceHeight);
						params_RightBtn.height=(int)(lftbtnhgt);
						try {
							float rightper = Float.parseFloat(_objEW.rightper.trim())/100.0f;
							params_RightBtn.width=(int)(rightper*widthLLTopPer*((Home)context).deviceWidth);
						} catch (Exception e) {
							// TODO: handle exception
							params_RightBtn.width=(int)(1.0f*lftbtnhgt);
						}
						RightBtn.setLayoutParams(params_RightBtn);


						if(MyUIApplication.IsSdCardImageAvailable(_objEW.right))
						{
							String rghtBtnfilePath=_objEW.right;
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
						}
						else 
						{
							String rghtBtnfilePath="images/"+_objEW.right;
							ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
						}
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}
			}
			else if(Section.equals("Bottom"))
			{
				double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
				double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
				double widthLLTopPer=widthLLTop/100;
				double heightLLTopPer=heightLLTop/100;

				ViewGroup.LayoutParams params_LLTop = ((Home)context).LLBottom.getLayoutParams();
				params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				((Home)context).LLBottom.setLayoutParams(params_LLTop);

				try
				{
					if(_objEW.Bitmap.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLBottom, context,topbarfilePath,(float)(heightLLTopPer*((Home)context).deviceHeight),(float)(widthLLTopPer*((Home)context).deviceWidth));
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLBottom, context,topbarfilePath,(float)(heightLLTopPer*((Home)context).deviceHeight),(float)(widthLLTopPer*((Home)context).deviceWidth));
						}
					}

					Heading= new TextView(context);
					Heading.setText(_objEW.Title);


					try {
						Typeface tf = MyUIApplication.fontmap.get(_objEW.fontStyle);
						Heading.setTypeface(tf);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						Heading.setTextColor(Color.parseColor(_objEW.fontColor));
						int ii = Integer.parseInt(_objEW.fontSize);
						float testsizepercent = ii/960f;
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(testsizepercent*((Home)context).deviceHeight)));
					} catch (Exception e) {
						// TODO: handle exception
						Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(int)(heightLLTopPer*((Home)context).deviceHeight)));
					}


					//					Heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(Heading.getTypeface(),(0.5f)*(.092f*((Home)context).deviceHeight)));
					Heading.setGravity(Gravity.CENTER);
					((Home)context).LLBottom.addView(Heading);

					ViewGroup.LayoutParams params_Heading = Heading.getLayoutParams();
					params_Heading = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_Heading.width=(int)(.65f*((Home)context).deviceWidth);
					Heading.setLayoutParams(params_Heading);

					if(_objScreenPartWrapper.BottombgImage.length()>0)
					{

						if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.BottombgImage))
						{
							String BottombgImagefilePath=_objScreenPartWrapper.BottombgImage;
							ImageUtil.setBgFromSDCardNotCache(((Home)context).LLBottom, context,BottombgImagefilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
						}
						else 
						{
							String BottombgImagefilePath="images/"+_objScreenPartWrapper.BottombgImage;
							ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLBottom, context,BottombgImagefilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
						}
					}
					else if(_objScreenPartWrapper.Bottombgcolor.length()>0)
					{
						((Home)context).LLBottom.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					}


					if(_objEW.left.length()>0)
					{
						((Home)context).LLBottom.addView(LeftBtn);
						//						LeftBtn.setGravity(Gravity.LEFT);

						ViewGroup.LayoutParams params_LeftBtn = LeftBtn.getLayoutParams();
						int lftbtnhgt=(int)(heightLLTopPer*((Home)context).deviceHeight);
						params_LeftBtn.height=(int)(lftbtnhgt);
						try {
							float leftper = Float.parseFloat(_objEW.leftper.trim())/100.0f;
							params_LeftBtn.width=(int)(leftper*widthLLTopPer*((Home)context).deviceWidth);
						} catch (Exception e) {
							// TODO: handle exception
							params_LeftBtn.width=(int)(1.0f*lftbtnhgt);
						}
						LeftBtn.setLayoutParams(params_LeftBtn);


						if(MyUIApplication.IsSdCardImageAvailable(_objEW.left))
						{
							String lftBtnfilePath=_objEW.left;
							ImageUtil.setBgFromSDCardNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
						}
						else 
						{
							String lftBtnfilePath="images/"+_objEW.left;
							ImageUtil.setBackgroundBgFromAssetsNotCache(LeftBtn, context,lftBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
						}




						if(MyUIApplication.currentScreenNumber.equals("0"))
						{
							if(!((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
							{
								LeftBtn.setVisibility(View.GONE);
							}
							else
							{
								try {
									ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
									Boolean showbackonhome = (Boolean)ai.metaData.get("showbackonhome");
									if(showbackonhome)
									{
									}
									else
									{
										LeftBtn.setBackgroundDrawable(null);
									}

								} catch (Exception e) {
									// TODO: handle exception
									LeftBtn.setBackgroundDrawable(null);
								}

							}
						}


					}
					if(_objEW.right.length()>0)
					{
						((Home)context).LLBottom.addView(RightBtn);
						//						RightBtn.setGravity(Gravity.RIGHT);

						ViewGroup.LayoutParams params_RightBtn = RightBtn.getLayoutParams();
						params_RightBtn = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
								FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.RIGHT);
						int lftbtnhgt=(int)(heightLLTopPer*((Home)context).deviceHeight);
						params_RightBtn.height=(int)(lftbtnhgt);
						try {
							float rightper = Float.parseFloat(_objEW.rightper.trim())/100.0f;
							params_RightBtn.width=(int)(rightper*widthLLTopPer*((Home)context).deviceWidth);
						} catch (Exception e) {
							// TODO: handle exception
							params_RightBtn.width=(int)(1.0f*lftbtnhgt);
						}

						RightBtn.setLayoutParams(params_RightBtn);



						if(MyUIApplication.IsSdCardImageAvailable(_objEW.right))
						{
							String rghtBtnfilePath=_objEW.right;
							ImageUtil.setBgFromSDCardNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
						}
						else 
						{
							String rghtBtnfilePath="images/"+_objEW.right;
							ImageUtil.setBackgroundBgFromAssetsNotCache(RightBtn, context,rghtBtnfilePath,(float)(lftbtnhgt),(float)(1.0f*lftbtnhgt));
						}
					}
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}
			}
			//			if(_objEW.leftClick.length()>12)
			//			{
			//				LeftBtn.setOnClickListener( new OnClickListener() {
			//
			//					public void onClick(View v) {
			//						//					Toast.makeText(context, _objEW.leftClick+"Left", Toast.LENGTH_SHORT).show();
			//
			//						MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
			//						System.out.println("State Machine"+MyUIApplication.StateMachine);
			//						if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
			//						{
			//							if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
			//							{
			//								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
			//								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
			//							}
			//							if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
			//							{
			//								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
			//								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
			//							}
			//							((Home)context).DesignHomeScreen();
			//
			//						}
			//						else
			//						{
			//							String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
			//							((Home)context).OpenHtmlPage(LastScreen);
			//							if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
			//							{
			//								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
			//								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
			//							}
			//							if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
			//							{
			//								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
			//								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
			//							}
			//							
			//						}
			//					}
			//				});
			LeftBtn.setOnTouchListener(new OnTouchListener() {


				public boolean onTouch(View v, MotionEvent event) {

					switch(event.getAction()) {

					case MotionEvent.ACTION_DOWN:
						try {
							LeftBtn.setAlpha(150);
						} catch (Exception e) {
							// TODO: handle exception
						}


						return true;
					case MotionEvent.ACTION_UP:
						try {
							LeftBtn.setAlpha(255);
						} catch (Exception e) {
							// TODO: handle exception
						}
						try {


							if(MyUIApplication.currentScreenNumber.equals("0"))
							{
								if(((MyUIApplication)MyUIApplication.getContext()).showclientscreen)
								{
									((Activity)context).finish();
									((Activity)context).overridePendingTransition(R.anim.slide_out_right,R.anim.slide_in_right);
								}
							}

							if(_objEW.leftClick.substring(12).equals("1"))
							{
								String mailto=_objEW.mailto;
								String body=_objEW.body;
								String subject=_objEW.subject;
								String cc=_objEW.cc;
								String bcc=_objEW.bcc;

								UtilMail mail = new UtilMail();
								mail.OpenMail(context ,mailto,cc,bcc,body,subject);


							}
							else
							{

								MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
								System.out.println("State Machine"+MyUIApplication.StateMachine);
								if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("0"))
								{

							
									//									if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
									//									{
									//										((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
									//										((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
									//									}
									//									if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
									//									{
									//										((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
									//										((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
									//									}
//									((Home)context).DesignHomeScreen();
									((Home)context).OpenHtmlPage("0", "");
									((Home)context).outLayoutAnim();

								}
								else if(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1).equals("1"))
								{
									try {
										String mailto=_objEW.mailto;
										String body=_objEW.body;
										String subject=_objEW.subject;
										String cc=_objEW.cc;
										String bcc=_objEW.bcc;

										UtilMail mail = new UtilMail();
										mail.OpenMail(context ,mailto,cc,bcc,body,subject);

									} catch (Exception e) {
										// TODO: handle exception
									}

								}
								else
								{
									String LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);


									//										if(LastScreen.equals("112"))
									//										{
									//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
									//										}
									//										else if(LastScreen.equals("113"))
									//										{
									//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
									//										}
									//										else if(LastScreen.equals("114"))
									//										{
									//											MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
									//											LastScreen =MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1);
									//										}

									((Home)context).OpenHtmlPage(LastScreen,"");
									((Home)context).outLayoutAnim();
									//									if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
									//									{
									//										((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
									//										((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
									//									}
									//									if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
									//									{
									//										((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
									//										((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
									//									}

								}
							}
						} catch (Exception e) {
							// TODO: handle exception
						}

						break;
					case MotionEvent.ACTION_CANCEL:
						try {
							LeftBtn.setAlpha(255);
							//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
						} catch (Exception e) {
							// TODO: handle exception
						}

						break;
					}

					return false;
				}

			});
			//			}

			if(_objEW.rightClick.length()>0)
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

							String screenNumber=_objEW.rightClick.substring(12);
							if(screenNumber.equals("5"))
							{
								new BadgeBGThread(context, "DownloadHTPMIMage","").execute();
								//								saveImageToGallery();
							}
							else  if(MyUIApplication.ScreenNumbers.contains(screenNumber))
							{
								((Home)context).inLayoutAnim();

								v.setEnabled(false);
								((Home)context).OpenHtmlPage(screenNumber,"");
								MyUIApplication.StateMachine.add(screenNumber);

							}
						}
					}
				});

				RightBtn.setOnTouchListener(new OnTouchListener() 
				{


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
		}
	}


	public void saveImageToGallery()
	{

		if(MyUIApplication.isInternetAvailable(context))
		{

			Bitmap bitmap;
			try {
				bitmap = BitmapFactory.decodeStream((InputStream)new URL(MyUIApplication.HTMLImageUrl).getContent());

				MediaStore.Images.Media.insertImage(context.getContentResolver(),bitmap,Heading.getText().toString() ,Heading.getText().toString());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}


