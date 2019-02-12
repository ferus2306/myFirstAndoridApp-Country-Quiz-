package com.bignerdranch.android.countryquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;


public class result extends AppCompatActivity {
    TextView mCorrect;
    TextView mIncorrect;
    EditText mEditName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

//        ================================================


        Intent intent = getIntent();


        mCorrect = (TextView)findViewById(R.id.incorrect);
        int value1 = intent.getIntExtra("key1", 0);
        mCorrect.setText(String.valueOf("Correct " +value1));

        mIncorrect = (TextView)findViewById(R.id.correct);
        int value2 = intent.getIntExtra("key2", 0);
        mIncorrect.setText(String.valueOf(" Incorrect " + value2 ));

    }

}