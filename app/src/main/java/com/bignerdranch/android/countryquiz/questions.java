package com.bignerdranch.android.countryquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class questions extends AppCompatActivity {


    ImageView imageView;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mResultTextView;

    public int getCorrect() {
        return correct;
    }

    public int correct =0;
    public int incorrect =0;


    private Countries[] mCountriesBank = new Countries[] {
            new Countries(R.drawable.greece, R.string.greece),
            new Countries(R.drawable.us, R.string.us),
            new Countries(R.drawable.mex, R.string.mexico),
            new Countries(R.drawable.rus, R.string.russia)
    };


    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        mResultTextView = findViewById(R.id.textView);


        Button button1 = (Button) findViewById(R.id.answer1);
        button1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.string.russia);
            }
        }));

        Button button2 = (Button) findViewById(R.id.answer2);
        button2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.string.mexico);
            }
        }));

        Button button3 = (Button) findViewById(R.id.answer3);
        button3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.string.greece);
            }
        }));

        Button button4 = (Button) findViewById(R.id.answer4);
        button4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.string.us);
            }
        }));




        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Log.d("countryquiz", "test print");
//                int newNum =1;
//                mCurrentIndex = newNum +1;

                if (mCurrentIndex < mCountriesBank.length-1){
                    mCurrentIndex = (mCurrentIndex +1); // % mCountriesBank.length;
                    updateCountry();
                } else {
                    Intent intent = new Intent(questions.this, result.class);
                    intent.putExtra("key1", correct);
                    intent.putExtra("key2", incorrect);
                    startActivity(intent);
                }


            }});


        mPrevButton = (Button) findViewById(R.id.previous_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex -1) % mCountriesBank.length;
                if (mCurrentIndex < 0) {
                    mCurrentIndex += mCountriesBank.length;
                }
                updateCountry();
            }});

        updateCountry();

    }


    private void updateCountry(){
        int country = mCountriesBank[mCurrentIndex].getFlagImageId();
        imageView = findViewById(R.id.image_country);
        imageView.setImageDrawable(getResources().getDrawable(country));

//        int question = mCountriesBank[mCurrentIndex].getTextResId();
//        imageView.setText(question);


//        imageView = findViewById(R.id.image_country);
//        imageView.setImageDrawable(getResources().getDrawable(R.drawable.us));
//        imageView.setImageDrawable(getResources().getDrawable(R.drawable.greece));
    }



    private void checkAnswer(int userChoice) {
        int correctAnswer = mCountriesBank[mCurrentIndex].getTextResId();
        int messageResId = 0;
//        int correct = 0;
//        int incorrect = 0;

        if (userChoice == correctAnswer) {
            messageResId = R.string.correct_toast;
            correct++;
//            Log.d("countryquiz", "correct");
//            System.out.println(correct);

        } else {
            messageResId = R.string.incorrect_toast;
            incorrect ++;
        }
//        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

        mResultTextView.setText(messageResId);
//        mResultTextView.setText(incorrect);
//        mResultTextView.setText(correct);
    }
}
