package com.example.levhazahav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class activity_search_q1 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnSearchOpt1Q1;
    Button btnSearchOpt2Q1;
    Button btnSearchOpt3Q1;
    Button btnSearchReturnQ1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_q1);

        nav = findViewById(R.id.bottom_navigation);

         btnSearchOpt1Q1 = findViewById(R.id.btnSearchOpt1Q1);
         btnSearchOpt2Q1 = findViewById(R.id.btnSearchOpt2Q1);
         btnSearchOpt3Q1 = findViewById(R.id.btnSearchOpt3Q1);
         btnSearchReturnQ1 = findViewById(R.id.btnSearchReturnQ1);


        btnSearchOpt1Q1.setOnClickListener(this);
        btnSearchOpt2Q1.setOnClickListener(this);
        btnSearchOpt3Q1.setOnClickListener(this);
        btnSearchReturnQ1.setOnClickListener(this);


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


            case R.id.btnSearchOpt1Q1:
                Intent intent = new Intent(activity_search_q1.this, activity_search_q2.class);
                startActivity(intent);
                break;


            case R.id.btnSearchOpt2Q1:
                Intent intent1 = new Intent(activity_search_q1.this, activity_search_q2.class);
                startActivity(intent1);
                break;

            case R.id.btnSearchOpt3Q1:
                Intent intent2 = new Intent(activity_search_q1.this, activity_search_q2.class);
                startActivity(intent2);
                break;

            case R.id.btnSearchReturnQ1:
                Intent intent3 = new Intent(activity_search_q1.this, activity_search_q2.class);
                startActivity(intent3);
                break;



        }




    }
}

