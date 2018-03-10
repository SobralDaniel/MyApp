package com.example.nbacademy.myapp.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by nbacademy on 08/03/2018.
 */
public final class UserContract {

    private UserContract(){

    }

    public static class UserEntry implements BaseColumns {

        private static final String TABLE_NAME = "user";
        private static final String COLUMN_NAME_NAME = "name";
        private static final String COLUMN_NAME_PHONE_NUMBER = "phone_number";
        private static final String COLUMN_NAME_AGE = "age";
        private static final String COLUMN_NAME_NIF = "nif";
        private static final String COLUMN_NAME_PASSWORD = "password";
        private static final String COLUMN_NAME_EMAIL = "email";

    }
}
