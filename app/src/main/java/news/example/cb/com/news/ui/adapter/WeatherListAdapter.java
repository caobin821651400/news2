package news.example.cb.com.news.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import news.example.cb.com.news.R;
import news.example.cb.com.news.http.WeatherResp.WeatherInfo.WeatherDetailsInfo;

/**
 * Created by caobin on 2016/12/9.
 */
public class WeatherListAdapter extends BaseAdapter {
    //上下文
    private Context context;
    private LayoutInflater mInflater;
    private List<WeatherDetailsInfo> mList;

    public WeatherListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setList(List<WeatherDetailsInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mList == null) {
            return 0;
        }
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_list_future_weather, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.img_weather_icon = (ImageView) view.findViewById(R.id.img_weather_icon);
            viewHolder.tv_day = (TextView) view.findViewById(R.id.tv_day);
            viewHolder.tv_weather = (TextView) view.findViewById(R.id.tv_weather);
            viewHolder.tv_high_low = (TextView) view.findViewById(R.id.tv_high_low);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        WeatherDetailsInfo item = (WeatherDetailsInfo) getItem(position);
        //设置图标,根据返回的String判断设置不同图标
        // 因为接口随便找的，所以还多不规范。
        if (item.getType().contains("雨")) {
            viewHolder.img_weather_icon.setImageResource(R.drawable.ic_rain);
        } else if (item.getType().contains("风")) {
            viewHolder.img_weather_icon.setImageResource(R.drawable.ic_windy);
        } else if (item.getType().contains("雪")) {
            viewHolder.img_weather_icon.setImageResource(R.drawable.ic_nown);
        } else if (item.getType().contains("阴")) {
            viewHolder.img_weather_icon.setImageResource(R.drawable.ic_cloudy);
        } else if (item.getType().contains("晴")) {
            viewHolder.img_weather_icon.setImageResource(R.drawable.ic_sunny);
        } else if (item.getType().contains("多云")) {
            viewHolder.img_weather_icon.setImageResource(R.drawable.ic_overcast);
        } else {
            viewHolder.img_weather_icon.setImageResource(R.drawable.ic_sunny);
        }

        String date = item.getDate();
        viewHolder.tv_day.setText(date.substring(3, date.length()));
        viewHolder.tv_weather.setText(item.getType() + " | " + item.getFengli());
        //这里截取了字符串，应为接口返回的数据不好看，以后根据自己接口返回的数据来改ia
        String high = (item.getHigh()).substring(3, (item.getHigh()).length());
        String low = (item.getLow()).substring(3, (item.getLow()).length());
        viewHolder.tv_high_low.setText(low + " / " + high);
        return view;
    }

    class ViewHolder {
        ImageView img_weather_icon;//图标，不同天气切换不同图标
        TextView tv_day;//日期
        TextView tv_weather;//天气情况
        TextView tv_high_low;//高低温

    }
}
