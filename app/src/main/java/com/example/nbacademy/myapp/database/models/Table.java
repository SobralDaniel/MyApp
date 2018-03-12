package com.example.nbacademy.myapp.database.models;

/**
 * Created by nbacademy on 12/03/2018.
 */
public class Table {

    protected static final long GET_TIME_INTERVAL = 5000;
    protected long lastTimeGet;

    public Table(){
        this.lastTimeGet = System.currentTimeMillis();
    }

    public boolean getFromDB(){
        return System.currentTimeMillis() - this.lastTimeGet > GET_TIME_INTERVAL;
    }
}
