package test.task.kupibilet.weather.data.network

import test.task.kupibilet.weather.data.network.openweathermap.OpenWeather
import javax.inject.Inject

class NetworkData @Inject constructor(
    val openWeather: OpenWeather
)