package com.example.a1234.agriculture;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Adapterschems extends RecyclerView.Adapter<Adapterschems.Hold> {

    List<Sheet2> data;
    Schemes schemes;

    public Adapterschems(Schemes schemes, List<Sheet2> data) {

        this.schemes=schemes;

        this.data=data;

    }

    @NonNull
    @Override
    public Hold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.schemero,viewGroup,false);

        Hold hold=new Hold(view);






        return hold;
    }

    @Override
    public void onBindViewHolder(@NonNull Hold hold,final int i) {
        hold.govschems.setText(data.get(i).getGOVERNMENT_SCHEMES());
      hold.link.setText(data.get(i).getLINK());
      hold.cardView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                      Uri.parse(data.get(i).getLINK()));
              schemes.startActivity(intent);

          }
      });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Hold extends RecyclerView.ViewHolder {
        CardView cardView;

        TextView govschems,link;

        public Hold(@NonNull View itemView) {
            super(itemView);
            govschems = itemView.findViewById(R.id.govschems);
            link =itemView.findViewById(R.id.link);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
