package com.example.nbacademy.myapp.Activitys;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nbacademy.myapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AlimentacaoActivity extends AppCompatActivity {

    private ListView mListView;
    double price = 0.0;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacao);

        final Activity t = this;

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Log.d("FC", id + "");
        final ArrayList<Activitie> activities = init();


        String[] restaurantes = {"Tinkuy Buffet","Chullpi Machupicchu", "AYASQA", "Apu Salkantay", "Tree House", "Incontri del Pueblo Viejo", "Full House Peruvian Cuisine"};
        //ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, restaurantes);
        mListView = (ListView) findViewById(R.id.listView);

        AdapterListView adapter =
                new AdapterListView(activities, this);

        mListView.setAdapter(adapter);

    }

    public ArrayList<Activitie> init() {
        price = 0.0;
        List<Activitie> activities = new ArrayList();
        Log.d("FC", id + " tttt");
        activities = Suggestions.getFood(id);
        Log.d("ttt", activities.size() + " tamano");
        ArrayList<Activitie> activitiesToSend = new ArrayList();

        Random r = new Random();
        List<Integer> check = new ArrayList();
        int a = 0;
        int tt = 1000;
        for (int i = 0; i < activities.size(); i++) {
            int t = r.nextInt(activities.size());
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
