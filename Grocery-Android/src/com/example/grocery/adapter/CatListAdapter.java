package com.example.grocery.adapter;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.grocery.R;
import com.example.grocery.api.AppController;
import com.example.grocery.model.CatListModel;
import com.example.grocery.model.SubCatListModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CatListAdapter extends BaseAdapter {

	private Activity activity;
	private LayoutInflater inflater;
	public  List<CatListModel> catListItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public CatListAdapter(Activity activity,
			List<CatListModel> catListItems) {
		this.activity = activity;
		this.catListItems = catListItems;
		
		//System.out.println("No. of restaurants open >>>>>> "+restaurantListItems.size());
	}

	@Override
	public int getCount() {
		
		//Singleton.Restaurant_cnt = Integer.toString(restaurantListItems.size());
		
		return catListItems.size();
	}
	
	
	@Override
	public Object getItem(int location) {
		return catListItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.category_list_item, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		
		NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.cat_thumbnail);
		TextView cat_name = (TextView) convertView.findViewById(R.id.cat_name);
		TextView cat_qnt = (TextView) convertView.findViewById(R.id.cat_qnty);
		TextView cat_price = (TextView) convertView.findViewById(R.id.cat_price);	
		TextView cat_add = (TextView) convertView.findViewById(R.id.cat_add);

		
		CatListModel m = catListItems.get(position);
		
	//	thumbNail.setImageUrl(m.getcat_ThumbnailUrl(), imageLoader);
		cat_name.setText(m.getcat_Name());
		cat_add.setText(m.getcat_Add());
		cat_qnt.setText(m.getcat_Qnty());
		cat_price.setText(m.getcat_Price());
		return convertView;
	}





}
