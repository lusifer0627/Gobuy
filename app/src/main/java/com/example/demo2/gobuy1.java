package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class gobuy1 extends AppCompatActivity {
    private SeekBar seekbar3;
    private Context context;
    private String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gobuy1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,    //對應的Context
                        R.array.array2,                             //資料選項內容
                        android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter);

        context = gobuy1.this;
        bindViews();
    }

    private void bindViews() {
        seekbar3 = (SeekBar) findViewById(R.id.seekBar2);
        seekbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p=String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(context, p+'%', Toast.LENGTH_SHORT).show();
            }
        });
    }
}