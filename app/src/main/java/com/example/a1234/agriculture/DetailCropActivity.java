package com.example.a1234.agriculture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class DetailCropActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_crop);

        recyclerView = findViewById(R.id.crop_recycler);

        ArrayList<Bittergourdpozo> list = getIntent().getParcelableArrayListExtra("crop_details");

        Log.i("size:",""+list.size());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DetailAdapter(this,list));
    }
}
