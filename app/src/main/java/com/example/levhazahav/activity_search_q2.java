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

public class activity_search_q2 extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    CheckBox btnZafon,btnHaifa,btnSharon,btnMerkaz,btnJerusalem,btnDarom,btnEilat;
    Button btnSearchReturnQ2,btnSearchNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_q2);

        nav = findViewById(R.id.bottom_navigation);

        btnZafon = findViewById(R.id. btnZafon);
        btnHaifa = findViewById(R.id.btnHaifa);
        btnSharon = findViewById(R.id.btnSharon);
        btnMerkaz = findViewById(R.id.btnMerkaz);
        btnJerusalem = findViewById(R.id.btnJerusalem);
        btnDarom = findViewById(R.id.btnDarom);
        btnEilat = findViewById(R.id.btnEilat);
        btnSearchReturnQ2 = findViewById(R.id.btnSearchReturnQ2);
        btnSearchNext = findViewById(R.id. btnSearchNext);

        btnZafon.setOnClickListener(this);
        btnHaifa.setOnClickListener(this);
        btnSharon.setOnClickListener(this);
        btnJerusalem.setOnClickListener(this);
        btnMerkaz.setOnClickListener(this);
        btnDarom.setOnClickListener(this);
        btnEilat.setOnClickListener(this);
        btnSearchReturnQ2.setOnClickListener(this);
        btnSearchNext.setOnClickListener(this);


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

        if(btnZafon.isChecked()){
            Intent intent = new Intent(activity_search_q2.this, activity_search_q3.class);
            intent.putExtra("Zone", "1");
            startActivity(intent);


        }

        if(btnHaifa.isChecked()){
            Intent intent = new Intent(activity_search_q2.this, activity_search_q3.class);
            intent.putExtra("Zone", "2");
            startActivity(intent);


        }
        if(btnSharon.isChecked()){
            Intent intent = new Intent(activity_search_q2.this, activity_search_q3.class);
            intent.putExtra("Zone", "3");
            startActivity(intent);


        }
        if(btnMerkaz.isChecked()){
            Intent intent = new Intent(activity_search_q2.this, activity_search_q3.class);
            intent.putExtra("Zone", "4");
            startActivity(intent);


        }
        if(btnJerusalem.isChecked()){
            Intent intent = new Intent(activity_search_q2.this, activity_search_q3.class);
            intent.putExtra("Zone", "5");
            startActivity(intent);


        }
        if(btnDarom.isChecked()){
            Intent intent = new Intent(activity_search_q2.this, activity_search_q3.class);
            intent.putExtra("Zone", "6");
            startActivity(intent);


        }
        if(btnEilat.isChecked()){
            Intent intent = new Intent(activity_search_q2.this, activity_search_q3.class);
            intent.putExtra("Zone", "7");
            startActivity(intent);




        }
        switch (view.getId()) {


            case R.id.btnSearchReturnQ2:
                Intent intent = new Intent(activity_search_q2.this, activity_search_q1.class);
                startActivity(intent);
                break;

            case R.id.btnSearchNext:
                Intent intent2 = new Intent(activity_search_q2.this, activity_search_q3.class);
                startActivity(intent2);
                break;

        }

    }
}

