package news.example.cb.com.news.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import news.example.cb.com.news.R;

/**
 * 温馨提示详情
 */
public class WeatherHintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_hint);
        if (getIntent() != null) {
            ((TextView) findViewById(R.id.tv_city)).setText(getIntent().getStringExtra("city"));
            ((TextView) findViewById(R.id.tv_hint)).setText(getIntent().getStringExtra("hint"));
        } else {
            ((TextView) findViewById(R.id.tv_city)).setText("");
            ((TextView) findViewById(R.id.tv_hint)).setText("");
        }
    }
}
