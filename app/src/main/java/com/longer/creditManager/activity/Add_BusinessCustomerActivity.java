package com.longer.creditManager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.longer.creditManager.R;
import com.longer.creditManager.util.AndroidBug54971Workaround;


public class Add_BusinessCustomerActivity extends AppCompatActivity {
    TextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add__business_customer);
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);
    }
}
