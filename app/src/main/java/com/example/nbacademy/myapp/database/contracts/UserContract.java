package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class UserContract {

    private UserContract(){

    }

    public static class UserEntry implements BaseColumns {

        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PHONE_NUMBER = "phone_number";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_NIF = "nif";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_EMAIL = "email";

    }
}
