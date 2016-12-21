package news.example.cb.com.news.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseFragment;
import news.example.cb.com.news.utils.Constant;
import news.example.cb.com.news.utils.MyLogUtil;

/**
 * 主页
 */
public class CareFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.care_tab, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        //fetchData();
    }

    private void fetchData() {
        RequestParams params = new RequestParams(Constant.NBA_API_URL);
        params.addBodyParameter("dtype","json");
        params.addBodyParameter("key","05e48b9d57df20876b5d2829016b5388");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                MyLogUtil.d("结果 ："+result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                MyLogUtil.d("错误 ："+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
