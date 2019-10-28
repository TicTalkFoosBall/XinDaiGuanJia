package com.longer.creditManager;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;


import com.longer.creditManager.buinese.BusinessFragment;
import com.longer.creditManager.home.HomeFragment;
import com.longer.creditManager.fragment.MyFragment;
import com.longer.creditManager.notice.ClientFragment;
import com.longer.creditManager.util.AndroidBug54971Workaround;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import hxz.www.commonbase.baseui.BaseActivity2;

/**
 *
 *  主Activity
 *  APP 入口
 */
public class MainActivity extends BaseActivity2 {
    private ViewPager vp;
    private BottomNavigationView bnv;
    private List<Fragment> fragments = new ArrayList<>();
    private FragMentAdapter adapter; // fragment适配器

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content),this);

        vp = findViewById(R.id.vp);
        bnv = findViewById(R.id.bnv);
        adapter = new FragMentAdapter(getSupportFragmentManager());


        fragments.add(new HomeFragment()); // 首页
        fragments.add(new ClientFragment());// 客户
        fragments.add(new BusinessFragment()); //  业务
        fragments.add(new MyFragment());//  我的

        initView();
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(4);
    }


    private void initView() {

//        if (AndroidWorkaround.checkDeviceHasNavigationBar(this)) {
//            AndroidWorkaround.assistActivity(findViewById(android.R.id.content));
//        }
        disableShiftMode(bnv);
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
                    case R.id.navigation_client :

                            vp.setCurrentItem(1);
                        return true;
                    case R.id.navigation_business :

                        vp.setCurrentItem(2);
                        return true;
                    case R.id.navigation_my:

                        vp.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });

    }


//    @Override
//    protected boolean checkDeviceHasNavigationBar(Context context) {
//        boolean hasNavigationBar = false;
//        Resources rs = context.getResources();
//        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
//        if (id > 0) {
//            hasNavigationBar = rs.getBoolean(id);
//        }
//        try {
//            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
//            Method m = systemPropertiesClass.getMethod("get", String.class);
//            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
//            if ("1".equals(navBarOverride)) {
//                hasNavigationBar = false;
//            } else if ("0".equals(navBarOverride)) {
//                hasNavigationBar = true;
//            }
//        } catch (Exception e) {
//
//        }
//        return hasNavigationBar;
//
//    }

    @Override
    public void showError(int reqCode, String msg) {

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


    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
