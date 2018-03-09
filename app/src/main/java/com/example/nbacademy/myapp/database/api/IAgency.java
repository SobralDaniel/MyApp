package com.example.nbacademy.myapp.database.api;

/**
 * Created by nbacademy on 09/03/2018.
 */
public interface IAgency extends ITable {

    int getId();

    String getName();

    void setName(String name);

    String getAddress();

    void setAddress(String address);

    String getType();

    void setType(String type);

    String getNib();

    void setNib(String nib);
}
