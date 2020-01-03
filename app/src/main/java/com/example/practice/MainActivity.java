package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private TextView mail;
    private int REQUEST_CODE=100;
    private Intent intent1;
    private String userid;
    private String passwordid;
    private String emailid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        Button button = findViewById(R.id.into);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1 = new Intent(MainActivity.this, UsernameActivity.class);
                startActivityForResult(intent1,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == REQUEST_CODE) {
            if (resultCode != RESULT_OK) {
                finish();
            }else{
                userid = getSharedPreferences("test", MODE_PRIVATE)
                        .getString("USER", "1");
                passwordid = getSharedPreferences("test1", MODE_PRIVATE)
                        .getString("PASSWORD", "1");
                emailid = getSharedPreferences("test2", MODE_PRIVATE)
                        .getString("EMAILBOX", "1");
                username.setText(userid+"");
                password.setText(passwordid+"");
                mail.setText(emailid+"");
                Log.d("MainActivity","name:"+userid+"");
            }

        }


    }

}

