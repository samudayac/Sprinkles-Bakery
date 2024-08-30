package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BIRTHDAY extends AppCompatActivity {

    Button btnBirthday1,btnBirthday2;
    TextView Birthday1Price,Birthday2Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        btnBirthday1 = findViewById(R.id.btnBIRTHDAY1);
        btnBirthday2 = findViewById(R.id.btnBIRTHDAY2);
        Birthday1Price = findViewById(R.id.txtBIRTHDAY1);
        Birthday2Price = findViewById(R.id.txtBIRTHDAY2);

        btnBirthday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = Birthday2Price.getText().toString();
                navigateToCart(price);
            }
        });

        btnBirthday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = Birthday1Price.getText().toString();
                navigateToCart(price);
            }
        });
    }

    private void navigateToCart(String price) {
        Intent intent = new Intent(BIRTHDAY.this, SHIPPING.class);
        intent.putExtra("price",price);
        startActivity(intent);
    }
}