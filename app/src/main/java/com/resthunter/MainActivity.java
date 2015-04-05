package com.resthunter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.resthunter.SlidingUpWidget.SlidingUpBaseActivity;
import com.resthunter.rest.model.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends SlidingUpBaseActivity<ObservableRecyclerView> implements ObservableScrollViewCallbacks {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected ObservableRecyclerView createScrollable() {
        ObservableRecyclerView recyclerView = (ObservableRecyclerView) findViewById(R.id.scroll);
        recyclerView.setScrollViewCallbacks(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CustomAdapter(this, getDummyData()));
        return recyclerView;
    }

    public static class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
        private Context mContext;
        private LayoutInflater mInflater;
        private ArrayList<Restaurant> mItems;

        public CustomAdapter(Context context, ArrayList<Restaurant> items) {
            mContext = context;
            mInflater = LayoutInflater.from(context);
            mItems = items;
        }

        @Override
        public int getItemCount() {
            if (mItems == null) {
                return 0;
            }
            return mItems.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(mContext, mInflater.inflate(R.layout.restaurant_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            viewHolder.mRestaurantName.setText(mItems.get(position).getName());
            Picasso.with(mContext).load(mItems.get(position).getImage()).into(viewHolder.mRestaurantImage);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, RestaurantActivity.class);
                    intent.putExtra("EXTRA_RESTAURANT", mItems.get(position));
                    mContext.startActivity(intent);
                }
            });
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView mRestaurantName;
            ImageView mRestaurantImage;
            Context context;

            public ViewHolder(Context context, View view) {
                super(view);
                this.context = context;
                this.mRestaurantName = (TextView) view.findViewById(R.id.restaurant_name);
                this.mRestaurantImage = (ImageView) view.findViewById(R.id.restaurant_image);
            }
        }
    }
}
