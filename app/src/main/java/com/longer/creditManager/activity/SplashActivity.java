package com.longer.creditManager.activity;

import android.content.Intent;
import android.os.Bundle;

import com.longer.creditManager.MainActivity;
import com.longer.creditManager.R;
import com.longer.creditManager.login.LoginActivity;

import hxz.www.commonbase.baseui.BaseActivity2;
import hxz.www.commonbase.cache.Cache;


public class SplashActivity extends BaseActivity2 {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        if (Cache.isLogin()) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }
        finish();
    }


    @Override
    public void showError(int reqCode, String msg) {

    }
}
