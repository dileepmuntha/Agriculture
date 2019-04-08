package com.example.a1234.agriculture;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    DetailCropActivity detailCropActivity;
    ArrayList<Bittergourdpozo> list;

    public DetailAdapter(DetailCropActivity detailCropActivity, ArrayList<Bittergourdpozo> list) {
        this.detailCropActivity = detailCropActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(detailCropActivity).inflate(R.layout.detail_row,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.location.setText(list.get(i).getLOCATION());
        viewHolder.type.setText(list.get(i).getTYPE_());
        viewHolder.price.setText(list.get(i).getPRICE());
        viewHolder.quantity.setText(list.get(i).getQUANTITY());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView location;
        TextView type;
        TextView price;
        TextView quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          /*  location=itemView.findViewById(R.id.locatid);
            type=itemView.findViewById(R.id.typeid);
            price=itemView.findViewById(R.id.priceid);
            quantity=itemView.findViewById(R.id.quantityid);*/
        }
    }
}
