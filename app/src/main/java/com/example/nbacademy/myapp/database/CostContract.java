package com.example.nbacademy.myapp.database;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class CostContract {

    private CostContract(){

    }

    public static class CostEntry implements BaseColumns {

        private static final String TABLE_NAME = "trip";
        private static final String COLUMN_NAME_DESTINATION = "destination";//ISTO ESTA LIGADO COM UM DESTINO NA TABELA DESTINO
        private static final String COLUMN_NAME_DURATION_IN_DAYS = "duration_in_days";
        private static final String COLUMN_NAME_UNIT_VALUE = "unit_value";
        private static final String COLUMN_NAME_DATE = "date";
        private static final String COLUMN_NAME_CURRENCY = "currency";
        private static final String COLUMN_NAME_TRIP_DAY = "trip_day";
        private static final String COLUMN_NAME_FK_CATEGORY_ID = "fk_category_id";
        private static final String COLUMN_NAME_SUBCATEGORY = "fk_subcategory";
        private static final String COLUMN_NAME_TOTAL_EXPECTED_COST = "total_expected_cost";
    }
}
