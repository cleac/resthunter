package com.resthunter.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.resthunter.MainActivity;
import com.resthunter.R;
import com.resthunter.Restaurant;
import com.resthunter.RestaurantActivity;

import java.util.ArrayList;

/**
 * Created by denys on 4/5/15.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>  {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mItems;

    public FoodAdapter(Context context, ArrayList<String> items) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mContext, mInflater.inflate(R.layout.food_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mFoodName.setText(mItems.get(position));
        viewHolder.mFoodImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_launcher));
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mFoodName;
        ImageView mFoodImage;
        Context context;

        public ViewHolder(Context context, View view) {
            super(view);
            this.context = context;
            this.mFoodName = (TextView) view.findViewById(R.id.food_name);
            this.mFoodImage = (ImageView) view.findViewById(R.id.food_image);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click(1);
                }
            });
        }

        private void click(int i) {
            Toast.makeText(context, "Food", Toast.LENGTH_SHORT).show();
        }
    }
}
