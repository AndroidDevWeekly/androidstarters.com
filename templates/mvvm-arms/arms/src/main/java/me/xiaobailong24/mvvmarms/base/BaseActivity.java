package <%= appPackage %>.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import <%= appPackage %>.lifecycle.delegate.IActivity;


/**
 * Created by xiaobailong24 on 2017/6/16.
 * MVVM BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity
        implements IActivity {
    protected final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(initView(savedInstanceState));
            initData(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean useEventBus() {
        return true;
    }


    @Override
    public boolean useFragment() {
        return true;
    }
}
