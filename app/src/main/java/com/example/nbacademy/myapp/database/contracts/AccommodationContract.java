package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class AccommodationContract {

    private AccommodationContract(){

    }

    public static class AccommodationEntry implements BaseColumns{

        private static final String TABLE_NAME = "accommodation";
        private static final String COLUMN_NAME_NAME = "name";
        private static final String COLUMN_NAME_ADDRESS = "adress";
        private static final String COLUMN_NAME_TYPE = "type";
        private static final String COLUMN_NAME_DATE_CHECKIN = "date_checkin";
        private static final String COLUMN_NAME_DATE_CHECKOUT = "date_checkout";
        private static final String COLUMN_NAME_FK_AGENCY = "fk_agency";
    }
}
