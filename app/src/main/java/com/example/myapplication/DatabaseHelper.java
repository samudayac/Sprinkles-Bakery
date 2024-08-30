package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sprinkles_db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_USER_TABLE = "CREATE TABLE users " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT," +
            "username TEXT, " +
            "email TEXT, " +
            "password TEXT );";
    private static final String CREATE_ORDER_TABLE = "CREATE TABLE orders" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT," +
            "email TEXT, " +
            "mobile_no TEXT, " +
            "address TEXT," +
            "amount TEXT," +
            "quantity TEXT );";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_ORDER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(db);
    }

    public Cursor getOrderData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT name,email,mobile_no,address,amount,quantity FROM orders", null);
        return cursor;
    }

    public boolean insertOrder(String name, String email, String mobileNo, String address, String amount, String quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("mobile_no", mobileNo);
        values.put("address", address);
        values.put("amount", amount);
        values.put("quantity", quantity);

        long newRowId = db.insert("orders", null, values);
        db.close();
        return newRowId != -1;
    }
}
