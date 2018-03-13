package com.example.nbacademy.myapp.database.api;

import java.util.Date;

/**
 * Created by nbacademy on 10/03/2018.
 */
public interface ITrip extends ITable {

    int getId();

    float getPrice();

    void setPrice(float price);

    int getStatus();

    void setStatus(int status);

    String getName();

    void setName(String name);

    String getOrigin();

    void setOrigin(String origin);

    String getType();

    void setType(String type);

    float getTotalBudget();

    void setTotalBudget(float totalBudget);

    int getUserId();

    void setUserId(int id);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    int getNumPeople();

    void setNumPeople(int numPeople);
}
