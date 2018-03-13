package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class TripContract {

    private TripContract(){

    }

    public static class TripEntry implements BaseColumns {

        public static final String TABLE_NAME = "trip";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_START_DATE = "start_date";
        public static final String COLUMN_NAME_END_DATE = "end_date";
        public static final String COLUMN_NAME_NUM_PEOPLE = "num_people";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_ORIGIN = "origin";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_STATUS = "status";//Logica de ligacao
        public static final String COLUMN_NAME_TOTAL_BUDGET = "total_budget";
        public static final String COLUMN_NAME_FK_USER_ID = "fk_user_id";

    }
}
