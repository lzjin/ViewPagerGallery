package com.lzj.gallery.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lzj.gallery.R;
import com.lzj.gallery.library.views.BannerViewPager;

import java.util.List;

public class RecyclerViewAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context context;
    public List<String> datas;
    public List<String> urls;
    private boolean isShow;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;


    public RecyclerViewAdpter(Context context, List<String> datas, List<String> url) {
        this.context = context;
        this.datas = datas;
        this.urls = url;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_NORMAL;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //头部轮播
        if (viewType==TYPE_HEADER){
            View headerView = LayoutInflater.from(context).inflate(R.layout.tab_item_header, parent, false);
            return new HeaderViewHolder(headerView);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        switch (getItemViewType(position)){
            case TYPE_HEADER:
                if (!isShow) {
                    ((HeaderViewHolder) viewHolder).bannerx.initBanner(urls, true)//关闭3D画廊效果
                            .addPageMargin(10, 50)//参数1page之间的间距,参数2中间item距离边界的间距
                            .addPointMargin(6)//添加指示器
                            .addPointBottom(7)
                            .finishConfig()//这句必须加
                            .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                                @Override
                                public void onBannerClick(int position) {
                                }
                            });
                    isShow=true;
                }
                break;
            case TYPE_NORMAL:
                ((ViewHolder)viewHolder).tv.setText(datas.get(position - 1));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return  datas.size() + 1;
    }


    static  class HeaderViewHolder extends RecyclerView.ViewHolder {
        BannerViewPager bannerx;
        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerx=itemView.findViewById(R.id.item_header_banner);
        }
    }

    //继承RecyclerView.ViewHolder抽象类的自定义ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }


}