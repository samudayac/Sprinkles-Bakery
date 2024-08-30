package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText etName, etUsername, etPassword, etConfirmPassword;
    Button buttonRegister, buttonBack;
    DatabaseHelper dbHelper;
    TextView textViewError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.edtNAME);
        etUsername = findViewById(R.id.edtUSERNAME);
        etPassword = findViewById(R.id.edtPASSWORD);
        etConfirmPassword = findViewById(R.id.edtCONFIRMPASSWORD);
        buttonRegister = findViewById(R.id.btnREGISTER);
        textViewError = findViewById(R.id.errVIEW);
        dbHelper = new DatabaseHelper(this);
        buttonBack = findViewById(R.id.btnBACK);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (name.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    textViewError.setText("Please fill the blank fields");
                } else if (!password.equals(confirmPassword)) {
                    textViewError.setText("Password do not match");
                } else {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("name", name);
                    values.put("username", username);
                    values.put("password", password);
                    long newRowId = db.insert("users", null, values);
                    if (newRowId != -1) {
                        Toast.makeText(Registration.this, "Registration Succesful!",
                                Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        textViewError.setText("Registration Failed!");
                    }
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }
    });

    }

}