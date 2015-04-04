package com.resthunter.SlidingUpWidget;

/**
 * Created by denys on 4/4/15.
 */

import android.content.Context;
import android.media.Image;
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

public class SimpleHeaderRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    private LayoutInflater mInflater;
    private ArrayList<Restaurant> mItems;
    private View mHeaderView;

    public SimpleHeaderRecyclerAdapter(Context context, ArrayList<Restaurant> items, View headerView) {
        mInflater = LayoutInflater.from(context);
        mItems = items;
        mHeaderView = headerView;
    }

    @Override
    public int getItemCount() {
        if (mHeaderView == null) {
            return mItems.size();
        } else {
            return mItems.size() + 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? VIEW_TYPE_HEADER : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            return new HeaderViewHolder(mHeaderView);
        } else {
            return new ItemViewHolder(mInflater.inflate(R.layout.restaurant_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ItemViewHolder) {
            Log.d("Set", "setting here");
            ((ItemViewHolder) viewHolder).mRestaurantName.setText(mItems.get(position - 1).getRestaurantName());
            ((ItemViewHolder) viewHolder).mRestaurantImage.setImageDrawable(mItems.get(position - 1).getRestaurantImage());
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mRestaurantName;
        ImageView mRestaurantImage;

        public ItemViewHolder(View view) {
            super(view);
            mRestaurantName = (TextView) view.findViewById(R.id.restaurant_name);
            mRestaurantImage = (ImageView) view.findViewById(R.id.restaurant_image);
        }
    }
}