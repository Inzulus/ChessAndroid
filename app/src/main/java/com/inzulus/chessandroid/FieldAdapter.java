package com.inzulus.chessandroid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * Created by Julius on 09.11.2014.
 */
public class FieldAdapter extends BaseAdapter {
    private Context mContext;

    public FieldAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
           //imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


    /*   public void getFigure(int position, int fig_id){
            mThumbIds[position] = R.drawable.bauer;
            notifyDataSetChanged();
    }*/

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,
            R.drawable.brown, R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white,
            R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,
            R.drawable.brown, R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white,
            R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,
            R.drawable.brown, R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white,
            R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,
            R.drawable.brown, R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white,

    };
}
