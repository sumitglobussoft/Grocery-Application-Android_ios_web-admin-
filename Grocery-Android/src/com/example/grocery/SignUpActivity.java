package com.example.grocery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpActivity extends Activity {

	TextView login, skip;
	ImageView signup_fbk, signup_twt, signUp_btn;
	EditText signup_email, signup_name, signup_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);

		InitUi();
	}

	private void InitUi() {

		login = (TextView) findViewById(R.id.txt_login);
		skip = (TextView) findViewById(R.id.signup_skip);
		signup_fbk = (ImageView) findViewById(R.id.signup_fbk);
		signup_twt = (ImageView) findViewById(R.id.signup_twt);
		signUp_btn = (ImageView) findViewById(R.id.signup_button);
		signup_email = (EditText) findViewById(R.id.signup_email);
		signup_name = (EditText) findViewById(R.id.signup_name);
		signup_password = (EditText) findViewById(R.id.signup_passowrd);

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
				startActivity(i);

			}
		});

		skip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(SignUpActivity.this, FetchLocation.class);
				startActivity(i);
			}
		});

	}
}
