package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UsernameActivity extends AppCompatActivity {

    private EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        user = findViewById(R.id.username_fill);
        setContentView(R.layout.activity_username);
        final Intent intent1 = getIntent();
        Button goPasswordbutton = findViewById(R.id.gopasswordbutton);
        goPasswordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(UsernameActivity.this,PasswordActivity.class);
                startActivity(intent2);
                SharedPreferences pref1 = getSharedPreferences("test", MODE_PRIVATE);
                pref1.edit()
                        .putString("USER",user.getText().toString() )
                        .commit();
                Log.d("MainActivity","NAME:"+user.getText().toString());
            }
        });

    }


}