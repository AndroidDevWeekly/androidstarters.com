package <%= appPackage %>.lifecycle.delegate;

import android.app.Application;
import android.content.Context;

/**
 * Created by xiaobailong24 on 2017/7/25.
 * Application 生命周期
 */

public interface AppLifecycles {
    void attachBaseContext(Context context);

    void onCreate(Application application);

    void onTerminate(Application application);
}
