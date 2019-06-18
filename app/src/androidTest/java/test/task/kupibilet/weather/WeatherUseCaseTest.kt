package test.task.kupibilet.weather

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import test.task.kupibilet.weather.data.Repo
import test.task.kupibilet.weather.data.local.LocalData
import test.task.kupibilet.weather.data.local.database.SQLiteDatabase
import test.task.kupibilet.weather.data.local.res.ResProvider
import test.task.kupibilet.weather.data.local.res.entity.City
import test.task.kupibilet.weather.data.network.NetworkData
import test.task.kupibilet.weather.data.network.openweathermap.OpenWeather
import test.task.kupibilet.weather.usecase.city.CityUseCaseImpl
import test.task.kupibilet.weather.usecase.weather.WeatherUseCaseImpl


@RunWith(AndroidJUnit4::class)
class WeatherUseCaseTest {

    lateinit var repo: Repo
    lateinit var city: City

    @Before
    fun setup() {
        val openWeather = OpenWeather(
            "http://api.openweathermap.org/data/2.5/",
            "appid",
            "9492bc092aee51eac7a22d53e03ef2c2"
        )
        val networkData = NetworkData(openWeather)

        val context = ApplicationProvider.getApplicationContext<Context>()
        val localData = LocalData(
            ResProvider(context),
            Room.inMemoryDatabaseBuilder(context, SQLiteDatabase::class.java).build()
        )

        repo = Repo(networkData, localData)

        val cityUseCase = CityUseCaseImpl(repo)
        cityUseCase.cities().subscribe({
            city = it.first()
        }, {
            assert(false)
        })
    }

    @After
    fun finish() {
        repo.local.database.close()
    }

    @Test
    fun weather_test() {
        val weaUseCaseImpl = WeatherUseCaseImpl(repo)

        weaUseCaseImpl.weather(city)
            .subscribe { downloadedAndSaved ->
                repo.local
                    .database
                    .weatherDao()
                    .allBy(city.id())
                    .subscribe { dbList -> assert(downloadedAndSaved == dbList) }
            }
    }
}
