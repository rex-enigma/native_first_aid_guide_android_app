package com.example.firstaidapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstaidapp.R;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private String[] titles;
    private int[] images;
    public GridViewAdapter(Context context, String[] titles, int[] images){
        this.context = context;
        this.titles = titles;
        this.images = images;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewItem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        gridViewItem = inflater.inflate(R.layout.grid_view_item, null);
        TextView textView =  gridViewItem.findViewById(R.id.gridViewItemTitle);
        ImageView imageView = gridViewItem.findViewById(R.id.gridViewItemImage);
        textView.setText(titles[position]);
        imageView.setImageResource(images[position]);

        return gridViewItem;
    }
}
