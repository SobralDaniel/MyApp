package com.example.nbacademy.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class DestinyActivity extends AppCompatActivity {

    public ArrayList<String> destinationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destiny);

        ImageView addDestiny = (ImageView) findViewById(R.id.addDestiny);
        Button backButton = (Button) findViewById(R.id.backButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);

        destinationList.add("Portugal");
        destinationList.add("Brasil");
        destinationList.add("França");

        ListView listDestination = (ListView) findViewById(R.id.destination);

        ArrayAdapter destinationAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, destinationList);

        listDestination.setAdapter(destinationAdapter);

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
