package mobi.neuerung.Util;


import java.util.ArrayList;

import mobi.neuerung.Adapters.AwesomeAdapter;
import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.FriendsListWrapper;
import mobi.neuerung.Wrapper.Message;
import mobi.neuerung.Wrapper.ScreenPartWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;



public class UtilFriendsDetail {


	ScreenPartWrapper _objScreenPartWrapper;
	String Section="";
	Context context;
	FriendsListWrapper _objFriendsListWrapper=null;
	String scrrenNumString="";

	// **** Set Show Update view for Type 10 *****
	public void SetFriendsDetail(ScreenPartWrapper _objScreenPartWrapper, String Section , final Context context, String UrlLink)
	{

		final ElementWrapper _objEW = ((Home)context)._objUtil.getElementWrapperFromDB(_objScreenPartWrapper.ScreenName,Section);

		this._objScreenPartWrapper=_objScreenPartWrapper;
		this.Section=Section;
		this.context=context;



		LinearLayout mainLayout = new LinearLayout(context);
		mainLayout.setOrientation(LinearLayout.VERTICAL);








		if(UrlLink.length()>0)
		{
			_objFriendsListWrapper = MyUIApplication._objFriendsListDB.getRecord(UrlLink);

			if(_objFriendsListWrapper !=null)
			{
				try {
					((Home)context)._objUtilTopBar.Heading.setText(_objFriendsListWrapper.Name.trim());
				} catch (Exception e) {
					// TODO: handle exception
				}


			}

		}
		else
		{
			return;
		}


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


					((Home)context).LLTopCopy.addView(mainLayout);



					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);


