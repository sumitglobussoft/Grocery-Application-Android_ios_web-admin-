package com.example.grocery.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.grocery.R;

public class Notification_Fragment extends Fragment{
	

	
	View rootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.notification, container, false);
		System.out.println(" notification Fragment ");
		InitUI();
		return rootView;
	}
	
	private void InitUI() {
		
	}



}
