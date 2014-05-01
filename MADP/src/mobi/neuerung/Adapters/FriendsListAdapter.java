package mobi.neuerung.Adapters;

import java.util.ArrayList;
import java.util.List;

import mobi.neuerung.BGThread.BadgeBGThread;
import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.FriendsListWrapper;
import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FriendsListAdapter extends ArrayAdapter<FriendsListWrapper> 
{
	private Context context;
	int deviceHeight,deviceWidth;

	ArrayList<FriendsListWrapper> array;

	public FriendsListAdapter(Context context,int textViewResourceId,ArrayList<FriendsListWrapper> array)
	{
		super(context, textViewResourceId,array);
		this.context = context;
		this.array = array;
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
				v = vi.inflate(R.layout.friends_list, null);

				holder.removeUser =(Button) v.findViewById(R.id.removeUser);
				holder.UserImage =(Button) v.findViewById(R.id.UserImage);
				holder.userName =(TextView) v.findViewById(R.id.userName);
				holder.emailId =(TextView) v.findViewById(R.id.emailId);
				holder.phoneNumber =(TextView) v.findViewById(R.id.phoneNumber);
				holder.arrowImage =(Button) v.findViewById(R.id.arrowImage);
				holder.subLayout =(LinearLayout) v.findViewById(R.id.subLayout);

				LinearLayout.LayoutParams params_removeUser =(LinearLayout.LayoutParams) holder.removeUser.getLayoutParams();
				params_removeUser.height=(int)(.07f*deviceHeight);
				params_removeUser.width=(int)(.1f*deviceWidth);
				params_removeUser.leftMargin=(int)(.02f*deviceWidth);
				holder.removeUser.setLayoutParams(params_removeUser);

				LinearLayout.LayoutParams params_UserImager =(LinearLayout.LayoutParams) holder.UserImage.getLayoutParams();
				params_UserImager.height=(int)(.09f*deviceHeight);
				params_UserImager.width=(int)(.09f*deviceHeight);
				params_UserImager.leftMargin=(int)(.02f*deviceWidth);
				holder.UserImage.setLayoutParams(params_UserImager);

				LinearLayout.LayoutParams params_arrowImage =(LinearLayout.LayoutParams) holder.arrowImage.getLayoutParams();
				params_arrowImage.height=(int)(.05f*deviceHeight);
				params_arrowImage.width=(int)(.05f*deviceWidth);
				params_arrowImage.rightMargin=(int)(.02f*deviceWidth);
				holder.arrowImage.setLayoutParams(params_arrowImage);

				LinearLayout.LayoutParams params_subLayout =(LinearLayout.LayoutParams) holder.subLayout.getLayoutParams();
				params_subLayout.width=(int)(.6f*deviceWidth);
				params_subLayout.leftMargin=(int)(.02f*deviceWidth);
				params_subLayout.rightMargin=(int)(.02f*deviceWidth);
				holder.subLayout.setLayoutParams(params_subLayout);

				holder.userName.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.userName.getTypeface(),((0.4f)*(.1f)*(((Home)context).deviceHeight))));
				holder.emailId.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.emailId.getTypeface(),((0.3f)*(.1f)*(((Home)context).deviceHeight))));
				holder.phoneNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.determineTextSize(holder.phoneNumber.getTypeface(),((0.3f)*(.1f)*(((Home)context).deviceHeight))));

				ImageUtil.setBackgroundBgFromAssetsNotCache(holder.arrowImage, context,"images/arrow.png",(.93f*.07f*deviceWidth),(.07f*deviceWidth));

				v.setTag(holder);
			}
			else
				holder=(ViewHolder)v.getTag();

			v.setMinimumHeight((int)(.128f*deviceHeight));

			final FriendsListWrapper _obj= array.get(position);
			if (_obj != null) {

				holder.userName.setText("Name : "+_obj.Name);
				holder.emailId.setText("EmailId : "+_obj.Email);
				holder.phoneNumber.setText("Mobile : "+_obj.Mobile);


				holder.UserImage.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						if(((Home)context)._objUtilFriendsList.scrrenNum.length()>0)
						{
							((Home)context).OpenHtmlPage(((Home)context)._objUtilFriendsList.scrrenNum,_obj.id);
							MyUIApplication.StateMachine.add(((Home)context)._objUtilFriendsList.scrrenNum);
						}

					}
				});
				holder.subLayout.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						if(((Home)context)._objUtilFriendsList.scrrenNum.length()>0)
						{
							((Home)context).OpenHtmlPage(((Home)context)._objUtilFriendsList.scrrenNum,_obj.id);
							MyUIApplication.StateMachine.add(((Home)context)._objUtilFriendsList.scrrenNum);
						}

					}
				});
				holder.arrowImage.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						if(((Home)context)._objUtilFriendsList.scrrenNum.length()>0)
						{
							((Home)context).OpenHtmlPage(((Home)context)._objUtilFriendsList.scrrenNum,_obj.id);
							MyUIApplication.StateMachine.add(((Home)context)._objUtilFriendsList.scrrenNum);
						}

					}
				});

				holder.removeUser.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						if(MyUIApplication.isInternetAvailable(context))
						{


							new BadgeBGThread(context, "UpdateFriendList",_obj.Code).execute();

							ArrayList<FriendsListWrapper> array = new ArrayList<FriendsListWrapper>();
							array.add(_obj);

							MyUIApplication._objFriendsListDB.deleteRecord(array);

							((Home)context)._objUtilFriendsList.fillList("", false, context);
						}
					}
				});

			}



		}catch (Exception e) {
			System.out.println("exception "+e);
		}
		return v;
	}

	public static class ViewHolder{

		public Button removeUser;
		public Button UserImage;
		public TextView userName;
		public TextView phoneNumber;
		public TextView emailId;
		public Button arrowImage;
		public LinearLayout subLayout;

	}




	List<FriendsListWrapper> filtered;
	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return new Filter() {
			@SuppressWarnings("unchecked")
			@Override
			protected void publishResults(CharSequence constraint, FilterResults results) {
				filtered = (ArrayList<FriendsListWrapper>)results.values;
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
					ArrayList<FriendsListWrapper> filt = new ArrayList<FriendsListWrapper>();
					ArrayList<FriendsListWrapper> lItems = new ArrayList<FriendsListWrapper>();
					synchronized (this)
					{
						lItems.addAll(array);
					}
					for(int i = 0, l = lItems.size(); i < l; i++)
					{
						FriendsListWrapper m = lItems.get(i);
						if(m.Name.toLowerCase().contains(constraint))
							filt.add(m);
					}
					result.count = filt.size();
					result.values = filt;
				}
				else
				{
					synchronized(this)
					{
						result.values = array;
						result.count = array.size();
					}
				}
				return result;
			}
		};
	}




}