					ViewGroup.LayoutParams params_LLTopCopy = ((Home)context).LLTopCopy.getLayoutParams();
					params_LLTopCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLTopCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLTopCopy.setLayoutParams(params_LLTopCopy);

					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
					scrrenNumString = _objEW.OnClick.substring(12);

				}
				else if(Section.equals("Middle"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLMiddleCopy.addView(mainLayout);


					createPage(mainLayout, widthLLTopCopyPer, heightLLTopCopyPer);
					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);


					ViewGroup.LayoutParams params_LLMiddleCopy = ((Home)context).LLMiddleCopy.getLayoutParams();
					params_LLMiddleCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLMiddleCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLMiddleCopy.setLayoutParams(params_LLMiddleCopy);

					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
					scrrenNumString = _objEW.OnClick.substring(12);
					System.out.println("QQQQQQQQ.. ...  ...  "+scrrenNumString);
				}
				else if(Section.equals("Bottom"))
				{
					double widthLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomWidth);
					double heightLLTopCopy=Double.parseDouble(_objScreenPartWrapper.BottomHeight);
					double widthLLTopCopyPer=widthLLTopCopy/100;
					double heightLLTopCopyPer=heightLLTopCopy/100;


					((Home)context).LLBottomCopy.addView(mainLayout);

					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);



					ViewGroup.LayoutParams params_LLBottomCopy = ((Home)context).LLBottomCopy.getLayoutParams();
					params_LLBottomCopy.height=(int)(heightLLTopCopyPer*((Home)context).deviceHeight);
					params_LLBottomCopy.width=(int)(widthLLTopCopyPer*((Home)context).deviceWidth);
					((Home)context).LLBottomCopy.setLayoutParams(params_LLBottomCopy);


					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
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

					((Home)context).LLTop.addView(mainLayout);


					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);


					ViewGroup.LayoutParams params_LLTop = ((Home)context).LLTop.getLayoutParams();
					params_LLTop.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLTop.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLTop.setLayoutParams(params_LLTop);


					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
					scrrenNumString = _objEW.OnClick.substring(12);

					System.out.println("QQQQQQQQ.. ...  ...  "+scrrenNumString);
				}
				else if(Section.equals("Middle"))
				{
					double widthLLTop=Double.parseDouble(_objScreenPartWrapper.MidWidth);
					double heightLLTop=Double.parseDouble(_objScreenPartWrapper.MidHeight);
					double widthLLTopPer=widthLLTop/100;
					double heightLLTopPer=heightLLTop/100;


					((Home)context).LLMiddle.addView(mainLayout);

					createPage(mainLayout, widthLLTopPer, heightLLTopPer);
					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);



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


					((Home)context).LLBottom.addView(mainLayout);




					ViewGroup.LayoutParams params_mainLayout = mainLayout.getLayoutParams();
					params_mainLayout.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_mainLayout.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					mainLayout.setLayoutParams(params_mainLayout);


					ViewGroup.LayoutParams params_LLBottom = ((Home)context).LLBottom.getLayoutParams();
					params_LLBottom.height=(int)(heightLLTopPer*((Home)context).deviceHeight);
					params_LLBottom.width=(int)(widthLLTopPer*((Home)context).deviceWidth);
					((Home)context).LLBottom.setLayoutParams(params_LLBottom);



					String onclick =_objEW.OnClick;
					System.out.println("WWWWWW.. ...  ...  "+onclick);
					scrrenNumString = _objEW.OnClick.substring(12);

				}




			}
			catch (Exception e) 
			{
				System.out.println(""+e);
			}


		}

	}


	private void createPage(ViewGroup viewGroup,double width, double height)
	{

		LinearLayout layout1 = new LinearLayout(context);
		layout1.setOrientation(LinearLayout.HORIZONTAL);

		viewGroup.addView(layout1);

		ImageView userImage = new ImageView(context);
		userImage.setImageResource(R.drawable.default_image);


		LinearLayout userDetailsLinear = new LinearLayout(context);
		userDetailsLinear.setOrientation(LinearLayout.VERTICAL);


		layout1.addView(userImage);
		layout1.addView(userDetailsLinear);

		LinearLayout.LayoutParams params_layout1 =(LinearLayout.LayoutParams) layout1.getLayoutParams();
		params_layout1.width =(int)(.96f*width*((Home)context).deviceWidth);
		params_layout1.leftMargin =(int)(.02f*width*((Home)context).deviceWidth);
		params_layout1.rightMargin =(int)(.02f*width*((Home)context).deviceWidth);
		params_layout1.height =(int)(.3f*height*((Home)context).deviceHeight);
		params_layout1.topMargin=(int)(.02f*height*((Home)context).deviceHeight);
		layout1.setLayoutParams(params_layout1);


		LinearLayout.LayoutParams params_userImage =(LinearLayout.LayoutParams) userImage.getLayoutParams();
		params_userImage.height=(int)(.22f*height*((Home)context).deviceHeight);
		params_userImage.width=(int)(.195f*width*((Home)context).deviceWidth);
		userImage.setLayoutParams(params_userImage);

		LinearLayout.LayoutParams params_userDetailsLinear =(LinearLayout.LayoutParams) userDetailsLinear.getLayoutParams();
		params_userDetailsLinear.height=(int)(.3f*height*((Home)context).deviceHeight);
		params_userDetailsLinear.width=(int)(.68f*width*((Home)context).deviceWidth);
		params_userDetailsLinear.leftMargin =(int)(.04f*width*((Home)context).deviceWidth);
		params_userDetailsLinear.rightMargin =(int)(.02f*width*((Home)context).deviceWidth);
		userDetailsLinear.setLayoutParams(params_userDetailsLinear);


		TextView companyName = new TextView(context);
		companyName.setTextColor(Color.BLACK);

		TextView post = new TextView(context);
		post.setTextColor(Color.BLACK);

		TextView mobile = new TextView(context);
		mobile.setTextColor(Color.BLACK);

		TextView emailId = new TextView(context);
		emailId.setTextColor(Color.BLACK);



		userDetailsLinear.addView(companyName);
		userDetailsLinear.addView(post);
		userDetailsLinear.addView(mobile);
		userDetailsLinear.addView(emailId);


		companyName.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(companyName.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		post.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(post.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		mobile.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(mobile.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));
		emailId.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
				determineTextSize(emailId.getTypeface(),((int)(height*((Home)context).deviceHeight)*.11f)*(.5f)));


		  chatList = new ListView(context);

		viewGroup.addView(chatList);


		LinearLayout.LayoutParams params_chatList =(LinearLayout.LayoutParams) chatList.getLayoutParams();
		params_chatList.width =(int)(.96f*width*((Home)context).deviceWidth);
		params_chatList.leftMargin =(int)(.02f*width*((Home)context).deviceWidth);
		params_chatList.rightMargin =(int)(.02f*width*((Home)context).deviceWidth);
		params_chatList.height =(int)(.4f*height*((Home)context).deviceHeight);
		params_chatList.topMargin=(int)(.02f*height*((Home)context).deviceHeight);
		chatList.setLayoutParams(params_chatList);

		chatList.setDividerHeight(0);

		LinearLayout sendMessageLayout = new LinearLayout(context);
		sendMessageLayout.setOrientation(LinearLayout.HORIZONTAL);

		viewGroup.addView(sendMessageLayout);


		LinearLayout.LayoutParams params_sendMessageLayout =(LinearLayout.LayoutParams) sendMessageLayout.getLayoutParams();
		params_sendMessageLayout.width =(int)(.96f*width*((Home)context).deviceWidth);
		params_sendMessageLayout.leftMargin =(int)(.02f*width*((Home)context).deviceWidth);
		params_sendMessageLayout.rightMargin =(int)(.02f*width*((Home)context).deviceWidth);
		params_sendMessageLayout.height =(int)(.1f*height*((Home)context).deviceHeight);
		params_sendMessageLayout.topMargin=(int)(.03f*height*((Home)context).deviceHeight);
		sendMessageLayout.setLayoutParams(params_sendMessageLayout);


		final EditText sendBox = new EditText(context);
		Button sendButton = new Button(context);
		sendButton.setText("SEND");

		sendMessageLayout.addView(sendBox);
		sendMessageLayout.addView(sendButton);

		LinearLayout.LayoutParams params_sendBox =(LinearLayout.LayoutParams) sendBox.getLayoutParams();
		params_sendBox.height=(int)(.1f*height*((Home)context).deviceHeight);
		params_sendBox.width=(int)(.7f*width*((Home)context).deviceWidth);
		sendBox.setLayoutParams(params_sendBox);

		LinearLayout.LayoutParams params_sendButton =(LinearLayout.LayoutParams) sendButton.getLayoutParams();
		params_sendButton.height=(int)(.1f*height*((Home)context).deviceHeight);
		params_sendButton.width=(int)(.23f*width*((Home)context).deviceWidth);
		params_sendButton.leftMargin=(int)(.02f*width*((Home)context).deviceWidth);
		sendButton.setLayoutParams(params_sendButton);

		if(_objFriendsListWrapper !=null)
		{
			companyName.setText("Company : "+_objFriendsListWrapper.Company);
			post.setText("City : "+_objFriendsListWrapper.City);
			mobile.setText("Mobile : "+_objFriendsListWrapper.Mobile);
			emailId.setText("Email Id : "+_objFriendsListWrapper.Email);

			sendButton.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					to =_objFriendsListWrapper.Email;
					message = sendBox.getText().toString();
					if(sendBox.length()>0)
					{
						Message _objmessage = new Message(message, true);
						
						ArrayList<Message> array = MyUIApplication.UserMessageArray.get(_objFriendsListWrapper.Email);
						if(array == null)
						{
							array = new ArrayList<Message>();
							MyUIApplication.UserMessageArray.put(_objFriendsListWrapper.Email,array);
						}
						array.add(_objmessage);
						
						adapter.notifyDataSetChanged();
						
						new BadgeBGThread(context, "SendMessage", "").execute();
						sendBox.setText("");
						chatList.setSelection(chatList.getAdapter().getCount()-1);	
					}
				}
			});
			
			
				ArrayList<Message> array = MyUIApplication.UserMessageArray.get(_objFriendsListWrapper.Email);
				
				if(array == null)
				{
					array = new ArrayList<Message>();
					MyUIApplication.UserMessageArray.put(_objFriendsListWrapper.Email,array);
				}
				
				 adapter = new AwesomeAdapter(context, array);
				
				chatList.setAdapter(adapter);
				chatList.setSelection(chatList.getAdapter().getCount()-1);				

		}




	}
	public static AwesomeAdapter adapter;
	public static ListView chatList;
//	ArrayList<Message> chatArray = new ArrayList<Message>();
	public String to="",message="";
}


