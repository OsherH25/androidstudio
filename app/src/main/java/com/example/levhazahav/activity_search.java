package com.example.levhazahav;

import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_ADDRESS;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_AGE_RANGE;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_AVAILABLE_BEDS;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_IS_1;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_IS_2;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_IS_3;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_IS_4;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_IS_5;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_IS_6;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_LAT;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_LONG;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_NAME;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_PHONE_NUMBER;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_RATING;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_STAR_RATING;
import static com.example.levhazahav.MyDatabaseHelper.COLUMN_ELDHOUSE_ZONE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class activity_search extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnReturnHome;
    Button btnStartSearch;
    elderlyHouse elderlyHouse1, elderlyHouseT;
    MyDatabaseHelper myDatabaseHelper;
    ArrayList<elderlyHouse> allElderlyHouses;
    ArrayAdapter <elderlyHouse> elderlyHouseArrayAdapter;
    Cursor elderlyHouseCursor;


    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        nav = findViewById(R.id.bottom_navigation);
        btnReturnHome = findViewById(R.id.btnReturnHome);
        btnStartSearch = findViewById(R.id.btnStartSearch);

        btnReturnHome.setOnClickListener(this);
        btnStartSearch.setOnClickListener(this);

        nav.setSelectedItemId(R.id.search);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){


                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.classify:
                        startActivity(new Intent(getApplicationContext(),activity_classify.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.search:
                        return true;

                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(),activity_info.class));
                        overridePendingTransition(0,0);
                        return true;

                }


                return false;
            }
        });


        elderlyHouse1=new elderlyHouse("שם מקום","כתובת","טלפון","לאט","לונג",50,5.0,3,true,false,false,false,false,false,3,4);
        elderlyHouseT=new elderlyHouse("שםמקום","תובת","טלפון","לט","לונג",50,5.0,3,true,false,false,false,false,false,3,4);
        myDatabaseHelper = new MyDatabaseHelper(this);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouse1);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouseT);



        elderlyHouseCursor = myDatabaseHelper.getAllElderlyHousesTest();

        elderlyHouseT =new elderlyHouse();
        elderlyHouseCursor.moveToFirst();
        while(!elderlyHouseCursor.isAfterLast()){

            elderlyHouseT.setEldHouseName( elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_NAME)));
            elderlyHouseT.setAddress( elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_ADDRESS)));
            elderlyHouseT.setPhoneNumber( elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_PHONE_NUMBER)));
            elderlyHouseT.setLat( elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_LAT)));
            elderlyHouseT.setLong( elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_LONG)));
            elderlyHouseT.setAvailableBeds( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_AVAILABLE_BEDS)));
            elderlyHouseT.setRating( elderlyHouseCursor.getDouble(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_RATING)));
            elderlyHouseT.setStarRating( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_STAR_RATING)));
            boolean setis1= new Boolean(elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_1 ))).booleanValue();
            elderlyHouseT.setIs1(setis1);
            boolean setis2= new Boolean(elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_2))).booleanValue();
            elderlyHouseT.setIs1(setis2);
            boolean setis3= new Boolean(elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_3 ))).booleanValue();
            elderlyHouseT.setIs1(setis3);
            boolean setis4= new Boolean(elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_4 ))).booleanValue();
            elderlyHouseT.setIs1(setis4);
            boolean setis5= new Boolean(elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_5 ))).booleanValue();
            elderlyHouseT.setIs1(setis5);
            boolean setis6= new Boolean(elderlyHouseCursor.getString(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_6 ))).booleanValue();
            elderlyHouseT.setIs1(setis6);
            elderlyHouseT.setZone( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_ZONE)));
            elderlyHouseT.setAgeRange( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_AGE_RANGE)));
            Toast.makeText(this, elderlyHouseT.toString(), Toast.LENGTH_LONG).show();

            elderlyHouseCursor.moveToNext();
        }


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.btnStartSearch:
                Intent intent = new Intent(activity_search.this, activity_search_q1.class);
                startActivity(intent);
                break;


            case R.id.btnReturnHome:
                Intent intent1 = new Intent(activity_search.this, MainActivity.class);
                startActivity(intent1);
                break;



        }


    }
}

