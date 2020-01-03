package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        email = findViewById(R.id.email_fill);
        Intent intent4 = getIntent();
        Button gobackbutton = findViewById(R.id.goback);
        gobackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(EmailActivity.this,MainActivity.class);
                startActivity(intent5);
                setResult(RESULT_OK);
                String emailbox = String.valueOf(email) ;
                SharedPreferences pref3 = getSharedPreferences("test2", MODE_PRIVATE);
                pref3.edit()
                        .putString("EMAILBOX", emailbox)
                        .commit();
                finish();
            }
        });
    }

}
