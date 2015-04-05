package com.resthunter.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.resthunter.R;

/**
 * Created by denys on 4/5/15.
 */
public class FragmentGarnish extends Fragment {

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity().getApplicationContext();

        View rootView = inflater.inflate(R.layout.garnish_fragment, container, false);


        return rootView;
    }
}
