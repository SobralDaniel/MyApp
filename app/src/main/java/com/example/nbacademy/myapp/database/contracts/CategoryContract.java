package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 10/03/2018.
 */
public final class CategoryContract {

    private CategoryContract(){

    }

    public static class CategoryEntry implements BaseColumns {

        public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_FK_DESTINATION_ID = "fk_destination_id";
    }
}
