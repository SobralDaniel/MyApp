package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class AgencyContract {

    private AgencyContract(){

    }

    public static class AgencyEntry implements BaseColumns {
        //NOT USED FOR NOW
        public static final String TABLE_NAME = "agency";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ADDRESS = "adress";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_NIB = "nib";
    }
}
