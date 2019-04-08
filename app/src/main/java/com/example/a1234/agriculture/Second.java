package com.example.a1234.agriculture;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Second extends AppCompatActivity {
    EditText Gmail;
    EditText password;
    EditText mobileno;
    String phone;
    EditText adharnumber;
    EditText confirmpassword;
    FirebaseDatabase database;
    List<Database> registerdata;


    DatabaseReference myRef;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Gmail = findViewById(R.id.mail);
        password = findViewById(R.id.pass);
        mobileno = findViewById(R.id.mobile);
        confirmpassword = findViewById(R.id.cpass);
        adharnumber = findViewById(R.id.adhar);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();


        myRef = database.getReference("Registers");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {


                  phone = dataSnapshot1.child("mphoneno").getValue(String.class);
            Toast.makeText(Second.this, "" + mobileno, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

             //  Toast.makeText(Forgetpassword.this, "No ID Found", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void register(View view) {
        if (adharnumber.getText().toString().length() != 12) {

            adharnumber.setError("it Not a Valid Aadhaar");


        } else if (mobileno.getText().toString().length() != 10) {

            mobileno.setError("it's not a Valid Mobile No");
        } else if (password.getText().toString().length() != 6) {

            password.setError("Enter 6Dig Password");

        } else if (confirmpassword.getText().toString().length() != 6) {
            confirmpassword.setError("Enter 6Dig Password");
        } else if (!password.getText().toString().equals(confirmpassword.getText().toString())) {

            confirmpassword.setError("Miss match PASSWORD");
        } else {
            String mgmail=Gmail.getText().toString();
             String mpassword=password.getText().toString();
            String mconfirmpassword=confirmpassword.getText().toString();
             String maadhar=adharnumber.getText().toString();
              String mphoneno=mobileno.getText().toString();

            Map<String,Object> map = new HashMap<>();
            map.put("Gmail",mgmail);
               map.put("Password",mpassword);
              map.put("Confirmpassword",mconfirmpassword);
              map.put("Aadhar", maadhar);
              map.put("Mobileno", mphoneno);
              myRef.child(mphoneno).setValue(map);
             // Gmail.getText().clear();
            //  password.getText().clear();
            //  confirmpassword.getText().clear();
             // adharnumber.getText().clear();
           //  mobileno.getText().clear();


            final ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setTitle("Register!!!!!");
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


            mAuth.createUserWithEmailAndPassword(mgmail, mpassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()) {
                                Toast.makeText(Second.this, "Register successful", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(Second.this, Nav.class);
//                                startActivity(intent);

                            } else {
                                Toast.makeText(Second.this, "Register unsuccessful", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(Second.this, Nav.class);
//                                startActivity(intent);

                            }
                        }
                    });

            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Third.class);
            startActivity(intent);
        }

    }
}
