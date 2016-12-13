package news.example.cb.com.news.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseFragment;
import news.example.cb.com.news.http.NewsResp;
import news.example.cb.com.news.ui.NewsDetailActivity;
import news.example.cb.com.news.ui.adapter.NewsListAdapter;
import news.example.cb.com.news.utils.MyLogUtil;
import news.example.cb.com.news.view.CircleRefreshLayout;

/**
 * Created by caobin on 2016/12/8.
 */
public class NewsCommonFragment extends BaseFragment {
    private ListView mListView;
    private NewsListAdapter mAdapter;
    private String type;
    //下拉刷新
    private CircleRefreshLayout mRefreshLayout;


    /**
     * 创建新实例
     *
     * @return
     */
    public static Fragment newInstance(String index) {
        NewsCommonFragment fragment = new NewsCommonFragment();
        Bundle bundle = new Bundle();
        bundle.putString("fragment_index", index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getString("fragment_index");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_common, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.list_view);
        mRefreshLayout = (CircleRefreshLayout) view.findViewById(R.id.refresh_layout);
        mAdapter = new NewsListAdapter(getActivity());
        mListView.setAdapter(mAdapter);


        mRefreshLayout.setOnRefreshListener(
                new CircleRefreshLayout.OnCircleRefreshListener() {
                    @Override
                    public void refreshing() {
                        // 开始刷新，
                        initData(type);
                    }

                    @Override
                    public void completeRefresh() {
                        // 刷新完成
                    }
                });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsResp.DataInfo info = (NewsResp.DataInfo) mAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString("url", info.getUrl());
                launchActivity(NewsDetailActivity.class, bundle);
            }
        });
    }


    /**
     * 请求网路数据
     * type  是请求类型  top头条  guonei国内 .....
     */
    private void initData(String type) {
        RequestParams params = new RequestParams("http://v.juhe.cn/toutiao/index");
        params.addBodyParameter("type", type);
        //申请的key
        params.addBodyParameter("key", "f323c09a114635eb935ed8dd19f7284e");
        x.http().get(params, new Callback.CommonCallback<String>() {
            /**
             * 请求成功
             * @param result
             */
            @Override
            public void onSuccess(String result) {
                List<NewsResp.DataInfo> list = new ArrayList<>();
                for (NewsResp.DataInfo item : parseGson(result).getResult().getData()) {
                    list.add(item);
                }
                mAdapter.setList(list);
            }

            /**
             * 请求错误
             * @param ex
             * @param isOnCallback
             */
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                MyLogUtil.d("请求失败 ：" + ex.getMessage());
            }

            /**
             *
             * @param cex
             */
            @Override
            public void onCancelled(CancelledException cex) {

            }

            /**
             * 请求完成
             */
            @Override
            public void onFinished() {
            }
        });
    }


    /**
     * 解析Json数据
     */
    private NewsResp parseGson(String json) {
        Gson gson = new Gson();
        NewsResp resp = gson.fromJson(json, NewsResp.class);
        return resp;
    }
}
