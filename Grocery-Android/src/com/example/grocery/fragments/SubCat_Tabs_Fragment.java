package com.example.grocery.fragments;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.example.grocery.R;
import com.example.grocery.adapter.PageAdapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

//import com.example.grocery.adapter.PageAdapter;;

public class SubCat_Tabs_Fragment extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
	
	
	private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, SubCat_Tabs_Fragment.TabInfo>();
    private PagerAdapter mPagerAdapter;
    
    private class TabInfo {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;
        TabInfo(String tag, Class<?> clazz, Bundle args) {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }
    }
    
    /**
     * A simple factory that returns dummy views to the Tabhost
     * @author mwho
     */
    class TabFactory implements TabContentFactory {
 
        private final Context mContext;
       
        public TabFactory(Context context) {
            mContext = context;
        } 
       
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(10);
            
            return v;
        }
 
    }
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout
        setContentView(R.layout.subcat_tabs);
        // Initialise the TabHost
        this.initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
            TextView tv = (TextView) mTabHost.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
            tv.setTextColor(Color.parseColor("#FFFFFF"));
        }
        // Intialise ViewPager
        this.intialiseViewPager();
    }
    
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); //save the tab selected
        super.onSaveInstanceState(outState);
    }
    
    /**
     * Initialise ViewPager
     */
    private void intialiseViewPager() {
 
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, SubCat_Fragment.class.getName()));
        fragments.add(Fragment.instantiate(this, SubCat_Fragment.class.getName()));
        fragments.add(Fragment.instantiate(this, SubCat_Fragment.class.getName()));
        fragments.add(Fragment.instantiate(this, SubCat_Fragment.class.getName()));
        this.mPagerAdapter  = new PageAdapter(super.getSupportFragmentManager(), fragments);
        //
        this.mViewPager = (ViewPager)super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);
    }
    
    /**
     * Initialise the Tab Host
     */
    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.getHeight();
        mTabHost.setup();
        TabInfo tabInfo = null;
        SubCat_Tabs_Fragment.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("Tea"), ( tabInfo = new TabInfo("Tab1", SubCat_Fragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        
        SubCat_Tabs_Fragment.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("Coffee"), ( tabInfo = new TabInfo("Tab2", SubCat_Fragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        
        SubCat_Tabs_Fragment.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3").setIndicator("Health Drinks"), ( tabInfo = new TabInfo("Tab3", SubCat_Fragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        
        SubCat_Tabs_Fragment.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab4").setIndicator("Soft Drinks"), ( tabInfo = new TabInfo("Tab4", SubCat_Fragment.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        // Default to first tab
        //this.onTabChanged("Tab1");
        //
        mTabHost.setOnTabChangedListener(this);
    }
    
    /**
     * Add Tab content to the Tabhost
     * @param activity
     * @param tabHost
     * @param tabSpec
     * @param clss
     * @param args
     */
    private static void AddTab(SubCat_Tabs_Fragment activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        // Attach a Tab view factory to the spec
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }   
   

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
		
        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
        	mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFF")); // unselected
            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
            tv.setTextColor(Color.parseColor("#848484"));
        }

        mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#FFFFFF")); // selected
        TextView tv = (TextView) mTabHost.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
        tv.setTextColor(Color.parseColor("#000000"));
        
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
        
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		// TODO Auto-generated method stub
		
		this.mTabHost.setCurrentTab(position);
		
	}

}
