package news.example.cb.com.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;

import org.xutils.view.annotation.ContentView;

import news.example.cb.com.news.base.BaseActivity;
import news.example.cb.com.news.ui.fragment.CareFragment;
import news.example.cb.com.news.ui.fragment.HomeFragment;
import news.example.cb.com.news.ui.fragment.MineFragment;

/**
 *
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Fragment homeFragment;//主页
    private Fragment careFragment;//关注
    private Fragment mineFragment;//我的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        //默认加载主页
        selectFragment(0);
    }

    /**
     * 初始化view
     */
    private void initView() {
        findViewById(R.id.rb_home).setOnClickListener(this);
        findViewById(R.id.rb_care).setOnClickListener(this);
        findViewById(R.id.rb_mine).setOnClickListener(this);
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
                selectFragment(0);
                break;
            case R.id.rb_care:
                //关注
                selectFragment(1);
                break;
            case R.id.rb_mine:
                //我的
                selectFragment(2);
                break;
            default:
                break;

        }
    }


    /**
     * 切换fragment
     *
     * @param i 第几个
     */
    private void selectFragment(int i) {
        FragmentManager fm = getSupportFragmentManager();
        //开启 Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 设置内容区域
        switch (i) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.fragment_content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (careFragment == null) {
                    careFragment = new CareFragment();
                    transaction.add(R.id.fragment_content, careFragment);
                } else {
                    transaction.show(careFragment);

                }
                break;
            case 2:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.fragment_content, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (careFragment != null) {
            transaction.hide(careFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
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
