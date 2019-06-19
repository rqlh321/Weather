package test.task.kupibilet.weather.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.common.ListItem
import test.task.kupibilet.weather.data.network.openweathermap.pojo.OpenWeatherResponse
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "WEATHER")
data class Weather(
    var cityId: String = "",
    var title: String = "",
    var description: String = "",
    var timestamp: Long = 0,
    var timestampPreview: String = ""
) : ListItem {

    override fun layout() = R.layout.list_item_weather

    @PrimaryKey
    var primaryKey: String = UUID.randomUUID().toString()

    constructor(cityId: String, data: OpenWeatherResponse.WeatherCondition) : this(
        cityId,
        data.main.toString(),
        data.toString(),
        System.currentTimeMillis(),
        CREATE_FORMAT.format(System.currentTimeMillis())
    )

    companion object {
        private var CREATE_FORMAT = SimpleDateFormat("HH:mm")
    }
}