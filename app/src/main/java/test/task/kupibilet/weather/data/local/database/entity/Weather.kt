package test.task.kupibilet.weather.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import test.task.kupibilet.weather.data.network.openweathermap.pojo.OpenWeatherResponse
import java.util.*

@Entity(tableName = "WEATHER")
data class Weather(
    var cityId: String = "",
    var title: String = "",
    var description: String = "",
    var date: Long = 0
) {

    @PrimaryKey
    var primaryKey: String = UUID.randomUUID().toString()

    var timestamp: Long = System.currentTimeMillis()

    constructor(cityId: String, data: OpenWeatherResponse.WeatherCondition) : this(
        cityId,
        data.main.toString(),
        data.toString(),
        data.date
    )

}