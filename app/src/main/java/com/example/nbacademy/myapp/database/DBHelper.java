package com.example.nbacademy.myapp.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nbacademy.myapp.database.contracts.ActivityContract;
import com.example.nbacademy.myapp.database.contracts.CategoryContract;
import com.example.nbacademy.myapp.database.contracts.CostContract;
import com.example.nbacademy.myapp.database.contracts.DestinationContract;
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
            UserContract.UserEntry.COLUMN_NAME_EMAIL + " TEXT NOT NULL, " +
            UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER + " TEXT), " +

            TripContract.TripEntry.COLUMN_NAME_NAME + " TEXT NOT NULL, " +
            TripContract.TripEntry.COLUMN_NAME_START_DATE + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_END_DATE + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE + " REAL, " +
            TripContract.TripEntry.COLUMN_NAME_PRICE + " REAL, " +
            TripContract.TripEntry.COLUMN_NAME_ORIGIN + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_TYPE + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_STATUS + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_TYPE + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_STATUS + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET + " REAL, " +
            TripContract.TripEntry.COLUMN_NAME_FK_USER_ID + " INTEGER NOT NULL" +
            "FOREIGN KEY ("+TripContract.TripEntry.COLUMN_NAME_FK_USER_ID+") REFERENCES " +
            UserContract.UserEntry.TABLE_NAME+" ("+UserContract.UserEntry._ID+"))," +

            "CREATE TABLE " + DestinationContract.DestinationEntry.TABLE_NAME + " (" +
            DestinationContract.DestinationEntry._ID + " INTEGER PRIMARY KEY," +
            DestinationContract.DestinationEntry.COLUMN_NAME_NAME + " TEXT NOT NULL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE + " TEXT, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE + " TEXT, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST + " REAL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST + " REAL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY + " TEXT, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE + " REAL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE + " TEXT, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE + " REAL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH + " REAL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER + " REAL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE + " REAL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA + " REAL, " +
            DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID + " INTEGER NOT NULL" +
            "FOREIGN KEY ("+DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID+") REFERENCES " +
            TripContract.TripEntry.TABLE_NAME+" ("+TripContract.TripEntry._ID+"))," +

            "CREATE TABLE " + CategoryContract.CategoryEntry.TABLE_NAME + " (" +
            CategoryContract.CategoryEntry._ID + " INTEGER PRIMARY KEY," +
            CategoryContract.CategoryEntry.COLUMN_NAME_NAME + " TEXT NOT NULL, " +
            CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID + " INTEGER NOT NULL" +
            "FOREIGN KEY ("+CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID+") REFERENCES " +
            DestinationContract.DestinationEntry.TABLE_NAME+" ("+DestinationContract.DestinationEntry._ID+"))," +

            "CREATE TABLE " + ActivityContract.ActivityEntry.TABLE_NAME + " (" +
            ActivityContract.ActivityEntry._ID + " INTEGER PRIMARY KEY," +
            ActivityContract.ActivityEntry.COLUMN_NAME_NAME + " TEXT NOT NULL, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_PRICE + " REAL, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_RANKING + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_TYPE + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID + " INTEGER NOT NULL" +
            "FOREIGN KEY ("+ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID+") REFERENCES " +
            CategoryContract.CategoryEntry.TABLE_NAME+" ("+CategoryContract.CategoryEntry._ID+"))," +

            "CREATE TABLE " + CostContract.CostEntry.TABLE_NAME + " (" +
            CostContract.CostEntry._ID + " INTEGER PRIMARY KEY," +
            CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE + " TEXT, " +
            CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE + " REAL, " +
            CostContract.CostEntry.COLUMN_NAME_DATE + " TEXT, " +
            CostContract.CostEntry.COLUMN_NAME_CURRENCY + " TEXT, " +
            CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY + " TEXT, " +
            CostContract.CostEntry.COLUMN_NAME_TOTAL_EXPECTED_COST + " REAL, " +
            CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID + " INTEGER NOT NULL" +
            "FOREIGN KEY ("+CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID+") REFERENCES " +
            ActivityContract.ActivityEntry.TABLE_NAME+" ("+ActivityContract.ActivityEntry._ID+"));";

    private static final String DB_DELETE_QUERY = "DROP TABLE IF EXISTS " + CostContract.CostEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + ActivityContract.ActivityEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + CategoryContract.CategoryEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + DestinationContract.DestinationEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + TripContract.TripEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME + ";";


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
        db.execSQL(DB_CREATION_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DB_DELETE_QUERY);
        //CHECK IF IT MAKES SENSE TO USE OLDVERSION AND NEWVERSION
        this.onCreate(db);
    }
}
