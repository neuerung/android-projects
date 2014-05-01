package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.Adapters.HomeAdaptorGrid;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.GridView;


public class UtilGridView 
{
	public static GridView GView;
	Integer column=3;
	ArrayList<ElementWrapper> SortedobjListEW;
	// *** Set Grid View ****
	public void SetGridView(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context)
	{

		ArrayList<ElementWrapper> _objListEW = ((Home)context)._objUtil.getElementWrapperList(_objScreenPartWrapper.ScreenName,Section);

		try {
			SortedobjListEW = new ArrayList<ElementWrapper>();
			for (int i = 0; i < _objListEW.size(); i++) {

				for (int j = 0; j < _objListEW.size(); j++) {
					Integer number = Integer.parseInt(_objListEW.get(j).Number);
					if(number == i+1)
					{
						SortedobjListEW.add(_objListEW.get(j));
					}

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			SortedobjListEW.clear();
			SortedobjListEW = new ArrayList<ElementWrapper>();
			SortedobjListEW = _objListEW;
		}

		if(MyUIApplication.Copy)
		{
			try
			{

				GView= new GridView(context);

				GView.setColumnWidth(GridView.STRETCH_COLUMN_WIDTH);
				GView.setGravity(Gravity.CENTER);

				if(Section.equals("Top"))
				{
					
					try {
						float horizontalSpacing = Float.parseFloat(_objScreenPartWrapper.TophorizontalSpacing.trim())/100f;
						horizontalSpacing = horizontalSpacing*((Home)context).deviceHeight;
						GView.setHorizontalSpacing((int)horizontalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						float verticalSpacing = Float.parseFloat(_objScreenPartWrapper.TopverticalSpacing.trim())/100f;
						verticalSpacing = verticalSpacing*((Home)context).deviceHeight;
						GView.setVerticalSpacing((int)verticalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(GView);


					try {
						column = Integer.parseInt(_objScreenPartWrapper.Topcolumns);
						if(column==0)
							column=3;
						GView.setNumColumns(column);
					} catch (Exception e) {
						// TODO: handle exception
						column=3;
						GView.setNumColumns(3);
					}

					try {
						GView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GView.setBackgroundColor(Color.WHITE);
					}
					
					if(_objScreenPartWrapper.TopbgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(GView, context, _objScreenPartWrapper.TopbgImage, (int)(heightLLTopCopyPer*((Home)context).deviceHeight), (int)(widthLLTopCopyPer*((Home)context).deviceWidth));

					}


					ViewGroup.LayoutParams params_GView = GView.getLayoutParams();
					params_GView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_GView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_GView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					GView.setLayoutParams(params_GView);

					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

					GView.setAdapter(null);
					GView.setAdapter(new HomeAdaptorGrid(context,SortedobjListEW,column,_objScreenPartWrapper.TopverticalSpacing.trim()));
					//					GView.smoothScrollToPosition(MyUIApplication.CurrentScrollPosition);

				}
				else if(Section.equals("Middle"))
				{
					
					
					try {
						float horizontalSpacing = Float.parseFloat(_objScreenPartWrapper.MidhorizontalSpacing.trim())/100f;
						horizontalSpacing = horizontalSpacing*((Home)context).deviceHeight;
						GView.setHorizontalSpacing((int)horizontalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						float verticalSpacing = Float.parseFloat(_objScreenPartWrapper.MidverticalSpacing.trim())/100f;
						verticalSpacing = verticalSpacing*((Home)context).deviceHeight;
						GView.setVerticalSpacing((int)verticalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(GView);


					try {
						column = Integer.parseInt(_objScreenPartWrapper.Midcolumns);
						if(column==0)
							column=3;
						GView.setNumColumns(column);
					} catch (Exception e) {
						// TODO: handle exception
						column=3;
						GView.setNumColumns(3);
					}

					try {
						GView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GView.setBackgroundColor(Color.WHITE);
					}
					
					if(_objScreenPartWrapper.MidbgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(GView, context, _objScreenPartWrapper.MidbgImage, (int)(heightLLTopCopyPer*((Home)context).deviceHeight), (int)(widthLLTopCopyPer*((Home)context).deviceWidth));

					}

					ViewGroup.LayoutParams params_GView = GView.getLayoutParams();
					params_GView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_GView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_GView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					GView.setLayoutParams(params_GView);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					GView.setAdapter(null);
					GView.setAdapter(new HomeAdaptorGrid(context,SortedobjListEW,column,_objScreenPartWrapper.MidverticalSpacing.trim()));
					//					GView.smoothScrollToPosition(MyUIApplication.CurrentScrollPosition);

				}
				else if(Section.equals("Bottom"))
				{
					
					try {
						float horizontalSpacing = Float.parseFloat(_objScreenPartWrapper.BottomhorizontalSpacing.trim())/100f;
						horizontalSpacing = horizontalSpacing*((Home)context).deviceHeight;
						GView.setHorizontalSpacing((int)horizontalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						float verticalSpacing = Float.parseFloat(_objScreenPartWrapper.BottomverticalSpacing.trim())/100f;
						verticalSpacing = verticalSpacing*((Home)context).deviceHeight;
						GView.setVerticalSpacing((int)verticalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(GView);


					try {
						column = Integer.parseInt(_objScreenPartWrapper.Bottomcolumns);
						if(column==0)
							column=3;
						GView.setNumColumns(column);
					} catch (Exception e) {
						// TODO: handle exception
						column=3;
						GView.setNumColumns(3);
					}

					try {
						GView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GView.setBackgroundColor(Color.WHITE);
					}
					
					if(_objScreenPartWrapper.BottombgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(GView, context, _objScreenPartWrapper.BottombgImage, (int)(heightLLTopCopyPer*((Home)context).deviceHeight), (int)(widthLLTopCopyPer*((Home)context).deviceWidth));

					}

					ViewGroup.LayoutParams params_GView = GView.getLayoutParams();
					params_GView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_GView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_GView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					GView.setLayoutParams(params_GView);

					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);


					HomeAdaptorGrid _objAdapter=new HomeAdaptorGrid(context,SortedobjListEW,column,_objScreenPartWrapper.BottomverticalSpacing.trim());
					try
					{
						GView.setAdapter(null);
						GView.setAdapter(_objAdapter);
						//						GView.smoothScrollToPosition(MyUIApplication.CurrentScrollPosition);
					}
					catch (Exception e)
					{
						System.out.println(""+e);
					}
				}
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}

		}
		else if(!MyUIApplication.Copy)
		{
			try
			{
				GridView GView= new GridView(context);
				GView.setBackgroundColor(Color.WHITE);

				GView.setColumnWidth(GridView.STRETCH_COLUMN_WIDTH);
				GView.setGravity(Gravity.CENTER);
				if(Section.equals("Top"))
				{
					
					try {
						float horizontalSpacing = Float.parseFloat(_objScreenPartWrapper.TophorizontalSpacing.trim())/100f;
						horizontalSpacing = horizontalSpacing*((Home)context).deviceHeight;
						GView.setHorizontalSpacing((int)horizontalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						float verticalSpacing = Float.parseFloat(_objScreenPartWrapper.TopverticalSpacing.trim())/100f;
						verticalSpacing = verticalSpacing*((Home)context).deviceHeight;
						GView.setVerticalSpacing((int)verticalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(GView);
					

					try {
						column = Integer.parseInt(_objScreenPartWrapper.Topcolumns);
						if(column==0)
							column=3;
						GView.setNumColumns(column);
					} catch (Exception e) {
						// TODO: handle exception
						column=3;
						GView.setNumColumns(3);
					}


					try {
						GView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GView.setBackgroundColor(Color.WHITE);
					}
					
					if(_objScreenPartWrapper.TopbgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(GView, context, _objScreenPartWrapper.TopbgImage, (int)(heightLLTopPer*((Home)context).deviceHeight), (int)(widthLLTopPer*((Home)context).deviceWidth));

					}

					ViewGroup.LayoutParams params_GView = GView.getLayoutParams();
					params_GView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_GView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_GView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					GView.setLayoutParams(params_GView);

					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

					GView.setAdapter(null);
					GView.setAdapter(new HomeAdaptorGrid(context,SortedobjListEW,column,_objScreenPartWrapper.TopverticalSpacing.trim()));
					//					GView.smoothScrollToPosition(MyUIApplication.CurrentScrollPosition);

				}
				else if(Section.equals("Middle"))
				{
					
					try {
						float horizontalSpacing = Float.parseFloat(_objScreenPartWrapper.MidhorizontalSpacing.trim())/100f;
						horizontalSpacing = horizontalSpacing*((Home)context).deviceHeight;
						GView.setHorizontalSpacing((int)horizontalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						float verticalSpacing = Float.parseFloat(_objScreenPartWrapper.MidverticalSpacing.trim())/100f;
						verticalSpacing = verticalSpacing*((Home)context).deviceHeight;
						GView.setVerticalSpacing((int)verticalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(GView);


					try {
						column = Integer.parseInt(_objScreenPartWrapper.Midcolumns);
						if(column==0)
							column=3;
						GView.setNumColumns(column);
					} catch (Exception e) {
						// TODO: handle exception
						column=3;
						GView.setNumColumns(3);
					}

					try {
						GView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GView.setBackgroundColor(Color.WHITE);
					}
					
					if(_objScreenPartWrapper.MidbgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(GView, context, _objScreenPartWrapper.MidbgImage, (int)(heightLLTopPer*((Home)context).deviceHeight), (int)(widthLLTopPer*((Home)context).deviceWidth));

					}

					ViewGroup.LayoutParams params_GView = GView.getLayoutParams();
					params_GView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_GView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_GView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					GView.setLayoutParams(params_GView);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					GView.setAdapter(null);
					GView.setAdapter(new HomeAdaptorGrid(context,SortedobjListEW,column,_objScreenPartWrapper.MidverticalSpacing.trim()));
					//					GView.smoothScrollToPosition(MyUIApplication.CurrentScrollPosition);

				}
				else if(Section.equals("Bottom"))
				{
					
					
					try {
						float horizontalSpacing = Float.parseFloat(_objScreenPartWrapper.BottomhorizontalSpacing.trim())/100f;
						horizontalSpacing = horizontalSpacing*((Home)context).deviceHeight;
						GView.setHorizontalSpacing((int)horizontalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						float verticalSpacing = Float.parseFloat(_objScreenPartWrapper.BottomverticalSpacing.trim())/100f;
						verticalSpacing = verticalSpacing*((Home)context).deviceHeight;
						GView.setVerticalSpacing((int)verticalSpacing);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(GView);


					try {
						column = Integer.parseInt(_objScreenPartWrapper.Bottomcolumns);
						if(column==0)
							column=3;
						GView.setNumColumns(column);
					} catch (Exception e) {
						// TODO: handle exception
						column=3;
						GView.setNumColumns(3);
					}


					try {
						GView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
					} catch (Exception e) {
						// TODO: handle exception
						GView.setBackgroundColor(Color.WHITE);
					}
					
					if(_objScreenPartWrapper.BottombgImage.trim().length()>0)
					{

						ImageUtil.setBgFromSDCardNotCache(GView, context, _objScreenPartWrapper.BottombgImage, (int)(heightLLTopPer*((Home)context).deviceHeight), (int)(widthLLTopPer*((Home)context).deviceWidth));

					}

					ViewGroup.LayoutParams params_GView = GView.getLayoutParams();
					params_GView = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
							FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
					params_GView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_GView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					GView.setLayoutParams(params_GView);

					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);


					HomeAdaptorGrid _objAdapter=new HomeAdaptorGrid(context,SortedobjListEW,column,_objScreenPartWrapper.BottomverticalSpacing.trim());
					try
					{
						GView.setAdapter(null);
						GView.setAdapter(_objAdapter);
						//					GView.smoothScrollToPosition(MyUIApplication.CurrentScrollPosition);
						//						GView.setSelection(MyUIApplication.CurrentScrollPosition);
					}
					catch (Exception e)
					{
						System.out.println(""+e);
					}
				}
				GView.setOnScrollListener(new OnScrollListener() {

					public void onScrollStateChanged(AbsListView view, int scrollState) {
						// TODO Auto-generated method stub

					}

					public void onScroll(AbsListView view, int firstVisibleItem,
							int visibleItemCount, int totalItemCount) {
						// TODO Auto-generated method stub
						//						MyUIApplication.CurrentScrollPosition = view.getFirstVisiblePosition();
						//					Toast.makeText(context, mCurrentX, Toast.LENGTH_SHORT).show();
						System.out.println("Scrollllllllll    "+MyUIApplication.CurrentScrollPosition);

					}
				});
			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}
		}
		
		
	}
	
	
}
