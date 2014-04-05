package com.fhooe.mc.interactivetechnologies.ucpisfun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContentActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		
		TextView title = (TextView) findViewById(R.id.content_title);
		TextView text = (TextView) findViewById(R.id.content_text);
		
		title.setText("The title according to each level");
		text.setText("the content the user has to absorb in order to answer the questions and complete the quiz");
	}
	
	public void skipButton(View v){
		Intent intent = new Intent(this, QuestionActivity.class);
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
