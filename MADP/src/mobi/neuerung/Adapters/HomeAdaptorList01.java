package mobi.neuerung.Adapters;

import java.util.ArrayList;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

import com.facebook.Session;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;

import mobi.neuerung.Adapters.HomeAdaptorList.twitterAsyn;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Util.UtilMail;
import mobi.neuerung.Wrapper.ElementWrapper;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



//**** Home Grid Adapter   *****
public class HomeAdaptorList01 extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<ElementWrapper> _objEWList;
	// Constructor
	public HomeAdaptorList01(Context c ,ArrayList<ElementWrapper> _objEWList)
	{
		mContext = c;
		this._objEWList = _objEWList;
		mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() 
	{
		return _objEWList.size();
	}
	public Object getItem(int position)
	{
		return _objEWList.get(position);
	}
	public long getItemId(int position)
	{
		return 0;
	}
	WindowManager mWinMgr;
	int deviceHeight=0;
	int deviceWidth=0;

	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolderList holder;
		WindowManager mWinMgr = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();
		int buttonwidth,ArrowWidth;
		if (convertView == null)
		{
			holder = new ViewHolderList();

			convertView = mInflater.inflate(R.layout.listview01xml, null);
			try
			{
				Double RowHeight = Double.parseDouble(_objEWList.get(position).height)/100;
				convertView.setMinimumHeight((int)(RowHeight*deviceHeight));


				ElementWrapper _objWrapper = _objEWList.get(position);


				holder.MainLL = (RelativeLayout)convertView.findViewById(R.id.MainLL);
				holder.ListButton=(LinearLayout)convertView.findViewById(R.id.ListButton);
				if(_objWrapper.bgcolor.length()>0)
				{
					try {
						holder.ListButton.setBackgroundColor(Color.parseColor(_objWrapper.bgcolor));
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				else
				{
					try {
						holder.ListButton.setBackgroundColor(Color.TRANSPARENT);
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				LinearLayout.LayoutParams params_MainLL = (LinearLayout.LayoutParams)holder.MainLL.getLayoutParams();
				params_MainLL.height = (int)((Double.parseDouble(_objWrapper.height)/100)*deviceHeight);
				holder.MainLL.setLayoutParams(params_MainLL);

				if(_objWrapper.leftper.length()>0)
				{
					holder.Frm1 = (FrameLayout)convertView.findViewById(R.id.Frm1);
					RelativeLayout.LayoutParams params_Frm1 = (RelativeLayout.LayoutParams)holder.Frm1.getLayoutParams();
					params_Frm1.width = (int)((Double.parseDouble(_objWrapper.leftper)/100)*deviceWidth);
					holder.Frm1.setLayoutParams(params_Frm1);
				}
				if(_objWrapper.middleper.length()>0)
				{
					holder.Frm2 = (LinearLayout)convertView.findViewById(R.id.Frm2);
					RelativeLayout.LayoutParams params_Frm2 = (RelativeLayout.LayoutParams)holder.Frm2.getLayoutParams();
					params_Frm2.width = (int)((Double.parseDouble(_objWrapper.middleper )/100)*deviceWidth);
					holder.Frm2.setLayoutParams(params_Frm2);
				}
				if(_objWrapper.rightper.length()>0)
				{
					holder.Frm3 = (FrameLayout)convertView.findViewById(R.id.Frm3);
					RelativeLayout.LayoutParams params_Frm3 = (RelativeLayout.LayoutParams)holder.Frm3.getLayoutParams();
					params_Frm3.width = (int)((Double.parseDouble(_objWrapper.rightper)/100)*deviceWidth);
					holder.Frm3.setLayoutParams(params_Frm3);
				}


				{
					Double Width2 = Double.parseDouble(_objEWList.get(position).leftper)/100;

					holder.ButtonList = (ImageView) convertView.findViewById(R.id.ButtonList);

					FrameLayout.LayoutParams params_ButtonList = (FrameLayout.LayoutParams)holder.ButtonList.getLayoutParams();
					params_ButtonList = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER_VERTICAL);
					buttonwidth=(int)(Width2*deviceWidth*.96f);

					try {
						Float leftscalefactor = Float.parseFloat(_objEWList.get(position).leftscalefactor);
						Float aa = buttonwidth*leftscalefactor;
						buttonwidth = Math.round(aa) ;
					} catch (Exception e) {
						// TODO: handle exception
					}

					params_ButtonList.width=buttonwidth;
					try {
						params_ButtonList.height= (int)(((Double.parseDouble(_objWrapper.height)/100)*deviceHeight)-(.01f*deviceHeight));
					} catch (Exception e) {
						// TODO: handle exception
						params_ButtonList.height=(int)(.795f*buttonwidth);
					}
					params_ButtonList.leftMargin = (int)(.01f*deviceWidth);
					params_ButtonList.rightMargin = (int)(.01f*deviceWidth);
					//				params_ButtonList.topMargin = (int)(.004f*deviceHeight);
					//				params_ButtonList.bottomMargin = (int)(.004f*deviceHeight);
					holder.ButtonList.setLayoutParams(params_ButtonList);
				}

				if(_objWrapper.rightper.length()>0)
				{
					Double RightWidth = Double.parseDouble(_objEWList.get(position).rightper)/100;

					holder.Arrow = (ImageView) convertView.findViewById(R.id.Arrow);
					FrameLayout.LayoutParams params_Arrow = (FrameLayout.LayoutParams)holder.Arrow.getLayoutParams();
					params_Arrow = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER_VERTICAL);
					ArrowWidth = (int)(RightWidth*deviceWidth*.96f);

					try {
						Float rightscalefactor = Float.parseFloat(_objEWList.get(position).rightscalefactor);
						Float aa = ArrowWidth*rightscalefactor;
						ArrowWidth = Math.round(aa) ;
					} catch (Exception e) {
						// TODO: handle exception
					}

					params_Arrow.width = ArrowWidth;;
					try {
						params_Arrow.height= (int)(((Double.parseDouble(_objWrapper.height)/100)*deviceHeight)-(.01f*deviceHeight));
					} catch (Exception e) {
						// TODO: handle exception
						params_Arrow.height=(int)(.795f*buttonwidth);
					}
					params_Arrow.rightMargin = (int)(.04f*((Home)mContext).deviceWidth);
					params_Arrow.topMargin = (int)(.004f*deviceHeight);
					params_Arrow.bottomMargin = (int)(.004f*deviceHeight);
					holder.Arrow.setLayoutParams(params_Arrow);

				}


				holder.TextListBtn=(TextView)convertView.findViewById(R.id.TextListBtn);


				LinearLayout.LayoutParams marginparam_TextListBtn =(LinearLayout.LayoutParams) holder.TextListBtn.getLayoutParams();
				marginparam_TextListBtn.leftMargin = (int)(.02f*deviceWidth);
				marginparam_TextListBtn.rightMargin = (int)(.02f*deviceWidth);
				holder.TextListBtn.setLayoutParams(marginparam_TextListBtn);

				holder.subtitle=(TextView)convertView.findViewById(R.id.subtitle);



				LinearLayout.LayoutParams marginparam_subtitle =(LinearLayout.LayoutParams) holder.subtitle.getLayoutParams();
				marginparam_subtitle.leftMargin = (int)(.02f*deviceWidth);
				marginparam_subtitle.rightMargin = (int)(.02f*deviceWidth);
				holder.subtitle.setLayoutParams(marginparam_subtitle);
				//				marginparam_TextListBtn.topMargin = (int)(.005f*deviceHeight);


			}
			catch (Exception e)
			{
				System.out.println("Exception in Home List Item's Width Please Define the Width"+e);

				holder.ButtonList = (ImageView) convertView.findViewById(R.id.ButtonList);
				ViewGroup.LayoutParams params_ButtonList = holder.ButtonList.getLayoutParams();
				buttonwidth=(int)(.2f*deviceWidth);
				params_ButtonList.width=buttonwidth;
				params_ButtonList.height=(int)(.795f*buttonwidth);
				holder.ButtonList.setLayoutParams(params_ButtonList);

				FrameLayout.LayoutParams marginparam_ButtonList =(FrameLayout.LayoutParams) holder.ButtonList.getLayoutParams();
				marginparam_ButtonList.leftMargin = (int)(.025f*deviceWidth);
				marginparam_ButtonList.topMargin = (int)(.004f*deviceHeight);
				marginparam_ButtonList.bottomMargin = (int)(.004f*deviceHeight);
			}

			convertView.setTag(holder);
		}
		else 
		{
			holder = (ViewHolderList) convertView.getTag();
		}
		try
		{
			ElementWrapper _objWrapper = _objEWList.get(position);

			try {
				holder.subtitle.setMaxLines(Integer.parseInt(_objWrapper.maxline));
			} catch (Exception e) {
				// TODO: handle exception
				holder.subtitle.setMaxLines(2);
			}
			
//			try {
//				holder.subtitle.setTextColor(Color.parseColor(_objWrapper.subtitlefontColor));
//			} catch (Exception e) {
//				// TODO: handle exception
//				holder.subtitle.setMaxLines(2);
//			}
			
			

			if(_objWrapper.leftbgColor.length()>0 && _objWrapper.leftper.length()>0)
			{
				holder.Frm1.setBackgroundColor(Color.parseColor(_objWrapper.leftbgColor.trim()));
			}
			if(_objWrapper.midbgColor.length()>0 && _objWrapper.middleper.length()>0)
			{
				holder.Frm2.setBackgroundColor(Color.parseColor(_objWrapper.midbgColor.trim()));
			}
			if(_objWrapper.rightbgColor.length()>0 && _objWrapper.rightper.length()>0)
			{
				holder.Frm3.setBackgroundColor(Color.parseColor(_objWrapper.rightbgColor.trim()));
			}

			if(_objEWList.get(position).leftper.length()>0)
			{
				String Width  = _objEWList.get(position).leftper;
				Double Width1 = Double.parseDouble(Width);
				Double Width2 = Width1/100;

				buttonwidth=(int)(Width2*deviceWidth*.96f);
				//				int buttonheight=0;
				//				try {
				//					params_ButtonList.height= (int)(((Double.parseDouble(_objWrapper.height)/100)*deviceHeight)-(.01f*deviceHeight));
				//				} catch (Exception e) {
				//					// TODO: handle exception
				//					params_ButtonList.height=(int)(.795f*buttonwidth);
				//				}

				if(MyUIApplication.IsSdCardImageAvailable(_objEWList.get(position).left))
				{

					String filePath=_objEWList.get(position).left;
					Bitmap bmp=null;
					try {
						bmp = ImageUtil.setBgFromSDCardNotCache(holder.ButtonList, (Home)mContext,filePath,(int)(holder.ButtonList.getHeight()),(int)(buttonwidth));
					} catch (Exception e) {
						// TODO: handle exception
						bmp = ImageUtil.setBgFromSDCardNotCache(holder.ButtonList, (Home)mContext,filePath,(int)(buttonwidth*.795f),(int)(buttonwidth));
					}



					if(bmp != null)
					{
						holder.ButtonList.setImageBitmap(bmp);
						holder.ButtonList.setBackgroundDrawable(null);
					}

				}
				else 
				{
					String filePath="images/"+_objEWList.get(position).left;
					Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(holder.ButtonList, (Home)mContext,filePath,(int)(buttonwidth*.795f),(int)(buttonwidth));

					if(bmp != null)
					{
						holder.ButtonList.setImageBitmap(bmp);
						holder.ButtonList.setBackgroundDrawable(null);
					}
				}
			}
			if(_objEWList.get(position).rightper.length()>0)
			{

				Double RightWidth = Double.parseDouble(_objEWList.get(position).rightper)/100;
				ArrowWidth=(int)(RightWidth*deviceWidth*.96f);


				if(MyUIApplication.IsSdCardImageAvailable(_objEWList.get(position).right))
				{
					String filePath=_objEWList.get(position).right;
					//					Bitmap bmp = ImageUtil.setBgFromSDCardNotCache(holder.Arrow, (Home)mContext,filePath,(int)(ArrowWidth*.795f),(int)(ArrowWidth));

					Bitmap bmp=null;
					try {
						bmp = ImageUtil.setBgFromSDCardNotCache(holder.Arrow, (Home)mContext,filePath,(int)(holder.ButtonList.getHeight()),(int)(ArrowWidth));
					} catch (Exception e) {
						// TODO: handle exception
						bmp = ImageUtil.setBgFromSDCardNotCache(holder.Arrow, (Home)mContext,filePath,(int)(ArrowWidth*.795f),(int)(ArrowWidth));
					}
					if(bmp != null)
					{
						holder.Arrow.setImageBitmap(bmp);
						holder.Arrow.setBackgroundDrawable(null);
					}

				}
				else 
				{
					String filePath="images/"+_objEWList.get(position).right;
					//				String filePath="arrow";
					//				ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Arrow, (Home)mContext,filePath,(int)((int)(.06f*((Home)mContext).deviceWidth+(.61f*.06f*((Home)mContext).deviceWidth))),(int)(.06f*((Home)mContext).deviceWidth));
					Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Arrow, (Home)mContext,filePath,(int)(ArrowWidth*.795f),(int)(ArrowWidth));

					if(bmp != null)
					{
						holder.Arrow.setImageBitmap(bmp);
						holder.Arrow.setBackgroundDrawable(null);
					}
				}
			}
			//			holder.ListButton.setOnClickListener(new OnClickListener() {
			//
			//				public void onClick(View v)
			//				{
			//					String screenNumber=_objEWList.get(position).OnClick.substring(12);
			//					System.out.println(""+screenNumber);
			//					
			//					((Home)mContext).OpenHtmlPage(screenNumber);
			//					MyUIApplication.StateMachine.add(screenNumber);
			//					
			//					int i=MyUIApplication.StateMachine.size();
			//					System.out.println("State Machine Size >>>"+i);
			//					if(!screenNumber.equals("-1"))
			//					{
			////						((Home)mContext).StateMachine.add(screenNumber);
			////						((Home)mContext).openButtonClickScreen(_objEWList.get(position).Title , screenNumber);
			//					}
			//				}
			//				
			//			});

			holder.ListButton.setOnTouchListener(new OnTouchListener() 
			{
				public boolean onTouch(View v, MotionEvent event)
				{
					switch(event.getAction()) 
					{

					case MotionEvent.ACTION_DOWN:

						try {
							String selbg = _objEWList.get(position).selectedBgcolor;
							v.setBackgroundColor(Color.parseColor(selbg));

							//							if(_objWrap.leftbgColor.length()>0 && _objWrap.leftper.length()>0)
							//							{
							holder.Frm1.setBackgroundDrawable(null);
							//							}
							//							if(_objWrap.midbgColor.length()>0 && _objWrap.middleper.length()>0)
							//							{
							holder.Frm2.setBackgroundDrawable(null);
							//							}
							//							if(_objWrap.rightbgColor.length()>0 && _objWrap.rightper.length()>0)
							//							{
							holder.Frm3.setBackgroundDrawable(null);
							//							}


						} catch (Exception e) {
							// TODO: handle exception
						}

						//						holder.ListButton.getBackground().setAlpha(150);
						//			        	holder.GridButtonTV.getBackground().setAlpha(150);
						//						return false;
						return true;
					case MotionEvent.ACTION_UP:
						//						holder.ListButton.getBackground().setAlpha(255);
						//			        	holder.GridButtonTV.getBackground().setAlpha(255);


						ElementWrapper _objWrap = _objEWList.get(position);

						try {
							String color =  _objWrap.bgcolor;
							if(color.length()>0)
							{
								v.setBackgroundColor(Color.parseColor(color));
							}else
							{
								v.setBackgroundColor(Color.TRANSPARENT);
							}

							if(_objWrap.leftbgColor.length()>0 && _objWrap.leftper.length()>0)
							{
								holder.Frm1.setBackgroundColor(Color.parseColor(_objWrap.leftbgColor.trim()));
							}
							if(_objWrap.midbgColor.length()>0 && _objWrap.middleper.length()>0)
							{
								holder.Frm2.setBackgroundColor(Color.parseColor(_objWrap.midbgColor.trim()));
							}
							if(_objWrap.rightbgColor.length()>0 && _objWrap.rightper.length()>0)
							{
								holder.Frm3.setBackgroundColor(Color.parseColor(_objWrap.rightbgColor.trim()));
							}

						} catch (Exception e) {
							// TODO: handle exception
						}

						if(_objWrap.OnClick.length()>0)
						{
							String screenNumber=_objEWList.get(position).OnClick.substring(12);

							try {

								if(screenNumber.equals("1"))    //  "1" For Mail
								{

									String mailto=_objEWList.get(position).mailto;
									String body=_objEWList.get(position).body;
									String subject=_objEWList.get(position).subject;
									String cc=_objEWList.get(position).cc;
									String bcc=_objEWList.get(position).bcc;

									UtilMail mail = new UtilMail();
									mail.OpenMail(mContext ,mailto,cc,bcc,body,subject);
								}
							} catch (Exception e) {
								// TODO: handle exception
							}


							if(MyUIApplication.ScreenNumbers.contains(screenNumber))
							{


								((Home)mContext).inLayoutAnim();


								System.out.println(""+screenNumber);


								if(_objEWList !=null && _objEWList.get(position).Code.length()>0)
								{
									if(_objEWList.get(position).Code.equals("P103") || _objEWList.get(position).Code.equals("P104") || _objEWList.get(position).Code.equals("P102") || _objEWList.get(position).Code.equals("P108"))
									{
										//										String aa[] = _objEWList.get(position).Title.split(" ");
										//										if(aa.length>=2)
										v.setEnabled(false);
										((Home)mContext).OpenHtmlPage(screenNumber,_objEWList.get(position).Code+"##"+_objEWList.get(position).Title);
									}
									//									else if(_objEWList.get(position).Code.equals("P104"))
									//									{
									//										((Home)mContext).OpenHtmlPage(screenNumber,_objEWList.get(position).Title);
									//									}
									else
									{
										v.setEnabled(false);
										((Home)mContext).OpenHtmlPage(screenNumber,_objEWList.get(position).Code);
									}
								}
								else
								{
									v.setEnabled(false);
									((Home)mContext).OpenHtmlPage(screenNumber,"");
								}
								MyUIApplication.StateMachine.add(screenNumber);

								int i=MyUIApplication.StateMachine.size();
								System.out.println("State Machine Size >>>"+i);
								if(!screenNumber.equals("-1"))
								{
									//							((Home)mContext).StateMachine.add(screenNumber);
									//							((Home)mContext).openButtonClickScreen(_objEWList.get(position).Title , screenNumber);
								}
							}
						}

						else if(_objWrap.Link !=null && _objWrap.Link.length()>0)
						{//Condition if link is given
							try {
								if(_objWrap.Link.trim().contains("facebook:")){

									try{
										FACEBOOK_APP_ID	=	_objWrap.Link.trim().split(":")[1].split(",")[0];
									}catch (Exception e) {
										System.out.println("Not able to extract FACABOOK id from XML");
										e.printStackTrace();
									}

									//Method to login in facebook
									String mailto=_objEWList.get(position).mailto;
									String body=_objEWList.get(position).body;
									String subject=_objEWList.get(position).subject;
									String cc=_objEWList.get(position).cc;
									String bcc=_objEWList.get(position).bcc;

									loginToFacebook(mailto,subject,body,cc);

								}else if(_objWrap.Link.trim().contains("twitter:")) {
									//Method to login in twitter
									loginToTwitter();
								}else if(_objWrap.Link.trim().contains("email:")) {

									String mailto=_objEWList.get(position).mailto;
									String body=_objEWList.get(position).body;
									String subject=_objEWList.get(position).subject;
									String cc=_objEWList.get(position).cc;
									String bcc=_objEWList.get(position).bcc;

									UtilMail mail = new UtilMail();
									mail.OpenMail(mContext , mailto ,cc,bcc, body , subject);
								}else {
									Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(_objWrap.Link.trim()));
									browserIntent.putExtra( "sms_body", _objEWList.get(position).body );
									((Home)mContext).startActivity(browserIntent);
								}

							} catch (Exception e) {
								e.printStackTrace();
							}
						}


						break;
					case MotionEvent.ACTION_CANCEL:
						//						holder.ListButton.getBackground().setAlpha(255);
						//			        	holder.GridButtonTV.getBackground().setAlpha(255);
						//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();

						try {
							String color =  _objEWList.get(position).bgcolor;
							if(color.length()>0)
							{
								v.setBackgroundColor(Color.parseColor(color));
							}else
							{
								v.setBackgroundColor(Color.TRANSPARENT);
							}

							if(_objEWList.get(position).leftbgColor.length()>0 && _objEWList.get(position).leftper.length()>0)
							{
								holder.Frm1.setBackgroundColor(Color.parseColor(_objEWList.get(position).leftbgColor.trim()));
							}
							if(_objEWList.get(position).midbgColor.length()>0 && _objEWList.get(position).middleper.length()>0)
							{
								holder.Frm2.setBackgroundColor(Color.parseColor(_objEWList.get(position).midbgColor.trim()));
							}
							if(_objEWList.get(position).rightbgColor.length()>0 && _objEWList.get(position).rightper.length()>0)
							{
								holder.Frm3.setBackgroundColor(Color.parseColor(_objEWList.get(position).rightbgColor.trim()));
							}


						} catch (Exception e) {
							// TODO: handle exception
						}

						break;

					}

					return false;
				}

			});
			try {
				String title =_objEWList.get(position).Title;
				holder.TextListBtn.setText(_objEWList.get(position).Title);

				String subtitle =_objEWList.get(position).subTitle;
				holder.subtitle.setText(_objEWList.get(position).subTitle);
			} catch (Exception e) {
				// TODO: handle exception
			}


			try {
				Typeface tf = MyUIApplication.fontmap.get(_objEWList.get(position).fontStyle);
				holder.TextListBtn.setTypeface(tf);
				holder.subtitle.setTypeface( MyUIApplication.fontmap.get(_objEWList.get(position).subtitlefontStyle));
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				holder.TextListBtn.setTextColor(Color.parseColor(_objEWList.get(position).fontColor));
				holder.subtitle.setTextColor(Color.parseColor(_objWrapper.subtitlefontColor));
				int i = Integer.parseInt(_objEWList.get(position).fontSize);
				float testsizepercent = i/960f;
				int i1 = Integer.parseInt(_objEWList.get(position).subtitlefontSize);
				float testsizepercent1 = i1/960f;
				holder.TextListBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(testsizepercent*deviceHeight)));
				holder.subtitle.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(.7f*testsizepercent1*deviceHeight)));
			} catch (Exception e) {
				holder.subtitle.setTextColor(Color.parseColor("#3c3c3c"));
				holder.TextListBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.TextListBtn.getTypeface(),(0.1f)*(.4f*deviceHeight)));
			}
		}

		catch (Exception e)
		{
			holder.ButtonList.setBackgroundResource(R.drawable.ic_launcher);

		}

		// Display planet data
		holder.id = position;
		if(_objEWList != null && _objEWList.get(position).Code.length()>0)
			holder.elementcode = _objEWList.get(position).Code;

		try {
			holder.MainLL.setBackgroundDrawable(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return convertView;
	}


	private class ViewHolderList 
	{
		ImageView ButtonList,Arrow;
		TextView TextListBtn,subtitle;
		LinearLayout ListButton;
		RelativeLayout MainLL;
		FrameLayout Frm1,Frm3;
		LinearLayout Frm2;
		int id;
		String elementcode;

	}
	
	
	/******************************************************************************************************/

	//	private static String APP_ID = "303528496438929"; // Replace your App ID here

	// Instance of Facebook Class
	private Facebook facebook;
	private AsyncFacebookRunner mAsyncRunner;
	private String 	FACEBOOK_APP_ID	=	"";
	//	String FILENAME = "AndroidSSO_data";
	//	private SharedPreferences mPrefs;


	public void loginToFacebook(final String name,final String caption, final String description, final String link){
		
		System.out.println("Name:= "+name);
		System.out.println("*******************************************");
		System.out.println("Caption:="+caption);
		System.out.println("********************************************");
		System.out.println("Description:="+description);
		System.out.println("*********************************************");
		System.out.println("link+"+link);
		System.out.println("*********************************************");
		System.out.println("Pictuew+"+"http://203.190.149.92/MADPlatform/Upload/Logo/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+MyUIApplication.EventCode);
		
		System.out.println("Opening FACEBOOK dialog");
		facebook = new Facebook(FACEBOOK_APP_ID);
		mAsyncRunner = new AsyncFacebookRunner(facebook);
		facebook.authorize((Activity)mContext, new DialogListener() {

			public void onFacebookError(FacebookError e) {
				System.out.println("Facebook Error 01");
				e.printStackTrace();
			}

			public void onError(DialogError e) {
				System.out.println("DialogError 01");
				e.printStackTrace();
			}

			public void onComplete(Bundle values) {
				postToWall(name,caption,description,link);
			}

			public void onCancel() {

			}
		});
	}

	public void postToWall(String name,String caption, String description, String link) {


		/*************************************************/

		Bundle params = new Bundle();
		params.putString("name", name);
		params.putString("caption", caption);
		params.putString("description", description);
		params.putString("link", link);
		params.putString("picture", "http://203.190.149.92/MADPlatform/Upload/Logo/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+MyUIApplication.EventCode);

		System.out.println("Name:= "+name);
		System.out.println("*******************************************");
		System.out.println("Caption:="+caption);
		System.out.println("********************************************");
		System.out.println("Description:="+description);
		System.out.println("*********************************************");
		System.out.println("link+"+link);
		System.out.println("*********************************************");
		System.out.println("Pictuew+"+"http://203.190.149.92/MADPlatform/Upload/Logo/"+MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/"+MyUIApplication.EventCode);
		// post on user's wall.
		facebook.dialog(mContext, "feed",params, new DialogListener() {

			public void onFacebookError(FacebookError e) {
				e.printStackTrace();
			}

			public void onError(DialogError e) {
				e.printStackTrace();
			}

			public void onComplete(Bundle values) {
				Log.e("Facebook", "Content Shared");
			}

			public void onCancel() {

			}
		});

	}

	static String TWITTER_CONSUMER_KEY = "xWl1EQskQuVWwENT9p0Q";
	static String TWITTER_CONSUMER_SECRET = "f3lAMGyKZlFY97mXlVKRsdmBJF0fKICYN5vwKU0I0";

	// Preference Constants
	//	    static String PREFERENCE_NAME = "twitter_oauth";
	//	    static final String PREF_KEY_OAUTH_TOKEN = "oauth_token";
	//	    static final String PREF_KEY_OAUTH_SECRET = "oauth_token_secret";
	//	    static final String PREF_KEY_TWITTER_LOGIN = "isTwitterLogedIn";
	static final String TWITTER_CALLBACK_URL = "oauth://t4jsample";

	// Twitter oauth urls
	static final String URL_TWITTER_AUTH = "auth_url";
	static final String URL_TWITTER_OAUTH_VERIFIER = "oauth_verifier";
	static final String URL_TWITTER_OAUTH_TOKEN = "oauth_token";

	// Twitter
	private static Twitter twitter;
	private static RequestToken requestToken;

	private void loginToTwitter() {
		System.out.println("Twitter Share");
		try{
			twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);

			new twitterAsyn().execute();

		}catch (Exception e) {
			e.printStackTrace();
		}

		//		 new Twitter_Dialog(mContext,"http://twitter.com/?status="+Uri.encode("Twitter Post")).show();
		// Check if already logged in
		//	        if (!isTwitterLoggedInAlready()) {
		//		 new Thread(new Runnable() {
		//			
		//			public void run() {
		//				// TODO Auto-generated method stub
		//				    ConfigurationBuilder builder = new ConfigurationBuilder();
		//		            builder.setOAuthConsumerKey(TWITTER_CONSUMER_KEY);
		//		            builder.setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET);
		//		            Configuration configuration = builder.build();
		//		             
		//		            TwitterFactory factory = new TwitterFactory(configuration);
		//		            twitter = factory.getInstance();
		//		 
		//		            try {
		//		                requestToken = twitter
		//		                        .getOAuthRequestToken(TWITTER_CALLBACK_URL);
		//		                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri
		//		                        .parse(requestToken.getAuthenticationURL())));
		//		            } catch (TwitterException e) {
		//		                e.printStackTrace();
		//		            }
		//			}
		//		}).start();

		//	        } else {
		// user already logged into twitter
		//	        }
	}

	public class twitterAsyn	extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			
			try {
				requestToken = twitter.getOAuthRequestToken();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			String url = requestToken.getAuthorizationURL();

			AlertDialog.Builder alert = new AlertDialog.Builder(mContext); 
			alert.setTitle("Twitter Share !!");

			WebView wv = new WebView(mContext);
			wv.loadUrl(url);
			wv.setWebViewClient(new WebViewClient() {
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return true;
				}
			});

			alert.setView(wv);
						alert.setPositiveButton("Close", new DialogInterface.OnClickListener() {
							
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								dialog.dismiss();
							}
						});
			alert.show();
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

	}
}

