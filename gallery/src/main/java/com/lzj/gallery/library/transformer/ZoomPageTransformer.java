package com.lzj.gallery.library.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2018/11/28.
 * 3D画廊效果其实就是ViewPager的item切换时，进行缩放的动画效果
 *
 */

public class ZoomPageTransformer implements ViewPager.PageTransformer {

    private static final float MAX_SCALE = 1.0f;//0缩放

    private static final float MIN_SCALE = 0.85f;//0.85缩放

    private float MIN_ALPHA = 1.0f;//最小透明度

    public ZoomPageTransformer() {
    }
    public ZoomPageTransformer(float MIN_ALPHA) {
        this.MIN_ALPHA = MIN_ALPHA;
    }
    @Override
    public void transformPage(View view, float position) {
        //setScaleY只支持api11以上
        /**
         * (-oo,-1) 相对于左边第一页，其左边的所有页面 **
         * x、y拉伸为MIN_SCALE、透明度MIN_ALPHA
         */
        if (position < -1) {
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            view.setAlpha(MIN_ALPHA);
        }
        /**
         * [-1, 1 )当前页的左右第一页
         */
        else if (position < 1) {
            float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
            //[0, 1 ） 相对于当前选中页，其右边第一页 **
            if (position > 0) {
                view.setTranslationX(-scaleFactor);
            }
            // [-1, 0 ) 相对于当前选中页，其左边的第一页**
            else if (position < 0) {
                view.setTranslationX(scaleFactor);
            }
            view.setScaleY(scaleFactor);
            view.setScaleX(scaleFactor);

            // float alpha = 1f -  Math.abs(position) * (1 - );

            float alpha = MIN_ALPHA + (1 - MIN_ALPHA) * (1 - Math.abs(position));
            view.setAlpha(alpha);

        }
        /**
         * [1,+oo） 相对于右边第一页，其右边的所有页面
         * x、y拉伸为MIN_SCALE、透明度MIN_ALPHA
         */
        else { // (1,+Infinity]
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            view.setAlpha(MIN_ALPHA);
        }
    }

}