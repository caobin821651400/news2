package news.example.cb.com.news.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseFragment;
import news.example.cb.com.news.view.MyViewPagerIndicator;

/**
 * 主页
 */
public class HomeFragment extends BaseFragment {
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    //滑动指示器
    private MyViewPagerIndicator indicator;
    //指示器内容
    private List<String> navData;
    //类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
    private String[] navInfo = {"头条", "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经", "时尚"};
    private String[] navInfo1 = {"top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing", "shishang"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View v) {
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);
        indicator = (MyViewPagerIndicator) v.findViewById(R.id.view_pager_indicator);
        //Toolbar mToolbar = (Toolbar) v.findViewById(R.id.toolbar);

        ImageButton imageButton = (ImageButton) v.findViewById(R.id.btn_left_more);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "左上方按钮", Toast.LENGTH_SHORT).show();
            }
        });

        navData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            navData.add(navInfo[i]);
        }

        mAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mAdapter);
        //将指示器与pager绑定
        indicator.setDatas(navData);
        indicator.setViewPager(mViewPager);
    }

    /**
     * ViewPager适配器
     */
    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //所有界面共用一个fragment，布局都一样就是内容不一样.
            return NewsCommonFragment.newInstance(navInfo1[position]);
        }

        @Override
        public int getCount() {
            return 10;
        }
    }
}
