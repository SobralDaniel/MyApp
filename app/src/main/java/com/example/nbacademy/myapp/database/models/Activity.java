package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.IActivity;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Activity implements IActivity {

    private String name, address, type;
    private int id, agencyId;
    private float price, ranking;
    private Boolean promotion;
    private long duration;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int getAgencyId() {
        return agencyId;
    }

    @Override
    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public float getRanking() {
        return ranking;
    }

    @Override
    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    @Override
    public Boolean getPromotion() {
        return promotion;
    }

    @Override
    public void setPromotion(Boolean promotion) {
        this.promotion = promotion;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
