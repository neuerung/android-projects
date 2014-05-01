package mobi.neuerung.MADP;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
public class PushNotificationMain {

	//Update 
	private String TAG = "** pushAndroidActivity **";
	private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
//	GoogleCloudMessaging gcm;
	String deviceId="";

	AsyncTask<Void, Void, Void> mRegisterTask;

	Context context;


	public PushNotificationMain(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}


	public void onCreate() {

		checkNotNull(CommonUtilities.SERVER_URL, "SERVER_URL");
		checkNotNull(CommonUtilities.SENDER_ID, "SENDER_ID");

		// Make sure the device has the proper dependencies.
		GCMRegistrar.checkDevice(context);

		// Make sure the manifest was properly set - comment out this line
		GCMRegistrar.checkManifest(context);

		/**Check for Google Play service and get instance of it */
//		if (checkPlayServices())
//			gcm = GoogleCloudMessaging.getInstance(context);



		final Context context = this.context;
		mRegisterTask = new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {

				//					deviceId	=	gcm.register(CommonUtilities.SENDER_ID);
									deviceId	=	GCMRegistrar.getRegistrationId(context);
									
									if(deviceId.equals("")){
										GCMRegistrar.register(context,CommonUtilities.SENDER_ID);
									}
									System.out.println(">>>> device gcm id :-"+deviceId);


				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				mRegisterTask = null;
			}

		};
		mRegisterTask.execute(null, null, null);
	}

	/* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {

	 * Typically, an application registers automatically, so options
	 * below are disabled. Uncomment them if you want to manually
	 * register or unregister the device (you will also need to
	 * uncomment the equivalent options on options_menu.xml).


            case R.id.options_register:
                GCMRegistrar.register(this, SENDER_ID);
                return true;
            case R.id.options_unregister:
                GCMRegistrar.unregister(this);
                return true;

            case R.id.options_clear:
                mDisplay.setText(null);
                return true;
            case R.id.options_exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

	//    @Override
	//    protected void onDestroy() {
	//        if (mRegisterTask != null) {
	//            mRegisterTask.cancel(true);
	//        }
	//        unregisterReceiver(mHandleMessageReceiver);
	//        GCMRegistrar.onDestroy(this);
	//        super.onDestroy();
	//    }

	private void checkNotNull(Object reference, String name) {
		if (reference == null) {
			throw new NullPointerException(
					context.getString(R.string.error_config, name));
		}
	}

	/**
	 * Check the device to make sure it has the Google Play Services APK. If
	 * it doesn't, display a dialog that allows users to download the APK from
	 * the Google Play Store or enable it in the device's system settings.
	 */
	private boolean checkPlayServices() {
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
		if (resultCode != ConnectionResult.SUCCESS) {
			//		if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
			//			GooglePlayServicesUtil.getErrorDialog(resultCode, this,
			//					PLAY_SERVICES_RESOLUTION_REQUEST).show();
			//		} else {
			Log.i(TAG, "This device is not supported.");

			//Show Alert Dialog as Deveice is not supported !!
			//			AlertDialog.Builder dialog	=	new AlertDialog.Builder(context);
			//			dialog.setTitle("Error");
			//			dialog.setMessage("No Google Play Service Find !!");
			//			dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			//				@Override
			//				public void onClick(DialogInterface dialog, int which) {
			//					((Activity) context).finish();
			//				}
			//			});
			//			dialog.show();
			//		}
			return false;
		}
		return true;
	}
}

//    private final BroadcastReceiver mHandleMessageReceiver =
//            new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
//            mDisplay.append(newMessage + "\n");
//        }
//    };





