package com.example.grocery.fragments;

import java.util.ArrayList;
import java.util.List;

import com.example.grocery.MainActivity;
import com.example.grocery.R;
import com.example.grocery.adapter.CatListAdapter;
import com.example.grocery.model.CatListModel;
import com.example.grocery.utils.Singleton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Category_Fragment extends Fragment {

	public List<CatListModel> catModelList = new ArrayList<CatListModel>();
	private ListView listView;
	public TextView rest_cnt, location, no_rest;
	public ImageView loc_edit;
	public ProgressBar progressbar;
	public RelativeLayout rel_pr;
	private CatListAdapter adapter;

	public String cat_name;
	public String cat_id;

	// Shared Preferences
	public static SharedPreferences pref;

	// Editor for Shared preferences
	Editor editor;

	// Shared pref mode
	int PRIVATE_MODE = 0;

	View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = inflater.inflate(R.layout.category_list, container, false);
		System.out.println(" category Fragment ");
		InitUI();
		return rootView;
	}

	protected void sharedPrefernces() {

		pref = this.getActivity().getSharedPreferences("Grocery", PRIVATE_MODE);
		editor = pref.edit();
		editor.putString("cat_id", Singleton.cat_id);
		editor.putString("cat_name", Singleton.cat_name);
		editor.putString("cat_img", Singleton.cat_img);

		editor.commit();

	}

	private void InitUI() {

		location = (TextView) rootView.findViewById(R.id.location);
		listView = (ListView) rootView.findViewById(R.id.list_categories);
		loc_edit = (ImageView) rootView.findViewById(R.id.edit);
		rel_pr = (RelativeLayout) rootView.findViewById(R.id.rel_pr);
		adapter = new CatListAdapter(getActivity(), catModelList);
		listView.setAdapter(adapter);

		location.setText(Singleton.Spn_CountryName + ", "
				+ Singleton.Spn_LocationName);
		
		loc_edit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Intent i = new Intent(packageContext, cls)
				
			}
		});

		catModelList.clear();

		CatListModel catlistModel = new CatListModel();

		catlistModel.setcat_Name("Tata Tea");
		catlistModel.setcat_Add("Nehru nagar");
		catlistModel.setcat_Price("Rs 150");
		catlistModel.setcat_Qnty("100g");
		//catlistModel.setcat_ThumbnailUrl(R.drawable.tea);

		catModelList.add(catlistModel);

		CatListModel catlistModel1 = new CatListModel();

		catlistModel.setcat_Name("Turmeric");
		catlistModel.setcat_Add("Durg");
		catlistModel.setcat_Price("Rs 50");
		catlistModel.setcat_Qnty("50g");		

		catModelList.add(catlistModel1);

		if (catModelList.size() > 0) {

			rel_pr.setVisibility(View.INVISIBLE);
		} else {
			rel_pr.setVisibility(View.VISIBLE);
		}

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				Singleton.cat_id = catModelList.get(position).getcat_Id();
				Singleton.cat_name = catModelList.get(position).getcat_Name();
				// Singleton.cat_img =
				// catModelList.get(position).getcat_ThumbnailUrl();

				sharedPrefernces();

				/*
				 * Singleton.previousfragment = "FoodsFragmentt";
				 * Singleton.currentfragment = "MenuList"; 
				

				MainActivity.mManager = getActivity()
						.getSupportFragmentManager();
				MainActivity.swipeFragment(new SubCat_Fragment()); */
				
				Intent i = new Intent(getActivity(), SubCat_Tabs_Fragment.class);
				getActivity().startActivity(i);
				
				
			}

		});

	}

}
