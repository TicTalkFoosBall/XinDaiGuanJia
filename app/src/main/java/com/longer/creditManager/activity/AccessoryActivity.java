package com.longer.creditManager.activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.longer.creditManager.R;
import com.longer.creditManager.util.AndroidBug54971Workaround;

import hxz.www.commonbase.base.mvp.BaseActivity;


/**
 *
 * 客户附件
 *
 */
public class AccessoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_accessory);
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);
    }

    @Override
    protected boolean checkDeviceHasNavigationBar(Context context) {
        return false;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
