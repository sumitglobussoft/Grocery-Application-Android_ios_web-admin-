package com.example.grocery.model;

public class LeftNavDrawerItems {

	
	private String title;
	private String titleId;
    private int icon;
    private String count = "0";
    // boolean to set visiblity of the counter
    private boolean isCounterVisible = false;
     
    public LeftNavDrawerItems(){}
 
    public LeftNavDrawerItems(String title, int icon){
        this.title = title;
        this.icon = icon;
    }
     
    public LeftNavDrawerItems(String title, int icon, boolean isCounterVisible, String count){
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }
     
    public String getTitle(){
        return this.title;
    }
    public String getTitleId(){
        return this.title;
    }
     
    public int getIcon(){
        return this.icon;
    }
     
    public String getCount(){
        return this.count;
    }
     
    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }
     
    public void setTitle(String title){
        this.title = title;
    }
    public void setTitleId(String titleId){
        this.titleId = titleId;
    }
     
    public void setIcon(int icon){
        this.icon = icon;
    }
     
    public void setCount(String count){
        this.count = count;
    }
     
    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
    
    @Override
	public String toString() {
		return "NavDrawerItemModel [title=" + title + ", icon=" + icon
				+ ", Count="	+ count + ", isCounterVisible="	+ isCounterVisible + "]";
	}



}
