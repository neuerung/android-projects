package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class UtilEventDetail {

	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static RelativeLayout RelativeView;

	public void SetEventsDetail(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String ID)
	{
		MyUIApplication._objEWList = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);

		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;


		if(MyUIApplication.Copy)
		{
			RelativeView= new RelativeLayout(context);

			try
			{


				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(RelativeView);

					ViewGroup.LayoutParams params_RelView = RelativeView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					RelativeView.setLayoutParams(params_RelView);


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

					((Home)context).LLMiddleCopy.addView(RelativeView);



					ViewGroup.LayoutParams params_RelView = RelativeView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					RelativeView.setLayoutParams(params_RelView);

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


					((Home)context).LLBottomCopy.addView(RelativeView);

					ViewGroup.LayoutParams params_RelView = RelativeView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					RelativeView.setLayoutParams(params_RelView);


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

		}
		else if(!MyUIApplication.Copy)
		{
			RelativeView = new RelativeLayout(context);

			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(RelativeView);

					ViewGroup.LayoutParams params_RelView = RelativeView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					RelativeView.setLayoutParams(params_RelView);


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

					((Home)context).LLMiddle.addView(RelativeView);

					ViewGroup.LayoutParams params_RelView = RelativeView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					RelativeView.setLayoutParams(params_RelView);

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


					((Home)context).LLBottom.addView(RelativeView);

					ViewGroup.LayoutParams params_RelView = RelativeView.getLayoutParams();
					params_RelView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_RelView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					RelativeView.setLayoutParams(params_RelView);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}
		LinScroll = new LinearLayout(context);
		RelativeView.addView(LinScroll);

		AddTopBar(context);
		AddDetailView(context);

	}


	static ArrayList<Button> _objButton;
	Button buttons;
	LinearLayout LinScroll;
	RelativeLayout DetailView;

	public void AddDetailView(Context context)
	{
		for(int i =0;i<MyUIApplication._objEWList.size();i++)
		{
			if(MyUIApplication._objEWList.get(i).Type.equals("0.2"))
			{
				DetailView = new RelativeLayout(context);
				RelativeView.addView(DetailView);
				DetailView.setBackgroundColor(Color.WHITE);

				ElementWrapper _objEWBtn = new ElementWrapper();
				_objEWBtn = MyUIApplication._objEWList.get(i);

				double Btnwidth=Double.parseDouble(_objEWBtn.width);
				double Btnheight=Double.parseDouble(_objEWBtn.height);
				double BtnwidthPer=Btnwidth/100;
				double BtnheightPer=Btnheight/100;


				RelativeLayout.LayoutParams DetailView_param = (RelativeLayout.LayoutParams)DetailView.getLayoutParams();
				DetailView_param.width = (int) (((Home)context).deviceWidth);
				DetailView_param.height =(int)(BtnheightPer*((Home)context).deviceHeight);
				DetailView.setLayoutParams(DetailView_param);
				DetailView_param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, DetailView.getId());

				LinearLayout LinearView = new LinearLayout(context);
				DetailView.addView(LinearView);
				LinearView.setOrientation(LinearLayout.VERTICAL);

				RelativeLayout.LayoutParams LinearView_param = (RelativeLayout.LayoutParams)LinearView.getLayoutParams();
				LinearView_param.topMargin =(int)(0.1f*((Home)context).deviceHeight);
				LinearView_param.leftMargin =(int)(0.05f*((Home)context).deviceWidth);
				LinearView.setLayoutParams(LinearView_param);
//				LinearView_param.addRule(RelativeLayout.CENTER_HORIZONTAL);



				TextView TV1 = new TextView(context);
				LinearView.addView(TV1);
				TextView TV2 = new TextView(context);
				LinearView.addView(TV2);
				TextView TV3 = new TextView(context);
				LinearView.addView(TV3);
				TextView TV4 = new TextView(context);
				LinearView.addView(TV4);

				TV1.setText("Location : "+MyUIApplication.EventsWrapperForDetail.Locations);
				TV2.setText("Details  : "+MyUIApplication.EventsWrapperForDetail.Description);
				TV3.setText("Fees     : "+MyUIApplication.EventsWrapperForDetail.Fees);
				TV4.setText("Language : "+MyUIApplication.EventsWrapperForDetail.Language);

				TV1.setTextColor(Color.BLACK);
				TV2.setTextColor(Color.BLACK);
				TV3.setTextColor(Color.BLACK);
				TV4.setTextColor(Color.BLACK);

				TV1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(TV1.getTypeface(),(0.3f)*(int)(.1f*((Home)context).deviceHeight)));
				TV2.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(TV2.getTypeface(),(0.3f)*(int)(.1f*((Home)context).deviceHeight)));
				TV3.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(TV3.getTypeface(),(0.3f)*(int)(.1f*((Home)context).deviceHeight)));
				TV4.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(TV4.getTypeface(),(0.3f)*(int)(.1f*((Home)context).deviceHeight)));

				Button BtnFav = new Button(context);
				DetailView.addView(BtnFav);
				RelativeLayout.LayoutParams params_TopButton1 = (RelativeLayout.LayoutParams)BtnFav.getLayoutParams();
				params_TopButton1.width=(int)(.17f*((Home)context).deviceWidth);
				params_TopButton1.height=(int)(.17f*(((Home)context).deviceWidth)*.763);
				BtnFav.setLayoutParams(params_TopButton1);
				params_TopButton1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
				ImageUtil.setBgFromSDCardNotCache(BtnFav, context, "exhi1.png", (.17f*(((Home)context).deviceWidth)*.763f), (.17f*((Home)context).deviceWidth));

				BtnFav.setId(21);

				try
				{

					Button BtnVis = new Button(context);
					DetailView.addView(BtnVis);
					RelativeLayout.LayoutParams params_TopButton2 =(RelativeLayout.LayoutParams) BtnVis.getLayoutParams();
					params_TopButton2.width=(int)(.17f*((Home)context).deviceWidth);
					params_TopButton2.height=(int)(.17f*(((Home)context).deviceWidth)*.763f);
					BtnVis.setLayoutParams(params_TopButton2);
					params_TopButton2.addRule(RelativeLayout.BELOW,BtnFav.getId());
					params_TopButton2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
					ImageUtil.setBgFromSDCardNotCache(BtnVis, context, "exhi2.png", (.17f*(((Home)context).deviceWidth)*.763f), (.17f*((Home)context).deviceWidth));
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println("llllll"+e);
				}
			}
		}
	}
	double LinScrollHeight ;
	public void AddTopBar(final Context context)
	{


		LinScroll.setBackgroundColor(Color.WHITE);

		try
		{

			_objButton = null;
			_objButton = new ArrayList<Button>();

			for(int i =0;i<MyUIApplication._objEWList.size();i++)
			{
				if(MyUIApplication._objEWList.get(i).Type.equals("0.3"))
				{
					buttons = new Button(context);
					LinScroll.addView(buttons);

					ElementWrapper _objEWBtn = new ElementWrapper();

					_objEWBtn = MyUIApplication._objEWList.get(i);

					double Btnwidth=Double.parseDouble(_objEWBtn.width);
					double Btnheight=Double.parseDouble(_objEWBtn.height);
					double BtnwidthPer=Btnwidth/100;
					double BtnheightPer=Btnheight/100;

					LinScrollHeight = BtnheightPer;

					LinearLayout.LayoutParams params_Frame =(LinearLayout.LayoutParams) buttons.getLayoutParams();
					params_Frame = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 
							LinearLayout.LayoutParams.WRAP_CONTENT,Gravity.LEFT|Gravity.TOP);
					//					params_Frame.height=(int)(BtnheightPer);
					//					params_Frame.width=(int)(BtnwidthPer*(((Home)context).deviceWidth));
					params_Frame.height=(int)(BtnwidthPer*(((Home)context).deviceWidth));
					params_Frame.width=(int)(BtnwidthPer*(((Home)context).deviceWidth));
					//					params_Frame.leftMargin=(int)(0.02f*(((Home)context).deviceWidth));
					buttons.setLayoutParams(params_Frame);


					if(_objEWBtn.Bitmap.length()>0)
					{
						if(MyUIApplication.IsSdCardImageAvailable(_objEWBtn.Bitmap+".png"))
						{
							String BtnfilePath=_objEWBtn.Bitmap+".png";
							ImageUtil.setBgFromSDCardNotCache(buttons, context,BtnfilePath,(int)(BtnheightPer),(int)(BtnwidthPer*(((Home)context).deviceWidth)));
						}
						else 
						{
							String BtnfilePath="images/"+_objEWBtn.Bitmap+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache(buttons, context,BtnfilePath,(int)(BtnheightPer),(int)(BtnwidthPer*(((Home)context).deviceWidth)));
						}
					}

					if(_objEWBtn.OnClick.equals("Play/Pause"))
					{
						buttons.setOnClickListener(new OnClickListener() {

							public void onClick(View v) {
								// TODO Auto-generated method stub
								//								VideoClick(v,context,v.getHeight(),v.getWidth());
							}
						});
					}
					else if(_objEWBtn.OnClick.equals("Like/Dislike"))
					{
						buttons.setOnClickListener(new OnClickListener() {

							public void onClick(View v) {
								if(MyUIApplication.isInternetAvailable(context))
								{
									//									String fileName = Url.substring(Url.lastIndexOf("/")+1);
									//									File sdMiddlefileImage= new File(Environment.getExternalStorageDirectory()+"/Download/"+fileName);
									//									if(!sdMiddlefileImage.exists())
									//									{
									//										new Splash0Thread(context,"DownLoadVideoInSdCard",Url).execute();
									//									}
									//									else
									//									{
									//										MyUIApplication.AlertString(context, "Already exist in SdCard Download");
									//									}
								}
							}
						});
					}
				}
			}

			RelativeLayout.LayoutParams LinScroll_param = (RelativeLayout.LayoutParams)LinScroll.getLayoutParams();
			LinScroll_param.height =(int)(LinScrollHeight*(((Home)context).deviceHeight));
			LinScroll.setLayoutParams(LinScroll_param);

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}


}
