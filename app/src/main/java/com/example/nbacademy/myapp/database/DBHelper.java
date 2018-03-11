package com.example.nbacademy.myapp.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nbacademy.myapp.database.contracts.TripContract;
import com.example.nbacademy.myapp.database.contracts.UserContract;

/**
 * Created by nbacademy on 08/03/2018.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper dbHelperInstance;

    private static final String DB_CREATION_QUERY = "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " (" +
            UserContract.UserEntry._ID + " INTEGER PRIMARY KEY," +
            UserContract.UserEntry.COLUMN_NAME_NAME + " TEXT, " +
            UserContract.UserEntry.COLUMN_NAME_AGE + " INTEGER, " +
            UserContract.UserEntry.COLUMN_NAME_NIF + " TEXT, " +
            UserContract.UserEntry.COLUMN_NAME_PASSWORD + " TEXT, " +
            UserContract.UserEntry.COLUMN_NAME_EMAIL + " TEXT, " +
            UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER + " TEXT)," +

            "CREATE TABLE " + TripContract.TripEntry.TABLE_NAME + " (" +
            TripContract.TripEntry._ID + " INTEGER PRIMARY KEY," +
            TripContract.TripEntry.COLUMN_NAME_NAME + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_AGE + " INTEGER, " +
            TripContract.TripEntry.COLUMN_NAME_NIF + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_PASSWORD + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_EMAIL + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_PHONE_NUMBER + " TEXT)," +;

    public static DBHelper getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        if(dbHelperInstance == null)
            dbHelperInstance = new DBHelper(context, name, factory, version);
        return dbHelperInstance;
    }

    public static DBHelper getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler){
        if(dbHelperInstance == null)
            dbHelperInstance = new DBHelper(context, name, factory, version, errorHandler);
        return dbHelperInstance;
    }
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("QUERIES DE CRIACAO DE TODAS AS TABELAS");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("QUERIES PARA APAGAR AS TABELAS");
        //VER SE FAZ SENTIDO USAR O OLDVERSION E O NEWVERSION
        this.onCreate(db);
    }
}
