package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  int mScore1 = 0;
    private int mScore2 = 0;
    private TextView mTextView1;
    private TextView mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView1 = (TextView) findViewById(R.id.score_1);
        mTextView2 = (TextView) findViewById(R.id.score_2);
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();

        switch (viewID) {
            case R.id.decreaseTeam1:
                if (mScore1 == 0){
                    Toast.makeText(this, "Score cannot be lower than zero!", Toast.LENGTH_SHORT).show();
                    break;
                }
                mScore1--;
                mTextView1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                if (mScore2 == 0){
                    Toast.makeText(this, "Score cannot be lower than zero!", Toast.LENGTH_SHORT).show();
                    break;
                }
                mScore2--;
                mTextView2.setText(String.valueOf(mScore2));
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();

        switch (viewID){
            case R.id.increaseTeam1:
                mScore1++;
                mTextView1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mTextView2.setText(String.valueOf(mScore2));
        }
    }
}