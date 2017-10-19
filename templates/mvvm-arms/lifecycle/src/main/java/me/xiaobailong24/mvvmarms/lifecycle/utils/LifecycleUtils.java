package <%= appPackage %>.lifecycle.utils;

import android.app.Application;
import android.content.Context;

import <%= appPackage %>.lifecycle.delegate.ILifecycle;
import <%= appPackage %>.lifecycle.di.component.LifecycleComponent;

/**
 * Created by xiaobailong24 on 2017/9/28.
 * LifecycleComponent 工具类
 */
public enum LifecycleUtils {
    INSTANCE;

    public LifecycleComponent obtainLifecycleComponent(Context context) {
        return obtainLifecycleComponent((Application) context.getApplicationContext());
    }

    public LifecycleComponent obtainLifecycleComponent(Application application) {
        Preconditions.checkState(application instanceof ILifecycle,
                "%s does not implements ILifecycle", application.getClass().getName());
        return ((ILifecycle) application).getLifecycleComponent();
    }

}
