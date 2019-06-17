package test.task.kupibilet.weather.data.network.openweathermap.pojo

import com.google.gson.annotations.SerializedName

data class OpenWeatherResponse(
    @SerializedName("city") val city: City,
    @SerializedName("list") val conditions: List<WeatherCondition>
) {

    data class City(
        @SerializedName("geoname_id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("country") val country: String,
        @SerializedName("lon") val lon: Double,
        @SerializedName("lat") val lat: Double
    )

    data class WeatherCondition(
        @SerializedName("dt") val date: Long,
        @SerializedName("wind") val wind: Wind,
        @SerializedName("main") val main: Main,
        @SerializedName("weather") val weather: List<Weather>
    ) {
        data class Wind(
            @SerializedName("speed") val speed: Double,
            @SerializedName("deg") val deg: Double
        )
        data class Main(
            @SerializedName("pressure") val pressure: Double,
            @SerializedName("temp") val temp: Double,
            @SerializedName("temp_min") val min: Double,
            @SerializedName("temp_max") val max: Double
        )
        data class Weather(
            @SerializedName("id") val id: Long,
            @SerializedName("main") val main: String,
            @SerializedName("description") val description: String,
            @SerializedName("icon") val icon: String

        )
    }
}