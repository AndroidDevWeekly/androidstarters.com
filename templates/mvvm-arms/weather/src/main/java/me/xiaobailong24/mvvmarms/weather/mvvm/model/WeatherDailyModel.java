package <%= appPackage %>.weather.mvvm.model;

import android.app.Application;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import <%= appPackage %>.mvvm.BaseModel;
import <%= appPackage %>.weather.mvvm.model.api.service.WeatherService;
import <%= appPackage %>.weather.mvvm.model.entry.WeatherDailyResponse;

/**
 * @author xiaobailong24
 * @date 2017/8/14
 * MVVM WeatherDailyModel
 */
public class WeatherDailyModel extends BaseModel {

    @Inject
    public WeatherDailyModel(Application application) {
        super(application);
    }


    /**
     * 从网络获取未来三天天气
     *
     * @param request 请求信息
     * @return 未来三天天气结果
     */
    public Observable<WeatherDailyResponse> getWeatherDaily(Map<String, String> request) {
        return mRepositoryManager
                .obtainRetrofitService(WeatherService.class)
                .getWeatherDaily(request);
    }
}
