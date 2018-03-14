package com.example.nbacademy.myapp.database.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.ICost;
import com.example.nbacademy.myapp.database.contracts.CostContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Cost extends Table implements ICost {

    private long id, activityId;
    private int numPeople;
    private float unitValue, realCost;
    private String currency, subCategory;
    private Date date;
    private Map<String,Boolean> updatedFields;

    public Cost()
    {
        super();
        updatedFields = new HashMap<String,Boolean>();
    }

    public void forceUpdateFields(){
        SQLiteDatabase db = DBHelper.getInstance(null).getReadableDatabase();

        String[] projection = {CostContract.CostEntry._ID,CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID,
                CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE,CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE,
                CostContract.CostEntry.COLUMN_NAME_REAL_COST,CostContract.CostEntry.COLUMN_NAME_CURRENCY,
                CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY,CostContract.CostEntry.COLUMN_NAME_DATE
        };

        String selection = CostContract.CostEntry._ID + "= ?";
        String[] selectionArgs = {""+id};

        String sortOrder = CostContract.CostEntry._ID + " ASC";
        Cursor cursor = db.query(CostContract.CostEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        if(cursor.moveToNext()){
            try {
                id = cursor.getLong(cursor.getColumnIndexOrThrow(CostContract.CostEntry._ID));
                SimpleDateFormat sdf = new SimpleDateFormat();
                date = sdf.parse(cursor.getString(cursor.getColumnIndexOrThrow(CostContract.CostEntry.COLUMN_NAME_DATE)));
                activityId = cursor.getLong(cursor.getColumnIndexOrThrow(CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID));
                numPeople = cursor.getInt(cursor.getColumnIndexOrThrow(CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE));
                unitValue = cursor.getFloat(cursor.getColumnIndexOrThrow(CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE));
                realCost = cursor.getFloat(cursor.getColumnIndexOrThrow(CostContract.CostEntry.COLUMN_NAME_REAL_COST));
                currency = cursor.getString(cursor.getColumnIndexOrThrow(CostContract.CostEntry.COLUMN_NAME_CURRENCY));
                subCategory = cursor.getString(cursor.getColumnIndexOrThrow(CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY));
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
        updatedFields.put(CostContract.CostEntry._ID,true);
        this.id = id;
    }

    @Override
    public float getUnitValue() {
        updateFields();
        return unitValue;
    }

    @Override
    public void setUnitValue(float unitValue) {
        updatedFields.put(CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE,true);
        this.unitValue = unitValue;
    }

    @Override
    public String getCurrency() {
        updateFields();
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        updatedFields.put(CostContract.CostEntry.COLUMN_NAME_CURRENCY,true);
        this.currency = currency;
    }

    @Override
    public String getSubCategory() {
        return subCategory;
    }

    @Override
    public void setSubCategory(String subCategory) {
        updatedFields.put(CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY,true);
        this.subCategory = subCategory;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        updatedFields.put(CostContract.CostEntry.COLUMN_NAME_DATE,true);
        this.date = date;
    }

    @Override
    public int getNumPeople() {
        return numPeople;
    }

    @Override
    public void setNumPeople(int numPeople) {
        updatedFields.put(CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE,true);
        this.numPeople = numPeople;
    }

    @Override
    public long getActivityId() {
        return activityId;
    }

    @Override
    public void setActivityId(long activityId) {
        updatedFields.put(CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID,true);
        this.activityId = activityId;
    }

    @Override
    public float getRealCost() {
        return realCost;
    }

    @Override
    public void setRealCost(float realCost) {
        updatedFields.put(CostContract.CostEntry.COLUMN_NAME_REAL_COST,true);
        this.realCost = realCost;
    }

    @Override
    public boolean create() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();

        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat();
        values.put(CostContract.CostEntry.COLUMN_NAME_DATE, sdf.format(date));
        values.put(CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID, activityId);
        values.put(CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE,numPeople);
        values.put(CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE,unitValue);
        values.put(CostContract.CostEntry.COLUMN_NAME_REAL_COST,realCost);
        values.put(CostContract.CostEntry.COLUMN_NAME_CURRENCY,currency);
        values.put(CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY,subCategory);

        id = db.insert(CostContract.CostEntry.TABLE_NAME, null,values);

        return id == -1 ? false : true;
    }

    @Override
    public boolean update() {
        ContentValues values = new ContentValues();
        for(Map.Entry<String,Boolean> entry : updatedFields.entrySet()){
            if(entry.getValue()){
                SimpleDateFormat sdf = new SimpleDateFormat();
                switch(entry.getKey()){
                    case CostContract.CostEntry.COLUMN_NAME_DATE : values.put(CostContract.CostEntry.COLUMN_NAME_DATE,sdf.format(date)); break;
                    case CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID : values.put(CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID,activityId); break;
                    case CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE : values.put(CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE,numPeople); break;
                    case CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE : values.put(CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE,unitValue); break;
                    case CostContract.CostEntry.COLUMN_NAME_REAL_COST : values.put(CostContract.CostEntry.COLUMN_NAME_REAL_COST,realCost); break;
                    case CostContract.CostEntry.COLUMN_NAME_CURRENCY : values.put(CostContract.CostEntry.COLUMN_NAME_CURRENCY,currency); break;
                    case CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY : values.put(CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY,subCategory); break;
                    default: break;
                }
            }
        }

        int nRowsAffected = 0;
        if(values.size() > 0){
            SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
            String selection = CostContract.CostEntry._ID + " =";
            String[] selectionArgs = {id + ""};
            nRowsAffected = db.update(CostContract.CostEntry.TABLE_NAME,values,selection,selectionArgs);
            updatedFields = new HashMap<String,Boolean>();
        }

        return nRowsAffected > 0;
    }

    @Override
    public boolean delete() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
        String selection = CostContract.CostEntry._ID + " =";
        String[] selectionArgs = {id + ""};
        int nRowsAffected = db.delete(CostContract.CostEntry.TABLE_NAME,selection,selectionArgs);

        return nRowsAffected > 0;
    }
}
