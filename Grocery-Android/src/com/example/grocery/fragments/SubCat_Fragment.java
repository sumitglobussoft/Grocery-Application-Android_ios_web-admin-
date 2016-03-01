package com.example.grocery.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.grocery.R;
import com.example.grocery.adapter.SubCatListAdapter;
import com.example.grocery.model.CatListModel;
import com.example.grocery.model.SubCatListModel;
import com.example.grocery.utils.Singleton;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SubCat_Fragment extends Fragment {

	public List<SubCatListModel> subcatModelList = new ArrayList<SubCatListModel>();
	private ListView listView;
	public TextView rest_cnt, location, no_rest;
	public ImageView loc_edit;
	public ProgressBar progressbar;
	public RelativeLayout rel_pr;
	private SubCatListAdapter adapter;
	View rootView;
	public String hotel_name;
	public String hotel_id;
	
	// Shared Preferences
		public static SharedPreferences pref;

		// Editor for Shared preferences
		Editor editor;

		// Shared pref mode
		int PRIVATE_MODE = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.subcat_list, container, false);
		System.out.println(" Sub cat Fragment ");
		InitUI();
		return rootView;
	}

	private void InitUI() 
	{
		listView = (ListView) rootView.findViewById(R.id.list_subcat);
		
		adapter = new SubCatListAdapter(getActivity(), subcatModelList);
		listView.setAdapter(adapter);
		
		subcatModelList.clear();

		SubCatListModel sublistModel = new SubCatListModel();

		sublistModel.setsubcat_Name("Tea");		
		sublistModel.setsubcat_Price("Rs 150");
		sublistModel.setsubcat_Qnty("100g");
		//sublistModel.setsubcat_ThumbnailUrl(subcat_ThumbnailUrl);
		

		subcatModelList.add(sublistModel);		
		
		//restModelList.clear();		

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}});

	}
	
	protected void sharedPrefernces() {

		pref   = this.getActivity().getSharedPreferences("Grocery", PRIVATE_MODE);
		editor = pref.edit();
		editor.putString("subcat_id", Singleton.sub_cat_id);
		editor.putString("subcat_name", Singleton.sub_cat_name);
		
		editor.commit();
		
		
	}

}
