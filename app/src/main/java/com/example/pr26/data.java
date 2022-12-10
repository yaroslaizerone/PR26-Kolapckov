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
        int schet = 1;
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

            textView.append("           Заказ#" +schet + "                 \n ");
            textView.append("Название блюда: "+name_order+"\n Cтоимость: "+cost+"\n Добавка: "+add_item+"\n Сахарку?: "+sugar+"\n Топинг?: "+adder+"\n Самовывоз?: "+personaldeliv+"\n Доставочку?: "+deliv+"\n Имя: "+name_client+"\n Телефонный номер: "+phone_client);
            textView.append(" \n ");
            schet++;
        }
        query.close();
        db.close();
    }
}