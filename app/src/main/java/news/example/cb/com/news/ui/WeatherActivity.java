package news.example.cb.com.news.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseActivity;
import news.example.cb.com.news.http.WeatherResp;
import news.example.cb.com.news.utils.Constant;
import news.example.cb.com.news.utils.MyLogUtil;

/**
 * 天气情况
 */
public class WeatherActivity extends BaseActivity {
    private TextView tv_temperature, tv_city_and_weather,
            tv_fen_li, tv_high_temp, tv_low_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initView();
    }

    private void initView() {
        tv_temperature = (TextView) findViewById(R.id.tv_temperature);
        tv_city_and_weather = (TextView) findViewById(R.id.tv_city_and_weather);
        tv_fen_li = (TextView) findViewById(R.id.tv_fen_li);
        tv_high_temp = (TextView) findViewById(R.id.tv_high_temp);
        tv_low_temp = (TextView) findViewById(R.id.tv_low_temp);
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
                //get(0)是今天的数据,数据原因所以写死了
                WeatherResp.WeatherInfo.WeatherDetailsInfo info1 = info.getForecast().get(0);
                //显示数据
                tv_temperature.setText(info.getWendu());
                tv_city_and_weather.setText(info.getCity() + "    |    " + info1.getType());
                tv_fen_li.setText(info1.getFengli());
                String high = info1.getHigh();
                tv_high_temp.setText(high.substring(3, high.length()));
                String low = info1.getLow();
                tv_low_temp.setText(low.substring(3, low.length()));
                // MyLogUtil.d("结果 ：" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
//                toast("请检查你的网络！");
                MyLogUtil.d("错误 ：" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 解析json数据
     *
     * @param json
     * @return
     */
    private WeatherResp parseGson(String json) {
        Gson gson = new Gson();
        WeatherResp resp = gson.fromJson(json, WeatherResp.class);
        return resp;
    }
}
