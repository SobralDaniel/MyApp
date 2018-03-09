package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.IAgency;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Agency implements IAgency {

    private int id;
    private String name, address, type, nib;

    @Override
    public int getId() {
        return id;
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
    public String getNib() {
        return nib;
    }

    @Override
    public void setNib(String nib) {
        this.nib = nib;
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
