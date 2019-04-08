package com.example.a1234.agriculture;

import android.os.AsyncTask;
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

public class RecyclerTask extends AsyncTask<String, Void, String> {

    Recycler recycler;

    public RecyclerTask(Recycler recycler) {

        this.recycler = recycler;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connectionn = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connectionn.getInputStream();

            StringBuffer buffer = new StringBuffer();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

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
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        List<Croppozo> data = new ArrayList<>();


        try {
            JSONObject first = new JSONObject(s);
            JSONArray arr = first.getJSONArray("Sheet1");

            for (int i = 0; i <= arr.length(); i++) {
                JSONObject object = arr.getJSONObject(i);
                String name = object.getString("Crop_name");
                String imge = object.getString("Image_url");
                String sourceLink = object.getString("Source_link");


                Croppozo obj = new Croppozo(name, imge, sourceLink);

                data.add(obj);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(recycler, "" + data.size(), Toast.LENGTH_SHORT).show();

        recycler.recyclerView.setAdapter(new RecycleAdapter(recycler, data));


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
