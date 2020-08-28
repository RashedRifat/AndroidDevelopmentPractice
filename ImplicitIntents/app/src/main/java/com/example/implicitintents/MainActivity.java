package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;
    private static final String LOG_TAG = "ImplicitIntents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent1 = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent1.resolveActivity(getPackageManager()) !=  null) {
            startActivity(intent1);
        }
        else {
            Log.d(LOG_TAG, "Can't handle URL");
            Toast.makeText(this, "Incorrect Format!", Toast.LENGTH_SHORT).show();
        }

    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent2 = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent2.resolveActivity(getPackageManager()) != null) {
            startActivity(intent2);
        }
        else {
            Log.d(LOG_TAG, "Can't Hnadle this location!");
            Toast.makeText(this, "Unable to handle location!", Toast.LENGTH_SHORT).show();
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setText(txt)
                .startChooser();

    }
}