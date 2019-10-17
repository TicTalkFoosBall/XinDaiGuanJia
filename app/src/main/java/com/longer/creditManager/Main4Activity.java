package com.longer.creditManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.longer.creditManager.util.AndroidBug54971Workaround;


public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);

    }
}
