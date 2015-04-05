
package com.resthunter.rest.model;

import com.google.gson.annotations.Expose;

public class MenuEntry {

    @Expose
    private Integer id;
    @Expose
    private Integer restaurant;
    @Expose
    private Boolean is_taken;

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

    /**
     *
     * @return
     *  isTaken
     */
    public Boolean getIs_taken() {
        return is_taken;
    }

    /**
     *
     * @param is_taken
     */
    public void setIs_taken(Boolean is_taken) {
        this.is_taken = is_taken;
    }
}
