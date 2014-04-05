package com.fhooe.mc.interactivetechnologies.ucpisfun;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class QuestionActivity extends Activity {
	private int levelNum = -1;
	private String subTitle = "";
	private String correctAnswer = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle bundle = getIntent().getExtras();
		levelNum = bundle.getInt("level");
		subTitle = bundle.getString("sub");
		
		//referencing the activity's views 
		setContentView(R.layout.activity_question);
		TextView levelTitle = (TextView) findViewById(R.id.level_title);
		levelTitle.setText("Level #" + levelNum + ": " + subTitle);
		
		TextView question = (TextView) findViewById(R.id.question);
		TextView answer_a = (TextView) findViewById(R.id.answer_a);
		TextView answer_b = (TextView) findViewById(R.id.answer_b);
		TextView answer_c = (TextView) findViewById(R.id.answer_c);
		TextView answer_d = (TextView) findViewById(R.id.answer_d);
		
		Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
		
		//set questions and answers according to the level num
		if(levelNum == 1){
			//set correctAnswer
			correctAnswer = "d";
			//set question
			question.setText(R.string.l1_q1);
			//set choices 
			answer_a.setText(R.string.l1_q1_a1);
			answer_b.setText(R.string.l1_q1_a2);
			answer_c.setText(R.string.l1_q1_a3);
			answer_d.setText(R.string.l1_q1_a4);
			
		}else if(levelNum == 2){
			//to do
		}else if(levelNum == 3){
			//set correctAnswer
			correctAnswer = "d";
			//set question
			question.setText(R.string.l3_q1);
			//set choices 
			answer_a.setText(R.string.l3_q1_a1);
			answer_b.setText(R.string.l3_q1_a2);
			answer_c.setText(R.string.l3_q1_a3);
			answer_d.setText(R.string.l3_q1_a4);
		}else if(levelNum == 4){
			//to do
		}
		
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
