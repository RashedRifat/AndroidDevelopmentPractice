package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  int mScore1 = 0;
    private int mScore2 = 0;
    private TextView mTextView1;
    private TextView mTextView2;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView1 = (TextView) findViewById(R.id.score_1);
        mTextView2 = (TextView) findViewById(R.id.score_2);

        // If the device has rotated, get the appropriate values
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            // Set the scores
            mTextView1.setText(String.valueOf(mScore1));
            mTextView2.setText(String.valueOf(mScore2));
        }
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else {
            menu.findItem(R.id.night_mode).setTitle((R.string.night_mode));
        }
        return true;
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the Scores.
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}