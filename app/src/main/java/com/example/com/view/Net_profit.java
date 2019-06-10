package com.example.com.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class Net_profit extends AppCompatActivity {
    private RecyclerView PrecyclerView;
    private ItemaAdpater ProwAdpter;
    private ArrayList<Item> AllIist;
    private TextView PTotal_profit;
    private TextView PTotal_Quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_profit);


        getSupportActionBar().setTitle("Net profit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PrecyclerView = (RecyclerView) findViewById(R.id.profit_recy);
        PTotal_profit =(TextView) findViewById(R.id.NTotal_profit);
        PTotal_Quantity =(TextView) findViewById(R.id.NTotal_Quantity);


        AllIist=new ArrayList<>();
        int totalProfit=0;
        int inside=0,outside=0;

        int qun=0;
        String dateInString = "2011-11-";
        for(int i=0 ;i<20;i++)
        {
            AllIist.add(new Item("shmam",20+i,30+i,35+2*i ,dateInString+i));
            inside  =AllIist.get(i).getSold()*AllIist.get(i).getPriceInsid();
            outside =AllIist.get(i).getSold()*AllIist.get(i).getPriceOutsid();
            totalProfit +=outside-inside;
            qun +=AllIist.get(i).getSold();
        }

        ProwAdpter =new ItemaAdpater(this,  AllIist,4);
        PrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        PrecyclerView.setAdapter(ProwAdpter);


        PTotal_profit.setText(Integer.toString(totalProfit));
        PTotal_Quantity.setText(Integer.toString(qun));

    }
}
