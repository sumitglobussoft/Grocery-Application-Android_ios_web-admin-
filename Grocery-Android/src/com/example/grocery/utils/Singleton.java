package com.example.grocery.utils;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
	
	public static String date ;
	public static String timestamp ;
	
	public static String app_min_order ; 
	
	public static boolean signup_status = false;

	public static String name ;
	public static String email;
	public static String pass;
	public static String fb_profilePicURL;
	
	public static boolean fromlogin=false;

	// user profile
	public static String firstName;
	public static String lastName;
	public static String user_address;
	public static String user_city;
	public static String user_state;
	public static String phone;
	
	public static String postalCode;
	public static String user_country;
	
	//Delivery address
	public static String delFirstname;
	public static String delPh_num;
	public static String delAddress;
	public static String delLandMark;
	public static String delCity;
	public static String delState;
	public static String del_time;
	

	public static String extendedAccestoken;
	public static String mytoken;

	public static String social_id;
	public static String user_id;

	public static String hotel_id ;
	public static String hotel_name ;
	public static List<String> AllRestNameList = new ArrayList<String>();
	public static List<String> LocRestNameList = new ArrayList<String>();
	//public static List<RestaurantListModel> restaurantListModel = new ArrayList<RestaurantListModel>();
	//public static RestaurantListModel selectedrest ;
	
	public static String hotel_status;
	public static String hotel_img;
	public static String cuisine;
	public static String min_order;
	public static String service_tax; 
	public static String Restaurant_cnt;
	public static String Rest_country;
	public static String Rest_state;
	public static String Rest_city;
	public static String Rest_address;
	public static String Rest_location_id;
	public static String Rest_location_type;
	public static String Rest_location_status;
	

	public static String product_id;
	public static String product_name;
	public static String product_desc;
	public static String product_image;
	public static String product_basic_price;
	public static String product_quantity;
	public static String currency = "$";
	public static String product_totalAmt;
	public static String product_subtotal;
	public static String delivery_charge = "";
	
	
	//Filter
	public static boolean filter_rating = false;
	public static boolean filter_Popularity = false;
	
	public static String sub_cat_name;
	public static String sub_cat_id;
	
	public static String cat;
	public static String cat_id;
	public static String cat_name;
	public static String cat_img;
	//public static String filter_Cuisine_status;
	
	
	//bag
	public static String cart_hotel_id ;
	public static String cart_hotel_name ;
	public static String cart_hotel_del_chrg = Singleton.currency +" 0";
	public static String product_sl_no ;
	public static String cart_product_amt ;
	public static String cart_subtotal_amt = Singleton.currency +" 0";
	public static String cart_total_amt = Singleton.currency +" 0";
	public static String cart_id ;
	public static List<String> product_cartid = new ArrayList<String>();	
	public static List<String> productsInBag = new ArrayList<String>();
	
	public static List<String> product_id_list = new ArrayList<String>();
	public static List<String> product_qnty_list = new ArrayList<String>();
	public static List<String> product_total_list = new ArrayList<String>();
	
	public static int mBagCount;
	//place order
	public static String order_id;
	public static String delivery_id;
	public static List<String> ordered_product_ids = new ArrayList<String>();
	
	//transaction
	
	public static String transaction_id;
	public static String ver_code;


	// location
	public static String location;
	public static String current_address;
	public static String countryName;
	public static String cityName;
	public static String stateName;
	public static float latitude;
	public static float longitude;
	
	//Spinner
	public static String Spn_CountryID = "";
	public static String Spn_CountryName = "Select Country";
	
	public static String Spn_StateID = "";
	public static String Spn_StateName = "Select State";
	
	public static String Spn_CityID  = "";
	public static String Spn_CityName  = "Select City";
	
	public static String Spn_LocationID  = "";
	public static String Spn_LocationName  = "Select Location";
	
	
	//SharedPreferences
	public static boolean Spn_loc_saved = false ;
	public static boolean LoginStatus = false ;

	//Search
	public static String srch_selected_name ;
	public static String srch_selected_id ;	

	//public static MyCallBack myCallBack; 

	public static String previousfragment = "";
	public static String currentfragment = "";

}
