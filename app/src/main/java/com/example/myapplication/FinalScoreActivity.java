package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class FinalScoreActivity extends AppCompatActivity {

    TextView scoreTextView;
    Button startAgainButton, finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        scoreTextView = findViewById(R.id.scoreTextView);
        startAgainButton = findViewById(R.id.startAgainButton);
        finishButton = findViewById(R.id.finishButton);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int score = intent.getIntExtra("score", 0);

        scoreTextView.setText("Congratulations , "  +username+ "! Your final score is: " + score);
    }

    public void startAgain(View view) {
        Intent intent = new Intent(FinalScoreActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void finishActivity(View view) {
        finish();
    }
}