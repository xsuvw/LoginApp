package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        EditText editText1 = findViewById(R.id.et_email);
        EditText editText2 = findViewById(R.id.et_password);
        Button button = findViewById(R.id.btn_register);
        Button button2 = findViewById(R.id.btn_login_instead);


        if (sharedPreferences.contains("isuserlogin")) {
            boolean isuserlogin = sharedPreferences.getBoolean("isuserlogin", false);
            if (isuserlogin) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        } else {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
        button.setOnClickListener(v -> {

            String email = editText1.getText().toString();
            String pass = editText2.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Email", email);
            editor.putString("Pass", pass);
            editor.apply();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

    }
}