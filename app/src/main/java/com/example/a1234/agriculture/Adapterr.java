package com.example.a1234.agriculture;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Adapterr extends RecyclerView.Adapter<Adapterr.ViewHolder> {

    Recycler mainActivity;
    String[] data;
    int[] image;

    public Adapterr(Recycler mainActivity, String[] data, int[] image){
        this.mainActivity= mainActivity;
        this.data= data;
        this.image=image;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_custom,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.result.setText(data[i]);
        viewHolder.image.setImageResource(image[i]);


        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageSwitcher logo;
        TextView result;
        ImageView image;
        CardView cardView;

        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            result=itemView.findViewById(R.id.cropname);
            cardView=itemView.findViewById(R.id.cardView1);
           // image=itemView.findViewById(R.id.logo);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mainActivity, "cotton", Toast.LENGTH_SHORT).show();
        }
    }
}
