package com.resthunter.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.resthunter.R;
import com.resthunter.rest.RestClient;
import com.resthunter.rest.model.Dish;
import com.resthunter.ui.FoodAdapter;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by denys on 4/4/15.
 */
public class FragmentDeserts extends Fragment {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;
    private LinearLayoutManager manager;

    private ArrayList<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity().getApplicationContext();

        View rootView = inflater.inflate(R.layout.desert_fragment, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.desert_recycler_view);
        list = new ArrayList<>();
        setmRecyclerView();

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setmRecyclerView() {

        manager = new LinearLayoutManager(getActivity());

        RestClient client = new RestClient();
        Callback<ArrayList<Dish>> callback = new Callback<ArrayList<Dish>>() {
            @Override
            public void success(ArrayList<Dish> data,Response response) {
                ArrayList<Dish> dishes = new ArrayList<>();
                for(int i = 0; i < data.size(); i++) {
                    if (data.get(i).getCategory() == 6)
                        dishes.add(data.get(i));
                }
                mAdapter = new FoodAdapter(mContext, dishes);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //handle error
            }
        };
        client.getApiService().getDishList(callback);
    }


}
