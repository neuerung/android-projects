package mobi.neuerung.ImageScale;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

public class ImageScaling {

	public int ImageScale(int ViewSize , String ImagePathinSDCard)
	{

		String imageInSD = Environment.getExternalStorageDirectory().getAbsolutePath() +ImagePathinSDCard;
		Bitmap bitmap = BitmapFactory.decodeFile(imageInSD);

		float bitWgt =bitmap.getWidth();
		float bitHgt =bitmap.getHeight();

		double d=0.0;
		int hgt=0;
		if(bitWgt>bitHgt)
		{
			d = (ViewSize/bitWgt);
			hgt = (int)(d*bitHgt);
		}
		else if(bitHgt>bitWgt)
		{
			d = (ViewSize/bitHgt);
			hgt = (int)(d*bitWgt);
		}
		else
		{
			hgt  = ViewSize;
		}

		return hgt;
	}

}
