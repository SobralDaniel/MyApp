package com.example.nbacademy.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PaymentActivity extends AppCompatActivity {

    public boolean oneIsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button backButton = (Button) findViewById(R.id.backButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        final RadioButton moneyButton = (RadioButton) findViewById(R.id.moneyButton);
        final RadioButton cardVisaButton = (RadioButton) findViewById(R.id.visaCardButton);

        final Intent backIntent = new Intent(this, DestinyActivity.class);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(backIntent);
            }
        });

        final Intent nextIntent = new Intent(this, MainActivity.class);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(nextIntent);
            }
        });

        moneyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(moneyButton.isChecked() && !cardVisaButton.isChecked()){
                    oneIsChecked = true;
                }else oneIsChecked = false;
            }
        });

        cardVisaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(cardVisaButton.isChecked() && !moneyButton.isChecked()){
                    oneIsChecked = true;
                }else oneIsChecked = false;
            }
        });
    }
}
