# ViewPagerGallery
3D轮播图片  

#### 博客讲解地址,欢迎前往查看
[博客讲解地址](https://blog.csdn.net/lin857/article/details/84644569)

### 欢迎大家Star,老铁给鼓励呗  
<img   src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/gif1.gif">
<img   src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/gif2.gif">

### 主要功能  
* 支持左右无限滑动轮播 
* 支持3D效果的画廊轮播
* 支持平面铺满常见轮播
* 支持平面自定义间距轮播
* 支持网络缓存图片(使用的Glide4.9)
* 支持自定义指示器图标(默认指示器个数与url一样)
* 支持自定义圆角 
* 支持自动切换图片,间隔默认5秒;手指滑动时停止定时器

### API方法介绍 
* initBanner(urlList, true)//url数组，是否3D画廊效果 
* addPageMargin(10, 50)//page之间的间距,中间item距离边界的间距 
* addPointMargin(6)//指示器的间距 
* addPointBottom(7)//指示器底部间距 
* addStartTimer(5)//自动切换时间 
* addRoundCorners(12)//添加圆角 
* finishConfig()//必加最后加这句 

### Jitpack 
 
---
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
	 ...
	 maven { url 'https://jitpack.io' }
    }
}
```
#### Gradle:
Step 2. Add the dependency
```
dependencies {
    //androidX  
    implementation 'com.github.lzjin:ViewPagerGallery:1.3'  

    //Support  
    implementation 'com.github.lzjin:ViewPagerGallery:1.2'  
}
```
#### Xml:
```
 <com.lzj.gallery.library.views.BannerViewPager
        android:id="@+id/banner"
        android:layout_width="match_parent"
        android:layout_height="150dp">
```

#### Java:
```
          banner.initBanner(urlList, true)//开启3D画廊效果
                .addPageMargin(10, 50)//参数1page之间的间距,参数2中间item距离边界的间距
                .addPointMargin(6)//指示器点间距
                .addStartTimer(8)//自动轮播5秒间隔
                .addPointBottom(7)//底部间距
                .addRoundCorners(12)//圆角
                .finishConfig()//这句必须加
                .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                    @Override
                    public void onBannerClick(int position) {
                        //点击item
                    }
                });
```

## 历史版本底部

#### v1.3
* 迁移AndroidX
* 新增滑动时取消延时
* 使用Glide4.9版本的圆角RoundedCorners
* 修复数组为null

#### v1.2
    优化更新
* 修复部分手机兼容问题
* demo增加Fragment与recyclerView使用示例

#### v1.1
* 优化界面适配问题
* 增加Demo演示代码

#### v1.0
* 基础使用
  
<h3>效果一:3D画廊效果</h3>
<p><img   src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/ic_banner1.png">
<h3>效果二:平面自定义间距效果</h3>
<p><img   src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/ic_banner2.png">
<h3>效果三:平面铺满常见效果</h3>
<p><img    src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/ic_banner3.png">
