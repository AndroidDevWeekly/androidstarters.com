package <%= appPackage %>.weather.mvvm.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import <%= appPackage %>.weather.mvvm.model.entry.Location;

/**
 * Created by xiaobailong24 on 2017/7/29.
 * Room Database
 */
@Database(entities = Location.class, version = 2)
public abstract class WeatherNowDb extends RoomDatabase {

    public abstract WeatherNowDao weatherNowDao();
}
