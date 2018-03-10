package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.IUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class User implements IUser {

    private int id, age;
    private String name, phoneNumber, nif, password, email;
    private Map<Integer,Trip> trips;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getNif() {
        return nif;
    }

    @Override
    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public List<Trip> getTrips() {
        return new ArrayList<Trip>(trips.values());
    }

    @Override
    public boolean addTrip(Trip trip) {
        if(trip != null && !trips.containsKey(trip.getId())){
            trips.put(trip.getId(),trip);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeTrip(int id) {
        return trips.remove(id) != null ? true : false;
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
