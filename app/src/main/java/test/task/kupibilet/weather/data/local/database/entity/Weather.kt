package test.task.kupibilet.weather.data.local.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "WEATHER")
data class Weather(
    @PrimaryKey var cityId: Long = 0,
    var temp: Float = 0f,
    var description: String = "",
    var date: Long = 0
)
