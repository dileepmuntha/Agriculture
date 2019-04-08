package com.example.a1234.agriculture;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
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

public class Recyclerasyntask extends AsyncTask<String, Void, String> {

    Recycler recycler;
    String crop ;

    public Recyclerasyntask(Recycler recycler, String source) {

        crop =source;
        this.recycler = recycler;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("data", s);
        List<Bittergourdpozo> data = new ArrayList<>();
        try {


            JSONObject first = new JSONObject(s);
            JSONArray arr = first.getJSONArray(crop);
            for (int i = 0; i <= arr.length(); i++) {

                JSONObject object = arr.getJSONObject(i);
                String s_no = object.getString("S_No");
                String location = object.getString("LOCATION");
                String type = object.getString("TYPE_");
                String price = object.getString("PRICE");
                String quantity = object.getString("QUANTITY");
                Bittergourdpozo obj = new Bittergourdpozo(s_no, location, type, price, quantity);
                data.add(obj);
                Log.d("data", "addes" + data.size());

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("data-->", "" + data.size());


        final StringBuilder buildera = new StringBuilder();
        final StringBuilder actual_msg = new StringBuilder();
        for (int i = 0;i<data.size();i++){
            buildera.append("Location:"+data.get(i).getLOCATION()+"  Type:"+data.get(i).getTYPE_()+"  Price:"+data.get(i).getPRICE()+"  Quantity:"+data
                    .get(i).getQUANTITY()+"\n");
            actual_msg.append(data.get(i).getLOCATION()+":"+data.get(i).getQUANTITY()+"  ");
        }
        Log.i("message:",buildera.toString());
        View view = LayoutInflater.from(recycler).inflate(R.layout.detail_row, null);

        TextView msg = view.findViewById(R.id.messagetext);
        msg.setText(""+buildera.toString());
        final AlertDialog.Builder builder = new AlertDialog.Builder(recycler);
        builder.setTitle("Send Message");
        builder.setMessage("Are you sure want to send the details!!!");
        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(recycler,Recycler.class);
                PendingIntent pi = PendingIntent.getActivity(recycler, 0, i, 0);
                SmsManager smsManager = SmsManager.getDefault();
                Toast.makeText(recycler, ""+buildera.toString(), Toast.LENGTH_SHORT).show();
                String msg = actual_msg.toString();
                smsManager.sendTextMessage("+919492043600", null, ""+msg, pi, null);
                Toast.makeText(recycler, "Sms Sent", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setView(view);

        builder.show();

       /* Intent intent = new Intent(recycler, DetailCropActivity.class);
        intent.putParcelableArrayListExtra("crop_details", (ArrayList<? extends Parcelable>) data);
        recycler.startActivity(intent);
*/
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


}
