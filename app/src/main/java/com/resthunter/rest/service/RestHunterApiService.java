package com.resthunter.rest.service;

import com.resthunter.rest.model.Category;
import com.resthunter.rest.model.Dish;
import com.resthunter.rest.model.Ingredient;
import com.resthunter.rest.model.MenuEntry;
import com.resthunter.rest.model.Restaurant;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import javax.security.auth.callback.Callback;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by cleac on 04.04.15.
 */
public interface RestHunterApiService {

    @GET("/api/dish?format=json")
    public void getDishList(retrofit.Callback<ArrayList<Dish>> callback);

    @GET("/api/ingredient?format=json")
    public void getIngredientList(retrofit.Callback<ArrayList<Ingredient>> callback);

    @GET("/api/menu?format=json")
    public void getMenu(retrofit.Callback<ArrayList<MenuEntry>> callback);

    @GET("/api/category?forman=json")
    public void getCategoryList(retrofit.Callback<ArrayList<Category>> callback);

    @GET("/api/restaurant?format=json")
    public void getRestaurantList(retrofit.Callback<ArrayList<Restaurant>> callback);


    @GET("/api/dish?format=json&ordering={field}")
    public void getDishList(@Path("field") String field,retrofit.Callback<ArrayList<Dish>> callback);

    @GET("/api/ingredient?format=json&ordering={field}")
    public void getIngredientList(@Path("field") String field,retrofit.Callback<ArrayList<Ingredient>> callback);

    @GET("/api/menu?format=json&ordering={field}")
    public void getMenu(@Path("field") String field,retrofit.Callback<ArrayList<MenuEntry>> callback);

    @GET("/api/category?forman=json&ordering={field}")
    public void getCategoryList(@Path("field") String field,retrofit.Callback<ArrayList<Category>> callback);

    @GET("/api/restaurant?format=json&ordering={field}")
    public void getRestaurantList(@Path("field") String field,retrofit.Callback<ArrayList<Restaurant>> callback);
}
