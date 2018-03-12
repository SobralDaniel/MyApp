package com.example.nbacademy.myapp.database.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.ITrip;
import com.example.nbacademy.myapp.database.api.IUser;
import com.example.nbacademy.myapp.database.contracts.UserContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class User extends Table implements IUser {

    private static final String TRIPS = "trips";

    private int age;
    private long id;
    private String name, phoneNumber, nif, password, email;
    private Map<Integer,ITrip> trips;
    private Map<String,Boolean> updatedFields;

    public User(){
        super();
        trips = new HashMap<Integer,ITrip>();
        updatedFields = new HashMap<String,Boolean>();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
        updatedFields.put(UserContract.UserEntry.COLUMN_NAME_AGE,true);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        updatedFields.put(UserContract.UserEntry.COLUMN_NAME_NAME,true);
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        updatedFields.put(UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER,true);
    }

    @Override
    public String getNif() {
        return nif;
    }

    @Override
    public void setNif(String nif) {
        this.nif = nif;
        updatedFields.put(UserContract.UserEntry.COLUMN_NAME_NIF,true);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
        updatedFields.put(UserContract.UserEntry.COLUMN_NAME_PASSWORD,true);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
        updatedFields.put(UserContract.UserEntry.COLUMN_NAME_EMAIL,true);
    }

    @Override
    public List<ITrip> getTrips() {
        return new ArrayList<ITrip>(trips.values());
    }

    @Override
    public boolean addTrip(ITrip trip) {
        if(trip != null && !trips.containsKey(trip.getId())){
            trips.put(trip.getId(),trip);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeTrip(long id) {
        if(trips.remove(id) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean create() {
        SQLiteDatabase db = DBHelper.getInstance(null,null,null,0).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.COLUMN_NAME_NAME,name);
        values.put(UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER,phoneNumber);
        values.put(UserContract.UserEntry.COLUMN_NAME_AGE,age);
        values.put(UserContract.UserEntry.COLUMN_NAME_NIF,nif);
        values.put(UserContract.UserEntry.COLUMN_NAME_PASSWORD,password);
        values.put(UserContract.UserEntry.COLUMN_NAME_EMAIL,email);

        id = db.insert(UserContract.UserEntry.TABLE_NAME,null,values);

        return id == -1 ? false : true;
    }

    @Override
    public boolean update() {

        ContentValues values = new ContentValues();
        for(Map.Entry<String,Boolean> entry : updatedFields.entrySet()){
            if(entry.getValue()){
                switch(entry.getKey()){
                    case UserContract.UserEntry.COLUMN_NAME_NAME : values.put(UserContract.UserEntry.COLUMN_NAME_NAME,name); break;
                    case UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER : values.put(UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER,phoneNumber); break;
                    case UserContract.UserEntry.COLUMN_NAME_AGE : values.put(UserContract.UserEntry.COLUMN_NAME_AGE,age); break;
                    case UserContract.UserEntry.COLUMN_NAME_NIF : values.put(UserContract.UserEntry.COLUMN_NAME_NIF,nif); break;
                    case UserContract.UserEntry.COLUMN_NAME_PASSWORD : values.put(UserContract.UserEntry.COLUMN_NAME_PASSWORD,password); break;
                    case UserContract.UserEntry.COLUMN_NAME_EMAIL : values.put(UserContract.UserEntry.COLUMN_NAME_EMAIL,email); break;
                    default: break;
                }
            }
        }

        int nRowsAffected = 0;
        if(values.size() > 0){
            SQLiteDatabase db = DBHelper.getInstance(null,null,null,0).getWritableDatabase();
            String selection = UserContract.UserEntry._ID + " =";
            String[] selectionArgs = {id + ""};
            nRowsAffected = db.update(UserContract.UserEntry.TABLE_NAME,values,selection,selectionArgs);
            updatedFields = new HashMap<String,Boolean>();
        }

        return nRowsAffected > 0;
    }

    @Override
    public boolean delete() {

        SQLiteDatabase db = DBHelper.getInstance(null,null,null,0).getWritableDatabase();
        String selection = UserContract.UserEntry._ID + " =";
        String[] selectionArgs = {id + ""};
        int nRowsAffected = db.delete(UserContract.UserEntry.TABLE_NAME,selection,selectionArgs);

        return nRowsAffected > 0;
    }
}
