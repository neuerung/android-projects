package mobi.neuerung.Util;


import java.util.ArrayList;

import mobi.neuerung.Adapters.PictureGaleryCategoryAdapter;
import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.BGThread.PictureGalleryBG;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.PictureGalleryCategoryWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;


public class UtilPictureGalleryCategory {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	public static GridView GridPicture;
	public static String screenNumber;
	ElementWrapper _objEW;

	// **** Set Show Update view for Type 10 *****
	public void SetPictureGaleryCategory(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{
		_objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		 MyUIApplication.globel_instance	=	_objEW.instance;
		 
		 
		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;

		if(_objEW.OnClick.length()>0)
		{
			screenNumber=_objEW.OnClick.substring(12);
		}
		else
		{
			Toast.makeText(context, "OnClick length is less than 12", Toast.LENGTH_SHORT).show();
		}



		if(MyUIApplication.Copy)
		{
			GridPicture= new GridView(context);


			GridPicture.setNumColumns(2);

			try
			{


				if(Section.equals("Top"))
				{

					try {
						GridPicture.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GridPicture.setBackgroundColor(Color.WHITE);
					}

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(GridPicture);

					ViewGroup.LayoutParams params_GridPicture = GridPicture.getLayoutParams();
					params_GridPicture.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_GridPicture.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					GridPicture.setLayoutParams(params_GridPicture);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

				}
				else if(Section.equals("Middle"))
				{

					try {
						GridPicture.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GridPicture.setBackgroundColor(Color.WHITE);
					}

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(GridPicture);



					ViewGroup.LayoutParams params_GridPicture = GridPicture.getLayoutParams();
					params_GridPicture.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_GridPicture.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					GridPicture.setLayoutParams(params_GridPicture);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);


				}
				else if(Section.equals("Bottom"))
				{

					try {
						GridPicture.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GridPicture.setBackgroundColor(Color.WHITE);
					}

					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(GridPicture);

					ViewGroup.LayoutParams params_GridPicture = GridPicture.getLayoutParams();
					params_GridPicture.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_GridPicture.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					GridPicture.setLayoutParams(params_GridPicture);


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
			GridPicture = new GridView(context);

			GridPicture.setNumColumns(2);

			try
			{

				if(Section.equals("Top"))
				{

					try {
						GridPicture.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GridPicture.setBackgroundColor(Color.WHITE);
					}

					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(GridPicture);

					ViewGroup.LayoutParams params_GridPicture = GridPicture.getLayoutParams();
					params_GridPicture.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_GridPicture.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					GridPicture.setLayoutParams(params_GridPicture);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

				}
				else if(Section.equals("Middle"))
				{
					try {
						GridPicture.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GridPicture.setBackgroundColor(Color.WHITE);
					}

					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(GridPicture);

					ViewGroup.LayoutParams params_GridPicture = GridPicture.getLayoutParams();
					params_GridPicture.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_GridPicture.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					GridPicture.setLayoutParams(params_GridPicture);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

				}
				else if(Section.equals("Bottom"))
				{

					try {
						GridPicture.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GridPicture.setBackgroundColor(Color.WHITE);
					}

					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(GridPicture);

					ViewGroup.LayoutParams params_GridPicture = GridPicture.getLayoutParams();
					params_GridPicture.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_GridPicture.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					GridPicture.setLayoutParams(params_GridPicture);


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

		MyUIApplication.PictureGaleryCategoryList = new ArrayList<PictureGalleryCategoryWrapper>();

		MyUIApplication._objPictureGalleryDB.getPGCategoryList();

//		SetAdapterForCategory(context);
//
//		if(MyUIApplication.isInternetAvailable(context))
//		{
//			// For Parsing and getting list of PictureGaleryGrid
//			new PictureGalleryBG(context, "PictureGalleryCategory").execute();
//		}
		

		if(MyUIApplication.checkUpdateCategory){
			
			if(MyUIApplication.isInternetAvailable(context))
			{
				// For Parsing and getting list of PictureGaleryGrid
				new PictureGalleryBG(context, "PictureGalleryCategory").execute();
				MyUIApplication.checkUpdateCategory	=	false;
			}
			
		}else {
			//Directly fill the list
			SetAdapterForCategory(context);
		}
	}

	public void SetAdapterForCategory(Context con)
	{
		try
		{
			MyUIApplication.PictureGaleryCategoryList = new ArrayList<PictureGalleryCategoryWrapper>();

			MyUIApplication._objPictureGalleryDB.getPGCategoryList();

			GridPicture.setAdapter(null);
			PictureGaleryCategoryAdapter adapter = new PictureGaleryCategoryAdapter(con,screenNumber,_objEW);
			GridPicture.setAdapter(adapter);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}


}

