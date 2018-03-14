package com.example.nbacademy.myapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nbacademy.myapp.database.api.IActivity;
import com.example.nbacademy.myapp.database.api.ICategory;
import com.example.nbacademy.myapp.database.api.ICost;
import com.example.nbacademy.myapp.database.api.IDestination;
import com.example.nbacademy.myapp.database.api.ITrip;
import com.example.nbacademy.myapp.database.api.IUser;
import com.example.nbacademy.myapp.database.contracts.ActivityContract;
import com.example.nbacademy.myapp.database.contracts.CategoryContract;
import com.example.nbacademy.myapp.database.contracts.CostContract;
import com.example.nbacademy.myapp.database.contracts.DestinationContract;
import com.example.nbacademy.myapp.database.contracts.TripContract;
import com.example.nbacademy.myapp.database.contracts.UserContract;
import com.example.nbacademy.myapp.database.models.Activity;
import com.example.nbacademy.myapp.database.models.Category;
import com.example.nbacademy.myapp.database.models.Cost;
import com.example.nbacademy.myapp.database.models.Destination;
import com.example.nbacademy.myapp.database.models.Trip;
import com.example.nbacademy.myapp.database.models.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nbacademy on 08/03/2018.
 */
public class DBHelper extends SQLiteOpenHelper {

    public final static String DATE_FORMAT_DB = "YYYY-MM-DD HH:MM:SS";

    private static DBHelper dbHelperInstance;

    public static final String NAME = "TrespoDB";

    public static final int VERSION = 1;

