package com.example.nbacademy.myapp.database.api;

import java.util.Date;

/**
 * Created by NBAcademy on 10/03/2018.
 */

public interface IDestination extends ITable {

    int getId();

    Date getInitialDate();

    void setInitialDate (Date date1);

    Date getFinalDate();

    void setFinalDate (Date date2);

    Double getMealCost ();

    void setMealCost (Double mealCost);

    Double getHostCost();

    void setHostCost (Double hostCost);

    String getCurrency();

    void setCurrency (String currency);

    Float getCurrencyValue();

    void setCurrencyValue (Float currencyValue);

    String getTimezone ();

    void setTimezone (String timezone);

    String getTemperature();

    void setTemperature (String temperature);

    int getTripId();

    int getPercLunch();

    void setPercLunch (int percLunch);

    int getPercDinner();

    void setPercDinner (int percDinner);

    int getPercShops ();

    void setPercShops (int percShops);

    int getPercExtras();

    void setPercExtras(int percExtras);

    int getDestinationId();

    String destinationName();

    void setDestinationName (String destinationName);
}
