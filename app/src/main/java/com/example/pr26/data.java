package com.example.pr26;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class data extends AppCompatActivity {
    Button buttonlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
    }
    public void onClick(View view){
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);


        Cursor query = db.rawQuery("SELECT * FROM client_Orders;", null);
        TextView textView = findViewById(R.id.textView);
        buttonlist = findViewById(R.id.button);
        buttonlist.setVisibility(View.GONE);
        textView.setText("");
        while(query.moveToNext()){
            String name_order = query.getString(0);
            String cost = query.getString(1);
            String add_item = query.getString(2);
            String sugar = query.getString(3);
            String adder = query.getString(4);
            String personaldeliv = query.getString(5);
            String deliv = query.getString(6);
            String name_client = query.getString(7);
            String phone_client = query.getString(8);

            textView.append(name_order+" "+cost+" "+add_item+" "+sugar+" "+adder+" "+personaldeliv+" "+deliv+" "+name_client+" "+phone_client);
            textView.append(" \n ");
            textView.append(" \n ");
        }
        query.close();
        db.close();
    }
}