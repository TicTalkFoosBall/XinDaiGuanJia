package com.longer.creditManager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.os.Bundle;


import com.longer.creditManager.util.AndroidBug54971Workaround;


import hxz.www.commonbase.base.mvp.BaseActivity;

public class Main3Activity extends BaseActivity {
    @Override
    protected boolean checkDeviceHasNavigationBar(Context context) {
        return false;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);


    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main3;
    }
}
