package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class CostContract {

    private CostContract(){

    }

    public static class CostEntry implements BaseColumns {

        private static final String TABLE_NAME = "cost";
        private static final String COLUMN_NAME_NUM_PEOPLE = "num_people";
        private static final String COLUMN_NAME_UNIT_VALUE = "unit_value";
        private static final String COLUMN_NAME_DATE = "date";//timestamp
        private static final String COLUMN_NAME_CURRENCY = "currency";
        private static final String COLUMN_NAME_TRIP_DAY = "trip_day";
        private static final String COLUMN_NAME_SUBCATEGORY = "subcategory";
        private static final String COLUMN_NAME_TOTAL_EXPECTED_COST = "total_expected_cost";
        private static final String COLUMN_NAME_FK_ACTIVITY_ID = "fk_activity_id";
    }
}
