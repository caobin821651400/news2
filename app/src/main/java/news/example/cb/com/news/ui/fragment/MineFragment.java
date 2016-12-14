package news.example.cb.com.news.ui.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseFragment;
import news.example.cb.com.news.http.WeatherResp;
import news.example.cb.com.news.utils.Constant;

/**
 * 主页
 */
public class MineFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mine_tab, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }


    private void initView(View view) {

        getWeatherData();
    }

    /**
     * 请求天气数据
     */
    private void getWeatherData() {
        final RequestParams params = new RequestParams(Constant.WEATHER_API_URL);
        //接一个参数，城市
        params.addBodyParameter("city", "成都");
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                WeatherResp.WeatherInfo info = parseGson(result).getData();
                WeatherResp.WeatherInfo.WeatherDetailsInfo info1 = info.getForecast().get(0);

                toast("结果 ：" + info1.getLow());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast("请检查你的网络！");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private WeatherResp parseGson(String json) {
        Gson gson = new Gson();
        WeatherResp resp = gson.fromJson(json, WeatherResp.class);
        return resp;
    }
}
