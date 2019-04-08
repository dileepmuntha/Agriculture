package com.example.a1234.agriculture;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Holder> {

    Recycler recycler;

    List<Croppozo> data;
    public RecycleAdapter(Recycler recyclerTask, List<Croppozo> data) {
        this.data=data;
        this.recycler=recyclerTask;
    }

    @NonNull
    @Override
    public RecycleAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerlayout,viewGroup,false);

        Holder holder=new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.Holder holder, final int i) {

        holder.name.setText(data.get(i).getCrop_name());
      //  holder.image.setText(data.get(i).getImage_url());
       // holder.link.setText(data.get(i).getSource_link());


      /*  Picasso.with(recycler).load("\n" +
                "https://docs.google.com/uc?id="+data.get(i).getImage_url()).into(holder.image);*/

        Glide.with(recycler).load("https://docs.google.com/uc?id="+data.get(i).getImage_url())
                .placeholder(R.drawable.available)
                .into(holder.image);

      holder.cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("data",data.get(i).getSource_link());
                String source = data.get(i).getCrop_name();
                Recyclerasyntask task = new Recyclerasyntask(recycler,source);
                task.execute(data.get(i).getSource_link());
              //  Toast.makeText(recycler, ""+data.get(i).getSource_link(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView name,link;
        ImageView image;
        CardView cardView2;
    

        public Holder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
           link =itemView.findViewById(R.id.link);
            image=itemView.findViewById(R.id.image);
            cardView2=itemView.findViewById(R.id.cardView2);    
            

        }
    }
}
