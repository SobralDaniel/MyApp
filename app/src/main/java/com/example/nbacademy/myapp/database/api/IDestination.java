package com.example.nbacademy.myapp.database.api;

import java.lang.reflect.Array;
import java.util.Date;

/**
 * Created by NBAcademy on 10/03/2018.
 */

public interface IDestination extends ITable {

    int getId();

    Date getInitialDate();

    void setInitialDate (Date initialDate);

    Date getFinalDate();

    void setFinalDate (Date finalDate);

    double getMealCost ();

    void setMealCost (Double mealCost);

    double getHostCost();

    void setHostCost (Double hostCost);

    String getCurrency();

    void setCurrency (String currency);

    double getCurrencyValue();

    void setCurrencyValue (double currencyValue);

    String getTimezone ();

    void setTimezone (String timezone);

    double getTemperature();

    void setTemperature (double temperature);

    int getTripId();

    void setTripId (int tripId);

    int getPercLunch();

    void setPercLunch (int percLunch);

    int getPercDinner();

    void setPercDinner (int percDinner);

    int getPercShops ();

    void setPercShops (int percShops);

    int getPercExtras();

    void setPercExtras(int percExtras);

    void setDestinationName (String destinationName);

    ICategory[] getCategories();

    boolean addCategory  (ICategory category);

    boolean removeCategory (String categoryName);

}
