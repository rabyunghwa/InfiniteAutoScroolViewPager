package com.example.infiniteautoscroolview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.infiniteautoscroolview.R;
import com.jakewharton.salvage.RecyclingPagerAdapter;

/**
 * this is a example fragment, just a imageview, u can replace it with your
 * needs
 * 
 * @author Trinea 2013-04-03
 */
class MyPagerAdapter extends RecyclingPagerAdapter {

	private LayoutInflater inflater;
	private Context mContext;
	private int[] ids =  new int[] {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
	
	
	public MyPagerAdapter(Context context) {
		mContext = context;
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup container) {
		 String recycled = "No";
		    ViewHolder holder;
		    if (convertView != null) {
		      holder = (ViewHolder) convertView.getTag();
		      recycled = "Yes";
		    } else {
		      convertView = inflater.inflate(R.layout.item_page, container, false);
		      holder = new ViewHolder(convertView);
		      convertView.setTag(holder);
		    }
		    holder.image.setImageResource(ids[position%5]);
		return convertView;
	}
	
	private static class ViewHolder {
	    final ImageView image;
	    public ViewHolder(View view) {
	      image = (ImageView) view.findViewById(R.id.image);
	    }
	  }
}