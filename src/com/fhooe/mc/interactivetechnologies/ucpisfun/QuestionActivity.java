package com.fhooe.mc.interactivetechnologies.ucpisfun;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class QuestionActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//referencing the activity's views 
		setContentView(R.layout.activity_question);
		TextView levelTitle = (TextView) findViewById(R.id.level_title);
		
		Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
		
		TextView question = (TextView) findViewById(R.id.question);
		TextView answer_a = (TextView) findViewById(R.id.answer_a);
		TextView answer_b = (TextView) findViewById(R.id.answer_b);
		TextView answer_c = (TextView) findViewById(R.id.answer_c);
		TextView answer_d = (TextView) findViewById(R.id.answer_d);
		
		Button btnA = (Button) findViewById(R.id.btn_a);
		Button btnB = (Button) findViewById(R.id.btn_b);
		Button btnC = (Button) findViewById(R.id.btn_c);
		Button btnD = (Button) findViewById(R.id.btn_d);
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
