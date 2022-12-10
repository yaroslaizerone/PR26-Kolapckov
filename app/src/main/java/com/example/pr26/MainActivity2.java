package com.example.pr26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity2 extends AppCompatActivity {

    CheckBox checktea;
    CheckBox checkcandy;
    CheckBox checkcoffee;
    CheckBox checkcombo;
    Button buttonresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        checktea = (CheckBox)findViewById(R.id.checktea);
        checkcandy = (CheckBox)findViewById(R.id.checkcandy);
        checkcoffee = (CheckBox)findViewById(R.id.checkcoffee);
        checkcombo = (CheckBox)findViewById(R.id.checkcombo);

        buttonresult = (Button) findViewById(R.id.buttonresult);

        buttonresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checktea.isChecked()) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                    startActivity(intent);
                }
                if(checkcandy.isChecked()){
                    Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
                    startActivity(intent);
                }
                if(checkcoffee.isChecked()){
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                }
                if(checkcombo.isChecked()){
                    Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                    startActivity(intent);
                }


            }
        });
    }

}