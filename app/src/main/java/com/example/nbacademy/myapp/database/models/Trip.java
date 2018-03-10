package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.ITrip;
import java.util.Date;

/**
 * Created by nbacademy on 10/03/2018.
 */
public class Trip implements ITrip {

    private Date startDate, endDate;
    private int numPeople, id, status, userId;
    private String name, origin, type;
    private float totalBudget, price;

    @Override
    public int getId() {
        return id;
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
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
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
    public String getOrigin() {
        return origin;
    }

    @Override
    public void setOrigin(String origin) {
        this.origin = origin;
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
    public float getTotalBudget() {
        return totalBudget;
    }

    @Override
    public void setTotalBudget(float totalBudget) {
        this.totalBudget = totalBudget;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int id) {
        this.userId = id;
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
    public int getNumPeople() {
        return numPeople;
    }

    @Override
    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
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
