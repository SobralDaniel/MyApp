package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 10/03/2018.
 */
public final class CategoryContract {

    private CategoryContract(){

    }

    public static class CategoryEntry implements BaseColumns {

        private static final String TABLE_NAME = "category";
        private static final String COLUMN_NAME_NAME = "name";
        private static final String COLUMN_NAME_START_DATE = "start_date";
        private static final String COLUMN_NAME_END_DATE = "end_date";
        private static final String COLUMN_NAME_MEAL_COST = "meal_cost";
        private static final String COLUMN_NAME_HOST_COST = "host_cost";
        private static final String COLUMN_NAME_CURRENCY = "currency";
        private static final String COLUMN_NAME_CURRENCY_VALUE = "currency_value";
        private static final String COLUMN_NAME_TIMEZONE = "timezone";
        private static final String COLUMN_NAME_TEMPERATURE = "temperature";
        private static final String COLUMN_NAME_ST_LUNCH = "st_lunch";//Percentage
        private static final String COLUMN_NAME_ST_DINNER = "st_dinner";//Percentage
        private static final String COLUMN_NAME_ST_PURCHASE = "st_purchase";//Percentage
        private static final String COLUMN_NAME_ST_EXTRA = "st_extra";//Logica de ligacao
        private static final String COLUMN_NAME_FK_DESTINATIONID = "fk_destinationid";

    }
}
