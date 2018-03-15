package com.example.nbacademy.myapp.grupo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.nbacademy.myapp.R;

public class Criar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar);
        final EditText etValor = (EditText) findViewById(R.id.etValor);
        final EditText etTotal = (EditText) findViewById(R.id.etTotal);
        final EditText etQuantidade = (EditText) findViewById(R.id.etQuantidade);
        etValor.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(etValor.getText().length()!=0 && etQuantidade.getText().length()!=0)
                {
                    float valor=Float.parseFloat(etValor.getText().toString());
                    float quantidade=Float.parseFloat(etQuantidade.getText().toString());
                    String total=String.valueOf(calcular(valor,quantidade));
                    etTotal.setText(total);
                }
                else
                {
                }
            }
        });
        etQuantidade.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(etValor.getText().length()!=0 && etQuantidade.getText().length()!=0)
                {
                    float valor=Float.parseFloat(etValor.getText().toString());
                    float quantidade=Float.parseFloat(etQuantidade.getText().toString());
                    String total=String.valueOf(calcular(valor,quantidade));
                    etTotal.setText(total);
                }
                else
                {
                }
            }
        });
    }

    public float calcular(float a, float b)
    {
        float resultado;
        resultado=a*b;
        return resultado;
    }

}

