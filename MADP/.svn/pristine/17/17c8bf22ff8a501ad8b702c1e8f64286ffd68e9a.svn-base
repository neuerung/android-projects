package mobi.neuerung.Adapters;

import java.util.ArrayList;
import java.util.List;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ExhibitorDirectoryWrapper;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class ExhibitorListAdapter extends ArrayAdapter<ExhibitorDirectoryWrapper> 
{
	private Context context;
	int deviceHeight,deviceWidth;
	public ExhibitorListAdapter(Context context,int textViewResourceId)
	{
		super(context, textViewResourceId,MyUIApplication._objExhibitorDirectoryList);
		this.context = context;
		deviceHeight = ((Home)context).deviceHeight;
		deviceWidth = ((Home)context).deviceWidth;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View v = convertView;

		try{

			final ViewHolder holder;
			if (v == null) {		
				
				holder = new ViewHolder();
				v = vi.inflate(R.layout.exhibitoritems, null);
				
				
				holder.name = (TextView) v.findViewById(R.id.name);
				holder.sep = (TextView) v.findViewById(R.id.sep);
				holder.heading = (TextView) v.findViewById(R.id.heading);
				holder.hall = (TextView) v.findViewById(R.id.hall);
				holder.Favourites = (ImageView) v.findViewById(R.id.Favourites);
				holder.Visited = (ImageView) v.findViewById(R.id.Visited);
				holder.LinFav = (FrameLayout) v.findViewById(R.id.LinFav);
				holder.LinHall = (FrameLayout) v.findViewById(R.id.LinHall);
				holder.LinHead = (RelativeLayout) v.findViewById(R.id.LinHead);
				holder.Row = (TableRow) v.findViewById(R.id.Row);
				holder.MainFrame = (TableLayout) v.findViewById(R.id.MainFrame);

				//holder.parentLayout=(LinearLayout)v.findViewById(R.id.parenttopLayout);//ADDED
				ViewGroup.LayoutParams params_Row = holder.Row.getLayoutParams();
				params_Row.height=(int)(.128f*deviceHeight);
				holder.Row.setLayoutParams(params_Row);
				
				TableRow.LayoutParams params_HomeBtn = (TableRow.LayoutParams) holder.LinFav.getLayoutParams();
				params_HomeBtn.width=(int)(.1f*deviceWidth);
//				params_HomeBtn.rightMargin=(int)(.02f*deviceWidth);
				holder.LinFav.setLayoutParams(params_HomeBtn);
				
				ViewGroup.LayoutParams params_LinHead = holder.LinHead.getLayoutParams();
				params_LinHead.width=(int)(.69f*deviceWidth);
				params_LinHead.height=(int)(.128f*deviceHeight);
				holder.LinHead.setLayoutParams(params_LinHead);
				
				ViewGroup.LayoutParams params_LinHall = holder.LinHall.getLayoutParams();
				params_LinHall.width=(int)(.168f*deviceWidth);
				params_LinHall.height=(int)(.128f*deviceHeight);
				holder.LinHall.setLayoutParams(params_LinHall);
				
				ViewGroup.LayoutParams params_Favourites = holder.Favourites.getLayoutParams();
				params_Favourites.width=(int)(.07f*deviceWidth);
				params_Favourites.height=(int)(.93f*.07f*deviceWidth);
				holder.Favourites.setLayoutParams(params_Favourites);
				
				FrameLayout.LayoutParams marginparams_Favourites = (FrameLayout.LayoutParams)holder.Favourites.getLayoutParams();
				marginparams_Favourites.topMargin=(int)(deviceHeight*.015f);
//				marginparams_Favourites.rightMargin=(int)(deviceWidth*.01f);
				
				ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Favourites, context,"images/bookmark_sel.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));
				
				ViewGroup.LayoutParams params_Visited = holder.Visited.getLayoutParams();
				params_Visited.width=(int)(.07f*deviceWidth);
				params_Visited.height=(int)(.93f*.07f*deviceWidth);
				holder.Visited.setLayoutParams(params_Visited);
				
				FrameLayout.LayoutParams marginparams_Visited = (FrameLayout.LayoutParams)holder.Visited.getLayoutParams();
				marginparams_Visited.bottomMargin=(int)(deviceHeight*.01f);
//				marginparams_Visited.rightMargin=(int)(deviceWidth*.015f);
				
				ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Visited, context,"images/visited_sel.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));
				
				holder.heading.setPadding((int)(0.02f*deviceWidth),(int)(0.02f*deviceHeight), 0, 0);
				holder.name.setPadding((int)(0.02f*deviceWidth), 0, 0, (int)(0.02f*deviceHeight));
				
				holder.heading.setTypeface(MyUIApplication.tf);
				holder.hall.setTypeface(MyUIApplication.tf);
				holder.name.setTypeface(MyUIApplication.tf);

				holder.heading.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.heading.getTypeface(),((0.33f)*(.088992f)*(deviceHeight))));
				holder.hall.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.hall.getTypeface(),((0.2f)*(.1f)*(deviceHeight))));
				holder.name.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.name.getTypeface(),((0.28f)*(.088992f)*(deviceHeight))));
				
				
				v.setTag(holder);
			}
			else
				holder=(ViewHolder)v.getTag();

			v.setMinimumHeight((int)(.128f*deviceHeight));
			// v.setBackgroundResource(R.drawable.listviewclick);

			final ExhibitorDirectoryWrapper _obj= MyUIApplication._objExhibitorDirectoryList.get(position);
			if (_obj != null) {
				
				holder.exhibitor_Id = _obj.exhibitor_id;
				//String [] data= _objBeerABCWrapper.Bezeichnung.split("Analytik");

				//			if(MyUIApplication.MyScreenSize(context).equals(MyUIApplication.MDPI))
				//			{
				//				try
				//				{
				//					holder.name.setText(_objBeerABCWrapper.Bezeichnung.replaceAll("\n", "").substring(0, 150));
				//				}
				//				catch(Exception ex)
				//				{
				//					holder.name.setText(_objBeerABCWrapper.Bezeichnung.replaceAll("\n", ""));		
				//				}
				//				holder.name.setTextSize(10);
				//			}
				//			else

				
				
				
				ArrayList<String> _ob = _obj.boothList;
				String st = "";
				for(int i =0;i<_ob.size();i++)
				{
					if(_ob.get(i).length()>0)
					st =st.concat( _ob.get(i)+", ");
				}
				
				holder.name.setText("(Hall "+_obj.hall+") "+st.substring(0,st.lastIndexOf(",")));
				holder.heading.setText(_obj.name);
				
			
				
//				holder.hall.setText(_obj.hall);
				
//				TableRow.LayoutParams marginparams_TextV1 = (TableRow.LayoutParams)holder.TextV1.getLayoutParams();
//				marginparams_TextV1.rightMargin=(int)(deviceWidth*.1f);

				if(_obj.Favourites.equals("1"))
				{
				holder.Favourites.setVisibility(View.VISIBLE);
				}
				else
				{
					holder.Favourites.setVisibility(View.GONE);
				}
				
				if(_obj.Visited.equals("1"))
				{
					holder.Visited.setVisibility(View.VISIBLE);
				}
				else if(_obj.Visited.equals("0"))
				{
					holder.Visited.setVisibility(View.GONE);
				}
				
				
//				if(_obj.section.equals("Couture"))
//				{
//					holder.LinHall.setBackgroundResource(R.drawable.green_grad);
//					holder.hall.setText("Couture");
//				}
//				else if(_obj.section.equals("Mass Produced"))
//				{
//					holder.LinHall.setBackgroundResource(R.drawable.blue_grad);
//					holder.hall.setText("Mass Produced");
//				}
//				else if(_obj.section.equals("Plain Gold Jewellery"))
//				{
//					holder.LinHall.setBackgroundResource(R.drawable.yellow_grad);
//					holder.hall.setText("Plain\nGold");
//				}
//				else if(_obj.section.equals("Loose Stones"))
//				{
//					holder.LinHall.setBackgroundResource(R.drawable.pink_grad);
//					holder.hall.setText("Loose\nStones");
//				}
//				else if(_obj.section.equals("International"))
//				{
//					holder.LinHall.setBackgroundResource(R.drawable.red_grad);
//					holder.hall.setText("Int.");
//				}
//				else if(_obj.section.equals("Allied"))
//				{
//					holder.LinHall.setBackgroundResource(R.drawable.gray_grad);
//					holder.hall.setText("Allied");
//				}
//				else if(_obj.section.equals("Machinery"))
//				{
//					holder.LinHall.setBackgroundResource(R.drawable.light_gray_grad);
//					holder.hall.setText("Machinery");
//				}
//				else if(_obj.section.equals("Studded Jewellery"))
//				{
//					holder.LinHall.setBackgroundResource(R.drawable.red_grad);
//					holder.hall.setText("Studded\nJewellery");
//				}
//				else if(_obj.section.equals("Signature Club"))
//				{
//					holder.hall.setText("Signature\nClub");
//					holder.LinHall.setBackgroundResource(R.drawable.red_grad);
//				}
				
				if(_obj.section.equals("Allied") || _obj.section.equals("International") || _obj.section.equals("Machinery"))
				{
					holder.hall.setTextColor(Color.WHITE);
				}
				else
					holder.hall.setTextColor(Color.BLACK);
			
				//_objHomeClass.changeViewBGWithScalling(R.drawable.newbeerlistbg,holder.parentLayout);


//				holder.MainFrame.setOnTouchListener(new OnTouchListener() {
//
//					public boolean onTouch(View v, MotionEvent event) {
//						// TODO Auto-generated method stub
//
//
//						switch (event.getAction()) {
//						case MotionEvent.ACTION_DOWN:
//							holder.MainFrame.setBackgroundResource(R.drawable.top_bargradient);
//							holder.hall.setTextColor(Color.WHITE);
//							holder.sep.setVisibility(View.GONE);
//							holder.name.setTextColor(Color.WHITE);
//							holder.heading.setTextColor(Color.WHITE);
//							holder.LinHall.setBackgroundColor(Color.parseColor("#00000000"));
//							
//							ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Favourites, context,"ExhiList/favourite_img.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));
//							ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Visited, context,"ExhiList/visited_sel.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));
//							
//							return true;
//						case MotionEvent.ACTION_CANCEL:
//							holder.MainFrame.setBackgroundColor(Color.WHITE);
//							holder.sep.setVisibility(View.VISIBLE);
//							holder.hall.setTextColor(Color.BLACK);
//							if(_obj.section.equals("Allied") || _obj.section.equals("International") || _obj.section.equals("Machinery"))
//							{
//								holder.hall.setTextColor(Color.WHITE);
//							}
//							holder.name.setTextColor(Color.BLACK);
//							holder.heading.setTextColor(Color.BLACK);
//							
//							ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Favourites, context,"ExhiList/favourite_img_nonsel.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));
//							ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Visited, context,"ExhiList/visited_nonsel.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));
//							
////							if(_obj.section.equals("Couture"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.green_grad);
////								holder.hall.setText("Couture");
////							}
////							else if(_obj.section.equals("Mass Produced"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.blue_grad);
////								holder.hall.setText("Mass produced");
////							}
////							else if(_obj.section.equals("Plain Gold Jewellery"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.yellow_grad);
////								holder.hall.setText("Plain\nGold");
////							}
////							else if(_obj.section.equals("Loose Stones"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.pink_grad);
////								holder.hall.setText("Loose\nStones");
////							}
////							else if(_obj.section.equals("International"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.red_grad);
////								holder.hall.setText("Int.");
////							}
////							else if(_obj.section.equals("Allied"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.gray_grad);
////								holder.hall.setText("Allied");
////							}
////							else if(_obj.section.equals("Machinery"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.light_gray_grad);
////								holder.hall.setText("Machinery");
////							}
////							else if(_obj.section.equals("Studded Jewellery"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.red_grad);
////								holder.hall.setText("Studded\nJewellery");
////							}
////							else if(_obj.section.equals("Signature Club"))
////							{
////								holder.hall.setText("Signature\nClub");
////								holder.LinHall.setBackgroundResource(R.drawable.red_grad);
////							}
//							
//							break;
//
//						case MotionEvent.ACTION_UP:
//							
//							
////							if(_obj.section.equals("Couture"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.green_grad);
////								holder.hall.setText("Couture");
////							}
////							else if(_obj.section.equals("Mass Produced"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.blue_grad);
////								holder.hall.setText("Mass produced");
////							}
////							else if(_obj.section.equals("Plain Gold Jewellery"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.yellow_grad);
////								holder.hall.setText("Plain\nGold");
////							}
////							else if(_obj.section.equals("Loose Stones"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.pink_grad);
////								holder.hall.setText("Loose\nStones");
////							}
////							else if(_obj.section.equals("International"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.red_grad);
////								holder.hall.setText("Int.");
////							}
////							else if(_obj.section.equals("Allied"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.gray_grad);
////								holder.hall.setText("Allied");
////							}
////							else if(_obj.section.equals("Machinery"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.light_gray_grad);
////								holder.hall.setText("Machinery");
////							}
////							else if(_obj.section.equals("Studded Jewellery"))
////							{
////								holder.LinHall.setBackgroundResource(R.drawable.red_grad);
////								holder.hall.setText("Studded\nJewellery");
////							}
////							else if(_obj.section.equals("Signature Club"))
////							{
////								holder.hall.setText("Signature\nClub");
////								holder.LinHall.setBackgroundResource(R.drawable.red_grad);
////							}
//
//							
//							
//							holder.MainFrame.setBackgroundColor(Color.WHITE);
//							holder.hall.setTextColor(Color.BLACK);
//							if(_obj.section.equals("Allied") || _obj.section.equals("International") || _obj.section.equals("Machinery"))
//							{
//								holder.hall.setTextColor(Color.WHITE);
//							}
//							holder.name.setTextColor(Color.BLACK);
//							holder.heading.setTextColor(Color.BLACK);
//							
//							ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Favourites, context,"ExhiList/favourite_img_nonsel.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));
//							ImageUtil.setBackgroundBgFromAssetsNotCache(holder.Visited, context,"ExhiList/visited_nonsel.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));
//							
////							MyUIApplication root=((MyUIApplication)context.getApplicationContext());
////							root.currentindex=position;
////
////							root.maxindex=MyUIApplication._objExhibitorDirectoryList.size();
////
////
////							Intent myIntent = new Intent(context, ExhibitorDetail.class);
////							context.startcontextForResult(myIntent, 0);
////							context.overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
//							
//							break;
//						default:
//							return false;
//						}
//
//
//						return false;
//					}
//				});


			}
		}catch (Exception e) {
			System.out.println("exception "+e);
		}
		return v;
	}
	
	public static class ViewHolder{
		public TextView name,sep;
		public TextView heading;
		public TextView hall;
		public TextView TextV1;
		public ImageView Favourites;
		public ImageView Visited;
		public FrameLayout LinFav;
		public FrameLayout LinHall;
		public TableLayout MainFrame;
		public RelativeLayout LinHead;
		public TableRow Row;
		public String exhibitor_Id;

		//ADDED
	}




	 List<ExhibitorDirectoryWrapper> filtered;
		@Override
		public Filter getFilter() {
			// TODO Auto-generated method stub
			 return new Filter() {
		            @SuppressWarnings("unchecked")
		            @Override
		            protected void publishResults(CharSequence constraint, FilterResults results) {
		            	 filtered = (ArrayList<ExhibitorDirectoryWrapper>)results.values;
		                 notifyDataSetChanged();
		                 clear();
		                 for(int i = 0, l = filtered.size(); i < l; i++)
		                     add(filtered.get(i));
		                 notifyDataSetInvalidated();
		            }

		            @Override
		            protected FilterResults performFiltering(CharSequence constraint) {
		                Log.d("", "**** PERFORM FILTERING for: " + constraint);
		                
		                constraint = constraint.toString().toLowerCase();
		                FilterResults result = new FilterResults();
		                if(constraint != null && constraint.toString().length() > 0)
		                {
		                    ArrayList<ExhibitorDirectoryWrapper> filt = new ArrayList<ExhibitorDirectoryWrapper>();
		                    ArrayList<ExhibitorDirectoryWrapper> lItems = new ArrayList<ExhibitorDirectoryWrapper>();
		                    synchronized (this)
		                    {
		                        lItems.addAll(MyUIApplication._objExhibitorDirectoryList);
		                    }
		                    for(int i = 0, l = lItems.size(); i < l; i++)
		                    {
		                    	ExhibitorDirectoryWrapper m = lItems.get(i);
		                        if(m.name.toLowerCase().contains(constraint))
		                            filt.add(m);
		                    }
		                    result.count = filt.size();
		                    result.values = filt;
		                }
		                else
		                {
		                    synchronized(this)
		                    {
		                        result.values = MyUIApplication._objExhibitorDirectoryList;
		                        result.count = MyUIApplication._objExhibitorDirectoryList.size();
		                    }
		                }
		                return result;
		            }
		        };
		}




}
