package com.example.retea.upbid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by retea on 04-May-18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ExampleViewHolder>{

    private ArrayList<Item> mItemList;
    private Context mContext;


    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public RelativeLayout mParentLayout;
        public TextView mTvNume;
        public TextView mTvDescriere;
        public TextView mTvPretStart;
        public TextView mTvPretBuyout;
        public TextView mTvPretCurent;
        public TextView mTvStare;


        public ExampleViewHolder(View itemView) {
            super(itemView);
            mTvNume = itemView.findViewById(R.id.tvNume);
            mTvDescriere = itemView.findViewById(R.id.tvDescriere);
            mTvPretStart = itemView.findViewById(R.id.tvPretStart);
            mTvPretBuyout = itemView.findViewById(R.id.tvPretBuyout);
            mTvPretCurent = itemView.findViewById(R.id.tvPretCurent);
            mParentLayout = itemView.findViewById(R.id.parent_layout);
            mTvStare = itemView.findViewById(R.id.tvStare);

        }
    }

    public ItemAdapter(ArrayList<Item> itemListU,Context context){
        mItemList = itemListU;
        mContext = context;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, final int position) {

        Item currentItem = mItemList.get(position);
        holder.mTvNume.setText(currentItem.getNume());
        holder.mTvDescriere.setText("Descriere: " + currentItem.getDescr());
        holder.mTvPretStart.setText("Pret start: " +String.valueOf(currentItem.getPretStart()));
        holder.mTvPretBuyout.setText("Pret buyout: " +String.valueOf(currentItem.getPretBuyout()));
        if (currentItem.isAuctioned()){
        holder.mTvPretCurent.setText("Pret curent: " + String.valueOf(currentItem.getPretCurent()));
        holder.mTvStare.setText("Licitatie in desfasurare");
        }
        else  {
            holder.mTvPretCurent.setText("Pret curent: Nelicitat" );
            holder.mTvStare.setText("Nelicitat");
        }
        if(currentItem.isVandut()){
            holder.mTvPretCurent.setText("Pret curent: "+ String.valueOf(currentItem.getPretCurent()));
            holder.mTvStare.setText("VANDUT!");
        }
        holder.mParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,ItemDetail.class);
                intent.putExtra("itemPosition",position);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
