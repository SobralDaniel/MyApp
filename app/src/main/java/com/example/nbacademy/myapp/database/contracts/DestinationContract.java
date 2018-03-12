package com.example.nbacademy.myapp.database.contracts;
import android.provider.BaseColumns;

/**
 * Created by nbacademy on 10/03/2018.
 */
public final class DestinationContract {

    private DestinationContract(){

    }

    public static class DestinationEntry implements BaseColumns {

        public static final String TABLE_NAME = "destination";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_START_DATE = "start_date";
        public static final String COLUMN_NAME_END_DATE = "end_date";
        public static final String COLUMN_NAME_MEAL_COST = "meal_cost";
        public static final String COLUMN_NAME_HOST_COST = "host_cost";
        public static final String COLUMN_NAME_CURRENCY = "currency";
        public static final String COLUMN_NAME_CURRENCY_VALUE = "currency_value";
        public static final String COLUMN_NAME_TIMEZONE = "timezone";
        public static final String COLUMN_NAME_TEMPERATURE = "temperature";
        public static final String COLUMN_NAME_ST_LUNCH = "st_lunch";//Percentage
        public static final String COLUMN_NAME_ST_DINNER = "st_dinner";//Percentage
        public static final String COLUMN_NAME_ST_PURCHASE = "st_purchase";//Percentage
        public static final String COLUMN_NAME_ST_EXTRA = "st_extra";//Logica de ligacao
        public static final String COLUMN_NAME_FK_TRIP_ID = "fk_trip_id";

    }
}
