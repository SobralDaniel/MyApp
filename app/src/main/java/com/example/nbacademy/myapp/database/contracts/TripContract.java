package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class TripContract {

    private TripContract(){

    }

    public static class TripEntry implements BaseColumns {

        private static final String TABLE_NAME = "trip";
        private static final String COLUMN_NAME_NAME = "name";
        private static final String COLUMN_NAME_START_DATE = "start_date";
        private static final String COLUMN_NAME_END_DATE = "end_date";
        private static final String COLUMN_NAME_NUM_PEOPLE = "num_people";
        private static final String COLUMN_NAME_PRICE = "price";
        private static final String COLUMN_NAME_ORIGIN = "origin";
        private static final String COLUMN_NAME_TYPE = "type";
        private static final String COLUMN_NAME_STATUS = "status";//Logica de ligacao
        private static final String COLUMN_NAME_TOTAL_BUDGET = "total_budget";
        private static final String COLUMN_NAME_FK_USERID = "fk_userid";

    }
}
