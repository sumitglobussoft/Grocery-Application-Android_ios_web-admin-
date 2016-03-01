package com.example.grocery.adapter;

import java.util.List;

import com.example.grocery.R;
import com.example.grocery.model.CatListModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SearchAdapter extends BaseAdapter {
	

	private Context context;
	private List<CatListModel> heightList;  // create separate model for search (foods and groceries)
	 
	TextView height;
	
	private LayoutInflater inflater;
	 
	public SearchAdapter(Context context, List<CatListModel> bpm)
	{
		this.context=context;
		this.heightList = bpm;
		 
	}

	@Override
	public int getCount() {
		return heightList.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return heightList.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		
		
		if (inflater == null)
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.dialog_search_item, null);

		height = (TextView) convertView.findViewById(R.id.heighttextview);
		
		height.setText(heightList.get(position).getcat_Name());
	
		return convertView;
	}

	
}
