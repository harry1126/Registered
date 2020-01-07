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
    private int REQUEST_CODE_USERACTIVITY=100;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        mail = findViewById(R.id.email);
        button = findViewById(R.id.into);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, UsernameActivity.class);
                startActivityForResult(intent1,REQUEST_CODE_USERACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == REQUEST_CODE_USERACTIVITY) {
            if (resultCode != RESULT_OK) {
                finish();
            }else{
                String userid = getSharedPreferences("test", MODE_PRIVATE)
                        .getString("USER", "");
                String passwordid = getSharedPreferences("test", MODE_PRIVATE)
                        .getString("PASSWORD", "");
                String emailid = getSharedPreferences("test", MODE_PRIVATE)
                        .getString("EMAILBOX", "");

                username.setText(userid);
                password.setText(passwordid);
                mail.setText(emailid);
                button.setVisibility(View.INVISIBLE);
//                Log.d("MainActivity","name:"+userid+"");
//                Log.d("MainActivity","password:"+passwordid+"");
//                Log.d("MainActivity","email:"+emailid+"");
            }

        }


    }

}

