package com.resthunter;

import android.graphics.drawable.Drawable;

/**
 * Created by denys on 4/4/15.
 */
public class Restaurant {

    private Drawable restaurantImage;
    private String restaurantName;

    public Restaurant() {}

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantImage(Drawable restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    /**
     * Getter method
     * @return restaurant image
     */
    public Drawable getRestaurantImage() {
        return restaurantImage;
    }

    /**
     * Getter method
     * @return name of restaurant
     */
    public String getRestaurantName() {
        return restaurantName;
    }

}
