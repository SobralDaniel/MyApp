package com.example.nbacademy.myapp.database.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.IActivity;
import com.example.nbacademy.myapp.database.api.ICategory;
import com.example.nbacademy.myapp.database.api.IDestination;
import com.example.nbacademy.myapp.database.api.ITrip;
import com.example.nbacademy.myapp.database.contracts.TripContract;
import com.example.nbacademy.myapp.database.contracts.UserContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nbacademy on 10/03/2018.
 */
public class Trip extends Table implements ITrip {

    private Date startDate, endDate;
    private long id, userId;
    private int numPeople, status;
    private String name, origin, type;
    private float totalBudget, price;

    private Map<Long,IDestination> destinations;
    private Map<String,Boolean> updatedFields;

    public Trip(){
        super();
        destinations = new HashMap<Long,IDestination>();
        updatedFields = new HashMap<String,Boolean>();
    }

    public void forceUpdateFields(){
        SQLiteDatabase db = DBHelper.getInstance(null).getReadableDatabase();

        String[] projection = {TripContract.TripEntry._ID,TripContract.TripEntry.COLUMN_NAME_NAME,
                TripContract.TripEntry.COLUMN_NAME_START_DATE,TripContract.TripEntry.COLUMN_NAME_END_DATE,
                TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE, TripContract.TripEntry.COLUMN_NAME_PRICE,
                TripContract.TripEntry.COLUMN_NAME_ORIGIN, TripContract.TripEntry.COLUMN_NAME_TYPE,
                TripContract.TripEntry.COLUMN_NAME_STATUS, TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET,
                TripContract.TripEntry.COLUMN_NAME_FK_USER_ID
        };

        String selection = TripContract.TripEntry._ID + "= ?";
        String[] selectionArgs = {""+id};

        String sortOrder = TripContract.TripEntry._ID + " ASC";
        Cursor cursor = db.query(TripContract.TripEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        SimpleDateFormat sdf = new SimpleDateFormat(DBHelper.DATE_FORMAT_DB);

        if(cursor.moveToNext()){
            try {
                id = cursor.getLong(cursor.getColumnIndexOrThrow(TripContract.TripEntry._ID));
                name = cursor.getString(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_NAME));
                startDate = sdf.parse(cursor.getString(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_START_DATE)));
                endDate = sdf.parse(cursor.getString(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_END_DATE)));
                numPeople = cursor.getInt(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE));
                status = cursor.getInt(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_STATUS));
                origin = cursor.getString(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_ORIGIN));
                type = cursor.getString(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_TYPE));
                totalBudget = cursor.getFloat(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET));
                price = cursor.getFloat(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_PRICE));
                userId = cursor.getLong(cursor.getColumnIndexOrThrow(TripContract.TripEntry.COLUMN_NAME_FK_USER_ID));
                getDestinations();
            } catch (ParseException e) {
                e.printStackTrace();
                //Handle errors better
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
        this.id = id;
        updatedFields.put(TripContract.TripEntry._ID,true);
    }

    @Override
    public float getPrice() {
        updateFields();
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_PRICE,true);
    }

    @Override
    public int getStatus() {
        updateFields();
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_STATUS,true);
    }

    @Override
    public String getName() {
        updateFields();
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_NAME,true);
    }

    @Override
    public String getOrigin() {
        updateFields();
        return origin;
    }

    @Override
    public void setOrigin(String origin) {
        this.origin = origin;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_ORIGIN,true);
    }

    @Override
    public String getType() {
        updateFields();
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_TYPE,true);
    }

    @Override
    public float getTotalBudget() {
        updateFields();
        return totalBudget;
    }

    @Override
    public void setTotalBudget(float totalBudget) {
        this.totalBudget = totalBudget;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET,true);
    }

    @Override
    public long getUserId() {
        updateFields();
        return userId;
    }

    @Override
    public void setUserId(long id) {
        this.userId = id;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_FK_USER_ID,true);
    }

    @Override
    public Date getStartDate() {
        updateFields();
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_START_DATE,true);
    }

    @Override
    public Date getEndDate() {
        updateFields();
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_END_DATE,true);
    }

    @Override
    public int getNumPeople() {
        updateFields();
        return numPeople;
    }

    @Override
    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
        updatedFields.put(TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE,true);
    }

    @Override
    public List<IDestination> getDestinations() {
        List<IDestination> auxDests = new ArrayList<IDestination>(destinations.values());

        //Really bad approach, change this in the future

        for(IDestination auxDest : auxDests)
        {
            auxDest.forceUpdateFields();
            for(ICategory auxCat : auxDest.getCategories())
            {
                auxCat.forceUpdateFields();
                for(IActivity auxAct : auxCat.getActivities())
                {
                    auxAct.forceUpdateFields();
                    auxAct.getCost().forceUpdateFields();
                }
            }
        }
        return auxDests;
    }

    @Override
    public boolean addDestination(IDestination destination) {
        if(destination != null && !destinations.containsKey(destination.getId())){
            destination.setTripId(this.id);
            destinations.put(destination.getId(),destination);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDestination(long id) {
        if(destinations.remove(id) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean create() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();

        SimpleDateFormat sdf = new SimpleDateFormat(DBHelper.DATE_FORMAT_DB);

        ContentValues values = new ContentValues();
        values.put(TripContract.TripEntry.COLUMN_NAME_NAME,name);
        values.put(TripContract.TripEntry.COLUMN_NAME_START_DATE,sdf.format(startDate));
        values.put(TripContract.TripEntry.COLUMN_NAME_END_DATE,sdf.format(endDate));
        values.put(TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE,numPeople);
        values.put(TripContract.TripEntry.COLUMN_NAME_PRICE,price);
        values.put(TripContract.TripEntry.COLUMN_NAME_ORIGIN,origin);
        values.put(TripContract.TripEntry.COLUMN_NAME_TYPE,type);
        values.put(TripContract.TripEntry.COLUMN_NAME_STATUS,status);
        values.put(TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET,totalBudget);
        values.put(TripContract.TripEntry.COLUMN_NAME_FK_USER_ID,userId);

        id = db.insert(TripContract.TripEntry.TABLE_NAME,null,values);

        return id == -1 ? false : true;
    }

    @Override
    public boolean update() {
        ContentValues values = new ContentValues();

        SimpleDateFormat sdf = new SimpleDateFormat(DBHelper.DATE_FORMAT_DB);

        for(Map.Entry<String,Boolean> entry : updatedFields.entrySet()){
            if(entry.getValue()){
                switch(entry.getKey()){
                    case TripContract.TripEntry.COLUMN_NAME_NAME : values.put(TripContract.TripEntry.COLUMN_NAME_NAME,name); break;
                    case TripContract.TripEntry.COLUMN_NAME_START_DATE : values.put(TripContract.TripEntry.COLUMN_NAME_START_DATE,sdf.format(startDate)); break;
                    case TripContract.TripEntry.COLUMN_NAME_END_DATE : values.put(TripContract.TripEntry.COLUMN_NAME_END_DATE,sdf.format(endDate)); break;
                    case TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE : values.put(TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE,numPeople); break;
                    case TripContract.TripEntry.COLUMN_NAME_PRICE : values.put(TripContract.TripEntry.COLUMN_NAME_PRICE,price); break;
                    case TripContract.TripEntry.COLUMN_NAME_ORIGIN : values.put(TripContract.TripEntry.COLUMN_NAME_ORIGIN,origin); break;
                    case TripContract.TripEntry.COLUMN_NAME_TYPE : values.put(TripContract.TripEntry.COLUMN_NAME_TYPE,type); break;
                    case TripContract.TripEntry.COLUMN_NAME_STATUS : values.put(TripContract.TripEntry.COLUMN_NAME_STATUS,status); break;
                    case TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET : values.put(TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET,totalBudget); break;
                    case TripContract.TripEntry.COLUMN_NAME_FK_USER_ID : values.put(TripContract.TripEntry.COLUMN_NAME_FK_USER_ID,userId);; break;
                    default: break;
                }
            }
        }

        int nRowsAffected = 0;
        if(values.size() > 0){
            SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
            String selection = TripContract.TripEntry._ID + " =";
            String[] selectionArgs = {id + ""};
            nRowsAffected = db.update(TripContract.TripEntry.TABLE_NAME,values,selection,selectionArgs);
            updatedFields = new HashMap<String,Boolean>();
        }

        return nRowsAffected > 0;
    }

    @Override
    public boolean delete() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
        String selection = TripContract.TripEntry._ID + " =";
        String[] selectionArgs = {id + ""};
        int nRowsAffected = db.delete(TripContract.TripEntry.TABLE_NAME,selection,selectionArgs);

        return nRowsAffected > 0;
    }
}
