package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GRADUATION extends AppCompatActivity {

Button buttonGraduation1,buttonGraduation2;
TextView textGraduation1,textGraduation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduation);

        buttonGraduation1 = findViewById(R.id.btnGraduation1);
        buttonGraduation2 = findViewById(R.id.btnGraduation2);
        textGraduation1 = findViewById(R.id.txtGraduation1);
        textGraduation2 = findViewById(R.id.txtGraduation2);

        buttonGraduation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = textGraduation1.getText().toString();
                navigateToCart(price);
            }
        });
        buttonGraduation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = textGraduation2.getText().toString();
                navigateToCart(price);
            }
        });
    }
    private void navigateToCart(String price) {
        Intent intent = new Intent(GRADUATION.this, SHIPPING.class);
        intent.putExtra("price",price);
        startActivity(intent);
    }
}