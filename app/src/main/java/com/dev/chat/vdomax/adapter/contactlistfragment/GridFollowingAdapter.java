package com.dev.chat.vdomax.adapter.contactlistfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dev.chat.vdomax.R;


/**
 * Created by Adisorn on 3/3/2558.
 */
public class GridFollowingAdapter extends BaseAdapter{
    private Context context;

    public GridFollowingAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
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

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)   context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_following_item, null);
        }

        return convertView;
    }

}
