package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class CostContract {

    private CostContract(){

    }

    public static class CostEntry implements BaseColumns {

        public static final String TABLE_NAME = "cost";
        public static final String COLUMN_NAME_NUM_PEOPLE = "num_people";
        public static final String COLUMN_NAME_UNIT_VALUE = "unit_value";
        public static final String COLUMN_NAME_DATE = "date";//timestamp
        public static final String COLUMN_NAME_CURRENCY = "currency";
        public static final String COLUMN_NAME_SUBCATEGORY = "subcategory";
        public static final String COLUMN_NAME_TOTAL_EXPECTED_COST = "total_expected_cost";
        public static final String COLUMN_NAME_FK_ACTIVITY_ID = "fk_activity_id";
    }
}
