package mobi.neuerung.Util;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;



public class UtilAdvertisementBar
{

	ScreenPartWrapper _objScreenPartWrapper;

	// *** Set AdvertisementBar ****
	public void UniversalAdvertisementBar(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{
		this._objScreenPartWrapper =_objScreenPartWrapper;
		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		FrameLayout layout = new FrameLayout(context);

		if(MyUIApplication.Copy)
		{
			if(Section.equals("Top"))
			{
				double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
				double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
				double widthLLTopCopyPer=widthLLTopCopy/100;
				double heightLLTopCopyPer=heightLLTopCopy/100;

				ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLTopCopy.getLayoutParams();
				params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
				params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
				((Home)context).LLTopCopy.setLayoutParams(params_LLMiddleCopy);

				if(_objScreenPartWrapper.TopbgImage.length()>0)
				{
					String topbarfilePath="images/"+_objScreenPartWrapper.TopbgImage;
					//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
					//				((Home)context).LLTopCopy.setBackgroundDrawable(d);
					ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTopCopy, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
				}
				else if(_objScreenPartWrapper.Topbgcolor.length()>0)
				{
					((Home)context).LLTopCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
				}
				
//				if(_objScreenPartWrapper.TopbgImage.length()>0)
//				{
//					if(MyUIApplication.IsSdCardImageAvailable(_objScreenPartWrapper.TopbgImage))
//					{
//						String topbarfilePath=_objScreenPartWrapper.TopbgImage;
//						ImageUtil.setBgFromSDCardNotCache(((Home)context).LLTopCopy, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
//					}
//					else 
//					{
//						String topbarfilePath="images/"+_objScreenPartWrapper.TopbgImage;
//						ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTopCopy, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
//					}
//				}
//				else if(_objScreenPartWrapper.Topbgcolor.length()>0)
//				{
//					((Home)context).LLTopCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
//				}

				try
				{
					ImageView adv= new ImageView(context);
					if(_objEW.ImageMode != null && _objEW.ImageMode.trim().equalsIgnoreCase("crop"))
					{
						adv.setScaleType(ScaleType.CENTER_CROP);
					}
					((Home)context).LLTopCopy.addView(adv);
					((Home)context).LLTopCopy.setTag(adv);


					double heightadv=Double.parseDouble(_objEW.height);
					double widthadv=Double.parseDouble(_objEW.width);


					ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
					params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					int advheight=(int)(heightadv*heightLLTopCopyPer);
					int advwidth=(int)(widthadv*widthLLTopCopyPer);
					int h=(int)(advheight*((Home)context).deviceHeight);
					int w=(int)(advwidth*((Home)context).deviceWidth);
					params_adv.height=(int)(h/100);
					params_adv.width=(int)(w/100);
					adv.setLayoutParams(params_adv);

					if(_objEW.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							Bitmap bmp=null;
							try {
								bmp=ImageUtil.setBgFromSDCardNotCache(adv, context,topbarfilePath,adv.getLayoutParams().height,adv.getLayoutParams().width);
							} catch (Exception e) {
								// TODO: handle exception
								bmp=ImageUtil.setBgFromSDCardNotCache(adv, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
							}

							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
							}

						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));

							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
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

				ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
				params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
				params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
				((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

				if(_objScreenPartWrapper.MidbgImage.length()>0)
				{
					String topbarfilePath="images/"+_objScreenPartWrapper.MidbgImage;
					//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
					//				((Home)context).LLTopCopy.setBackgroundDrawable(d);
					ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLMiddleCopy, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
				}
				else if(_objScreenPartWrapper.Midbgcolor.length()>0)
				{
					((Home)context).LLMiddleCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
				}


				try
				{
					ImageView adv= new ImageView(context);
					if(_objEW.ImageMode != null &&_objEW.ImageMode.trim().equalsIgnoreCase("crop"))
					{
						adv.setScaleType(ScaleType.CENTER_CROP);
					}
					((Home)context).LLMiddleCopy.addView(layout);
					layout.addView(adv);
					layout.setTag(adv);


					double heightadv=Double.parseDouble(_objEW.height);
					double widthadv=Double.parseDouble(_objEW.width);


					ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
					params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					int advheight=(int)(heightadv*heightLLTopCopyPer);
					int advwidth=(int)(widthadv*widthLLTopCopyPer);
					int h=(int)(advheight*((Home)context).deviceHeight);
					int w=(int)(advwidth*((Home)context).deviceWidth);
					params_adv.height=(int)(h/100);
					params_adv.width=(int)(w/100);
					adv.setLayoutParams(params_adv);

					if(_objEW.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							Bitmap bmp =ImageUtil.setBgFromSDCardNotCache(adv, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));

							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
							}
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							//							Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
							Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,adv.getHeight(),adv.getWidth());

							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
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

				ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLBottomCopy.getLayoutParams();
				params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
				params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
				((Home)context).LLBottomCopy.setLayoutParams(params_LLMiddleCopy);

				if(_objScreenPartWrapper.BottombgImage.length()>0)
				{
					String topbarfilePath="images/"+_objScreenPartWrapper.BottombgImage;
					//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
					//				((Home)context).LLTopCopy.setBackgroundDrawable(d);
					ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLBottomCopy, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));
				}
				else if(_objScreenPartWrapper.Bottombgcolor.length()>0)
				{
					((Home)context).LLBottomCopy.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
				}

				try
				{
					ImageView adv= new ImageView(context);
					if(_objEW.ImageMode != null &&_objEW.ImageMode.trim().equalsIgnoreCase("crop"))
					{
						adv.setScaleType(ScaleType.CENTER_CROP);
					}
					((Home)context).LLBottomCopy.addView(adv);
					((Home)context).LLBottomCopy.setTag(adv);


					double heightadv=Double.parseDouble(_objEW.height);
					double widthadv=Double.parseDouble(_objEW.width);


					ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
					params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					int advheight=(int)(heightadv*heightLLTopCopyPer);
					int h=(int)(advheight*((Home)context).deviceHeight);
					params_adv.height=(int)(h/100);
					params_adv.width=(int)(h*3.333f*.01f);
					adv.setLayoutParams(params_adv);

					if(_objEW.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							Bitmap bmp =ImageUtil.setBgFromSDCardNotCache(adv, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));

							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
							}
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopCopyPer*((Home)context).deviceHeight),(int)(widthLLTopCopyPer*((Home)context).deviceWidth));

							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
							}
						}
					}					
				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}
			}




			if(_objEW.OnClick != null && _objEW.OnClick.length()>0)
			{

				layout.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						switch(event.getAction()) 
						{

						case MotionEvent.ACTION_DOWN:

							try {
								((ImageView)v.getTag()).setAlpha(150);
							} catch (Exception e) {
								// TODO: handle exception
							}
							return true;

						case MotionEvent.ACTION_UP:

							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}

							try {


								//								if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
								//								{
								//									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
								//									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								//								}
								//								if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
								//								{
								//									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
								//									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								//								}

								((Home)context).inLayoutAnim();

								String screenNumber=_objEW.OnClick.substring(12);

								((Home)context).OpenHtmlPage(screenNumber,UtilAdvertisementBar.this._objScreenPartWrapper.MidLink);
								MyUIApplication.StateMachine.add(screenNumber);
								v.setEnabled(false);
								int i=MyUIApplication.StateMachine.size();
								System.out.println("State Machine Size >>>"+i);

							} catch (Exception e) {
								// TODO: handle exception
							}

							break;

						case MotionEvent.ACTION_CANCEL:
							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;
						}

						return false;
					}
				});
			}
			else if(_objScreenPartWrapper.TopLink !=null && _objScreenPartWrapper.TopLink.length()>0)
			{

				((Home)context).LLTopCopy.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						switch(event.getAction()) 
						{

						case MotionEvent.ACTION_DOWN:

							try {
								((ImageView)v.getTag()).setAlpha(150);
							} catch (Exception e) {
								// TODO: handle exception
							}
							return true;

						case MotionEvent.ACTION_UP:

							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}

							try {

								String str = UtilAdvertisementBar.this._objScreenPartWrapper.TopLink.toString().trim();

								if(MyUIApplication.isInternetAvailable(context))
								{
									Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
									myWebLink.setData(Uri.parse(str));
									context.startActivity(myWebLink);
								}
								//								else if(str.trim().length()>0)
								//								{
								//									new AlertDialog.Builder(context)
								//									.setTitle("Internet Not Available")
								//									.setMessage("")
								//									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								//										public void onClick(DialogInterface dialog, int which) { 
								//											// continue with delete
								//											dialog.dismiss();
								//
								//										}
								//									}).show();
								//								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;

						case MotionEvent.ACTION_CANCEL:
							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;
						}

						return false;
					}
				});

			}
			else if(_objScreenPartWrapper.MidLink !=null && _objScreenPartWrapper.MidLink.length()>0)
			{
				layout.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						try {

							if(event.getAction() == MotionEvent.ACTION_DOWN)
							{
								try {
									((ImageView)v.getTag()).setAlpha(150);
								} catch (Exception e) {
									// TODO: handle exception
								}
								return false;
							}
							else
								if(event.getAction() == MotionEvent.ACTION_UP)
								{

									try {
										((ImageView)v.getTag()).setAlpha(255);
									} catch (Exception e) {
										// TODO: handle exception
									}


								}
								else
									if(event.getAction() == MotionEvent.ACTION_CANCEL)
									{
										try {
											((ImageView)v.getTag()).setAlpha(255);
										} catch (Exception e) {
											// TODO: handle exception
										}
									}
						} catch (Exception e) {
							// TODO: handle exception
						}

						return false;
					}
				});



				layout.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						try {

							String str = UtilAdvertisementBar.this._objScreenPartWrapper.MidLink.toString().trim();

							//								if(MyUIApplication.isInternetAvailable(context))
							//								{
							Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
							myWebLink.setData(Uri.parse(str));
							context.startActivity(myWebLink);
							//									v.setEnabled(false);
							//								}
							//								else if(str.trim().length()>0)
							//								{
							//									new AlertDialog.Builder(context)
							//									.setTitle("Internet Not Available")
							//									.setMessage("")
							//									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							//										public void onClick(DialogInterface dialog, int which) { 
							//											// continue with delete
							//											dialog.dismiss();
							//
							//										}
							//									}).show();
							//								}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				});
			}
			else if(_objScreenPartWrapper.BottomLink!=null && _objScreenPartWrapper.BottomLink.length()>0)
			{
				((Home)context).LLBottomCopy.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						switch(event.getAction()) 
						{

						case MotionEvent.ACTION_DOWN:

							try {
								((ImageView)v.getTag()).setAlpha(150);
							} catch (Exception e) {
								// TODO: handle exception
							}
							return true;

						case MotionEvent.ACTION_UP:

							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}

							try {

								String str = UtilAdvertisementBar.this._objScreenPartWrapper.BottomLink.toString().trim();

								if(MyUIApplication.isInternetAvailable(context))
								{
									Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
									myWebLink.setData(Uri.parse(str));
									context.startActivity(myWebLink);
								}
								//								else if(str.trim().length()>0)
								//								{
								//									new AlertDialog.Builder(context)
								//									.setTitle("Internet Not Available")
								//									.setMessage("")
								//									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								//										public void onClick(DialogInterface dialog, int which) { 
								//											// continue with delete
								//											dialog.dismiss();
								//
								//										}
								//									}).show();
								//								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;

						case MotionEvent.ACTION_CANCEL:
							try {
								((ImageView)v.getTag()).setAlpha(255);
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
		else if(!MyUIApplication.Copy)
		{


			if(Section.equals("Top"))
			{
				double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
				double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
				double widthLLTopPer=widthLLTop/100;
				double heightLLTopPer=heightLLTop/100;

				ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLTop.getLayoutParams();
				params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				((Home)context).LLTop.setLayoutParams(params_LLMiddle);

				if(_objScreenPartWrapper.TopbgImage.length()>0)
				{
					String topbarfilePath="images/"+_objScreenPartWrapper.TopbgImage;
					//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
					//				((Home)context).LLTopCopy.setBackgroundDrawable(d);
					ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLTop, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
				}
				else if(_objScreenPartWrapper.Topbgcolor.length()>0)
				{
					((Home)context).LLTop.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
				}


				try
				{
					ImageView adv= new ImageView(context);
					if(_objEW.ImageMode != null && _objEW.ImageMode.trim().equalsIgnoreCase("crop"))
					{
						adv.setScaleType(ScaleType.CENTER_CROP);
					}
					((Home)context).LLTop.addView(adv);
					((Home)context).LLTop.setTag(adv);


					double heightadv=Double.parseDouble(_objEW.height);
					double widthadv=Double.parseDouble(_objEW.width);


					ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
					params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					int advheight=(int)(heightadv*heightLLTopPer);
					int h=(int)(advheight*((Home)context).deviceHeight);
					params_adv.height=(int)(h/100);
					params_adv.width=(int)(h*3.333f*.01f);
					adv.setLayoutParams(params_adv);

					if(_objEW.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							Bitmap bmp =ImageUtil.setBgFromSDCardNotCache(adv, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
							}
						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
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

				ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
				params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

				if(_objScreenPartWrapper.MidbgImage.length()>0)
				{
					String topbarfilePath="images/"+_objScreenPartWrapper.MidbgImage;
					//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
					//				((Home)context).LLTopCopy.setBackgroundDrawable(d);
					ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLMiddle, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
				}
				else if(_objScreenPartWrapper.Midbgcolor.length()>0)
				{
					((Home)context).LLMiddle.setBackgroundColor(MyUIApplication.GetColor(_objScreenPartWrapper.Midbgcolor));
				}

				try
				{
					ImageView adv= new ImageView(context);
					if(_objEW.ImageMode != null && _objEW.ImageMode.trim().equalsIgnoreCase("crop"))
					{
						adv.setScaleType(ScaleType.CENTER_CROP);
					}
					((Home)context).LLMiddle.addView(layout);
					layout.addView(adv);
					layout.setTag(adv);


					double heightadv=Double.parseDouble(_objEW.height);
					double widthadv=Double.parseDouble(_objEW.width);


					ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
					params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					int advheight=(int)(heightadv*heightLLTopPer);
					int h=(int)(advheight*((Home)context).deviceHeight);
					int w=(int)(widthadv*((Home)context).deviceWidth);
					params_adv.height=(int)(h/100);
					params_adv.width=(int)(w/100);
					adv.setLayoutParams(params_adv);

					if(_objEW.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							Bitmap bmp = ImageUtil.setBgFromSDCardNotCache(adv, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));

							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
							}

						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));

							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
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
				double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
				double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
				double widthLLTopPer=widthLLTop/100;
				double heightLLTopPer=heightLLTop/100;

				ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLBottom.getLayoutParams();
				params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				((Home)context).LLBottom.setLayoutParams(params_LLMiddle);

//				if(_objScreenPartWrapper.Bottombgcolor.length()>0)
//				{
//					String topbarfilePath="images/"+_objScreenPartWrapper.BottombgImage;
//					//				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
//					//				((Home)context).LLTopCopy.setBackgroundDrawable(d);
//					ImageUtil.setBackgroundBgFromAssetsNotCache(((Home)context).LLBottom, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
//				}
//				else
				if(_objScreenPartWrapper.Bottombgcolor.length()>0)
				{
					((Home)context).LLBottom.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
				}


				try
				{
					ImageView adv= new ImageView(context);
					if(_objEW.ImageMode != null && _objEW.ImageMode.trim().equalsIgnoreCase("crop"))
					{
						adv.setScaleType(ScaleType.CENTER_CROP);
					}
					((Home)context).LLBottom.addView(adv);
					((Home)context).LLBottom.setTag(adv);


					double heightadv=Double.parseDouble(_objEW.height);
					double widthadv=Double.parseDouble(_objEW.width);


					ViewGroup.LayoutParams params_adv = adv.getLayoutParams();
					params_adv = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					int advheight=(int)(heightadv*heightLLTopPer);
					int h=(int)(advheight*((Home)context).deviceHeight);
					params_adv.height=(int)(h/100);
					params_adv.width=(int)(h*3.333f*.01f);
					adv.setLayoutParams(params_adv);

					if(_objEW.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEW.Bitmap))
						{
							String topbarfilePath=_objEW.Bitmap;
							Bitmap bmp=	ImageUtil.setBgFromSDCardNotCache(adv, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
							}

						}
						else 
						{
							String topbarfilePath="images/"+_objEW.Bitmap;
							Bitmap bmp=ImageUtil.setBackgroundBgFromAssetsNotCache(adv, context,topbarfilePath,(int)(heightLLTopPer*((Home)context).deviceHeight),(int)(widthLLTopPer*((Home)context).deviceWidth));
							if(bmp !=null)
							{
								adv.setImageBitmap(bmp);
								adv.setBackgroundDrawable(null);
							}
						}
					}

				}
				catch (Exception e) 
				{
					System.out.println("Exception in Setting home Page Top Bar"+e);
				}
			}


			if(_objEW.OnClick.length()>0)
			{

				layout.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						switch(event.getAction()) 
						{

						case MotionEvent.ACTION_DOWN:

							try {
								((ImageView)v.getTag()).setAlpha(150);
							} catch (Exception e) {
								// TODO: handle exception
							}
							return true;

						case MotionEvent.ACTION_UP:

							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}

							try {


								//								if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
								//								{
								//									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
								//									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								//								}
								//								if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
								//								{
								//									((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
								//									((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
								//								}

								((Home)context).inLayoutAnim();

								String screenNumber=_objEW.OnClick.substring(12);

								((Home)context).OpenHtmlPage(screenNumber,UtilAdvertisementBar.this._objScreenPartWrapper.MidLink);
								MyUIApplication.StateMachine.add(screenNumber);
								v.setEnabled(false);
								int i=MyUIApplication.StateMachine.size();
								System.out.println("State Machine Size >>>"+i);

							} catch (Exception e) {
								// TODO: handle exception
							}

							break;

						case MotionEvent.ACTION_CANCEL:
							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;
						}

						return false;
					}
				});


			}
			else if(_objScreenPartWrapper.TopLink !=null && _objScreenPartWrapper.TopLink.length()>0)
			{

				((Home)context).LLTop.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						switch(event.getAction()) 
						{

						case MotionEvent.ACTION_DOWN:

							try {
								((ImageView)v.getTag()).setAlpha(150);
							} catch (Exception e) {
								// TODO: handle exception
							}
							return true;

						case MotionEvent.ACTION_UP:

							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}

							try {

								String str = UtilAdvertisementBar.this._objScreenPartWrapper.TopLink.toString().trim();

								if(MyUIApplication.isInternetAvailable(context))
								{
									Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
									myWebLink.setData(Uri.parse(str));
									context.startActivity(myWebLink);
								}
								//								else if(str.trim().length()>0)
								//								{
								//									new AlertDialog.Builder(context)
								//									.setTitle("Internet Not Available")
								//									.setMessage("")
								//									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								//										public void onClick(DialogInterface dialog, int which) { 
								//											// continue with delete
								//											dialog.dismiss();
								//
								//										}
								//									}).show();
								//								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;

						case MotionEvent.ACTION_CANCEL:
							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;
						}

						return false;
					}
				});

			}
			else if(_objScreenPartWrapper.MidLink != null && _objScreenPartWrapper.MidLink.length()>0)
			{
				layout.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						try {

							if(event.getAction() == MotionEvent.ACTION_DOWN)
							{
								try {
									((ImageView)v.getTag()).setAlpha(150);
								} catch (Exception e) {
									// TODO: handle exception
								}
								return false;
							}
							else
								if(event.getAction() == MotionEvent.ACTION_UP)
								{

									try {
										((ImageView)v.getTag()).setAlpha(255);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
								else
									if(event.getAction() == MotionEvent.ACTION_CANCEL)
									{
										try {
											((ImageView)v.getTag()).setAlpha(255);
										} catch (Exception e) {
											// TODO: handle exception
										}
									}
						} catch (Exception e) {
							// TODO: handle exception
						}

						return false;
					}
				});

				layout.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						try {

							String str = UtilAdvertisementBar.this._objScreenPartWrapper.MidLink.toString().trim();

							//								if(MyUIApplication.isInternetAvailable(context))
							//								{
							Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
							myWebLink.setData(Uri.parse(str));
							context.startActivity(myWebLink);
							//									v.setEnabled(false);
							//								}
							//								else if(str.trim().length()>0)
							//								{
							//									new AlertDialog.Builder(context)
							//									.setTitle("Internet Not Available")
							//									.setMessage("")
							//									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							//										public void onClick(DialogInterface dialog, int which) { 
							//											// continue with delete
							//											dialog.dismiss();
							//
							//										}
							//									}).show();
							//								}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				});
			}
			else if(_objScreenPartWrapper.BottomLink != null && _objScreenPartWrapper.BottomLink.length()>0)
			{
				((Home)context).LLBottom.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						switch(event.getAction()) 
						{

						case MotionEvent.ACTION_DOWN:

							try {
								((ImageView)v.getTag()).setAlpha(150);
							} catch (Exception e) {
								// TODO: handle exception
							}
							return true;

						case MotionEvent.ACTION_UP:

							try {
								((ImageView)v.getTag()).setAlpha(255);
							} catch (Exception e) {
								// TODO: handle exception
							}

							try {

								String str = UtilAdvertisementBar.this._objScreenPartWrapper.BottomLink.toString().trim();

								if(MyUIApplication.isInternetAvailable(context))
								{
									Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
									myWebLink.setData(Uri.parse(str));
									context.startActivity(myWebLink);
								}
								//								else if(str.trim().length()>0)
								//								{
								//									new AlertDialog.Builder(context)
								//									.setTitle("Internet Not Available")
								//									.setMessage("")
								//									.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								//										public void onClick(DialogInterface dialog, int which) { 
								//											// continue with delete
								//											dialog.dismiss();
								//
								//										}
								//									}).show();
								//								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							break;

						case MotionEvent.ACTION_CANCEL:
							try {
								((ImageView)v.getTag()).setAlpha(255);
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
				layout.setOnTouchListener(new OnTouchListener() {
					
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						return false;
					}
				});
			}




		}
		
		

		
	}
}
