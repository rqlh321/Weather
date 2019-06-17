package test.task.kupibilet.weather

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import test.task.kupibilet.weather.data.Repo
import test.task.kupibilet.weather.data.local.LocalData
import test.task.kupibilet.weather.data.local.database.SQLiteDatabase
import test.task.kupibilet.weather.data.local.res.ResProvider
import test.task.kupibilet.weather.data.network.NetworkData
import test.task.kupibilet.weather.data.network.openweathermap.OpenWeather

class OpenWeatherUnitTest {

    lateinit var repo: Repo

    @Before
    fun setup() {
        val openWeather = OpenWeather(
            "http://api.openweathermap.org/data/2.5/",
            "appid",
            "9492bc092aee51eac7a22d53e03ef2c2"
        )
        val networkData = NetworkData(openWeather)

        val localData = LocalData(
            Mockito.mock(ResProvider::class.java),
            Mockito.mock(SQLiteDatabase::class.java)
        )

        repo = Repo(networkData, localData)

    }

    @Test
    fun check_info_request() {
        repo.network
            .openWeather
            .api
            .info(35.0164, 139.0077)
            .subscribe({
                assert(it.conditions.size == 10)
            }, {
                it.printStackTrace()
            })
    }

}
