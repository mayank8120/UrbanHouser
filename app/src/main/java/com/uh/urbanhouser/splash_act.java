package com.uh.urbanhouser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_act);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_act.this, login_act.class);
                startActivity(intent);
                finish();
            }
        }, 1000);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


    }
}
