package com.longer.creditManager.main;

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

    private final int[] mIconUnselectIds = {R.mipmap.main_bottom_tab_discover_normal, R.mipmap.main_bottom_tab_club_normal, R.mipmap.main_bottom_tab_message_normal, R.mipmap.main_bottom_tab_me_normal};

    private final int[] mIconSelectIds = {
            R.drawable.anim_list_discover,
            R.drawable.anim_list_club,
            R.drawable.anim_list_msg,
            R.drawable.anim_list_mine};
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

        App.getInstance().getLocationService().start();
    }

    @Override
    public boolean getSwipeBackEnable() {
        return false;
    }

    @Override
    protected boolean registerEventBus() {
        return true;
    }

    public void setCurrentTab(int position) {
        LogUtil.d("setCurrentTab position=" + position + " currentPosition= " + mCurrentPosition + " tabLayout=" + tabLayout);
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
        LogUtil.d("initTab currentPosition=" + mCurrentPosition);
        tabLayout.setCurrentTab(mCurrentPosition);
    }

    @Override
    public void showError(int reqCode, String msg) {

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
        stopLocation();
    }

    private void stopLocation() {
        BaseApplication.getInstance().getLocationService().stop();
    }

    public void setUnreadCount(int count) {
        if (count > 0) {
            tabLayout.showDot(2);
        } else {
            tabLayout.hideMsg(2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLocationEvent(LocationEvent event) {
        if (isReportLocation || !SpCache.getLocationSwitchStat()) {
            return;
        }
        if (event.code == 1) {
            return;
        }

        if (event.code == 0) {
            isReportLocation = true;
            mPresenter.updateLocation(event.location);
        }
    }

    @Override
    public void reportLocationResult(boolean isSucc) {
        isReportLocation = isSucc;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserLocationEvent(UserLocationEvent event) {
        if (event.getOpen()) {
            isReportLocation = false;
        } else {
            mPresenter.updateLocation();
        }
    }


    @Override
    public void showMsg(String msg) {

    }
}
