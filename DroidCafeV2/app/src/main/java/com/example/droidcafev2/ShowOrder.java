package com.example.droidcafev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.droidcafev2.MainActivity.*;

public class ShowOrder extends AppCompatActivity {
    TextView ordered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int donut_count, froyo_count, sandwich_count;
        setContentView(R.layout.activity_show_order);
        ordered = findViewById(R.id.showOrder);
        Intent orders = getIntent();
        donut_count = orders.getIntExtra(MainActivity.DONUT, 0);
        froyo_count = orders.getIntExtra(MainActivity.FROYO, 0);
        sandwich_count = orders.getIntExtra(SANDWICH, 0);
        Log.d("LOG_TAG", String.valueOf(donut_count));
        StringBuilder orderMessage = new StringBuilder();
        orderMessage.append("Your orders are listed below.\n\nYou have ordered ").append(String.valueOf(donut_count)).append(" donuts.");
        orderMessage.append("\nYou have ordered ").append(String.valueOf(froyo_count)).append(" froyo's.");
        orderMessage.append("\nYou have ordered ").append(String.valueOf(sandwich_count)).append(" ice-cream sandwiches.");
        Log.d("LOG_TAG", String.valueOf(orderMessage));
        ordered.setText(orderMessage);
    }

    public void cancel(View view) {
        finish();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                Log.e("Show Order Activity", "Radio Button Case not matched");
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}