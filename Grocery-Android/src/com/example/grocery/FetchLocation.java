package com.example.grocery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Spinner;
import android.widget.TextView;

public class FetchLocation extends Activity {
	
	Spinner select_country, select_place;
	TextView search;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);

		InitUi();
	}

	private void InitUi()
	{
		select_country = (Spinner) findViewById(R.id.spinner_country);
		select_place = (Spinner) findViewById(R.id.spinner_place);
		search = (TextView) findViewById(R.id.cat_search);
		
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(FetchLocation.this, MainActivity.class);
				startActivity(i);
				
			}
		});
		
		
	}

}
