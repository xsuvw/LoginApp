package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    MainActivity mainActivity;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        //  TextView textView = findViewById(R.id.textview);
        Button button = findViewById(R.id.btn_login);
        Button button2 = findViewById(R.id.btn_register_first);

        button.setOnClickListener(v -> {

            editText1 = findViewById(R.id.lemail);
            editText2 = findViewById(R.id.lpassword);
            String lemail = editText1.getText().toString();
            String lpassword = editText2.getText().toString();

            if (sharedPreferences.contains("Email")) {
                String email;
                String pass;

                email = sharedPreferences.getString("Email", "");
                pass = sharedPreferences.getString("Pass", "");

                if (lemail.equals(email) && lpassword.equals(pass)) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                } else {
//                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
//                        startActivity(intent);
                    Toast.makeText(MainActivity2.this, "Please Register First", Toast.LENGTH_SHORT).show();
                }

            } else {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
        });

    }
}

