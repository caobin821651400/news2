package news.example.cb.com.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.KeyEvent;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import news.example.cb.com.news.base.BaseActivity;
import news.example.cb.com.news.ui.fragment.CareFragment;
import news.example.cb.com.news.ui.fragment.HomeFragment;
import news.example.cb.com.news.ui.fragment.MineFragment;
import news.example.cb.com.news.view.NoScrollViewPager;

/**
 *
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @ViewInject(R.id.view_pager)
    private NoScrollViewPager mViewPager;

    private FragmentPagerAdapter mPagerAdapter;
    //将fragment添加到list中
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        findViewById(R.id.rb_home).setOnClickListener(this);
        findViewById(R.id.rb_care).setOnClickListener(this);
        findViewById(R.id.rb_mine).setOnClickListener(this);

        //初始化fragmnet
        fragmentList = new ArrayList<>();
        Fragment homeFragment = new HomeFragment();
        Fragment careFragment = new CareFragment();
        Fragment mineFragment = new MineFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(careFragment);
        fragmentList.add(mineFragment);

        //viewPager适配器
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                if (fragmentList == null) {
                    return 0;
                }
                return fragmentList.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    /**
     * 处理点击事件
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_home:
                //主页
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.rb_care:
                //关注
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.rb_mine:
                //我的
                mViewPager.setCurrentItem(2, false);
                break;
            default:
                break;

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
                toast("再按一次，退出程序!");
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
