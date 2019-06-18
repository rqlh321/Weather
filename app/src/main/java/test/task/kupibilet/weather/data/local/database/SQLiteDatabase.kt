package test.task.kupibilet.weather.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import test.task.kupibilet.weather.data.local.database.entity.Weather

@Database(
    entities = [
        Weather::class
    ],
    version = 1
)

abstract class SQLiteDatabase : RoomDatabase() {
    abstract fun weatherDao(): OpenWeatherMapDao
}