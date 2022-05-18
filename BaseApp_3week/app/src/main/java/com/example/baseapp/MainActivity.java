package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    EditText text1;
    Toast toast1;
    RadioGroup rg;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup)findViewById(R.id.radioGroup);
        img=(ImageView)findViewById(R.id.imageView);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.android2);

        button1 =(Button) findViewById(R.id.button1);
        text1=(EditText)findViewById(R.id.editText);
        button1.setBackgroundColor(Color.GRAY);
        button1.setTextColor(Color.BLACK);

        //첫번째 버튼, text editer에 작성한 문구가 toast로 뜨도록 함
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast1 = Toast.makeText(getApplicationContext(),text1.getText(),
                Toast.LENGTH_SHORT);

                toast1.show();
            }
        });

        //두번째 버튼, 클릭시 네이트 페이지로 이동함
        button2 =(Button) findViewById(R.id.button2);
        button2.setBackgroundColor(Color.GRAY);
        button2.setTextColor(Color.BLACK);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
                startActivity(mIntent);
            }
        });

        //라디오 그룹, 처음에는 첫번째 라디오 버튼이 자동으로 눌러져 있도록 셋팅되있고
        //두번째 버튼을 누를시 다른 이미지로 바뀜.
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.br1){
                    img.setImageResource(R.drawable.android1);
                }
                else {
                    img.setImageResource(R.drawable.android2);
                }
            }
        });

    }
}