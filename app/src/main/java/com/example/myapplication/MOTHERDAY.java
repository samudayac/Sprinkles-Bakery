package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MOTHERDAY extends AppCompatActivity {

    Button buttonMotherDay1,buttonMotherDay2;
    TextView textMotherDay1,textMotherDay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motherday);

        buttonMotherDay1 = findViewById(R.id.btnMotherDay1);
        buttonMotherDay2 = findViewById(R.id.btnMotherDay2);
        textMotherDay1 = findViewById(R.id.txtMotherDay1);
        textMotherDay2 = findViewById(R.id.txtMotherDay2);

        buttonMotherDay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = textMotherDay1.getText().toString();
                navigateToCart(price);
            }
        });

        buttonMotherDay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = textMotherDay1.getText().toString();
                navigateToCart(price);
            }
        });

    }
    private void navigateToCart(String price) {
        Intent intent = new Intent(MOTHERDAY.this, SHIPPING.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}