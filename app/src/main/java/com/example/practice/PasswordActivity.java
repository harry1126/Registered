package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        pass = findViewById(R.id.password_fill);
        Intent intent2 = getIntent();
        Button goEmailbutton = findViewById(R.id.goemailbutton);
        goEmailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(PasswordActivity.this, EmailActivity.class);
                startActivity(intent3);
                String password = String.valueOf(pass);
                SharedPreferences pref2 = getSharedPreferences("test1", MODE_PRIVATE);
                pref2.edit()
                        .putString("PASSWORD", password)
                        .commit();
            }

        });
    }

}
