package com.example.quizapp.Cpp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.R;
import com.example.quizapp.ResultActivity;

public class CPPActivity extends AppCompatActivity {
    TextView tv;
    Button submitButton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String question[] = {
            "1. Who invented C++?",
            "2. What is C++?",
            "3. Which of the following approach is used by C++?",
            "4. Which of the following type is provided by C++ but not C?",
            "5. By default, all the files in C++ are opened in _________ mode."
    };

    String ans[] = {
            "Bjarne Stroustrup",
            "C++ supports both procedural and object oriented programming language",
            "Bottom-up",
            "bool",
            "Text"

    };

    String opt[] = {
            "Dennis Ritchie","Ken Thompson","Brian Kernighan","Bjarne Stroustrup",
            "C++ is an object oriented programming language", "C++ is a procedural programming language", "C++ supports both procedural and object oriented programming language", "C++ is a functional programming language",
            "Left-right", "Right-left", "Bottom-up", "Top-down",
             "double", "float", "int", "bool",
            "Binary", "VTC", "Text", "ISCII"
    };

    int flag = 0;
    public static int marks=0, correct=0, wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cppactivity);

        final TextView score = (TextView) findViewById(R.id.textscore);

        submitButton = (Button) findViewById(R.id.btnnext);
        tv = (TextView) findViewById(R.id.text_ques);

        radio_g = (RadioGroup) findViewById(R.id.radio_group);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton1);
        rb3 = (RadioButton) findViewById(R.id.radioButton2);
        rb4 = (RadioButton) findViewById(R.id.radioButton3);

        tv.setText(question[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radio_g.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(ansText.equals(ans[flag])){
                    correct++;
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(getApplicationContext(),"Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if(score != null)
                    score.setText(""+correct);

                if(flag<question.length){
                    tv.setText(question[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else{
                    marks = correct;
                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(i);
                    finish();
                }
                radio_g.clearCheck();
            }
        });

    }
}