package com.example.nbacademy.myapp.grupo1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nbacademy.myapp.R;
import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.MockupData;
import com.example.nbacademy.myapp.database.models.Cost;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {
    DBHelper helpher;
    List<Cost> dbList;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        MockupData md = new MockupData(this);

        mRecyclerView = (RecyclerView)findViewById(R.id.rvViagens);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this, md.getCosts());
        mRecyclerView.setAdapter(mAdapter);
    }
}
