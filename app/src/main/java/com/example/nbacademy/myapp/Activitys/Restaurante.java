package com.example.nbacademy.myapp.Activitys;

/**
 * Created by nbacademy on 14/03/2018.
 */
public class Restaurante {

    int id;
    String name;
    int cityId;

    public Restaurante(int id, String name, int cityId){
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
