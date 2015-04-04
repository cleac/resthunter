package com.resthunter.SlidingUpWidget;

/**
 * Created by denys on 4/4/15.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.resthunter.R;
import com.resthunter.Restaurant;

import java.util.ArrayList;

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private ArrayList<Restaurant> mItems;

    public SimpleRecyclerAdapter(Context context, ArrayList<Restaurant> items) {
        mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.restaurant_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mRestaurantName.setText(mItems.get(position).getRestaurantName());
        viewHolder.mRestaurantImage.setImageDrawable(mItems.get(position).getRestaurantImage());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mRestaurantName;
        ImageView mRestaurantImage;

        public ViewHolder(View view) {
            super(view);
            mRestaurantName = (TextView) view.findViewById(R.id.restaurant_name);
            mRestaurantImage = (ImageView) view.findViewById(R.id.restaurant_image);
        }
    }
}