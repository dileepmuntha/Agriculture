package com.example.a1234.agriculture;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.a1234.agriculture.Desease;
import com.example.a1234.agriculture.deseaseadapter;
import com.example.a1234.agriculture.deseasepozo;

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

class Deseasetask extends AsyncTask<String,Void,String> {

    Desease desease;
    public Deseasetask(Desease desease){

        this.desease = desease;

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
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Toast.makeText(desease, ""+s, Toast.LENGTH_SHORT).show();
        List<deseasepozo> data = new ArrayList<>();
        try {
            JSONObject first = new JSONObject(s);

            JSONArray arr = first.getJSONArray("Sheet1");

            for (int i = 0; i < arr.length(); i++) {
                JSONObject object = arr.getJSONObject(i);

                String Crops = object.getString("Crops");
                Log.d("crops", Crops);

                String Crops_Disease = object.getString("Crops_Disease");
                Log.d("cropsdesease", Crops_Disease);
                String Link = object.getString("Link");
                Log.d("link", Link);
                deseasepozo obj;

                obj = new deseasepozo( Crops,Crops_Disease,Link);

                data.add(obj);

            }

            Toast.makeText(desease, ""+data.size(), Toast.LENGTH_SHORT).show();
            desease.recy.setAdapter(new deseaseadapter(desease,data));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
