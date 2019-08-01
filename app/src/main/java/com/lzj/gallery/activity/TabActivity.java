package com.lzj.gallery.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lzj.gallery.R;
import com.lzj.gallery.adapter.TabLayoutPagerAdapter;
import com.lzj.gallery.fragment.TabFragmentOne;
import com.lzj.gallery.fragment.TabFragmentTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lzj on 2019/8/1
 * Describe ：Fragment中使用
 */
public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabLayoutPagerAdapter mAdapter;
    List<Fragment> fragments;
    private String[] titles = new String[]{"最新", "专栏"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        initTabLayout();
        initFragment();
    }

    /**
     * 初始化tab标签
     */
    private void initTabLayout() {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);// MODE_FIXED 表示固定; MODE_SCROLLABLE 表示可滚动
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); //对齐方式，必须将tabMode设置为MODE_FIXED才有效
        for (int i = 0; i < titles.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titles[i]));
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("test","------点击--------"+tab);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * 初始化 Fragment
     * tablayout和ViewPager关联动
     */
    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(TabFragmentOne.getInstance());
        fragments.add(TabFragmentTwo.getInstance());


        mAdapter  = new TabLayoutPagerAdapter(getSupportFragmentManager(),this,fragments, Arrays.asList(titles));
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);//此方法就是让tablayout和ViewPager联动
    }
}
