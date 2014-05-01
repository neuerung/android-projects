package mobi.neuerung.Util;

import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ExhibitorDirectoryWrapper;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;






public class UtilExhibitorDetails {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;

	String scrrenNumString="";
	private ExhibitorDirectoryWrapper _objExhibitorDirectoryWrapper;

	// **** Set Show Update view for Type 28 *****
	public void SetExhibitorDetails(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{
		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;


		if(MyUIApplication.exhibitornumbeinList !=-1)
		{
			_objExhibitorDirectoryWrapper = MyUIApplication._objExhibitorDirectoryList.get(MyUIApplication.exhibitornumbeinList);
		}
		else
		{
			return;
		}


		LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		ScrollView layout =(ScrollView) vi.inflate(R.layout.exhibitor_details,null);
		layout.setBackgroundColor(Color.WHITE);

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

					((Home)context).LLTopCopy.addView(layout);

					createPage(layout,widthLLTopCopyPer,heightLLTopCopyPer);

					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLMiddleCopy.addView(layout);

					createPage(layout,widthLLTopCopyPer,heightLLTopCopyPer);


					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;

					((Home)context).LLBottomCopy.addView(layout);

					createPage(layout,widthLLTopCopyPer,heightLLTopCopyPer);

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
			try
			{

				if(Section.equals("Top"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.TopWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.TopHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLTop.addView(layout);

					createPage(layout,widthLLTopPer,heightLLTopPer);



					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);
					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLMiddle.addView(layout);

					createPage(layout,widthLLTopPer,heightLLTopPer);

					ViewGroup.LayoutParams params_LLMiddle = ((Home)context).LLMiddle.getLayoutParams();
					params_LLMiddle.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLMiddle.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLMiddle.setLayoutParams(params_LLMiddle);

					String onclick =_objEW.OnClick;
					scrrenNumString = _objEW.OnClick.substring(12);


				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;

					((Home)context).LLBottom.addView(layout);

					createPage(layout,widthLLTopPer,heightLLTopPer);

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
	}


	private void createPage(ViewGroup viewGroup,final double width,final double height)
	{
		TextView heading =(TextView) viewGroup.findViewById(R.id.heading);

		ViewGroup.LayoutParams params_LLBottom = heading.getLayoutParams();
		params_LLBottom.height=(int)(.1f*height*((Home)context).deviceHeight);
		params_LLBottom.width=(int)(width*((Home)context).deviceWidth);
		heading.setLayoutParams(params_LLBottom);

		heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(heading.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));

		heading.setText("Agarwal & Co.");


		LinearLayout topButtonLinear = (LinearLayout) viewGroup.findViewById(R.id.topButtonLinear);

		LinearLayout.LayoutParams params_topButtonLinear =(LinearLayout.LayoutParams) topButtonLinear.getLayoutParams();
		params_topButtonLinear.height=(int)(.1f*height*((Home)context).deviceHeight);
		params_topButtonLinear.topMargin=(int)(.03f*height*((Home)context).deviceHeight);
		params_topButtonLinear.width=(int)(width*((Home)context).deviceWidth);
		//		params_topButtonLinear.leftMargin=(int)(.08f*width*((Home)context).deviceWidth);
		//		params_topButtonLinear.rightMargin=(int)(.08f*width*((Home)context).deviceWidth);
		topButtonLinear.setLayoutParams(params_topButtonLinear);


		final Button bookmark_btn =(Button) viewGroup.findViewById(R.id.bookmark_btn);

		LinearLayout.LayoutParams params_bookmark_btn =(LinearLayout.LayoutParams) bookmark_btn.getLayoutParams();
		params_bookmark_btn.height=(int)(.08f*height*((Home)context).deviceHeight);
		params_bookmark_btn.width=(int)(.14f*width*((Home)context).deviceWidth);
		bookmark_btn.setLayoutParams(params_bookmark_btn);

		ImageUtil.setBackgroundBgFromAssetsNotCache(bookmark_btn, context,"images/bookmark_nonsel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));

		final	Button visited_btn =(Button) viewGroup.findViewById(R.id.visited_btn);

		LinearLayout.LayoutParams params_visited_btnn =(LinearLayout.LayoutParams) visited_btn.getLayoutParams();
		params_visited_btnn.height=(int)(.08f*height*((Home)context).deviceHeight);
		params_visited_btnn.width=(int)(.14f*width*((Home)context).deviceWidth);
		params_visited_btnn.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		visited_btn.setLayoutParams(params_visited_btnn);

		ImageUtil.setBackgroundBgFromAssetsNotCache(visited_btn, context,"images/visited_nonsel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));

		Button locate_btn =(Button) viewGroup.findViewById(R.id.locate_btn);

		LinearLayout.LayoutParams params_locate_btnn =(LinearLayout.LayoutParams) locate_btn.getLayoutParams();
		params_locate_btnn.height=(int)(.08f*height*((Home)context).deviceHeight);
		params_locate_btnn.width=(int)(.14f*width*((Home)context).deviceWidth);
		params_locate_btnn.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		locate_btn.setLayoutParams(params_locate_btnn);

		ImageUtil.setBackgroundBgFromAssetsNotCache(locate_btn, context,"images/locate.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));

		Button getDirection_btn =(Button) viewGroup.findViewById(R.id.getDirection_btn);

		LinearLayout.LayoutParams params_getDirection_btnn =(LinearLayout.LayoutParams) getDirection_btn.getLayoutParams();
		params_getDirection_btnn.height=(int)(.08f*height*((Home)context).deviceHeight);
		params_getDirection_btnn.width=(int)(.14f*width*((Home)context).deviceWidth);
		params_getDirection_btnn.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		getDirection_btn.setLayoutParams(params_getDirection_btnn);

		ImageUtil.setBackgroundBgFromAssetsNotCache(getDirection_btn, context,"images/getdirection_nonsel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));



		TextView locationText =(TextView) viewGroup.findViewById(R.id.locationText);

		locationText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(locationText.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.6f)));

		locationText.setText("Location");
		locationText.setPadding((int)(.04f*width*((Home)context).deviceWidth), 0, 0, 0);


		FrameLayout locationValueFrame = (FrameLayout) viewGroup.findViewById(R.id.locationValueFrame);

		LinearLayout.LayoutParams params_locationValueFrame =(LinearLayout.LayoutParams) locationValueFrame.getLayoutParams();
		params_locationValueFrame.topMargin=(int)(.01f*height*((Home)context).deviceHeight);
		params_locationValueFrame.width=(int)(.92f*width*((Home)context).deviceWidth);
		params_locationValueFrame.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		params_locationValueFrame.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		locationValueFrame.setLayoutParams(params_locationValueFrame);


		TextView locationValue =(TextView) viewGroup.findViewById(R.id.locationValue);

		locationValue.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(locationValue.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));

		locationValue.setPadding((int)(.02f*width*((Home)context).deviceWidth), ((int)(.02f*width*((Home)context).deviceWidth)),
				((int)(.02f*width*((Home)context).deviceWidth)),((int)(.02f*width*((Home)context).deviceWidth)));


		TextView exhibitorName =(TextView) viewGroup.findViewById(R.id.exhibitorName);

		LinearLayout.LayoutParams params_exhibitorName =(LinearLayout.LayoutParams) exhibitorName.getLayoutParams();
		params_exhibitorName.topMargin=(int)(.03f*height*((Home)context).deviceHeight);
		params_exhibitorName.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		params_exhibitorName.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		exhibitorName.setLayoutParams(params_exhibitorName);

		exhibitorName.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(exhibitorName.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.6f)));


		LinearLayout exhibitorDetailLinear = (LinearLayout) viewGroup.findViewById(R.id.exhibitorDetailLinear);

		LinearLayout.LayoutParams params_exhibitorDetailLinearr =(LinearLayout.LayoutParams) exhibitorDetailLinear.getLayoutParams();
		params_exhibitorDetailLinearr.topMargin=(int)(.03f*height*((Home)context).deviceHeight);
		params_exhibitorDetailLinearr.width=(int)(.92f*width*((Home)context).deviceWidth);
		params_exhibitorDetailLinearr.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		params_exhibitorDetailLinearr.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		exhibitorDetailLinear.setLayoutParams(params_exhibitorDetailLinearr);


		FrameLayout phoneFrame = (FrameLayout) viewGroup.findViewById(R.id.phoneFrame);

		LinearLayout.LayoutParams params_phoneFrame =(LinearLayout.LayoutParams) phoneFrame.getLayoutParams();
		params_phoneFrame.topMargin=(int)(.01f*height*((Home)context).deviceHeight);
		params_phoneFrame.bottomMargin=(int)(.01f*height*((Home)context).deviceHeight);
		phoneFrame.setLayoutParams(params_phoneFrame);


		TextView phoneText =(TextView) viewGroup.findViewById(R.id.phoneText);

		phoneText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(phoneText.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		phoneText.setPadding((int)(.02f*width*((Home)context).deviceWidth), 0, 0, 0);

		TextView phoneValue =(TextView) viewGroup.findViewById(R.id.phoneValue);

		phoneValue.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(phoneValue.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		phoneValue.setPadding(0, 0,(int)(.02f*width*((Home)context).deviceWidth), 0);

		FrameLayout eamilFrame = (FrameLayout) viewGroup.findViewById(R.id.eamilFrame);

		LinearLayout.LayoutParams params_eamilFrame =(LinearLayout.LayoutParams) eamilFrame.getLayoutParams();
		params_eamilFrame.topMargin=(int)(.01f*height*((Home)context).deviceHeight);
		params_eamilFrame.bottomMargin=(int)(.01f*height*((Home)context).deviceHeight);
		eamilFrame.setLayoutParams(params_eamilFrame);


		TextView eamilText =(TextView) viewGroup.findViewById(R.id.eamilText);

		eamilText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(eamilText.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		eamilText.setPadding((int)(.02f*width*((Home)context).deviceWidth), 0, 0, 0);

		TextView eamilValue =(TextView) viewGroup.findViewById(R.id.eamilValue);

		eamilValue.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(eamilValue.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		eamilValue.setPadding(0, 0,(int)(.02f*width*((Home)context).deviceWidth), 0);

		FrameLayout addressFrame = (FrameLayout) viewGroup.findViewById(R.id.addressFrame);

		LinearLayout.LayoutParams params_addressFrame =(LinearLayout.LayoutParams) addressFrame.getLayoutParams();
		params_addressFrame.topMargin=(int)(.01f*height*((Home)context).deviceHeight);
		params_addressFrame.bottomMargin=(int)(.01f*height*((Home)context).deviceHeight);
		addressFrame.setLayoutParams(params_addressFrame);


		TextView addressText =(TextView) viewGroup.findViewById(R.id.addressText);

		addressText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(addressText.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		addressText.setPadding((int)(.02f*width*((Home)context).deviceWidth), 0, 0, 0);

		TextView addressValue =(TextView) viewGroup.findViewById(R.id.addressValue);
		addressValue.getLayoutParams().width=(int)(.55f*width*((Home)context).deviceWidth);
		addressValue.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(addressValue.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		addressValue.setPadding(0, 0,(int)(.02f*width*((Home)context).deviceWidth), 0);




		TextView productCode =(TextView) viewGroup.findViewById(R.id.productCode);

		LinearLayout.LayoutParams params_productCode =(LinearLayout.LayoutParams) productCode.getLayoutParams();
		params_productCode.topMargin=(int)(.03f*height*((Home)context).deviceHeight);
		params_productCode.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		params_productCode.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		productCode.setLayoutParams(params_productCode);

		productCode.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(productCode.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.6f)));




		LinearLayout noteTextLinear = (LinearLayout) viewGroup.findViewById(R.id.noteTextLinear);

		LinearLayout.LayoutParams params_noteTextLinear =(LinearLayout.LayoutParams) noteTextLinear.getLayoutParams();
		params_noteTextLinear.topMargin=(int)(.03f*height*((Home)context).deviceHeight);
		params_noteTextLinear.width=(int)(.92f*width*((Home)context).deviceWidth);
		params_noteTextLinear.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		params_noteTextLinear.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		noteTextLinear.setLayoutParams(params_noteTextLinear);


		Button Addnote_btn =(Button) viewGroup.findViewById(R.id.Addnote_btn);

		LinearLayout.LayoutParams params_Addnote_btn =(LinearLayout.LayoutParams) Addnote_btn.getLayoutParams();
		params_Addnote_btn.height=(int)(.08f*height*((Home)context).deviceHeight);
		params_Addnote_btn.width=(int)(.08f*height*((Home)context).deviceHeight);
		params_Addnote_btn.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		Addnote_btn.setLayoutParams(params_Addnote_btn);

		ImageUtil.setBackgroundBgFromAssetsNotCache(Addnote_btn, context,"images/plus_Button.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.08f*height*((Home)context).deviceHeight));



		TextView noteText =(TextView) viewGroup.findViewById(R.id.noteText);
		noteText.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(noteText.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.6f)));

		LinearLayout notesLinear = (LinearLayout) viewGroup.findViewById(R.id.notesLinear);

		LinearLayout.LayoutParams params_notesLinear =(LinearLayout.LayoutParams) notesLinear.getLayoutParams();
		params_notesLinear.height=(int)(.3f*height*((Home)context).deviceHeight);
		params_notesLinear.topMargin=(int)(.01f*height*((Home)context).deviceHeight);
		params_notesLinear.width=(int)(.92f*width*((Home)context).deviceWidth);
		params_notesLinear.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		params_notesLinear.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		notesLinear.setLayoutParams(params_notesLinear);

		LinearLayout appoinmentTextLinear = (LinearLayout) viewGroup.findViewById(R.id.appoinmentTextLinear);

		LinearLayout.LayoutParams params_appoinmentTextLinear =(LinearLayout.LayoutParams) appoinmentTextLinear.getLayoutParams();
		params_appoinmentTextLinear.topMargin=(int)(.03f*height*((Home)context).deviceHeight);
		params_appoinmentTextLinear.width=(int)(.92f*width*((Home)context).deviceWidth);
		params_appoinmentTextLinear.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		params_appoinmentTextLinear.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		appoinmentTextLinear.setLayoutParams(params_appoinmentTextLinear);


		Button Addappoinment_btn =(Button) viewGroup.findViewById(R.id.Addappoinment_btn);

		LinearLayout.LayoutParams params_Addappoinment_btn =(LinearLayout.LayoutParams) Addappoinment_btn.getLayoutParams();
		params_Addappoinment_btn.height=(int)(.08f*height*((Home)context).deviceHeight);
		params_Addappoinment_btn.width=(int)(.08f*height*((Home)context).deviceHeight);
		params_Addappoinment_btn.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		Addappoinment_btn.setLayoutParams(params_Addappoinment_btn);

		ImageUtil.setBackgroundBgFromAssetsNotCache(Addappoinment_btn, context,"images/plus_Button.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.08f*height*((Home)context).deviceHeight));



		TextView appoinmentText1 =(TextView) viewGroup.findViewById(R.id.appoinmentText);
		appoinmentText1.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(appoinmentText1.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.6f)));

		LinearLayout appoinmentsLinear = (LinearLayout) viewGroup.findViewById(R.id.appoinmentsLinear);

		LinearLayout.LayoutParams params_appoinmentsLinear =(LinearLayout.LayoutParams) appoinmentsLinear.getLayoutParams();
		params_appoinmentsLinear.height=(int)(.3f*height*((Home)context).deviceHeight);
		params_appoinmentsLinear.topMargin=(int)(.01f*height*((Home)context).deviceHeight);
		params_appoinmentsLinear.bottomMargin=(int)(.05f*height*((Home)context).deviceHeight);
		params_appoinmentsLinear.width=(int)(.92f*width*((Home)context).deviceWidth);
		params_appoinmentsLinear.leftMargin=(int)(.04f*width*((Home)context).deviceWidth);
		params_appoinmentsLinear.rightMargin=(int)(.04f*width*((Home)context).deviceWidth);
		appoinmentsLinear.setLayoutParams(params_appoinmentsLinear);



		if(_objExhibitorDirectoryWrapper != null)
		{

			ArrayList<String> _ob = _objExhibitorDirectoryWrapper.boothList;
			String st = "";
			for(int i =0;i<_ob.size();i++)
			{
				if(_ob.get(i).length()>0)
					st =st.concat( _ob.get(i)+", ");
			}


			heading.setText(_objExhibitorDirectoryWrapper.name);
			locationValue.setText("(Hall "+_objExhibitorDirectoryWrapper.hall+") "+st.substring(0,st.lastIndexOf(",")));
			exhibitorName.setText(_objExhibitorDirectoryWrapper.contact_person);
			phoneValue.setText(_objExhibitorDirectoryWrapper.phone);
			eamilValue.setText(_objExhibitorDirectoryWrapper.email);
			addressValue.setText(_objExhibitorDirectoryWrapper.address);

			if(_objExhibitorDirectoryWrapper.CategoryName.trim().length()>0)
			{
				productCode.setText("Product Code : "+_objExhibitorDirectoryWrapper.CategoryName);


				productCode.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						MyUIApplication.exhibitorproductName=_objExhibitorDirectoryWrapper.CategoryCode;

						((Home)context).OpenHtmlPage(scrrenNumString,"");
						MyUIApplication.StateMachine.add(scrrenNumString);

					}
				});
			}
			if(_objExhibitorDirectoryWrapper.Favourites.equals("0"))
			{
				ImageUtil.setBackgroundBgFromAssetsNotCache(bookmark_btn, context,"images/bookmark_nonsel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));
			}
			else if(_objExhibitorDirectoryWrapper.Favourites.equals("1"))
			{
				ImageUtil.setBackgroundBgFromAssetsNotCache(bookmark_btn, context,"images/bookmark_sel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));
			}

			if(_objExhibitorDirectoryWrapper.Visited.equals("0"))
			{
				ImageUtil.setBackgroundBgFromAssetsNotCache(visited_btn, context,"images/visited_nonsel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));
			}
			else if(_objExhibitorDirectoryWrapper.Visited.equals("1"))
			{
				ImageUtil.setBackgroundBgFromAssetsNotCache(visited_btn, context,"images/visited_sel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));
			}


			bookmark_btn.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub

					MyUIApplication._objMyExhiDB.addFavourite(_objExhibitorDirectoryWrapper.exhibitor_id,_objExhibitorDirectoryWrapper.Favourites);

					if(_objExhibitorDirectoryWrapper.Favourites.equals("0"))
					{
						_objExhibitorDirectoryWrapper.Favourites="1";
						ImageUtil.setBackgroundBgFromAssetsNotCache(bookmark_btn, context,"images/bookmark_sel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));
					}
					else if(_objExhibitorDirectoryWrapper.Favourites.equals("1"))
					{
						_objExhibitorDirectoryWrapper.Favourites="0";
						ImageUtil.setBackgroundBgFromAssetsNotCache(bookmark_btn, context,"images/bookmark_nonsel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));
					}
				}
			});

			visited_btn.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub

					MyUIApplication._objMyExhiDB.addVisited(_objExhibitorDirectoryWrapper.exhibitor_id,_objExhibitorDirectoryWrapper.Visited);

					if(_objExhibitorDirectoryWrapper.Visited.equals("0"))
					{
						_objExhibitorDirectoryWrapper.Visited="1";
						ImageUtil.setBackgroundBgFromAssetsNotCache(visited_btn, context,"images/visited_sel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));
					}
					else if(_objExhibitorDirectoryWrapper.Visited.equals("1"))
					{
						_objExhibitorDirectoryWrapper.Visited="0";
						ImageUtil.setBackgroundBgFromAssetsNotCache(visited_btn, context,"images/visited_nonsel.png",(float)(.08f*height*((Home)context).deviceHeight),(int)(.14f*width*((Home)context).deviceWidth));
					}
				}
			});


		}


	}

}
