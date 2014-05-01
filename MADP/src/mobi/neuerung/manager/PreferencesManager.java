package mobi.neuerung.manager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class PreferencesManager {
	
	private static final String TAG	=	"Preference Manager";

	private static final String PREF_NAME = "SalesPlatFormPref";

	private SharedPreferences pref;

	private Editor editor;

	Context context;

	int PRIVATE_MODE = Activity.MODE_PRIVATE;
	
	private String IS_PUSH_ENABLE	=	"is push enable";
	private String DEVICE_TOKEN	=	"device token";
	
	private ArrayList<String> client_event	=	new ArrayList<String>();
	
	public PreferencesManager(Context context) {
		this.context = context;
		pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
		editor = pref.edit();
	}
	
	public SharedPreferences getSharedPreferences(){
		return pref;
	}

	
	public Boolean getPushStatus(String flag){
		
		String pushEnableClient 	=	pref.getString(IS_PUSH_ENABLE, "");
		List<String> list = Arrays.asList(TextUtils.split(pushEnableClient, ","));
		
		if(list != null){
			return list.contains(flag);
		}else {
			return false;
		}
		
	}
	
	public void setPushStatus(String flag){
		
		String pushEnableClient 	=	pref.getString(IS_PUSH_ENABLE, "");
		String newpushEnableClient	=	"";
		
		if(pushEnableClient.length() == 0){
			newpushEnableClient	=	flag;
		}else {
			newpushEnableClient	=	pushEnableClient+","+flag;
		}
		
		editor.putString(IS_PUSH_ENABLE, newpushEnableClient);
		editor.commit();
//		editor.putBoolean(IS_PUSH_ENABLE, flag);
//		editor.commit();
	}
	
	public void saveDeviceId(String id){
		editor.putString(DEVICE_TOKEN, id);
		editor.commit();
	}
	
	public String getDeviceId(){
		return pref.getString(DEVICE_TOKEN, "");
	}
	
}
