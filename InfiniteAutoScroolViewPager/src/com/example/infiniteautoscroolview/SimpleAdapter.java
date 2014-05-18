package com.example.infiniteautoscroolview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infiniteautoscroolview.R;
import com.jakewharton.salvage.RecyclingPagerAdapter;

public class SimpleAdapter extends RecyclingPagerAdapter {
  private static final String[] DATA = "The quick brown fox jumps go on body".split(" ");
  private int[] ids =  new int[] {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
  private final LayoutInflater inflater;

  public SimpleAdapter(Context context) {
    inflater = LayoutInflater.from(context);
  }

  @Override public View getView(int position, View view, ViewGroup container) {
    String recycled = "No";
    ViewHolder holder;
    if (view != null) {
      holder = (ViewHolder) view.getTag();
      recycled = "Yes";
    } else {
      view = inflater.inflate(R.layout.page, container, false);
      holder = new ViewHolder(view);
      view.setTag(holder);
    }

    holder.word.setText(DATA[position]);
    holder.position.setText(String.valueOf(position));
    holder.recycled.setText(recycled);
    holder.image.setImageResource(ids[position%5]);
    
    return view;
  }

  @Override public int getCount() {
    return DATA.length;
  }

  private static class ViewHolder {
    final TextView word;
    final TextView position;
    final TextView recycled;
    final ImageView image;

    public ViewHolder(View view) {
      word = (TextView) view.findViewById(R.id.word);
      position = (TextView) view.findViewById(R.id.position);
      recycled = (TextView) view.findViewById(R.id.recycled);
      image = (ImageView) view.findViewById(R.id.image);
    }
  }
}
