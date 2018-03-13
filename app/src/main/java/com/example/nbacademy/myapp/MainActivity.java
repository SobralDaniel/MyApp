package com.example.nbacademy.myapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.nbacademy.myapp.Activitys.MainActivity_Activitys;
import com.example.nbacademy.myapp.Activitys.MeuPercurso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
