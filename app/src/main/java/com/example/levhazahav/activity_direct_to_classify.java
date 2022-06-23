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

public class activity_direct_to_classify extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnContinueToClassify;
    Button btnReturnHomeDirect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_to_classify);

        nav = findViewById(R.id.bottom_navigation);
        btnContinueToClassify = findViewById(R.id.btnContinueToClassify);
        btnReturnHomeDirect = findViewById(R.id.btnReturnHomeDirect);

        btnContinueToClassify.setOnClickListener(this);
        btnReturnHomeDirect.setOnClickListener(this);


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


            case R.id.btnContinueToClassify:
                Intent intent = new Intent(activity_direct_to_classify.this, activity_classify.class);
                startActivity(intent);
                break;


            case R.id.btnReturnHomeDirect:
                Intent intent1 = new Intent(activity_direct_to_classify.this, MainActivity.class);
                startActivity(intent1);
                break;



        }


    }
}

