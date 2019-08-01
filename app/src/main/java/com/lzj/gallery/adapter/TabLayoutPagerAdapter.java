package com.lzj.gallery.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lzj on 2019/7/3
 * Describe ：注释
 */
public class TabLayoutPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    public TabLayoutPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    /**
     * //此方法用来显示tab上的名字
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
