package com.example.nbacademy.myapp.database.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.IActivity;
import com.example.nbacademy.myapp.database.api.ICategory;
import com.example.nbacademy.myapp.database.api.IDestination;
import com.example.nbacademy.myapp.database.api.ITrip;
import com.example.nbacademy.myapp.database.contracts.CategoryContract;
import com.example.nbacademy.myapp.database.contracts.DestinationContract;
import com.example.nbacademy.myapp.database.contracts.TripContract;
import com.example.nbacademy.myapp.database.contracts.UserContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nbacademy on 10/03/2018.
 */
public class Category extends Table implements ICategory {

    private long id,destinationId;
    private String name;
    private Map<Long,IActivity> activities;
    private Map<String,Boolean> updatedFields;

    public Category(){
        super();
        activities = new HashMap<Long,IActivity>();
        updatedFields = new HashMap<String,Boolean>();
    }

    public void forceUpdateFields(){
        SQLiteDatabase db = DBHelper.getInstance(null).getReadableDatabase();

        String[] projection = {CategoryContract.CategoryEntry._ID,CategoryContract.CategoryEntry.COLUMN_NAME_NAME,
                CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID
        };

        String selection = CategoryContract.CategoryEntry._ID + "= ?";
        String[] selectionArgs = {""+id};

        String sortOrder = CategoryContract.CategoryEntry._ID + " ASC";
        Cursor cursor = db.query(CategoryContract.CategoryEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        if(cursor.moveToNext()){
            id = cursor.getLong(cursor.getColumnIndexOrThrow(CategoryContract.CategoryEntry._ID));
            name = cursor.getString(cursor.getColumnIndexOrThrow(CategoryContract.CategoryEntry.COLUMN_NAME_NAME));
            destinationId = cursor.getLong(cursor.getColumnIndexOrThrow(CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID));
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
        updatedFields.put(CategoryContract.CategoryEntry._ID,true);
    }

    public long getDestinationId() {
        updateFields();
        return destinationId;
    }

    public void setDestinationId(long destinationId) {
        this.destinationId = destinationId;
        updatedFields.put(CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID,true);
    }

    public String getName() {
        updateFields();
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updatedFields.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAME,true);
    }

    @Override
    public List<IActivity> getActivities() {
        List<IActivity> auxactivities = new ArrayList<IActivity>(activities.values());

        for(IActivity auxAct : auxactivities)
        {
            auxAct.forceUpdateFields();
            auxAct.getCost().forceUpdateFields();
        }

        return auxactivities;
    }

    @Override
    public boolean addActivity(IActivity activity) {
        if(activity != null && !activities.containsKey(activity.getId())){
            activity.setCategoryId(this.id);
            activities.put(activity.getId(),activity);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeActivity(long id) {
        return activities.remove(id) != null ? true : false;
    }
    
    @Override
    public boolean create() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();

        SimpleDateFormat sdf = new SimpleDateFormat(DBHelper.DATE_FORMAT_DB);

        ContentValues values = new ContentValues();
        values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAME,name);
        values.put(CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID,destinationId);

        id = db.insert(CategoryContract.CategoryEntry.TABLE_NAME,null,values);

        return id == -1 ? false : true;
    }

    @Override
    public boolean update() {
        ContentValues values = new ContentValues();

        for(Map.Entry<String,Boolean> entry : updatedFields.entrySet()){
            if(entry.getValue()){
                switch(entry.getKey()){
                    case CategoryContract.CategoryEntry.COLUMN_NAME_NAME : values.put(CategoryContract.CategoryEntry.COLUMN_NAME_NAME,name); break;
                    case CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID : values.put(CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID,destinationId); break;
                    default: break;
                }
            }
        }

        int nRowsAffected = 0;
        if(values.size() > 0){
            SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
            String selection = CategoryContract.CategoryEntry._ID + " =";
            String[] selectionArgs = {id + ""};
            nRowsAffected = db.update(CategoryContract.CategoryEntry.TABLE_NAME,values,selection,selectionArgs);
            updatedFields = new HashMap<String,Boolean>();
        }

        return nRowsAffected > 0;
    }

    @Override
    public boolean delete() {
        SQLiteDatabase db = DBHelper.getInstance(null).getWritableDatabase();
        String selection = CategoryContract.CategoryEntry._ID + " =";
        String[] selectionArgs = {id + ""};
        int nRowsAffected = db.delete(CategoryContract.CategoryEntry.TABLE_NAME,selection,selectionArgs);

        return nRowsAffected > 0;
    }
}
