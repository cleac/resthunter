
package com.resthunter.rest.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Dish {

    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String price;
    @Expose
    private String rate;
    @Expose
    private String image;
    @Expose
    private Integer category;
    @Expose
    private List<Integer> ingredients = new ArrayList<Integer>();

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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The rate
     */
    public String getRate() {
        return rate;
    }

    /**
     * 
     * @param rate
     *     The rate
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The category
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The ingredients
     */
    public List<Integer> getIngredients() {
        return ingredients;
    }

    /**
     * 
     * @param ingredients
     *     The ingredients
     */
    public void setIngredients(List<Integer> ingredients) {
        this.ingredients = ingredients;
    }

}
