package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OnBoarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isonboardshow", true);
        editor.apply();

        Button button = findViewById(R.id.onboardbutton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(OnBoarding.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}