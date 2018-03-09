package com.example.nbacademy.myapp.database;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class AgencyContract {

    private AgencyContract(){

    }

    public static class AgencyEntry implements BaseColumns {

        private static final String TABLE_NAME = "agency";
        private static final String COLUMN_NAME_NAME = "name";
        private static final String COLUMN_NAME_ADDRESS = "adress";
        private static final String COLUMN_NAME_TYPE = "type";
        private static final String COLUMN_NAME_NIB = "nib";
    }
}
