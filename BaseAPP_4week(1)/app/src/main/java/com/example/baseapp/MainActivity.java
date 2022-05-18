package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chbox1;
    CheckBox chbox2;
    CheckBox chbox3;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chbox1 = (CheckBox) findViewById(R.id.checkBox1);
        chbox2 = (CheckBox) findViewById(R.id.checkBox2);
        chbox3 = (CheckBox) findViewById(R.id.checkBox3);
        button1 = (Button)  findViewById(R.id.button);

        chbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chbox1.isChecked()){
                button1.setEnabled(true);
            }else
                    button1.setEnabled(false);
        }});

        chbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chbox2.isChecked()) {
                    button1.setClickable(true);
                }else
                    button1.setClickable(false);

            }
        });
        chbox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chbox3.isChecked()) {
                    button1.setRotation(45);
                }else
                    button1.setRotation(-45);

            }
        });




    }
}