    public static final String DB_CREATION_QUERY = "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " (" +
            UserContract.UserEntry._ID + " INTEGER PRIMARY KEY," +
            UserContract.UserEntry.COLUMN_NAME_NAME + " TEXT, " +
            UserContract.UserEntry.COLUMN_NAME_AGE + " INTEGER, " +
            UserContract.UserEntry.COLUMN_NAME_NIF + " TEXT, " +
            UserContract.UserEntry.COLUMN_NAME_PASSWORD + " TEXT, " +
            UserContract.UserEntry.COLUMN_NAME_EMAIL + " TEXT NOT NULL, " +
            UserContract.UserEntry.COLUMN_NAME_PHONE_NUMBER + " TEXT); " +

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
            TripContract.TripEntry.COLUMN_NAME_FK_USER_ID + " INTEGER NOT NULL " +
            "FOREIGN KEY ("+TripContract.TripEntry.COLUMN_NAME_FK_USER_ID+") REFERENCES " +
            UserContract.UserEntry.TABLE_NAME+" ("+UserContract.UserEntry._ID+"));" +

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
            DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID + " INTEGER NOT NULL " +
            "FOREIGN KEY ("+DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID+") REFERENCES " +
            TripContract.TripEntry.TABLE_NAME+" ("+TripContract.TripEntry._ID+"));" +

            "CREATE TABLE " + CategoryContract.CategoryEntry.TABLE_NAME + " (" +
            CategoryContract.CategoryEntry._ID + " INTEGER PRIMARY KEY," +
            CategoryContract.CategoryEntry.COLUMN_NAME_NAME + " TEXT NOT NULL, " +
            CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID + " INTEGER NOT NULL " +
            "FOREIGN KEY ("+CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID+") REFERENCES " +
            DestinationContract.DestinationEntry.TABLE_NAME+" ("+DestinationContract.DestinationEntry._ID+"));" +

            "CREATE TABLE " + ActivityContract.ActivityEntry.TABLE_NAME + " (" +
            ActivityContract.ActivityEntry._ID + " INTEGER PRIMARY KEY," +
            ActivityContract.ActivityEntry.COLUMN_NAME_NAME + " TEXT NOT NULL, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_PRICE + " REAL, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_RANKING + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_TYPE + " TEXT, " +
            ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID + " INTEGER NOT NULL " +
            "FOREIGN KEY ("+ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID+") REFERENCES " +
            CategoryContract.CategoryEntry.TABLE_NAME+" ("+CategoryContract.CategoryEntry._ID+"));" +

            "CREATE TABLE " + CostContract.CostEntry.TABLE_NAME + " (" +
            CostContract.CostEntry._ID + " INTEGER PRIMARY KEY," +
            CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE + " TEXT, " +
            CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE + " REAL, " +
            CostContract.CostEntry.COLUMN_NAME_DATE + " TEXT, " +
            CostContract.CostEntry.COLUMN_NAME_CURRENCY + " TEXT, " +
            CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY + " TEXT, " +
            CostContract.CostEntry.COLUMN_NAME_REAL_COST + " REAL, " +
            CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID + " INTEGER NOT NULL " +
            "FOREIGN KEY ("+CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID+") REFERENCES " +
            ActivityContract.ActivityEntry.TABLE_NAME+" ("+ActivityContract.ActivityEntry._ID+"));";

    private static final String DB_DELETE_QUERY = "DROP TABLE IF EXISTS " + CostContract.CostEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + ActivityContract.ActivityEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + CategoryContract.CategoryEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + DestinationContract.DestinationEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + TripContract.TripEntry.TABLE_NAME + ", " +
            "DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME + ";";

    public static DBHelper getInstance(Context context){
        if(dbHelperInstance == null)
            dbHelperInstance = new DBHelper(context);
        return dbHelperInstance;
    }

    private DBHelper(Context context) {
        super(context, DBHelper.NAME, null, DBHelper.VERSION);
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

    public IUser findUserById(long id){
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
            for(ITrip auxTrip : getAllTripsByUserId(user.getId()).values()){
                user.addTrip(auxTrip);
            }
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

        String sortOrder = UserContract.UserEntry._ID + " ASC";

        Cursor cursor = dbReadable.query(
                UserContract.UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
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
            for(ITrip auxTrip : getAllTripsByUserId(user.getId()).values()){
                user.addTrip(auxTrip);
            }
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

        String sortOrder = UserContract.UserEntry._ID + " ASC";

        Cursor cursor = dbReadable.query(
                UserContract.UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
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

            for(ITrip auxTrip : getAllTripsByUserId(user.getId()).values()){
                user.addTrip(auxTrip);
            }

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

        String sortOrder = TripContract.TripEntry._ID + " ASC";

        Cursor cursor = dbReadable.query(
                TripContract.TripEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DB);

        while(cursor.moveToNext()){

            try {
                ITrip trip = new Trip();
                trip.setId(cursor.getLong(cursor.getColumnIndex(TripContract.TripEntry._ID)));
                trip.setName(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_NAME)));
                trip.setStartDate(sdf.parse(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_START_DATE))));
                trip.setEndDate(sdf.parse(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_END_DATE))));
                trip.setNumPeople(cursor.getInt(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE)));
                trip.setPrice(cursor.getFloat(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_PRICE)));
                trip.setOrigin(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_ORIGIN)));
                trip.setType(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TYPE)));
                trip.setType(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TYPE)));
                trip.setStatus(cursor.getInt(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_STATUS)));
                trip.setTotalBudget(cursor.getFloat(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET)));

                for(IDestination auxDest : getAllDestinationsByTripId(trip.getId()).values()){
                    trip.addDestination(auxDest);
                }

                trips.put(trip.getId(),trip);
            } catch (ParseException e) {
                e.printStackTrace();
                //Handle Errors better
            }

        }

        cursor.close();

        return trips;
    }

    public Map<Long,ITrip> getAllTripsByUserId(long userId){
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

        String sortOrder = TripContract.TripEntry._ID + " ASC";

        String selection = TripContract.TripEntry.COLUMN_NAME_FK_USER_ID + "= ?";
        String[] selectionArgs = {""+userId};

        Cursor cursor = dbReadable.query(
                TripContract.TripEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DB);

        while(cursor.moveToNext()){

            try {
                ITrip trip = new Trip();
                trip.setId(cursor.getLong(cursor.getColumnIndex(TripContract.TripEntry._ID)));
                trip.setName(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_NAME)));
                trip.setStartDate(sdf.parse(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_START_DATE))));
                trip.setEndDate(sdf.parse(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_END_DATE))));
                trip.setNumPeople(cursor.getInt(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_NUM_PEOPLE)));
                trip.setPrice(cursor.getFloat(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_PRICE)));
                trip.setOrigin(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_ORIGIN)));
                trip.setType(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TYPE)));
                trip.setType(cursor.getString(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TYPE)));
                trip.setStatus(cursor.getInt(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_STATUS)));
                trip.setTotalBudget(cursor.getFloat(cursor.getColumnIndex(TripContract.TripEntry.COLUMN_NAME_TOTAL_BUDGET)));

                for(IDestination auxDest : getAllDestinationsByTripId(trip.getId()).values()){
                    trip.addDestination(auxDest);
                }

                trips.put(trip.getId(),trip);
            } catch (ParseException e) {
                e.printStackTrace();
                //Handle Errors better
            }

        }

        cursor.close();

        return trips;
    }

    public Map<Long,IDestination> getAllDestinationsByTripId(long tripId){
        Map<Long,IDestination> dests = new HashMap<Long,IDestination>();

        SQLiteDatabase dbReadable = dbHelperInstance.getReadableDatabase();

        String[] projection = {
                DestinationContract.DestinationEntry._ID,
                DestinationContract.DestinationEntry.COLUMN_NAME_NAME,
                DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE,
                DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE,
                DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST,
                DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST,
                DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY,
                DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE,
                DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE,
                DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE,
                DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH,
                DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER,
                DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE,
                DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA,
                DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID
        };

        String sortOrder = DestinationContract.DestinationEntry._ID + " ASC";

        String selection = DestinationContract.DestinationEntry.COLUMN_NAME_FK_TRIP_ID + "= ?";
        String[] selectionArgs = {""+tripId};

        Cursor cursor = dbReadable.query(
                TripContract.TripEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DB);

        while(cursor.moveToNext()){

            try {
                IDestination dest = new Destination();
                dest.setId(cursor.getLong(cursor.getColumnIndex(DestinationContract.DestinationEntry._ID)));
                dest.setDestinationName(cursor.getString(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_NAME)));
                dest.setInitialDate(sdf.parse(cursor.getString(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_START_DATE))));
                dest.setFinalDate(sdf.parse(cursor.getString(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_END_DATE))));
                dest.setMealCost(cursor.getDouble(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_MEAL_COST)));
                dest.setHostCost(cursor.getDouble(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_HOST_COST)));
                dest.setCurrency(cursor.getString(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY)));
                dest.setCurrencyValue(cursor.getDouble(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_CURRENCY_VALUE)));
                dest.setTimezone(cursor.getString(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_TIMEZONE)));
                dest.setTemperature(cursor.getDouble(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_TEMPERATURE)));
                dest.setPercLunch(cursor.getInt(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_ST_LUNCH)));
                dest.setPercDinner(cursor.getInt(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_ST_DINNER)));
                dest.setPercShops(cursor.getInt(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_ST_PURCHASE)));
                dest.setPercExtras(cursor.getInt(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA)));
                dest.setPercExtras(cursor.getInt(cursor.getColumnIndex(DestinationContract.DestinationEntry.COLUMN_NAME_ST_EXTRA)));

                for(ICategory auxCategory : getAllCategoriesByDestinationId(dest.getId()).values()){
                    dest.addCategory(auxCategory);
                }


                dests.put(dest.getId(),dest);
            } catch (ParseException e) {
                e.printStackTrace();
                //Handle Errors better
            }

        }

        cursor.close();

        return dests;
    }

    public Map<Long,ICategory> getAllCategoriesByDestinationId(long destId){
        Map<Long,ICategory> categories = new HashMap<Long,ICategory>();

        SQLiteDatabase dbReadable = dbHelperInstance.getReadableDatabase();

        String[] projection = {
                CategoryContract.CategoryEntry._ID,
                CategoryContract.CategoryEntry.COLUMN_NAME_NAME,
                CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID
        };

        String sortOrder = CategoryContract.CategoryEntry._ID + " ASC";

        String selection = CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID + "= ?";
        String[] selectionArgs = {""+destId};

        Cursor cursor = dbReadable.query(
                CategoryContract.CategoryEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DB);

        while(cursor.moveToNext()){

            ICategory category = new Category();
            category.setId(cursor.getLong(cursor.getColumnIndex(CategoryContract.CategoryEntry._ID)));
            category.setName(cursor.getString(cursor.getColumnIndex(CategoryContract.CategoryEntry.COLUMN_NAME_NAME)));
            category.setDestinationId(cursor.getLong(cursor.getColumnIndex(CategoryContract.CategoryEntry.COLUMN_NAME_FK_DESTINATION_ID)));

            for(IActivity auxActivity : getAllActivitiesByCategoryId(category.getId()).values()){
                category.addActivity(auxActivity);
            }

            categories.put(category.getId(),category);

        }

        cursor.close();

        return categories;
    }

    public Map<Long,IActivity> getAllActivitiesByCategoryId(long categoryId){
        Map<Long,IActivity> activities = new HashMap<Long,IActivity>();

        SQLiteDatabase dbReadable = dbHelperInstance.getReadableDatabase();

        String[] projection = {
                ActivityContract.ActivityEntry._ID,
                ActivityContract.ActivityEntry.COLUMN_NAME_NAME,
                ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE,
                ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE,
                ActivityContract.ActivityEntry.COLUMN_NAME_PRICE,
                ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS,
                ActivityContract.ActivityEntry.COLUMN_NAME_RANKING,
                ActivityContract.ActivityEntry.COLUMN_NAME_TYPE,
                ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID
        };

        String sortOrder = ActivityContract.ActivityEntry._ID + " ASC";

        String selection = ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID + "= ?";
        String[] selectionArgs = {""+categoryId};

        Cursor cursor = dbReadable.query(
                ActivityContract.ActivityEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DB);

        while(cursor.moveToNext()){

            try {
                IActivity activity = new Activity();
                activity.setId(cursor.getLong(cursor.getColumnIndex(ActivityContract.ActivityEntry._ID)));
                activity.setName(cursor.getString(cursor.getColumnIndex(ActivityContract.ActivityEntry.COLUMN_NAME_NAME)));
                activity.setStartDate(sdf.parse(cursor.getString(cursor.getColumnIndex(ActivityContract.ActivityEntry.COLUMN_NAME_START_DATE))));
                activity.setEndDate(sdf.parse(cursor.getString(cursor.getColumnIndex(ActivityContract.ActivityEntry.COLUMN_NAME_END_DATE))));
                activity.setPrice(cursor.getFloat(cursor.getColumnIndex(ActivityContract.ActivityEntry.COLUMN_NAME_PRICE)));
                activity.setAddress(cursor.getString(cursor.getColumnIndex(ActivityContract.ActivityEntry.COLUMN_NAME_ADDRESS)));
                activity.setRanking(cursor.getInt(cursor.getColumnIndex(ActivityContract.ActivityEntry.COLUMN_NAME_RANKING)));
                activity.setType(cursor.getString(cursor.getColumnIndex(ActivityContract.ActivityEntry.COLUMN_NAME_TYPE)));
                activity.setCategoryId(cursor.getLong(cursor.getColumnIndex(ActivityContract.ActivityEntry.COLUMN_NAME_FK_CATEGORY_ID)));

                activity.setCost(getCostByActivityId(activity.getId()));
                activities.put(activity.getId(),activity);
            } catch (ParseException e) {
                e.printStackTrace();
                //Handle Errors better
            }

        }

        cursor.close();

        return activities;
    }

    public ICost getCostByActivityId(long activityId){
        ICost cost = new Cost();

        SQLiteDatabase dbReadable = dbHelperInstance.getReadableDatabase();

        String[] projection = {
                CostContract.CostEntry._ID,
                CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE,
                CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE,
                CostContract.CostEntry.COLUMN_NAME_DATE,
                CostContract.CostEntry.COLUMN_NAME_CURRENCY,
                CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY,
                CostContract.CostEntry.COLUMN_NAME_REAL_COST,
                CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID
        };

        String sortOrder = CostContract.CostEntry._ID + " ASC";

        String selection = CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID + "= ?";
        String[] selectionArgs = {""+activityId};

        Cursor cursor = dbReadable.query(
                CostContract.CostEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DB);

        if(cursor.moveToNext()){

            try {
                cost = new Cost();
                cost.setId(cursor.getLong(cursor.getColumnIndex(CostContract.CostEntry._ID)));
                cost.setNumPeople(cursor.getInt(cursor.getColumnIndex(CostContract.CostEntry.COLUMN_NAME_NUM_PEOPLE)));
                cost.setUnitValue(cursor.getFloat(cursor.getColumnIndex(CostContract.CostEntry.COLUMN_NAME_UNIT_VALUE)));
                cost.setDate(sdf.parse(cursor.getString(cursor.getColumnIndex(CostContract.CostEntry.COLUMN_NAME_DATE))));
                cost.setCurrency(cursor.getString(cursor.getColumnIndex(CostContract.CostEntry.COLUMN_NAME_CURRENCY)));
                cost.setSubCategory(cursor.getString(cursor.getColumnIndex(CostContract.CostEntry.COLUMN_NAME_SUBCATEGORY)));
                cost.setRealCost(cursor.getFloat(cursor.getColumnIndex(CostContract.CostEntry.COLUMN_NAME_REAL_COST)));
                cost.setActivityId(cursor.getLong(cursor.getColumnIndex(CostContract.CostEntry.COLUMN_NAME_FK_ACTIVITY_ID)));
            } catch (ParseException e) {
                e.printStackTrace();
                //Handle Errors better
            }

        }

        cursor.close();

        return cost;
    }

}
