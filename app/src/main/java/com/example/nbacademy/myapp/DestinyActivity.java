package com.example.nbacademy.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DestinyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destiny);

        Button addDestiny = (Button) findViewById(R.id.addDestiny);
        Button backButton = (Button) findViewById(R.id.backButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);

        final Intent addDestinyIntent = new Intent(this, NewDestinyActivity.class);

        addDestiny.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(addDestinyIntent);
            }
        });

        final Intent backIntent = new Intent(this, TripCategoriesActivity.class);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(backIntent);
            }
        });

        final Intent nextIntent = new Intent(this, PaymentActivity.class);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(nextIntent);
            }
        });
    }
}
