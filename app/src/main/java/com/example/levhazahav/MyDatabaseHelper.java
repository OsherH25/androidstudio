package com.example.levhazahav;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    public static final String DATABASE_NAME="databaseEldHouse.db";
    public static final int DATABASE_VERSION=1;


    public MyDatabaseHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open()
    {
        database=this.getWritableDatabase();
        Log.i("data", "DB CONNECTION OPEND");

    }

    public static final String TABLE_ELD_HOUSE="tblEldHouse";
    public static final String COLUMN_ELDHOUSE_NAME="EldHouseName";
    public static final String COLUMN_ELDHOUSE_ADDRESS="Address";
    public static final String COLUMN_ELDHOUSE_PHONE_NUMBER="PhoneNumber";
    public static final String COLUMN_ELDHOUSE_LONG="long";
    public static final String COLUMN_ELDHOUSE_LAT="Lat";
    public static final String COLUMN_ELDHOUSE_AVAILABLE_BEDS="AvailableBeds";
    public static final String COLUMN_ELDHOUSE_RATING="Rating";
    public static final  String COLUMN_ELDHOUSE_STAR_RATING="StarRating";
    public static final  String COLUMN_ELDHOUSE_IS_1="is1";
    public static final String COLUMN_ELDHOUSE_IS_2="is2";
    public static final  String COLUMN_ELDHOUSE_IS_3="is3";
    public static final  String COLUMN_ELDHOUSE_IS_4="is4";
    public static final  String COLUMN_ELDHOUSE_IS_5="is5";
    public static final  String COLUMN_ELDHOUSE_IS_6="is6";
    public static final String COLUMN_ELDHOUSE_ZONE="zone";
    public static final String COLUMN_ELDHOUSE_AGE_RANGE="AgeRange";


    public static final String CREATE_TABLE_ELD_HOUSE = "CREATE TABLE IF NOT EXISTS "+  TABLE_ELD_HOUSE
            + "(" + COLUMN_ELDHOUSE_NAME + " VARCHAR,"
            + COLUMN_ELDHOUSE_ADDRESS + " VARCHAR," + COLUMN_ELDHOUSE_PHONE_NUMBER + " VARCHAR,"
            + COLUMN_ELDHOUSE_LONG + " VARCHAR," + COLUMN_ELDHOUSE_LAT + " VARCHAR," + COLUMN_ELDHOUSE_AVAILABLE_BEDS + " INTEGER," + COLUMN_ELDHOUSE_RATING + " DOUBLE,"
            + COLUMN_ELDHOUSE_STAR_RATING + " INTEGER," + COLUMN_ELDHOUSE_IS_1 + " BOOLEAN," + COLUMN_ELDHOUSE_IS_2 + " BOOLEAN,"
            + COLUMN_ELDHOUSE_IS_3 + " BOOLEAN," + COLUMN_ELDHOUSE_IS_4 + " BOOLEAN," + COLUMN_ELDHOUSE_IS_5
            + " BOOLEAN," + COLUMN_ELDHOUSE_IS_6 + " BOOLEAN," + COLUMN_ELDHOUSE_ZONE + " INTEGER," + COLUMN_ELDHOUSE_AGE_RANGE +  " INTEGER" + ");";



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_ELD_HOUSE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ELD_HOUSE);
        onCreate(sqLiteDatabase);

    }


    public long InsertToElderlyHouse(elderlyHouse elderlyHouse)
    {
        open();
        ContentValues ELD_House_value = new ContentValues();
        ELD_House_value.put(COLUMN_ELDHOUSE_NAME,elderlyHouse.getEldHouseName());
        ELD_House_value.put(COLUMN_ELDHOUSE_ADDRESS,elderlyHouse.getAddress());
        ELD_House_value.put(COLUMN_ELDHOUSE_PHONE_NUMBER,elderlyHouse.getPhoneNumber());
        ELD_House_value.put(COLUMN_ELDHOUSE_LONG,elderlyHouse.getLong());
        ELD_House_value.put(COLUMN_ELDHOUSE_LAT,elderlyHouse.getLat());
        ELD_House_value.put(COLUMN_ELDHOUSE_AVAILABLE_BEDS,elderlyHouse.getAvailableBeds());
        ELD_House_value.put(COLUMN_ELDHOUSE_RATING,elderlyHouse.getRating());
        ELD_House_value.put(COLUMN_ELDHOUSE_STAR_RATING,elderlyHouse.getStarRating());
        ELD_House_value.put(COLUMN_ELDHOUSE_IS_1,elderlyHouse.isIs1());
        ELD_House_value.put(COLUMN_ELDHOUSE_IS_2,elderlyHouse.isIs2());
        ELD_House_value.put(COLUMN_ELDHOUSE_IS_3,elderlyHouse.isIs3());
        ELD_House_value.put(COLUMN_ELDHOUSE_IS_4,elderlyHouse.isIs4());
        ELD_House_value.put(COLUMN_ELDHOUSE_IS_5,elderlyHouse.isIs5());
        ELD_House_value.put(COLUMN_ELDHOUSE_IS_6,elderlyHouse.isIs6());
        ELD_House_value.put(COLUMN_ELDHOUSE_ZONE,elderlyHouse.getZone());
        ELD_House_value.put(COLUMN_ELDHOUSE_AGE_RANGE,elderlyHouse.getAgeRange());


        return database.insert(TABLE_ELD_HOUSE,null,ELD_House_value);
    }


    public ArrayList<elderlyHouse> getAllElderlyHouses()
    {
        ArrayList<elderlyHouse> elderlyHouseArr= new ArrayList<>();
        String query= " select * from "+ TABLE_ELD_HOUSE;
        Cursor cursor= database.rawQuery(query,null );
        if (cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                 @SuppressLint("Range") String EldHouseName =cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_NAME));
                @SuppressLint("Range")String Address=cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_ADDRESS));
                @SuppressLint("Range")String PhoneNumber=cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_PHONE_NUMBER));
                @SuppressLint("Range")String Lat =cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_LAT));
                @SuppressLint("Range")String Long =cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_LONG));
                @SuppressLint("Range")int  AvailableBeds =cursor.getInt(cursor.getColumnIndex(COLUMN_ELDHOUSE_AVAILABLE_BEDS));
                @SuppressLint("Range")double Rating=cursor.getDouble(cursor.getColumnIndex(COLUMN_ELDHOUSE_RATING));
                @SuppressLint("Range")int StarRating=cursor.getInt(cursor.getColumnIndex(COLUMN_ELDHOUSE_STAR_RATING));
                @SuppressLint("Range")boolean is1= new Boolean(cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_IS_1 ))).booleanValue();
                @SuppressLint("Range")boolean is2= new Boolean(cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_IS_2 ))).booleanValue();
                @SuppressLint("Range")boolean is3= new Boolean(cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_IS_3 ))).booleanValue();
                @SuppressLint("Range")boolean is4= new Boolean(cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_IS_4 ))).booleanValue();
                @SuppressLint("Range")boolean is5= new Boolean(cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_IS_5 ))).booleanValue();
                @SuppressLint("Range")boolean is6= new Boolean(cursor.getString(cursor.getColumnIndex(COLUMN_ELDHOUSE_IS_6 ))).booleanValue();
                @SuppressLint("Range")int Zone=cursor.getInt(cursor.getColumnIndex(COLUMN_ELDHOUSE_ZONE));
                @SuppressLint("Range") int AgeRange =cursor.getInt(cursor.getColumnIndex(COLUMN_ELDHOUSE_ZONE));
                elderlyHouse currElderlyHouse= new elderlyHouse(EldHouseName, Address, PhoneNumber,Lat,Long,AvailableBeds,Rating,StarRating,is1,is2,is3,is4,is5,is6,Zone,AgeRange);
                elderlyHouseArr.add(currElderlyHouse);
            }
        }
        return elderlyHouseArr;
    }


    public Cursor getAllElderlyHousesTest()
    {
        open();
        String[] columns = new String[] {COLUMN_ELDHOUSE_NAME, COLUMN_ELDHOUSE_ADDRESS,COLUMN_ELDHOUSE_PHONE_NUMBER,
                COLUMN_ELDHOUSE_LAT, COLUMN_ELDHOUSE_LONG,COLUMN_ELDHOUSE_AVAILABLE_BEDS,COLUMN_ELDHOUSE_RATING,COLUMN_ELDHOUSE_STAR_RATING,COLUMN_ELDHOUSE_IS_1
                ,COLUMN_ELDHOUSE_IS_2,COLUMN_ELDHOUSE_IS_3,COLUMN_ELDHOUSE_IS_4,COLUMN_ELDHOUSE_IS_5,COLUMN_ELDHOUSE_IS_6
                ,COLUMN_ELDHOUSE_ZONE,COLUMN_ELDHOUSE_ZONE};

        return database.query(TABLE_ELD_HOUSE, columns, null,
                null, null, null, null);

    }




    public void deleteAllDataFromTblElderlyHouse()
    {
        String strDeleteElderlyHouse_sql= "DELETE FROM "+ TABLE_ELD_HOUSE;
        database.execSQL(strDeleteElderlyHouse_sql);
    }

    public void deleteElderlyHouseByRowName(String EldHouseName)
    {
        String str_sql= "DELETE FROM "+ TABLE_ELD_HOUSE+ " WHERE" + COLUMN_ELDHOUSE_NAME + "="+ EldHouseName;
        database.execSQL(str_sql);
    }



}
