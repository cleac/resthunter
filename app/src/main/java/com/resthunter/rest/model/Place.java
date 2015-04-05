package com.resthunter.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {

    @Expose
    private Integer id;
    @Expose
    private Integer x;
    @Expose
    private Integer y;
    @SerializedName("is_taken")
    @Expose
    private Boolean isTaken;
    @Expose
    private Integer width;
    @Expose
    private Integer height;
    @Expose
    private Integer places;
    @Expose
    private Integer restaurant;
    @Expose
    private Object user;

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
     * The isTaken
     */
    public Boolean getIsTaken() {
        return isTaken;
    }

    /**
     *
     * @param isTaken
     * The is_taken
     */
    public void setIsTaken(Boolean isTaken) {
        this.isTaken = isTaken;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The places
     */
    public Integer getPlaces() {
        return places;
    }

    /**
     *
     * @param places
     * The places
     */
    public void setPlaces(Integer places) {
        this.places = places;
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
    public Object getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(Object user) {
        this.user = user;
    }

}