package com.example.quizapp;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Loginpage extends AppCompatActivity {
EditText userid,pass;
Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        Login();
    }
    void Login(){
        userid = findViewById(R.id.userid);
        pass = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userid.getText().toString().equals("admin") && pass.getText().toString().equals("gaurav")){
                    Toast.makeText(Loginpage.this,"Username and password is correct",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Loginpage.this, Homepage.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(Loginpage.this,"Username and password is incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}