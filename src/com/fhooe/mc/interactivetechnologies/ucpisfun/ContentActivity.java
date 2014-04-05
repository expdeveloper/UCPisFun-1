package com.fhooe.mc.interactivetechnologies.ucpisfun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContentActivity extends Activity {
	private int levelNum = -1;
	private String subTitle = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		
		//gets the level number 
		Bundle bundle = getIntent().getExtras();
		if(bundle != null){
			levelNum = bundle.getInt("level");
			subTitle = bundle.getString("sub");
		}
		
		TextView title = (TextView) findViewById(R.id.content_title);
		TextView text = (TextView) findViewById(R.id.content_text);
		
		title.setText("Level #" + levelNum + ": " + subTitle);
		
//		TO DO ... SET THE CONTENT ACCORDINGLY
		text.setText(R.string.content1);
	}
	
	public void skipButton(View v){
		Intent intent = new Intent(this, QuestionActivity.class);
		intent.putExtra("level", levelNum);
		intent.putExtra("sub", subTitle);
		startActivity(intent);
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
