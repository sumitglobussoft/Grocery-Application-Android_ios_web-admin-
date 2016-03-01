package com.example.grocery;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class PayByCard extends Activity{
	
	ImageView place_order, bkbtn_pay_card;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.pay_card);
	InitUi();
	}
	
	private void InitUi()
	{
		place_order = (ImageView) findViewById(R.id.img_place_order);
		bkbtn_pay_card = (ImageView) findViewById(R.id.bkbtn_pay_card);
		
		place_order.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(PayByCard.this, OrderConfirmActivity.class);
				startActivity(i);
				
			}
		});
		
		bkbtn_pay_card.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 onBackPressed();
			}
		});
	}

}
