package news.example.cb.com.news.ui;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import news.example.cb.com.news.MainActivity;
import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseActivity;
import news.example.cb.com.news.utils.CacheUtils;

/**
 * 欢迎界面
 */
public class WelcomeActivity extends BaseActivity {
    public static final String START_MAIN = "start_main";
    private RelativeLayout rl_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        rl_welcome = (RelativeLayout) findViewById(R.id.rl_welcome);
        //渐变动画
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        //缩放动画
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        //旋转动画
        RotateAnimation ra = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.addAnimation(ra);
        set.setDuration(500);//设置时长
        set.setFillAfter(true);
        //播放动画
        rl_welcome.startAnimation(set);
        //监听动画完成
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //播放完成
                Boolean isStarMain = CacheUtils.getBoolean(WelcomeActivity.this, START_MAIN);
                if (isStarMain) {
                    //如果进过主页面，就直接进入主页面
                    launchActivity(MainActivity.class, null);
                } else {
                    //进入引导界面
                    launchActivity(GuideActivity.class, null);
                }
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
