package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SHIPPING extends AppCompatActivity {

    EditText editName, editMail, editMobile, editAddress, editQuantity;
    TextView textAmount;
    Button buttonPay;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);

        editName = findViewById(R.id.edtName);
        editMail = findViewById(R.id.edtMail);
        editMobile = findViewById(R.id.edtMobile);
        editAddress = findViewById(R.id.edtAddress);
        editQuantity = findViewById(R.id.edtQuantity);
        buttonPay = findViewById(R.id.btnPay);
        dbHelper = new DatabaseHelper(this);

        textAmount = findViewById(R.id.txtAmount);
        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        textAmount.setText(price);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String email = editMail.getText().toString();
                String mobile_no = editMobile.getText().toString();
                String address = editAddress.getText().toString();
                String amount = textAmount.getText().toString();
                String quantity = editQuantity.getText().toString();

                if (name.isEmpty() || email.isEmpty() || mobile_no.isEmpty() || address.isEmpty() || quantity.isEmpty()) {
                    Toast.makeText(SHIPPING.this, "Please fill the blank fields", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(SHIPPING.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = dbHelper.insertOrder(name, email, mobile_no, address, amount, quantity);
                    if (isInserted) {
                        Intent intent = new Intent(SHIPPING.this, ORDERCONFIRM.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SHIPPING.this, "Failed to place order", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}