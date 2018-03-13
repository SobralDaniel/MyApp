package com.example.nbacademy.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class TripCategoriesActivity extends AppCompatActivity {

    public ArrayList<String> categoriesList = new ArrayList<>();
    public ArrayList<String> newCategoriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_categories);

        //final RadioButton accomodation = (RadioButton) findViewById(R.id.accomodation);
        //final RadioButton food = (RadioButton) findViewById(R.id.food);
        ImageView addButton = (ImageView) findViewById(R.id.addCategory);

        categoriesList.add("Food");
        categoriesList.add("Accomodation");
        categoriesList.add("Lazer");
        categoriesList.add("Extras");

        String name = getIntent().getStringExtra("Name");
        String startingDate = getIntent().getStringExtra("StartingDate");
        String endingDate = getIntent().getStringExtra("EndingDate");

        ListView listOfCategories = (ListView) findViewById(R.id.categories);

        ArrayAdapter categoryAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, categoriesList);

        listOfCategories.setAdapter(categoryAdapter);

        newCategoriesList.add("Food");
        newCategoriesList.add("Accomodation");
        newCategoriesList.add("Lazer");
        newCategoriesList.add("Extras");

        final ListView listOfNewCategories = (ListView) findViewById(R.id.newCategories);
        ArrayAdapter newCategoriesAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, newCategoriesList);

        listOfNewCategories.setAdapter(newCategoriesAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listOfNewCategories.setVisibility(View.VISIBLE);
            }
        });

        /*accomodation.setOnClickListener(new View.OnClickListener() {

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
        });*/

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
