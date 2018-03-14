//package com.example.nbacademy.grupo5;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//public class MainActivity_2 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        new Suggestions();
//        new Transporte();
//
//        Button sugestions = (Button) findViewById(R.id.s);
//        Button buttonMeuPercurso = (Button) findViewById(R.id.meuP);
//        Button alimentacao = (Button) findViewById(R.id.cb) ;
//
//
//        sugestions.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//               sgestionsActivitie(v);
//            }
//        });
//
//        buttonMeuPercurso.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                meuPercurso(v);
//            }
//        });
//
//        alimentacao.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alimentacao(v);
//            }
//        });
//    }
//
//    public void sgestionsActivitie(View view) {
//        Intent intent = new Intent(this, SuggestionsActivity.class);
//        startActivity(intent);
//    }
//
//    public void meuPercurso(View view) {
//        Intent intent = new Intent(this, MeuPercurso.class);
//        startActivity(intent);
//    }
//
//    public void alimentacao(View view) {
//        Intent intent = new Intent(this, AlimentacaoActivity.class);
//        startActivity(intent);
//    }
//}
