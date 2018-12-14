# ViewPagerGallery
支持无限滑动的3D视觉的画廊效果、 平面普通广告栏轮播
<p>[博客讲解地址](https://blog.csdn.net/lin857/article/details/84644569)
<h3>效果图</h3>
<p><img  width="300" height="500"  src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/ic_banner1.png">
<p><img  width="300" height="500"  src="https://raw.githubusercontent.com/lzjin/ViewPagerGallery/master/imgfile/ic_banner2.png">
<h2>使用步骤</h2>
</br>首先在gradle文件中添加
<h3> implementation 'com.github.lzjin:ViewPagerGallery:1.06' </h3>

<h3>代码使用</h3>
viewPager.initBanner(urlList, true) </br>
         .addPageMargin(10, 60) </br>
         .addPoint(6)           </br>
         .addPointBottom(7)     </br>
         .addStartTimer(5)      </br>
         .addRoundCorners(12)   </br>
         .finishConfig()        </br>
         .addBannerListener(new BannerViewPager.OnClickBannerListener() { </br>
         @Override              </br>
         public void onBannerClick(int i) { </br>
             //点击回调          </br>
         }                      </br>
         });                    </br>
         
