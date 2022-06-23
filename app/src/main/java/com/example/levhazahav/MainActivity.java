package com.example.levhazahav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    ImageButton btnClassify;
    ImageButton btnSearch;
    ImageButton btncalculate;
    ImageButton btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.bottom_navigation);
        nav.setSelectedItemId(R.id.home);

        btnClassify = (ImageButton) findViewById(R.id.btnclassify);
        btnSearch = (ImageButton) findViewById(R.id.btnsearch);
        btncalculate = (ImageButton) findViewById(R.id.btncalculate);
        btnInfo = (ImageButton) findViewById(R.id.btninfo);

        btnClassify.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btncalculate.setOnClickListener(this);
        btnInfo.setOnClickListener(this);


        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

             switch (item.getItemId()){


                 case R.id.home:
                     return true;

                 case R.id.classify:
                     startActivity(new Intent(getApplicationContext(),activity_classify.class));
                     overridePendingTransition(0,0);
                     return true;

                 case R.id.search:
                     startActivity(new Intent(getApplicationContext(),activity_search.class));
                     overridePendingTransition(0,0);
                     return true;

                 case R.id.info:
                     startActivity(new Intent(getApplicationContext(),activity_info.class));
                     overridePendingTransition(0,0);
                     return true;


             }


                return false;
            }
        });



    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.btnclassify:
           Intent intent = new Intent(MainActivity.this, activity_classify.class);
                startActivity(intent);

                break;


           case R.id.btnsearch:
                Intent intent2 = new Intent(MainActivity.this, activity_search.class);
               startActivity(intent2);

               break;


            case R.id.btninfo:
                Intent intent3 = new Intent(this, activity_info.class);
               startActivity(intent3);

                break;

            case R.id.btncalculate:
               Intent intent4 = new Intent(this, activity_calculate.class);
                startActivity(intent4);
               //Toast.makeText(MainActivity.this, "CALC", Toast.LENGTH_LONG).show();
               break;


        }

    }
}