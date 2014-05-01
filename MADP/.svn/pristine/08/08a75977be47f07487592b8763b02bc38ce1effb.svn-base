package mobi.neuerung.Adapters;

import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.MenuItem.MenuEntryItem;
import mobi.neuerung.MenuItem.MenuItem;
import mobi.neuerung.MenuItem.MenuSectionItem;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MenuAdapter extends ArrayAdapter<MenuItem> {

	private Context context;
	private ArrayList<MenuItem> items;
	private LayoutInflater vi;

	WindowManager mWinMgr;
	int deviceHeight,deviceWidth;
	int ConstHeight,ConstWidth;
	public MenuAdapter(Context context,ArrayList<MenuItem> items,int Height,int Width) {
		super(context,0, items);

		mWinMgr = (WindowManager)context.getSystemService(Home.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();



		this.context = context;
		this.items = items;
		this.ConstHeight=Height;
		this.ConstWidth=Width;
		vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final MenuItem i = items.get(position);
		if (i != null) {
			if(i.isSection())
			{

				MenuSectionItem si = (MenuSectionItem)i;
				String s=si.getTitle();
				System.out.println(""+s);
				v = vi.inflate(R.layout.menu_list_item_section, null);

				v.setOnClickListener(null);
				v.setOnLongClickListener(null);
				v.setLongClickable(false);
				
				final TextView sectionView = (TextView) v.findViewById(R.id.list_item_section_text);


				if(s.length()>0)
				{
					sectionView.setText(si.getTitle());

					ViewGroup.LayoutParams params_sectionView = sectionView.getLayoutParams();
					params_sectionView.height=(int)(.0007f*ConstHeight*deviceHeight);
					sectionView.setLayoutParams(params_sectionView);

					sectionView.setBackgroundColor(Color.parseColor("#127877"));
					sectionView.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(sectionView.getTypeface(),(0.35f)*(int)(.1f*deviceHeight)));
				}
				else
				{
					ViewGroup.LayoutParams params_sectionView = sectionView.getLayoutParams();
					params_sectionView.height=(int)(.00000000001*deviceHeight);
					sectionView.setLayoutParams(params_sectionView);
				}

			}
			else
			{
				MenuEntryItem ei = (MenuEntryItem)i;
				v = vi.inflate(R.layout.menu_buttons_list, null);
				v.setMinimumHeight((int)(.001f*ConstHeight*deviceHeight));
				//				final LinearLayout ButtonClickLin = (LinearLayout)v.findViewById(R.id.ButtonClickLin);
				final ImageView ButtonIcon = (ImageView)v.findViewById(R.id.ButtonIcon);
				final TextView title = (TextView)v.findViewById(R.id.list_item_entry_title);

				if (title != null) 
				{

					title.setText(ei._objMenuWrapper.title.trim());
				}

				try
				{
					
					//					Drawable d = Drawable.createFromStream(context.getAssets().open(topbarfilePath), null);
					//					//				ButtonIcon.setText(ei.time.substring(0, ei.time.length()-3));
					//					ButtonIcon.setBackgroundDrawable(d);


					try
					{
						String Height  = ei._objMenuWrapper.height;
						Double Height1 = Double.parseDouble(Height);
						Double Height2 = Height1/100;


						Double ConstHeightt2=(double) ConstHeight;
						Double ConstHeightt3 =ConstHeightt2/100;


						ViewGroup.LayoutParams params_ButtonIcon = ButtonIcon.getLayoutParams();
						int buttonHeight=(int)(Height2*deviceHeight*ConstHeightt3);
						params_ButtonIcon.height=buttonHeight;
						params_ButtonIcon.width=(int)(1.25f*buttonHeight);
						ButtonIcon.setLayoutParams(params_ButtonIcon);

						LinearLayout.LayoutParams marginparam_ButtonIcon =(LinearLayout.LayoutParams) ButtonIcon.getLayoutParams();
						marginparam_ButtonIcon.leftMargin = (int)(.025f*deviceWidth);

						
						if(MyUIApplication.IsSdCardImageAvailable(ei._objMenuWrapper.imageName+".png"))
						{
							String topbarfilePath=ei._objMenuWrapper.imageName+".png";
							ImageUtil.setBgFromSDCardNotCache((View)ButtonIcon, context,topbarfilePath,(float)(buttonHeight),(float)(.795f*buttonHeight));
						}
						else 
						{
							String topbarfilePath="images/"+ei._objMenuWrapper.imageName+".png";
							ImageUtil.setBackgroundBgFromAssetsNotCache((View)ButtonIcon, context,topbarfilePath,(float)(buttonHeight),(float)(.795f*buttonHeight));
						}
					}
					catch (Exception e)
					{
						System.out.println("Exception in Grid Item's Width Please Define the Width"+e);

						ViewGroup.LayoutParams params_ButtonIcon = ButtonIcon.getLayoutParams();
						int buttonwidth=(int)(.2f*deviceWidth);
						params_ButtonIcon.width=buttonwidth;
						params_ButtonIcon.height=(int)(.795f*buttonwidth);
						ButtonIcon.setLayoutParams(params_ButtonIcon);

						LinearLayout.LayoutParams marginparam_ButtonIcon =(LinearLayout.LayoutParams) ButtonIcon.getLayoutParams();
						marginparam_ButtonIcon.leftMargin = (int)(.025f*deviceWidth);

					}


					title.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(title.getTypeface(),(0.35f)*(int)(.1f*deviceHeight)));
					//				ButtonClickLin.setOnTouchListener(new OnTouchListener() 
					//				{
					//					public boolean onTouch(View v, MotionEvent event)
					//					{
					//						switch(event.getAction()) 
					//						{
					//
					//						case MotionEvent.ACTION_DOWN:
					//							ButtonClickLin.setBackgroundColor(Color.parseColor("#505152"));
					//							//				        	holder.GridButtonTV.getBackground().setAlpha(150);
					//							//							return false;
					//							return true;
					//						case MotionEvent.ACTION_UP:
					//							ButtonClickLin.setBackgroundDrawable(null);
					//							//				        	holder.GridButtonTV.getBackground().setAlpha(255);
					//
					//
					//							MenuItem i = MyUIApplication.Menuitems.get(position);
					//							if(i.isSection()){
					//
					//							}
					//							else
					//							{
					//
					//								MenuEntryItem ei = (MenuEntryItem)MyUIApplication.Menuitems.get(position);;
					//								MenuWrapper _obj=ei._objMenuWrapper;
					//								if(_obj.OnClick.length()>0)
					//								{
					//									if(_obj.OnClick.substring(12).equals(MyUIApplication.StateMachine.get(MyUIApplication.StateMachine.size()-1)))
					//									{
					//										((Home)context).LLLayoutMenu.setVisibility(View.GONE);
					//										((Home)context).MenuButton.setVisibility(View.GONE);
					//
					//
					//
					//										((Home)context).LLTopMenu.removeAllViews();
					//										((Home)context).LLMiddleMenu.removeAllViews();
					//										((Home)context).LLBottomMenu.removeAllViews();
					//									}
					//									else
					//									{
					//
					//										((Home)context).LLLayoutMenu.setVisibility(View.GONE);
					//										((Home)context).MenuButton.setVisibility(View.GONE);
					//
					//
					//
					//										((Home)context).LLTopMenu.removeAllViews();
					//										((Home)context).LLMiddleMenu.removeAllViews();
					//										((Home)context).LLBottomMenu.removeAllViews();
					//
					////										v.setEnabled(false);
					//
					//
					//										//					MyUIApplication.StateMachine.remove(MyUIApplication.StateMachine.size()-1);
					//
					//
					//
					//										System.out.println("State Machine"+MyUIApplication.StateMachine);
					//										if(_obj.OnClick.substring(12).equals("0"))
					//										{
					//											((Home)context).DesignHomeScreen();
					//										}
					//										else
					//										{
					//											String LastScreen =_obj.OnClick.substring(12);
					//											MyUIApplication.StateMachine.add(LastScreen);
					//											((Home)context).OpenHtmlPage(LastScreen);
					//										}
					//									}
					//								}
					//							}
					//
					//
					//							break;
					//						case MotionEvent.ACTION_CANCEL:
					//							ButtonClickLin.setBackgroundDrawable(null);
					//							//				        	holder.GridButtonTV.getBackground().setAlpha(255);
					//							//Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
					//							break;
					//						}
					//
					//						return false;
					//					}
					//
					//				});

				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(""+e);
				}

				//				LinearLayout ButtonClickLin=(LinearLayout)v.findViewById(R.id.ButtonClickLin);
				//				ButtonClickLin.setOnClickListener(new OnClickListener() {
				//
				//					public void onClick(View v) {
				//						// TODO Auto-generated method stub
				//						String screenNumber=Home._objButtonList.get(position).OnClick.substring(12);
				//						((Home)context).StateMachine.add(screenNumber);
				//						((Home)context).openButtonClickScreen(Home._objButtonList.get(position).Title , screenNumber);
				//					}
				//				});

			}
		}
		return v;
	}

}
