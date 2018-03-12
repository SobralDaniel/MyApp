package com.example.nbacademy.myapp.database.api;

import com.example.nbacademy.myapp.database.models.Activity;

import java.util.List;

/**
 * Created by nbacademy on 10/03/2018.
 */
public interface ICategory extends ITable{

    int getId();

    int getDestinationId();

    void setDestinationId(int destinationId);

    String getName();

    void setName(String name);

    List<Activity> getActivities();

    boolean addActivity(Activity activity);

    boolean removeActivity(int id);
}
