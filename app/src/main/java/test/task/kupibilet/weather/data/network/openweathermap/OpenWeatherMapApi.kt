package test.task.kupibilet.weather.data.network.openweathermap

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import test.task.kupibilet.weather.data.network.openweathermap.pojo.OpenWeatherResponse

interface OpenWeatherMapApi {


    @GET("forecast?units=metric&cnt=10")
    fun info(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Single<OpenWeatherResponse>

}