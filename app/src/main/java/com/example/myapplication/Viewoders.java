package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Viewoders extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name,email,mobileNo,address,amount,quantity;
    DatabaseHelper dbHelper;
    OrderAdapter orderAdapter;
    Button btnOrdDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewoders);

        dbHelper = new DatabaseHelper(this);
        name = new ArrayList<>();
        email = new ArrayList<>();
        mobileNo = new ArrayList<>();
        address = new ArrayList<>();
        amount = new ArrayList<>();
        quantity = new ArrayList<>();

        recyclerView = findViewById(R.id.rclViewOrder);
        orderAdapter = new OrderAdapter(this,name,email,mobileNo,address,amount,quantity);
        recyclerView.setAdapter(orderAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData(){
        Cursor cursor = dbHelper.getOrderData();
        if(cursor.getCount()==0){
            Toast.makeText(Viewoders.this,"NO ORDERS FOUND",Toast.LENGTH_SHORT).show();
            return;
        }
        while(cursor.moveToNext()){

            String orderName = cursor.getString(0);
            if (!name.contains(orderName)) {
                name.add(orderName);
                email.add(cursor.getString(1));
                mobileNo.add(cursor.getString(2));
                address.add(cursor.getString(3));
                amount.add(cursor.getString(4));
                quantity.add(cursor.getString(5));
            }
        }
        cursor.close();

        orderAdapter.notifyDataSetChanged();
    }
}