package mobi.neuerung.SectionList;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import mobi.neuerung.DateUtilPackage.DateUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Util.UtilShowUpdate;
import mobi.neuerung.Wrapper.ElementWrapper;
import mobi.neuerung.Wrapper.ShowUpdatesWrapper;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;



public class ShowUpdateAdapter extends ArrayAdapter<ShowUpdateItem> {

	private Context context;
	private ArrayList<ShowUpdateItem> items;
	private LayoutInflater vi;

	WindowManager mWinMgr;
	int deviceHeight,deviceWidth;

	ElementWrapper _objElement;

	public ShowUpdateAdapter(Context context,ArrayList<ShowUpdateItem> items,ElementWrapper _objElement) {
		super(context,0, items);


		this.context = context;
		this.items = items;

		this._objElement =_objElement;

		WindowManager mWinMgr = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();


		vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final ShowUpdateItem i = items.get(position);
		
		if (i != null) {
			
			if(i.isSection())
			{

				ShowUpdateSectionItem si = (ShowUpdateSectionItem)i;
				v = vi.inflate(R.layout.event_list_item_section, null);

				v.setOnClickListener(null);
				v.setOnLongClickListener(null);
				v.setLongClickable(false);

				final TextView sectionView = (TextView) v.findViewById(R.id.list_item_section_text);
				String s=si.getTitle();

				DateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");


				//					Date d = (Date)formatter.parse(si.getTitle());
//					String ss=DateUtil.checkDate(d);
				sectionView.setText(si.getTitle());

				ViewGroup.LayoutParams params_sectionView = sectionView.getLayoutParams();
				params_sectionView.height=(int)(.07f*deviceHeight);
				sectionView.setLayoutParams(params_sectionView);


				sectionView.setPadding((int)(.02f*deviceHeight),0,0,0);

				try {
					sectionView.setBackgroundColor(Color.parseColor(_objElement.Datebg));
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					Typeface tf = MyUIApplication.fontmap.get(_objElement.DatefontStyle);
					sectionView.setTypeface(tf);
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					sectionView.setTextColor(Color.parseColor(_objElement.DatefontColor));
				} catch (Exception e) {
					// TODO: handle exception
					sectionView.setTextColor(Color.BLACK);
				}

				try {
					int ii = Integer.parseInt(_objElement.DatefontSize);
					float testsizepercent = ii/960f;
					sectionView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(sectionView.getTypeface(),(testsizepercent*deviceHeight)));	
				} catch (Exception e) {
					// TODO: handle exception
					sectionView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(sectionView.getTypeface(),(0.1f)*(.4f*deviceHeight)));
				}

			}
			else
			{
				ShowUpdateEntryItem ei = (ShowUpdateEntryItem)i;
				v = vi.inflate(R.layout.showupdate_list_item_entry, null);
				final TextView time = (TextView)v.findViewById(R.id.time);
				final TextView title = (TextView)v.findViewById(R.id.list_item_entry_title);
				final TextView name = (TextView)v.findViewById(R.id.name);
				final FrameLayout MainFrame = (FrameLayout)v.findViewById(R.id.MainFrame);


				int arrowHeight=(int)(.035f*deviceHeight);
				int arraywidth=(int)(0.7f*arrowHeight);


				ViewGroup.LayoutParams params_time = time.getLayoutParams();
				time.setLayoutParams(params_time);
				title.setPadding((int)(0.02f*deviceWidth), (int)(0.02f*deviceHeight), 0, 0);
				time.setPadding((int)(0.02f*deviceWidth), (int)(0.02f*deviceHeight),(int)(0.03f*deviceWidth), (int)(0.01f*deviceHeight));
				name.setPadding((int)(0.02f*deviceWidth),(int)(0.005f*deviceHeight), (int)(0.02f*deviceWidth), (int)(0.04f*deviceHeight));

				if (title != null) 
				{
					title.setText(ei._objShowUpdatesWrapper.title.trim());
				}
				if (name != null) 
				{
					name.setText(ei._objShowUpdatesWrapper.description.trim().replace("\n", " "));
				}

				try {
					MainFrame.setBackgroundColor(Color.parseColor(_objElement.bgcolor));
				} catch (Exception e) {
					// TODO: handle exception
				}
				try
				{
//					DateFormat StringToDate = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
//					String t=ei.time.trim();
//					Date date = StringToDate.parse(t);
//
//					Format DateToString = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
//					String strng = DateToString.format(date);

					time.setText(ei.time.trim());
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(""+e);
					time.setText("Exception");
				}
				MainFrame.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

						UtilShowUpdate _objSU = new UtilShowUpdate();

						switch (event.getAction()) {
						case MotionEvent.ACTION_DOWN:
							try {
								MainFrame.setBackgroundColor(Color.parseColor(_objElement.selectedBgcolor));
							} catch (Exception e) {
								// TODO: handle exception
							}

							//							title.setTextColor(Color.WHITE);
							//							name.setTextColor(Color.WHITE);

							return true;
						case MotionEvent.ACTION_CANCEL:
							try {
								MainFrame.setBackgroundColor(Color.parseColor(_objElement.bgcolor));
							} catch (Exception e) {
								// TODO: handle exception
							}

							//							title.setTextColor(Color.BLACK);
							//							name.setTextColor(Color.parseColor("#888686"));

							break;

						case MotionEvent.ACTION_UP:
							try {
								MainFrame.setBackgroundColor(Color.parseColor(_objElement.bgcolor));
							} catch (Exception e) {
								// TODO: handle exception
							}

							//							title.setTextColor(Color.BLACK);
							//							name.setTextColor(Color.parseColor("#888686"));

							ShowUpdateEntryItem ei = (ShowUpdateEntryItem)MyUIApplication.ShowUpdateitems.get(position);;
							ShowUpdatesWrapper _obj=ei._objShowUpdatesWrapper;

							MyUIApplication._objShowUpdateDB.updateTableForReadandUnread(_obj.id, "Red");



							try
							{

								try
								{

									MyUIApplication.ShowUpdateWrapperForDetail = _obj;
									_objSU.Listview.setEnabled(false);
									((Home)context).inLayoutAnim();
									((Home)context).OpenHtmlPage(_objElement.OnClick.trim().substring(12),_obj.id);

									MyUIApplication.StateMachine.add(_objElement.OnClick.trim().substring(12));

								}
								catch (Exception e)
								{
									System.out.println(e);
								}

							}catch (Exception e) 
							{
								System.out.println(e);
							}

							break;
						default:
							return false;
						}


						return false;
					}
				});


				try {
					if(_objElement.TitleGravity.equalsIgnoreCase("center"))
						title.setGravity(Gravity.CENTER);
					if(_objElement.TitleGravity.equalsIgnoreCase("right"))
						title.setGravity(Gravity.RIGHT);
					if(_objElement.TitleGravity.equalsIgnoreCase("left"))
						title.setGravity(Gravity.LEFT);
				} catch (Exception e) {
					// TODO: handle exception
					title.setGravity(Gravity.LEFT);
				}

				try {
					if(_objElement.SubTitleGravity.equalsIgnoreCase("center"))
						name.setGravity(Gravity.CENTER);
					if(_objElement.SubTitleGravity.equalsIgnoreCase("right"))
						name.setGravity(Gravity.RIGHT);
					if(_objElement.SubTitleGravity.equalsIgnoreCase("left"))
						name.setGravity(Gravity.LEFT);
				} catch (Exception e) {
					// TODO: handle exception
					name.setGravity(Gravity.LEFT);
				}


				try {
					Typeface tf = MyUIApplication.fontmap.get(_objElement.fontStyle);
					title.setTypeface(tf);
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					Typeface tf = MyUIApplication.fontmap.get(_objElement.subtitlefontStyle);
					name.setTypeface(tf);
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					title.setTextColor(Color.parseColor(_objElement.fontColor));
				} catch (Exception e) {
					// TODO: handle exception
					title.setTextColor(Color.BLACK);
				}

				try {
					name.setTextColor(Color.parseColor(_objElement.subtitlefontColor));
				} catch (Exception e) {
					// TODO: handle exception
					name.setTextColor(Color.BLACK);
				}

				try {
					int ii = Integer.parseInt(_objElement.fontSize);
					float testsizepercent = ii/960f;
					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
				} catch (Exception e) {
					// TODO: handle exception
					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.4f*deviceHeight)));
				}

				try {
					int ii = Integer.parseInt(_objElement.subtitlefontSize);
					float testsizepercent = ii/960f;
					name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
				} catch (Exception e) {
					// TODO: handle exception
					name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.3f*deviceHeight)));
				}

				//On Read news
				if(ei._objShowUpdatesWrapper.ReadOrUnRead.equalsIgnoreCase("Red"))
				{

					try {
						Typeface tf = MyUIApplication.fontmap.get(_objElement.ReadNewsfontStyle);
						title.setTypeface(tf);
						name.setTypeface(tf);
					} catch (Exception e) {
						// TODO: handle exception
					}

					try {
						title.setTextColor(Color.parseColor(_objElement.ReadNewsfontColor));
						name.setTextColor(Color.parseColor(_objElement.ReadNewsfontColor));
					} catch (Exception e) {
						// TODO: handle exception
						title.setTextColor(Color.BLACK);
						name.setTextColor(Color.BLACK);
					}
//
//					try {
//						int ii = Integer.parseInt(_objElement.ReadNewsfontSize);
//						float testsizepercent = ii/960f;
//						title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
//						name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(name.getTypeface(),(testsizepercent*deviceHeight)));	
//					} catch (Exception e) {
//						// TODO: handle exception
//						title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.3f*deviceHeight)));
//						name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(name.getTypeface(),(0.1f)*(.3f*deviceHeight)));
//					}
					
					try {
						int ii = Integer.parseInt(_objElement.fontSize);
						float testsizepercent = ii/960f;
						title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
					} catch (Exception e) {
						// TODO: handle exception
						title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.4f*deviceHeight)));
					}

					try {
						int ii = Integer.parseInt(_objElement.subtitlefontSize);
						float testsizepercent = ii/960f;
						name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(testsizepercent*deviceHeight)));	
					} catch (Exception e) {
						// TODO: handle exception
						name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.1f)*(.3f*deviceHeight)));
					}

				}



				try {
					Typeface tf = MyUIApplication.fontmap.get(_objElement.TimefontStyle);
					time.setTypeface(tf);
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					time.setTextColor(Color.parseColor(_objElement.TimefontColor));
				} catch (Exception e) {
					// TODO: handle exception
					time.setTextColor(Color.BLACK);
				}

				try {
					int ii = Integer.parseInt(_objElement.TimefontSize);
					float testsizepercent = ii/960f;
					time.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(time.getTypeface(),(testsizepercent*deviceHeight)));	
				} catch (Exception e) {
					// TODO: handle exception
					time.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(time.getTypeface(),(0.1f)*(.25f*deviceHeight)));
				}
				
			}
		}
		return v;
	}

}
