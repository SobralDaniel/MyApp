package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.ICost;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Cost implements ICost {

    private long id, activityId;
    private int numPeople;
    private float unitValue, realCost;
    private String currency, subCategory;
    private Date date;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id){
        this.id = id;
    }

    @Override
    public float getUnitValue() {
        return unitValue;
    }

    @Override
    public void setUnitValue(float unitValue) {
        this.unitValue = unitValue;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String getSubCategory() {
        return subCategory;
    }

    @Override
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int getNumPeople() {
        return numPeople;
    }

    @Override
    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    @Override
    public long getActivityId() {
        return activityId;
    }

    @Override
    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    @Override
    public float getRealCost() {
        return realCost;
    }

    @Override
    public void setRealCost(float realCost) {
        this.realCost = realCost;
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
