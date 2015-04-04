
package com.resthunter.rest.model;

import com.google.gson.annotations.Expose;

public class MenuEntry {

    @Expose
    private Integer id;
    @Expose
    private Integer restaurant;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The restaurant
     */
    public Integer getRestaurant() {
        return restaurant;
    }

    /**
     * 
     * @param restaurant
     *     The restaurant
     */
    public void setRestaurant(Integer restaurant) {
        this.restaurant = restaurant;
    }

}
