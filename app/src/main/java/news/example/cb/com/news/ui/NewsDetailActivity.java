package news.example.cb.com.news.ui;

import android.os.Bundle;
import android.renderscript.Element;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import news.example.cb.com.news.R;
import news.example.cb.com.news.base.BaseActivity;

/**
 * 新闻详情界面
 */
public class NewsDetailActivity extends BaseActivity {
    private WebView mWebView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
        if (getIntent() != null) {
            url = getIntent().getStringExtra("url");
            initWeb();
        } else {
            toast("程序发生错误了，请在尝试一次！");
        }
    }


    private void initView() {
        mWebView = (WebView) findViewById(R.id.web_view);
        findViewById(R.id.btn_news_details_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.btn_news_details_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("稍后完成！");
            }
        });

    }

    /**
     * 设置webView
     */
    private void initWeb() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        //设置 缓存模式
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }


    /**
     * 重写返回键方法
     *
     * @return
     */
    @Override
    // 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
