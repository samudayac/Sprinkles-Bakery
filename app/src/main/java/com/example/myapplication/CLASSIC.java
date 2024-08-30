package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CLASSIC extends AppCompatActivity {

Button classic1,classic2;
TextView vanilaprice,chocoprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);

        vanilaprice = findViewById(R.id.txtCLASICVANILAPRICE);
        chocoprice = findViewById(R.id.txtCLASSICCHOCO);

        classic1 = findViewById(R.id.btnCLASSICVANILA);
        classic2 = findViewById(R.id.btnCLASSICCHOCO);

        classic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = vanilaprice.getText().toString();
                navigateToCart(price);
            }
        });

        classic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = chocoprice.getText().toString();
                navigateToCart(price);
            }
        });
    }

    private void navigateToCart(String price) {
        Intent intent = new Intent(CLASSIC.this, SHIPPING.class);
        intent.putExtra("price",price);
        startActivity(intent);
    }
}