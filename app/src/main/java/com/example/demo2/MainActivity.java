package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button bt1,bt2;
    private EditText editText,editText1,editText2,editText3;
    private CheckBox checkbox1;
    private boolean check=false;
    private Context context11;
    private String[] day;
    private String[] day22;
    private String day0,day1,day2,day3,day4,day5,day6,day7,day8,day9;
    private int day00,day01,day02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        bt1 = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        editText=findViewById(R.id.editText);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        checkbox1=findViewById(R.id.checkBox);
        bt2.setEnabled(check);
        context11 = MainActivity.this;
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.array1,
                        android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                check=b;
                bt2.setEnabled(b);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check==true &&
                        (!editText1.getText().toString().isEmpty())&&
                        (!editText2.getText().toString().isEmpty())&&
                        (!editText3.getText().toString().isEmpty())&&
                        (!editText.getText().toString().isEmpty()))
                {
                    if(editText1.getText().toString().length()!=10)
                    {
                        Toast.makeText(context11,"請輸入符合格式的電話號碼", Toast.LENGTH_SHORT).show();
                    }
                    else if(editText2.getText().toString().length()<6)
                    {
                        Toast.makeText(context11,"密碼不足六位元", Toast.LENGTH_SHORT).show();
                    }
                    else if (editText3.getText().toString().length()!=10)
                    {
                        Toast.makeText(context11,"請輸入符合格式的日期", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        day=editText3.getText().toString().split("");
                        day0=day[10];day1=day[1];day2=day[2];day3=day[3];day4=day[4];day5=day[5];day6=day[6];day7=day[7];day8=day[8];day9=day[9];
                        if(!day5.equals("/") || !day8.equals("/") || day0.equals("/") || day1.equals("/") || day2.equals("/") ||
                                day3.equals("/") || day4.equals("/") || day6.equals("/") || day7.equals("/") || day9.equals("/"))
                        {
                            Toast.makeText(context11,"請以2個'/'分隔年、月、日", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            day22=editText3.getText().toString().split("/");
                            day00=Integer.parseInt(day22[0]);day01=Integer.parseInt(day22[1]);day02=Integer.parseInt(day22[2]);
                            if(!(day00>=1999 && day00<=2023) || !(day01>=1 && day01<=12) || !(day02>=1 && day02<=31))
                            {
                                Toast.makeText(context11,"請輸入真實存在的的日期", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                if((day01==2 && day02==31) || (day01==2 && day02==30))
                                {
                                    Toast.makeText(context11,"2/30、2/31是無效日期", Toast.LENGTH_SHORT).show();
                                }
                                else if((day02==31 && day01==4) || (day02==31 && day01==6) || (day02==31 && day01==9) || (day02==31 && day01==11))
                                {
                                    Toast.makeText(context11,"無效日期", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Intent intent1 = new Intent();
                                    intent1.setClass(MainActivity.this, gobuy0.class);
                                    startActivity(intent1);
                                }
                            }
                        }
                    }
                }
                else
                {
                    Toast.makeText(context11,"您有尚未填寫的資料", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}