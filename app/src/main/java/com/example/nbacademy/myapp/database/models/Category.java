package com.example.nbacademy.myapp.database.models;

import com.example.nbacademy.myapp.database.api.ICategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nbacademy on 10/03/2018.
 */
public class Category implements ICategory {

    private int destinationId, id;
    private String name;
    private Map<Integer,Activity> activities;

    @Override
    public int getId() {
        return id;
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
    public boolean removeActivity(int id) {
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
