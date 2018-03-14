package com.example.nbacademy.myapp.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nbacademy.myapp.MainActivity;
import com.example.nbacademy.myapp.R;
import com.example.nbacademy.myapp.database.DBHelper;
import com.example.nbacademy.myapp.database.api.IUser;
import com.facebook.FacebookSdk;
import com.mukeshsolanki.sociallogin.facebook.FacebookHelper;
import com.mukeshsolanki.sociallogin.facebook.FacebookListener;
import com.mukeshsolanki.sociallogin.google.GoogleHelper;
import com.mukeshsolanki.sociallogin.google.GoogleListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity implements FacebookListener, GoogleListener {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @InjectView(R.id.input_email)
    EditText _emailText;
    @InjectView(R.id.input_password)
    EditText _passwordText;
    @InjectView(R.id.btn_login)
    Button _loginButton;
    @InjectView(R.id.link_signup)
    TextView _signupLink;

    FacebookHelper mFacebook;
    GoogleHelper mGoogle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        //social logins

        FacebookSdk.setApplicationId(getResources().getString(R.string.facebook_app_id));
        FacebookSdk.sdkInitialize(this);


        mFacebook = new FacebookHelper(this);

        mGoogle = new GoogleHelper(this, this, null);

        ImageButton btnFacebook = (ImageButton) findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mFacebook.performSignIn(LoginActivity.this);
            }
        });

        ImageButton btnGoogle = (ImageButton) findViewById(R.id.btnGoogle);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mGoogle.performSignIn(LoginActivity.this);
            }
        });

    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


        @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                super.onActivityResult(requestCode, resultCode, data);
                mFacebook.onActivityResult(requestCode, resultCode, data);
                mGoogle.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

//        IUser u = DBHelper.getInstance(null, null, null, 0).findUserByEmail(email);

//        if (password.isEmpty() || password.length()
//                < 4 || password.matches("[A-Za-z0-9]+")) {
//            _passwordText.setError("minimum of 8 alphanumeric characters");
//            valid = false;
//        } else if(u == null || !u.getPassword().equals(password)) {
//            _emailText.setError("Incorrect email or password");
//        }
//        else{
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//
//            _passwordText.setError(null);
//        }



        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

        return valid;
    }

    //Auth Facebook e Google

    @Override
    public void onFbSignInSuccess(String s, String s1){
        Toast.makeText(this, "Academia Março 2018 Crl "+s1, Toast.LENGTH_SHORT).show();
        System.out.println("Sucesso------------------------------------------------");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFbSignInFail(String s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
        System.out.println("fail------------------------------------------------");
    }

    @Override
    public void onFBSignOut(){
        Toast.makeText(this, "Signout!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGoogleAuthSignIn(String s, String s1) {
        Toast.makeText(this, "Academia Março 2018 Crl "+s1, Toast.LENGTH_SHORT).show();
        System.out.println("Sucesso------------------------------------------------");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onGoogleAuthSignInFailed(String s) {
        Toast.makeText(this, "Fogo......"+s, Toast.LENGTH_SHORT).show();
        System.out.println("Fail------------------------------------------------");;
    }

    @Override
    public void onGoogleAuthSignOut() {
        Toast.makeText(this, "Signout", Toast.LENGTH_SHORT).show();
    }



}