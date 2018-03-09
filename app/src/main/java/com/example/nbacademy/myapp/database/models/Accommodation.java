package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.IAccommodation;

import java.util.Date;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Accommodation implements IAccommodation {

    private int id, agencyId;
    private String name, address, type;
    private Date checkIn, checkOut;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getAgencyId() {
        return agencyId;
    }

    @Override
    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
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
    public Date getCheckIn() {
        return checkIn;
    }

    @Override
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    @Override
    public Date getCheckOut() {
        return checkOut;
    }

    @Override
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
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
