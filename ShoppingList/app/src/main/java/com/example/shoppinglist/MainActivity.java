package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<EditText> IDList = new ArrayList<>();
    private static final int LogRequest = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String STRING_TAG = "GET EDITTEXT STRINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout myTextView = findViewById(R.id.EditTextView);
        for( int i = 0; i < myTextView.getChildCount(); i++ )
            if( myTextView.getChildAt(i) instanceof EditText ) {
                IDList.add((EditText) myTextView.getChildAt(i)); }
        Log.d(LOG_TAG, String.valueOf(IDList.size()));

        if (savedInstanceState != null) {
            ArrayList<String> allStrings = savedInstanceState.getStringArrayList(STRING_TAG);
            if (!allStrings.isEmpty()) {
                for (int index = 0; index < allStrings.size(); index++) {
                    IDList.get(index).setText(allStrings.get(index));
                }
            }
        }

    }

    public void launchSecondActivity(View view) {
        Intent getCommonItem = new Intent(this, second_activity.class);
        startActivityForResult(getCommonItem, LogRequest);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ArrayList<String> texts = getEditText();
        if (!texts.isEmpty()) {
            outState.putStringArrayList(STRING_TAG, texts); }
        }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LogRequest) {
            if (resultCode == RESULT_OK) {
                String buttonText = data.getStringExtra(second_activity.TEXT_REQUEST);
                //Find an EditText that has not yet been used.
                for (int index = 0; index < IDList.size(); index++) {
                    if (TextUtils.isEmpty(IDList.get(index).getText().toString())) {
                        IDList.get(index).setText(buttonText);
                        return;
                    }
                }
                Toast.makeText(this, "Shopping list full! Unable to add item...", Toast.LENGTH_LONG).show();
            }
        }
    }

    private ArrayList<String> getEditText() {
        ArrayList<String> texts = new ArrayList<>();
        if (IDList.isEmpty()) {
            Log.d(LOG_TAG, "IDList is Empty when calling GetEditText");
            return texts;
        }
        for (int index  = 0; index < IDList.size(); index++) {
            EditText sample = IDList.get(index);
            if (sample.getText() != null) {
                texts.add(sample.getText().toString());
            }
        }
        Log.d(LOG_TAG, "EditText Strings Successfully Logged");
        return texts;
    }
}