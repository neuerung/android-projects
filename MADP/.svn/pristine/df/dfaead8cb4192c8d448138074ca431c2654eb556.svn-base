package mobi.neuerung.MADP;

import static mobi.neuerung.MADP.CommonUtilities.SERVER_URL;
import static mobi.neuerung.MADP.CommonUtilities.TAG;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;
public class ServerUtilities {
	private static final int MAX_ATTEMPTS = 5;
	private static final int BACKOFF_MILLI_SECONDS = 1000;
	private static final Random random = new Random();

	/**
	 * Register this account/device pair within the server.
	 *
	 * @return whether the registration succeeded or not.
	 */
	static boolean register(final Context context, final String regId) {
		Log.i(TAG, "registering device (regId = " + regId + ")");
		//String serverUrl = SERVER_URL + "/register";

		String serverUrl = SERVER_URL;
		String appName	=	"";
		String version	=	"";
		Map<String, String> params = new HashMap<String, String>();
		try {
			 version	=context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
			 appName	=	context.getResources().getString(R.string.app_name);
		} catch (NameNotFoundException e2) {
			e2.printStackTrace();
		}
		long backoff = BACKOFF_MILLI_SECONDS + random.nextInt(1000);
		// Once GCM returns a registration id, we need to register it in the
		// demo server. As the server might be down, we will retry it a couple
		// times.
		for (int i = 1; i <= MAX_ATTEMPTS; i++) {
			Log.d(TAG, "Attempt #" + i + " to register");
			try {
//				displayMessage(context, context.getString(
//						R.string.server_registering, i, MAX_ATTEMPTS));
				postData(regId,version,appName);
				//	                post(serverUrl, params);
				GCMRegistrar.setRegisteredOnServer(context, true);
//				String message = context.getString(R.string.server_registered);
//				CommonUtilities.displayMessage(context, message);
				return true;
			} catch (IOException e) {
				// Here we are simplifying and retrying on any error; in a real
				// application, it should retry only on unrecoverable errors

				Log.e(TAG, "Failed to register on attempt " + i, e);
				if (i == MAX_ATTEMPTS) {
					break;
				}
				try {
					Log.d(TAG, "Sleeping for " + backoff + " ms before retry");
					Thread.sleep(backoff);
				} catch (InterruptedException e1) {
					// Activity finished before we complete - exit.
					Log.d(TAG, "Thread interrupted: abort remaining retries!");
					Thread.currentThread().interrupt();
					return false;
				}
				// increase backoff exponentially
				backoff *= 2;
			}
		}
//		String message = context.getString(R.string.server_register_error,
//				MAX_ATTEMPTS);
//		CommonUtilities.displayMessage(context, message);
		return false;
	}

	/**
	 * Unregister this account/device pair within the server.
	 */
//	static void unregister(final Context context, final String regId) {
//		Log.i(TAG, "unregistering device (regId = " + regId + ")");
//		String serverUrl = SERVER_URL + "/unregister";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("regId", regId);
//		try {
//			post(serverUrl, params);
////			GCMRegistrar.setRegisteredOnServer(context, false);
////			String message = context.getString(R.string.server_unregistered);
////			CommonUtilities.displayMessage(context, message);
//		} catch (IOException e) {
//			// At this point the device is unregistered from GCM, but still
//			// registered in the server.
//			// We could try to unregister again, but it is not necessary:
//			// if the server tries to send a message to the device, it will get
//			// a "NotRegistered" error message and should unregister the device.
////			String message = context.getString(R.string.server_unregister_error,
////					e.getMessage());
////			CommonUtilities.displayMessage(context, message);
//		}
//	}

