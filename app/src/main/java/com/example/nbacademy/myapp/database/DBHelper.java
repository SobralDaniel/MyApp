package com.example.nbacademy.myapp.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nbacademy on 08/03/2018.
 */
public class DBHelper extends SQLiteOpenHelper {

    //private static final String DB_CREATION_QUERY = "CREATE TABLE " + User;

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
