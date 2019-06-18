package test.task.kupibilet.weather.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import test.task.kupibilet.weather.data.local.database.entity.Weather

@Dao
interface OpenWeatherMapDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(items: List<Weather>): Completable

    @Query("SELECT * FROM WEATHER WHERE cityId=:cityId")
    fun allBy(cityId: String): Single<List<Weather>>

}