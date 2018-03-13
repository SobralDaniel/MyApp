package com.example.nbacademy.myapp.database.api;

import com.example.nbacademy.myapp.database.models.Activity;

import java.util.List;

/**
 * Created by nbacademy on 10/03/2018.
 */
public interface ICategory extends ITable{

    long getId();

    void setId(long id);

    int getDestinationId();

    void setDestinationId(int destinationId);

    String getName();

    void setName(String name);

    List<Activity> getActivities();

    boolean addActivity(Activity activity);

    boolean removeActivity(long id);
}
