package com.searchandfound.snf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckState extends AppCompatActivity implements View.OnClickListener {

    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_state);

        next = (Button) findViewById(R.id.main_weiterbutton);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == next.findViewById(R.id.main_weiterbutton)){

            Intent next = new Intent(CheckState.this,Homescreen.class);
            startActivity(next);
        }
    }
}
