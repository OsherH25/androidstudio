package com.example.levhazahav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class activity_req_info extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Intent getInfo;
    Button btnGotolvl1,btnReturnHome1;
    String Classification;
    TextView tvResults1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_info);
        nav = findViewById(R.id.bottom_navigation);
        btnGotolvl1 = findViewById(R.id.btnGotolvl1);
        btnReturnHome1 = findViewById(R.id.btnReturnHome1);

        btnGotolvl1.setOnClickListener(this);
        btnReturnHome1.setOnClickListener(this);


        tvResults1 = findViewById(R.id.tvResults1);

        getInfo=getIntent();
        Classification=getInfo.getStringExtra("classification");


            tvResults1.setText(" לפי המידע שהזנת , הסיווג הרפואי של בן משפחתך הינו"+ Classification);





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


            case R.id.btnGotolvl1:
                Intent intent = new Intent(activity_req_info.this, activity_req_info_2.class);
                startActivity(intent);
                break;


            case R.id.btnReturnHome1:
                Intent intent1 = new Intent(activity_req_info.this, MainActivity.class);
                startActivity(intent1);
                break;



        }


    }
}

