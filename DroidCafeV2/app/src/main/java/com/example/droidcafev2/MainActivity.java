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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        switch (item.getItemId()){
            case R.id.action_order:
                displayToast(getString(R.string.action_order_message));
                View view = findViewById(R.id.fab);
                showOrders(view);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_order_message));
                return true;
            case R.id.action_favorites:
                if ((donut_count + froyo_count + sandwich_count) == 0){
                    displayToast("You have not yet selected any desserts!");
                    return true; }
                displayToast(fav_order());
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
                //Do nothing
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
        Log.d(LOG_TAG, String.valueOf(view.getId()));
        startActivity(showOrder);
    }

    public String fav_order() {
        if (donut_count > froyo_count && donut_count > sandwich_count)
            return "Your favorite dessert is our donuts!";
        if (froyo_count > donut_count && froyo_count > sandwich_count)
            return "Your favorite dessert is our froyo!";
        if (sandwich_count > froyo_count && sandwich_count > donut_count)
            return "Your favorite dessert is our ice cream sandwiches!";
        return "You like all of our desserts equally!";
    }

}