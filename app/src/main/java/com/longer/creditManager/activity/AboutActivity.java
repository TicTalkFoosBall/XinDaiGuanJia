package com.longer.creditManager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.longer.creditManager.R;
import com.longer.creditManager.util.AndroidBug54971Workaround;

import hxz.www.commonbase.baseui.BaseActivity2;


public class AboutActivity extends BaseActivity2 {

    private ImageView back;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        back=findViewById(R.id.iv_back_about2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void showError(int reqCode, String msg) {

    }
}
