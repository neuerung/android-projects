package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.MenuWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import mobi.neuerung.Wrapper.ScreenWrapper;


public class Util
{
	//  Calling From Home.
	public ScreenWrapper getScreenWrapperFromDB(String ScreenNumber)
	{
		ScreenWrapper _obj = new ScreenWrapper();
		for(int i =0 ; i<MyUIApplication._objScreenPartWrappersList.size(); i++)
		{
			if(MyUIApplication._objScreenWrappersList.get(i).Number.equals(ScreenNumber))
			{

				_obj=MyUIApplication._objScreenWrappersList.get(i);

			}
		}
		return _obj;


		//  *** it is for DB *****
		//		return MyUIApplication._objScreenPartDB.getScreenPartWrapper(ScreenNumber);

	}
	//  Calling From Home.
	public ScreenPartWrapper getScreenPartWrapper(String ScreenNumber)
	{
		ScreenPartWrapper _obj = new ScreenPartWrapper();
		for(int i =0 ; i<MyUIApplication._objScreenPartWrappersList.size(); i++)
		{
			if(MyUIApplication._objScreenPartWrappersList.get(i).ScreenName.equals(ScreenNumber))
			{
				
				_obj=MyUIApplication._objScreenPartWrappersList.get(i);
				
			}
		}
		return _obj;
		
		
		//  *** it is for DB *****
		//		return MyUIApplication._objScreenPartDB.getScreenPartWrapper(ScreenNumber);
		
	}

	//  Calling From Home.
	public ElementWrapper getElementWrapperFromDB(String ScreenName , String Section)
	{

		ElementWrapper _obj = new ElementWrapper();
		for(int i =0 ; i<MyUIApplication._objElementWrapperList.size(); i++)
		{
			if(MyUIApplication._objElementWrapperList.get(i).ScreenName.equals(ScreenName))
			{
				if(MyUIApplication._objElementWrapperList.get(i).Section.equals(Section))
				{
					_obj=MyUIApplication._objElementWrapperList.get(i);
				}

			}
		}
		return _obj;


		//  *** it is for DB *****
		//		return MyUIApplication._objElementDB.getTopBarWrapper(ScreenName,Section);
	}

	//  Calling From Home.SetGridView()
	public ArrayList<ElementWrapper> getElementWrapperList(String ScreenName , String Section)
	{
		ArrayList<ElementWrapper> _objList= new ArrayList<ElementWrapper>();

		for(int i =0 ; i<MyUIApplication._objElementWrapperList.size(); i++)
		{
			//			ElementWrapper _obj= new ElementWrapper();
			if(MyUIApplication._objElementWrapperList.get(i).ScreenName.equals(ScreenName))
			{
				if(MyUIApplication._objElementWrapperList.get(i).Section.equals(Section))
				{
					_objList.add(MyUIApplication._objElementWrapperList.get(i));
				}

			}
		}
		return _objList;


		//  *** it is for DB *****
		//		return MyUIApplication._objElementDB.getElementWrapperList(ScreenName,Section);
	}

	public void getMenuListAccordingType(String ButtonType)
	{

		try
		{
			//		String query="SELECT * FROM Element where Type='"+ButtonType+"'";

			ArrayList<MenuWrapper> myTemplist = new ArrayList<MenuWrapper>();
			for(int i =0 ; i<MyUIApplication._objElementWrapperList.size(); i++)
			{

				if(MyUIApplication._objElementWrapperList.get(i).Type.equals(ButtonType))
				{
					int idint=0;
					MenuWrapper _obj = new MenuWrapper();
					_obj.id=""+idint;
					idint++;


					_obj.imageName=MyUIApplication._objElementWrapperList.get(i).Bitmap;
					_obj.title=MyUIApplication._objElementWrapperList.get(i).Title;
					_obj.ScreenName=MyUIApplication._objElementWrapperList.get(i).ScreenName;
					_obj.OnClick=MyUIApplication._objElementWrapperList.get(i).OnClick;
					_obj.width=MyUIApplication._objElementWrapperList.get(i).width;
					_obj.height=MyUIApplication._objElementWrapperList.get(i).height;


					myTemplist.add(_obj);
					_obj= null;

				}
			}
			MyUIApplication.sectionList.add(myTemplist);
			int l =MyUIApplication.sectionList.size();
			System.out.println(""+l);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(""+e);
		}

	}
	public void getMenuList(String Section)
	{


		getTypesList(Section);


		try
		{
			MyUIApplication.sectionList = null;
			MyUIApplication.sectionList =new ArrayList<ArrayList<MenuWrapper>>();
			for(int i=0;i<MyUIApplication.TypeWisesectionList.size();i++)
			{
				System.out.println(MyUIApplication.TypeWisesectionList.get(i));
				getMenuListAccordingType(MyUIApplication.TypeWisesectionList.get(i));
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println(""+e);
		}

	}

	public void getTypesList(String Section)
	{
		try
		{


			MyUIApplication.TypeWisesectionList = null;
			MyUIApplication.TypeWisesectionList = new ArrayList<String>();

			//			String query="SELECT Type FROM Button where ScreenName ='1'  group by Type ";       // order by SUBSTR(date_time ,0,11) desc";

			for(int i =0 ; i<MyUIApplication._objElementWrapperList.size(); i++)
			{
				if(MyUIApplication._objElementWrapperList.get(i).Section.equals(Section))
				{
					if(MyUIApplication._objElementWrapperList.get(i).ScreenName.equals("50"))
					{
						if(!MyUIApplication.TypeWisesectionList.contains(MyUIApplication._objElementWrapperList.get(i).Type))
						{
							MyUIApplication.TypeWisesectionList.add(MyUIApplication._objElementWrapperList.get(i).Type);
						}
					}
				}

			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(""+e);
		}


		//		dbAdapter.getTypeOfSection(query, null);


	}






}
