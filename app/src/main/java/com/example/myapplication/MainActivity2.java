package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.FinalScoreActivity;

public class MainActivity2 extends AppCompatActivity {

    ProgressBar progressBar;
    TextView questionTextView;
    TextView questionNumberTextView;
    Button option1Button, option2Button, option3Button, nextButton, submitButton;
    int currentQuestion = 0;
    int totalQuestions = 5;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progressBar = findViewById(R.id.progressBar);
        questionTextView = findViewById(R.id.questionTextView);
        questionNumberTextView = findViewById(R.id.questionNumberTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        nextButton = findViewById(R.id.nextButton);
        submitButton = findViewById(R.id.submitButton);

        updateQuestion();
    }

    private void updateQuestion() {
        String[] questions = {
                "What does SDK stand for in Android development?",
                "What is an Activity in Android?",
                "What layout do you use to align the children views horizontally?",
                "What is an Intent in Android?",
                "What is the purpose of a Fragment in Android?"
        };
        String[][] options = {
                {"Software Development Kit", "Standard Development Kit", "System Development Kit"},
                {"A single screen with a user interface", "A background process that runs independently", "A type of database in Android"},
                {"LinearLayout", "RelativeLayout", "ConstraintLayout"},
                {"A messaging system between applications", "A representation of an app's user interface", "A component used to perform asynchronous tasks"},
                {"To represent a portion of a user interface or behavior", "To store data locally on the device", "To make network requests"}
        };

        questionTextView.setText(questions[currentQuestion]);
        option1Button.setText(options[currentQuestion][0]);
        option2Button.setText(options[currentQuestion][1]);
        option3Button.setText(options[currentQuestion][2]);

        String questionNumberText = (currentQuestion + 1) + "/" + totalQuestions;
        questionNumberTextView.setText(questionNumberText);

        progressBar.setProgress((currentQuestion + 1) * 100 / totalQuestions);

        nextButton.setVisibility(currentQuestion < totalQuestions - 1 ? View.VISIBLE : View.GONE);

        submitButton.setVisibility(currentQuestion == totalQuestions - 1 ? View.VISIBLE : View.GONE);

        option1Button.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        option2Button.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        option3Button.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        option1Button.setEnabled(true);
        option2Button.setEnabled(true);
        option3Button.setEnabled(true);
    }


    public void submitAnswer(View view) {
        Button selectedOption = (Button) view;
        int[] correctOptions = {0, 1, 2, 0, 0}; // Index of the correct option for each question
        int selectedOptionIndex = -1;
        if (view.getId() == R.id.option1Button) {
            selectedOptionIndex = 0;
        } else if (view.getId() == R.id.option2Button) {
            selectedOptionIndex = 1;
        } else if (view.getId() == R.id.option3Button) {
            selectedOptionIndex = 2;
        }


        if (selectedOptionIndex == correctOptions[currentQuestion]) {

            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            selectedOption.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            score++;
        } else {
            // Incorrect answer
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            selectedOption.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            // Highlight correct answer
            switch (correctOptions[currentQuestion]) {
                case 0:
                    option1Button.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    break;
                case 1:
                    option2Button.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    break;
                case 2:
                    option3Button.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    break;
            }
        }

        option1Button.setEnabled(false);
        option2Button.setEnabled(false);
        option3Button.setEnabled(false);
    }

    public void nextQuestion(View view) {
        currentQuestion++;
        updateQuestion();
    }

    public void submitQuiz(View view) {
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        String username = usernameEditText.getText().toString();


        Toast.makeText(this, "Final Score: " + score + "/" + totalQuestions, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, FinalScoreActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("totalQuestions", totalQuestions);
        intent.putExtra("username", usernameEditText.getText().toString());
        startActivity(intent);
    }

}
