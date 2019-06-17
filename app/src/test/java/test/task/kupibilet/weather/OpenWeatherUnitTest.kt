package test.task.kupibilet.weather

import org.junit.Test
import test.task.kupibilet.weather.data.network.openweathermap.OpenWeather

class OpenWeatherUnitTest {

    private val openWeather = OpenWeather(
        "http://api.openweathermap.org/data/2.5/",
        "appid",
        "9492bc092aee51eac7a22d53e03ef2c2"
    )

    @Test
    fun check_info_request() {
        openWeather.api
            .info(35.0164, 139.0077)
            .subscribe({
                assert(it.conditions.size == 10)
            }, {
                it.printStackTrace()
            })
    }

}
