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
        private static final String COLUMN_NAME_PHONE_NUMBER = "phone_number";
        private static final String COLUMN_NAME_NUM_PEOPLE = "num_people";
        private static final String COLUMN_NAME_PRICE = "price";
        private static final String COLUMN_NAME_ORIGIN = "origin";
        private static final String COLUMN_NAME_DESTINATION = "destination";//ISTO ESTA LIGADO COM VARIOS DESTINOS COM A TABELA DESTINO
        private static final String COLUMN_NAME_TYPE = "type";
        private static final String COLUMN_NAME_DATE_BEGIN = "date_begin";
        private static final String COLUMN_NAME_DATE_END = "date_end";
        private static final String COLUMN_NAME_STATUS = "status";
        private static final String COLUMN_NAME_TOTAL_BUDGET = "total_budget";
        private static final String COLUMN_NAME_FK_USERID = "fk_userid";
        private static final String COLUMN_NAME_FK_AGENCY = "fk_agency";

    }
}
