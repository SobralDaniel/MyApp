package com.example.nbacademy.myapp.database.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.IActivity;
import com.example.nbacademy.myapp.database.api.ICategory;
import com.example.nbacademy.myapp.database.api.IDestination;
import com.example.nbacademy.myapp.database.contracts.DestinationContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private int percLunch, percDinner, percPurchase, percExtras;
    private long id, tripId;
    private Map<String,Boolean> updatedFields;

    public Destination()
    {
        super();
        categories = new ArrayList<ICategory>();
        updatedFields = new HashMap<String,Boolean>();
    }

    public void forceUpdateFields(){
        SQLiteDatabase db = DBHelper.getInstance(null).getReadableDatabase();

        String[] projection = {DestinationContract.DestinationEntry._ID,DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE,
                DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE,DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST,
                DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST,DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY,
                DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE,DestinationContract.DestinationEntry.COLUMN_NAME_NAME,
                DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE,DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE,
                DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH,DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER,
                DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE,DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA,
                DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID
        };

        String selection = DestinationContract.DestinationEntry._ID + "= ?";
        String[] selectionArgs = {""+id};

        String sortOrder = DestinationContract.DestinationEntry._ID + " ASC";
        Cursor cursor = db.query(DestinationContract.DestinationEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        if(cursor.moveToNext()){
            try {
                id = cursor.getLong(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry._ID));
                SimpleDateFormat sdf = new SimpleDateFormat();
                initialDate = sdf.parse(cursor.getString(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE)));
                finalDate = sdf.parse(cursor.getString(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE)));
                mealCost = cursor.getDouble(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST));
                hostCost = cursor.getDouble(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST));
                currency = cursor.getString(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY));
                timezone = cursor.getString(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE));
                destinationName = cursor.getString(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_NAME));
                currencyValue = cursor.getDouble(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE));
                temperature = cursor.getDouble(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE));
                percLunch = cursor.getInt(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH));
                percDinner = cursor.getInt(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER));
                percPurchase = cursor.getInt(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE));
                percExtras = cursor.getInt(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA));
                tripId = cursor.getInt(cursor.getColumnIndexOrThrow(DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID));
                getCategories();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateFields(){
        if(getFromDB()){
            forceUpdateFields();
        }
    }

    @Override
    public long getId() {
        updateFields();
        return id;
    }


    @Override
    public void setId(long id){
        updatedFields.put(DestinationContract.DestinationEntry._ID,true);
        this.id = id;
    }

    @Override
    public Date getInitialDate() {
        updateFields();
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE,true);
        this.initialDate = initialDate;
    }

    @Override
    public Date getFinalDate() {
        updateFields();
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE,true);
        this.finalDate = finalDate;
    }

    @Override
    public double getMealCost() {
        updateFields();
        return mealCost;
    }

    @Override
    public void setMealCost(Double mealCost) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST,true);
        this.mealCost = mealCost;
    }

    @Override
    public double getHostCost() {
        updateFields();
        return hostCost;
    }

    @Override
    public void setHostCost(Double hostCost) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST,true);
        this.hostCost = hostCost;
    }

    @Override
    public String getCurrency() {
        updateFields();
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY,true);
        this.currency = currency;
    }

    @Override
    public String getTimezone() {
        updateFields();
        return timezone;
    }

    @Override
    public void setTimezone(String timezone) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE,true);
        this.timezone = timezone;
    }

    @Override
    public double getTemperature() {
        updateFields();
        return temperature;
    }

    @Override
    public void setTemperature(double temperature) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE,true);
        this.temperature = temperature;
    }

    @Override
    public String getDestinationName() {
        updateFields();
        return destinationName;
    }

    @Override
    public void setDestinationName(String destinationName) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_NAME,true);
        this.destinationName = destinationName;
    }

    @Override
    public List<ICategory> getCategories() {
        List<ICategory> auxCategories = categories;

//Really bad approach, change this in the future

        for(ICategory auxCategory : auxCategories)
        {
            auxCategory.forceUpdateFields();
            for(IActivity auxAct : auxCategory.getActivities())
            {
                auxAct.forceUpdateFields();
                auxAct.getCost().forceUpdateFields();
            }
        }
        return auxCategories;
    }

    @Override
    public boolean addCategory(ICategory category) {

        if (category != null)
        {
            int i;
            for(i = 0; i < categories.size() ; i++){
                if(Objects.equals(categories.get(i).getId(),category.getId())){
                    categories.remove(i);
                    category.setDestinationId(this.id);
                    categories.add(category);
                    return true;
                }
            }
            if(i < 6){
                category.setDestinationId(this.id);
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
        updateFields();
        return currencyValue;
    }

    @Override
    public void setCurrencyValue(double currencyValue) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE,true);
        this.currencyValue = currencyValue;
    }

    @Override
    public long getTripId() {
        updateFields();
        return tripId;
    }

    @Override
    public void setTripId(long tripId) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID,true);
        this.tripId = tripId;
    }

    @Override
    public int getPercLunch() {
        updateFields();
        return percLunch;
    }

    @Override
    public void setPercLunch(int percLunch) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH,true);
        this.percLunch = percLunch;
    }

    @Override
    public int getPercDinner() {
        updateFields();
        return percDinner;
    }

    @Override
    public void setPercDinner(int percDinner) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER,true);
        this.percDinner = percDinner;
    }

    @Override
    public int getPercPurchase() {
        updateFields();
        return percPurchase;
    }

    @Override
    public void setPercPurchase(int percPurchase) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE,true);
        this.percPurchase = percPurchase;
    }

    @Override
    public int getPercExtras() {
        updateFields();
        return percExtras;
    }

    @Override
    public void setPercExtras(int percExtras) {
        updatedFields.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA,true);
        this.percExtras = percExtras;
    }

    @Override
    public boolean create() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();

        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat();
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE, sdf.format(initialDate));
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE, sdf.format(finalDate));
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST, mealCost);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST, hostCost);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY, currency);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE, timezone);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_NAME, destinationName);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE, currencyValue);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE, temperature);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH, percLunch);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER, percDinner);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE, percPurchase);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA, percExtras);
        values.put(DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID, tripId);

        id = db.insert(DestinationContract.DestinationEntry.TABLE_NAME, null,values);

        return id == -1 ? false : true;
    }

    @Override
    public boolean update() {
        ContentValues values = new ContentValues();
        for(Map.Entry<String,Boolean> entry : updatedFields.entrySet()){
            if(entry.getValue()){
                SimpleDateFormat sdf = new SimpleDateFormat();
                switch(entry.getKey()){
                    case DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE,sdf.format(initialDate)); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE,sdf.format(finalDate)); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST,mealCost); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST,hostCost); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY,currency); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE,timezone); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_NAME : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_NAME,destinationName); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE,currencyValue); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE,temperature); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH,percLunch); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER,percDinner); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE,percPurchase); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA,percExtras); break;
                    case DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID : values.put(DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID,tripId); break;
                    default: break;
                }
            }
        }

        int nRowsAffected = 0;
        if(values.size() > 0){
            SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
            String selection = DestinationContract.DestinationEntry._ID + " =";
            String[] selectionArgs = {id + ""};
            nRowsAffected = db.update(DestinationContract.DestinationEntry.TABLE_NAME,values,selection,selectionArgs);
            updatedFields = new HashMap<String,Boolean>();
        }

        return nRowsAffected > 0;

    }

    @Override
    public boolean delete() {

        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
        String selection = DestinationContract.DestinationEntry._ID + " =";
        String[] selectionArgs = {id + ""};
        int nRowsAffected = db.delete(DestinationContract.DestinationEntry.TABLE_NAME,selection,selectionArgs);

        return nRowsAffected > 0;
    }
}
