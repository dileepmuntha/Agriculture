package com.example.a1234.agriculture;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
  Recycler recyclerView;
    List<Sheet1> listLiveData;
    public DataAdapter(Recycler mainActivity, List<Sheet1> listLiveData) {
        this.recyclerView = mainActivity;
        this.listLiveData = listLiveData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(recyclerView).inflate(R.layout.activity_custom, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.cropname.setText(listLiveData.get(i).getCROP_NAME());
        viewHolder.location.setText(listLiveData.get(i).getLOCATION());
        viewHolder.type.setText(listLiveData.get(i).getTYPE_());
        viewHolder.price.setText(listLiveData.get(i).getPRICE());
        viewHolder.quantity.setText(listLiveData.get(i).getQUANTITY());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list=listLiveData.get(i).getTYPE_();
                String crop=listLiveData.get(i).getCROP_NAME();
                String location=listLiveData.get(i).getLOCATION();
                String price=listLiveData.get(i).getPRICE();
                String quantity=listLiveData.get(i).getQUANTITY();


            }
        });


    }

    @Override
    public int getItemCount() {
        if (listLiveData != null) {
            return listLiveData.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView cropname,location,type,price,quantity;
        CardView cardView;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            cropname = itemView.findViewById(R.id.cropname);
            location = itemView.findViewById(R.id.location);
            type = itemView.findViewById(R.id.type);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            cardView=itemView.findViewById(R.id.cardView1);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(recyclerView, "cotton", Toast.LENGTH_SHORT).show();
        }
    }
}
