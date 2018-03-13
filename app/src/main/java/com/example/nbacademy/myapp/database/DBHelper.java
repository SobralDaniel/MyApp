package com.example.nbacademy.myapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nbacademy.myapp.database.api.ITrip;
import com.example.nbacademy.myapp.database.api.IUser;
import com.example.nbacademy.myapp.database.contracts.ActivityContract;
import com.example.nbacademy.myapp.database.contracts.CategoryContract;
import com.example.nbacademy.myapp.database.contracts.CostContract;
import com.example.nbacademy.myapp.database.contracts.DestinationContract;
import com.example.nbacademy.myapp.database.contracts.TripContract;
import com.example.nbacademy.myapp.database.contracts.UserContract;
import com.example.nbacademy.myapp.database.models.Trip;
import com.example.nbacademy.myapp.database.models.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

            "CREATE TABLE " + TripContract.TripEntry.TABLE_NAME + " (" +
            TripContract.TripEntry._ID + " INTEGER PRIMARY KEY," +
            TripContract.TripEntry.COLUMN_NAME_NAME + " TEXT NOT NULL, " +
            TripContract.TripEntry.COLUMN_NAME_START_DATE + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_END_DATE + " TEXT, " +
            TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE + " REAL, " +
            TripContract.TripEntry.COLUMN_NAME_PRICE + " REAL, " +
            TripContract.TripEntry.COLUMN_NAME_ORIGIN + " TEXT, " +
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
            CostContract.CostEntry.COLUMN_NAME_REAL_COST + " REAL, " +
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

    public IUser findUserById(int id){
        IUser user = null;

        SQLiteDatabase dbReadable = dbHelperInstance.getReadableDatabase();

        String[] projection = {
                UserContract.UserEntry._ID,
                UserContract.UserEntry.COLUMN_NAME_NAME,
                UserContract.UserEntry.COLUMN_NAME_AGE,
                UserContract.UserEntry.COLUMN_NAME_NIF,
                UserContract.UserEntry.COLUMN_NAME_PASSWORD,
                UserContract.UserEntry.COLUMN_NAME_EMAIL,
                UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER
        };

        String selection = UserContract.UserEntry._ID + " = ?";
        String[] selectionArgs = { id+"" };

        Cursor cursor = dbReadable.query(
                UserContract.UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        //dbReadable.execSQL("SELECT * from "+UserContract.UserEntry.TABLE_NAME + " where "
        //        + UserContract.UserEntry._ID + " = " +id);

        if(cursor.moveToNext()){
            user = new User();
            user.setId(cursor.getLong(cursor.getColumnIndex(UserContract.UserEntry._ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_NAME)));
            user.setAge(cursor.getInt(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_AGE)));
            user.setEmail(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_EMAIL)));
            user.setNif(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_NIF)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_PASSWORD)));
            user.setPhoneNumber(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER)));
        }

        cursor.close();

        return user;
    }

    public IUser findUserByEmail(String email){
        IUser user = null;

        SQLiteDatabase dbReadable = dbHelperInstance.getReadableDatabase();

        String[] projection = {
                UserContract.UserEntry._ID,
                UserContract.UserEntry.COLUMN_NAME_NAME,
                UserContract.UserEntry.COLUMN_NAME_AGE,
                UserContract.UserEntry.COLUMN_NAME_NIF,
                UserContract.UserEntry.COLUMN_NAME_PASSWORD,
                UserContract.UserEntry.COLUMN_NAME_EMAIL,
                UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER
        };

        String selection = UserContract.UserEntry.COLUMN_NAME_EMAIL + " = ?";
        String[] selectionArgs = { email+"" };

        Cursor cursor = dbReadable.query(
                UserContract.UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        //dbReadable.execSQL("SELECT * from "+UserContract.UserEntry.TABLE_NAME + " where "
        //        + UserContract.UserEntry._ID + " = " +id);

        if(cursor.moveToNext()){
            user = new User();
            user.setId(cursor.getLong(cursor.getColumnIndex(UserContract.UserEntry._ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_NAME)));
            user.setAge(cursor.getInt(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_AGE)));
            user.setEmail(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_EMAIL)));
            user.setNif(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_NIF)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_PASSWORD)));
            user.setPhoneNumber(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER)));
        }

        cursor.close();

        return user;
    }

    public Map<Long,IUser> getAllUsers(){
        Map<Long,IUser> users = new HashMap<Long,IUser>();

        SQLiteDatabase dbReadable = dbHelperInstance.getReadableDatabase();

        String[] projection = {
                UserContract.UserEntry._ID,
                UserContract.UserEntry.COLUMN_NAME_NAME,
                UserContract.UserEntry.COLUMN_NAME_AGE,
                UserContract.UserEntry.COLUMN_NAME_NIF,
                UserContract.UserEntry.COLUMN_NAME_PASSWORD,
                UserContract.UserEntry.COLUMN_NAME_EMAIL,
                UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER
        };

        Cursor cursor = dbReadable.query(
                UserContract.UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        while(cursor.moveToNext()){
            IUser user = new User();
            user.setId(cursor.getLong(cursor.getColumnIndex(UserContract.UserEntry._ID)));
            user.setName(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_NAME)));
            user.setAge(cursor.getInt(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_AGE)));
            user.setEmail(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_EMAIL)));
            user.setNif(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_NIF)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_PASSWORD)));
            user.setPhoneNumber(cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER)));
            users.put(user.getId(),user);
        }

        cursor.close();

        return users;
    }

    public Map<Long,ITrip> getAllTrips(){
        Map<Long,ITrip> trips = new HashMap<Long,ITrip>();

        SQLiteDatabase dbReadable = dbHelperInstance.getReadableDatabase();

        String[] projection = {
                TripContract.TripEntry._ID,
                TripContract.TripEntry.COLUMN_NAME_NAME,
                TripContract.TripEntry.COLUMN_NAME_START_DATE,
                TripContract.TripEntry.COLUMN_NAME_END_DATE,
                TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE,
                TripContract.TripEntry.COLUMN_NAME_PRICE,
                TripContract.TripEntry.COLUMN_NAME_ORIGIN,
                TripContract.TripEntry.COLUMN_NAME_TYPE,
                TripContract.TripEntry.COLUMN_NAME_STATUS,
                TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET,
                TripContract.TripEntry.COLUMN_NAME_FK_USER_ID,
        };

        Cursor cursor = dbReadable.query(
                TripContract.TripEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        while(cursor.moveToNext()){
            ITrip trip = new Trip();
            trip.setId(cursor.getLong(cursor.getColumnIndex(TripContract.TripEntry._ID)));
            trip.setName(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_NAME)));
            trip.setStartDate(new Date(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_START_DATE))));
            trip.setEndDate(new Date(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_END_DATE))));
            trip.setNumPeople(cursor.getInt(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE)));
            trip.setPrice(cursor.getFloat(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_PRICE)));
            trip.setOrigin(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_ORIGIN)));
            trip.setType(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TYPE)));
            trip.setType(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TYPE)));
            trip.setStatus(cursor.getInt(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_STATUS)));
            trip.setTotalBudget(cursor.getFloat(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET)));
            trips.put(trip.getId(),trip);
        }

        cursor.close();

        return trips;
    }
}
