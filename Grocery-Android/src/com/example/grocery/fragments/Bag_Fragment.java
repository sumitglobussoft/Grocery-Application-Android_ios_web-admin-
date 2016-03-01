package com.example.grocery.fragments;

import com.example.grocery.DeliveryAddress;
import com.example.grocery.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;

public class Bag_Fragment extends Fragment {

	ImageView chkout;

	View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.cart, container, false);
		System.out.println(" bag Fragment ");
		InitUI();
		return rootView;
	}

	private void InitUI() {
		
		chkout = (ImageView) rootView.findViewById(R.id.chkout);
		
		chkout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				 Intent i = new Intent(getActivity(), DeliveryAddress.class);
			        startActivity(i);
				
			}
		});

	}

}
