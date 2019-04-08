package com.example.a1234.agriculture;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SharedMemory;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

import static com.example.a1234.agriculture.R.string.app_name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
       ActionBar actionBar=getSupportActionBar();
       loadLocale();
       //actionBar.setTitle(""+getResources().getString(app_name));
        Button ChangeLang = findViewById(R.id.changeMyLang);
        ChangeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });
    }

    public void button(View view) {
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    public void thirdsign(View view) {
        Intent intent = new Intent(this, Third.class);
        startActivity(intent);
    }


    private void showChangeLanguageDialog() {
        final String[] listitems = {"తెలుగు", "English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {
                    setLocale("te");
                    recreate();
                } else if (i == 1) {
                    setLocale("en");
                    recreate();
                }
                //dismiss alert dialog when language is selected
                dialogInterface.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
        //show  alert dialog
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor= getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("MY_LANG",lang);
        editor.apply();
    }
    public void loadLocale(){
        SharedPreferences pres= getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language =pres.getString("MY_LANG","");
        setLocale(language);
    }
}

