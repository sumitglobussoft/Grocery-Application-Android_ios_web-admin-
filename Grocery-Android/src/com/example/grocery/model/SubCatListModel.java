package com.example.grocery.model;

public class SubCatListModel {

	

	public String subcat_Id = "";	
	public String subcat_Name = "";	
	public String subcat_ThumbnailUrl = "";	
	public String subcat_Qnty = "";
	public String subcat_Price = "";	
	
	
	

	public SubCatListModel() {
	}

	public SubCatListModel(String subcat_Id, String subcat_Name,
			String subcat_ThumbnailUrl, String subcat_Qnty,
			String subcat_Price) {

		this.subcat_Id = subcat_Id;
		this.subcat_Name = subcat_Name;
		this.subcat_ThumbnailUrl = subcat_ThumbnailUrl;		
		this.subcat_Qnty = subcat_Qnty;
		this.subcat_Price = subcat_Price;
		
	}

	public String getsubcat_Id() {
		return subcat_Id;
	}

	public void setsubcat_Id(String subcat_Id) {
		this.subcat_Id = subcat_Id;
	}

	public String getsubcat_Name() {
		return subcat_Name;
	}

	public void setsubcat_Name(String subcat_Name) {
		this.subcat_Name = subcat_Name;
	}

	public String getsubcat_ThumbnailUrl() {
		return subcat_ThumbnailUrl;
	}

	public void setsubcat_ThumbnailUrl(String subcat_ThumbnailUrl) {
		this.subcat_ThumbnailUrl = subcat_ThumbnailUrl;
	}

	
	public String getsubcat_Qnty() {
		return subcat_Qnty;
	}

	public void setsubcat_Qnty(String subcat_Qnty) {
		this.subcat_Qnty = subcat_Qnty;
	}

	public String getsubcat_Price() {
		return subcat_Price;
	}

	public void setsubcat_Price(String subcat_Price) {
		this.subcat_Price = subcat_Price;
	}

	
}
