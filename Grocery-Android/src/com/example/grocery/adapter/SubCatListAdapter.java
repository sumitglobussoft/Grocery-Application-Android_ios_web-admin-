package com.example.grocery.adapter;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.grocery.R;
import com.example.grocery.api.AppController;
import com.example.grocery.model.SubCatListModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SubCatListAdapter extends BaseAdapter {

	private Activity activity;
	private LayoutInflater inflater;
	public List<SubCatListModel> subcatListItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public static int i = 0;

	public SubCatListAdapter(Activity activity,
			List<SubCatListModel> subcatListItems) {
		this.activity = activity;
		this.subcatListItems = subcatListItems;

		 System.out.println("No. of subcat Items >>>>>> "+ subcatListItems.size());
	}

	@Override
	public int getCount() {

		// Singleton.Restaurant_cnt =
		// Integer.toString(restaurantListItems.size());

		return subcatListItems.size();
	}

	@Override
	public Object getItem(int location) {
		return subcatListItems.get(location);
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
			convertView = inflater.inflate(R.layout.subcat_list_item, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();

		// NetworkImageView thumbNail = (NetworkImageView)
		// convertView.findViewById(R.id.thumbnail);
		TextView subcat_name = (TextView) convertView
				.findViewById(R.id.subcat_name);
		TextView subcat_qnt = (TextView) convertView
				.findViewById(R.id.subcat_qnty);
		TextView subcat_price = (TextView) convertView
				.findViewById(R.id.subcat_price);
		final TextView subcat_qntcnt = (TextView) convertView
				.findViewById(R.id.qnt_cnt);
		ImageView subcat_minus = (ImageView) convertView
				.findViewById(R.id.qnt_minus);
		ImageView subcat_plus = (ImageView) convertView
				.findViewById(R.id.qnt_plus);

		SubCatListModel m = subcatListItems.get(position);

		// thumbNail.setImageUrl(m.getsubcat_ThumbnailUrl(), imageLoader);
		subcat_name.setText(m.getsubcat_Name());
		subcat_qnt.setText(m.getsubcat_Qnty());
		subcat_price.setText(m.getsubcat_Price());

		subcat_plus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				i++;
				subcat_qntcnt.setText(Integer.toString(i));

			}
		});

		subcat_minus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (i <= 1) {

				} else {
					i--;
					subcat_qntcnt.setText(Integer.toString(i));
				}

			}
		});
		return convertView;
	}

}
