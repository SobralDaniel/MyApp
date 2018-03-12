package com.example.nbacademy.myapp.database.api;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public interface ICost extends ITable {

    int getId();

    float getUnitValue();

    void setUnitValue(float unitValue);

    String getCurrency();

    void setCurrency(String currency);

    String getSubCategory();

    void setSubCategory(String subCategory);

    Date getDate();

    void setDate(Date date);

    int getNumPeople();

    void setNumPeople(int numPeople);

    int getActivityId();

    void setActivityId(int activityId);

    float getTotalExpectedCost();

    void setTotalExpectedCost(float totalExpectedCost);
}
