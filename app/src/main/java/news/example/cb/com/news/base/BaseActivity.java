package news.example.cb.com.news.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import org.xutils.x;

/**
 * Created by caobin on 2016/11/18.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化xutils
        x.view().inject(this);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    /**
     * toast任何类型的数据
     */
    public void toast(Object o) {
        Toast.makeText(BaseActivity.this, o.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 跳转activity
     *
     * @param cls    跳转的类
     * @param bundle 携带的数据
     */
    protected void launchActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转activity,通过请求码
     * @param cls
     * @param bundle
     * @param code
     */
    protected void launchActivityByCode(Class<?> cls, Bundle bundle, int code) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, code);
    }
}
