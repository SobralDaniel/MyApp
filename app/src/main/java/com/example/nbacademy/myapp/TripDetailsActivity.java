package com.example.nbacademy.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;

/**
 * Created by nbacademy on 08/03/2018.
 */
public class TripDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        Button backButton = (Button) findViewById(R.id.doneButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);

        String name = findViewById(R.id.name).toString();
        String startingDate = findViewById(R.id.startingDate).toString();
        String endingDate = findViewById(R.id.endingDate).toString();

        final Intent backTo = new Intent(this, MainActivity.class);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(backTo);
            }
        });

        final Intent nextTo = new Intent(this, TripCategoriesActivity.class);
        nextTo.putExtra("Name", name);
        nextTo.putExtra("StartingDate", startingDate);
        nextTo.putExtra("EndingDate", endingDate);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(nextTo);
            }
        });
    }
}
