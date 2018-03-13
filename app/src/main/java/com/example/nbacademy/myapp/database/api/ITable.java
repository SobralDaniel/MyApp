package com.example.nbacademy.myapp.database.api;

/**
 * Created by nbacademy on 09/03/2018.
 */
public interface ITable {

    /**
     * Creates a new entry in a table.
     * @return true - in case of success, false - otherwise
     */
    public boolean create();

    /**
     * Updates an entry in a table.
     * @return true - in case of success, false - otherwise
     */
    public boolean update();

    /**
     * Delete an entry from a table.
     * @return true - in case of success, false - otherwise
     */
    public boolean delete();
}
