package com.searchandfound.snf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ridvan on 18.08.2016.
 */
public class EntryAdapter extends BaseAdapter {

    private List<Entry> data;

    public EntryAdapter(List<Entry> data){
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();
        Entry entry = data.get(position);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View root = convertView;
        if(root == null){
            root = inflater.inflate(R.layout.entry,null,false);
        }

        ImageView cb = (ImageView) root.findViewById(R.id.item_image);
        cb.setImageResource(context.getResources().getIdentifier("bckgrnd", "drawable", context.getPackageName()));

        TextView tw = (TextView) root.findViewById(R.id.item_description);
        tw.setText("Dummy");

        return root;
    }
}
