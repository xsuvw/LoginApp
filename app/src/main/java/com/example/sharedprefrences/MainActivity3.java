package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {

    String email, pass;
    TextView textView1, textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isuserlogin", true);
        editor.apply();

        email = sharedPreferences.getString("Email", "");
        pass = sharedPreferences.getString("Pass", "");

        textView1 = findViewById(R.id.text2);
        //   textView2 = findViewById(R.id.text3);
        //    textView2.setText(pass);
        textView1.setText(email);
        button = findViewById(R.id.logoutButton);

        button.setOnClickListener(v -> {
            editor.putBoolean("isuserlogin", false);
            editor.commit();

            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
            startActivity(intent);
        });


    }
}
