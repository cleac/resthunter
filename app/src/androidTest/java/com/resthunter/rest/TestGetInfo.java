package com.resthunter.rest;

import android.test.AndroidTestCase;
import android.util.Log;

import com.resthunter.rest.model.Category;
import com.resthunter.rest.model.Dish;
import com.resthunter.rest.model.Ingredient;
import com.resthunter.rest.model.MenuEntry;
import com.resthunter.rest.model.Place;
import com.resthunter.rest.model.Restaurant;
import com.resthunter.rest.service.RestHunterApiService;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.Callback;
import retrofit.client.Response;

/**
 * Created by cleac on 04.04.15.
 */
public class TestGetInfo  extends AndroidTestCase {
    public static final String LOG_TAG = TestGetInfo.class.getSimpleName();
    public static RestHunterApiService API_SERVICE = new RestClient().getApiService();

    public void testGetCategory() throws Throwable {
        Log.v(LOG_TAG,"TestGET  started");
        Callback<ArrayList<Category>> callback = new retrofit.Callback<ArrayList<Category>>() {
            @Override
            public void success(ArrayList<Category> arrayList,Response response) {
                for(Category category: arrayList) {
                    Log.v(LOG_TAG,category.getName());
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                assertTrue("Error", false);
            }
        };
        API_SERVICE.getCategoryList(callback);
    }

    public void testGetDishes() throws Throwable {
        Callback<ArrayList<Dish>> callback = new Callback<ArrayList<Dish>>() {
            @Override
            public void success(ArrayList<Dish> o, Response response) {
                Log.v(LOG_TAG, "Get success");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                assertTrue("Error", false);
            }
        };
        API_SERVICE.getDishList(callback);
    }

    public void testGetIngredient() throws Throwable {
        Callback<ArrayList<Ingredient>> callback = new retrofit.Callback<ArrayList<Ingredient>>() {
            @Override
            public void success(ArrayList<Ingredient> o, Response response) {
                Log.v(LOG_TAG, "Get success");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                assertTrue("Error", false);
            }
        };
        API_SERVICE.getIngredientList(callback);
    }

    public void testGetMenu() throws Throwable {
        Callback<ArrayList<MenuEntry>> callback = new retrofit.Callback<ArrayList<MenuEntry>>() {
            @Override
            public void success(ArrayList<MenuEntry> o, Response response) {
                Log.v(LOG_TAG, "Get success");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                assertTrue("Error", false);
            }
        };
        API_SERVICE.getMenu(callback);
    }

    public void testGetRestaurant() throws Throwable {
        Callback<ArrayList<Restaurant>> callback = new retrofit.Callback<ArrayList<Restaurant>>() {
            @Override
            public void success(ArrayList<Restaurant> o, Response response) {
                Log.v(LOG_TAG, "Get success");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                assertTrue("Error", false);
            }
        };
        API_SERVICE.getRestaurantList(callback);
    }

    public void testGetPlaces() throws Throwable {
        Callback<ArrayList<Place>> callback = new retrofit.Callback<ArrayList<Place>>() {
            @Override
            public void success(ArrayList<Place> o, Response response) {
                Log.v(LOG_TAG, "Get success");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                assertTrue("Error", false);
            }
        };
        API_SERVICE.getPlaceList(callback);
    }
}
