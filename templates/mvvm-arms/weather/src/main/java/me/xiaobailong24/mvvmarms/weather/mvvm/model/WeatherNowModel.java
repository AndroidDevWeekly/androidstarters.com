package <%= appPackage %>.weather.mvvm.model;

import android.app.Application;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import <%= appPackage %>.mvvm.BaseModel;
import <%= appPackage %>.weather.mvvm.model.api.service.WeatherService;
import <%= appPackage %>.weather.mvvm.model.db.WeatherNowDb;
import <%= appPackage %>.weather.mvvm.model.entry.Location;
import <%= appPackage %>.weather.mvvm.model.entry.WeatherNowResponse;

/**
 * Created by xiaobailong24 on 2017/7/22.
 * MVVM WeatherNowModel
 */
public class WeatherNowModel extends BaseModel {

    @Inject
    public WeatherNowModel(Application application) {
        super(application);
    }

    //从网络获取天气
    public Observable<WeatherNowResponse> getWeatherNow(Map<String, String> request) {
        return mRepositoryManager
                .obtainRetrofitService(WeatherService.class)
                .getWeatherNow(request);
    }

    //存储位置信息到Room数据库
    public void saveLocation(Location location) {
        mRepositoryManager
                .obtainRoomDatabase(WeatherNowDb.class, WeatherNowDb.class.getSimpleName())
                .weatherNowDao()
                .insertAll(location);
    }

    //从Room数据库查询所有位置信息
    public List<Location> getAllLocations() {
        return mRepositoryManager
                .obtainRoomDatabase(WeatherNowDb.class, WeatherNowDb.class.getSimpleName())
                .weatherNowDao()
                .getAll();
    }

    //从Room数据库查询指定位置信息
    public Location getLocationByName(String name) {
        return mRepositoryManager
                .obtainRoomDatabase(WeatherNowDb.class, WeatherNowDb.class.getSimpleName())
                .weatherNowDao()
                .getLocationByName(name);
    }

    //更新Room数据库位置信息
    public void updateLocation(Location location) {
        mRepositoryManager
                .obtainRoomDatabase(WeatherNowDb.class, WeatherNowDb.class.getSimpleName())
                .weatherNowDao()
                .updateAll(location);
    }

    //删除Room数据库位置信息
    public void deleteLocation(Location location) {
        mRepositoryManager
                .obtainRoomDatabase(WeatherNowDb.class, WeatherNowDb.class.getSimpleName())
                .weatherNowDao()
                .deleteLocation(location);
    }
}
