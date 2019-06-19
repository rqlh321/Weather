package test.task.kupibilet.weather.business.cities

import io.reactivex.disposables.CompositeDisposable
import test.task.kupibilet.weather.usecase.city.CityUseCase
import javax.inject.Inject

class CitiesPresenter @Inject constructor(
    override val view: CitiesContract.View,
    private val cityUseCase: CityUseCase
) : CitiesContract.Presenter {

    private val disposables = CompositeDisposable()

    override fun checkData() {
        disposables.add(
            cityUseCase.cities()
                .subscribe(
                    {
                        view.putData(it)
                    }, {
                        it.printStackTrace()
                    })
        )

    }
}