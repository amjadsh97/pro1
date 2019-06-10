package com.example.com.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class List_Group extends AppCompatActivity {

    private RecyclerView LrecyclerView;
    private ItemaAdpater LitemAdpter;
    private ArrayList<Item> AllIist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__group);

        getSupportActionBar().setTitle("List Group");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        LrecyclerView = (RecyclerView) findViewById(R.id.list_Screen);
        AllIist=new ArrayList<>();

        String dateInString = "2011-11-";
        for(int i=0 ;i<20;i++)
            AllIist.add(new Item("shmam",20+i,30+1,31+i ,dateInString+i));

        LitemAdpter =new ItemaAdpater(this,  AllIist,1);
        LrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        LrecyclerView.setAdapter(LitemAdpter);

    }
}
