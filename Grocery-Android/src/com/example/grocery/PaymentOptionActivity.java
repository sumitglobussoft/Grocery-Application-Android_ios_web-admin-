package com.example.grocery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class PaymentOptionActivity extends Activity {
	
	ImageView mk_payment, bkbtn_pay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	  setContentView(R.layout.payment_options);
	  
	  InitUi();
	}

	private void InitUi() {
		
		mk_payment = (ImageView) findViewById(R.id.mk_payment);
		bkbtn_pay = (ImageView) findViewById(R.id.bkbtn_pay);
		
		mk_payment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(PaymentOptionActivity.this, PayByCard.class);
				startActivity(i);
				
			}
		});
		
		bkbtn_pay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
								
			}
		});
		
	}
}
