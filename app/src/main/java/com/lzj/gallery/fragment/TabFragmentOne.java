package com.lzj.gallery.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzj.gallery.R;
import com.lzj.gallery.adapter.RecyclerViewAdpter;
import com.lzj.gallery.library.views.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzj on 2019/8/1
 * Describe ：注释
 */
public class TabFragmentOne extends Fragment {
    /**
     * 单例
     */
    private static volatile TabFragmentOne instance = null;
    public static TabFragmentOne getInstance() {
        if (instance == null) {
            synchronized (TabFragmentOne.class) {
                if (instance == null) {
                    instance = new TabFragmentOne();
                }
            }
        }
        return instance;
    }
    private View mRootView;
    RecyclerView recyclerView;
    BannerViewPager banner;
    List<String> urlList;
    List<String> list;
    RecyclerViewAdpter mViewAdpter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_one, container, false);
        initData();
        initAdpter();
        return mRootView;
    }

    /**
     * 模拟数据
     */
    private void initData() {
        urlList = new ArrayList<>();
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543221773&di=c63f30c7809e518cafbff961bcd9ec2a&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0116605851154fa8012060c8587ca1.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042541&di=3ad9deeefff266e76d1f5d57a58f63d1&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F69%2F99%2F66%2F9fce5755f081660431464492a9aeb003.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042539&di=95bd41d43c335e74863d9bb540361906&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019a0558be22d6a801219c77d0578a.jpg%402o.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586013578881&di=3fe60f355e63e0b15aa59e6f3597b2a8&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F34%2F07%2F16pic_3407117_b.jpg");

        list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("你好"+i);
        }
    }

    private void initAdpter() {
        recyclerView=mRootView.findViewById(R.id.recyclerView);
        mViewAdpter=new RecyclerViewAdpter(getActivity(),list,urlList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//listview效果
        recyclerView.setAdapter(mViewAdpter);
//
//        View header=LayoutInflater.from(getActivity()).inflate(R.layout.tab_item_header,recyclerView,false);
//        mViewAdpter.addHeaderView(header);
//        mViewAdpter.notifyDataSetChanged();

    }
}
