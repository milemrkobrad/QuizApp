package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //get score value from previous activity
        String score = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score  = String.valueOf(extras.getInt("SCORE"));
            //The key argument here must match that used in the other activity
        };
        //show score
        TextView scoreTextView = (TextView) findViewById(R.id.score_textview);
        scoreTextView.setText(score + "/5");

        // 1) How to replace link by text like "Click Here to visit Google" and
        // the text is linked with the website url ?
        TextView link = (TextView) findViewById(R.id.moreInfo_textview);
        String linkText = "To find more interesting facts about Nikola Tesla visit <a href='https://en.wikipedia.org/wiki/Nikola_Tesla'>Wikipedia</a>";
        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
