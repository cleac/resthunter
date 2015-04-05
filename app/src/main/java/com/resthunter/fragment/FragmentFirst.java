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
import com.resthunter.ui.FoodAdapter;

import java.util.ArrayList;

/**
 * Created by denys on 4/5/15.
 */
public class FragmentFirst extends Fragment {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;
    private LinearLayoutManager manager;

    private ArrayList<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity().getApplicationContext();

        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.main_recycler_view);
        list = new ArrayList<>();
        fillFoodList();

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        manager = new LinearLayoutManager(getActivity());
        mAdapter = new FoodAdapter(mContext, list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void fillFoodList() {
        for(int i = 0; i < 10; i++) {
            list.add("Food " + i);
        }
    }
}
