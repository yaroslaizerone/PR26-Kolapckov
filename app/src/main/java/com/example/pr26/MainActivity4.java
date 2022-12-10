package com.example.pr26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    TextView textcost;
    Spinner spin;
    Switch sw1;
    Switch sw2;
    Switch sw3;
    Switch sw4;
    EditText textclientname;
    EditText textclientphone;
    TextView textname;
    Button but;
    Button but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        but2 = findViewById(R.id.button4);
        but = findViewById(R.id.button3);
        textcost = findViewById(R.id.textView7);
        spin = findViewById((R.id.spinner));
        sw1 = findViewById((R.id.switch4));
        sw2 = findViewById((R.id.switch3));
        sw3 = findViewById((R.id.switch2));
        sw4 = findViewById((R.id.switch1));
        textclientname = findViewById(R.id.editText2);
        textclientphone = findViewById(R.id.editText);
        textname = findViewById(R.id.textView6);

        Button button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                String name_order = textname.getText().toString();
                String cost = textcost.getText().toString();
                String add_item = spin.getSelectedItem().toString();
                String sugar;
                String adder;
                String personaldeliv;
                String deliv;
                if(sw1.isChecked()) { sugar = "Да";}
                else{ sugar = "Нет";}
                if(sw2.isChecked()) { adder = "Да";}
                else{ adder = "Нет";}
                if(sw3.isChecked()) { personaldeliv = "Да";}
                else{ personaldeliv = "Нет";}
                if(sw4.isChecked()) { deliv = "Да";}
                else{ deliv = "Нет";}

                String name_client = textclientname.getText().toString();
                String phone_client = textclientphone.getText().toString();

                Toast toast2 = Toast.makeText(getApplicationContext(),
                        "Добавление записи",
                        Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.CENTER, 0, 0);
                toast2.show();

                SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

                db.execSQL("CREATE TABLE IF NOT EXISTS client_Orders (name_order TEXT, cost TEXT," +
                        "add_item TEXT, sugar TEXT,adder TEXT,personaldeliv TEXT,deliv TEXT" +
                        ",name_client TEXT,phone_client TEXT)");
                db.execSQL("INSERT OR IGNORE INTO client_Orders VALUES ('"+name_order+"','"+cost+"','"+add_item+"','"+sugar+"'," +
                        "'"+adder+"','"+personaldeliv+"','"+deliv+"','"+name_client+"','"+phone_client+"');");
                db.close();
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Запись добавлена",
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });


        but.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent;
                switch (view.getId()) {

                    case R.id.button3:
                        intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("geo:-0.45609946,-90.26607513"));
                        startActivity(intent);
                        break;
                }}
        });
        but2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity4.this, data.class);
                startActivity(intent);
            }
        });
    }
}