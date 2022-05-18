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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String num1, num2; //숫자 1,2 입력받을 변수
    Double result; //계산 결과값
    int i; //for문 위한 정수형 변수
    Button[] numButtons = new Button[10]; //계산기 숫자 버튼 생성
    Integer[] numBtnIDs = {R.id.bum1, R.id.bum2, R.id.bum3, R.id.bum4, R.id.bum5,
            R.id.bum6, R.id.bum7, R.id.bum8, R.id.bum9, R.id.bum10}; //각 아이디 버튼 아이디 할당

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.android2);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        EditText et1 = (EditText) findViewById(R.id.edit1);
        EditText et2 = (EditText) findViewById(R.id.edit2);
        TextView tv = (TextView) findViewById(R.id.textview);


        //덧셈 버튼
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = et1.getText().toString();
                num2 = et2.getText().toString();

                if (num1.getBytes().length <= 0 || num2.getBytes().length <= 0) //어떤 숫자도 입력되지 않은 경우
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요!", Toast.LENGTH_SHORT).show();
                else {
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    tv.setText("계산결과:" + result.toString());
                }
            }
        });

        //뺄셈 버튼
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();

                if (num1.getBytes().length <= 0 || num2.getBytes().length <= 0)
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요!", Toast.LENGTH_SHORT).show();
                else {
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    tv.setText("계산결과:" + result.toString());
                }
            }
        });

        //곱하기
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                if (num1.getBytes().length <= 0 || num2.getBytes().length <= 0)
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요!", Toast.LENGTH_SHORT).show();
                else {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    tv.setText("계산결과:" + result.toString());
                }
            }
        });

        //나누기
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                if (num1.getBytes().length <= 0 || num2.getBytes().length <= 0)
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요!", Toast.LENGTH_SHORT).show();
                else if (num2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없어요!", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    tv.setText("계산결과:" + result.toString());
                }
            }
        });

        //나머지 계산
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                if (num1.getBytes().length <= 0 || num2.getBytes().length <= 0)
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요!", Toast.LENGTH_SHORT).show();
                else {
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    tv.setText("계산결과:" + result.toString());
                }
            }
        });

        //0~9의 숫자버튼 설정
        for(i=0; i<numBtnIDs.length; i++)
        {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for (i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (et1.isFocused() == true) { //첫번째 edittext가 선택되었다면 현재 입력된 값에 num버튼값 추가
                        num1 = et1.getText().toString()
                                + numButtons[index].getText().toString();
                        et1.setText(num1);
                    } else if (et2.isFocused() == true) { //두번째 edittext가 선택되었다면 현재 입력된 값에 num버튼값 추가
                        num2 = et2.getText().toString()
                                + numButtons[index].getText().toString();
                        et2.setText(num2);
                    } else { //에디터 텍스트가 선택되지 않았을 경우
                        Toast.makeText(getApplicationContext(), "먼저 에디터 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}