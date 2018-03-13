package com.example.nbacademy.myapp.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.nbacademy.myapp.R;

import java.util.ArrayList;
import java.util.List;

public class MeuPercurso extends AppCompatActivity {

    List<Activitie> activities = new ArrayList();
    ArrayList<Integer> test = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_percurso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       test = getIntent().getIntegerArrayListExtra("test");


        if (test == null) {
            test = IntentArrayList.test;

        } else {
            IntentArrayList.test = test;
        }

        final ListView lista = (ListView) findViewById(R.id.listV);
        if (test != null) {
            for (int i = 0; i < test.size(); i++) {
               int id = test.get(i);

                if(Suggestions.getAct(id) != null){
                    activities.add(Suggestions.activities.get(id));
                }
                else
                    activities.add(Transporte.getT(id));

            }
        }

        Suggestions.activitiesSelected = activities;

        AdapterListView2 adapter =
                new AdapterListView2(Suggestions.activitiesSelected, this);

        lista.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newAct(view);

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void newAct(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        intent.putIntegerArrayListExtra("test", (ArrayList<Integer>) test);
        startActivity(intent);
    }

}
