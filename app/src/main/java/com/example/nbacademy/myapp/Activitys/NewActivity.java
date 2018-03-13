package com.example.nbacademy.myapp.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nbacademy.myapp.R;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewActivity extends AppCompatActivity {

    ArrayList<Integer> test = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        test = getIntent().getIntegerArrayListExtra("test");

        Button b = (Button) findViewById(R.id.button);

        EditText name = (EditText) findViewById(R.id.editText);
        EditText cidade = (EditText) findViewById(R.id.cidade);
        EditText tipo = (EditText) findViewById(R.id.editTextTipo);
        EditText ranking = (EditText) findViewById(R.id.editTextranking);
        EditText inicio = (EditText) findViewById(R.id.editTextInit);
        EditText fim = (EditText) findViewById(R.id.editTextfim);
        EditText preco = (EditText) findViewById(R.id.editTextpreco);

        DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");

        String nameS = name.getText().toString();
        String cidadeS = cidade.getText().toString();
        String tipoS = tipo.getText().toString();

        double rankingS = Double.parseDouble(ranking.getText().toString());
        double inicioS = Double.parseDouble(inicio.getText().toString());

        double fimS = Double.parseDouble(fim.getText().toString());
        double precoS = Double.parseDouble(preco.getText().toString());

        Suggestions.add(nameS, cidadeS, tipoS, precoS, inicioS, fimS, rankingS);

        test.add(Suggestions.getlast());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meuPercurso(v, test);
            }
        });

    }

    public void meuPercurso(View view, List<Integer> list) {
        Intent intent = new Intent(this, MeuPercurso.class);
        intent.putIntegerArrayListExtra("test", (ArrayList<Integer>) list);
        IntentArrayList.test = (ArrayList<Integer>) list;
        startActivity(intent);
    }
}
