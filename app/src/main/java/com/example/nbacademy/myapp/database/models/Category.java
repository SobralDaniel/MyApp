package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.ICategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nbacademy on 10/03/2018.
 */
public class Category implements ICategory {

    private long id;
    private int destinationId;
    private String name;
    private Map<Long,Activity> activities;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id){
        this.id = id;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Activity> getActivities() {
        return new ArrayList<Activity>(activities.values());
    }

    @Override
    public boolean addActivity(Activity activity) {
        if(activity != null && !activities.containsKey(activity.getId())){
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
