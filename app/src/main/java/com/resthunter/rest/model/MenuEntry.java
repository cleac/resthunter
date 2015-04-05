
package com.resthunter.rest.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class MenuEntry {

    @Expose
    private Integer id;
    @Expose
    private Integer restaurant;
    @Expose
    private ArrayList<Integer> dishes = new ArrayList<Integer>();

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The restaurant
     */
    public Integer getRestaurant() {
        return restaurant;
    }

    /**
     *
     * @param restaurant
     * The restaurant
     */
    public void setRestaurant(Integer restaurant) {
        this.restaurant = restaurant;
    }

    /**
     *
     * @return
     * The dishes
     */
    public ArrayList<Integer> getDishes() {
        return dishes;
    }

    /**
     *
     * @param dishes
     * The dishes
     */
    public void setDishes(ArrayList<Integer> dishes) {
        this.dishes = dishes;
    }


}
