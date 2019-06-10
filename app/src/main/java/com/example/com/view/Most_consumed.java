package com.example.com.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class Most_consumed extends AppCompatActivity {

    private RecyclerView MOrecyclerView;
    private ItemaAdpater MOrowAdpter;
    private ArrayList<Item> MOAllIist;
    private TextView MOTotal_profit;
    private TextView MOTotal_Quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_consumed);

        getSupportActionBar().setTitle("Net profit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MOrecyclerView = (RecyclerView) findViewById(R.id.most_recy);
        MOTotal_profit =(TextView) findViewById(R.id.MOTotal_cost);
        MOTotal_Quantity =(TextView) findViewById(R.id.MOTotal_Quantity);


        MOAllIist=new ArrayList<>();
        int totalsum=0;
        int inside=0,outside=0;

        int qun=0;
        String dateInString = "2011-11-";
        for(int i=0 ;i<20;i++)
        {
            MOAllIist.add(new Item("shmam",20+i,30+i,31+i ,dateInString+i));
            totalsum +=MOAllIist.get(i).getSold()*MOAllIist.get(i).getPriceOutsid();
            qun +=MOAllIist.get(i).getSold();
        }

        MOrowAdpter =new ItemaAdpater(this,  MOAllIist,3);
        MOrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MOrecyclerView.setAdapter(MOrowAdpter);

        MOTotal_profit.setText(Integer.toString(totalsum));
        MOTotal_Quantity.setText(Integer.toString(qun));




    }
}
