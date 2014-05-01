package mobi.neuerung.Adapters;

import java.io.File;
import java.util.ArrayList;

import mobi.neuerung.ImageScale.ImageUtil;
import mobi.neuerung.MADP.Home;
import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.MADP.R;
import mobi.neuerung.Wrapper.PictureGalleryGridWrapper;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;



//**** Home Grid Adapter   *****
public class PictureGalleryGridAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<PictureGalleryGridWrapper> PictureGaleryGridList;
	private String CategoryCode;
	private static String ScreenNumber;
	private LayoutInflater mInflater;
	// Constructor
	public PictureGalleryGridAdapter(Context c,String CategoryCode,String screenNumber,ArrayList<PictureGalleryGridWrapper> PictureGaleryGridList)
	{
		mContext = c;
		this.PictureGaleryGridList = PictureGaleryGridList;
		this.CategoryCode = CategoryCode;
		ScreenNumber = screenNumber;
		mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() 
	{
		int l =  PictureGaleryGridList.size();
		return l;
	}
	public Object getItem(int position)
	{
		return PictureGaleryGridList.get(position);
	}
	public long getItemId(int position)
	{
		return 0;
	}
	WindowManager mWinMgr;
	int deviceHeight=0;
	int deviceWidth=0;

	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder3 holder;
		WindowManager mWinMgr = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
		deviceHeight=mWinMgr.getDefaultDisplay().getHeight();
		deviceWidth=mWinMgr.getDefaultDisplay().getWidth();

		if (convertView == null)
		{
			holder = new ViewHolder3();

			convertView = mInflater.inflate(R.layout.picturegrid, null);
			try
			{

				int buttonwidth=(int)(deviceWidth*.3);

				holder.ButtonGrid = (FrameLayout) convertView.findViewById(R.id.ButtonGrid);
				holder.ButtonGrid1 = (RelativeLayout) convertView.findViewById(R.id.ButtonGrid1);

				FrameLayout.LayoutParams params_ButtonGrid = (FrameLayout.LayoutParams)holder.ButtonGrid1.getLayoutParams();
				params_ButtonGrid	=	new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
				params_ButtonGrid.height=buttonwidth;
				params_ButtonGrid.width=buttonwidth;
				params_ButtonGrid.topMargin=(int)(deviceWidth*.003f);
				params_ButtonGrid.bottomMargin=(int)(deviceWidth*.003f);
				params_ButtonGrid.rightMargin=(int)(deviceWidth*.03f);
				params_ButtonGrid.leftMargin=(int)(deviceWidth*.03f);
				holder.ButtonGrid1.setLayoutParams(params_ButtonGrid);

				holder.Img = (ImageView) convertView.findViewById(R.id.Img);
				holder.Img.setPadding((int)(deviceWidth*.005f), 0, (int)(deviceWidth*.005f), 0);

			}
			catch (Exception e)
			{
				System.out.println("Exception in Grid Item's Width Please Define the Width"+e);

				holder.ButtonGrid = (FrameLayout) convertView.findViewById(R.id.ButtonGrid);
				ViewGroup.LayoutParams params_ButtonGrid = holder.ButtonGrid.getLayoutParams();
				int buttonwidth=(int)(.2f*deviceWidth);
				params_ButtonGrid.width=buttonwidth;
				params_ButtonGrid.height=buttonwidth;
				holder.ButtonGrid.setLayoutParams(params_ButtonGrid);


			}

			convertView.setTag(holder);
		}
		else 
		{
			holder = (ViewHolder3) convertView.getTag();
		}

		holder.ButtonGrid.setOnTouchListener(new OnTouchListener() 
		{
			public boolean onTouch(View v, MotionEvent event)
			{
				switch(event.getAction()) 
				{

				case MotionEvent.ACTION_DOWN:
					try {
						holder.Img.setAlpha(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
					return true;

				case MotionEvent.ACTION_UP:
					try {
						holder.Img.setAlpha(255);
					} catch (Exception e) {
						// TODO: handle exception
					}
//					if(((Home)mContext).LLLayout.getVisibility()==View.VISIBLE)
//					{
//						((Home)mContext).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_left));
//						((Home)mContext).LLLayout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_left));
//					}
//					if(((Home)mContext).LLLayoutCopy.getVisibility()==View.VISIBLE)
//					{
//						((Home)mContext).LLLayout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_in_left));
//						((Home)mContext).LLLayoutCopy.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_left));
//					}

					try {
						((Home)mContext).inLayoutAnim();
					} catch (Exception e) {
						// TODO: handle exception
					}
					v.setEnabled(false);

					String Id = PictureGaleryGridList.get(position).Id;
					String ImageName = PictureGaleryGridList.get(position).ImageName;
					String ImagePath = PictureGaleryGridList.get(position).ImagePath;
					String ThumbnailPath = PictureGaleryGridList.get(position).ThumbnailPath;
					String CatagoryCode = PictureGaleryGridList.get(position).CatagoryCode;
					String SDescription = PictureGaleryGridList.get(position).SDescription;
					String LDescription = PictureGaleryGridList.get(position).LDescription;
					String wrapper = Id+"#,"+ImageName+"#,"+ImagePath+"#,"+ThumbnailPath+"#,"+CatagoryCode+"#,"+
																			SDescription+"#,"+LDescription;

					((Home)mContext).OpenHtmlPage(ScreenNumber,wrapper);
					MyUIApplication.StateMachine.add(ScreenNumber);

					int i=MyUIApplication.StateMachine.size();
					System.out.println("State Machine Size >>>"+i);
					break;

				case MotionEvent.ACTION_CANCEL:
//					holder.Img.getBackground().setAlpha(255);
					try {
						holder.Img.setAlpha(255);
					} catch (Exception e) {
						// TODO: handle exception
					}
					break;
				}

				return false;
			}

		});
		
		try
		{
				File dir = MyUIApplication.SDCardPath("/"+MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Thumbnails/"+CategoryCode);

				String imagepath = MyUIApplication.mainDirectoryName+"/"+ MyUIApplication.ClientCode+"/"+MyUIApplication.EventCode+"/PictureGalleryGrid/Thumbnails/"+CategoryCode+"/"+PictureGaleryGridList.get(position).ThumbnailPath;

				if(dir.exists())
				{
//					Bitmap bmp	=	BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath()+"/"+imagepath);
					Bitmap bmp =ImageUtil.setBgFromSDCardForOtherDirectoy(holder.Img, (Home)mContext,imagepath,(int)(deviceWidth*.3),(int)(deviceWidth*.3));
					if(bmp != null)
					{
						holder.Img.setImageBitmap(bmp);
						holder.Img.setBackgroundDrawable(null);
					}else {
//						holder.Img.setBackgroundResource(R.drawable.ic_launcher);
					}
				}
		}
		catch (Exception e)
		{
			holder.Img.setBackgroundResource(R.drawable.ic_launcher);
			e.printStackTrace();
		}

		// Display planet data
		holder.id = position;
		return convertView;
	}
}

class ViewHolder3 
{
	FrameLayout ButtonGrid;
	RelativeLayout ButtonGrid1;
	ImageView Img;
	int id;

}