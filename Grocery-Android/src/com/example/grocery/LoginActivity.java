package com.example.grocery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends Activity {
	
	TextView signup, skip;
	ImageView login_fbk, login_twt, login_btn;
	EditText login_email, login_password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		InitUi();
	}
	
	private void InitUi() {
		
		login_email = (EditText) findViewById(R.id.login_email);
		login_password = (EditText) findViewById(R.id.login_passowrd);
		login_btn = (ImageView) findViewById(R.id.login_button);
		login_fbk = (ImageView) findViewById(R.id.login_fbk);
		login_twt = (ImageView) findViewById(R.id.login_twt);
		signup = (TextView) findViewById(R.id.nu_signup);
		skip = (TextView) findViewById(R.id.login_skip);
		
		signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
				startActivity(i);
				
			}
		});
		
		skip.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(LoginActivity.this, FetchLocation.class);
				startActivity(i);
				
			}
		});
		
	}


}
