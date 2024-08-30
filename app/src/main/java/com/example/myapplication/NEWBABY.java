package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NEWBABY extends AppCompatActivity {

    Button babyBOY,babyGIRL;
    TextView txtBOYPRICE,txtGIRLPRICE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbaby);

        babyBOY= findViewById(R.id.btnBABYBOY);
        babyGIRL = findViewById(R.id.btnBABYGIRL);
        txtBOYPRICE = findViewById(R.id.txtBABYBOY);
        txtGIRLPRICE = findViewById(R.id.txtBABYGIRL);

        babyBOY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = txtBOYPRICE.getText().toString();
                navigateToCart(price);
            }
        });

        babyGIRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = txtGIRLPRICE.getText().toString();
                navigateToCart(price);
            }
        });
    }

    private void navigateToCart(String price) {
        Intent intent = new Intent(NEWBABY.this, SHIPPING.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}