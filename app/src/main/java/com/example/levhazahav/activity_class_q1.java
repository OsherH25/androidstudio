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

public class activity_class_q1 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btn_opt1_q1;
    Button btn_opt2_q1;
    Button btn_opt3_q1;
    Button returnQ1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_q1);

        nav = findViewById(R.id.bottom_navigation);

        Button btn_opt1_q1 = findViewById(R.id.btnOpt1Q1);
        Button btn_opt2_q1 = findViewById(R.id.btnOpt2Q1);
        Button btn_opt3_q1 = findViewById(R.id.btnOpt3Q1);
        Button returnQ1 = findViewById(R.id.btnReturnQ1);


        btn_opt1_q1.setOnClickListener(this);
        btn_opt2_q1.setOnClickListener(this);
        btn_opt3_q1.setOnClickListener(this);
        returnQ1.setOnClickListener(this);


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


            case R.id.btnOpt1Q1:
                Intent intent = new Intent(activity_class_q1.this, activity_class_q2.class);
                startActivity(intent);
                break;


            case R.id.btnOpt2Q1:
                Intent intent1 = new Intent(activity_class_q1.this, activity_class_q2.class);
                startActivity(intent1);
                break;

            case R.id.btnOpt3Q1:
                Intent intent2 = new Intent(activity_class_q1.this, activity_class_q2.class);
                startActivity(intent2);
                break;

            case R.id.btnReturnQ1:
                Intent intent3 = new Intent(activity_class_q1.this, activity_classify2.class);
                startActivity(intent3);
                break;



        }




    }
}

