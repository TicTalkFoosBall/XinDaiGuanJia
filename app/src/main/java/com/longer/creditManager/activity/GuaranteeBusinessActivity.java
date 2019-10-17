package com.longer.creditManager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.longer.creditManager.R;
import com.longer.creditManager.util.AndroidBug54971Workaround;

/**
 *
 * 担保业务
 */
public class GuaranteeBusinessActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_message; // 客户信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guaranteebusiness);
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);

        tv_message = findViewById(R.id.tv_message);
        tv_message.setOnClickListener(this);


    }

        @Override
        public void onClick(View v) {

                startActivity(new Intent(this,CustomerInformationcompanyActivity.class));


        }

}
