package com.example.a1234.agriculture;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class Schemes extends AppCompatActivity {
   // String url ="https://script.googleusercontent.com/macros/echo?user_content_key=flTDw0TBZDP8rLThZuAEtpN60fO_tiuhRMW5ZP2HmleTVB3enJl4ThvL2HFIPf3z-NZvUL7hOb-8I7cANQLM2NebS3ejcNMxOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUAkGI3C6WPkX3gVkr877UMIr__gIYlSwBJF7VsRtqFW8kmYH6wMYU4NYWOvoTwl975y7FLqOV0Tk27B8Rh4QJTQ&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva";
    RecyclerView recyclerView;
    DataViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes);
        viewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        recyclerView = findViewById(R.id.schemes);
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

        gatherData();
    }

    private void gatherData() {

        //final List<Sheet1> listLiveData = viewModel.getList();


       Schemstask schemstask=new Schemstask(this);

        schemstask.execute("https://script.googleusercontent.com/macros/echo?user_content_key=18sJ1mgez2T9FoeubLpwkH" +
                "iwqg6xMZVjZFicj7Wn7k2ybKQSan8VIUUGCH_uPcQsAyT4-aIHyUl8qRgKfkd4duiFGjGeMHEWOJmA1Yb3SEsKFZqtv3DaNYcMrmhZ" +
                "HmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUAkGI3" +
                "C6WPkX3gVkr877UMI" +
                "r__gIYlSwBJF7VsRtqFW8kmYH6wMYU4NYWOvoTwl975y7FLqOV0Tk27B8Rh4QJTQ&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva");

    }
}
