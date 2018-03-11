package com.example.nbacademy.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TripCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_categories);

        Button categories = (Button) findViewById(R.id.categories);
        Button accomodation = (Button) findViewById(R.id.accomodation);
        Button food = (Button) findViewById(R.id.food);

        categories.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //TODO
            }
        });

        accomodation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //TODO
            }
        });

        food.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //TODO
            }
        });

        Button backButton = (Button) findViewById(R.id.backButton);
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
