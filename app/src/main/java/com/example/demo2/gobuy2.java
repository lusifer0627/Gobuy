package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class gobuy2 extends AppCompatActivity {
    String TAG = "mExample";
    RecyclerView mRecyclerView;
    MyListAdapter myListAdapter;
    private String days,hours,mins;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gobuy2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,    //對應的Context
                        R.array.array3,                             //資料選項內容
                        android.R.layout.simple_spinner_item);
        spinner3.setAdapter(adapter);
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("福勝亭");arrayList1.add("吉野家");arrayList1.add("饗食天堂");

        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", arrayList1.get(new Random().nextInt(3)));
            int monthi=new Random().nextInt(12)+1;
            if(monthi==2)
            {
                days= String.valueOf(new Random().nextInt(27)+1);
            }
            else if(monthi==1 && monthi==3 && monthi==5 && monthi==7 && monthi==8 && monthi==10 && monthi==12)
            {
                days= String.valueOf(new Random().nextInt(30)+1);
            }
            else
            {
                days= String.valueOf(new Random().nextInt(29)+1);
            }
            hashMap.put("day", String.valueOf(new Random().nextInt(3)+2020)+"/"+String.valueOf(monthi) +"/"+days);
            int houri=new Random().nextInt(23);
            int mini=new Random().nextInt(59);
            hours = (houri<10) ? ("0"+houri) : (String.valueOf(houri));
            mins = (mini<10) ? ("0"+mini) : (String.valueOf(mini));
            hashMap.put("time", hours+':'+mins);
            hashMap.put("point", "+"+String.valueOf(new Random().nextInt(1000)+2000));
            arrayList.add(hashMap);
        }
        //設置RecycleView
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        myListAdapter = new MyListAdapter();
        mRecyclerView.setAdapter(myListAdapter);
    }
    private class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tvname, tvday,tvtime, tvpoint;
            public ViewHolder(View itemView) {
                super(itemView);
                tvname = itemView.findViewById(R.id.textView25);
                tvday = itemView.findViewById(R.id.textView23);
                tvtime = itemView.findViewById(R.id.textView24);
                tvpoint = itemView.findViewById(R.id.textView20);
            }
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.rev1, parent, false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvname.setText(arrayList.get(position).get("name"));
            holder.tvday.setText(arrayList.get(position).get("day"));
            holder.tvtime.setText(arrayList.get(position).get("time"));
            holder.tvpoint.setText(arrayList.get(position).get("point"));
        }
        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }
}