package com.nobert.webview.testapp;


import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebClient extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView viewi,String Url){
		if(Uri.parse(Url).getHost().endsWith("care.php,disease.php,index.php,report.php" 	)) {
			
			return false;
		}
	
	
		Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(Url));
		viewi.getContext().startActivity(intent);
		return true;
		
	}
	
}
