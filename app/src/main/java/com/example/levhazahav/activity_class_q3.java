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

public class activity_class_q3 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btn_opt1_q3;
    Button btn_opt2_q3;
    Button btn_opt3_q3;
    Button returnQ3;
    Intent takeInfo;
    int indication1, indication2;
    String Classification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_q3);

        nav = findViewById(R.id.bottom_navigation);

        btn_opt1_q3 = findViewById(R.id.btnOpt1Q3);
        btn_opt2_q3 = findViewById(R.id.btnOpt2Q3);
        btn_opt3_q3 = findViewById(R.id.btnOpt3Q3);
        returnQ3 = findViewById(R.id.btnReturnQ3);


        btn_opt1_q3.setOnClickListener(this);
        btn_opt2_q3.setOnClickListener(this);
        btn_opt3_q3.setOnClickListener(this);
        returnQ3.setOnClickListener(this);

        takeInfo= getIntent();
        indication1 = takeInfo.getIntExtra("indexQ2", 0);


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


            case R.id.btnOpt1Q3:
                indication2=1;
                IntentToNextScreen();
                break;

            case R.id.btnOpt2Q3:
                indication2=2;
                IntentToNextScreen();
                break;

            case R.id.btnOpt3Q3:
                indication2=3;
                IntentToNextScreen();
                break;


            case R.id.btnReturnQ3:
                Intent intent4 = new Intent(activity_class_q3.this, activity_class_q2.class);
                startActivity(intent4);
                break;
        }

    }


    private void IntentToNextScreen()
    {
        if((indication1==1) &&(indication2==1))
        {
             Classification="עצמאי";
        }

        if((indication1==1) &&(indication2==2))
        {
             Classification="תשוש נפש";
        }

        if((indication1==1) &&(indication2==3))
        {
             Classification="תשוש נפש";
        }

        if((indication1==2) &&(indication2==1))
        {
             Classification="סיעודי";
        }

        if((indication1==2) &&(indication2==2))
        {
             Classification="סיעודי מורכב";
        }

        if((indication1==2) &&(indication2==3))
        {
             Classification="סיעודי מורכב";
        }

        if((indication1==3) &&(indication2==1))
        {
             Classification="תשוש";
        }

        if((indication1==3) &&(indication2==2))
        {
             Classification="תשוש נפש";
        }

        if((indication1==3) &&(indication2==3))
        {
            Classification="תשוש נפש";
        }

        if((indication1==4) &&(indication2==1))
        {
            Classification="סיעודי";
        }

        if((indication1==4) &&(indication2==2))
        {
             Classification="סיעודי";
        }

        if((indication1==4) &&(indication2==3))
        {
             Classification="סיעודי מורכב";
        }

        Intent intent = new Intent(activity_class_q3.this, activity_class_results.class);
        intent.putExtra("classification", Classification);
        startActivity(intent);

    }
}

