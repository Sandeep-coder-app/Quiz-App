package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.Cpp.CPPActivity;
import com.example.quizapp.c.CPage;

public class Homepage extends AppCompatActivity {
    int[] images = {R.drawable.c,R.drawable.c,R.drawable.java,R.drawable.javascript,R.drawable.python, R.drawable.sql};

    String[] texts = {"C language","C++ Language","java","javaScript","Python","Sql"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ListView listView = findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),images,texts);
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        Context context;
        int[] images;
        String[] texts;
        LayoutInflater inflater;

        public CustomAdapter(Context context, int[] images, String[] texts) {
            this.context = context;
            this.images = images;
            this.texts = texts;
            inflater = (LayoutInflater.from(getApplicationContext()));
        }

        @Override
        public int getCount() {
            return texts.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.custom_list, null );

            ImageView imageView =view.findViewById(R.id.image);
            TextView textView = view.findViewById(R.id.text_view);


            imageView.setImageResource(images[i]);

            textView.setText(texts[i]);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (i){
                        case 0:
                            Toast.makeText(getApplicationContext(),"C language", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), CPage.class);
                            startActivity(i);
                            finish();
                            break;

                        case 1:
                            Toast.makeText(getApplicationContext(),"C++ language", Toast.LENGTH_SHORT).show();
                            Intent sc = new Intent(getApplicationContext(), CPPActivity.class);
                            startActivity(sc);
                            finish();
                            break;

                        case 2:
                            Toast.makeText(getApplicationContext(),"java", Toast.LENGTH_SHORT).show();
                            break;

                        case 3:
                            Toast.makeText(getApplicationContext(),"javaScript", Toast.LENGTH_SHORT).show();
                            break;

                        case 4:
                            Toast.makeText(getApplicationContext(),"Python", Toast.LENGTH_SHORT).show();
                            break;

                        case 5:
                            Toast.makeText(getApplicationContext(),"Sql", Toast.LENGTH_SHORT).show();
                            break;

                    }
                }
            });
            return view;
        }

    }
}