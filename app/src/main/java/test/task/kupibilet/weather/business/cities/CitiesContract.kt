package test.task.kupibilet.weather.business.cities

import test.task.kupibilet.weather.common.BasePresenter
import test.task.kupibilet.weather.common.BaseView
import test.task.kupibilet.weather.data.local.res.entity.City

interface CitiesContract {

    interface Presenter : BasePresenter<View>

    interface View : BaseView<Presenter,List<City>>

}