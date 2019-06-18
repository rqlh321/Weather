package test.task.kupibilet.weather.usecase.weather

import io.reactivex.Single
import test.task.kupibilet.weather.BuildConfig.DATA_TIMEOUT_IN_MINUTES
import test.task.kupibilet.weather.data.Repo
import test.task.kupibilet.weather.data.local.database.entity.Weather
import test.task.kupibilet.weather.data.local.res.entity.City
import javax.inject.Inject

class WeatherUseCaseImpl @Inject constructor(
    private val repo: Repo
) : WeatherUseCase {

    override fun weather(city: City): Single<List<Weather>> {
        return repo.local
            .database
            .weatherDao()
            .allBy(city.id())
            .flatMap {
                if (it.isEmpty()) {
                    downloadWeather(city)
                } else {
                    if (it.first().timestamp.isOld()) {
                        downloadWeather(city)
                    } else {
                        Single.just(it)
                    }
                }
            }
    }

    private fun downloadWeather(city: City): Single<List<Weather>> {
        return repo.network
            .openWeather
            .api
            .info(city.coordinates.lat, city.coordinates.lon)
            .flatMap { openWeatherResp ->
                val weatherConditions = openWeatherResp.conditions.map { Weather(city.id(), it) }
                return@flatMap repo.local
                    .database
                    .weatherDao()
                    .insert(weatherConditions)
                    .andThen(Single.just(weatherConditions))
            }
    }

}

private fun Long.isOld() = System.currentTimeMillis() - this > DATA_TIMEOUT_IN_MINUTES * 60 * 1000
