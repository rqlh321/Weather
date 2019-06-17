package test.task.kupibilet.weather.data.local.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import test.task.kupibilet.weather.data.local.database.entity.Weather

@Dao
interface OpenWeatherMapDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Weather)

    @Query("SELECT * FROM WEATHER WHERE cityId=:cityId")
    fun get(cityId: Int): Single<List<Weather>>

}