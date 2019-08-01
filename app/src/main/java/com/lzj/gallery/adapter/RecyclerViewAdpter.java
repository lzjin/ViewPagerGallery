package com.lzj.gallery.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzj.gallery.R;
import com.lzj.gallery.library.views.BannerViewPager;

import java.util.List;

public class RecyclerViewAdpter extends RecyclerView.Adapter<RecyclerViewAdpter.ViewHolder> {
    public  Context context;
    public List<String> datas;
    public List<String> urls;

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    public BannerViewPager banner;
    private View mHeaderView;
    public RecyclerViewAdpter(Context context, List<String> datas,List<String> url) {
        this.context = context;
        this.datas = datas;
        this.urls=url;
    }

    public void addHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }


    @Override
    public int getItemViewType(int position) {
        if(mHeaderView != null&&position == 0){
            return TYPE_HEADER;
        }
        else {
            return TYPE_NORMAL;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         //头部轮播
        if(mHeaderView != null && viewType == TYPE_HEADER) {
            mHeaderView=LayoutInflater.from(context).inflate(R.layout.tab_item_header,parent,false);
            return new ViewHolder(mHeaderView);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) {
            banner=mHeaderView.findViewById(R.id.item_header_banner);
            banner.initBanner(urls, false)//关闭3D画廊效果
                    .addPageMargin(0, 0)//参数1page之间的间距,参数2中间item距离边界的间距
                    .addPoint(6)//添加指示器
                    .addPointBottom(7)
                    .finishConfig()//这句必须加
                    .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                        @Override
                        public void onBannerClick(int position) {
                        }
                    });
            return;
        }
        else {
            viewHolder.tv.setText(datas.get(position-1));
        }
    }

    @Override
    public int getItemCount() {
        return  mHeaderView == null ? datas.size() : datas.size() + 1;
    }

    //继承RecyclerView.ViewHolder抽象类的自定义ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }



}