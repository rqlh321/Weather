package test.task.kupibilet.weather.data.local.res.entity

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("coordinates") val coordinates: Coordinates

) {

    fun id() = country + name

    data class Coordinates(
        @SerializedName("lat") val lat: Double,
        @SerializedName("lon") val lon: Double
    )
}