package com.example.grocery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.grocery.adapter.ExpandableNavListAdapter;
import com.example.grocery.adapter.SearchAdapter;
import com.example.grocery.fragments.Bag_Fragment;
import com.example.grocery.fragments.Category_Fragment;
import com.example.grocery.fragments.Notification_Fragment;
import com.example.grocery.fragments.SubCat_Tabs_Fragment;
import com.example.grocery.model.CatListModel;
import com.example.grocery.model.LeftNavDrawerItems;
import com.example.grocery.ui.MyCallBack;
import com.example.grocery.utils.ConstantUrl;
import com.example.grocery.utils.Singleton;
import com.example.grocery.model.LeftNavDrawerItems;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity implements MyCallBack {

	public static int mBagCount, mNotificationsCount = 0;
	private String[] mDrawerTitles;
	private TypedArray mDrawerIcons;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	public static CharSequence mTitle;
	boolean doubleBackToExitPressedOnce;
	public static FragmentManager mManager;

	public static Context context;
	public static ImageView search_btn;
	public static Toolbar toolbar;
	EditText editTextBox;
	SearchAdapter search_adapter;
	List<CatListModel> rlm = new ArrayList<CatListModel>();
	public ListView searclist;
	public TextView no_productsl;

	private ExpandableListView mDrawerList;
	private ArrayList<LeftNavDrawerItems> drawerItems;
	private ExpandableNavListAdapter exDrawerAdapter;

	private List<String> listDrawerHeader;
	// HashMap<String, List<LeftNavDrawerItems>> listDrawerChild;
	HashMap<String, List<String>> listDrawerChild;

	Dialog dialog;

	// public JSONParser parser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dialog = new Dialog(MainActivity.this);
		// parser = new JSONParser();

		// dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.MATCH_PARENT);

		dialog.setContentView(R.layout.dialog_search);

		// Fragment home = new Home_Fragment();
		mManager = getSupportFragmentManager();

		FragmentTransaction ftran = mManager.beginTransaction();
		ftran.replace(R.id.frame_container, new Category_Fragment()).commit();

		/*
		 * @Override public void onBackPressed() { int fragments =
		 * getFragmentManager().getBackStackEntryCount(); if (fragments == 1) {
		 * finish(); } super.onBackPressed(); }
		 */

		toolbar = (Toolbar) findViewById(R.id.toolbar);

		if (toolbar != null)
			setSupportActionBar(toolbar);

		// Singleton.myCallBack = this;

		context = getApplicationContext();

		mDrawerTitles = getResources().getStringArray(
				R.array.left_nav_drawer_items);
		drawerItems = new ArrayList<LeftNavDrawerItems>();

		mDrawerList = (ExpandableListView) findViewById(R.id.exlist_slidermenu);
		
		prepareListData();

		/*for (int i = 0; i < mDrawerTitles.length; i++) {

			drawerItems.add(new LeftNavDrawerItems(mDrawerTitles[i],
					mDrawerIcons.getResourceId(i, -(i + 1))));
		}*/

		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		toolbar, /* nav drawer icon to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description */
		R.string.drawer_close /* "close drawer" description */)

		{

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getSupportActionBar().setTitle(mTitle);
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getSupportActionBar().setTitle(mDrawerTitle);
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		LayoutInflater inflater = getLayoutInflater();

		final ViewGroup header = (ViewGroup) inflater.inflate(
				R.layout.leftdrawer_header, mDrawerList, false);		

		TextView name_text = (TextView) header.findViewById(R.id.location);

		if (Singleton.firstName != null) {
			name_text.setText(Singleton.location);
			/*
			 * if (!Singleton.firstName.equals("")) {
			 * footer.setVisibility(View.INVISIBLE); }
			 */
		}

		// mDrawerList.addHeaderView(header, null, true); // true = clickable
		// mDrawerList.addFooterView(footer, null, true); // true = clickable

		DrawerLayout.LayoutParams lp = (DrawerLayout.LayoutParams) mDrawerList
				.getLayoutParams();
		lp.width = calculateDrawerWidth();

		mDrawerList.setLayoutParams(lp);
		
		prepareListData();

		mDrawerList.setAdapter(new ExpandableNavListAdapter(
				getApplicationContext(), listDrawerHeader, listDrawerChild));
	

		/*mDrawerList.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// TODO Auto-generated method stub

				exDrawerAdapter.notifyDataSetChanged();

				Singleton.cat = drawerItems.get(groupPosition).getTitle();
				Singleton.cat_id = drawerItems.get(groupPosition).getTitleId();

				System.out.println("cat ==  " + Singleton.sub_cat);
				System.out.println("cat_ID == " + Singleton.sub_cat_id);
				System.out.println(listDrawerHeader.get(groupPosition) + " : "
						+ listDrawerHeader.get(groupPosition));
				Toast.makeText(
						getApplicationContext(),
						listDrawerHeader.get(groupPosition) + " : "
								+ listDrawerHeader.get(groupPosition),
						Toast.LENGTH_SHORT).show();
				//selectItem(groupPosition);
				return false;
			}
		});*/
		
		mDrawerList.setOnGroupExpandListener(new OnGroupExpandListener() {
			@Override
			public void onGroupExpand(int groupPosition) {
				// TODO Auto-generated method stub

				exDrawerAdapter.open.setVisibility(View.INVISIBLE);
				exDrawerAdapter.close.setVisibility(View.VISIBLE);

			}
		});

		mDrawerList.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				// TODO Auto-generated method stub

				exDrawerAdapter.open.setVisibility(View.VISIBLE);
				exDrawerAdapter.close.setVisibility(View.INVISIBLE);

			}
		});

		mDrawerList.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub

				exDrawerAdapter.notifyDataSetChanged();

				Singleton.sub_cat_name = drawerItems.get(childPosition).getTitle();
				Singleton.sub_cat_id = drawerItems.get(childPosition)
						.getTitleId();

				System.out.println("sub_cat ==  " + Singleton.sub_cat_name);
				System.out.println("sub_cat_ID == " + Singleton.sub_cat_id);
				System.out.println(listDrawerHeader.get(groupPosition)
						+ " : "
						+ listDrawerChild.get(
								listDrawerHeader.get(groupPosition)).get(
								childPosition));
				Toast.makeText(
						getApplicationContext(),
						listDrawerHeader.get(groupPosition)
								+ " : "
								+ listDrawerChild.get(
										listDrawerHeader.get(groupPosition))
										.get(childPosition), Toast.LENGTH_SHORT)
						.show();
				return false;
			}
		});

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportActionBar().setHomeButtonEnabled(true);

		// Fragment fragment = new Home_Fragment();
		// swipeFragment(fragment);

		/*
		 * if (ConstantUrl.isNetworkAvailable(getApplicationContext())) {
		 * if(Singleton.user_id != null && Singleton.hotel_id != null) {
		 * fetchBagCount(Singleton.user_id, Singleton.hotel_id); } } else {
		 * Toast.makeText(getApplicationContext(),
		 * "Please check your internet connection", Toast.LENGTH_SHORT).show();
		 * }
		 */

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
		// trySetupSwipeRefresh();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/* Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the nav drawer is open, hide action items related to the content
		// view
		System.out.println("onPrepareOptionsMenu ");
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_search).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);

	}

	private void selectItem(int position) {

		Fragment fragment = null;

		switch (position) {

		case 0:
			// Profile details
			System.out.println("Clicked on profile");
			// fragment = new FoodsFragment();
			break;

		case 1:
			// Home
			System.out.println("Clicked on Home");
			fragment = new Category_Fragment();

			break;

		default:
			fragment = new Category_Fragment();
			break;
		}

		if (fragment != null) {
			// Insert the fragment by replacing any existing fragment
			mManager.beginTransaction().replace(R.id.frame_container, fragment)
					.commit();
			// swipeFragment(fragment);
		}

		// Highlight the selected item, update the title, and close the drawer
		mDrawerList.setItemChecked(position, true);

		if (position != 0) {
			setTitle(mDrawerTitles[position - 1]);
		}

		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);

		// Get the notifications MenuItem and LayerDrawable (layer-list)

		if (Build.VERSION.SDK_INT >= 16) {
			MenuItem item = menu.findItem(R.id.action_bag);
		//	LayerDrawable icon = (LayerDrawable) item.getIcon();

			// Update LayerDrawable's BadgeDrawable
			// Utils2.setBadgeCount(this, icon, mBagCount);
		}

		/*
		 * if (menu.getItem(3).getItemId() == R.id.action_settings) { if
		 * (Singleton.user_id.equals("")) menu.getItem(3).setTitle("Login"); }
		 */

		System.out.println("Oncreate option menu");

		return super.onCreateOptionsMenu(menu);

		// return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		System.out.println(" onOptionsItemSelected");

		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		// Respond to the action bar's Up/Home button
		case android.R.id.home:

			mDrawerToggle.setDrawerIndicatorEnabled(true);

			return true;
		}

		if (item.getItemId() == R.id.action_notification) {

			// Notification Fragment
			Fragment fragment = new Notification_Fragment();
			mManager.beginTransaction().replace(R.id.frame_container, fragment)
					.commit();

			setTitle("Notifications");
		}

		else if (item.getItemId() == R.id.action_bag) {

			System.out.println(" Bag clicked");

			// Bag Fragment

			// fetchBagCount(Singleton.user_id, Singleton.hotel_id);

			Fragment fragment = new Bag_Fragment();
			mManager.beginTransaction().replace(R.id.frame_container, fragment)
					.commit();

			setTitle("Bag");
		}

		else if (item.getItemId() == R.id.action_search) {
			rlm.clear();
			OpenLocationChnageDialog();

			setTitle("Search");
		}

		return super.onOptionsItemSelected(item);
	}

	public int calculateDrawerWidth() {
		// Calculate ActionBar height
		TypedValue tv = new TypedValue();
		int actionBarHeight = 0;
		if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
			actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,
					getResources().getDisplayMetrics());
		}

		Display display = getWindowManager().getDefaultDisplay();
		int width;
		int height;
		if (android.os.Build.VERSION.SDK_INT >= 13) {
			Point size = new Point();
			display.getSize(size);
			width = size.x;
			height = size.y;
		} else {
			width = display.getWidth(); // deprecated
			height = display.getHeight(); // deprecated
		}
		return width - actionBarHeight;
	}

	public static void swipeFragment(Fragment fragment) {

		mManager.beginTransaction().replace(R.id.frame_container, fragment)
				.addToBackStack(null).commit();
	}

	static Handler handler = new Handler();

	@Override
	public void executeThis() {
		// TODO Auto-generated method stub
		handler.post(new Runnable() {

			@Override
			public void run() {

				mDrawerToggle.setDrawerIndicatorEnabled(false);
			}
		});

	}

	public void updateNotificationsBadge(int count) {
		// mNotificationsCount = count;

		mBagCount = count;
		// force the ActionBar to relayout its MenuItems.
		// onCreateOptionsMenu(Menu) will be called again.
		invalidateOptionsMenu();
	}

	public void OpenLocationChnageDialog() {

		editTextBox = (EditText) dialog.findViewById(R.id.editbox);
		searclist = (ListView) dialog.findViewById(R.id.list);
		search_btn = (ImageView) dialog.findViewById(R.id.search_btn);
		no_productsl = (TextView) dialog.findViewById(R.id.no_products);

		search_adapter = new SearchAdapter(getApplicationContext(), rlm);
		searclist.setAdapter(search_adapter);

		// enables filtering for the contents of the given ListView
		searclist.setTextFilterEnabled(true);

		searclist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Singleton.srch_selected_name = rlm.get(position).getcat_Name();

				System.out.println("Singleton.srch_selected_name == "
						+ Singleton.srch_selected_name);

				// Singleton.previousfragment = "Product_List";
				// Singleton.currentfragment = "SelectedProductDetails";
				/*
				 * Fragment fragment = new SelectedProductDetails();
				 * mManager.beginTransaction().add(R.id.frame_container,
				 * fragment) .addToBackStack(null).commit();
				 */

				Fragment fragment = new Category_Fragment();
				mManager.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();
				dialog.dismiss();

			}
		});

		editTextBox.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// search_adapter.getFilter().filter(s.toString());
				search_adapter.getItem(start).toString();

			}
		});

		search_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// rlm.clear();
				// search_adapter.notifyDataSetChanged();

				if (!editTextBox.getText().toString().trim().isEmpty()) {

					/*
					 * new
					 * FetchProducts().execute(editTextBox.getText().toString
					 * ().trim());
					 */

					// searchRestName();

				} else {
					editTextBox.setError("please give restaurant name");
				}

			}
		});

		if (ConstantUrl.isNetworkAvailable(getApplicationContext())) {
			// new FetchProducts().execute();

			// searchRestName();

		} else {
			Toast.makeText(getApplicationContext(),
					"Please check internet connection!!", Toast.LENGTH_SHORT)
					.show();
		}

		dialog.show();

	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
		System.out.println("setTitle");

	}

	private void prepareListData() {

		listDrawerHeader = new ArrayList<String>();
		listDrawerChild = new HashMap<String, List<String>>();

		// Adding cat data
		listDrawerHeader.add("Fruits");
		listDrawerHeader.add("Vegetables");
		listDrawerHeader.add("Drinks");
		listDrawerHeader.add("Milk Products");
		listDrawerHeader.add("Dry Fruits");		

		List<String> fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Mango");
		fruits.add("Banana");
		fruits.add("Grapes");

		List<String> veg = new ArrayList<String>();
		veg.add("Tomato");
		veg.add("Potato");
		veg.add("Chilli");
		veg.add("Onion");
		veg.add("Spinach");
		
		List<String> Drinks = new ArrayList<String>();
		Drinks.add("Tea");
		Drinks.add("Coffee");
		Drinks.add("Health drinks");
		Drinks.add("Soft drinks");
		
		List<String> milk_products = new ArrayList<String>();
		milk_products.add("Cheese");
		milk_products.add("Curd");
		milk_products.add("Paneer");
		milk_products.add("Butter Milk");
		
		List<String> dry_fruits = new ArrayList<String>();
		dry_fruits.add("Chashew");
		dry_fruits.add("Badam");
		dry_fruits.add("Fig");
		dry_fruits.add("Pista");
		dry_fruits.add("Apricot");
				

		listDrawerChild.put(listDrawerHeader.get(0), fruits);
		listDrawerChild.put(listDrawerHeader.get(1), veg);
		listDrawerChild.put(listDrawerHeader.get(2), Drinks);
		listDrawerChild.put(listDrawerHeader.get(3), milk_products);
		listDrawerChild.put(listDrawerHeader.get(4), dry_fruits);

		// fetchcatNames();

	}

	/*public static void swipeFragment1(SubCat_Tabs_Fragment subCat_Tabs_Fragment) {
		// TODO Auto-generated method stub
		mManager.beginTransaction().replace(R.id.frame_container, subCat_Tabs_Fragment)
		.addToBackStack(null).commit();
		
	}*/
}
