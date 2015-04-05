package com.resthunter.rest.service;

import com.resthunter.rest.model.Category;
import com.resthunter.rest.model.Dish;
import com.resthunter.rest.model.Ingredient;
import com.resthunter.rest.model.Kitchen;
import com.resthunter.rest.model.MenuEntry;
import com.resthunter.rest.model.Place;
import com.resthunter.rest.model.Restaurant;
import com.resthunter.rest.model.Service;
import com.resthunter.rest.model.User;

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
    public ArrayList<Dish> getDishList();

    @GET("/api/ingredient?format=json")
    public ArrayList<Ingredient> getIngredientList();

    @GET("/api/menu?format=json")
    public ArrayList<MenuEntry> getMenu();

    @GET("/api/category?forman=json")
    public ArrayList<Category> getCategoryList();

    @GET("/api/restaurant?format=json")
    public ArrayList<Restaurant> getRestaurantList();

    @GET("/api/place?format=json")
    public ArrayList<Place> getPlaceList();

    @GET("/api/category_restaurant?format=json")
    public ArrayList<Place> getRestCategoryList();

    @GET("/api/kitchen?format=json")
    public ArrayList<Kitchen> getKitchenList();

    @GET("/api/service?format=json")
    public ArrayList<Service> getServiceList();

    @GET("/api/user?format=json")
    public ArrayList<User> getUserList();

    @GET("/api/near/?n={n}&e={e}")
    public ArrayList<Restaurant> getRestaurantsNear(@Path("n") double n,@Path("e") double e);



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

    @GET("/api/place?format=json")
    public void getPlaceList(retrofit.Callback<ArrayList<Place>> callback);

    @GET("/api/category_restaurant?format=json")
    public void getRestCategoryList(retrofit.Callback<ArrayList<Place>> callback);

    @GET("/api/kitchen?format=json")
    public void getKitchenList(retrofit.Callback<ArrayList<Kitchen>> callback);

    @GET("/api/service?format=json")
    public void getServiceList(retrofit.Callback<ArrayList<Service>> callback);

    @GET("/api/user?format=json")
    public void getUserList(retrofit.Callback<ArrayList<User>> callback);

    @GET("/api/near/?n={n}&e={e}")
    public void getRestaurantsNear(@Path("n") double n,@Path("e") double e, retrofit.Callback<ArrayList<Restaurant>> callback);


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

    @GET("/api/place?format=json&ordering={field}")
    public void getPlaceList(@Path("field") String field,retrofit.Callback<ArrayList<Place>> callback);
}
