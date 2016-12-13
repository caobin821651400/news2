package news.example.cb.com.news.http;

import java.io.Serializable;
import java.util.List;

/**
 * 请求参数对象l
 * Created by caobin on 2016/12/8.
 */
public class NewsResp implements Serializable{
    private static final long serialVersionUID = -5330252222601935562L;

    private String reason;
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     */
    public class Result implements Serializable{
        private static final long serialVersionUID = -8608380279753160975L;

        private String stat;
        private List<DataInfo> data;

        public List<DataInfo> getData() {
            return data;
        }

        public void setData(List<DataInfo> data) {
            this.data = data;
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }
    }
    /**
     *
     */
    public class DataInfo implements Serializable{
        private static final long serialVersionUID = 525983234664300755L;

          /*"reason":"成功的返回",
	"result":{
		"stat":"1",
		"data":[
			{
				"title":"女子从狗嘴里抢到块“腊肉”砖家一看，顿时脸色突变！",
				"date":"2016-12-08 17:29",
				"author_name":"小杜说说",
				"thumbnail_pic_s":"http:\/\/09.imgmini.eastday.com\/mobile\/20161208\/20161208_37f479b999922d8552f2cf5701677ae5_mwpm_03200403.jpg",
				"thumbnail_pic_s02":"http:\/\/09.imgmini.eastday.com\/mobile\/20161208\/20161208_37f479b999922d8552f2cf5701677ae5_mwpl_05500201.jpg",
				"thumbnail_pic_s03":"http:\/\/09.imgmini.eastday.com\/mobile\/20161208\/20161208_37f479b999922d8552f2cf5701677ae5_mwpl_05500201.jpg",
				"url":"http:\/\/mini.eastday.com\/mobile\/161208172918661.html?qid=juheshuju",
				"uniquekey":"161208172918661",
				"type":"头条",
				"realtype":"社会"
			},*/
        private String title;
        private String date;
        private String author_name;
        private String thumbnail_pic_s;
        private String thumbnail_pic_s02;
        private String thumbnail_pic_s03;
        private String url;
        private String uniquekey;
        private String type;
        private String realtype;

        public String getRealtype() {
            return realtype;
        }

        public void setRealtype(String realtype) {
            this.realtype = realtype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail_pic_s03() {
            return thumbnail_pic_s03;
        }

        public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
            this.thumbnail_pic_s03 = thumbnail_pic_s03;
        }

        public String getThumbnail_pic_s02() {
            return thumbnail_pic_s02;
        }

        public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
            this.thumbnail_pic_s02 = thumbnail_pic_s02;
        }

        public String getThumbnail_pic_s() {
            return thumbnail_pic_s;
        }

        public void setThumbnail_pic_s(String thumbnail_pic_s) {
            this.thumbnail_pic_s = thumbnail_pic_s;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUniquekey() {
            return uniquekey;
        }

        public void setUniquekey(String uniquekey) {
            this.uniquekey = uniquekey;
        }
    }
}
