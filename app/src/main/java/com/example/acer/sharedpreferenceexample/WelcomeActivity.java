package com.example.acer.sharedpreferenceexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    private Button logoutButton;
    private SharedPreferences sharedPreferences;
    private static final String PREF_KEY_NUMBER="number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        sharedPreferences=getSharedPreferences(PREF_KEY_NUMBER, Context.MODE_PRIVATE);




        logoutButton=(Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                Intent loginIntent=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });

    }

}
