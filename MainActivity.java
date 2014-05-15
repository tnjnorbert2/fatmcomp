package com.nobert.webview.testapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity  {
private WebView browser;
protected ProgressBar mProgressBar;
protected TextView mTextView;


	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView=(TextView)findViewById(R.id.errorTextView);
		mProgressBar =(ProgressBar)findViewById(R.id.progressBar);
		if(isNetworkAvailable()){
			mProgressBar.setVisibility(View.VISIBLE);
			//TODO create different method for the web view
			loadwebview();
			mProgressBar.setVisibility(View.INVISIBLE);

		}else{
			//mTextView.setText(R.string.error);
            mTextView.setText("nonetwork detected");

		}

	}

	@Override
	public void onBackPressed(){
		if(browser.canGoBack()){
			browser.goBack();
		}else{
			super.onBackPressed();
		}
        //ddd

		
			
	}
	
	private boolean isNetworkAvailable(){
	ConnectivityManager manager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
	NetworkInfo  networkInfo=manager.getActiveNetworkInfo();
	//TODO checking if netwotk is available
	boolean isAvailable=false;
	if(networkInfo !=null && networkInfo.isConnected()){
		isAvailable=true;
		mProgressBar.setVisibility(View.VISIBLE);
		
	}
	return isAvailable;
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	private void loadwebview(){
		mProgressBar.setVisibility(View.INVISIBLE);
		browser=(WebView)findViewById(R.id.webkit);
		WebSettings webSettings = browser.getSettings();
		webSettings.setJavaScriptEnabled(true);
		//browser.loadUrl("http://farmcompanion.cooljobsuganda.com");
		 browser.loadUrl("http://10.42.0.1/jq/");
		browser.setWebViewClient(new WebViewClient());	
		
		
	}

}
