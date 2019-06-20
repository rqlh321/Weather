package test.task.kupibilet.weather.business.weather

import test.task.kupibilet.weather.common.BasePresenter
import test.task.kupibilet.weather.common.BaseView
import test.task.kupibilet.weather.data.local.database.entity.Weather
import test.task.kupibilet.weather.data.local.res.entity.City

interface WeatherContract {

    interface Presenter : BasePresenter<View> {

        var city: City

        fun select(weather: Weather)

    }

    interface View : BaseView<Presenter, List<Weather>>{

        fun showDescription(weather: Weather)

    }
}