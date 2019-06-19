package test.task.kupibilet.weather.business.weather

import io.reactivex.disposables.CompositeDisposable
import test.task.kupibilet.weather.data.local.res.entity.City
import test.task.kupibilet.weather.usecase.weather.WeatherUseCase
import javax.inject.Inject

class WeatherPresenter @Inject constructor(
    override val view: WeatherContract.View,
    private val weatherUseCase: WeatherUseCase
) : WeatherContract.Presenter {

    override lateinit var city: City

    private val disposables = CompositeDisposable()

    override fun checkData() {
        disposables.add(
            weatherUseCase.weather(city)
                .subscribe({
                    view.putData(it)
                }, {
                    it.printStackTrace()
                })
        )
    }
}