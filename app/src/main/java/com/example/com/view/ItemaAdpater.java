package com.example.com.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Instant;
import java.util.List;

import static com.example.com.view.R.id.Quantity;

public class ItemaAdpater extends RecyclerView.Adapter<ItemaAdpater.ViewHolder> {

    private  OnItemClickListener listener;
    private Cursor mCursor;

    private int totalsum=0 ,qun=0; int mdiget=1;
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        String img;
        TextView name;
        TextView Quantity;
        TextView price;
        TextView Date;

        TextView mname;
        TextView mQuantity;
        TextView mprice;
        TextView mcost;
        TextView digte;

        TextView Oname;
        TextView OQuantity;
        TextView Oprice;
        TextView Ocost;
        TextView Odigte;

        TextView Pname;
        TextView PQuantity;
        TextView Pcost;
        TextView Pdigte;

        ImageView NameGroup;
        TextView Name2Group;
        OnItemClickListener onItem;

        public ViewHolder (View itemView, OnItemClickListener onItem){
               super(itemView);
            name     = (TextView) itemView.findViewById(R.id.item_name);
            Quantity = (TextView) itemView.findViewById(R.id.Quantity);
            price    = (TextView) itemView.findViewById(R.id.price);
            Date     = (TextView) itemView.findViewById(R.id.Date);

            digte     = (TextView) itemView.findViewById(R.id.digte);
            mname     = (TextView) itemView.findViewById(R.id.inside_Name);
            mQuantity = (TextView) itemView.findViewById(R.id.inside_Quantity);
            mprice    = (TextView) itemView.findViewById(R.id.inside_price);
            mcost     = (TextView) itemView.findViewById(R.id.inside_cost);

            Odigte     = (TextView) itemView.findViewById(R.id.outside_digte);
            Oname      = (TextView) itemView.findViewById(R.id.outside_Name);
            OQuantity = (TextView) itemView.findViewById(R.id.outside_Quantity);
            Oprice    = (TextView) itemView.findViewById(R.id.outside_price);
            Ocost     = (TextView) itemView.findViewById(R.id.outside_cost);

            Pdigte     = (TextView) itemView.findViewById(R.id.profit_digte);
            Pname      = (TextView) itemView.findViewById(R.id.profit_Name);
            PQuantity = (TextView) itemView.findViewById(R.id.profit_Quantity);
            Pcost     = (TextView) itemView.findViewById(R.id.profit_cost);

            this.onItem=onItem;

            NameGroup     = (ImageView) itemView.findViewById(R.id.Bimg_group);
            Name2Group     = (TextView) itemView.findViewById(R.id.Bname_group);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItem.onItemClick(getAdapterPosition());

        }
    }
     private Context Context;
     private List<Item> row;
     private int Act;
    private List<String> g;



    public ItemaAdpater(Context c, List<Item> rowlist,int i){

        this.Context=c;
        this.row=rowlist;
        this.Act=i;

    }
//Cursor cursor
    public ItemaAdpater(Context c,List<String> rowlist ,int i,OnItemClickListener listener){

        this.Context=c;
        this.Act=i;
        this.listener=listener;
        this.g=rowlist;

//        mCursor = cursor;
    }
    @NonNull
    @Override
    public ItemaAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View paperView;
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        if(Act==0) {
            paperView = layoutInflater.inflate(R.layout.row_group, viewGroup, false);
        }else if(Act==2) {
            paperView = layoutInflater.inflate(R.layout.row_inside, viewGroup, false);
        }else if(Act==3) {
            paperView = layoutInflater.inflate(R.layout.row_outside, viewGroup, false);
        }else if(Act==4) {
            paperView = layoutInflater.inflate(R.layout.row_profit, viewGroup, false);
        }else {
            paperView = layoutInflater.inflate(R.layout.row_item, viewGroup, false);
        }
        ViewHolder myViewHolder = new ViewHolder(paperView,listener );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemaAdpater.ViewHolder viewHolder, int i) {

        if(Act==2)
        {
            Item p = row.get(i);
            mdiget=i+1;
            viewHolder.digte.setText(Integer.toString(mdiget));
            viewHolder.mname.setText(p.getName().toString());
            viewHolder.mQuantity.setText(Integer.toString(p.getQuantity()));
            viewHolder.mprice.setText(Integer.toString(p.getPriceInsid()));
            viewHolder.mcost.setText(Integer.toString(p.getQuantity()*p.getPriceInsid()));
        }
        else if(Act==3)
        {
            Item p = row.get(i);
            mdiget=i+1;
            viewHolder.Odigte.setText(Integer.toString(mdiget));
            viewHolder.Oname.setText(p.getName().toString());
            viewHolder.OQuantity.setText(Integer.toString(p.getSold()));
            viewHolder.Oprice.setText(Integer.toString(p.getPriceOutsid()));
            viewHolder.Ocost.setText(Integer.toString(p.getSold()*p.getPriceOutsid()));

        }else if(Act==0)
        {
//            if (!mCursor.moveToPosition(i)) {
//                return;
//            }
//
//            String name = mCursor.getString(mCursor.getColumnIndex(GroupContantDB.GroupEntry.COLUMN_NAME));
//            System.out.println(name);
            String name = g.get(i);
            viewHolder.Name2Group.setText(name);

            viewHolder.NameGroup.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent myIntent = new Intent(Context , List_Group.class);
                    Context.startActivity(myIntent);
                }
            });
        }else if(Act==4)
        {
            int inside,outside,totalProfit=0;
            Item p = row.get(i);
            mdiget=i+1;
            viewHolder.Pdigte.setText(Integer.toString(mdiget));
            viewHolder.Pname.setText(p.getName().toString());
            viewHolder.PQuantity.setText(Integer.toString(p.getSold()));
            inside  =row.get(i).getSold()*row.get(i).getPriceInsid();
            outside =row.get(i).getSold()*row.get(i).getPriceOutsid();
            totalProfit +=outside-inside;
            viewHolder.Pcost.setText(Integer.toString(totalProfit));
        }
        else
        {
            Item p = row.get(i);
            viewHolder.name.setText(p.getName());
            viewHolder.Quantity.setText(Integer.toString(p.getQuantity()));
            viewHolder.price.setText(Integer.toString(p.getPriceOutsid()));
            viewHolder.Date.setText(p.getDate());
        }
    }



    @Override
    public int getItemCount() {
        if(Act==0)return g.size();
        return row.size();
    }


    public interface OnItemClickListener {
        void onItemClick(int item);
    }


    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}

