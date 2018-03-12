package com.example.nbacademy.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class TripCategoriesActivity extends AppCompatActivity {

    public boolean oneIsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_categories);

        final RadioButton accomodation = (RadioButton) findViewById(R.id.accomodation);
        final RadioButton food = (RadioButton) findViewById(R.id.food);
        ImageView addButton = (ImageView) findViewById(R.id.addCategory);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //TODO carregar as categorias adicionadas -- fazer put e get
                //fazer refresh à página
            }
        });

        accomodation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(accomodation.isChecked() && !food.isChecked()) {
                    oneIsChecked = true;
                }
                if(!accomodation.isChecked() && !food.isChecked()) oneIsChecked = false;
            }
        });

        food.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!accomodation.isChecked() && food.isChecked()) {
                    oneIsChecked = true;
                }
                if(!accomodation.isChecked() && !food.isChecked()) oneIsChecked = false;
            }
        });

        Button backButton = (Button) findViewById(R.id.doneButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);

        final Intent backIntent = new Intent(this, TripDetailsActivity.class);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(backIntent);
            }
        });

        final Intent nextIntent = new Intent(this, DestinyActivity.class);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(nextIntent);
            }
        });
    }
}
