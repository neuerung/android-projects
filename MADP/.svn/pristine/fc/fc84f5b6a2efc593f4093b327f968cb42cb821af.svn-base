package mobi.neuerung.Util;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

public class UtilMail
{
	public void OpenMail(Context context , String mailto ,String cc,String bcc, String body , String subject)
	{
		String[] to = mailto.split(",");
		String[] ccperson = cc.split(",");
		String[] bccperson = bcc.split(",");
		mail(subject, body , to, ccperson, bccperson, context);
	}
	
	public static void mail(String subject,String body,String[] to,String[] cc,String[] bcc,Context context)
	{
		Intent email = new Intent(Intent.ACTION_SEND);
		email.putExtra(Intent.EXTRA_EMAIL, to);
		email.putExtra(Intent.EXTRA_CC, cc);
		email.putExtra(Intent.EXTRA_BCC,bcc);
		email.putExtra(Intent.EXTRA_SUBJECT, subject);
		email.putExtra(Intent.EXTRA_TEXT, body);

		//need this to prompts email client only
		email.setType("message/rfc822");
		final PackageManager pm = context.getPackageManager();
		final List<ResolveInfo> matches = pm.queryIntentActivities(email, 0);
		ResolveInfo best = null;
		for (final ResolveInfo info : matches)
			if (info.activityInfo.packageName.endsWith(".gm") ||
					info.activityInfo.name.toLowerCase().contains("gmail")) best = info;
		if (best != null)
			email.setClassName(best.activityInfo.packageName, best.activityInfo.name);
		//		  context.startActivity(Intent.createChooser(email, "Choose an Email client :"));
		context.startActivity(email);
	}
}
