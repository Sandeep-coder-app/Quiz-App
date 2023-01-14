package com.example.quizapp.Cpp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp.Homepage;
import com.example.quizapp.R;
import com.example.quizapp.c.CPage;

public class Result1Activity extends AppCompatActivity {
    TextView tv,tv2, tv3;
    Button btnexit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);

        tv = (TextView) findViewById(R.id.tvres1);
        tv2 = (TextView) findViewById(R.id.tvres2);
        tv3 = (TextView) findViewById(R.id.tvres3);
        btnexit = (Button) findViewById(R.id.btnexit);

        StringBuffer sb = new StringBuffer();
        sb.append(""+ CPage.correct+"\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append(""+CPage.wrong+"\n");

        StringBuffer sb3 = new StringBuffer();
        sb3.append(""+CPage.correct+"\n");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        CPPActivity.correct = 0;
        CPPActivity.wrong = 0;

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Homepage.class);
                startActivity(i);

            }
        });
    }
}