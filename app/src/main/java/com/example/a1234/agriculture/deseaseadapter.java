package com.example.a1234.agriculture;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class deseaseadapter  extends RecyclerView.Adapter<deseaseadapter.Hold> {


    List<deseasepozo> data;
    Desease desease;


    public deseaseadapter(Desease desease, List<deseasepozo> data) {

        this.desease = desease;

        this.data = data;
    }
    @NonNull
    @Override
    public deseaseadapter.Hold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.deseasero,viewGroup,false);

        Hold hold=new Hold(view);

        return hold;

    }

    @Override
    public void onBindViewHolder(@NonNull deseaseadapter.Hold hold,final int i) {

        hold.crops.setText(data.get(i).getCrops());
        hold.desease.setText(data.get(i).getCrops_Disease());
        hold.link.setText(data.get(i).getLink());
        hold.cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(data.get(i).getLink()));
                desease.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Hold extends RecyclerView.ViewHolder {
        TextView crops,desease,link;
        CardView cardView5;

        public Hold(@NonNull View itemView) {
            super(itemView);
            crops=itemView.findViewById(R.id.crops);
            desease=itemView.findViewById(R.id.desease);
            link=itemView.findViewById(R.id.link);
            cardView5=itemView.findViewById(R.id.cardView5);


        }
    }
}
