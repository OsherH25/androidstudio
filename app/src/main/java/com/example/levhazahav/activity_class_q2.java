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

public class activity_class_q2 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btn_opt1_q2;
    Button btn_opt2_q2;
    Button btn_opt3_q2;
    Button btn_opt4_q2;
    Button returnQ2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_q2);

        nav = findViewById(R.id.bottom_navigation);

         btn_opt1_q2 = findViewById(R.id.btnOpt1Q2);
         btn_opt2_q2 = findViewById(R.id.btnOpt2Q2);
         btn_opt3_q2 = findViewById(R.id.btnOpt3Q2);
         btn_opt4_q2 = findViewById(R.id.btnOpt4Q2);
         returnQ2 = findViewById(R.id.btnReturnQ2);


        btn_opt1_q2.setOnClickListener(this);
        btn_opt2_q2.setOnClickListener(this);
        btn_opt3_q2.setOnClickListener(this);
        btn_opt4_q2.setOnClickListener(this);
        returnQ2.setOnClickListener(this);


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
                Intent intent = new Intent(activity_class_q2.this, activity_class_q3.class);
                intent.putExtra("indexQ2", 1);
                startActivity(intent);
                break;

            case R.id.btnOpt2Q2:
                Intent intent1 = new Intent(activity_class_q2.this, activity_class_q3.class);
                intent1.putExtra("indexQ2", 2);
                startActivity(intent1);
                break;

            case R.id.btnOpt3Q2:
                Intent intent2 = new Intent(activity_class_q2.this, activity_class_q3.class);
                intent2.putExtra("indexQ2", 3);
                startActivity(intent2);
                break;

            case R.id.btnOpt4Q2:
                Intent intent3 = new Intent(activity_class_q2.this, activity_class_q3.class);
                intent3.putExtra("indexQ2", 4);
                startActivity(intent3);
                break;


            case R.id.btnReturnQ2:
                Intent intent4 = new Intent(activity_class_q2.this, activity_class_q1.class);
                startActivity(intent4);
                break;
        }




    }
}

