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

public class activity_class_results extends AppCompatActivity implements View.OnClickListener {


    BottomNavigationView nav;
    Button btnGoToLvls;
    Button btnStartClassifyAgain;
    Button btnReturnToHomeQuestions;
    Intent getInfo;
    String Classification;
    TextView tvResults;
    TextView explainResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_results);

        nav = findViewById(R.id.bottom_navigation);

        btnGoToLvls = findViewById(R.id.btnGoToLvls);
        btnStartClassifyAgain = findViewById(R.id.btnStartClassifyAgain);
        btnReturnToHomeQuestions = findViewById(R.id.btnReturnToHomeQuestions);
        tvResults = findViewById(R.id.tvResults);
        explainResults = findViewById(R.id.explainResults);

        btnGoToLvls.setOnClickListener(this);
        btnStartClassifyAgain.setOnClickListener(this);
        btnReturnToHomeQuestions.setOnClickListener(this);

        getInfo=getIntent();
        Classification=getInfo.getStringExtra("classification");


        if (Classification.equals("עצמאי")== true)
        {
            tvResults.setText("עצמאי");
            explainResults.setText("אם הסיווג הרפואי של האדם הינו “סיעודי” \n" +
                    "הוא מתאים לאשפוז במחלקה לסיעודיים או במחלקה לתשושי נפש. \n" +
                    "במצב זה קיימת אפשרות לקבל סיוע כספי ממשרד הבריאות למימון עלות האשפוז.\n" +
                    "הסיוע ניתן בהתאם למצבם הכלכלי של המטופל ובני משפחתו.");

        }
        else

        if (Classification.equals("תשוש")== true)
        {
            tvResults.setText("תשוש");
            explainResults.setText("אם הסיווג הרפואי של האדם הינו “סיעודי” \n" +
                    "הוא מתאים לאשפוז במחלקה לסיעודיים או במחלקה לתשושי נפש. \n" +
                    "במצב זה קיימת אפשרות לקבל סיוע כספי ממשרד הבריאות למימון עלות האשפוז.\n" +
                    "הסיוע ניתן בהתאם למצבם הכלכלי של המטופל ובני משפחתו.");

        }
        else

        if (Classification.equals("סיעודי")== true)
        {
            tvResults.setText("סיעודי");
            explainResults.setText("אם הסיווג הרפואי של האדם הינו “סיעודי” \n" +
                    "הוא מתאים לאשפוז במחלקה לסיעודיים או במחלקה לתשושי נפש. \n" +
                    "במצב זה קיימת אפשרות לקבל סיוע כספי ממשרד הבריאות למימון עלות האשפוז.\n" +
                    "הסיוע ניתן בהתאם למצבם הכלכלי של המטופל ובני משפחתו.");

        }
        else

        if (Classification.equals("תשוש נפש")== true)
        {
            tvResults.setText("תשוש נפש");
            explainResults.setText("אם הסיווג הרפואי של האדם הינו “סיעודי” \n" +
                    "הוא מתאים לאשפוז במחלקה לסיעודיים או במחלקה לתשושי נפש. \n" +
                    "במצב זה קיימת אפשרות לקבל סיוע כספי ממשרד הבריאות למימון עלות האשפוז.\n" +
                    "הסיוע ניתן בהתאם למצבם הכלכלי של המטופל ובני משפחתו.");

        }
        else

        if (Classification.equals("סיעודי מורכב")== true)
        {
            tvResults.setText("סיעודי מורכב");
            explainResults.setText("אם הסיווג הרפואי של האדם הינו “סיעודי” \n" +
                    "הוא מתאים לאשפוז במחלקה לסיעודיים או במחלקה לתשושי נפש. \n" +
                    "במצב זה קיימת אפשרות לקבל סיוע כספי ממשרד הבריאות למימון עלות האשפוז.\n" +
                    "הסיוע ניתן בהתאם למצבם הכלכלי של המטופל ובני משפחתו.");

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


            case R.id.btnGoToLvls:
                Intent intent = new Intent(activity_class_results.this, activity_req_info.class);
                startActivity(intent);
                break;


            case R.id.btnStartClassifyAgain:
                Intent intent1 = new Intent(activity_class_results.this, activity_classify.class);
                startActivity(intent1);
                break;


            case R.id.btnReturnToHomeQuestions:
                Intent intent2 = new Intent(activity_class_results.this, MainActivity.class);
                startActivity(intent2);
                break;


        }




    }
}

