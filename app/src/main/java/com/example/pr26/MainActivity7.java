package com.example.pr26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    TextView textname;
    TextView textnameblud;
    TextView textsugar;
    TextView textdobav;
    TextView textcost;
    ImageView but2;
    int costtovar;
    ImageView plus1;
    ImageView plus2;
    ImageView minus1;
    ImageView minus2;
    Button but;

    TextView sum1;
    TextView sum2;

    TextView result;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        but = findViewById(R.id.button2);
        result = findViewById(R.id.textView23);
        plus1 = findViewById(R.id.imageView14);
        minus1 = findViewById(R.id.imageView13);
        plus2 = findViewById(R.id.imageView17);
        minus2 = findViewById(R.id.imageView16);
        imageView = findViewById(R.id.imageView12);

        sum1 = findViewById(R.id.textView16);
        sum2 = findViewById(R.id.textView21);

        but2 = findViewById(R.id.imageView11);
        textnameblud = findViewById(R.id.textView11);
        textname = findViewById(R.id.textView9);
        textsugar = findViewById(R.id.textView12);
        textdobav = findViewById(R.id.textView14);
        textcost = findViewById(R.id.textView15);
        textname.setText("");
        textnameblud.setText("");
        textcost.setText("");
        result.setText("");

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM client_Orders", null);
        long numRows = DatabaseUtils.queryNumEntries(db, "client_Orders");
        try {
            int number = 1;
            while(query.moveToNext()){
                if(number == numRows){
                    String name = query.getString(0);
                    String cost = query.getString(1);
                    String sugar = query.getString(3);
                    String adder = query.getString(4);
                    String name_client = query.getString(7);
                    String phone_client = query.getString(8);
                    textname.append(name_client +"\n"+ phone_client);
                    textnameblud.append(name);
                    textsugar.append(": "+ sugar);
                    textdobav.append(": "+ adder);
                    textcost.append(cost);



                    String[] costlist = cost.split(" ");
                    costtovar = Integer.parseInt(costlist[0]);

                    if(costtovar == 140){
                        imageView.setImageResource(R.drawable.coffee_next);
                    }
                    else if(costtovar == 70){
                        imageView.setImageResource(R.drawable.tea);
                    }
                    else if(costtovar == 320){
                        imageView.setImageResource(R.drawable.litebreakfast);
                    }
                    else if(costtovar == 250){
                        imageView.setImageResource(R.drawable.tort);
                    }

                    result.append(String.valueOf(costtovar+230) + " рублей");
                }
                number ++;
            }

        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        finally {
            query.close();
            db.close();
        }

        but2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity7.this, data.class);
                startActivity(intent);
            }
        });

        plus1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int sum = Integer.parseInt(sum1.getText().toString());
                if(sum != 9){
                    sum++;
                    sum1.setText(String.valueOf(sum));
                    String[] costlist = result.getText().toString().split(" ");
                    int sumall = Integer.parseInt(costlist[0]);
                    result.setText(String.valueOf(sumall + costtovar) + " рублей");
                }
            }
        });

        minus1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int sum = Integer.parseInt(sum1.getText().toString());
                if(sum != 1){
                    sum--;
                    sum1.setText(String.valueOf(sum));
                    String[] costlist = result.getText().toString().split(" ");
                    int sumall = Integer.parseInt(costlist[0]);
                    result.setText(String.valueOf(sumall - costtovar) + " рублей");
                }
            }
        });

        plus2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int sum = Integer.parseInt(sum2.getText().toString());
                if(sum != 9){
                    sum++;
                    sum2.setText(String.valueOf(sum));
                    String[] costlist = result.getText().toString().split(" ");
                    int sumall = Integer.parseInt(costlist[0]);
                    result.setText(String.valueOf(sumall + 230) + " рублей");
                }
            }
        });

        minus2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int sum = Integer.parseInt(sum2.getText().toString());
                if(sum != 1){
                    sum--;
                    sum2.setText(String.valueOf(sum));
                    String[] costlist = result.getText().toString().split(" ");
                    int sumall = Integer.parseInt(costlist[0]);
                    result.setText(String.valueOf(sumall - 230) + " рублей");
                }
            }
        });

        but.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent;
                switch (view.getId()) {

                    case R.id.button2:
                        intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("geo:55.034238155701566,82.92005552645742"));
                        startActivity(intent);
                        break;
                }}
        });
    }
}