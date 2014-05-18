package com.example.infiniteautoscroolview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import com.example.infiniteautoscroolview.R;
import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends ActionBarActivity {
	private AutoScrollViewPager mViewPager;
	private static final int viewCount = 5 ;
	private int[] ids;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
		CirclePageIndicator mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mViewPager.setAdapter(new MyPagerAdapter(this));
		mIndicator.setViewPager(mViewPager);
		mIndicator.setViewCount(viewCount);
		mViewPager.startAutoScroll(); //start auto scroll, delay time is getInterval().
//		startAutoScroll(int) //start auto scroll delayed.
//		stopAutoScroll() st
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
