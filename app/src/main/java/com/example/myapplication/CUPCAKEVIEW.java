package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CUPCAKEVIEW extends AppCompatActivity {

    ImageButton btnClassic,btnTHEMED,btnBIRTHDAY,btnANNIVERSARY,btnNEWBABY,btnVALENTINES,btnGRADUATION,btnMOTHER,btnBackMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakeview);

        btnClassic = findViewById(R.id.btnCLASSIC);
        btnTHEMED = findViewById(R.id.btnTHEMED);
        btnBIRTHDAY = findViewById(R.id.btnBIRTHDAY);

        btnANNIVERSARY = findViewById(R.id.btnANNIVERSARY);
        btnNEWBABY = findViewById(R.id.btnNEWBABY);
        btnVALENTINES = findViewById(R.id.btnVALENTINES);
        btnGRADUATION = findViewById(R.id.btnGRADUATION);
        btnMOTHER = findViewById(R.id.btnMOTHER);
        btnBackMenu = findViewById(R.id.btnBackMenu);

        btnClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, CLASSIC.class);
                startActivity(intent);
            }
        });

        btnTHEMED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, THEMED.class);
                startActivity(intent);
            }
        });
        btnBIRTHDAY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, BIRTHDAY.class);
                startActivity(intent);
            }
        });
        btnANNIVERSARY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, ANNIVERSARY.class);
                startActivity(intent);
            }
        });
        btnNEWBABY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, NEWBABY.class);
                startActivity(intent);
            }
        });
        btnVALENTINES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, VALENTINE.class);
                startActivity(intent);
            }
        });
        btnGRADUATION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, GRADUATION.class);
                startActivity(intent);
            }
        });

        btnMOTHER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, MOTHERDAY.class);
                startActivity(intent);
            }
        });

        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CUPCAKEVIEW.this, UserMenu.class);
                startActivity(intent);
            }
        });
    }
}