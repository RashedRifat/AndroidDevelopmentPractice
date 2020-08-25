package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button zeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView);
        zeroButton = (Button) findViewById(R.id.clearButton);
    }

    public void show_toast(View view) {
        Toast message = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG);
        message.show();
    }

    public void count_up(View view) {
        ++mCount;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        if (mCount % 2 == 0) {
            mShowCount.setBackgroundColor(Color.YELLOW);
        }
        else {
            mShowCount.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        if (mCount > 0) {
            zeroButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    public void clearAll(View view) {
        mCount = 0;
        mShowCount.setText(R.string.default_value);
        zeroButton.setBackgroundColor(getResources().getColor(R.color.gray));
        mShowCount.setBackgroundColor(Color.YELLOW);
    }


}