package com.example.a1234.agriculture;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Fourth extends AppCompatActivity {
    private EditText forgetpassword;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        forgetpassword = findViewById(R.id.forgetpassword);
        resetPassword = findViewById(R.id.resetPassword);
        firebaseAuth = FirebaseAuth.getInstance();
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail = forgetpassword.getText().toString().trim();
                if (useremail.equals("")) {
                    Toast.makeText(Fourth.this, "please enter your registered email_id", Toast.LENGTH_LONG).show();
                } else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {

                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Fourth.this, "password reset email sent", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(Fourth.this, Third.class));
                            } else {
                                Toast.makeText(Fourth.this, "Error in sending password reset email", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}



