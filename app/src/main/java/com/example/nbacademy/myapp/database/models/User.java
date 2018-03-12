package com.example.nbacademy.myapp.database.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.IUser;
import com.example.nbacademy.myapp.database.contracts.UserContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class User implements IUser {

    private int id, age;
    private String name, phoneNumber, nif, password, email;
    private Map<Integer,Trip> trips;

    public User(){
        trips = new HashMap<Integer,Trip>();
    }

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
       // SQLiteDatabase db = DBHelper.getInstance(null,null,null,0);

        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.COLUMN_NAME_NAME,name);
        values.put(UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER,phoneNumber);
        values.put(UserContract.UserEntry.COLUMN_NAME_AGE,age);
        values.put(UserContract.UserEntry.COLUMN_NAME_NIF,nif);
        values.put(UserContract.UserEntry.COLUMN_NAME_PASSWORD,password);
        values.put(UserContract.UserEntry.COLUMN_NAME_EMAIL,email);

//        db.insert(UserContract.UserEntry.TABLE_NAME,null,values);

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
