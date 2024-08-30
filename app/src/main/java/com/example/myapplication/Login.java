package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText etusername, etpassword;
    Button buttonlogin, buttonsignup;
    TextView errview;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusername = findViewById(R.id.edittextUSERNAME);
        etpassword = findViewById(R.id.edittextPASSWORD);
        buttonlogin = findViewById(R.id.btnLOGIN);
        buttonsignup = findViewById(R.id.btnSIGNUP);
        errview = findViewById(R.id.textERRORVIEW);

        dbHelper = new DatabaseHelper(this);

        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                startActivity(intent);
            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    errview.setText("Please fill the all fields");
                } else if (checkUserCredentials(username, password)) {

                    if (username.equalsIgnoreCase("Admin") || password.equalsIgnoreCase("Admin")) {
                        Intent intent = new Intent(Login.this, AdminMenu.class);
                        startActivity(intent);

                    } else {
                        Intent intent = new Intent(Login.this, UserMenu.class);
                        startActivity(intent);
                    }

                } else {
                    errview.setText("Login Failed!! Wrong Username or Password");
                }
            }
        });
    }

    private boolean checkUserCredentials(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selection = "username = ? AND password = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query("users", null, selection, selectionArgs, null, null, null);
        boolean credentialsMatch = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return credentialsMatch;
    }

}
