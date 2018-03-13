package com.example.nbacademy.myapp.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.nbacademy.myapp.R;
import com.example.nbacademy.myapp.database.models.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MockupData md = new MockupData(this);

    }
}
