package com.example.textpassagecodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static String passage;
    public static final String PASSAGE = ".com.example.android.textpassagecodingchallenge.extra.PASSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setValueOne(View view) {
        passage = "1";
        displayText(passage);
    }

    public void setValueTwo(View view) {
        passage = "2";
        displayText(passage);
    }

    public void setValueThree(View view) {
        passage = "3";
        displayText(passage);
    }

    public void displayText(String value) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(PASSAGE, value);
        startActivity(intent);
    }
}