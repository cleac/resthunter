package com.resthunter.rest.model;

import com.google.gson.annotations.Expose;

public class Place {

    @Expose
    private Integer id;
    @Expose
    private Integer x;
    @Expose
    private Integer y;
    @Expose
    private Integer restaurant;
    @Expose
    private Integer user;

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
     * The x
     */
    public Integer getX() {
        return x;
    }

    /**
     *
     * @param x
     * The x
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     *
     * @return
     * The y
     */
    public Integer getY() {
        return y;
    }

    /**
     *
     * @param y
     * The y
     */
    public void setY(Integer y) {
        this.y = y;
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
     * The user
     */
    public Integer getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(Integer user) {
        this.user = user;
    }

}