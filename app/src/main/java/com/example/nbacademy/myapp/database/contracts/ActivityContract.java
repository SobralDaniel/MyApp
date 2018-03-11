package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class ActivityContract {

    private ActivityContract(){
        //Nothing to do here
    }

    /*Inner class representing a table*/
    public static class ActivityEntry implements BaseColumns{

        private static final String TABLE_NAME = "activity";
        private static final String COLUMN_NAME_NAME = "name";
        private static final String COLUMN_NAME_PRICE = "price";
        private static final String COLUMN_NAME_ADDRESS = "adress";
        private static final String COLUMN_NAME_START_DATE = "start_date";
        private static final String COLUMN_NAME_END_DATE = "end_date";
        private static final String COLUMN_NAME_RANKING = "ranking";
        private static final String COLUMN_NAME_TYPE = "type";
        private static final String COLUMN_NAME_FK_CATEGORY_ID = "fk_category_id";
    }
}
