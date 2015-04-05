
package com.resthunter.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {


    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String image;
    @Expose
    private String interior;
    @Expose
    private String address;
    @SerializedName("coord_n")
    @Expose
    private String coordN;
    @SerializedName("coord_e")
    @Expose
    private String coordE;
    @Expose
    private String rate;
    @Expose
    private Integer category;
    @Expose
    private Integer kitchen;
    @Expose
    private List<Integer> services = new ArrayList<Integer>();

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
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     * The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     * The interior
     */
    public String getInterior() {
        return interior;
    }

    /**
     *
     * @param interior
     * The interior
     */
    public void setInterior(String interior) {
        this.interior = interior;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The coordN
     */
    public String getCoordN() {
        return coordN;
    }

    /**
     *
     * @param coordN
     * The coord_n
     */
    public void setCoordN(String coordN) {
        this.coordN = coordN;
    }

    /**
     *
     * @return
     * The coordE
     */
    public String getCoordE() {
        return coordE;
    }

    /**
     *
     * @param coordE
     * The coord_e
     */
    public void setCoordE(String coordE) {
        this.coordE = coordE;
    }

    /**
     *
     * @return
     * The rate
     */
    public String getRate() {
        return rate;
    }

    /**
     *
     * @param rate
     * The rate
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     *
     * @return
     * The category
     */
    public Integer getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The kitchen
     */
    public Integer getKitchen() {
        return kitchen;
    }

    /**
     *
     * @param kitchen
     * The kitchen
     */
    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    /**
     *
     * @return
     * The services
     */
    public List<Integer> getServices() {
        return services;
    }

    /**
     *
     * @param services
     * The services
     */
    public void setServices(List<Integer> services) {
        this.services = services;
    }
}