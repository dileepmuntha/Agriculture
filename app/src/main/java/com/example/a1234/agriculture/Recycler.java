package com.example.a1234.agriculture;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Recycler extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading!!!!!");
        progressDialog.setMessage("Please wait..");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
        progressDialog.show();


        RecyclerTask task=new RecyclerTask(this);
        task.execute("https://script.googleusercontent.com/macros/echo?user_content_key=XE6DfoDh2OPiuq2pX2i" +
                "7y0zJCK53Ii4AU1Pz7wCTL4eh6d1qv4pRvSBf6N7vUJrZKJDuozHfeO29P9Oa-DMDvRZLfzgNpJTNOJmA1Yb3SEsKFZq" +
                "tv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvO" +
                "to09QuWI89K6KjOu0SP2F-BdwUlsd8zNtN2CimY00lFn2LLfUWTw8zQARj6LYR6S6U53BjGxKbitwCip8s9yopbmD-5y" +
                "7FLqOV0Tk27B8Rh4QJTQ&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva");






    }
}


