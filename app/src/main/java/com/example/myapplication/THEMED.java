package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class THEMED extends AppCompatActivity {

    Button THEMED1, THEMED2;
    TextView catPrice, footballPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themed);

        THEMED1 = findViewById(R.id.btnTHEMED1);
        THEMED2 = findViewById(R.id.btnTHEMED2);
        catPrice = findViewById(R.id.txtCATTHEMED);
        footballPrice = findViewById(R.id.txtFOOTCALLTHEMED);

        THEMED1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = catPrice.getText().toString();
                navigateToCart(price);
            }
        });

        THEMED2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = footballPrice.getText().toString();
                navigateToCart(price);
            }
        });

    }

    private void navigateToCart(String price) {
        Intent intent = new Intent(THEMED.this, SHIPPING.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}