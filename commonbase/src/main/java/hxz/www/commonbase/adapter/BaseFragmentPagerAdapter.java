package hxz.www.commonbase.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] titles;
    private Fragment[] fragments;

    public BaseFragmentPagerAdapter(FragmentManager fm, Fragment[] fragments, String... titles) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return titles == null ? 0 : titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
