package com.androidweardocs.alwayson;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AlwaysOn extends WearableActivity {

    private static final String TAG = "AlwaysOn";

    private TextView mTextView;
    private Integer i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_always_on);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
        // Enable the Always On feature
        setAmbientEnabled();

        i = 1;
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);

        Log.i(TAG, "onEnterAmbient");
        mTextView.setBackgroundColor(Color.BLACK);
        mTextView.getPaint().setAntiAlias(false);
        mTextView.setTextColor(Color.WHITE);

       // mTextView.setText("Hello Ambient");

    }

    @Override
    public void onExitAmbient(){
        Log.i(TAG, "onExitAmbient");
        mTextView.setBackgroundColor(Color.CYAN);
        mTextView.getPaint().setAntiAlias(true);
        mTextView.setTextColor(Color.BLACK);

     //   mTextView.setText("Hello Interactive");
        super.onExitAmbient();
    }

    @Override
    public void onUpdateAmbient() {
        Log.i(TAG, "onUpdateAmbient");
        super.onUpdateAmbient();
        mTextView.setText("Hello Square World! " + i.toString());
        i++;
    }

}


