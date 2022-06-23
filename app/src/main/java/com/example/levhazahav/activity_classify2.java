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

public class activity_classify2 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnStartClassify;
    Button btnReturnClass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify2);

        nav = findViewById(R.id.bottom_navigation);

        btnStartClassify = findViewById(R.id.btnStartClassify);
        btnReturnClass2 = findViewById(R.id.btnReturnClass2);

        btnStartClassify.setOnClickListener(this);
        btnReturnClass2.setOnClickListener(this);




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


            case R.id.btnStartClassify:
                Intent intent7 = new Intent(activity_classify2.this, activity_class_q1.class);
                startActivity(intent7);
                break;


            case R.id.btnReturnClass2:
                Intent intent1 = new Intent(activity_classify2.this, activity_classify.class);
                startActivity(intent1);
                break;

        }




    }
}

