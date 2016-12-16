package news.example.cb.com.news.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseActivity;
import news.example.cb.com.news.http.WeatherResp;
import news.example.cb.com.news.ui.adapter.WeatherListAdapter;
import news.example.cb.com.news.utils.Constant;
import news.example.cb.com.news.utils.MyLogUtil;

/**
 * 天气情况
 */
public class WeatherActivity extends BaseActivity {
    //各种TextView，显示天气情况
    private TextView tv_temperature, tv_city_and_weather,
            tv_fen_li, tv_high_temp, tv_low_temp, tv_weather_message;
    private ListView mListView;
    private WeatherListAdapter mAdapter;
    //右上角的更多按钮
    private ImageButton btn_more;
    //
    private LinearLayout ll_weather_message;
    private String city, hint;//城市，提示信息

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
        mListView = (ListView) findViewById(R.id.list_view);
        btn_more = (ImageButton) findViewById(R.id.btn_more);
        tv_weather_message = (TextView) findViewById(R.id.tv_weather_message);
        ll_weather_message = (LinearLayout) findViewById(R.id.ll_weather_message);
        //温馨提示
        ll_weather_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("city", city);
                bundle.putString("hint", hint);
                launchActivity(WeatherHintActivity.class, bundle);
            }
        });
        //左上角更多
        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("以后完成定位和切换城市");
            }
        });

        mAdapter = new WeatherListAdapter(this);
        mListView.setAdapter(mAdapter);
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
                // MyLogUtil.d("结果 ：" + result);
                WeatherResp.WeatherInfo info = parseGson(result).getData();
                //get(0)是今天的数据,数据原因所以写死了
                WeatherResp.WeatherInfo.WeatherDetailsInfo info1 = info.getForecast().get(0);
                //intent传递数据时用
                hint = info.getGanmao();
                city = info.getCity();
                
                //显示数据
                tv_weather_message.setText("温馨提示：" + info.getGanmao());
                tv_temperature.setText(info.getWendu());
                tv_city_and_weather.setText(info.getCity() + "    |    " + info1.getType());
                tv_fen_li.setText(info1.getFengli());

                String high = info1.getHigh();
                tv_high_temp.setText(high.substring(3, high.length()));
                String low = info1.getLow();
                tv_low_temp.setText(low.substring(3, low.length()));

                //将近几天的数据传给adapter
                List<WeatherResp.WeatherInfo.WeatherDetailsInfo> list = new ArrayList<>();
                for (WeatherResp.WeatherInfo.WeatherDetailsInfo item : info.getForecast()) {
                    list.add(item);
                }
                mAdapter.setList(list);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
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
