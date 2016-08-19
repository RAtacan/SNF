package com.searchandfound.snf;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.searchandfound.snf.Models.EmailRequest;
import com.searchandfound.snf.Utils.APIBuilder;
import com.searchandfound.snf.Utils.Helper;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import retrofit.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEnter;
    private Button next;
    private ProgressBar emailProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        emailEnter = (EditText) findViewById(R.id.main_email);
        emailProgress = (ProgressBar)findViewById(R.id.main_progressBar);
        emailProgress.setVisibility(View.GONE);
        next = (Button) findViewById(R.id.main_weiterbutton);
        next.setOnClickListener(this);

        if (!Helper.isNetworkAvailable(this)) {

            Toast.makeText(this, getResources().getString(R.string.main_checkConnect), Toast.LENGTH_SHORT);

            //TODO: Aktualisierungsbutton einbauen, entweder BTN oder per Scrollgeste refresh der Activity

            return;

        }

        //TODO: Check if User already logged in... In Progress after creating Login Class

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        if(v == next.findViewById(R.id.main_weiterbutton)){

            if(!this.emailEnter.getText().toString().equals(null) && this.emailEnter.getText().toString().trim().contains("@")){

                checkEmailExisting(this.emailEnter.getText().toString().trim());

            }else{

                Toast.makeText(this,getResources().getString(R.string.main_checkInput),Toast.LENGTH_SHORT);

            }




            Intent next = new Intent(MainActivity.this,CheckState.class);
            startActivity(next);
        }
    }
    public void checkEmailExisting(String email){

        String mail = email;

        Call<EmailRequest> call = (Call) APIBuilder.getInstance().getService().checkMail(mail);
        call.enqueue(new Callback<EmailRequest>() {
            @Override
            public void onResponse(Response<EmailRequest> response, Retrofit retrofit) {

                

            }

            @Override
            public void onFailure(Throwable t) {



            }
        });

    }
}
