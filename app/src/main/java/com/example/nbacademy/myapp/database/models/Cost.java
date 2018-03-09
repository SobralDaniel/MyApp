package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.ICost;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Cost implements ICost {

    private int id, categoryId, destinationId, durationInDays, tripDay;
    private float unitValue, expectedCost;
    private String currency, subCategory;
    private Date date;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int getDestinationId() {
        return destinationId;
    }

    @Override
    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public int getDurationInDays() {
        return durationInDays;
    }

    @Override
    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    @Override
    public int getTripDay() {
        return tripDay;
    }

    @Override
    public void setTripDay(int tripDay) {
        this.tripDay = tripDay;
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
    public float getExpectedCost() {
        return expectedCost;
    }

    @Override
    public void setExpectedCost(float expectedCost) {
        this.expectedCost = expectedCost;
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
