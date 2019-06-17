package test.task.kupibilet.weather.usecase

import io.reactivex.Single
import test.task.kupibilet.weather.data.local.res.entity.City

interface CityUsecase {

    fun cities():Single<List<City>>

}