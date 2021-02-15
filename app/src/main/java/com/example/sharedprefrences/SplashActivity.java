package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        new Handler().postDelayed(() -> {

            if (sharedPreferences.contains("isonboardshow")) {
                boolean isonboardshow = sharedPreferences.getBoolean("isonboardshow", false);
                if (isonboardshow) {

                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            } else {
                Intent intent = new Intent(SplashActivity.this, OnBoarding.class);
                startActivity(intent);
            }

            finish();
        }, 3000);

    }

}