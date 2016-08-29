package com.example.joketelleractivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;


public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

//        AdView mAdView = (AdView) this.findViewById(R.id.adView);
//        // Create an ad request. Check logcat output for the hashed device ID to
//        // get test ads on a physical device. e.g.
//        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//        mAdView.loadAd(adRequest);


        Intent intent = getIntent();
        String jokeMsg = intent.getStringExtra("JOKE");

        TextView textView = (TextView) findViewById(R.id.joke_teller_activity_layout_textview);
        textView.setText(jokeMsg);
    }
}
