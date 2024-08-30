package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMenu extends AppCompatActivity {
    Button buttonViewOrders,buttonManageCat,buttonManageCup,buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        buttonViewOrders = findViewById(R.id.btnViewOrders);
        buttonManageCat = findViewById(R.id.btnMngeCtgry);
        buttonManageCup = findViewById(R.id.btnMngCupcake);
        buttonLogout = findViewById(R.id.btnLogout1);

        buttonViewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenu.this, Viewoders.class);
                startActivity(intent);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenu.this, Login.class);
                startActivity(intent);
            }
        });
    }
}