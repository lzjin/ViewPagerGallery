package com.lzj.gallery.library.adapter;

import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.lzj.gallery.library.R;

import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 * banner的适配器
 */

public class BannerPagerAdapter  extends PagerAdapter {
    private List<String> mList;
    private Context mContext;
    private int defaultImg=R.mipmap.ic_banner_error;//默认图片
    private int mRoundCorners=-1;
    private int mMaxNumber;//最大banner数
    /**
     * 默认
     * @param defaultImg
     */
    public void setDefaultImg(int defaultImg) {
        this.defaultImg = defaultImg;
    }

    /**
     * 设置圆角
     * @param mRoundCorners
     */
    public void setmRoundCorners(int mRoundCorners) {
        this.mRoundCorners = mRoundCorners;
    }

    /**
     * 点击回调
     */
    public static interface OnClickImagesListener {
        void onImagesClick(int position);
    }
    private OnClickImagesListener mImagesListener;

    public void setOnClickImagesListener(OnClickImagesListener listener) {
        mImagesListener = listener;

    }

    public BannerPagerAdapter(List<String> list,Context context){
       // this.mList = list;
        this.mContext = context;
        if(mList==null){
            mList=list;
        }
        if(list.size()>9){
            this.mMaxNumber=9;
        } else {
            this.mMaxNumber=list.size();
        }
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.banner_img_layout,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.img);

        final int index=position % mMaxNumber;
        LoadImage(mList.get(index),imageView);
        //OnClick
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImagesListener.onImagesClick(index);
            }
        });

        container.addView(view);
        return view;
    }

    /**
     * 加载图片
     */
    public  void LoadImage(String url, ImageView imageview) {
        if(mRoundCorners==-1){
            Glide.with(mContext)
                    .load(url)
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(defaultImg)// 加载中图片
                    .error(defaultImg) // 加载失败图片
                    .diskCacheStrategy( DiskCacheStrategy.AUTOMATIC )//设置磁盘缓存
                    .into(imageview);
        }
        else {
            Glide.with(mContext)
                    .load(url)
                    .centerCrop()
                    .dontAnimate()
                    .placeholder(defaultImg)// 加载中图片
                    .error(defaultImg) // 加载失败图片
                    .transform(new RoundedCorners(mRoundCorners)) //
                    .diskCacheStrategy( DiskCacheStrategy.AUTOMATIC )//设置磁盘缓存
                    .into(imageview);
        }
    }


}