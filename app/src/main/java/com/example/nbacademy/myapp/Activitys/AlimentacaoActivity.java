package com.example.nbacademy.myapp.Activitys;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.nbacademy.myapp.R;

public class AlimentacaoActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacao);

        String[] restaurantes = {"Tinkuy Buffet","Chullpi Machupicchu", "AYASQA", "Apu Salkantay", "Tree House", "Incontri del Pueblo Viejo", "Full House Peruvian Cuisine"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, restaurantes);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(adapter);

    }
}
