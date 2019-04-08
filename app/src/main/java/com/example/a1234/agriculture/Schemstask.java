package com.example.a1234.agriculture;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Schemstask extends AsyncTask<String,Void,String> {

Schemes schemes;
    public Schemstask(Schemes schemes) {

        this.schemes=schemes;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream stream = con.getInputStream();
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String line = "";
            while (line != null) {
                line = reader.readLine();
                buffer.append(line);
            }
            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return null;
    }


    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

       // Toast.makeText(schemes, ""+s, Toast.LENGTH_SHORT).show();

        List<Sheet2> data = new ArrayList<>();


        try {
            JSONObject first = new JSONObject(s);

            JSONArray arr = first.getJSONArray("Sheet1");

            for (int i = 0; i < arr.length(); i++) {
                JSONObject object = arr.getJSONObject(i);

                String GOVERNMENT_SCHEMES    = object.getString("GOVERNMENT_SCHEMES");
                Log.d("gov",GOVERNMENT_SCHEMES);

                String LINK = object.getString("LINK");
                Log.d("gov",LINK);

                Sheet2 obj;

                obj = new Sheet2(GOVERNMENT_SCHEMES,LINK);

                data.add(obj);

            }

         //   Toast.makeText(schemes, ""+data.size(), Toast.LENGTH_SHORT).show();
            schemes.recyclerView.setAdapter(new Adapterschems(schemes,data));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
