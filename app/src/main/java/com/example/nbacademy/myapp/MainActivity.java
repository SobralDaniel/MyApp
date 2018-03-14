package com.example.nbacademy.myapp;

import android.support.v7.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context ctx = this;
    public ArrayList<String> trips = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
 //       setSupportActionBar(toolbar);

        ImageView addTrip = (ImageView) findViewById(R.id.addTrip);

        final Intent myIntent = new Intent(this, TripDetailsActivity.class);
        final Intent myIntent2 = new Intent(this, MainActivity_2.class);

        trips.add("México");
        trips.add("Brasil");
        trips.add("Portugal");

        ListView listOfTrips = (ListView) findViewById(R.id.tripList);

        DeleteAdapter deleteTripAdapter = new DeleteAdapter(this,
                android.R.layout.simple_list_item_1, trips);

        listOfTrips.setAdapter(deleteTripAdapter);

        listOfTrips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(myIntent2);
            }
        });

        addTrip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
