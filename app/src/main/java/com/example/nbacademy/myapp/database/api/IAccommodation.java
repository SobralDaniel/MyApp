package com.example.nbacademy.myapp.database.api;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public interface IAccommodation extends ITable {

    int getId();

    int getAgencyId();

    void setAgencyId(int agencyId);

    String getName();

    void setName(String name);

    String getAddress();

    void setAddress(String address);

    String getType();

    void setType(String type);

    Date getCheckIn();

    void setCheckIn(Date checkIn);

    Date getCheckOut();

    void setCheckOut(Date checkOut);
}
