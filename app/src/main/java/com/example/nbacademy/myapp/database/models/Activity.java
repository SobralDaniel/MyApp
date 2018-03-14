package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.IActivity;
import com.example.nbacademy.myapp.database.api.ICost;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Activity implements IActivity {

    private String name, address, type;
    private long id, categoryId;
    private float price, ranking;
    private Boolean promotion;
    private Date startDate, endDate;
    private ICost cost;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id){
        this.id = id;
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
    public long getCategoryId() {
        return categoryId;
    }

    @Override
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
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
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public ICost getCost() {
        return cost;
    }

    @Override
    public void setCost(ICost cost) {
        this.cost = cost;
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
