
package com.resthunter.rest.model;

import com.google.gson.annotations.Expose;

public class Category {

    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private Integer menu;

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
     *     The menu
     */
    public Integer getMenu() {
        return menu;
    }

    /**
     * 
     * @param menu
     *     The menu
     */
    public void setMenu(Integer menu) {
        this.menu = menu;
    }

}
