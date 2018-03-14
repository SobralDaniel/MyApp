package com.example.nbacademy.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nbacademy.myapp.Activitys.MainActivity_Activitys;

public class MainActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button sugestions = (Button) findViewById(R.id.Actividades);
        sugestions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Activitys(v);
            }
        });

    }


    public void Activitys(View view) {
        Intent intent = new Intent(this, MainActivity_Activitys.class);
        startActivity(intent);
    }
}
