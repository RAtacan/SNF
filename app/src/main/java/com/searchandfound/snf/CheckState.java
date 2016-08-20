package com.searchandfound.snf;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.searchandfound.snf.Models.Authentication;
import com.searchandfound.snf.Models.AuthenticationResponse;
import com.searchandfound.snf.Models.RegisterResponse;
import com.searchandfound.snf.Utils.APIBuilder;
import com.searchandfound.snf.Utils.Prefs;
import com.searchandfound.snf.Utils.SearchAndFoundStrings;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class CheckState extends AppCompatActivity implements View.OnClickListener {

    private String email, password;
    private TextView username;
    private EditText passwordField;
    private Button loginButton, registerrButton;
    private ProgressBar loginProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getString("checkedEmail") != null) {

                email = bundle.getString("checkedEmail");
                setContentView(R.layout.activity_check_state2);
                instanciateView(0, email);

            } else {

                email = bundle.getString("unregisteredMail");
                setContentView(R.layout.activity_check_state);
                instanciateView(1, email);
            }

        }
    }

    private void instanciateView(int i, String email) {

        if (i == 0) {

            username = (TextView) findViewById(R.id.username);
            username.setText(email);
            loginProgress = (ProgressBar) findViewById(R.id.login_progressbar);
            loginProgress.setVisibility(View.GONE);
            passwordField = (EditText) findViewById(R.id.password);
            loginButton = (Button) findViewById(R.id.loginbutton);
            loginButton.setOnClickListener(this);

        } else {

            username = (TextView) findViewById(R.id.register_username);
            loginProgress = (ProgressBar) findViewById(R.id.register_progressbar);
            loginProgress.setVisibility(View.GONE);
            passwordField = (EditText) findViewById(R.id.password);
            registerrButton = (Button) findViewById(R.id.register_weiterbutton);
            registerrButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!(username.getText().toString().equals(null) && passwordField.getText().toString().equals(null))){

                        if(passwordField.getText().toString().trim().length() >= 4){

                            registerUser();

                        }else{
                            Toast.makeText(CheckState.this,"Bitte mehr als 4 Zeichen für das Passwort!",Toast.LENGTH_SHORT);
                        }

                    }

                }
            });

        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == loginButton.getId()) {

            password = passwordField.getText().toString();

            if (!password.equals(null)) {
                loginProgress.setVisibility(View.VISIBLE);
                checkPassword(password);

            } else {

                Toast.makeText(CheckState.this, this.getResources().getString(R.string.nopw), Toast.LENGTH_SHORT);

            }

        }

    }

    private void checkPassword(final String pw) {

        Call<AuthenticationResponse> call = (Call) APIBuilder.getInstance().getService().authenticate(email, pw);
        call.enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Response<AuthenticationResponse> response, Retrofit retrofit) {

                if (response.body().getMeta().getCode() == 200) {
                    loginProgress.setVisibility(View.GONE);
                    Authentication auth = response.body().getAuth();
                    Prefs.save(CheckState.this, SearchAndFoundStrings.EMAIL, email);
                    Prefs.save(CheckState.this, SearchAndFoundStrings.PASSWORD, pw);
                    saveAuth(auth);
                    Intent intent = new Intent(CheckState.this, Homescreen.class);
                    startActivity(intent);
                    finish();
                } else {

                    loginProgress.setVisibility(View.GONE);

                }

            }

            @Override
            public void onFailure(Throwable t) {


            }
        });

    }
    public void registerUser(){

        Call<RegisterResponse> call = (Call) APIBuilder.getInstance().getService().register(username.getText().toString(),
                                         passwordField.getText().toString(),email);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Response<RegisterResponse> response, Retrofit retrofit) {

                if(response.body().getMeta().getCode() == 200){
                    loginProgress.setVisibility(View.GONE);
                    String email = response.body().getEmail();
                    Intent intent = new Intent(CheckState.this,CheckState.class);
                    intent.putExtra("checkedEmail",email);
                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onFailure(Throwable t) {

                loginProgress.setVisibility(View.GONE);

            }
        });

    }

    private void saveAuth(Authentication auth) {

        Prefs.save(this, SearchAndFoundStrings.AUTHENTICATION_ID, Integer.toString(auth.getId()));
        Prefs.save(this, SearchAndFoundStrings.AUTHENTICATION_ID, auth.getAuthToken());
        Prefs.save(this, SearchAndFoundStrings.LOCATION, auth.getLocation());
        Prefs.save(this, SearchAndFoundStrings.USERNAME, auth.getUsername());

    }
}
