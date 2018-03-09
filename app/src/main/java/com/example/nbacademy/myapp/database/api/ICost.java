package com.example.nbacademy.myapp.database.api;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public interface ICost extends ITable {

    int getId();

    int getCategoryId();

    void setCategoryId(int categoryId);

    int getDestinationId();

    void setDestinationId(int destinationId);

    int getDurationInDays();

    void setDurationInDays(int durationInDays);

    int getTripDay();

    void setTripDay(int tripDay);

    float getUnitValue();

    void setUnitValue(float unitValue);

    float getExpectedCost();

    void setExpectedCost(float expectedCost);

    String getCurrency();

    void setCurrency(String currency);

    String getSubCategory();

    void setSubCategory(String subCategory);

    Date getDate();

    void setDate(Date date);
}
