package mobi.neuerung.Adapters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.EventsWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;



public class EventsAdapter extends ArrayAdapter<EventItem> {

	private Context context;
	private ArrayList<EventItem> items;
	private LayoutInflater vi;
	int deviceHeight,deviceWidth;


	public EventsAdapter(Context context,ArrayList<EventItem> items) {
		super(context,0, items);



		this.context = context;
		this.items = items;

		deviceHeight= ((Home)context).deviceHeight;
		deviceWidth= ((Home)context).deviceWidth;

		vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	String date="";
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View v = convertView;



		final EventItem i = items.get(position);
		if (i != null) {
			if(i.isSection()){
				EventSectionItem si = (EventSectionItem)i;
				v = vi.inflate(R.layout.event_list_item_section, null);

				v.setOnClickListener(null);
				v.setOnLongClickListener(null);
				v.setLongClickable(false);

				final TextView sectionView = (TextView) v.findViewById(R.id.list_item_section_text);


				sectionView.setText(si.getTitle());
				sectionView.setTypeface(MyUIApplication.tf);
				date=si.getTitle();
				ViewGroup.LayoutParams params_sectionView = sectionView.getLayoutParams();
				params_sectionView.height=(int)(.07f*deviceHeight);
				sectionView.setLayoutParams(params_sectionView);

				sectionView.setPadding((int)(.02f*deviceHeight),0,0,0);
				sectionView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(sectionView.getTypeface(),(0.3f)*(.1f*deviceHeight)));

			}

			else

			{
				EventEntryItem ei = (EventEntryItem)i;

				EventsWrapper _obj=ei._objEventsWrapper;

				v = vi.inflate(R.layout.event_list_item_entry, null);

				final TextView time = (TextView)v.findViewById(R.id.time);
				final TextView title = (TextView)v.findViewById(R.id.list_item_entry_title);
				final TextView description = (TextView)v.findViewById(R.id.list_item_entry_des);
				final TableLayout MainFrame = (TableLayout)v.findViewById(R.id.MainFrame);
				final Button Btn1 = (Button)v.findViewById(R.id.Btn1);
				final Button Btn2 = (Button)v.findViewById(R.id.Btn2);

				if (title != null) 
				{
					try
					{
						//title.setText(ei.title.substring(0, 30)+"...");
					}
					catch(Exception ex)
					{

						title.setText(ei.title);
					}


					title.setText(ei.title);
					description.setText(_obj.Description);
				}

				time.setText(ei.time.substring(0, ei.time.length()-3));


				//				ViewGroup.LayoutParams params_time = time.getLayoutParams();
				//				params_time.width=(int)(.13f*deviceWidth);
				//				time.setLayoutParams(params_time);

				ViewGroup.LayoutParams params_title = title.getLayoutParams();
				params_title.width=(int)(.75f*deviceWidth);
				title.setLayoutParams(params_title);

				ViewGroup.LayoutParams params_description = description.getLayoutParams();
				params_description.width=(int)(deviceWidth);
				description.setLayoutParams(params_description);

				time.setTypeface(MyUIApplication.tf);
				title.setTypeface(MyUIApplication.tf);
				description.setTypeface(MyUIApplication.tf);

				ViewGroup.LayoutParams params_TopButton1 = Btn1.getLayoutParams();
				params_TopButton1.width=(int)(.17f*deviceWidth);
				params_TopButton1.height=(int)(.17f*deviceWidth*.763);
				Btn1.setLayoutParams(params_TopButton1);

				ViewGroup.LayoutParams params_TopButton2 = Btn2.getLayoutParams();
				params_TopButton2.width=(int)(.17f*deviceWidth);
				params_TopButton2.height=(int)(.17f*deviceWidth*.763f);
				Btn2.setLayoutParams(params_TopButton2);

				if(_obj.Attended.equals("No"))
				{
					ImageUtil.setBgFromSDCardNotCache(Btn1, context, "exhi1.png", (.17f*deviceWidth*.763f), (.17f*deviceWidth));
				}
				else
				{
					ImageUtil.setBgFromSDCardNotCache(Btn1, context, "exhi2.png", (.17f*deviceWidth*.763f), (.17f*deviceWidth));
				}
				ImageUtil.setBgFromSDCardNotCache(Btn2, context, "exhi2.png", (.17f*deviceWidth*.763f), (.17f*deviceWidth));

				time.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(time.getTypeface(),((0.3f)*(.1f)*(deviceHeight))));
				title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),((0.3f)*(.1f)*(deviceHeight))));
				description.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(description.getTypeface(),((0.3f)*(.1f)*(deviceHeight))));


				title.setPadding((int)(.02f*deviceHeight),(int)(.02f*deviceHeight),(int)(.02f*deviceHeight),0);
				description.setPadding((int)(.02f*deviceHeight),(int)(.01f*deviceHeight),(int)(.02f*deviceHeight),(int)(.02f*deviceHeight));
				time.setPadding((int)(.02f*deviceHeight),(int)(.02f*deviceHeight),(int)(.02f*deviceHeight),0);

				MainFrame.setOnTouchListener(new OnTouchListener() {

					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub


						switch (event.getAction()) {
						case MotionEvent.ACTION_DOWN:
							MainFrame.setBackgroundResource(R.drawable.top_bargradient);
							title.setTextColor(Color.WHITE);
							description.setTextColor(Color.WHITE);

							return true;
						case MotionEvent.ACTION_CANCEL:
							MainFrame.setBackgroundColor(Color.WHITE);
							title.setTextColor(Color.BLACK);
							description.setTextColor(Color.parseColor("#888686"));

							break;

						case MotionEvent.ACTION_UP:
							MainFrame.setBackgroundColor(Color.WHITE);
							title.setTextColor(Color.BLACK);
							description.setTextColor(Color.parseColor("#888686"));


							//							((Events)context).listview.setEnabled(false);
							//
							//							((Events)context).currentindex=position;
							//							((Events)context).maxindex=MyUIApplication.Eventitems.size()-1;
							EventEntryItem ei = (EventEntryItem)MyUIApplication.Eventitems.get(position);;
							EventsWrapper _obj=ei._objEventsWrapper;
							//
							//							((Events)context).Title.setText(_obj.title.trim());

							try
							{
								//				Date date ; 

								SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
								SimpleDateFormat format2 = new SimpleDateFormat("dd-MMMM-yyyy");

								try
								{

									//									Date date1 = format1.parse(_obj.date_time);


									//									((Events)context).date.setText(format2.format(date1));
								}catch (Exception e) {
									// TODO: handle exception
								}

							}catch (Exception e) {
								System.out.println(e);
							}
							//							String datetime[]=_obj.date_time.split(" ");
							//							((Events)context).time.setText(datetime[1].substring(0, datetime[1].length()-3));
							//
							//							((Events)context).details.setText(_obj.description.trim());
							//							((Events)context)._objPopUpLayout.setVisibility(View.VISIBLE);
							//							((Events)context).popupFrame.setVisibility(View.VISIBLE);
							//							((Events)context).seminar.setEnabled(false);
							//							((Events)context).networking.setEnabled(false);
							//							((Events)context).BackBtn.setEnabled(false);
							//							((Events)context).HomeBtn.setEnabled(false);
							
							
							if(((Home)context).LLLayout.getVisibility()==View.VISIBLE)
							{
								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
							}
							if(((Home)context).LLLayoutCopy.getVisibility()==View.VISIBLE)
							{
								((Home)context).LLLayout.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
								((Home)context).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
							}


							MyUIApplication.EventsWrapperForDetail = _obj;
							((Home)context).OpenHtmlPage("121",_obj.id);
							MyUIApplication.StateMachine.add("121");

							break;
						default:
							return false;
						}


						return false;
					}
				});

				Btn1.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						EventEntryItem ei = (EventEntryItem)MyUIApplication.Eventitems.get(position);;
						EventsWrapper _objWrap=ei._objEventsWrapper;

						try
						{
							String str = MyUIApplication._objEventsDB.getEventAttendedOrNot(_objWrap.Name_id);


							if(str.equals("No"))
							{
								ImageUtil.setBgFromSDCardNotCache(Btn1, context, "exhi2.png", (.17f*deviceWidth*.763f), (.17f*deviceWidth));

								MyUIApplication._objEventsDB.updateAttendedColumn(_objWrap.id,"Yes");
							}
							else
							{
								ImageUtil.setBgFromSDCardNotCache(Btn1, context, "exhi1.png", (.17f*deviceWidth*.763f), (.17f*deviceWidth));

								MyUIApplication._objEventsDB.updateAttendedColumn(_objWrap.id,"No");
							}
						}
						catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}

					}
				});

			}
		}
		return v;
	}

}
