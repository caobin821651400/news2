package news.example.cb.com.news.ui;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import news.example.cb.com.news.MainActivity;
import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseActivity;
import news.example.cb.com.news.utils.CacheUtils;
import news.example.cb.com.news.utils.MyDensityUtil;

/**
 * 引导界面
 */
public class GuideActivity extends BaseActivity {
    private ViewPager view_pager;
    private LinearLayout ll_point_group;//灰色点的父布局
    private Button btn_start_main;//开始体验按钮
    private ImageView iv_point_red;//红点的父布局
    private ArrayList<ImageView> imageViews;//存放背景图片的集合
    private int leftmax;//两点之间的间距

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        ll_point_group = (LinearLayout) findViewById(R.id.ll_point_group);
        btn_start_main = (Button) findViewById(R.id.btn_start_main);
        iv_point_red = (ImageView) findViewById(R.id.iv_point_red);
        //背景图片
        int[] ids = new int[]{
                R.drawable.guide_1,
                R.drawable.guide_2,
                R.drawable.guide_3
        };
        imageViews = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            imageViews.add(imageView);
            //创建灰色的点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            //单位dip
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MyDensityUtil.dip2px(this, 10),
                    MyDensityUtil.dip2px(this, 10));
            if (i != 0) {
                //出了第一个点其他的都要设置左边距
                params.leftMargin = MyDensityUtil.dip2px(this, 10);
            }
            point.setLayoutParams(params);
            //添加到线性布局里
            ll_point_group.addView(point);
        }
        //添加ViewPager适配器
        view_pager.setAdapter(new MyPagerAdapter());
        //根据视图树，得到点之间的边距
        iv_point_red.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());
        //得到屏幕滑动百分比
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * 页面滑动时回调
             * @param position 滑动位置
             * @param positionOffset 滑动百分比
             * @param positionOffsetPixels 滑动像素
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //两点移动的距离= 屏幕的滑动的百分比 * 间距
                //两点对应坐标= 原来的坐标 + 两点移动距离
                int leftmargin = (int) (position * leftmax + positionOffset * leftmax);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_point_red.getLayoutParams();
                params.leftMargin = leftmargin;
                iv_point_red.setLayoutParams(params);
            }

            /**
             * 当页面被选中时回调方法
             * @param position 对应页面的位置
             */
            @Override
            public void onPageSelected(int position) {
                if (position == imageViews.size() - 1) {
                    btn_start_main.setVisibility(View.VISIBLE);
                } else {
                    btn_start_main.setVisibility(View.GONE);
                }
            }

            /**
             * 当页面滑动状态发生变化时
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //开始体验
        btn_start_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存进过主界面
                CacheUtils.putBoolean(GuideActivity.this, WelcomeActivity.START_MAIN, true);
                launchActivity(MainActivity.class, null);
                finish();
            }
        });
    }

    /**
     * 视图树发生改变时的监听
     * 拿到两点之间的间距
     */
    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

        @Override
        public void onGlobalLayout() {
            //执行一次就可以了
            iv_point_red.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            //间距=第一个点左边的距离 -- 第零个点左边的距离
            leftmax = ll_point_group.getChildAt(1).getLeft() - ll_point_group.getChildAt(0).getLeft();
        }
    }

    /**
     * ViewPager适配器
     */
    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViews.size();
        }

        /**
         * 相当于listView的getView方法
         *
         * @param container viewpager
         * @param position  要创建的位置
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            container.addView(imageView);
            return imageView;
        }

        /**
         * 判断上面返回的视图的结果
         *
         * @param view
         * @param object
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 销毁界面
         *
         * @param container viewpager
         * @param position  要销毁的
         * @param object
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }
    }

    /**
     * 再按一次退出程序
     * 判断在一定的时间内连续点击两次才退出程序
     */

    private long waitTime = 2000;
    private long touchTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                toast("再按一次退出程序");
                touchTime = currentTime;
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
