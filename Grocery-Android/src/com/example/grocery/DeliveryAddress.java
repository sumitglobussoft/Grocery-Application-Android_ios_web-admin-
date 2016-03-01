package com.example.grocery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DeliveryAddress extends Activity
{
	ImageView cnt_pay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.delivery_add);
	    
	    InitUi();
	}
	
	private void InitUi() {
		
		cnt_pay = (ImageView) findViewById(R.id.cnt_pay);
		
		cnt_pay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(DeliveryAddress.this, PaymentOptionActivity.class);
				startActivity(i);
				
				
			}
		});
	}

}
