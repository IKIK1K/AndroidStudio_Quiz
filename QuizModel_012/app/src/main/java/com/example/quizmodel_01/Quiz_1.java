package com.example.quizmodel_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Quiz_1 extends AppCompatActivity {

    Button btnhint, btnCorrectAnswer, btnWrongAnswer1, btnWrongAnswer2, btnWrongAnswer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_form);

        Button btnQuizCollect = (Button)findViewById(R.id.btnCorrectAnswer);
        Button btnWrongAnswer1 = (Button)findViewById(R.id.btnWrongAnswer1);
        Button btnWrongAnswer2 = (Button)findViewById(R.id.btnWrongAnswer2);
        Button btnWrongAnswer3 = (Button)findViewById(R.id.btnWrongAnswer3);
        Button btnHint = (Button)findViewById(R.id.btnHint);



        btnQuizCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnWrongAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Try again...", Toast.LENGTH_LONG).show();
            }
        });

        btnWrongAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Try again...", Toast.LENGTH_LONG).show();
            }
        });

        btnWrongAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Try again...", Toast.LENGTH_LONG).show();
            }
        });

        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hint is here...", Toast.LENGTH_LONG).show();
            }
        });



    }
}
