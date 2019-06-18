package test.task.kupibilet.weather.usecase.weather

import io.reactivex.Single
import test.task.kupibilet.weather.data.local.database.entity.Weather
import test.task.kupibilet.weather.data.local.res.entity.City

interface WeatherUseCase {

    fun weather(city:City):Single<List<Weather>>

}