package test.task.kupibilet.weather.usecase

import io.reactivex.Single
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.data.Repo
import test.task.kupibilet.weather.data.local.res.entity.City
import javax.inject.Inject

class CityUsecaseImpl @Inject constructor(
    private val repo: Repo
) : CityUsecase {

    override fun cities(): Single<List<City>> {
        return Single.just(repo.local.res.raw(R.raw.cities, Array<City>::class).toList())
    }

}