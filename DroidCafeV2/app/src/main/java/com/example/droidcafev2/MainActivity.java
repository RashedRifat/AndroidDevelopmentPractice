package com.example.droidcafev2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String DONUT = "DONUT_COUNT";
    public static final String FROYO = "FROYO";
    public static final String SANDWICH = "SANDWICH";
    private int donut_count, froyo_count, sandwich_count;
    private static final String LOG_TAG = "LOG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(LOG_TAG, "IS THIS WORKING?");
        FloatingActionButton fab = findViewById(R.id.fab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void show_donut(View view) {
        donut_count += 1;
        displayToast(getString(R.string.show_donut));
    }

    public void show_froyo(View view) {
        froyo_count += 1;
        displayToast(getString(R.string.show_froyo));
    }

    public void show_sandwich(View view) {
        sandwich_count += 1;
        displayToast(getString(R.string.show_sandwich));
    }

    public void showOrders(View view) {
        Intent showOrder = new Intent(this, ShowOrder.class);
        showOrder.putExtra(DONUT, donut_count);
        showOrder.putExtra(FROYO, froyo_count);
        showOrder.putExtra(SANDWICH, sandwich_count);
        Log.d(LOG_TAG, "Starting Activity");
        startActivity(showOrder);
    }
}