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
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class activity_search_results extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    TextView tvResultNum;
    int resultNum=0; // the amount of elderly houses that are found
    Intent takeAll;
    String zone,age,classify;
    Cursor ElderlyHouseCursor;
    MyDatabaseHelper myDatabaseHelper;
    elderlyHouse elderlyHouse;
   ListView listView;
    ArrayList<String> stringInfoArray;
    Button btnReturnResults;
    ArrayList<elderlyHouse> mArrayList;
    ArrayListAdapter adapter;
    Dialog dialogInfoElderlyHouse;
    TextView tvLocation, tvPhone, tvAvBedsNum, tvRating, btnSendMsg;
    Object obj;
    int possition;
    elderlyHouse eldhus;




    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        nav = findViewById(R.id.bottom_navigation);
        tvResultNum = findViewById(R.id.tvResultNum);
        btnReturnResults = findViewById(R.id.btnReturnResults);
        listView = findViewById(R.id.lv);
        stringInfoArray=new ArrayList<>();
        btnReturnResults.setOnClickListener(this);
        takeAll= getIntent();
        zone = takeAll.getStringExtra("Zone");
        age = takeAll.getStringExtra("Age");
        classify = takeAll.getStringExtra("Class");


        resultNum=0;
        listView.setAdapter(null);
        adapter = new ArrayListAdapter(this, null);




        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){


                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        resultNum=0;
                        return true;

                    case R.id.classify:
                        startActivity(new Intent(getApplicationContext(),activity_classify.class));
                        overridePendingTransition(0,0);
                        resultNum=0;
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(),activity_search.class));
                        overridePendingTransition(0,0);
                        resultNum=0;
                        return true;

                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(),activity_info.class));
                        overridePendingTransition(0,0);
                        resultNum=0;
                        return true;

                }


                return false;
            }





        });




        showAll();

    }

    private void onCreateDialogInfoEH() {
        dialogInfoElderlyHouse=new Dialog(this);
        dialogInfoElderlyHouse.setContentView(R.layout.elderlyhouse_dialog_layout);



         tvPhone = dialogInfoElderlyHouse.findViewById(R.id.tvPhone);
         tvPhone.setText(eldhus.getPhoneNumber());
         tvAvBedsNum = dialogInfoElderlyHouse.findViewById(R.id.tvAvBedsNum);
         tvAvBedsNum.setText(String.valueOf(eldhus.getAvailableBeds()));
         tvRating = dialogInfoElderlyHouse.findViewById(R.id.tvRating);
         tvRating.setText(String.valueOf(eldhus.getRating()));
         btnSendMsg = dialogInfoElderlyHouse.findViewById(R.id.btnSendMsg);
         btnSendMsg.setOnClickListener(this);


        dialogInfoElderlyHouse.setCancelable(true);
        dialogInfoElderlyHouse.show();
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnReturnResults:
                Intent intent = new Intent(activity_search_results.this, activity_search_q4.class);
                resultNum=0;
                startActivity(intent);
                break;
        }
        if(view==btnSendMsg)
        {
            Toast.makeText(activity_search_results.this, "נשלחה הודעה :)", Toast.LENGTH_SHORT).show();
        }
    }




    @SuppressLint("Range")
    public void showAll()
    {
        mArrayList = new ArrayList<elderlyHouse>();
        mArrayList.clear();

        myDatabaseHelper = new MyDatabaseHelper(this);
        ElderlyHouseCursor=null;
        ElderlyHouseCursor = myDatabaseHelper.getAllElderlyHousesTest();
        ElderlyHouseCursor.moveToFirst();
        resultNum=0;
        int i=0;
        while(!ElderlyHouseCursor.isAfterLast()){

            elderlyHouse=new elderlyHouse();
            elderlyHouse.setEldHouseName( ElderlyHouseCursor.getString(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_NAME)));
            elderlyHouse.setAddress( ElderlyHouseCursor.getString(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_ADDRESS)));
            elderlyHouse.setPhoneNumber( ElderlyHouseCursor.getString(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_PHONE_NUMBER)));
            elderlyHouse.setLat( ElderlyHouseCursor.getString(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_LAT)));
            elderlyHouse.setLong( ElderlyHouseCursor.getString(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_LONG)));
            elderlyHouse.setAvailableBeds( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_AVAILABLE_BEDS)));
            elderlyHouse.setRating( ElderlyHouseCursor.getDouble(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_RATING)));
            elderlyHouse.setStarRating( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_STAR_RATING)));
            elderlyHouse.setIs1( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_1)));
            elderlyHouse.setIs2( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_2)));
            elderlyHouse.setIs3( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_3)));
            elderlyHouse.setIs4( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_4)));
            elderlyHouse.setIs5( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_5)));
            elderlyHouse.setIs6( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_IS_6)));
            elderlyHouse.setZone( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_ZONE)));
            elderlyHouse.setAgeRange( ElderlyHouseCursor.getInt(ElderlyHouseCursor.getColumnIndex(COLUMN_ELDHOUSE_AGE_RANGE)));
            if(elderlyHouse.getZone()==Integer.valueOf(zone) && elderlyHouse.getAgeRange()==Integer.valueOf(age) )
            {
                if (classify.equals("1") &&elderlyHouse.getIs1()==1 )
                {
                    resultNum++;
                    //Add to list view
                    mArrayList.add(elderlyHouse);
                }
                else if (classify.equals("2") &&elderlyHouse.getIs2()==1)
                {
                    resultNum++;
                    //Add to list view
                    mArrayList.add(elderlyHouse);

                }
                else if (classify.equals("3") &&elderlyHouse.getIs3()==1)
                {
                    resultNum++;
                    //Add to list view
                    mArrayList.add(elderlyHouse);

                }
                else  if (classify.equals("4") &&elderlyHouse.getIs4()==1)
                {
                    resultNum++;
                    //Add to list view
                    mArrayList.add(elderlyHouse);
                }
                else if (classify.equals("5") &&elderlyHouse.getIs5()==1)
                {
                    resultNum++;
                    //Add to list view
                    mArrayList.add(elderlyHouse);
                }
                else if (classify.equals("6") &&elderlyHouse.getIs6()==1)
                {
                    resultNum++;
                    //Add to list view
                    mArrayList.add(elderlyHouse);
                }
            }

            ElderlyHouseCursor.moveToNext();
        }



        adapter = new ArrayListAdapter(this, mArrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                obj = listView.getItemAtPosition(position);
                eldhus = ((elderlyHouse) obj);
                onCreateDialogInfoEH();


            }
        });



        tvResultNum.setText("נמצאו "+ resultNum + " תוצאות חיפוש");

    }


}

