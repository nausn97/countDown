package com.tapplent.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CountDownActivity extends AppCompatActivity {
    ProgressBar _progressBar;
    TextView _progText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        _progressBar = (ProgressBar) findViewById(R.id.circularProgressBar);
        _progText = (TextView) findViewById(R.id.textView1);
        _progressBar.setProgress(30);

        startTimer(1, _progressBar, _progText);

        _progText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer(1, _progressBar, _progText);

            }
        });
    }

    private void startTimer(final int minuti, final ProgressBar barTimer, final TextView textTimer) {
        CountDownTimer countDownTimer = new CountDownTimer(60 * minuti * 1000, 500) {
            // 500 means, onTick function will be called at every 500 milliseconds

            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = leftTimeInMilliseconds / 1000;
                barTimer.setProgress((int) seconds);
                textTimer.setText(String.format("%02d", seconds / 60) + ":" + String.format("%02d", seconds % 60));
                // format the textview to show the easily readable format

            }

            @Override
            public void onFinish() {
                if (textTimer.getText().equals("00:00")) {
                    textTimer.setText("STOP");
                } else {
                    textTimer.setText("2:00");
                    barTimer.setProgress(60 * minuti);
                }
            }
        }.start();

    }
}
