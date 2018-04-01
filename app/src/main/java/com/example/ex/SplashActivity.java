package com.example.ex;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final TextView textView = findViewById(R.id.persen);
        final ProgressBar progressBar = findViewById(R.id.progbar);

        new Thread(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(10);
                        textView.setText(i / 10 + "%");
                        progressBar.setProgress(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                textView.setText("Proses Selesai");
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        }).start();
    }
}