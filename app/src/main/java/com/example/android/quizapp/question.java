package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;

public class question extends AppCompatActivity {

    private int questionNo = 1;
    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionNo = 1;
        setQuestion1();
    }

    //display image, question and possible answers
    private void displayQuestionAnswer(int image, String question, String answerA, String answerB, String answerC) {
        ImageView imgView = (ImageView) findViewById(R. id.question_image);
        imgView.setImageResource(image);

        TextView questionTextView = (TextView) findViewById(R.id.question_textview);
        questionTextView.setText(question);

        Button answerABtn = (Button) findViewById(R.id.answerA_btn);
        answerABtn.setText(answerA);

        Button answerBBtn = (Button) findViewById(R.id.answerB_btn);
        answerBBtn.setText(answerB);

        Button answerCBtn = (Button) findViewById(R.id.answerC_btn);
        answerCBtn.setText(answerC);
    }

    //image, question and answers definition
    private void setQuestion1() {
        displayQuestionAnswer(R.drawable.q1, getResources().getString(R.string.question1), getResources().getString(R.string.answer1a), getResources().getString(R.string.answer1b), getResources().getString(R.string.answer1c));
    }

    private void setQuestion2() {
        displayQuestionAnswer(R.drawable.q2, getResources().getString(R.string.question2), getResources().getString(R.string.answer2a), getResources().getString(R.string.answer2b), getResources().getString(R.string.answer2c));
    }

    private void setQuestion3() {
        displayQuestionAnswer(R.drawable.q3, getResources().getString(R.string.question3), getResources().getString(R.string.answer3a), getResources().getString(R.string.answer3b), getResources().getString(R.string.answer3c));
    }

    private void setQuestion4() {
        displayQuestionAnswer(R.drawable.q4, getResources().getString(R.string.question4), getResources().getString(R.string.answer4a), getResources().getString(R.string.answer4b), getResources().getString(R.string.answer4c));
    }

    private void setQuestion5() {
        displayQuestionAnswer(R.drawable.q5, getResources().getString(R.string.question5), getResources().getString(R.string.answer5a), getResources().getString(R.string.answer5b), getResources().getString(R.string.answer5c));
    }

    //on button click event- when user answering question check if answer is correct
    public void answerA_btn_click(View v) {
        int qNo = 1;
        switch (questionNo) {
            case 1:
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                setQuestion2();
                score += 1;
                qNo = 2;
                break;

            case 2:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                setQuestion3();
                qNo = 3;
                break;

            case 3:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                setQuestion4();
                qNo = 4;
                break;

            case 4:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                setQuestion5();
                qNo = 5;
                break;

            case 5:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                callScoreActivity();
                break;

        }
        questionNo = qNo;
    }

    public void answerB_btn_click(View v) {
        int qNo = 1;
        switch (questionNo) {
            case 1:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                setQuestion2();
                qNo = 2;
                break;

            case 2:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                setQuestion3();
                qNo = 3;
                break;

            case 3:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                setQuestion4();
                qNo = 4;
                break;

            case 4:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                setQuestion5();
                qNo = 5;
                break;

            case 5:
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                score += 1;
                callScoreActivity();
                break;

        }
        questionNo = qNo;
    }

    public void answerC_btn_click(View v) {
        int qNo = 1;
        switch (questionNo) {
            case 1:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                setQuestion2();
                qNo = 2;
                break;

            case 2:
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                score += 1;
                setQuestion3();
                qNo = 3;
                break;

            case 3:
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                score += 1;
                setQuestion4();
                qNo = 4;
                break;

            case 4:
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                score += 1;
                setQuestion5();
                qNo = 5;
                break;

            case 5:
                Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                callScoreActivity();
                break;

        }
        questionNo = qNo;
    }

    //go to score activity, after answering on last question
    private void callScoreActivity(){
        Intent myIntent = new Intent(question.this, score.class);
        myIntent.putExtra("SCORE", score);
        question.this.startActivity(myIntent);
        finish();
    }
}
