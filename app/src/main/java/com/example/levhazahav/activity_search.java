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
    elderlyHouse elderlyHouse1, elderlyHouseT, elderlyHouse2, elderlyHouse3,elderlyHouse4,elderlyHouse5,elderlyHouse6,elderlyHouse7;
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


        elderlyHouse1=new elderlyHouse("קרן אסתר ויונה","יעקב דורי 2 - באר שבע","08-6407444","31.2683099311294","34.7840541271467",30,4.5,4,0,1,0,0,0,0,6,2);
        elderlyHouse2=new elderlyHouse("נת.ן -ורד הכרמל בעמ","פינסקי 26-חיפה","04-8389236","32.8034002324403","34.979453586634",50,4,4,0,0,0,1,1,0,2,1);
        elderlyHouse3=new elderlyHouse("כנרת רד ליין","השומר 2-טבריה","04-6716016","32.8002519369124","35.526033317317",15,3,3,1,0,1,1,1,0,1,3);
        elderlyHouse4=new elderlyHouse("נוה הורים מושב זקנים","ת.ד. 888, מעלה זאב -ירושלים","02-6403333","31.7592386638576","35.2058132580121",50,4.8,4,1,1,1,1,1,0,5,4);
        elderlyHouse5=new elderlyHouse( "אגודה למען הזקן - גיל הזהב","קדש 25 א', ת.ד. 265-אופקים","08-9963344","34.61566379646915","31.316151595772098",50,5.0,5,0,0,1,1,1,0,6,3);
        elderlyHouse6=new elderlyHouse("בית מנוחה לזקנים","רב קוק 3-בני ברק","03-6182542","32.0854890491489","34.8254962241625",20,3,3,0,0,1,1,1,0,4,5);
        elderlyHouse7=new elderlyHouse("מעון זקנים הרצליה","הרב קוק 91-הרצליה","09-9500134","32.1628040521417","34.8306443578118",16,5.0,5,1,1,1,1,1,0,3,2);


        myDatabaseHelper = new MyDatabaseHelper(this);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouse1);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouse2);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouse3);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouse4);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouse5);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouse6);
        myDatabaseHelper.InsertToElderlyHouse(elderlyHouse7);


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
            elderlyHouseT.setIs1( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_1)));
            elderlyHouseT.setIs2( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_2)));
            elderlyHouseT.setIs3( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_3)));
            elderlyHouseT.setIs4( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_4)));
            elderlyHouseT.setIs5( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_5)));
            elderlyHouseT.setIs6( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_6)));
            elderlyHouseT.setZone( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_ZONE)));
            elderlyHouseT.setAgeRange( elderlyHouseCursor.getInt(elderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_AGE_RANGE)));
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

