package com.example.com.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class Inside_Expense extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private ItemaAdpater mrowAdpter;
    private ArrayList<Item> AllIist;
    private TextView Total_cost;
    private TextView Total_Quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside__expense);

        getSupportActionBar().setTitle("inside Expense");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mrecyclerView = (RecyclerView) findViewById(R.id.inside_recy);
        Total_cost =(TextView) findViewById(R.id.Total_cost);
        Total_Quantity =(TextView) findViewById(R.id.Total_Quantity);


        AllIist=new ArrayList<>();
        int totalsum=0;
        int qun=0;
        String dateInString = "2011-11-";
        for(int i=0 ;i<20;i++)
        {
            AllIist.add(new Item("shmam",20+i,30+i,31+i ,dateInString+i));
            totalsum +=AllIist.get(i).getQuantity()*AllIist.get(i).getPriceInsid();
            qun +=AllIist.get(i).getQuantity();
        }

        mrowAdpter =new ItemaAdpater(this,  AllIist,2);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setAdapter(mrowAdpter);


        Total_cost.setText(Integer.toString(totalsum));
        Total_Quantity.setText(Integer.toString(qun));

    }
}
