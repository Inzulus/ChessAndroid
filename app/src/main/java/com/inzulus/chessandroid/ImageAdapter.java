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

    private Integer[] figure_id = {
            R.drawable.empty,R.drawable.wking,R.drawable.wqueen,R.drawable.wbishop,R.drawable.wknight,R.drawable.wrook,R.drawable.wpawn,
            R.drawable.bking,R.drawable.bqueen,R.drawable.bbishop,R.drawable.bknight,R.drawable.brook,R.drawable.bpawn,
    };

    private Integer[] figure_pos = {
            R.drawable.brook,R.drawable.bknight,R.drawable.bbishop,R.drawable.bqueen,R.drawable.bking,R.drawable.bbishop,R.drawable.bknight,R.drawable.brook,
            R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,R.drawable.bpawn,
            R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,
            R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,
            R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,
            R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,
            R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,R.drawable.wpawn,
            R.drawable.wrook,R.drawable.wknight,R.drawable.wbishop,R.drawable.wqueen,R.drawable.wking,R.drawable.wbishop,R.drawable.wknight,R.drawable.wrook,

    };

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
        if (figure_pos[position] == R.drawable.empty)
            return true;
        else
            return false;

    }

    public int getFigureId(int position){
        switch (figure_pos[position]) {
            case R.drawable.wking:
                return 1;
            case R.drawable.wqueen:
                return 2;
            case R.drawable.wbishop:
                return 3;
            case R.drawable.wknight:
                return 4;
            case R.drawable.wrook:
                return 5;
            case R.drawable.wpawn:
                return 6;
            case R.drawable.bking:
                return 7;
            case R.drawable.bqueen:
                return 8;
            case R.drawable.bbishop:
                return 9;
            case R.drawable.bknight:
                return 10;
            case R.drawable.brook:
                return 11;
            case R.drawable.bpawn:
                return 12;
            case R.drawable.empty:
                return 0;
        }
        return 99;
    }


    public void setFigure(int position, int fig_id){
        figure_pos[position] = figure_id[fig_id];
        notifyDataSetChanged();
    }

    public void setEmpty(int position){
        figure_pos[position] = R.drawable.empty;
    }


}
