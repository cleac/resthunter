package com.resthunter.SlidingUpWidget;

/**
 * Created by denys on 4/4/15.
 */

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.resthunter.R;
import com.resthunter.Restaurant;

import java.util.ArrayList;

public abstract class BaseActivity extends ActionBarActivity {
    private static final int NUM_OF_ITEMS = 100;
    private static final int NUM_OF_ITEMS_FEW = 3;

    protected int getActionBarSize() {
        TypedValue typedValue = new TypedValue();
        int[] textSizeAttr = new int[]{R.attr.actionBarSize};
        int indexOfAttrTextSize = 0;
        TypedArray a = obtainStyledAttributes(typedValue.data, textSizeAttr);
        int actionBarSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
        return actionBarSize;
    }

    protected int getScreenHeight() {
        return findViewById(android.R.id.content).getHeight();
    }

    public static ArrayList<Restaurant> getDummyData() {
        return getDummyData(NUM_OF_ITEMS);
    }

    public static ArrayList<Restaurant> getDummyData(int num) {
        ArrayList<Restaurant> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantName("Name " + i);
            restaurant.setRestaurantImage(null);
            items.add(restaurant);
        }
        return items;
    }

}