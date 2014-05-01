package mobi.neuerung.Adapters;

import java.util.ArrayList;

import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.ProductListWrapper;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ProductListAdapter extends ArrayAdapter<ProductListWrapper> {

	ArrayList<ProductListWrapper> array;
	
	Context context;
	
	int resourceId;
	
	public ProductListAdapter(Context context,int textViewResourceId,ArrayList<ProductListWrapper> array) {
		super(context,textViewResourceId,array);
		// TODO Auto-generated constructor stub
		
		this.context = context;
		
		this.resourceId = textViewResourceId;
		
		this.array = array;
		
	}
	
	public static class ViewHolder{
		
		public TextView showUpadteCategoryName;
		
		public String categoryCode;
	}
	
	int deviceHeight =0;
	int deviceWidth =0;

	private ViewHolder holder;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
          View v = convertView;
		
          WindowManager windMgr = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
          
          deviceHeight =windMgr.getDefaultDisplay().getHeight();
          deviceWidth =windMgr.getDefaultDisplay().getWidth();
          
		if (v == null) {		
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			v=inflater.inflate(resourceId, null);
			holder = new ViewHolder();
			
			holder.showUpadteCategoryName =(TextView) v.findViewById(R.id.showUpadteCategoryName);
			
			holder.showUpadteCategoryName.setTextSize(TypedValue.COMPLEX_UNIT_PX,MyUIApplication.
					determineTextSize(holder.showUpadteCategoryName.getTypeface(),(deviceHeight*.11f)*(.4f)));
			
			holder.showUpadteCategoryName.setPadding((int)(.02f*deviceWidth), (int)(.02f*deviceHeight),(int)(.02f*deviceWidth),(int)(.01f*deviceHeight));
			
			
			v.setTag(holder);
			
		}
		else
		{
			holder=(ViewHolder)v.getTag();
		}
		
		if(array.size()>0)
		{
			holder.showUpadteCategoryName.setText(array.get(position).ProductName);
			
			holder.categoryCode = array.get(position).id;
			
		}
		return v;
	}

}
