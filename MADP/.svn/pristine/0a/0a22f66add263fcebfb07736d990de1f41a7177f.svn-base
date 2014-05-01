package mobi.neuerung.Util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ShowUpdatesWrapper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;



public class UtilShowUpdateDetail {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static ScrollView FrameLay;
	public TextView _objPopHeading,_objPopDec,_objPopTime,_objPopDate,newsLink;
	public ImageView newsImage;
	ElementWrapper _objElement;
	ShowUpdatesWrapper _objWrapper=null;
	// **** Set Show Update view for Type 10 *****
	public void SetShowUpdateDetail(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;
		_objElement = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);
	

		if(MyUIApplication.ShowUpdateWrapperForDetail != null)
		{
			_objWrapper = MyUIApplication.ShowUpdateWrapperForDetail;
		}


		if(MyUIApplication.Copy)
		{

			FrameLay = (ScrollView) ((Activity) context).getLayoutInflater()
			.inflate(R.layout.showupdate_popup, null, false);

			try
			{
				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(FrameLay);

					ViewGroup.LayoutParams params_FrameLay = FrameLay.getLayoutParams();
					params_FrameLay.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_FrameLay.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					FrameLay.setLayoutParams(params_FrameLay);


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

					((Home)context).LLMiddleCopy.addView(FrameLay);



					ViewGroup.LayoutParams params_FrameLay = FrameLay.getLayoutParams();
					params_FrameLay.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_FrameLay.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					FrameLay.setLayoutParams(params_FrameLay);

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


					((Home)context).LLBottomCopy.addView(FrameLay);

					ViewGroup.LayoutParams params_FrameLay = FrameLay.getLayoutParams();
					params_FrameLay.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_FrameLay.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					FrameLay.setLayoutParams(params_FrameLay);


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


			try
			{

				_objPopHeading = (TextView) FrameLay.findViewById(R.id.heading);
				_objPopDec = (TextView)FrameLay.findViewById(R.id.content);
				_objPopTime = (TextView)FrameLay.findViewById(R.id.time);
				_objPopDate = (TextView)FrameLay.findViewById(R.id.date);
				newsImage = (ImageView)FrameLay.findViewById(R.id.newsImage);
				newsLink = (TextView)FrameLay.findViewById(R.id.newsLink);

				try
				{


					String datetime[]=_objWrapper.ShowDate.split(" ");

					try {
						DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
						DateFormat targetFormat = new SimpleDateFormat("dd-MMM-yyyy");
						Date date = originalFormat.parse(datetime[0]);
						String formattedDate = targetFormat.format(date);
						_objPopDate.setText(formattedDate);
					} catch (Exception e) {
						// TODO: handle exception
						_objPopDate.setText(datetime[0]);
					}


					_objPopTime.setText(datetime[1]);
				}
				catch (Exception e)
				{
					System.out.println(e);
				}

				try {
					_objPopDec.setText(_objWrapper.description+"\n");

				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					_objPopHeading.setText(_objWrapper.title.trim());
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					newsLink.setText("Read more..");
					final String link =_objWrapper.Link;
					try {
						if(link.trim().length()>0){
							newsLink.setOnClickListener(new OnClickListener() {

								public void onClick(View v) {
									// TODO Auto-generated method stub
									try {

										if(link.trim().length()>0)
										{
											if(link.contains("http"))
											{
												Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(link.trim()));
												((Activity)context).startActivity(myIntent);
											}
											else
											{
												Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+link.trim()));
												((Activity)context).startActivity(myIntent);
											}
										}
									} catch (Exception e) {
										// TODO: handle exception
									}

								}
							});
						}else {
							newsLink.setVisibility(8);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}


				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}


			/**
			 * Image View Concept
			 */
			int deviceHeight =((Home)context).deviceHeight;
			int deviceWidth =((Home)context).deviceWidth;

			try {
				Float leftper = Float.parseFloat(_objElement.leftper);
				Float rightPer = Float.parseFloat(_objElement.rightper);

				float leftperf = leftper/100.0f;
				float rightPerf = rightPer/100.0f;

				//				FrameLay.setBackgroundColor(Color.RED);

				//				FrameLayout.LayoutParams params_framell =(FrameLayout.LayoutParams) FrameLay.getLayoutParams();
				//				params_framell.leftMargin=(int)(leftperf*deviceWidth);
				//				params_framell.rightMargin=(int)(rightPerf*deviceWidth);
			} catch (Exception e) {
				// TODO: handle exception
				//				FrameLayout.LayoutParams params_framell =(FrameLayout.LayoutParams) FrameLay.getLayoutParams();
				//				params_framell.leftMargin=(int)(.02f*deviceWidth);
				//				params_framell.rightMargin=(int)(.02f*deviceWidth);
			}



			try {

				//				Float leftper = Float.parseFloat(_objElement.leftper);
				//				Float rightPer = Float.parseFloat(_objElement.rightper);
				//
				//				float leftperf = leftper/100.0f;
				//				float rightPerf = rightPer/100.0f;
				//
				//				float totalMargin = leftperf+rightPerf;



				newsImage.getLayoutParams().height =(int)(.25*((Home)context).deviceHeight);
				newsImage.getLayoutParams().width =(int)(.25*((Home)context).deviceHeight);

				//				newsImage.getLayoutParams().width =(int)(deviceWidth-totalMargin*deviceWidth);


				Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(newsImage, context,MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/showUpdate/"+MyUIApplication.showUpdateCategoryCode+"/"+_objWrapper.ImageUrl,(int)(.25*((Home)context).deviceHeight),(int)(.25*((Home)context).deviceHeight));

				if(bmp != null)
				{
					newsImage.setVisibility(View.VISIBLE);
					newsImage.setImageBitmap(bmp);
				}
				else if(_objWrapper.ImageUrl.trim().length()==0)
				{
					newsImage.setVisibility(View.GONE);
				}
			} catch (Exception e) {
				// TODO: handle exception
				try {

					newsImage.getLayoutParams().height =(int)(.25*((Home)context).deviceHeight);
					newsImage.getLayoutParams().width =(int)(.25*((Home)context).deviceHeight);

					//					newsImage.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);


					Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(newsImage, context,MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/showUpdate/"+MyUIApplication.showUpdateCategoryCode+"/"+_objWrapper.ImageUrl,(int)(.25*((Home)context).deviceHeight),(int)(deviceWidth-.04f*deviceWidth));

					if(bmp != null)
					{
						newsImage.setVisibility(View.VISIBLE);
						newsImage.setImageBitmap(bmp);
					}
					else if(_objWrapper.ImageUrl.trim().length()==0)
					{
						newsImage.setVisibility(View.GONE);
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
				newsImage.setVisibility(View.GONE);
			}


			//			try {
			//
			//				Float leftper = Float.parseFloat(_objElement.leftper);
			//				Float rightPer = Float.parseFloat(_objElement.rightper);
			//
			//				float leftperf = leftper/100.0f;
			//				float rightPerf = rightPer/100.0f;
			//
			//				float totalMargin = leftperf+rightPerf;
			//
			//
			//				_objPopHeading.getLayoutParams().width =(int)(deviceWidth-totalMargin*deviceWidth);
			//				_objPopDec.getLayoutParams().width =(int)(deviceWidth-totalMargin*deviceWidth);
			//				_objPopDate.getLayoutParams().width =(int)(deviceWidth-totalMargin*deviceWidth);
			//				_objPopTime.getLayoutParams().width =(int)(deviceWidth-totalMargin*deviceWidth);
			//				newsLink.getLayoutParams().width =(int)(deviceWidth-totalMargin*deviceWidth);
			//
			//			} catch (Exception e) {
			//				// TODO: handle exception
			//				_objPopHeading.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//				_objPopDec.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//				_objPopDate.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//				_objPopTime.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//				newsLink.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//			}

			Float leftper = Float.parseFloat(_objElement.leftper);
			Float rightPer = Float.parseFloat(_objElement.rightper);

			int leftperf = (int)((leftper/100.0f)*deviceWidth);
			int rightPerf = (int)((rightPer/100.0f)*deviceWidth);

			float totalMargin = leftperf+rightPerf;

			_objPopHeading.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			_objPopDec.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			_objPopDate.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			_objPopTime.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			newsLink.getLayoutParams().width =LayoutParams.MATCH_PARENT;

			try {
				_objPopHeading.setPadding(leftperf,(int)(.04f*deviceHeight), rightPerf,(int)(.04f*deviceHeight));
				_objPopTime.setPadding(leftperf,(int)(.01f*deviceHeight), rightPerf,(int)(.01f*deviceHeight));
				_objPopDate.setPadding(leftperf,(int)(.01f*deviceHeight), rightPerf,(int)(.01f*deviceHeight));
				_objPopDec.setPadding(leftperf,(int)(.04f*deviceHeight), rightPerf,(int)(.01f*deviceHeight));
				newsLink.setPadding(leftperf,(int)(.02f*deviceHeight), rightPerf,(int)(.04f*deviceHeight));
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				if(_objElement.TitleGravity.equalsIgnoreCase("center"))
					_objPopHeading.setGravity(Gravity.CENTER);
				if(_objElement.TitleGravity.equalsIgnoreCase("right"))
					_objPopHeading.setGravity(Gravity.RIGHT);
				if(_objElement.TitleGravity.equalsIgnoreCase("left"))
					_objPopHeading.setGravity(Gravity.LEFT);
			} catch (Exception e) {
				// TODO: handle exception
				_objPopHeading.setGravity(Gravity.LEFT);
			}

			try {
				if(_objElement.SubTitleGravity.equalsIgnoreCase("center"))
					_objPopDec.setGravity(Gravity.CENTER);
				if(_objElement.SubTitleGravity.equalsIgnoreCase("right"))
					_objPopDec.setGravity(Gravity.RIGHT);
				if(_objElement.SubTitleGravity.equalsIgnoreCase("left"))
					_objPopDec.setGravity(Gravity.LEFT);
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDec.setGravity(Gravity.CENTER);
			}



			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.fontStyle);
				_objPopHeading.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.SubTitlefont);
				_objPopDec.setTypeface(tf);

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.Linkfont);
				newsLink.setTypeface(tf);
				newsLink.setTextColor(Color.parseColor(_objElement.LinkfontColor));
				int i = Integer.parseInt(_objElement.LinkfontSize);
				float testsizepercent = i/960f;
				newsLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(newsLink.getTypeface(),(testsizepercent*deviceHeight)));	

			} catch (Exception e) {
				newsLink.setTextColor(Color.BLACK);
				newsLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(newsLink.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			}

			try {
				_objPopHeading.setTextColor(Color.parseColor(_objElement.fontColor));
			} catch (Exception e) {
				// TODO: handle exception
				_objPopHeading.setTextColor(Color.BLACK);
			}

			try {
				_objPopDec.setTextColor(Color.parseColor(_objElement.subtitlefontColor));
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDec.setTextColor(Color.BLACK);
			}

			try {
				int i = Integer.parseInt(_objElement.fontSize);
				float testsizepercent = i/960f;
				_objPopHeading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopHeading.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				_objPopHeading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopHeading.getTypeface(),(0.1f)*(.4f*deviceHeight)));
			}

			try {
				int i = Integer.parseInt(_objElement.subtitlefontSize);
				float testsizepercent = i/960f;
				_objPopDec.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopDec.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDec.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopDec.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			}

			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.DatefontStyle);
				_objPopDate.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				_objPopDate.setTextColor(Color.parseColor(_objElement.DatefontColor));
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDate.setTextColor(Color.BLACK);
			}

			try {
				int ii = Integer.parseInt(_objElement.DatefontSize);
				float testsizepercent = ii/960f;
				_objPopDate.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopDate.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDate.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopDate.getTypeface(),(0.1f)*(.25f*deviceHeight)));
			}


			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.TimefontStyle);
				_objPopTime.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				_objPopTime.setTextColor(Color.parseColor(_objElement.TimefontColor));
			} catch (Exception e) {
				// TODO: handle exception
				_objPopTime.setTextColor(Color.BLACK);
			}

			try {
				int ii = Integer.parseInt(_objElement.TimefontSize);
				float testsizepercent = ii/960f;
				_objPopTime.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopTime.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				_objPopTime.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopTime.getTypeface(),(0.1f)*(.25f*deviceHeight)));
			}

			//			try {
			//				_objPopHeading.setPadding(0,(int)(.04f*deviceHeight), 0,(int)(.04f*deviceHeight));
			//				_objPopTime.setPadding(0,(int)(.01f*deviceHeight), 0,(int)(.01f*deviceHeight));
			//				_objPopDate.setPadding(0,(int)(.01f*deviceHeight), 0,(int)(.01f*deviceHeight));
			//				_objPopDec.setPadding(0,(int)(.04f*deviceHeight), 0,(int)(.01f*deviceHeight));
			//				newsLink.setPadding(0,(int)(.02f*deviceHeight), 0,(int)(.04f*deviceHeight));
			//			} catch (Exception e) {
			//				// TODO: handle exception
			//			}


		}
		else if(!MyUIApplication.Copy)
		{
			FrameLay = (ScrollView) ((Activity) context).getLayoutInflater()
			.inflate(R.layout.showupdate_popup, null, false);

			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(FrameLay);

					ViewGroup.LayoutParams params_FrameLay = FrameLay.getLayoutParams();
					params_FrameLay.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_FrameLay.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					FrameLay.setLayoutParams(params_FrameLay);


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

					((Home)context).LLMiddle.addView(FrameLay);

					ViewGroup.LayoutParams params_FrameLay = FrameLay.getLayoutParams();
					params_FrameLay.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_FrameLay.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					FrameLay.setLayoutParams(params_FrameLay);

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


					((Home)context).LLBottom.addView(FrameLay);

					ViewGroup.LayoutParams params_FrameLay = FrameLay.getLayoutParams();
					params_FrameLay.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_FrameLay.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					FrameLay.setLayoutParams(params_FrameLay);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

				}
				try
				{

					_objPopHeading = (TextView) FrameLay.findViewById(R.id.heading);
					_objPopDec = (TextView) FrameLay.findViewById(R.id.content);
					_objPopTime = (TextView)FrameLay.findViewById(R.id.time);
					_objPopDate = (TextView)FrameLay.findViewById(R.id.date);

					newsImage = (ImageView)FrameLay.findViewById(R.id.newsImage);
					newsLink = (TextView)FrameLay.findViewById(R.id.newsLink);


					try
					{

						_objPopHeading.setText(_objWrapper.title.trim());
					}
					catch (Exception e)
					{
						System.out.println(e);
					}

					try
					{


						String datetime[]=_objWrapper.ShowDate.split(" ");

						try {
							DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
							DateFormat targetFormat = new SimpleDateFormat("dd-MMM-yyyy");
							Date date = originalFormat.parse(datetime[0]);
							String formattedDate = targetFormat.format(date);
							_objPopDate.setText(formattedDate);
						} catch (Exception e) {
							// TODO: handle exception
							_objPopDate.setText(datetime[0]);
						}


						_objPopTime.setText(datetime[1]);
					}
					catch (Exception e)
					{
						System.out.println(e);
					}

					try {
						_objPopDec.setText(_objWrapper.description.trim());

					} catch (Exception e) {
						// TODO: handle exception
					}





					try {
						newsLink.setText("Read more..");

						final String link =_objWrapper.Link;
						try {
							if(link.trim().length()>0){
								newsLink.setOnClickListener(new OnClickListener() {

									public void onClick(View v) {
										// TODO Auto-generated method stub
										try {

											if(link.trim().length()>0)
											{
												if(link.contains("http"))
												{
													Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(link.trim()));
													((Activity)context).startActivity(myIntent);
												}
												else
												{
													Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+link.trim()));
													((Activity)context).startActivity(myIntent);
												}
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
							}else {
								newsLink.setVisibility(8);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}


				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}




			int deviceHeight =((Home)context).deviceHeight;
			int deviceWidth =((Home)context).deviceWidth;

			try {
				Float leftper = Float.parseFloat(_objElement.leftper);
				Float rightPer = Float.parseFloat(_objElement.rightper);

				float leftperf = leftper/100.0f;
				float rightPerf = rightPer/100.0f;

				//				FrameLay.setBackgroundColor(Color.RED);

				//				FrameLayout.LayoutParams params_framell =(FrameLayout.LayoutParams) FrameLay.getLayoutParams();
				//				params_framell.leftMargin=(int)(leftperf*deviceWidth);
				//				params_framell.rightMargin=(int)(rightPerf*deviceWidth);
			} catch (Exception e) {
				// TODO: handle exception
				//				FrameLayout.LayoutParams params_framell =(FrameLayout.LayoutParams) FrameLay.getLayoutParams();
				//				params_framell.leftMargin=(int)(.02f*deviceWidth);
				//				params_framell.rightMargin=(int)(.02f*deviceWidth);
			}



			try {

				//				Float leftper = Float.parseFloat(_objElement.leftper);
				//				Float rightPer = Float.parseFloat(_objElement.rightper);
				//
				//				float leftperf = leftper/100.0f;
				//				float rightPerf = rightPer/100.0f;
				//
				//				float totalMargin = leftperf+rightPerf;

				newsImage.getLayoutParams().height =(int)(.25*((Home)context).deviceHeight);
				newsImage.getLayoutParams().width =(int)(.25*((Home)context).deviceHeight);


				//				newsImage.getLayoutParams().width =(int)(deviceWidth-totalMargin*deviceWidth);

				//				Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(newsImage, context,MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/showUpdate/"+MyUIApplication.showUpdateCategoryCode+"/"+_objWrapper.ImageUrl,(int)(.25*((Home)context).deviceHeight),(int)(deviceWidth-totalMargin*deviceWidth));
				Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(newsImage, context,MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/showUpdate/"+MyUIApplication.showUpdateCategoryCode+"/"+_objWrapper.ImageUrl,(int)(.25*((Home)context).deviceHeight),(int)(.25*((Home)context).deviceHeight));

				if(bmp != null)
				{
					newsImage.setVisibility(View.VISIBLE);
					newsImage.setImageBitmap(bmp);
				}
				else if(_objWrapper.ImageUrl.trim().length()==0)
				{
					newsImage.setVisibility(View.GONE);
				}
			} catch (Exception e) {
				// TODO: handle exception
				try {

					newsImage.getLayoutParams().height =(int)(.25*((Home)context).deviceHeight);
					newsImage.getLayoutParams().width =(int)(.25*((Home)context).deviceHeight);

					//					newsImage.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);


					Bitmap bmp = ImageUtil.setBgFromSDCardForOtherDirectoy(newsImage, context,MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/showUpdate/"+MyUIApplication.showUpdateCategoryCode+"/"+_objWrapper.ImageUrl,(int)(.25*((Home)context).deviceHeight),(int)(deviceWidth-.04f*deviceWidth));

					if(bmp != null)
					{
						newsImage.setVisibility(View.VISIBLE);
						newsImage.setImageBitmap(bmp);
					}
					else if(_objWrapper.ImageUrl.trim().length()==0)
					{
						newsImage.setVisibility(View.GONE);
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
				newsImage.setVisibility(View.GONE);
			}


			//			try {

			Float leftper = Float.parseFloat(_objElement.leftper);
			Float rightPer = Float.parseFloat(_objElement.rightper);

			int leftperf = (int)((leftper/100.0f)*deviceWidth);
			int rightPerf = (int)((rightPer/100.0f)*deviceWidth);

			float totalMargin = leftperf+rightPerf;

			_objPopHeading.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			_objPopDec.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			_objPopDate.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			_objPopTime.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			newsLink.getLayoutParams().width =LayoutParams.MATCH_PARENT;
			//
			//			} catch (Exception e) {
			//				// TODO: handle exception
			//				_objPopHeading.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//				_objPopDec.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//				_objPopDate.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//				_objPopTime.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//				newsLink.getLayoutParams().width =(int)(deviceWidth-.04f*deviceWidth);
			//			}

			try {
				if(_objElement.TitleGravity.equalsIgnoreCase("center"))
					_objPopHeading.setGravity(Gravity.CENTER);
				if(_objElement.TitleGravity.equalsIgnoreCase("right"))
					_objPopHeading.setGravity(Gravity.RIGHT);
				if(_objElement.TitleGravity.equalsIgnoreCase("left"))
					_objPopHeading.setGravity(Gravity.LEFT);
			} catch (Exception e) {
				_objPopHeading.setGravity(Gravity.LEFT);
			}


			try {
				if(_objElement.SubTitleGravity.equalsIgnoreCase("center"))
					_objPopDec.setGravity(Gravity.CENTER);
				if(_objElement.SubTitleGravity.equalsIgnoreCase("right"))
					_objPopDec.setGravity(Gravity.RIGHT);
				if(_objElement.SubTitleGravity.equalsIgnoreCase("left"))
					_objPopDec.setGravity(Gravity.LEFT);
			} catch (Exception e) {
				_objPopDec.setGravity(Gravity.CENTER);
			}


			try {
				_objPopHeading.setPadding(leftperf,(int)(.04f*deviceHeight), rightPerf,(int)(.04f*deviceHeight));
				_objPopTime.setPadding(leftperf,(int)(.01f*deviceHeight), rightPerf,(int)(.01f*deviceHeight));
				_objPopDate.setPadding(leftperf,(int)(.01f*deviceHeight), rightPerf,(int)(.01f*deviceHeight));
				_objPopDec.setPadding(leftperf,(int)(.04f*deviceHeight), rightPerf,(int)(.01f*deviceHeight));
				newsLink.setPadding(leftperf,(int)(.02f*deviceHeight), rightPerf,(int)(.04f*deviceHeight));
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.fontStyle);
				_objPopHeading.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.subtitlefontStyle);
				_objPopDec.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				_objPopHeading.setTextColor(Color.parseColor(_objElement.fontColor));
			} catch (Exception e) {
				// TODO: handle exception
				_objPopHeading.setTextColor(Color.BLACK);
			}



			try {
				_objPopDec.setTextColor(Color.parseColor(_objElement.subtitlefontColor));
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDec.setTextColor(Color.BLACK);
			}

			try {
				int i = Integer.parseInt(_objElement.fontSize);
				float testsizepercent = i/960f;
				_objPopHeading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopHeading.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				_objPopHeading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopHeading.getTypeface(),(0.1f)*(.4f*deviceHeight)));
			}

			try {
				int i = Integer.parseInt(_objElement.subtitlefontSize);
				float testsizepercent = i/960f;
				_objPopDec.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopDec.getTypeface(),(testsizepercent*deviceHeight)));	
				newsLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(newsLink.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDec.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopDec.getTypeface(),(0.1f)*(.3f*deviceHeight)));
				newsLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(newsLink.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			}


			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.DatefontStyle);
				_objPopDate.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				_objPopDate.setTextColor(Color.parseColor(_objElement.DatefontColor));
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDate.setTextColor(Color.BLACK);
			}

			try {
				int ii = Integer.parseInt(_objElement.DatefontSize);
				float testsizepercent = ii/960f;
				_objPopDate.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopDate.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				_objPopDate.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopDate.getTypeface(),(0.1f)*(.25f*deviceHeight)));
			}


			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.TimefontStyle);
				_objPopTime.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				_objPopTime.setTextColor(Color.parseColor(_objElement.TimefontColor));
			} catch (Exception e) {
				// TODO: handle exception
				_objPopTime.setTextColor(Color.BLACK);
			}

			try {
				int ii = Integer.parseInt(_objElement.TimefontSize);
				float testsizepercent = ii/960f;
				_objPopTime.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopTime.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				_objPopTime.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(_objPopTime.getTypeface(),(0.1f)*(.25f*deviceHeight)));
			}


			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.LinkfontStyle);
				newsLink.setTypeface(tf);
			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				newsLink.setTextColor(Color.parseColor(_objElement.LinkfontColor));
			} catch (Exception e) {
				// TODO: handle exception
				newsLink.setTextColor(Color.BLUE);
			}

			try {
				int ii = Integer.parseInt(_objElement.LinkfontSize);
				float testsizepercent = ii/960f;
				newsLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(newsLink.getTypeface(),(testsizepercent*deviceHeight)));	
			} catch (Exception e) {
				// TODO: handle exception
				newsLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(newsLink.getTypeface(),(0.1f)*(.25f*deviceHeight)));
			}

			try {
				Typeface tf = MyUIApplication.fontmap.get(_objElement.Linkfont);
				newsLink.setTypeface(tf);
				newsLink.setTextColor(Color.parseColor(_objElement.LinkfontColor));
				int i = Integer.parseInt(_objElement.LinkfontSize);
				float testsizepercent = i/960f;
				newsLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(newsLink.getTypeface(),(testsizepercent*deviceHeight)));	

			} catch (Exception e) {
				newsLink.setTextColor(Color.BLACK);
				newsLink.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(newsLink.getTypeface(),(0.1f)*(.3f*deviceHeight)));
			}
		}

		newsImage.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try
				{
					
					System.out.println(_objElement.OnClick.trim());
					
					((Home)context).inLayoutAnim();
					((Home)context).OpenHtmlPage(_objElement.OnClick.trim().substring(12),MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/showUpdate/"+MyUIApplication.showUpdateCategoryCode+"/"+_objWrapper.ImageUrl);
					MyUIApplication.StateMachine.add(_objElement.OnClick.trim().substring(12));

				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
		});
	}
}
