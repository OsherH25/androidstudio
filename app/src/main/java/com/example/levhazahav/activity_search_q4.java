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

public class activity_search_q4 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnSearchOpt1Q4;
    Button btnSearchOpt2Q4;
    Button btnSearchOpt3Q4;
    Button btnSearchOpt4Q4;
    Button btnSearchOpt5Q4;
    Button btnSearchOpt6Q4;
    Button btnSearchReturnQ4;
    Intent  takeAge;
    String zone , age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_q4);

        nav = findViewById(R.id.bottom_navigation);

        btnSearchOpt1Q4 = findViewById(R.id.btnSearchOpt1Q4);
        btnSearchOpt2Q4 = findViewById(R.id.btnSearchOpt2Q4);
        btnSearchOpt3Q4 = findViewById(R.id.btnSearchOpt3Q4);
        btnSearchOpt4Q4 = findViewById(R.id.btnSearchOpt4Q4);
        btnSearchOpt5Q4 = findViewById(R.id.btnSearchOpt5Q4);
        btnSearchOpt6Q4 = findViewById(R.id.btnSearchOpt6Q4);
        btnSearchReturnQ4 = findViewById(R.id.btnSearchReturnQ4);

        btnSearchOpt1Q4.setOnClickListener(this);
        btnSearchOpt2Q4.setOnClickListener(this);
        btnSearchOpt3Q4.setOnClickListener(this);
        btnSearchOpt4Q4.setOnClickListener(this);
        btnSearchOpt5Q4.setOnClickListener(this);
        btnSearchOpt6Q4.setOnClickListener(this);
        btnSearchReturnQ4.setOnClickListener(this);



        takeAge= getIntent();
        age = takeAge.getStringExtra("Age");
        zone = takeAge.getStringExtra("Zone");




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



            case R.id.btnSearchOpt1Q4:
                Intent intent = new Intent(activity_search_q4.this, activity_search_results.class);
                intent.putExtra("Age", age);
                intent.putExtra("Zone", zone);
                intent.putExtra("Class", "1");
                startActivity(intent);
                break;

            case R.id.btnSearchOpt2Q4:
                Intent intent1 = new Intent(activity_search_q4.this,  activity_search_results.class);
                intent1.putExtra("Age", age);
                intent1.putExtra("Zone", zone);
                intent1.putExtra("Class", "2");
                startActivity(intent1);
                break;

            case R.id.btnSearchOpt3Q4:
                Intent intent2 = new Intent(activity_search_q4.this,  activity_search_results.class);
                intent2.putExtra("Age", age);
                intent2.putExtra("Zone", zone);
                intent2.putExtra("Class", "3");
                startActivity(intent2);
                break;

            case R.id.btnSearchOpt4Q4:
                Intent intent3 = new Intent(activity_search_q4.this,  activity_search_results.class);
                intent3.putExtra("Age", age);
                intent3.putExtra("Zone", zone);;
                intent3.putExtra("Class", "4");
                startActivity(intent3);
                break;

            case R.id.btnSearchOpt5Q4:
                Intent intent4 = new Intent(activity_search_q4.this,  activity_search_results.class);
                intent4.putExtra("Age", age);
                intent4.putExtra("Zone",  zone);;
                intent4.putExtra("Class", "4");
                startActivity(intent4);
                break;

            case R.id.btnSearchReturnQ4:
                Intent intent5 = new Intent(activity_search_q4.this, activity_search_q3.class);
                startActivity(intent5);
                break;

            case R.id.btnSearchOpt6Q4:
                Intent intent6 = new Intent(activity_search_q4.this, activity_direct_to_classify.class);
                startActivity(intent6);
                break;

        }


    }
}

