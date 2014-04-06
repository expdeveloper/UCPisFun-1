package com.fhooe.mc.interactivetechnologies.ucpisfun;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class QuestionActivity extends Activity {
	private int levelNum = -1;
	private String subTitle = "";
	private int currentQuestion = 1;
	private String correctAnswer = "";
	
	TextView question = null;
	TextView answer_a = null;
	TextView answer_b = null;
	TextView answer_c = null;
	TextView answer_d = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle bundle = getIntent().getExtras();
		levelNum = bundle.getInt("level");
		subTitle = bundle.getString("sub");
		currentQuestion = bundle.getInt("currentQuestion");
		
		//referencing the activity's views 
		setContentView(R.layout.activity_question);
		TextView levelTitle = (TextView) findViewById(R.id.level_title);
		levelTitle.setText("Level #" + levelNum + ": " + subTitle);
		
		question = (TextView) findViewById(R.id.question);
		answer_a = (TextView) findViewById(R.id.answer_a);
		answer_b = (TextView) findViewById(R.id.answer_b);
		answer_c = (TextView) findViewById(R.id.answer_c);
		answer_d = (TextView) findViewById(R.id.answer_d);
		
		Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
		
		//set questions and answers according to the level num
		questionAndAnswersSetUp(levelNum, currentQuestion);
		
		Button btnA = (Button) findViewById(R.id.btn_a);
		Button btnB = (Button) findViewById(R.id.btn_b);
		Button btnC = (Button) findViewById(R.id.btn_c);
		Button btnD = (Button) findViewById(R.id.btn_d);
		
		btnA.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				decideCorrectOrWrong(v);
			}
		});
		
		btnB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				decideCorrectOrWrong(v);
			}
		});
		
		btnC.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				decideCorrectOrWrong(v);
			}
		});
		
		btnD.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				decideCorrectOrWrong(v);
			}
		});
	}
	
	public void questionAndAnswersSetUp(int _levelNum, int _currentQuestion){
		if(_levelNum == 1){
			if(_currentQuestion == 1){
				//set question
				question.setText(R.string.l1_q1);
				//set choices 
				answer_a.setText(R.string.l1_q1_a1);
				answer_b.setText(R.string.l1_q1_a2);
				answer_c.setText(R.string.l1_q1_a3);
				answer_d.setText(R.string.l1_q1_a4);
				//set correct answer
				correctAnswer = getResources().getString(R.string.l1_q1_correct);
			}else if(_currentQuestion == 2){
				//set question
				question.setText(R.string.l1_q2);
				//set choices 
				answer_a.setText(R.string.l1_q2_a1);
				answer_b.setText(R.string.l1_q2_a2);
				answer_c.setText(R.string.l1_q2_a3);
				answer_d.setText(R.string.l1_q2_a4);
				//set correct answer
				correctAnswer = getResources().getString(R.string.l1_q2_correct);
			}else if(_currentQuestion == 3){
				//set question
				question.setText(R.string.l1_q3);
				//set choices 
				answer_a.setText(R.string.l1_q3_a1);
				answer_b.setText(R.string.l1_q3_a2);
				answer_c.setText(R.string.l1_q3_a3);
				answer_d.setText(R.string.l1_q3_a4);
				//set correct answer
				correctAnswer = getResources().getString(R.string.l1_q3_correct);
			}else if(_currentQuestion == 4){
				//set question
				question.setText(R.string.l1_q4);
				//set choices 
				answer_a.setText(R.string.l1_q4_a1);
				answer_b.setText(R.string.l1_q4_a2);
				answer_c.setText(R.string.l1_q4_a3);
				answer_d.setText(R.string.l1_q4_a4);
				//set correct answer
				correctAnswer = getResources().getString(R.string.l1_q4_correct);
			}else if(_currentQuestion == 5){
				//set question
				question.setText(R.string.l1_q5);
				//set choices 
				answer_a.setText(R.string.l1_q5_a1);
				answer_b.setText(R.string.l1_q5_a2);
				answer_c.setText(R.string.l1_q5_a3);
				answer_d.setText(R.string.l1_q5_a4);
				//set correct answer
				correctAnswer = getResources().getString(R.string.l1_q5_correct);
			}
			
		}else if(_levelNum == 2){
			//to do
		}else if(_levelNum == 3){
			//set question
			question.setText(R.string.l3_q1);
			//set choices 
			answer_a.setText(R.string.l3_q1_a1);
			answer_b.setText(R.string.l3_q1_a2);
			answer_c.setText(R.string.l3_q1_a3);
			answer_d.setText(R.string.l3_q1_a4);
		}else if(_levelNum == 4){
			//to do
		}
	}
	
	public void decideCorrectOrWrong(View v){
		Button b = (Button) v;
		if(correctAnswer.equalsIgnoreCase(b.getText().toString())){
			new AlertDialog.Builder(QuestionActivity.this)
		    .setTitle("Correct answer!")
		    .setPositiveButton("next question", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		        	if(currentQuestion < 6){
		        		currentQuestion++;
			        	questionAndAnswersSetUp(levelNum, currentQuestion);
		        	}else{
		        		//congratulations screen intent
		        	}
		        }
		     })
		     .show();
		}else{
			new AlertDialog.Builder(QuestionActivity.this)
		    .setTitle("Wrong answer!")
		    .setMessage("Please try again")
		    .setPositiveButton("retry", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		     .show();
		}
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
