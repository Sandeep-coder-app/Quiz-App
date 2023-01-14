package com.example.quizapp.c;

import androidx.appcompat.app.AppCompatActivity;

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

public class CPage extends AppCompatActivity {
TextView tv;
Button submitButton;
RadioGroup radio_g;
RadioButton rb1,rb2,rb3,rb4;

String question[] = {
        "1. Who is the father of C language?",
        "2. All keywords in C are in ____________",
        "3. How many number of pointer (*) does C have against a pointer variable declaration?",
        "4. Which of the following cannot be a variable name in C?",
        "5. What is short int in C programming?",
        "6. What is the result of logical or relational expression in C?",
         "7. What is an example of iteration in C?",
        "8. Property which allows to produce different executable for different platforms in C is called?",
        "9. C preprocessors can have compiler specific features.",
        "10. When a C program is started, O.S environment is responsible for opening file and providing pointer for that file?",
};

String ans[] = {
      "Dennis Ritchie",
        "LowerCase letters",
        "No limits",
        "volatile",
        "Short is the qualifier and int is the basic data type",
        "0 or 1",
        "all of the mentioned",
        "Conditional compilation",
        "true",
        "All of the mentioned"
    };

String opt[] = {
        "Steve Jobs", "James Gosling", "Dennis Ritchie", "Rasmus Lerdorf",
        "LowerCase letters", "UpperCase letters", "CamelCase letters", "None of the mentioned",
        "7","127", "255", "No limits",
        "volatile","true","friend","export",
        "The basic data type of C", "Qualifier", "Short is the qualifier and int is the basic data type", "All of the mentioned",
         "True or False", "0 or 1", "0 if an expression is false and any positive number if an expression is true", "None of the mentioned",
        "for", "while", "do=while", "all of the mentioned",
        "File inclusion", "Selective inclusion", "Conditional compilation", "Recursive macros",
        "True", "False", "Depends on the standard", "Depends on the platform",
        "Standard input", "Standard output", "Standard error", "All of the mentioned",
};

int flag = 0;
public static int marks=0, correct=0, wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpage);

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