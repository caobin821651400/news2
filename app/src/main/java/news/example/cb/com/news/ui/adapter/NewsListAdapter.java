package news.example.cb.com.news.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

import news.example.cb.com.news.R;
import news.example.cb.com.news.http.NewsResp;

/**
 * Created by caobin on 2016/12/9.
 */
public class NewsListAdapter extends BaseAdapter {
    //上下文
    private Context context;
    private LayoutInflater mInflater;
    private List<NewsResp.DataInfo> mList;

    public NewsListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setList(List<NewsResp.DataInfo> list) {
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
            view = mInflater.inflate(R.layout.item_list_news_content, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.tv_title);
            viewHolder.date = (TextView) view.findViewById(R.id.tv_author_time);
            viewHolder.imgTitle1 = (ImageView) view.findViewById(R.id.image_info_1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        NewsResp.DataInfo resp = (NewsResp.DataInfo) getItem(position);
        viewHolder.title.setText(resp.getTitle());
        viewHolder.date.setText(resp.getDate() + "      作者" + resp.getAuthor_name());
        x.image().bind(viewHolder.imgTitle1, resp.getThumbnail_pic_s(),imageOptions);
        return view;
    }

    class ViewHolder {
        TextView title;//标题
        TextView date;//时间和作者
        ImageView imgTitle1;//图片封面1

    }
    ImageOptions imageOptions=new ImageOptions.Builder()
            .setSize(0,0)
            .setImageScaleType(ImageView.ScaleType.FIT_XY)
            .build();
}
