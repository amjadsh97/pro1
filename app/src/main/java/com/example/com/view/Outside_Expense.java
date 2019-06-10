package com.example.com.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class Outside_Expense extends AppCompatActivity {
    private RecyclerView OrecyclerView;
    private ItemaAdpater OrowAdpter;
    private ArrayList<Item> AllIist;
    private TextView OTotal_cost;
    private TextView OTotal_Quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outside__expense);


        getSupportActionBar().setTitle("Outside Expense");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        OrecyclerView = (RecyclerView) findViewById(R.id.outside_recy);
        OTotal_cost =(TextView) findViewById(R.id.OTotal_cost);
        OTotal_Quantity =(TextView) findViewById(R.id.OTotal_Quantity);


        AllIist=new ArrayList<>();
        int totalsum=0;
        int qun=0;
        String dateInString = "2011-11-";
        for(int i=0 ;i<20;i++)
        {
            AllIist.add(new Item("shmam",20+i,30+i,31+i ,dateInString+i));
            totalsum +=AllIist.get(i).getSold()*AllIist.get(i).getPriceOutsid();
            qun +=AllIist.get(i).getSold();
        }

        OrowAdpter =new ItemaAdpater(this,  AllIist,3);
        OrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        OrecyclerView.setAdapter(OrowAdpter);

        OTotal_cost.setText(Integer.toString(totalsum));
        OTotal_Quantity.setText(Integer.toString(qun));

    }
}
