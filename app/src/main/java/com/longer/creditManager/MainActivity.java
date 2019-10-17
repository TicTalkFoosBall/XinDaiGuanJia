package com.longer.creditManager;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;


import com.longer.creditManager.fragment.Address_ListFragment;
import com.longer.creditManager.fragment.BusinessFragment;
import com.longer.creditManager.fragment.ClientFragment;
import com.longer.creditManager.fragment.HomeFragment;
import com.longer.creditManager.fragment.MyFragment;
import com.longer.creditManager.util.AndroidBug54971Workaround;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import hxz.www.commonbase.base.mvp.BaseActivity;

/**
 *
 *  主Activity
 *  APP 入口
 */
public class MainActivity extends  BaseActivity {
    private ViewPager vp;
    private BottomNavigationView bnv;
    private List<Fragment> fragments = new ArrayList<>();
    private FragMentAdapter adapter; // fragment适配器



    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);

        vp = findViewById(R.id.vp);
        bnv = findViewById(R.id.bnv);
        adapter = new FragMentAdapter(getSupportFragmentManager());


        fragments.add(new HomeFragment()); // 首页
        fragments.add(new Address_ListFragment());// 通讯录
        fragments.add(new ClientFragment());// 客户
        fragments.add(new BusinessFragment()); //  业务
        fragments.add(new MyFragment());//  我的

        initView();
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(4);

       // loginYun();

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    private void initView() {

//        if (AndroidWorkaround.checkDeviceHasNavigationBar(this)) {
//            AndroidWorkaround.assistActivity(findViewById(android.R.id.content));
//        }

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bnv.getMenu().getItem(i).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        bnv.setItemIconTintList(null);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home :

                        vp.setCurrentItem(0);
                       return true;
                    case R.id.navigation_list :

                        vp.setCurrentItem(1);
                        return true;
                    case R.id.navigation_client :

                        vp.setCurrentItem(2);
                        return true;
                    case R.id.navigation_business :

                        vp.setCurrentItem(3);
                        return true;
                    case R.id.navigation_my:

                        vp.setCurrentItem(4);
                        return true;
                }
                return false;
            }
        });




    }


    @Override
    protected boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;

    }



    class FragMentAdapter extends FragmentPagerAdapter{

        public FragMentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }





}
