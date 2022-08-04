package com.example.levhazahav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class activity_search_q3 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnSearchOpt1Q3;
    Button btnSearchOpt2Q3;
    Button btnSearchOpt3Q3;
    Button btnSearchOpt4Q3;
    Button btnSearchOpt5Q3;
    Button btnSearchReturnQ3;
    Intent takeZone;
    String Zone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_q3);

        nav = findViewById(R.id.bottom_navigation);

        btnSearchOpt1Q3 = findViewById(R.id.btnSearchOpt1Q3);
        btnSearchOpt2Q3 = findViewById(R.id.btnSearchOpt2Q3);
        btnSearchOpt3Q3 = findViewById(R.id.btnSearchOpt3Q3);
        btnSearchOpt4Q3 = findViewById(R.id.btnSearchOpt4Q3);
        btnSearchOpt5Q3 = findViewById(R.id.btnSearchOpt5Q3);
        btnSearchReturnQ3 = findViewById(R.id.btnSearchReturnQ3);


        btnSearchOpt1Q3.setOnClickListener(this);
        btnSearchOpt2Q3.setOnClickListener(this);
        btnSearchOpt3Q3.setOnClickListener(this);
        btnSearchOpt4Q3.setOnClickListener(this);
        btnSearchOpt5Q3.setOnClickListener(this);
        btnSearchReturnQ3.setOnClickListener(this);


        takeZone = getIntent();
        Zone = takeZone.getStringExtra("Zone");


        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {


                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.classify:
                        startActivity(new Intent(getApplicationContext(), activity_classify.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), activity_search.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(), activity_info.class));
                        overridePendingTransition(0, 0);
                        return true;

                }


                return false;
            }
        });


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.btnSearchOpt1Q3:
                Intent intent = new Intent(activity_search_q3.this, activity_search_q4.class);
                intent.putExtra("Age", "1");
                intent.putExtra("Zone", Zone);
                startActivity(intent);
                break;

            case R.id.btnSearchOpt2Q3:
                Intent intent1 = new Intent(activity_search_q3.this, activity_search_q4.class);
                intent1.putExtra("Age", "2");
                intent1.putExtra("Zone", Zone);
                startActivity(intent1);
                break;

            case R.id.btnSearchOpt3Q3:
                Intent intent2 = new Intent(activity_search_q3.this, activity_search_q4.class);
                intent2.putExtra("Age", "3");
                intent2.putExtra("Zone", Zone);
                startActivity(intent2);
                break;

            case R.id.btnSearchOpt4Q3:
                Intent intent3 = new Intent(activity_search_q3.this, activity_search_q4.class);
                intent3.putExtra("Age", "4");
                intent3.putExtra("Zone", Zone);
                startActivity(intent3);
                break;

            case R.id.btnSearchOpt5Q3:
                Intent intent4 = new Intent(activity_search_q3.this, activity_search_q4.class);
                intent4.putExtra("Age", "5");
                intent4.putExtra("Zone", Zone);
                startActivity(intent4);
                break;

            case R.id.btnSearchReturnQ3:
                Intent intent5 = new Intent(activity_search_q3.this, activity_search_q2.class);
                startActivity(intent5);
                break;


        }


    }
}


