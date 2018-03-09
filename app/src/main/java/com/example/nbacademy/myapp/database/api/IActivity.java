package com.example.nbacademy.myapp.database.api;

/**
 * Created by nbacademy on 08/03/2018.
 */
public interface IActivity extends ITable {

    int getId();

    String getName();

    void setName(String name);

    String getAddress();

    void setAddress(String address);

    String getType();

    void setType(String type);

    float getPrice();

    void setPrice(float price);

    int getAgencyId();

    void setAgencyId(int agencyId);

    float getRanking();

    void setRanking(float ranking);

    Boolean getPromotion();

    void setPromotion(Boolean promotion);

    long getDuration();

    void setDuration(long duration);
}
