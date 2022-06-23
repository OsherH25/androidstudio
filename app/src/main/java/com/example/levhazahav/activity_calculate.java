package com.example.levhazahav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class activity_calculate extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnContinueCalc;
    Button btnReturnCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        nav = findViewById(R.id.bottom_navigation);

        btnContinueCalc = findViewById(R.id.btnContinueCalc);
        btnReturnCalc = findViewById(R.id.btnReturnCalc);

        btnContinueCalc.setOnClickListener(this);
        btnReturnCalc.setOnClickListener(this);

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


            case R.id.btnContinueCalc:
                gotoUrl("https://nursingcalculator.health.gov.il/#/home");

                break;


            case R.id.btnReturnCalc:
                Intent intent = new Intent(activity_calculate.this, MainActivity.class);
                startActivity(intent);
                break;


        }
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));


    }
}