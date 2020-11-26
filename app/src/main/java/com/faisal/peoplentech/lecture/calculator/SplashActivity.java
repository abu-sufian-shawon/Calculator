package com.faisal.peoplentech.lecture.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressStatus = 1;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressbar);

        countDownTimer = new CountDownTimer(4000, 40) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressStatus += 1;
                progressBar.setProgress(progressStatus);
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();

    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }
}