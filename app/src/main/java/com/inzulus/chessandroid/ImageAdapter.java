package com.inzulus.chessandroid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Julius on 26.11.2014.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return figure_pos.length;
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
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0,0,0,0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(figure_pos[position]);
        return imageView;
    }

    public boolean checkEmpty(int position){
        if (figure_pos[position] == R.drawable.brown)
            return true;
        if (figure_pos[position] == R.drawable.white)
            return true;
        else
            return false;

    }


    public void setFigure(int position, int fig_id){
        figure_pos[position] = figure_id[fig_id];
        notifyDataSetChanged();
    }

    private Integer[] figure_id = {
            R.drawable.wking,R.drawable.wqueen,R.drawable.wbishop,R.drawable.wknight,R.drawable.wrook,R.drawable.wpawn,
            R.drawable.bking,R.drawable.bqueen,R.drawable.bbishop,R.drawable.bknight,R.drawable.brook,R.drawable.bpawn,
    };

    private Integer[] figure_pos = {
            R.drawable.brook,R.drawable.bknight,R.drawable.bbishop,R.drawable.bqueen,R.drawable.bking,R.drawable.bbishop,R.drawable.bknight,R.drawable.brook,
            R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,
            R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,
            R.drawable.brown, R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white,
            R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,
            R.drawable.brown, R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white, R.drawable.brown,R.drawable.white,
            R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,
            R.drawable.wrook,R.drawable.wknight,R.drawable.wbishop,R.drawable.wqueen,R.drawable.wking,R.drawable.wbishop,R.drawable.wknight,R.drawable.wrook,

    };
}
