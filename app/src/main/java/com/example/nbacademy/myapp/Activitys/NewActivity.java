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
    double rankingS = 0.0;
    double inicioS = 0.0;
    double fimS = 0.0;
    double precoS = 0.0;
    String nameS;
    String cidadeS;
    String tipoS;

    EditText name;
    EditText cidade;
    EditText tipo;
    EditText ranking;
    EditText inicio;
    EditText fim;
    EditText preco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        test = getIntent().getIntegerArrayListExtra("test");

        Button b = (Button) findViewById(R.id.button);

        name = (EditText) findViewById(R.id.editText);
        cidade = (EditText) findViewById(R.id.cidade);
        tipo = (EditText) findViewById(R.id.editTextTipo);
        ranking = (EditText) findViewById(R.id.editTextranking);
        inicio = (EditText) findViewById(R.id.editTextInit);
        fim = (EditText) findViewById(R.id.editTextfim);
        preco = (EditText) findViewById(R.id.editTextpreco);

        DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");




        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameS = name.getText().toString();
                cidadeS = cidade.getText().toString();
                tipoS = tipo.getText().toString();
                rankingS = Double.parseDouble(ranking.getText().toString());
                inicioS = Double.parseDouble(inicio.getText().toString());
                fimS = Double.parseDouble(fim.getText().toString());
                precoS = Double.parseDouble(preco.getText().toString());


                Suggestions.add(nameS, cidadeS, tipoS, precoS, inicioS, fimS, rankingS);

                test.add(Suggestions.getlast());
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
