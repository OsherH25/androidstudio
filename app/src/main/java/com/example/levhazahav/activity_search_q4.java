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


            case R.id.btnOpt1Q2:
                Intent intent = new Intent(activity_search_q4.this, activity_class_q3.class);
                intent.putExtra("indexQ2", 1);
                startActivity(intent);
                break;


        }




    }
}

