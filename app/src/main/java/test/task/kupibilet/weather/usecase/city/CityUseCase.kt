package test.task.kupibilet.weather.usecase.city

import io.reactivex.Single
import test.task.kupibilet.weather.data.local.res.entity.City

interface CityUseCase {

    fun cities():Single<List<City>>

}