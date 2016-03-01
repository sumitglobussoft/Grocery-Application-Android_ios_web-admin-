package com.example.grocery;

import android.app.Activity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.grocery.ui.AppLocationService;
import com.example.grocery.ui.LocationAddress;
import com.example.grocery.utils.ConstantUrl;
import com.example.grocery.utils.Singleton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class SplashscreenActivity extends Activity implements LocationListener {

	int timeDelay = 2000;

	private Location location;
	private AppLocationService appLocationService;
	private LocationManager locationManager;
	private String provider;
	// The minimum distance to change Updates in meters
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
	// The minimum time between updates in milliseconds
	private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
	private double longitude, latitude;

	// private SharedPreferences preferences;
	private SharedPreferences.Editor editor;

	// static boolean login_status = false;

	// private SpotsDialog spotsdialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		setContentView(R.layout.splashscreen);

		// Get Current Location of User
		appLocationService = new AppLocationService(SplashscreenActivity.this);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);

		if (ConstantUrl.isNetworkAvailable(SplashscreenActivity.this)) 
		{
			if (location != null) 
			{
				onLocationChanged(location);
			} 
			else 
			{
				System.out.println("location is null");
			}

		} 
		else 
		{
			System.out.println(" NO internet available");
		}
		
		// date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss",
				Locale.getDefault());
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date = new Date();		
		Singleton.date = dateFormat.format(date); 		
		
		System.out.println("Singleton.date == "+Singleton.date);
		/*
		Timestamp ts = new Timestamp(date.getTime());					
		Singleton.timestamp = ts.toString();		
		System.out.println("Singleton.timestamp == "+Singleton.timestamp);	*/	

		// retrieve data

	/*	SharedPreferences preferences= this.getSharedPreferences("Grocery", MODE_PRIVATE);		
			
		Singleton.name = preferences.getString("Username", null);
		Singleton.email = preferences.getString("email", null);
		Singleton.pass = preferences.getString("Password", null);
		Singleton.social_id = preferences.getString("social_id", null);
		Singleton.user_id = preferences.getString("user_id", null);
		Singleton.LoginStatus = preferences.getBoolean("Login_status", false);
		
		Singleton.firstName = preferences.getString("firstName", null);
		Singleton.lastName = preferences.getString("lastName", null);
		Singleton.user_address = preferences.getString("address", null);
		Singleton.cityName = preferences.getString("city", null);
		Singleton.stateName = preferences.getString("state", null);
		Singleton.countryName = preferences.getString("country", null);
		Singleton.phone = preferences.getString("phone", null);		

		Singleton.Spn_CountryName = preferences.getString("CountryName", null);
		Singleton.Spn_StateName = preferences.getString("StateName", null);
		Singleton.Spn_CityName =preferences.getString("CityName", null);
		Singleton.Spn_LocationName = preferences.getString("LocationName", null);
		Singleton.Spn_loc_saved = preferences.getBoolean("Spinner_loc", false);
		
		Singleton.hotel_id = preferences.getString("hotel_id", null);
		Singleton.delivery_charge = preferences.getString("delivery_charge", null);
		Singleton.min_order = preferences.getString("min_order", null);	*/
		

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				
				Intent intent = new Intent(SplashscreenActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
				 
				   /* if(Singleton.user_id != null)
				    {
				    	if(Singleton.Spn_loc_saved == true)
				    	{
				    		Intent intent = new Intent(SplashActivity.this, MainActivity.class);
							startActivity(intent);
							finish();					    	
				    	}
				    	
				    	else
				    	{
				    		Intent intent = new Intent(SplashscreenActivity.this, FetchLocation.class);
							startActivity(intent);
							finish();
				    	//}
				    	
				    }
				    else
				    {
				    	Intent intent = new Intent(SplashscreenActivity.this, LoginActivity.class);
						startActivity(intent);
						finish();
				    	
				    }
				*/
			}

		}, timeDelay);  

	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO

		getLocation();

		locationManager.requestLocationUpdates(provider, 400, 1, this);
	}

	/* Remove the location-listener updates when Activity is paused */
	@Override
	public void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {

		// TODO Auto-generated method stub
		float lat = (float) (location.getLatitude());
		float lng = (float) (location.getLongitude());

		Singleton.latitude = lat;
		Singleton.longitude = lng;

		Location location1 = appLocationService
				.getLocation(LocationManager.GPS_PROVIDER);

		// double latitude = 37.422005;
		// double longitude = -122.084095

		if (location != null) {
			double latitude = location.getLatitude();
			double longitude = location.getLongitude();
			// LocationAddress locationAddress = new LocationAddress();
			LocationAddress.getAddressFromLocation(latitude, longitude,
					getApplicationContext(), new GeocoderHandler());
		} 
		else 
		{
			System.out.println(" No location found");
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	private class GeocoderHandler extends Handler {
		@Override
		public void handleMessage(Message message) {
			String locationAddress;
			switch (message.what) {
			case 1:
				Bundle bundle = message.getData();
				locationAddress = bundle.getString("address");
				System.out.println("ADDRESS>>>>>>>>>>" + locationAddress);

				Singleton.current_address = locationAddress;

				break;
			default:
				locationAddress = null;
			}
		}
	}

	public Location getLocation() {

		try {
			boolean canGetLocation;
			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

			// getting GPS status
			boolean isGPSEnabled = locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER);

			// getting network status
			boolean isNetworkEnabled = locationManager
					.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

			if (!isGPSEnabled && !isNetworkEnabled) {
				// no network provider is enabled
			} else {
				canGetLocation = true;
				// First get location from Network Provider
				if (isNetworkEnabled) {
					locationManager.requestLocationUpdates(
							LocationManager.NETWORK_PROVIDER,
							MIN_TIME_BW_UPDATES,
							MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
					Log.d("Network", "Network");
					if (locationManager != null) {
						location = locationManager
								.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if (location != null) {
							latitude = location.getLatitude();
							longitude = location.getLongitude();
						}
					}
				}
				// if GPS Enabled get lat/long using GPS Services
				if (isGPSEnabled) {
					if (location == null) {
						locationManager.requestLocationUpdates(
								LocationManager.GPS_PROVIDER,
								MIN_TIME_BW_UPDATES,
								MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
						Log.d("GPS Enabled", "GPS Enabled");
						if (locationManager != null) {
							location = locationManager
									.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if (location != null) {
								latitude = location.getLatitude();
								longitude = location.getLongitude();
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return location;
	}

}
