package com.example.nbacademy.myapp.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nbacademy.myapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuggestionsActivity extends AppCompatActivity {

    double price = 0.0;
    TextView total;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        final Activity t = this;
        Button check = (Button) findViewById(R.id.check);
        total = (TextView) findViewById(R.id.total);

        Button more = (Button) findViewById(R.id.more);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Log.d("FC", id + "");
        final ArrayList<Activitie> activities = init();

        final ListView listaDeCursos = (ListView) findViewById(R.id.list);


        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<Activitie> activities = init();
                AdapterListView adapter =
                        new AdapterListView(activities, t);

                listaDeCursos.setAdapter(adapter);
            }
        });

        AdapterListView adapter =
                new AdapterListView(activities, this);

        listaDeCursos.setAdapter(adapter);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meuPercurso(v, getList(activities));
            }
        });


    }

    public void meuPercurso(View view, List<Integer> list) {
        Intent intent = new Intent(this, MeuPercurso.class);
        intent.putIntegerArrayListExtra("test", (ArrayList<Integer>) list);
        IntentArrayList.test = (ArrayList<Integer>) list;
        Suggestions.map.put(id, list);
        startActivity(intent);
    }

    public ArrayList<Activitie> init() {
        price = 0.0;
        List<Activitie> activities = new ArrayList();
        Log.d("FC", id + " tttt");
        activities = Suggestions.getActivities(id);
        Log.d("ttt", activities.size() + " tamano");
        ArrayList<Activitie> activitiesToSend = new ArrayList();

        Random r = new Random();
        List<Integer> check = new ArrayList();
        int a = 0;
        int tt = 1000;
        for (int i = 0; i < 5; i++) {
            int t = r.nextInt(5);
            Log.d("ttt", t + "valo ");
            if (!check.contains(t)) {
                check.add(t);
                activitiesToSend.add(activities.get(t));
                if (a < 4) {
                    activitiesToSend.add(Transporte.getT(tt));
                    tt--;
                    a++;
                }
            } else {
                i--;
            }

        }

        for (int i = 0; i < activitiesToSend.size(); i++) {
            price += activitiesToSend.get(i).getPrice();
        }

        total.setText("Total: " + price);

        return activitiesToSend;
    }

    public List<Integer> getList(ArrayList<Activitie> activities) {
        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < activities.size(); i++) {
            ids.add(activities.get(i).getId());
        }
        return ids;
    }


}
