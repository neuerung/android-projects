package mobi.neuerung.MADP;

import mobi.neuerung.Wrapper.PushNotificationWrapper;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class GcmBroadcastReceiver extends BroadcastReceiver  {

	private Context context;
	@Override
	public void onReceive(Context context, Intent intent) {

		this.context		=	context;
		// Explicitly specify that GcmIntentService will handle the intent.

		Bundle extras	=	intent.getExtras();

		if(!extras.isEmpty()){

			//    		String cmd	=	extras.getString("cmd");

			//    		if(cmd.equalsIgnoreCase("contact_sync")){
			//    			
			//    			Log.e("GCM Message","Contact command received");
			//    		}
			Log.e("GCM Message !! >","Received: " + extras.toString());

			/*********************************/
			
			int icon = R.drawable.app_icon;
	        long when = System.currentTimeMillis();
	        String message	=	extras.getString("message");
	        
	        /**Insert Message to Psuh DB*/
	        
	        PushNotificationWrapper _obj	=	new PushNotificationWrapper();
	        _obj.setTitle("Push Notificatio", message);
	        MyUIApplication._objPushDB.insertRecords(_obj);
	        
			NotificationManager notificationManager = (NotificationManager)
			context.getSystemService(Context.NOTIFICATION_SERVICE);
			Notification notification = new Notification(icon, message, when);

			String title = context.getString(R.string.app_name);

			Intent notificationIntent = new Intent(context, Splash0.class);
			// set intent so it does not start a new activity
			notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
					Intent.FLAG_ACTIVITY_SINGLE_TOP);
			PendingIntent pen_intent =
				PendingIntent.getActivity(context, 0, notificationIntent, 0);
			notification.setLatestEventInfo(context, title, message, pen_intent);
			notification.flags |= Notification.FLAG_AUTO_CANCEL;

			// Play default notification sound
			notification.defaults |= Notification.DEFAULT_SOUND;

			// Vibrate if vibrate is enabled
			notification.defaults |= Notification.DEFAULT_VIBRATE;
			notificationManager.notify(0, notification);   

		}
	}

}
