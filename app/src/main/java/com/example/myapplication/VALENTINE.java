package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VALENTINE extends AppCompatActivity {

    Button btnVALENTINE1,btnVALENTINEPACK;
    TextView txtVALENTINEPRICE,txtVALENTINEPACKPRICE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valentine);

        btnVALENTINE1 = findViewById(R.id.btnVALENTINE1);
        btnVALENTINEPACK = findViewById(R.id.btnVALENTINEPACK);
        txtVALENTINEPRICE = findViewById(R.id.txtVALENTINEPRICE);
        txtVALENTINEPACKPRICE = findViewById(R.id.txtVALENTINEPACKPRICE);

        btnVALENTINE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = txtVALENTINEPRICE.getText().toString();
                navigateToCart(price);
            }
        });

        btnVALENTINEPACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = txtVALENTINEPACKPRICE.getText().toString();
                navigateToCart(price);
            }
        });
    }
    private void navigateToCart(String price) {
        Intent intent = new Intent(VALENTINE.this, SHIPPING.class);
        intent.putExtra("price",price);
        startActivity(intent);
    }
}