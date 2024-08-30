package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ANNIVERSARY extends AppCompatActivity {

    Button button1ST,button10TH;

    TextView anniversary1,anniversary2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anniversary);

        button1ST = findViewById(R.id.btn1ST);
        button10TH = findViewById(R.id.btn10TH);
        anniversary1 = findViewById(R.id.txt1STYEAR);
        anniversary2 = findViewById(R.id.txt10THYEAR);

        button1ST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = anniversary1.getText().toString();
                navigateToCart(price);
            }
        });

        button10TH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = anniversary2.getText().toString();
                navigateToCart(price);
            }
        });
    }
    private void navigateToCart(String price) {
        Intent intent = new Intent(ANNIVERSARY.this, SHIPPING.class);
        intent.putExtra("price",price);
        startActivity(intent);
    }
}