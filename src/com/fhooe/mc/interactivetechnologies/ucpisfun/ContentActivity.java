package com.fhooe.mc.interactivetechnologies.ucpisfun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
}
