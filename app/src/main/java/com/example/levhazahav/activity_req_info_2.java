package com.example.levhazahav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class activity_req_info_2 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnDepByAdress,btnOnlineReq,btnReturnHome2,btnReturnLvl1;
    TextView tvResults2;
    Intent getInfo;
    String Classification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_info2);

        getInfo=getIntent();
        Classification=getInfo.getStringExtra("classification");

        nav = findViewById(R.id.bottom_navigation);
        btnDepByAdress = findViewById(R.id.btnDepByAdress);
        btnOnlineReq = findViewById(R.id.btnOnlineReq);
        btnReturnHome2 = findViewById(R.id.btnReturnHome2);
        btnReturnLvl1 = findViewById(R.id.btnReturnLvl1);
        tvResults2 = findViewById(R.id.tvResults2);

        btnDepByAdress.setOnClickListener(this);
        btnOnlineReq.setOnClickListener(this);
        btnReturnHome2.setOnClickListener(this);
        btnReturnLvl1.setOnClickListener(this);


        if (Classification != null)
        {
            tvResults2.setText(" לפי המידע שהזנת , הסיווג הרפואי של בן משפחתך הינו"+ Classification);

        }



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


            case R.id.btnReturnLvl1:
                Intent intent = new Intent(activity_req_info_2.this, activity_req_info.class);
                startActivity(intent);
                break;


            case R.id.btnReturnHome2:
                Intent intent1 = new Intent(activity_req_info_2.this, MainActivity.class);
                startActivity(intent1);
                break;

            case R.id.btnOnlineReq:
                gotoUrl("https://www.gov.il/he/departments/news/?OfficeId=104cb0f4-d65a-4692-b590-94af928c19c0&skip=0&limit=10"); //placeholder for the real link
                break;

            case R.id.btnDepByAdress:
                gotoUrl("https://www.gov.il/he/departments/ministry_of_health/govil-landing-page"); //placeholder for the real link
                break;



        }


    }

    //function to send the user to the url if he presses a button
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));


    }
}

