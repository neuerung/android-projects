package mobi.neuerung.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.DateUtilPackage.DateUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.SectionList.ShowUpdateAdapter;
import mobi.neuerung.SectionList.ShowUpdateEntryItem;
import mobi.neuerung.SectionList.ShowUpdateItem;
import mobi.neuerung.SectionList.ShowUpdateSectionItem;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ShowUpdatesWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.ListView;


public class UtilShowUpdate {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static ListView Listview;
	ElementWrapper _objEW;
	// **** Set Show Update view for Type 10 *****
	public void SetShowUpdateList(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;

		_objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		MyUIApplication.globel_instance	=	_objEW.instance;

		//Check if Copy View is displaying
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

				}
				else if(Section.equals("Middle"))
				{
					//Set Show update list view BG Color 
					try {
						Listview.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						Listview.setBackgroundColor(Color.parseColor("#FFFFFF"));
					}

					//Set Width & Height of the middle section 
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					//Add  the list view to main middle section
					((Home)context).LLMiddleCopy.addView(Listview);

					//Apply Width & Height to middle section of main view
					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					//Apply Width & Height to show update list view
					ViewGroup.LayoutParams params_Listview = Listview.getLayoutParams();
					params_Listview.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_Listview.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					Listview.setLayoutParams(params_Listview);

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

				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}

		if(MyUIApplication.checkShowUpdate){

			if(MyUIApplication.isInternetAvailable(context))
			{
				//Check for update & then fill the list
				new BadgeBGThread(context, "UPDATE", false).execute();
				MyUIApplication.checkShowUpdate	=	false;
			}

		}else {
			//Directly fill the list
			fillList(context);
		}

	}

	// Filling Values in Shoe Update List and Setting Adapter
	public void fillList(Context con)
	{

		MyUIApplication._objShowUpdateDB.getShowUpdateList();
		String ss	=	"";
		System.out.println("Filling list");
		MyUIApplication.ShowUpdateitems=null;
		MyUIApplication.ShowUpdateitems = new ArrayList<ShowUpdateItem>();

		//Creating list to show in news list
		for(int i =0;i<MyUIApplication._objDateShowUpdateList.size();i++)
		{
			try
			{

				SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
				SimpleDateFormat format2 = new SimpleDateFormat("dd-MMMM-yyyy");

				try
				{
					String s = MyUIApplication._objDateShowUpdateList.get(i).trim();

					Date date = format1.parse(s);
					//					String Dat = format2.format(date);
					//					Date d = (Date)formatter.parse(si.getTitle());
					ss=DateUtil.checkDate(date);
					MyUIApplication.ShowUpdateitems.add(new ShowUpdateSectionItem(ss));

				}catch (Exception e) {
					e.printStackTrace();
				}

			}catch (Exception e) {
				e.printStackTrace();
			}


			ArrayList<ShowUpdatesWrapper> _objArray =MyUIApplication._objShowUpdateList.get(i);

			for(int j=0;j<_objArray.size();j++)
			{

				ShowUpdatesWrapper _obj =	_objArray.get(j);
				String datetime	=	"";

				if(ss.equals("Today")){
					try {
						datetime=DateUtil.checkTime((new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")).parse(_obj.ShowDate));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}else {

					try{
						DateFormat StringToDate = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
						String t=_obj.ShowDate.trim();
						Date date = StringToDate.parse(t);
						datetime=new SimpleDateFormat("HH:mm").format(date);
					}catch (Exception e) {
						e.printStackTrace();
						MyUIApplication.LoggerToSD("Show Update_ 343", "Unable to Simple date formate");
					}
				}

				MyUIApplication.ShowUpdateitems.add(new ShowUpdateEntryItem(_obj.title,datetime,_objArray.get(j)));
			}

		}

		//Setting News Adapter
		try
		{
			ShowUpdateAdapter adapter = new ShowUpdateAdapter(con, MyUIApplication.ShowUpdateitems,_objEW);
			Listview.setAdapter(adapter);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}


	}
}
