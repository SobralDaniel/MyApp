package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.ICost;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Cost implements ICost {

    private int id, numPeople, activityId;
    private float unitValue, totalExpectedCost;
    private String currency, subCategory;
    private Date date;

    @Override
    public int getId() {
        return id;
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
    public int getActivityId() {
        return activityId;
    }

    @Override
    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Override
    public float getTotalExpectedCost() {
        return totalExpectedCost;
    }

    @Override
    public void setTotalExpectedCost(float totalExpectedCost) {
        this.totalExpectedCost = totalExpectedCost;
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
