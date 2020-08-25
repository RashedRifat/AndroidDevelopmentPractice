package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class second_activity extends AppCompatActivity {
    public static final String TEXT_REQUEST = "Text_Request";
    private static final String LOG_TAG = second_activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void confirm(View view) {
        Intent replyIntent = new Intent(this, MainActivity.class);
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        Log.d("Main --> Second", buttonText);
        replyIntent.putExtra(TEXT_REQUEST, buttonText);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}