package mobi.neuerung.Sevices;


import mobi.neuerung.MADP.MyUIApplication;
import mobi.neuerung.Parser.GetMessageBG;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GetMessageService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		System.out.println("Service : on Create");
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		System.out.println("Service : on Start command");
		
		
		new GetMessageBG().execute();
		
		
		
		((MyUIApplication)MyUIApplication.getContext()).startService();
		
		return START_STICKY;
	}
	
	
	


}
