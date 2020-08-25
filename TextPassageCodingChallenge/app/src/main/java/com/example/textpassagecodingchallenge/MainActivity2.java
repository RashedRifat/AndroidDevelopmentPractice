package com.example.textpassagecodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    private static TextView passageView;
    private static TextView passageHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        passageView = findViewById(R.id.passage_content);
        passageHeader = findViewById(R.id.passage_header);
        display();

    }

    protected void display() {
        Intent intent = getIntent();
        String passage = intent.getStringExtra(MainActivity.PASSAGE);
        assert passage != null;
        if (passage.equals("1")) {
            passageView.setText(R.string.content_one);
            passageHeader.setText(R.string.title_one);
        }
        else if (passage.equals("2")) {
            passageView.setText(R.string.content_two);
            passageHeader.setText(R.string.title_two);
        }
        else if (passage.equals("3")){
            passageView.setText(R.string.content_three);
            passageHeader.setText(R.string.title_three);
        }
        else {
            Log.e("MainActivity2", "Display Error");}
        passageView.setVisibility(View.VISIBLE);
    }

    public void go_back(View view) {
        finish();
    }
}

