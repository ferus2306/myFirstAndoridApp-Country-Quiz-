package com.bignerdranch.android.countryquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

//    ImageView imageView;
    Button mStartButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mStartButton = (Button)findViewById(R.id.start_button);
            mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // Jumps tp the game page
                Intent intent = new Intent(MainActivity.this, questions.class);
                startActivity(intent);

            }
        });

    }
}
