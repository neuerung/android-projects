package mobi.neuerung.MADP;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class DefaultSplash extends Activity {
	LinearLayout LLLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.splash);

		WindowManager mgr =(WindowManager)getSystemService(Context.WINDOW_SERVICE);
		int deviceH = mgr.getDefaultDisplay().getHeight();
		int deviceW = mgr.getDefaultDisplay().getWidth();

		LLLayout =(LinearLayout) findViewById(R.id.LLLayout);

//		CheckPointForPushNotification();
		checkForClientScreen();
	}

//	public void CheckPointForPushNotification() {
//		if(!MyUIApplication.pref.getPushStatus()){
//
//			AlertDialog.Builder dialog	=	new AlertDialog.Builder(this);
//			dialog.setTitle("Notification");
//			dialog.setMessage("May we have permission to send you message ? if so please make sure your device is set to receive them.");
//			dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//
//				public void onClick(DialogInterface dialog, int which) {
//					new PushNotificationMain(getBaseContext()).onCreate();
//					checkForClientScreen(); //KD_100220141840
//				}
//			});
//			dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//
//				public void onClick(DialogInterface dialog, int which) {
//					checkForClientScreen(); //KD_100220141840
//				}
//			});
//			dialog.setCancelable(false);
//			dialog.show();
//		}else {
//			//If registered ,Do nothing
//			checkForClientScreen(); //KD_100220141840
//		}
//	}

	public void checkForClientScreen(){
		if(((MyUIApplication)getApplication()).showclientscreen)
		{
			if(MyUIApplication.client.trim().length()==0)
			{
				LLLayout.setBackgroundResource(R.drawable.splash);
			}
			else
			{
				LLLayout.setBackgroundResource(R.drawable.splash); //Splash for paathshala
//				LLLayout.setBackgroundResource(R.drawable.bhojnalaya_splash_800_1280); //Splash for Bhojnalaya
			}
			StartActivity();
		}
		else
		{
			finish();
			startActivity(new Intent(DefaultSplash.this, Splash.class));
		}
	}

	public void StartActivity()
	{
		new  CountDownTimer(2000, 500) {
			
			public void onTick(long millisUntilFinished)
			{}
			
			public void onFinish() {
				finish();
				startActivity(new Intent(DefaultSplash.this, Splash0.class));
				overridePendingTransition( R.anim.slide_in_left, R.anim.noanim );		
			}
		}.start();

	}

}
