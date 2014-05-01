package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.Adapters.ShowUpdateCategorayAdapter;
import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ShowUpdatesCategoryWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.ListView;



public class UtilShowUpdateCategory {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static ListView Listview;

	String scrrenNumString="";
	ElementWrapper _objEW;
	// **** Set Show Update view for Type 24 *****
	public void SetShowUpdateList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		_objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;

		MyUIApplication.globel_instance	=	_objEW.instance;   

		MyUIApplication.showUpdateCategoryCode	=	"All";


		if(MyUIApplication.Copy)
		{
			Listview= new ListView(context);


			try {
				Listview.setDivider(new ColorDrawable(Color.parseColor(_objEW.dividerColor)));
				Listview.setDividerHeight((int)(.003*((Home)context).deviceHeight));
			} catch (Exception e) {
				// TODO: handle exception
				Listview.setDivider(new ColorDrawable(Color.WHITE));
				Listview.setDividerHeight((int)(.003f*((Home)context).deviceHeight));
			}


			try
			{

				if(Section.equals("Top"))
				{


					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{

					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(Listview);



					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{


					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

		}
		else if(!MyUIApplication.Copy)
		{
			Listview = new ListView(context);

			try {
				Listview.setDivider(new ColorDrawable(Color.parseColor(_objEW.dividerColor)));
				Listview.setDividerHeight((int)(.003*((Home)context).deviceHeight));
			} catch (Exception e) {
				// TODO: handle exception
				Listview.setDivider(new ColorDrawable(Color.WHITE));
				Listview.setDividerHeight((int)(.003f*((Home)context).deviceHeight));
			}


			try
			{

				if(Section.equals("Top"))
				{


					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{


					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{


					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(Listview);

					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}

		if(MyUIApplication.checkUpdateCategory){
			if(MyUIApplication.isInternetAvailable(context))
			{
				new BadgeBGThread(context, "UPDATE Category", false).execute();
				MyUIApplication.checkUpdateCategory	=	false;
			}
		}else {
			fillList(context);
		}

	}

	// Filling Values in Shoe Update List and Setting Adapter
	public void fillList(Context con)
	{

		ArrayList<ShowUpdatesCategoryWrapper> array = MyUIApplication._objShowUpdateCategoryDB.getRecords();
		ShowUpdatesCategoryWrapper _obj = new ShowUpdatesCategoryWrapper();

		_obj.CatagoryName ="ALL Category";
		_obj.CatagoryCode ="All";

		array.add(0, _obj);

		try
		{
			ShowUpdateCategorayAdapter adapter = new ShowUpdateCategorayAdapter(con,R.layout.show_update_category,array,_objEW);
			Listview.setAdapter(adapter);
			//			if(scrrenNumString.length()>0)
			//			{
			//				Listview.setOnItemClickListener(new OnItemClickListener() {
			//
			//					public void onItemClick(AdapterView<?> arg0, View arg1,
			//							int arg2, long arg3) {
			//						// TODO Auto-generated method stub
			//
			//						
			//					}
			//				});
			//			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}


	}
}
