package com.example.acer.sharedpreferenceexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText,passwordEditText;
    private CheckBox rememberMeCheckBox;
    private Button loginButton;

    private static final String PREF_KEY_NUMBER="number";
    private static final String PREF_CREDENTIAL_USERNAME="default_username";
    private static final String PREF_CREDENTIAL_PASSWORD="default_password";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences=getSharedPreferences(PREF_KEY_NUMBER, Context.MODE_PRIVATE);
        if (isValueExist()==true){
            Intent welcomeIntent=new Intent(LoginActivity.this,WelcomeActivity.class);
            startActivity(welcomeIntent);
        }
        else {

            Toast.makeText(this, "Value Empty you need to login again", Toast.LENGTH_SHORT).show();
        }

        usernameEditText=(EditText) findViewById(R.id.usernameEditText);
        passwordEditText=(EditText) findViewById(R.id.passwordEditText);
        rememberMeCheckBox=(CheckBox) findViewById(R.id.remembermeCheckBox);
        loginButton=(Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=usernameEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                if(rememberMeCheckBox.isChecked()){
                    sharedPreferences.edit().putString(PREF_CREDENTIAL_USERNAME,username).apply();
                    sharedPreferences.edit().putString(PREF_CREDENTIAL_PASSWORD,password).apply();
                    Intent welcomeIntent=new Intent(LoginActivity.this,WelcomeActivity.class);
                    startActivity(welcomeIntent);
                }
            }
        });

    }
    private boolean isValueExist(){
        return sharedPreferences.contains(PREF_CREDENTIAL_USERNAME)&&
        sharedPreferences.contains(PREF_CREDENTIAL_PASSWORD);

    }
}
