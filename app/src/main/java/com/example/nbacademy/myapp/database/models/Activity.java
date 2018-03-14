package com.example.nbacademy.myapp.database.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.IActivity;
import com.example.nbacademy.myapp.database.api.ICost;
import com.example.nbacademy.myapp.database.contracts.ActivityContract;
import com.example.nbacademy.myapp.database.contracts.DestinationContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nbacademy on 09/03/2018.
 */
public class Activity extends Table implements IActivity {

    private String name, address, type;
    private long id, categoryId;
    private float price, ranking;
    private Date startDate, endDate;
    private ICost cost;
    private Map<String,Boolean> updatedFields;

    public Activity()
    {
        super();
        updatedFields = new HashMap<String,Boolean>();
    }

    public void forceUpdateFields(){
        SQLiteDatabase db = DBHelper.getInstance(null).getReadableDatabase();

        String[] projection = {ActivityContract.ActivityEntry._ID,ActivityContract.ActivityEntry.COLUMN_NAME_NAME,
                ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS,ActivityContract.ActivityEntry.COLUMN_NAME_TYPE,
                ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID,ActivityContract.ActivityEntry.COLUMN_NAME_PRICE,
                ActivityContract.ActivityEntry.COLUMN_NAME_RANKING,ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE,
                ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE
        };

        String selection = ActivityContract.ActivityEntry._ID + "= ?";
        String[] selectionArgs = {""+id};

        String sortOrder = ActivityContract.ActivityEntry._ID + " ASC";
        Cursor cursor = db.query(ActivityContract.ActivityEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        if(cursor.moveToNext()){
            try {
                id = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry._ID));
                SimpleDateFormat sdf = new SimpleDateFormat();
                startDate = sdf.parse(cursor.getString(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE)));
                endDate = sdf.parse(cursor.getString(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE)));
                name = cursor.getString(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_NAME));
                address = cursor.getString(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS));
                type = cursor.getString(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_TYPE));
                categoryId = cursor.getLong(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID));
                price = cursor.getFloat(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_PRICE));
                ranking = cursor.getFloat(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_RANKING));
                price = cursor.getFloat(cursor.getColumnIndexOrThrow(ActivityContract.ActivityEntry.COLUMN_NAME_PRICE));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateFields(){
        if(getFromDB()){
            forceUpdateFields();
            resetTimerDB();
        }
    }

    @Override
    public long getId() {
        updateFields();
        return id;
    }

    @Override
    public void setId(long id){
        updatedFields.put(ActivityContract.ActivityEntry._ID,true);
        this.id = id;
    }

    @Override
    public String getName() {
        updateFields();
        return name;
    }

    @Override
    public void setName(String name) {
        updatedFields.put(ActivityContract.ActivityEntry.COLUMN_NAME_NAME,true);
        this.name = name;
    }

    @Override
    public String getAddress(){
        updateFields();
        return address;
    }

    @Override
    public void setAddress(String address) {
        updatedFields.put(ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS,true);
        this.address = address;
    }

    @Override
    public String getType() {
        updateFields();
        return type;
    }

    @Override
    public void setType(String type) {
        updatedFields.put(ActivityContract.ActivityEntry.COLUMN_NAME_TYPE,true);
        this.type = type;
    }

    @Override
    public float getPrice() {
        updateFields();
        return price;
    }

    @Override
    public void setPrice(float price) {
        updatedFields.put(ActivityContract.ActivityEntry.COLUMN_NAME_PRICE,true);
        this.price = price;
    }

    @Override
    public long getCategoryId() {
        updateFields();
        return categoryId;
    }

    @Override
    public void setCategoryId(long categoryId) {
        updatedFields.put(ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID,true);
        this.categoryId = categoryId;
    }

    @Override
    public float getRanking() {
        updateFields();
        return ranking;
    }

    @Override
    public void setRanking(float ranking) {
        updatedFields.put(ActivityContract.ActivityEntry.COLUMN_NAME_RANKING,true);
        this.ranking = ranking;
    }

    @Override
    public Date getStartDate() {
        updateFields();
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        updatedFields.put(ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE,true);
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        updateFields();
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        updatedFields.put(ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE,true);
        this.endDate = endDate;
    }

    @Override
    public ICost getCost() {
        cost.forceUpdateFields();
        return cost;
    }

    @Override
    public void setCost(ICost cost) {
        this.cost = cost;
    }

    @Override
    public boolean create() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();

        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat();
        values.put(ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE, sdf.format(startDate));
        values.put(ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE, sdf.format(endDate));
        values.put(ActivityContract.ActivityEntry.COLUMN_NAME_NAME,name);
        values.put(ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS,address);
        values.put(ActivityContract.ActivityEntry.COLUMN_NAME_TYPE,type);
        values.put(ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID,categoryId);
        values.put(ActivityContract.ActivityEntry.COLUMN_NAME_PRICE,price);
        values.put(ActivityContract.ActivityEntry.COLUMN_NAME_RANKING,ranking);

        id = db.insert(ActivityContract.ActivityEntry.TABLE_NAME, null,values);

        return id == -1 ? false : true;
    }

    @Override
    public boolean update() {
        ContentValues values = new ContentValues();
        for(Map.Entry<String,Boolean> entry : updatedFields.entrySet()){
            if(entry.getValue()){
                SimpleDateFormat sdf = new SimpleDateFormat();
                switch(entry.getKey()){
                    case ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE : values.put(ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE,sdf.format(startDate)); break;
                    case ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE : values.put(ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE,sdf.format(endDate)); break;
                    case ActivityContract.ActivityEntry.COLUMN_NAME_NAME : values.put(ActivityContract.ActivityEntry.COLUMN_NAME_NAME,name); break;
                    case ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS : values.put(ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS,address); break;
                    case ActivityContract.ActivityEntry.COLUMN_NAME_TYPE : values.put(ActivityContract.ActivityEntry.COLUMN_NAME_TYPE,type); break;
                    case ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID : values.put(ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID,categoryId); break;
                    case ActivityContract.ActivityEntry.COLUMN_NAME_PRICE : values.put(ActivityContract.ActivityEntry.COLUMN_NAME_PRICE,price); break;
                    case ActivityContract.ActivityEntry.COLUMN_NAME_RANKING : values.put(ActivityContract.ActivityEntry.COLUMN_NAME_RANKING,ranking); break;
                    default: break;
                }
            }
        }

        int nRowsAffected = 0;
        if(values.size() > 0){
            SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
            String selection = ActivityContract.ActivityEntry._ID + " =";
            String[] selectionArgs = {id + ""};
            nRowsAffected = db.update(ActivityContract.ActivityEntry.TABLE_NAME,values,selection,selectionArgs);
            updatedFields = new HashMap<String,Boolean>();
        }

        return nRowsAffected > 0;
    }

    @Override
    public boolean delete() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
        String selection = ActivityContract.ActivityEntry._ID + " =";
        String[] selectionArgs = {id + ""};
        int nRowsAffected = db.delete(ActivityContract.ActivityEntry.TABLE_NAME,selection,selectionArgs);

        return nRowsAffected > 0;
    }
}
