package mobi.neuerung.Adapters;

import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Util.UtilMail;
import mobi.neuerung.Wrapper.ElementWrapper;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



//**** Home Grid Adapter   *****
public class HomeAdaptorGrid extends BaseAdapter {
	private Context mContext;
	private ArrayList<ElementWrapper> _objListEW;
	private LayoutInflater mInflater;
	Integer ColumnNumber=3;
	String verticalSpacing;
	// Constructor
	public HomeAdaptorGrid(Context c , ArrayList<ElementWrapper>  _objListEW,Integer ColumnNumber,String verticalSpacing)
	{
		mContext = c;
		this._objListEW = _objListEW;
		this.ColumnNumber = ColumnNumber;
		this.verticalSpacing = verticalSpacing;
		mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() 
	{
		return _objListEW.size();
	}
	public Object getItem(int position)
	{
		return _objListEW.get(position);
	}
	public long getItemId(int position)
	{
		return 0;
	}
	WindowManager mWinMgr;
	int deviceHeight=0;
	int deviceWidth=0;
	public View getView(final int position, View convertView, ViewGroup parent) {
		try {



			final ViewHolder holder;
			WindowManager mWinMgr = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
			deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
			deviceWidth=mWinMgr.getDefaultDisplay().getWidth();

			if (convertView == null)
			{
				holder = new ViewHolder();

				convertView = mInflater.inflate(R.layout.gridviewxml, null);
				try
				{

					holder.ButtonGrid = (RelativeLayout) convertView.findViewById(R.id.ButtonGrid);
					holder.ButtonGV = (ImageView) convertView.findViewById(R.id.ButtonGV);
						holder.ButtonGrid.setTag(holder.ButtonGV);
					holder.GridButtonTV = (TextView) convertView.findViewById(R.id.GridButtonTV);

				}
				catch (Exception e)
				{

					holder.ButtonGrid = (RelativeLayout) convertView.findViewById(R.id.ButtonGrid);
					ViewGroup.LayoutParams params_ButtonGrid = holder.ButtonGrid.getLayoutParams();
					int buttonwidth=(int)(.2f*deviceWidth);
					params_ButtonGrid.width=buttonwidth;
					params_ButtonGrid.height=(int)(1.07f*buttonwidth);
					holder.ButtonGrid.setLayoutParams(params_ButtonGrid);

					LinearLayout.LayoutParams marginparam_ButtonGrid =(LinearLayout.LayoutParams) holder.ButtonGrid.getLayoutParams();
					marginparam_ButtonGrid.topMargin = (int)(.025f*deviceHeight);

					holder.ButtonGV = (ImageView) convertView.findViewById(R.id.ButtonGV);
					ViewGroup.LayoutParams params_ButtonGV = holder.ButtonGV.getLayoutParams();
					params_ButtonGV.width=buttonwidth;
					params_ButtonGV.height=(int)(.6f*buttonwidth);
					holder.ButtonGV.setLayoutParams(params_ButtonGV);

					holder.GridButtonTV = (TextView) convertView.findViewById(R.id.GridButtonTV);
					ViewGroup.LayoutParams params_GridButtonTV = holder.GridButtonTV.getLayoutParams();
					params_GridButtonTV.height=(int)(.0725f*deviceHeight);
					holder.GridButtonTV.setLayoutParams(params_GridButtonTV);


				}

				convertView.setTag(holder);
			}
			else 
			{
				holder = (ViewHolder) convertView.getTag();
			}

			holder.ButtonGrid.setOnTouchListener(new OnTouchListener() 
			{
				public boolean onTouch(View v, MotionEvent event)
				{
					ImageView im=null;

					try {
						im =(ImageView) v.getTag();
					} catch (Exception e) {
						// TODO: handle exception
					}

					switch(event.getAction()) 
					{

					case MotionEvent.ACTION_DOWN:

						try {
							//							im.getBackground().setAlpha(150);
							im.setAlpha(150);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(""+e);
						}

						//		        	holder.GridButtonTV.getBackground().setAlpha(150);
						//					return false;
						return true;
					case MotionEvent.ACTION_UP:

						try
						{

							//							im.getBackground().setAlpha(255);
							im.setAlpha(255);
							if(_objListEW.get(position).OnClick.trim().length()>0)
							{

								String screenNumber=_objListEW.get(position).OnClick.substring(12);
								if(MyUIApplication.ScreenNumbers.contains(screenNumber))
								{
									try {

										if(screenNumber.equals("1"))    //  "1" For Mail
										{

											String mailto=_objListEW.get(position).mailto;
											String body=_objListEW.get(position).body;
											String subject=_objListEW.get(position).subject;
											String cc=_objListEW.get(position).cc;
											String bcc=_objListEW.get(position).bcc;

											UtilMail mail = new UtilMail();
											mail.OpenMail(mContext ,mailto,cc,bcc,body,subject);
										}
									} catch (Exception e) {
										// TODO: handle exception
									}


									if(screenNumber.length()>0)
									{

										
										if(screenNumber.equals("2"))   //  "2" For google
										{
											((Home)mContext).OpenHtmlPage(screenNumber,"");
											//											MyUIApplication.StateMachine.add(screenNumber);
										}
										else
										{

											((Home)mContext).inLayoutAnim();


											v.setEnabled(false);
											((Home)mContext).OpenHtmlPage(screenNumber,"");
											MyUIApplication.StateMachine.add(screenNumber);

											int i=MyUIApplication.StateMachine.size();
											System.out.println("State Machine Size >>>"+i);
										}
									}
								}
							}

							else if(_objListEW.get(position).Link.length()>0)
							{
								try {
									Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(_objListEW.get(position).Link.trim()));
									((Home)mContext).startActivity(browserIntent);
								} catch (Exception e) {
									// TODO: handle exception
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
							//							im.getBackground().setAlpha(255);
							im.setAlpha(255);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(""+e);
						}

						break;
					}

					return false;
				}

			});

			
			try {
				holder.GridButtonTV.setMaxLines(Integer.parseInt(_objListEW.get(position).maxline));
			} catch (Exception e) {
				// TODO: handle exception
				holder.GridButtonTV.setMaxLines(2);
			}
			try {
				String Width  = _objListEW.get(position).width;
				Double Width1 = Double.parseDouble(Width);
				Double Width2 = Width1/100;
				int buttonwidth=(int)(Width2*deviceWidth);

				String height  = _objListEW.get(position).height;
				Double height1 = Double.parseDouble(height);
				Double height2 = height1/100;
				int buttonheight=(int)(height2*deviceHeight);

				ViewGroup.LayoutParams params_ButtonGrid = holder.ButtonGrid.getLayoutParams();
				try {
					float margins = Float.parseFloat(verticalSpacing);
					int margintimes = ColumnNumber-1;
					float totalgridwidth = (100-(margintimes*margins))/100.0f;
					int bwidth = (int)(totalgridwidth*deviceWidth)/ColumnNumber;
					params_ButtonGrid.width=bwidth;
				} catch (Exception e) {
					// TODO: handle exception
					params_ButtonGrid.width=(int)(.3333f*deviceWidth);
				}

				params_ButtonGrid.height=(int)(buttonheight);
				holder.ButtonGrid.setLayoutParams(params_ButtonGrid);

				try {
					if(_objListEW.get(position).bgcolor.trim().length()>0)
					{
						holder.ButtonGrid.setBackgroundColor(Color.parseColor(_objListEW.get(position).bgcolor.trim()));
					}
				} catch (Exception e) {
					// TODO: handle exception
					holder.ButtonGrid.setBackgroundColor(Color.WHITE);
				}



				ViewGroup.LayoutParams params_ButtonGV = holder.ButtonGV.getLayoutParams();

				try {
					float ImageWidth = Float.parseFloat(_objListEW.get(position).ImageWidth)/100.0f;
					params_ButtonGV.width=(int)(ImageWidth*deviceWidth);
				} catch (Exception e) {
					// TODO: handle exception
					params_ButtonGV.width=buttonwidth;
				}


				try {
					float ImageHeight = Float.parseFloat(_objListEW.get(position).ImageHeight)/100.0f;
					params_ButtonGV.height=(int)(ImageHeight*deviceHeight);
				} catch (Exception e) {
					// TODO: handle exception
					params_ButtonGV.height=(int)(.7f*buttonheight);
				}

				holder.ButtonGV.setLayoutParams(params_ButtonGV);



				ViewGroup.LayoutParams params_GridButtonTV = holder.GridButtonTV.getLayoutParams();

				try {
					float textWidth = Float.parseFloat(_objListEW.get(position).TextWidth)/100.0f;
					params_GridButtonTV.width=(int)(textWidth*deviceWidth);
				} catch (Exception e) {
					// TODO: handle exception
					params_GridButtonTV.width=buttonwidth;
				}


				try {
					float textHeight = Float.parseFloat(_objListEW.get(position).TextHeight)/100.0f;
					params_GridButtonTV.height=(int)(textHeight*deviceHeight);
				} catch (Exception e) {
					// TODO: handle exception
					params_GridButtonTV.height=(int)(.295f*buttonheight);
				}

				holder.GridButtonTV.setLayoutParams(params_GridButtonTV);
				holder.GridButtonTV.setPadding(0,(int)(.005f*buttonheight),0,0);

				try {
					if(_objListEW.get(position).TextMode.trim().length()>0)
					{
						if(_objListEW.get(position).TextMode.trim().equalsIgnoreCase("top"))
						{
							RelativeLayout.LayoutParams Marginparams_GridButtonTV =(RelativeLayout.LayoutParams) holder.GridButtonTV.getLayoutParams();
							Marginparams_GridButtonTV.addRule(RelativeLayout.ALIGN_PARENT_TOP);
						}
						else if(_objListEW.get(position).TextMode.trim().equalsIgnoreCase("bottom"))
						{
							RelativeLayout.LayoutParams Marginparams_GridButtonTV =(RelativeLayout.LayoutParams) holder.GridButtonTV.getLayoutParams();
							Marginparams_GridButtonTV.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
						}
						else
						{
							RelativeLayout.LayoutParams Marginparams_GridButtonTV =(RelativeLayout.LayoutParams) holder.GridButtonTV.getLayoutParams();
							Marginparams_GridButtonTV.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
						}
					}
					else
					{
						RelativeLayout.LayoutParams Marginparams_GridButtonTV =(RelativeLayout.LayoutParams) holder.GridButtonTV.getLayoutParams();
						Marginparams_GridButtonTV.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
					}
				} catch (Exception e) {
					// TODO: handle exception
					RelativeLayout.LayoutParams Marginparams_GridButtonTV =(RelativeLayout.LayoutParams) holder.GridButtonTV.getLayoutParams();
					Marginparams_GridButtonTV.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
				}

				try {
					if(_objListEW.get(position).TextTransColor.trim().length()>0)
					{
						holder.GridButtonTV.setBackgroundColor(Color.parseColor(_objListEW.get(position).TextTransColor.trim()));
						holder.GridButtonTV.getBackground().setAlpha(100);

					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
				if(_objListEW.get(position).ImageMode.equalsIgnoreCase("Crop"))
				{
					holder.ButtonGV.setScaleType(ScaleType.CENTER_CROP);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			

			LinearLayout.LayoutParams marginparam_ButtonGrid =(LinearLayout.LayoutParams) holder.ButtonGrid.getLayoutParams();

			try {
//				leftMargin = leftMargin/100f;
//				rightMargin = rightMargin/100f;
//				topmargin = topmargin/100f;
//				marginparam_ButtonGrid.leftMargin = (int)(leftMargin*deviceWidth);
//				marginparam_ButtonGrid.rightMargin = (int)(rightMargin*deviceWidth);
//				marginparam_ButtonGrid.topMargin = (int)(topmargin*deviceHeight);

			} catch (Exception e) {
				// TODO: handle exception
				marginparam_ButtonGrid.leftMargin = (int)(.02f*deviceWidth);
				marginparam_ButtonGrid.rightMargin = (int)(.02f*deviceWidth);
				marginparam_ButtonGrid.topMargin = (int)(.0f*deviceHeight);

			}

			
			
			try
			{

				String Width  = _objListEW.get(position).width;
				Double Width1 = Double.parseDouble(Width);
				Double Width2 = Width1/100;

				int buttonwidth=(int)(Width2*deviceWidth);

				String height  = _objListEW.get(position).height;
				Double height1 = Double.parseDouble(height);
				Double height2 = height1/100;
				int buttonheight=(int)(height2*deviceHeight);
				if(_objListEW.get(position).Bitmap.trim().length()>0)
				{
					if(MyUIApplication.IsSdCardImageAvailable(_objListEW.get(position).Bitmap))
					{
						String filePath=_objListEW.get(position).Bitmap;
						Bitmap bmp = ImageUtil.setBgFromSDCardNotCache(holder.ButtonGV, (Home)mContext,filePath,(int)(.7f*buttonheight),(int)(buttonwidth));

						if(bmp !=null)
						{
							holder.ButtonGV.setImageBitmap(bmp);
							holder.ButtonGV.setBackgroundDrawable(null);
						}

					}
					else 
					{
						String filePath="images/"+_objListEW.get(position).Bitmap;
						Bitmap bmp = ImageUtil.setBackgroundBgFromAssetsNotCache(holder.ButtonGV, (Home)mContext,filePath,(int)(.7f*buttonheight),(int)(buttonwidth));

						if(bmp !=null)
						{
							holder.ButtonGV.setImageBitmap(bmp);
							holder.ButtonGV.setBackgroundDrawable(null);
						}
					}
				}
				else
				{
					holder.ButtonGV.setImageBitmap(null);
					holder.ButtonGV.setBackgroundDrawable(null);
				}

				String s=_objListEW.get(position).Title.trim();
				holder.GridButtonTV.setText(_objListEW.get(position).Title.trim());


				try {
					Typeface tf = MyUIApplication.fontmap.get(_objListEW.get(position).fontStyle);
					holder.GridButtonTV.setTypeface(tf);
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					holder.GridButtonTV.setTextColor(Color.parseColor(_objListEW.get(position).fontColor));
					int i = Integer.parseInt(_objListEW.get(position).fontSize);
					float testsizepercent = i/960f;
					holder.GridButtonTV.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.GridButtonTV.getTypeface(),(testsizepercent*deviceHeight)));
				} catch (Exception e) {
					// TODO: handle exception
					holder.GridButtonTV.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.GridButtonTV.getTypeface(),(0.1f)*(.4f*deviceHeight)));
				}
				
				try {
					if(_objListEW.get(position).TitleGravity.equalsIgnoreCase("center"))
						holder.GridButtonTV.setGravity(Gravity.CENTER);
					if(_objListEW.get(position).TitleGravity.equalsIgnoreCase("right"))
						holder.GridButtonTV.setGravity(Gravity.RIGHT);
					if(_objListEW.get(position).TitleGravity.equalsIgnoreCase("left"))
						holder.GridButtonTV.setGravity(Gravity.LEFT);
				} catch (Exception e) {
					// TODO: handle exception
					holder.GridButtonTV.setGravity(Gravity.CENTER);
				}



			}
			catch (Exception e)
			{

				holder.ButtonGV.setBackgroundResource(R.drawable.ic_launcher);

			}

			// Display planet data
			holder.id = position;

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(""+e);
		}

		return convertView;
	}


}

class ViewHolder 
{
	RelativeLayout ButtonGrid;
	FrameLayout TransBtn;
	ImageView ButtonGV;
	TextView GridButtonTV;
	int id;

}