	/**
	 * Issue a POST request to the server.
	 * @param endpoint POST address.
	 * @param params request parameters.
	 * @throws IOException propagated from POST.
	 */
//	private static void post(String endpoint, Map<String, String> params)
//	throws IOException {
//		URL url;
//		try {
//			url = new URL(endpoint);
//		} catch (MalformedURLException e) {
//			throw new IllegalArgumentException("invalid url: " + endpoint);
//		}
//		StringBuilder bodyBuilder = new StringBuilder();
//		Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
//		// constructs the POST body using the parameters
//		while (iterator.hasNext()) {
//			Entry<String, String> param = iterator.next();
//			bodyBuilder.append(param.getKey()).append('=')
//			.append(param.getValue());
//			if (iterator.hasNext()) {
//				bodyBuilder.append('&');
//			}
//		}
//		String body = bodyBuilder.toString();
//		Log.v(TAG, "Posting '" + body + "' to " + url);
//		byte[] bytes = body.getBytes();
//		HttpURLConnection conn = null;
//		try {
//			conn = (HttpURLConnection) url.openConnection();
//			conn.setDoOutput(true);
//			conn.setUseCaches(false);
//			conn.setFixedLengthStreamingMode(bytes.length);
//			conn.setRequestMethod("POST");
//			conn.setRequestProperty("Content-Type",
//			"application/x-www-form-urlencoded;charset=UTF-8");
//			// post the request
//			OutputStream out = conn.getOutputStream();
//			out.write(bytes);
//			out.close();
//			// handle the response
//			int status = conn.getResponseCode();
//			if (status != 200) {
//				throw new IOException("Post failed with error code " + status);
//			}
//		} finally {
//			if (conn != null) {
//				conn.disconnect();
//			}
//		}
//	}


	public static void postData(String s,String version,String appName) throws MalformedURLException {
		// Create a new HttpClient and Post Header

		HttpPost httppost = new HttpPost("http://203.190.149.92/MADPlatform/Services/PostDeviceId.aspx");

		try {
			HttpParams httpParams = new BasicHttpParams();
			int some_reasonable_timeout = 8000;
			HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
			HttpClient httpclient = new DefaultHttpClient(httpParams);
			// Add your data
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("ClientCode", MyUIApplication.ClientCode));
			nameValuePairs.add(new BasicNameValuePair("EventCode", MyUIApplication.EventCode));
			nameValuePairs.add(new BasicNameValuePair("OSCode", "OS002"));
			nameValuePairs.add(new BasicNameValuePair("DeviceID", s));
			nameValuePairs.add(new BasicNameValuePair("Badge", "false"));
			nameValuePairs.add(new BasicNameValuePair("TimeZone", TimeZone.getDefault().getID()));
			nameValuePairs.add(new BasicNameValuePair("DeviceType", "false"));
			nameValuePairs.add(new BasicNameValuePair("InstallationId", "false"));
			nameValuePairs.add(new BasicNameValuePair("ChannelURI", "false"));
			nameValuePairs.add(new BasicNameValuePair("AppName", appName));
			nameValuePairs.add(new BasicNameValuePair("AppVersion",version ));
			nameValuePairs.add(new BasicNameValuePair("AppIdentifire", "false"));
			
			MyUIApplication.LoggerToSD("PushNotificatio", "Enable push notification For-->");
			MyUIApplication.LoggerToSD("PushNotificatio_Client COde", MyUIApplication.ClientCode);
			MyUIApplication.LoggerToSD("PushNotificatio_Event Code", MyUIApplication.EventCode);
			MyUIApplication.LoggerToSD("PushNotificatio_Device Id", s);

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));

			// Execute HTTP Post Request
			HttpResponse response =   httpclient.execute(httppost);
			String message = EntityUtils.toString(response.getEntity());
			System.out.println(""+message);
			
			if(message.equalsIgnoreCase("DeviceID Saved") || message.equalsIgnoreCase("DeviceID Already Exist")){
				MyUIApplication.pref.setPushStatus(MyUIApplication.ClientCode+"_"+MyUIApplication.EventCode);
				Log.e("Server Utility", "Saving Device id in preference !!" +s);
				MyUIApplication.pref.saveDeviceId(s);
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
}





