package com.longer.creditManager.main;

import android.app.Application;
import android.os.Bundle;

import com.longer.creditManager.R;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import hxz.www.commonbase.app.BaseApplication;
import hxz.www.commonbase.base.mvp.BaseFragment;
import hxz.www.commonbase.util.ToastUtil;
import hxz.www.commonbase.util.fragment.FragmentHelper;
import hxz.www.commonbase.view.tab.CommonTabLayout;
import hxz.www.commonbase.view.tab.listener.CustomTabEntity;
import hxz.www.commonbase.view.tab.listener.OnTabSelectListener;

/**
 * Create by Circle on 2019/7/11
 */
public class MainFragment extends BaseFragment<MainPresenter> implements MainContract.View {

    public static final String KEY_STATE_POSITION = "KEY_STATE_POSITION";

    @BindView(R.id.tabLayout)
    CommonTabLayout tabLayout;

    private long mBackPressTime = 0;
    private int mCurrentPosition = 0;

    private final int[] mIconUnselectIds = {R.mipmap.menu_1, R.mipmap.menu_2, R.mipmap.menu_3, R.mipmap.menu_4};

    private final int[] mIconSelectIds = {
            R.drawable.menu_1_hl,
            R.drawable.menu_2_hl,
            R.drawable.menu_3_hl,
            R.drawable.menu_4_hl};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private BaseFragment[] mFragments = new BaseFragment[mIconSelectIds.length];

    private boolean isReportLocation;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            if (mParams != null && mParams.length > 0) {
                mCurrentPosition = (int) mParams[0];
            }
            mFragments[0] = FragmentHelper.newInstance(DiscoverFragment.class);
            mFragments[1] = FragmentHelper.newInstance(ClubFragment.class);
            mFragments[2] = FragmentHelper.newInstance(ConversationListFragment.class);
            mFragments[3] = FragmentHelper.newInstance(MeFragment.class);
            loadMultipleRootFragment(R.id.fl_container, mCurrentPosition, mFragments);
        } else {
            mFragments[0] = findChildFragment(DiscoverFragment.class);
            mFragments[1] = findChildFragment(ClubFragment.class);
            mFragments[2] = findChildFragment(ConversationListFragment.class);
            mFragments[3] = findChildFragment(MeFragment.class);
            mCurrentPosition = savedInstanceState.getInt(KEY_STATE_POSITION, 0);
        }
        initTab();

        Application.getInstance().getLocationService().start();
    }



    public void setCurrentTab(int position) {
        if (mCurrentPosition == position && tabLayout != null)
            return;
        try {
            tabLayout.setCurrentTab(position);
            showHideFragment(mFragments[position], mFragments[mCurrentPosition]);
            mCurrentPosition = position;
        } catch (Exception e) {

        }
    }

    private void initTab() {
        String[] mTitles = getResources().getStringArray(R.array.main_bottom_tab_titles);
        mTabEntities.clear();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabModel(mTitles[i],
                    mIconSelectIds[i],
                    mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                showHideFragment(mFragments[position], mFragments[mCurrentPosition]);
                mCurrentPosition = position;
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        tabLayout.setCurrentTab(mCurrentPosition);
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_STATE_POSITION, mCurrentPosition);
    }


    @Override
    protected boolean isImmersionBarEnabled() {
        return false;
    }

    @Override
    public boolean onBackPressedSupport() {
        long nowTime = System.currentTimeMillis();
        if (System.currentTimeMillis() - mBackPressTime > 2000) {
            mBackPressTime = nowTime;
            ToastUtil.show(R.string.click_exit_app);
        } else {
            BaseApplication.getInstance().exitApp();

        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



    @Override
    public void reportLocationResult(boolean isSucc) {
        isReportLocation = isSucc;
    }



    @Override
    public void showMsg(String msg) {

    }
}
