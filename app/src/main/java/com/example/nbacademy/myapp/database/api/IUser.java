package com.example.nbacademy.myapp.database.api;

import com.example.nbacademy.myapp.database.models.Trip;

import java.util.List;

/**
 * Created by nbacademy on 09/03/2018.
 */
public interface IUser extends ITable {

    int getId();

    int getAge();

    void setAge(int age);

    String getName();

    void setName(String name);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getNif();

    void setNif(String nif);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);

    List<Trip> getTrips();

    boolean addTrip(Trip trip);

    boolean removeTrip(int id);
}
