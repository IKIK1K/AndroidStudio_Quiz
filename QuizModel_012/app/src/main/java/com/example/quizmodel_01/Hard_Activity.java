package com.example.quizmodel_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Hard_Activity extends AppCompatActivity {

    private TextView Question, Score, QuestionNo, Timer, Hint;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;
    int score;

    ColorStateList ikColor;
    boolean answered;
    CountDownTimer countDownTimer;

    private QuestionModel_Hard currentQuestion;
    private List<QuestionModel_Hard> questionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

        questionsList = new ArrayList<>();
        Question = findViewById(R.id.textQuestionNo);
        Score = findViewById(R.id.textScore);
        QuestionNo = findViewById(R.id.textQuestionNo);
        Timer = findViewById(R.id.textTimer);
        Hint = findViewById(R.id.Hint);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        btnNext = findViewById(R.id.btnNext);
        ikColor = rb1.getTextColors();

        addQuestions();
        totalQuestions = questionsList.size();
        showNextQuestion();


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == false) {
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                        countDownTimer.cancel();
                    }else {
                        Toast.makeText(Hard_Activity.this, "Please Select an option", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
        if(answerNo == currentQuestion.getCorrectAnsNo()) {
            score++;
            Score.setText("Score : " +score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if(qCounter < totalQuestions) {
            btnNext.setText("Next");
        }else {
            btnNext.setText("FINISH");
        }
    }

    private void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(ikColor);
        rb2.setTextColor(ikColor);
        rb3.setTextColor(ikColor);
        rb4.setTextColor(ikColor);

        if(qCounter < totalQuestions) {
            timer();
            currentQuestion = questionsList.get(qCounter);
            Question.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            Hint.setText(currentQuestion.getHint());

            qCounter++;
            btnNext.setText("submit");
            QuestionNo.setText("Question : " + qCounter + "/" + totalQuestions);
            answered = false;

        }else {
            finish();

        }
    }

    private void timer() {
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) { Timer.setText(" " + l/1000); }

            @Override
            public void onFinish() { showNextQuestion(); }
        }.start();
    }

    private void addQuestions() {
        questionsList.add(new QuestionModel_Hard("Question is here",
                "option1", "option2", "option3", "option4",
                "hint is here",1));

        questionsList.add(new QuestionModel_Hard("Question is here",
                "option1", "option2", "option3", "option4",
                "hint is here",2));

        questionsList.add(new QuestionModel_Hard("Question is here",
                "option1", "option2", "option3", "option4",
                "hint is here",3));

        questionsList.add(new QuestionModel_Hard("Question is here",
                "option1", "option2", "option3", "option4",
                "hint is here",4));

    }

}
