package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.usernameEditText);
    }

    public void startQuiz(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", usernameEditText.getText().toString());
        startActivity(intent);
    }
}
