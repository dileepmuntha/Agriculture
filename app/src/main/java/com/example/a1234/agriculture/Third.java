package com.example.a1234.agriculture;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Third extends AppCompatActivity {
    EditText username, password;
    GoogleSignInClient mGoogleSignInClient;
    SignInButton signInButton;
    private FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        username = findViewById(R.id.user);
        password = findViewById(R.id.psw);
        mauth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                //.requestIdToken("944872665035-eojiplgq019o6t4thq8oj7n8nhjf48os.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton = findViewById(R.id.mybutton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Third.this, "clicked", Toast.LENGTH_SHORT).show();
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 101);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 101) {
            // Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
         //   handleSignInResult(task);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                e.printStackTrace();
                Log.i("exe", "Error msg:" + e.getMessage());
            }


        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            String idToken = account.getIdToken();

            // TODO(developer): send ID Token to server and validate

            Log.i("exe", "token" + idToken);
            // updateUI(account);
        } catch (ApiException e) {
            Log.i("exe", "handleSignInResult:error", e);
            // updateUI(null);
        }
    }

    public void forget(View view) {
        Intent intent = new Intent(this, Fourth.class);
        startActivity(intent);
    }

    public void sign(View view) {

        if (TextUtils.isEmpty(username.getText().toString())) {

            username.setError("it Not a Valid gmail");
        } else if (TextUtils.isEmpty(password.getText().toString())) {

            password.setError("Enter 6Dig Password");
        } else {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Login!!!!!");
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


            String user = username.getText().toString();
            String psw = password.getText().toString();


            // Toast.makeText(this, ""+user, Toast.LENGTH_SHORT).show();
            // Toast.makeText(this, ""+psw, Toast.LENGTH_SHORT).show();
            mauth.signInWithEmailAndPassword(user, psw)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Third.this, "Login successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Third.this, Nav.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Third.this, "Invalid username or pasword", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.i("exe", "" + account.getEmail());
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mauth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mauth.getCurrentUser();
                            Intent intent = new Intent(getApplicationContext(), Nav.class);
                            startActivity(intent);

                            Toast.makeText(getApplicationContext(), "User login successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Not login user", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

}


