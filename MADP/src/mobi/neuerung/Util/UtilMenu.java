package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.Adapters.MenuAdapter;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MenuItem.MenuEntryItem;
import mobi.neuerung.MenuItem.MenuItem;
import mobi.neuerung.MenuItem.MenuSectionItem;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.MenuWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;

public class UtilMenu 
{
	ListView listView;
	Util _objUtil;

	public void SetMenuView(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{
		_objUtil=new Util();
		listView=new ListView(context);


		try
		{
			if(Section.equals("Top"))
			{
				if(_objScreenPartWrapper.Topbgcolor.length()>0)
				{
					((Home)context).LLTopMenu.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					listView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					listView.setCacheColorHint(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
				}


				double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
				double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
				double widthLLTopPer=widthLLTop/100;
				double heightLLTopPer=heightLLTop/100;

				((Home)context).LLTopMenu.addView(listView);

				ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTopMenu.getLayoutParams();
				params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				((Home)context).LLTopMenu.setLayoutParams(params_LLTop);

				ViewGroup.LayoutParams params_WView = listView.getLayoutParams();
				params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				listView.setLayoutParams(params_WView);

				_objUtil.getMenuList(Section);

				System.out.println("Filling list");
				MyUIApplication.Menuitems=null;
				MyUIApplication.Menuitems = new ArrayList<MenuItem>();


				for(int i =0;i<MyUIApplication.TypeWisesectionList.size();i++)
				{
					try
					{
						MyUIApplication.Menuitems.add(new MenuSectionItem(MyUIApplication.TypeWisesectionList.get(i)));

					}
					catch (Exception e) 
					{
					}
					ArrayList<MenuWrapper> _objArray =MyUIApplication.sectionList.get(i);
					for(int j=0;j<_objArray.size();j++)
					{
						MenuWrapper _obj =	_objArray.get(j);
						MyUIApplication.Menuitems.add(new MenuEntryItem(_obj.title,_obj.imageName,_objArray.get(j)));
					}
				}

				listView.setAdapter(null);
				MenuAdapter adapter = new MenuAdapter(context, MyUIApplication.Menuitems,(int)heightLLTop,(int)widthLLTop);
				listView.setAdapter(adapter);

				listView.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) {

						// TODO Auto-generated method stub
						//				MyUIApplication.EventSelected=arg2;
						//				startActivityForResult(MyUIApplication._objEventsDetailIntent, 304);
						//				overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
						//				
						MenuItem i = MyUIApplication.Menuitems.get(arg2);
						if(i.isSection()){

						}
						else
						{

							MenuEntryItem ei = (MenuEntryItem)MyUIApplication.Menuitems.get(arg2);;
							MenuWrapper _obj=ei._objMenuWrapper;

							if(_obj.OnClick.substring(12).equals(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1)))
							{
								((Home)context).LLLayoutMenu.setVisibility(View.GONE);
								((Home)context).MenuButton.setVisibility(View.GONE);



								((Home)context).LLTopMenu.removeAllViews();
								((Home)context).LLMiddleMenu.removeAllViews();
								((Home)context).LLBottomMenu.removeAllViews();
							}
							else
							{

								((Home)context).LLLayoutMenu.setVisibility(View.GONE);
								((Home)context).MenuButton.setVisibility(View.GONE);



								((Home)context).LLTopMenu.removeAllViews();
								((Home)context).LLMiddleMenu.removeAllViews();
								((Home)context).LLBottomMenu.removeAllViews();

								listView.setEnabled(false);


								//					MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);


								System.out.println("State Machine"+MyUIApplication.StateMachine);
								if(_obj.OnClick.substring(12).equals("0"))
								{
//									((Home)context).DesignHomeScreen();
									((Home)context).OpenHtmlPage("0", "");
								}
								else
								{
									String LastScreen =_obj.OnClick.substring(12);
									MyUIApplication.StateMachine.add(LastScreen);
									((Home)context).OpenHtmlPage(LastScreen,"");
								}
							}


						}

					}
				});
				listView.setVerticalFadingEdgeEnabled(false);
			}
			else if(Section.equals("Middle"))
			{
				if(_objScreenPartWrapper.Midbgcolor.length()>0)
				{
					((Home)context).LLMiddleMenu.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					listView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					listView.setCacheColorHint(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
				}

				double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
				double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
				double widthLLTopPer=widthLLTop/100;
				double heightLLTopPer=heightLLTop/100;

				((Home)context).LLMiddleMenu.addView(listView);

				ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddleMenu.getLayoutParams();
				params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				((Home)context).LLMiddleMenu.setLayoutParams(params_LLMiddle);

				ViewGroup.LayoutParams params_WView = listView.getLayoutParams();
				params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				listView.setLayoutParams(params_WView);

				_objUtil.getMenuList(Section);

				System.out.println("Filling list");
				MyUIApplication.Menuitems=null;
				MyUIApplication.Menuitems = new ArrayList<MenuItem>();


				for(int i =0;i<MyUIApplication.TypeWisesectionList.size();i++)
				{
					try
					{


						MyUIApplication.Menuitems.add(new MenuSectionItem(MyUIApplication.TypeWisesectionList.get(i)));

					}
					catch (Exception e) 
					{
					}

					ArrayList<MenuWrapper> _objArray =MyUIApplication.sectionList.get(i);
					for(int j=0;j<_objArray.size();j++)
					{
						MenuWrapper _obj =	_objArray.get(j);
						MyUIApplication.Menuitems.add(new MenuEntryItem(_obj.title,_obj.imageName,_objArray.get(j)));
					}
				}

				listView.setAdapter(null);
				MenuAdapter adapter = new MenuAdapter(context, MyUIApplication.Menuitems,(int)heightLLTop,(int)widthLLTop);
				listView.setAdapter(adapter);

				listView.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) {
						// TODO Auto-generated method stub
						//				MyUIApplication.EventSelected=arg2;
						//				startActivityForResult(MyUIApplication._objEventsDetailIntent, 304);
						//				overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
						//				
						MenuItem i = MyUIApplication.Menuitems.get(arg2);
						if(i.isSection()){

						}
						else
						{

							MenuEntryItem ei = (MenuEntryItem)MyUIApplication.Menuitems.get(arg2);;
							MenuWrapper _obj=ei._objMenuWrapper;
							if(_obj.OnClick.equals("update"))
							{
								((Home)context).LLLayoutMenu.setVisibility(View.GONE);
								((Home)context).MenuButton.setVisibility(View.GONE);



								((Home)context).LLTopMenu.removeAllViews();
								((Home)context).LLMiddleMenu.removeAllViews();
								((Home)context).LLBottomMenu.removeAllViews();

//								((Home)context).PleaseCheckForSync();
								MyUIApplication.Menu=true;
							}
							else if(_obj.OnClick.substring(12).equals(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1)))
							{
								((Home)context).LLLayoutMenu.setVisibility(View.GONE);
								((Home)context).MenuButton.setVisibility(View.GONE);



								((Home)context).LLTopMenu.removeAllViews();
								((Home)context).LLMiddleMenu.removeAllViews();
								((Home)context).LLBottomMenu.removeAllViews();
							}
							else
							{

								((Home)context).LLLayoutMenu.setVisibility(View.GONE);
								((Home)context).MenuButton.setVisibility(View.GONE);



								((Home)context).LLTopMenu.removeAllViews();
								((Home)context).LLMiddleMenu.removeAllViews();
								((Home)context).LLBottomMenu.removeAllViews();

								listView.setEnabled(false);


								//					MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);



								System.out.println("State Machine"+MyUIApplication.StateMachine);
								if(_obj.OnClick.substring(12).equals("0"))
								{
//									((Home)context).DesignHomeScreen();
									((Home)context).OpenHtmlPage("0", "");
								}
								else
								{
									String LastScreen =_obj.OnClick.substring(12);
									MyUIApplication.StateMachine.add(LastScreen);
									((Home)context).OpenHtmlPage(LastScreen,"");
								}
							}
						}
					}
				});
				listView.setVerticalFadingEdgeEnabled(false);
			}
			else if(Section.equals("Bottom"))
			{
				if(_objScreenPartWrapper.Bottombgcolor.length()>0)
				{
					((Home)context).LLBottomMenu.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					listView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					listView.setCacheColorHint(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
				}


				double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
				double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
				double widthLLTopPer=widthLLTop/100;
				double heightLLTopPer=heightLLTop/100;


				((Home)context).LLBottomMenu.addView(listView);

				ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottomMenu.getLayoutParams();
				params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				((Home)context).LLBottomMenu.setLayoutParams(params_LLBottom);

				ViewGroup.LayoutParams params_WView = listView.getLayoutParams();
				params_WView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
				params_WView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
				listView.setLayoutParams(params_WView);

				_objUtil.getMenuList(Section);

				System.out.println("Filling list");
				MyUIApplication.Menuitems=null;
				MyUIApplication.Menuitems = new ArrayList<MenuItem>();


				for(int i =0;i<MyUIApplication.TypeWisesectionList.size();i++)
				{
					try
					{


						MyUIApplication.Menuitems.add(new MenuSectionItem(MyUIApplication.TypeWisesectionList.get(i)));

					}
					catch (Exception e) 
					{
					}

					ArrayList<MenuWrapper> _objArray =MyUIApplication.sectionList.get(i);
					for(int j=0;j<_objArray.size();j++)
					{
						MenuWrapper _obj =	_objArray.get(j);
						MyUIApplication.Menuitems.add(new MenuEntryItem(_obj.title,_obj.imageName,_objArray.get(j)));
					}
				}

				listView.setAdapter(null);
				MenuAdapter adapter = new MenuAdapter(context, MyUIApplication.Menuitems,(int)heightLLTop,(int)widthLLTop);
				listView.setAdapter(adapter);

				listView.setOnItemClickListener(new OnItemClickListener() {

					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) {
						// TODO Auto-generated method stub
						//				MyUIApplication.EventSelected=arg2;
						//				startActivityForResult(MyUIApplication._objEventsDetailIntent, 304);
						//				overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
						//				
						MenuItem i = MyUIApplication.Menuitems.get(arg2);
						if(i.isSection())
						{
						}
						else
						{
							MenuEntryItem ei = (MenuEntryItem)MyUIApplication.Menuitems.get(arg2);;
							MenuWrapper _obj=ei._objMenuWrapper;

							if(_obj.OnClick.substring(12).equals(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1)))
							{
								((Home)context).LLLayoutMenu.setVisibility(View.GONE);
								((Home)context).MenuButton.setVisibility(View.GONE);

								((Home)context).LLTopMenu.removeAllViews();
								((Home)context).LLMiddleMenu.removeAllViews();
								((Home)context).LLBottomMenu.removeAllViews();
							}
							else
							{
								((Home)context).LLLayoutMenu.setVisibility(View.GONE);
								((Home)context).MenuButton.setVisibility(View.GONE);

								((Home)context).LLTopMenu.removeAllViews();
								((Home)context).LLMiddleMenu.removeAllViews();
								((Home)context).LLBottomMenu.removeAllViews();

								listView.setEnabled(false);


								//					MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);

								System.out.println("State Machine"+MyUIApplication.StateMachine);
								if(_obj.OnClick.substring(12).equals("0"))
								{
//									((Home)context).DesignHomeScreen();
									((Home)context).OpenHtmlPage("0","");
								}
								else
								{
									String LastScreen =_obj.OnClick.substring(12);
									MyUIApplication.StateMachine.add(LastScreen);
									((Home)context).OpenHtmlPage(LastScreen,"");
								}
							}
						}
					}
				});

				listView.setVerticalFadingEdgeEnabled(false);
			}
		}
		catch (Exception e) 
		{
			System.out.println(""+e);
		}
	}

	//   Top Bar For Menu
	public void UniversalTopBar(ScreenPartWrapper _objScreenPartWrapper, String Section,final Context context)
	{
		try
		{
		if(Section.equals("Top"))
		{
			double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
			double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
			double widthLLTopPer=widthLLTop/100;
			double heightLLTopPer=heightLLTop/100;

			ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTopMenu.getLayoutParams();
//			params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
			params_LLTop.height=(int)(0);
			params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
			((Home)context).LLTopMenu.setLayoutParams(params_LLTop);
			
			FrameLayout.LayoutParams params_LLTopMargin = (FrameLayout.LayoutParams)((Home)context).LLLayoutMenu.getLayoutParams();
			params_LLTopMargin.topMargin = (int)(heightLLTopPer*((Home)context).deviceHeight);
			((Home)context).LLLayoutMenu.setLayoutParams(params_LLTopMargin);
		}
		else if(Section.equals("Middle"))
		{
			double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
			double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
			double widthLLTopPer=widthLLTop/100;
			double heightLLTopPer=heightLLTop/100;

			ViewGroup.LayoutParams params_LLTop = ((Home)context).LLMiddleMenu.getLayoutParams();
			params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
			params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
			((Home)context).LLMiddleMenu.setLayoutParams(params_LLTop);
			
			FrameLayout.LayoutParams params_LLTopMargin = (FrameLayout.LayoutParams)((Home)context).LLLayoutMenu.getLayoutParams();
			params_LLTopMargin.topMargin = (int)(heightLLTopPer*((Home)context).deviceHeight);
			((Home)context).LLLayoutMenu.setLayoutParams(params_LLTopMargin);
		}
		else if(Section.equals("Bottom"))
		{
			double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
			double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
			double widthLLTopPer=widthLLTop/100;
			double heightLLTopPer=heightLLTop/100;

			ViewGroup.LayoutParams params_LLTop = ((Home)context).LLBottomMenu.getLayoutParams();
			params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
			params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
			((Home)context).LLBottomMenu.setLayoutParams(params_LLTop);
			
			FrameLayout.LayoutParams params_LLTopMargin = (FrameLayout.LayoutParams)((Home)context).LLLayoutMenu.getLayoutParams();
			params_LLTopMargin.topMargin = (int)(heightLLTopPer*((Home)context).deviceHeight);
			((Home)context).LLLayoutMenu.setLayoutParams(params_LLTopMargin);
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in Menu's UniversalTopBar Section -"+Section+e);
		}
	}



	// *** Set AdvertisementBar ****
	public void UniversalAdvertisementBar(ScreenPartWrapper _objScreenPartWrapper, String Section , Context context)
	{
		ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);


		if(Section.equals("Top"))
		{
			double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
			double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
			double widthLLTopPer=widthLLTop/100;
			double heightLLTopPer=heightLLTop/100;

			ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLTopMenu.getLayoutParams();
			params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
			params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
			((Home)context).LLTopMenu.setLayoutParams(params_LLMiddle);


			try
			{
				String topbarfilePath="images/"+_objEW.Bitmap+".png";
				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				((Home)context).LLTopMenu.setBackgroundDrawable(d);

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

			ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddleMenu.getLayoutParams();
			params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
			params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
			((Home)context).LLMiddleMenu.setLayoutParams(params_LLMiddle);


			try
			{
				String topbarfilePath="images/"+_objEW.Bitmap+".png";
				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				((Home)context).LLMiddleMenu.setBackgroundDrawable(d);

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

			ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLBottomMenu.getLayoutParams();
			params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
			params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
			((Home)context).LLBottomMenu.setLayoutParams(params_LLMiddle);


			try
			{
				String topbarfilePath="images/"+_objEW.Bitmap+".png";
				Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
				((Home)context).LLBottomMenu.setBackgroundDrawable(d);

			}
			catch (Exception e) 
			{
				System.out.println("Exception in Setting home Page Top Bar"+e);
			}
		}
	}
}


