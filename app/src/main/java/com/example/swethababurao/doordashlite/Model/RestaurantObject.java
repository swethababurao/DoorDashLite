package com.example.swethababurao.doordashlite.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by swethababurao on 8/6/18.
 */

public class RestaurantObject {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("cover_img_url")
    private String cover_img_url;
    @SerializedName("status")
    private String status;
    @SerializedName("delivery_fee")
    private String delivery_fee;

    public RestaurantObject(String id, String name, String description, String cover_img_url, String status, String delivery_fee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cover_img_url = cover_img_url;
        this.status = status;
        this.delivery_fee = delivery_fee;
    }

    public RestaurantObject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_img_url() {
        return cover_img_url;
    }

    public void setCover_img_url(String cover_img_url) {
        this.cover_img_url = cover_img_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(String delivery_fee) {
        this.delivery_fee = delivery_fee;
    }
}


