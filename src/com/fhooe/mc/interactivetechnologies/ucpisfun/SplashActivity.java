package com.fhooe.mc.interactivetechnologies.ucpisfun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		//the splash screen will be displayed for only 1 sec
		//use a thread to realize the splash screen
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent intent = new Intent(SplashActivity.this, MainActivity.class);
					startActivity(intent);
				}
			}
		};
		timer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	protected void onPause(){
		super.onPause();
		finish();
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		finish();
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		finish();
	}

}
