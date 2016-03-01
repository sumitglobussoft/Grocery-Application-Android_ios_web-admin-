package com.example.grocery.model;

public class CatListModel {

	public boolean isChecekd;
	public boolean isChecekd() {
		return isChecekd;
	}

	public void setChecekd(boolean isChecekd) {
		this.isChecekd = isChecekd;
	}

	public String getReviews_count() {
		return Reviews_count;
	}

	public void setReviews_count(String reviews_count) {
		Reviews_count = reviews_count;
	}

	public String cat_Id = "";	
	public String cat_Name = "";	
	public int cat_ThumbnailUrl ;
	public String cat_Add = "";
	public String cat_Qnty = "";
	public String cat_Price = "";	
	
	public String Delivery_charge = "";
	public String Reviews_count = "";

	

	public CatListModel() {
	}

	public CatListModel(String cat_Id, String cat_Name,
			int cat_ThumbnailUrl, String cat_Add, String cat_Qnty,
			String cat_Price, String Delivery_charge, String Reviews_count) {

		this.cat_Id = cat_Id;
		this.cat_Name = cat_Name;
		this.cat_ThumbnailUrl = cat_ThumbnailUrl;
		this.cat_Add = cat_Add;
		this.cat_Qnty = cat_Qnty;
		this.cat_Price = cat_Price;
		this.Reviews_count = Reviews_count;
        this.Delivery_charge = Delivery_charge;
		
	}

	public String getcat_Id() {
		return cat_Id;
	}

	public void setcat_Id(String cat_Id) {
		this.cat_Id = cat_Id;
	}

	public String getcat_Name() {
		return cat_Name;
	}

	public void setcat_Name(String cat_Name) {
		this.cat_Name = cat_Name;
	}

	public int getcat_ThumbnailUrl() {
		return cat_ThumbnailUrl;
	}

	public void setcat_ThumbnailUrl(int tea) {
		this.cat_ThumbnailUrl = tea;
	}

	public String getcat_Add() {
		return cat_Add;
	}

	public void setcat_Add(String cat_Add) {
		this.cat_Add = cat_Add;
	}

	public String getcat_Qnty() {
		return cat_Qnty;
	}

	public void setcat_Qnty(String cat_Qnty) {
		this.cat_Qnty = cat_Qnty;
	}

	public String getcat_Price() {
		return cat_Price;
	}

	public void setcat_Price(String cat_Price) {
		this.cat_Price = cat_Price;
	}

	public String getReviews() {
		return Reviews_count;
	}

	public void setReviews(String reviews_count) {
		this.Reviews_count = reviews_count;
	}	
	
	public String getDelivery_charge() {
		return Delivery_charge;
	}

	public void setDelivery_charge(String Delivery_charge) {
		this.Delivery_charge = Delivery_charge;
	}

}
