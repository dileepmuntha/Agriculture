package com.example.a1234.agriculture;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Desease extends AppCompatActivity {
    RecyclerView recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desease);
        recy = findViewById(R.id.desease);
        recy.setLayoutManager(new LinearLayoutManager(this));
        gatherData();
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
    }

    private void gatherData() {
        Deseasetask deseasetask = new Deseasetask(this);
        deseasetask.execute("https://script.googleusercontent.com/macros/echo?user_content_key=Vt1whIb-nu-P7UsEx2rLUlTj891RDo3L9573h_6xLRobiVrdSyocZ5NzBQ0bOQXohW9vRkStSYVJRo6lgEXi365QYvWRvozJOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUW8vduI4y_TZDbr7jTHhL_FnJC6RHrqHM7SZ70ULEnWk5EkOuY8K8S0Rrile7zAHl5y7FLqOV0Tk27B8Rh4QJTQ&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva");
    }
}
