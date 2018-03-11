package com.example.nbacademy.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button backButton = (Button) findViewById(R.id.backButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button paymentButton = (Button) findViewById(R.id.payment);
        Button moneyButton = (Button) findViewById(R.id.money);
        Button cardVisaButton = (Button) findViewById(R.id.visa_card);

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

        paymentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //TODO

            }
        });

        moneyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        cardVisaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //TODO
            }
        });
    }
}
