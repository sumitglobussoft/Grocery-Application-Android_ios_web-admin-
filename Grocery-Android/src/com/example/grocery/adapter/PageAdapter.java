package com.example.grocery.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
	
	 private List<Fragment> fragments;

	public PageAdapter(FragmentManager fm, List<Fragment> fragments) {
		// TODO Auto-generated constructor stub
		super(fm);		
		 this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		 return this.fragments.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.fragments.size();
	}

}
