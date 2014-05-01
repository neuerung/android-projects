package mobi.neuerung.Util;

import mobi.neuerung.Adapters.ExhibitorListAdapter;
import mobi.neuerung.BGThread.ExhibitorBgThread;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;



public class UtilExhibitorList {

	public static ListView LView;

	private String scrrenNum="";

	EditText searchText;
	Button refresh;
	Context context;

	// *** Set Grid View ****
	public void SetExhibitorList(ScreenPartWrapper _objScreenPartWrapper, String Section ,final Context context,String ForFilter)
	{
		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);
		this.context = context;

		LinearLayout mainLayout = new LinearLayout(context);
		mainLayout.setOrientation(LinearLayout.VERTICAL);

		FrameLayout searchLayout = new FrameLayout(context);
		searchLayout.setBackgroundResource(R.drawable.search_speaker);

		ImageView searchImage = new ImageView(context);
		searchImage.setClickable(false);

		searchText = new EditText(context);
		searchText.setBackgroundColor(Color.parseColor("#00000000"));



		refresh = new Button(context);


		mainLayout.addView(searchLayout);

		LView= new ListView(context);
		if(MyUIApplication.Copy)
		{
			try
			{
				if(Section.equals("Top"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLTopCopy.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

					String onclick =_objEW.OnClick;
					scrrenNum = _objEW.OnClick.substring(12);

					try
					{
						if(_objScreenPartWrapper.Topbgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}


				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					searchLayout.addView(refresh);
					((Home)context).LLMiddleCopy.addView(mainLayout);
					((Home)context).LLMiddleCopy.addView(LView);





					LinearLayout.LayoutParams params_searchLayout =(LinearLayout.LayoutParams) searchLayout.getLayoutParams();
					params_searchLayout.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.width=(int)(.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchLayout.topMargin=(int)(.02f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.bottomMargin=(int)(.01f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchLayout.leftMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchLayout.rightMargin=(int)(.02f*widthLLTopCopyPer*((Home)context).deviceWidth);
					searchLayout.setLayoutParams(params_searchLayout);

					FrameLayout.LayoutParams params_searchImage =(FrameLayout.LayoutParams) searchImage.getLayoutParams();
					params_searchImage.height=(int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchImage.width=(int)(.08f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchImage.leftMargin=(int)(.023f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchImage.gravity=Gravity.LEFT|Gravity.CENTER_VERTICAL;
					searchImage.setLayoutParams(params_searchImage);

					ImageUtil.setBackgroundBgFromAssetsNotCache(searchImage, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth));

					FrameLayout.LayoutParams params_searchText =(FrameLayout.LayoutParams) searchText.getLayoutParams();
					params_searchText.height=(int)(.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_searchText.width=(int)(.70f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.CENTER|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setHint("Exhibitor Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopCopyPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_refresh =(FrameLayout.LayoutParams) refresh.getLayoutParams();
					params_refresh.height=(int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_refresh.width=(int)(.08f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_refresh.rightMargin=(int)(.024f*widthLLTopCopyPer*((Home)context).deviceWidth);
					params_refresh.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					refresh.setLayoutParams(params_refresh);
					refresh.setBackgroundDrawable(null);
					//					ImageUtil.setBackgroundBgFromAssetsNotCache(refresh, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopCopyPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopCopyPer*((Home)context).deviceWidth));


					FrameLayout.LayoutParams params_LView =(FrameLayout.LayoutParams) LView.getLayoutParams();
					params_LView.height=(int)(.865f*heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					params_LView.gravity=Gravity.BOTTOM;
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					String onclick =_objEW.OnClick;
					scrrenNum = _objEW.OnClick.substring(12);

					try
					{
						if(_objScreenPartWrapper.Midbgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}


				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);


					String onclick =_objEW.OnClick;
					scrrenNum = _objEW.OnClick.substring(12);

					try
					{
						if(_objScreenPartWrapper.Bottombgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}



				}
				LView.setVerticalFadingEdgeEnabled(false);

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
				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);

					String onclick =_objEW.OnClick;
					scrrenNum = _objEW.OnClick.substring(12);

					try
					{
						if(_objScreenPartWrapper.Topbgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Topbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}



				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					searchLayout.addView(searchImage);
					searchLayout.addView(searchText);
					searchLayout.addView(refresh);
					((Home)context).LLMiddle.addView(mainLayout);
					((Home)context).LLMiddle.addView(LView);





					LinearLayout.LayoutParams params_searchLayout =(LinearLayout.LayoutParams) searchLayout.getLayoutParams();
					params_searchLayout.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.width=(int)(.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchLayout.topMargin=(int)(.02f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.bottomMargin=(int)(.01f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchLayout.leftMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchLayout.rightMargin=(int)(.02f*widthLLTopPer*((Home)context).deviceWidth);
					searchLayout.setLayoutParams(params_searchLayout);

					FrameLayout.LayoutParams params_searchImage =(FrameLayout.LayoutParams) searchImage.getLayoutParams();
					params_searchImage.height=(int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchImage.width=(int)(.08f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchImage.leftMargin=(int)(.023f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchImage.gravity=Gravity.LEFT|Gravity.CENTER_VERTICAL;
					searchImage.setLayoutParams(params_searchImage);

					ImageUtil.setBackgroundBgFromAssetsNotCache(searchImage, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopPer*((Home)context).deviceWidth));

					FrameLayout.LayoutParams params_searchText =(FrameLayout.LayoutParams) searchText.getLayoutParams();
					params_searchText.height=(int)(.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_searchText.width=(int)(.70f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_searchText.gravity=Gravity.CENTER|Gravity.CENTER_VERTICAL;
					searchText.setLayoutParams(params_searchText);
					searchText.setHint("Exhibitor Search ");
					searchText.setGravity(Gravity.CENTER_VERTICAL);
					searchText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
							determineTextSize(searchText.getTypeface(),((int)(heightLLTopPer*((Home)context).deviceHeight)*.11f)*(.5f)));


					FrameLayout.LayoutParams params_refresh =(FrameLayout.LayoutParams) refresh.getLayoutParams();
					params_refresh.height=(int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight);
					params_refresh.width=(int)(.08f*.96f*widthLLTopPer*((Home)context).deviceWidth);
					params_refresh.rightMargin=(int)(.024f*widthLLTopPer*((Home)context).deviceWidth);
					params_refresh.gravity=Gravity.RIGHT|Gravity.CENTER_VERTICAL;
					refresh.setLayoutParams(params_refresh);
					refresh.setBackgroundDrawable(null);
					//					ImageUtil.setBackgroundBgFromAssetsNotCache(refresh, context, "images/search.jpg", (int)(.5f*.1f*heightLLTopPer*((Home)context).deviceHeight), (int)(.1f*.96f*widthLLTopPer*((Home)context).deviceWidth));


					FrameLayout.LayoutParams params_LView =(FrameLayout.LayoutParams) LView.getLayoutParams();
					params_LView.height=(int)(.865f*heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					params_LView.gravity=Gravity.BOTTOM;
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					String onclick =_objEW.OnClick;
					scrrenNum = _objEW.OnClick.substring(12);

					try
					{
						if(_objScreenPartWrapper.Midbgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Midbgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}



				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLBottom.addView(LView);

					ViewGroup.LayoutParams params_LView = LView.getLayoutParams();
					params_LView.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LView.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					LView.setLayoutParams(params_LView);

					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);

					try
					{
						if(_objScreenPartWrapper.Bottombgcolor.length()>0)
						{
							LView.setBackgroundColor(Color.parseColor(_objScreenPartWrapper.Bottombgcolor));
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception in Setting List background color"+e);
					}

					String onclick =_objEW.OnClick;
					scrrenNum = _objEW.OnClick.substring(12);
				}
				LView.setVerticalFadingEdgeEnabled(false);

			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}



		}


		LView.setOnItemClickListener(new OnItemClickListener() {



			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				try
				{

					MyUIApplication.exhibitornumbeinList = arg2;

					((Home)context).OpenHtmlPage(scrrenNum,"");

					MyUIApplication.StateMachine.add(scrrenNum);

					((Activity)context).overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );

				}catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});



//		searchText.setOnKeyListener(new OnKeyListener()
//		{
//			public boolean onKey(View v, int keyCode, KeyEvent event)
//			{
//				if (event.getAction() == KeyEvent.ACTION_DOWN)
//				{
//					switch (keyCode)
//					{
//					case KeyEvent.KEYCODE_DPAD_CENTER:
//					case KeyEvent.KEYCODE_ENTER:
//						//	popupbgmain.setVisibility(View.GONE);
//						LView.setEnabled(true);
//						InputMethodManager imm = (InputMethodManager) context.getSystemService(
//								Context.INPUT_METHOD_SERVICE);
//						imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
//
//						if(searchText.getText().toString().length()!=0)
//						{
//							filterTextWise(searchText.getText().toString());
//							searchText.setText("");
//						}
//						InputMethodManager imm1 = (InputMethodManager) context.getSystemService(
//								Context.INPUT_METHOD_SERVICE);
//						imm1.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
//						return true;
//					default:
//						break;
//					}
//				}
//				return false;
//			}
//		});
		

		searchText.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(s.toString().length()==0)
				{
					fillList(code,false,context);
				}
				else
				{
				 _objExhibitorListAdapter.getFilter().filter(s.toString());
				}
			}

			public void beforeTextChanged(CharSequence s, int start,
					int count, int after) {
				// TODO Auto-generated method stub
				
			}

			public void onTextChanged(CharSequence s, int start,
					int before, int count) {
				// TODO Auto-generated method stub
				 
			}
		     
		  
			
		});


		LView.setBackgroundColor(Color.WHITE);
		//		LView.setAdapter(new HomeAdaptorList(context));

		new ExhibitorBgThread(context,"",ForFilter).execute();
	}
	static ExhibitorListAdapter _objExhibitorListAdapter;
	static String code="-1";
	public void fillList(String forParser,Boolean isRefresh,final Context context)
	{
		try {

			code =forParser;
			String aa[] = forParser.split("##");

			if(aa.length==2)
			{
				if(aa[0].equals("P103"))
				{
					String hallNo[] =aa[1].split(" ");

					if(hallNo.length==2)
					{
						MyUIApplication._objMyExhiDB.getMyExhiListFilterByHall(hallNo[1]);
					}
				}
				else if(aa[0].equals("P104"))
				{
					MyUIApplication._objMyExhiDB.getMyExhiListFilterBySectiom(aa[1]);
				}

				else if(aa[0].equals("P102"))
				{
					MyUIApplication._objMyExhiDB.getMyExhiListFilterByNewExhibitor(aa[1]);
				}

				else if(aa[0].equals("P108"))
				{
					MyUIApplication._objMyExhiDB.getMyExhiListFilterByProductCategory(aa[1]);
				}

			}


			if(forParser.equals("P106"))
			{
				MyUIApplication._objMyExhiDB.getMyExhiListFilterByFavourites("1");
			}
			else if(forParser.equals("P107"))
			{
				MyUIApplication._objMyExhiDB.getMyExhiListFilterByVisited("1");
			}

			else if(forParser.equals("P105"))
			{
				MyUIApplication._objMyExhiDB.getMyExhiListFilterByProductCategoryCode(MyUIApplication.exhibitorproductName);
			}

			else if(forParser.equals("Note"))
			{
				MyUIApplication._objMyExhiDB.getMyExhiListFilterByNote("1");
			}

			else if(forParser.startsWith("EDIT"))
			{
				MyUIApplication._objMyExhiDB.getMyExhiListFilterByEditext(forParser.substring(4));
			}
			else if(forParser.equals("P101"))
			{
				MyUIApplication._objMyExhiDB.getMyExhiListFilterByAlphabetic();
			}



			_objExhibitorListAdapter=new ExhibitorListAdapter((Activity) context, R.layout.exhibitoritems);


			LView.setAdapter(null);
			LView.setAdapter(_objExhibitorListAdapter);    

			_objExhibitorListAdapter.notifyDataSetChanged();




		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
