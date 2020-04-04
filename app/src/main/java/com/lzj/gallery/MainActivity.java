package com.lzj.gallery;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lzj.gallery.activity.TabActivity;
import com.lzj.gallery.library.views.BannerViewPager;
import com.lzj.gallery.utils.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 效果演示
 */
public class MainActivity extends AppCompatActivity {

    BannerViewPager banner_3d;
    BannerViewPager banner_2;
    BannerViewPager banner_3;
    List<String> urlList;
    Toast toast;
    TextView tvFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initData();
    }

    /**
     *
     */
    private void init() {

        banner_3d=findViewById(R.id.banner_3d);
        banner_2=findViewById(R.id.banner_2);
        banner_3=findViewById(R.id.banner_3);
        tvFragment=findViewById(R.id.fragment);

        urlList = new ArrayList<>();
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543221773&di=c63f30c7809e518cafbff961bcd9ec2a&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0116605851154fa8012060c8587ca1.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042541&di=3ad9deeefff266e76d1f5d57a58f63d1&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F69%2F99%2F66%2F9fce5755f081660431464492a9aeb003.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042539&di=95bd41d43c335e74863d9bb540361906&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019a0558be22d6a801219c77d0578a.jpg%402o.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1586013578881&di=3fe60f355e63e0b15aa59e6f3597b2a8&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F34%2F07%2F16pic_3407117_b.jpg");


    }

    /**
     *
     */
    private void initData() {

        banner_3d.initBanner(urlList, true)//开启3D画廊效果
                .addPageMargin(10, 50)//参数1page之间的间距,参数2中间item距离边界的间距
                .addPointMargin(6)//添加指示器
                .addStartTimer(8)//自动轮播5秒间隔
                .addPointBottom(7)
                .addRoundCorners(20)//圆角
                .finishConfig()//这句必须加
                .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                    @Override
                    public void onBannerClick(int position) {
                        //点击item
                        showShort("效果1点击"+position);
                        Log.i("test","--------------00x1");
                    }
                });

        banner_2.initBanner(urlList, false)//关闭3D画廊效果
                .addPageMargin(10, 50)//参数1page之间的间距,参数2中间item距离边界的间距
                .addPointMargin(6)//添加指示器
                .addStartTimer(8)//自动轮播5秒间隔
                .addPointBottom(7)
                .addRoundCorners(20)//圆角
                .finishConfig()//这句必须加
                .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                    @Override
                    public void onBannerClick(int position) {
                        //点击item
                        showShort("效果2点击"+position);
                        Log.i("test","--------------00x2");
                    }
                });


        banner_3.initBanner(urlList, false)//关闭3D画廊效果
                .addPageMargin(0, 0)//无间距
                .addPointMargin(6)//添加指示器
                .addPointBottom(7)
                .finishConfig()//这句必须加
                .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                    @Override
                    public void onBannerClick(int position) {
                        //点击item
                        showShort("效果3点击"+position);
                        Log.i("test","--------------00x3");
                    }
                });

        //Fragment中使用
        tvFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtil.IntenToActivity(MainActivity.this, TabActivity.class);
            }
        });
    }

    /**
     *
     * @param text
     */
    public  void showShort( String text){
        if(toast == null) toast = Toast.makeText(this,text, Toast.LENGTH_SHORT);
        else toast.setText(text);
        toast.show();
    }


}
