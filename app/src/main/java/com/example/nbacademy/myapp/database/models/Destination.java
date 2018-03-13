package com.example.nbacademy.myapp.database.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.ICategory;
import com.example.nbacademy.myapp.database.api.IDestination;
import com.example.nbacademy.myapp.database.contracts.DestinationContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by NBAcademy on 11/03/2018.
 */

public class Destination extends Table implements IDestination {

    private Date initialDate, finalDate;
    private double mealCost, hostCost;
    private String currency, timezone, destinationName;
    private List<ICategory> categories;
    private double currencyValue, temperature;
    private int percLunch, percDinner, percShops, percExtras;
    private long id, tripId;

    public Destination()
    {
        super();
        categories = new ArrayList<ICategory>();
    }

    @Override
    public long getId() {
        return id;
    }


    @Override
    public void setId(long id){
        this.id = id;
    }

    @Override
    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {

        this.initialDate = initialDate;
    }

    @Override
    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    @Override
    public double getMealCost() {
        return mealCost;
    }

    @Override
    public void setMealCost(Double mealCost) { this.mealCost = mealCost; }

    public void setMealCost(double mealCost) {
        this.mealCost = mealCost;
    }

    @Override
    public double getHostCost() {
        return hostCost;
    }

    @Override
    public void setHostCost(Double hostCost) { this.hostCost = hostCost; }

    public void setHostCost(double hostCost) {
        this.hostCost = hostCost;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String getTimezone() {
        return timezone;
    }

    @Override
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDestinationName() {
        return destinationName;
    }

    @Override
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @Override
    public ICategory[] getCategories() {
        return new ICategory[0];
    }

    @Override
    public boolean addCategory(ICategory category) {

        if (category != null)
        {
            int i;
            for(i = 0; i < categories.size() ; i++){
                if(Objects.equals(categories.get(i).getId(),category.getId())){
                    categories.remove(i);
                    categories.add(category);
                    return true;
                }
            }
            if(i < 6){
                categories.add(category);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeCategory(String categoryId) {
        if(categoryId != null && !categoryId.isEmpty()){
            for(int i = 0; i < categories.size() ; i++){
                if(Objects.equals(categories.get(i).getId(),categoryId)){
                    categories.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public double getCurrencyValue() {
        return currencyValue;
    }

    @Override
    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    @Override
    public long getTripId() {
        return tripId;
    }

    @Override
    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    @Override
    public int getPercLunch() {
        return percLunch;
    }

    @Override
    public void setPercLunch(int percLunch) {
        this.percLunch = percLunch;
    }

    @Override
    public int getPercDinner() {
        return percDinner;
    }

    @Override
    public void setPercDinner(int percDinner) {
        this.percDinner = percDinner;
    }

    @Override
    public int getPercShops() {
        return percShops;
    }

    @Override
    public void setPercShops(int percShops) {
        this.percShops = percShops;
    }

    @Override
    public int getPercExtras() {
        return percExtras;
    }

    @Override
    public void setPercExtras(int percExtras) {
        this.percExtras = percExtras;
    }

    @Override
    public boolean create() {
        SQLiteDatabase db = DBHelper.getInstance(null,null,null,0).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_NAME, destinationName);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE, temperature);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE, percShops);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH, getPercLunch());
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER, percDinner);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE, initialDate.toString());
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE, finalDate.toString());
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST, mealCost);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST, hostCost);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE, currencyValue);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY, currency);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE, temperature);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE, timezone);

        id = db.insert(DestinationContract.DestinationEntry.TABLE_NAME, null,values);

        return id == -1 ? false : true;
    }

    @Override
    public boolean update() {
        ContentValues values = new ContentValues();

        return false;

    }

    @Override
    public boolean delete() {

        SQLiteDatabase db = DBHelper.getInstance(null,null,null,0).getWritableDatabase();
        String selection = DestinationContract.DestinationEntry._ID + " =";
        String[] selectionArgs = {id + ""};
        int nRowsAffected = db.delete(DestinationContract.DestinationEntry.TABLE_NAME,selection,selectionArgs);

        return nRowsAffected > 0;
    }
}
