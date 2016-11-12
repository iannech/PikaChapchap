package com.example.gyleodhis.pikachapchap;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

@SerializedName("id")
@Expose
private String id;
@SerializedName("beans_variery")
@Expose
private String beansVariery;
@SerializedName("soaked")
@Expose
private String soaked;
@SerializedName("temperature")
@Expose
private String temperature;
@SerializedName("Humidy")
@Expose
private String  humidy;
@SerializedName("storage_months")
@Expose
private String storageMonths;
@SerializedName("cooking_minutes")
@Expose
private String cookingMinutes;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeansVariery() {
        return beansVariery;
    }

    public void setBeansVariery(String beansVariery) {
        this.beansVariery = beansVariery;
    }

    public String getSoaked() {
        return soaked;
    }

    public void setSoaked(String soaked) {
        this.soaked = soaked;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidy() {
        return humidy;
    }

    public void setHumidy(String humidy) {
        this.humidy = humidy;
    }

    public String getStorageMonths() {
        return storageMonths;
    }

    public void setStorageMonths(String storageMonths) {
        this.storageMonths = storageMonths;
    }

    public String getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(String cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }
}
