package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ORDERCONFIRM extends AppCompatActivity {

    Button confirmbutton;
    TextView nameview, emailview, mobilenoview, addressview, quantityview, amountview;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderconfirm);

        confirmbutton = findViewById(R.id.btnCONFIRM);
        nameview = findViewById(R.id.txtNAMEVIEW);
        emailview = findViewById(R.id.txtEMAILVIEW);
        mobilenoview = findViewById(R.id.txtMOBILENOVIEW);
        addressview = findViewById(R.id.txtADDRESSVIEW);
        quantityview = findViewById(R.id.txtQUANTITYVIEW);
        amountview = findViewById(R.id.txtAMOUNTVIEW);
        dbHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String email = intent.getStringExtra("email");
            String mobile_no = intent.getStringExtra("mobile_no");
            String address = intent.getStringExtra("address");
            String quantity = intent.getStringExtra("quantity");
            String amount = intent.getStringExtra("amount");

            nameview.setText(name);
            emailview.setText(email);
            mobilenoview.setText(mobile_no);
            addressview.setText(address);
            quantityview.setText(quantity);
            amountview.setText(amount);


            confirmbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = nameview.getText().toString();
                    String email = emailview.getText().toString();
                    String mobile_no = mobilenoview.getText().toString();
                    String address = addressview.getText().toString();
                    String quantity = quantityview.getText().toString();
                    String amount = amountview.getText().toString();

                    boolean isInserted = dbHelper.insertOrder(name, email, mobile_no, address, quantity, amount);
                    if (isInserted) {
                        Toast.makeText(ORDERCONFIRM.this, "Order Placed successfully", Toast.LENGTH_SHORT).show();
                        Intent homeintent = new Intent(ORDERCONFIRM.this, UserMenu.class);
                        startActivity(homeintent);
                        finish();
                    } else {
                        Toast.makeText(ORDERCONFIRM.this, "Order Placed Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}



