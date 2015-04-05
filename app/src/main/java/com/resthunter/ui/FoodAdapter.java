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
import com.resthunter.RestaurantActivity;
import com.resthunter.rest.RestClient;
import com.resthunter.rest.model.Dish;
import com.resthunter.rest.model.Ingredient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by denys on 4/5/15.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>  {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Dish> mItems;

    public FoodAdapter(Context context, ArrayList<Dish> items) {
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
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.mFoodName.setText(mItems.get(position).getName());
        viewHolder.mFoodPrice.setText(mItems.get(position).getPrice());
        final List<Integer> ingredients = mItems.get(position).getIngredients();

        RestClient client = new RestClient();
        Callback<ArrayList<Ingredient>> callback = new Callback<ArrayList<Ingredient>>() {
            String temp = "";
            @Override
            public void success(ArrayList<Ingredient> integers,Response response) {
                for (Ingredient i : integers) {
                    for(Integer integer : ingredients) {
                        if(i.getId() == integer) {
                            temp += i.getName() + ", ";
                        }
                    }
                }
                viewHolder.mFoodIngredients.setText(temp.substring(0, temp.length()-2));
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //handle error
            }
        };
        client.getApiService().getIngredientList(callback);

        Picasso.with(mContext).load(mItems.get(position).getImage()).into((ImageView) viewHolder.mFoodImage);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mFoodName;
        TextView mFoodPrice;
        TextView mFoodIngredients;
        ImageView mFoodImage;
        Context context;

        public ViewHolder(Context context, View view) {
            super(view);
            this.context = context;
            this.mFoodName = (TextView) view.findViewById(R.id.food_name);
            this.mFoodImage = (ImageView) view.findViewById(R.id.food_image);
            this.mFoodPrice = (TextView) view.findViewById(R.id.food_desc);
            this.mFoodIngredients = (TextView) view.findViewById(R.id.food_ingredients);
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
