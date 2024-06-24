package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class gobuy0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gobuy0);
        ImageView imgv7=findViewById(R.id.imagv7);
        ImageView imgv5=findViewById(R.id.imagv5);
        ImageView imgv=findViewById(R.id.imageView);

        imgv7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(gobuy0.this,gobuy1.class);
                startActivity(intent);
            }
        });
        imgv5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent();
                intent1.setClass(gobuy0.this,gobuy2.class);
                startActivity(intent1);
            }
        });
        imgv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent();
                intent1.setClass(gobuy0.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}