# ViewPagerGallery
不懂看博客、不懂看博客、不懂看博客
<p>[博客讲解地址](https://blog.csdn.net/lin857/article/details/84644569)
<h2>欢迎大家Star</h2>
<p>[下载体验APK-Demo](https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/app1.2.apk)
<p><img   src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/gif1.gif">
<p><img   src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/gif2.gif">
<h3>特点功能:</h3>
<h6>支持左右无限滑动轮播</h6>
<h6>支持3D效果的画廊轮播</h6>
<h6>支持平面铺满常见轮播</h6>
<h6>支持平面自定义间距轮播</h6>
<h6>支持网络缓存图片(使用的Glide)</h6>
<h6>支持自定义指示器图标(默认指示器个数与url一样)</h6>
<h6>支持自定义圆角</h6>
<h6>支持自动切换图片,间隔默认5秒</h6>
<h3>API方法介绍:</h3>
<h6>initBanner(urlList, true)//url数组，是否3D画廊效果</h6>
<h6>addPageMargin(10, 50)//page之间的间距,中间item距离边界的间距</h6>
<h6>addPoint(6)//添加指示器之间的间距</h6>
<h6>addPointBottom(7)//指示器底部间距</h6>
<h6>addStartTimer(5)//添加自动切换</h6>
<h6>addRoundCorners(12)//添加圆角</h6>
<h6>finishConfig()//最后加这句</h6>

Usage
--
##### Gradle:
```groovy
implementation 'com.github.lzjin:ViewPagerGallery:1.2'  
```
## 历史版本底部

#### Xml:
```groovy
 <com.lzj.gallery.library.views.BannerViewPager
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="150dp">
```
#### Java:
```groovy
          banner.initBanner(urlList, true)//开启3D画廊效果
                .addPageMargin(10, 50)//参数1page之间的间距,参数2中间item距离边界的间距
                .addPoint(6)//指示器点间距
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
#### v1.2
    优化更新
 * 修复部分手机兼容问题
 * demo增加Fragment与recyclerView使用示例
 #### v1.1
     优化更新
  * 优化界面适配问题
  * 增加Demo演示代码
  #### v1.0
     预览版
  * 不建议使用
  
  <h3>效果一:3D画廊效果</h3>
  <p><img   src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/ic_banner1.png">
  <h3>效果二:平面自定义间距效果</h3>
  <p><img   src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/ic_banner2.png">
  <h3>效果三:平面铺满常见效果</h3>
  <p><img    src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/ic_banner3.png">
